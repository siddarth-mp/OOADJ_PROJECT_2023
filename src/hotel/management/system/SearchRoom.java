///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package hotel.management.system;
//import java.awt.BorderLayout;
//import java.awt.*;
//
//import javax.swing.JFrame;
//import javax.swing.JPanel;
//import javax.swing.border.EmptyBorder;
//
//import net.proteanit.sql.DbUtils; //from rs2xml pkg
//
//import javax.swing.JTable;
//import java.sql.*; //for ResultSet
//import javax.swing.*;
//import java.awt.event.ActionListener;
//import java.awt.event.ActionEvent;
//
///**
// *
// * @author Umesh
// */
//public class SearchRoom extends JFrame implements ActionListener{
//    public static String hidi;
//    JTable table;
//    JButton back,submit;
//    JComboBox bedType;
//    JCheckBox available;
//    SearchRoom(String hid){
//        hidi = hid;
//
//
//        getContentPane().setBackground(Color.WHITE);
//        setLayout(null);
//
//        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/sr3.jpg"));
//        Image i2 = i1.getImage().getScaledInstance(600,600,Image.SCALE_DEFAULT);
//        ImageIcon i3 = new ImageIcon(i2);
//        JLabel image = new JLabel(i3);
//        image.setBounds(610,20,370,500);
//        add(image);
//
//        JLabel text = new JLabel("Search for Room");
//        text.setFont(new Font("Tahoma",Font.BOLD,20));
//        text.setBounds(200,30,200,30);
//        add(text);
//
//        JLabel lblbed = new JLabel("Bed Type");
//        lblbed.setBounds(50,100,100,20);
//        add(lblbed);
//
//        //inside combobox pass an array of strings=?creare String object
//        bedType = new JComboBox(new String[]{"Single Bed","Double Bed"});
//        bedType.setBounds(130,100,110,25);
//        bedType.setBackground(Color.WHITE);
//        add(bedType);
//
//        //only display available:
//
//        available = new JCheckBox("Only display Available");
//        available.setBounds(320,100,150,25);
//        available.setBackground(Color.WHITE);
//        add(available);
//
//
//        //for putting col names on top of table in GUI
//        JLabel l1 = new JLabel("Room number");
//        l1.setBounds(20,160,100,20);
//        add(l1);
//
//        JLabel l2 = new JLabel("Availability");
//        l2.setBounds(150,160,100,20);
//        add(l2);
//
//        JLabel l3 = new JLabel("Status");
//        l3.setBounds(280,160,100,20);// col name shuld appear in same line but move towards left side
//        add(l3);
//
//        JLabel l4 = new JLabel("Price");
//        l4.setBounds(400,160,100,20);// col name shuld appear in same line but move towards left side
//        add(l4);
//
//        JLabel l5 = new JLabel("Bed type");
//        l5.setBounds(520,160,100,20);// col name shuld appear in same line but move towards left side
//        add(l5);
//
//        table = new JTable();//1st arg: data to put in , 2nd param: headers
//        table.setBounds(0,200,600,300);
//        add(table);
//
//        try{
//            Conn c = new Conn();
//            String query = "select * from room where hotel_id = '"+hidi+"' ";
//            ResultSet rs = c.s.executeQuery(query);
//
//            table.setModel(DbUtils.resultSetToTableModel(rs));//object of Dbutils;which has method of converting resultset to table
//            //need to load this dt from rs to above table
//            // can use 2 for loops and do manually or use rs2xml.jva pkg (imported)
//        }catch(Exception e){e.printStackTrace();}
//        back = new JButton("Back");
//        back.setBackground(Color.BLACK);
//        back.setForeground(Color.WHITE);
//        back.addActionListener(this);
//        back.setBounds(320,500,120,30);
//        add(back);
//
//        submit = new JButton("Submit");
//        submit.setBackground(Color.BLACK);
//        submit.setForeground(Color.WHITE);
//        submit.addActionListener(this);
//        submit.setBounds(110,500,120,30);
//        add(submit);
//
//        setBounds(300,200,1050,600);
//        setVisible(true);
//    }
//
//    public void actionPerformed(ActionEvent ae){
//        if(ae.getSource()==submit){
//            try{
//                //1st type of query is when single or double bed is selected and "display available" checkbox is unselected, 2nd condition is when this checkbox is selected
//                String query1 = "select * from room where (bed_type = '"+bedType.getSelectedItem()+"' and hotel_id = '"+hidi+"') ";
//                String query2 = "select * from room where (availability = 'Available' and bed_type = '"+bedType.getSelectedItem()+"' and hotel_id = '"+hidi+"') ";
//
//                Conn conn = new Conn();
//                ResultSet rs;
//                if(available.isSelected()){
//                    //if checkbox is ticked use 2nd query
//                    rs = conn.s.executeQuery(query2);
//                }else {
//                    //if checkbox is not ticked , execute query 1
//                   rs = conn.s.executeQuery(query1);
//                }
//                table.setModel(DbUtils.resultSetToTableModel(rs));
//            }catch(Exception e){e.printStackTrace();}
//        }
//        else{
//            setVisible(false);
//            
//        }
//
//    }
//    public static void main(String[] args){
//        new SearchRoom(hidi);
//    }
//
//}



