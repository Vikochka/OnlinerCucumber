package page;

import lombok.Getter;
import org.openqa.selenium.By;

@Getter
public class MainPage extends BaseOnlinerPage {
    private static String pageLocator = "//div[@class='b-top-logo']";

    public MainPage() {
        super(By.xpath(pageLocator), "Main page");
    }
}