package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DemoTest extends BaseTest {
    
    @Test(description = "Check first test case")
    public void firstTest() {
    	Assert.assertTrue(mainPage.pageIsDisplayed(), "Main page should be displayed");
     	mainPage.scrollToHairLossPlan();
     	mainPage.scrollToAlternativePlans();
    	mainPage.scrollToDoctor();
    	mainPage.scrollToHowItWorks();
     	mainPage.scrollToQuestions();
    	mainPage.scrollToHelping();
     	Assert.assertTrue(mainPage.stickyBlocIskDisplayed(), "Sticky block should be displayed");
    }
    
    @Test(description = "Check second test case")
    public void secondTest() {
    	mainPage.scrollToHairLossPlan();
     	mainPage.addToCartHairLossPlan();
    	mainPage.closeMiniCart();
     	Assert.assertTrue(mainPage.getItemCounter().equals("1"), "The item counter should be equal to 1");
     	Assert.assertTrue(mainPage.cartButtonIsDisplayed(), "The cart button should be displayed");
    }
    
    @Test(description = "Check third test case")
    public void thirdTest() {
    	mainPage.scrollToHairLossPlan();
        mainPage.addToCartHairLossPlan();
        Assert.assertTrue(mainPage.miniCartIsDisplayed(), "The mini-cart should be displayed");
        Assert.assertTrue(mainPage.getItemCounter().equals("1"), "The item should be n one copy");
    }

}
