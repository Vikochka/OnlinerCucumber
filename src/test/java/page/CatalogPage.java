package page;

import framework.elements.Button;
import framework.elements.Label;
import org.openqa.selenium.By;

public class CatalogPage extends BaseOnlinerPage {

    private static final String pageLocator = "//h1[contains(@class,'catalog-navigation__title')][contains(text(),'%s')]";
    private static final String lblMainMenuNavigation = "//span[contains(@class,'catalog-navigation-classifier__item-title-wrapper')][contains(text(),'%s')]";
    private static final String btnMenuListSection = "//div[contains(@class,'catalog-navigation-list__aside-title')][contains(text(),'%s')]";
    private static final String btnDropMenuSection = "//a[contains(@class,'catalog-navigation-list__dropdown-item')]//span[contains(text(),'%s')]";

    private Button btnMainMenuSection = new Button(By.xpath("//div[@data-id='1']//div[contains(@class,'catalog-navigation-list__aside-list')]"));

    public CatalogPage(String pageTitle) {
        super(By.xpath(String.format(pageLocator, pageTitle)), "Catalog page");
    }

    public void catalogNavigation(String catalogNavigation) {
        Label lblCatalog = new Label(By.xpath(String.format(lblMainMenuNavigation, catalogNavigation)));
        lblCatalog.click();
    }

    public void navigatioList(String listTitle, String listDropdown) {
        Button btnNavigateList = new Button(By.xpath(String.format(btnMenuListSection, listTitle)));
        btnNavigateList.click();
        Label lblNavigateSection = new Label(By.xpath(String.format(btnDropMenuSection, listDropdown)));
        lblNavigateSection.click();
    }

    public void isCatalogList() {
        btnMainMenuSection.waitForIsElementPresent();
    }
}
