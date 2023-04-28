//package hotel.management.system;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.sql.ResultSet;
//
//public class Resolveissue extends JFrame implements ActionListener {
//    Choice croom;
//    JRadioButton rmale,rfemale;
//    JButton delt,det,Resolve,back;
//
//    JTextField tfst,tfde;
//    Resolveissue(){
//        //see hotel reports and choose a hotel to proceed , add hotels
//        getContentPane().setBackground(Color.WHITE);
//        setLayout(null);
//
//        JLabel text = new JLabel("Resolve Issue");
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
//        JLabel lblroom = new JLabel("Available Issue Id's : ");
//        lblroom.setBounds(10,80,200,25);
//        lblroom.setFont(new Font("Raleway",Font.PLAIN,20));
//        add(lblroom);
//
//        croom = new Choice();
//
//        try{
//            Conn conn = new Conn();
//            //Hit MySQL:
//            String query = "select * from Issue";
//            ResultSet rs = conn.s.executeQuery(query);// this has entire table
//            while(rs.next()){
//                //i need to add col name of result set to croom:
//                croom.add(rs.getString("issue_id"));
//            }
//        }catch(Exception e){e.printStackTrace();}
//        croom .setBounds(230,80,150,25);
//        add(croom);
//
//        JLabel lblstn = new JLabel("Set Status : ");
//        lblstn.setBounds(10,220,150,25);
//        lblstn.setFont(new Font("Raleway",Font.PLAIN,20));
//        add(lblstn);
//
//        rmale = new JRadioButton("Resolved");
//        rmale.setBackground(Color.WHITE);
//        rmale.setBounds(170,220,100,30);
//        add(rmale);
//
//        rfemale = new JRadioButton("To be Resolved");
//        rfemale.setBackground(Color.WHITE);
//        rfemale.setBounds(280,220,150,25);//why 270? coz right side of male option, we need female btn
//        add(rfemale);
//
//        JLabel lblst = new JLabel(" Old Status : ");
//        lblst.setBounds(10,125,150,25);
//        lblst.setFont(new Font("Raleway",Font.PLAIN,20));
//        add(lblst);
//
//        tfst = new JTextField();
//        tfst.setBounds(180,125,100,30);
//        add(tfst);
//
//        JLabel lblde = new JLabel("Description : ");
//        lblde.setBounds(10,175,200,25);
//        lblde.setFont(new Font("Raleway",Font.PLAIN,20));
//        add(lblde);
//
//        tfde = new JTextField();
//        tfde.setBounds(180,175,100,30);
//        add(tfde);
//
//        Resolve = new JButton("Resolve");
//        Resolve.setBackground(Color.BLACK);
//        Resolve.setForeground(Color.WHITE);
//        Resolve.setBounds(200,300,120,30);
//        Resolve.addActionListener(this);
//        add(Resolve);
//
//        back = new JButton("Back");
//        back.setBackground(Color.BLACK);
//        back.setForeground(Color.WHITE);
//        back.setBounds(45,350,120,30);
//        back.addActionListener(this);
//        add(back);
//
//        det = new JButton("View details");
//        det.setBackground(Color.BLACK);
//        det.setForeground(Color.WHITE);
//        det.setBounds(45,300,120,30);
//        det.addActionListener(this);
//        add(det);
//
//        delt = new JButton("Delete Issue");
//        delt.setBackground(Color.BLACK);
//        delt.setForeground(Color.WHITE);
//        delt.setBounds(200,350,120,30);
//        delt.addActionListener(this);
//        add(delt);
//
//        setBounds(600,600,800,460);
//        setVisible(true);
//    }
//    public void actionPerformed(ActionEvent ae){
//        if(ae.getSource()==Resolve){
//            String stat = null;
//            if(rmale.isSelected()) {stat="Resolved";}
//            else if(rfemale.isSelected()) {stat = "To be Resolved";}
//            String iid = croom.getSelectedItem();
//            if(iid.equals("")){JOptionPane.showMessageDialog(null,"Choose a Issue Id to resolve");}
//            else{
//                try{
//                    Conn c = new Conn();
//                    c.s.executeUpdate("update Issue set status = '"+stat+"' where (issue_id = '"+iid+"')");
//                    JOptionPane.showMessageDialog(null,"Issue updated Successfully");
//                    setVisible(false);
//                    new Adminview();
//                }catch(Exception e){e.printStackTrace();}
//            }
//        }
//        else if(ae.getSource()==back){
//            setVisible(false);
//            new Adminview();
//        }
//        else if(ae.getSource()==delt){
//            String iid = croom.getSelectedItem();
//            try{
//                Conn c = new Conn();
//                c.s.executeUpdate("delete from Issue where issue_id = '"+iid+"'");
//                JOptionPane.showMessageDialog(null,"Successfully deleted");
//                setVisible(false);
//                new Adminview();
//            }catch(Exception e){e.printStackTrace();}
//        }
//        else if(ae.getSource()==det){
//            String iid = croom.getSelectedItem();
//            try{
//                Conn c = new Conn();
//                ResultSet rs = c.s.executeQuery("select status,descr from Issue where issue_id = '"+iid+"'");
//                if(rs.next()){
//                    tfde.setText(rs.getString("descr"));
//                    tfst.setText(rs.getString("status"));
//                }
//
//            }catch(Exception e){
//                e.printStackTrace();
//            }
//        }
//
//    }
//
//    public static void main(String[] args){
//        new Resolveissue();
//}
//
//}

