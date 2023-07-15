package org.example.stepdefinations;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

public class LoginPageDefinations {

    private static WebDriver driver;
    public final static int TIMEOUT = 10;

    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions ops = new ChromeOptions();
        ops.addArguments("--remote-allow-origins=*");
        ops.addArguments("--start-maximized");
        ops.addArguments("--incognito");
        ops.addArguments("--disable-geolocation");
        ops.setExperimentalOption("useAutomationExtension", false);
        ops.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
        driver = new ChromeDriver(ops);
        driver.manage().timeouts().implicitlyWait(TIMEOUT, TimeUnit.SECONDS);
    }

    @Given("User is in Suacedemo homepage {string}")
    public void navigate_to_url(String url) {
        System.out.println("in prestep");
        driver.get(url);
    }
    @When("Logins to the system")
    public void logins_to_the_system() {
        System.out.println("test");
    }
    @Then("User enters correct username {string}")
    public void user_enters_correct_username(String username) {
        driver.findElement(By.cssSelector("input[id='user-name']")).sendKeys(username);

    }
    @Then("User enters correct password {string}")
    public void user_enters_correct_password(String password) {
        driver.findElement(By.cssSelector("input[id='password']")).sendKeys(password);
    }

    @Then("User should be able to login")
    public void user_should_be_able_to_login() {
        driver.findElement(By.cssSelector("input[id='login-button']")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='app_logo' and text()='Swag Labs']")));
        String errortext = driver.findElement(By.xpath("//div[@class='app_logo' and text()='Swag Labs']")).getText();
        if (errortext.contains("Swag Labs")){
            Assert.assertTrue(true);
        }
        else {
            Assert.fail("Logo didn't appeared after waiting for 10 seconds");
        }
    }

    @After
    public void teardown(){
        driver.quit();
    }
}
