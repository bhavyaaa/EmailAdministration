package emailapp;

import java.util.*;
import java.io.*;

public class Email {
    public Scanner s = new Scanner(System.in);
    private String fname;
    private String lname;
    private String dept;
    private String email;
    private String password;
    private int mailCapacity = 500;
    private String alter_email;

    public Email(String fname, String lname) {
        this.fname = fname;
        this.lname = lname;
        System.out.println("New Employee:" + this.fname + " " + this.lname);
        this.dept= this.setDept();
        this.password= this.generate_password(8);
        this.email = this.generate_email();
    }

    private String generate_email() {
        return this.fname.toLowerCase() + "." + this.lname.toLowerCase() + "@" + this.dept.toLowerCase();
    }

    private String setDept() {
        System.out.println("Department Codes \n1 Sales \n2 Development \n3 Accounting \n0 Prefer not to say");
        boolean flag = false;
        do {
            System.out.println("Enter Department Code");
            int choice = s.nextInt();
            switch (choice) {
                case 1:
                    return "Sales";
                case 2:
                    return "Development";
                case 3:
                    return "Accounting";
                case 0:
                    return "Prefer not to say";
                default:
                    System.out.println("Invalid Choice");
            }
        } while (!flag);
        return null;
    }

    private String generate_password(int length) {
        Random r = new Random();
        String Capital_chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String Small_chars = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";
        String symbols = "!@#$%^&*-?";
        String values = Capital_chars + Small_chars + numbers + symbols;
        String password = "";
        for (int i = 0; i < length; i++) {
            password = password + values.charAt(r.nextInt(values.length()));
        }
        return password;
    }

    public void set_password() {
        boolean flag = false;
        do {
            System.out.println("Do you want to change your password(Y/N)");
            char choice = s.next().charAt(0);
            if (choice == 'Y' || choice == 'y') {
                flag = true;
                System.out.println("Enter Current Password:");
                String temp = s.next();
                if (temp.equals(this.password)) {
                    System.out.println("Enter new password:");
                    this.password = s.next();
                    System.out.println("Password changed successfully");
                } else {
                    System.out.println("Incorrect password");
                }
            } else if (choice == 'N' || choice == 'n') {
                flag = true;
                System.out.println("Password changed option cancelled");
            } else {
                System.out.println("Invalid choice");
            }
        } while (!flag);
    }

    public void set_mailCap() {
        System.out.println("Current capacity= " + this.mailCapacity + "mb");
        System.out.println("Enter new mail box capacity:");
        this.mailCapacity = s.nextInt();
        System.out.println("Mailbox capacity is successfully changed");
    }

    public void alternate_email() {
        System.out.println("Enter new alternate mail:");
        this.alter_email = s.next();
        System.out.println("Alternate email is set");
    }

    public void getInfo() {
        System.out.println("New:" + this.fname + " " + this.lname);
        System.out.println("Department:" + this.dept);
        System.out.println("Email:" + this.email);
        System.out.println("Password: " + this.password);
        System.out.println("Mailbox Capacity: " + this.mailCapacity + "mb");
        System.out.println("Alternate mail: " + this.alter_email);
    }
    public void storefile(){
        try{
            FileWriter in = new FileWriter("C:\\Users\\DELL\\Desktop\\info.txt");
            in.write("First name: "+this.fname);
            in.append("\nLast name: "+this.lname);
            in.append("\nEmail: "+this.email);
            in.append("\nPassword: "+ this.password);
            in.append("\nCapacity "+this.mailCapacity);
            in.append("\nAlternate Mail"+this.alter_email);
            in.close();
            System.out.println("Data stored!");
        }catch(Exception e){
            System.out.println(e);
        }
    }
    public void read_file(){
        try{
            FileReader f1 = new FileReader("C:\\Users\\DELL\\Desktop\\info.txt");
            int i;
            while((i=f1.read())!=-1){
                System.out.print((char)i);
            }
            f1.close();
        }catch(Exception e){
            System.out.println(e);
        }
        }
}
