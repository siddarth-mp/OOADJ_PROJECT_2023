///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package hotel.management.system;
//import java.awt.*;
//
//import javax.swing.JFrame;
//
//import java.sql.*; //for ResultSet
//import javax.swing.*;
//import java.awt.event.ActionListener;
//import java.awt.event.ActionEvent;
///**
// *
// * @author Umesh
// */
//public class UpdateRoom extends JFrame implements ActionListener{
//     public static String hidi;
//    Choice ccustomer;
//    JButton check,back,update;
//    JTextField tfpaid,tfpending,tfstatus,tfavailable,tfroom;
//    UpdateRoom(String hid){
//        hidi = hid;
//
//        getContentPane().setBackground(Color.WHITE);
//        setLayout(null);
//
//        JLabel text = new JLabel("Update Room Status");
//        text.setFont(new Font("Tahoma",Font.BOLD,25));
//        text.setBounds(50,20,320,30);
//        text.setForeground(Color.BLUE);
//        add(text);
//
//
//        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/seventh.jpg"));
//        Image i2 = i1.getImage().getScaledInstance(500,300,Image.SCALE_DEFAULT);
//        ImageIcon i3 = new ImageIcon(i2);
//        JLabel image = new JLabel(i3);
//        image.setBounds(400,50,500,300);
//        add(image);
//
//        JLabel lblid = new JLabel("Customer Id");
//        //lblid.setFont(new Font("Tahoma",Font.BOLD,20));
//        lblid.setBounds(30,80,100,20);
//        //text.setForeground(Color.BLUE);
//        add(lblid);
//
//        ccustomer = new Choice();
//        ccustomer.setBounds(200,80,150,25);
//        add(ccustomer);
//
//        try{
//            Conn c = new Conn();
//            String query = "select * from customer where hotel_id = '"+hidi+"'";
//            ResultSet rs = c.s.executeQuery(query);
//
//            while (rs.next()) {
//                //select which cust id to update
//                ccustomer.add(rs.getString("number"));
//            }
//        }catch(Exception e){e.printStackTrace();}
//
//        JLabel lblroom = new JLabel("Room number");
//        lblroom.setBounds(30,130,100,20);
//        add(lblroom);
//
//        tfroom = new JTextField();
//        tfroom.setBounds(200,130,150,25);
//        add(tfroom);
//
//        JLabel lblname = new JLabel("Availability");
//        lblname.setBounds(30,180,100,20);
//        add(lblname);
//
//        tfavailable = new JTextField();
//        tfavailable.setBounds(200,180,150,25);
//        add(tfavailable);
//
//        JLabel lblcheckin = new JLabel("Cleaning Status");
//        lblcheckin.setBounds(30,230,100,20);
//        add(lblcheckin);
//
//        tfstatus = new JTextField();
//        tfstatus.setBounds(200,230,150,25);
//        add(tfstatus);
//
//        check = new JButton("Check");
//        check.setBackground(Color.BLACK);
//        check.setForeground(Color.WHITE);
//        check.setBounds(30,300,100,30);
//        check.addActionListener(this);
//        add(check);
//
//
//        update = new JButton("Update");
//        update.setBackground(Color.BLACK);
//        update.setForeground(Color.WHITE);
//        update.setBounds(150,300,100,30);
//        update.addActionListener(this);
//        add(update);
//
//        back = new JButton("Back");
//        back.setBackground(Color.BLACK);
//        back.setForeground(Color.WHITE);
//        back.setBounds(270,300,100,30);
//        back.addActionListener(this);
//        add(back);
//
//
//
//        setBounds(300,200,980,500);
//        setVisible(true);
//    }
//
//    public void actionPerformed(ActionEvent ae){
//        if(ae.getSource()==check){
//            String id = ccustomer.getSelectedItem();
//            String query = "select * from customer where (number = '"+id+"' and hotel_id = '"+hidi+"') ";
//            try{
//                Conn c = new Conn();
//                ResultSet rs = c.s.executeQuery(query);
//                //now these data stored in rs needs to be loaded into tfroom field
//                while(rs.next()){
//                    tfroom.setText(rs.getString("room"));
//              }
//                //now we need to access availaability,cleaning status of this number '102' no based on uid
//                ResultSet rs2 = c.s.executeQuery("select * from room where (roomnumber = '"+tfroom.getText()+"' and hotel_id = '"+hidi+"') ");
//                while(rs2.next()){
//                    tfavailable.setText(rs2.getString("availability"));
//                    tfstatus.setText(rs2.getString("cleaning_status"));
//                }
//
//            }catch(Exception e){e.printStackTrace();}
//        }
//        else if(ae.getSource()==update){
//            if(tfroom.equals("") || tfavailable.equals("") || tfstatus.equals(""))
//            {
//                JOptionPane.showMessageDialog(null,"please enter all fields or click on : Check' ");
//            }
//            else {
//                String number = ccustomer.getSelectedItem();
//                String room = tfroom.getText();
//                String available = tfavailable.getText();
//                String status = tfstatus.getText();
//
//                try{
//                    Conn c = new Conn();
//                    c.s.executeUpdate("update room set availability = '"+available+"' , cleaning_status = '"+status+"' where (roomnumber = '"+room+"' and hotel_id = '"+hidi+"') ");
//
//                    JOptionPane.showMessageDialog(null,"Data updated Successfully");
//                    new Reception(hidi);
//                    setVisible(true);
//                    setVisible(false);
//
//
//                }catch(Exception e){
//                    e.printStackTrace();
//                }
//            }
//
//        }
//        else{
//            setVisible(false);
//           
//        }
//    }
//    public static void main(String[] args){
//        new UpdateRoom(hidi);
//    }
//}



