///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
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
//public class Reception extends JFrame implements ActionListener{
//    public static String hidi;
//    JButton bk,logout,checkout,pickup,roomStatus,update,searchRoom,newCustomer,rooms,customers,department,allEmployee,managerInfo;
//    Reception(String hid){
//        hidi = hid;
//
//        getContentPane().setBackground(Color.WHITE);
//        setLayout(null);//need to do this for setbounds to work
//
//         newCustomer = new JButton("New Customer Form");
//        newCustomer.setBounds(10,30,200,30);
//        newCustomer.setBackground(Color.BLACK);
//        newCustomer.setForeground(Color.WHITE);
//        newCustomer.addActionListener(this);
//        add(newCustomer);
//
//        rooms = new JButton("Rooms");
//        rooms.setBounds(10,70,200,30); //add 40 to previous 'y'
//        rooms.setBackground(Color.BLACK);
//        rooms.setForeground(Color.WHITE);
//        rooms.addActionListener(this);
//        add(rooms);
//        //upon clicking Department, a new frame opens which shows dept revenue, staff,..
//         department = new JButton("Department");
//        department.setBounds(10,110,200,30); //add 40 to previous 'y'
//        department.setBackground(Color.BLACK);
//        department.setForeground(Color.WHITE);
//        department.addActionListener(this);
//        add(department);
//
//         allEmployee = new JButton("All Employees");
//        allEmployee.setBounds(10,150,200,30); //add 40 to previous 'y'
//        allEmployee.setBackground(Color.BLACK);
//        allEmployee.setForeground(Color.WHITE);
//        allEmployee.addActionListener(this);
//        add(allEmployee);
//
//        //upon clicking cust info button, need to get all info by opening a new frame
//         customers = new JButton("Customer info");
//        customers.setBounds(10,190,200,30); //add 40 to previous 'y'
//        customers.setBackground(Color.BLACK);
//        customers.setForeground(Color.WHITE);
//        customers.addActionListener(this);
//        add(customers);
//
//         managerInfo = new JButton("Manager info");
//        managerInfo.setBounds(10,230,200,30); //add 40 to previous 'y'
//        managerInfo.setBackground(Color.BLACK);
//        managerInfo.setForeground(Color.WHITE);
//        managerInfo.addActionListener(this);
//        add(managerInfo);
//
//         checkout = new JButton("Checkout");
//        checkout.setBounds(10,270,200,30); //add 40 to previous 'y'
//        checkout.setBackground(Color.BLACK);
//        checkout.setForeground(Color.WHITE);
//        checkout.addActionListener(this);
//        add(checkout);
//
//         update = new JButton("Update Status");
//        update.setBounds(10,310,200,30); //add 40 to previous 'y'
//        update.setBackground(Color.BLACK);
//        update.setForeground(Color.WHITE);
//        update.addActionListener(this);
//        add(update);
//
//         roomStatus = new JButton("Update Room Status");
//        roomStatus.setBounds(10,350,200,30); //add 40 to previous 'y'
//        roomStatus.setBackground(Color.BLACK);
//        roomStatus.setForeground(Color.WHITE);
//        roomStatus.addActionListener(this);
//        add(roomStatus);
//
//         pickup = new JButton("Pickup Service");
//        pickup.setBounds(10,390,200,30); //add 40 to previous 'y'
//        pickup.setBackground(Color.BLACK);
//        pickup.setForeground(Color.WHITE);
//        pickup.addActionListener(this);
//        add(pickup);
//
//         searchRoom = new JButton("Search Room");
//        searchRoom.setBounds(10,430,200,30); //add 40 to previous 'y'
//        searchRoom.setBackground(Color.BLACK);
//        searchRoom.setForeground(Color.WHITE);
//        searchRoom.addActionListener(this);
//        add(searchRoom);
//
//         logout = new JButton("Logout");
//        logout.setBounds(10,470,200,30); //add 40 to previous 'y'
//        logout.setBackground(Color.BLACK);
//        logout.setForeground(Color.WHITE);
//        logout.addActionListener(this);
//        add(logout);
//
//        bk = new JButton("Back");
//        bk.setBounds(10,510,200,30); //add 40 to previous 'y'
//        bk.setBackground(Color.BLACK);
//        bk.setForeground(Color.WHITE);
//        bk.addActionListener(this);
//        add(bk);
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
//        } else if(ae.getSource()==rooms){
//            setVisible(false);
//            new Room(hidi);
//        }
//        else if(ae.getSource()==department){
//            setVisible(false);
//            new Department(hidi);
//        }
//        else if(ae.getSource()==allEmployee){
//            setVisible(false);
//            new EmployeeInfo(hidi);
//        }
//        else if(ae.getSource()==managerInfo){
//            setVisible(false);
//            new ManagerInfo(hidi);
//        }
//        else if(ae.getSource()==customers){
//            setVisible(false);
//            new CustomerInfo(hidi);
//        }
//        else if(ae.getSource()==searchRoom){
//            setVisible(false);
//            new SearchRoom(hidi);
//        }
//        else if(ae.getSource()==update){
//            setVisible(false);
//            new UpdateCheck(hidi);
//        }
//        else if(ae.getSource()==roomStatus){
//            setVisible(false);
//            new UpdateRoom(hidi);
//        }
//        else if(ae.getSource()==pickup){
//            setVisible(false);
//            new Pickup(hidi);
//        }
//        else if(ae.getSource()==checkout){
//            setVisible(false);
//            new Checkout(hidi);
//        }
//        else if(ae.getSource()==logout){
//            JOptionPane.showMessageDialog(null,"Thank You!!");
//            setVisible(false);
//        }
//        else if(ae.getSource()==bk){
//            //JOptionPane.showMessageDialog(null,"Thank You!!");
//            setVisible(false);
//            //new Dashboard();
//        }
//    }
//
//    public static void main(String[] args){
//        new Reception(hidi);
//    }
//}


