package Gra;

import Gra.Brick.typeOfBrick;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.*;
import java.net.MalformedURLException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import Wczytywanie_plikow.Constants;

/**
 * Klasa panelu gry
 */


public class GamePanel extends JPanel implements Runnable,  KeyListener
{
	/**
     * Wysokoœæ panelu gry
     */
    private int panelHeight;
    /**
     * Szerokoœæ panelu gry
     */
    private int panelWidth;
    /**
     * Wymiar okna
     */
    private Dimension gamePanelSize;
    /**
     * Obiekt paletka
     */
    protected Paddle paletka;
    
    /**
     * Kolor planszy
     */
    private Color boardColor;
    
    /**
     * Obiekt pi³ka
     */
    protected Ball pilka;
    
    /**
     * Tablica obiektów cegie³ek
     */
    protected static Brick[][] bricks;
    
    /**
     * Liczba rzêdów cegie³ek
     */
    private int numberOfRows;
    
    /**
     * Liczba kolumn cegie³ek
     */
    private int numberOfColumnes;
    
    /**
     * Szerokosc cegielki
     */
    private double BrickWidth;
    
    /**
     * Wysokosc cegielki
     */
    private double BrickHeight;
 
    /**
     * Obiekt obs³uguj¹cy kolizje
     */
    private Collision CollisionE;  
    
    /**
     * Iloœæ boosterów
     */
    private int numberOfBoosters; 
    
    /**
     * Tablica obiektów boosterów
     */
    protected Booster[] boosters;
    
    /**
     * Numer aktywnego boostera
     */
    protected static int numberOfActiveBooster;
    
    /**
     * Okreœla, czy czarny booster jest aktywny
     */
    protected static boolean blackBoosterActive;
    
    /**
     * Okreœla, czy ¿ó³ty booster jest aktywny
     */
    protected static boolean yellowBoosterActive;
    
    /**
     * Okreœla, czy jakiœ booster jest aktywny
     */
    protected static boolean boosterActive;	
    
    /**
     * W¹tek odpowiadaj¹cy za animacje
     */ 
    private Thread animthread;

    /**
     * Okreœla, czy gra zosta³a zatrzymana
     */
    protected static volatile boolean isPaused = true;
    
    /**
     * Liczy czas rozgrywki
     */
    public Timer timer;
    
    /**
     * G³ówne okno gry
     */
    protected MainGameWindow mainGameWindow;
    
	/**
	* Panel informacyjny
	*/
	protected InfoPanel infoPanel;
	
    /**
     * Okno g³ównego menu
     */
    protected MainMenuFrame mainMenuFrame;
    
    /**
     * Okreœla aktualny numer planszy
     */
    protected int nrLevel;
    
    /**
     * Kontruktor panelu gry
     * @param gamePanelWidth szerokoœæ panelu gry
     * @param gamePanelHeight wysokoœæ panelu gry
     * @param infoContainer inforamcyjny
     * @param mainContainer okno g³ównego menu
     */

    public GamePanel(int gamePanelWidth, int gamePanelHeight, InfoPanel infoContainer, MainGameWindow mainContainer) {
    	
        nrLevel = Constants.firstLevel;
    	boosterActive = false;	
    	blackBoosterActive=false;
    	yellowBoosterActive=false;
        numberOfBoosters = 6;
        numberOfActiveBooster=10;	
    	numberOfColumnes = Constants.numberOfBrickColumnes;
        numberOfRows = Constants.numberOfBrickRows;
        panelHeight = (int)Math.round(gamePanelHeight*Constants.heightOfGamePanel);
        panelWidth = (int)Math.round(gamePanelWidth*Constants.widthOfGamePanel);
        gamePanelSize = new Dimension(panelWidth, panelHeight);
        setPreferredSize(gamePanelSize);
        setLayout(new BorderLayout());
        boardColor = Color.white;
        numberOfBoosters = 6;
        numberOfActiveBooster=10;
        addComponents(); 
        mainContainer.addKeyListener(this);
        infoPanel = infoContainer;	
        mainGameWindow = mainContainer;            	
    }

    /**
     * Metoda inicjuj¹ca obiekty
     */
    private void addComponents() {
  
        paletka = new Paddle(panelWidth, panelHeight);
        pilka = new Ball(panelWidth, panelHeight);
        loadFirstLevel();
 
    }
    
