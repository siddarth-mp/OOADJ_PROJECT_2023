//package hotel.management.system;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.sql.ResultSet;
//
//public class Adminview extends JFrame implements ActionListener {
//    Choice croom;
//    JButton ack,addh,back,viewhotel,deletehotel,htlanal;
//    Adminview(){
//        //see hotel reports and choose a hotel to proceed , add hotels
//        getContentPane().setBackground(Color.WHITE);
//        setLayout(null);
//
//        JLabel text = new JLabel("ADMIN VIEW");
//        text.setBounds(150,20,180,30);
//        text.setForeground(Color.BLUE);
//        text.setFont(new Font("Tahoma",Font.BOLD,20));
//        add(text);
//
//        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/hms.jpg"));
//        Image i2 = i1.getImage().getScaledInstance(350,300,Image.SCALE_DEFAULT); // resize the image previously it was enlarged
//        ImageIcon i3 = new ImageIcon(i2);
//        JLabel image = new JLabel(i3);
//        image.setBounds(430,20,350,300); //where to place the image (coords)
//        add(image);
//
//        JLabel lblroom = new JLabel("Available Hotels : ");
//        lblroom.setBounds(10,80,200,25);
//        lblroom.setFont(new Font("Raleway",Font.PLAIN,20));
//        add(lblroom);
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
//        croom .setBounds(230,80,150,25);
//        add(croom);
//
//        addh = new JButton("Add Hotel");
//        addh.setBackground(Color.BLACK);
//        addh.setForeground(Color.WHITE);
//        addh.setBounds(10,250,120,30);
//        addh.addActionListener(this);
//        add(addh);
//
//        viewhotel = new JButton("View Hotel");
//        viewhotel.setBackground(Color.BLACK);
//        viewhotel.setForeground(Color.WHITE);
//        viewhotel.setBounds(150,250,120,30);
//        viewhotel.addActionListener(this);
//        add(viewhotel);
//
//        deletehotel = new JButton("Delete Hotel");
//        deletehotel.setBackground(Color.BLACK);
//        deletehotel.setForeground(Color.WHITE);
//        deletehotel.setBounds(300,250,120,30);
//        deletehotel.addActionListener(this);
//        add(deletehotel);
//
//        htlanal = new JButton("View Hotels Analysis");
//        htlanal.setBackground(Color.BLACK);
//        htlanal.setForeground(Color.WHITE);
//        htlanal.setBounds(20,300,170,30);
//        htlanal.addActionListener(this);
//        add(htlanal);
//
//        back = new JButton("Back");
//        back.setBackground(Color.BLACK);
//        back.setForeground(Color.WHITE);
//        back.setBounds(200,300,70,30);
//        back.addActionListener(this);
//        add(back);
//
//        ack = new JButton("Resolve issue");
//        ack.setBackground(Color.BLACK);
//        ack.setForeground(Color.WHITE);
//        ack.setBounds(290,300,120,30);
//        ack.addActionListener(this);
//        add(ack);
//
//
//
//
//        setBounds(600,600,800,400);
//        setVisible(true);
//    }
//    public void actionPerformed(ActionEvent ae){
//        if(ae.getSource()==addh){
//            setVisible(false);
//            new Addhotel();
//        }
//        else if(ae.getSource()==viewhotel){
//            String hid = croom.getSelectedItem();
//            if(hid.equals("")){JOptionPane.showMessageDialog(null,"Choose a Hotel to proceed");}
//            else{
//                try{
//                    Conn c = new Conn();
//                    c.s.executeQuery("select * from hotels where hotel_id = '"+hid+"'");
//                    setVisible(false);
//                    new Dashboard(hid);
//                }catch(Exception e){e.printStackTrace();}
//            }
//        }
//        else if(ae.getSource()==deletehotel){
//            String hid = croom.getSelectedItem();
//            try{
//                Conn c = new Conn();
//                c.s.executeUpdate("delete from hotels where hotel_id = '"+hid+"'");
//                JOptionPane.showMessageDialog(null,"Hotel deleted Successfully!!");
//                setVisible(false);
//                new Adminview();
//            }catch (Exception e){e.printStackTrace();}
//        }
//        else if(ae.getSource()==htlanal){
//
//            new Htlsanalysis();
//        }
//        else if(ae.getSource()==back){
//            setVisible(false);
//            new Start();
//        }
//        else if(ae.getSource()==ack){
//         setVisible(false);
//         new Resolveissue();
//        }
//
//    }
//
//    public static void main(String[] args){
//        new Adminview();
//}
//
//}

