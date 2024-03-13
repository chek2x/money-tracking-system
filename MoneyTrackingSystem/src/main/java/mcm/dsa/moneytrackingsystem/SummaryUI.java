/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mcm.dsa.moneytrackingsystem;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import javax.swing.JFrame;
import org.jfree.chart.plot.PiePlot3D;

/**
 *
 * @author zazhe
 */
public class SummaryUI extends JFrame{
    public SummaryUI(String appTitle, String chartTitle) {
        PieDataset dataSet = createDataset();
        JFreeChart chart = createChart(dataSet, chartTitle);
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(500, 300));
        setContentPane(chartPanel);
        setResizable(false);
        setVisible(true);
    }

    private PieDataset createDataset() {
        DefaultPieDataset result = new DefaultPieDataset();
        for (int i = 0; i < AddItemUI.categoryBox.getItemCount(); i++) {
            result.setValue(AddItemUI.categoryBox.getItemAt(i), MoneyTrackerUI.totals[i]);
        }
        result.setValue("Income", MoneyTrackerUI.totals[6]);
        return result;
    }

    private JFreeChart createChart(PieDataset data, String title) {
        JFreeChart chart = ChartFactory.createPieChart3D(title, data, true, true, false);
        PiePlot3D plot  = (PiePlot3D) chart.getPlot();
        plot.setStartAngle(0);
        plot.setForegroundAlpha(0.5f);
        return chart;
    }
}
