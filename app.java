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
    
    private void printMonths() {
        String months[] = {"jan", "feb", "mar", "apr", "may", "jun"
                , "jul", "aug", "sep", "oct", "nov", "dec"};
        for (int i = 0; i < 12; i++)
            System.out.print(months[i] + " ");
        System.out.println(" ");
    }

    /**
     * function to check if date in right format or not
     * @param s date
     * @return boolean
     */
    private boolean checkDate(final String s) {
        if (s.length() < 11)
            return false;
        String months[] = {"jan", "feb", "mar", "apr", "may", "jun"
                , "jul", "aug", "sep", "oct", "nov", "dec"};
        String temp = s.substring(0, 3);
        temp = temp.toLowerCase();
        boolean flag = false;
        for (int i = 0; i < 12; i++) {
            if (temp.equals(months[i])) {
                flag = true;
                break;
            }
        }
        if (!flag)
            return false;
        temp = s.substring(3, 5);
        int num = 0;
        try {
            num = Integer.parseInt(temp);
        } catch (NumberFormatException object) {
            return false;
        }
        if (num < 1 || num > 30)
            return false;
        temp = s.substring(5, 7);
        num = 0;
        try {
            num = Integer.parseInt(temp);
        } catch (NumberFormatException object) {
            return false;
        }
        if (num < 0 || num > 23)
            return false;
        char temp2;
        temp2 = s.charAt(7);
        if (temp2 - ':' != 0)
            return false;
        temp = s.substring(8, 10);
        try {
            num = Integer.parseInt(temp);
        } catch (NumberFormatException object) {
            return false;
        }
        if (num < 0 || num > 59)
            return false;
        temp = s.substring(10, s.length());
        try {
            num = Integer.parseInt(temp);
        } catch (NumberFormatException object) {
            return false;
        }
        return true;
    }

    /**
     * function to input date
     * @return String
     */
    private String inputDate() {
        Scanner input = new Scanner(System.in);
        printMonths();
        System.out.print("Enter a month from months which been mentioned above: ");
        String mon = input.next();
        System.out.print("Enter a day from 1 to 30: ");
        String day = input.next();
        while (!checkNum(day)) {
            System.out.print("Enter a valid day: ");
            day = input.next();
        }
        if (day.length() == 1)
            day = "0" + day;
        System.out.println("Time:");
        System.out.print("Enter an hour from 00 to 23: ");
        String hour = input.next();
        while (!checkNum(hour)) {
            System.out.print("Enter a valid day: ");
            hour = input.next();
        }
        if (hour.length() == 1)
            hour = "0" + hour;
        System.out.print("Enter a minute from 00 to 59: ");
        String min = input.next();
        while (!checkNum(min)) {
            System.out.print("Enter a valid minute: ");
            min = input.next();
        }
        if (min.length() == 1)
            min = "0" + min;
        System.out.print("Enter the period of playing: ");
        String period = input.next();
        String Date = mon + day + hour + ":" + min + period;
        if (!checkDate(Date))
            return "no";
        return Date;
    }

    /**
     * send invitation to specific player's team
     * @param p the player
     */
    private void sendInvitation(player p) {
        if (p.getTeam().getSize() > 0)
            p.sendInvitation();
        else
            System.out.println("There is no players in your team.");
        bookPlayground(p);
    }

    /**
     * function to make a specific player to book a playground
     * @param pp the player
     */
    private void bookPlayground(player pp) {
        System.out.println("----------------------------------------------------------------------------------");
        System.out.println("1- Book playground.");
        System.out.println("2- Exit.");
        String choice = "1";
        System.out.print("Your choice: ");
        Scanner input = new Scanner(System.in);
        choice = input.next();
        while (checkIfValid(2, choice)) {
            System.out.println("Please enter valid choice: ");
            choice = input.next();
        }
        if (choice.equals("1")) {
            System.out.print("Name: ");
            String name = input.next();
            while (!checkAlpha(name)) {
                System.out.print("Please enter a valid name: ");
                name = input.next();
            }
            if (!ifExistPlayground(name)) {
                System.out.println("There is no playground with that name.");
                bookPlayground(pp);
            }
            playground p = searchPlayground(name);
            if (!p.getStatus()) {
                System.out.println("This playground didn't approved by administrator.");
                bookPlayground(pp);
            }
            String date = inputDate();
            if (date.equals("no")) {
                System.out.println("Format of date which you input is wrong.");
                bookPlayground(pp);
            } else {
                if (!p.book(date)) {
                    System.out.println("This time will be not available in this playground.");
                    bookPlayground(pp);
                } else if (!p.getStatus()) {
                    System.out.println("This playground didn't approved by administrator.");
                    bookPlayground(pp);
                } else {
                    System.out.println("Your booking is completed successfully.");
                    System.out.println("Do you want to send invitation to your team? (yes/no)");
                    String c = input.next();
                    while (!c.equals("yes") && !c.equals("no")) {
                        System.out.print("Please enter a valid answer: ");
                        c = input.next();
                    }
                    if (c.equals("yes"))
                        sendInvitation(pp);
                    bookPlayground(pp);
                }
            }
        }
        playerMenu(pp);
    }

    /**
     * function to make a specific player to add another player in his team
     * @param p the player who wants to add another in his team
     */
    private void addPlayersInTeam(player p) {
        System.out.println("----------------------------------------------------------------------------------");
        System.out.println("1- add player.");
        System.out.println("2- Exit.");
        String choice = "1";
        System.out.print("Your choice: ");
        Scanner input = new Scanner(System.in);
        choice = input.next();
        while (checkIfValid(2, choice)) {
            System.out.println("Please enter valid choice: ");
            choice = input.next();
        }
        if (choice.equals("1")) {
            System.out.print("Enter Email of the player you want to add: ");
            String id, temp;
            Scanner in = new Scanner(System.in);
            temp = in.next();
            id = temp;
            if (!p.ifInTeam(id)) {
                System.out.println("This player is added successfully in your team");
                p.addplayer(id);
            } else
                System.out.println("The player is already in the team");
            addPlayersInTeam(p);
        }
        playerMenu(p);
    }

    /**
     * display player menu
     * @param p the player
     */
    private void playerMenu(player p) {
        System.out.println("----------------------------------------------------------------------------------");
        System.out.println("\t\t\t\t\tHELLO " + p.getName());
        System.out.println("1- Viewing playgrounds.");
        System.out.println("2- Booking playgrounds.");
        System.out.println("3- Adding players in your team.");
        System.out.println("4- Log out.");
        String choice = "1";
        System.out.print("Your choice: ");
        Scanner input = new Scanner(System.in);
        choice = input.next();
        while (checkIfValid(4, choice)) {
            System.out.println("Please enter valid choice: ");
            choice = input.next();
        }
        if (choice.equals("1"))
            viewPlaygrounds(p);
        else if (choice.equals("2"))
            bookPlayground(p);
        else if (choice.equals("3"))
            addPlayersInTeam(p);
        else
            mainMenu();
    }


};
