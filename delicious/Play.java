import greenfoot.*;

/**
 * Write a description of class Play here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Play extends Boton
{
    private GreenfootSound soundBoton = new GreenfootSound("play.wav");
    
    /**
     * Metodo del boton play el cual al precionarlo dara inicio al juego
     * 
     */
    public void act() 
    {
        // Add your action code here.
        MouseInfo mouse = Greenfoot.getMouseInfo();      
        if(mouse!=null)
        {
            if(Greenfoot.mouseClicked(this)){
                soundBoton.play();
                Greenfoot.setWorld(new Juego());   

            }
        }
    }      
}
