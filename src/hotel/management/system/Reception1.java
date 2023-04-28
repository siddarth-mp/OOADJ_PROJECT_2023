//package hotel.management.system;
//import javax.swing.*;
//
//import java.sql.*;
//import java.awt.event.*;
//import java.awt.*;
///**
// *
// * @author Umesh
// */
//public class Reception1 extends JFrame implements ActionListener{
//    public static String hidi;
//    JButton dep,newCustomer,bk,mgr,logout,roomStatus,searchRoom,rooms,customers,department,allEmployee,managerInfo;
//    Reception1(String hid){
//        hidi = hid;
//
//        getContentPane().setBackground(Color.WHITE);
//        setLayout(null);//need to do this for setbounds to work
//
//        newCustomer = new JButton("New Customer Form");
//        newCustomer.setBounds(10,50,200,30);
//        newCustomer.setBackground(Color.BLACK);
//        newCustomer.setForeground(Color.WHITE);
//        newCustomer.addActionListener(this);
//        add(newCustomer);
//
//        rooms = new JButton("Rooms");
//        rooms.setBounds(10,120,200,30); //add 40 to previous 'y'
//        rooms.setBackground(Color.BLACK);
//        rooms.setForeground(Color.WHITE);
//        rooms.addActionListener(this);
//        add(rooms);
//        //upon clicking Department, a new frame opens which shows dept revenue, staff,..
//
//        roomStatus = new JButton("Department Info");
//        roomStatus.setBounds(10,190,200,30); //add 40 to previous 'y'
//        roomStatus.setBackground(Color.BLACK);
//        roomStatus.setForeground(Color.WHITE);
//        roomStatus.addActionListener(this);
//        add(roomStatus);
//
//
//        searchRoom = new JButton("Search Room");
//        searchRoom.setBounds(10,260,200,30); //add 40 to previous 'y'
//        searchRoom.setBackground(Color.BLACK);
//        searchRoom.setForeground(Color.WHITE);
//        searchRoom.addActionListener(this);
//        add(searchRoom);
//
//        logout = new JButton("Logout");
//        logout.setBounds(10,330,200,30); //add 40 to previous 'y'
//        logout.setBackground(Color.BLACK);
//        logout.setForeground(Color.WHITE);
//        logout.addActionListener(this);
//        add(logout);
//
//        bk = new JButton("Back");
//        bk.setBounds(10,400,200,30); //add 40 to previous 'y'
//        bk.setBackground(Color.BLACK);
//        bk.setForeground(Color.WHITE);
//        bk.addActionListener(this);
//        add(bk);
//
//        mgr = new JButton("Manager info");
//        mgr.setBounds(10,470,200,30); //add 40 to previous 'y'
//        mgr.setBackground(Color.BLACK);
//        mgr.setForeground(Color.WHITE);
//        mgr.addActionListener(this);
//        add(mgr);
//
//
//
//        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fourth.jpg"));
//        JLabel image = new JLabel(i1);
//        image.setBounds(250,30,500,470);
//        add(image);
//
//
//        setBounds(350,200,800,600);
//        setVisible(true);
//    }
//    public void actionPerformed(ActionEvent ae){
//        if(ae.getSource()==newCustomer){
//            setVisible(false);
//            new AddCustomer(hidi);
//        }
//        else if(ae.getSource()==rooms){
//            setVisible(false);
//            new Room(hidi);
//        }
//        else if(ae.getSource()==searchRoom){
//            setVisible(false);
//            new SearchRoom(hidi);
//        }
//
//        else if(ae.getSource()==roomStatus){
//            setVisible(false);
//            new Department(hidi);
//        }
//        else if(ae.getSource()==logout){
//            JOptionPane.showMessageDialog(null,"Thank You!!");
//            setVisible(false);
//            new Feedback(hidi);
//
//        }
//        else if(ae.getSource()==bk){
//            //JOptionPane.showMessageDialog(null,"Thank You!!");
//            setVisible(false);
//            //new Dashboard();
//        }
//        else if(ae.getSource()==mgr){
//            //JOptionPane.showMessageDialog(null,"Thank You!!");
//            setVisible(false);
//            new ManagerInfo(hidi);
//            //new Dashboard();
//        }
//    }
//
//    public static void main(String[] args){
//        new Reception1(hidi);}
//
//}


package hotel.management.system;
import javax.swing.*;

import java.sql.*;
import java.awt.event.*;
import java.awt.*;

