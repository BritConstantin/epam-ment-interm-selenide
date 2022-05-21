import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.junit.ScreenShooter;
import com.codeborne.selenide.junit.TextReport;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SkyUpTest {
    @Rule
    public TextReport report = new TextReport();
    @Rule
    public ScreenShooter makeScreenshotOnFailure = ScreenShooter.failedTests();

    @BeforeClass
    public static void setUp() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));
    }

    @After
    public void after() {
        closeWebDriver();
    }

    @Test
    public void getTicketsTest() {
        String log = "kb111110101@gmail.com";
        String pas = "";

        open("https://skyup.aero/en/");
        $(By.cssSelector("#open-appeal-modal>div>div.modal__content>button.modal__close")).click();
        $(By.cssSelector(".header__login")).click();
        $(".btn-4").click();
        $("#logInEmail").setValue(log);
        $(By.xpath("//input[@type='password']")).setValue(pas);
        $("#logInBtn").click();
    }
}
