package PageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class MainPage {

    WebDriver driver;
    WebDriverWait wait;

    @FindBy (xpath = "//a[text() = 'Платежи']")
    private WebElement payments;
    @FindBy (xpath = "//a[text() = 'Платежи']")
    private WebElement footerPayments;


    public MainPage(WebDriver driver, WebDriverWait wait){
        this.driver=driver;
        this.wait=wait;
        PageFactory.initElements(driver, this);
    }

    public PaymentsPage clickPayments(){
        wait.until(ExpectedConditions.visibilityOf(payments)).click();
        return new PaymentsPage(driver);
    }

    public PaymentsPage clickFooterPayments(){
        footerPayments.click();
        return new PaymentsPage(driver);
    }

}
