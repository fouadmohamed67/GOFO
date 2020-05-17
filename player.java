/**
 * class inherits from class user to store information of the player which includes
 * team of player
 * @author Marwan Galal Mohamed    20180268
 */
public class player extends user {
    private team Team = new team();

    /**
     * default constructor
     */
    public player() {
        super();
    }

    /**
     * player's team getter
     * @return team
     */
    public team getTeam() {
        return Team;
    }

    /**
     * function to send invitation to player's team
     */
    public void sendInvitation() {
        System.out.println("Invitations are sent");
    }

    /**
     * function toadd player in the team
     * @param p player who wanted to be added in team
     */

    public void addplayer(String p) {
        Team.addPlayer(p);
    }

    /**
     * predicate function to check if a specific player is in team or not
     * @param s mail of player who wanted to be checked if he is in team
     * @return boolean
     */
    public boolean ifInTeam(final String s) {
        return Team.ifInTeam(s);
    }

}