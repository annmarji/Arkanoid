/**
 * By Anna and Karol 2017/2018
 */
package Wczytywanie_plikow;

import org.w3c.dom.Document; 

import java.io.File;
import java.io.FileNotFoundException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.FileNotFoundException;

/**
 *  Sta�e parametry pobierane z plik�w konfiguracyjnych
 */

public final class Constants {
    public static final String configFile="Pliki_konfiguracyjne\\config.xml";
    /**
     * Okre�la szeroko�� okna menu g��wnego
     */
    public static int mainMenuWidth;
    /**
     * Okre�la wysoko�� okna menu g��wnego
     */
    public static int mainMenuHeight;
    /**
     * Okre�la tytu� okna
     */
    public static String frameTitle;
    /**
     *  Okre�la nazw� gry
     */
    public static String gameTitle;
    /**
     * Tekst na przycisku nowej gry w g��wnym menu
     */
    public static String mainMenuNewGameBtn;
    /**
     * Tekst na przycisku najlepszych wynik�w w g��wnym menu
     */
    public static String mainMenuHighScoreBtn;
    /**
     * Tekst na przycisku zako�czenia programu w g��wnym menu
     */
    public static String mainMenuQuitBtn;
    /**
     * Tytu� okna wy�wietlanego po naci�ni�ciu przycisku ko�cz�cego program w menu g��wnym
     */
    public static String frameTitleQuit;
    /**
     * Tekst w oknie wy�wietlanym po naci�ni�ciu przycisku ko�cz�cego program w menu g��wnym
     */
    public static String quitDialogText;
    /**
     * Tekst wy�wietlany w przycisku okna dialogowego, kt�rego naci�ni�cie potwierdza ch�� opuszczenia programu
     */
    public static String quitDialogOptionYes;
    /**
     * Tekst wy�wietlany w przycisku okna dialogowego, kt�rego naci�ni�cie odwo�uje ch�� opuszczenia programu
     */
    public static String quitDialogOptionNo;
    /**
     * Tytu� okna, kt�re wy�wietla si� podczas podawania nicku gracza
     */
    public static String frameTitleNick;
    /**
     * Tekst w oknie, kt�re wy�wietla si� podczas podawania nicku gracza
     */
    public static String nickDialogText;
    /**
     * Tekst wy�wietlany w przycisku umo�liwiaj�cy przej�cie do kolejnego okienka
     */
    public static String nextBtn;
    /**
     * Tekst wy�wietlany w przycisku umo�liwiaj�cym powr�t do menu g�ownego
     */
    public static String backToMainMenuBtn;
    /**
     * Tytu� okna w kt�rym gracz dokonuje wyboru poziomu trudno�ci gry
     */
    public static String frameTitleDiffLevel;
    /**
     * Tekst wy�wietlany w oknie wyboru poziomu trudno�ci gry
     */
    public static String diffLevelDialogText;
    /**
     * Tekst wy�wietlony na przycisku �atwego poziomu gry
     */
    public static String levelEasyBtn;
    /**
     * Tekst wy�wietlony na przycisku �redniego poziomu gry
     */
    public static String levelMediumBtn;
    /**
     * Tekst wy�wietlony na przycisku trudnego poziomu gry
     */
    public static String levelHardBtn;
    /**
     * Zmienna okre�laj�ca plik zawieraj�cy najlepsze wyniki
     */
    public static String highScoreFile;
    /**
     * Tekst wy�wietlany w oknie, kt�re pojawia si� w przypadku
     * nieznalezienia pliku
     */
    public static String fileNotFoundText;
    /**
     * Tytu� okna, kt�re pojawia si� w przypadku nieznalezienia pliku
     */
    public static String frameTitleFileNotFound;
    /**
     * Wysoko�� panelu informacyjnego
     */
    public static double heightOfInfoPanel; 
    /**
     * Szeroko�� panelu informacyjnego
     */
    public static double widthOfInfoPanel;
    /**
     * Wysoko�� panelu gry
     */
    public static double heightOfGamePanel;
    /**
     * Szeroko�� panelu gry
     */
    public static double widthOfGamePanel;
    /**
     * Tekst w miejscu podania punktacji
     */
    public static String pointLabelText;
    /**
     * Tekst w miejscu podania liczby pozosta�ych �y�
     */
    public static String remainingLifesLabelText;
    /**
     * Tekst w miejscu podania nicku gracza
     */
    public static String nickLabelText;
    /**
     * Tekst w miejscu podania czasu trwania rozgrywki
     */
    public static String timeLabelText;
    /**
     * Tekst wy�wietlany na przycisku odpowiadaj�cym za pauz� w grze
     */
    public static String pauzaBtn;
    /**
     * Tekst wy�wietlany na przycisku odpowiadaj�cym za wznowienie gry po pauzie
     */
    public static String backToGameBtn;
    /**
     * Tekst wy�wietlany na przycisku powrotu do g��wnego menu 
     */
    public static String quitToMainMenuBtn;
    /**
     * Tytu� okna powrotu do g��wnego menu
     */
    public static String frameTitleQuitToMainMenu;
    /**
     * Tekst wy�wietlany w oknie powrotu do g��wnego menu
     */
    public static String quitToMainMenuText;
    /**
     * Pocz�tkowa liczba punkt�w;
     */
    public static int initialAmountOfPoints;
    /**
     * Pocz�tkowy czas trwania gry;
     */
    public static int initialTime;
    /**
     * Pocz�tkowa liczba �y�
     */
    public static int initialLifes;
    /**
     * Liczba rz�d�w cegie�ek
     */
    public static int numberOfBrickRows;
    /**
     * Liczba kolumn cegie�ek
     */
    public static int numberOfBrickColumnes;
    /**
     * Miejsce rozpocz�cia rysowania cegie�ek w osi X
     */
    public static int brickStartX;
    /**
     * Miejsce rozpocz�cia rysowania cegie�ek w osi Y 
     */
    public static int brickStartYCounter;
    /**
     * Miejsce rozpocz�cia rysowania cegie�ek w osi Y ratio
     */
    public static int brickStartYDenominator;
    /**
     * Wysoko�� cegie�ki
     */
    public static double brickHeight;
    /**
     * Szeroko�� cegie�ki
     */
    public static double brickWidth;
    /**
     * Wysoko�� boostera
     */
    public static double boosterHeight;
    /**
     * Szeroko�� boostera
     */
    public static double boosterWidth;
    /**
     * Ilo�� uderze� potrzebnych do zbicia cegie�ki czarnej
     */
    public static int blackBrickLifes;
    /**
     * Ilo�� punkt�w za zbicie cegie�ki czarnej
     */
    public static int blackBrickPoints;
    /**
     * Ilo�� uderze� potrzebnych do zbicia cegie�ki czerwonej
     */
    public static int redBrickLifes;
    /**
     * Ilo�� punkt�w za zbicie cegie�ki czerwonej
     */
    public static int redBrickPoints;
    /**
     * Ilo�� uderze� potrzebnych do zbicia cegie�ki ��tej
     */
    public static int yellowBrickLifes;
    /**
     * Ilo�� punkt�w za zbicie cegie�ki ��tej
     */
    public static int yellowBrickPoints;
    /**
     * Ilo�� uderze� potrzebnych do zbicia cegie�ki zielonej
     */
    public static int greenBrickLifes;
    /**
     * Ilo�� punkt�w za zbicie cegie�ki zielonej
     */
    public static int greenBrickPoints;
    /**
     * Ilo�� uderze� potrzebnych do zbicia zbitej cegie�ki
     */
    public static int noneBrickLifes;
    /**
     * Ilo�� punkt�w za zbicie zbitej cegie�ki
     */
    public static int noneBrickPoints;
    /**
     * Stosunek szeroko�ci paletki
     */
    public static double paddleWidthRatio;
    /**
     * Stosunek wysoko�ci paletki
     */
    public static double paddleHeightRatio;
    /**
     * promie� pi�ki
     */
    public static double ballRadius;

