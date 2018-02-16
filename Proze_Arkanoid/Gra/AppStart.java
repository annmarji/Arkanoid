package Gra;

import javax.swing.JOptionPane;

import Wczytywanie_plikow.Constants;
/**
 * Klasa s³u¿¹ca do uruchomienia programu
 */

public class AppStart{
    
	/**
	 * Statyczny obiekt przechowuj¹cy ramkê menu g³ównego
	 */
	private static MainMenuFrame menuFrame;

    /**
     * Statyczna metoda tworz¹ca menu g³ówne gry
     */
    public static void makeMenu(){

        menuFrame=new MainMenuFrame(Constants.mainMenuWidth,Constants.mainMenuHeight);
        menuFrame.setVisible(true);
        
    }
    /**
     * Statyczna metoda uruchamiaj¹ca grê
     */
    public static void runGame () {

            Constants.parseConfigurationMenuFile();
            makeMenu();

            }
            
    
 }
       
