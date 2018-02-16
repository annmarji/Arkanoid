package Gra;

import Wczytywanie_plikow.Constants;
import java.awt.*;

/**
 * Klasa opisuj�ca pi�k� 
 */
public class Ball
{
    /**
     * Zmienna opisuj�ca pi�k� jako kwadrat
     */
    private Rectangle ballRect;
    
    /**
     * Szeroko�� planszy do gry
     */
    private int screenWidth;
    
    /**
     * Wysoko�� planszy do gry
     */
    private int screenHeight;
    
    /**
     * Znormalizowana pr�dko�� pi�ki w kierunku X
     */
    protected double normXVelocity;
    
    /**
     * Znormaliwana pr�dko�� pi�ki w kierunku Y
     */
    protected double normYVelocity;
   
    /**
     * Znormalizowana pr�dko�� pi�ki w kierunku X poziom �atwy
     */
    protected double easyNormXVelocity;
    
    /**
     * Znormaliwana pr�dko�� pi�ki w kierunku Y poziom �atwy
     */
    protected double easyNormYVelocity;
    
    /**
     * Znormalizowana pr�dko�� pi�ki w kierunku X poziom �redni
     */
    protected double mediumNormXVelocity;
    
    /**
     * Znormaliwana pr�dko�� pi�ki w kierunku Y poziom �redni
     */
    protected double mediumNormYVelocity;
    
    /**
     * Znormalizowana pr�dko�� pi�ki w kierunku X poziom trudny
     */
    protected double hardNormXVelocity;
    
    /**
     * Znormaliwana pr�dko�� pi�ki w kierunku Y poziom trudny
     */
    protected double hardNormYVelocity;
    
    /**
     * Znormalizowana warto�� wypadkowa pr�dko�ci
     */
    private double normVelocityVector;
    
    /**
     * Znormalizowana warto�� wypadkowa pr�dko�ci poziom �atwy
     */
    private double easyNormVelocityVector;
    
    /**
     * Znormalizowana warto�� wypadkowa pr�dko�ci poziom �redni
     */
    private double mediumNormVelocityVector;
    
    /**
     * Znormalizowana warto�� wypadkowa pr�dko�ci poziom trudny
     */
    private double hardNormVelocityVector;
    
    /**
     * Promie� pi�ki
     */
    protected double ballRadius;

    /**
     * Znormalizowana pozycja X pi�ki
     */
    protected double normXPosition;
    /**
     * Znormalizowana pozycja Y Pi�ki
     */
    protected double normYPosition;
    /**
     * Po�o�enie pi�eczki na osi X
     */
    protected double ballX;
    /**
     * Po�o�enie pi�eczki na osi Y
     */
    protected double ballY;
    
    /**
     * Okre�la wybrany poziom trudno�ci
     */
    protected static String poziom;
    
    /**
     * Konstruktor klasy Ball
     * @param screenWidth1 Parametr szeroko�ci ekranu
     * @param screenHeight1 Parametr wysoko�ci ekranu 
    */
    public Ball(int screenWidth1, int screenHeight1){
        this.screenHeight=screenHeight1;
        this.screenWidth=screenWidth1;
        this.easyNormXVelocity=Constants.easyBallXVelocity;
        this.easyNormYVelocity=-Constants.easyBallYVelocity;
        this.mediumNormXVelocity=Constants.mediumBallXVelocity;
        this.mediumNormYVelocity=-Constants.mediumBallYVelocity;
        this.hardNormXVelocity=Constants.hardBallXVelocity;
        this.hardNormYVelocity=-Constants.hardBallYVelocity;
        this.ballRadius = (Constants.ballRadius/2); 
        this.setInitOnScreen();

        easyNormVelocityVector=Math.sqrt(easyNormXVelocity*easyNormXVelocity+easyNormYVelocity*easyNormYVelocity);
        mediumNormVelocityVector=Math.sqrt(mediumNormXVelocity*mediumNormXVelocity+mediumNormYVelocity*mediumNormYVelocity);
        hardNormVelocityVector=Math.sqrt(hardNormXVelocity*hardNormXVelocity+hardNormYVelocity*hardNormYVelocity);
        
    }

    /**
     * Metoda ustawia pi�k� w pocz�tkowym miejscu
     */
    public void setInitOnScreen(){  

    	normXPosition = Constants.initBallNormXPosition - (Constants.ballRadius/2);
    	normYPosition = Constants.initBallNormYPosition - Constants.ballRadius/2;
    	ballX = normXPosition * this.screenWidth;
    	ballY = normYPosition * this.screenHeight;
    	
        switch(poziom)
     	{
     	case "latwy":
     		{
     			normXVelocity = easyNormXVelocity;		
     			normYVelocity = easyNormYVelocity;		
     			normVelocityVector = easyNormVelocityVector;
     			break;
     		}
     	case "sredni":
 			{
 				normXVelocity = mediumNormXVelocity;		
     			normYVelocity = mediumNormYVelocity;		
     			normVelocityVector = mediumNormVelocityVector;
 				break;
 			}	
     	case "trudny":
 			{
 				normXVelocity = hardNormXVelocity;		
     			normYVelocity = hardNormYVelocity;		
     			normVelocityVector = hardNormVelocityVector;
 				break;
 			}
 		default:
 			break;
     	}
    	ballRect = new Rectangle();
        ballRect.setLocation((int)Math.round(ballX),(int)Math.round(ballY));
        ballRect.setSize((int)Math.round(ballRadius), (int)Math.round(ballRadius));
    
        
        if (normYVelocity>0)
        	reverseYVelocity();
        if (normXVelocity<0)
        	reverseXVelocity();
    }
    
    
    /**
     * Metoda zwracaj�ca prostok�t reprezentuj�cy pi�k�
     * @return Zwraca prostok�t reprezentuj�cy pi�k�
     */
    public Rectangle getBallRect(){
        return ballRect;
    }

    /**
     * Zwraca wsp�rz�dn� X pi�eczki
     * @return wsp�rz�dna x pi�eczki
     */
    public double getXofBall()
    {
    	return ballRect.x; 	
    }
    
    /**
     * Zwraca wsp�rz�dn� Y pi�eczki
     * @return wsp�rz�dna y pi�eczki
     */
    public double getYofBall()
   {
    	return ballRect.y; 	
    }

    /**
     *  Metoda odpowiedzialna za poruszanie si� pi�eczki, aktualizuje jej po�o�enie
     */
    
    public void move(){
	
    	normXPosition += normXVelocity;
		normYPosition += normYVelocity;
		
    }
    
    /**
     * Metoda odwracaj�ca zwrot wektora pr�dko�ci pi�ki w kierunku X
     */
    public void reverseXVelocity(){
  
    	normXVelocity=-normXVelocity;
    }
    
    /**
     * Metoda odwracaj�ca zwrot wektora pr�dko�ci pi�ki w kierunku Y
     */
    public void reverseYVelocity(){
    	
    	normYVelocity=-normYVelocity;
    }

    
    /**
     * Metoda zwracaj�ca wsp�rz�dn� X dolnego prawego rogu pi�eczki (jako prostok�ta)
     * @return wsp�rz�dna X dolnego prawego rogu pi�eczki
     */
    public double getBottomRightX()
    {
    	return ballX + ballRadius;
    }
    
    /**
     * Metoda zwracaj�ca wsp�rz�dn� Y dolnego prawego rogu pi�eczki (jako prostok�ta)
     * @return wsp�rz�dna Y dolnego prawego rogu pi�eczki
     */
    public double getBottomRightY()
    {
    	return ballY + ballRadius;

    }
}
