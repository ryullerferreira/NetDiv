package br.edu.fcsl.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTextArea;

import br.edu.fcsl.entidade.DadosTeste;
import br.edu.fcsl.entidade.Parametros;
import br.edu.fcsl.entidade.Ping;
import br.edu.fcsl.estatisticas.Grafico;
import br.edu.fcsl.relatorio.PingRel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;

import java.awt.Toolkit;

public class TelaPing extends JDialog implements ActionListener,
		ItemListener, KeyListener, Parametros {

	private final JPanel contentPanel = new JPanel();
	private JScrollPane scrollPane;
	private JPanel panel;
	private JLabel lblTesteDeComunicao;
	private JTextField campoIP;
	private JButton btnIniciar;
	private JButton btnLimpar;
	private JLabel lblIp;
	private JPanel panel_1;
	private JLabel lblParametros;
	private JComboBox opcao1;
	private JComboBox opcao2;
	private JTextField parametro1;
	private JTextField parametro2;
	private JPanel panel_2;
	private JLabel lblPing;
	private JTextArea painelPing;
	private JPanel panel_3;
	private JLabel lblSistemaOperacional;

	// Instancia da classe Ping
	Ping ping = new Ping();
	

	private JPanel painelSO;
	private JLabel lbIcone;
	private JLabel lbNomeSO;
	private JLabel lbArch;
	private JPanel painelGrafico;
	private JLabel lblDescrioDeParametros;
	private JLabel lblParametro;
	private JLabel lbHint1;
	private JLabel lbHint2;
	private JPanel panel_4;
	private JMenuBar menuBar;
	private JMenu mnExibir;
	private JMenuItem mntmRelatorio;

	/**
	 * Iniciar a aplica��o.
	 */
	public static void main(String[] args) {
		try {
			TelaPing dialog = new TelaPing();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public TelaPing() {
		setMinimumSize(new Dimension(1080, 640));
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaPing.class.getResource("/imagens/logo-pi_64-64.png")));
		setModal(true);
		getContentPane().setBackground(new Color(255, 250, 240));
		addKeyListener(this);
		setTitle("TESTE DE RESPOSTA");
		setBounds(100, 100, 1080, 642);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 250, 240));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.NORTH);

		scrollPane = new JScrollPane();

		panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBorder(new LineBorder(new Color(128, 128, 128), 2, true));

		campoIP = new JTextField();
		campoIP.addKeyListener(this);
		campoIP.setColumns(10);

		btnIniciar = new JButton("Ping");
		btnIniciar.setIcon(new ImageIcon(TelaPing.class.getResource("/imagens/icon_calcular.jpg")));
		btnIniciar.addActionListener(this);

		btnLimpar = new JButton("Limpar");
		btnLimpar.setIcon(new ImageIcon(TelaPing.class.getResource("/imagens/icon_limpar.jpg")));
		btnLimpar.addActionListener(this);

		lblIp = new JLabel("IP:");
		lblIp.setFont(new Font("Tahoma", Font.BOLD, 11));

		panel_1 = new JPanel();
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBorder(new LineBorder(new Color(128, 128, 128), 2, true));
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		lblParametros = new JLabel("PARAMETROS");
		lblParametros.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel_1.add(lblParametros);

		panel_2 = new JPanel();
		panel_2.setBackground(Color.LIGHT_GRAY);
		panel_2.setBorder(new LineBorder(new Color(128, 128, 128), 2, true));

		lblPing = new JLabel("PING");
		lblPing.setFont(new Font("Tahoma", Font.BOLD, 11));

		panel_3 = new JPanel();
		panel_3.setBackground(Color.LIGHT_GRAY);
		panel_3.setBorder(new LineBorder(new Color(128, 128, 128), 2, true));
		panel_3.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		lblSistemaOperacional = new JLabel("SISTEMA OPERACIONAL");
		lblSistemaOperacional.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel_3.add(lblSistemaOperacional);

		painelSO = new JPanel();
		painelSO.setBorder(new LineBorder(Color.GRAY));

		painelGrafico = new JPanel();
		painelGrafico.setBorder(new LineBorder(Color.GRAY));
		
		panel_4 = new JPanel();
		panel_4.setBackground(new Color(255, 250, 240));
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(255, 250, 240));
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 1034, Short.MAX_VALUE)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 531, Short.MAX_VALUE)
							.addGap(18)
							.addComponent(painelGrafico, GroupLayout.DEFAULT_SIZE, 485, Short.MAX_VALUE))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(panel_5, GroupLayout.PREFERRED_SIZE, 532, GroupLayout.PREFERRED_SIZE)
								.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, 532, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPanel.createSequentialGroup()
									.addGap(27)
									.addComponent(lblIp, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(campoIP, GroupLayout.PREFERRED_SIZE, 238, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(btnIniciar, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnLimpar, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
									.addGap(0, 0, Short.MAX_VALUE))
								.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 532, GroupLayout.PREFERRED_SIZE)
								.addComponent(panel, GroupLayout.PREFERRED_SIZE, 532, GroupLayout.PREFERRED_SIZE))
							.addGap(290)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING, false)
								.addComponent(painelSO, GroupLayout.PREFERRED_SIZE, 212, GroupLayout.PREFERRED_SIZE)
								.addComponent(panel_3, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 212, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap())
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(campoIP, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblIp)
								.addComponent(btnIniciar)
								.addComponent(btnLimpar))
							.addGap(32)
							.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(panel_5, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(painelSO, 0, 0, Short.MAX_VALUE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
							.addGap(11))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(painelGrafico, GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
							.addContainerGap())))
		);
		
				opcao1 = new JComboBox();
				opcao1.setToolTipText("");
				opcao1.addItemListener(this);
				ping.listaOpPing(opcao1);
				
						parametro1 = new JTextField();
						parametro1.setColumns(10);
						
								opcao2 = new JComboBox();
								opcao2.addItemListener(this);
								ping.listaOpPing(opcao2);
								
										parametro2 = new JTextField();
										parametro2.setColumns(10);
										GroupLayout gl_panel_5 = new GroupLayout(panel_5);
										gl_panel_5.setHorizontalGroup(
											gl_panel_5.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_panel_5.createSequentialGroup()
													.addGap(84)
													.addComponent(opcao1, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
													.addGap(5)
													.addComponent(parametro1, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
													.addGap(63)
													.addComponent(opcao2, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
													.addPreferredGap(ComponentPlacement.RELATED)
													.addComponent(parametro2, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
													.addGap(148))
										);
										gl_panel_5.setVerticalGroup(
											gl_panel_5.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_panel_5.createSequentialGroup()
													.addGap(5)
													.addGroup(gl_panel_5.createParallelGroup(Alignment.LEADING)
														.addComponent(parametro2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
														.addComponent(parametro1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
														.addComponent(opcao1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
														.addComponent(opcao2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
													.addContainerGap())
										);
										panel_5.setLayout(gl_panel_5);
		panel_4.setLayout(new GridLayout(2, 4, 0, 0));
		
		lblDescrioDeParametros = new JLabel("Op\u00E7\u00E3o 1:");
		lblDescrioDeParametros.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDescrioDeParametros.setBackground(new Color(255, 250, 240));
		panel_4.add(lblDescrioDeParametros);
		
		lblParametro = new JLabel("Op\u00E7\u00E3o 2:");
		lblParametro.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblParametro.setBackground(new Color(255, 250, 240));
		panel_4.add(lblParametro);
		
		lbHint1 = new JLabel("");
		lbHint1.setBackground(new Color(255, 250, 240));
		panel_4.add(lbHint1);
		
		lbHint2 = new JLabel("");
		lbHint2.setBackground(new Color(255, 250, 240));
		panel_4.add(lbHint2);
		panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		panel_2.add(lblPing);

		lbIcone = new JLabel("");

		lbNomeSO = new JLabel("...");

		lbArch = new JLabel("...");
		GroupLayout gl_painelSO = new GroupLayout(painelSO);
		gl_painelSO.setHorizontalGroup(gl_painelSO
				.createParallelGroup(Alignment.TRAILING)
				.addGroup(
						gl_painelSO
								.createSequentialGroup()
								.addGap(40)
								.addComponent(lbNomeSO)
								.addPreferredGap(ComponentPlacement.RELATED,
										114, Short.MAX_VALUE)
								.addComponent(lbArch).addGap(44))
				.addGroup(
						Alignment.LEADING,
						gl_painelSO.createSequentialGroup().addGap(66)
								.addComponent(lbIcone)
								.addContainerGap(118, Short.MAX_VALUE)));
		gl_painelSO.setVerticalGroup(gl_painelSO.createParallelGroup(
				Alignment.LEADING)
				.addGroup(
						gl_painelSO
								.createSequentialGroup()
								.addGap(29)
								.addComponent(lbIcone)
								.addGap(30)
								.addGroup(
										gl_painelSO
												.createParallelGroup(
														Alignment.BASELINE)
												.addComponent(lbArch)
												.addComponent(lbNomeSO))
								.addContainerGap(62, Short.MAX_VALUE)));
		painelSO.setLayout(gl_painelSO);

		painelPing = new JTextArea();
		painelPing.setToolTipText("Console de exibi\u00E7\u00E3o do teste de resposta");
		painelPing.setForeground(Color.WHITE);
		painelPing.setBackground(Color.BLACK);
		painelPing.setEditable(false);
		scrollPane.setViewportView(painelPing);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		lblTesteDeComunicao = new JLabel("TESTE DE COMUNICA\u00C7\u00C3O");
		lblTesteDeComunicao.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel.add(lblTesteDeComunicao);
		contentPanel.setLayout(gl_contentPanel);

		/**
		 * Chamada as funcoes de deteccao do SO e definicao da lista de
		 * parametros para o teste segundo o sistema operacional utilizado
		 */
		lbNomeSO.setText(ping.getNomeOS());
		lbArch.setText(ping.getArquiteturaOS());
		ping.alteraIcone(lbNomeSO, lbIcone);
		painelGrafico.setLayout(new BorderLayout(0, 0));
		Grafico graf = new Grafico();
		graf.criaGrafico(painelGrafico);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnExibir = new JMenu("Exibir");
		menuBar.add(mnExibir);
		
		mntmRelatorio = new JMenuItem("Relatorio");
		mntmRelatorio.addActionListener(this);
		mnExibir.add(mntmRelatorio);

	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == mntmRelatorio) {
			try {
				do_mntmRelatorio_actionPerformed(arg0);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (arg0.getSource() == btnLimpar) {
			do_btnLimpar_actionPerformed(arg0);
		}
		if (arg0.getSource() == btnIniciar) {
			try {
				do_btnIniciar_actionPerformed(arg0);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * Executa o teste
	 * 
	 * @param arg0
	 * @throws Exception 
	 * @throws IOException
	 */
	protected void do_btnIniciar_actionPerformed(ActionEvent arg0) throws Exception{
		relacao.clear();
		if (!campoIP.getText().equals("")) {
			try {
				ping.processarPing(opcao1, opcao2, painelPing, campoIP, parametro1,
						parametro2, btnIniciar, btnLimpar, painelGrafico, ping.comandos);
				painelGrafico.repaint();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
				JOptionPane.showMessageDialog(null, "O campo 'IP' deve ser preenchido!", "Campo Vazio", JOptionPane.WARNING_MESSAGE);
		}

	}

	public void itemStateChanged(ItemEvent arg0) {
		if (arg0.getSource() == opcao2) {
			do_opcao2_itemStateChanged(arg0);
		}
		if (arg0.getSource() == opcao1) {
			do_opcao1_itemStateChanged(arg0);
		}
	}

	/**
	 * Verificar se a primeira op��o escolhida requer parametros
	 * 
	 * @param arg0
	 */
	protected void do_opcao1_itemStateChanged(ItemEvent arg0) {
		ping.argumentosPing(opcao1, parametro1);
		ping.setarHint(opcao1, lbHint1);
	}

	/**
	 * Verificar se a segunda op��o escolhida requer parametros
	 * 
	 * @param arg0
	 */
	protected void do_opcao2_itemStateChanged(ItemEvent arg0) {
		ping.argumentosPing(opcao2, parametro2);
		ping.setarHint(opcao2, lbHint2);
	}

	/**
	 * Limpar os dados da consulta anterior
	 * 
	 * @param arg0
	 */
	protected void do_btnLimpar_actionPerformed(ActionEvent arg0) {
		ping.limparDados(opcao1, opcao2, painelPing, campoIP, ping.comandos);
		ping.variacao.clear();
		Grafico grafico = new Grafico();
		grafico.criaGrafico(painelGrafico);
		
	}
	public void keyPressed(KeyEvent arg0) {
		if (arg0.getSource() == campoIP) {
			try {
				do_campoIP_keyPressed(arg0);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (arg0.getSource() == this) {
			do_this_keyPressed(arg0);
		}
	}
	public void keyReleased(KeyEvent arg0) {
	}
	public void keyTyped(KeyEvent arg0) {
	}
	protected void do_this_keyPressed(KeyEvent arg0) {
		
	}
	/**
	 * Aciona a função de testar a comunicação quando a tecla enter for pressionada
	 * @param arg0
	 * @throws Exception 
	 */
	protected void do_campoIP_keyPressed(KeyEvent arg0) throws Exception {
		if(arg0.getKeyCode() == KeyEvent.VK_ENTER){
			do_btnIniciar_actionPerformed(null);
		}
	}

	@Override
	public void limparDados(JComboBox opcaoA, JComboBox opcaoB,
			JTextArea painel, JTextField campo, List<String> comando) {
		// TODO Auto-generated method stub
		
	}
	protected void do_mntmRelatorio_actionPerformed(ActionEvent arg0) throws Exception {
		dadosRelatorio();
	}
	
	protected void dadosRelatorio() throws Exception{
		DadosTeste DadosRel = new DadosTeste();
		PingRel relatorio = new PingRel();
		
		String texto = painelPing.getText();
		
		String[] linhas = texto.split("\n");

		String linha = null;
		for(int i = 0; i < linhas.length; i++){
			if(linhas[i].contains("Pacotes:")){
				linha = linhas[i];
			}
		}
		
		linha = linha.replaceAll("\\D", " ");
		
		List<String> pacotes = new ArrayList<String>();
		for(int i = 0; i < linha.length(); i++){
			if(linha.charAt(i) != ' '){
				pacotes.add(String.valueOf(linha.charAt(i)));
			}
		}
		
		
		DadosRel.setIp(campoIP.getText());
		DadosRel.setEnviados(pacotes.get(0));
		DadosRel.setRecebidos(pacotes.get(1));
		DadosRel.setPerdidos(pacotes.get(2));
			
		double perc = (Integer.parseInt(pacotes.get(2)) * 100) / Integer.parseInt(pacotes.get(0));
		DadosRel.setPorcentagem(String.valueOf(perc));
		
		if(perc >= 80){
			DadosRel.setStatus("Inst�vel");
		}else{
			DadosRel.setStatus("Est�vel");
		}
		
		relacao.add(DadosRel);
		relatorio.imprimir(relacao);
	}
}
