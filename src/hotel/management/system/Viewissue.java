///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package hotel.management.system;
//
//import javax.swing.*; //for JFrame to create frame,java extended
//import java.awt.*;
//import java.awt.event.*;
//import java.sql.*;
////through ActionListener can catch the events
//public class Viewissue extends JFrame implements ActionListener{
//    public static String hidi;
//
//    JTextField u2,username2,username; // we need to access these fields outside this constructor, to use in the handler fn
//    JPasswordField password;
//    JButton login,cancel;
//    Viewissue(String hid){
//        hidi = hid;
//        getContentPane().setBackground(Color.WHITE);
//
//        setLayout(null);
//
//        //create Username label
//        JLabel user = new JLabel("Enter issue id :");
//        user.setBounds(40,20,100,30);
//        add(user);
//
//        //create text field right infront of "Username"
//        username = new JTextField();
//        username.setBounds(140,20,150,30);
//        add(username);
//
//        //create "Password label"
//        JLabel pass = new JLabel("Your issue :");
//        pass.setBounds(40,70,100,30);
//        add(pass);
//
//        //create "password" text field where user will enter his pswd
//        username2 = new JTextField();
//        username2.setBounds(150,70,150,30);
//        add(username2);
//
//        JLabel st = new JLabel("Your Status :");
//        st.setBounds(40,120,100,30);
//        add(st);
//
//        //create "password" text field where user will enter his pswd
//        u2 = new JTextField();
//        u2.setBounds(150,120,150,30);
//        add(u2);
//
//
//
//        //create login button
//        login = new JButton("Check");
//        login.setBounds(40,180,160,30); //40+120=160 is total height of this button so for 'cancel' button need to give bit large size
//        login.setBackground(Color.BLACK);
//        login.setForeground(Color.WHITE);
//        login.addActionListener(this);
//        add(login);
//
//        //create "cancel" button
//        cancel = new JButton("Back");
//        cancel.setBounds(210,180,120,30);
//        cancel.setBackground(Color.GREEN);
//        cancel.setForeground(Color.WHITE);
//        cancel.addActionListener(this);
//        add(cancel);
//
//
//
//
//        setBounds(500,200,600,300);
//        setVisible(true);
//    }
//
//    public void actionPerformed(ActionEvent ae){
//        if(ae.getSource()==login) { //if login button is clicked
//            String iid = username.getText();
//            try{
//                Conn c = new Conn();
//                //here user,pass is variable whose value needs to be compared so use '+' operator:
//                // and also username is given as 'user' with single invited comma, so use single invited comma like this:
//                String query = "select status,descr from Issue where (issue_id = '" + iid +"' and hotel_id = '"+hidi+"') ";
//                ResultSet rs = c.s.executeQuery(query);
//                if(rs.next()){
//                    username2.setText(rs.getString("status"));
//                    u2.setText(rs.getString("descr"));
//                }
//                else{
//                    JOptionPane.showMessageDialog(null,"Invalid Issue id");
//                    //setVisible(false);
//                }
//            }catch (Exception e){
//                e.printStackTrace();
//            }
//        }
//        else if(ae.getSource()==cancel){ // to close this frame
//            setVisible(false);
//            new Issue(hidi);
//        }
//    }
//
//    public static void main(String[] args){
//        new Viewissue("" + hidi);
//}
//
//}


package hotel.management.system;

import javax.swing.*; //for JFrame to create frame,java extended
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Viewissue extends JFrame{
    public static String hidi;
    
     private class ViewissueModel {
         public void connect(String hidi, String iid,ViewissueView view){
             try{
                Conn c = new Conn();
                //here user,pass is variable whose value needs to be compared so use '+' operator:
                // and also username is given as 'user' with single invited comma, so use single invited comma like this:
                String query = "select status,descr from Issue where (issue_id = '" + iid +"' and hotel_id = '"+hidi+"') ";
                ResultSet rs = c.s.executeQuery(query);
                if(rs.next()){
                    view.username2.setText(rs.getString("status"));
                    view.u2.setText(rs.getString("descr"));
                }
                else{
                    JOptionPane.showMessageDialog(null,"Invalid Issue id");
                    //setVisible(false);
                }
            }catch (Exception e){
                e.printStackTrace();
            }
         }
     }
     
     private class ViewissueView extends JFrame {
         JTextField u2,username2,username; // we need to access these fields outside this constructor, to use in the handler fn
    JPasswordField password;
    JButton login,cancel;
    ViewissueView(String hid){
        hidi = hid;
        getContentPane().setBackground(Color.WHITE);

        setLayout(null);

        //create Username label
        JLabel user = new JLabel("Enter issue id :");
        user.setBounds(40,20,100,30);
        add(user);

        //create text field right infront of "Username"
        username = new JTextField();
        username.setBounds(140,20,150,30);
        add(username);

        //create "Password label"
        JLabel pass = new JLabel("Your issue :");
        pass.setBounds(40,70,100,30);
        add(pass);

        //create "password" text field where user will enter his pswd
        username2 = new JTextField();
        username2.setBounds(150,70,150,30);
        add(username2);

        JLabel st = new JLabel("Your Status :");
        st.setBounds(40,120,100,30);
        add(st);

        //create "password" text field where user will enter his pswd
        u2 = new JTextField();
        u2.setBounds(150,120,150,30);
        add(u2);



        //create login button
        login = new JButton("Check");
        login.setBounds(40,180,160,30); //40+120=160 is total height of this button so for 'cancel' button need to give bit large size
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
//        login.addActionListener(this);
        add(login);

        //create "cancel" button
        cancel = new JButton("Back");
        cancel.setBounds(210,180,120,30);
        cancel.setBackground(Color.GREEN);
        cancel.setForeground(Color.WHITE);
//        cancel.addActionListener(this);
        add(cancel);




        setBounds(500,200,600,300);
        setVisible(true);
    }
     public void addNextButtonListener(ActionListener listener) {
            login.addActionListener(listener);
            cancel.addActionListener(listener);
        }
        
        public void showText() {
            setVisible(true);
        }
        
        public void hideText() {
            setVisible(false);
        }
        
        public void close() {
            setVisible(false);
            dispose();
        }
     }
     private class ViewissueController implements ActionListener {
        private ViewissueModel model;
        private ViewissueView view;
        
       ViewissueController(ViewissueModel model, ViewissueView view) {
            this.model = model;
            this.view = view;
            view.addNextButtonListener(this);
        }
        
        public void actionPerformed(ActionEvent ae) {
            
       if(ae.getSource()==view.login) { //if login button is clicked
            String iid = view.username.getText();
            model.connect(hidi,iid,view);
        }
        else if(ae.getSource()==view.cancel){ // to close this frame
            view.close();
            new Issue(hidi);
        }
        }
    
     }
      public Viewissue(String hidi) {
        ViewissueModel model = new ViewissueModel();
        ViewissueView view = new ViewissueView(hidi);
        ViewissueController controller = new ViewissueController(model, view);
    }
    
    public static void main(String[] args) {
        new Viewissue(hidi);
    }
}