public class Reception1 extends JFrame{
     public static String hidi;
     
     private class Reception1Model {
         
     }
     
      private class Reception1View extends JFrame {
          JButton dep,newCustomer,bk,mgr,logout,roomStatus,searchRoom,rooms,customers,department,allEmployee,managerInfo;
          JLabel image;
            Reception1View(String hid){
        hidi = hid;

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);//need to do this for setbounds to work

        newCustomer = new JButton("New Customer Form");
        newCustomer.setBounds(10,50,200,30);
        newCustomer.setBackground(Color.BLACK);
        newCustomer.setForeground(Color.WHITE);
//        newCustomer.addActionListener(this);
        add(newCustomer);

        rooms = new JButton("Rooms");
        rooms.setBounds(10,120,200,30); //add 40 to previous 'y'
        rooms.setBackground(Color.BLACK);
        rooms.setForeground(Color.WHITE);
//        rooms.addActionListener(this);
        add(rooms);
        //upon clicking Department, a new frame opens which shows dept revenue, staff,..

        roomStatus = new JButton("Department Info");
        roomStatus.setBounds(10,190,200,30); //add 40 to previous 'y'
        roomStatus.setBackground(Color.BLACK);
        roomStatus.setForeground(Color.WHITE);
//        roomStatus.addActionListener(this);
        add(roomStatus);


        searchRoom = new JButton("Search Room");
        searchRoom.setBounds(10,260,200,30); //add 40 to previous 'y'
        searchRoom.setBackground(Color.BLACK);
        searchRoom.setForeground(Color.WHITE);
//        searchRoom.addActionListener(this);
        add(searchRoom);

        logout = new JButton("Logout");
        logout.setBounds(10,330,200,30); //add 40 to previous 'y'
        logout.setBackground(Color.BLACK);
        logout.setForeground(Color.WHITE);
//        logout.addActionListener(this);
        add(logout);

        bk = new JButton("Back");
        bk.setBounds(10,400,200,30); //add 40 to previous 'y'
        bk.setBackground(Color.BLACK);
        bk.setForeground(Color.WHITE);
//        bk.addActionListener(this);
        add(bk);

        mgr = new JButton("Manager info");
        mgr.setBounds(10,470,200,30); //add 40 to previous 'y'
        mgr.setBackground(Color.BLACK);
        mgr.setForeground(Color.WHITE);
//        mgr.addActionListener(this);
        add(mgr);



        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fourth.jpg"));
        image = new JLabel(i1);
        image.setBounds(250,30,500,470);
        add(image);


        setBounds(350,200,800,600);
        setVisible(true);
    }
            public void addNextButtonListener(ActionListener listener) {
            newCustomer.addActionListener(listener);
            rooms.addActionListener(listener);
            roomStatus.addActionListener(listener);
            searchRoom.addActionListener(listener);
            logout.addActionListener(listener);
            bk.addActionListener(listener);
            mgr.addActionListener(listener);
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
    private class Reception1Controller implements ActionListener {
        private Reception1Model model;
        private Reception1View view;
        
        Reception1Controller(Reception1Model model, Reception1View view) {
            this.model = model;
            this.view = view;
            view.addNextButtonListener(this);
        }
        
        public void actionPerformed(ActionEvent ae) {
            if(ae.getSource()==view.newCustomer){
            setVisible(false);
            new AddCustomer(hidi);
        }
        else if(ae.getSource()==view.rooms){
            setVisible(false);
            new Room(hidi);
        }
        else if(ae.getSource()==view.searchRoom){
            setVisible(false);
            new SearchRoom(hidi);
        }

        else if(ae.getSource()==view.roomStatus){
            view.close();
            setVisible(false);
            new Department(hidi);
        }
        else if(ae.getSource()==view.logout){
            JOptionPane.showMessageDialog(null,"Thank You!!");
            view.close();
            new Feedback(hidi);

        }
        else if(ae.getSource()==view.bk){
            view.close();
            //new Dashboard();
        }
        else if(ae.getSource()==view.mgr){
            //JOptionPane.showMessageDialog(null,"Thank You!!");
            view.close();
            new ManagerInfo(hidi);
            //new Dashboard();
        }

        }
    }
    
     public Reception1(String hidi) {
        Reception1Model model = new Reception1Model();
        Reception1View view = new Reception1View(hidi);
        Reception1Controller controller = new Reception1Controller(model, view);
    }
    
    public static void main(String[] args) {
        new Reception1(hidi);
    }
}