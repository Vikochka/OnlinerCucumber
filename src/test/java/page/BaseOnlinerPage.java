package page;

import framework.BasePage;
import lombok.Getter;
import org.openqa.selenium.By;

@Getter
public class BaseOnlinerPage extends BasePage {
    private final Header header = new Header();

    public BaseOnlinerPage(By locator, String pageTitle) {
        super(locator, pageTitle);
    }

}