package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Adminview extends JFrame{
    private class AdminviewModel {
        public void connect1(String hid)
        {
            try{
                    Conn c = new Conn();
                    c.s.executeQuery("select * from hotels where hotel_id = '"+hid+"'");
                    setVisible(false);
                    new Dashboard(hid);
                }catch(Exception e){e.printStackTrace();}
        }
        
        public void connect2(String hid)
        {
            try{
                Conn c = new Conn();
                c.s.executeUpdate("delete from hotels where hotel_id = '"+hid+"'");
                JOptionPane.showMessageDialog(null,"Hotel deleted Successfully!!");
                setVisible(false);
                new Adminview();
            }catch (Exception e){e.printStackTrace();}
        }
    }
    private class AdminviewView extends JFrame {
        Choice croom;
    JButton ack,addh,back,viewhotel,deletehotel,htlanal;
    JLabel image;
    AdminviewView(){
        //see hotel reports and choose a hotel to proceed , add hotels
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel text = new JLabel("ADMIN VIEW");
        text.setBounds(150,20,180,30);
        text.setForeground(Color.BLUE);
        text.setFont(new Font("Tahoma",Font.BOLD,20));
        add(text);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/hms.jpg"));
        Image i2 = i1.getImage().getScaledInstance(350,300,Image.SCALE_DEFAULT); // resize the image previously it was enlarged
        ImageIcon i3 = new ImageIcon(i2);
        image = new JLabel(i3);
        image.setBounds(430,20,350,300); //where to place the image (coords)
        add(image);

        JLabel lblroom = new JLabel("Available Hotels : ");
        lblroom.setBounds(10,80,200,25);
        lblroom.setFont(new Font("Raleway",Font.PLAIN,20));
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
        croom .setBounds(230,80,150,25);
        add(croom);

        addh = new JButton("Add Hotel");
        addh.setBackground(Color.BLACK);
        addh.setForeground(Color.WHITE);
        addh.setBounds(10,250,120,30);
//        addh.addActionListener(this);
        add(addh);

        viewhotel = new JButton("View Hotel");
        viewhotel.setBackground(Color.BLACK);
        viewhotel.setForeground(Color.WHITE);
        viewhotel.setBounds(150,250,120,30);
//        viewhotel.addActionListener(this);
        add(viewhotel);

        deletehotel = new JButton("Delete Hotel");
        deletehotel.setBackground(Color.BLACK);
        deletehotel.setForeground(Color.WHITE);
        deletehotel.setBounds(300,250,120,30);
//        deletehotel.addActionListener(this);
        add(deletehotel);

        htlanal = new JButton("View Hotels Analysis");
        htlanal.setBackground(Color.BLACK);
        htlanal.setForeground(Color.WHITE);
        htlanal.setBounds(20,300,170,30);
//        htlanal.addActionListener(this);
        add(htlanal);

        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(200,300,70,30);
//        back.addActionListener(this);
        add(back);

        ack = new JButton("Resolve issue");
        ack.setBackground(Color.BLACK);
        ack.setForeground(Color.WHITE);
        ack.setBounds(290,300,120,30);
//        ack.addActionListener(this);
        add(ack);




        setBounds(600,600,800,400);
        setVisible(true);
    }
    public void addNextButtonListener(ActionListener listener) {
            addh.addActionListener(listener);
            viewhotel.addActionListener(listener);
            deletehotel.addActionListener(listener);
            htlanal.addActionListener(listener);
            back.addActionListener(listener);
            ack.addActionListener(listener);

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
    private class AdminviewController implements ActionListener {
        private AdminviewModel model;
        private AdminviewView view;
        
        AdminviewController(AdminviewModel model, AdminviewView view) {
            this.model = model;
            this.view = view;
            view.addNextButtonListener(this);
        }
        
        public void actionPerformed(ActionEvent ae) {
            
        if(ae.getSource()==view.addh){
            view.close();
            new Addhotel();
        }
        else if(ae.getSource()==view.viewhotel){
            view.close();
            String hid = view.croom.getSelectedItem();
            if(hid.equals("")){JOptionPane.showMessageDialog(null,"Choose a Hotel to proceed");}
            else{
                model.connect1(hid);
                
            }
        }
        else if(ae.getSource()==view.deletehotel){
            view.close();
            String hid = view.croom.getSelectedItem();
            model.connect2(hid);
            
        }
        else if(ae.getSource()==view.htlanal){

            new Htlsanalysis();
        }
        else if(ae.getSource()==view.back){
           view.close();
            new Start();
        }
        else if(ae.getSource()==view.ack){
         view.close();
         new ResolveIssue();
        }
        }
    }
    
    public Adminview() {
        AdminviewModel model = new AdminviewModel();
        AdminviewView view = new AdminviewView();
        AdminviewController controller = new AdminviewController(model, view);
    }
    
    public static void main(String[] args) {
        new Adminview();
    }
}