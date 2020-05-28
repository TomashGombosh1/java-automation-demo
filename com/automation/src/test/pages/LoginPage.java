package pages;

import common.PageElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private static final PageElement userNameFld = new PageElement(
            "User Name Field",
            By.id("user"),
            true);
    private static final PageElement passwordFld = new PageElement(
            "Password Field",
            By.id("pass"),
            true);
    private static final PageElement signInBtn = new PageElement(
            "Sign In Button",
            By.cssSelector("button[class='MuiButtonBase-root MuiButton-root MuiButton-outlined MuiButton-outlinedPrimary']"),
            true);

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean pageIsDisplayed() {
        return allRequiredElementDisplayed();
    }

    public void login(String username, String password){
        waitToBeVisible(userNameFld);
        enterText(userNameFld, username);
        enterText(passwordFld, password);
        click(signInBtn);
    }
}
