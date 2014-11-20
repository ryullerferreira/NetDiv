package br.edu.fcsl.entidade;


import javax.swing.ImageIcon;
import javax.swing.JLabel;

import br.edu.fcsl.gui.TelaPing;



/**
 * Classe com informações do sistema operacional
 * @author Ramon
 *
 */
public abstract class SisInfo {
	
	public static String nomeOS;
	public static String arquiteturaOS;
	
	
	public SisInfo() {		
		nomeOS = String.valueOf(System.getProperties().get("os.name"));
		arquiteturaOS = String.valueOf(System.getProperties().get("os.arch"));
	}

	public static String getNomeOS() {
		return nomeOS;
	}

	public static String getArquiteturaOS() {
		return arquiteturaOS;
	}
	
	/**
	 * Método responsável por alterar o icone do SO
	 */
	public void alteraIcone(JLabel lbSO, JLabel icone) {
		if (lbSO.getText().contains("Windows")) {
			icone.setIcon(new ImageIcon(TelaPing.class
					.getResource("/imagens/Windows.png")));
		} else if (lbSO.getText().contains("Linux")) {
			icone.setIcon(new ImageIcon(TelaPing.class
					.getResource("/imagens/Linux.png")));
		} else if (lbSO.getText().contains("Mac")) {
			icone.setIcon(new ImageIcon(TelaPing.class
					.getResource("/imagens/Apple.png")));
		}
	}

	
}
