package sms;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;


public class addAttendance extends JFrame implements ActionListener {

    JLabel l1, l2;
    JTextField gr, att;
    JButton display,submit,back,home;
    JScrollPane sp1;
    JTable t1;
    addAttendance(){
        setSize(550,600);

        l1 = new JLabel("GR NO");
        l1.setBounds(70,50,120,50);
        l1.setForeground(Color.WHITE);
        add(l1);


        gr = new JTextField();
        gr.setBounds(190,50,150,50);
        add(gr);

        display = new JButton("Display");
        display.setBounds(390,50,100,50);
        display.addActionListener(this);
        add(display);

        sp1 = new JScrollPane();
        sp1.setBounds(30,180,480,50);
        add(sp1);

        t1 = new JTable();
        sp1.setViewportView(t1);

        l2 = new JLabel("Add / Update Record ");
        l2.setBounds(60,300,130,50);
        l2.setForeground(Color.WHITE);
        add(l2);

        att= new JTextField();
        att.setBounds(250,300,130,50);
        add(att);

        submit= new JButton("Submit");
        submit.setBounds(180,450,100,50);
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
        home.setBounds(490,0,50,50);
        add(home);

        ImageIcon i100= new ImageIcon(ClassLoader.getSystemResource("images/b91.jpg"));
        JLabel i300 = new JLabel(i100);
        i300.setBounds(0,0,550,600);
        add(i300);

        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);

    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==display){
            String gr = this.gr.getText();
            conn c = new conn();
            try{
                String str ="select name , gr , attendance from stud_details where gr = '"+gr+"';";
                ResultSet rs = c.s.executeQuery(str);
                t1.setModel(DbUtils.resultSetToTableModel(rs));

            }catch(Exception e){
                System.out.println(e);
            }
        }
        if(ae.getSource()==submit){
            String gr = this.gr.getText();
            String attend = this.att.getText();
            conn c = new conn();
            try{
                String str1 ="update stud_details  set attendance = '"+attend+"' where gr='"+gr+"';";
                c.s.executeUpdate(str1);
                JOptionPane.showMessageDialog(null,"Attendance Record Updated Successfully!!");



            }catch(Exception e){
                System.out.println(e);
            }
        }

        if (ae.getSource() == home) {
            new dashboard();
            this.setVisible(false);


        }
        if (ae.getSource() == back) {
            new attendance();
            this.setVisible(false);
        }
    }

    public static void main(String[] args) {
        new addAttendance();
    }
}
