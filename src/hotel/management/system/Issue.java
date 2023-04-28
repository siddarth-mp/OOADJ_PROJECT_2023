//package hotel.management.system;
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.sql.ResultSet;
///**
// *
// * @author Umesh
// */
//public class Issue extends JFrame implements ActionListener{
//
//    public static String abcd;
//    JTextField tfrat,tfdesc;
//    JButton ist,lgot,submit;
//    JLabel lblcheckintime;
//    Issue(String abc){
//        abcd = abc;
//        getContentPane().setBackground(Color.WHITE);
//        setLayout(null);
//
//        JLabel text = new JLabel("System Issue");
//        text.setBounds(100,20,180,30);
//        text.setForeground(Color.BLUE);
//        text.setFont(new Font("Tahoma",Font.BOLD,20));
//        add(text);
//
//        JLabel text2 = new JLabel("Enter your Issue Id ");
//        text2.setBounds(40,160,340,30);
//        text2.setForeground(Color.BLACK);
//        text2.setFont(new Font("Tahoma",Font.PLAIN,14));
//        add(text2);
//
//        tfrat = new JTextField();
//        tfrat.setBounds(180,160,100,30);
//        add(tfrat);
//
//        JLabel text3 = new JLabel("Enter your Issue ");
//        text3.setBounds(40,220,340,30);
//        text3.setForeground(Color.BLACK);
//        text3.setFont(new Font("Tahoma",Font.PLAIN,14));
//        add(text3);
//
//        tfdesc = new JTextField();
//        tfdesc.setBounds(180,220,100,30);
//        add(tfdesc);
//
//
//        submit = new JButton("Submit");
//        submit.setBounds(35,350,100,30); //40+120=160 is total height of this button so for 'cancel' button need to give bit large size
//        submit.setBackground(Color.BLACK);
//        submit.setForeground(Color.WHITE);
//        submit.addActionListener(this);
//        add(submit);
//
//        lgot = new JButton("No Issue; logout");
//        lgot.setBounds(150,350,220,30); //40+120=160 is total height of this button so for 'cancel' button need to give bit large size
//        lgot.setBackground(Color.BLACK);
//        lgot.setForeground(Color.WHITE);
//        lgot.addActionListener(this);
//        add(lgot);
//
//        ist = new JButton("View issue status");
//        ist.setBounds(385,350,160,30); //40+120=160 is total height of this button so for 'cancel' button need to give bit large size
//        ist.setBackground(Color.BLACK);
//        ist.setForeground(Color.WHITE);
//        ist.addActionListener(this);
//        add(ist);
//
//        setBounds(600,600,600,490);
//        setVisible(true);
//
//    }
//    public void actionPerformed(ActionEvent ae){
//        if(ae.getSource()==submit){
//            String id = tfrat.getText();
//            String descrip = tfdesc.getText();
//            String status = "To be Resolved";
//           // if(rmale.isSelected()) {status = "To be Resolved";}
//            try{
//                Conn c = new Conn();
//                String query = "insert into Issue(issue_id,descr,hotel_id,status) values ('"+id+"','"+descrip+"','"+abcd+"' , '"+status+"')";
//                c.s.executeUpdate(query);
//                JOptionPane.showMessageDialog(null,"Thanks for ur time");
//                setVisible(false);
//            }catch(Exception e){e.printStackTrace();}
//        }
//        else if(ae.getSource()==lgot){
//            JOptionPane.showMessageDialog(null,"Thank you, see you soon");
//            setVisible(false);
//        }
//        else if(ae.getSource()==ist){
//            String id = tfrat.getText();
//            setVisible(false);
//            new Viewissue(id);
//        }
//    }
//
//    public static void main(String[] args){
//        new Issue("" + abcd);
//}
//}


