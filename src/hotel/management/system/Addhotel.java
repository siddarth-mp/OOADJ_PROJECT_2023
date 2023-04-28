package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Addhotel extends JFrame implements ActionListener {

    JButton submit,back;
    JPasswordField password;
    JComboBox comboid;
    JTextField tfmail,tfcountry,tfnumber,tfname,tfman;
    Addhotel(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel text = new JLabel("ADD NEW HOTEL");
        text.setBounds(100,20,300,30);
        text.setForeground(Color.BLUE);
        text.setFont(new Font("Raleway",Font.PLAIN,20));
        add(text);

        JLabel lblnumber = new JLabel("Hotel Id");
        lblnumber.setBounds(35,130,180,25);
        lblnumber.setFont(new Font("Raleway",Font.PLAIN,20));
        add(lblnumber);

        tfnumber = new JTextField();
        tfnumber.setBounds(200,130,180,25);
        add(tfnumber);

        JLabel lblname = new JLabel("Name");
        lblname.setBounds(35,185,180,20);
        lblname.setFont(new Font("Raleway",Font.PLAIN,20));
        add(lblname);

        tfname = new JTextField();
        tfname.setBounds(200,185,180,25);
        add(tfname);

        JLabel lblcountry = new JLabel("Pincode");
        lblcountry.setBounds(35,240,100,20);
        lblcountry.setFont(new Font("Raleway",Font.PLAIN,20));
        add(lblcountry);

        tfcountry = new JTextField();
        tfcountry.setBounds(200,240,150,25);
        add(tfcountry);

        JLabel lblid = new JLabel("Type");
        lblid.setBounds(35,80,100,30);
        lblid.setFont(new Font("Raleway",Font.PLAIN,20));
        add(lblid);

        String options[] = {"Boarding", "Lodging"};   //, "Voter Id", "Driving license"};
        comboid = new JComboBox(options);
        comboid.setBounds(200,80,100,30);
        comboid.setBackground(Color.WHITE);
        add(comboid);

        JLabel lblman = new JLabel("Manager name");
        lblman.setBounds(35,280,180,40);
        lblman.setFont(new Font("Raleway",Font.PLAIN,20));
        add(lblman);

        tfman = new JTextField();
        tfman.setBounds(200,280,150,25);
        add(tfman);

        JLabel lblmail = new JLabel("Manager Mail-Id");
        lblmail.setBounds(35,340,180,40);
        lblmail.setFont(new Font("Raleway",Font.PLAIN,20));
        add(lblmail);

        tfmail = new JTextField();
        tfmail.setBounds(200,340,150,25);
        add(tfmail);

        JLabel pass = new JLabel("Manager Password");
        pass.setBounds(35,400,200,30);
        pass.setFont(new Font("Raleway",Font.PLAIN,20));
        add(pass);

        //create "password" text field where user will enter his pswd
        password = new JPasswordField();
        password.setBounds(240,400,150,30);
        add(password);

        submit = new JButton("Submit");
        submit.setBounds(20,480,160,30); //40+120=160 is total height of this button so for 'cancel' button need to give bit large size
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        add(submit);

        back = new JButton("Back");
        back.setBounds(240,480,160,30); //40+120=160 is total height of this button so for 'cancel' button need to give bit large size
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/htl.jpg"));
        Image i2 = i1.getImage().getScaledInstance(450,370,Image.SCALE_DEFAULT); // resize the image previously it was enlarged
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(430,20,450,370); //where to place the image (coords)
        add(image);

        setBounds(600,600,1000,650);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==submit){
            String name = tfname.getText();
            String id = tfnumber.getText();
            String pin = tfcountry.getText();
            String type = (String) comboid.getSelectedItem();
            String manam = tfman.getText();
            String mail = tfmail.getText();
            String pwd = password.getText();

            if(name.equals("") || id.equals("") || pin.equals("") || pin.length()!=6 ||type.equals("")){
                JOptionPane.showMessageDialog(null,"Enter all fields");
            }
            else{
                try{
                    Conn c = new Conn();
                    String query = "insert into hotels values('"+id+"' , '"+name+"' , '"+pin+"' , '"+type+"' )";
                    String query2 = "insert into manager values('"+manam+"' , '"+pwd+"' , '"+id+"' , '"+mail+"')";
                    c.s.executeUpdate(query);
                    c.s.executeUpdate(query2);
                    JOptionPane.showMessageDialog(null,"Hotel Added successfully!");
                    setVisible(false);
                    new Adminview();
                }catch(Exception e){e.printStackTrace();}
            }
        }
        else if(ae.getSource()==back){
            setVisible(false);
            new Adminview();


        }
    }
    public static void main(String[] args){
        new Addhotel();}
}