//package hotel.management.system;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.sql.ResultSet;
//
//public class Start extends JFrame implements ActionListener {
//    JButton user,admin,manager,view,viewrat;
//    Start(){
//        getContentPane().setBackground(Color.WHITE);
//        setLayout(null);
//
//        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/hmss.jpg"));
//        Image i2 = i1.getImage().getScaledInstance(350,300,Image.SCALE_DEFAULT); // resize the image previously it was enlarged
//        ImageIcon i3 = new ImageIcon(i2);
//        JLabel image = new JLabel(i3);
//        image.setBounds(520,20,350,300); //where to place the image (coords)
//        add(image);
//
//        JLabel text = new JLabel("Hotel Management System");
//        text.setBounds(70,20,300,30);
//        text.setForeground(Color.BLUE);
//        text.setFont(new Font("Tahoma",Font.BOLD,20));
//        add(text);
//
//        JLabel text1 = new JLabel("Welcome to our Hotel Management System, where we recommend");
//        text1.setBounds(30,60,500,30);
//        text1.setForeground(Color.BLACK);
//        text1.setFont(new Font("Tahoma",Font.PLAIN,14));
//        add(text1);
//
//        JLabel text2 = new JLabel("you some of the top hotels in banglore, we offer lodging/");
//        text2.setBounds(30,100,500,30);
//        text2.setForeground(Color.BLACK);
//        text2.setFont(new Font("Tahoma",Font.PLAIN,14));
//        add(text2);
//
//        JLabel text3 = new JLabel("pickup service at your stay, you can choose hotel of your");
//        text3.setBounds(30,140,500,30);
//        text3.setForeground(Color.BLACK);
//        text3.setFont(new Font("Tahoma",Font.PLAIN,14));
//        add(text3);
//
//        JLabel text4 = new JLabel("liking.This a Centralized system where managers can review");
//        text4.setBounds(30,180,500,30);
//        text4.setForeground(Color.BLACK);
//        text4.setFont(new Font("Tahoma",Font.PLAIN,14));
//        add(text4);
//
//        JLabel text5 = new JLabel("their hotel,admins can add hotels. view anlystics,user can avail");
//        text5.setBounds(30,220,500,30);
//        text5.setForeground(Color.BLACK);
//        text5.setFont(new Font("Tahoma",Font.PLAIN,14));
//        add(text5);
//
//        JLabel text6 = new JLabel("all the benefits by logging in, Hope you enjoy your time with us :)");
//        text6.setBounds(30,260,500,30);
//        text6.setForeground(Color.BLACK);
//        text6.setFont(new Font("Tahoma",Font.PLAIN,14));
//        add(text6);
//
//        user = new JButton("User Login");
//        user.setBackground(Color.BLACK);
//        user.setForeground(Color.WHITE);
//        user.setBounds(10,320,120,30);
//        user.addActionListener(this);
//        add(user);
//
//        admin = new JButton("Admin Login");
//        admin.setBackground(Color.BLACK);
//        admin.setForeground(Color.WHITE);
//        admin.setBounds(150,320,120,30);
//        admin.addActionListener(this);
//        add(admin);
//
//        manager = new JButton("Manager Login");
//        manager.setBackground(Color.BLACK);
//        manager.setForeground(Color.WHITE);
//        manager.setBounds(300,320,120,30);
//        manager.addActionListener(this);
//        add(manager);
//
//        view = new JButton("View Hotels");
//        view.setBackground(Color.BLACK);
//        view.setForeground(Color.WHITE);
//        view.setBounds(65,370,120,30);
//        view.addActionListener(this);
//        add(view);
//
//        viewrat = new JButton("View Ratings");
//        viewrat.setBackground(Color.BLACK);
//        viewrat.setForeground(Color.WHITE);
//        viewrat.setBounds(205,370,120,30);
//        viewrat.addActionListener(this);
//        add(viewrat);
//
//
//        setBounds(400,450,900,450);
//        setVisible(true);
//
//
//
//    }
//    public void actionPerformed(ActionEvent ae){
//        if(ae.getSource()==user){
//           setVisible(false);
//           new User();
//        }
//        else if(ae.getSource()==admin){
//            setVisible(false);
//            new Login();
//        }
//        else if(ae.getSource()==manager){
//             setVisible(false);
//             new Managerlogin();
//        }
//        else if(ae.getSource()==view){
//            setVisible(false);
//            try{
//                Conn c = new Conn();
//                String g = "1";
//                ResultSet rs = c.s.executeQuery("select * from hotels where hotel_id = '"+g+"'");
//                while(rs.next()){
//                    String abc = rs.getString("hotel_id");
//                    new Viewhotel(abc);
//                }
//
//
//            }catch(Exception e){e.printStackTrace();}
//
//
//        }
//        else if(ae.getSource()==viewrat){;
//            new Htlsanalysis();
//        }
//
//    }
//    public static void main(String[] args){new Start();}
//}



