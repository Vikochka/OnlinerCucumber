package page;

import framework.BasePage;
import framework.elements.Button;
import framework.elements.Label;
import org.openqa.selenium.By;

public class CatalogPage extends BasePage {
    private static final String CATALOG_NAVIGATION = "//span[contains(@class,'catalog-navigation-classifier__item-title-wrapper')][contains(text(),'%s')]"; //электрика
    private Button CATALOG_LIST =new Button(By.xpath("//div[@data-id='1']//div[contains(@class,'catalog-navigation-list__aside-list')]"));
    private static final String LIST_TITLE_XPATH = "//a[@class='catalog-navigation-list__dropdown-item']/ancestor::div[@class='catalog-navigation-list__aside-item']/div[@class='catalog-navigation-list__aside-title'][contains(text(),'%s')]";
    public static final String LIST_DROPDOWN_XPATH = "//a[contains(@class,'catalog-navigation-list__dropdown-item')]//span[contains(text(),'%s')]";
    public static final String WAIT_FOR_IS_PAGE_OPEN = "//h1[contains(@class,'catalog-navigation__title')][contains(text(),'%s')]";

    public CatalogPage( String pageTitle) {
        super(By.xpath(String.format(WAIT_FOR_IS_PAGE_OPEN,pageTitle)), pageTitle);
    }

    public void catalogNavigation(String catalogNavigation) {
        Label catalog =new Label(By.xpath(String.format(CATALOG_NAVIGATION,catalogNavigation)));
        catalog.click();
    }

    public void listTitle(String listTitle, String listDropdown) {
        Button navigateList =new Button(By.xpath(String.format(LIST_TITLE_XPATH,listTitle)));
        navigateList.click();
        Label navigateSection = new Label(By.xpath(String.format(LIST_DROPDOWN_XPATH, listDropdown)));
        navigateSection.click();
    }

    public void isCatalogList() {
        CATALOG_LIST.waitForIsElementPresent();
    }
}
