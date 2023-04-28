//package hotel.management.system;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.sql.ResultSet;
//
//public class User extends JFrame implements ActionListener {
//    JButton Login,Register,cancel;
//    JTextField username,htlid; // we need to access these fields outside this constructor, to use in the handler fn
//    JPasswordField password;
//
//    User(){
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
//        JLabel htl = new JLabel("Enter ur registered hotel id");
//        htl.setBounds(40,140,200,30);
//        add(htl);
//
//        htlid = new JTextField();
//        htlid.setBounds(220,140,150,30);
//        add(htlid);
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
//        image.setBounds(440,10,200,200);
//        add(image);
//
//        Login = new JButton("Login");
//        Login.setBounds(40,200,120,30);
//        Login.setBackground(Color.BLACK);
//        Login.setForeground(Color.WHITE);
//        Login.addActionListener(this);
//        add(Login);
//
//        //create "cancel" button
//        Register = new JButton("Register");
//        Register.setBounds(180,200,120,30);
//        Register.setBackground(Color.BLACK);
//        Register.setForeground(Color.WHITE);
//        Register.addActionListener(this);
//        add(Register);
//
//        
//        cancel = new JButton("Back");
//        cancel.setBounds(330,200,120,30);
//        cancel.setBackground(Color.GREEN);
//        cancel.setForeground(Color.WHITE);
//        cancel.addActionListener(this);
//        add(cancel);
//        
//        setBounds(500,200,660,300);
//        setVisible(true);
//    }
//    public void actionPerformed(ActionEvent ae) {
//        if (ae.getSource() == Login) { //if login button is clicked
//            String user = username.getText();
//            String pass = password.getText();
//            String hid1 = htlid.getText();
//            try {
//                Conn c = new Conn();
//                //here user,pass is variable whose value needs to be compared so use '+' operator:
//                // and also username is given as 'user' with single invited comma, so use single invited comma like this:
//                String query = "select * from usr_name where (name = '" + user + "' and pwd = '" + pass + "' and hotel_id = '"+hid1+"')";
//                ResultSet rs = c.s.executeQuery(query);
//                //store result of table in rs (above)
//                if (rs.next()) {
//                    //if rs.next is true => values are received, if not goto else => show popup invalid credentials
//                    setVisible(false); //if crct data is received then close login frame and open Main dashboard page:
//                    JOptionPane.showMessageDialog(null, "Welcome Back");
//                    new usrview(hid1); //upon this call, constructor is called and frame is opened :)
//                } else {
//                    JOptionPane.showMessageDialog(null, "Invalid Credentials of user");
//                    //setVisible(false);
//                }
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//
//        }
//        else if(ae.getSource()==Register){
//            setVisible(false);
//            new Register();
//        }
//        else if(ae.getSource()==cancel){
//            setVisible(false);
//            new Start();
//        }
//        setVisible(false);
//    }
//    public static void main(String[] args){new User();}
//
//}


package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;


public class User extends JFrame{
    private class UserModel {
        public void connect(String user,String pass,String hid1){
            try {
                Conn c = new Conn();
                //here user,pass is variable whose value needs to be compared so use '+' operator:
                // and also username is given as 'user' with single invited comma, so use single invited comma like this:
                String query = "select * from usr_name where (name = '" + user + "' and pwd = '" + pass + "' and hotel_id = '"+hid1+"')";
                ResultSet rs = c.s.executeQuery(query);
                //store result of table in rs (above)
                if (rs.next()) {
                    //if rs.next is true => values are received, if not goto else => show popup invalid credentials
                   //if crct data is received then close login frame and open Main dashboard page:
                    JOptionPane.showMessageDialog(null, "Welcome Back");
                    new usrview(hid1); //upon this call, constructor is called and frame is opened :)
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Credentials of user");
                    //setVisible(false);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
    }
    
    private class UserView extends JFrame {
        JButton Login,Register,cancel;
    JTextField username,htlid; // we need to access these fields outside this constructor, to use in the handler fn
    JPasswordField password;
    JLabel image;
    UserView(){
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

        JLabel htl = new JLabel("Enter ur registered hotel id");
        htl.setBounds(40,140,200,30);
        add(htl);

        htlid = new JTextField();
        htlid.setBounds(220,140,150,30);
        add(htlid);


        //add 'user' image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        //scale the image , get image from i1 use i2 which stores updated scaled i1's image, then need to add it to frame
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        //cant place image class ka aobject (i2) inside JLabel
        //so store in i3 then use it
        ImageIcon i3 = new ImageIcon(i2);
        image = new JLabel(i3);
        image.setBounds(440,10,200,200);
        add(image);

        Login = new JButton("Login");
        Login.setBounds(40,200,120,30);
        Login.setBackground(Color.BLACK);
        Login.setForeground(Color.WHITE);
//        Login.addActionListener(this);
        add(Login);

        //create "cancel" button
        Register = new JButton("Register");
        Register.setBounds(180,200,120,30);
        Register.setBackground(Color.BLACK);
        Register.setForeground(Color.WHITE);
//        Register.addActionListener(this);
        add(Register);

        
        cancel = new JButton("Back");
        cancel.setBounds(330,200,120,30);
        cancel.setBackground(Color.GREEN);
        cancel.setForeground(Color.WHITE);
//        cancel.addActionListener(this);
        add(cancel);
        
        setBounds(500,200,660,300);
        setVisible(true);
    }
    
        public void addNextButtonListener(ActionListener listener) {
            Login.addActionListener(listener);
            Register.addActionListener(listener);
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
    private class UserController implements ActionListener {
        private UserModel model;
        private UserView view;
        
        UserController(UserModel model, UserView view) {
            this.model = model;
            this.view = view;
            view.addNextButtonListener(this);
        }
        
        public void actionPerformed(ActionEvent ae) {
            view.close();
            if (ae.getSource() == view.Login) { //if login button is clicked
                setVisible(false);
//                view.hideText();
            String user = view.username.getText();
            String pass = view.password.getText();
            String hid1 = view.htlid.getText();
            
            model.connect(user,pass,hid1);
            

        }
        else if(ae.getSource()==view.Register){
            view.hideText();
            new Register();
        }
        else if(ae.getSource()==view.cancel){
            view.hideText();
            new Start();
        }

        }
    }
    
    public User() {
        UserModel model = new UserModel();
        UserView view = new UserView();
        UserController controller = new UserController(model, view);
    }
    
    public static void main(String[] args) {
        new User();
    }
}