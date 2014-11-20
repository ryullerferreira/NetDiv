package br.edu.fcsl.entidade;

import java.util.stream.IntStream;

import javax.print.DocFlavor.STRING;
import javax.swing.JSpinner;

public class DivisaoDeSubRedes {
	int[] quantSubrede = new int[25];
	String[] classeBin = new String[3];
	int[] classeDec = new int[4];

	/**
	 * A classe A para o calculo ip não será considerada Inicializa o vetor
	 * classeBin das Classes B C e D. Onde estiver zero acrecentará "00000000"
	 */
	public DivisaoDeSubRedes() {

		for (int j = 0; j < classeBin.length; j++) {

			classeBin[j] = new String();

			if (classeBin[j].equals("0") || classeBin[j].equals("")) {
				classeBin[j] = "00000000";
			}
		}
		for (int i = 0; i < quantSubrede.length; i++) {

			quantSubrede[i] = (int) Math.pow(2, i);
		}

	}

	public int[] getQuatSubrede() {
		return quantSubrede;
	}

	public void setQuantSubrede(int[] quantSubrede) {
		this.quantSubrede = quantSubrede;
	}

	public DivisaoDeSubRedes(String[] classeBin, int[] classeDec,
			int[] quantSubrede) {
		super();
		this.classeBin = classeBin;
		this.classeDec = classeDec;
		this.quantSubrede = quantSubrede;

	}

	public String[] getClasseBin() {
		return classeBin;
	}

	public void setClasseBin(String[] classeBin) {
		this.classeBin = classeBin;
	}

	public int[] getClasseDec() {
		return classeDec;
	}

	public void setClasseDec(int[] classeDec) {
		classeDec = classeDec;
	}

	/**
	 * Transforma um número decimal em binário
	 */
	public String DecimalBinario(int valor) {
		int resto = -1;
		StringBuilder sb = new StringBuilder();

		if (valor == 0) {
			return "0";
		}

		/**
		 * enquanto o resultado da divisão por 2 for maior que 0 adiciona o
		 * 
		 * resto ao início da String de retorno
		 */
		while (valor > 0) {
			resto = valor % 2;
			valor = valor / 2;
			sb.insert(0, resto);
		}

		return sb.toString();
	}

	/**
	 * Transforma a sequência binária em um número decimal
	 */
	public int BinarioDecimal(String bin) {
		int num = 0;
		num = Integer.parseInt(bin, 2);
		return num;
	}

	/**
	 * Transforma a sequência binária em um número decimal
	 */
	public String PreencherClasseDec(String b, JSpinner primeiraCasa) {
		/*new Thread(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				super.run();
			}
		}.start();*/
		
		while (b.length() < 24) {
			b = "0" + b;
		}

		classeDec[0] = (int) primeiraCasa.getValue();

		classeDec[1] = BinarioDecimal(String.valueOf(b.subSequence(0, 8)));

		classeDec[2] = BinarioDecimal(String.valueOf(b.subSequence(8, 16)));

		classeDec[3] = BinarioDecimal(String.valueOf(b.subSequence(16, 24)));

		return (String.valueOf(classeDec[0]) + "."
				+ String.valueOf(classeDec[1]) + "."
				+ String.valueOf(classeDec[2]) + "." + String
					.valueOf(classeDec[3]));
	}
}
