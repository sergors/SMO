package com.sergors.mip;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.DefaultXYDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.*;
import java.awt.*;

public class SMOWindow extends JFrame {
    private JFreeChart jFreeChart;

    public SMOWindow() {
        jFreeChart = ChartFactory.createXYLineChart(
                "Chart",
                "time, t",
                "count app",
                createDataSet(),
                PlotOrientation.VERTICAL,
                true, true, false
        );
        ChartPanel chartPanel = new ChartPanel(jFreeChart);
        chartPanel.setPreferredSize(new Dimension(560, 360));
        setTitle("SMO");
        setSize(600, 400);
        setContentPane(chartPanel);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private XYDataset createDataSet() {
        final XYSeries applications = new XYSeries("apps");
        applications.add(1, 1);
        applications.add(2, 2);
        applications.add(3, 3);
        applications.add(4, 4);
        applications.add(5, 3);
        applications.add(6, 4);
        applications.add(7, 3);
        applications.add(8, 4);
        applications.add(9, 3);
        applications.add(10, 4);
        applications.add(11, 3);
        applications.add(12, 4);
        applications.add(13, 5);
        final XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(applications);
        return dataset;
    }

    public static void kek(String[] args) {
        SMOWindow window = new SMOWindow();
        window.setVisible(true);
    }
}
