///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package hotel.management.system;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.sql.*;
//import org.jfree.chart.ChartFactory;
//import org.jfree.chart.ChartFrame;
//import org.jfree.chart.JFreeChart;
//import org.jfree.data.category.DefaultCategoryDataset;
//import javax.swing.*;
//
//public class Analysis extends JFrame{
//    public static String hidi;
//
//    JButton cancel;
//
//    Analysis(String hid) {
//        hidi = hid;
//        getContentPane().setBackground(Color.WHITE);
//        setLayout(null);
//        try {
//
//            Conn c = new Conn();
//
//            String sql = "SELECT deposit, number FROM customer where hotel_id = '" + hidi + "'";
////
////            PreparedStatement statement = c.prepareStatement(sql);
//            ResultSet result = c.s.executeQuery(sql);
//
//            DefaultCategoryDataset dataset = new DefaultCategoryDataset();
//
//            while (result.next()) {
//                dataset.addValue(result.getDouble("deposit"), "deposit", result.getString("number"));
//            }
//
//            JFreeChart chart = ChartFactory.createBarChart("Price vs. Customer ID", "number", "deposit", dataset);
//
//            ChartFrame frame = new ChartFrame("Customer wise deposit", chart);
//            frame.setBounds(150, 200, 500, 400);
//            frame.setVisible(true);
//
//            //
//
//        } catch (SQLException ex) {
//            System.out.println("Error: " + ex.getMessage());
//        }
//
//
//    }
//
//
//
//    public static void main(String[] args){
//        new Analysis(hidi);
//    }
//}


package hotel.management.system;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import javax.swing.*;

public class Analysis extends JFrame {
    public static String hidi;
    private class AnalysisModel {
        
    }
    
    private class AnalysisView extends JFrame {
        JButton cancel;

    AnalysisView(String hid) {
        hidi = hid;
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        try {

            Conn c = new Conn();

            String sql = "SELECT deposit, number FROM customer where hotel_id = '" + hidi + "'";
//
//            PreparedStatement statement = c.prepareStatement(sql);
            ResultSet result = c.s.executeQuery(sql);

            DefaultCategoryDataset dataset = new DefaultCategoryDataset();

            while (result.next()) {
                dataset.addValue(result.getDouble("deposit"), "deposit", result.getString("number"));
            }

            JFreeChart chart = ChartFactory.createBarChart("Price vs. Customer ID", "number", "deposit", dataset);

            ChartFrame frame = new ChartFrame("Customer wise deposit", chart);
            frame.setBounds(150, 200, 500, 400);
            frame.setVisible(true);

            //

        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    }
    
     // Controller
    private class AnalysisController{
        private AnalysisModel model;
        private AnalysisView view;
        
        AnalysisController(AnalysisModel model, AnalysisView view) {
            this.model = model;
            this.view = view;
        }
       
    }
    
    public Analysis(String hid) {
        AnalysisModel model = new AnalysisModel();
        AnalysisView view = new AnalysisView(hid);
        AnalysisController controller = new AnalysisController(model, view);
    }
    
    public static void main(String[] args) {
        new Analysis(hidi);
    }
}