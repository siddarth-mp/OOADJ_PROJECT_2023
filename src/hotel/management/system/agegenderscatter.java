/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.management.system;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
/**
 *
 * @author Umesh
 */
public class agegenderscatter {
    public static void main(String[] args) throws Exception {
        // Connect to the database
        Conn c = new Conn();

        // Query the database to get job and salary data
        String query = "SELECT job, salary FROM employee ";
        //Statement stmt = c.s.createStatement();
        ResultSet rs = c.s.executeQuery(query);

        // Map each job category to a unique integer value
        Map<String, Integer> jobMap = new HashMap<>();
        int jobCount = 0;
        while (rs.next()) {
            String job = rs.getString("job");
            if (!jobMap.containsKey(job)) {
                jobMap.put(job, jobCount++);
            }
        }
        rs.beforeFirst();

        // Create a dataset for the scatter plot
        XYSeriesCollection dataset = new XYSeriesCollection();
        XYSeries series = new XYSeries("Job vs Salary");
        while (rs.next()) {
            String job = rs.getString("job");
            int jobValue = jobMap.get(job);
            double salary = rs.getDouble("salary");
            series.add(jobValue, salary);
        }
        dataset.addSeries(series);

        // Create the chart and set the axis labels
        JFreeChart chart = ChartFactory.createScatterPlot("Job vs Salary", "Job", "Salary", dataset,
                PlotOrientation.VERTICAL, true, true, false);

        // Display the chart in a frame
        ChartFrame frame = new ChartFrame("Scatter Plot Example", chart);
        frame.setVisible(true);
        frame.setSize(800, 600);

        // Close the database connection

    }
    
}
