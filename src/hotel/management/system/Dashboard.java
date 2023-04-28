///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package hotel.management.system;
//import java.awt.*;
//import javax.swing.*;
//import java.awt.event.*;
//import java.sql.ResultSet;
///**
// *
// * @author Umesh
// */
//public class Dashboard extends JFrame implements ActionListener{
//    public static String hidi;
//    JLabel lblname;
//    Dashboard(String hid){
//        hidi = hid;
//        setLayout(null);
//        setBounds(0,0,1550,1000); //start from top left origin and span across breadth,heght of window screen
//
//        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/third.jpg"));
//        Image i2 = i1.getImage().getScaledInstance(1950, 1000,Image.SCALE_DEFAULT); //scale the image
//        //add image to frame, add i2 to i3:
//        ImageIcon i3 = new ImageIcon(i2);
//        JLabel image = new JLabel(i3); //create a JLabel
//        image.setBounds(0, 0, 1950, 1000);
//        add(image);
//
//        //add text on the image
//        JLabel text = new JLabel("HOTEL :");
//        text.setBounds(400,80,1000,50);
//        text.setForeground(Color.BLACK);
//        text.setFont(new Font("Tahoma",Font.PLAIN,46));
//        image.add(text);
//
//        lblname = new JLabel();
//        lblname.setForeground(Color.BLACK);
//        lblname.setFont(new Font("Tahoma",Font.PLAIN,46));
//        lblname.setBounds(600,80,500,50);
//        image.add(lblname);
//
//
//        try{
//            Conn c = new Conn();
//            ResultSet rs = c.s.executeQuery("select * from hotels where hotel_id = '"+hidi+"' ");
//            while(rs.next()) {
//                String nm = rs.getString("hotel_name");
//                lblname.setText("" + nm);
//            }
//
//        }catch(Exception e){e.printStackTrace();}
//
//
//
//        //create a MENU-BAR at top left
//        JMenuBar mb = new JMenuBar();
//        mb.setBounds(0,0,1550,30);
//        image.add(mb);
//
//        //create a text field for menu bar at top left
//        JMenu hotel = new JMenu("HOTEL MANAGEMENT");
//        hotel.setForeground(Color.RED);
//        mb.add(hotel);
//
//        //after clicking "HOTEL MANAGEMENT" a drop down menu (Menuitems) shuld appear:
//        JMenuItem reception=new JMenuItem("RECEPTION");
//        //menuitem is added to menu(hotel), menu is added to menubar
//        reception.addActionListener(this);
//        hotel.add(reception);
//
//        JMenuItem analysis=new JMenuItem("VIEW CUSTOMER ANALYSIS");
//        //menuitem is added to menu(hotel), menu is added to menubar
//        analysis.addActionListener(this);
//        hotel.add(analysis);
//
//        JMenuItem roomanalysis=new JMenuItem("VIEW ROOM ANALYSIS");
//        //menuitem is added to menu(hotel), menu is added to menubar
//        roomanalysis.addActionListener(this);
//        hotel.add(roomanalysis);
//
//        JMenuItem empanalysis=new JMenuItem("VIEW EMPLOYEE ANALYSIS");
//        //menuitem is added to menu(hotel), menu is added to menubar
//        empanalysis.addActionListener(this);
//        hotel.add(empanalysis);
//
//        JMenuItem avl=new JMenuItem("AVAILABILITY");
//        //menuitem is added to menu(hotel), menu is added to menubar
//        avl.addActionListener(this);
//        hotel.add(avl);
//
//
//        //create a text field for admin menu bar at top left
//        JMenu admin = new JMenu("ADMIN");
//        hotel.setForeground(Color.BLUE);
//        mb.add(admin);
//
//        JMenuItem addemployee = new JMenuItem("ADD EMPLOYEE");
//        addemployee.addActionListener(this);
//        admin.add(addemployee);
//
//        JMenuItem addrooms = new JMenuItem("ADD ROOMS");
//        addrooms.addActionListener(this);
//        admin.add(addrooms);
//
//        JMenuItem adddrivers = new JMenuItem("ADD DRIVERS");
//        adddrivers.addActionListener(this);
//        admin.add(adddrivers);
//
//
//
//        setVisible(true); //setbounds,etvisible are available in jframe which is of javax swing
//
//
//    }
//
//    public void actionPerformed(ActionEvent ae){
//        if(ae.getActionCommand().equals("ADD EMPLOYEE")){
//            new AddEmployee(hidi);
//        }
//        else if(ae.getActionCommand().equals("ADD ROOMS")){
//            new AddRooms(hidi);
//        }
//        else if(ae.getActionCommand().equals("ADD DRIVERS")){
//            new AddDriver(hidi);
//        }
//        else if(ae.getActionCommand().equals("RECEPTION")){
//            new Reception(hidi);
//        }
//        else if(ae.getActionCommand().equals("VIEW CUSTOMER ANALYSIS")){
//            new Analysis(hidi);
//        }
//        else if(ae.getActionCommand().equals("VIEW ROOM ANALYSIS")){
//            new Pieroomanalysis(hidi);
//        }
//        else if(ae.getActionCommand().equals("VIEW EMPLOYEE ANALYSIS")){
//            new histogram(hidi);
//        }
//        else if(ae.getActionCommand().equals("AVAILABILITY")){
//            new HotelRoomView(hidi);
//        }
//    }
//
//    public static void main(String[] args) {
//        new Dashboard(hidi);
//    }
//}

