package br.edu.fcsl.gui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import br.edu.fcsl.entidade.DivisaoDeSubRedes;

import javax.swing.border.BevelBorder;
import java.awt.Toolkit;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;

public class TelaSubRedes extends JDialog {

	private JPanel contentPane;

	JSpinner spinnerip1 = new JSpinner();
	JSpinner spinnerip2 = new JSpinner();
	JSpinner spinnerip3 = new JSpinner();
	JSpinner spinnerip4 = new JSpinner();

	JComboBox comboBoxNumSubRedes = new JComboBox();
	JComboBox comboBoxClasseDeRede = new JComboBox();
	private JTextField textField;

	JButton btnLimpar = new JButton("Limpar");
	private JTextField textFieldMask_1;
	private JTextField textFieldMask_2;
	private JTextField textFieldMask_3;
	private JTextField textFieldMask_4;

	private JTable tableSubredes;

	final JScrollPane scrollPane = new JScrollPane();

	DefaultTableModel model = new DefaultTableModel();
	private JTextField textFieldMascaraSubRedes;

	int quantIpsPorRede;
	Integer subRedes[][];
	String valoresDaTabela[][];

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager
							.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
					TelaSubRedes frame = new TelaSubRedes();
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
	public TelaSubRedes() {
		setModal(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaSubRedes.class.getResource("/imagens/logo-pi_64-64.png")));
		setTitle("Divis\u00E3o de Sub Redes");
		setMinimumSize(new Dimension(1080, 680));
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1188, 501);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 250, 240));
		contentPane.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, new Color(0, 0, 0)));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(220, 220, 220));
		panel.setBorder(new LineBorder(new Color(105, 105, 105), 2, true));

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(220, 220, 220));
		panel_1.setBorder(new LineBorder(new Color(105, 105, 105), 2, true));

		final JScrollPane scrollPane = new JScrollPane();
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(TelaSubRedes.class.getResource("/imagens/rede.png")));
		
		JLabel lblSubdivisoDeRedes = new JLabel("Subdivis\u00E3o de Redes");
		lblSubdivisoDeRedes.setFont(new Font("SansSerif", Font.PLAIN, 28));
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(TelaSubRedes.class.getResource("/imagens/network-img.png")));

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 1156, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 163, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(lblSubdivisoDeRedes, GroupLayout.PREFERRED_SIZE, 284, GroupLayout.PREFERRED_SIZE))
								.addComponent(panel, GroupLayout.DEFAULT_SIZE, 466, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 672, Short.MAX_VALUE)
									.addContainerGap())
								.addComponent(lblNewLabel_1)))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(12)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel)
						.addComponent(lblSubdivisoDeRedes, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
						.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(panel_1, 0, 0, Short.MAX_VALUE)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 162, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE))
		);

		tableSubredes = new JTable();
		tableSubredes.setFont(new Font("Arial", Font.PLAIN, 16));
		scrollPane.setViewportView(tableSubredes);

		JLabel lblNmeroDeSubredes = new JLabel("N\u00FAmero de SubRedes:");
		lblNmeroDeSubredes.setFont(new Font("SansSerif", Font.PLAIN, 18));
		comboBoxNumSubRedes.setFont(new Font("Times New Roman",
				Font.PLAIN, 14));
		comboBoxNumSubRedes.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if (comboBoxClasseDeRede.getSelectedIndex() == 2) {

					if (comboBoxNumSubRedes.getSelectedIndex() == 0) {
						textField.setText("128");
					} else if (comboBoxNumSubRedes.getSelectedIndex() == 1) {
						textField.setText("64");
					} else if (comboBoxNumSubRedes.getSelectedIndex() == 2) {
						textField.setText("32");
					} else if (comboBoxNumSubRedes.getSelectedIndex() == 3) {
						textField.setText("16");
					} else if (comboBoxNumSubRedes.getSelectedIndex() == 4) {
						textField.setText("8");
					} else if (comboBoxNumSubRedes.getSelectedIndex() == 5) {
						textField.setText("4");
					}

				} else if (comboBoxClasseDeRede.getSelectedIndex() == 1) {
					if (comboBoxNumSubRedes.getSelectedIndex() == 0) {
						textField.setText("32768");
					} else if (comboBoxNumSubRedes.getSelectedIndex() == 1) {
						textField.setText("16384");
					} else if (comboBoxNumSubRedes.getSelectedIndex() == 2) {
						textField.setText("8192");
					} else if (comboBoxNumSubRedes.getSelectedIndex() == 3) {
						textField.setText("4096");
					} else if (comboBoxNumSubRedes.getSelectedIndex() == 4) {
						textField.setText("2048");
					} else if (comboBoxNumSubRedes.getSelectedIndex() == 5) {
						textField.setText("1024");
					} else if (comboBoxNumSubRedes.getSelectedIndex() == 6) {
						textField.setText("512");
					} else if (comboBoxNumSubRedes.getSelectedIndex() == 7) {
						textField.setText("256");
					} else if (comboBoxNumSubRedes.getSelectedIndex() == 8) {
						textField.setText("128");
					} else if (comboBoxNumSubRedes.getSelectedIndex() == 9) {
						textField.setText("64");
					} else if (comboBoxNumSubRedes.getSelectedIndex() == 10) {
						textField.setText("32");
					} else if (comboBoxNumSubRedes.getSelectedIndex() == 11) {
						textField.setText("16");
					} else if (comboBoxNumSubRedes.getSelectedIndex() == 12) {
						textField.setText("8");
					} else if (comboBoxNumSubRedes.getSelectedIndex() == 13) {
						textField.setText("4");
					}

				}
				
				else if(comboBoxClasseDeRede.getSelectedIndex() == 0){
					
					//if (comboBoxNumSubRedes.getSelectedIndex() == 0) {
					//	textField.setText("16777216");
					//} else 
						
					if (comboBoxNumSubRedes.getSelectedIndex() == 0) {
						textField.setText("8388608");
					} else if (comboBoxNumSubRedes.getSelectedIndex() == 1) {
						textField.setText("4194304");
					} else if (comboBoxNumSubRedes.getSelectedIndex() == 2) {
						textField.setText("2097152");
					} else if (comboBoxNumSubRedes.getSelectedIndex() == 3) {
						textField.setText("1048576");
					} else if (comboBoxNumSubRedes.getSelectedIndex() == 4) {
						textField.setText("524288");
					} else if (comboBoxNumSubRedes.getSelectedIndex() == 5) {
						textField.setText("262144");
					} else if (comboBoxNumSubRedes.getSelectedIndex() == 6) {
						textField.setText("131072");
					} else if (comboBoxNumSubRedes.getSelectedIndex() == 7) {
						textField.setText("65536");
					} else if (comboBoxNumSubRedes.getSelectedIndex() == 8) {
						textField.setText("32768");
					} else if (comboBoxNumSubRedes.getSelectedIndex() == 9) {
						textField.setText("16384");
					} else if (comboBoxNumSubRedes.getSelectedIndex() == 10) {
						textField.setText("8192");
					} else if (comboBoxNumSubRedes.getSelectedIndex() == 11) {
						textField.setText("4096");
					} else if (comboBoxNumSubRedes.getSelectedIndex() == 12) {
						textField.setText("2048");
					}else if (comboBoxNumSubRedes.getSelectedIndex() == 13) {
						textField.setText("1024");
					}else if (comboBoxNumSubRedes.getSelectedIndex() == 14) {
						textField.setText("512");
					}else if (comboBoxNumSubRedes.getSelectedIndex() == 15) {
						textField.setText("256");
					}else if (comboBoxNumSubRedes.getSelectedIndex() == 16) {
						textField.setText("128");
					}else if (comboBoxNumSubRedes.getSelectedIndex() == 17) {
						textField.setText("64");
					}else if (comboBoxNumSubRedes.getSelectedIndex() == 18) {
						textField.setText("32");
					}else if (comboBoxNumSubRedes.getSelectedIndex() == 19) {
						textField.setText("16");
					}else if (comboBoxNumSubRedes.getSelectedIndex() == 20) {
						textField.setText("8");
					}else if (comboBoxNumSubRedes.getSelectedIndex() == 21) {
						textField.setText("4");
					}
				}
			}
		});
		btnLimpar.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		btnLimpar.setIcon(new ImageIcon(TelaSubRedes.class
				.getResource("/imagens/icon_limpar.jpg")));

		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				limparTabela();

			}
		});

		JButton btnCalcular = new JButton("Calcular");
		btnCalcular.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		btnCalcular.setIcon(new ImageIcon(TelaSubRedes.class
				.getResource("/imagens/icon_calcular.jpg")));
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				int selecaoDeSubRede = comboBoxNumSubRedes
						.getSelectedIndex();
				int classeSubRede = comboBoxClasseDeRede.getSelectedIndex();
				int numeroDeSubRedes = 0;
				int totalDeIps = 0;
				int ipsPorRede;
				int ipPorRedeMascara = 0;

				if(classeSubRede == 0){
					totalDeIps = 16777216;
				}
				else if (classeSubRede == 1) {
					totalDeIps = 65536;
				} else if (classeSubRede == 2) {
					totalDeIps = 256;
				}

				if (selecaoDeSubRede == 0) {
					numeroDeSubRedes = 2;
					ipPorRedeMascara = 128;
				} else if (selecaoDeSubRede == 1) {
					numeroDeSubRedes = 4;
					ipPorRedeMascara = 64;
				} else if (selecaoDeSubRede == 2) {
					numeroDeSubRedes = 8;
					ipPorRedeMascara = 32;
				} else if (selecaoDeSubRede == 3) {
					numeroDeSubRedes = 16;
					ipPorRedeMascara = 16;
				} else if (selecaoDeSubRede == 4) {
					numeroDeSubRedes = 32;
					ipPorRedeMascara = 8;
				} else if (selecaoDeSubRede == 5) {
					numeroDeSubRedes = 64;
					ipPorRedeMascara = 4;
				} else if (selecaoDeSubRede == 6) {
					numeroDeSubRedes = 128;
					ipPorRedeMascara = 2;
				} else if (selecaoDeSubRede == 7) {
					numeroDeSubRedes = 256;
					ipPorRedeMascara = 256;
				} else if (selecaoDeSubRede == 8) {
					numeroDeSubRedes = 512;
					ipPorRedeMascara = 128;
				} else if (selecaoDeSubRede == 9) {
					numeroDeSubRedes = 1024;
					ipPorRedeMascara = 64;
				} else if (selecaoDeSubRede == 10) {
					numeroDeSubRedes = 2048;
					ipPorRedeMascara = 32;
				} else if (selecaoDeSubRede == 11) {
					numeroDeSubRedes = 4096;
					ipPorRedeMascara = 16;
				} else if (selecaoDeSubRede == 12) {
					numeroDeSubRedes = 8192;
					ipPorRedeMascara = 8;
				} else if (selecaoDeSubRede == 13) {
					numeroDeSubRedes = 16384;
					ipPorRedeMascara = 4;
				} else if (selecaoDeSubRede == 14) {
					numeroDeSubRedes = 32768;
					ipPorRedeMascara = 2;
				}else if (selecaoDeSubRede == 15) {
					numeroDeSubRedes = 65536;
					ipPorRedeMascara = 1;
				}else if (selecaoDeSubRede == 16) {
					numeroDeSubRedes = 131072;
					ipPorRedeMascara = 128;
				}else if (selecaoDeSubRede == 17) {
					numeroDeSubRedes = 262144;
					ipPorRedeMascara = 64;
				}else if (selecaoDeSubRede == 18) {
					numeroDeSubRedes = 524288;
					ipPorRedeMascara = 32;
				}else if (selecaoDeSubRede == 19) {
					numeroDeSubRedes = 1048576;
					ipPorRedeMascara = 16;
				}else if (selecaoDeSubRede == 20) {
					numeroDeSubRedes = 2097152;
					ipPorRedeMascara = 8;
				}else if (selecaoDeSubRede == 21) {
					numeroDeSubRedes = 4194304;
					ipPorRedeMascara = 4;
				}else if (selecaoDeSubRede == 22) {
					numeroDeSubRedes = 8388608;
					ipPorRedeMascara = 2;
				}
								
				
				
				String valoresTabela[][] = new String[numeroDeSubRedes][6];

				ipsPorRede = totalDeIps / numeroDeSubRedes;

				int ipMascaraDeRede = 256 - ipPorRedeMascara;
				
				
				if (comboBoxClasseDeRede.getSelectedIndex() == 0) {
				
					if(selecaoDeSubRede < 7){
						textFieldMascaraSubRedes.setText(textFieldMask_1.getText()
								+ "." + String.valueOf(ipMascaraDeRede) + "."
								+ textFieldMask_3.getText() + "."
								+ textFieldMask_4.getText() );
					}					
					else if(selecaoDeSubRede >= 7 && selecaoDeSubRede <= 15){
						textFieldMascaraSubRedes.setText(textFieldMask_1.getText()
								+ "." + 255 + "."
								+ String.valueOf(ipMascaraDeRede) + "."
								+ textFieldMask_4.getText() );
					}
					else  {
						textFieldMascaraSubRedes.setText(textFieldMask_1.getText()
								+ "." + 255 + "."
								+ 255 + "."
								+ String.valueOf(ipMascaraDeRede));
					}
					
					
				}
				
				else if (comboBoxClasseDeRede.getSelectedIndex() == 1) {
					if(selecaoDeSubRede >= 7){
						textFieldMascaraSubRedes.setText(textFieldMask_1.getText()
								+ "." + textFieldMask_2.getText() + "."
								+ 255 + "."
								+ String.valueOf(ipMascaraDeRede));
					}
					else {
						textFieldMascaraSubRedes.setText(textFieldMask_1.getText()
								+ "." + textFieldMask_2.getText() + "."
								+ String.valueOf(ipMascaraDeRede) + "."
								+ textFieldMask_4.getText());
					}
					
				} else if (comboBoxClasseDeRede.getSelectedIndex() == 2) {					
					textFieldMascaraSubRedes.setText(textFieldMask_1.getText()
							+ "." + textFieldMask_2.getText() + "."
							+ textFieldMask_3.getText() + "."
							+ String.valueOf(ipMascaraDeRede));
				}

				DivisaoDeSubRedes calculoSubRede = new DivisaoDeSubRedes();

				String ip1 = Integer.toBinaryString((int) spinnerip1.getValue());
				String ip_1Binario = (String.format("%08d",
						Integer.parseInt(ip1)));
				//System.out.println(ip_1Binario);
				String ip2 = Integer.toBinaryString((int) spinnerip2.getValue());
				String ip_2Binario = (String.format("%08d",
						Integer.parseInt(ip2)));
				//System.out.println(ip_2Binario);
				String ip3 = Integer.toBinaryString((int) spinnerip3.getValue());
				String ip_3Binario = (String.format("%08d",
						Integer.parseInt(ip3)));
				//System.out.println(ip_3Binario);
				String ip4 = Integer.toBinaryString((int) spinnerip4.getValue());
				String ip_4Binario = (String.format("%08d",
						Integer.parseInt(ip4)));
				//System.out.println(ip_4Binario);
				int ipEmDecimal = calculoSubRede.BinarioDecimal(ip_2Binario
						+ ip_3Binario + ip_4Binario);

				String totalBinario = calculoSubRede
						.DecimalBinario(ipEmDecimal);

				String ipInicialEmBinario = calculoSubRede
						.DecimalBinario(ipEmDecimal);
				valoresTabela[0][0] = calculoSubRede.PreencherClasseDec(
						ipInicialEmBinario, spinnerip1);
				valoresTabela[0][2] = calculoSubRede.PreencherClasseDec(
						ipInicialEmBinario, spinnerip1);

				int ipEmDecimalInicial = ipEmDecimal;

				int ipEmDecimalFinal = ipEmDecimal + ipsPorRede - 1;

				int ipEmDecimalUtilizavelInicial = ipEmDecimal + 1;

				int ipEmDecimalUtilizavelFinal = ipEmDecimal + ipsPorRede - 2;

				String ipFinalEmBinario = calculoSubRede
						.DecimalBinario(ipEmDecimalFinal);

				valoresTabela[0][1] = calculoSubRede.PreencherClasseDec(
						ipFinalEmBinario, spinnerip1);
				valoresTabela[0][3] = calculoSubRede.PreencherClasseDec(
						ipFinalEmBinario, spinnerip1);

				String ipUtilizavelInicialEmBinario = calculoSubRede
						.DecimalBinario(ipEmDecimalUtilizavelInicial);
				valoresTabela[0][4] = calculoSubRede.PreencherClasseDec(
						ipUtilizavelInicialEmBinario, spinnerip1);

				String ipUtilizavelFinalEmBinario = calculoSubRede
						.DecimalBinario(ipEmDecimalUtilizavelFinal);
				valoresTabela[0][5] = calculoSubRede.PreencherClasseDec(
						ipUtilizavelFinalEmBinario, spinnerip1);

				for (int i = 1; i < numeroDeSubRedes; i++) {

					ipEmDecimalFinal += ipsPorRede;
					ipEmDecimalInicial += ipsPorRede;
					ipEmDecimalUtilizavelInicial += ipsPorRede;
					ipEmDecimalUtilizavelFinal += ipsPorRede;

					ipInicialEmBinario = calculoSubRede
							.DecimalBinario(ipEmDecimalInicial);
					valoresTabela[i][0] = calculoSubRede.PreencherClasseDec(
							ipInicialEmBinario, spinnerip1);
					valoresTabela[i][2] = calculoSubRede.PreencherClasseDec(
							ipInicialEmBinario, spinnerip1);

					ipFinalEmBinario = calculoSubRede
							.DecimalBinario(ipEmDecimalFinal);
					valoresTabela[i][1] = calculoSubRede.PreencherClasseDec(
							ipFinalEmBinario, spinnerip1);
					valoresTabela[i][3] = calculoSubRede.PreencherClasseDec(
							ipFinalEmBinario, spinnerip1);

					ipUtilizavelInicialEmBinario = calculoSubRede
							.DecimalBinario(ipEmDecimalUtilizavelInicial);
					valoresTabela[i][4] = calculoSubRede.PreencherClasseDec(
							ipUtilizavelInicialEmBinario, spinnerip1);

					ipUtilizavelFinalEmBinario = calculoSubRede
							.DecimalBinario(ipEmDecimalUtilizavelFinal);
					valoresTabela[i][5] = calculoSubRede.PreencherClasseDec(
							ipUtilizavelFinalEmBinario, spinnerip1);

				}

				String colunas[] = { "IP Inicial", "IP Final", "IP Sub Rede",
						"IP Broadcast", "IP Utilizável Inicial",
						"IP Utilizável Final" };

				tableSubredes = new JTable();
				scrollPane.setViewportView(tableSubredes);

				tableSubredes.setForeground(Color.WHITE);
				tableSubredes.setBackground(Color.BLACK);
				tableSubredes.setModel(new DefaultTableModel(valoresTabela,
						colunas));

				DefaultTableModel model = new DefaultTableModel();
				model.setDataVector(valoresTabela, colunas); // Matriz de
																// subredes

				tableSubredes.setModel(model);

				// textAreaFaixaDeBroadcast.setText(textoIFaixaIP);

			}
		});

		JLabel lblNDeIps = new JLabel("N\u00BA de IP's por Sub Rede:");
		lblNDeIps.setFont(new Font("SansSerif", Font.PLAIN, 18));

		textField = new JTextField();
		textField.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setText("128");
		textField.setEditable(false);
		textField.setColumns(10);
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(btnCalcular)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnLimpar))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(lblNmeroDeSubredes)
							.addGap(10)
							.addComponent(comboBoxNumSubRedes, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lblNDeIps)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addContainerGap(123, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(3)
							.addComponent(lblNmeroDeSubredes))
						.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
							.addComponent(comboBoxNumSubRedes, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblNDeIps)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCalcular)
						.addComponent(btnLimpar))
					.addContainerGap(304, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);

		JLabel lblIpDeRede = new JLabel("Ip de Rede:");
		lblIpDeRede.setFont(new Font("SansSerif", Font.PLAIN, 18));

		JLabel lblMscaraDaRede = new JLabel("M\u00E1scara da Rede:");
		lblMscaraDaRede.setFont(new Font("SansSerif", Font.PLAIN, 18));
		spinnerip1.setFont(new Font("Times New Roman", Font.PLAIN, 14));

		spinnerip1.setModel(new SpinnerNumberModel(new Integer(192), null,
				null, new Integer(1)));
		spinnerip2.setFont(new Font("Times New Roman", Font.PLAIN, 14));

		spinnerip2.setModel(new SpinnerNumberModel(new Integer(168), null,
				null, new Integer(1)));

		textFieldMask_1 = new JTextField();
		textFieldMask_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		textFieldMask_1.setEditable(false);
		textFieldMask_1.setText("255");
		textFieldMask_1.setColumns(10);

		textFieldMask_2 = new JTextField();
		textFieldMask_2.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		textFieldMask_2.setEditable(false);
		textFieldMask_2.setText("255");
		textFieldMask_2.setColumns(10);

		textFieldMask_3 = new JTextField();
		textFieldMask_3.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		textFieldMask_3.setEditable(false);
		textFieldMask_3.setText("255");
		textFieldMask_3.setColumns(10);

		textFieldMask_4 = new JTextField();
		textFieldMask_4.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		textFieldMask_4.setEditable(false);
		textFieldMask_4.setText("0");
		textFieldMask_4.setColumns(10);

		JLabel lblClasseDeRede = new JLabel("Classe de Rede:");
		lblClasseDeRede.setFont(new Font("SansSerif", Font.PLAIN, 18));
		comboBoxClasseDeRede.setCursor(Cursor
				.getPredefinedCursor(Cursor.HAND_CURSOR));
		comboBoxClasseDeRede.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		comboBoxClasseDeRede.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				
				if (comboBoxClasseDeRede.getSelectedIndex() == 2) {
					if (tableSubredes.getRowCount() >= 1) {
						limparTabela();
					}
					
					spinnerip2.setEnabled(true);;
					spinnerip3.setEnabled(true);
				

					spinnerip1.setModel(new SpinnerNumberModel(192, 192, 223, 1));
					spinnerip2.setModel(new SpinnerNumberModel(0, 0, 255, 1));
					spinnerip3.setModel(new SpinnerNumberModel(0, 0, 255, 1));
					spinnerip4.setEnabled(false);
					
					comboBoxNumSubRedes
							.setModel(new DefaultComboBoxModel(new String[] {
									"2", "4", "8", "16", "32", "64" }));
					textFieldMask_1.setText("255");
					textFieldMask_2.setText("255");
					textFieldMask_3.setText("255");
					textFieldMask_4.setText("0");

					if (comboBoxNumSubRedes.getSelectedIndex() == 0) {
						textField.setText("128");
					} else if (comboBoxNumSubRedes.getSelectedIndex() == 1) {
						textField.setText("64");
					} else if (comboBoxNumSubRedes.getSelectedIndex() == 2) {
						textField.setText("32");
					} else if (comboBoxNumSubRedes.getSelectedIndex() == 3) {
						textField.setText("16");
					} else if (comboBoxNumSubRedes.getSelectedIndex() == 4) {
						textField.setText("8");
					} else if (comboBoxNumSubRedes.getSelectedIndex() == 5) {
						textField.setText("4");
					}

				} else if (comboBoxClasseDeRede.getSelectedIndex() == 1) {
					if (tableSubredes.getRowCount() >= 1) {
						limparTabela();
					}
					spinnerip2.setEnabled(true);					
					
					spinnerip1.setModel(new SpinnerNumberModel(128, 128, 191, 1));
					spinnerip2.setModel(new SpinnerNumberModel(0, 0, 255, 1));
					spinnerip3.setEnabled(false);
					spinnerip4.setEnabled(false);
					
					comboBoxNumSubRedes
							.setModel(new DefaultComboBoxModel(new String[] {
									"2", "4", "8", "16", "32", "64", "128",
									"256", "512", "1024", "2048", "4096",
									"8192", "16384" }));
					textFieldMask_1.setText("255");
					textFieldMask_2.setText("255");
					textFieldMask_3.setText("0");
					textFieldMask_4.setText("0");

					if (comboBoxNumSubRedes.getSelectedIndex() == 0) {
						textField.setText("32768");
					} else if (comboBoxNumSubRedes.getSelectedIndex() == 1) {
						textField.setText("16384");
					} else if (comboBoxNumSubRedes.getSelectedIndex() == 2) {
						textField.setText("8192");
					} else if (comboBoxNumSubRedes.getSelectedIndex() == 3) {
						textField.setText("4096");
					} else if (comboBoxNumSubRedes.getSelectedIndex() == 4) {
						textField.setText("2048");
					} else if (comboBoxNumSubRedes.getSelectedIndex() == 5) {
						textField.setText("1024");
					} else if (comboBoxNumSubRedes.getSelectedIndex() == 6) {
						textField.setText("512");
					} else if (comboBoxNumSubRedes.getSelectedIndex() == 7) {
						textField.setText("256");
					} else if (comboBoxNumSubRedes.getSelectedIndex() == 8) {
						textField.setText("128");
					} else if (comboBoxNumSubRedes.getSelectedIndex() == 9) {
						textField.setText("64");
					} else if (comboBoxNumSubRedes.getSelectedIndex() == 10) {
						textField.setText("32");
					} else if (comboBoxNumSubRedes.getSelectedIndex() == 11) {
						textField.setText("16");
					} else if (comboBoxNumSubRedes.getSelectedIndex() == 13) {
						textField.setText("8");
					} else if (comboBoxNumSubRedes.getSelectedIndex() == 14) {
						textField.setText("4");
					}

				}
				
				else if(comboBoxClasseDeRede.getSelectedIndex() == 0){
					if (tableSubredes.getRowCount() >= 1) {
						limparTabela();
					}

					spinnerip1.setModel(new SpinnerNumberModel(1, 1, 126, 1));
					spinnerip2.setEnabled(false);;
					spinnerip3.setEnabled(false);
					spinnerip4.setEnabled(false);
					
					
					comboBoxNumSubRedes
							.setModel(new DefaultComboBoxModel(new String[] {
									"2", "4", "8", "16", "32", "64", "128",
									"256", "512", "1024", "2048", "4096",
									"8192", "16384","32768","65536", "131072", "262144", "524288" , "1048576" , "2097152" , "4194304"  }));
					textFieldMask_1.setText("255");
					textFieldMask_2.setText("0");
					textFieldMask_3.setText("0");
					textFieldMask_4.setText("0");

					
					if (comboBoxNumSubRedes.getSelectedIndex() == 0) {
						textField.setText("8388608");
					} else if (comboBoxNumSubRedes.getSelectedIndex() == 1) {
						textField.setText("4194304");
					} else if (comboBoxNumSubRedes.getSelectedIndex() == 2) {
						textField.setText("2097152");
					} else if (comboBoxNumSubRedes.getSelectedIndex() == 3) {
						textField.setText("1048576");
					} else if (comboBoxNumSubRedes.getSelectedIndex() == 4) {
						textField.setText("524288");
					} else if (comboBoxNumSubRedes.getSelectedIndex() == 5) {
						textField.setText("262144");
					} else if (comboBoxNumSubRedes.getSelectedIndex() == 6) {
						textField.setText("131072");
					} else if (comboBoxNumSubRedes.getSelectedIndex() == 7) {
						textField.setText("65536");
					} else if (comboBoxNumSubRedes.getSelectedIndex() == 8) {
						textField.setText("32768");
					} else if (comboBoxNumSubRedes.getSelectedIndex() == 9) {
						textField.setText("16384");
					} else if (comboBoxNumSubRedes.getSelectedIndex() == 10) {
						textField.setText("8192");
					} else if (comboBoxNumSubRedes.getSelectedIndex() == 11) {
						textField.setText("4096");
					} else if (comboBoxNumSubRedes.getSelectedIndex() == 12) {
						textField.setText("2048");
					}else if (comboBoxNumSubRedes.getSelectedIndex() == 13) {
						textField.setText("1024");
					}else if (comboBoxNumSubRedes.getSelectedIndex() == 14) {
						textField.setText("512");
					}else if (comboBoxNumSubRedes.getSelectedIndex() == 15) {
						textField.setText("256");
					}else if (comboBoxNumSubRedes.getSelectedIndex() == 16) {
						textField.setText("128");
					}else if (comboBoxNumSubRedes.getSelectedIndex() == 17) {
						textField.setText("64");
					}else if (comboBoxNumSubRedes.getSelectedIndex() == 18) {
						textField.setText("32");
					}else if (comboBoxNumSubRedes.getSelectedIndex() == 19) {
						textField.setText("16");
					}else if (comboBoxNumSubRedes.getSelectedIndex() == 20) {
						textField.setText("8");
					}else if (comboBoxNumSubRedes.getSelectedIndex() == 21) {
						textField.setText("4");
					}

				}
				
				
			}
		});

		comboBoxClasseDeRede.addInputMethodListener(new InputMethodListener() {
			public void caretPositionChanged(InputMethodEvent arg0) {

			}

			public void inputMethodTextChanged(InputMethodEvent arg0) {
			}
		});
		comboBoxClasseDeRede.setModel(new DefaultComboBoxModel(new String[] {"Classe A", "Classe B", "Classe C"}));
		comboBoxClasseDeRede.setSelectedIndex(2);

		JLabel lblMscaraDaSub = new JLabel("M\u00E1scara da Sub Rede:");
		lblMscaraDaSub.setFont(new Font("SansSerif", Font.PLAIN, 18));

		textFieldMascaraSubRedes = new JTextField();
		textFieldMascaraSubRedes.setFont(new Font("SansSerif", Font.PLAIN, 12));
		textFieldMascaraSubRedes.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldMascaraSubRedes.setText("--Calcule as Sub Redes--");
		textFieldMascaraSubRedes.setEditable(false);
		textFieldMascaraSubRedes.setColumns(10);

		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblMscaraDaSub)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblMscaraDaRede)
								.addComponent(lblIpDeRede))
							.addGap(31)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panel.createSequentialGroup()
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(comboBoxClasseDeRede, 0, 52, Short.MAX_VALUE))
										.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
											.addComponent(spinnerip1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(spinnerip2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addGap(1)))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(spinnerip3, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(spinnerip4, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
									.addGap(1))
								.addGroup(gl_panel.createSequentialGroup()
									.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
										.addGroup(gl_panel.createSequentialGroup()
											.addGap(16)
											.addComponent(textFieldMascaraSubRedes, GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE))
										.addGroup(gl_panel.createSequentialGroup()
											.addComponent(textFieldMask_1, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(textFieldMask_2, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(textFieldMask_3, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(textFieldMask_4, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
											.addGap(2)))
									.addGap(24)))
							.addGap(58))
						.addComponent(lblClasseDeRede)))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblClasseDeRede)
						.addComponent(comboBoxClasseDeRede, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblIpDeRede)
						.addComponent(spinnerip1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(spinnerip2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(spinnerip3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(spinnerip4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(textFieldMask_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblMscaraDaRede)
						.addComponent(textFieldMask_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldMask_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldMask_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblMscaraDaSub)
						.addComponent(textFieldMascaraSubRedes, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		spinnerip3.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		spinnerip4.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
	}

	public void limparTabela() {
		textFieldMascaraSubRedes.setText("--Calcule as Sub Redes--");
		DefaultTableModel model = (DefaultTableModel) tableSubredes.getModel();
	    model.setRowCount(0);
	}
}
