import org.apache.log4j.BasicConfigurator;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;


import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class Registration {
    @Test
    public void Required(){
        BasicConfigurator.configure();
        //System.setProperty("webdriver.chrome.driver","d:\\BARS_BIB_1.8\\TeachMeSkills\\chromedriver.exe");
        open("https://www.sharelane.com/cgi-bin/register.py?page=1&zip_code=11111");
        $(By.name("first_name")).sendKeys("Timoxa");
        $(By.name("email")).sendKeys("timoxa@tut.by");
        $(By.name("password1")).sendKeys("12345678");
        $(By.name("password2")).sendKeys("12345678");
        $("[value=Register]").click();
        String result = $(By.className("confirmation_message")).getText();
        Assert.assertEquals(result,"Account is created!");
    }
}