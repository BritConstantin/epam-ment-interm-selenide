
import com.codeborne.selenide.junit.TextReport;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;

public class MainTest {
    public static void main(String[] args) {

    }
    @Rule
    public TextReport report = new TextReport();

    @Before
    public void setUp() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));
    }

    @Test
    public void userCanSearchAnyKeyword() {
        open("https://duckduckgo.com/");
        $(By.name("q")).val("selenide").pressEnter();
        $$(".js-results").shouldHave(size(1));
        $$(".js-results").shouldHave(size(1));
        $$(".js-results").shouldHave(size(1));
//        $$(".js-results .result").shouldHave(sizeGreaterThan(5));
//        $(".js-results .result").shouldHave(text("selenide.org"));
    }
}
