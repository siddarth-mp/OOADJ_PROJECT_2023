//
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
//
//public class UpdateCheck extends JFrame implements ActionListener {
//    public static String hidi;
//    Choice ccustomer;
//    JButton check,back,update;
//    JTextField tfpaid,tfpending,tfcheckin,tfname,tfroom;
//    UpdateCheck(String hid){
//        hidi = hid;
//
//        getContentPane().setBackground(Color.WHITE);
//        setLayout(null);
//
//        JLabel text = new JLabel("Update Status");
//        text.setFont(new Font("Tahoma",Font.BOLD,20));
//        text.setBounds(90,20,200,30);
//        text.setForeground(Color.BLUE);
//        add(text);
//
//
//        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/nine.jpg"));
//        JLabel image = new JLabel(i1);
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
//            String query = "select * from customer where hotel_id = '"+hidi+"' ";
//            ResultSet rs = c.s.executeQuery(query);
//
//            while (rs.next()) {
//                //select which cust id to update
//                 ccustomer.add(rs.getString("number"));
//            }
//        }catch(Exception e){e.printStackTrace();}
//
//        JLabel lblroom = new JLabel("Room number");
//        lblroom.setBounds(30,120,100,20);
//        add(lblroom);
//
//        tfroom = new JTextField();
//        tfroom.setBounds(200,120,150,25);
//        add(tfroom);
//
//        JLabel lblname = new JLabel("Name");
//        lblname.setBounds(30,160,100,20);
//        add(lblname);
//
//        tfname = new JTextField();
//        tfname.setBounds(200,160,150,25);
//        add(tfname);
//
//        JLabel lblcheckin = new JLabel("Checkin time");
//        lblcheckin.setBounds(30,200,100,20);
//        add(lblcheckin);
//
//        tfcheckin = new JTextField();
//        tfcheckin.setBounds(200,200,150,25);
//        add(tfcheckin);
//
//        JLabel lblpaid = new JLabel("Amount paid");
//        lblpaid.setBounds(30,240,100,20);
//        add(lblpaid);
//
//        tfpaid = new JTextField();
//        tfpaid.setBounds(200,240,150,25);
//        add(tfpaid);
//
//        JLabel lblpending = new JLabel("Pending amount");
//        lblpending.setBounds(30,280,100,20);
//        add(lblpending);
//
//        tfpending = new JTextField();
//        tfpending.setBounds(200,280,150,25);
//        add(tfpending);
//
//
//        check = new JButton("Check");
//        check.setBackground(Color.BLACK);
//        check.setForeground(Color.WHITE);
//        check.setBounds(30,340,100,30);
//        check.addActionListener(this);
//        add(check);
//
//
//        update = new JButton("Update");
//        update.setBackground(Color.BLACK);
//        update.setForeground(Color.WHITE);
//        update.setBounds(150,340,100,30);
//        update.addActionListener(this);
//        add(update);
//
//        back = new JButton("Back");
//        back.setBackground(Color.BLACK);
//        back.setForeground(Color.WHITE);
//        back.setBounds(270,340,100,30);
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
//            String query = "select * from customer where (number = '"+id+"' and hotel_id='"+hidi+"') ";
//            try{
//                Conn c = new Conn();
//                ResultSet rs = c.s.executeQuery(query);
//                //now these data stored in rs needs to be loaded into tfroom field
//                while(rs.next()){
//                    tfroom.setText(rs.getString("room"));
//                    tfname.setText(rs.getString("name"));
//                    tfcheckin.setText(rs.getString("checkintime"));
//                    //so here in room table, price is wat room's cost, so pending = deposit - actual price(defined in room table)
//                    tfpaid.setText(rs.getString("deposit"));
//                }
//                ResultSet rs2 = c.s.executeQuery("select * from room where (roomnumber = '"+tfroom.getText()+"' and hotel_id='"+hidi+"') ");
//                while(rs2.next()){
//                    String price = rs2.getString("price");
//                    //pending = price-deposit
//                    int amountPaid = (Integer.parseInt(price)) - Integer.parseInt(tfpaid.getText());
//                    tfpending.setText("" + amountPaid); //in to str by concatenation
//
//                }
//
//            }catch(Exception e){e.printStackTrace();}
//        }
//        else if(ae.getSource()==update){
//            if(tfroom.equals("") || tfname.equals("") || tfcheckin.equals("") || tfpaid.equals("") || tfpending.equals(""))
//            {
//                JOptionPane.showMessageDialog(null,"please enter all fields or click on : Check' ");
//            }
//            else {
//            String number = ccustomer.getSelectedItem();
//            String room = tfroom.getText();
//            String name = tfname.getText();
//            String checkin = tfcheckin.getText();
//            String deposit = tfpaid.getText();
//
//                try{
//                    Conn c = new Conn();
//                    c.s.executeUpdate("update customer set room = '"+room+"' , name = '"+name+"' , checkintime = '"+checkin+"' , deposit = '"+deposit+"'  where number = '"+number+"' where hotel_id = '"+hidi+"'");
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
//            new Reception(hidi);
//        }
//    }
//    public static void main(String[] args){
//       new UpdateCheck(hidi);
//}
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

