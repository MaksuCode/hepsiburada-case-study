package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage{

    By usernameLocator = By.cssSelector("input[name='username']");
    By loginButton = By.id("btnLogin");
    By passwordLocator = By.cssSelector("input[name='password']");
    By loginButton2 = By.id("btnEmailSelect");

    public void loginWith(String username, String password) {
        type(usernameLocator, username);
        click(loginButton);
        type(passwordLocator, password);
        click(loginButton2);
        wait.until(ExpectedConditions.titleIs("Türkiye'nin En Büyük Online Alışveriş Sitesi Hepsiburada.com"));
    }

}