    /**
     * Metoda wczytuj¹ca pierwsz¹ planszê z pliku konfiguracyjnego
     */

    private void loadFirstLevel(){
                
    	makeBricksAndBoosters("level"+nrLevel+".xml");
        CollisionE=new Collision(pilka, paletka);
    	nrLevel++;
    }
    
    /**
     * Metoda wczytuj¹ca kolejn¹ planszê z pliku konfiguracyjnego
     */
    protected void loadNextLevel(){

    	   makeBricksAndBoosters("level"+nrLevel+".xml");
    	   removeBoosters();
    	   nrLevel++;

    }
  
    /**
     * Metoda która usuwa dzia³anie boosterów przy przejœciu do kolejnego poziomu
     */
    
    private void removeBoosters()
    {
    	  GamePanel.blackBoosterActive = false;
		  GamePanel.yellowBoosterActive = false;
    }

    /**
     * Metoda kreuj¹ca cegie³ki w o odpowiednich rozmiarach i rozmieszczeniu oraz boostery w czarnych cegie³kach
     * @param fname nazwa pliku
     */

    private void makeBricksAndBoosters(String fname){
        bricks = new Brick[numberOfRows][numberOfColumnes];
        boosters = new Booster[numberOfBoosters];
        double startY=(1-1.0*Constants.brickStartYCounter/Constants.brickStartYDenominator);
        double startX=Constants.brickStartX;
        int p=0;
        int[][] brickArray=fillBrickArray(fname);
        for(int n=0;n<numberOfRows;n++){
            startX=0;
            for(int m=0;m<numberOfColumnes;m++) {
                bricks[n][m] = new Brick(startX, startY, brickArray[n][m], panelWidth, panelHeight);
                if(brickArray[n][m] ==4)
                {
                	boosters[p] = new Booster(p, startX, startY, panelWidth, panelHeight);
  
                	bricks[n][m].numberOfBrickBooster = p;
                	p++;
                }
                BrickWidth = bricks[n][m].normWidth; 
                BrickHeight =bricks[n][m].normHeight;
                startX += BrickWidth;
            }
            startY+= BrickHeight+0.01;
        }
    }
    				
    /**
     * Metoda do tworzenia muru z cegie³ek dla danego poziomu gry
     * @param filename nazwa pliku
     * @return Tablica cegie³ek
     */