package hotel.management.system;
import javax.swing.*;

import java.sql.*;
import java.awt.event.*;
import java.awt.*;
/**
 *
 * @author Umesh
 */
public class Reception extends JFrame{
    public static String hidi;
     private class ReceptionModel {
         
     }
     
     private class ReceptionView extends JFrame {
        JButton bk,logout,checkout,pickup,roomStatus,update,searchRoom,newCustomer,rooms,customers,department,allEmployee,managerInfo;
        JLabel image;
        ReceptionView(String hid){
        hidi = hid;

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);//need to do this for setbounds to work

         newCustomer = new JButton("New Customer Form");
        newCustomer.setBounds(10,30,200,30);
        newCustomer.setBackground(Color.BLACK);
        newCustomer.setForeground(Color.WHITE);
//        newCustomer.addActionListener(this);
        add(newCustomer);

        rooms = new JButton("Rooms");
        rooms.setBounds(10,70,200,30); //add 40 to previous 'y'
        rooms.setBackground(Color.BLACK);
        rooms.setForeground(Color.WHITE);
//        rooms.addActionListener(this);
        add(rooms);
        //upon clicking Department, a new frame opens which shows dept revenue, staff,..
         department = new JButton("Department");
        department.setBounds(10,110,200,30); //add 40 to previous 'y'
        department.setBackground(Color.BLACK);
        department.setForeground(Color.WHITE);
//        department.addActionListener(this);
        add(department);

         allEmployee = new JButton("All Employees");
        allEmployee.setBounds(10,150,200,30); //add 40 to previous 'y'
        allEmployee.setBackground(Color.BLACK);
        allEmployee.setForeground(Color.WHITE);
//        allEmployee.addActionListener(this);
        add(allEmployee);

        //upon clicking cust info button, need to get all info by opening a new frame
         customers = new JButton("Customer info");
        customers.setBounds(10,190,200,30); //add 40 to previous 'y'
        customers.setBackground(Color.BLACK);
        customers.setForeground(Color.WHITE);
//        customers.addActionListener(this);
        add(customers);

         managerInfo = new JButton("Manager info");
        managerInfo.setBounds(10,230,200,30); //add 40 to previous 'y'
        managerInfo.setBackground(Color.BLACK);
        managerInfo.setForeground(Color.WHITE);
//        managerInfo.addActionListener(this);
        add(managerInfo);

         checkout = new JButton("Checkout");
        checkout.setBounds(10,270,200,30); //add 40 to previous 'y'
        checkout.setBackground(Color.BLACK);
        checkout.setForeground(Color.WHITE);
//        checkout.addActionListener(this);
        add(checkout);

