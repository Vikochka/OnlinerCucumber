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

    public void navigationList(String listTitle, String listDropdown) {
        int i = 0;
        int count = 0;
        StringBuilder stringBuilder = new StringBuilder(listTitle);
        while( i < stringBuilder.length() ){
            if( stringBuilder.charAt(i) == ' ' ) {
                count++;
            }
            i++;
        }

        if (count > 1) {
            int index = stringBuilder.lastIndexOf(" ");
            StringBuilder convert = stringBuilder.replace(index, index + 1, "\u00a0");
            Button btnNavigateList = new Button(By.xpath(String.format(btnMenuListSection, convert)));
            btnNavigateList.click();
        } else {
            Button btnNavigateList = new Button(By.xpath(String.format(btnMenuListSection, listTitle)));
            btnNavigateList.click();
        }

        Label lblNavigateSection = new Label(By.xpath(String.format(btnDropMenuSection, listDropdown)));
        lblNavigateSection.click();
    }

    public void isCatalogList() {
        btnMainMenuSection.waitForIsElementPresent();
    }
}