package hotel.management.system;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class Dashboard extends JFrame {
     public static String hidi;
     private class DashboardModel {
         
     }
     
     private class DashboardView extends JFrame {
         JLabel lblname,image;
         JMenuItem reception,analysis,roomanalysis,empanalysis,avl,admin,addemployee,addrooms,adddrivers;
        DashboardView(String hid){
        hidi = hid;
        setLayout(null);
        setBounds(0,0,1550,1000); //start from top left origin and span across breadth,heght of window screen

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/third.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1950, 1000,Image.SCALE_DEFAULT); //scale the image
        //add image to frame, add i2 to i3:
        ImageIcon i3 = new ImageIcon(i2);
        image = new JLabel(i3); //create a JLabel
        image.setBounds(0, 0, 1950, 1000);
        add(image);

        //add text on the image
        JLabel text = new JLabel("HOTEL :");
        text.setBounds(400,80,1000,50);
        text.setForeground(Color.BLACK);
        text.setFont(new Font("Tahoma",Font.PLAIN,46));
        image.add(text);

        lblname = new JLabel();
        lblname.setForeground(Color.BLACK);
        lblname.setFont(new Font("Tahoma",Font.PLAIN,46));
        lblname.setBounds(600,80,500,50);
        image.add(lblname);


        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from hotels where hotel_id = '"+hidi+"' ");
            while(rs.next()) {
                String nm = rs.getString("hotel_name");
                lblname.setText("" + nm);
            }

        }catch(Exception e){e.printStackTrace();}



        //create a MENU-BAR at top left
        JMenuBar mb = new JMenuBar();
        mb.setBounds(0,0,1550,30);
        image.add(mb);

        //create a text field for menu bar at top left
        JMenu hotel = new JMenu("HOTEL MANAGEMENT");
        hotel.setForeground(Color.RED);
        mb.add(hotel);

        //after clicking "HOTEL MANAGEMENT" a drop down menu (Menuitems) shuld appear:
        reception=new JMenuItem("RECEPTION");
        //menuitem is added to menu(hotel), menu is added to menubar
//        reception.addActionListener(this);
        hotel.add(reception);

        analysis=new JMenuItem("VIEW CUSTOMER ANALYSIS");
        //menuitem is added to menu(hotel), menu is added to menubar
//        analysis.addActionListener(this);
        hotel.add(analysis);

        roomanalysis=new JMenuItem("VIEW ROOM ANALYSIS");
        //menuitem is added to menu(hotel), menu is added to menubar
//        roomanalysis.addActionListener(this);
        hotel.add(roomanalysis);

        empanalysis=new JMenuItem("VIEW EMPLOYEE ANALYSIS");
        //menuitem is added to menu(hotel), menu is added to menubar
//        empanalysis.addActionListener(this);
        hotel.add(empanalysis);

        avl=new JMenuItem("AVAILABILITY");
        //menuitem is added to menu(hotel), menu is added to menubar
//        avl.addActionListener(this);
        hotel.add(avl);


        //create a text field for admin menu bar at top left
        JMenu admin = new JMenu("ADMIN");
        hotel.setForeground(Color.BLUE);
        mb.add(admin);

        addemployee = new JMenuItem("ADD EMPLOYEE");
//        addemployee.addActionListener(this);
        admin.add(addemployee);

        addrooms = new JMenuItem("ADD ROOMS");
//        addrooms.addActionListener(this);
        admin.add(addrooms);

        adddrivers = new JMenuItem("ADD DRIVERS");
//        adddrivers.addActionListener(this);
        admin.add(adddrivers);



        setVisible(true); //setbounds,etvisible are available in jframe which is of javax swing
    }
        public void addNextButtonListener(ActionListener listener) {
            reception.addActionListener(listener);
            analysis.addActionListener(listener);
            roomanalysis.addActionListener(listener);
            empanalysis.addActionListener(listener);
            avl.addActionListener(listener);
            addemployee.addActionListener(listener);
            addrooms.addActionListener(listener);
            adddrivers.addActionListener(listener);

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
    private class DashboardController implements ActionListener {
        private DashboardModel model;
        private DashboardView view;
        
        DashboardController(DashboardModel model, DashboardView view) {
            this.model = model;
            this.view = view;
            view.addNextButtonListener(this);
        }
        
        public void actionPerformed(ActionEvent ae) {
            
        if(ae.getActionCommand().equals("ADD EMPLOYEE")){
            new AddEmployee(hidi);
        }
        else if(ae.getActionCommand().equals("ADD ROOMS")){
            new AddRooms(hidi);
        }
        else if(ae.getActionCommand().equals("ADD DRIVERS")){
            new AddDriver(hidi);
        }
        else if(ae.getActionCommand().equals("RECEPTION")){
            new Reception(hidi);
        }
        else if(ae.getActionCommand().equals("VIEW CUSTOMER ANALYSIS")){
            new Analysis(hidi);
        }
        else if(ae.getActionCommand().equals("VIEW ROOM ANALYSIS")){
            new Pieroomanalysis(hidi);
        }
        else if(ae.getActionCommand().equals("VIEW EMPLOYEE ANALYSIS")){
            new histogram(hidi);
        }
        else if(ae.getActionCommand().equals("AVAILABILITY")){
            new HotelRoomView(hidi);
        }
        }
    }
    
    public Dashboard(String hid) {
        DashboardModel model = new DashboardModel();
        DashboardView view = new DashboardView(hid);
        DashboardController controller = new DashboardController(model, view);
    }
    
    public static void main(String[] args) {
        new Dashboard(hidi);
    }
}