package hotel.management.system;
import java.awt.BorderLayout;
import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils; //from rs2xml pkg

import javax.swing.JTable;
import java.sql.*; //for ResultSet
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 *
 * @author Umesh
 */
public class SearchRoom extends JFrame {
    public static String hidi;
     private class SearchRoomModel {
         public void connect(SearchRoomView view, String hidi)
         {
              try{
                //1st type of query is when single or double bed is selected and "display available" checkbox is unselected, 2nd condition is when this checkbox is selected
                String query1 = "select * from room where (bed_type = '"+view.bedType.getSelectedItem()+"' and hotel_id = '"+hidi+"') ";
                String query2 = "select * from room where (availability = 'Available' and bed_type = '"+view.bedType.getSelectedItem()+"' and hotel_id = '"+hidi+"') ";

                Conn conn = new Conn();
                ResultSet rs;
                if(view.available.isSelected()){
                    //if checkbox is ticked use 2nd query
                    rs = conn.s.executeQuery(query2);
                }else {
                    //if checkbox is not ticked , execute query 1
                   rs = conn.s.executeQuery(query1);
                }
                view.table.setModel(DbUtils.resultSetToTableModel(rs));
            }catch(Exception e){e.printStackTrace();}
         }
     }
     private class SearchRoomView extends JFrame {
         JTable table;
         JLabel image;
    JButton back,submit;
    JComboBox bedType;
    JCheckBox available;
    SearchRoomView(String hid){
        hidi = hid;


        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/sr3.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600,600,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        image = new JLabel(i3);
        image.setBounds(610,20,370,500);
        add(image);

        JLabel text = new JLabel("Search for Room");
        text.setFont(new Font("Tahoma",Font.BOLD,20));
        text.setBounds(200,30,200,30);
        add(text);

        JLabel lblbed = new JLabel("Bed Type");
        lblbed.setBounds(50,100,100,20);
        add(lblbed);

        //inside combobox pass an array of strings=?creare String object
        bedType = new JComboBox(new String[]{"Single Bed","Double Bed"});
        bedType.setBounds(130,100,110,25);
        bedType.setBackground(Color.WHITE);
        add(bedType);

        //only display available:

        available = new JCheckBox("Only display Available");
        available.setBounds(320,100,150,25);
        available.setBackground(Color.WHITE);
        add(available);


        //for putting col names on top of table in GUI
        JLabel l1 = new JLabel("Room number");
        l1.setBounds(20,160,100,20);
        add(l1);

        JLabel l2 = new JLabel("Availability");
        l2.setBounds(150,160,100,20);
        add(l2);

        JLabel l3 = new JLabel("Status");
        l3.setBounds(280,160,100,20);// col name shuld appear in same line but move towards left side
        add(l3);

        JLabel l4 = new JLabel("Price");
        l4.setBounds(400,160,100,20);// col name shuld appear in same line but move towards left side
        add(l4);

        JLabel l5 = new JLabel("Bed type");
        l5.setBounds(520,160,100,20);// col name shuld appear in same line but move towards left side
        add(l5);

        table = new JTable();//1st arg: data to put in , 2nd param: headers
        table.setBounds(0,200,600,300);
        add(table);

        try{
            Conn c = new Conn();
            String query = "select * from room where hotel_id = '"+hidi+"' ";
            ResultSet rs = c.s.executeQuery(query);

            table.setModel(DbUtils.resultSetToTableModel(rs));//object of Dbutils;which has method of converting resultset to table
            //need to load this dt from rs to above table
            // can use 2 for loops and do manually or use rs2xml.jva pkg (imported)
        }catch(Exception e){e.printStackTrace();}
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
//        back.addActionListener(this);
        back.setBounds(320,500,120,30);
        add(back);

        submit = new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
//        submit.addActionListener(this);
        submit.setBounds(110,500,120,30);
        add(submit);

        setBounds(300,200,1050,600);
        setVisible(true);
     }
     public void addNextButtonListener(ActionListener listener) {
            back.addActionListener(listener);
            submit.addActionListener(listener);
        }
        
        public void showText() {
            image.setVisible(true);
        }
        
        public void hideText() {
            image.setVisible(false);
        }
        
        public void close() {
            setVisible(false);
            dispose();
        }
     }
     
      private class SearchRoomController implements ActionListener {
        private SearchRoomModel model;
        private SearchRoomView view;
        
        SearchRoomController(SearchRoomModel model, SearchRoomView view) {
            this.model = model;
            this.view = view;
            view.addNextButtonListener(this);
        }
        
        public void actionPerformed(ActionEvent ae) {
             if(ae.getSource()==view.submit){
                 model.connect(view,hidi);
        }
        else{
                 view.close();
            
        }

        }
    }
    
     public SearchRoom(String hidi) {
        SearchRoomModel model = new SearchRoomModel();
        SearchRoomView view = new SearchRoomView(hidi);
        SearchRoomController controller = new SearchRoomController(model, view);
    }
    
    public static void main(String[] args) {
        new SearchRoom(hidi);
    }
}