package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CartPage extends BasePage{

    By deleteAll = By.cssSelector("div.delete_all_2uTds");
    By deleteButton = By.cssSelector("button.red_3m-Kl");

    public void clearCart() {
        click(deleteAll);
        wait.until(ExpectedConditions.visibilityOfElementLocated(deleteButton));
        click(deleteButton);
    }
}
