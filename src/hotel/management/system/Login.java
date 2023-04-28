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
//public class Login extends JFrame implements ActionListener{
//
//    JTextField username; // we need to access these fields outside this constructor, to use in the handler fn
//    JPasswordField password;
//    JButton login,cancel;
//    Login(){
//        getContentPane().setBackground(Color.WHITE);
//        
//        setLayout(null);
//        
//        //create Username label
//        JLabel user = new JLabel("Username");
//        user.setBounds(40,20,100,30);
//        add(user);
//        
//        //create text field right infront of "Username"
//        username = new JTextField();
//        username.setBounds(140,20,150,30);
//        add(username);
//        
//        //create "Password label"
//        JLabel pass = new JLabel("Password");
//        pass.setBounds(40,70,100,30);
//        add(pass);
//        
//        //create "password" text field where user will enter his pswd
//         password = new JPasswordField();
//        password.setBounds(150,70,150,30);
//        add(password);
//        
//        //create login button
//         login = new JButton("Login");
//        login.setBounds(40,150,160,30); //40+120=160 is total height of this button so for 'cancel' button need to give bit large size
//        login.setBackground(Color.BLACK);
//        login.setForeground(Color.WHITE);
//        login.addActionListener(this);
//        add(login);
//        
//        //create "cancel" button
//         cancel = new JButton("Back");
//        cancel.setBounds(210,150,120,30);
//        cancel.setBackground(Color.GREEN);
//        cancel.setForeground(Color.WHITE);
//        cancel.addActionListener(this);
//        add(cancel);
//        
//        //add 'user' image
//        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
//        //scale the image , get image from i1 use i2 which stores updated scaled i1's image, then need to add it to frame
//        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
//        //cant place image class ka aobject (i2) inside JLabel
//        //so store in i3 then use it
//        ImageIcon i3 = new ImageIcon(i2);
//        JLabel image = new JLabel(i3);
//        image.setBounds(350,10,200,200);
//        add(image);
//        
//        
//        setBounds(500,200,600,300);
//        setVisible(true);
//    }
//
//    public void actionPerformed(ActionEvent ae){
//        if(ae.getSource()==login) { //if login button is clicked
//            String user = username.getText();
//            String pass = password.getText();
//         try{
//               Conn c = new Conn();
//               //here user,pass is variable whose value needs to be compared so use '+' operator:
//              // and also username is given as 'user' with single invited comma, so use single invited comma like this:
//             String query = "select * from login where username = '" + user + "' and password = '" + pass + "'";
//             ResultSet rs = c.s.executeQuery(query);
//             //store result of table in rs (above)
//             if(rs.next()){
//                 //if rs.next is true => values are received, if not goto else => show popup invalid credentials
//                 setVisible(false); //if crct data is received then close login frame and open Main dashboard page:
//                 new Adminview(); //upon this call, constructor is called and frame is opened :)
//             }
//             else{
//                 JOptionPane.showMessageDialog(null,"Invalid Credentials/Only Admins can login here :)");
//                 //setVisible(false);
//             }
//         }catch (Exception e){
//             e.printStackTrace();
//         }
//        }
//        else if(ae.getSource()==cancel){
//            setVisible(false); // to close this frame
//            new Start();
//        }
//    }
//
//    public static void main(String[] args){
//
//
//        new Login();
//}
//}

package hotel.management.system;

import javax.swing.*; //for JFrame to create frame,java extended 
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame {
    private class LoginModel {
        public void connect(String user,String pass)
        {
            try{
               Conn c = new Conn();
               //here user,pass is variable whose value needs to be compared so use '+' operator:
              // and also username is given as 'user' with single invited comma, so use single invited comma like this:
             String query = "select * from login where username = '" + user + "' and password = '" + pass + "'";
             ResultSet rs = c.s.executeQuery(query);
             //store result of table in rs (above)
             if(rs.next()){
                 //if rs.next is true => values are received, if not goto else => show popup invalid credentials
                 setVisible(false); //if crct data is received then close login frame and open Main dashboard page:
                 new Adminview(); //upon this call, constructor is called and frame is opened :)
             }
             else{
                 JOptionPane.showMessageDialog(null,"Invalid Credentials/Only Admins can login here :)");
                 //setVisible(false);
             }
         }catch (Exception e){
             e.printStackTrace();
         }
        }
    }
    
     private class LoginView extends JFrame {
         JTextField username; // we need to access these fields outside this constructor, to use in the handler fn
    JPasswordField password;
    JButton login,cancel;
    JLabel image;
    LoginView(){
        getContentPane().setBackground(Color.WHITE);
        
        setLayout(null);
        
        //create Username label
        JLabel user = new JLabel("Username");
        user.setBounds(40,20,100,30);
        add(user);
        
        //create text field right infront of "Username"
        username = new JTextField();
        username.setBounds(140,20,150,30);
        add(username);
        
        //create "Password label"
        JLabel pass = new JLabel("Password");
        pass.setBounds(40,70,100,30);
        add(pass);
        
        //create "password" text field where user will enter his pswd
         password = new JPasswordField();
        password.setBounds(150,70,150,30);
        add(password);
        
        //create login button
         login = new JButton("Login");
        login.setBounds(40,150,160,30); //40+120=160 is total height of this button so for 'cancel' button need to give bit large size
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
//        login.addActionListener(this);
        add(login);
        
        //create "cancel" button
         cancel = new JButton("Back");
        cancel.setBounds(210,150,120,30);
        cancel.setBackground(Color.GREEN);
        cancel.setForeground(Color.WHITE);
//        cancel.addActionListener(this);
        add(cancel);
        
        //add 'user' image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        //scale the image , get image from i1 use i2 which stores updated scaled i1's image, then need to add it to frame
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        //cant place image class ka aobject (i2) inside JLabel
        //so store in i3 then use it
        ImageIcon i3 = new ImageIcon(i2);
        image = new JLabel(i3);
        image.setBounds(350,10,200,200);
        add(image);
        
        
        setBounds(500,200,600,300);
        setVisible(true);
     }
    public void addNextButtonListener(ActionListener listener) {
            login.addActionListener(listener);
            cancel.addActionListener(listener);

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
    private class LoginController implements ActionListener {
        private LoginModel model;
        private LoginView view;
        
        LoginController(LoginModel model, LoginView view) {
            this.model = model;
            this.view = view;
            view.addNextButtonListener(this);
        }
        
        public void actionPerformed(ActionEvent ae) {
            view.close();
        if(ae.getSource()==view.login) { //if login button is clicked
            String user = view.username.getText();
            String pass = view.password.getText();
            model.connect(user,pass);
         
        }
        else if(ae.getSource()==view.cancel){
            setVisible(false); // to close this frame
            new Start();
        }

        }
    }
    
    public Login() {
        LoginModel model = new LoginModel();
        LoginView view = new LoginView();
        LoginController controller = new LoginController(model, view);
    }
    
    public static void main(String[] args) {
        new Login();
    }
     
}