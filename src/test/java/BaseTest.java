import PageObjects.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    public WebDriver driver;
    public WebDriverWait wait;
    public MainPage mainPage;
    public PaymentsPage paymentsPage;
    public KommunalniePlatezhi kommunalniePlatezhi;
    public ZhkuMoskva zhkuMoskva;
    public ZhkuMoskvaOplata zhkuMoskvaOplata;

    @BeforeClass
    public void init(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 20);
        mainPage = new MainPage(driver, wait);
        paymentsPage = new PaymentsPage(driver);
        kommunalniePlatezhi = new KommunalniePlatezhi(driver);
        zhkuMoskva = new ZhkuMoskva(driver);
        zhkuMoskvaOplata = new ZhkuMoskvaOplata(driver);
    }

    @AfterClass
    public void tearDown(){
        //if(driver==null){
          //  return;
        //}
        driver.quit();
    }
}