    /**
     * Pr�dko�� pi�ki w kierunku X na poziomie �atwym
     */
    public static double easyBallXVelocity;
  
    /**
     * Pr�dko�� pi�ki w kierunku Y na poziomie �atwym
     */
    public static double easyBallYVelocity;
    
    /**
     * Pr�dko�� pi�ki w kierunku X na poziomie �rednim
     */
    public static double mediumBallXVelocity;
    
    /**
     * Pr�dko�� pi�ki w kierunku Y na poziomie �rednim
     */
    public static double mediumBallYVelocity;
    
    /**
     * Pr�dko�� pi�ki w kierunku X na poziomie trudnym
     */
    public static double hardBallXVelocity;
    
    /**
     * Pr�dko�� pi�ki w kierunku Y na poziomie trudnym
     */
    public static double hardBallYVelocity;   
    
    /**
     * Maksymalny k�t odciaia od paletki
     */
    public static int maxAngle;
 
    /**
     * Pocz�tkowe po�o�enie paletki na osi X
     */
    public static double paddleStartX;
    
    /**
     * Pocz�tkowe po�o�enie paletki na osi Y
     */
    public static double paddleStartY;
    
    /**
     * Pr�dko�� paletki w kierunku X
     */
    public static double paddleXVelocity;
    
