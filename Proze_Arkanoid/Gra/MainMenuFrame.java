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
 * Klasa opisuj¹ca okno g³ównego menu
 */

public class MainMenuFrame extends JFrame implements ActionListener
{
    /**
     * Rozmiar ramki g³ównego menu
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
     * Przycisk do wyœwietlenia najlepszych wyników
     */
	private JButton highScoreBtn;
	
	  /**
     * Przycisk do wyœwietlenia informacji o grze
     */
	private JButton about;
	
	/**
	 * Przycisk wyjœcia
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
	 * Okno z mo¿liwoœci¹ wyboru poziomu trudnoœci gry
	 */
	protected diffLevelWindow diffWindow;
	
	/**
	 *  Okno wyœwietlaj¹ce najlepsze wyniki
	 */
	protected HighScoresWindow highWindow;
		
	/**
	 *  Okno wyœwietlaj¹ce instrukcje do gry
	 */
	protected Instruction instruction;
		
	
    /**
	 * Konstruktor klasy MainFrame
	 * @param width szerokoœæ ramki menu g³ównego
     * @param height wysokoœæ ramki menu g³ównego
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
		        quitBtn.setActionCommand("Wyjœcie");
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
		     * Metoda tworz¹ca okno wyboru poziomu trudnoœci gry
		     */		    
		    private void makeDiffLevelWindow()
		    {
		    	diffWindow = new diffLevelWindow();
		    	diffWindow.setVisible(true);
		    	
		    }
		    
		    /**
		     * Metoda tworz¹ca okno najlepszych wyników
		     * @throws IOException
		     */		 
		    protected void makeHighScoresWindow() throws IOException
		    {
		    	highWindow = new HighScoresWindow();
		    	highWindow.setVisible(true);
		    }
		    
		    /**
		     * Metoda tworz¹ca okno instrukcji
		     */		 
		    protected void  makeInstruction() throws IOException
		    {
		    	instruction = new Instruction();
		    	instruction.setVisible(true);
		    }
		   

		    /**
		     * Metoda obs³uguj¹ca zdarzenia wciœniêcia przycisku w g³ównym menu
		     * @param actionEvent obiekt zdarzenia wciœniêcia przycisku
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
						JOptionPane.showMessageDialog(null, "B³¹d odczytu listy");
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

		        case "Wyjœcie":
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
		     * Metoda zwracaj¹ca nick gracza
		     * @return nick gracza
		     */
		    public static String getNick()
		    {
		    	return nick;
		    }
		    

}
