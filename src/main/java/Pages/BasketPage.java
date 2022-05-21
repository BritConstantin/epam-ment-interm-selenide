package Pages;

import Pages.CorePage;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class BasketPage extends CorePage {
    private String pageURL = "http://stels.kharkov.ua/index.php?route=checkout/cart";
    private String removeCheckBoxCss = ".remove>input";
    private String appyText = "Применить";

    public BasketPage removeFirstItem() {
        SelenideElement checkBox = $(By.cssSelector(removeCheckBoxCss));
        checkBox.shouldNotBe(Condition.checked);
        checkBox.click();
        checkBox.shouldBe(Condition.checked);
        $(byText(appyText)).click();
        return this;
    }

}
