package Gra;

import java.awt.*;
import javax.swing.*;
import Wczytywanie_plikow.Constants;

/**
 * Klasa opisuj¹ca paletkê
 */
public class Paddle extends JPanel 
{
    /**
     * Szerokoœæ paletki
     */
    public int width;
    
    /**
     * Wysokoœæ paletki
     */
    public int height;
    
    /**
     * Wspó³rzêdna X po³o¿enie paletki
     */
    public int xPosition;
    
    /**
     * Wspó³rzêdna Y po³o¿enia paletki 
     */
    public int yPosition;
    
    /**
     * Szerokoœæ planszy do gry
     */
    protected int screenWidth;
    
    /**
     * Wysokoœæ planszy do gry
     */
    private int screenHeight;
    
    /**
     * Prostok¹t reprezentuj¹cy paletkê
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
     * Znormalizowana szerokoœæ paletki
     */
    protected double paddleWidth;

    /**
     * Znormalizowana wysokoœæ paletki
     */
    protected double paddleHeight;
    
    /**
     * Wartoœci logiczne odpowiadaj¹ce za ruch paletki
     */
    protected boolean right, left;
    
    /**
     * Prêdkoœæ paletki w kierunku X
     */
    protected double velocityX;
    
    /**
     * Znormalizowana prêdkoœæ paletki w kierunku X
     */
    protected double normVelocityX;
    
    /**
     * Konstrutor klasy Paddle
     * @param screenwidth szerokoœæ ekrany
     * @param screenheight wysokoœæ ekranu
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
     * Metoda ustawia paletkê w pocz¹tkowej pozycji
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
     * Metoda zwracaj¹ca prostok¹t opisuj¹cy paletkê
     * @return prostok¹t opisuj¹cy rozmiar i po³o¿enie paletki
     */
    public Rectangle getPaddleRect(){
        return paddleRect;
    }
    
    /**
     * Metoda odpowiedzialna za poruszanie siê paletki, aktualizuje jej po³o¿enie
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
     *  Metoda zwracaj¹ca wspó³rzêdn¹ X dolnego prawego rogu paletki
     * @return wspó³rzêdna X dolnego prawego rogu paletki
     */
    public double getBottomRightX()
    {
    	return xPosition + this.getPaddleRect().width;
    }
    
    /**
    * Metoda zwracaj¹ca wspó³rzêdn¹ Y dolnego prawego rogu paletki
    * @return wspó³rzêdna Y dolnego prawego rogu paletki
    */
    public double getBottomRightY()
    {
    	return yPosition + this.getPaddleRect().height;

    }
}