package Gra;

import Wczytywanie_plikow.Constants;
import java.awt.*;

/**
 * Klasa cegie³ki
 */
public class Brick 
{
    /**
     * Zmienna okreœlaj¹ca, ¿e cegie³ka jest prostok¹tem
     */
    private Rectangle brickRect;
   
    /**
     * Zmienna okreœlaj¹ca typ cegie³ki
     */
    protected typeOfBrick brickType;
    
    /**
     * Wysokoœæ ekranu
     */
    private int screenHeight;

    /**
     * Szerokoœæ ekranu
     */
    private int screenWidth;
  
    /**
     * Znormalizowna wysokoœæ cegielki
     */
    protected double normHeight;
    
    /**
     * Znormalizowana szerokoœæ cegielki
     */
    protected double normWidth;
    
    /**
     * Znormalizowane po³o¿enie cegie³ki w p³aszczyznie X
     */
    protected double normX;
    
    /**
     * Znormalizowane po³o¿enie cegie³ki w p³aszczyznie Y
     */
    protected double normY;
    
    /**
     * Numer boostra w cegie³ce
     */
    protected int numberOfBrickBooster;
    
    /**
     * Metoda zwracaj¹ca cegie³kê jako prostok¹t 
     * @return Cegie³ka jako prostok¹t
     */
    public Rectangle getRect() {
        return brickRect;
    }
    
    /**
     * Metoda zamieniaj¹ca reprezentacjê typu cegie³ki z int na wyliczeniowy
     *
     * @param number numer reprezentujacy typ cegie³ki
     * @return Wyliczeniowy typ cegie³ki
     */
    public typeOfBrick getTypeOfBrick(int number) {
        switch (number) {
        	case 4:		
        		return typeOfBrick.BLACK;		
            case 3:
                return typeOfBrick.RED;
            case 2:
                return typeOfBrick.YELLOW;
            case 1:
                return typeOfBrick.GREEN;
            case 0:
                return typeOfBrick.NONE;
            default:
                return typeOfBrick.NONE;
        }
    }
    /**
     * Metoda ustalaj¹ca typ cegie³ki
     * @param b nowy typ cegie³ki
     */
    public void setTypeOfBrick(typeOfBrick b)
    {
    	this.brickType = b;
    }
    
    
    /**
     * Metoda zwracaj¹ca kolor cegie³ki w zale¿noœci od jej typu
     * @return kolor cegie³ki
     */
   public Color getColorFromType()
    {
    	return brickType.getColor();
   }
    
    /**
     * Konstruktor klasy Brick do tworzenia cegie³ek
     *
     * @param x      wspó³rzêdna cegie³ki na osi X
     * @param y      wspó³rzêdna cegie³ki na osi Y
     * @param type   reprezentacja typu cegie³ki jako int
     * @param screenWidth1 szerokoœæ ekranu
     * @param screenHeight1 wysokoœæ ekranu
     */
   
   public Brick(double x, double y,  int type, int screenWidth1, int screenHeight1) {

    	this.screenHeight=(int) (screenHeight1);
        this.screenWidth=(int) (screenWidth1);

        this.normWidth = (Constants.brickWidth);
        this.normHeight = (Constants.brickHeight);
 
        normX = x + normWidth;
        normY = y;
        brickType = getTypeOfBrick(type);
        numberOfBrickBooster=0;
        brickRect = new Rectangle((int) Math.round(((x* screenWidth))), (int) Math.round(y* screenHeight), 
        		   (int) Math.round(normWidth* screenWidth), (int) Math.round(normHeight* screenHeight));
   }
       
          
    /**
     * Zmienna wyliczeniowa opisuj¹ca wystêpuj¹ce typy cegie³ek
     */
    
    public enum typeOfBrick {
    	BLACK(Constants.blackBrickLifes, Constants.blackBrickPoints, Color.black),		
    	RED(Constants.redBrickLifes, Constants.redBrickPoints, Color.red),
    	YELLOW(Constants.yellowBrickLifes, Constants.yellowBrickPoints, Color.yellow),
    	GREEN(Constants.greenBrickLifes, Constants.greenBrickPoints, Color.green),    
        NONE(Constants.noneBrickLifes, Constants.noneBrickPoints, Color.white);

        protected int life;	
        protected int points;
        protected Color color;

        typeOfBrick(int life, int points, Color color) {
            this.life = life;
            this.points = points;
            this.color = color;
        }
       
     /**
      * Zwraca kolor cegie³ki      
      *  @return kolor cegie³ki
      */

        public Color getColor() {
            return color;
        }
    }
    
    /**
     * Zwraca wspolrzedna X cegie³ki
     * @return wspolrzedna X cegielki
     */
    public double getXofBrick()
    {
    	return brickRect.getX(); 	
    }
    
    /**
     * Zwraca wspolrzedna Y cegielki
     * @return wspolrzedna Y cegielki
     */
    
    public double getYofBrick()
    {
    	return brickRect.getY(); 	
    }
    
    /**
     * Zwraca szerokoœæ cegielki
     * @return szerokoœæ cegielki
     */
    public double getWidth()
    {
    	return brickRect.width;
    }
    
    /**
     * Zwraca wysokoœæ Y cegielki
     * @return wysokoœæ cegielki
     */
    public double getHeight()
    {
    	return brickRect.height;
    }
    
   }
