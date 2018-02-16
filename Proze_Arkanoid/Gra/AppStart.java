package Gra;

import javax.swing.JOptionPane;

import Wczytywanie_plikow.Constants;
/**
 * Klasa s�u��ca do uruchomienia programu
 */

public class AppStart{
    
	/**
	 * Statyczny obiekt przechowuj�cy ramk� menu g��wnego
	 */
	private static MainMenuFrame menuFrame;

    /**
     * Statyczna metoda tworz�ca menu g��wne gry
     */
    public static void makeMenu(){

        menuFrame=new MainMenuFrame(Constants.mainMenuWidth,Constants.mainMenuHeight);
        menuFrame.setVisible(true);
        
    }
    /**
     * Statyczna metoda uruchamiaj�ca gr�
     */
    public static void runGame () {

            Constants.parseConfigurationMenuFile();
            makeMenu();

            }
            
    
 }
       
