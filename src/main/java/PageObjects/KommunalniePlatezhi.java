package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class KommunalniePlatezhi {

    WebDriver driver;
    @FindBy (xpath = "//div[text() = 'ЖКХ']/span/span/span")
    private WebElement region;
    @FindBy (xpath = "//section[@class = 'UILayoutSection__section_32gTj']//li/span/a")
    private WebElement firstElement;
    @FindBy (xpath = "//input [@class = 'Input__valueContent_1Os4v Input__valueContent_alone_2RBHi Input__valueContent_primary_3sxF0']")
    private WebElement searchField;
    @FindBy (xpath = "//input[@class = 'ui-input__field']")
    private WebElement searchRegion;
    @FindBy (xpath = "//div[@class = 'UiRegions__uiRegions__layout_2wFF-']/div")
    private WebElement firstRegionByName;
    @FindBy (xpath = "//section[@class = 'UILayoutSection__section_32gTj']")
    private List<WebElement> webElementList;

    public KommunalniePlatezhi(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    public String getRegionName(){
        return region.getText();
    }

    public KommunalniePlatezhi setRegion(String name){
        region.click();
        searchRegion.sendKeys(name);
        firstRegionByName.click();
        return this;
    }

    public String getFirstElementName(){
        return firstElement.getAttribute("title");
    }

    public ZhkuMoskva clickZhkuMoskva(){
        firstElement.click();
        return new ZhkuMoskva(driver);
    }

    public Boolean searchIskomuy(String iskomuy){

        for (WebElement w : webElementList) {
            if(w.getAttribute("title").equals(iskomuy)){
                return true;
            }
        }
        return false;
    }

}
