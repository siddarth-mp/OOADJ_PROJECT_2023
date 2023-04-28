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
///**
// *
// * @author Umesh
// */
//public class Room extends JFrame implements ActionListener{
//    public static String hidi;
//    JTable table;
//    JButton back;
//    Room(String hid){
//        hidi = hid;
//
//
//        getContentPane().setBackground(Color.WHITE);
//        setLayout(null);
//
//        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/eight.jpg"));
//        Image i2 = i1.getImage().getScaledInstance(600,600,Image.SCALE_DEFAULT);
//        ImageIcon i3 = new ImageIcon(i2);
//        JLabel image = new JLabel(i3);
//        image.setBounds(500,0,600,600);
//        add(image);
//
//        //for putting col names on top of table in GUI
//        JLabel l1 = new JLabel("Room number");
//        l1.setBounds(10,10,100,20);
//        add(l1);
//
//        JLabel l2 = new JLabel("Availability");
//        l2.setBounds(120,10,100,20);
//        add(l2);
//
//        JLabel l3 = new JLabel("Status");
//        l3.setBounds(230,10,100,20);// col name shuld appear in same line but move towards left side
//        add(l3);
//
//        JLabel l4 = new JLabel("Price");
//        l4.setBounds(330,10,100,20);// col name shuld appear in same line but move towards left side
//        add(l4);
//
//        JLabel l5 = new JLabel("Bed type");
//        l5.setBounds(410,10,100,20);// col name shuld appear in same line but move towards left side
//        add(l5);
//
//        table = new JTable();//1st arg: data to put in , 2nd param: headers
//        table.setBounds(0,40,500,400);
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
//        back.setBackground(Color.WHITE);
//        back.addActionListener(this);
//        back.setBounds(200,500,120,30);
//        add(back);
//
//        setBounds(300,200,1050,600);
//        setVisible(true);
//    }
//
//    public void actionPerformed(ActionEvent ae){
//        setVisible(false);
//    }
//    public static void main(String[] args){
//        new Room(hidi);
//    }
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
public class Room extends JFrame{
    public static String hidi;
    private class RoomModel {
         
     }
    
    private class RoomView extends JFrame {
        JTable table;
    JButton back;
    JLabel image;
    RoomView(String hid){
        hidi = hid;


        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/eight.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600,600,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        image = new JLabel(i3);
        image.setBounds(500,0,600,600);
        add(image);

        //for putting col names on top of table in GUI
        JLabel l1 = new JLabel("Room number");
        l1.setBounds(10,10,100,20);
        add(l1);

        JLabel l2 = new JLabel("Availability");
        l2.setBounds(120,10,100,20);
        add(l2);

        JLabel l3 = new JLabel("Status");
        l3.setBounds(230,10,100,20);// col name shuld appear in same line but move towards left side
        add(l3);

        JLabel l4 = new JLabel("Price");
        l4.setBounds(330,10,100,20);// col name shuld appear in same line but move towards left side
        add(l4);

        JLabel l5 = new JLabel("Bed type");
        l5.setBounds(410,10,100,20);// col name shuld appear in same line but move towards left side
        add(l5);

        table = new JTable();//1st arg: data to put in , 2nd param: headers
        table.setBounds(0,40,500,400);
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
        back.setBackground(Color.WHITE);
//        back.addActionListener(this);
        back.setBounds(200,500,120,30);
        add(back);

        setBounds(300,200,1050,600);
        setVisible(true);
    }
    public void addNextButtonListener(ActionListener listener) {
            back.addActionListener(listener);
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
    
    private class RoomController implements ActionListener {
        private RoomModel model;
        private RoomView view;
        
        RoomController(RoomModel model, RoomView view) {
            this.model = model;
            this.view = view;
            view.addNextButtonListener(this);
        }
        
        public void actionPerformed(ActionEvent ae) {
            view.close();

        }
    }
    
     public Room(String hidi) {
        RoomModel model = new RoomModel();
        RoomView view = new RoomView(hidi);
        RoomController controller = new RoomController(model, view);
    }
    
    public static void main(String[] args) {
        new Room(hidi);
    }
}