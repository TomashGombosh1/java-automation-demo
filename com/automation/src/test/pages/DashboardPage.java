package pages;

import common.PageElement;
import common.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class DashboardPage extends BasePage {
	private static final PageElement headerLabel = new PageElement(
			"Header Label",
			By.cssSelector("h6.MuiTypography-root"),
			true);
    private static final PageElement searchFld = new PageElement(
            "Search Field",
            By.cssSelector("input[role='combobox']"),
            false);
    private static final PageElement currentCompanies = new PageElement(
            "Current companies Drop Down",
            By.cssSelector("div.peek-carousel>ul>li:nth-child(3)"),
            false);
    private static final PageElement applyButton = new PageElement(
            "Apply filter button",
            By.cssSelector("div#current-companies-facet-values .ember-view .ember-view:nth-child(3) button:nth-child(2)"),
            false);
    private static final PageElement resultsField = new PageElement(
            "Showing results field",
            By.cssSelector("h3.search-results__total"),
            false);
    private static final PageElement nextButton = new PageElement(
            "Next button",
            By.cssSelector("div[role='main']>div>div>div:nth-child(3) button:nth-child(3)"));

    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean pageIsDisplayed() {
        return allRequiredElementDisplayed();
    }

    public void searchEmployee() {
        waitToBePresent(searchFld);
        click(searchFld);
        enterText(searchFld, "google");
        pressEnter(searchFld);
    }

    public void collectData() {
        Utils.sleep(4000);
        collect();
    }

    private void collect() {
        PageElement name = new PageElement("Name of employee", By.cssSelector("ul.search-results__list li:nth-child(1) div:nth-child(2) [data-control-name='search_srp_result']"));
        PageElement position = new PageElement("Position of employee", By.cssSelector("ul.search-results__list li:nth-child(1) div:nth-child(2)  p:nth-child(2)"));
        PageElement country = new PageElement("Country of employee", By.cssSelector("ul.search-results__list li:nth-child(1) div:nth-child(2)  p:nth-child(3)"));
        scrollToView(name);
        log.info(getText(name));
        log.info(getText(position));
        log.info(getText(country));
    }

}
