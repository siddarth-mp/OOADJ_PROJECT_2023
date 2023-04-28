//package hotel.management.system;
//
//import java.awt.Color;
//import java.awt.Dimension;
//import java.sql.ResultSet;
//import java.util.ArrayList;
//import java.util.List;
//import javax.swing.JFrame;
//import org.jfree.chart.ChartFactory;
//import org.jfree.chart.ChartPanel;
//import org.jfree.chart.JFreeChart;
//import org.jfree.chart.axis.NumberAxis;
//import org.jfree.chart.plot.PlotOrientation;
//import org.jfree.chart.plot.XYPlot;
//import org.jfree.chart.renderer.xy.XYBarRenderer;
//import org.jfree.chart.renderer.xy.StandardXYBarPainter;
//import org.jfree.data.xy.XYSeries;
//import org.jfree.data.xy.XYSeriesCollection;
//public class histogram extends JFrame {
//    public static String hidi;
//
//     histogram(String hid) {
//         getContentPane().setBackground(Color.WHITE);
//         setLayout(null);
//        hidi = hid;
//        // Create dataset
//        // HistogramDataset dataset = new HistogramDataset();
//        List<Integer> ages = new ArrayList<>();
//        List<Integer> salaries = new ArrayList<>();
//
//        try {
//            // Connect to database
//            Conn c = new Conn();
//            // Retrieve data
//            String sql = "SELECT age, salary FROM employee where hotel_id = '"+hidi+"'";
//            //PreparedStatement pstmt = conn.prepareStatement(sql);
//            ResultSet rs = c.s.executeQuery(sql);
//            while (rs.next()) {
//                ages.add(rs.getInt("age"));
//                salaries.add(rs.getInt("salary"));
//            }
//            // Add data to dataset
//            double[] ageValues = ages.stream().mapToDouble(Integer::doubleValue).toArray();
//            double[] salaryValues = salaries.stream().mapToDouble(Integer::doubleValue).toArray();
//
//            XYSeries series = new XYSeries("Age vs Salary");
//            for (int i = 0; i < ageValues.length; i++) {
//                series.add(ageValues[i], salaryValues[i]);
//            }
//            XYSeriesCollection dataset = new XYSeriesCollection();
//            dataset.addSeries(series);
//
//            JFreeChart chart = ChartFactory.createHistogram("Age vs Salary", "Age", "Salary", dataset, PlotOrientation.VERTICAL, true, true, false);
//
//
//            // Create chart
//
//
//            // Customize chart
//            chart.setBackgroundPaint(Color.WHITE);
//
//            XYPlot plot = (XYPlot) chart.getPlot();
//            plot.setBackgroundPaint(Color.WHITE);
//            plot.setDomainGridlinePaint(Color.GRAY);
//            plot.setRangeGridlinePaint(Color.GRAY);
//
//            XYBarRenderer renderer = (XYBarRenderer) plot.getRenderer();
//            renderer.setBarPainter(new StandardXYBarPainter());
//            renderer.setSeriesPaint(0, new Color(31, 119, 180));
//
//            NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
//            rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
//
//            // Create chart panel
//            ChartPanel chartPanel = new ChartPanel(chart);
//            chartPanel.setPreferredSize(new Dimension(500, 300));
//            setContentPane(chartPanel);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        setBounds(800,800,800,800);
//        setVisible(true);
//
//    }
//    public static void main(String[] args) {
//        // Create chart
//        histogram histogram = new histogram("" + hidi);
//        histogram.pack();
//        histogram.setLocationRelativeTo(null);
//        histogram.setVisible(true);
//}
//}


package hotel.management.system;

import java.awt.Color;
import java.awt.Dimension;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYBarRenderer;
import org.jfree.chart.renderer.xy.StandardXYBarPainter;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;


public class histogram extends JFrame {
    public static String hidi;
private class histogramModel {
        
    }

 private class histogramView extends JFrame {
     histogramView(String hid) {
         getContentPane().setBackground(Color.WHITE);
         setLayout(null);
        hidi = hid;
        // Create dataset
        // HistogramDataset dataset = new HistogramDataset();
        List<Integer> ages = new ArrayList<>();
        List<Integer> salaries = new ArrayList<>();

        try {
            // Connect to database
            Conn c = new Conn();
            // Retrieve data
            String sql = "SELECT age, salary FROM employee where hotel_id = '"+hidi+"'";
            //PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = c.s.executeQuery(sql);
            while (rs.next()) {
                ages.add(rs.getInt("age"));
                salaries.add(rs.getInt("salary"));
            }
            // Add data to dataset
            double[] ageValues = ages.stream().mapToDouble(Integer::doubleValue).toArray();
            double[] salaryValues = salaries.stream().mapToDouble(Integer::doubleValue).toArray();

            XYSeries series = new XYSeries("Age vs Salary");
            for (int i = 0; i < ageValues.length; i++) {
                series.add(ageValues[i], salaryValues[i]);
            }
            XYSeriesCollection dataset = new XYSeriesCollection();
            dataset.addSeries(series);

            JFreeChart chart = ChartFactory.createHistogram("Age vs Salary", "Age", "Salary", dataset, PlotOrientation.VERTICAL, true, true, false);


            // Create chart


            // Customize chart
            chart.setBackgroundPaint(Color.WHITE);

            XYPlot plot = (XYPlot) chart.getPlot();
            plot.setBackgroundPaint(Color.WHITE);
            plot.setDomainGridlinePaint(Color.GRAY);
            plot.setRangeGridlinePaint(Color.GRAY);

            XYBarRenderer renderer = (XYBarRenderer) plot.getRenderer();
            renderer.setBarPainter(new StandardXYBarPainter());
            renderer.setSeriesPaint(0, new Color(31, 119, 180));

            NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
            rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());

            // Create chart panel
            ChartPanel chartPanel = new ChartPanel(chart);
            chartPanel.setPreferredSize(new Dimension(500, 300));
            setContentPane(chartPanel);
        } catch (Exception e) {
            e.printStackTrace();
        }
        setBounds(800,800,800,800);
        setVisible(true);

    }
 }
 private class histogramController{
        private histogramModel model;
        private histogramView view;
        
        histogramController(histogramModel model, histogramView view) {
            this.model = model;
            this.view = view;
        }
    }
    
    public histogram(String hidi) {
        histogramModel model = new histogramModel();
        histogramView view = new histogramView(hidi);
    }
    
    public static void main(String[] args) {
        new histogram(hidi);
    }
 }


