package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ZhkuMoskvaOplata {

    WebDriver driver;

    @FindBy (xpath = "//input[@name = 'provider-payerCode']")
    private WebElement codeField;
    @FindBy (xpath = "//input[@name = 'provider-period']")
    private WebElement periodField;
    @FindBy (xpath = "//form[@class = 'ui-form']/div[4]//input")
    private WebElement combinationField;

    @FindBy (xpath = "//div[@class = 'ui-form__row ui-form__row_text ui-form__row_default-error-view-visible']/div/div[2]")
    private WebElement codeFieldErrorMessage;
    @FindBy (xpath = "//div[@class = 'ui-form__row ui-form__row_date ui-form__row_default-error-view-visible']/div/div[2]")
    private WebElement periodFieldErrorMessage;
    @FindBy (xpath = "//div[@class = 'ui-form__row ui-form__row_amount ui-form__row_default-error-view-visible']/div/div[2]")
    private WebElement combinationFieldErrorMessage;

    @FindBy (xpath = "//button/h2[text() = 'Оплатить ЖКУ в Москве']")
    private WebElement button;

    public ZhkuMoskvaOplata(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    public void sendCode(String code){
        codeField.sendKeys(code);
    }

    public void sendPeriod(String period){
        periodField.sendKeys(period);
    }

    public void sendCombination(String comb){
        combinationField.sendKeys(comb);
    }

    public String getErrorCodeMessage(){
        return codeFieldErrorMessage.getText();
    }

    public String getErrorPeriodMessage(){
        return periodFieldErrorMessage.getText();
    }

    public String getErrorCombMessage(){
        return combinationFieldErrorMessage.getText();
    }

    public String getTitle(){
        return driver.getTitle();
    }

    public void clickButton(){
        button.click();
    }
}
