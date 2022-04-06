package StepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class Steps {
    private WebDriver driver;

    @Given("^Open the browser and launch the application$")
    public void open_the_browser_and_launch_the_application() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");
    }

    @When("^search (.+)$")
    public void search(String word) {
        final WebElement webElement = driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input"));
        webElement.sendKeys(word);
        webElement.sendKeys(Keys.ENTER);
    }

    @Then("^show data$")
    public void show_data() {
    }

    @And("^click (.+)$")
    public void click(String result) {
        By xpath = By.xpath("//a[@href='" + result + "']");
        final WebElement webElement = driver.findElement(xpath);
        webElement.click();
    }

    @And("^searching in wikipedia (.+)$")
    public void search_in_wikipedia(String wikipediaword) {
        final WebElement webElement = driver.findElement(By.id("searchInput"));
        webElement.sendKeys(wikipediaword);
        webElement.sendKeys(Keys.ENTER);
    }

    @And("^select (.+)$")
    public void select(String externallink) {
        By xpath = By.xpath("//a[@href='" + externallink + "']");
        driver.findElement(xpath).sendKeys(Keys.CONTROL, "t");

        ((JavascriptExecutor) driver).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        driver.get(externallink);
    }
}
