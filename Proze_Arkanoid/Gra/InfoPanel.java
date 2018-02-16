package Gra;

import Wczytywanie_plikow.Constants;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;		
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;			

import Gra.MainMenuFrame;
/**
 * Klasa opisuj�ca panel informacyjny o bie��cej rozgrywce
 */

public class InfoPanel extends JPanel implements ActionListener
{
    /**
     * Rozmiar panelu
     */
    private Dimension panelSize;
    
    /**
     * zarz�dca rozk�adu element�w
     */
    private GridBagConstraints gbc;
    
    /**
     * wysoko�� panelu
     */
    private int panelHeight;
    
    /**
     * szeroko�� panelu
     */
    protected int panelWidth;
    
    /**
     * layout rozk�adu element�w
     */
    private GridBagLayout GBL = new GridBagLayout();
    
    /**
     * odleg�o�ci pomi�dzy elementami
     */
    private static final Insets insets = new Insets(5, 5, 5, 5);
    
    /**
     * czas pozosta�y do ko�ca gry
     */ 
    protected static int timeInit;
    
    /**
     * napis na panelu okre�laj�cy czas trwania rozgrywki
     */
    protected JLabel timeLbl1;
    
    /**
     * liczba pozosta�ych �y�
     */
    protected int lifesRemaining;
    
    /**
     * Napis na panelu okre�laj�cy liczbe pozosta�ych �y�
     */
    protected JLabel lifesRemainingLbl;
    
    /**
     * Napis na panelu okre�laj�cy liczb� punkt�w
     */
    protected JLabel pointsLbl1;
    
    /**
     * Nick gracza
     */
    protected JLabel nick;
    
    /**
     * Napis na panelu okre�laj�cy nick gracza
     */
    protected JLabel nickLbl;
    
    /**
     * Napis na panelu okre�laj�cy liczb� punkt�w
     */
    protected static int amountOfPoints;
    

    /**
     * Konstruktor klasy InfoPanel
     * @param screenHeight wysoko�� okna gry
     * @param screenWidth szeroko�� okna gry
     * @param color kolor panelu
     * @param container kontener w kt�rym znajduje si� panel
     */

    public InfoPanel(int screenWidth, int screenHeight, Color color, JFrame container){
 
    	panelHeight=(int)(Constants.heightOfInfoPanel*screenHeight);
        panelWidth=(int)(Constants.widthOfInfoPanel*screenWidth);
        panelSize= new Dimension(panelWidth,panelHeight);
        setPreferredSize(panelSize);
        setLayout(GBL);
        gbc=new GridBagConstraints();
        lifesRemaining=Constants.initialLifes;
        timeInit= Constants.initialTime;
        amountOfPoints = Constants.initialAmountOfPoints;
        initializeButtonAndLabels();

    }

