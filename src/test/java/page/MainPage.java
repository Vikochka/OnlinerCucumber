package page;

import framework.BasePage;
import framework.elements.Label;
import org.openqa.selenium.By;

public class MainPage extends BasePage {
    public static final String MainMenu ="//span[contains(@class,'b-main-navigation__text')][contains(text(),'%s')]";
    private static String MAIN_LABEL = "//a[@class='footer-3-links all-news-link']";

    public MainPage() {
        super(By.xpath(MAIN_LABEL), "Main page");
    }

    public void navigatePage(String title) {
        Label mainMenu = new Label(By.xpath(String.format(MainMenu,title)));
        mainMenu.clickAndWait();
    }
}