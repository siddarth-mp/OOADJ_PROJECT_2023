///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package hotel.management.system;
//import javax.swing.*;
//import java.awt.*; // awt is for color.white
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.sql.ResultSet;
//import java.util.Date;
///**
// *
// * @author Umesh
// */
//public class AddCustomer extends JFrame implements ActionListener{
//    public static String hidi;
//    JComboBox comboid;
//    JTextField tfnumber,tfname,tfdeposit,tfcountry;
//    JRadioButton rmale,rfemale;
//    Choice croom;
//    JLabel checkintime;
//    JButton add,back;
//    AddCustomer(String hid){
//        hidi = hid;
//        getContentPane().setBackground(Color.WHITE);
//        setLayout(null);
//
//        JLabel text = new JLabel("NEW CUSTOMER FORM");
//        text.setBounds(100,20,300,30);
//        text.setFont(new Font("Raleway",Font.PLAIN,20));
//        add(text);
//
//        JLabel lblid = new JLabel("ID");
//        lblid.setBounds(35,80,100,20);
//        lblid.setFont(new Font("Raleway",Font.PLAIN,20));
//        add(lblid);
//
//        String options[] = {"Passport", "Aadhar Card", "Voter Id", "Driving license"};
//        comboid = new JComboBox(options);
//        comboid.setBounds(200,80,150,25);
//        comboid.setBackground(Color.WHITE);
//        add(comboid);
//
//        JLabel lblnumber = new JLabel("Adhaar Number");
//        lblnumber.setBounds(35,120,180,20);
//        lblnumber.setFont(new Font("Raleway",Font.PLAIN,20));
//        add(lblnumber);
//
//        tfnumber = new JTextField();
//        tfnumber.setBounds(200,120,150,25);
//        add(tfnumber);
//
//        JLabel lblname = new JLabel("Name");
//        lblname.setBounds(35,160,100,20);
//        lblname.setFont(new Font("Raleway",Font.PLAIN,20));
//        add(lblname);
//
//        tfname = new JTextField();
//        tfname.setBounds(200,160,150,25);
//        add(tfname);
//
//        JLabel lblgender = new JLabel("Gender");
//        lblgender.setBounds(35,200,100,20);
//        lblgender.setFont(new Font("Raleway",Font.PLAIN,20));
//        add(lblgender);
//
//        //radio btn for male,female
//        rmale = new JRadioButton("Male");
//        rmale.setBackground(Color.WHITE);
//        rmale.setBounds(200,200,100,25);
//        add(rmale);
//        rfemale = new JRadioButton("Female");
//        rfemale.setBackground(Color.WHITE);
//        rfemale.setBounds(300,200,150,25);//why 270? coz right side of male option, we need female btn
//        add(rfemale);
//
//        //to avoid selecting both radiobuttons: by grouping them
//        ButtonGroup bg = new ButtonGroup();
//        bg.add(rmale);
//        bg.add(rfemale);
//
//        //Nationality details
//        JLabel lblcountry = new JLabel("Country");
//        lblcountry.setBounds(35,240,100,20);
//        lblcountry.setFont(new Font("Raleway",Font.PLAIN,20));
//        add(lblcountry);
//
//        tfcountry = new JTextField();
//        tfcountry.setBounds(200,240,150,25);
//        add(tfcountry);
//
//        //Allocated room number : dynamic allocation:
//        JLabel lblroom = new JLabel("Allocated Room");
//        lblroom.setBounds(35,280,150,20);
//        lblroom.setFont(new Font("Raleway",Font.PLAIN,20));
//        add(lblroom);
//        //to create a drop down use JComboBox or else other method is to use Choice method, so in Jcombobox we need to pass options as paramtr, but in Choice, just use .add("1st") method
//        //so here watever is there in DB needs to appear in drop down
//        croom = new Choice();
//
//        try{
//            Conn conn = new Conn();
//            //Hit MySQL:
//            String query = "select * from room where (availability = 'Available' and hotel_id = '"+hidi+"') ";
//            ResultSet rs = conn.s.executeQuery(query);// this has entire table
//            while(rs.next()){
//                //i need to add col name of result set to croom:
//                croom.add(rs.getString("roomnumber"));
//            }
//        }catch(Exception e){e.printStackTrace();}
//        croom .setBounds(200,280,150,25);
//        add(croom);
//
//        JLabel lbltime = new JLabel("Checkin time");
//        lbltime.setBounds(35,320,150,20);
//        lbltime.setFont(new Font("Raleway",Font.PLAIN,20));
//        add(lbltime);
//
//        //this field is non editable by user , time from system needs to be fetched:
//        Date date = new Date();
//        //1+2+3+4+5+"sidd"+1+2+3+4+5 : output = 15sidd12345, once it sees string later on all r concatenation
//        checkintime = new JLabel("" + date);
//        checkintime.setBounds(200,320,150,25);
//        checkintime.setFont(new Font("Raleway",Font.PLAIN,16));
//        add(checkintime);
//
//
//        JLabel lbldeposit = new JLabel("Deposit");
//        lbldeposit.setBounds(35,360,100,20);
//        lbldeposit.setFont(new Font("Raleway",Font.PLAIN,20));
//        add(lbldeposit);
//
//        tfdeposit = new JTextField();
//        tfdeposit.setBounds(200,360,150,25);
//        add(tfdeposit);
//
//        add = new JButton("Add");
//        add.setBackground(Color.BLACK);
//        add.setForeground(Color.WHITE);
//        add.setBounds(50,410,120,30);
//        add.addActionListener(this);
//        add(add);
//
//        back = new JButton("Back");
//        back.setBackground(Color.BLACK);
//        back.setForeground(Color.WHITE);
//        back.setBounds(200,410,120,30);
//        back.addActionListener(this);
//        add(back);
//
//        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fifth.png"));
//        Image i2 = i1.getImage().getScaledInstance(300,400,Image.SCALE_DEFAULT);
//        //convert i2 back to img icon:
//        ImageIcon i3 = new ImageIcon(i2);
//        JLabel image = new JLabel(i3);
//        image.setBounds(400,50,300,400);
//        add(image);
//
//        setBounds(350,200,800,550);
//        setVisible(true);
//    }
//    public void actionPerformed(ActionEvent ae){
//
//        if(ae.getSource()==add){
//            String id = (String) comboid.getSelectedItem();
//            String number = tfnumber.getText();
//            String name = tfname.getText();
//            String gender = null;
//            if(rmale.isSelected()) {gender="Male";}
//            else if(rfemale.isSelected()) {gender = "Female";}
//            else   { JOptionPane.showMessageDialog(null,"Choose Gender");}
//            String country = tfcountry.getText();
//            String room = croom.getSelectedItem();//no type cast of obj is needed
//            String time = checkintime.getText();
//            String deposit = tfdeposit.getText();
//            Integer deposit1 = Integer.valueOf(deposit);
//            if (number.length()!=12 || number.equals("")){
//                JOptionPane.showMessageDialog(null,"Enter Valid Id number");
//                return;
//            }
//            if (name.equals("") || country.equals("")){
//                JOptionPane.showMessageDialog(null,"Enter All fields");
//                return;
//            }
//
//            if (deposit1.equals("") || deposit1<500 ){
//                JOptionPane.showMessageDialog(null,"Enter Minimum deposit of 500rs");
//                return;
//            }
//
//
//            try{
//                Conn conn = new Conn();
//                String query = "insert into customer values('"+id+"','"+number+"','"+name+"','"+gender+"','"+country+"','"+room+"','"+time+"','"+deposit+"','"+hidi+"')";
//                //here once when room is allocated, in room table set availability to occupied
//                String query2 = "update room set availability = 'Occupied' where (roomnumber = '"+room+"' and hotel_id='"+hidi+"') ";
//                String query3 = "update room set availability = 'Cleaned' where (roomnumber = '"+room+"' and hotel_id='"+hidi+"') ";
//                //execite these 2 DML cmds
//                conn.s.executeUpdate(query);
//                conn.s.executeUpdate(query2);
//                conn.s.executeUpdate(query3);
//                JOptionPane.showMessageDialog(null,"New Customer Added Successfully");
//                setVisible(false);
//                new Reception(hidi);
//
//            }catch(Exception e){e.printStackTrace();}
//
//        }else if(ae.getSource()==back){
//             setVisible(false);
//        }
//    }
//    public static void main(String[] args){
//        new AddCustomer(hidi);
//    }
//}


