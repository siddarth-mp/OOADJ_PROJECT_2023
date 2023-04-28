package hotel.management.system;

import java.awt.*;
import java.sql.*;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

import javax.swing.*;

public class Depanalysis extends JFrame {
    public static String hidi;
    Depanalysis(String hid){
        hidi = hid;
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        try{

            Conn c = new Conn();

            String sql = "SELECT dname, budget AS Budget FROM department where hotel_id = '"+hidi+"'";

            //PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet result = c.s.executeQuery(sql);

            DefaultPieDataset dataset = new DefaultPieDataset();

            while (result.next()) {
                dataset.setValue(result.getString("dname"), result.getInt("Budget"));
            }

            JFreeChart chart = ChartFactory.createPieChart("Department Investments of Hotel: "+hidi, dataset, true, true, false);

            ChartFrame frame = new ChartFrame("Pie Chart of departments", chart);
            //frame.pack();
            frame.setBounds(500,500,800,800);
            frame.setVisible(true);
        }catch(Exception e){e.printStackTrace();}

    }
    public static void main(String[] args){
        new Depanalysis(hidi);
}
}