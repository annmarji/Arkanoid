package Gra;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import javax.swing.border.EtchedBorder;


import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;

import Wczytywanie_plikow.Constants;


	/**
	 * Klasa opisuj�ca g��wne okno, w kt�rym znajdzie si� panel z gr� oraz panel z informacjami o tocz�cej si� rozgrywce
	 */
	public class MainGameWindow extends JFrame implements ActionListener
	{
	    /**
	     * Ramka menu g��wnego
	     */
	    protected MainMenuFrame mainMenuFrame;
	    /**
	     * Szeroko�� okna
	     */
	    private int frameWidth=Constants.mainMenuWidth;
	    
	    /**
	     * Wysoko�� okna
	     */
	    private int frameHeight=Constants.mainMenuHeight;
	    
	    /**
	     * Panel z informacjami o tocz�cej si� rozgrywce
	     */
	    protected InfoPanel infoPanel;
	    
	    /**
	     * Panel z plansz� do gry
	     */
	    protected GamePanel gamePanel;
	    
	    /**
	     * Rozmiar okna
	     */
	    private Dimension mainWindowSize ;
	    
	    /**
	     * Liczy czas rozgrywki
	     */
	    public static Timer timer;
	    
	    /**
	     * Okresla, czy gracz ma jeszcze zycia
	     */
	    protected boolean anyLifes;
	    
	    /**
	     * Okresla, czy gracz straci� �ycie
	     */
	    protected boolean lifesLess;
	    
	    /**
	     * Typ layoutu
	     */
	    protected GridBagLayout gBL;
	    
	    /**
	     * Zarzadca rozkladu elementow
	     */
	    protected GridBagConstraints c;

	    
	    
	    /**
	     * Konstrukor klasy MainGameWindow
	     * @param mainMenuList Listener menu g��wnego
	     */
	    
	    public MainGameWindow(ActionListener mainMenuList)
	    {
	    	setTitle(Constants.frameTitle);
	    	setDefualtFrameParameters();
	    	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	    	pack();
	    	setLocationRelativeTo(null);
	    	
	    	gBL = new GridBagLayout(); 
	    	this.setLayout(gBL);
	        createUI();
	        
	        anyLifes = true;

	        Thread animThread = new Thread();
	        animThread.start();
	        initializeTimer();
	        startTimer();
	        gamePanel.start();
	        
	        
	    }
	    
	    /**
	     * Metoda ustawiaj�ca domy�lne ustawienia g��wnego okna
	     */
	    private void setDefualtFrameParameters(){
	        
	        mainWindowSize= new Dimension(frameWidth, frameHeight);
	        this.setPreferredSize(mainWindowSize);
	    }
	    
	    /**
	     * Inicializator interfejsu graficznego
	     */
	    private void createUI(){
	    	
	    	c = new GridBagConstraints();

	    	infoPanel =new InfoPanel(frameWidth,frameHeight,Color.blue, this);
			infoPanel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED), 
			    	BorderFactory.createEtchedBorder(EtchedBorder.LOWERED)));   
		    infoPanel.setBackground(Color.green);
			   			    
	    	gamePanel =new GamePanel(frameWidth,frameHeight, infoPanel, this);
	    	gamePanel.setBackground(Color.white);
	    	
	    	c.fill = GridBagConstraints.BOTH;
	    	c.weightx = Constants.widthOfGamePanel+0.2;
	    	c.weighty = 1.1;
	    	c.gridx = 0;
	    	c.gridy = 0;
	    	this.add(gamePanel, c);	     
	       
	       c.fill = GridBagConstraints.BOTH;
	       c.weightx = Constants.widthOfInfoPanel;
	       c.weighty = 1.1;
	       c.gridx = 1;
	       c.gridy = 0;
	       this.add(infoPanel, c);
	        

	        this.setVisible(true);
	        Collision.points = 0;
	        InfoPanel.amountOfPoints = 0;
	        InfoPanel.timeInit = 0;
	       		        
	        
	    }
	    
	    /**
	     * Inicializator timera
	     */
	    private void initializeTimer(){
	        timer= new Timer(1000,infoPanel);
	        timer.setActionCommand("TimerTic");

	    }

	    /**
	     * Metoda rozpoczynaj�ca pomiar czasu
	     */
	    public static void startTimer(){
	        //initializeTimer();
	        timer.start();
	        
	    }

	    /**
	     * Metoda ko�cz�ca odliczanie czasu
	     */
	    protected static void stopTimer(){
	        timer.stop();
	    }
	    
	    /**
	     * Metoda obs�uguj�ca zdarzenia wci�ni�cia przycisku w oknie gry
	     * @param actionEvent obiekt zdarzenia wci�ni�cia przycisku
	     */
	    @Override
	    public void actionPerformed(ActionEvent actionEvent) {
	        String actCommand = actionEvent.getActionCommand();
	        if(actCommand=="TimerTic") {
	        	
	           Dimension size2 = new Dimension();
	     	   size2 = this.getSize();

	     	   System.out.println("wysokosc: "+size2.height +" Szerokosc: "+size2.width);

	        }

	    }
	   
	    /**
	     * Metoda wy�wietlaj�ca aktualn� liczb� punkt�w zebranych przez gracza
	     */
		public void getPoints()
		{
		    InfoPanel.amountOfPoints = Collision.points;			
	        infoPanel.pointsLbl1.setText(Constants.pointLabelText + InfoPanel.amountOfPoints);
	     	gamePanel.revalidate();
	  	    gamePanel.repaint();
	        infoPanel.revalidate();
	  	    infoPanel.repaint();
		}

		/**
		 * Metoda zmniejszaj�ca liczb� �yc gracza 
		 */
		public void takeLife()  
		{
			lifesLess = false;
			if (infoPanel.lifesRemaining >0)
			{
				infoPanel.lifesRemaining--;			
			}
			
			infoPanel.lifesRemainingLbl.setText(Constants.remainingLifesLabelText + infoPanel.lifesRemaining);
			if (infoPanel.lifesRemaining == 0)
			{
				anyLifes = false;
				stopTimer();
				GamePanel.isPaused= true;
				try{
					infoPanel.compareScores();
				}
				catch (IOException e)
				{
					JOptionPane.showMessageDialog(null, "Problem z odczytem pliku z najlepszymi wynikami", "Error", JOptionPane.ERROR_MESSAGE);
				}
				
			    playSound("Sounds\\game_over.wav");
				JOptionPane.showMessageDialog(null, "Nie masz wi�cej �y�. Koniec gry! \nTw�j wynik: " + InfoPanel.amountOfPoints +
						" punkt�w.\nCzas gry: "+ infoPanel.timeInit + " sekund." );

				this.setVisible(false);
				InfoPanel.amountOfPoints = Constants.initialAmountOfPoints;
				Collision.points = Constants.initialAmountOfPoints;				
				HighScoresWindow highWindow = new HighScoresWindow();
		    	highWindow.setVisible(true);
		    	
			}
			else
			{	
				stopTimer();
				 playSound("Sounds\\game_over.wav");
				JOptionPane.showMessageDialog(null, "Tracisz �ycie.");
				lifesLess = true;
			}
		
		}

		
		
		/**
		 * Metoda s�u��ca do odtwarzania dzwi�ku podczas gry
		 * @param soundFile plik dzwiekowy
		 */
		public void playSound(String soundFile) 
		{
		    File f = new File(soundFile);
		    AudioInputStream audioIn;
		    try {
				audioIn = AudioSystem.getAudioInputStream(f.toURI().toURL());
				Clip clip = AudioSystem.getClip();			
				clip.open(audioIn);
				clip.start();
			} 
			catch (LineUnavailableException e) {
				JOptionPane.showMessageDialog(null, "B��d odtwarzania pliku.", "B��d", JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();
			}
			catch (MalformedURLException e) {
				JOptionPane.showMessageDialog(null, "B��d odtwarzania pliku.", "B��d", JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();
			} catch (UnsupportedAudioFileException e) {
				JOptionPane.showMessageDialog(null, "B��d odtwarzania pliku.", "B��d", JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, "B��d odtwarzania pliku.", "B��d", JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();
			}  
		   
		  
		}
		
		/**
		 * Wykonuje czynnosci po zakonczeniu jednego poziomu gry
		 */
		public void endOfLevel()  {
			
			if(gamePanel.nrLevel <= Constants.lastLevel)
			{

				MainGameWindow.stopTimer();
				playSound("Sounds\\Powerup.wav");
				JOptionPane.showMessageDialog(null, "Uko�czy�e� poziom!\nPrzejdz do kolejnego.");
				System.out.println("Nr levela przed: "+ gamePanel.nrLevel);
				gamePanel.loadNextLevel();
				System.out.println("Nr levela po: "+ gamePanel.nrLevel);
				gamePanel.pilka.setInitOnScreen();
				gamePanel.paletka.setStartPosition();
				repaint();
			}
			else
			{

				MainGameWindow.stopTimer();
				if(infoPanel.timeInit < 180)
					InfoPanel.amountOfPoints += ((180 - infoPanel.timeInit)*2);
				if(infoPanel.lifesRemaining > 0)
					InfoPanel.amountOfPoints += infoPanel.lifesRemaining* 30;
				playSound("Sounds\\Powerup.wav");										
				JOptionPane.showMessageDialog(null, "Uko�czy�e� gr�!\nTw�j wynik: " + InfoPanel.amountOfPoints +		
					" punkt�w.\nCzas gry: "+ InfoPanel.timeInit + " sekund." );
				
				
				try {
					infoPanel.compareScores();
				} 
				catch (IOException e) {					
					
					JOptionPane.showMessageDialog(null, "B��d zapisu do listy najlepszych wynik�w.\n Przejdz do menu g��wnego.");
					e.printStackTrace();
					mainMenuFrame = new MainMenuFrame(Constants.mainMenuWidth,Constants.mainMenuHeight);
					mainMenuFrame.setVisible(true);					
				}
				InfoPanel.amountOfPoints = Constants.initialAmountOfPoints;
				Collision.points = Constants.initialAmountOfPoints;	
				this.setVisible(false);
				
				HighScoresWindow highWindow = new HighScoresWindow();
				highWindow.setVisible(true);
					    	
				
			}			
			
		}

	 
		
	}
