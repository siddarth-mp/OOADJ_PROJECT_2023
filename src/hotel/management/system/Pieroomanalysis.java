///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package hotel.management.system;
//import java.awt.*;
//import java.sql.*;
//import org.jfree.chart.ChartFactory;
//import org.jfree.chart.ChartFrame;
//import org.jfree.chart.JFreeChart;
//import org.jfree.data.general.DefaultPieDataset;
//import javax.swing.*;
//
//public class Pieroomanalysis extends JFrame{
//    public static String hidi;
//    Pieroomanalysis(String hid){
//        hidi = hid;
//        getContentPane().setBackground(Color.WHITE);
//        setLayout(null);
//        try{
//
//            Conn c = new Conn();
//
//            String sql = "SELECT bed_type, COUNT(*) AS bed_count FROM room where hotel_id = '"+hidi+"' GROUP BY bed_type ";
//
//            //PreparedStatement statement = conn.prepareStatement(sql);
//            ResultSet result = c.s.executeQuery(sql);
//
//            DefaultPieDataset dataset = new DefaultPieDataset();
//
//            while (result.next()) {
//                dataset.setValue(result.getString("bed_type"), result.getInt("bed_count"));
//            }
//
//            JFreeChart chart = ChartFactory.createPieChart("Distribution of Bed Types", dataset, true, true, false);
//
//            ChartFrame frame = new ChartFrame("Pie Chart Example", chart);
//            //frame.pack();
//            frame.setBounds(500,500,800,800);
//            frame.setVisible(true);
//        }catch(Exception e){e.printStackTrace();}
//
//    }
//    public static void main(String[] args){
//        new Pieroomanalysis(hidi);
//    }
//}

package hotel.management.system;
import java.awt.*;
import java.sql.*;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import javax.swing.*;

public class Pieroomanalysis extends JFrame{
    public static String hidi;
    private class PieroomanalysisModel {
        
    }
    private class PieroomanalysisView extends JFrame {
        PieroomanalysisView(String hid){
        hidi = hid;
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        try{

            Conn c = new Conn();

            String sql = "SELECT bed_type, COUNT(*) AS bed_count FROM room where hotel_id = '"+hidi+"' GROUP BY bed_type ";

            //PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet result = c.s.executeQuery(sql);

            DefaultPieDataset dataset = new DefaultPieDataset();

            while (result.next()) {
                dataset.setValue(result.getString("bed_type"), result.getInt("bed_count"));
            }

            JFreeChart chart = ChartFactory.createPieChart("Distribution of Bed Types", dataset, true, true, false);

            ChartFrame frame = new ChartFrame("Pie Chart Example", chart);
            //frame.pack();
            frame.setBounds(500,500,800,800);
            frame.setVisible(true);
        }catch(Exception e){e.printStackTrace();}

    }
    }
    
    private class PieroomanalysisController{
        private PieroomanalysisModel model;
        private PieroomanalysisView view;
        
        PieroomanalysisController(PieroomanalysisModel model, PieroomanalysisView view) {
            this.model = model;
            this.view = view;
        }
    }
    
    public Pieroomanalysis(String hidi) {
        PieroomanalysisModel model = new PieroomanalysisModel();
        PieroomanalysisView view = new PieroomanalysisView(hidi);
    }
    
    public static void main(String[] args) {
        new Pieroomanalysis(hidi);
    }
}