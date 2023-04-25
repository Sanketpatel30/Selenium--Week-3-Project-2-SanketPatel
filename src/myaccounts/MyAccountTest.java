package myaccounts;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utility.Utility;

import java.util.UUID;

public class MyAccountTest extends Utility {

    String baseUrl = "http://tutorialsninja.com/demo/index.php?";

    @Before
    public void setup() {
        openBrowser(baseUrl);
    }

    public void selectMyAccountOptions(String option) throws InterruptedException {
        //Generic X-path for Options navigation
        Thread.sleep(1000);
        clickOnElement(By.xpath("//span[normalize-space()='My Account']"));
        clickOnElement(By.xpath("(//a[normalize-space()='" + option + "'])[1]"));
    }

    @After
    public void tearDown() {
        closeBrowser();
    }

    @Test
    public void verifyUserShouldNavigateToRegisterPageSuccessfully() throws InterruptedException {

        selectMyAccountOptions("Register");

        Thread.sleep(1000);
        String expectedMsg = "Register Account";
        String actualMsg = getTextFromElement(By.xpath("//h1[normalize-space()='Register Account']"));
        verifyText("The expected text is not displayed", expectedMsg, actualMsg);
    }

    @Test
    public void verifyUserShouldNavigateToLoginPageSuccessfully() throws InterruptedException {

        selectMyAccountOptions("Login");

        // Verify the text “Returning Customer”.
        String expectedMessage = "Returning Customer";
        String actualMessage = getTextFromElement(By.xpath("//h2[normalize-space()='Returning Customer']"));
        verifyText("The expected text is not displayed",expectedMessage, actualMessage);

    }

    String email;
    String password = "Abcd1234";
    @Test
    public void verifyThatUserRegisterAccountSuccessfully() throws InterruptedException {

        String name = UUID.randomUUID().toString();
        email = name + "@gmail.com";
        selectMyAccountOptions("Register");

        sendTextToElement(By.xpath("//input[@id='input-firstname']"), "Michael");
        sendTextToElement(By.xpath("//input[@id='input-lastname']"), "Vine");
        sendTextToElement(By.xpath("//input[@id='input-email']"), email);
        sendTextToElement(By.xpath("//input[@id='input-telephone']"), "07788995566");
        sendTextToElement(By.xpath("//input[@id='input-password']"), password);
        sendTextToElement(By.xpath("//input[@id='input-confirm']"), password);

        clickOnElement(By.xpath("//label[normalize-space()='Yes']"));
        clickOnElement(By.xpath("//input[@name='agree']"));
        clickOnElement(By.xpath("//input[@value='Continue']"));

        String expectedMessage = "Your Account Has Been Created!";
        String actualMessage = getTextFromElement(By.xpath("//h1[normalize-space()='Your " +
                "Account Has Been Created!']"));
        verifyText("The expected text is not displayed",expectedMessage, actualMessage);

        clickOnElement(By.xpath("//a[normalize-space()='Continue']"));

        selectMyAccountOptions("Logout");

        String expectedMes = "Account Logout";
        String actualMes = getTextFromElement(By.xpath("//h1[normalize-space()='Account Logout']"));
        verifyText("The expected text is not displayed",expectedMes, actualMes);

        clickOnElement(By.xpath("//a[normalize-space()='Continue']"));
    }

    @Test
    public  void verifyThatUserShouldLoginAndLogoutSuccessfully() throws InterruptedException {


        selectMyAccountOptions("Login");

        sendTextToElement(By.xpath("//input[@id='input-email']"), "michael12@gmail.com");
        sendTextToElement(By.xpath("//input[@id='input-password']"), "Asdf1234");

        clickOnElement(By.xpath("//input[@value='Login']"));

        String expectedMes = "My Account";
        String actualMes = getTextFromElement(By.xpath("//h2[normalize-space()='My Account']"));
        verifyText("The expected text is not displayed",expectedMes, actualMes);

        selectMyAccountOptions("Logout");

        String expectedMessage = "Account Logout";
        String actualMessage = getTextFromElement(By.xpath("//h1[normalize-space()='Account Logout']"));
        verifyText("The expected text is not displayed",expectedMessage, actualMessage);

        clickOnElement(By.xpath("//a[normalize-space()='Continue']"));
    }
}
