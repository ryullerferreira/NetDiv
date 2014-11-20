package br.edu.fcsl.entidade;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public interface Parametros {
	
	/**
	 * Lista de comandos para execu��o dos testes
	 */
	List<String> comandos = new ArrayList<String>();
	static List<String> variacao = new ArrayList<String>();
	static List<DadosTeste> relacao = new ArrayList<DadosTeste>();
	
	/**
	 * M�todo respons�vel por limpar os dados de uma consulta
	 * @param opcaoA
	 * @param opcaoB
	 * @param painel
	 * @param campo
	 * @param comando
	 */
	void limparDados(JComboBox opcaoA, JComboBox opcaoB, JTextArea painel, JTextField campo, List<String> comando);
	

}
