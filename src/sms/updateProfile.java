package sms;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class updateProfile extends JFrame implements ActionListener {
    JLabel l1,l2,l3,l4;
    JTextField gr,data;
    JButton disp,submit,back,home;
    JComboBox fields;
    JTable t1;
    JScrollPane sp1;
    String [] list = {"name","address","aadhar","phoneno","gender"};



    updateProfile(){
        setSize(900,580);

        l1 = new JLabel("GR Number");
        l1.setBounds(80,40,150,50);
        add(l1);

        gr= new JTextField();
        gr.setBounds(250,40,150,40);
        add(gr);

        disp= new JButton("Display");
        disp.setBounds(450,40,100,40);
        disp.addActionListener(this);
        add(disp);

        sp1 = new JScrollPane();
        sp1.setBounds(50,170,770,60);
        add(sp1);

        t1= new JTable();
        sp1.setViewportView(t1);


        l2 = new JLabel("Choose Fields");
        l2.setBounds(80,300,150,50);
        add(l2);

        //combobox
        fields = new JComboBox(list);
        fields.setBounds(300,300,150,40);
        add(fields);

        l3= new JLabel("Updated Value");
        l3.setBounds(80,380,150,50);
        add(l3);

        data =new JTextField();
        data.setBounds(300,380,150,40);
        add(data);

        submit = new JButton("Update Data");
        submit.setBounds(400,450,180,50);
        submit.addActionListener(this);
        add(submit);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/back.png"));
        Image i2= i1.getImage().getScaledInstance(50,50,Image.SCALE_SMOOTH);
        ImageIcon i3= new ImageIcon(i2);

        back = new JButton(i3);
        back.addActionListener(this);
        back.setBounds(0,0,50,50);
        add(back);

        ImageIcon i10 = new ImageIcon(ClassLoader.getSystemResource("images/home.jpg"));
        Image i12= i10.getImage().getScaledInstance(50,50,Image.SCALE_SMOOTH);
        ImageIcon i13= new ImageIcon(i12);

        home = new JButton(i13);
        home.addActionListener(this);
        home.setBounds(840,0,50,50);
        add(home);



        ImageIcon i100= new ImageIcon(ClassLoader.getSystemResource("images/b5.jpg"));
        JLabel i300 = new JLabel(i100);
        i300.setBounds(0,0,900,580);
        add(i300);




        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public  void actionPerformed(ActionEvent ae){
        if(ae.getSource()==disp){
            String gr =this.gr.getText();
            conn c = new conn();
            try {
                String str = "select name ,address, dob , aadhar , phoneno ,gender from stud_details where gr = '"+gr+"';";
                ResultSet rs = c.s.executeQuery(str);
                t1.setModel(DbUtils.resultSetToTableModel(rs));

            }catch (Exception e){
                System.out.println(e);
            }
        }

        if(ae.getSource()==submit){
            String gr=this.gr.getText();
            String value =this.data.getText();
            String choice =fields.getSelectedItem().toString();


            conn c = new conn();
            try {
                String  str = "update stud_details set "+choice+"='"+value+"' where gr ='"+gr+"';";

                c.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null,"Data Updated Successfully!");

            }catch (Exception e){
                System.out.println(e);
            }
        }
        if (ae.getSource() == home) {
            new dashboard();
            this.setVisible(false);


        }
        if (ae.getSource() == back) {
            new viewDetails();
            this.setVisible(false);
        }

    }

    public static void main(String[] args) {
        new updateProfile();
    }
}


