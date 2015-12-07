import greenfoot.*;

/**
 * Write a description of class Juego here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Juego extends World
{
    private GreenfootImage fondo;  //Imagen de fondo del nivel 1
    private GreenfootImage fondo2;  //Imagen de fondo del nivel 2
    private GreenfootImage fondo3;  //Imagen de fondo del nivel 3
    private SimpleTimer reloj;  
    private int Dir; 
    private Niño n;
    private int an;
    private int punt;
    private String marcadorNivel; 
    private int nivel;
    //    private Pizza p;
    private int vidas;

    /**
     * Constructor for objects of class Juego. Se inicializan las variables , carga las imagenes del esenario, el niño lo agrega al esenario 
     * 
     */
    public Juego()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 550, 1); 
        fondo = new GreenfootImage("escenario.png");
        fondo.scale(1000,550);/* escala la imagen a las medidas del escenario en caso de exceder las dimensiones */
        setBackground(fondo);/* muestra la imagen en pantalla */
        fondo2 = new GreenfootImage("nivel2.jpg"); 
        fondo2.scale(1000,550);        
        fondo3 = new GreenfootImage("nivel3.jpg");
        fondo3.scale(1000,550);
        nivel = 1;
        n = new Niño();
        addObject(n,150,490);  
        Dir=0;
        reloj = new SimpleTimer();
        reloj.mark();
        vidas = 3;
    }

    /**
     * Metodo en el que llama a las acciones que ara el niño , controla la velocidad en la qeu aparecen los objetos en el esenario,
     * llama a los letreros perdiste y ganaste, cambia los esenarios de los niveles y controla las vidas, puntos y direccion. 
     */
    public void act()
    {
        if(reloj.millisElapsed()>=3000 && nivel ==1)  //velocidad en la que van a aparecer los objetos en el primer nimerl 
        {             
            reloj.mark();
            agregaObjeto(Greenfoot.getRandomNumber(8)+1,Greenfoot.getRandomNumber(800)+100,Greenfoot.getRandomNumber(400)+50);

        }

        if(reloj.millisElapsed()>=2000 && nivel ==2)
        {             
            reloj.mark();
            agregaObjeto(Greenfoot.getRandomNumber(8)+1,Greenfoot.getRandomNumber(800)+100,Greenfoot.getRandomNumber(400)+50);

        }
        if(reloj.millisElapsed()>=1000 && nivel ==3)
        {             
            reloj.mark();
            agregaObjeto(Greenfoot.getRandomNumber(8)+1,Greenfoot.getRandomNumber(800)+100,Greenfoot.getRandomNumber(400)+50);

        }

        if(nivel == 4)
        {
            Greenfoot.playSound("ganaste.mp3");
            Letrero ganaste;
            ganaste = new Letrero(" GANASTE ");
            addObject(ganaste,getWidth()/2,getHeight()/2); 
            Greenfoot.stop();
        } 
        
        if(vidas == 0)
        {

            Greenfoot.playSound("gameOver.mp3");
            Letrero perdiste;
            perdiste = new Letrero("PERDISTE");
            addObject(perdiste,getWidth()/2,getHeight()/2); 
            Greenfoot.stop();
        }

        vidas = n.getVidas(); 
        Dir = n.getDir();
        nivel = n.getNivel();
        
        switch(nivel)
        {
            case 1:
            setBackground(fondo);
            break;
            case 2:
            setBackground(fondo2);
            break;
            case 3:
            setBackground(fondo3);
            break;
        }

         //  p.setDir(Dir);
    }

    /**
     * Metodo que va agregando la comida sana y chatarra aleatoriamente mediante un switch se pasa como parametro el numero de objeto, una coordenada en x y otra en y 
     */
    public void agregaObjeto(int objeto, int x, int y){
        switch(objeto){
            case 1:  
            Agua a = new Agua();
            addObject(a,x,y);
            break;
            case 2: 
            Sandia s = new Sandia();
            addObject(s, x, y);
            break;
            case 3: 
            Fresa f = new Fresa();
            addObject(f,x,y);
            break;
            case 4: 
            Brocoli b = new Brocoli(an,x,y); 
            addObject(b,x,y);
            break;
            case 5: 
            Refresco r = new Refresco(an,x,y);
            addObject(r,x,y);
            break;
            case 6:
            Hamburguesa h = new Hamburguesa();
            addObject(h,x,y);
            break;
            case 7:
            Papa pa = new Papa();
            addObject(pa,x,y);
            break;
            case 8:
           Pizza p = new Pizza();
            addObject(p,x,y);
           // p.setDir(Dir);
            break;

            default:
        }

    }

}
