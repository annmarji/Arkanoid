package Gra;

import Gra.Brick.typeOfBrick;
import Wczytywanie_plikow.Constants;
import java.awt.*;


/**
 * Klasa odpowiedzialna za obs³ugê kolizji w grze
 */
public class Collision 
	{

	/**
     * Zmienna reprezentujaca plike
     */
    private Ball pilka;
    
    /**
     * Zmienna reprezentujaca paletke
     */
    private Paddle paletka;
    
    /**
     * 	Panel gry, w którym mamy okreœlon¹ tablicê cegie³ek
     */
    protected GamePanel gamePanel;

    /**
     * Okreœla czy pi³ka znalaz³a siê poza polem gry
     */
    protected boolean ballOutOfScreen;    
    
    /**
     * Wysokoœæ panelu gry
     */
	private int gamePanelHeight;
	
	/**
	 * Szerokoœæ panelu gry
	 */
	private int gamePanelWidth;

	 /**
     * Liczba rzêdów cegie³ek
     */
    private int numberOfRows;
    
    /**
     * Liczba kolumn cegie³ek
     */
    private int numberOfColumnes;
    
    /**
     * Okresla liczbe punktow uzyskanych za zbicie klockow
     */
    protected static int points;
    
    /**
     * Okresla, czy doszlo do kolizji z klockami
     */
    protected boolean blockCollision;
    
    /**
     * Okreœla, czy na planszy znajduj¹ siê jeszcze jakieœ cegie³ki do zbicia
     */
    protected boolean bricksExist;
	
    /**
     * Kontruktor klasy Collision
     * @param pilka pi³ka
     * @param paddle paletka
     */
    public Collision(Ball ball, Paddle paddle){
        
        numberOfColumnes=Constants.numberOfBrickColumnes;
        numberOfRows=Constants.numberOfBrickRows;
        pilka = ball;
        paletka = paddle;
        ballOutOfScreen=false;

    }

    /**
     * Sprawdza czy dosz³o do kolizji miêdzy pi³eczk¹ a œciankami pola gry
     */
    public void wallCollision()
	{
		if(pilka.ballY<=0)
			pilka.reverseYVelocity();
		if(pilka.ballX<=0 || ((pilka.ballX+pilka.getBallRect().getWidth())>=gamePanelWidth))
		{
			pilka.reverseXVelocity();
		}
	}

    
    /**
     * Metoda sprwadzaj¹ca czy wyst¹pi³a kolizja z doln¹ krawêdzi¹
     * @return czy wystapi³a kolizja z dolna krawêdzi¹
     */
    private boolean bottomCageCollision(){
        return (pilka.ballY+pilka.getBallRect().getHeight()>=gamePanelHeight) ? true : false;
    }
    
    
    /**
     * Metoda odpowiedzialna za sprawdzanie kolizji w grze
     * @param gamePanelW szerokosc panelu gry
     * @param gamePanelH wysokosc panelu gry
     */
    public void checkCollisions(int gamePanelW, int gamePanelH){
    	this.gamePanelHeight=gamePanelH;
        this.gamePanelWidth=gamePanelW;
        wallCollision();
        ballOutOfScreen=false;
        if(bottomCageCollision()){
            ballOutOfScreen=true;                  
        }
        checkBlockCollisions();
        paddleBounce();
   
    }
    
	/**
	 * Metoda odpowiadaj¹ca za stwierdzenie czy nast¹pi³o uderzenie pi³eczki o paletkê i zmiany zwrotu prêdkoœci pi³ki w kierunku Y
	 */
    
	public void paddleBounce()
	{
			
		if ((pilka.ballX + pilka.ballRadius + pilka.normXVelocity*gamePanelWidth)>=paletka.xPosition && pilka.ballX<=(paletka.xPosition+paletka.getPaddleRect().width) 
			&& (pilka.ballY + pilka.ballRadius + (pilka.normYVelocity*gamePanelHeight))>=(paletka.yPosition)&& pilka.ballY<=(paletka.yPosition))//&& pilka.getYofBall()>=(paletka.yPosition+(pilka.normalizedYVelocity*panelHeight)/2))
			
		{
			pilka.reverseYVelocity();
		
			if(paletka.right || paletka.left)  
			{
				if( pilka.normXVelocity >0)
					pilka.normXVelocity += 0.001;
				if( pilka.normXVelocity <0)
					pilka.normXVelocity -= 0.001;
			}
		}
	}
	
    /**
     * Metoda sprawdzaj¹ca wyst¹pnienie kolizji z cegie³kami
     */
    public void checkBlockCollisions()
    {

        blockCollision = false;
        bricksExist = false;

    	for (int n = 0; n < numberOfRows; n++) {
            for (int m = 0; m < numberOfColumnes; m++) {
            	Brick brick = GamePanel.bricks[n][m];
            	
            	if (brick.getColorFromType() != Color.white)
            	{
            		bricksExist = true;
            		
            		if (((pilka.ballX + pilka.getBallRect().width + (pilka.normXVelocity*gamePanelWidth) >= (brick.normX * gamePanelWidth) ) &&
                          ((pilka.ballX + (pilka.normXVelocity*gamePanelWidth))  <= ((brick.normX + brick.normWidth) * gamePanelWidth) &&
                            ((pilka.ballY + pilka.getBallRect().height + (pilka.normYVelocity *gamePanelHeight)) >= (brick.normY * gamePanelHeight)) &&
                               ((pilka.ballY + (pilka.normYVelocity*gamePanelHeight)) <= ((brick.normY + brick.normHeight)* gamePanelHeight)))))
            			
            		{
            			
            			blockCollision = true;      		
            			
            			switch (brick.brickType.toString())
            			{          			
	        				case "BLACK":
	        				{
	        					GamePanel.boosterActive = true;			
	        					GamePanel.numberOfActiveBooster=brick.numberOfBrickBooster;		
	        					brick.setTypeOfBrick(typeOfBrick.NONE);			
	        					points += typeOfBrick.BLACK.points;
	        					break;
	        				}
            				case "RED":
            				{
            					brick.setTypeOfBrick(typeOfBrick.YELLOW);
            					points += typeOfBrick.RED.points;
            					break;
            				}
            				case "YELLOW":
            				{
            					brick.setTypeOfBrick(typeOfBrick.GREEN);
            					points += typeOfBrick.YELLOW.points;
            					break;
            				}
            				case "GREEN":
            				{
            					brick.setTypeOfBrick(typeOfBrick.NONE);
            					points += typeOfBrick.GREEN.points;
            					break;
            				}
            				default:
            					break;            				
            			}
    
                		if (((pilka.ballX + pilka.getBallRect().width) <= (brick.normX*gamePanelWidth)) && ((pilka.ballX + pilka.getBallRect().width +  (pilka.normXVelocity*gamePanelWidth)) >= (brick.normX*gamePanelWidth)))
     						{    							   							
     							pilka.reverseXVelocity();
     						}
                		
            			else if (((pilka.ballX) >= ((brick.normX+brick.normWidth)*gamePanelWidth)) && ((pilka.ballX - pilka.getBallRect().width + (pilka.normXVelocity*gamePanelWidth)) <= ((brick.normX+brick.normWidth)*gamePanelWidth )))
     						{						
     							pilka.reverseXVelocity();
     						}
            			
            			else if (((pilka.ballY) >= ((brick.normY+brick.normHeight)*gamePanelHeight)) && ((pilka.ballY + (pilka.normYVelocity * gamePanelHeight)) <= ((brick.normHeight+brick.normY)*gamePanelHeight)))
						{
														
							pilka.reverseYVelocity();
						}
            			
                		else if ((pilka.ballY  <= (brick.normY * gamePanelHeight)) && ((pilka.ballY + pilka.getBallRect().height +(pilka.normYVelocity*gamePanelHeight)) >= (brick.normY * gamePanelHeight)))
            			{                   		
                   			pilka.reverseYVelocity();
                   		}
            			
            			else
            			{
            				pilka.reverseXVelocity();
            				pilka.reverseYVelocity();           			
            			}
            		
            		}
            	}
            	
            }
    	}
            				
 
    }


}
