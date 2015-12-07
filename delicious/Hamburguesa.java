import greenfoot.*;

/**
 * Write a description of class Hamburguesa here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Hamburguesa extends ComidaChatarra
{
    private int dir; 
    private int vel; 
    private int dir2; //direccion del jugador 
    
    /**
     * constructor de variables de la clase Hamburguesa
     */
    public Hamburguesa()
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
        if(dir2 == 0)
            this.mover();
    }   

    public void setDir(int dir){
        dir2 = dir;
    }
        
        
    /**
     * metodo que checa la direccion en que debe de ir la hamburguesa, al llegar a un extremo en el eje de las x 
     * cambia su posision a la contraria
     */
    public void cambiaDir()
    {
        switch(dir)
        {
            case 1:
            if(getX()+40>=getWorld().getWidth())
            {
                setLocation(getX()-vel,getY());
                dir=2;
            }
            break;
            case 2:
            if(getX()-70<=0)
            { 
                setLocation(getX()+vel,getY()); 
                dir=1;
            }
            break;

            default:

        }

    }
    /**
     * mueve la hamburguesa en el eje de las X dependiendo su direccion
     */
    public void mover()
    {

        switch(dir)
        {
            case 1: 
            setLocation(getX()+vel,getY()); 
            break;
            case 2:
            setLocation(getX()-vel,getY());  
            break;

            default:

        }

    }
    
  
}
