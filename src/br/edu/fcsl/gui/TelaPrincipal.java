package br.edu.fcsl.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.ImageIcon;

import java.awt.Color;

import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import java.awt.Rectangle;
import java.awt.Cursor;
import java.awt.Dimension;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.UIManager;

import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.SwingConstants;

import java.awt.event.MouseListener;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaPrincipal extends JFrame implements MouseListener {

	private JPanel contentPane;
	private JLabel label_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager
					.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
					TelaPrincipal frame = new TelaPrincipal();
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
	public TelaPrincipal() {
		setMinimumSize(new Dimension(1100, 550));
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaPrincipal.class.getResource("/imagens/logo-pi_64-64.png")));
		setTitle("NetDiv - Network Solutions");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 984, 487);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnInformaes = new JMenu("Ajuda");
		mnInformaes.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/imagens/help-icon.png")));
		menuBar.add(mnInformaes);
		
		JMenuItem mntmSobreONetdiv = new JMenuItem("Sobre o NetDiv");
		mntmSobreONetdiv.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/imagens/info-icon.png")));
		mntmSobreONetdiv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaSobre sobre = new TelaSobre();
				sobre.setLocationRelativeTo(null);
				sobre.setVisible(true);
			}
		});
		
		JMenuItem mntmTutorial = new JMenuItem("Tutorial");
		mntmTutorial.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/imagens/tutorial-icon.png")));
		mnInformaes.add(mntmTutorial);
		mnInformaes.add(mntmSobreONetdiv);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(105, 105, 105), 4, true));
		panel.setBackground(new Color(245, 245, 220));
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setHgap(15);
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel label = new JLabel("");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				TelaSubRedes subRedes = new TelaSubRedes();
				subRedes.setLocationRelativeTo(null);
				subRedes.setVisible(true);
			}
		});
		label.setBackground(new Color(153, 204, 204));
		label.setPreferredSize(new Dimension(100, 100));
		label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label.setBorder(new TitledBorder(new LineBorder(new Color(128, 128, 128), 2, true), "SubDivis\u00E3o", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(59, 59, 59)));
		label.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/imagens/subnet-division.png")));
		panel.add(label);
		
		label_1 = new JLabel("");
		label_1.addMouseListener(this);
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setPreferredSize(new Dimension(100, 100));
		label_1.setBorder(new TitledBorder(new LineBorder(new Color(128, 128, 128), 2, true), "Ping", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(59, 59, 59)));
		label_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label_1.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/imagens/cmd-icon.png")));
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("");
		label_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.exit(0);
			}
		});
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label_2.setPreferredSize(new Dimension(100, 100));
		label_2.setBorder(new TitledBorder(new LineBorder(new Color(128, 128, 128), 2, true), "Sair", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(59, 59, 59)));
		label_2.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/imagens/exit-icon.png")));
		panel.add(label_2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBorder(new LineBorder(new Color(105, 105, 105), 4, true));
		contentPane.add(panel_1, BorderLayout.CENTER);
		
		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/imagens/logo-tela.png")));
		panel_1.add(label_3);
	}

	public void mouseClicked(MouseEvent arg0) {
		if (arg0.getSource() == label_1) {
			do_label_1_mouseClicked(arg0);
		}
	}
	public void mouseEntered(MouseEvent arg0) {
	}
	public void mouseExited(MouseEvent arg0) {
	}
	public void mousePressed(MouseEvent arg0) {
	}
	public void mouseReleased(MouseEvent arg0) {
	}
	protected void do_label_1_mouseClicked(MouseEvent arg0) {
		TelaPing ping = new TelaPing();
		ping.setLocationRelativeTo(null);
		ping.setVisible(true);
	}
}
