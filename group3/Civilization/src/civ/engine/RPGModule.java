
package civ.engine;
/**
 * A layer on between the engine and it's managers. It will receive the message,
 * and translate the message into an rpg message. Example, WASD will move the main
 * character now.
 * @author Justin
 */
public interface RPGModule {
    /**
     * 
     */
    public void movePlayer();
    
    public void randomEncouter();
    
    public void combatEngine();
}
