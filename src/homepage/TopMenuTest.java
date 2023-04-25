package homepage;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utility.Utility;

public class TopMenuTest extends Utility {

    String baseUrl = "http://tutorialsninja.com/demo/index.php?";

    @Before

    public void launchBrowser() {
        openBrowser(baseUrl);
    }
    // Use the WebDriver instance to find and click the menu based on its name

    public void selectMenu(String menu) {
        driver.findElement(By.xpath("//nav[@id='menu'], '" + menu + "')]")).click();
        Assert.assertEquals("Correct page is not displayed", menu, driver.findElement(By.xpath("//nav[@id='menu'],'" + menu + "')]")).getText());
    }

    @Test
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully() {
        clickOnElement(By.xpath("//body/div[1]/nav[1]/div[2]/ul[1]/li[1]/a[1]"));
        clickOnElement(By.xpath("//a[contains(text(),'Show AllDesktops')]"));
        Assert.assertEquals("Desktops not displayed", "Desktops", driver.findElement(By.xpath("//h2[contains(text(),'Desktops')]")).getText());
    }

    @Test
    public void verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully() {
        clickOnElement(By.xpath("//body/div[1]/nav[1]/div[2]/ul[1]/li[2]/a[1]"));
        clickOnMouseHoverOnElement(By.xpath("//a[contains(text(),'Show AllLaptops & Notebooks')]"));
        clickOnElement(By.xpath("//a[contains(text(),'Show AllLaptops & Notebooks')]"));
        selectMenu("Show All Laptops & Notebooks");
        Assert.assertEquals("Laptops & Notebooks page not displayed", "Laptops & Notebooks", driver.findElement(By.xpath("//h2[contains(text(),'Laptops & Notebooks')]")).getText());
        driver.findElement(By.xpath("//h2[normalize-space()='Laptops & Notebooks']")).click();

    }

    @Test
    public void verifyUserShouldNavigateToComponentsPageSuccessfully() {
        //3.1 Mouse hover on “Components” Tab and click
        clickOnMouseHoverOnElement(By.xpath("//body/div[1]/nav[1]/div[2]/ul[1]/li[3]/a[1]"));
        //3.2 call selectMenu method and pass the menu = “Show All Components
        clickOnMouseHoverOnElement(By.xpath("//a[contains(text(),'Show AllComponents')]"));
        // 3.3 Verify the text ‘Components’
        Assert.assertEquals("Components page not displayed", "Components", driver.findElement(By.xpath("//h2[contains(text(),'Components')]")).getText());


    }

}