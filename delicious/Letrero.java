import greenfoot.*;

/**
 * Write a description of class Letrero here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Letrero extends Actor
{
    /**
     * Act - do whatever the Letrero wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
    /**
     * Metodo que crea un letrero y se manda llamar en la clase juego y aparesca
     * segun la condicion ganaste o perdiste 
     */
    public Letrero(String mensaje)
    {
        GreenfootImage letrero;
        letrero = new GreenfootImage(mensaje,50,java.awt.Color.white,java.awt.Color.black);
        setImage(letrero);
    }
    //metodos
}
