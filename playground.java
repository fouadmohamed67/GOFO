
import java.util.ArrayList;
import java.util.List;
import java.util.*;

import static java.lang.StrictMath.abs;

/**
 * class playground to store information of playground
 * @author Abdelrahman Ammar Abbas    20180146
 */

public class playground {
    private String name, size, location, avHours, pricePerHour, cancelPeriod;
    private boolean status;
    private List<String> booking = new ArrayList<>();

    /**
     * parameterized constructor to store information of playground
     * @param name name of the playground
     * @param size size of playground
     * @param location location of the playground
     * @param avHoures available hours of the playground
     * @param pricePerHour price per hour of the playground
     * @param cancelPeriod cancellation period of playground
     */
    public playground(String name, String size, String location, String avHoures, String pricePerHour, String cancelPeriod) {
        setName(name);
        setSize(size);
        setLocation(location);
        setAvHours(avHoures);
        setPricePerHour(pricePerHour);
        setCancelPeriod(cancelPeriod);
        setStatus(false);
    }

    /**
     * name setter
     * @param name name of the playground
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * name getter
     * @return String
     */
    public String getName() {
        return name;
    }
    /**
     * size setter
     * @param size size of playground
     */
    public void setSize(String size) {
        size = size.concat(" m2");
        this.size = size;
    }
    /**
     * location setter
     * @param location location of the playground
     */
    public void setLocation(String location) {
        location = location.toLowerCase();
        this.location = location;
    }
    /**
     * available hours setter
     * @param avHoures available hours of the playground
     */
    public void setAvHours(String avHoures) {
        avHoures += " Hours";
        this.avHours = avHoures;
    }
    /**
     * price per hour setter
     * @param pricePerHour price per hour of the playground
     */
    public void setPricePerHour(String pricePerHour) {
        pricePerHour += " EGP ";
        this.pricePerHour = pricePerHour;
    }
    /**
     * cancellation period setter
     * @param cancelPeriod cancellation period of playground
     */
    public void setCancelPeriod(String cancelPeriod) {
        cancelPeriod += " Minutes";
        this.cancelPeriod = cancelPeriod;
    }
    /**
     * status setter
     * @param status status of playground (active or not)
     */
    public void setStatus(boolean status) {
        this.status = status;
    }
    /**
     * status getter
     * @return boolean
     */
    public boolean getStatus() {
        return status;
    }

    //____________________________________________________________________________________________________________

    /**
     * function to print information of playground
     */
    void tostring() {
        System.out.print("Play Ground Name : " + name + "\nPlay Ground Location : " +
                location + "\nPlay Ground Size : " + size + "\nAvailabel Houre : " + avHours + "\nplay Ground Price : "
                + pricePerHour + "perhour\nCancelation Period : " + cancelPeriod + "\nPlay Ground Status : ");
        if (status == true) {
            System.out.println("Available");
        } else {
            System.out.println("Not Availabe Now (Not approved by administrator)");
        }
        System.out.print("Bookings: ");
        for (int counter = 0; counter < booking.size(); counter++) {
            String temp = "";
            temp = temp.concat(booking.get(counter).substring(0, 3));
            temp = temp.concat(" ");
            temp = temp.concat(booking.get(counter).substring(3, 5));
            temp = temp.concat(" ");
            temp = temp.concat(booking.get(counter).substring(5, 10));
            temp = temp.concat(" ");
            temp = temp.concat("(");
            temp = temp.concat(booking.get(counter).substring(10, booking.get(counter).length()));
            temp = temp.concat(" Hours)");
            System.out.print(temp);
            System.out.print(", ");
        }
        System.out.println("");
    }

    /**
     * function to display all playgrounds in the system
     */
    public static void displayall() {
        if (Global.allPlayground.size() < 1) {
            System.out.println("There are no playgrounds in the system. ");
            return;
        }
        int numOfPlayground = Global.allPlayground.size();
        int counter;
        for (counter = 0; counter < numOfPlayground; counter++) {
            System.out.println("----------------------------------------------------------------------------------");
            Global.allPlayground.get(counter).tostring();
            System.out.println("----------------------------------------------------------------------------------");
        }
    }

    /**
     * function display all playgrounds in a specific location and it returns true if there is
     * at least an playground there and false if there is no playgrounds there
     * @param location location which user want to display the playgrounds there
     * @return boolean
     */
    public static boolean displayByLocation(String location) {
        location = location.toLowerCase();
        int numOfPlayground = Global.allPlayground.size();
        int counter;
        boolean found = false;
        for (counter = 0; counter < numOfPlayground; counter++) {
            if (location.equals(Global.allPlayground.get(counter).location)) {
                System.out.println("----------------------------------------------------------------------------------");
                Global.allPlayground.get(counter).tostring();
                System.out.println("----------------------------------------------------------------------------------");
                found = true;
            }
        }
        return found;
    }

    /**
     * function display a playgrounds with a specific name and it returns true if there is
     * a playground with that name and false if there is no playground with that name
     * @param Name name of the playground which the user want to display
     * @return boolean
     */
    public static boolean displayByName(String Name) {
        int numOfPlayground = Global.allPlayground.size();
        int counter;
        boolean found = false;
        for (counter = 0; counter < numOfPlayground; counter++) {
            if (Name.equals(Global.allPlayground.get(counter).name)) {
                System.out.println("----------------------------------------------------------------------------------");
                Global.allPlayground.get(counter).tostring();
                System.out.println("----------------------------------------------------------------------------------");
                return true;
            }
        }
        return false;
    }

