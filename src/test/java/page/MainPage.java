package page;

import lombok.Getter;
import org.openqa.selenium.By;

@Getter
public class MainPage extends BaseOnlinerPage {
    private static String pageLocator = "[//a[@class='footer-3-links all-news-link']";

    public MainPage() {
        super(By.xpath(pageLocator), "Main page");
    }
}