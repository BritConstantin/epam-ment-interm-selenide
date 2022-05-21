package Pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class CorePage {
    private String mainPageTextSel = "Главная";
    private String basketText = "Корзина";
    public MainPage goToMainPage() {
        $(byText(mainPageTextSel)).click();
        return Selenide.page(MainPage.class);
    }
    public BasketPage openBasketPage() {
        $(byText(basketText)).click();
        return  page(BasketPage.class);
    }

    public void checkThatTextVisible(String s) {
        $(byText(s)).shouldBe(Condition.visible);
    }
}
