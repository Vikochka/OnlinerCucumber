package onliner.pageObject.header;

import framework.elements.Label;
import org.openqa.selenium.By;

public class MainMenu {

    private static final String menu = "//span[contains(@class,'b-main-navigation__text')][contains(text(),'%s')]";

    public void navigatePage(String title) {
        Label mainMenu = new Label(By.xpath(String.format(menu, title)));
        mainMenu.clickAndWait();
    }
}
