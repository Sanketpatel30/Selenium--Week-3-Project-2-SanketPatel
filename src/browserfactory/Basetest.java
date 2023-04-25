package browserfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Basetest {

    public static WebDriver driver;

   public void openBrowser(String baseUrl){
       System.setProperty("WebDriver.chrome.driver", "drivers/chromedriver.exe");
       driver = new ChromeDriver();
       // Launch the Url
       driver.get(baseUrl);
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
   }

    public void closeBrowser() {
        driver.quit();
    }

    public static void main(String[] args) {
        Basetest b = new Basetest();
        b.openBrowser("http://tutorialsninja.com/demo/index.php");

        b.closeBrowser();
    }
}