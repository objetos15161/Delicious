import greenfoot.*;

/**
 * Write a description of class Brocoli here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Brocoli extends ComidaSana
{
    private int xPos;
    private int yPos;
    private int xRadius;
    private int yRadius;
    private double angle;

    /**
     * constructor de variables de la clase Brocoli
     * parametros un angulo, posision en x y posision en y.
     */
    public Brocoli(double angle, int xPos, int yPos)
    {
        this.angle=3.1416D/180*angle;
        this.xPos=xPos;
        this.yPos=yPos;
        this.yRadius=50;
        this.xRadius=50;

    }

    public void act()
    {
        this.mover();
    }

    /**
     * metodo que mueve al brocoli en forma de circulo 
     * 
     */   
    public void mover() 
    {
        double x = (Math.cos(angle) * xRadius + xPos);
        double y = (Math.sin(angle) * yRadius + yPos);
        setLocation((int)x,(int)y);
        angle+=0.1;
        if(angle>=2D*3.1416D)
            angle=0; 
    } 

    /**
     *iguala la posision inicial con la posision actual en x e y
     */
    public void cambiaCenter(int xPos, int yPos)
    {
        this.xPos=xPos;
        this.yPos=yPos;
    }
}   


