package pages.components;

import org.openqa.selenium.By;
import pages.BasePage;

public class NavigationBar extends BasePage {

    By myAccount = By.id("myAccount");
    By login = By.id("login");
    By cart = By.id("shoppingCart");
    SearchBox searchBox;

    public NavigationBar() {
        this.searchBox = new SearchBox();
    }

    public SearchBox searchBox(){
        return this.searchBox;
    }

    public void navigateToLoginPage(){
        hoverOverMyAccount();
        click(login);
    }

    public void navigateToCartPage(){
        click(cart);
    }

    private void hoverOverMyAccount(){
        hoverOver(myAccount);
    }

}
