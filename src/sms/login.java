package sms;
import com.mysql.cj.protocol.Resultset;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class login extends JFrame implements ActionListener {

    JButton signin, cancel;
    JTextField username ;
    JPasswordField password;

    login(){
        setSize(600,400);






        JLabel l1 =new JLabel("Username");
        l1.setBounds(60,80,150,50);
        l1.setFont(new Font("Tahoma",Font.BOLD,20));
        l1.setForeground(Color.white);
        add(l1);

        JLabel l2 = new JLabel("Password");
        l2.setBounds(60,160,150,50);
        l2.setFont(new Font("Tahoma",Font.BOLD,20));
        l2.setForeground(Color.white);
        add(l2);

        username = new JTextField();
        username.setBounds(250,80,150,40);
        username.setFont(new Font("Segeo",Font.BOLD,20));
        add(username);

        password =new JPasswordField();
        password.setBounds(250,160,150,40);
        add(password);

        signin = new JButton("Sign In");
        signin.setBounds(440,280,100,50);
        signin.setFont(new Font("Tahoma",Font.BOLD , 12));
        signin.addActionListener(this);
        add(signin);

        cancel = new JButton("Cancel");
        cancel.setBounds(40,280,120,50);
        cancel.setFont(new Font("Tahoma",Font.BOLD , 20));
        cancel.setBackground(Color.RED);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);


        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("images/b15.jpg"));
        JLabel i3 = new JLabel(i1);
        i3.setBounds(0,0,600,400);
        add(i3);



        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);

    }
    public void actionPerformed(ActionEvent ae){


        if (ae.getSource() == signin) {
            String username = this.username.getText();
            String password = String.valueOf(this.password.getPassword());

            conn c = new conn();
            try {
                String str1 = "select * from login where username = '" + username + "' and password = '" + password + "';";
                ResultSet rs = c.s.executeQuery(str1);
                if (rs.next()) {
                    JOptionPane.showMessageDialog(null, "Login successfull!");
                    this.setVisible(false);

                    if (ae.getSource() == signin) {
                        new dashboard();
                        this.setVisible(false);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid login credentials");
                }
            } catch (Exception e) {
                System.out.println(e);
            }

        }



        if(ae.getSource()==cancel){
            new starter();
            this.setVisible(false);

        }




    }


    public static void main(String[] args) {
        new login();
    }
}
