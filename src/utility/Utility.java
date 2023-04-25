package utility;

import browserfactory.Basetest;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Utility extends Basetest {

    public void dismiss() {
        dismiss();
    }

    public void alertDismiss() {
        clickOnElement(By.id("alertbtn"));//click on alert button
        Alert alert = driver.switchTo().alert();//Creating alert object reference and Switch to Alert
        System.out.println(alert.getText());
        alert.dismiss();
    }

    //******************************Click, get text, send text & verify text methods**********************************//

    //This method will click on element
    public void clickOnElement(By by) {
        WebElement element = driver.findElement(by);
        element.click();
    }
    public WebElement element (By by){
        return driver.findElement(by);
    }

    //This method get text from element
    public String getTextFromElement(By by) {
        return driver.findElement(by).getText();
    }

    //This method will send to element
    public void sendTextToElement(By by, String text) {
        driver.findElement(by).sendKeys(text);
    }

    //This method verify the expected text
    public void assertVerifyText(By by, String expectedtext) {
        String actualText = getTextFromElement(by);
        String expectedText = expectedtext;
        Assert.assertEquals("Error has occurred --->  Test failed : ", expectedText, actualText);
    }

    public void selectByVisibleText(By by, String text) {
        driver.findElement(by).sendKeys(text);
    }

    //*********************************************Alert methods******************************************************//

    //This method will switch to the alert
    public void actions(By by, String text) {
        driver.findElement(by).sendKeys(text);
    }

    //    This method will get text from element

    public void getTextFromElement(By by, String text) {
        driver.findElement(by).getText();
    }

    public void sendKeyToElement(By by, CharSequence keys) {
        driver.findElement(by).sendKeys(keys);
    }

    public void switchToAlert() {
        driver.switchTo().alert();
    }

    //This method will accept the alert
    public void acceptAlert() {
        driver.switchTo().alert().accept();
    }

    public void dismissAlert() {
        driver.switchTo().alert().dismiss();
    }

    public void sendKeysToAlert(String text) {
        driver.switchTo().alert().sendKeys(text);
    }

    public void verifyText(String s, String expectedText, String actualText) {
    }


    //**********************************************Select class******************************************************//
    public void verifyElements(String displayMessage, String expectedMessage, By by) {
        String actualMessage = getTextFromElement(by);
        Assert.assertEquals(displayMessage, expectedMessage, actualMessage);
    }

    public void selectByVisibleTextFromDropDown(By by, String text) {
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        select.selectByVisibleText(text);
    }

    public void selectByValueFromDropDown(By by, String text) {
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        select.selectByValue(text);
    }

    public void selectByIndexFromDropDown(By by, int a) {
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        select.selectByIndex(a);
    }

    public void selectByGetAllOptionFromDropDown(By by, String text) {
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        List<WebElement> allOptions = select.getOptions();
        for (WebElement element : allOptions
        ) {
            //System.out.println(element.getText());//to print all countries
            if (element.getText().equals(text)) {
                element.click();
            }
        }
    }

    //***********************************************Mouse Hover******************************************************//

    public void mouseHoverOnElement(By by) {
        Actions actions = new Actions(driver);
        WebElement xyz = driver.findElement(by);
        actions.moveToElement(xyz).build().perform();
    }

    public void clickOnMouseHoverOnElement(By by) {
        Actions actions = new Actions(driver);
        WebElement xyz = driver.findElement(by);
        actions.moveToElement(xyz).click().build().perform();
    }

    public void selectDate() {
        String year = "2025";
        String month = "May";
        String date = "5";

        clickOnElement(By.id("onward_cal"));
        while (true) {
            String monthYear = driver.findElement(By.xpath("//td[@class='monthTitle']")).getText();
            System.out.println(monthYear); //Apr 2023
            String[] a = monthYear.split(" ");
            String mon = a[0];
            String yer = a[1];
            if (mon.equalsIgnoreCase(month) && yer.equalsIgnoreCase(year)) {
                break;
            } else {
                clickOnElement((By.xpath("//button[normalize-space()='>']")));
            }
        }

        //Select the date
        List<WebElement> allDates = driver.findElements(By.xpath("//div[@id='rb-calendar_onward_cal']//table//td"));

        for (WebElement dt : allDates) {

            if (dt.getText().equalsIgnoreCase(date)) {
                dt.click();
                break;
            }
        }
    }
}

