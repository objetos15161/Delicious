import greenfoot.*;

/**
 * Write a description of class Ayuda here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ayuda extends Boton
{
    private GreenfootSound soundBoton = new GreenfootSound("play.wav");
    /**
     * Metodo del boton ayuda el cual al precionarlo mostrara la ayuda del juego
     * 
     */
    public void act() 
    {
        // Add your action code here.
        MouseInfo mouse = Greenfoot.getMouseInfo();      
        if(mouse!=null)
        {
            if(Greenfoot.mouseClicked(this))
                ((Menu)getWorld()).creaAyuda();   
        }
    }    
}
