import greenfoot.*;

/**
 * Write a description of class Papa here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Papa extends ComidaChatarra
{
    private int dir; 
    private int vel; 

    /**
     * constructor de variables de la clase Papa
     */
    public Papa()
    {
        dir=1;
        vel=3;
        GreenfootImage image=getImage();
        image.scale(30,30);
        setImage(image);
    }

    /**
     * Act - do whatever the Enemy3 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */

    public void act() 
    {
        this.cambiaDir();
        this.mover();
    }   

    /**
     * metodo que checa la direccion en que debe de ir la Papa, al llegar a un extremo en el eje de las x 
     * cambia su posision a la contraria
     */
    public void cambiaDir()
    {
        switch(dir)
        {
            case 1:   
            if(getY()+10>=getWorld().getHeight())
            {

                dir=2;
            }
            break;
            case 2:
            if(getY()-10<=0)
            { 

                dir=1;
            }
            break;

            default:

        }

    }

    /**
     * mueve la papa en el eje de las X dependiendo su direccion
     */
    public void mover()
    {

        switch(dir)
        {
            case 1: 
            setLocation(getX(),getY()+vel); 
            break;
            case 2:
            setLocation(getX(),getY()-vel);  
            break;

            default:

        }

    }

}
