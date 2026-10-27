package sms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class conn {
    Connection c;
    Statement s;
    conn(){
        String username = "root";
        String password = "YOUR_MYSQL_PASSWORD";
        String url = "jdbc:mysql://localhost:3306/student_monitoring";

        try {
            c = DriverManager.getConnection(url , username , password);
            s = c.createStatement();
            System.out.println("Connection Successfull");
        }catch (Exception e){
            System.out.println(e);
            System.out.println("Failed!");
        }
    }

    public static void main(String[] args) {

        conn c = new conn();
    }
}
//query for total =SELECT gr,name,address,aadhar,phoneno,gender,bldgrp,dob,attendance,english,maths,science,history,geography,marathi,(english+maths+science+history+geography+marathi) AS total FROM sysmonsys2.stud_details;

//query for error which was occured due to gr no

//USE sysmonsys2;
//ALTER TABLE STUD_DETAILS MODIFY COLUMN gr INT AUTO_INCREMENT;
//ALTER TABLE STUD_DETAILS AUTO_INCREMENT = 1001;