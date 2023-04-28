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
//public class Pickup extends JFrame implements ActionListener{
//    public static String hidi;
//    JTable table;
//    JButton back,submit;
//    Choice typeofcar;
//    JCheckBox available;
//    Pickup(String hid){
//        hidi = hid;
//
//
//        getContentPane().setBackground(Color.WHITE);
//        setLayout(null);
//
//        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/tx.jpg"));
//        Image i2 = i1.getImage().getScaledInstance(520,480,Image.SCALE_DEFAULT);
//        ImageIcon i3 = new ImageIcon(i2);
//        JLabel image = new JLabel(i3);
//        image.setBounds(610,30,520,480);
//        add(image);
//
//        JLabel text = new JLabel("Pickup Service");
//        text.setFont(new Font("Tahoma",Font.BOLD,20));
//        text.setBounds(200,30,200,30);
//        add(text);
//
//        JLabel lblbed = new JLabel("Type of Car");
//        lblbed.setBounds(50,100,100,20);
//        add(lblbed);
//
//        //here car models need to come dynamically from DB not hard coded
//        typeofcar = new Choice();
//        typeofcar.setBounds(150,100,200,25);
//        add(typeofcar);
//        //coming from DB => use try-catch
//        try{
//            Conn c = new Conn();
//            ResultSet rs = c.s.executeQuery("select * from driver where hotel_id = '"+hidi+"'");
//            while(rs.next()){
//                typeofcar.add(rs.getString("brand"));
//            }
//        }catch(Exception e){e.printStackTrace();}
//
//        //for putting col names on top of table in GUI
//        JLabel l1 = new JLabel("Name");
//        l1.setBounds(20,160,100,20);
//        add(l1);
//
//        JLabel l2 = new JLabel("Age");
//        l2.setBounds(120,160,100,20);
//        add(l2);
//
//        JLabel l3 = new JLabel("Gender");
//        l3.setBounds(180,160,100,20);// col name shuld appear in same line but move towards left side
//        add(l3);
//
//        JLabel l4 = new JLabel("Company");
//        l4.setBounds(270,160,100,20);// col name shuld appear in same line but move towards left side
//        add(l4);
//
//        JLabel l5 = new JLabel("Brand");
//        l5.setBounds(360,160,100,20);// col name shuld appear in same line but move towards left side
//        add(l5);
//
//        JLabel l6 = new JLabel("Availablity");
//        l6.setBounds(440,160,100,20);// col name shuld appear in same line but move towards left side
//        add(l6);
//
//        JLabel l7 = new JLabel("Location");
//        l7.setBounds(530,160,100,20);// col name shuld appear in same line but move towards left side
//        add(l7);
//
//        table = new JTable();//1st arg: data to put in , 2nd param: headers
//        table.setBounds(0,200,600,300);
//        add(table);
//
//        try{
//            Conn c = new Conn();
//            String query = "select * from driver where hotel_id = '"+hidi+"'";
//            ResultSet rs = c.s.executeQuery(query);
//            table.setModel(DbUtils.resultSetToTableModel(rs));
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
//        setBounds(300,200,1200,600);
//        setVisible(true);
//    }
//
//    public void actionPerformed(ActionEvent ae){
//        if(ae.getSource()==submit){
//            try{
//                //1st type of query is when single or double bed is selected and "display available" checkbox is unselected, 2nd condition is when this checkbox is selected
//                String query1 = "select * from driver where (brand = '"+typeofcar.getSelectedItem()+"' and hotel_id = '"+hidi+"') ";
//                Conn conn = new Conn();
//                ResultSet rs;
//                rs = conn.s.executeQuery(query1);
//                table.setModel(DbUtils.resultSetToTableModel(rs));
//            }catch(Exception e){e.printStackTrace();}
//        }
//        else{
//            setVisible(false);
//            new Reception(hidi);
//        }
//
//    }
//    public static void main(String[] args){
//        new Pickup(hidi);
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
public class Pickup extends JFrame {
    public static String hidi;
     private class PickupModel {
         public void connect(PickupView view){
             try{
                //1st type of query is when single or double bed is selected and "display available" checkbox is unselected, 2nd condition is when this checkbox is selected
                String query1 = "select * from driver where (brand = '"+view.typeofcar.getSelectedItem()+"' and hotel_id = '"+hidi+"') ";
                Conn conn = new Conn();
                ResultSet rs;
                rs = conn.s.executeQuery(query1);
                view.table.setModel(DbUtils.resultSetToTableModel(rs));
            }catch(Exception e){e.printStackTrace();}
         }
     }
     
