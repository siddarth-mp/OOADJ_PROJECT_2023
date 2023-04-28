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
//public class AddRooms extends JFrame implements ActionListener{
//    public static String hidi;
//
//    JButton add,cancel;  // declare these globally coz iska values needs to be accesed later to put in DB
//    JTextField tfroom,tfprice;
//    JComboBox typecombo,cleancombo,availablecombo;
//    AddRooms(String hid){
//        hidi = hid;
//         getContentPane().setBackground(Color.WHITE);
//         setLayout(null);
//
//         JLabel heading = new JLabel("Add ROOMS");
//         heading.setFont(new Font("Tahoma",Font.BOLD,18));
//         heading.setBounds(150,20,200,20);
//         add(heading);
//        //cretate "add room" label
//        JLabel lblroomno = new JLabel("Room number: ");
//        lblroomno.setFont(new Font("Tahoma",Font.PLAIN,16));
//        lblroomno.setBounds( 60,80,120,30);
//        add(lblroomno);
//        //create text field to hold room no
//         tfroom = new JTextField();
//        tfroom.setBounds(200,80,150,30);
//        add(tfroom);
//
//        //Available label txt field
//        JLabel lblavailable = new JLabel("Available: ");
//        lblavailable.setFont(new Font("Tahoma",Font.PLAIN,16));
//        lblavailable.setBounds( 60,130,120,30); //130>80+30(from previous)
//        add(lblavailable);
//        //create drop down:
//        String availableOptions[]={"Available","Occupied"};
//        availablecombo = new JComboBox(availableOptions);
//        availablecombo.setBounds(200,130,150,30);
//         availablecombo.setBackground(Color.WHITE);
//         add(availablecombo);
//
//        //Cleaning status label txt field
//        JLabel lblclean = new JLabel("Cleaning Status: ");
//        lblclean.setFont(new Font("Tahoma",Font.PLAIN,16));
//        lblclean.setBounds( 60,180,120,30); //180>130+30(from previous)
//        add(lblclean);
//        //create drop down:
//        String cleanOptions[]={"Cleaned","To be Cleaned"};
//         cleancombo = new JComboBox(cleanOptions);
//        cleancombo.setBounds(200,180,150,30);
//        cleancombo.setBackground(Color.WHITE);
//        add(cleancombo);
//
//        //cretate "Price" label
//        JLabel lblprice = new JLabel("Price: ");
//        lblprice.setFont(new Font("Tahoma",Font.PLAIN,16));
//        lblprice.setBounds( 60,230,120,30);
//        add(lblprice);
//        //create text field to hold room no
//         tfprice = new JTextField();
//        tfprice.setBounds(200,230,150,30);
//        add(tfprice);
//
//        //Bed type status label txt field
//        JLabel lbltype = new JLabel("Bed Type: ");
//        lbltype.setFont(new Font("Tahoma",Font.PLAIN,16));
//        lbltype.setBounds( 60,280,120,30); //180>130+30(from previous)
//        add(lbltype);
//        //create drop down:
//        String typeOptions[]={"Single Bed","Double Bed","Pent House","Tree house","Boat House"};
//         typecombo = new JComboBox(typeOptions);
//        typecombo.setBounds(200,280,150,30);
//        typecombo.setBackground(Color.WHITE);
//        add(typecombo);
//
//        //add "Add" button
//         add = new JButton("Add Room");
//        add.setForeground(Color.WHITE);
//        add.setBackground(Color.BLACK);
//        add.setBounds(60,350,130,30);
//        add.addActionListener(this);
//        add(add);
//
//        //add cancel button
//         cancel = new JButton("Cancel");
//        cancel.setForeground(Color.WHITE);
//        cancel.setBackground(Color.BLACK);
//        cancel.setBounds(230,350,130,30);
//        cancel.addActionListener(this);
//        add(cancel);
//
//        //add image background
//        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/twelve.jpg"));
//        JLabel image = new JLabel(i1);
//        image.setBounds(400,30,500,300);
//        add(image);
//
//
//        setBounds(330,200,940,470);
//         setVisible(true);
//    }
//    public void actionPerformed(ActionEvent ae){
//        if(ae.getSource()==add){
//            String roomnumber = tfroom.getText();
//            String availability = (String) availablecombo.getSelectedItem(); //this is a drop down so returns object hence need to convert to string
//            String status = (String) cleancombo.getSelectedItem();
//            String price = tfprice.getText();
//            String type = (String) typecombo.getSelectedItem();
//            if (roomnumber.length()!=3 || roomnumber.equals("") ){
//                JOptionPane.showMessageDialog(null,"Room number should be 3 digits");
//                return;
//            }
//            if (price.equals("") ){
//                JOptionPane.showMessageDialog(null,"Enter Price");
//                return;
//            }
//            //MySQL HIT :
//            try{
//                Conn conn = new Conn();
//                String str = "insert into room values('"+roomnumber+"','"+availability+"','"+status+"','"+price+"','"+type+"','"+hidi+"')";
//                conn.s.executeUpdate(str);
//
//                JOptionPane.showMessageDialog(null,"New Room Added Successfully");
//                setVisible(false);
//            }catch(Exception e){
//                e.printStackTrace();
//            }
//        }else{ //clicked on cancel
//            setVisible(false);
//        }
//    }
//    public static void main(String[] args){
//         new AddRooms(hidi);
//    }
//}


