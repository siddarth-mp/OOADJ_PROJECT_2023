//package hotel.management.system;
//
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
//public class Department extends JFrame implements ActionListener{
//    public static String hidi;
//    JTable table;
//    JButton back;
//    Department(String hid){
//        hidi = hid;
//
//
//        getContentPane().setBackground(Color.WHITE);
//        setLayout(null);
//
//        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/dept1.jpg"));
//        Image i2 = i1.getImage().getScaledInstance(400,500,Image.SCALE_DEFAULT);
//        ImageIcon i3 = new ImageIcon(i2);
//        JLabel image = new JLabel(i3);
//        image.setBounds(400,20,250,350);
//        add(image);
//
//        //for putting col names on top of table in GUI
//        JLabel l1 = new JLabel("Department");
//        l1.setBounds(10,10,100,20);
//        add(l1);
//
//        JLabel l2 = new JLabel("Budget");
//        l2.setBounds(140,10,100,20);
//        add(l2);
//
//        JLabel l3 = new JLabel("Staff size");
//        l3.setBounds(270,10,100,20);
//        add(l3);
//
//
//
//        table = new JTable();//1st arg: data to put in , 2nd param: headers
//        table.setBounds(10,50,370,100);
//        add(table);
//
//        try{
//            Conn c = new Conn();
//            String query = "select dname,budget,staff from department where hotel_id = '"+hidi+"' ";
//            ResultSet rs = c.s.executeQuery(query);
//
//            table.setModel(DbUtils.resultSetToTableModel(rs));//object of Dbutils;which has method of converting resultset to table
//            //need to load this dt from rs to above table
//            // can use 2 for loops and do manually or use rs2xml.jva pkg (imported)
//        }catch(Exception e){e.printStackTrace();}
//        back = new JButton("Back");
//        back.setBackground(Color.WHITE);
//        back.addActionListener(this);
//        back.setBounds(100,280,120,30);
//        add(back);
//
//
//        setBounds(400,400,700,420);
//        setVisible(true);
//    }
//
//    public void actionPerformed(ActionEvent ae){
//        setVisible(false);
//        new Reception1(hidi);
//    }
//    public static void main(String[] args){
//        new Department(hidi);
//}
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

public class Department extends JFrame {
    public static String hidi;
    private class DepartmentModel {
         
     }
    
     private class DepartmentView extends JFrame {
         JLabel image;
         JTable table;
    JButton back;
    DepartmentView(String hid){
        hidi = hid;


        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/dept1.jpg"));
        Image i2 = i1.getImage().getScaledInstance(400,500,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        image = new JLabel(i3);
        image.setBounds(400,20,250,350);
        add(image);

        //for putting col names on top of table in GUI
        JLabel l1 = new JLabel("Department");
        l1.setBounds(10,10,100,20);
        add(l1);

        JLabel l2 = new JLabel("Budget");
        l2.setBounds(140,10,100,20);
        add(l2);

        JLabel l3 = new JLabel("Staff size");
        l3.setBounds(270,10,100,20);
        add(l3);



        table = new JTable();//1st arg: data to put in , 2nd param: headers
        table.setBounds(10,50,370,100);
        add(table);

        try{
            Conn c = new Conn();
            String query = "select dname,budget,staff from department where hotel_id = '"+hidi+"' ";
            ResultSet rs = c.s.executeQuery(query);

            table.setModel(DbUtils.resultSetToTableModel(rs));//object of Dbutils;which has method of converting resultset to table
            //need to load this dt from rs to above table
            // can use 2 for loops and do manually or use rs2xml.jva pkg (imported)
        }catch(Exception e){e.printStackTrace();}
        back = new JButton("Back");
        back.setBackground(Color.WHITE);
//        back.addActionListener(this);
        back.setBounds(100,280,120,30);
        add(back);


        setBounds(400,400,700,420);
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
    private class DepartmentController implements ActionListener {
        private DepartmentModel model;
        private DepartmentView view;
        
        DepartmentController(DepartmentModel model, DepartmentView view) {
            this.model = model;
            this.view = view;
            view.addNextButtonListener(this);
        }
        
        public void actionPerformed(ActionEvent ae) {
            view.close();
        }
    }
    
     public Department(String hidi) {
        DepartmentModel model = new DepartmentModel();
        DepartmentView view = new DepartmentView(hidi);
        DepartmentController controller = new DepartmentController(model, view);
    }
    
    public static void main(String[] args) {
        new Department(hidi);
    }
}