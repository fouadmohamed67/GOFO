import java.util.ArrayList;
import java.util.List;

/**
 * class team 
 * @author Marwan Galal Mohamed 20180268
 */
public class team {
    private final List<String> playersOfTeam = new ArrayList<>();

    /**
     *function to get how many players are in team
     * @return int
     */
    public int getSize() {
        return playersOfTeam.size();
    }

    /**
     * function to add specific player in team
     * @param s mail of player
     */
    public void addPlayer(String s) {
        playersOfTeam.add(s);
    }

    /**
     * predicate function to check if a specific player is in team or not
     * @param s mail of player who wanted to be checked if he is in team
     * @return boolean
     */
    public boolean ifInTeam(final String s) {
        for (int i = 0; i < playersOfTeam.size(); i++) {
            if (playersOfTeam.get(i).equals(s))
                return true;
        }
        return false;
    }
}