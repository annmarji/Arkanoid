package Gra;

import Wczytywanie_plikow.Constants;
import javax.swing.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.w3c.dom.*;

import java.io.*;
import java.util.*;

/**
 * Klasa opisuj�ca okno g��wnego menu
 */

public class MainMenuFrame extends JFrame implements ActionListener
{
    /**
     * Rozmiar ramki g��wnego menu
     */
    private Dimension mainMenuFrameSize;
   
    /**
     * Panel z przyciskami
     */
    private JPanel mainMenuPanel;
    
    /**
     * Nazwa gry
     */
    private JLabel nameOfGame;
    
    /**
     * Przycisk nowej gry
     */
    private JButton newGameBtn;
    
    /**
     * Przycisk do wy�wietlenia najlepszych wynik�w
     */
	private JButton highScoreBtn;
	
	  /**
     * Przycisk do wy�wietlenia informacji o grze
     */
	private JButton about;
	
	/**
	 * Przycisk wyj�cia
	 */
	private JButton quitBtn;
	
	/**
	 * Nick gracza 
	 */
	private static String nick;
	
	/**
	 * Panel Gry
	 */
	public GamePanel gamePanel;
		
	/**
	 * Okno z mo�liwo�ci� wyboru poziomu trudno�ci gry
	 */
	protected diffLevelWindow diffWindow;
	
	/**
	 *  Okno wy�wietlaj�ce najlepsze wyniki
	 */
	protected HighScoresWindow highWindow;
		
	/**
	 *  Okno wy�wietlaj�ce instrukcje do gry
	 */
	protected Instruction instruction;
		
	
    /**
	 * Konstruktor klasy MainFrame
	 * @param width szeroko�� ramki menu g��wnego
     * @param height wysoko�� ramki menu g��wnego
	 */
	 public MainMenuFrame(int width, int height) {

		 setTitle(Constants.frameTitle);
		 mainMenuFrameSize = new Dimension(width, height);
		 setPreferredSize(mainMenuFrameSize);
		 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);            
		 pack();						
		 
		 setLocationRelativeTo(null);
		 nick = null;
		 createUI();
	}
		    
	 
	/**
	 * Inicializator interfejsfu graficznego
	 */
		    private void createUI() {
		        mainMenuPanel = new JPanel();
		        Dimension d = new Dimension(500, 25);
		        nameOfGame = new JLabel(Constants.gameTitle, SwingConstants.CENTER);
		        newGameBtn = new JButton(Constants.mainMenuNewGameBtn);
		        
		        newGameBtn.setActionCommand("NowaGra");
		        newGameBtn.addActionListener(this);
		        newGameBtn.setFocusable(false);
		        newGameBtn.setSize(d);
		        highScoreBtn = new JButton(Constants.mainMenuHighScoreBtn);
		        highScoreBtn.setActionCommand("NajlepszeWyniki");
		        highScoreBtn.addActionListener(this);
		        highScoreBtn.setFocusable(false);
		        about = new JButton("O grze");
		        about.setActionCommand("O grze");
		        about.addActionListener(this);
		        about.setFocusable(false);
		        quitBtn = new JButton(Constants.mainMenuQuitBtn);
		        quitBtn.setActionCommand("Wyj�cie");
		        quitBtn.addActionListener(this);
		        quitBtn.setFocusable(false);
		        mainMenuPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 500, 50));
		        mainMenuPanel.add(nameOfGame);
		        mainMenuPanel.add(newGameBtn);
		        mainMenuPanel.add(highScoreBtn);
		        mainMenuPanel.add(about);
		        mainMenuPanel.add(quitBtn);
		        mainMenuPanel.setBackground(Color.blue);
		        getContentPane().add(mainMenuPanel);
		         
		    }
		    
		    /**
		     * Metoda tworz�ca okno wyboru poziomu trudno�ci gry
		     */		    
		    private void makeDiffLevelWindow()
		    {
		    	diffWindow = new diffLevelWindow();
		    	diffWindow.setVisible(true);
		    	
		    }
		    
		    /**
		     * Metoda tworz�ca okno najlepszych wynik�w
		     * @throws IOException
		     */		 
		    protected void makeHighScoresWindow() throws IOException
		    {
		    	highWindow = new HighScoresWindow();
		    	highWindow.setVisible(true);
		    }
		    
		    /**
		     * Metoda tworz�ca okno instrukcji
		     */		 
		    protected void  makeInstruction() throws IOException
		    {
		    	instruction = new Instruction();
		    	instruction.setVisible(true);
		    }
		   

		    /**
		     * Metoda obs�uguj�ca zdarzenia wci�ni�cia przycisku w g��wnym menu
		     * @param actionEvent obiekt zdarzenia wci�ni�cia przycisku
		     */
		    @Override
		    public void actionPerformed(ActionEvent actionEvent) {
		        String komenda = actionEvent.getActionCommand();
		        switch (komenda) {
	            case "NowaGra":
	                this.setVisible(false);
	                while(nick==null || nick.length()==0){
	                    nick= JOptionPane.showInputDialog(this,Constants.nickDialogText,Constants.frameTitleNick,JOptionPane.INFORMATION_MESSAGE);
	                    if(nick==null){
	                        break;
	                    }
	                }
	                if(nick==null) {
	                    this.setVisible(true);
	                    break;
	                }
	                makeDiffLevelWindow();
	               
	                
	                break;    
	                
	            case "NajlepszeWyniki":

	            	this.setVisible(false);
	            	 try {
						makeHighScoresWindow();
					} catch (IOException e) {
						JOptionPane.showMessageDialog(null, "B��d odczytu listy");
						e.printStackTrace();
					}	   
	            	
	            	break;
	            	
	            case "O grze":

	            	this.setVisible(false);
	            	 try {
						  makeInstruction();
	            	 	 } 
	            	 catch (IOException e) {
						e.printStackTrace();
					}	   
	            	
	            	break;

		        case "Wyj�cie":
		                Object[] options = {Constants.quitDialogOptionYes,
		                        Constants.quitDialogOptionNo};
		                int reply = JOptionPane.showOptionDialog(this, Constants.quitDialogText, Constants.frameTitleQuit,
		                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
		                if (reply == JOptionPane.YES_OPTION) {
		                    System.exit(0);      
		                }
		                break;

		            default:
		                break;
		        }
		    }	
		    
		    /**
		     * Metoda zwracaj�ca nick gracza
		     * @return nick gracza
		     */
		    public static String getNick()
		    {
		    	return nick;
		    }
		    

}
