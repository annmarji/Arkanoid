package Gra;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import Wczytywanie_plikow.Constants;

/**
 * Klasa opisuj¹ca okno, w którym mo¿na wybraæ poziom trudnoœci gry
 */

public class diffLevelWindow extends JFrame implements ActionListener
{	
	/**
	 * Panel z przyciskami
	 */
	protected JPanel poziomTrudnosci;
	
	/**
	 * Przycisk odpowiadaj¹cy za wybór ³atwego poziomu trudnoœci
	 */
	protected JButton easy;
	
	/**
	 * Przycisk odpowiadaj¹cy za wybór œredniego poziomu trudnoœci
	 */
	protected JButton medium;
	
	/**
	 * Przycisk odpowiadaj¹cy za wybór trudnego poziomu trudnoœci
	 */
	protected JButton hard;
	
	/**
	 * Przycisk odpowiadaj¹cy za powrót do menu g³ównego
	 */
	protected JButton backToMenu;	
	
	/**
	 * przechowuje informacje o wybranym poziomie trudnoœci
	 */
	protected String komenda = " ";
	
	/**
	 * Glowne okno gry
	 */
	protected MainGameWindow mainWindow;
	
	/**
	 * Okno glownego menu gry
	 */
	protected MainMenuFrame mainMenu;
	
	/**
	 * Konstruktor klasy diffLevelWindow
	 */
	
	public diffLevelWindow()
	{
		setTitle("Wybór poziomu trudnoœci");
        Dimension D = new Dimension(400,400);
        this.setPreferredSize(D);
        
    	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
    	setLocationRelativeTo(null);

        this.setLayout(new BorderLayout());
                
        
        poziomTrudnosci = new JPanel();
        easy = new JButton("Latwy");
        medium = new JButton("Sredni");
        hard = new JButton("Trudny");
        backToMenu = new JButton("Powrot do menu");
        poziomTrudnosci.setLayout(new FlowLayout(FlowLayout.CENTER, 500, 50));
        easy.setActionCommand("latwy");
        easy.addActionListener(this);
        easy.setFocusable(false);
        medium.setActionCommand("sredni");
        medium.addActionListener(this); 
        medium.setFocusable(false);
        hard.setActionCommand("trudny");
        hard.addActionListener(this); 
        hard.setFocusable(false);
        backToMenu.setActionCommand("powrot");
        backToMenu.addActionListener(this);
        backToMenu.setFocusable(false);
        
        poziomTrudnosci.add(easy);
        poziomTrudnosci.add(medium);
        poziomTrudnosci.add(hard);
        poziomTrudnosci.add(backToMenu);
        this.add(poziomTrudnosci, BorderLayout.CENTER);
        this.setVisible(true);
        

	}

	   /**
     * Metoda obs³uguj¹ca zdarzenia wciœniêcia przycisku w oknie wyboru leveli
     * @param actEvent obiekt zdarzenia wciœniêcia przycisku
     */
	@Override
	public void actionPerformed(ActionEvent actEvent) {
		komenda = actEvent.getActionCommand();
		switch(komenda)
		{
		case "latwy":
			this.setVisible(false);
			Ball.poziom = "latwy";
			 mainWindow = new MainGameWindow(this);
			 mainWindow.setVisible(true);
			break;
		case "sredni":
			this.setVisible(false);
			Ball.poziom = "sredni";
			mainWindow = new MainGameWindow(this);
			mainWindow.setVisible(true);
			break;
		case "trudny":
			this.setVisible(false);
			Ball.poziom = "trudny";
			mainWindow = new MainGameWindow(this);
			mainWindow.setVisible(true);
			break;
		case "powrot":
			this.setVisible(false);
			mainMenu = new MainMenuFrame(Constants.mainMenuWidth, Constants.mainMenuHeight);
			mainMenu.setVisible(true);
			break;
		default:
			break;
		}	
		
	}
}
