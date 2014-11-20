package br.edu.fcsl.entidade;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import br.edu.fcsl.estatisticas.Grafico;

public class Ping extends SisInfo implements Parametros {

	ProcessBuilder criaProcesso = new ProcessBuilder(comandos);
	Grafico grafico = new Grafico();
	

	public Ping() {

	}

	/**
	 * Metodo que implementa o processo de execucao do teste de resposta lendo o
	 * ip alvo e armazendo na lista de parametros para que seja executado o
	 * processo de ping A saida � exibida no textArea usando uma Thread para
	 * exibicao da resposta em tempo real
	 * 
	 * @param textArea
	 * @throws IOException
	 */
	public void processarPing(JComboBox opcaoA, JComboBox opcaoB,
			final JTextArea painel, JTextField texto, JTextField param1,
			JTextField param2, final JButton botao, final JButton botao2, final JPanel painelGrafico,
			List<String> comando) throws IOException {
		botao.setEnabled(false);
		botao2.setEnabled(false);
		painel.setText(null);
		setParametrosPing(opcaoA, opcaoB, texto, param1, param2, comando);
		painelGrafico.repaint();
		
		
		/**
		 * Thread para exibicao do processamento do ping em tempo real
		 * inserindo no painel JTextArea
		 */
		new Thread() {
			Process processo = criaProcesso.start();
			BufferedReader entrada = new BufferedReader(new InputStreamReader(
					processo.getInputStream()));

			String saida = null;

			public void run() {
				
				try {
					while ((saida = entrada.readLine()) != null) {
						if (getNomeOS().contains("Windows")) {
							
							if (saida.contains("TTL")) {
								if (saida.contains("<")) {
									variacao.add(saida.substring(
											saida.indexOf("<") + 1,
											saida.lastIndexOf("ms TTL")));
								} else {
									variacao.add(saida.substring(
											saida.indexOf("tempo=") + 6,
											saida.lastIndexOf("ms TTL")));
								}
							}
						} else if (getNomeOS().contains("Linux")) {
							if (saida.contains("ttl")) {
								variacao.add(saida.substring(
										saida.indexOf("time=") + 5,
										saida.lastIndexOf(" ms")));
							}
						}
						painel.append(saida);
						painel.append("\n");
					}
				} catch (IOException e) {

					e.printStackTrace();

				} finally {
					if (getNomeOS().contains("Windows")) {
						processo.destroy();
					}
					botao.setEnabled(true);
					botao2.setEnabled(true);
					grafico.criaGrafico(painelGrafico);
					variacao.clear();
				}

			}

		}.start();
	}

	/**
	 * Método responsável por pegar os valores informados pelo usuário e
	 * armazená-los em uma lista de comandos, aqui ocorre a verificação se há
	 * seleção de opções extras ou nao, se houver, a opção é inclusa na lista de
	 * comandos, senão, é passado apenas o IP de destino
	 * 
	 * @param opcaoA
	 * @param opcaoB
	 * @param texto
	 * @param comando
	 */
	public void setParametrosPing(JComboBox opcaoA, JComboBox opcaoB,
			JTextField texto, JTextField param1, JTextField param2,
			List<String> comando) {
		comando.clear();
		if (getNomeOS().contains("Windows")) {
			comando.add("ping");
			if (opcaoA.getSelectedItem() != null) {
				comando.add(String.valueOf(opcaoA.getSelectedItem()));
				if (opcaoA.getSelectedItem() == "-l"
						|| opcaoA.getSelectedItem() == "-i") {
					comando.add(param1.getText());
				}
				if (opcaoA.getSelectedItem() == "-n"
						|| opcaoA.getSelectedItem() == "-w") {
					comando.add(param1.getText());
				}
			}
			if (opcaoB.getSelectedItem() != null) {
				comando.add(String.valueOf(opcaoB.getSelectedItem()));
				if (opcaoB.getSelectedItem() == "-l"
						|| opcaoB.getSelectedItem() == "-i") {
					comando.add(param2.getText());
				}
				if (opcaoB.getSelectedItem() == "-n"
						|| opcaoB.getSelectedItem() == "-w") {
					comando.add(param2.getText());
				}
			}
			comando.add(texto.getText());

		} else if (getNomeOS().contains("Linux") || getNomeOS().contains("MAC")) {
			comando.add("ping");
			if (opcaoA.getSelectedItem() != null) {
				comando.add(String.valueOf(opcaoA.getSelectedItem()));
				if (opcaoA.getSelectedItem() == "-c"
						|| opcaoA.getSelectedItem() == "-t") {
					comando.add(param1.getText());
				}
				if (opcaoA.getSelectedItem() == "-b"
						|| opcaoA.getSelectedItem() == "-i") {
					comando.add(param1.getText());
				}
			}
			if (opcaoB.getSelectedItem() != null) {
				comando.add(String.valueOf(opcaoB.getSelectedItem()));
				if (opcaoB.getSelectedItem() == "-c"
						|| opcaoB.getSelectedItem() == "-t") {
					comando.add(param2.getText());
				}
				if (opcaoB.getSelectedItem() == "-b"
						|| opcaoB.getSelectedItem() == "-i") {
					comando.add(param2.getText());
				}
			}

			if (opcaoA.getSelectedIndex() != 1
					&& opcaoB.getSelectedIndex() != 1) {
				comando.add("-c");
				comando.add("4");
			}
			comando.add(texto.getText());
		}

	}

