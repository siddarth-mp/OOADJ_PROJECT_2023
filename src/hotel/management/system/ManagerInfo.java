//package hotel.management.system;
////Manager is one among employees, so when u register a employee with job = manager , he comes here
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
//public class ManagerInfo extends JFrame implements ActionListener{
//    public static String hidi;
//    JTable table;
//    JButton back;
//    ManagerInfo(String hid){
//        hidi = hid;
//
//        getContentPane().setBackground(Color.WHITE);
//        setLayout(null);
//
//        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/hm.png"));
//        Image i2 = i1.getImage().getScaledInstance(400,500,Image.SCALE_DEFAULT);
//        ImageIcon i3 = new ImageIcon(i2);
//        JLabel image = new JLabel(i3);
//        image.setBounds(390,0,250,600);
//        add(image);
//
//        JLabel l = new JLabel("Contact your  Manager");
//        l.setForeground(Color.BLUE);
//        l.setBounds(130,10,150,20);
//        add(l);
//        //for putting col names on top of table in GUI
//        JLabel l1 = new JLabel("Name");
//        l1.setBounds(40,40,100,20);
//        add(l1);
//
//        JLabel l2 = new JLabel("Email-id");
//        l2.setBounds(150,40,100,20);
//        add(l2);
//
//        JLabel l3 = new JLabel("Hotel id");
//        l3.setBounds(260,40,100,20);
//        add(l3);
//
//
//        table = new JTable();//1st arg: data to put in , 2nd param: headers
//        table.setBounds(10,70,360,100);
//        add(table);
//
//        try{
//            Conn c = new Conn();
//            String query = "select mname,mail,hotel_id from manager where (hotel_id='"+hidi+"') ";
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
//        back.setBounds(100,330,120,30);
//        add(back);
//
//        setBounds(400,400,760,590);
//        setVisible(true);
//    }
//
//    public void actionPerformed(ActionEvent ae){
//        setVisible(false);
//        new Reception1(hidi);
//    }
//    public static void main(String[] args){
//        new ManagerInfo(hidi);
//}
//
//}

package hotel.management.system;
//Manager is one among employees, so when u register a employee with job = manager , he comes here
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

public class ManagerInfo extends JFrame{
    public static String hidi;
     
     private class ManagerInfoModel {
         
     }
     
     private class ManagerInfoView extends JFrame {
         JTable table;
         JLabel  image;
    JButton back;
    ManagerInfoView(String hid){
        hidi = hid;

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/hm.png"));
        Image i2 = i1.getImage().getScaledInstance(400,500,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        image = new JLabel(i3);
        image.setBounds(390,0,250,600);
        add(image);

        JLabel l = new JLabel("Contact your  Manager");
        l.setForeground(Color.BLUE);
        l.setBounds(130,10,150,20);
        add(l);
        //for putting col names on top of table in GUI
        JLabel l1 = new JLabel("Name");
        l1.setBounds(40,40,100,20);
        add(l1);

        JLabel l2 = new JLabel("Email-id");
        l2.setBounds(150,40,100,20);
        add(l2);

        JLabel l3 = new JLabel("Hotel id");
        l3.setBounds(260,40,100,20);
        add(l3);


        table = new JTable();//1st arg: data to put in , 2nd param: headers
        table.setBounds(10,70,360,100);
        add(table);

        try{
            Conn c = new Conn();
            String query = "select mname,mail,hotel_id from manager where (hotel_id='"+hidi+"') ";
            ResultSet rs = c.s.executeQuery(query);

            table.setModel(DbUtils.resultSetToTableModel(rs));//object of Dbutils;which has method of converting resultset to table
            //need to load this dt from rs to above table
            // can use 2 for loops and do manually or use rs2xml.jva pkg (imported)
        }catch(Exception e){e.printStackTrace();}
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
//        back.addActionListener(this);
        back.setForeground(Color.WHITE);
        back.setBounds(100,330,120,30);
        add(back);

        setBounds(400,400,760,590);
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
     private class ManagerInfoController implements ActionListener {
        private ManagerInfoModel model;
        private ManagerInfoView view;
        
        ManagerInfoController(ManagerInfoModel model, ManagerInfoView view) {
            this.model = model;
            this.view = view;
            view.addNextButtonListener(this);
        }
        
        public void actionPerformed(ActionEvent ae) {
                view.close();

        }
    }
    
     public ManagerInfo(String hidi) {
        ManagerInfoModel model = new ManagerInfoModel();
        ManagerInfoView view = new ManagerInfoView(hidi);
        ManagerInfoController controller = new ManagerInfoController(model, view);
    }
    
    public static void main(String[] args) {
        new ManagerInfo(hidi);
    }
}