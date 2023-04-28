//package hotel.management.system;
//import java.awt.*;
//import javax.swing.*;
//import java.awt.event.*;
//import java.sql.ResultSet;
//
//public class usrview extends JFrame implements ActionListener{
//    JLabel lblname;
//    public static String hidi;
//    usrview(String hid){
//        hidi = hid;
//        setBounds(0,0,1550,1000); //start from top left origin and span across breadth,heght of window screen
//
//        setLayout(null);//by default set this to null, later we are altering/setting our new layout
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
//        //create a MENU-BAR at top left
//        JMenuBar mb = new JMenuBar();
//        mb.setBounds(0,0,1550,30);
//        image.add(mb);
//
//        //create a text field for menu bar at top left
//        JMenu hotel = new JMenu("HOTEL MANAGEMENT");
//        hotel.setForeground(Color.BLACK);
//        mb.add(hotel);
//
//        JMenu Back = new JMenu("BACK");
//        Back.setForeground(Color.BLACK);
//        mb.add(Back);
//
//        JMenuItem start=new JMenuItem("TO START");
//        //menuitem is added to menu(hotel), menu is added to menubar
//        start.addActionListener(this);
//        Back.add(start);
//
//        JMenuItem lgn=new JMenuItem("TO LOGIN");
//        //menuitem is added to menu(hotel), menu is added to menubar
//        lgn.addActionListener(this);
//        Back.add(lgn);
//
//        //after clicking "HOTEL MANAGEMENT" a drop down menu (Menuitems) shuld appear:
//        JMenuItem reception=new JMenuItem("RECEPTION");
//        //menuitem is added to menu(hotel), menu is added to menubar
//        reception.addActionListener(this);
//        hotel.add(reception);
//
//
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
//        setVisible(true); //setbounds,etvisible are available in jframe which is of javax swing
//
//
//    }
//
//    public void actionPerformed(ActionEvent ae){
//        if(ae.getActionCommand().equals("RECEPTION")){
//            new Reception1(hidi);
//        }
//        else if(ae.getActionCommand().equals("VIEW ROOM ANALYSIS")){
//            new Pieroomanalysis(hidi);
//        }
//        else if(ae.getActionCommand().equals("TO START")){
//            new Start();
//        }
//        else if(ae.getActionCommand().equals("TO LOGIN")){
//            new User();
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
//        new usrview(hidi);
//}
//}


package hotel.management.system;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.ResultSet;


public class usrview extends JFrame{
     public static String hidi;
    private class usrviewModel {
        
    }
    
    private class usrviewView extends JFrame {
        JLabel lblname,image;
        JMenuItem start,lgn,reception,roomanalysis,empanalysis,avl;
   
        usrviewView(String hid){
        hidi = hid;
        setBounds(0,0,1550,1000); //start from top left origin and span across breadth,heght of window screen

        setLayout(null);//by default set this to null, later we are altering/setting our new layout
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
        hotel.setForeground(Color.BLACK);
        mb.add(hotel);

        JMenu Back = new JMenu("BACK");
        Back.setForeground(Color.BLACK);
        mb.add(Back);

        start=new JMenuItem("TO START");
        //menuitem is added to menu(hotel), menu is added to menubar
//        start.addActionListener(this);
        Back.add(start);

        lgn=new JMenuItem("TO LOGIN");
        //menuitem is added to menu(hotel), menu is added to menubar
//        lgn.addActionListener(this);
        Back.add(lgn);

        //after clicking "HOTEL MANAGEMENT" a drop down menu (Menuitems) shuld appear:
        reception=new JMenuItem("RECEPTION");
        //menuitem is added to menu(hotel), menu is added to menubar
//        reception.addActionListener(this);
        hotel.add(reception);



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


        setVisible(true); //setbounds,etvisible are available in jframe which is of javax swing

    }
     public void addNextButtonListener(ActionListener listener) {
            start.addActionListener(listener);
            lgn.addActionListener(listener);
            reception.addActionListener(listener);
            roomanalysis.addActionListener(listener);
            empanalysis.addActionListener(listener);
            avl.addActionListener(listener);
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
    private class usrviewController implements ActionListener {
        private usrviewModel model;
        private usrviewView view;
        
        usrviewController(usrviewModel model, usrviewView view) {
            this.model = model;
            this.view = view;
            view.addNextButtonListener(this);
        }
        
        public void actionPerformed(ActionEvent ae) {
            if(ae.getActionCommand().equals("RECEPTION")){
            new Reception1(hidi);
        }
        else if(ae.getActionCommand().equals("VIEW ROOM ANALYSIS")){
            new Pieroomanalysis(hidi);
        }
        else if(ae.getActionCommand().equals("TO START")){
            view.close();
            new Start();
        }
        else if(ae.getActionCommand().equals("TO LOGIN")){
            view.close();
            new User();
        }
        else if(ae.getActionCommand().equals("VIEW EMPLOYEE ANALYSIS")){
            new histogram(hidi);
        }
        else if(ae.getActionCommand().equals("AVAILABILITY")){
            new HotelRoomView(hidi);
        }

        }
    }
    
    public usrview(String hidi) {
        usrviewModel model = new usrviewModel();
        usrviewView view = new usrviewView(hidi);
        usrviewController controller = new usrviewController(model, view);
    }
    
    public static void main(String[] args) {
        new usrview(hidi);
    }
}

