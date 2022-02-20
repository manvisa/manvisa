package sel1;

//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileReader;

import com.opencsv.*;

import javax.net.ssl.HttpsURLConnection;

import java.net.URL;

public class sel1class1 {
   public static final String CSV_FILE_PATH
           = "C:\\Users\\Manvi\\Downloads\\Test.csv";

    public static void main(String[] args) {

        System.out.println("Read Data Line by Line With Header \n");
       // String CSV_FILE_PATH = "C:\\Users\\Manvi\\Downloads\\Test.csv";

        System.out.println("Hello");
        System.setProperty("webdriver.chrome.driver","C:\\Driver\\chromedriver_win32\\chromedriver.exe");

        //WebDriver driver;
        //driver = new ChromeDriver();
        //driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //driver.get("https://meta.com");
        //System.out.println(driver.getTitle());
        //driver.quit();
        //String ss;
        readDataLineByLine(CSV_FILE_PATH);
        //checkLink(ss);

    }

    public static void readDataLineByLine(String file)
    {

        try {

            // Create an object of filereader class
            // with CSV file as a parameter.
            FileReader filereader = new FileReader(file);

            // create csvReader object passing
            // filereader as parameter
            CSVReader csvReader = new CSVReader(filereader);
            String[] nextRecord;

            // we are going to read data line by line
            while ((nextRecord = csvReader.readNext()) != null) {
                for (String cell : nextRecord) {
                    checkLink(cell);
                }
              //  System.out.println();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
       // return file;
    }


    public static void checkLink(String Lurl)
    {
        try
        {
            URL link=new URL(Lurl);
            HttpsURLConnection httpconn=(HttpsURLConnection) link.openConnection();
            httpconn.connect();
            int rescode= httpconn.getResponseCode();
            if (rescode>=400)
            {
                System.out.println(Lurl+"- is DOWN");

            }
            else
            {
                System.out.println(Lurl+"- is WORKING");
            }
        }
        catch (Exception e){}
    }
}