    /**
     * Metoda obsługująca zdarzenia generowane przez timer
     * @param actionEvent zdarzenie Timera
     */

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        String actCommand = actionEvent.getActionCommand();
        if(actCommand=="TimerTic") {
            timeInit++;
            timeLbl1.setText(Constants.timeLabelText + timeInit);

            revalidate();
            repaint();
        }
        if(actCommand == "Pauza")
            {
            	if(!GamePanel.isPaused)
            	GamePanel.isPaused = true;            	
            }

      }
    
    
    
    /**
     * metoda inicializujaca przyciski i etykiety
     */

    private void initializeButtonAndLabels(){
   
        pointsLbl1= new JLabel(Constants.pointLabelText + amountOfPoints);
        timeLbl1 = new JLabel(Constants.timeLabelText+ timeInit);
        lifesRemainingLbl = new JLabel(Constants.remainingLifesLabelText+lifesRemaining);
        nickLbl = new JLabel(Constants.nickLabelText+MainMenuFrame.getNick());
        JButton pauseBtn1 = new JButton(Constants.pauzaBtn);

        gbc.insets=insets;
        gbc.fill=GridBagConstraints.BOTH;
        gbc.weightx=0.375;
        gbc.weighty=0.5;
        gbc.gridx=0;
        gbc.gridy=0;
        pointsLbl1.setOpaque(true);
        pointsLbl1.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(pointsLbl1,gbc);

        gbc.weightx=0.375;
        gbc.weighty=0.5;
        gbc.gridx=0;
        gbc.gridy=1;
        timeLbl1.setOpaque(true);
        timeLbl1.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(timeLbl1,gbc);

        gbc.weightx=0.25;
        gbc.weighty=0.5;
        gbc.gridx=0;
        gbc.gridy=2;
        lifesRemainingLbl.setOpaque(true);
        lifesRemainingLbl.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(lifesRemainingLbl,gbc);

        gbc.weightx=0.25;
        gbc.weighty=0.5;
        gbc.gridx=0;
        gbc.gridy=3;
        nickLbl.setOpaque(true);
        nickLbl.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(nickLbl,gbc);
        
        gbc.gridwidth = 1;
        gbc.weightx=0.5;
        gbc.weighty=0.2;
        gbc.gridx=0;
        gbc.gridy=4;

        pauseBtn1.setFocusable(false);
        pauseBtn1.setPreferredSize(new Dimension(100, 40));
        pauseBtn1.setBackground(Color.LIGHT_GRAY);
        pauseBtn1.addActionListener(this);
        pauseBtn1.setFocusable(false);	
        pauseBtn1.setActionCommand("Pauza");
        this.add(pauseBtn1,gbc);
        
        gbc.weightx=0.25;
        gbc.weighty=0.2;
        gbc.gridx=0;
        gbc.gridy=5;
        gbc.gridheight=1;
   
    }
    	
    /**
     * Metoda zapisujaca wyniki do pliku
     * @param names tablica nick�w graczy
     * @param scores tablica wynik�w graczy
     * @throws IOException
     */
    public void saveHighScore(String[] names, int[] scores) throws IOException
    {
	    PrintWriter saving = new PrintWriter("Pliki_konfiguracyjne\\HighScores.txt");
	    int i=0;
	    while(i < names.length)
	    {

	    	saving.println(names[i]);
		   	saving.println(scores[i]);
		   	i++;
	    }
	    saving.close();
    }
    
    /**
     * Metoda por�wnuj�ca wynik z wynikami ju� zapisanymi
     * @throws IOException
     */
    public void compareScores() throws IOException
    {
    
    	String[] nickNames = new String[3];
    	int[] highScores = new int[3];
    	FileReader fileReader = new FileReader("Pliki_konfiguracyjne\\HighScores.txt");
    	BufferedReader bufferedReader = new BufferedReader(fileReader);
  
    	int t=0;
    	try
    	{
	    	while(t < 20)
	    	{
	        	nickNames[t] = bufferedReader.readLine();
	        	highScores[t] = Integer.parseInt(bufferedReader.readLine());
	        	t++;
	    	}
    	}
    	catch(NumberFormatException e)
    	{
	    	int p=1;
	    	int b=0;
	    	int c = highScores[0];
	    	while(p<nickNames.length)
	    	{
	    		if(highScores[p] < c)
	    		{
	    			c = highScores[p];
	    			b++;
	    		}

	    		p++;
	    	}
	    	if(highScores[b]<=amountOfPoints)
	    	{
	    		highScores[b] = amountOfPoints;
	    		nickNames[b] = MainMenuFrame.getNick();
	    		
	    	}
	    	int temp1;
	    	String temp2;
	    	int z = 1;
	    	while(z > 0)
	    	{
		    	z = 0;
		    	for(int i=0; i<highScores.length-1; i++)
		    	{
			    	if(highScores[i]<highScores[i+1])
			    	{
			    	temp1 = highScores[i];
			    	temp2 = nickNames[i];
			    	highScores[i] = highScores[i+1];
			    	nickNames[i] = nickNames[i+1];
			    	highScores[i+1] = temp1;
			    	nickNames[i+1] = temp2;
			    	z++;
			    	}
		    	}
	    	}
	    	
	    	int k=0;
	       	while(k<highScores.length)
	    	{
	    		k++;
	    	}
	    	bufferedReader.close();
	    	saveHighScore(nickNames, highScores);
    	}
    	catch(ArrayIndexOutOfBoundsException e)
    	{
	    	int p=1;
	    	int b=0;
	    	int c = highScores[0];
	    	while(p<nickNames.length)
	    	{
	    		if(highScores[p] < c)
	    		{
	    			c = highScores[p];
	    			b++;
	    		}

	    		p++;
	    	}
	    	if(highScores[b]<=amountOfPoints)			
	    	{
	    		highScores[b] = amountOfPoints;
	    		nickNames[b] = MainMenuFrame.getNick();
	    		
	    	}
	    	int temp1;
	    	String temp2;
	    	int z = 1;
	    	while(z > 0)
	    	{
		    	z = 0;
		    	for(int i=0; i<highScores.length-1; i++)
		    	{
			    	if(highScores[i]<highScores[i+1])
			    	{
			    		temp1 = highScores[i];
			    		temp2 = nickNames[i];
			    		highScores[i] = highScores[i+1];
			    		nickNames[i] = nickNames[i+1];
			    		highScores[i+1] = temp1;
			    		nickNames[i+1] = temp2;
			    		z++;
			    	}
		    	}
	    	}
	    	
	    	int k=0;
	       	while(k<highScores.length)
	    	{
	    		k++;
	    	}
	    	bufferedReader.close();
	    	saveHighScore(nickNames, highScores);
    	}
    	
    }
    		
    /**
     * Pobiera ilo�� punkt�w gracza z klasy Collision
     */
    public static void getPoints()
    {
    	amountOfPoints = Collision.points;
    	
    }
       

}