///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package hotel.management.system;
//import java.awt.*;
//import javax.swing.*;
//import javax.swing.border.*;
//import java.awt.event.*;
//import java.sql.*;
//import java.util.*;
///**
// *
// * @author Umesh
// */
//public class AddDriver extends JFrame implements ActionListener{
//    public static String hidi;
//
//    JButton add,cancel;  // declare these globally coz iska values needs to be accesed later to put in DB
//    JTextField tfage,tfcompany,tfmodel,tfname,tflocation;
//    JComboBox typecombo,agecombo,availablecombo,gendercombo;
//    AddDriver(String hid){
//        hidi = hid;
//        getContentPane().setBackground(Color.WHITE);
//        setLayout(null);
//
//        JLabel heading = new JLabel("Add Drivers");
//        heading.setFont(new Font("Tahoma",Font.BOLD,18));
//        heading.setBounds(150,10,200,20);
//        add(heading);
//        //cretate "add room" label
//        JLabel lblroomno = new JLabel("Name: ");
//        lblroomno.setFont(new Font("Tahoma",Font.PLAIN,16));
//        lblroomno.setBounds( 60,70,120,30);
//        add(lblroomno);
//        //create text field to hold room no
//        tfname = new JTextField();
//        tfname.setBounds(200,80,150,30);
//        add(tfname);
//
//        //Available label txt field
//        JLabel lblage = new JLabel("Age : ");
//        lblage.setFont(new Font("Tahoma",Font.PLAIN,16));
//        lblage.setBounds( 60,110,120,30); //130>80+30(from previous)
//        add(lblage);
//
//        tfage = new JTextField();
//        tfage.setBounds(200,110,150,30);
//        add(tfage);
//
//
//        //Cleaning status label txt field
//        JLabel lblclean = new JLabel("Gender: ");
//        lblclean.setFont(new Font("Tahoma",Font.PLAIN,16));
//        lblclean.setBounds( 60,150,120,30); //180>130+30(from previous)
//        add(lblclean);
//        //create drop down:
//        String cleanOptions[]={"Male","Female"};
//        gendercombo = new JComboBox(cleanOptions);
//        gendercombo.setBounds(200,150,150,30);
//        gendercombo.setBackground(Color.WHITE);
//        add(gendercombo);
//
//        //cretate "Price" label
//        JLabel lblprice = new JLabel("Car Company: ");
//        lblprice.setFont(new Font("Tahoma",Font.PLAIN,16));
//        lblprice.setBounds( 60,190,120,30);
//        add(lblprice);
//        //create text field to hold room no
//        tfcompany = new JTextField();
//        tfcompany.setBounds(200,190,150,30);
//        add(tfcompany);
//
//        //Bed type status label txt field
//        JLabel lbltype = new JLabel("Car Model: ");
//        lbltype.setFont(new Font("Tahoma",Font.PLAIN,16));
//        lbltype.setBounds( 60,230,120,30); //180>130+30(from previous)
//        add(lbltype);
//        //create drop down:
//        tfmodel = new JTextField();
//        tfmodel.setBounds(200,230,150,30);
//        add(tfmodel);
//
//        JLabel lblavailable = new JLabel("Availability: ");
//        lblavailable.setFont(new Font("Tahoma",Font.PLAIN,16));
//        lblavailable.setBounds( 60,270,120,30); //180>130+30(from previous)
//        add(lblavailable);
//
//        String driverOptions[]={"Available","Busy"};
//        availablecombo = new JComboBox(driverOptions);
//        availablecombo.setBounds(200,270,150,30);
//        availablecombo.setBackground(Color.WHITE);
//        add(availablecombo);
//
//        JLabel lbllocation = new JLabel("Location: ");
//        lbllocation.setFont(new Font("Tahoma",Font.PLAIN,16));
//        lbllocation.setBounds( 60,310,120,30); //180>130+30(from previous)
//        add(lbllocation);
//        //create drop down:
//        tflocation = new JTextField();
//        tflocation.setBounds(200,310,150,30);
//        add(tflocation);
//
//        //add "Add" button
//        add = new JButton("Add Driver");
//        add.setForeground(Color.WHITE);
//        add.setBackground(Color.BLACK);
//        add.setBounds(60,370,130,30);
//        add.addActionListener(this);
//        add(add);
//
//        //add cancel button
//        cancel = new JButton("Cancel");
//        cancel.setForeground(Color.WHITE);
//        cancel.setBackground(Color.BLACK);
//        cancel.setBounds(230,370,130,30);
//        cancel.addActionListener(this);
//        add(cancel);
//
//        //add image background
//        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/eleven.jpg"));
//        Image i2 = i1.getImage().getScaledInstance(500,300,Image.SCALE_DEFAULT);
//        ImageIcon i3 = new ImageIcon(i2);
//        JLabel image = new JLabel(i3);
//        image.setBounds(400,30,500,300);
//        add(image);
//
//
//        setBounds(300,200,980,470);
//        setVisible(true);
//    }
//    public void actionPerformed(ActionEvent ae){
//        if(ae.getSource()==add){
//            String name = tfname.getText();
//            String age = tfage.getText(); //this is a drop down so returns object hence need to convert to string
//            String gender = (String) gendercombo.getSelectedItem();
//            String company = tfcompany.getText();
//            String brand = tfmodel.getText();
//            String available = (String) availablecombo.getSelectedItem();
//            String location = tflocation.getText();
//            Integer age1 = Integer.valueOf(age);
//            if (name.equals("") ){
//                JOptionPane.showMessageDialog(null,"Enter Name");
//                return;
//            }
//            if (age.equals("") || age1<18 ){
//                JOptionPane.showMessageDialog(null,"Enter Valid Age");
//                return;
//            }
//            if (location.equals("") ){
//                JOptionPane.showMessageDialog(null,"Enter Location");
//                return;
//            }
//            if (company.equals("") ){
//                JOptionPane.showMessageDialog(null,"Enter Car's Company");
//                return;
//            }
//            if (brand.equals("") ){
//                JOptionPane.showMessageDialog(null,"Enter model");
//                return;
//            }
//            //MySQL HIT :
//            try{
//                Conn conn = new Conn();
//                String str = "insert into driver values('"+name+"','"+age+"','"+gender+"','"+company+"','"+brand+"','"+available+"','"+location+"','"+hidi+"')";
//                conn.s.executeUpdate(str);
//
//                JOptionPane.showMessageDialog(null,"New Driver Added Successfully");
//                setVisible(false);
//            }catch(Exception e){
//                e.printStackTrace();
//            }
//        }else{ //clicked on cancel
//            setVisible(false);
//        }
//    }
//    public static void main(String[] args){
//        new AddDriver(hidi);
//    }
//}


