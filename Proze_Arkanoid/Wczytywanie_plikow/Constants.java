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
 *  Sta³e parametry pobierane z plików konfiguracyjnych
 */

public final class Constants {
    public static final String configFile="Pliki_konfiguracyjne\\config.xml";
    /**
     * Okreœla szerokoœæ okna menu g³ównego
     */
    public static int mainMenuWidth;
    /**
     * Okreœla wysokoœæ okna menu g³ównego
     */
    public static int mainMenuHeight;
    /**
     * Okreœla tytu³ okna
     */
    public static String frameTitle;
    /**
     *  Okreœla nazwê gry
     */
    public static String gameTitle;
    /**
     * Tekst na przycisku nowej gry w g³ównym menu
     */
    public static String mainMenuNewGameBtn;
    /**
     * Tekst na przycisku najlepszych wyników w g³ównym menu
     */
    public static String mainMenuHighScoreBtn;
    /**
     * Tekst na przycisku zakoñczenia programu w g³ównym menu
     */
    public static String mainMenuQuitBtn;
    /**
     * Tytu³ okna wyœwietlanego po naciœniêciu przycisku koñcz¹cego program w menu g³ównym
     */
    public static String frameTitleQuit;
    /**
     * Tekst w oknie wyœwietlanym po naciœniêciu przycisku koñcz¹cego program w menu g³ównym
     */
    public static String quitDialogText;
    /**
     * Tekst wyœwietlany w przycisku okna dialogowego, którego naciœniêcie potwierdza chêæ opuszczenia programu
     */
    public static String quitDialogOptionYes;
    /**
     * Tekst wyœwietlany w przycisku okna dialogowego, którego naciœniêcie odwo³uje chêæ opuszczenia programu
     */
    public static String quitDialogOptionNo;
    /**
     * Tytu³ okna, które wyœwietla siê podczas podawania nicku gracza
     */
    public static String frameTitleNick;
    /**
     * Tekst w oknie, które wyœwietla siê podczas podawania nicku gracza
     */
    public static String nickDialogText;
    /**
     * Tekst wyœwietlany w przycisku umo¿liwiaj¹cy przejœcie do kolejnego okienka
     */
    public static String nextBtn;
    /**
     * Tekst wyœwietlany w przycisku umo¿liwiaj¹cym powrót do menu g³ownego
     */
    public static String backToMainMenuBtn;
    /**
     * Tytu³ okna w którym gracz dokonuje wyboru poziomu trudnoœci gry
     */
    public static String frameTitleDiffLevel;
    /**
     * Tekst wyœwietlany w oknie wyboru poziomu trudnoœci gry
     */
    public static String diffLevelDialogText;
    /**
     * Tekst wyœwietlony na przycisku ³atwego poziomu gry
     */
    public static String levelEasyBtn;
    /**
     * Tekst wyœwietlony na przycisku œredniego poziomu gry
     */
    public static String levelMediumBtn;
    /**
     * Tekst wyœwietlony na przycisku trudnego poziomu gry
     */
    public static String levelHardBtn;
    /**
     * Zmienna okreœlaj¹ca plik zawieraj¹cy najlepsze wyniki
     */
    public static String highScoreFile;
    /**
     * Tekst wyœwietlany w oknie, które pojawia siê w przypadku
     * nieznalezienia pliku
     */
    public static String fileNotFoundText;
    /**
     * Tytu³ okna, które pojawia siê w przypadku nieznalezienia pliku
     */
    public static String frameTitleFileNotFound;
    /**
     * Wysokoœæ panelu informacyjnego
     */
    public static double heightOfInfoPanel; 
    /**
     * Szerokoœæ panelu informacyjnego
     */
    public static double widthOfInfoPanel;
    /**
     * Wysokoœæ panelu gry
     */
    public static double heightOfGamePanel;
    /**
     * Szerokoœæ panelu gry
     */
    public static double widthOfGamePanel;
    /**
     * Tekst w miejscu podania punktacji
     */
    public static String pointLabelText;
    /**
     * Tekst w miejscu podania liczby pozosta³ych ¿yæ
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
     * Tekst wyœwietlany na przycisku odpowiadaj¹cym za pauzê w grze
     */
    public static String pauzaBtn;
    /**
     * Tekst wyœwietlany na przycisku odpowiadaj¹cym za wznowienie gry po pauzie
     */
    public static String backToGameBtn;
    /**
     * Tekst wyœwietlany na przycisku powrotu do g³ównego menu 
     */
    public static String quitToMainMenuBtn;
    /**
     * Tytu³ okna powrotu do g³ównego menu
     */
    public static String frameTitleQuitToMainMenu;
    /**
     * Tekst wyœwietlany w oknie powrotu do g³ównego menu
     */
    public static String quitToMainMenuText;
    /**
     * Pocz¹tkowa liczba punktów;
     */
    public static int initialAmountOfPoints;
    /**
     * Pocz¹tkowy czas trwania gry;
     */
    public static int initialTime;
    /**
     * Pocz¹tkowa liczba ¿yæ
     */
    public static int initialLifes;
    /**
     * Liczba rzêdów cegie³ek
     */
    public static int numberOfBrickRows;
    /**
     * Liczba kolumn cegie³ek
     */
    public static int numberOfBrickColumnes;
    /**
     * Miejsce rozpoczêcia rysowania cegie³ek w osi X
     */
    public static int brickStartX;
    /**
     * Miejsce rozpoczêcia rysowania cegie³ek w osi Y 
     */
    public static int brickStartYCounter;
    /**
     * Miejsce rozpoczêcia rysowania cegie³ek w osi Y ratio
     */
    public static int brickStartYDenominator;
    /**
     * Wysokoœæ cegie³ki
     */
    public static double brickHeight;
    /**
     * Szerokoœæ cegie³ki
     */
    public static double brickWidth;
    /**
     * Wysokoœæ boostera
     */
    public static double boosterHeight;
    /**
     * Szerokoœæ boostera
     */
    public static double boosterWidth;
    /**
     * Iloœæ uderzeñ potrzebnych do zbicia cegie³ki czarnej
     */
    public static int blackBrickLifes;
    /**
     * Iloœæ punktów za zbicie cegie³ki czarnej
     */
    public static int blackBrickPoints;
    /**
     * Iloœæ uderzeñ potrzebnych do zbicia cegie³ki czerwonej
     */
    public static int redBrickLifes;
    /**
     * Iloœæ punktów za zbicie cegie³ki czerwonej
     */
    public static int redBrickPoints;
    /**
     * Iloœæ uderzeñ potrzebnych do zbicia cegie³ki ¿ó³tej
     */
    public static int yellowBrickLifes;
    /**
     * Iloœæ punktów za zbicie cegie³ki ¿ó³tej
     */
    public static int yellowBrickPoints;
    /**
     * Iloœæ uderzeñ potrzebnych do zbicia cegie³ki zielonej
     */
    public static int greenBrickLifes;
    /**
     * Iloœæ punktów za zbicie cegie³ki zielonej
     */
    public static int greenBrickPoints;
    /**
     * Iloœæ uderzeñ potrzebnych do zbicia zbitej cegie³ki
     */
    public static int noneBrickLifes;
    /**
     * Iloœæ punktów za zbicie zbitej cegie³ki
     */
    public static int noneBrickPoints;
    /**
     * Stosunek szerokoœci paletki
     */
    public static double paddleWidthRatio;
    /**
     * Stosunek wysokoœci paletki
     */
    public static double paddleHeightRatio;
    /**
     * promieñ pi³ki
     */
    public static double ballRadius;

