package sms;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class marks extends JFrame implements ActionListener {
    JTabbedPane tabs;
    JTabbedPane tabsPass,tabsFail;
    JScrollPane sppass1,sppass2,spfail1,spfail2;
    JLabel l1,l2;
    JTable psem1,psem2,fsem1,fsem2;


    JScrollPane sp1, sp2;
    JTable sem1, sem2;
    JButton addMarks ,back,home;
    JButton passFail , refresh;

    marks(){
        setSize(1000,800);

        tabs = new JTabbedPane();
        tabs.setBounds(300,100,650,600);
        tabs.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(tabs);

        sem1 = new JTable();
        sem2 = new JTable();

        sp1 = new JScrollPane();
        sp1.setViewportView(sem1);

        sp2 = new JScrollPane();
        sp2.setViewportView(sem2);

        getDetails();

        tabs.addTab("SEM 1", sp1);
        tabs.addTab("SEM 2", sp2);

        addMarks =new JButton("Add/Update");
        addMarks.setBounds(60,120,150,50);
        addMarks.addActionListener(this);
        add(addMarks);


        passFail= new JButton("Pass/Fail");
        passFail.setBounds(60,360,150,50);
        passFail.addActionListener(this);
        add(passFail);

        refresh= new JButton("Refresh");
        refresh.setBounds(60,600,150,50);
        refresh.addActionListener(this);
        add(refresh);



        l1 = new JLabel("Passed Students");
        l1.setBounds(400,20,200,50);
        l1.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(l1);
        l1.setVisible(false);



        tabsPass = new JTabbedPane();
        tabsPass.setBounds(400,70,550,300);
        add(tabsPass);
        tabsPass.setVisible(false);

        l2 = new JLabel("Failed Students");
        l2.setBounds(400,390,200,50);
        l2.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(l2);
        l2.setVisible(false);


        tabsFail = new JTabbedPane();
        tabsFail.setBounds(400,440,550,300);
        add(tabsFail);
        tabsFail.setVisible(false);


        sppass1 = new JScrollPane();
        psem1 = new JTable();
        sppass1.setViewportView(psem1);

        sppass2 = new JScrollPane();
        psem2 = new JTable();
        sppass2.setViewportView(psem2);

        spfail1 = new JScrollPane();
        fsem1 =new JTable();
        spfail1.setViewportView(fsem1);

        spfail2 = new JScrollPane();
        fsem2 =new JTable();
        spfail2.setViewportView(fsem2);

        tabsPass.addTab("SEM1",sppass1);
        tabsPass.addTab("SEM2",sppass2);

        tabsFail.addTab("SEM1",spfail1);
        tabsFail.addTab("SEM2",spfail2);





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
        home.setBounds(930,0,50,50);
        add(home);


        ImageIcon i100= new ImageIcon(ClassLoader.getSystemResource("images/b22.jpg"));
        JLabel i300 = new JLabel(i100);
        i300.setBounds(0,0,1000,850);
        add(i300);


        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);


    }

    void getDetails(){
        conn c = new conn();

//        sem1 marks fetching code
        String query1 = "select gr , name , english , maths , science ,total1 from stud_details;";

        try{
            ResultSet rs1 = c.s.executeQuery(query1);
            sem1.setModel(DbUtils.resultSetToTableModel(rs1));
        }catch (Exception e){
            System.out.println(e);
        }

//        sem 2 marks fetching code
        String query2 = "select gr , name, marathi , history, geography , total2 from stud_details;";
        try{
            ResultSet rs2 = c.s.executeQuery(query2);
            sem2.setModel(DbUtils.resultSetToTableModel(rs2));
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    public void actionPerformed(ActionEvent ae){
        UIManager.put("OptionPane.messageFont",new Font("Tahoma", Font.PLAIN, 20));

        if(ae.getSource()==addMarks){
            new addMarks();
            this.setVisible(false);
        }

        if(ae.getSource()==passFail){

            String cutoff = JOptionPane.showInputDialog("Enter the Cutoff Marks");
            conn c= new conn();

            //sem1 ,sem2 passed students
            String query1= "select gr, name, english, maths, science , total1 from stud_details where total1>= '"+cutoff+"';";
            String query2= "select gr, name, marathi, history, geography , total2 from stud_details where total1>= '"+cutoff+"';";

            //sem1,sem2 failed students
            String query3= "select gr, name, english, maths, science , total1 from stud_details where total1< '"+cutoff+"';";
            String query4= "select gr, name, marathi, history, geography , total2 from stud_details where total1< '"+cutoff+"';";

            try{
                ResultSet rs1 = c.s.executeQuery(query1);
                psem1.setModel(DbUtils.resultSetToTableModel(rs1));

                ResultSet rs2 = c.s.executeQuery(query2);
                psem2.setModel(DbUtils.resultSetToTableModel(rs2));

                ResultSet rs3 = c.s.executeQuery(query3);
                fsem1.setModel(DbUtils.resultSetToTableModel(rs3));

                ResultSet rs4 = c.s.executeQuery(query4);
                fsem2.setModel(DbUtils.resultSetToTableModel(rs4));

                tabs.setVisible(false);

                l1.setVisible(true);
                l2.setVisible(true);
                tabsPass.setVisible(true);
                tabsFail.setVisible(true);





            }catch (Exception e){
                System.out.println(e);
            }




        }

        if(ae.getSource()==refresh){
            getDetails();
            tabs.setVisible(true);

            l1.setVisible(false);
            l2.setVisible(false);
            tabsPass.setVisible(false);
            tabsFail.setVisible(false);

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
        new marks();
    }
}



