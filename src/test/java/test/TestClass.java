package test;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.util.List;

public class TestClass extends  Base {
    WebDriver driver;
    String name,price;
    public By txtboxSearch,signIn,tickbox,product,logo,tensp,gia,txtboxSearchama,signInama,producta,tenspa,giaa;
    String expect="Iphone 11";

    public void useField() {
        signIn=By.xpath("//*[@id=\"gh-btn\"]");
        signInama=By.xpath("//*[@id=\"nav-search-submit-button\"]");
        txtboxSearch = By.xpath("//*[@id=\"gh-ac\"]");
        tickbox=By.xpath("//*[@id=\"x-refine__group_1__0\"]/ul/li[1]/div/a/div/div/span[1]");
        txtboxSearchama=By.xpath("//*[@id=\"twotabsearchtextbox\"]");
        product=By.xpath("//*[@id=\"srp-river-results\"]/ul/li");
        //*[@id="srp-river-results"]/ul/li
        logo=By.xpath("//*[@id=\"gh-la\"]");
        tensp=By.xpath("//*[@id=\"srp-river-results\"]/ul/li/div/div[2]/a/h3");
        gia=By.xpath("//*[@id=\"srp-river-results\"]/ul/li/div/div[2]/div[4]/div[1]/span");
        producta=By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div");
        tenspa=By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[3]/div[2]/div/div/span/div/div/div[2]/div[2]/div/div/div[1]/h2/a/span");
        giaa=By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[3]/div[2]/div/div/span/div/div/div[2]/div[2]/div/div/div[3]/div[1]/div/div[1]/div");
    }


    @Test
    public void Task() {
        useField();
        implicitWait(driver, 10);
        sendKey(driver, txtboxSearch, expect);
        click(driver, signIn);
        click(driver, tickbox);
        String title=driver.getTitle();
        title=title.substring(11);
        String url=driver.getCurrentUrl();
        List<WebElement> we = driver.findElements(tensp);
        List<WebElement> we1 = driver.findElements(gia);
        System.out.println(title);
        System.out.println(url);
        for (WebElement webElement : we ) {
                String ten = webElement.getText();
                System.out.println(ten );
            }
        for (WebElement webElement1 : we1 ) {
            String gia = webElement1.getText();
            System.out.println(gia );
        }

        driver.get("https://www.amazon.com/");
        sendKey(driver, txtboxSearchama, expect);
        click(driver,signInama);

        List<WebElement> we3 = driver.findElements(tenspa);
        List<WebElement> we4 = driver.findElements(giaa);
        System.out.println("====================== Product of Amazon ======================");
        for (WebElement webElement : we3 ) {
            String ten = webElement.getText();
            System.out.println(ten );
        }
        for (WebElement webElement1 : we4 ) {
            String gia = webElement1.getText();
            System.out.println(gia );
        }
    }

    @BeforeMethod
    public void beforeMethod() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\admin\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.ebay.com/");

        driver.manage().window().maximize();

    }

    @AfterMethod
    public void afterMethod() {
        driver.close();
    }
}
