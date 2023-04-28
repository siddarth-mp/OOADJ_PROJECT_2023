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
//public class EmployeeInfo extends JFrame implements ActionListener{
//    public static String hidi;
//    JTable table;
//    JButton back;
//    EmployeeInfo(String hid){
//        hidi = hid;
//
//
//        getContentPane().setBackground(Color.WHITE);
//        setLayout(null);
//
//        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/emp2.jpg"));
//        Image i2 = i1.getImage().getScaledInstance(400,500,Image.SCALE_DEFAULT);
//        ImageIcon i3 = new ImageIcon(i2);
//        JLabel image = new JLabel(i3);
//        image.setBounds(820,20,450,350);
//        add(image);
//
//        //for putting col names on top of table in GUI
//        JLabel l1 = new JLabel("Name");
//        l1.setBounds(30,10,100,20);
//        add(l1);
//
//        JLabel l2 = new JLabel("Age");
//        l2.setBounds(140,10,100,20);
//        add(l2);
//
//        JLabel l3 = new JLabel("Gender");
//        l3.setBounds(240,10,100,20);
//        add(l3);
//
//        JLabel l4 = new JLabel("Job");
//        l4.setBounds(360,10,100,20);
//        add(l4);
//
//        JLabel l5 = new JLabel("Salary");
//        l5.setBounds(460,10,100,20);
//        add(l5);
//
//        JLabel l6 = new JLabel("Phone");
//        l6.setBounds(560,10,100,20);
//        add(l6);
//
//        JLabel l7 = new JLabel("E-mail id");
//        l7.setBounds(660,10,100,20);
//        add(l7);
//
//        JLabel l8 = new JLabel("Adhaar");
//        l8.setBounds(760,10,100,20);
//        add(l8);
//
//
//
//        table = new JTable();//1st arg: data to put in , 2nd param: headers
//        table.setBounds(10,40,830,100);
//        add(table);
//
//        try{
//            Conn c = new Conn();
//            String query = "select * from employee where hotel_id = '"+hidi+"' ";
//            ResultSet rs = c.s.executeQuery(query);
//
//            table.setModel(DbUtils.resultSetToTableModel(rs));//object of Dbutils;which has method of converting resultset to table
//            //need to load this dt from rs to above table
//            // can use 2 for loops and do manually or use rs2xml.jva pkg (imported)
//        }catch(Exception e){e.printStackTrace();}
//        back = new JButton("Back");
//        back.setBackground(Color.BLACK);
//        back.addActionListener(this);
//        back.setForeground(Color.WHITE);
//        back.setBounds(350,330,120,30);
//        add(back);
//
//        setBounds(400,400,1250,500);
//        setVisible(true);
//    }
//
//    public void actionPerformed(ActionEvent ae){
//        setVisible(false);
//        new Reception(hidi);
//    }
//    public static void main(String[] args){
//        new EmployeeInfo(hidi);
//                }
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

public class EmployeeInfo extends JFrame{
    public static String hidi;
    
     private class EmployeeInfoModel {
         
     }
     
     private class EmployeeInfoView extends JFrame {
         JTable table;
    JButton back;
    JLabel image;
    EmployeeInfoView(String hid){
        hidi = hid;


        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/emp2.jpg"));
        Image i2 = i1.getImage().getScaledInstance(400,500,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(820,20,450,350);
        add(image);

        //for putting col names on top of table in GUI
        JLabel l1 = new JLabel("Name");
        l1.setBounds(30,10,100,20);
        add(l1);

        JLabel l2 = new JLabel("Age");
        l2.setBounds(140,10,100,20);
        add(l2);

        JLabel l3 = new JLabel("Gender");
        l3.setBounds(240,10,100,20);
        add(l3);

        JLabel l4 = new JLabel("Job");
        l4.setBounds(360,10,100,20);
        add(l4);

        JLabel l5 = new JLabel("Salary");
        l5.setBounds(460,10,100,20);
        add(l5);

        JLabel l6 = new JLabel("Phone");
        l6.setBounds(560,10,100,20);
        add(l6);

        JLabel l7 = new JLabel("E-mail id");
        l7.setBounds(660,10,100,20);
        add(l7);

        JLabel l8 = new JLabel("Adhaar");
        l8.setBounds(760,10,100,20);
        add(l8);



        table = new JTable();//1st arg: data to put in , 2nd param: headers
        table.setBounds(10,40,830,100);
        add(table);

        try{
            Conn c = new Conn();
            String query = "select * from employee where hotel_id = '"+hidi+"' ";
            ResultSet rs = c.s.executeQuery(query);

            table.setModel(DbUtils.resultSetToTableModel(rs));//object of Dbutils;which has method of converting resultset to table
            //need to load this dt from rs to above table
            // can use 2 for loops and do manually or use rs2xml.jva pkg (imported)
        }catch(Exception e){e.printStackTrace();}
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
//        back.addActionListener(this);
        back.setForeground(Color.WHITE);
        back.setBounds(350,330,120,30);
        add(back);

        setBounds(400,400,1250,500);
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
     
      // Controller
    private class EmployeeInfoController implements ActionListener {
        private EmployeeInfoModel model;
        private EmployeeInfoView view;
        
        EmployeeInfoController(EmployeeInfoModel model, EmployeeInfoView view) {
            this.model = model;
            this.view = view;
            view.addNextButtonListener(this);
        }
        
        public void actionPerformed(ActionEvent ae) {
          view.close();
           new Reception(hidi);

        }
    }
    
     public EmployeeInfo(String hidi) {
        EmployeeInfoModel model = new EmployeeInfoModel();
        EmployeeInfoView view = new EmployeeInfoView(hidi);
        EmployeeInfoController controller = new EmployeeInfoController(model, view);
    }
    
    public static void main(String[] args) {
        new EmployeeInfo(hidi);
    }
}