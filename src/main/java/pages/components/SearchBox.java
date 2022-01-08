package pages.components;

import org.openqa.selenium.By;
import pages.BasePage;

public class SearchBox extends BasePage {

    By searchInput = By.cssSelector("div[id='SearchBoxOld'] input");
    By searchButton = By.cssSelector("div.SearchBoxOld-buttonContainer");

    public void search(String text) {
        type(searchInput, text);
        click(searchButton);
    }

}
