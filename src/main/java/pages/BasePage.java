package pages;

import driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.components.NavigationBar;
import java.util.List;

/**
 * Parent class of all page objects.
 * Extends DriverManager to reach driver instance.
 * Contains all common methods used in page objects.
 */
public class BasePage extends DriverManager {

    protected String baseUrl = "https://www.hepsiburada.com/";
    protected final WebDriverWait wait;
    private final Actions action;
    protected NavigationBar navigationBar;
    protected final By continueButton = By.id("continue_step_btn");

    public BasePage() {
        this.wait = new WebDriverWait(driver , 10);
        this.action = new Actions(driver);
    }

    public NavigationBar navigationBar(){
        this.navigationBar = new NavigationBar();
        return this.navigationBar;
    }

    protected WebElement findBy(By locator){
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return driver.findElement(locator);
    }

    protected List<WebElement> findAllBy(By locator){
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return driver.findElements(locator);
    }

    public String getTitle(){
        return driver.getTitle();
    }

    protected void click(By locator){
        findBy(locator).click();
    }

    protected void type(By locator, String text){
        findBy(locator).sendKeys(text);
    }

    protected void hoverOver(By locator){
        WebElement element = findBy(locator);
        action.moveToElement(element).perform();
    }

    protected void hoverOver(WebElement element){
        action.moveToElement(element).perform();
    }

    public void navigateTo(String url){
        driver.get(url);
    }

    public void back(){
        driver.navigate().back();
    }

    protected WebElement findByText(String text){
        return driver.findElement(By.linkText(text));
    }

    public void clickContinue(){
        // TODO: 7.01.2022 Fix here
        try {
            click(continueButton);

            Thread.sleep(3000);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public String getText(By locator){
        return findBy(locator).getText();
    }

}
