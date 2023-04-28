///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package hotel.management.system;
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.sql.ResultSet;
//import java.util.Date;
///**
// *
// * @author Umesh
// */
//public class Checkout extends JFrame implements ActionListener{
//    public static String hidi;
//    Choice ccustomer;
//    JButton checkout,back;
//    JLabel lblcheckintime,lblroomnumber,lblcheckouttime;
//    Checkout(String hid){
//        hidi = hid;
//        getContentPane().setBackground(Color.WHITE);
//        setLayout(null);
//
//        JLabel text = new JLabel("Checkout");
//        text.setBounds(100,20,100,30);
//        text.setForeground(Color.BLUE);
//        text.setFont(new Font("Tahoma",Font.BOLD,20));
//        add(text);
//
//        JLabel lblid = new JLabel("Customer Id");
//        lblid.setBounds(30,80,100,30);
//        add(lblid);
//
//        //dropdown of id's
//        ccustomer = new Choice();
//        ccustomer.setBounds(150,80,150,25);
//        add(ccustomer);
//
//
//
//        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/tick.png"));
//        Image i2 = i1.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
//        ImageIcon i3 = new ImageIcon(i2);
//        JLabel tick = new JLabel(i3);
//        tick.setBounds(310,80,20,20);
//        add(tick);
//
//        JLabel lblroom = new JLabel("Room number");
//        lblroom.setBounds(30,130,100,30);
//        add(lblroom);
//
//         lblroomnumber = new JLabel();
//        lblroomnumber.setBounds(150,130,100,30);
//        add(lblroomnumber);
//
//        JLabel lblcheckin = new JLabel("Checkin time");
//        lblcheckin.setBounds(30,180,100,30);
//        add(lblcheckin);
//
//        lblcheckintime = new JLabel();
//        lblcheckintime.setBounds(150,180,100,30);
//        add(lblcheckintime);
//
//        JLabel lblcheckout = new JLabel("Checkout time");
//        lblcheckout.setBounds(30,230,100,30);
//        add(lblcheckout);
//
//        Date date = new Date();//cretae date class obj, convert to string:
//        lblcheckouttime = new JLabel("" + date);
//        lblcheckouttime.setBounds(150,230,150,30);
//        add(lblcheckouttime);
//
//
//        checkout = new JButton("Checkout");
//        checkout.setBackground(Color.BLACK);
//        checkout.setForeground(Color.WHITE);
//        checkout.setBounds(30,280,120,30);
//        checkout.addActionListener(this);
//        add(checkout);
//
//        back = new JButton("Back");
//        back.setBackground(Color.BLACK);
//        back.setForeground(Color.WHITE);
//        back.setBounds(170,280,120,30);
//        back.addActionListener(this);
//        add(back);
//
//        try{
//            Conn c = new Conn();
//            String query = "select * from customer where hotel_id = '"+hidi+"' ";
//            ResultSet rs = c.s.executeQuery(query);
//
//            while (rs.next()) {
//                //select which cust id to update
//                ccustomer.add(rs.getString("number"));
//                lblroomnumber.setText(rs.getString("room"));
//                lblcheckintime.setText(rs.getString("checkintime"));
//            }
//        }catch(Exception e){e.printStackTrace();}
//
//        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/sixth.jpg"));
//        Image i5 = i4.getImage().getScaledInstance(400,250,Image.SCALE_DEFAULT);
//        ImageIcon i6 = new ImageIcon(i5);
//        JLabel image = new JLabel(i6);
//        image.setBounds(350,50,400,250);
//        add(image);
//
//        setBounds(300,200,800,400);
//        setVisible(true);
//
//    }
//    public void actionPerformed(ActionEvent ae){
//        if(ae.getSource()==checkout){
//           //need to remove customer from customer table and change availablity from occcupied to Available in room table  so 2 queries
//           String query1 = "delete from customer where (number = '"+ccustomer.getSelectedItem()+"' and hotel_id = '"+hidi+"') ";
//           String query2 = "update room set availability = 'Available' where (roomnumber = '"+lblroomnumber.getText()+"' and hotel_id = '"+hidi+"') ";
//           try{
//               Conn c =new Conn();
//               c.s.executeUpdate(query1);
//               c.s.executeUpdate(query2);
//
//               JOptionPane.showMessageDialog(null,"Thank you for your time, see u soon");
//               setVisible(false);
//               String abc = ccustomer.getSelectedItem();
//               new Feedback(""+abc);
//           }catch(Exception e){e.printStackTrace();}
//
//        }else{
//            setVisible(false);
//            new Reception(hidi);
//        }
//    }
//
//    public static void main(String[] args){
//        new Checkout(hidi);
//    }
//}


