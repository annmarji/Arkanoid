package Gra;

import Wczytywanie_plikow.Constants;
import java.awt.*;

/**
 * Klasa cegie�ki
 */
public class Brick 
{
    /**
     * Zmienna okre�laj�ca, �e cegie�ka jest prostok�tem
     */
    private Rectangle brickRect;
   
    /**
     * Zmienna okre�laj�ca typ cegie�ki
     */
    protected typeOfBrick brickType;
    
    /**
     * Wysoko�� ekranu
     */
    private int screenHeight;

    /**
     * Szeroko�� ekranu
     */
    private int screenWidth;
  
    /**
     * Znormalizowna wysoko�� cegielki
     */
    protected double normHeight;
    
    /**
     * Znormalizowana szeroko�� cegielki
     */
    protected double normWidth;
    
    /**
     * Znormalizowane po�o�enie cegie�ki w p�aszczyznie X
     */
    protected double normX;
    
    /**
     * Znormalizowane po�o�enie cegie�ki w p�aszczyznie Y
     */
    protected double normY;
    
    /**
     * Numer boostra w cegie�ce
     */
    protected int numberOfBrickBooster;
    
    /**
     * Metoda zwracaj�ca cegie�k� jako prostok�t 
     * @return Cegie�ka jako prostok�t
     */
    public Rectangle getRect() {
        return brickRect;
    }
    
    /**
     * Metoda zamieniaj�ca reprezentacj� typu cegie�ki z int na wyliczeniowy
     *
     * @param number numer reprezentujacy typ cegie�ki
     * @return Wyliczeniowy typ cegie�ki
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
     * Metoda ustalaj�ca typ cegie�ki
     * @param b nowy typ cegie�ki
     */
    public void setTypeOfBrick(typeOfBrick b)
    {
    	this.brickType = b;
    }
    
    
    /**
     * Metoda zwracaj�ca kolor cegie�ki w zale�no�ci od jej typu
     * @return kolor cegie�ki
     */
   public Color getColorFromType()
    {
    	return brickType.getColor();
   }
    
    /**
     * Konstruktor klasy Brick do tworzenia cegie�ek
     *
     * @param x      wsp�rz�dna cegie�ki na osi X
     * @param y      wsp�rz�dna cegie�ki na osi Y
     * @param type   reprezentacja typu cegie�ki jako int
     * @param screenWidth1 szeroko�� ekranu
     * @param screenHeight1 wysoko�� ekranu
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
     * Zmienna wyliczeniowa opisuj�ca wyst�puj�ce typy cegie�ek
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
      * Zwraca kolor cegie�ki      
      *  @return kolor cegie�ki
      */

        public Color getColor() {
            return color;
        }
    }
    
    /**
     * Zwraca wspolrzedna X cegie�ki
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
     * Zwraca szeroko�� cegielki
     * @return szeroko�� cegielki
     */
    public double getWidth()
    {
    	return brickRect.width;
    }
    
    /**
     * Zwraca wysoko�� Y cegielki
     * @return wysoko�� cegielki
     */
    public double getHeight()
    {
    	return brickRect.height;
    }
    
   }
