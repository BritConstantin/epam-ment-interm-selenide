import Pages.AccountPage;
import Pages.BasketPage;
import Pages.MainPage;
import com.codeborne.selenide.impl.Waiter;
import com.codeborne.selenide.junit.ScreenShooter;
import com.codeborne.selenide.junit.TextReport;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.*;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class LoginTest {
    @Rule
    public TextReport report = new TextReport();
    @Rule
    public ScreenShooter makeScreenshotOnFailure = ScreenShooter.failedTests();
    @BeforeClass
    public static void setUp() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));
    }
    @After
    public void after(){
        closeWebDriver();
    }
    @Test
    public void loginEmptyBag() {
        AccountPage accountPage = new MainPage()
                .open()
                .clickLogin();
        accountPage
                .login("kb111110101@gmail.com", "test1234TEST")
                .checkCustomerName("Kostiantyn");
    }

    @Test
    public void logoutEmptyBag() {
        AccountPage accountPage = new MainPage()
                .open()
                .clickLogin();
        accountPage
                .login("kb111110101@gmail.com", "test1234TEST")
                .checkCustomerName("Kostiantyn")
                .logout()
                .checkLogoutSuccess();
    }

    @Test
    public void logoutWithFullBag() {
        AccountPage accountPage = new MainPage()
                .open()
                .clickLogin();
        MainPage mainPage = accountPage
                .login("kb111110101@gmail.com", "test1234TEST")
                .checkCustomerName("Kostiantyn")
                .goToMainPage();
        mainPage
                .addRandomItemToBasket()
                .checkBasketSizeEqualTo("1 шт. - 17850,00грн.");
        accountPage
                .logout()
                .checkLogoutSuccess();
        mainPage.checkBasketSizeEqualTo("0 шт. - 0,00грн.");

    }

//    @Ignore("WIP")
    @Test
    public void loginRemoveFromBucket(){
        new AccountPage().open()
                .login("kb111110101@gmail.com", "")
                .checkCustomerName("Kostiantyn");
        BasketPage basketPage = new MainPage()
                .open()
                .openBasketPage();
        basketPage
                .removeFirstItem()
                .checkThatTextVisible("Ваша корзина пуста!");
    }
}
