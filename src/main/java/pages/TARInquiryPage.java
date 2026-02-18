package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class TARInquiryPage {

    WebDriver driver;
    WebDriverWait wait;

    // Constructor
    public TARInquiryPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // 10s explicit wait
    }

    // TAR inquiry method
    public void TARInquiry(String tarNumber) {

        // Click TAR Menu
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@alt='[TAR Menu]']"))).click();

        // Click Inquire on a TAR
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Inquire on a TAR']"))).click();

        // Enter TAR number
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("TarNum"))).sendKeys(tarNumber);

        // Click Submit
        wait.until(ExpectedConditions.elementToBeClickable(By.name("Submit"))).click();

        // Handle alert if present
        try {
            wait.until(ExpectedConditions.alertIsPresent());
            driver.switchTo().alert().accept();
        } catch (Exception e) {
            System.out.println("No alert present");
        }

        // Click on TCN cell
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[@headers='TCN']"))).click();

        // Scroll the page safely
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, -500);");
        js.executeScript("window.scrollBy(0, 500);");
    }
}
