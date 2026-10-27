package sms;

import net.proteanit.sql.DbUtils;

import javax.imageio.stream.ImageInputStream;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class attendance extends JFrame implements ActionListener {

    JButton add , defaulters , refresh;
    JTable t1;
    JScrollPane sp1;
    JButton back , home;

    attendance(){
        setSize(1000,500);

        //Scrollpane code
        sp1 = new JScrollPane();
        sp1.setBounds(550,80,400,300);
        this.add(sp1);

        //Table code
        t1 = new JTable();


        sp1.setViewportView(t1);
        displayOriginal();


        //button code

        add = new JButton("Add/ Update");
        add.setBounds(70,80,150,70);
        add.addActionListener(this);
        this.add(add);

        defaulters = new JButton("Defaulters");
        defaulters.setBounds(70,280,150,70);
        defaulters.addActionListener(this);
        this.add(defaulters);




        ImageIcon i5 = new ImageIcon(ClassLoader.getSystemResource("images/sync.png"));


        Image i6 = i5.getImage().getScaledInstance(40,40,Image.SCALE_SMOOTH);

        ImageIcon i7 = new ImageIcon(i6);

        refresh = new JButton(i7);
        refresh.setBounds(850,390,40,40);
        refresh.addActionListener(this);
        add(refresh);


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
        home.setBounds(940,0,50,50);
        add(home);

        ImageIcon i100= new ImageIcon(ClassLoader.getSystemResource("images/b144.jpg"));
        JLabel i300 = new JLabel(i100);
        i300.setBounds(0,0,1000,500);
        add(i300);

        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    void displayOriginal(){
        try{
            conn c = new conn();
            String str = "select gr,name, attendance from stud_details;";
            ResultSet rs = c.s.executeQuery(str);
            t1.setModel(DbUtils.resultSetToTableModel(rs));


        }catch (Exception e){
            System.out.println(e);
        }
    }
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == defaulters) {
            conn c = new conn();
            try {
                String str = "select gr ,name , attendance from stud_details where attendance <50;";
                ResultSet rs = c.s.executeQuery(str);
                t1.setModel(DbUtils.resultSetToTableModel(rs));

            } catch (Exception e) {
                System.out.println(e);
            }
        }
        if (ae.getSource() == refresh) {
            displayOriginal();
        }
        if (ae.getSource() == add) {
            new addAttendance();
            this.setVisible(false);
        }
        if (ae.getSource() == home) {
            new dashboard();
            this.setVisible(false);


        }
        if (ae.getSource() == back) {
            new chooseTheField();
            this.setVisible(false);
        }
    }

    public static void main(String[] args) {

        new attendance();
    }
}

