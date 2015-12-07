import greenfoot.*;

/**
 * Write a description of class Niño here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Niño extends Actor
{   
    private GreenfootImage[] niño; 
    private int puntos;
    private String marcador;
    private String marcadorVidas;
    private String marcadorNivel;
    private int iDir;
    private int contGordura;
    private int contVidas;
    private GreenfootSound soundBoton = new GreenfootSound("soundFood.mp3");
    private int nivel;
    private int x1;
    private SimpleTimer reloj;
    private int cambiaImagen;
    private int cambio;

    /**
     * Constructor de la clase niño. aqui se agregan las imagenes al arreglo , ademas de inicalizar las variables 
     */
    public Niño()
    {
        niño = new GreenfootImage[13]; //Arreglo de tipo GreenfootImage guarda todas las imagenes que pertenecen al movimietno del actor 

        niño[0] = new GreenfootImage("s1.png"); //delgado
        niño[1] = new GreenfootImage("s3.png");

        niño[2] = new GreenfootImage("s1_izq.png"); //delgado izq
        niño[3] = new GreenfootImage("s3_izq.png"); 

        niño[4] = new GreenfootImage("sm1.png");   //mediano
        niño[5] = new GreenfootImage("sm2.png");        

        niño[6] = new GreenfootImage("sm1_izq.png");
        niño[7] = new GreenfootImage("sm2_izq.png");

        niño[8] = new GreenfootImage("s_g1.png");   //gordo
        niño[9] = new GreenfootImage("sg2.png");

        niño[10] = new GreenfootImage("s_g1_izq.png");
        niño[11] = new GreenfootImage("sg2_izq.png"); 

        contGordura = 1;  //contador de la gordura 0 es delgado
        contVidas = 3;  //contador de vidas
        nivel = 1;  //niveles
        iDir = 0;  //direccion 0 es derecha 
        reloj=new SimpleTimer();
        reloj.mark();
        cambiaImagen = 1;
        cambio=0;
    }

    /**
     * Act - do whatever the Niño wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        getWorld().showText("Puntos",70,20);
        getWorld().showText("Vidas",170,20);
        marcadorVidas = String .valueOf(contVidas);
        getWorld().showText(marcadorVidas,170,50);
        marcador = String .valueOf(puntos);
        getWorld().showText(marcador,70,50);
        getWorld().showText("Nivel",270,20);
        marcadorNivel = String .valueOf(nivel);
        getWorld().showText(marcadorNivel,270,50);

        if(contVidas > 0){
            if(contGordura == 4){
                contVidas--;
                contGordura = 1;
                if(iDir==0 )cambiaImagen = 1;
                else
                    cambiaImagen=3;

            }

            if(reloj.millisElapsed()>=500)//las imagenes cambian cada cierto tiempo definido
            {             
                reloj.mark();
                animacion();//llamada a funcion para movimiento de jugador
            }  
            mover();
            comeSanamente();
            comeMal();
            niveles();
        }

    }    

    /** Metodo que se encargara del movimietno del actor y lo condiciona para que no salga del limite de la pantalla, 
     * ademas de cambiar las imagenes para que se mueva la capa al momento de ir avanzando 
     * 
     */
    public void mover()
    {     if(getX()<960 ){   
            if(Greenfoot.isKeyDown("right")){
                move(5);
                setImage(niño[   cambiaImagen -cambio  ]);
                iDir = 0;
                if(contGordura == 1)
                    cambiaImagen = 1;
                else 
                if(contGordura == 2)
                    cambiaImagen = 5;
                else 
                if(contGordura == 3)
                    cambiaImagen = 9;
            }
        }

        if(getX()>40 ){
            if(Greenfoot.isKeyDown("left")){
                move(-5);
                setImage(niño[   cambiaImagen -cambio ]);
                iDir =1;
                if(contGordura == 1)
                    cambiaImagen = 3;
                else 
                if(contGordura == 2)
                    cambiaImagen = 7;
                else 
                if(contGordura == 3)
                    cambiaImagen = 11;
            }
        }

        if(getY()>130){ 
            if(Greenfoot.isKeyDown("up")){
                setLocation(getX(), getY()-5);
                setImage(niño[cambiaImagen]);
            }

        }

        if(getY()<520){ 
            if(Greenfoot.isKeyDown("down")){
                setLocation(getX(), getY()+5);  
                setImage(niño[cambiaImagen ]);
            }

        }

    }

    /**
     * Metodo que se encarga de desaparecer la comida sana cuando es tocada por el jugador y aumentar los puntos
     *  que corresponden por cada alimento
     */
    void comeSanamente(){
        if(isTouching(Fresa.class)){
            soundBoton.play();
            puntos+=200;
            removeTouching(Fresa.class);
        }
        else if(isTouching(Sandia.class)){
            soundBoton.play();
            puntos+=175;
            removeTouching(Sandia.class);
        }
        else if(isTouching(Brocoli.class)){
            soundBoton.play();
            puntos+=150;
            removeTouching(Brocoli.class);
        }
        else if(isTouching(Agua.class)){
            soundBoton.play();
            puntos+=50;
            removeTouching(Agua.class);
        }
    }

    /**
     * Metodo que restara puntos y vidas cada vez que el jugador sea tocado por la comida chatarra
     */
    void comeMal()
    {
        if(isTouching(Hamburguesa.class)){
            soundBoton.play();
            if(puntos > 200)
                puntos-=200;
            removeTouching(Hamburguesa.class);
            if(contGordura < 4)
                contGordura += 1;
        }
        else if(isTouching(Pizza.class)){
            soundBoton.play();
            if(puntos > 250)
                puntos-=250;
            removeTouching(Pizza.class);
            if(contGordura < 4)
                contGordura += 1;
        }

        else if(isTouching(Papa.class)){
            soundBoton.play();
            if(puntos > 150)
                puntos-=150;
            removeTouching(Papa.class);
            if(contGordura < 4)
                contGordura += 1;
        }

        else if(isTouching(Refresco.class)){
            soundBoton.play();
            if(puntos > 100)
                puntos-=100;
            removeTouching(Refresco.class);
            if(contGordura < 4)
                contGordura += 1;
        }

    }

    /**
     * metodo el cual se encarga de mandar la direccion a la clase juego
     */
    public int getDir(){
        return iDir; 
    }

    /**
     * Metodo que cambia de nivel segun los puntos ira cambiando de nivel 
     */
    public void niveles(){
        if(puntos >= 1000 && nivel ==1){ //pasar nivel 2
            nivel = 2;

            puntos += 250;
            contVidas += 1;
        }
        if(puntos >= 2250 && nivel == 2){ //pasar nivel 3
            puntos += 500;
            contVidas += 1;
            nivel = 3;
        }
        if(puntos == 4000 && nivel == 3){ // pra ganar 
            puntos += 1000;   
            nivel = 4;
        }
    }

    /**
     * metodo que se encarga de mandar los niveles a la clase juego
     */
    
    public int getNivel(){
        return nivel;
    }
    /**
     * Metodo que se encarga de mandar las vidas a la clase juego
     */
    public int getVidas(){
        return contVidas;
    }

    /**
     * Metodo en el cual se hace la animacion de la capa para que simule que esta en movimiento la capa
     */
    public void animacion(){
        if(cambio==0)
            cambio =1;
        else 
            cambio=0;

    }

}