package hotel.management.system;
import java.awt.*;

import javax.swing.JFrame;

import java.sql.*; //for ResultSet
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class UpdateRoom extends JFrame{
     public static String hidi;
     private class UpdateRoomModel {
         public void connect1(String query,UpdateRoomView view)
         {
             try{
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                //now these data stored in rs needs to be loaded into tfroom field
                while(rs.next()){
                    view.tfroom.setText(rs.getString("room"));
              }
                //now we need to access availaability,cleaning status of this number '102' no based on uid
                ResultSet rs2 = c.s.executeQuery("select * from room where (roomnumber = '"+view.tfroom.getText()+"' and hotel_id = '"+hidi+"') ");
                while(rs2.next()){
                    view.tfavailable.setText(rs2.getString("availability"));
                    view.tfstatus.setText(rs2.getString("cleaning_status"));
                }

            }catch(Exception e){e.printStackTrace();}
         }
         
         public void connect2(String hidi,String room,String available,String status){
           try{
                    Conn c = new Conn();
                    c.s.executeUpdate("update room set availability = '"+available+"' , cleaning_status = '"+status+"' where (roomnumber = '"+room+"' and hotel_id = '"+hidi+"') ");

                    JOptionPane.showMessageDialog(null,"Data updated Successfully");
                    new Reception(hidi);


                }catch(Exception e){
                    e.printStackTrace();
                }
     }
     }
     
     private class UpdateRoomView extends JFrame {
          Choice ccustomer;
          JLabel image;
    JButton check,back,update;
    JTextField tfpaid,tfpending,tfstatus,tfavailable,tfroom;
    UpdateRoomView(String hid){
        hidi = hid;

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel text = new JLabel("Update Room Status");
        text.setFont(new Font("Tahoma",Font.BOLD,25));
        text.setBounds(50,20,320,30);
        text.setForeground(Color.BLUE);
        add(text);


        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/seventh.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500,300,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        image = new JLabel(i3);
        image.setBounds(400,50,500,300);
        add(image);

        JLabel lblid = new JLabel("Customer Id");
        //lblid.setFont(new Font("Tahoma",Font.BOLD,20));
        lblid.setBounds(30,80,100,20);
        //text.setForeground(Color.BLUE);
        add(lblid);

        ccustomer = new Choice();
        ccustomer.setBounds(200,80,150,25);
        add(ccustomer);

        try{
            Conn c = new Conn();
            String query = "select * from customer where hotel_id = '"+hidi+"'";
            ResultSet rs = c.s.executeQuery(query);

            while (rs.next()) {
                //select which cust id to update
                ccustomer.add(rs.getString("number"));
            }
        }catch(Exception e){e.printStackTrace();}

        JLabel lblroom = new JLabel("Room number");
        lblroom.setBounds(30,130,100,20);
        add(lblroom);

        tfroom = new JTextField();
        tfroom.setBounds(200,130,150,25);
        add(tfroom);

        JLabel lblname = new JLabel("Availability");
        lblname.setBounds(30,180,100,20);
        add(lblname);

        tfavailable = new JTextField();
        tfavailable.setBounds(200,180,150,25);
        add(tfavailable);

        JLabel lblcheckin = new JLabel("Cleaning Status");
        lblcheckin.setBounds(30,230,100,20);
        add(lblcheckin);

        tfstatus = new JTextField();
        tfstatus.setBounds(200,230,150,25);
        add(tfstatus);

        check = new JButton("Check");
        check.setBackground(Color.BLACK);
        check.setForeground(Color.WHITE);
        check.setBounds(30,300,100,30);
//        check.addActionListener(this);
        add(check);


        update = new JButton("Update");
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.setBounds(150,300,100,30);
//        update.addActionListener(this);
        add(update);

        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(270,300,100,30);
//        back.addActionListener(this);
        add(back);



        setBounds(300,200,980,500);
        setVisible(true);
    }
    public void addNextButtonListener(ActionListener listener) {
            check.addActionListener(listener);
            update.addActionListener(listener);
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
    private class UpdateRoomController implements ActionListener {
        private UpdateRoomModel model;
        private UpdateRoomView view;
        
        UpdateRoomController(UpdateRoomModel model, UpdateRoomView view) {
            this.model = model;
            this.view = view;
            view.addNextButtonListener(this);
        }
        
        public void actionPerformed(ActionEvent ae) {
          if(ae.getSource()==view.check){
            String id = view.ccustomer.getSelectedItem();
            String query = "select * from customer where (number = '"+id+"' and hotel_id = '"+hidi+"') ";
            model.connect1(query,view);
     
        }
        else if(ae.getSource()==view.update){
            view.close();
            if(view.tfroom.equals("") || view.tfavailable.equals("") || view.tfstatus.equals(""))
            {
                JOptionPane.showMessageDialog(null,"please enter all fields or click on : Check' ");
            }
            else {
                String number = view.ccustomer.getSelectedItem();
                String room = view.tfroom.getText();
                String available = view.tfavailable.getText();
                String status = view.tfstatus.getText();
                model.connect2(hidi,room,available,status);
                
            }

        }
        else{
            setVisible(false);
            view.close();
           
        }
          
    }
    }
     public UpdateRoom(String hidi) {
        UpdateRoomModel model = new UpdateRoomModel();
        UpdateRoomView view = new UpdateRoomView(hidi);
        UpdateRoomController controller = new UpdateRoomController(model, view);
    }
    
    public static void main(String[] args) {
        new UpdateRoom(hidi);
    }
}