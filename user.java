import java.util.Scanner;

public class user {
    private String name, pass, mail, location, phone;
    private int ID;
    private static int id = 0;

    public user() {
        id++;
        ID = id;
    }

    public user(String name, String pass, String mail, String location, String phone) {
        this.name = name;
        this.pass = pass;
        this.mail = mail;
        this.location = location;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return ID;
    }

    public String getPass() {
        return pass;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}