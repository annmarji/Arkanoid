package Gra;

import Wczytywanie_plikow.Constants;
import java.awt.*;

/**
 * Klasa opisuj¹ca pi³kê 
 */
public class Ball
{
    /**
     * Zmienna opisuj¹ca pi³kê jako kwadrat
     */
    private Rectangle ballRect;
    
    /**
     * Szerokoœæ planszy do gry
     */
    private int screenWidth;
    
    /**
     * Wysokoœæ planszy do gry
     */
    private int screenHeight;
    
    /**
     * Znormalizowana prêdkoœæ pi³ki w kierunku X
     */
    protected double normXVelocity;
    
    /**
     * Znormaliwana prêdkoœæ pi³ki w kierunku Y
     */
    protected double normYVelocity;
   
    /**
     * Znormalizowana prêdkoœæ pi³ki w kierunku X poziom ³atwy
     */
    protected double easyNormXVelocity;
    
    /**
     * Znormaliwana prêdkoœæ pi³ki w kierunku Y poziom ³atwy
     */
    protected double easyNormYVelocity;
    
    /**
     * Znormalizowana prêdkoœæ pi³ki w kierunku X poziom œredni
     */
    protected double mediumNormXVelocity;
    
    /**
     * Znormaliwana prêdkoœæ pi³ki w kierunku Y poziom œredni
     */
    protected double mediumNormYVelocity;
    
    /**
     * Znormalizowana prêdkoœæ pi³ki w kierunku X poziom trudny
     */
    protected double hardNormXVelocity;
    
    /**
     * Znormaliwana prêdkoœæ pi³ki w kierunku Y poziom trudny
     */
    protected double hardNormYVelocity;
    
    /**
     * Znormalizowana wartoœæ wypadkowa prêdkoœci
     */
    private double normVelocityVector;
    
    /**
     * Znormalizowana wartoœæ wypadkowa prêdkoœci poziom ³atwy
     */
    private double easyNormVelocityVector;
    
    /**
     * Znormalizowana wartoœæ wypadkowa prêdkoœci poziom œredni
     */
    private double mediumNormVelocityVector;
    
    /**
     * Znormalizowana wartoœæ wypadkowa prêdkoœci poziom trudny
     */
    private double hardNormVelocityVector;
    
    /**
     * Promieñ pi³ki
     */
    protected double ballRadius;

    /**
     * Znormalizowana pozycja X pi³ki
     */
    protected double normXPosition;
    /**
     * Znormalizowana pozycja Y Pi³ki
     */
    protected double normYPosition;
    /**
     * Po³o¿enie pi³eczki na osi X
     */
    protected double ballX;
    /**
     * Po³o¿enie pi³eczki na osi Y
     */
    protected double ballY;
    
    /**
     * Okreœla wybrany poziom trudnoœci
     */
    protected static String poziom;
    
    /**
     * Konstruktor klasy Ball
     * @param screenWidth1 Parametr szerokoœci ekranu
     * @param screenHeight1 Parametr wysokoœci ekranu 
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
     * Metoda ustawia pi³kê w pocz¹tkowym miejscu
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
     * Metoda zwracaj¹ca prostok¹t reprezentuj¹cy pi³kê
     * @return Zwraca prostok¹t reprezentuj¹cy pi³kê
     */
    public Rectangle getBallRect(){
        return ballRect;
    }

    /**
     * Zwraca wspó³rzêdn¹ X pi³eczki
     * @return wspó³rzêdna x pi³eczki
     */
    public double getXofBall()
    {
    	return ballRect.x; 	
    }
    
    /**
     * Zwraca wspó³rzêdn¹ Y pi³eczki
     * @return wspó³rzêdna y pi³eczki
     */
    public double getYofBall()
   {
    	return ballRect.y; 	
    }

    /**
     *  Metoda odpowiedzialna za poruszanie siê pi³eczki, aktualizuje jej po³o¿enie
     */
    
    public void move(){
	
    	normXPosition += normXVelocity;
		normYPosition += normYVelocity;
		
    }
    
    /**
     * Metoda odwracaj¹ca zwrot wektora prêdkoœci pi³ki w kierunku X
     */
    public void reverseXVelocity(){
  
    	normXVelocity=-normXVelocity;
    }
    
    /**
     * Metoda odwracaj¹ca zwrot wektora prêdkoœci pi³ki w kierunku Y
     */
    public void reverseYVelocity(){
    	
    	normYVelocity=-normYVelocity;
    }

    
    /**
     * Metoda zwracaj¹ca wspó³rzêdn¹ X dolnego prawego rogu pi³eczki (jako prostok¹ta)
     * @return wspó³rzêdna X dolnego prawego rogu pi³eczki
     */
    public double getBottomRightX()
    {
    	return ballX + ballRadius;
    }
    
    /**
     * Metoda zwracaj¹ca wspó³rzêdn¹ Y dolnego prawego rogu pi³eczki (jako prostok¹ta)
     * @return wspó³rzêdna Y dolnego prawego rogu pi³eczki
     */
    public double getBottomRightY()
    {
    	return ballY + ballRadius;

    }
}
