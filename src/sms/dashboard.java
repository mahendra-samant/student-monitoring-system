package sms;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class dashboard extends JFrame implements ActionListener {

    JMenuBar mb;
    JButton prim, sec , highSec, logout;


    dashboard(){
        setSize(700,500);

        mb = new JMenuBar();
        mb.setBounds(0,0,150,500);
        mb.setBackground(Color.BLUE);
        mb.setBackground(Color.getColor("gray",40));
        mb.setLayout(new GridLayout(5,1,0,20));
        add(mb);

        //adding buttons
        prim = new JButton("Primary");
        prim.addActionListener(this);
        mb.add(prim);

        sec = new JButton("Secondary");
        sec.addActionListener(this);
        mb.add(sec);

        highSec = new JButton("Higher Secondary");
        highSec.addActionListener(this);
        mb.add(highSec);

        logout= new JButton("Log Out");
        logout.addActionListener(this);
        mb.add(logout);






        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("images/b00.png"));
        JLabel i3 = new JLabel(i1);
        i3.setBounds(150,0,550,500);
        add(i3);


        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==prim){
            new selectStd();
            this.setVisible(false);
        }
        if(ae.getSource()==logout){
            new starter();
            this.setVisible(false);

        }
    }

    public static void main(String[] args) {
        new dashboard();
    }
}
