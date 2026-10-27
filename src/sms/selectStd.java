package sms;

//import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class selectStd extends JFrame implements ActionListener{
    Font font = new Font("Tahoma",Font.BOLD,20);
    JButton first,sec,third,fourth,back,home;
    JLabel select;

    selectStd(){
        setSize(750,380);

        select = new JLabel("Select The standard");
        select.setBounds(200,20,290,100);
        select.setFont(font);
        select.setForeground(Color.RED);
        add(select);

        first= new JButton("1st Standard");
        first.setBounds(50,150,150,40);
        first.addActionListener(this);
        add(first);

        sec= new JButton("2nd Standard");
        sec.setBounds(300,150,150,40);
        sec.addActionListener(this);
        add(sec);

        third= new JButton("3rd Standard");
        third.setBounds(50,250,150,40);
        third.addActionListener(this);
        add(third);

        fourth= new JButton("4th Standard");
        fourth.setBounds(300,250,150,40);
        fourth.addActionListener(this);
        add(fourth);


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

        ImageIcon i100= new ImageIcon(ClassLoader.getSystemResource("images/b12.jpg"));
        JLabel i300 = new JLabel(i100);
        i300.setBounds(0,0,750,380);
        add(i300);

        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);

    }
    public void actionPerformed(ActionEvent ae) {


        if (ae.getSource() == first) {
            new chooseTheField();
            this.setVisible(false);
        }

        if (ae.getSource() == sec) {
            new chooseTheField();
            this.setVisible(false);
        }

        if (ae.getSource() == third) {
            new chooseTheField();
            this.setVisible(false);
        }

        if (ae.getSource() == fourth) {
            new chooseTheField();
            this.setVisible(false);
        }

        if (ae.getSource() == home) {
            new dashboard();
            this.setVisible(false);


        }
        if (ae.getSource() == back) {
            new dashboard();
            this.setVisible(false);
        }



    }










    public static void main(String[] args) {
        new selectStd();
    }
}
