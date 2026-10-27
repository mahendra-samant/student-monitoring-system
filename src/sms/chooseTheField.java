package sms;
import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;


public class chooseTheField extends JFrame implements ActionListener {

    Font font = new Font("Tahoma",Font.BOLD,20);
    JButton att,marks,detail,back,home;
    JLabel ch;
    chooseTheField(){
        setSize(750,380);

        ch = new JLabel("Choose The Field");
        ch.setBounds(300,20,290,100);
        ch.setFont(font);
        ch.setForeground(Color.white);
        add(ch);

        att= new JButton("Attendance");
        att.setBounds(50,250,150,60);
        att.addActionListener(this);
        add(att);

        marks= new JButton("Marks");
        marks.setBounds(300,250,150,60);
        marks.addActionListener(this);
        add(marks);

        detail= new JButton("Details");
        detail.setBounds(550,250,150,60);
        detail.addActionListener(this);
        add(detail);

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
        home.setBounds(690,0,50,50);
        add(home);

        ImageIcon i5= new ImageIcon(ClassLoader.getSystemResource("images/b44.jpg"));
        JLabel i6 = new JLabel(i5);
        i6.setBounds(0,0,750,380);
        add(i6);


        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==att){
            new attendance();
            this.setVisible(false);
        }

        if(ae.getSource()==marks){
            new marks();
            this.setVisible(false);
        }

        if(ae.getSource()==detail){
            new viewDetails();
            this.setVisible(false);
        }

        if (ae.getSource() == home) {
            new dashboard();
            this.setVisible(false);


        }
        if (ae.getSource() == back) {
            new selectStd();
            this.setVisible(false);
        }

    }




    public static void main(String[] args) {
        new chooseTheField();
    }
}

