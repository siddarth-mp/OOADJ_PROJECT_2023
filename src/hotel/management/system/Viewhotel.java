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
//import javax.swing.text.View;
//import java.awt.event.ActionListener;
//import java.awt.event.ActionEvent;
//public class Viewhotel extends JFrame implements ActionListener{
//    public static String hidi;
//    Choice croom;
//    JTable table;
//    JButton back,submit;
//    JComboBox bedType;
//    JCheckBox available;
//    Viewhotel(String hid){
//        hidi = hid;
//
//        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/" + hidi + ".jpg"));
//        Image i2 = i1.getImage().getScaledInstance(600,600,Image.SCALE_DEFAULT);
//        ImageIcon i3 = new ImageIcon(i2);
//        JLabel image = new JLabel(i3);
//        image.setBounds(610,20,370,500);
//        add(image);
//
//        getContentPane().setBackground(Color.WHITE);
//        setLayout(null);
//
//        JLabel text = new JLabel("View Hotels");
//        text.setFont(new Font("Tahoma",Font.BOLD,20));
//        text.setBounds(200,30,200,30);
//        add(text);
//
//        JLabel lblbed = new JLabel("Select Hotel Id");
//        lblbed.setBounds(120,100,100,20);
//        add(lblbed);
//
//        croom = new Choice();
//
//        try{
//            Conn conn = new Conn();
//            //Hit MySQL:
//            String query = "select * from hotels";
//            ResultSet rs = conn.s.executeQuery(query);// this has entire table
//            while(rs.next()){
//                //i need to add col name of result set to croom:
//                croom.add(rs.getString("hotel_id"));
//            }
//        }catch(Exception e){e.printStackTrace();}
//        croom .setBounds(280,100,90,25);
//        add(croom);
//
//
//        //for putting col names on top of table in GUI
//        JLabel l1 = new JLabel("Hotel Id");
//        l1.setBounds(20,160,100,20);
//        add(l1);
//
//        JLabel l2 = new JLabel("Hotel Name");
//        l2.setBounds(110,160,100,20);
//        add(l2);
//
//        JLabel l3 = new JLabel("Pincode");
//        l3.setBounds(220,160,100,20);// col name shuld appear in same line but move towards left side
//        add(l3);
//
//        JLabel l4 = new JLabel("Type");
//        l4.setBounds(310,160,100,20);// col name shuld appear in same line but move towards left side
//        add(l4);
//
//        table = new JTable();//1st arg: data to put in , 2nd param: headers
//        table.setBounds(0,200,400,300);
//        add(table);
//
//        try{
//            Conn c = new Conn();
//            String query = "select * from hotels where hotel_id = '"+hidi+"' ";
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
//        back.setBounds(250,500,120,30);
//        add(back);
//
//        submit = new JButton("Submit");
//        submit.setBackground(Color.BLACK);
//        submit.setForeground(Color.WHITE);
//        submit.addActionListener(this);
//        submit.setBounds(60,500,120,30);
//        add(submit);
//
//        setBounds(200,200,1050,600);
//        setVisible(true);
//    }
//
//    public void actionPerformed(ActionEvent ae){
//        if(ae.getSource()==submit){
//            try{
//                Conn conn = new Conn();
//                ResultSet rs;
//                String hidi = croom.getSelectedItem();
//                String query1 = "select * from hotels where (hotel_id = '"+hidi+"') ";
//                rs = conn.s.executeQuery(query1);
//                table.setModel(DbUtils.resultSetToTableModel(rs));
//                new Viewhotel(hidi);
//                setVisible(false);
//                
//
//            }catch(Exception e){e.printStackTrace();}
//        }
//        else{
//            setVisible(false);
//            new Start();
//        }
//
//    }
//    public static void main(String[] args){
//        new Viewhotel(hidi);
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
import javax.swing.text.View;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Viewhotel extends JFrame{
    public static String hidi;
    private class ViewhotelModel {
        public void connect1(ViewhotelView view)
        {
            try{
                Conn conn = new Conn();
                ResultSet rs;
                String hidi = view.croom.getSelectedItem();
                String query1 = "select * from hotels where (hotel_id = '"+hidi+"') ";
                rs = conn.s.executeQuery(query1);
                view.table.setModel(DbUtils.resultSetToTableModel(rs));
                new Viewhotel(hidi);
                setVisible(false);
                

            }catch(Exception e){e.printStackTrace();}
        
        }
    }
    
    private class ViewhotelView extends JFrame {
     
    Choice croom;
    JTable table;
    JButton back,submit;
    JComboBox bedType;
    JCheckBox available;
    JLabel image;
    ViewhotelView(String hid){
        hidi = hid;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/" + hidi + ".jpg"));
        Image i2 = i1.getImage().getScaledInstance(600,600,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        image = new JLabel(i3);
        image.setBounds(610,20,370,500);
        add(image);

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel text = new JLabel("View Hotels");
        text.setFont(new Font("Tahoma",Font.BOLD,20));
        text.setBounds(200,30,200,30);
        add(text);

        JLabel lblbed = new JLabel("Select Hotel Id");
        lblbed.setBounds(120,100,100,20);
        add(lblbed);

        croom = new Choice();

        try{
            Conn conn = new Conn();
            //Hit MySQL:
            String query = "select * from hotels";
            ResultSet rs = conn.s.executeQuery(query);// this has entire table
            while(rs.next()){
                //i need to add col name of result set to croom:
                croom.add(rs.getString("hotel_id"));
            }
        }catch(Exception e){e.printStackTrace();}
        croom .setBounds(280,100,90,25);
        add(croom);


        //for putting col names on top of table in GUI
        JLabel l1 = new JLabel("Hotel Id");
        l1.setBounds(20,160,100,20);
        add(l1);

        JLabel l2 = new JLabel("Hotel Name");
        l2.setBounds(110,160,100,20);
        add(l2);

        JLabel l3 = new JLabel("Pincode");
        l3.setBounds(220,160,100,20);// col name shuld appear in same line but move towards left side
        add(l3);

        JLabel l4 = new JLabel("Type");
        l4.setBounds(310,160,100,20);// col name shuld appear in same line but move towards left side
        add(l4);

        table = new JTable();//1st arg: data to put in , 2nd param: headers
        table.setBounds(0,200,400,300);
        add(table);

        try{
            Conn c = new Conn();
            String query = "select * from hotels where hotel_id = '"+hidi+"' ";
            ResultSet rs = c.s.executeQuery(query);

            table.setModel(DbUtils.resultSetToTableModel(rs));//object of Dbutils;which has method of converting resultset to table
            //need to load this dt from rs to above table
            // can use 2 for loops and do manually or use rs2xml.jva pkg (imported)
        }catch(Exception e){e.printStackTrace();}
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
//        back.addActionListener(this);
        back.setBounds(250,500,120,30);
        add(back);

        submit = new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
//        submit.addActionListener(this);
        submit.setBounds(60,500,120,30);
        add(submit);

        setBounds(200,200,1050,600);
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
    private class ViewhotelController implements ActionListener {
        private ViewhotelModel model;
        private ViewhotelView view;
        
        ViewhotelController(ViewhotelModel model, ViewhotelView view) {
            this.model = model;
            this.view = view;
            view.addNextButtonListener(this);
        }
        
        public void actionPerformed(ActionEvent ae) {
            view.close();
        if(ae.getSource()==view.submit){
            model.connect1(view);
            }
        else{
            setVisible(false);
            new Start();
        }
        }
    }
    
    public Viewhotel(String hidi) {
        ViewhotelModel model = new ViewhotelModel();
        ViewhotelView view = new ViewhotelView(hidi);
        ViewhotelController controller = new ViewhotelController(model, view);
    }
    
    public static void main(String[] args) {
        new Viewhotel(hidi);
    }
}