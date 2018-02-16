package Gra;

import Wczytywanie_plikow.Constants;
import java.awt.*;


/**
 * Klasa boostera
 */
public class Booster 
{
    /**
     * Szeroko�� boostera
     */
    public int width;
    
    /**
     * Wysoko�� boostera
     */
    public int height;
    
    /**
     * Zmienna okre�laj�ca, �e booster jest prostok�tem
     */
    private Rectangle boosterRect;
    
    /**
     * Zmienna okre�laj�ca typ boostera
     */
    protected typeOfBooster boosterType;
    
    /**
     * Wysoko�� ekranu
     */
    private int screenHeight;

    /**
     * Szeroko�� ekranu
     */
    protected int screenWidth;
  
    /**
     * Znormalizowna wysoko�� boostera
     */
    protected double normHeight;
    
    /**
     * Znormalizowana szeroko�� boostera
     */
    protected double normWidth;
    
    /**
     * Znormalizowane po�o�enie boostera w p�aszczyznie X
     */
    protected double normX;
    
    /**
     * Znormalizowane po�o�enie boostera w p�aszczyznie Y
     */
    protected double normY;
    
    /**
     * Wsp�rz�dna X po�o�enie boostera
     */
    public int xPosition;
    
    /**
     * Wsp�rz�dna Y po�o�enia boostera 
     */
    public int yPosition;
    
    /**
     * Pr�dko�� boostera w kierunku Y
     */
    protected double velocityY;
    
    /**
     * Znormalizowana pr�dko�� boostera w kierunku Y
     */
    protected double normVelocityY;
   
    /**
     * Metoda zwracaj�ca booster jako kwadrat 
     * @return Cegie�ka jako prostok�t
     */
    public Rectangle getRect() {
        return boosterRect;
    }
    
    /**
     * Metoda zamieniaj�ca reprezentacj� typu boostera z int na wyliczeniowy
     *
     * @param number numer reprezentujacy typ boostera
     * @return Wyliczeniowy typ boostera
     */
  
    public typeOfBooster getTypeOfBooster(int number) {
        switch (number) {
        	case 4:
        		return typeOfBooster.BLACK;
            case 3:
                return typeOfBooster.RED;
            case 0:
                return typeOfBooster.YELLOW;
            case 1:
                return typeOfBooster.GREEN;
            case 2:
                return typeOfBooster.CYAN;
            default:
                return typeOfBooster.RED;
        }
    }
    
    /**
     * Konstruktor klasy Booster do tworzenia booster�w
     *
     * @param type   reprezentacja typu boostera jako int
     * @param x      wsp�rz�dna boostera na osi X
     * @param y      wsp�rz�dna boostera na osi Y
     * @param screenWidth1 szeroko�� ekranu
     * @param screenHeight1 wysoko�� ekranu
     */
   
   public Booster(int type, double x, double y, int screenWidth1, int screenHeight1) {

    	this.screenHeight=(int) (screenHeight1);
        this.screenWidth=(int) (screenWidth1);
        boosterRect=new Rectangle(xPosition,yPosition,width,height);
        this.normWidth = (Constants.boosterWidth);
        this.normHeight = (Constants.boosterHeight);
        normX = x + 4*this.normWidth;
        normY = y - this.normHeight/2;
        xPosition = ((int) Math.round(normX * screenWidth));
        yPosition = ((int) Math.round(normY * screenHeight));
        width = (int) Math.round(this.normWidth*screenWidth);
        height = (int)Math.round(this.normHeight*screenHeight);
        boosterType = getTypeOfBooster(type);
        boosterRect.setSize(width, height);
        boosterRect.setLocation(xPosition, yPosition);
        normVelocityY = Constants.paddleXVelocity;
        velocityY = Constants.paddleXVelocity * screenWidth;
       
   }
   
   /**
    * Metoda zwracaj�ca kolor boostera w zale�no�ci od jej typu
    * @return kolor boostera
    */
  public Color getColorFromType()
   {
   	return boosterType.getColor();
  }
   
   /**
    * Metoda zwracaj�ca prostok�t opisuj�cy booster
    * @return prostok�t opisuj�cy rozmiar i po�o�enie boostera
    */
   public Rectangle getBoosterRect(){
       return boosterRect;
   }
   
   /**
    * Metoda odpowiedzialna za poruszanie si� boostera, aktualizuje jego po�o�enie
    */
   public void move()
   {
   	 
   	if (yPosition < (screenHeight - this.normHeight))
   	{	 
   		normY += normVelocityY;
   	}
   	else
   	{   		
   		GamePanel.boosterActive = false;
   	}
   }
   

    
   /**
    * Zmienna wyliczeniowa opisuj�ca wyst�puj�ce typy booster�w
    */
   
   public enum typeOfBooster
   {	   	
	   BLACK(Color.black),
	   RED(Color.red),
	   YELLOW(Color.yellow),
	   GREEN(Color.green),
	   CYAN(Color.cyan);
	   
	   protected Color color;
		   
	  typeOfBooster (Color color) {
	      this.color = color;
	  }
	   
	  /**
	   * Zwraca kolor boostera     
	   *  @return kolor boostera
	   */
	   public Color getColor()
	   {
	       return color;
	   }
   }
}

