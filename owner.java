/**
 * class inherits from class user to store information of the owner which includes
 * playground of the owner
 * @author Marwna Galal Mohamed 20180268
 */
public class owner extends user {
    private playground Playground;
    private boolean have = false;

    /**
     * function to check if the owner has playground or not
     * @return boolean
     */
    public boolean ifHave() {
        return have;
    }

    /**
     * owner playground setter
     * @param playground
     */
    public void setPlayground(playground playground) {
        Playground = playground;
        have = true;
    }

    /**
     * owner playground getter
     * @return playground
     */
    public playground getPlayground() {
        return Playground;
    }

}