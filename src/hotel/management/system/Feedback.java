//package hotel.management.system;
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.sql.ResultSet;
//
//public class Feedback extends JFrame implements ActionListener{
//    public static String abcd;
//    JTextField tfrat;
//    JButton rp,ist,submit;
//    JLabel lblcheckintime;
//    Feedback(String abc){
//        abcd = abc;
//        getContentPane().setBackground(Color.WHITE);
//        setLayout(null);
//
//        JLabel text = new JLabel("Feedback Form");
//        text.setBounds(100,20,180,30);
//        text.setForeground(Color.BLUE);
//        text.setFont(new Font("Tahoma",Font.BOLD,20));
//        add(text);
//
//        JLabel text1 = new JLabel("Hotel id   :  ");
//        text1.setBounds(60,80,100,30);
//        text1.setForeground(Color.BLACK);
//        text1.setFont(new Font("Tahoma",Font.PLAIN,14));
//        add(text1);
//
//
//        lblcheckintime = new JLabel();
//        lblcheckintime.setBounds(180,80,100,30);
//        add(lblcheckintime);
//
//        lblcheckintime.setText("" + abcd);
//
//        JLabel text2 = new JLabel("Enter your overall rating on a scale of 1-10 : ");
//        text2.setBounds(40,160,340,30);
//        text2.setForeground(Color.BLACK);
//        text2.setFont(new Font("Tahoma",Font.PLAIN,14));
//        add(text2);
//
//        tfrat = new JTextField();
//        tfrat.setBounds(350,160,100,30);
//        add(tfrat);
//
//
//        submit = new JButton("Submit");
//        submit.setBounds(10,300,130,30); //40+120=160 is total height of this button so for 'cancel' button need to give bit large size
//        submit.setBackground(Color.BLACK);
//        submit.setForeground(Color.WHITE);
//        submit.addActionListener(this);
//        add(submit);
//
//        ist = new JButton("View issue status");
//        ist.setBounds(150,300,180,30); //40+120=160 is total height of this button so for 'cancel' button need to give bit large size
//        ist.setBackground(Color.BLACK);
//        ist.setForeground(Color.WHITE);
//        ist.addActionListener(this);
//        add(ist);
//
//        rp = new JButton("Report System Issue");
//        rp.setBounds(350,300,220,30); //40+120=160 is total height of this button so for 'cancel' button need to give bit large size
//        rp.setBackground(Color.BLACK);
//        rp.setForeground(Color.WHITE);
//        rp.addActionListener(this);
//        add(rp);
//
//        setBounds(600,600,600,490);
//        setVisible(true);
//
//    }
//    public void actionPerformed(ActionEvent ae){
//        if(ae.getSource()==submit){
//            String rat = tfrat.getText();
//            Integer rat1 = Integer.parseInt(rat);
//            try{
//                Conn c = new Conn();
//                String query = "insert into feedback(hotel_id,rating) values ('"+abcd+"','"+rat1+"')";
//                c.s.executeUpdate(query);
//                JOptionPane.showMessageDialog(null,"Thanks for ur rating");
//                setVisible(false);
//                new Issue(abcd);
//            }catch(Exception e){e.printStackTrace();}
//        }
//        else if(ae.getSource()==ist){
//            try{
//                Conn c = new Conn();
//                new Viewissue(abcd);
//            }catch(Exception e){e.printStackTrace();}
//        }
//        else if(ae.getSource()==rp){
//            setVisible(false);
//            new Issue(abcd);
//        }
//    }
//
//    public static void main(String[] args){
//        new Feedback(abcd);
//}
//}


package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Feedback extends JFrame
{
    public static String abcd;
    private class FeedbackModel {
         public void connect(Integer rat1){
             try{
                Conn c = new Conn();
                String query = "insert into feedback(hotel_id,rating) values ('"+abcd+"','"+rat1+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Thanks for ur rating");
                setVisible(false);
                new Issue(abcd);
            }catch(Exception e){e.printStackTrace();}
         }
     }
    private class FeedbackView extends JFrame {
        JTextField tfrat;
    JButton rp,ist,submit;
    JLabel lblcheckintime;
    FeedbackView(String abc){
        abcd = abc;
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel text = new JLabel("Feedback Form");
        text.setBounds(100,20,180,30);
        text.setForeground(Color.BLUE);
        text.setFont(new Font("Tahoma",Font.BOLD,20));
        add(text);

        JLabel text1 = new JLabel("Hotel id   :  ");
        text1.setBounds(60,80,100,30);
        text1.setForeground(Color.BLACK);
        text1.setFont(new Font("Tahoma",Font.PLAIN,14));
        add(text1);


        lblcheckintime = new JLabel();
        lblcheckintime.setBounds(180,80,100,30);
        add(lblcheckintime);

        lblcheckintime.setText("" + abcd);

        JLabel text2 = new JLabel("Enter your overall rating on a scale of 1-10 : ");
        text2.setBounds(40,160,340,30);
        text2.setForeground(Color.BLACK);
        text2.setFont(new Font("Tahoma",Font.PLAIN,14));
        add(text2);

        tfrat = new JTextField();
        tfrat.setBounds(350,160,100,30);
        add(tfrat);


        submit = new JButton("Submit");
        submit.setBounds(10,300,130,30); //40+120=160 is total height of this button so for 'cancel' button need to give bit large size
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
//        submit.addActionListener(this);
        add(submit);

        ist = new JButton("View issue status");
        ist.setBounds(150,300,180,30); //40+120=160 is total height of this button so for 'cancel' button need to give bit large size
        ist.setBackground(Color.BLACK);
        ist.setForeground(Color.WHITE);
//        ist.addActionListener(this);
        add(ist);

        rp = new JButton("Report System Issue");
        rp.setBounds(350,300,220,30); //40+120=160 is total height of this button so for 'cancel' button need to give bit large size
        rp.setBackground(Color.BLACK);
        rp.setForeground(Color.WHITE);
//        rp.addActionListener(this);
        add(rp);

        setBounds(600,600,600,490);
        setVisible(true);
    }
    public void addNextButtonListener(ActionListener listener) {
            submit.addActionListener(listener);
            ist.addActionListener(listener);
            rp.addActionListener(listener);
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
    private class FeedbackController implements ActionListener {
        private FeedbackModel model;
        private FeedbackView view;
        
        FeedbackController(FeedbackModel model, FeedbackView view) {
            this.model = model;
            this.view = view;
            view.addNextButtonListener(this);
        }
        
        public void actionPerformed(ActionEvent ae) {
            view.close();
            
       if(ae.getSource()==view.submit){
            String rat = view.tfrat.getText();
            Integer rat1 = Integer.parseInt(rat);
            model.connect(rat1);
        }
        else if(ae.getSource()==view.ist){
            try{
                Conn c = new Conn();
                new Viewissue(abcd);
            }catch(Exception e){e.printStackTrace();}
        }
        else if(ae.getSource()==view.rp){
            setVisible(false);
            new Issue(abcd);
        }

        }
    
    }
    
    public Feedback(String hidi) {
        FeedbackModel model = new FeedbackModel();
        FeedbackView view = new FeedbackView(hidi);
        FeedbackController controller = new FeedbackController(model, view);
    }
    
    public static void main(String[] args) {
        new Feedback(abcd);
    }
    
    
}