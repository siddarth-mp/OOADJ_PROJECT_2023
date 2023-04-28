
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.management.system;

import javax.swing.*; //for JFrame to create frame,java extended
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
//through ActionListener can catch the events
public class Managerlogin extends JFrame implements ActionListener{

    JTextField username,id; // we need to access these fields outside this constructor, to use in the handler fn
    JPasswordField password;
    JButton login,cancel;
    Managerlogin(){
        getContentPane().setBackground(Color.WHITE);

        setLayout(null);

        //create Username label
        JLabel user = new JLabel("Manager name");
        user.setBounds(40,20,100,30);
        add(user);

        //create text field right infront of "Username"
        username = new JTextField();
        username.setBounds(140,20,150,30);
        add(username);

        //create "Password label"
        JLabel pass = new JLabel("Manager Password");
        pass.setBounds(40,70,130,30);
        add(pass);

        //create "password" text field where user will enter his pswd
        password = new JPasswordField();
        password.setBounds(180,70,173,30);
        add(password);

        JLabel lblh = new JLabel("Enter Hotel Id");
        lblh.setBounds(40,120,100,30);
        add(lblh);

        id = new JTextField();
        id.setBounds(140,120,150,30);
        add(id);

        //create login button
        login = new JButton("Login");
        login.setBounds(40,190,160,30); //40+120=160 is total height of this button so for 'cancel' button need to give bit large size
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);

        //create "cancel" button
        cancel = new JButton("Back");
        cancel.setBounds(210,190,120,30);
        cancel.setBackground(Color.GREEN);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);

        //add 'user' image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        //scale the image , get image from i1 use i2 which stores updated scaled i1's image, then need to add it to frame
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        //cant place image class ka aobject (i2) inside JLabel
        //so store in i3 then use it
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350,10,200,200);
        add(image);


        setBounds(500,200,600,300);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==login) { //if login button is clicked
            String user = username.getText();
            String pass = password.getText();
            String hid = id.getText();
            try{
                Conn c = new Conn();
                //here user,pass is variable whose value needs to be compared so use '+' operator:
                // and also username is given as 'user' with single invited comma, so use single invited comma like this:
                String query = "select * from manager where (mname = '" + user + "' and mpwd = '" + pass + "' and hotel_id = '"+hid+"') ";
                ResultSet rs = c.s.executeQuery(query);
                //store result of table in rs (above)
                if(rs.next()){
                    //if rs.next is true => values are received, if not goto else => show popup invalid credentials
                    setVisible(false); //if crct data is received then close login frame and open Main dashboard page:
                    new Managerview(hid); //upon this call, constructor is called and frame is opened :)
                }
                else{
                    JOptionPane.showMessageDialog(null,"Invalid Credentials");
                    //setVisible(false);
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        else if(ae.getSource()==cancel){
            setVisible(false); // to close this frame
            new Start();
        }
    }

    public static void main(String[] args){
        new Managerlogin();
}

}