    /**
     * Lokalizacja pliku z opisem poziom�w
     */
    public static String levelFile;
   
    /**
     * Zmienna okre�laj�ca po�o�enie pliku z opisem poziom�w
     */
    public static String xmlLvlFile;
    
    /**
     * numer pierwszego poziomu gry
     */
    public static int firstLevel;
    
    /**
     * numer ostatniego poziomu gry
     */
    public static int lastLevel;
   
    /**
     * Tekst informuj�cy, �e gracz nie ma wi�cej �y�
     */
    public static String lifesOverText;
    
    /**
     * Tekst informuj�cy o ko�cu gry
     */
    public static String gameOverText;
   
    /**
     * Pocz�tkowe znormalizowane po�o�enie pi�ki w p�aszczyznie X
     */
    public static double initBallNormXPosition;
    
    /**
     * Pocz�tkowe znormalizowane po�o�enie pi�ki w p�aszczyznie Y
     */
    public static double initBallNormYPosition;
    

   static{
        parseConfigurationMenuFile();

    }

    private Constants(){}


    /**
     * Metoda wczytuj�ca pola z pliku konfugracyjnego
     */

    public static void parseConfigurationMenuFile (){
        try {

            File inputFile = new File(configFile);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            mainMenuWidth=Integer.parseInt(doc.getElementsByTagName("mainMenuWidth").item(0).getTextContent());
            mainMenuHeight=Integer.parseInt(doc.getElementsByTagName("mainMenuHeight").item(0).getTextContent());
            frameTitle=doc.getElementsByTagName("frameTitle").item(0).getTextContent();
            gameTitle=doc.getElementsByTagName("gameTitle").item(0).getTextContent();
            mainMenuNewGameBtn=doc.getElementsByTagName("mainMenuNewGameBtn").item(0).getTextContent();
            mainMenuHighScoreBtn=doc.getElementsByTagName("mainMenuHighScoreBtn").item(0).getTextContent();
            mainMenuQuitBtn=doc.getElementsByTagName("mainMenuQuitBtn").item(0).getTextContent();
            frameTitleQuit =doc.getElementsByTagName("frameTitleQuit").item(0).getTextContent();
            quitDialogText=doc.getElementsByTagName("quitDialogText").item(0).getTextContent();
            quitDialogOptionYes=doc.getElementsByTagName("quitDialogOptionYes").item(0).getTextContent();
            quitDialogOptionNo=doc.getElementsByTagName("quitDialogOptionNo").item(0).getTextContent();
            frameTitleNick=doc.getElementsByTagName("frameTitleNick").item(0).getTextContent();
            nickDialogText=doc.getElementsByTagName("nickDialogText").item(0).getTextContent();
            nextBtn=doc.getElementsByTagName("nextBtn").item(0).getTextContent();
            backToMainMenuBtn=doc.getElementsByTagName("backToMainMenuBtn").item(0).getTextContent();
            frameTitleDiffLevel=doc.getElementsByTagName("frameTitleDiffLevel").item(0).getTextContent();
            diffLevelDialogText=doc.getElementsByTagName("diffLevelDialogText").item(0).getTextContent();
            levelEasyBtn=doc.getElementsByTagName("levelEasyBtn").item(0).getTextContent();
            levelMediumBtn=doc.getElementsByTagName("levelMediumBtn").item(0).getTextContent();
            levelHardBtn=doc.getElementsByTagName("levelHardBtn").item(0).getTextContent();
            highScoreFile=doc.getElementsByTagName("highScoreFile").item(0).getTextContent();
            fileNotFoundText=doc.getElementsByTagName("fileNotFoundText").item(0).getTextContent();
            frameTitleFileNotFound=doc.getElementsByTagName("frameTitleFileNotFound").item(0).getTextContent();
            heightOfInfoPanel=Double.parseDouble(doc.getElementsByTagName("heightOfInfoPanel").item(0).getTextContent());
            widthOfInfoPanel=Double.parseDouble(doc.getElementsByTagName("widthOfInfoPanel").item(0).getTextContent());
            heightOfGamePanel=Double.parseDouble(doc.getElementsByTagName("heightOfGamePanel").item(0).getTextContent());
            widthOfGamePanel=Double.parseDouble(doc.getElementsByTagName("widthOfGamePanel").item(0).getTextContent());
            pointLabelText=doc.getElementsByTagName("pointLabelText").item(0).getTextContent();
            remainingLifesLabelText=doc.getElementsByTagName("remainingLifesLabelText").item(0).getTextContent();
            nickLabelText=doc.getElementsByTagName("nickLabelText").item(0).getTextContent();
            timeLabelText=doc.getElementsByTagName("timeLabelText").item(0).getTextContent();
            pauzaBtn=doc.getElementsByTagName("pauzaBtn").item(0).getTextContent();
            backToGameBtn=doc.getElementsByTagName("backToGameBtn").item(0).getTextContent();
            quitToMainMenuBtn=doc.getElementsByTagName("quitToMainMenuBtn").item(0).getTextContent();
            frameTitleQuitToMainMenu=doc.getElementsByTagName("frameTitleQuitToMainMenu").item(0).getTextContent();
            quitToMainMenuText=doc.getElementsByTagName("quitToMainMenuText").item(0).getTextContent();
            initialAmountOfPoints=Integer.parseInt(doc.getElementsByTagName("initialAmountOfPoints").item(0).getTextContent());
            initialTime=Integer.parseInt(doc.getElementsByTagName("initialTime").item(0).getTextContent());
            initialLifes=Integer.parseInt(doc.getElementsByTagName("initialLifes").item(0).getTextContent());
            numberOfBrickRows=Integer.parseInt(doc.getElementsByTagName("numberOfBrickRows").item(0).getTextContent());
            numberOfBrickColumnes=Integer.parseInt(doc.getElementsByTagName("numberOfBrickColumnes").item(0).getTextContent());
            brickStartX=Integer.parseInt(doc.getElementsByTagName("brickStartX").item(0).getTextContent());
            brickStartYCounter=Integer.parseInt(doc.getElementsByTagName("brickStartYCounter").item(0).getTextContent());
            brickStartYDenominator=Integer.parseInt(doc.getElementsByTagName("brickStartYDenominator").item(0).getTextContent());
            brickHeight=Double.parseDouble(doc.getElementsByTagName("brickHeight").item(0).getTextContent());
            brickWidth=Double.parseDouble(doc.getElementsByTagName("brickWidth").item(0).getTextContent());
            boosterHeight=Double.parseDouble(doc.getElementsByTagName("boosterHeight").item(0).getTextContent());		
            boosterWidth=Double.parseDouble(doc.getElementsByTagName("boosterWidth").item(0).getTextContent());			
            blackBrickLifes=Integer.parseInt(doc.getElementsByTagName("blackBrickLifes").item(0).getTextContent());
            blackBrickPoints=Integer.parseInt(doc.getElementsByTagName("blackBrickPoints").item(0).getTextContent());
            redBrickLifes=Integer.parseInt(doc.getElementsByTagName("redBrickLifes").item(0).getTextContent());
            redBrickPoints=Integer.parseInt(doc.getElementsByTagName("redBrickPoints").item(0).getTextContent());
            yellowBrickLifes=Integer.parseInt(doc.getElementsByTagName("yellowBrickLifes").item(0).getTextContent());
            yellowBrickPoints=Integer.parseInt(doc.getElementsByTagName("yellowBrickPoints").item(0).getTextContent());
            greenBrickLifes=Integer.parseInt(doc.getElementsByTagName("greenBrickLifes").item(0).getTextContent());
            greenBrickPoints=Integer.parseInt(doc.getElementsByTagName("greenBrickPoints").item(0).getTextContent());
            noneBrickLifes=Integer.parseInt(doc.getElementsByTagName("noneBrickLifes").item(0).getTextContent());
            noneBrickPoints=Integer.parseInt(doc.getElementsByTagName("noneBrickPoints").item(0).getTextContent());
            paddleWidthRatio=Double.parseDouble(doc.getElementsByTagName("paddleWidthRatio").item(0).getTextContent());
            paddleHeightRatio=Double.parseDouble(doc.getElementsByTagName("paddleHeightRatio").item(0).getTextContent());
            ballRadius=Double.parseDouble(doc.getElementsByTagName("ballRadius").item(0).getTextContent());
            maxAngle=Integer.parseInt(doc.getElementsByTagName("maxAngle").item(0).getTextContent());
            paddleStartX=Double.parseDouble(doc.getElementsByTagName("paddleStartX").item(0).getTextContent());
            paddleStartY=Double.parseDouble(doc.getElementsByTagName("paddleStartY").item(0).getTextContent());
            paddleXVelocity=Double.parseDouble(doc.getElementsByTagName("paddleXVelocity").item(0).getTextContent());
            levelFile=doc.getElementsByTagName("levelFile").item(0).getTextContent();
            xmlLvlFile=doc.getElementsByTagName("xmlLvlFile").item(0).getTextContent();
            firstLevel=Integer.parseInt(doc.getElementsByTagName("firstLevel").item(0).getTextContent());
            lastLevel=Integer.parseInt(doc.getElementsByTagName("lastLevel").item(0).getTextContent());
            lifesOverText=doc.getElementsByTagName("lifesOverText").item(0).getTextContent();
            gameOverText=doc.getElementsByTagName("gameOverText").item(0).getTextContent();
            easyBallXVelocity=Double.parseDouble(doc.getElementsByTagName("easyBallXVelocity").item(0).getTextContent());
            easyBallYVelocity=Double.parseDouble(doc.getElementsByTagName("easyBallYVelocity").item(0).getTextContent());
            mediumBallXVelocity=(Double.parseDouble(doc.getElementsByTagName("mediumBallXVelocity").item(0).getTextContent()));
            mediumBallYVelocity=(Double.parseDouble(doc.getElementsByTagName("mediumBallYVelocity").item(0).getTextContent()));
            hardBallXVelocity=(Double.parseDouble(doc.getElementsByTagName("hardBallXVelocity").item(0).getTextContent()));
            hardBallYVelocity=(Double.parseDouble(doc.getElementsByTagName("hardBallYVelocity").item(0).getTextContent()));          
            initBallNormXPosition = Double.parseDouble(doc.getElementsByTagName("initBallNormXPosition").item(0).getTextContent());
            initBallNormYPosition = Double.parseDouble(doc.getElementsByTagName("initBallNormYPosition").item(0).getTextContent());
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}

