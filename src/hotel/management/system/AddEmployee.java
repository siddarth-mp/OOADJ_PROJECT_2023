/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.*;
/**
 *
 * @author Umesh
 */
public class AddEmployee extends JFrame implements ActionListener{
    public static String hidi;

    JTextField tfname,tfemail,tfphone,tfage,tfsalary,tfaadhar;
    JRadioButton rbmale,rbfemale;
    JButton submit,bk;
    JComboBox cbjob;

    AddEmployee(String hid){
        hidi = hid;
        setLayout(null); //i want my own frame/layout so default one is not needed

        //create "NAME" FIELD
        JLabel lblname = new JLabel("NAME");
        lblname.setBounds(60,30,120,30);
        lblname.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lblname);

        //create textfield to hold name :
         tfname = new JTextField();
        tfname.setBounds(200,30,150,30);
        add(tfname);

        //create "AGE" FIELD
        JLabel lblage = new JLabel("AGE");
        lblage.setBounds(60,80,120,30);
        lblage.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lblage);

        //create textfield to hold age :
         tfage = new JTextField();
        tfage.setBounds(200,80,150,30);
        add(tfage); // here 30+30=60 for name label;so for age label+value holder set y>60

        //create "GENDER" FIELD
        JLabel lblgender = new JLabel("GENDER");
        lblgender.setBounds(60,130,120,30); //give y=greater than(80+30)
        lblgender.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lblgender);

        //create radiobuton : male,female
         rbmale = new JRadioButton("Male");
        rbmale.setBounds(200,130,70,30);
        rbmale.setFont(new Font("Tahoma",Font.PLAIN,14));
        rbmale.setBackground(Color.WHITE);
        add(rbmale);

         rbfemale = new JRadioButton("Female");
        rbfemale.setBounds(280,130,70,30);
        rbfemale.setFont(new Font("Tahoma",Font.PLAIN,14));
        rbfemale.setBackground(Color.WHITE);
        add(rbfemale);

        //to avoid selecting both radiobuttons: by grouping them
        ButtonGroup bg = new ButtonGroup();
        bg.add(rbmale);
        bg.add(rbfemale);

        //create JOB Field
        JLabel lbljob = new JLabel("JOB");
        lbljob.setBounds(60,180,120,30); //give y=greater than(80+30)
        lbljob.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lbljob);

        //create drop down:
        String str[] = {"Front Desk Clerks","Porters","Housekeeping","Kitchen Staff","Room Service","Waiter/Waitress","Manager","Accountant","Chef"};
         cbjob = new JComboBox(str);
        cbjob.setBounds(200,180,150,30);
        cbjob.setBackground(Color.WHITE);
        add(cbjob);


        //create "SALARY" FIELD
        JLabel lblsalary = new JLabel("SALARY");
        lblsalary.setBounds(60,230,120,30); // 210>180+30
        lblsalary.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lblsalary);

        //create textfield to hold SALARY :
         tfsalary = new JTextField();
        tfsalary.setBounds(200,230,150,30);
        add(tfsalary);


        //create "PHONE" FIELD
        JLabel lblphone = new JLabel("PHONE");
        lblphone.setBounds(60,280,120,30); // 280>230+30(from previous)
        lblphone.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lblphone);

        //create textfield to hold PHONE :
         tfphone = new JTextField();
        tfphone.setBounds(200,280,150,30);
        add(tfphone);


        //create "EMAIL" FIELD
        JLabel lblemail = new JLabel("E-MAIL");
        lblemail.setBounds(60,330,120,30); // 330>280+30
        lblemail.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lblemail);

        //create textfield to hold EMAIL :
         tfemail = new JTextField();
        tfemail.setBounds(200,330,150,30);
        add(tfemail);

        //create "AADHAR" FIELD
        JLabel lblaadhar = new JLabel("AADHAR ID");
        lblaadhar.setBounds(60,380,120,30); //380>330+30(from email)
        lblaadhar.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lblaadhar);

        //create textfield to hold AADHAR :
        tfaadhar = new JTextField();
        tfaadhar.setBounds(200,380,150,30); //380>330+30(from email)
        add(tfaadhar);


        //create submit button
         submit = new JButton("SUBMIT");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setBounds(80,430,150,30);
        submit.addActionListener(this);
        add(submit);

        bk = new JButton("Cancel");
        bk.setBackground(Color.BLACK);
        bk.setForeground(Color.WHITE);
        bk.setBounds(250,430,150,30);
        bk.addActionListener(this);
        add(bk);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/tenth.jpg"));
        Image i2 = i1.getImage().getScaledInstance(450,450,Image.SCALE_DEFAULT); // resize the image previously it was enlarged
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(380,60,450,370); //where to place the image (coords)
        add(image);

        //for main layout
        getContentPane().setBackground(Color.WHITE);
        setBounds(350,200,850,600);
        setVisible(true);

    }
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == bk) {
            setVisible(false);
            //new Dashboard();
        } else {
            //take dt from text field
            String name = tfname.getText();
            String age = tfage.getText();
            String salary = tfsalary.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();
            String aadhar = tfaadhar.getText();
            //take value from radio button
            String gender = null;

            if (name.equals("")) {
                JOptionPane.showMessageDialog(null, "Name should not be empty");
                return;
            }
            if (salary.equals("")) {
                JOptionPane.showMessageDialog(null, "Salary should not be empty");
                return;
            }
            if (age.equals("")) {
                JOptionPane.showMessageDialog(null, "Age should not be empty");
                return;
            }

//            if (email.equals("") || email.contains("@") || email.contains(".com")) {
//                JOptionPane.showMessageDialog(null, "Enter valid E-Mail id");
//                return;
//            }
            if (aadhar.length() != 12 || aadhar.equals("")) {
                JOptionPane.showMessageDialog(null, "Enter valid aadhar");
                return;
            }
            if (phone.length() != 10 || phone.equals("")) {
                JOptionPane.showMessageDialog(null, "Enter valid Contact number");
                return;
            }


            //check which one is selected:
            if (rbmale.isSelected()) {
                gender = "Male";
            } else if (rbfemale.isSelected()) {
                gender = "Female";
            } else if (gender == null) {
                JOptionPane.showMessageDialog(null, "Choose appropriate gender");
                return;
            }
            //take value from dropdown(combobox):
            //getselecteditem returns object, so type cast it to string
            String job = (String) cbjob.getSelectedItem();

            try {
                //need to make a aquery
                Conn conn = new Conn();

                String query = "insert into employee values ('" + name + "','" + age + "','" + gender + "','" + job + "','" + salary + "','" + phone + "','" + email + "','" + aadhar + "' ,'"+hidi+"')";
                //here need to inser5t dt to tbl: so in login we just need to use execute bu here like in case of update/add/drop/ins: executeUpdt
                conn.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Employee added Successfully!!");
                setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }



    public static void main(String[] args){
        new AddEmployee(hidi);
    }
}
