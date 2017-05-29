package engine;

/**
 * Timer.
 * @author anhcx
 */
public class Timer {
    
    /**
     * Constructor.
     * @param i period of time.
     */
    public Timer(int i) {
        this.delay = i;
        this.currentTick = 0;
    }
    
    /**
     * Action to do every period of time.
     * @param l period of time.
     * @return boolean
     */    
    public boolean action(long l) {
        currentTick += l;
        if (currentTick >= delay) {
            
            currentTick -= delay;

            return true;
        }
        return false;
    }
    
    
    /**
     * Delay times.
     */
    private final long delay;

    /**
     * Current tick.
     */
    private long currentTick;    
}
