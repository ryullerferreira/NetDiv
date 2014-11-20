package br.edu.fcsl.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import java.awt.Window.Type;

import javax.swing.JProgressBar;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ImageIcon;
import java.awt.Dimension;
import java.awt.Color;

public class TelaLoading extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager
					.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
					TelaLoading frame = new TelaLoading();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaLoading() {
		setResizable(false);
		
		setMinimumSize(new Dimension(350, 320));
		setTitle("NetDiv - Network Solutions");
		setType(Type.UTILITY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 311);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		final JProgressBar progressBar = new JProgressBar();
		progressBar.setStringPainted(true);
		
		final JLabel label = new JLabel("");
		label.setForeground(new Color(255, 255, 255));
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(TelaLoading.class.getResource("/imagens/pi.jpg")));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(progressBar, GroupLayout.DEFAULT_SIZE, 572, Short.MAX_VALUE)
						.addComponent(label)
						.addComponent(label_1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 578, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(label_1, GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(label)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(progressBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		);
		contentPane.setLayout(gl_contentPane);
		
		new Thread(){
			
			public void run(){
								
					for(int i =0; i<101; i++){	
						try {
						sleep(60);
						progressBar.setValue(i);
						if(progressBar.getValue() <= 20){
							label.setText("Inicializando...");
						}
						else if(progressBar.getValue() > 20 && progressBar.getValue() <= 60){
							label.setText("Carregando componentes...");
						}
						else if(progressBar.getValue() >60 && progressBar.getValue() <= 80){
							label.setText("Configurando diretrizes...");
						}
						else {
							label.setText("Iniciando sistema...");
						}
						
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}						
					}	
				dispose();
				TelaPrincipal sistema = new TelaPrincipal();
				sistema.setLocationRelativeTo(null);
				sistema.setVisible(true);
					
			}
			
			
		}.start();
		
	}

}
