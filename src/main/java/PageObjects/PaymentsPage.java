package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PaymentsPage {

    WebDriver driver;

    @FindBy (xpath = "//span[text() = 'ЖКХ']")
    private WebElement kommunalniePlatezhi;
    @FindBy (xpath = "//input[@class = 'Input__valueContent_1Os4v Input__valueContent_alone_2RBHi Input__valueContent_primary_3sxF0']")
    private WebElement searchField;
    @FindBy (xpath = "//div[@class = 'Grid__column_3qcJA Grid__column_size_12_2AOcu Grid__column_sizeMobile_12_1mA7y']")
    private List<WebElement> webElementList;

    public PaymentsPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    public KommunalniePlatezhi clickKommunalniePlatezhi(){
        kommunalniePlatezhi.click();
        return new KommunalniePlatezhi(driver);
    }

    public void inputSearchField(String name){
        searchField.sendKeys(name);
    }

    public WebElement getFirstElementOfResult(){
        return webElementList.get(0);
    }

}
