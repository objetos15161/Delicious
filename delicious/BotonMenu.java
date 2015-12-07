import greenfoot.*;

/**
 * Write a description of class BotonMenu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class BotonMenu extends Boton
{
    private GreenfootSound soundBoton = new GreenfootSound("play.wav");
    
    public BotonMenu()
    {
        setImage("menu.png");
    }

    /**
     * metodo donde se checa si se presiono el boton menu
     */
    public void act(){
        MouseInfo mouse = Greenfoot.getMouseInfo();      
        if(mouse!=null)
        {
            if(Greenfoot.mouseClicked(this)){
                soundBoton.play();
                Greenfoot.setWorld(new Menu());   
            }
        }
    }
}
