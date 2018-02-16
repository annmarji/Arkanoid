package Gra;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Wczytywanie_plikow.Constants;

/**
 * Klasa opisuj�ca okno wy�wietlaj�ce informacje o grze
 */

public class Instruction  extends JFrame implements ActionListener{

	/**
	 * Przycisk s�u��cy do powrotu do g��wnego menu
	 */
	private JButton back;
    
	/**
	 * Okno g��wnego menu gry
	 */
	private MainMenuFrame mainMenuFrame;

	
	/**
	 * Konstruktor klasy Instruction
	 */	
	public Instruction() 
	{
		
		setTitle("Instrukcja gry");
		Dimension D = new Dimension(1000,700);
		this.setPreferredSize(D);

		this.setDefaultCloseOperation(EXIT_ON_CLOSE);  
		   
		pack();
		setLocationRelativeTo(null);
		this.setLayout(new BorderLayout());

		String[] instrLines = new String[31];
   
		FileReader fr = null;
		String linia = "";
		int i = 0;
   
		try 
		{
			fr = new FileReader("Instrukcja.txt");
		} 
		catch (FileNotFoundException e) 
		{
			JOptionPane.showMessageDialog(null, "B��D PRZY OTWIERANIU PLIKU!", "Error", JOptionPane.ERROR_MESSAGE);
		}

		BufferedReader bfr = new BufferedReader(fr);
 
		try 
		{
			while((linia = bfr.readLine()) != null)
			{
				instrLines[i] = linia;
				i++;
			}
		} 
   
		catch (IOException e)
		{
			JOptionPane.showMessageDialog(null, "B��D ODCZYTU Z PLIKU!", "Error", JOptionPane.ERROR_MESSAGE);
		}


		try 
		{
			fr.close();
		} 
		catch (IOException e) 
		{
			JOptionPane.showMessageDialog(null, "B��D PRZY ZAMYKANIU PLIKU!", "Error", JOptionPane.ERROR_MESSAGE);
        }
   
		JPanel childPanel = new JPanel();
		childPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 80));
	
		JPanel inputPanel = new JPanel();
		inputPanel.setLayout(new GridLayout(30, 3));
		for (int x=0; x<30; x++)
		{
			inputPanel.add(new JLabel(instrLines[x]));		
		}
	
		childPanel.add(inputPanel);
		this.add(childPanel, BorderLayout.CENTER);
	
		back = new JButton("Cofnij");
		back.addActionListener(this);
		back.setFocusable(false);
       
		this.add(back, BorderLayout.PAGE_END);
     
    }
	
	   /**
     * Metoda obs�uguj�ca zdarzenia wci�ni�cia przycisku w oknie instrukcji
     * @param e obiekt zdarzenia wci�ni�cia przycisku
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
