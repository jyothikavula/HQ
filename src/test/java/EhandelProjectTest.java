import io.github.bonigarcia.wdm.WebDriverManager;
import io.qase.api.annotation.QaseTitle;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;




public class EhandelProjectTest {
    WebDriver driver;
    @BeforeClass
    public void init (){
        WebDriverManager.chromedriver().setup();
    }
    @BeforeMethod
    public void  setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://ecommerce-playground.lambdatest.io/");



    }
    @Test
    @QaseTitle("Register")
    public void register ()throws InterruptedException {
        driver.findElement(By.linkText("My account")).click();
        driver.findElement(By.linkText("Register")).click();
        driver.findElement(By.id("input-firstname")).sendKeys("rama");
        driver.findElement(By.id("input-lastname")).sendKeys("seetha");
        driver.findElement(By.id("input-email")).sendKeys("rama.seetha@gmail.com");
        driver.findElement(By.id("input-telephone")).sendKeys("9999999911");
        driver.findElement(By.id("input-password")).sendKeys("rama5see");
        driver.findElement(By.id("input-confirm")).sendKeys("rama5see");
        driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/div/label")).click();
      //  driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input")).click();
        driver.findElement(By.xpath("//input[@type='submit']")).click();


     //   Actions actions = new Actions(driver);
    //    actions.moveToElement(driver.findElement(By.linkText("My account"))).perform();

     //   driver.findElement(By.xpath("//*[@id=\"column-right\"]/div/a[2]")).click();

    }
    @Test
    @QaseTitle("login")
    public void login() throws InterruptedException {
        driver.findElement(By.linkText("My account")).click();
       driver.findElement(By.id("input-email")).sendKeys("rama.seetha@gmail.com");
       driver.findElement(By.id("input-password")).sendKeys("rama5see");
       driver.findElement(By.xpath("//input[@type ='submit']")).click();

    }

        @Test
        @QaseTitle("logout")
                public void logout() throws InterruptedException{
            login();
            driver.findElement(By.linkText("Logout")).click();

        }
        @Test
        @QaseTitle("buy product")
        public void buySony_VAIO(){
        driver.findElement(By.xpath("//input[@name='search']")).sendKeys("sony VAIO");
        driver.findElement(By.xpath("//button [@type='submit' and text() ='Search']")).click();
        driver.findElement(By.xpath("//*[@id=\"mz-product-grid-image-46-212469\"]/div/div[1]/img")).click();

    }



    @AfterClass
    public void quit() throws InterruptedException {
        Thread.sleep(200);
        driver.quit();

    }
}
