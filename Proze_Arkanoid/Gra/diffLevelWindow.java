package Gra;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import Wczytywanie_plikow.Constants;

/**
 * Klasa opisuj�ca okno, w kt�rym mo�na wybra� poziom trudno�ci gry
 */

public class diffLevelWindow extends JFrame implements ActionListener
{	
	/**
	 * Panel z przyciskami
	 */
	protected JPanel poziomTrudnosci;
	
	/**
	 * Przycisk odpowiadaj�cy za wyb�r �atwego poziomu trudno�ci
	 */
	protected JButton easy;
	
	/**
	 * Przycisk odpowiadaj�cy za wyb�r �redniego poziomu trudno�ci
	 */
	protected JButton medium;
	
	/**
	 * Przycisk odpowiadaj�cy za wyb�r trudnego poziomu trudno�ci
	 */
	protected JButton hard;
	
	/**
	 * Przycisk odpowiadaj�cy za powr�t do menu g��wnego
	 */
	protected JButton backToMenu;	
	
	/**
	 * przechowuje informacje o wybranym poziomie trudno�ci
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
		setTitle("Wyb�r poziomu trudno�ci");
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
     * Metoda obs�uguj�ca zdarzenia wci�ni�cia przycisku w oknie wyboru leveli
     * @param actEvent obiekt zdarzenia wci�ni�cia przycisku
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
