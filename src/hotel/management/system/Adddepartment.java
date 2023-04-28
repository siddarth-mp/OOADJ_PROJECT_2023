package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Adddepartment extends JFrame implements ActionListener {
    public static String  hidi;
    JTextField tfname,tfbud,tfstaf;
    JButton add,cancel;
    Adddepartment(String hid){
        hidi = hid;
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("Add Departments");
        heading.setFont(new Font("Tahoma",Font.BOLD,18));
        heading.setBounds(150,30,200,20);
        add(heading);

        //cretate "add room" label
        JLabel lblroomno = new JLabel("Name: ");
        lblroomno.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblroomno.setBounds( 60,90,120,30);
        add(lblroomno);
        //create text field to hold room no
        tfname = new JTextField();
        tfname.setBounds(200,90,150,30);
        add(tfname);

        //Available label txt field
        JLabel lblage = new JLabel("Budget : ");
        lblage.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblage.setBounds( 60,150,120,30); //130>80+30(from previous)
        add(lblage);

        tfbud = new JTextField();
        tfbud.setBounds(200,150,150,30);
        add(tfbud);


        //Cleaning status label txt field
        JLabel lblclean = new JLabel("Staff size: ");
        lblclean.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblclean.setBounds( 60,220,120,30); //180>130+30(from previous)
        add(lblclean);

        //create text field to hold room no
        tfstaf = new JTextField();
        tfstaf.setBounds(200,220,150,30);
        add(tfstaf);

        //add "Add" button
        add = new JButton("Add Department");
        add.setForeground(Color.WHITE);
        add.setBackground(Color.BLACK);
        add.setBounds(60,340,130,30);
        add.addActionListener(this);
        add(add);

        //add cancel button
        cancel = new JButton("Back");
        cancel.setForeground(Color.WHITE);
        cancel.setBackground(Color.BLACK);
        cancel.setBounds(230,340,130,30);
        cancel.addActionListener(this);
        add(cancel);

        //add image background
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/dep.jpg"));
        Image i2 = i1.getImage().getScaledInstance(320,320,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400,30,320,320);
        add(image);


        setBounds(300,200,750,470);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==cancel){
              setVisible(false);
              new Managerview(hidi);
        }
        else if(ae.getSource()==add){
            String name = tfname.getText();
            String budget = tfbud.getText();
            String staff = tfstaf.getText();
            try{
                Conn c = new Conn();
                c.s.executeUpdate("insert into department values('"+name+"' , '"+budget+"' , '"+hidi+"' , '"+staff+"') ");
                JOptionPane.showMessageDialog(null,"Department added Successfully!");
                setVisible(false);
                new Managerview(hidi);
            }catch(Exception e){e.printStackTrace();}
        }
    }

    public static void main(String[] args) {
        new Adddepartment(hidi);}
}