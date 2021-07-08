package onliner.pageObject.page;

import framework.BasePage;
import lombok.Getter;
import onliner.pageObject.header.MainMenu;
import org.openqa.selenium.By;

@Getter
public class BaseOnlinerPage extends BasePage {
    private final MainMenu mainMenu = new MainMenu();

    public BaseOnlinerPage(By locator, String pageTitle) {
        super(locator, pageTitle);
    }

}