    /**
     * function to book the player ground in a specific date and it returns true if this period of time
     * is available in playground
     * @param s the date which player want to book the play ground during it and the playing period
     * @return boolean
     */
    public boolean book(final String s) {
        if (booking.size() > 0) {
            Collections.sort(booking);
            int ind = 0;
            for (int i = 0; i < booking.size(); i++) {
                int com = s.compareToIgnoreCase(booking.get(i));
                if (com == 0)
                    return false;
                else if (com < 0 && i == 0) {
                    ind = -1;
                    break;
                } else if (com > 0 && i == booking.size() - 1) {
                    ind = -2;
                    break;
                } else if (com < 0) {
                    ind = i - 1;
                    break;
                }
            }
            if (ind == -1) {
                String tempS = s.substring(0, 5);
                String tempind = booking.get(0).substring(0, 5);
                if (tempS.equals(tempind)) {
                    int timeS = 0, timeind = 0;
                    String hour = s.substring(5, 7);
                    timeS += Integer.parseInt(hour);
                    hour = booking.get(0).substring(5, 7);
                    timeind += Integer.parseInt(hour);
                    hour = s.substring(8, 10);
                    timeS *= 60;
                    timeS += Integer.parseInt(hour);
                    hour = booking.get(0).substring(8, 10);
                    timeind *= 60;
                    timeind += Integer.parseInt(hour);
                    int periodS = 0, periodind = 0;
                    hour = s.substring(10, s.length());
                    periodS += Integer.parseInt(hour);
                    hour = booking.get(0).substring(10, s.length());
                    periodind += Integer.parseInt(hour);
                    periodind *= 60;
                    periodS *= 60;
                    if (abs(timeind - timeS) < periodS)
                        return false;
                }
            } else if (ind == -2) {
                String tempS = s.substring(0, 5);
                String tempind = booking.get(booking.size() - 1).substring(0, 5);
                if (tempS.equals(tempind)) {
                    int timeS = 0, timeind = 0;
                    String hour = s.substring(5, 7);
                    timeS += Integer.parseInt(hour);
                    hour = booking.get(booking.size() - 1).substring(5, 7);
                    timeind += Integer.parseInt(hour);
                    hour = s.substring(8, 10);
                    timeS *= 60;
                    timeS += Integer.parseInt(hour);
                    hour = booking.get(booking.size() - 1).substring(8, 10);
                    timeind *= 60;
                    timeind += Integer.parseInt(hour);
                    int periodS = 0, periodind = 0;
                    hour = s.substring(10, s.length());
                    periodS += Integer.parseInt(hour);
                    hour = booking.get(booking.size() - 1).substring(10, s.length());
                    periodind += Integer.parseInt(hour);
                    periodind *= 60;
                    periodS *= 60;
                    if (timeind + periodind > timeS)
                        return false;
                }
            } else {
                String tempS = s.substring(0, 5);
                String tempind = booking.get(ind).substring(0, 5);
                if (tempS.equals(tempind)) {
                    int timeS = 0, timeind = 0;
                    String hour = s.substring(5, 7);
                    timeS += Integer.parseInt(hour);
                    hour = booking.get(ind).substring(5, 7);
                    timeind += Integer.parseInt(hour);
                    hour = s.substring(8, 10);
                    timeS *= 60;
                    timeS += Integer.parseInt(hour);
                    hour = booking.get(ind).substring(8, 10);
                    timeind *= 60;
                    timeind += Integer.parseInt(hour);
                    int periodS = 0, periodind = 0;
                    hour = s.substring(10, s.length());
                    periodS += Integer.parseInt(hour);
                    hour = booking.get(ind).substring(10, s.length());
                    periodind += Integer.parseInt(hour);
                    periodind *= 60;
                    periodS *= 60;
                    if (abs(timeind - timeS) < periodS)
                        return false;
                }
                tempind = booking.get(ind + 1).substring(0, 5);
                if (tempS.equals(tempind)) {
                    int timeS = 0, timeind = 0;
                    String hour = s.substring(5, 7);
                    timeS += Integer.parseInt(hour);
                    hour = booking.get(ind + 1).substring(5, 7);
                    timeind += Integer.parseInt(hour);
                    hour = s.substring(8, 10);
                    timeS *= 60;
                    timeS += Integer.parseInt(hour);
                    hour = booking.get(ind + 1).substring(8, 10);
                    timeind *= 60;
                    timeind += Integer.parseInt(hour);
                    int periodS = 0, periodind = 0;
                    hour = s.substring(10, s.length());
                    periodS += Integer.parseInt(hour);
                    hour = booking.get(ind + 1).substring(10, s.length());
                    periodind += Integer.parseInt(hour);
                    periodind *= 60;
                    periodS *= 60;
                    if (timeS + periodS > timeind)
                        return false;
                }
            }
        }
        booking.add(s);
        Collections.sort(booking);
        return true;
    }
}