package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginPage {

    WebDriver driver;
    WebDriverWait wait;

    // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void loginToeTAR(String UserName, String OwnerNum, String Email) throws InterruptedException {

        driver.get("https://silsr.softsol.com:6118/ProviderPortalSimulator?handler=login");
        driver.findElement(By.id("pname")).sendKeys(UserName);
        driver.findElement(By.id("oname")).sendKeys(OwnerNum);
        Thread.sleep(1000);  // This line can throw InterruptedException
        driver.findElement(By.name("EmailId")).sendKeys(Email);
        Select envDropdown = new Select(driver.findElement(By.id("Environment")));
        envDropdown.selectByValue("DEV");

        driver.findElement(By.id("txt_ShowUrl")).click();
        driver.findElement(By.id("LinkMedicalServices")).click();
    }
}


















        /*driver.get("http://sysdev.softsol.com/");
        driver.findElement(By.xpath("//input[@value='Login']")).click();
        driver.findElement(By.xpath("//a[@id='MedicalService']")).click();
        driver.findElement(By.xpath("//a[normalize-space()='Create a New TAR']")).click();*/



