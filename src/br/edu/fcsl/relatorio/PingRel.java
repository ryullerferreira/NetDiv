package br.edu.fcsl.relatorio;

import java.util.List;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;
import br.edu.fcsl.entidade.DadosTeste;
 
public class PingRel
{
	private String path; //Caminho base
	
	private String pathToReportPackage; // Caminho para o package onde estão armazenados os relatorios Jarper
	
	//Recupera os caminhos para que a classe possa encontrar os relatórios
	public PingRel() {
		this.path = this.getClass().getClassLoader().getResource("").getPath();
		this.path = this.path.replaceAll("%20", " ");
		this.pathToReportPackage = this.path + "br/edu/fcsl/relatorio/";
		System.out.println(path);
	}
	
	
	//Imprime/gera uma lista de Clientes
	public void imprimir(List<DadosTeste> ping) throws Exception	
	{
		JasperReport report = JasperCompileManager.compileReport(this.getPathToReportPackage() + "RelatorioPing.jrxml");
		
		JasperPrint print = JasperFillManager.fillReport(report, null, new JRBeanCollectionDataSource(ping));
 
		//JasperExportManager.exportReportToPdfFile(print, "Relatorios/Relatorio_Ping.pdf");	
		JasperViewer.viewReport(print, false);
	}
 
	public String getPathToReportPackage() {
		return this.pathToReportPackage;
	}
	
	public String getPath() {
		return this.path;
	}
}
