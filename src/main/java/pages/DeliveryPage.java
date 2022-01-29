package pages;

import org.openqa.selenium.By;

public class DeliveryPage extends BasePage{

    private final By changePaymentMethod = By.cssSelector("a.redirect_button_MHGMG");

    public void clickChangePaymentMethod(){
        try {
            click(changePaymentMethod);
            Thread.sleep(2000);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
