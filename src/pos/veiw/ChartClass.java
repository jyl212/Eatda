package pos.veiw;

import java.awt.Color;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartRenderingInfo;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.entity.StandardEntityCollection;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
public class ChartClass {
	public JFreeChart showBarChart(int cashvalue,int cardvalue){
		DefaultCategoryDataset dataset=new DefaultCategoryDataset();
		dataset.addValue(cashvalue,"2017","cash");
		dataset.addValue(cardvalue,"2017","card");
		JFreeChart chart=ChartFactory.createBarChart("credit/card","type","total",dataset,PlotOrientation.VERTICAL,true,true,false);
		
		chart.setBackgroundPaint(Color.white);
		chart.setTitle("credit/card");
		ChartRenderingInfo info=new ChartRenderingInfo(new StandardEntityCollection());
		return chart;
	}
	public JFreeChart showPieChart(int man,int woman){
		DefaultPieDataset dataset=new DefaultPieDataset();
		dataset.setValue("man",man);
		dataset.setValue("woman",woman);
		JFreeChart chart=ChartFactory.createPieChart("man/wman",dataset,true,true,false);
		chart.setBackgroundPaint(Color.white);
		chart.setTitle("man/woman");
		ChartRenderingInfo info=new ChartRenderingInfo(new StandardEntityCollection());
		return chart;
	}
}