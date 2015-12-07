import greenfoot.*;

/**
 * Write a description of class Credito here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Credito extends Boton
{
    /**
     * Act - do whatever the Credito wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     * En este metodo se crea la funcion para que al presionar el boton de credits 
     * con el mouse se active y llama al metodo de creaCreditos
     */
    public void act() 
    {
        // Add your action code here.
        click();     
    }

    public void click()
    {  
        MouseInfo mouse = Greenfoot.getMouseInfo();      
        if(mouse!=null)
        {
            if(Greenfoot.mouseClicked(this))
                ((Menu)getWorld()).creaCreditos();  

        }
    }
}