package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class SubmissionPage {

    WebDriver driver;
    WebDriverWait wait;

    // Constructor
    public SubmissionPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // 10s explicit wait
    }

    // Check TAR summary
    public void checkTARSummary() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@alt=\"['TAR Summary']\"]"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("button16"))).click();
    }

    // Submit TAR and return TAR number
    public String submitTAR() {

        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//a[contains(@href,'SetAttachmentsInd.htm')]"))).click();

        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//input[@alt='Attachment(s) Submission Option: 2']"))).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.id("submit1"))).click();

        // Wait until the TAR number element is visible
        String TAR = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[text()='TAR # : ']"))).getText();

        String[] splitTAR = TAR.split(":");

        if(splitTAR.length > 1) {
            System.out.println("TCN: " + splitTAR[1].trim());
            return splitTAR[1].trim();
        } else {
            System.out.println("No TAR Found");
            return null;
        }
    }
}