package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class ResolveIssue extends JFrame {
    private class ResolveIssueModel {
        public void connect(String stat,String iid)
        {
            try{
                    Conn c = new Conn();
                    c.s.executeUpdate("update Issue set status = '"+stat+"' where (issue_id = '"+iid+"')");
                    JOptionPane.showMessageDialog(null,"Issue updated Successfully");
                    
                    new Adminview();
                }catch(Exception e){e.printStackTrace();}
        }
        public void connect1(String iid,ResolveIssueView view)
        {
            try{
                Conn c = new Conn();
                c.s.executeUpdate("delete from Issue where issue_id = '"+iid+"'");
                JOptionPane.showMessageDialog(null,"Successfully deleted");
                view.close();
                new Adminview();
            }catch(Exception e){e.printStackTrace();}
        }
        public void connect2(String iid,ResolveIssueView view)
        {
            try{
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery("select status,descr from Issue where issue_id = '"+iid+"'");
                if(rs.next()){
                    view.tfde.setText(rs.getString("descr"));
                    view.tfst.setText(rs.getString("status"));
                }

            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
    
    private class ResolveIssueView extends JFrame {
        Choice croom;
    JRadioButton rmale,rfemale;
    JButton delt,det,Resolve,back;
JLabel image;
    JTextField tfst,tfde;
    ResolveIssueView(){
        //see hotel reports and choose a hotel to proceed , add hotels
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel text = new JLabel("Resolve Issue");
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

        JLabel lblroom = new JLabel("Available Issue Id's : ");
        lblroom.setBounds(10,80,200,25);
        lblroom.setFont(new Font("Raleway",Font.PLAIN,20));
        add(lblroom);

        croom = new Choice();

        try{
            Conn conn = new Conn();
            //Hit MySQL:
            String query = "select * from Issue";
            ResultSet rs = conn.s.executeQuery(query);// this has entire table
            while(rs.next()){
                //i need to add col name of result set to croom:
                croom.add(rs.getString("issue_id"));
            }
        }catch(Exception e){e.printStackTrace();}
        croom .setBounds(230,80,150,25);
        add(croom);

        JLabel lblstn = new JLabel("Set Status : ");
        lblstn.setBounds(10,220,150,25);
        lblstn.setFont(new Font("Raleway",Font.PLAIN,20));
        add(lblstn);

        rmale = new JRadioButton("Resolved");
        rmale.setBackground(Color.WHITE);
        rmale.setBounds(170,220,100,30);
        add(rmale);

        rfemale = new JRadioButton("To be Resolved");
        rfemale.setBackground(Color.WHITE);
        rfemale.setBounds(280,220,150,25);//why 270? coz right side of male option, we need female btn
        add(rfemale);

        JLabel lblst = new JLabel(" Old Status : ");
        lblst.setBounds(10,125,150,25);
        lblst.setFont(new Font("Raleway",Font.PLAIN,20));
        add(lblst);

        tfst = new JTextField();
        tfst.setBounds(180,125,100,30);
        add(tfst);

        JLabel lblde = new JLabel("Description : ");
        lblde.setBounds(10,175,200,25);
        lblde.setFont(new Font("Raleway",Font.PLAIN,20));
        add(lblde);

        tfde = new JTextField();
        tfde.setBounds(180,175,100,30);
        add(tfde);

        Resolve = new JButton("Resolve");
        Resolve.setBackground(Color.BLACK);
        Resolve.setForeground(Color.WHITE);
        Resolve.setBounds(200,300,120,30);
//        Resolve.addActionListener(this);
        add(Resolve);

        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(45,350,120,30);
//        back.addActionListener(this);
        add(back);

        det = new JButton("View details");
        det.setBackground(Color.BLACK);
        det.setForeground(Color.WHITE);
        det.setBounds(45,300,120,30);
//        det.addActionListener(this);
        add(det);

        delt = new JButton("Delete Issue");
        delt.setBackground(Color.BLACK);
        delt.setForeground(Color.WHITE);
        delt.setBounds(200,350,120,30);
//        delt.addActionListener(this);
        add(delt);

        setBounds(600,600,800,460);
        setVisible(true);
    }
    public void addNextButtonListener(ActionListener listener) {
            Resolve.addActionListener(listener);
            det.addActionListener(listener);
            delt.addActionListener(listener);
            back.addActionListener(listener);

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
    private class ResolveIssueController implements ActionListener {
        private ResolveIssueModel model;
        private ResolveIssueView view;
        
        ResolveIssueController(ResolveIssueModel model, ResolveIssueView view) {
            this.model = model;
            this.view = view;
            view.addNextButtonListener(this);
        }
        
        public void actionPerformed(ActionEvent ae) {
            
         if(ae.getSource()==view.Resolve){
            String stat = null;
            if(view.rmale.isSelected()) {stat="Resolved";}
            else if(view.rfemale.isSelected()) {stat = "To be Resolved";}
            String iid = view.croom.getSelectedItem();
            if(iid.equals("")){JOptionPane.showMessageDialog(null,"Choose a Issue Id to resolve");}
            else{
                view.close();
                model.connect(stat,iid);
                
            }
        }
        else if(ae.getSource()==view.back){
            view.close();
            new Adminview();
        }
        else if(ae.getSource()==view.delt){
            String iid = view.croom.getSelectedItem();
            model.connect1(iid,view);
            
        }
        else if(ae.getSource()==view.det){
            String iid = view.croom.getSelectedItem();
            model.connect2(iid,view);
            
        }

    }
    }
    public ResolveIssue() {
        ResolveIssueModel model = new ResolveIssueModel();
        ResolveIssueView view = new ResolveIssueView();
        ResolveIssueController controller = new ResolveIssueController(model, view);
    }
    
    public static void main(String[] args) {
        new ResolveIssue();
    }
}