package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Start extends JFrame {
    private class StartModel {
        // You could add any necessary fields and methods here for the model
        
        public void connect()
        {
            try{
                Conn c = new Conn();
                String g = "1";
                ResultSet rs = c.s.executeQuery("select * from hotels where hotel_id = '"+g+"'");
                while(rs.next()){
                    String abc = rs.getString("hotel_id");
                    new Viewhotel(abc);
                }


            }catch(Exception e){e.printStackTrace();}
        }
        
    }
    
    private class StartView extends JFrame {
        JButton user,admin,manager,view1,viewrat;
        JLabel image;
        StartView(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/hmss.jpg"));
        Image i2 = i1.getImage().getScaledInstance(350,300,Image.SCALE_DEFAULT); // resize the image previously it was enlarged
        ImageIcon i3 = new ImageIcon(i2);
        image = new JLabel(i3);
        image.setBounds(520,20,350,300); //where to place the image (coords)
        add(image);

        JLabel text = new JLabel("Hotel Management System");
        text.setBounds(70,20,300,30);
        text.setForeground(Color.BLUE);
        text.setFont(new Font("Tahoma",Font.BOLD,20));
        add(text);

        JLabel text1 = new JLabel("Welcome to our Hotel Management System, where we recommend");
        text1.setBounds(30,60,500,30);
        text1.setForeground(Color.BLACK);
        text1.setFont(new Font("Tahoma",Font.PLAIN,14));
        add(text1);

        JLabel text2 = new JLabel("you some of the top hotels in banglore, we offer lodging/");
        text2.setBounds(30,100,500,30);
        text2.setForeground(Color.BLACK);
        text2.setFont(new Font("Tahoma",Font.PLAIN,14));
        add(text2);

        JLabel text3 = new JLabel("pickup service at your stay, you can choose hotel of your");
        text3.setBounds(30,140,500,30);
        text3.setForeground(Color.BLACK);
        text3.setFont(new Font("Tahoma",Font.PLAIN,14));
        add(text3);

        JLabel text4 = new JLabel("liking.This a Centralized system where managers can review");
        text4.setBounds(30,180,500,30);
        text4.setForeground(Color.BLACK);
        text4.setFont(new Font("Tahoma",Font.PLAIN,14));
        add(text4);

        JLabel text5 = new JLabel("their hotel,admins can add hotels. view anlystics,user can avail");
        text5.setBounds(30,220,500,30);
        text5.setForeground(Color.BLACK);
        text5.setFont(new Font("Tahoma",Font.PLAIN,14));
        add(text5);

        JLabel text6 = new JLabel("all the benefits by logging in, Hope you enjoy your time with us :)");
        text6.setBounds(30,260,500,30);
        text6.setForeground(Color.BLACK);
        text6.setFont(new Font("Tahoma",Font.PLAIN,14));
        add(text6);

        user = new JButton("User Login");
        user.setBackground(Color.BLACK);
        user.setForeground(Color.WHITE);
        user.setBounds(10,320,120,30);
//        user.addActionListener(this);
        add(user);

        admin = new JButton("Admin Login");
        admin.setBackground(Color.BLACK);
        admin.setForeground(Color.WHITE);
        admin.setBounds(150,320,120,30);
//        admin.addActionListener(this);
        add(admin);

        manager = new JButton("Manager Login");
        manager.setBackground(Color.BLACK);
        manager.setForeground(Color.WHITE);
        manager.setBounds(300,320,120,30);
//        manager.addActionListener(this);
        add(manager);

        view1 = new JButton("View Hotels");
        view1.setBackground(Color.BLACK);
        view1.setForeground(Color.WHITE);
        view1.setBounds(65,370,120,30);
//        view1.addActionListener(this);
        add(view1);

        viewrat = new JButton("View Ratings");
        viewrat.setBackground(Color.BLACK);
        viewrat.setForeground(Color.WHITE);
        viewrat.setBounds(205,370,120,30);
//        viewrat.addActionListener(this);
        add(viewrat);


        setBounds(400,450,900,450);
        setVisible(true);
        }
        
        public void addNextButtonListener(ActionListener listener) {
            user.addActionListener(listener);
            admin.addActionListener(listener);
            manager.addActionListener(listener);
            view1.addActionListener(listener);
            viewrat.addActionListener(listener);
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
    private class StartController implements ActionListener {
        private StartModel model;
        private StartView view;
        
        StartController(StartModel model, StartView view) {
            this.model = model;
            this.view = view;
            view.addNextButtonListener(this);
        }
        
        public void actionPerformed(ActionEvent ae) {
            
        if(ae.getSource()==view.user){
           view.hideText();
           view.close();
           new User();
        }
        else if(ae.getSource()==view.admin){
            view.hideText();
            view.close();
            new Login();
        }
        else if(ae.getSource()==view.manager){
             view.hideText();
             view.close();
             new Managerlogin();
        }
        else if(ae.getSource()==view.view1){
            view.hideText();
            view.close();
            model.connect();
            


        }
        else if(ae.getSource()==view.viewrat){
            new Htlsanalysis();
        }

        }
    }
    
    public Start() {
        StartModel model = new StartModel();
        StartView view = new StartView();
        StartController controller = new StartController(model, view);
    }
    
    public static void main(String[] args) {
        new Start();
    }
}