package pages;

import org.openqa.selenium.By;

public class PaymentPage extends BasePage{

    String paymentMethodXpath = "//div[@id='payment-methods']//h3[contains(text() , '";
    String moneyTransferBankNameXpath = "//div[@class='sardesPaymentPage-MoneyTransfer-bank_description']/p[1][contains(text(), '";

    public void selectBankForMoneyTransfer(String bankName){
        moneyTransferBankNameXpath = moneyTransferBankNameXpath + bankName + "')]" ;
        findBy(By.xpath(moneyTransferBankNameXpath)).click();
    }

    public void selectPaymentMethod(String paymentMethod){
        paymentMethodXpath = paymentMethodXpath + paymentMethod + "')]";
        click(By.xpath(paymentMethodXpath));
    }


}
