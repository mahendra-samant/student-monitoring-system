package sms;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class starter extends JFrame implements ActionListener {
    JButton login,exit;
    starter(){
        setSize(800,600);

        JLabel l1 =new JLabel("Pandurang Vidyalaya");
        l1.setBounds(220,50,400,100);
        l1.setFont(new Font("Tahoma",Font.BOLD,32));
        add(l1);

       login = new JButton("LOGIN");
        login.setBounds(600,470,100,50);
        login.addActionListener(this);
        add(login);

        exit= new JButton("Exit");
        exit.setBounds(100,470,100,50);
        exit.addActionListener(this);
        add(exit);



        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("images/first1.jpg"));
        JLabel i3 = new JLabel(i1);
        i3.setBounds(0,0,800,600);
        add(i3);

        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);

    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==login){
            new login();
            this.setVisible(false);
        }
        if(ae.getSource()==exit){
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new starter();
    }


}