package hotel.management.system;
import javax.swing.*;
import java.awt.*; // awt is for color.white
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;
/**
 *
 * @author Umesh
 */
public class AddCustomer extends JFrame{
    public static String hidi;
    private class AddCustomerModel {
         public void connect(String id,String number,String name,String gender,String country,String room,String time,String deposit,String hidi )
         {
             try{
                Conn conn = new Conn();
                String query = "insert into customer values('"+id+"','"+number+"','"+name+"','"+gender+"','"+country+"','"+room+"','"+time+"','"+deposit+"','"+hidi+"')";
                //here once when room is allocated, in room table set availability to occupied
                String query2 = "update room set availability = 'Occupied' where (roomnumber = '"+room+"' and hotel_id='"+hidi+"') ";
                String query3 = "update room set availability = 'Cleaned' where (roomnumber = '"+room+"' and hotel_id='"+hidi+"') ";
                //execite these 2 DML cmds
                conn.s.executeUpdate(query);
                conn.s.executeUpdate(query2);
                conn.s.executeUpdate(query3);
                JOptionPane.showMessageDialog(null,"New Customer Added Successfully");
                setVisible(false);

            }catch(Exception e){e.printStackTrace();}

         }
     }
     
     private class AddCustomerView extends JFrame {
         JComboBox comboid;
    JTextField tfnumber,tfname,tfdeposit,tfcountry;
    JRadioButton rmale,rfemale;
    Choice croom;
    JLabel checkintime,image;
    JButton add,back;
    AddCustomerView(String hid){
        hidi = hid;
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel text = new JLabel("NEW CUSTOMER FORM");
        text.setBounds(100,20,300,30);
        text.setFont(new Font("Raleway",Font.PLAIN,20));
        add(text);

        JLabel lblid = new JLabel("ID");
        lblid.setBounds(35,80,100,20);
        lblid.setFont(new Font("Raleway",Font.PLAIN,20));
        add(lblid);

        String options[] = {"Passport", "Aadhar Card", "Voter Id", "Driving license"};
        comboid = new JComboBox(options);
        comboid.setBounds(200,80,150,25);
        comboid.setBackground(Color.WHITE);
        add(comboid);

        JLabel lblnumber = new JLabel("Adhaar Number");
        lblnumber.setBounds(35,120,180,20);
        lblnumber.setFont(new Font("Raleway",Font.PLAIN,20));
        add(lblnumber);

        tfnumber = new JTextField();
        tfnumber.setBounds(200,120,150,25);
        add(tfnumber);

        JLabel lblname = new JLabel("Name");
        lblname.setBounds(35,160,100,20);
        lblname.setFont(new Font("Raleway",Font.PLAIN,20));
        add(lblname);

        tfname = new JTextField();
        tfname.setBounds(200,160,150,25);
        add(tfname);

        JLabel lblgender = new JLabel("Gender");
        lblgender.setBounds(35,200,100,20);
        lblgender.setFont(new Font("Raleway",Font.PLAIN,20));
        add(lblgender);

        //radio btn for male,female
        rmale = new JRadioButton("Male");
        rmale.setBackground(Color.WHITE);
        rmale.setBounds(200,200,100,25);
        add(rmale);
        rfemale = new JRadioButton("Female");
        rfemale.setBackground(Color.WHITE);
        rfemale.setBounds(300,200,150,25);//why 270? coz right side of male option, we need female btn
        add(rfemale);

        //to avoid selecting both radiobuttons: by grouping them
        ButtonGroup bg = new ButtonGroup();
        bg.add(rmale);
        bg.add(rfemale);

        //Nationality details
        JLabel lblcountry = new JLabel("Country");
        lblcountry.setBounds(35,240,100,20);
        lblcountry.setFont(new Font("Raleway",Font.PLAIN,20));
        add(lblcountry);

        tfcountry = new JTextField();
        tfcountry.setBounds(200,240,150,25);
        add(tfcountry);

        //Allocated room number : dynamic allocation:
        JLabel lblroom = new JLabel("Allocated Room");
        lblroom.setBounds(35,280,150,20);
        lblroom.setFont(new Font("Raleway",Font.PLAIN,20));
        add(lblroom);
        //to create a drop down use JComboBox or else other method is to use Choice method, so in Jcombobox we need to pass options as paramtr, but in Choice, just use .add("1st") method
        //so here watever is there in DB needs to appear in drop down
        croom = new Choice();

        try{
            Conn conn = new Conn();
            //Hit MySQL:
            String query = "select * from room where (availability = 'Available' and hotel_id = '"+hidi+"') ";
            ResultSet rs = conn.s.executeQuery(query);// this has entire table
            while(rs.next()){
                //i need to add col name of result set to croom:
                croom.add(rs.getString("roomnumber"));
            }
        }catch(Exception e){e.printStackTrace();}
        croom .setBounds(200,280,150,25);
        add(croom);

        JLabel lbltime = new JLabel("Checkin time");
        lbltime.setBounds(35,320,150,20);
        lbltime.setFont(new Font("Raleway",Font.PLAIN,20));
        add(lbltime);

        //this field is non editable by user , time from system needs to be fetched:
        Date date = new Date();
        //1+2+3+4+5+"sidd"+1+2+3+4+5 : output = 15sidd12345, once it sees string later on all r concatenation
        checkintime = new JLabel("" + date);
        checkintime.setBounds(200,320,150,25);
        checkintime.setFont(new Font("Raleway",Font.PLAIN,16));
        add(checkintime);


        JLabel lbldeposit = new JLabel("Deposit");
        lbldeposit.setBounds(35,360,100,20);
        lbldeposit.setFont(new Font("Raleway",Font.PLAIN,20));
        add(lbldeposit);

        tfdeposit = new JTextField();
        tfdeposit.setBounds(200,360,150,25);
        add(tfdeposit);

        add = new JButton("Add");
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.setBounds(50,410,120,30);
//        add.addActionListener(this);
        add(add);

        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(200,410,120,30);
//        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fifth.png"));
        Image i2 = i1.getImage().getScaledInstance(300,400,Image.SCALE_DEFAULT);
        //convert i2 back to img icon:
        ImageIcon i3 = new ImageIcon(i2);
        image = new JLabel(i3);
        image.setBounds(400,50,300,400);
        add(image);

        setBounds(350,200,800,550);
        setVisible(true);
    }
    public void addNextButtonListener(ActionListener listener) {
            add.addActionListener(listener);
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
    private class AddCustomerController implements ActionListener {
        private AddCustomerModel model;
        private AddCustomerView view;
        
        AddCustomerController(AddCustomerModel model, AddCustomerView view) {
            this.model = model;
            this.view = view;
            view.addNextButtonListener(this);
        }
        
        public void actionPerformed(ActionEvent ae) {
            view.close();
            if(ae.getSource()==view.add){
            String id = (String) view.comboid.getSelectedItem();
            String number = view.tfnumber.getText();
            String name = view.tfname.getText();
            String gender = null;
            if(view.rmale.isSelected()) {gender="Male";}
            else if(view.rfemale.isSelected()) {gender = "Female";}
            else   { JOptionPane.showMessageDialog(null,"Choose Gender");}
            String country = view.tfcountry.getText();
            String room = view.croom.getSelectedItem();//no type cast of obj is needed
            String time = view.checkintime.getText();
            String deposit = view.tfdeposit.getText();
            Integer deposit1 = Integer.valueOf(deposit);
            if (number.length()!=12 || number.equals("")){
                JOptionPane.showMessageDialog(null,"Enter Valid Id number");
                return;
            }
            if (name.equals("") || country.equals("")){
                JOptionPane.showMessageDialog(null,"Enter All fields");
                return;
            }

            if (deposit1.equals("") || deposit1<500 ){
                JOptionPane.showMessageDialog(null,"Enter Minimum deposit of 500rs");
                return;
            }
            model.connect(id,number,name,gender,country,room,time,deposit,hidi);

            
        }else if(ae.getSource()==view.back){
            
             setVisible(false);
        }

        }
    }
    
     public AddCustomer(String hidi) {
        AddCustomerModel model = new AddCustomerModel();
        AddCustomerView view = new AddCustomerView(hidi);
        AddCustomerController controller = new AddCustomerController(model, view);
    }
    
    public static void main(String[] args) {
        new AddCustomer(hidi);
    }
}