	/**
	 * Método que verifica se opção escolhida necessita de passagem de
	 * argumentos, se for necessário o uso de argumentos para a opção escolhida,
	 * os campos de texto são habilidados para inserir o parametro requerido
	 * 
	 * @param opcao
	 * @param texto
	 */
	public void argumentosPing(JComboBox opcao, JTextField texto) {
		if (getNomeOS().contains("Windows")) {
			if (opcao.getSelectedItem() == "-l"
					|| opcao.getSelectedItem() == "-i") {
				texto.enable();
			} else {
				texto.disable();
				texto.setText(null);

				if (opcao.getSelectedItem() == "-w"
						|| opcao.getSelectedItem() == "-n") {
					texto.enable();
				} else {
					texto.disable();
					texto.setText(null);
				}
			}
		} else if (getNomeOS().contains("Linux")) {
			if (opcao.getSelectedItem() == "-c"
					|| opcao.getSelectedItem() == "-i") {
				texto.enable();
			} else {
				texto.disable();
				texto.setText(null);

				if (opcao.getSelectedItem() == "-w"
						|| opcao.getSelectedItem() == "-t") {
					texto.enable();
				} else {
					texto.disable();
					texto.setText(null);
				}
			}
		}
	}

	/**
	 * M�todo que recebe um componente JcomboBox e define os
	 * parametros e opções de Ping de acordo com o SO em uso
	 * 
	 * @param opcao
	 */
	public void listaOpPing(JComboBox opcao) {
		if (getNomeOS().contains("Windows")) {
			opcao.setModel(new DefaultComboBoxModel(new String[] { null, "-n",
					"-w", "-l", "-f", "-i", "-a" }));
		} else if (getNomeOS().contains("Linux")) {
			opcao.setModel(new DefaultComboBoxModel(new String[] { null, "-c",
					"-A", "-b", "-i", "-s", "-t", "-R" }));
		}
	}

	/**
	 * Método responsável por limpar os dados para a realização de um novo teste
	 */
	public void limparDados(JComboBox opcaoA, JComboBox opcaoB,
			JTextArea painel, JTextField campo, List<String> comando) {
		opcaoA.setSelectedItem(null);
		opcaoB.setSelectedItem(null);
		painel.setText(null);
		campo.setText(null);
		comando.clear();

	}
	
	/**
	 * Método responsável por setar as legendas de cada opção selecionada
	 * para o teste de resposta
	 * @param opcao
	 * @param hint
	 */
	public void setarHint(JComboBox opcao, JLabel hint){
		if(getNomeOS().contains("Windows")){
			if(opcao.getSelectedItem() == null){
				hint.setText(null);
			}else if(opcao.getSelectedIndex() == 1){
				hint.setText("Quantidade de frames");
			}else if(opcao.getSelectedIndex() == 2){
				hint.setText("Tempo limite para cada resposta");
			}else if(opcao.getSelectedIndex() == 3){
				hint.setText("Tamanho do Buffer");
			}else if(opcao.getSelectedIndex() == 4){
				hint.setText("Ativa o sinalizador (Don't Fragment)");
			}else if(opcao.getSelectedIndex() == 5){
				hint.setText("Vida útil dos frames (TTL)");
			}else if(opcao.getSelectedIndex() == 6){
				hint.setText("Resolve endereços para nomes de host");
			}
		}else if(getNomeOS().contains("Linux") || getNomeOS().contains("Mac")){
			if(opcao.getSelectedItem() == null){
				hint.setText(null);
			}else if(opcao.getSelectedIndex() == 1){
				hint.setText("Quantidade de frames");
			}else if(opcao.getSelectedIndex() == 2){
				hint.setText("Fast ping");
			}else if(opcao.getSelectedIndex() == 3){
				hint.setText("Ping por broadcast");
			}else if(opcao.getSelectedIndex() == 4){
				hint.setText("Intervalo entre envio de frames");
			}else if(opcao.getSelectedIndex() == 5){
				hint.setText("Tamanho do frame a ser enviado");
			}else if(opcao.getSelectedIndex() == 6){
				hint.setText("Vida �til dos frames (TTL)");
			}else if(opcao.getSelectedIndex() == 7){
				hint.setText("Ping com rota de rede");
			}
		}
	}

}
