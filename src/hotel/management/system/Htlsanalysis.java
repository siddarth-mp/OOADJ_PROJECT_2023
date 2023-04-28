//package hotel.management.system;
//import java.sql.*;
//import javax.swing.*;
//import org.jfree.chart.*;
//import org.jfree.data.category.*;
//
//public class Htlsanalysis extends JFrame {
//    public Htlsanalysis() {
//        try{
//            Conn c = new Conn();
//
//            ResultSet rs = c.s.executeQuery("SELECT hotel_id, AVG(rating) as avg_rating FROM feedback GROUP BY hotel_id");
//
//            DefaultCategoryDataset dataset = new DefaultCategoryDataset();
//            while (rs.next()) {
//                int hotelId = rs.getInt("hotel_id");
//                double avgRating = rs.getDouble("avg_rating");
//                dataset.addValue(avgRating, "Average Rating", String.valueOf(hotelId));
//            }
//            JFreeChart chart = ChartFactory.createBarChart("Hotel Ratings", "Hotel ID", "Average Rating", dataset);
//            ChartPanel chartPanel = new ChartPanel(chart);
//
//            // Add the chart panel to the JFrame
//            add(chartPanel);
//        }catch(Exception e){e.printStackTrace();}
//        // Execute an SQL query to retrieve the hotel_id and its corresponding average rating
//
//        // Create a new JBarChart panel and add the data points to it
//
//
//
//
//        // Set the size and visibility of the JFrame
//        setSize(700, 500);
//        setVisible(true);
//    }
//
//    public static void main(String[] args) {
//        Htlsanalysis chart = new Htlsanalysis();
//}
//}


package hotel.management.system;
import java.sql.*;
import javax.swing.*;
import org.jfree.chart.*;
import org.jfree.data.category.*;


public class Htlsanalysis extends JFrame {
     private class HtlsanalysisModel {
         public void connect1()
         {
             
         }
     }
     
     private class HtlsanalysisView extends JFrame {
         public HtlsanalysisView() {
             try{
            Conn c = new Conn();

            ResultSet rs = c.s.executeQuery("SELECT hotel_id, AVG(rating) as avg_rating FROM feedback GROUP BY hotel_id");

            DefaultCategoryDataset dataset = new DefaultCategoryDataset();
            while (rs.next()) {
                int hotelId = rs.getInt("hotel_id");
                double avgRating = rs.getDouble("avg_rating");
                dataset.addValue(avgRating, "Average Rating", String.valueOf(hotelId));
            }
            JFreeChart chart = ChartFactory.createBarChart("Hotel Ratings", "Hotel ID", "Average Rating", dataset);
            ChartPanel chartPanel = new ChartPanel(chart);

            // Add the chart panel to the JFrame
            add(chartPanel);
        }catch(Exception e){e.printStackTrace();}
        setSize(700, 500);
        setVisible(true);
    }
     }
         
    private class HtlsanalysisController{
        private HtlsanalysisModel model;
        private HtlsanalysisView view;
        
        HtlsanalysisController(HtlsanalysisModel model, HtlsanalysisView view) {
            this.model = model;
            this.view = view;
        }
        
        
         

    }
     
     public Htlsanalysis() {
        HtlsanalysisModel model = new HtlsanalysisModel();
        HtlsanalysisView view = new HtlsanalysisView();
        HtlsanalysisController controller = new HtlsanalysisController(model, view);
    }
     
    
    public static void main(String[] args) {
        new Htlsanalysis();
    }
}
     

