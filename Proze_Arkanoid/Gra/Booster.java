package Gra;

import Wczytywanie_plikow.Constants;
import java.awt.*;


/**
 * Klasa boostera
 */
public class Booster 
{
    /**
     * Szerokoœæ boostera
     */
    public int width;
    
    /**
     * Wysokoœæ boostera
     */
    public int height;
    
    /**
     * Zmienna okreœlaj¹ca, ¿e booster jest prostok¹tem
     */
    private Rectangle boosterRect;
    
    /**
     * Zmienna okreœlaj¹ca typ boostera
     */
    protected typeOfBooster boosterType;
    
    /**
     * Wysokoœæ ekranu
     */
    private int screenHeight;

    /**
     * Szerokoœæ ekranu
     */
    protected int screenWidth;
  
    /**
     * Znormalizowna wysokoœæ boostera
     */
    protected double normHeight;
    
    /**
     * Znormalizowana szerokoœæ boostera
     */
    protected double normWidth;
    
    /**
     * Znormalizowane po³o¿enie boostera w p³aszczyznie X
     */
    protected double normX;
    
    /**
     * Znormalizowane po³o¿enie boostera w p³aszczyznie Y
     */
    protected double normY;
    
    /**
     * Wspó³rzêdna X po³o¿enie boostera
     */
    public int xPosition;
    
    /**
     * Wspó³rzêdna Y po³o¿enia boostera 
     */
    public int yPosition;
    
    /**
     * Prêdkoœæ boostera w kierunku Y
     */
    protected double velocityY;
    
    /**
     * Znormalizowana prêdkoœæ boostera w kierunku Y
     */
    protected double normVelocityY;
   
    /**
     * Metoda zwracaj¹ca booster jako kwadrat 
     * @return Cegie³ka jako prostok¹t
     */
    public Rectangle getRect() {
        return boosterRect;
    }
    
    /**
     * Metoda zamieniaj¹ca reprezentacjê typu boostera z int na wyliczeniowy
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
     * Konstruktor klasy Booster do tworzenia boosterów
     *
     * @param type   reprezentacja typu boostera jako int
     * @param x      wspó³rzêdna boostera na osi X
     * @param y      wspó³rzêdna boostera na osi Y
     * @param screenWidth1 szerokoœæ ekranu
     * @param screenHeight1 wysokoœæ ekranu
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
    * Metoda zwracaj¹ca kolor boostera w zale¿noœci od jej typu
    * @return kolor boostera
    */
  public Color getColorFromType()
   {
   	return boosterType.getColor();
  }
   
   /**
    * Metoda zwracaj¹ca prostok¹t opisuj¹cy booster
    * @return prostok¹t opisuj¹cy rozmiar i po³o¿enie boostera
    */
   public Rectangle getBoosterRect(){
       return boosterRect;
   }
   
   /**
    * Metoda odpowiedzialna za poruszanie siê boostera, aktualizuje jego po³o¿enie
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
    * Zmienna wyliczeniowa opisuj¹ca wystêpuj¹ce typy boosterów
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

