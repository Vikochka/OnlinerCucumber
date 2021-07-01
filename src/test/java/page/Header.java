package page;

import framework.elements.Label;
import org.openqa.selenium.By;

public class Header {

    private static final String MainMenu = "//span[contains(@class,'b-main-navigation__text')][contains(text(),'%s')]";

    public void navigatePage(String title) {
        Label mainMenu = new Label(By.xpath(String.format(MainMenu, title)));
        mainMenu.clickAndWait();
    }
}
