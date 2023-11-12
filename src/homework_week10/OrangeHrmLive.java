package homework_week10;

/** Project-2 - ProjectName : com-orangehrmlive
 BaseUrl = https://opensource-demo.orangehrmlive.com/
 1. Setup chrome browser.
 2. Open URL.
 3. Print the title of the page.
 4. Print the current url.
 5. Print the page source.
 6. Click on ‘Forgot your password?’ link.
 7. Print the current url.
 8. Navigate back to the login page.
 9. Refresh the page.
 10. Enter the email to email field.
 11. Enter the password to password field.
 12. Click on Login Button.
 13. Close the browser.
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class OrangeHrmLive
{
        static String baseUrl = "https://opensource-demo.orangehrmlive.com/";                  //GV's declared
    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException
    {
        System.setProperty("webdriver.chrome.driver" , "chromedriver.exe");
        driver = new ChromeDriver();                                                 //Launch the empty browser
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));          //implicitly wait to driver
        driver.manage().window().maximize();                                       //maximize windows
        driver.get(baseUrl);                                                      //Open url
        Thread.sleep(4000);

        String title = driver.getTitle();
        System.out.println("Title of the page is : " + title);
        String currentUrl = driver.getCurrentUrl();
        System.out.println("Current Url is: " +currentUrl );
        String pageSource = driver.getPageSource();
        System.out.println("Page Source is : " +pageSource);
        Thread.sleep(10000);

        WebElement forgotYourPwdLink = driver.findElement(By.xpath("//div[@class='orangehrm-login-forgot']")); //Find, Locate
        forgotYourPwdLink.click();                                                                                          //Action
        Thread.sleep(4000);

        String currentUrl1 = driver.getCurrentUrl();
        System.out.println( "Current Url of Forgot Your Password Link is : " +currentUrl1 );

        driver.navigate().back();                                                  //navigate back to the login page
        driver.navigate().refresh();                                              //refresh the page
        Thread.sleep(4000);

        WebElement username = driver.findElement(By.name("username"));          //Find, locate by name locator
        username.sendKeys("Admin");
        Thread.sleep(4000);

        WebElement pwd = driver.findElement(By.name("password"));              //Find, locate by name locator
        pwd.sendKeys("admin123");                                 //Action
        Thread.sleep(4000);

        WebElement loginLink = driver.findElement(By.xpath("//button[@type ='submit']"));
        loginLink.click();
        Thread.sleep(4000);

        driver.quit();                                                     //Close the browser
    }
}
