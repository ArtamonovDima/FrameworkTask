import org.testng.Assert;
import org.testng.annotations.Test;

public class TestClass extends BaseTest {

    @Test
    public void test1(){
        String iskomuy;

        driver.get("https://www.tinkoff.ru");

        mainPage.clickPayments().clickKommunalniePlatezhi();

        if(kommunalniePlatezhi.getRegionName().equals("Москве")){
            iskomuy = kommunalniePlatezhi.getFirstElementName();
            //System.out.println(iskomuy);
            Assert.assertEquals("ЖКУ-Москва", iskomuy);
            kommunalniePlatezhi.clickZhkuMoskva();
        }else{
            kommunalniePlatezhi.setRegion("Москва");
            iskomuy = kommunalniePlatezhi.getFirstElementName();
            Assert.assertEquals("ЖКУ-Москва", iskomuy);
            kommunalniePlatezhi.clickZhkuMoskva();
        }

        zhkuMoskva.clickOplata();
        String oplataTitle = zhkuMoskvaOplata.getTitle();
        System.out.println(oplataTitle);


        /*zhkuMoskvaOplata.sendCode("123");
        zhkuMoskvaOplata.sendPeriod("00");
        zhkuMoskvaOplata.sendCombination("100000");
        //zhkuMoskvaOplata.clickButton();

        System.out.println(zhkuMoskvaOplata.getErrorCodeMessage());
        Assert.assertEquals("Поле неправильно заполнено", zhkuMoskvaOplata.getErrorCodeMessage());
        System.out.println(zhkuMoskvaOplata.getErrorPeriodMessage());
        Assert.assertEquals("Поле заполнено некорректно", zhkuMoskvaOplata.getErrorPeriodMessage());
        System.out.println(zhkuMoskvaOplata.getErrorCombMessage());
        Assert.assertEquals("Максимум — 15 000 \u20BD", zhkuMoskvaOplata.getErrorCombMessage());*/

        mainPage.clickPayments().inputSearchField(iskomuy);
        Assert.assertEquals("ЖКУ-Москва\n" +
                "Коммунальные платежи", paymentsPage.getFirstElementOfResult().getText() );
        paymentsPage.getFirstElementOfResult().click();

        zhkuMoskva.clickOplata();
        System.out.println(zhkuMoskvaOplata.getTitle());
        //Assert.assertEquals(oplataTitle, zhkuMoskvaOplata.getTitle());

        mainPage.clickPayments().clickKommunalniePlatezhi().setRegion("Санкт-Петербург");
        Assert.assertFalse(kommunalniePlatezhi.searchIskomuy(iskomuy));
    }
}
