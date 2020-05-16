import java.sql.ClientInfoStatus;
import java.util.ArrayList;
import java.util.List;

/**
 * class admin which has requests of registered playground and only admin can approve or refuse
 * @author Osama Salah Abdelmoniem 20180039
 */
public class admin {
    private final List<Integer> requests = new ArrayList<>();

    /**
     * function to display requests which sent to administrator
     */
    public void viewRequests() {
        if (requests.size() < 1) {
            System.out.println("There is no requests.");
            return;
        }
        for (int i = 0; i < requests.size(); i++) {
            System.out.println("Request ID " + (requests.get(i) + 1) + ": ");
            Global.allPlayground.get(requests.get(i)).tostring();
            System.out.println(" ");
        }
    }

    /**
     * function to send request to administrator
     * @param p number of playground which wanted to be approved in allPlayground list
     * and it's number of request
     */
    public void sendRequest(final int p) {
        requests.add(p);
    }

    /**
     * function to get number of requests
     * @return int
     */
    public int sizeOfReq() {
        return requests.size();
    }

    /**
     * function to approve a specific request
     * @param p number of request
     */
    public void approveRequest(final int p) {

        Global.allPlayground.get(requests.get(p - 1)).setStatus(true);
        requests.remove(p - 1);
        System.out.println("Playground is approved successfully.");
    }
}