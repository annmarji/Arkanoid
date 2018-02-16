package Gra;

import java.awt.*;
import javax.swing.*;
import Wczytywanie_plikow.Constants;

/**
 * Klasa opisuj�ca paletk�
 */
public class Paddle extends JPanel 
{
    /**
     * Szeroko�� paletki
     */
    public int width;
    
    /**
     * Wysoko�� paletki
     */
    public int height;
    
    /**
     * Wsp�rz�dna X po�o�enie paletki
     */
    public int xPosition;
    
    /**
     * Wsp�rz�dna Y po�o�enia paletki 
     */
    public int yPosition;
    
    /**
     * Szeroko�� planszy do gry
     */
    protected int screenWidth;
    
    /**
     * Wysoko�� planszy do gry
     */
    private int screenHeight;
    
    /**
     * Prostok�t reprezentuj�cy paletk�
     */
    private Rectangle paddleRect;   

    /**
     * Znormalizowana pozycja Y paletki
     */
    protected double normYPosition;

    /**
     * Znormalizowana pozycja X Paletki
     */
    protected double normXPosition;

    /**
     * Znormalizowana szeroko�� paletki
     */
    protected double paddleWidth;

    /**
     * Znormalizowana wysoko�� paletki
     */
    protected double paddleHeight;
    
    /**
     * Warto�ci logiczne odpowiadaj�ce za ruch paletki
     */
    protected boolean right, left;
    
    /**
     * Pr�dko�� paletki w kierunku X
     */
    protected double velocityX;
    
    /**
     * Znormalizowana pr�dko�� paletki w kierunku X
     */
    protected double normVelocityX;
    
    /**
     * Konstrutor klasy Paddle
     * @param screenwidth szeroko�� ekrany
     * @param screenheight wysoko�� ekranu
     */
    public Paddle(int screenwidth, int screenheight){
        right = false;
        left = false;
    	this.screenWidth=screenwidth;
        this.screenHeight=screenheight; 
        paddleRect=new Rectangle(xPosition,yPosition,width,height);
        paddleWidth=Constants.paddleWidthRatio;
        paddleHeight=Constants.paddleHeightRatio;
        normVelocityX = Constants.paddleXVelocity;
        velocityX = Constants.paddleXVelocity * screenWidth;
        right = false;
        left = false;
        setStartPosition();
    }

    /**
     * Metoda ustawia paletk� w pocz�tkowej pozycji
     */
    public void setStartPosition(){

    	normXPosition=Constants.paddleStartX-0.5*paddleWidth;
        normYPosition=Constants.paddleStartY-paddleHeight/2;
        xPosition = ((int) Math.round(normXPosition * screenWidth));
        yPosition = ((int) Math.round(normYPosition * screenHeight));
        paddleRect.setSize((int)Math.round(paddleWidth*screenWidth),(int)Math.round(paddleHeight*screenHeight));
        paddleRect.setLocation(xPosition, yPosition);
        right = false;
        left = false;

    }

    /**
     * Metoda zwracaj�ca prostok�t opisuj�cy paletk�
     * @return prostok�t opisuj�cy rozmiar i po�o�enie paletki
     */
    public Rectangle getPaddleRect(){
        return paddleRect;
    }
    
    /**
     * Metoda odpowiedzialna za poruszanie si� paletki, aktualizuje jej po�o�enie
     */
    public void move()
    {
    	 
    	if (right && xPosition < (screenWidth - this.getPaddleRect().width))
    	{	    		
    		normXPosition += normVelocityX;
    	}
    	
    	if (left && xPosition > 0)
    	{
    		normXPosition -= normVelocityX;

    	}
    }
    
    /**
     *  Metoda zwracaj�ca wsp�rz�dn� X dolnego prawego rogu paletki
     * @return wsp�rz�dna X dolnego prawego rogu paletki
     */
    public double getBottomRightX()
    {
    	return xPosition + this.getPaddleRect().width;
    }
    
    /**
    * Metoda zwracaj�ca wsp�rz�dn� Y dolnego prawego rogu paletki
    * @return wsp�rz�dna Y dolnego prawego rogu paletki
    */
    public double getBottomRightY()
    {
    	return yPosition + this.getPaddleRect().height;

    }
}