package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Issue extends JFrame{
    public static String abcd;
    
    private class IssueModel {
        public void connect(String id, String descrip,String status)
        {
             try{
                Conn c = new Conn();
                String query = "insert into Issue(issue_id,descr,hotel_id,status) values ('"+id+"','"+descrip+"','"+abcd+"' , '"+status+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Thanks for ur time");
                setVisible(false);
            }catch(Exception e){e.printStackTrace();}
        }
    }
    private class IssueView extends JFrame {
        JTextField tfrat,tfdesc;
    JButton ist,lgot,submit;
    JLabel lblcheckintime;
    IssueView(String abc){
        abcd = abc;
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel text = new JLabel("System Issue");
        text.setBounds(100,20,180,30);
        text.setForeground(Color.BLUE);
        text.setFont(new Font("Tahoma",Font.BOLD,20));
        add(text);

        JLabel text2 = new JLabel("Enter your Issue Id ");
        text2.setBounds(40,160,340,30);
        text2.setForeground(Color.BLACK);
        text2.setFont(new Font("Tahoma",Font.PLAIN,14));
        add(text2);

        tfrat = new JTextField();
        tfrat.setBounds(180,160,100,30);
        add(tfrat);

        JLabel text3 = new JLabel("Enter your Issue ");
        text3.setBounds(40,220,340,30);
        text3.setForeground(Color.BLACK);
        text3.setFont(new Font("Tahoma",Font.PLAIN,14));
        add(text3);

        tfdesc = new JTextField();
        tfdesc.setBounds(180,220,100,30);
        add(tfdesc);


        submit = new JButton("Submit");
        submit.setBounds(35,350,100,30); //40+120=160 is total height of this button so for 'cancel' button need to give bit large size
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
//        submit.addActionListener(this);
        add(submit);

        lgot = new JButton("No Issue; logout");
        lgot.setBounds(150,350,220,30); //40+120=160 is total height of this button so for 'cancel' button need to give bit large size
        lgot.setBackground(Color.BLACK);
        lgot.setForeground(Color.WHITE);
//        lgot.addActionListener(this);
        add(lgot);

        ist = new JButton("View issue status");
        ist.setBounds(385,350,160,30); //40+120=160 is total height of this button so for 'cancel' button need to give bit large size
        ist.setBackground(Color.BLACK);
        ist.setForeground(Color.WHITE);
//        ist.addActionListener(this);
        add(ist);

        setBounds(600,600,600,490);
        setVisible(true);
    }
    public void addNextButtonListener(ActionListener listener) {
            submit.addActionListener(listener);
            lgot.addActionListener(listener);
            ist.addActionListener(listener);
        }
        
        public void showText() {
            setVisible(true);
        }
        
        public void hideText() {
            setVisible(false);
        }
        
        public void close() {
            setVisible(false);
            dispose();
        }
    }
    private class IssueController implements ActionListener {
        private IssueModel model;
        private IssueView view;
        
       IssueController(IssueModel model, IssueView view) {
            this.model = model;
            this.view = view;
            view.addNextButtonListener(this);
        }
        
        public void actionPerformed(ActionEvent ae) {
            view.close();
            
       if(ae.getSource()==view.submit){
            String id = view.tfrat.getText();
            String descrip = view.tfdesc.getText();
            String status = "To be Resolved";
           // if(rmale.isSelected()) {status = "To be Resolved";}
           model.connect(id,descrip,status);
           
        }
        else if(ae.getSource()==view.lgot){
            JOptionPane.showMessageDialog(null,"Thank you, see you soon");
            setVisible(false);
        }
        else if(ae.getSource()==view.ist){
            String id = view.tfrat.getText();
            setVisible(false);
            new Viewissue(id);
        }

        }
    
    }
    
    public Issue(String hidi) {
        IssueModel model = new IssueModel();
        IssueView view = new IssueView(hidi);
        IssueController controller = new IssueController(model, view);
    }
    
    public static void main(String[] args) {
        new Issue(abcd);
    }
    
}