public class UpdateCheck extends JFrame {
    public static String hidi;
     private class UpdateCheckModel {
         public void connect1(String query, UpdateCheckView view){
             try{
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                //now these data stored in rs needs to be loaded into tfroom field
                while(rs.next()){
                    view.tfroom.setText(rs.getString("room"));
                    view.tfname.setText(rs.getString("name"));
                    view.tfcheckin.setText(rs.getString("checkintime"));
                    //so here in room table, price is wat room's cost, so pending = deposit - actual price(defined in room table)
                    view.tfpaid.setText(rs.getString("deposit"));
                }
                ResultSet rs2 = c.s.executeQuery("select * from room where (roomnumber = '"+view.tfroom.getText()+"' and hotel_id='"+hidi+"') ");
                while(rs2.next()){
                    String price = rs2.getString("price");
                    //pending = price-deposit
                    int amountPaid = (Integer.parseInt(price)) - Integer.parseInt(view.tfpaid.getText());
                    view.tfpending.setText("" + amountPaid); //in to str by concatenation

                }

            }catch(Exception e){e.printStackTrace();}
         }
         
         public void connect2( UpdateCheckView view,String hidi){
            String number = view.ccustomer.getSelectedItem();
            String room = view.tfroom.getText();
            String name = view.tfname.getText();
            String checkin = view.tfcheckin.getText();
            String deposit = view.tfpaid.getText();
             try{
                    Conn c = new Conn();
                    c.s.executeUpdate("update customer set room = '"+room+"' , name = '"+name+"' , checkintime = '"+checkin+"' , deposit = '"+deposit+"'  where number = '"+number+"' and hotel_id = '"+hidi+"'");

                    JOptionPane.showMessageDialog(null,"Data updated Successfully");
                    new Reception(hidi);
                    setVisible(true);
                    setVisible(false);


                }catch(Exception e){
                    e.printStackTrace();
                }
         }
     }
     
     private class UpdateCheckView extends JFrame {
         Choice ccustomer;
        JButton check,back,update;
        JTextField tfpaid,tfpending,tfcheckin,tfname,tfroom;
        JLabel image;
    UpdateCheckView(String hid){
        hidi = hid;

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel text = new JLabel("Update Status");
        text.setFont(new Font("Tahoma",Font.BOLD,20));
        text.setBounds(90,20,200,30);
        text.setForeground(Color.BLUE);
        add(text);


        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/nine.jpg"));
        image = new JLabel(i1);
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
            String query = "select * from customer where hotel_id = '"+hidi+"' ";
            ResultSet rs = c.s.executeQuery(query);

            while (rs.next()) {
                //select which cust id to update
                 ccustomer.add(rs.getString("number"));
            }
        }catch(Exception e){e.printStackTrace();}

        JLabel lblroom = new JLabel("Room number");
        lblroom.setBounds(30,120,100,20);
        add(lblroom);

        tfroom = new JTextField();
        tfroom.setBounds(200,120,150,25);
        add(tfroom);

        JLabel lblname = new JLabel("Name");
        lblname.setBounds(30,160,100,20);
        add(lblname);

        tfname = new JTextField();
        tfname.setBounds(200,160,150,25);
        add(tfname);

        JLabel lblcheckin = new JLabel("Checkin time");
        lblcheckin.setBounds(30,200,100,20);
        add(lblcheckin);

        tfcheckin = new JTextField();
        tfcheckin.setBounds(200,200,150,25);
        add(tfcheckin);

        JLabel lblpaid = new JLabel("Amount paid");
        lblpaid.setBounds(30,240,100,20);
        add(lblpaid);

        tfpaid = new JTextField();
        tfpaid.setBounds(200,240,150,25);
        add(tfpaid);

        JLabel lblpending = new JLabel("Pending amount");
        lblpending.setBounds(30,280,100,20);
        add(lblpending);

        tfpending = new JTextField();
        tfpending.setBounds(200,280,150,25);
        add(tfpending);


        check = new JButton("Check");
        check.setBackground(Color.BLACK);
        check.setForeground(Color.WHITE);
        check.setBounds(30,340,100,30);
//        check.addActionListener(this);
        add(check);


        update = new JButton("Update");
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.setBounds(150,340,100,30);
//        update.addActionListener(this);
        add(update);

        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(270,340,100,30);
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
     
      private class UpdateCheckController implements ActionListener {
        private UpdateCheckModel model;
        private UpdateCheckView view;
        
        UpdateCheckController(UpdateCheckModel model, UpdateCheckView view) {
            this.model = model;
            this.view = view;
            view.addNextButtonListener(this);
        }
        
        public void actionPerformed(ActionEvent ae) {
           if(ae.getSource()==view.check){
            String id = view.ccustomer.getSelectedItem();
            String query = "select * from customer where (number = '"+id+"' and hotel_id='"+hidi+"') ";
            
        }
        else if(ae.getSource()==view.update){
            if(view.tfroom.equals("") || view.tfname.equals("") || view.tfcheckin.equals("") || view.tfpaid.equals("") || view.tfpending.equals(""))
            {
                JOptionPane.showMessageDialog(null,"please enter all fields or click on : Check' ");
            }
            else {
            
            model.connect2(view,hidi);
                
            }

        }
        else{
            view.close();
            new Reception(hidi);
        }
    }
      }
    
     public UpdateCheck(String hidi) {
        UpdateCheckModel model = new UpdateCheckModel();
        UpdateCheckView view = new UpdateCheckView(hidi);
        UpdateCheckController controller = new UpdateCheckController(model, view);
    }
    
    public static void main(String[] args) {
        new UpdateCheck(hidi);
    }
}