package hotel.management.system;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

public class AddDriver extends JFrame{
    public static String hidi;
    private class AddDriverModel {
         public void connect(String name,String age,String gender,String company,String brand,String available,String location,String hidi){
             try{
                Conn conn = new Conn();
                String str = "insert into driver values('"+name+"','"+age+"','"+gender+"','"+company+"','"+brand+"','"+available+"','"+location+"','"+hidi+"')";
                conn.s.executeUpdate(str);

                JOptionPane.showMessageDialog(null,"New Driver Added Successfully");
                setVisible(false);
            }catch(Exception e){
                e.printStackTrace();
            }
         }
     }
     
     private class AddDriverView extends JFrame {
         JLabel image;
         JButton add,cancel;  // declare these globally coz iska values needs to be accesed later to put in DB
    JTextField tfage,tfcompany,tfmodel,tfname,tflocation;
    JComboBox typecombo,agecombo,availablecombo,gendercombo;
    AddDriverView(String hid){
        hidi = hid;
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("Add Drivers");
        heading.setFont(new Font("Tahoma",Font.BOLD,18));
        heading.setBounds(150,10,200,20);
        add(heading);
        //cretate "add room" label
        JLabel lblroomno = new JLabel("Name: ");
        lblroomno.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblroomno.setBounds( 60,70,120,30);
        add(lblroomno);
        //create text field to hold room no
        tfname = new JTextField();
        tfname.setBounds(200,80,150,30);
        add(tfname);

        //Available label txt field
        JLabel lblage = new JLabel("Age : ");
        lblage.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblage.setBounds( 60,110,120,30); //130>80+30(from previous)
        add(lblage);

        tfage = new JTextField();
        tfage.setBounds(200,110,150,30);
        add(tfage);


        //Cleaning status label txt field
        JLabel lblclean = new JLabel("Gender: ");
        lblclean.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblclean.setBounds( 60,150,120,30); //180>130+30(from previous)
        add(lblclean);
        //create drop down:
        String cleanOptions[]={"Male","Female"};
        gendercombo = new JComboBox(cleanOptions);
        gendercombo.setBounds(200,150,150,30);
        gendercombo.setBackground(Color.WHITE);
        add(gendercombo);

        //cretate "Price" label
        JLabel lblprice = new JLabel("Car Company: ");
        lblprice.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblprice.setBounds( 60,190,120,30);
        add(lblprice);
        //create text field to hold room no
        tfcompany = new JTextField();
        tfcompany.setBounds(200,190,150,30);
        add(tfcompany);

        //Bed type status label txt field
        JLabel lbltype = new JLabel("Car Model: ");
        lbltype.setFont(new Font("Tahoma",Font.PLAIN,16));
        lbltype.setBounds( 60,230,120,30); //180>130+30(from previous)
        add(lbltype);
        //create drop down:
        tfmodel = new JTextField();
        tfmodel.setBounds(200,230,150,30);
        add(tfmodel);

        JLabel lblavailable = new JLabel("Availability: ");
        lblavailable.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblavailable.setBounds( 60,270,120,30); //180>130+30(from previous)
        add(lblavailable);

        String driverOptions[]={"Available","Busy"};
        availablecombo = new JComboBox(driverOptions);
        availablecombo.setBounds(200,270,150,30);
        availablecombo.setBackground(Color.WHITE);
        add(availablecombo);

        JLabel lbllocation = new JLabel("Location: ");
        lbllocation.setFont(new Font("Tahoma",Font.PLAIN,16));
        lbllocation.setBounds( 60,310,120,30); //180>130+30(from previous)
        add(lbllocation);
        //create drop down:
        tflocation = new JTextField();
        tflocation.setBounds(200,310,150,30);
        add(tflocation);

        //add "Add" button
        add = new JButton("Add Driver");
        add.setForeground(Color.WHITE);
        add.setBackground(Color.BLACK);
        add.setBounds(60,370,130,30);
//        add.addActionListener(this);
        add(add);

        //add cancel button
        cancel = new JButton("Cancel");
        cancel.setForeground(Color.WHITE);
        cancel.setBackground(Color.BLACK);
        cancel.setBounds(230,370,130,30);
//        cancel.addActionListener(this);
        add(cancel);

        //add image background
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/eleven.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500,300,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        image = new JLabel(i3);
        image.setBounds(400,30,500,300);
        add(image);


        setBounds(300,200,980,470);
        setVisible(true);
    }
    public void addNextButtonListener(ActionListener listener) {
            add.addActionListener(listener);
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
    private class AddDriverController implements ActionListener {
        private AddDriverModel model;
        private AddDriverView view;
        
        AddDriverController(AddDriverModel model, AddDriverView view) {
            this.model = model;
            this.view = view;
            view.addNextButtonListener(this);
        }
        
        public void actionPerformed(ActionEvent ae) {
            view.close();
        if(ae.getSource()==view.add){
            String name = view.tfname.getText();
            String age = view.tfage.getText(); //this is a drop down so returns object hence need to convert to string
            String gender = (String) view.gendercombo.getSelectedItem();
            String company = view.tfcompany.getText();
            String brand = view.tfmodel.getText();
            String available = (String) view.availablecombo.getSelectedItem();
            String location = view.tflocation.getText();
            Integer age1 = Integer.valueOf(age);
            if (name.equals("") ){
                JOptionPane.showMessageDialog(null,"Enter Name");
                return;
            }
            if (age.equals("") || age1<18 ){
                JOptionPane.showMessageDialog(null,"Enter Valid Age");
                return;
            }
            if (location.equals("") ){
                JOptionPane.showMessageDialog(null,"Enter Location");
                return;
            }
            if (company.equals("") ){
                JOptionPane.showMessageDialog(null,"Enter Car's Company");
                return;
            }
            if (brand.equals("") ){
                JOptionPane.showMessageDialog(null,"Enter model");
                return;
            }
            
            model.connect(name,age,gender,company,brand,available,location,hidi);
            //MySQL HIT :
            
        }else{ //clicked on cancel
            view.close();
        }
        }
    }
    
    public AddDriver(String hid) {
        AddDriverModel model = new AddDriverModel();
        AddDriverView view = new AddDriverView(hid);
        AddDriverController controller = new AddDriverController(model, view);
    }
    
    public static void main(String[] args) {
        new AddDriver(hidi);
    }
}