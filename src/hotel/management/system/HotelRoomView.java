//package hotel.management.system;
//
//import hotel.management.system.Conn;
//
//import java.awt.Color;
//import java.awt.GridBagConstraints;
//import java.awt.GridBagLayout;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import javax.swing.BorderFactory;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JPanel;
//import javax.swing.SwingConstants;
//
//public class HotelRoomView extends JFrame {
//
//    public static String hidi;
//    public HotelRoomView(String hid) {
//        hidi = hid;
//        // Set up the JFrame
//        setTitle("Room Availability ");
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setSize(600, 400);
//        setLocationRelativeTo(null); // Center the JFrame on the screen
//
//        // Set up the content pane
//        JPanel contentPane = new JPanel(new GridBagLayout());
//        setContentPane(contentPane);
//
//
//
//        try{
//            Conn co = new Conn();
//            String query = "SELECT roomnumber, availability FROM room where hotel_id = '"+hidi+"'";
//            ResultSet rs = co.s.executeQuery(query);
//
//            // Iterate over the results and add the room cells to the content pane
//            int row = 0;
//            int col = 0;
//            while (rs.next()) {
//                // Create a JLabel for the room cell
//                JLabel roomLabel = new JLabel(rs.getString("roomnumber"), SwingConstants.CENTER);
//                roomLabel.setOpaque(true);
//                if (rs.getString("availability").equals("Occupied")) {
//                    roomLabel.setBackground(Color.GRAY);
//                    roomLabel.setForeground(Color.BLACK);
//                } else {
//                    roomLabel.setBackground(Color.green);
//                    roomLabel.setForeground(Color.white);
//                }
//                roomLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
//
//                // Add the room cell to the content pane
//                GridBagConstraints c = new GridBagConstraints();
//                c.gridx = col;
//                c.gridy = row;
//                c.weightx = 1.0;
//                c.weighty = 1.0;
//                contentPane.add(roomLabel, c);
//
//                // Increment the row and column counters
//                col++;
//                if (col == 10) {
//                    row++;
//                    col = 0;
//                }
//            }
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//
//        // Make the JFrame visible
//        setVisible(true);
//    }
//
//    public static void main(String[] args) {
//        new HotelRoomView("hidi");
//}
//}

package hotel.management.system;

import hotel.management.system.Conn;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class HotelRoomView extends JFrame {

    public static String hidi;
    private class HotelRoomViewModel {
        
    }
    
     private class HotelRoomViewView extends JFrame {
              public HotelRoomViewView(String hid) {
        hidi = hid;
        // Set up the JFrame
        setTitle("Room Availability ");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null); // Center the JFrame on the screen

        // Set up the content pane
        JPanel contentPane = new JPanel(new GridBagLayout());
        setContentPane(contentPane);



        try{
            Conn co = new Conn();
            String query = "SELECT roomnumber, availability FROM room where hotel_id = '"+hidi+"'";
            ResultSet rs = co.s.executeQuery(query);

            // Iterate over the results and add the room cells to the content pane
            int row = 0;
            int col = 0;
            while (rs.next()) {
                // Create a JLabel for the room cell
                JLabel roomLabel = new JLabel(rs.getString("roomnumber"), SwingConstants.CENTER);
                roomLabel.setOpaque(true);
                if (rs.getString("availability").equals("Occupied")) {
                    roomLabel.setBackground(Color.GRAY);
                    roomLabel.setForeground(Color.BLACK);
                } else {
                    roomLabel.setBackground(Color.green);
                    roomLabel.setForeground(Color.white);
                }
                roomLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

                // Add the room cell to the content pane
                GridBagConstraints c = new GridBagConstraints();
                c.gridx = col;
                c.gridy = row;
                c.weightx = 1.0;
                c.weighty = 1.0;
                contentPane.add(roomLabel, c);

                // Increment the row and column counters
                col++;
                if (col == 10) {
                    row++;
                    col = 0;
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        // Make the JFrame visible
        setVisible(true);
              }
     }
     
     private class HotelRoomViewController{
        private HotelRoomViewModel model;
        private HotelRoomViewView view;
        
        HotelRoomViewController(HotelRoomViewModel model, HotelRoomViewView view) {
            this.model = model;
            this.view = view;
        }
    }
    
    public HotelRoomView(String hidi) {
        HotelRoomViewModel model = new HotelRoomViewModel();
        HotelRoomViewView view = new HotelRoomViewView(hidi);
    }
    
    public static void main(String[] args) {
        new HotelRoomView(hidi);
    }
}