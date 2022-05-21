import Pages.BasketPage;
import Pages.MainPage;
import com.codeborne.selenide.junit.ScreenShooter;
import com.codeborne.selenide.junit.TextReport;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.*;

import static com.codeborne.selenide.Selenide.closeWebDriver;
public class AnonymousTest {
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
    public void anonAddToBucket(){
        new MainPage()
                .open()
                .checkBasketSizeEqualTo("0 шт. - 0,00грн.")
                .addRandomItemToBasket()
                .checkBasketSizeEqualTo("1 шт. - 17850,00грн.")
                .addRandomItemToBasket()
                .checkBasketSizeEqualTo("2 шт. - 35700,00грн.");
        new BasketPage()
                .openBasketPage()
                .removeFirstItem();
    }
    @Test
    public void anonRemoveFromBucket(){
        BasketPage basketPage = new MainPage()
                .open()
                .checkBasketSizeEqualTo("0 шт. - 0,00грн.")
                .addRandomItemToBasket()
                .checkBasketSizeEqualTo("1 шт. - 17850,00грн.")
                .openBasketPage();
        basketPage
                .removeFirstItem()
                .checkThatTextVisible("Ваша корзина пуста!");
    }

}
