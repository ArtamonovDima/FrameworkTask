package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ZhkuMoskva {

    WebDriver driver;

    @FindBy (xpath = "//span[text() = 'Оплатить ЖКУ в Москве']")
    private WebElement oplata;

    public ZhkuMoskva(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    public ZhkuMoskvaOplata clickOplata(){
        oplata.click();
        return new ZhkuMoskvaOplata(driver);
    }

}