    private int[][] fillBrickArray(String filename){
        int[][] brickArray=new int[numberOfRows][numberOfColumnes];
        try {
            File XmlFile = new File(Constants.xmlLvlFile+filename);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(XmlFile);
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("row");
            for (int x = 0; x < nList.getLength(); x++) {
                Node nNode = nList.item(x);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    for(int i=0;i<10;i++) {
                        brickArray[x][i]=Integer.parseInt(eElement.getElementsByTagName("column").item(i).getTextContent());
                    }
                }
            }
        }
        catch (Exception e){
            System.out.println("B³¹d wczytywania pliku");
        }
        return brickArray;
    }
     

    /**
     * Metoda do rysowania komponentow w grze
     * @param g grafika
     */
   @Override
    public void paintComponent(Graphics g)
    {   
	   super.paintComponent(g);
	   Dimension size2 = new Dimension();
	   size2 = getSize();
	   
	   panelWidth = size2.width;
	   panelHeight = size2.height;

    	drawPaddle(g);

        for (int n = 0; n < numberOfRows; n++) {
            for (int m = 0; m < numberOfColumnes; m++) {
                drawBricks(g, n, m); 
            }
        }
        if(GamePanel.boosterActive)					
        {
            drawBoosters(g, GamePanel.numberOfActiveBooster); 
        }							
        drawBall(g);
    }

    /**
     * Metoda do rysowania paletki
     * @param g grafika
     */

    private void drawPaddle(Graphics g) {			
        g.setColor(Color.blue);
        paletka.screenWidth = panelWidth;
        paletka.getPaddleRect().width = (int) (panelWidth*Constants.paddleWidthRatio);
        paletka.getPaddleRect().height = (int) (panelHeight*Constants.paddleHeightRatio);
        paletka.xPosition = (int) (paletka.normXPosition*panelWidth);
        paletka.yPosition = (int) (paletka.normYPosition*panelHeight);
        paletka.getPaddleRect().height = (int) (panelHeight*Constants.paddleHeightRatio);
        
        if(GamePanel.blackBoosterActive)
        {
        	paletka.getPaddleRect().width = (int) (panelWidth*Constants.paddleWidthRatio/2);          
        	g.fillRect((int) paletka.xPosition, (int) paletka.yPosition, (int) paletka.getPaddleRect().width, (int) paletka.getPaddleRect().height);
        } 
        else if(GamePanel.yellowBoosterActive)
        {
        	paletka.getPaddleRect().width = (int) (panelWidth*Constants.paddleWidthRatio*2); 
        	g.fillRect((int) paletka.xPosition, (int) paletka.yPosition, (int) paletka.getPaddleRect().width, (int) paletka.getPaddleRect().height);
        }
        else
        {
        	paletka.getPaddleRect().width = (int) (panelWidth*Constants.paddleWidthRatio); 
        	g.fillRect((int) paletka.xPosition, (int) paletka.yPosition, (int) paletka.getPaddleRect().width, (int) paletka.getPaddleRect().height);
        }
    }
    					
    /**
     * Metoda do kolorowania boosterów
     * @param g grafika
     * @param k numer i typ boostera
     */
    
    private void drawBoosters(Graphics g, int k){		
        Booster booster = boosters[k];
           g.setColor(booster.getColorFromType());

           booster.screenWidth = panelWidth;
           booster.getBoosterRect().width = (int) (panelWidth*Constants.paddleWidthRatio);
           booster.getBoosterRect().height = (int) (panelHeight*Constants.paddleHeightRatio);
           booster.xPosition = (int) (booster.normX*panelWidth);
           booster.yPosition = (int) (booster.normY*panelHeight);
           g.fillRect((int) booster.xPosition, (int) booster.yPosition, (int) booster.getBoosterRect().getWidth()/6, (int) booster.getBoosterRect().getHeight());
    }
    											
    /**
     * Metoda do rysowania pileczki
     * @param g grafika
     */
    private void drawBall(Graphics g) {
    	
        g.setColor(Color.orange);
        pilka.ballX = pilka.normXPosition*panelWidth;
    	pilka.ballY = pilka.normYPosition*panelHeight;
    	pilka.getBallRect().width = (int) (pilka.ballRadius * panelWidth);
    	pilka.getBallRect().height = (int) (pilka.ballRadius * panelHeight);
    	
    	g.fillOval((int) pilka.ballX, (int) pilka.ballY, pilka.getBallRect().width, pilka.getBallRect().height);//(int) pilka.ballRadius * panelWidth , (int) pilka.ballRadius * panelWidth);

    }

    /**
     * Metoda do rysowania cegie³ek
     * @param g grafika
     * @param n numer wiersza
     * @param m numer kolumny
     */
    private void drawBricks(Graphics g, int n, int m){
        Brick brick = bricks[n][m];
           g.setColor(brick.getColorFromType());

           	g.fillRect((int) (brick.normX * panelWidth), 
        			   (int) (brick.normY * panelHeight), (int) (brick.normWidth * panelWidth), (int) (brick.normHeight * panelHeight));
    }
    
    /**
     * 	Metoda odpowiadaj¹ca za animacjê gry
     */
    @Override
    public void run()
    {
    	
    	try {
			while (animthread == Thread.currentThread()) {   
    					
    	while ((pilka.getYofBall() < panelHeight + 50 ) && mainGameWindow.anyLifes)
    	{ 
    		try {
    		    if (isPaused) {
    		        synchronized (this) {
    		            while (isPaused) {
    		                MainGameWindow.stopTimer();
    		                JOptionPane.showMessageDialog(null, "Gra zatrzymana. Aby wznowiæ naciœnij spacjê.");
    		            	wait();							
    		            }
    		        }
    		    }
    		} catch (InterruptedException e) {
    		    e.printStackTrace();
    		}
    		MainGameWindow.startTimer();
    		CollisionE.checkCollisions(panelWidth, panelHeight);

    		checkEvents();
    		
    		paletka.move();
    	
    		pilka.move();
    		
    		revalidate();
    		repaint();

    		 try 
    		 { 
    			 Thread.sleep(30);
                       
                     } catch (InterruptedException e) {
                    	 Thread.currentThread().interrupt();
             }
                    
    		}
    	
			}

			}
    	catch(Exception e)
			{
				e.printStackTrace();
			}
    	
  	
    }
    
    /**
     * Metoda s³u¿¹ca do wznawiania gry po pauzie
     */
    public synchronized void resumeGame() {
        isPaused = false;
        notify();
    }
    
    /**
     * Sprawdza czy zaszlo jakies zdarzenie typu zbicie cegielki, czy strata zycia
     */
    public void checkEvents()
    {
    	if(GamePanel.boosterActive)		
		{
			boosters[numberOfActiveBooster].move();
			paddleGetBooster();		
		}							
		if (CollisionE.blockCollision)
		{	
			mainGameWindow.getPoints();		   
		}
		if (CollisionE.ballOutOfScreen)
		{			
			mainGameWindow.takeLife();
				
	
			if (mainGameWindow.lifesLess)
			{
				pilka.setInitOnScreen();
				paletka.setStartPosition();
				GamePanel.boosterActive = false;
				repaint();
				isPaused = true;
			}
		
		}	

		if (CollisionE.bricksExist == false)
		{
			GamePanel.boosterActive = false;
			isPaused = true;
			mainGameWindow.endOfLevel();    		
			
		} 
    }
    
    /**
     * Metoda zsynchronizuj¹ca animacjê 
     */
    public synchronized void start() {
    	startAnimationThread();
    }
    
    /**
     * Metoda uruchamiaj¹ca w¹tek odpowiadaj¹cy za animacjê
     */
    void startAnimationThread() {
		(animthread = new Thread(this)).start();					
	}


	/**
	 * Metoda odpowiedzialna za ruch paletki w odpowiedzi na naciskanie klawiszy.
	 */

	public void keyPressed(KeyEvent e) {

		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
			paletka.right = true;
		if (e.getKeyCode() == KeyEvent.VK_LEFT)
			paletka.left = true;
	
	if (e.getKeyCode()==KeyEvent.VK_SPACE)

	{ 
		if (isPaused == false) 
		{
	        isPaused = true;
	    } 
		else 
	    {
	        resumeGame();
	    }
	}
	}

	/**
	 * Metoda odpowiedzialna za zatrzymanie ruchu paletki po zwolnieniu przycisku
	 */
	public void keyReleased(KeyEvent e) {
		
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
			paletka.right = false;
		if (e.getKeyCode() == KeyEvent.VK_LEFT)
			paletka.left = false;

	}

	
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}
	
	
	/**
	 * Metoda odpowiadaj¹ca za stwierdzenie czy paletka przechwyci³a boostera
	 */
	public void paddleGetBooster()
	{
		if (boosters[numberOfActiveBooster].xPosition>=paletka.xPosition && boosters[numberOfActiveBooster].xPosition<=paletka.getBottomRightX() 
				&& ((boosters[numberOfActiveBooster].yPosition+boosters[numberOfActiveBooster].height)>=(paletka.yPosition))&& boosters[numberOfActiveBooster].yPosition<=(paletka.yPosition))

				{
			checkTypeOfBooster();
			 mainGameWindow.playSound("Sounds\\fireball.wav");
			GamePanel.boosterActive = false;
		}

	}
	
	/**
	 * Metoda sprawdzaj¹ca typ boostera
	 */
	public void checkTypeOfBooster()
	{
		switch (boosters[numberOfActiveBooster].boosterType.toString())
		{          			
			case "BLACK":
			{
				GamePanel.yellowBoosterActive = false;
				GamePanel.blackBoosterActive = true;
				break;
			}
			case "RED":
			{
				infoPanel.lifesRemaining++;
				infoPanel.lifesRemainingLbl.setText(Constants.remainingLifesLabelText + infoPanel.lifesRemaining);
				break;
			}
			case "YELLOW":
			{
				GamePanel.blackBoosterActive = false;
				GamePanel.yellowBoosterActive = true;
				break;
			}
			case "GREEN":
			{
				InfoPanel.amountOfPoints += 100;
				break;
			}
			case "CYAN":
			{
				if(pilka.normXVelocity>0) 
					pilka.normXVelocity += 0.005;
				else
					pilka.normXVelocity -= 0.005;
				
				if(pilka.normYVelocity>0) 
					pilka.normYVelocity += 0.005;
				else
					pilka.normYVelocity -= 0.005;
	
				break;
			}
			default:
				break;            				
		}
	}
	
}

