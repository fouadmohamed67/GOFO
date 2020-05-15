import java.util.Scanner;


/**
 * class to store information of the user (player / owner)
 * @author fouad mohamed fouad    20180198
 */

public class user {
    private String name, pass, mail, location, phone;
    private int ID;
    private static int id = 0;

    /**
     * constructor to initialize id of the user and increment static variable
     * of ids by one
     */
    public user() {
        id++;
        ID = id;
    }

    /**
     * parameterized constructor to initialize information of the player
     * @param name name of the user
     * @param pass password of the user
     * @param mail mail of the user
     * @param location location of the user
     * @param phone phone of the user
     */
    public user(String name, String pass, String mail, String location, String phone) {
        this.name = name;
        this.pass = pass;
        this.mail = mail;
        this.location = location;
        this.phone = phone;
    }

    /**
     * name getter
     * @return String
     */
    public String getName() {
        return name;
    }

    /**
     * id getter
     * @return int
     */
    public int getId() {
        return ID;
    }

    /**
     * password getter
     * @return String
     */
    public String getPass() {
        return pass;
    }

    /**
     * setter to name
     * @param name name of the user
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * password setter
     * @param pass password of the user
     */
    public void setPass(String pass) {
        this.pass = pass;
    }
    /**
     * mail setter
     * @param mail mail of the user
     */
    public void setMail(String mail) {
        this.mail = mail;
    }
    /**
     * location setter
     * @param location location of the user
     */
    public void setLocation(String location) {
        this.location = location;
    }
    /**
     * phone setter
     * @param phone phone of the user
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }
}