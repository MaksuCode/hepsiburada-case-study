package pages;

import org.openqa.selenium.By;

public class CheckoutPage extends BasePage{

    By bankName = By.cssSelector("div.detail_20j8y:nth-child(1) span:nth-child(2)");
    By paymentMethod = By.cssSelector("div.detail_20j8y:nth-child(2) span:nth-child(2)");

    public String getBankName(){
        return getText(bankName);
    }

    public String getPaymentMethod() {
        return getText(paymentMethod);
    }

}
