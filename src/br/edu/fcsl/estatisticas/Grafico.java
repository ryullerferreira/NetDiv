package br.edu.fcsl.estatisticas;

import java.awt.BasicStroke;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import br.edu.fcsl.entidade.Parametros;
import br.edu.fcsl.entidade.SisInfo;

public class Grafico extends SisInfo implements Parametros {

	/**
	 * Mï¿½todo que define um dataset para criaï¿½ï¿½o do grï¿½fico, As opï¿½ï¿½es de
	 * quantificaï¿½ï¿½o estatï¿½ticas, sï¿½o setadas conforme a lista de variaï¿½ï¿½oes de
	 * tempo, obtidas pelo processoPing
	 * 
	 * @return
	 */
	private XYDataset createDataset() {
		
		XYSeriesCollection dataset = new XYSeriesCollection();
		XYSeries series1 = new XYSeries("Pacotes");
		
			for (int i = 0; i < variacao.size(); i++) {
				series1.add(i, Double.parseDouble(variacao.get(i)));
			}
		dataset.addSeries(series1);		
		return dataset;

	}

	/**
	 * Método responsï¿½vel por customizar o layout do grï¿½fico
	 * 
	 * @param chart
	 */
	private void customizar(JFreeChart chart) {
		XYPlot plot = chart.getXYPlot();
		XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();

		// setar cor da linha
		renderer.setSeriesPaint(0, Color.GREEN);

		// setar espessura da linha
		renderer.setSeriesStroke(0, new BasicStroke(3.0f));

		// setar cor e borda da margem
		plot.setOutlinePaint(Color.BLACK);
		plot.setOutlineStroke(new BasicStroke(2.0f));

		// renderizar
		plot.setRenderer(renderer);

		// setar cor do background
		plot.setBackgroundPaint(Color.WHITE);

		// setar as cores da linha de grade do grï¿½fico
		plot.setRangeGridlinesVisible(true);
		plot.setRangeGridlinePaint(Color.GRAY);

		plot.setDomainGridlinesVisible(true);
		plot.setDomainGridlinePaint(Color.GRAY);

	}

	/**
	 * Mï¿½todo responsï¿½vel por criar o grï¿½fico
	 * 
	 * @param panel
	 */
	public void criaGrafico(JPanel panel) {
		XYDataset cds = createDataset();
		String titulo = "Variacoes de Tempo";
		String eixoy = "Tempo (ms)";
		String txt_legenda = "Legenda:";
		boolean legenda = true;
		boolean tooltips = true;
		boolean urls = true;
		JFreeChart graf = ChartFactory.createXYLineChart(titulo, txt_legenda,
				eixoy, cds, PlotOrientation.VERTICAL, true, true, false);
		ChartPanel myChartPanel = new ChartPanel(graf, true);
		myChartPanel.setSize(panel.getWidth(), panel.getHeight());
		myChartPanel.setVisible(true);
		panel.removeAll();
		panel.add(myChartPanel);
		panel.revalidate();
		panel.repaint();
		customizar(graf);
	}

	@Override
	public void limparDados(JComboBox opcaoA, JComboBox opcaoB,
			JTextArea painel, JTextField campo, List<String> comando) {

	}

}
