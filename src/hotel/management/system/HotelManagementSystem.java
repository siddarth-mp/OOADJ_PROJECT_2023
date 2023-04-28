/////*
//// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
//// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
//// */
//package hotel.management.system;
//import javax.swing.*; 
//import java.awt.*; 
//import java.awt.event.*;
//import java.sql.*;
//
//public class HotelManagementSystem extends JFrame implements ActionListener{
//
//   HotelManagementSystem() { 
//        setBounds(100,100,1366,565);
//        setLayout(null);
//        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/first.jpg")); //img's path shuld be given in relative to hotel.mgmt.system pakage
//        JLabel image = new JLabel(i1); // to add img / to write onto to frame need to use this class and create obj
//        image.setBounds(0, 0, 1366,565); // frame creation wrto frame size
//        add(image); // to add image to this compo/obj'image' use add method
//     
//        JLabel text = new JLabel("HOTEL MANAGEMENT SYSTEM"); //create txt compo
//        text.setBounds(20,430,1000,90);
//        text.setForeground(Color.white);
//        text.setFont(new Font("serif",Font.PLAIN,50));
//        image.add(text); //apply text upon img compo
//        
//        //next button creation
//        JButton next = new JButton("Next");
//        next.setBounds(1150,450,150,50);
//        image.add(next);
//        next.setBackground(Color.WHITE); //white button,pink text
//        next.setForeground(Color.MAGENTA); //color of "next"
//        //where to listen the clicking/event:
//        next.addActionListener(this);
//        next.setFont(new Font("serif",Font.PLAIN,24));
//        
//        setVisible(true); // by default frame is not visible, so make visibility true
//      
//        while(true){ //actually label on image was hiding/showing toggling continously, so to tackle this, use multithreading
//            text.setVisible(false); //1st text shuld be invisible for 5000ms
//            try{
//                Thread.sleep(500);
//                  
//            }
//            catch (Exception e){
//                e.printStackTrace();// to catch errors
//            }
//            text.setVisible(true); //if text is invisible then after 5 sec,turn it to visible; to avoid to going back to hiding state use other try,catch block:
//            try{
//                Thread.sleep(500);
//                  
//            }
//            catch (Exception e){
//                e.printStackTrace();// to catch errors
//            }
//            
//            
//        }
//    }
//    public void actionPerformed(ActionEvent ae){ //overriding fns of ActionListener abstract interface
//            // write code here to handle wat to do upon clicking 'next'
//            setVisible(false); //hide home screen frame
//            new Start(); // open up login frame
//    }    
//    public static void main(String[] args) {
//        // TODO code application logic here
//        new HotelManagementSystem();
//    }
//}

package hotel.management.system;

import javax.swing.*; 
import java.awt.*; 
import java.awt.event.*;
import java.sql.*;

public class HotelManagementSystem extends JFrame {

    // Model
    private class HotelModel {
        // You could add any necessary fields and methods here for the model
    }
    
    // View
    private class HotelView extends JFrame {
        private JLabel image;
        private JLabel text;
        private JButton next;
        
        HotelView() {
            setBounds(100, 100, 1366, 565);
            setLayout(null);
            
            ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/first.jpg"));
            image = new JLabel(i1);
            image.setBounds(0, 0, 1366, 565);
            add(image);
            
            text = new JLabel("HOTEL MANAGEMENT SYSTEM");
            text.setBounds(20, 430, 1000, 90);
            text.setForeground(Color.WHITE);
            text.setFont(new Font("serif", Font.PLAIN, 50));
            image.add(text);
            
            next = new JButton("Next");
            next.setBounds(1150, 450, 150, 50);
            image.add(next);
            next.setBackground(Color.WHITE);
            next.setForeground(Color.MAGENTA);
            next.setFont(new Font("serif", Font.PLAIN, 24));
            
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setVisible(true);
        }
        
        public void addNextButtonListener(ActionListener listener) {
            next.addActionListener(listener);
        }
        
        public void showText() {
            text.setVisible(true);
        }
        
        public void hideText() {
            text.setVisible(false);
        }
        
        public void close() {
            setVisible(false);
            dispose();
        }
    }
    
    // Controller
    private class HotelController implements ActionListener {
        private HotelModel model;
        private HotelView view;
        
        HotelController(HotelModel model, HotelView view) {
            this.model = model;
            this.view = view;
            view.addNextButtonListener(this);
            
            // Thread to toggle label visibility
            new Thread(new Runnable() {
                public void run() {
                    while(true) {
                        view.hideText();
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        view.showText();
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();
        }
        
        public void actionPerformed(ActionEvent ae) {
            view.close();
            new Start();
        }
    }
    
    public HotelManagementSystem() {
        HotelModel model = new HotelModel();
        HotelView view = new HotelView();
        HotelController controller = new HotelController(model, view);
    }
    
    public static void main(String[] args) {
        new HotelManagementSystem();
    }
}
