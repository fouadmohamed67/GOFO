import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * class app
 * @author Osama Salah Abdelmoniem 20180039
 * @author Marwan Galal Mohamed 20180268
 * @author fouad mohamed fouad    20180198
 * @author Abdelrahman Ammar Abbas    20180146
 */
public class app {
    private final List<player> allPlayers = new ArrayList<>();
    private final List<owner> allOwners = new ArrayList<>();

    /**
     * utility function to check if th string has alphabetic only or not
     * @param s string
     * @return boolean
     */
    private boolean checkAlpha(final String s) {
        for (int i = 0; i < s.length(); i++) {
            if ((s.charAt(i) < 'a' || s.charAt(i) > 'z') && ((s.charAt(i) < 'A' || s.charAt(i) > 'Z')))
                return false;
        }
        return true;
    }


    /**
     * utility function to check if the string has numbers only or not
     * @param s string
     * @return boolean
     */
    private boolean checkNum(final String s) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) < '0' || s.charAt(i) > '9')
                return false;
        }
        return true;
    }


    /**
     * utility function to check if the input in a range from 1 to y or not
     * @param y upper bound
     * @param c string
     * @return boolean
     */
    private boolean checkIfValid(final int y, final String c) {
        int checkNumeric = 0;
        try {
            checkNumeric = Integer.parseInt(c);
        } catch (NumberFormatException object) {
            return true;
        }
        return checkNumeric < 1 || checkNumeric > y;
    }

    /**
     * function to display admin menu
     */
    private void adminMenu() {
        System.out.println("----------------------------------------------------------------------------------");
        System.out.println("\t\t\t\t\tHELLO ADMIN");
        System.out.println("1- view requests. ");
        System.out.println("2- approve request. ");
        System.out.println("3- exit");
        String choice = "1";
        System.out.print("Your choice: ");
        Scanner input = new Scanner(System.in);
        choice = input.next();
        while (checkIfValid(3, choice)) {
            System.out.print("Please enter valid choice: ");
            choice = input.next();
        }
        if (choice.equals("1")) {
            Global.administrator.viewRequests();
            adminMenu();
        } else if (choice.equals("2")) {
            if (Global.administrator.sizeOfReq() < 1) {
                System.out.println("There is no requests.");
                adminMenu();
            }
            System.out.print("Enter number of the request: ");
            String c = "1";
            input = new Scanner(System.in);
            c = input.next();
            while (checkIfValid(Global.administrator.sizeOfReq(), c)) {
                System.out.print("Please enter a valid choice: ");
                c = input.next();
            }
            int num = Integer.parseInt(c);
            Global.administrator.approveRequest(num);
            adminMenu();
        } else {
            mainMenu();
        }
    }

    /**
     * function to make an owner to sign up
     */
    private void signUpOwner() {
        System.out.println("----------------------------------------------------------------------------------");
        owner p = new owner();
        Scanner input = new Scanner(System.in);
        String s = "";
        System.out.print("Name: ");
        s = input.next();
        while (!checkAlpha(s)) {
            System.out.print("Please enter a valid name: ");
            s = input.next();
        }
        p.setName(s);
        System.out.print("Mail: ");
        s = input.next();
        p.setMail(s);
        System.out.print("Location: ");
        s = input.next();
        while (!checkAlpha(s)) {
            System.out.print("Please enter a valid location: ");
            s = input.next();
        }
        p.setLocation(s);
        System.out.print("Phone: ");
        s = input.next();
        while (!checkNum(s)) {
            System.out.print("Please enter a valid phone: ");
            s = input.next();
        }
        p.setPhone(s);
        System.out.print("Password: ");
        s = input.next();
        System.out.print("Confirm your Password: ");
        String s2 = "";
        s2 = input.next();
        while (!s.equals(s2)) {
            System.out.print("Two passwords don't match, please reconfirm your password: ");
            s2 = input.next();
        }
        p.setPass(s);
        System.out.println("This is registration code and ID: " + p.getId());
        System.out.print("enter your registration code to confirm your account: ");
        s = input.next();
        int num = Integer.parseInt(s);
        while (num != p.getId()) {
            System.out.print("Please enter a valid registration code: ");
            s = input.next();
            num = Integer.parseInt(s);
        }
        allOwners.add(p);

    }

    /**
     * function to make a player to sign up
     */
    private void signUpPlayer() {
        System.out.println("----------------------------------------------------------------------------------");
        player p = new player();
        Scanner input = new Scanner(System.in);
        String s = "";
        System.out.print("Name: ");
        s = input.next();
        while (!checkAlpha(s)) {
            System.out.print("Please enter a valid name: ");
            s = input.next();
        }
        p.setName(s);
        System.out.print("Mail: ");
        s = input.next();
        p.setMail(s);
        System.out.print("Location: ");
        s = input.next();
        while (!checkAlpha(s)) {
            System.out.print("Please enter a valid location: ");
            s = input.next();
        }
        p.setLocation(s);
        System.out.print("Phone: ");
        s = input.next();
        while (!checkNum(s)) {
            System.out.print("Please enter a valid phone: ");
            s = input.next();
        }
        p.setPhone(s);
        System.out.print("Password: ");
        s = input.next();
        System.out.print("Confirm your Password: ");
        String s2 = "";
        s2 = input.next();
        while (!s.equals(s2)) {
            System.out.print("Two passwords don't match, please reconfirm your password: ");
            s2 = input.next();
        }
        p.setPass(s);
        System.out.println("This is registration code and ID: " + p.getId());
        System.out.print("enter your registration code to confirm your account: ");
        s = input.next();
        int num = Integer.parseInt(s);
        while (num != p.getId()) {
            System.out.print("Please enter a valid registration code: ");
            s = input.next();
            num = Integer.parseInt(s);
        }
        allPlayers.add(p);

    }

    /**
     * function to check if a specific owner is in the system or not
     * @param id id of that owner
     * @return string
     */
    private String ifExistOwner(final int id) {
        for (int i = 0; i < allOwners.size(); i++) {
            if (allOwners.get(i).getId() == id)
                return "owner";
        }
        return "no";
    }

    /**
     * function to check if a specific player is in the system or not
     * @param id id of that player
     * @return string
     */
    private String ifExistPlayer(final int id) {
        for (int i = 0; i < allPlayers.size(); i++) {
            if (allPlayers.get(i).getId() == id)
                return "player";
        }
        return "no";
    }

	
	/**
     * function to check if a specific user is in the system or not
     * @param id id of that user
     * @return string
     */
    private String ifExistUser(final int id) {
        if (ifExistPlayer(id).equals("player"))
            return ifExistPlayer(id);
        return ifExistOwner(id);
    }

    /**
     * function to check if there is player with specific id and password in the system
     * or not
     * @param id    id of the player
     * @param pass  password of the player
     * @return boolean
     */
    private boolean searchPlayer(final int id, final String pass) {
        int ind = 0;
        for (int i = 0; i < allPlayers.size(); i++) {
            if (allPlayers.get(i).getId() == id && allPlayers.get(i).getPass().equals(pass)) {
                return true;
            }
        }
        return false;
    }

    /**
     * function to get a player with specific id
     * @param id    if of that player
     * @return player
     */
    private player getPlayer(final int id) {
        int ind = 0;
        for (int i = 0; i < allPlayers.size(); i++) {
            if (allPlayers.get(i).getId() == id) {
                ind = i;
                break;
            }
        }
        return allPlayers.get(ind);
    }

    /**
     * function to check if there is owner with specific id and password in the system
     * or not
     * @param id    id of the owner
     * @param pass  password of the owner
     * @return boolean
     */
    private boolean searchOwner(final int id, final String pass) {
        int ind = 0;
        for (int i = 0; i < allOwners.size(); i++) {
            if (allOwners.get(i).getId() == id && allOwners.get(i).getPass().equals(pass)) {
                return true;
            }
        }
        return false;
    }

    /**
     * function to get a owner with specific id
     * @param id    if of that owner
     * @return owner
     */
    private owner getOwner(final int id) {
        int ind = 0;
        for (int i = 0; i < allOwners.size(); i++) {
            if (allOwners.get(i).getId() == id) {
                ind = i;
                break;
            }
        }
        return allOwners.get(ind);
    }

    /**
     * function to display all playgrounds in the system
     * @param p the player who wants to that
     */
    private void viewPlaygrounds(player p) {
        System.out.println("1- View all playgrounds.");
        System.out.println("2- View playgrounds within specific location.");
        System.out.println("3- View playground within specific name.");
        System.out.println("4- Exit.");
        String choice = "1";
        System.out.print("Your choice: ");
        Scanner input = new Scanner(System.in);
        choice = input.next();
        while (checkIfValid(4, choice)) {
            System.out.print("Please enter valid choice: ");
            choice = input.next();
        }
        if (choice.equals("1")) {
            playground.displayall();
            viewPlaygrounds(p);
        }
        if (choice.equals("2")) {
            String loc = "";
            System.out.print("Location: ");
            loc = input.next();
            while (!checkAlpha(loc)) {
                System.out.print("Please enter a valid location: ");
                loc = input.next();
            }
            loc = loc.toLowerCase();
            if (!playground.displayByLocation(loc))
                System.out.println("There is no playground in this location.");
            viewPlaygrounds(p);
        }
        if (choice.equals("3")) {
            String name = "";
            System.out.print("Name: ");
            name = input.next();
            while (!checkAlpha(name)) {
                System.out.print("Please enter a valid name: ");
                name = input.next();
            }
            name = name.toLowerCase();
            if (!playground.displayByName(name))
                System.out.println("There is no playground with this name.");
            viewPlaygrounds(p);
        } else
            playerMenu(p);

    }

    /**
     * function to check if a playground with a specific name is un system or not
     * @param name name of playground
     * @return boolean
     */
    private boolean ifExistPlayground(final String name) {
        for (int i = 0; i < Global.allPlayground.size(); i++) {
            if (Global.allPlayground.get(i).getName().equals(name))
                return true;
        }
        return false;
    }

    /**
     * function to get playground with specific name
     * @param name name of playground
     * @return  playground
     */
    private playground searchPlayground(final String name) {
        int ind = 0;
        for (int i = 0; i < Global.allPlayground.size(); i++) {
            if (Global.allPlayground.get(i).getName().equals(name)) {
                ind = i;
                break;
            }
        }
        return Global.allPlayground.get(ind);
    }

};
