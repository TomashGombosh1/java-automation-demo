package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import common.PageElement;

public class MainPage extends BasePage {

    private static final PageElement stickyBlock = new PageElement(
            "Menu List",
            By.cssSelector("div[class='header__wrap container container container--xl']"),
            true);
    private static final PageElement plansContainer = new PageElement(
            "Plans Container",
            By.cssSelector("div[class='container']"),
            true);
    private static final PageElement doctorSection = new PageElement(
            "Doctor Section",
            By.cssSelector("section[class='DrQuoteSectionSmall section']"),
            true);
    private static final PageElement howItWorksBlock = new PageElement(
            "How It Works Block",
            By.cssSelector("div[class='HowItWorks noTrustpilot']"),
            true);
    private static final PageElement askClinicianBlock = new PageElement(
            "Ask Clinician Block",
            By.cssSelector("div[class='AskClinician image-earim']"),
            true);
    private static final PageElement readMoreBlock = new PageElement(
            "Read More Block",
            By.cssSelector("div[class='ReadMore section']"),
            true);

    public MainPage(WebDriver driver) {
        super(driver);
    }

    protected WebElement findHairLossPlan() {
    	return find(plansContainer).findElement(By.cssSelector("div[class='HairPlanCard mostEffective'"));
    }
    
    protected boolean isElementActive(By locator) {
    	try {
    		return find(locator).isDisplayed();
    	} catch (NullPointerException | NoSuchElementException e) {
    		return false;
    	}
    }
    
    public String getItemCounter() {
    	return find(By.cssSelector("div[class='cart-btn__counter']")).getText();
    }
    
    @Override
    public boolean pageIsDisplayed() {
        return allRequiredElementDisplayed();
    }
    
    public boolean stickyBlocIskDisplayed() {
    	return find(stickyBlock).isDisplayed();
    }
    
    public boolean miniCartIsDisplayed() {
    	return find(By.cssSelector("div[class='cart active']")).isDisplayed();
    }
    
    public boolean cartButtonIsDisplayed() {
    	return isElementActive(By.cssSelector("div[class='header__cart cart-btn active']"));
    }
    
    public void scrollToHairLossPlan() {
    	scrollToView(findHairLossPlan());
    }
    
    public void scrollToAlternativePlans() {
    	final List<WebElement> alternativePlans = find(plansContainer).findElements(By.cssSelector("div[class='HairPlanCard'"));
    	
    	for (WebElement e : alternativePlans) {
    		scrollToView(e);
    	}
    }
    
    public void scrollToDoctor() {
    	scrollToView(doctorSection);
    }
    
    public void scrollToHowItWorks() {
    	scrollToView(howItWorksBlock);
    }
    
    public void scrollToQuestions() {
    	scrollToView(askClinicianBlock);
    }
    
    public void scrollToHelping() {
    	scrollToView(readMoreBlock);
    }
    
    public void addToCartHairLossPlan() {
    	final WebElement addToCart = findHairLossPlan().findElement(By.cssSelector("button[class='btn']"));
    	try {
    		click(addToCart);
    		waitUntilPageLoad(2); // if tests fail with "The mini-cart should be displayed", try increasing it
    	} catch (WebDriverException e) {
    		final JavascriptExecutor executor = (JavascriptExecutor) driver;
    		executor.executeScript("arguments[0].click()", addToCart);
    	}
    }
    
    public void closeMiniCart() {
    	final WebElement backButton = find(By.id("icon-back"));
    	final Point backPoint = backButton.getLocation();
    	final Actions builder = new Actions(driver);
    	waitUntilPageLoad(); // mini-cart doesn`t close, try increasing it
    	builder.moveByOffset(backPoint.x, backPoint.y).click().build().perform();
    }
}
