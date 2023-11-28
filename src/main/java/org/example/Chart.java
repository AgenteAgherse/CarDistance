package org.example;

import lombok.ToString;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.DefaultXYDataset;
import org.jfree.data.xy.XYDataset;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class Chart {

    public static void createDistanceChart(ArrayList<Auto> data, Integer maxDistance) throws Exception{
        DefaultXYDataset dataset = new DefaultXYDataset();
        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();

        for (int i = 0; i < data.size(); i++) {
            double time[] = generateTime(data.get(i).getTiempoActual());
            dataset.addSeries("Auto " + (i+1), new double[][]{data.get(i).toDouble(), time});
            System.out.println("Auto " + (i+1));
            System.out.println(data.get(i).toString());
            System.out.println("_____________________________________");
            renderer.setSeriesLinesVisible(i, true);
            renderer.setSeriesPaint(i, data.get(i).getColor());
            renderer.setSeriesStroke(i, new BasicStroke(2));
        }

        JFreeChart chart = ChartFactory.createXYLineChart(
                "Distancias recorridas",
      "Distancia",
      "Tiempo",
                dataset,
                PlotOrientation.HORIZONTAL,
                true,
                true,
                false
                );
        chart.getXYPlot().getRangeAxis().setRange(0, maxDistance);
        chart.getXYPlot().setRenderer(renderer);

        BufferedImage image = chart.createBufferedImage(550, 350);
        ImageIO.write(image, "png", new File("distances.png"));

    }


    private static double[] generateTime(Integer time) {
        double[] times = new double[time];
        for (int counter = 0; counter < time; counter++) {
            times[counter] = counter;
        }
        return times;
    }
}
