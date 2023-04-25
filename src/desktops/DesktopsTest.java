package desktops;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utility.Utility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DesktopsTest extends Utility {

    String baseUrl = "http://tutorialsninja.com/demo/index.php?";

    @Before
    public void launchBrowser() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyProductArrangeInAlphabeticalOrder() throws InterruptedException {
        clickOnMouseHoverOnElement(By.xpath("//body/div[1]/nav[1]/div[2]/ul[1]/li[1]/a[1]"));
        clickOnMouseHoverOnElement(By.xpath("//a[contains(text(),'Show AllDesktops')]"));
        clickOnElement(By.xpath("//select[@id='input-sort']"));
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='input-sort']"), "Name (Z - A)");
        List<WebElement> productNames = driver.findElements(By.xpath("//select[@id='input-sort']"));
        List<String> productNameStrings = new ArrayList<String>();
        for (WebElement productName : productNames) {
            productNameStrings.add(productName.getText());
        }
        List<String> sortedProductNames = new ArrayList<String>(productNameStrings);
        Collections.sort(sortedProductNames, Collections.reverseOrder());
        Assert.assertEquals(productNameStrings, sortedProductNames);
        clickOnMouseHoverOnElement(By.xpath("//body/div[1]/nav[1]/div[2]/ul[1]/li[1]/a[1]"));
        clickOnMouseHoverOnElement(By.xpath("//a[contains(text(),'Show AllDesktops')]"));
        clickOnElement(By.xpath("//select[@id='input-sort']"));
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='input-sort']"), "Name (A - Z)");
        clickOnMouseHoverOnElement(By.xpath("//a[contains(text(),'HP LP3065')]"));
        Assert.assertEquals("Incorrect Product", "HP LP3065", getTextFromElement(By.xpath("//h1[contains(text(),'HP LP3065')]")));

        String year = "2022";////2.6 Select Delivery Date 2022-11-30
        String month = "November";
        String date = "30";
        clickOnElement(By.xpath("//i[@class='fa fa-calendar']"));
        while (true) {
            String monthYear = driver.findElement(By.xpath("//th[@class='picker-switch']")).getText();

            String arr[] = monthYear.split(" ");
            String mon = arr[0];
            String yr = arr[1];
            //select expected year
            if (mon.equalsIgnoreCase(month) && yr.equals(year))
                break;
            else
                clickOnElement(By.xpath("//body[1]/div[4]/div[1]/div[1]/table[1]/thead[1]/tr[1]/th[3]"));
        }
        //select date
        List<WebElement> allDates = driver.findElements(By.xpath("/html[1]/body[1]/div[4]/div[1]/div[1]/table[1]/tbody[1]/tr[5]/td[3]"));
        for (WebElement dt : allDates) {
            if (dt.getText().equalsIgnoreCase(date)) {
                dt.click();
                break;
            }
        }

        driver.findElement(By.xpath("//input[@id='input-quantity']")).clear();
        sendTextToElement(By.xpath("//input[@id='input-quantity']"), "1");
        Thread.sleep(2000);

    }

}