package br.edu.fcsl.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import java.awt.Window.Type;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

import java.awt.Font;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaSobre extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager
			.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
			TelaSobre dialog = new TelaSobre();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public TelaSobre() {
		setUndecorated(true);
		setType(Type.POPUP);
		setModal(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 250, 240));
		contentPanel.setBorder(new LineBorder(new Color(0, 0, 0), 5, true));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(TelaSobre.class.getResource("/imagens/cnec-logo.png")));
		JLabel lblProjetoIntegrador = new JLabel("Projeto Integrador - 2014/2");
		lblProjetoIntegrador.setFont(new Font("SansSerif", Font.PLAIN, 18));
		JLabel lblGrupo = new JLabel("Bacharelado em Sistemas de Inforrma\u00E7\u00E3o");
		JLabel label = new JLabel("Grupo 16 - 4\u00AA Per\u00EDodo");
		JLabel lblAndrPedras = new JLabel("Andr\u00E9 Pedras");
		lblAndrPedras.setFont(new Font("SansSerif", Font.PLAIN, 14));
		JLabel lblDanielCastro = new JLabel("Daniel Castro");
		lblDanielCastro.setFont(new Font("SansSerif", Font.PLAIN, 14));
		JLabel lblRamonRodrigues = new JLabel("Ramon Rodrigues");
		lblRamonRodrigues.setFont(new Font("SansSerif", Font.PLAIN, 14));
		JLabel lblRyullerFerreira = new JLabel("Ryuller Ferreira");
		lblRyullerFerreira.setFont(new Font("SansSerif", Font.PLAIN, 14));
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblProjetoIntegrador)
						.addComponent(label, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblGrupo)
						.addComponent(lblAndrPedras)
						.addComponent(lblDanielCastro)
						.addComponent(lblRamonRodrigues)
						.addComponent(lblRyullerFerreira))
					.addContainerGap(34, Short.MAX_VALUE))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblProjetoIntegrador)
							.addGap(18)
							.addComponent(lblGrupo)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(label)
							.addGap(18)
							.addComponent(lblAndrPedras)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblDanielCastro)
							.addGap(18)
							.addComponent(lblRamonRodrigues)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblRyullerFerreira)))
					.addContainerGap())
		);
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(255, 255, 255));
			buttonPane.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
			buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}
}