         update = new JButton("Update Status");
        update.setBounds(10,310,200,30); //add 40 to previous 'y'
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
//        update.addActionListener(this);
        add(update);

         roomStatus = new JButton("Update Room Status");
        roomStatus.setBounds(10,350,200,30); //add 40 to previous 'y'
        roomStatus.setBackground(Color.BLACK);
        roomStatus.setForeground(Color.WHITE);
//        roomStatus.addActionListener(this);
        add(roomStatus);

         pickup = new JButton("Pickup Service");
        pickup.setBounds(10,390,200,30); //add 40 to previous 'y'
        pickup.setBackground(Color.BLACK);
        pickup.setForeground(Color.WHITE);
//        pickup.addActionListener(this);
        add(pickup);

         searchRoom = new JButton("Search Room");
        searchRoom.setBounds(10,430,200,30); //add 40 to previous 'y'
        searchRoom.setBackground(Color.BLACK);
        searchRoom.setForeground(Color.WHITE);
//        searchRoom.addActionListener(this);
        add(searchRoom);

         logout = new JButton("Logout");
        logout.setBounds(10,470,200,30); //add 40 to previous 'y'
        logout.setBackground(Color.BLACK);
        logout.setForeground(Color.WHITE);
//        logout.addActionListener(this);
        add(logout);

        bk = new JButton("Back");
        bk.setBounds(10,510,200,30); //add 40 to previous 'y'
        bk.setBackground(Color.BLACK);
        bk.setForeground(Color.WHITE);
//        bk.addActionListener(this);
        add(bk);

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
            department.addActionListener(listener);
            allEmployee.addActionListener(listener);
            customers.addActionListener(listener);
            managerInfo.addActionListener(listener);
            checkout.addActionListener(listener);
            roomStatus.addActionListener(listener);
            pickup.addActionListener(listener);
            update.addActionListener(listener);
            searchRoom.addActionListener(listener);
            logout.addActionListener(listener);
            bk.addActionListener(listener);


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
    private class ReceptionController implements ActionListener {
        private ReceptionModel model;
        private ReceptionView view;
        
        ReceptionController(ReceptionModel model, ReceptionView view) {
            this.model = model;
            this.view = view;
            view.addNextButtonListener(this);
        }
        
        public void actionPerformed(ActionEvent ae) {
          view.close();
            if(ae.getSource()==view.newCustomer){
            setVisible(false);
            new AddCustomer(hidi);
        } else if(ae.getSource()==view.rooms){
            setVisible(false);
            new Room(hidi);
        }
        else if(ae.getSource()==view.department){
            setVisible(false);
            new Department(hidi);
        }
        else if(ae.getSource()==view.allEmployee){
            setVisible(false);
            new EmployeeInfo(hidi);
        }
        else if(ae.getSource()==view.managerInfo){
            setVisible(false);
            new ManagerInfo(hidi);
        }
        else if(ae.getSource()==view.customers){
            setVisible(false);
            new CustomerInfo(hidi);
        }
        else if(ae.getSource()==view.searchRoom){
            setVisible(false);
            new SearchRoom(hidi);
        }
        else if(ae.getSource()==view.update){
            setVisible(false);
            new UpdateCheck(hidi);
        }
        else if(ae.getSource()==view.roomStatus){
            setVisible(false);
            new UpdateRoom(hidi);
        }
        else if(ae.getSource()==view.pickup){
            setVisible(false);
            new Pickup(hidi);
        }
        else if(ae.getSource()==view.checkout){
            setVisible(false);
            new Checkout(hidi);
        }
        else if(ae.getSource()==view.logout){
            JOptionPane.showMessageDialog(null,"Thank You!!");
            setVisible(false);
        }
        else if(ae.getSource()==view.bk){
            //JOptionPane.showMessageDialog(null,"Thank You!!");
            setVisible(false);
            //new Dashboard();
        }

        }
    }
    
     public Reception(String hidi) {
        ReceptionModel model = new ReceptionModel();
        ReceptionView view = new ReceptionView(hidi);
        ReceptionController controller = new ReceptionController(model, view);
    }
    
    public static void main(String[] args) {
        new Reception(hidi);
    }
}