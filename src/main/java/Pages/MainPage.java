package Pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.impl.Waiter;
import org.openqa.selenium.By;

import java.time.Duration;
import java.util.logging.Logger;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class MainPage extends CorePage {
    private String pageURL = "http://stels.kharkov.ua/";
    private String personalOfficeText = "Личный Кабинет";
    private String bucketSizeCss = "#cart_total";
    private String firstBuyButtonCss = ".box-product :first-child>div.cart";


    public MainPage open() {
        Selenide.open(pageURL);
        return this;
    }

    public AccountPage clickLogin() {
        $(byText(personalOfficeText)).click();
        return page(AccountPage.class);
    }


    public MainPage checkBasketSizeEqualTo(String expectedSize) {
        SelenideElement element = $(By.cssSelector(bucketSizeCss));
        element.shouldHave(Condition.text(expectedSize), Duration.ofSeconds(10));

//
//        String actualText = $(By.cssSelector(bucketSizeCss)).getText();
//        Assert.assertEquals(
//                String.format("Size should be equal! \nexpected='%s'\nactual='%s'",expectedSize, actualText)
//                ,expectedSize
//                ,actualText);
        return this;
    }

    public MainPage addRandomItemToBasket() {
        $(By.cssSelector(firstBuyButtonCss)).click();
        return this;
    }


}
