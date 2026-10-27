package sms;

import com.mysql.cj.protocol.Resultset;
import net.proteanit.sql.DbUtils;

import javax.swing.*;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class viewDetails extends JFrame implements ActionListener {
    JScrollPane sp1;
    JTable details;
    JButton back,home,upPro,newadd;

    viewDetails(){
        setSize(1050,700);

        sp1 = new JScrollPane();
        sp1.setBounds(30,80,1000,400);
        add(sp1);

        details = new JTable();
        details.setFont(new Font("Tahoma", Font.PLAIN, 8));
        details.setRowHeight(26);
        sp1.setViewportView(details);

        getDetails();

        JTableHeader tb1 = details.getTableHeader();
        tb1.setFont(new Font("Tahoma", Font.BOLD, 10));
        tb1.setBackground(Color.cyan);

        upPro = new JButton("Update");
        upPro.setBounds(600,500,100,50);
        upPro.addActionListener(this);
        add(upPro);

        newadd = new JButton("Add new");
        newadd.setBounds(300,500,100,50);
        newadd.addActionListener(this);
        add(newadd);



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
        home.setBounds(990,0,50,50);
        add(home);

        ImageIcon i100= new ImageIcon(ClassLoader.getSystemResource("images/b644.jpg"));
        JLabel i300 = new JLabel(i100);
        i300.setBounds(0,0,1050,700);
        add(i300);




        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
    }


    void getDetails(){
//        data fetching code
        conn c = new conn();
        String query = "select * from stud_details";
        try{
            ResultSet rs = c.s.executeQuery(query);
            details.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==upPro){
            new updateProfile();
            this.setVisible(false);
        }
        if(ae.getSource()==newadd){
            new addDetails();
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
        new viewDetails();
        conn c = new conn();
    }
}
