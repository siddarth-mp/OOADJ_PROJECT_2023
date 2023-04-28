//package hotel.management.system;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.sql.ResultSet;
//
//public class Register extends JFrame implements ActionListener {
//    Choice croom;
//    JButton register,cancel;
//    JTextField username; // we need to access these fields outside this constructor, to use in the handler fn
//    JPasswordField password;
//    Register(){
//        getContentPane().setBackground(Color.WHITE);
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
//        password = new JPasswordField();
//        password.setBounds(150,70,150,30);
//        add(password);
//
//        JLabel lblroom = new JLabel("Choose Hotel to proceed :");
//        lblroom.setBounds(40,120,200,25);
//        lblroom.setFont(new Font("Raleway",Font.BOLD,14));
//        add(lblroom);
//        
//        
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
//        croom .setBounds(260,125,80,25);
//        add(croom);
//
//
//
//        //add 'user' image
//        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
//        //scale the image , get image from i1 use i2 which stores updated scaled i1's image, then need to add it to frame
//        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
//        //cant place image class ka aobject (i2) inside JLabel
//        //so store in i3 then use it
//        ImageIcon i3 = new ImageIcon(i2);
//        JLabel image = new JLabel(i3);
//       image.setBounds(350,10,200,200);
//       add(image);
//
//        register = new JButton("Register");
//        register.setBounds(80,200,120,30);
//        register.setBackground(Color.BLACK);
//        register.setForeground(Color.WHITE);
//        register.addActionListener(this);
//        add(register);
//        
//        cancel = new JButton("Back");
//        cancel.setBounds(240,200,120,30);
//        cancel.setBackground(Color.GREEN);
//        cancel.setForeground(Color.WHITE);
//        cancel.addActionListener(this);
//        add(cancel);
//
//        setBounds(500,200,600,300);
//        setVisible(true);
//    }
//    public void actionPerformed(ActionEvent ae) {
//        if (ae.getSource() == register) { //if login button is clicked
//            String user = username.getText();
//            String pass = password.getText();
//            String hid = croom.getSelectedItem();
//            if (hid.equals("")) {
//                JOptionPane.showMessageDialog(null, "Choose a Hotel to proceed");
//            } else {
//                try {
//                    if (user.equals("") || pass.equals("")) {
//                        JOptionPane.showMessageDialog(null, "Enter username,password");
//                    } else {
//                        Conn c = new Conn();
//                        //here user,pass is variable whose value needs to be compared so use '+' operator:
//                        // and also username is given as 'user' with single invited comma, so use single invited comma like this:
//                        String query = "insert into usr_name(name,pwd,hotel_id) values('" + user + "' , '" + pass + "' , '" + hid + "')";
//                        c.s.executeUpdate(query);
//                        JOptionPane.showMessageDialog(null, "Registered Successfully with Hotel!!, Login Back");
//                        setVisible(false);
//                        new User(); //upon this call, constructor is called and frame is opened :)
//                    }
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//
//            }
//        }
//        else if(ae.getSource() == cancel)
//        {
//            setVisible(false);
//            new User();
//        }
//    }
//    public static void main(String[] args){new Register();}
//}

package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Register extends JFrame{
    private class RegisterModel {
        public void connect(String user,String pass,String hid)
        {
             try {
                    if (user.equals("") || pass.equals("")) {
                        JOptionPane.showMessageDialog(null, "Enter username,password");
                    } else {
            Conn c = new Conn();
                        String query = "insert into usr_name(name,pwd,hotel_id) values('" + user + "' , '" + pass + "' , '" + hid + "')";
                        c.s.executeUpdate(query);
                        JOptionPane.showMessageDialog(null, "Registered Successfully with Hotel!!, Login Back");
                        setVisible(false);
                        new User(); //upon this call, constructor is called and frame is opened :)
                        }
                } catch (Exception e) {
                    e.printStackTrace();
        }
    }
    }
    private class RegisterView extends JFrame {
        Choice croom;
    JButton register,cancel;
    JTextField username; // we need to access these fields outside this constructor, to use in the handler fn
    JPasswordField password;
    JLabel image;
    RegisterView(){
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

        JLabel lblroom = new JLabel("Choose Hotel to proceed :");
        lblroom.setBounds(40,120,200,25);
        lblroom.setFont(new Font("Raleway",Font.BOLD,14));
        add(lblroom);
        
        

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
        croom .setBounds(260,125,80,25);
        add(croom);



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

        register = new JButton("Register");
        register.setBounds(80,200,120,30);
        register.setBackground(Color.BLACK);
        register.setForeground(Color.WHITE);
//        register.addActionListener(this);
        add(register);
        
        cancel = new JButton("Back");
        cancel.setBounds(240,200,120,30);
        cancel.setBackground(Color.GREEN);
        cancel.setForeground(Color.WHITE);
//        cancel.addActionListener(this);
        add(cancel);

        setBounds(500,200,600,300);
        setVisible(true);
    }
    public void addNextButtonListener(ActionListener listener) {
            register.addActionListener(listener);
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
    
     private class RegisterController implements ActionListener {
        private RegisterModel model;
        private RegisterView view;
        
        RegisterController(RegisterModel model, RegisterView view) {
            this.model = model;
            this.view = view;
            view.addNextButtonListener(this);
        }
        
        public void actionPerformed(ActionEvent ae) {
            view.close();
            if (ae.getSource() == view.register) { //if login button is clicked
            String user = view.username.getText();
            String pass = view.password.getText();
            String hid = view.croom.getSelectedItem();
            if (hid.equals("")) {
                JOptionPane.showMessageDialog(null, "Choose a Hotel to proceed");
            } else {
               
                        model.connect(user,pass,hid);
                    
                }

            }
        else if(ae.getSource() == view.cancel)
        {
            setVisible(false);
            new User();
        }

        }
     }
    public Register() {
        RegisterModel model = new RegisterModel();
        RegisterView view = new RegisterView();
        RegisterController controller = new RegisterController(model, view);
    }
    
    public static void main(String[] args) {
        new Register();
    }
}
     