import greenfoot.*;

/**
 * Write a description of class Menu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Menu extends World
{
    private GreenfootSound soundBoton = new GreenfootSound("play.wav");
    private GreenfootImage fondo;
    private Play botonplay;
    private BotonMenu botonM;
    

    /**
     * Constructor for objects of class Menu.
     * 
     */
    public Menu()
    {    
        super(1000, 550, 1, false); 
        fondo = new GreenfootImage("delicious.png");
        fondo.scale(1000,550);/* escala la imagen a las medidas del escenario en caso de exceder las dimensiones */
        setBackground(fondo);/* muestra la imagen en pantalla */
        botonplay = new Play();
        botonM = new BotonMenu();
        prepare();
    }

    public void prepare()
    {
        addObject(botonplay, 300, 460);
        addObject(new Ayuda(), 720, 475);
        addObject(new Credito(), 510, 460);   
    }

    /**
     * Metodo que crea la ayuda al presionar el boton de la ayuda llama a este metodo y muestra la imagen que contiene la ayuda
     */
    public void creaAyuda()
    {

        removeObjects( getObjects(Actor.class) );
        setBackground("help.jpg");
        soundBoton.play();
        addObject(botonM, 850,460);
    }
    
    /**
     * Metodo que crea los creditosa al presionar el boton de los creditos llama a este metodo y muestra la imagen que contiene los creditos
     */
    public void creaCreditos()
    {

        removeObjects( getObjects(Actor.class) );
        setBackground("credito.jpg");
        soundBoton.play();
        addObject(botonM, 850, 460);
     
    }

}
