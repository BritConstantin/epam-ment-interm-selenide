package Pages;

import com.codeborne.selenide.Selenide;
import org.junit.Assert;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.WebDriverRunner.url;

public class AccountPage extends CorePage {
    private String pageLogoutURL = "http://stels.kharkov.ua/index.php?route=account/login";
    private String pageAccountURL = "http://stels.kharkov.ua/index.php?route=account/account";
    private String loginInputName ="email";
    private String passwordInputName = "password";
    private String submitButtonCss = "form>div>a.button";
    private String userNameCss = "#welcome :first-child";
    private String logoutButtonCss = "#welcome :nth-child(3)";
    private String userNameLogout = "Выйти";

    public AccountPage open() {
        Selenide.open(pageLogoutURL);
        return this;
    }

    public AccountPage login(String log, String pas) {
        $(By.name(loginInputName)).setValue(log);
        $(By.name(passwordInputName)).setValue(pas);
        $(By.cssSelector(submitButtonCss)).click();
        Assert.assertEquals("URL should be same",pageAccountURL,url());
        return this;
    }
    public AccountPage checkCustomerName(String userName) {
        $(By.cssSelector(userNameCss)).shouldHave(text(userName));
        return this;
    }

    public AccountPage logout() {
        return this;
    }

    public AccountPage checkLogoutSuccess() {
        $(By.cssSelector(logoutButtonCss)).shouldHave(text(userNameLogout)).click();
        return this;
    }

}
