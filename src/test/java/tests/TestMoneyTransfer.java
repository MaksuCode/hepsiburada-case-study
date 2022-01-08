package tests;

import driver.DriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import pages.*;
import testlogger.TestResultLogger;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 1 - browser variable needs to be present via -Dbrowser command.
 * 2- I did no want to expose my credentials here so that email and password should be provided
 * via -Demail , -Dpassword on commandline.
 */

@ExtendWith(TestResultLogger.class)
public class TestMoneyTransfer {

    static String browser = System.getProperty("browser");
    static String email = System.getProperty("email");
    static String password = System.getProperty("password");

    /**
     * The reason why I decided to have a @BeforeAll method is that my main aim is to test if the
     * bank information is set correctly on checkout or not. This method is run once the test
     * class is initiated and adds a product to cart.
     */

    @BeforeAll
    public static void login_and_add_product_to_cart(){

        DriverManager.initialize(browser);

        HomePage homePage = new HomePage();
        assertEquals("Türkiye'nin En Büyük Online Alışveriş Sitesi Hepsiburada.com",
                homePage.getTitle(), "Not on home page!");

        homePage.navigationBar().navigateToLoginPage();
        LoginPage loginPage = new LoginPage();
        assertEquals("Üye Giriş Sayfası & Üye Ol - Hepsiburada",
                loginPage.getTitle(), "Not on login page!");

        loginPage.loginWith(email, password);
        assertEquals("Türkiye'nin En Büyük Online Alışveriş Sitesi Hepsiburada.com",
                homePage.getTitle(), "Not on home page!");

        homePage.navigationBar().searchBox().search("Kitap");
        ProductsPage productsPage = new ProductsPage();
        productsPage.selectProduct(0);

    }

    /**
     * Proceed to payment page. It is executed before each test case.
     */

    @BeforeEach
    public void proceed_to_payment(){

        HomePage homePage = new HomePage();
        homePage.navigationBar().navigateToCartPage();
        CartPage cartPage = new CartPage();
        assertEquals("Sepetim", cartPage.getTitle() , "Not on cart page!");

        cartPage.clickContinue();
        DeliveryPage deliveryPage = new DeliveryPage();
        assertEquals("Teslimat Bilgileri" , deliveryPage.getTitle(), "Not on delivery page!");
        deliveryPage.clickContinue();

    }

    /**
     * Actual test method which is a parametrized test. It runs for every bankName on banks.csv file
     */

    @ParameterizedTest
    @CsvFileSource(resources = "/banks.csv")
    public void test_bank_name_on_checkout(String bankName) {

        PaymentPage paymentPage = new PaymentPage();
        assertEquals("Ödeme Bilgileri" , paymentPage.getTitle(), "Not on payment page!");
        paymentPage.selectPaymentMethod("Anında Havale");
        paymentPage.selectBankForMoneyTransfer(bankName);
        paymentPage.clickContinue();
        CheckoutPage checkoutPage = new CheckoutPage();
        assertEquals("Sipariş Özeti" , checkoutPage.getTitle() , "Not on checkout page!");
        assertEquals(bankName , checkoutPage.getBankName(), "Bank name is not correct on checkout!");
        assertEquals("Anında Havale" , checkoutPage.getPaymentMethod(), "Bank name is not correct on checkout!");

    }

    /**
     * Clears cart
     * Quits the driver after all of the test cases are run.
     */

    @AfterAll
    public static void tearDown(){
        HomePage homePage = new HomePage();
        homePage.navigationBar().navigateToCartPage();

        CartPage cartPage = new CartPage();
        cartPage.clearCart();
        DriverManager.tearDown();
    }

}