     private class PickupView extends JFrame {
         JTable table;
    JButton back,submit;
    Choice typeofcar;
    JCheckBox available;
    JLabel image;
    PickupView(String hid){
        hidi = hid;


        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/tx.jpg"));
        Image i2 = i1.getImage().getScaledInstance(520,480,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        image = new JLabel(i3);
        image.setBounds(610,30,520,480);
        add(image);

        JLabel text = new JLabel("Pickup Service");
        text.setFont(new Font("Tahoma",Font.BOLD,20));
        text.setBounds(200,30,200,30);
        add(text);

        JLabel lblbed = new JLabel("Type of Car");
        lblbed.setBounds(50,100,100,20);
        add(lblbed);

        //here car models need to come dynamically from DB not hard coded
        typeofcar = new Choice();
        typeofcar.setBounds(150,100,200,25);
        add(typeofcar);
        //coming from DB => use try-catch
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from driver where hotel_id = '"+hidi+"'");
            while(rs.next()){
                typeofcar.add(rs.getString("brand"));
            }
        }catch(Exception e){e.printStackTrace();}

        //for putting col names on top of table in GUI
        JLabel l1 = new JLabel("Name");
        l1.setBounds(20,160,100,20);
        add(l1);

        JLabel l2 = new JLabel("Age");
        l2.setBounds(120,160,100,20);
        add(l2);

        JLabel l3 = new JLabel("Gender");
        l3.setBounds(180,160,100,20);// col name shuld appear in same line but move towards left side
        add(l3);

        JLabel l4 = new JLabel("Company");
        l4.setBounds(270,160,100,20);// col name shuld appear in same line but move towards left side
        add(l4);

        JLabel l5 = new JLabel("Brand");
        l5.setBounds(360,160,100,20);// col name shuld appear in same line but move towards left side
        add(l5);

        JLabel l6 = new JLabel("Availablity");
        l6.setBounds(440,160,100,20);// col name shuld appear in same line but move towards left side
        add(l6);

        JLabel l7 = new JLabel("Location");
        l7.setBounds(530,160,100,20);// col name shuld appear in same line but move towards left side
        add(l7);

        table = new JTable();//1st arg: data to put in , 2nd param: headers
        table.setBounds(0,200,600,300);
        add(table);

        try{
            Conn c = new Conn();
            String query = "select * from driver where hotel_id = '"+hidi+"'";
            ResultSet rs = c.s.executeQuery(query);
            table.setModel(DbUtils.resultSetToTableModel(rs));
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

        setBounds(300,200,1200,600);
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
     
      // Controller
    private class PickupController implements ActionListener {
        private PickupModel model;
        private PickupView view;
        
        PickupController(PickupModel model, PickupView view) {
            this.model = model;
            this.view = view;
            view.addNextButtonListener(this);
        }
        
        public void actionPerformed(ActionEvent ae) {
          
            if(ae.getSource()==view.submit){
                model.connect(view);
            
        }
        else{
                view.close();
            setVisible(false);
            new Reception(hidi);
        }
}
    }
    
     public Pickup(String hidi) {
        PickupModel model = new PickupModel();
        PickupView view = new PickupView(hidi);
        PickupController controller = new PickupController(model, view);
    }
    
    public static void main(String[] args) {
        new Pickup(hidi);
    }
}