    /**
     * Prêdkoœæ pi³ki w kierunku X na poziomie ³atwym
     */
    public static double easyBallXVelocity;
  
    /**
     * Prêdkoœæ pi³ki w kierunku Y na poziomie ³atwym
     */
    public static double easyBallYVelocity;
    
    /**
     * Prêdkoœæ pi³ki w kierunku X na poziomie œrednim
     */
    public static double mediumBallXVelocity;
    
    /**
     * Prêdkoœæ pi³ki w kierunku Y na poziomie œrednim
     */
    public static double mediumBallYVelocity;
    
    /**
     * Prêdkoœæ pi³ki w kierunku X na poziomie trudnym
     */
    public static double hardBallXVelocity;
    
    /**
     * Prêdkoœæ pi³ki w kierunku Y na poziomie trudnym
     */
    public static double hardBallYVelocity;   
    
    /**
     * Maksymalny k¹t odciaia od paletki
     */
    public static int maxAngle;
 
    /**
     * Pocz¹tkowe po³o¿enie paletki na osi X
     */
    public static double paddleStartX;
    
    /**
     * Pocz¹tkowe po³o¿enie paletki na osi Y
     */
    public static double paddleStartY;
    
    /**
     * Prêdkoœæ paletki w kierunku X
     */
    public static double paddleXVelocity;
    
    /**
     * Lokalizacja pliku z opisem poziomów
     */
    public static String levelFile;
   
    /**
     * Zmienna okreœlaj¹ca po³o¿enie pliku z opisem poziomów
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
     * Tekst informuj¹cy, ¿e gracz nie ma wiêcej ¿yæ
     */
    public static String lifesOverText;
    
    /**
     * Tekst informuj¹cy o koñcu gry
     */
    public static String gameOverText;
   
    /**
     * Pocz¹tkowe znormalizowane po³o¿enie pi³ki w p³aszczyznie X
     */
    public static double initBallNormXPosition;
    
    /**
     * Pocz¹tkowe znormalizowane po³o¿enie pi³ki w p³aszczyznie Y
     */
    public static double initBallNormYPosition;
    

   static{
        parseConfigurationMenuFile();

    }

    private Constants(){}


    /**
     * Metoda wczytuj¹ca pola z pliku konfugracyjnego
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

