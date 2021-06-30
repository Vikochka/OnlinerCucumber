package page;

import framework.BasePage;
import framework.elements.Checkbox;
import framework.elements.TextBox;
import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;

public class TVPage extends BasePage {
    private static final String CHECKBOX_XPATH = "//ul[@class='schema-filter__list']//label[contains(@class,'schema-filter__checkbox-item')]//span[contains(@class,'schema-filter__checkbox-text')][text()='%s'] ";
    private TextBox DIAGONAL_FROM = new TextBox(By.xpath("//div[contains(@class,'schema-filter__label')]/..//div[@class='schema-filter-control schema-filter-control_select']//select[contains(@data-bind,'value: facet.value.from')]"));
    private TextBox DIAGONAL_TO = new TextBox(By.xpath("//div[contains(@class,'schema-filter__label')]/..//div[@class='schema-filter-control schema-filter-control_select']//select[contains(@data-bind,'value: facet.value.to')]"));
    private TextBox SELECT_PRICE_TO = new TextBox(By.xpath("//div[contains(@class,'schema-filter__label')]/..//div[@class='schema-filter__facet']//input[contains(@placeholder,'до')]"));
    private static final String TITLE_CHECK_XPATH = "//div[@class='schema-product__title']//span[contains(text(),'%s')]";
    private static final String RESOLUTION_CHECK_XPATH = "//div[@class='schema-product__description']//span[contains(text(),'%s')] ";
    private TextBox CHECK_PRICE_TO = new TextBox(By.xpath("//div[@class='schema-product__group']//div[contains(@class,'schema-product__price')]//span[contains(@data-bind,'format.minPrice')]"));
    private TextBox BLOCK = new TextBox(By.xpath("//div[@id='schema-products']//div[contains(@class,'schema-product__group')]"));
    private TextBox DESCRIPTION = new TextBox(By.xpath("//div[@id='schema-products']//div[contains(@class,'schema-product__group')]//div[@class='schema-product__description']"));
    private static final String HEADER_TITLE = "//h1[contains(@class,'schema-header__title')][contains(text(),'%s')]";
    SoftAssert softAssert;

    public TVPage(String pageTitle) {
        super(By.xpath(String.format(HEADER_TITLE, pageTitle)), pageTitle);

    }

    public void selectManufacturer(String manufacturer) {
        Checkbox manufactorer = new Checkbox(By.xpath(String.format(CHECKBOX_XPATH, manufacturer)));
        manufactorer.click();
        manufactorer.isSelected();
    }

    public void selectResolution(String resolution) {
        Checkbox selectResolution = new Checkbox(By.xpath(String.format(CHECKBOX_XPATH, resolution)));
        selectResolution.moveAndClickByAction();
    }

    public void selectDiagonal(String from, String to) {
        DIAGONAL_FROM.sendKeys(from);
        DIAGONAL_TO.sendKeys(to);
    }

    public void selectPrice(String price) {
        SELECT_PRICE_TO.sendKeys(price);
    }

    public void validationManufacturer(String title) {
        String[] manufacturer;
        TextBox value = new TextBox(By.xpath(String.format(TITLE_CHECK_XPATH, title)));
        value.getText();
        manufacturer = value.split(" ");
        for (int i = 0; i < manufacturer.length; i++) {
            if (manufacturer[i].equals(title)) {
                softAssert.assertTrue(true);
            }
        }
    }

    public void validationResolution(String resolution) {
        String[] description;
        TextBox validationResolution = new TextBox(By.xpath(String.format(RESOLUTION_CHECK_XPATH, resolution)));
        validationResolution.getText();
        description = validationResolution.split(" ");
        for (int i = 0; i < description.length; i++) {
            if (description[i].equals(resolution)) {
                softAssert.assertTrue(true);
            }
        }
    }

    public void validationDiagonal(String diagonalFrom, String diagonalTo) {
        BLOCK.waitForElementsArePresent();
        DESCRIPTION.getText();
        for (int i = 1; i <= BLOCK.size(); i++) {
            String[] description;
            description = DESCRIPTION.split("\"");
            int intDiagonalFrom = Integer.parseInt(diagonalFrom);
            int intDiagonalTo = Integer.parseInt(diagonalTo);
            for (int j = 0; j < description.length; j++) {
                double convert = Double.parseDouble(description[0]);
                if (convert >= intDiagonalFrom && convert <= intDiagonalTo) {
                    softAssert.assertTrue(true);
                }
            }
        }
    }

    public void validationPrice(String priceTo) {
        BLOCK.waitForElementsArePresent();
        CHECK_PRICE_TO.getText();
        for (int i = 1; i <= BLOCK.size(); i++) {
            String[] price;
            price = CHECK_PRICE_TO.split(",");
            for (int j = 0; j < price.length; j++) {
                double convert = Double.parseDouble(price[0]);
                int intPriceTo = Integer.parseInt(priceTo);
                if (convert < intPriceTo) ;
                softAssert.assertTrue(true);
            }
        }
    }
}
