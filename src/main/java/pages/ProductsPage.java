package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductsPage extends BasePage{

    By product = By.cssSelector("li.productListContent-item");
    By addToCart = By.cssSelector("button[data-test-id='product-info-button']");
    public void selectProduct(int index){
        WebElement product1 = getProducts().get(index);
        hoverOver(product1);
        click(addToCart);

    }

    private List<WebElement> getProducts(){
        return findAllBy(product);
    }

}
