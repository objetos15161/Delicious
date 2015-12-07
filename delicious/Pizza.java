import greenfoot.*;

/**
 * Write a description of class Pizza here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class Pizza extends ComidaChatarra
{ 
    private int dir; 
    private int vel; 
  
    /**
     * constructor de variables de la clase pizza
     */
    public Pizza()
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
        this.cambiarDir();
      //  if(dir2==0)
        this.mover();
        
    }   

 /*   public void setDir(int dir){
        dir2 = dir;
    }*/
    /**
     * metodo que checa la direccion en que debe de ir la pizza, al llegar a un extremo en el eje de las x 
     * cambia su posision a la contraria
     */
    public void cambiarDir()
    {
        switch(dir)
        {
            case 1:
                if(getX()+10>=getWorld().getWidth())
                    dir=2;
                if(getY()-20<=0)
                    dir = 4;
            break;
            case 2:
                if(getX()-10<=0)
                    dir =1;
                if(getY()-20<=0)
                    dir=3;
            break;
            case 3:
                if(getX()-10<=0)
                    dir = 4;
                if(getY()+10>=getWorld().getHeight())
                    dir =2;
            break;
            case 4:
                if(getX()+10>=getWorld().getWidth())
                    dir= 3;
                if(getY()+10>=getWorld().getHeight())
                    dir=1;
            break;

            default:
        }
    }
    
    /**
     * mueve la pizzaen el eje de las X dependiendo su direccion
     */
    public void mover()
    {
            switch(dir)
        {
            case 1: 
            setLocation(getX()+vel,getY()-vel); 
            break;
            case 2:
            setLocation(getX()-vel,getY()-vel);  
            break;
            case 3:
            setLocation(getX()-vel,getY()+vel);
            break;
            case 4:
            setLocation(getX()+vel,getY()+vel);
            break;     
            default:
        }
  
    }
}