package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;
/**
 *
 * @author Umesh
 */
public class Checkout extends JFrame{
    public static String hidi;
    private class CheckoutModel {
         public void connect(String query1,String query2,CheckoutView view)
         {
              try{
               Conn c =new Conn();
               c.s.executeUpdate(query1);
               c.s.executeUpdate(query2);

               JOptionPane.showMessageDialog(null,"Thank you for your time, see u soon");
               setVisible(false);
               String abc = view.ccustomer.getSelectedItem();
               new Feedback(""+abc);
           }catch(Exception e){e.printStackTrace();}
         }
     }
    
     private class CheckoutView extends JFrame {
         Choice ccustomer;
    JButton checkout,back;
    JLabel lblcheckintime,lblroomnumber,lblcheckouttime,image;
    CheckoutView(String hid){
        hidi = hid;
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel text = new JLabel("Checkout");
        text.setBounds(100,20,100,30);
        text.setForeground(Color.BLUE);
        text.setFont(new Font("Tahoma",Font.BOLD,20));
        add(text);

        JLabel lblid = new JLabel("Customer Id");
        lblid.setBounds(30,80,100,30);
        add(lblid);

        //dropdown of id's
        ccustomer = new Choice();
        ccustomer.setBounds(150,80,150,25);
        add(ccustomer);



        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/tick.png"));
        Image i2 = i1.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel tick = new JLabel(i3);
        tick.setBounds(310,80,20,20);
        add(tick);

        JLabel lblroom = new JLabel("Room number");
        lblroom.setBounds(30,130,100,30);
        add(lblroom);

         lblroomnumber = new JLabel();
        lblroomnumber.setBounds(150,130,100,30);
        add(lblroomnumber);

        JLabel lblcheckin = new JLabel("Checkin time");
        lblcheckin.setBounds(30,180,100,30);
        add(lblcheckin);

        lblcheckintime = new JLabel();
        lblcheckintime.setBounds(150,180,100,30);
        add(lblcheckintime);

        JLabel lblcheckout = new JLabel("Checkout time");
        lblcheckout.setBounds(30,230,100,30);
        add(lblcheckout);

        Date date = new Date();//cretae date class obj, convert to string:
        lblcheckouttime = new JLabel("" + date);
        lblcheckouttime.setBounds(150,230,150,30);
        add(lblcheckouttime);


        checkout = new JButton("Checkout");
        checkout.setBackground(Color.BLACK);
        checkout.setForeground(Color.WHITE);
        checkout.setBounds(30,280,120,30);
//        checkout.addActionListener(this);
        add(checkout);

        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(170,280,120,30);
//        back.addActionListener(this);
        add(back);

        try{
            Conn c = new Conn();
            String query = "select * from customer where hotel_id = '"+hidi+"' ";
            ResultSet rs = c.s.executeQuery(query);

            while (rs.next()) {
                //select which cust id to update
                ccustomer.add(rs.getString("number"));
                lblroomnumber.setText(rs.getString("room"));
                lblcheckintime.setText(rs.getString("checkintime"));
            }
        }catch(Exception e){e.printStackTrace();}

        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/sixth.jpg"));
        Image i5 = i4.getImage().getScaledInstance(400,250,Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        image = new JLabel(i6);
        image.setBounds(350,50,400,250);
        add(image);

        setBounds(300,200,800,400);
        setVisible(true);
    }
    public void addNextButtonListener(ActionListener listener) {
            checkout.addActionListener(listener);
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
    private class CheckoutController implements ActionListener {
        private CheckoutModel model;
        private CheckoutView view;
        
        CheckoutController(CheckoutModel model, CheckoutView view) {
            this.model = model;
            this.view = view;
            view.addNextButtonListener(this);
        }
        
        public void actionPerformed(ActionEvent ae) {
          view.close();
            if(ae.getSource()==view.checkout){
                
           //need to remove customer from customer table and change availablity from occcupied to Available in room table  so 2 queries
           String query1 = "delete from customer where (number = '"+view.ccustomer.getSelectedItem()+"' and hotel_id = '"+hidi+"') ";
           String query2 = "update room set availability = 'Available' where (roomnumber = '"+view.lblroomnumber.getText()+"' and hotel_id = '"+hidi+"') ";
           
           model.connect(query1,query2,view);
          

        }else{
            setVisible(false);
            new Reception(hidi);
        }
        }
    }
    
     public Checkout(String hidi) {
        CheckoutModel model = new CheckoutModel();
        CheckoutView view = new CheckoutView(hidi);
        CheckoutController controller = new CheckoutController(model, view);
    }
    
    public static void main(String[] args) {
        new Checkout(hidi);
    }
}