package hotel.management.system;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

public class AddRooms extends JFrame{
    public static String hidi;
     private class AddRoomsModel {
         
     }
     
     private class AddRoomsView extends JFrame {
         
        JLabel image;
        JButton add,cancel;  // declare these globally coz iska values needs to be accesed later to put in DB
        JTextField tfroom,tfprice;
        JComboBox typecombo,cleancombo,availablecombo;
    AddRoomsView(String hid){
        hidi = hid;
         getContentPane().setBackground(Color.WHITE);
         setLayout(null);

         JLabel heading = new JLabel("Add ROOMS");
         heading.setFont(new Font("Tahoma",Font.BOLD,18));
         heading.setBounds(150,20,200,20);
         add(heading);
        //cretate "add room" label
        JLabel lblroomno = new JLabel("Room number: ");
        lblroomno.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblroomno.setBounds( 60,80,120,30);
        add(lblroomno);
        //create text field to hold room no
         tfroom = new JTextField();
        tfroom.setBounds(200,80,150,30);
        add(tfroom);

        //Available label txt field
        JLabel lblavailable = new JLabel("Available: ");
        lblavailable.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblavailable.setBounds( 60,130,120,30); //130>80+30(from previous)
        add(lblavailable);
        //create drop down:
        String availableOptions[]={"Available","Occupied"};
        availablecombo = new JComboBox(availableOptions);
        availablecombo.setBounds(200,130,150,30);
         availablecombo.setBackground(Color.WHITE);
         add(availablecombo);

        //Cleaning status label txt field
        JLabel lblclean = new JLabel("Cleaning Status: ");
        lblclean.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblclean.setBounds( 60,180,120,30); //180>130+30(from previous)
        add(lblclean);
        //create drop down:
        String cleanOptions[]={"Cleaned","To be Cleaned"};
         cleancombo = new JComboBox(cleanOptions);
        cleancombo.setBounds(200,180,150,30);
        cleancombo.setBackground(Color.WHITE);
        add(cleancombo);

        //cretate "Price" label
        JLabel lblprice = new JLabel("Price: ");
        lblprice.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblprice.setBounds( 60,230,120,30);
        add(lblprice);
        //create text field to hold room no
         tfprice = new JTextField();
        tfprice.setBounds(200,230,150,30);
        add(tfprice);

        //Bed type status label txt field
        JLabel lbltype = new JLabel("Bed Type: ");
        lbltype.setFont(new Font("Tahoma",Font.PLAIN,16));
        lbltype.setBounds( 60,280,120,30); //180>130+30(from previous)
        add(lbltype);
        //create drop down:
        String typeOptions[]={"Single Bed","Double Bed","Pent House","Tree house","Boat House"};
         typecombo = new JComboBox(typeOptions);
        typecombo.setBounds(200,280,150,30);
        typecombo.setBackground(Color.WHITE);
        add(typecombo);

        //add "Add" button
         add = new JButton("Add Room");
        add.setForeground(Color.WHITE);
        add.setBackground(Color.BLACK);
        add.setBounds(60,350,130,30);
//        add.addActionListener(this);
        add(add);

        //add cancel button
         cancel = new JButton("Cancel");
        cancel.setForeground(Color.WHITE);
        cancel.setBackground(Color.BLACK);
        cancel.setBounds(230,350,130,30);
//        cancel.addActionListener(this);
        add(cancel);

        //add image background
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/twelve.jpg"));
        image = new JLabel(i1);
        image.setBounds(400,30,500,300);
        add(image);


        setBounds(330,200,940,470);
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
    private class AddRoomsController implements ActionListener {
        private AddRoomsModel model;
        private AddRoomsView view;
        
        AddRoomsController(AddRoomsModel model, AddRoomsView view) {
            this.model = model;
            this.view = view;
            view.addNextButtonListener(this);
        }
        
        public void actionPerformed(ActionEvent ae) {
            
        if(ae.getSource()==view.add){
            String roomnumber = view.tfroom.getText();
            String availability = (String) view.availablecombo.getSelectedItem(); //this is a drop down so returns object hence need to convert to string
            String status = (String) view.cleancombo.getSelectedItem();
            String price = view.tfprice.getText();
            String type = (String) view.typecombo.getSelectedItem();
            if (roomnumber.length()!=3 || roomnumber.equals("") ){
                JOptionPane.showMessageDialog(null,"Room number should be 3 digits");
                return;
            }
            if (price.equals("") ){
                JOptionPane.showMessageDialog(null,"Enter Price");
                return;
            }
            //MySQL HIT :
            try{
                Conn conn = new Conn();
                String str = "insert into room values('"+roomnumber+"','"+availability+"','"+status+"','"+price+"','"+type+"','"+hidi+"')";
                conn.s.executeUpdate(str);

                JOptionPane.showMessageDialog(null,"New Room Added Successfully");
                view.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }else{ //clicked on cancel
            view.close();
        }
        }
    }
    
    public AddRooms(String hid) {
        AddRoomsModel model = new AddRoomsModel();
        AddRoomsView view = new AddRoomsView(hid);
        AddRoomsController controller = new AddRoomsController(model, view);
    }
    
    public static void main(String[] args) {
        new AddRooms(hidi);
    }

}
