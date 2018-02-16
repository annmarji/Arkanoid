package Gra;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.*;

import Wczytywanie_plikow.Constants;
import javafx.scene.paint.Color;

/**
 * Klasa opisuj¹ca okno, które wyœwietla listê najlepszych wyników
 */

public class HighScoresWindow extends JFrame implements ActionListener{
	
	/**
	 * Przycisk s³u¿¹cy do powrotu do g³ównego menu
	 */
	private JButton back;
    
	/**
	 * Okno g³ównego menu gry
	 */
	private MainMenuFrame mainMenuFrame;
	
	
	/**
	 * Konstruktor klasy HighScoresWindow
	 */
	public HighScoresWindow()
	{
		setTitle("Najlepsze wyniki");
		Dimension D = new Dimension(400,400);
        this.setPreferredSize(D);
    	this.setDefaultCloseOperation(EXIT_ON_CLOSE);  
    	pack();
    	setLocationRelativeTo(null);
    	this.setLayout(new BorderLayout());
    	String filePath = new String("Pliki_konfiguracyjne\\HighScores.txt");

	    String[] nickNames = new String[4];
		int[] highScores = new int[4];
		
		try{
			FileReader fileReader = new FileReader(filePath);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String textLine = new String();
			boolean line=true;
			int i=0;
			int p=0;
			do 
			{
				if(line)
				{
					textLine = bufferedReader.readLine();
					nickNames[i] = textLine;
					System.out.println("Nickname:" + nickNames[i]);
					i++;
					line=false;
				}
				else
				{				
					textLine = bufferedReader.readLine();
					highScores[p] = Integer.parseInt(textLine);
					System.out.println("HighScores:" + highScores[p]);
					p++;
					line=true;
				}
			}	while(textLine != null);	
			
			bufferedReader.close();
		}
		
		catch (IOException e)
		{
			JOptionPane.showMessageDialog(null, "Problem z odczytem pliku z najlepszymi wynikami", "Error", JOptionPane.ERROR_MESSAGE);
			this.setVisible(false);
			mainMenuFrame = new MainMenuFrame(Constants.mainMenuWidth,Constants.mainMenuHeight);
			mainMenuFrame.setVisible(true);
		}
		
		
		JPanel childPanel = new JPanel();
		childPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 80));
		
		JPanel inputPanel = new JPanel();
		inputPanel.setLayout(new GridLayout(12, 2));
		inputPanel.add(new JLabel("        Najlepsze wyniki : "));
		inputPanel.add( new JLabel(" ") );
		inputPanel.add(new JLabel("1.  " + nickNames[0] + ":  " + highScores[0]));
		inputPanel.add( new JLabel(" ") );
		inputPanel.add(new JLabel("2.  " + nickNames[1] + ":  " + highScores[1]));
		inputPanel.add( new JLabel(" ") );
		inputPanel.add(new JLabel("3.  " + nickNames[2] + ":  " + highScores[2]));
		
		childPanel.add(inputPanel);
		this.add(childPanel, BorderLayout.CENTER);
		
        back = new JButton("Cofnij");
        back.addActionListener(this);
        back.setFocusable(false);

       
        this.add(back, BorderLayout.PAGE_END);
        
        pack();
        
	}
	
	   /**
     * Metoda czytaj¹ca z pliku najwy¿sze wyniki
     * @param filePath œcie¿ka do pliku
     */
	public void readHighScores(String filePath)
	{
	    String[] nickNames = new String[3];
		int[] highScores = new int[3];
		
		try
		{
			FileReader fileReader = new FileReader(filePath);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String textLine = new String();
			boolean line=true;
			int i=0;
			int p=0;
			do 
			{
				if(line)
				{
					textLine = bufferedReader.readLine();
					nickNames[i] = textLine;
					System.out.println("Nickname:" + nickNames[i]);
					i++;
					line=false;
				}
				else
				{				
					textLine = bufferedReader.readLine();
					highScores[p] = Integer.parseInt(textLine);
					System.out.println("HighScores:" + highScores[p]);
					p++;
					line=true;
				}
			}while(textLine != null);	
			
			bufferedReader.close();	
		}	
		catch (IOException e)
		{
			JOptionPane.showMessageDialog(null, "Problem z odczytem pliku z najlepszymi wynikami", "Error", JOptionPane.ERROR_MESSAGE);
			this.setVisible(false);
			mainMenuFrame = new MainMenuFrame(Constants.mainMenuWidth,Constants.mainMenuHeight);
			mainMenuFrame.setVisible(true);
		}
	}
	
	   /**
     * Metoda obs³uguj¹ca zdarzenia wciœniêcia przycisku w oknie najlepszych wyników
     * @param e obiekt zdarzenia wciœniêcia przycisku
     */
	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		
		if (source == back)
		{
			this.setVisible(false);
			mainMenuFrame = new MainMenuFrame(Constants.mainMenuWidth, Constants.mainMenuHeight);
			mainMenuFrame.setVisible(true);
		}
		
	}
	
}
