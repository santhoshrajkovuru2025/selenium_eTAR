package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PatientPage {

    WebDriver driver;

    public PatientPage(WebDriver driver) {

        this.driver = driver;
    }

    public void enterPatientInformation(String MedicalID, String Patient_Last_Name, String Patient_First_Name, String Patient_DOB) {

        driver.findElement(By.xpath("//input[@name='MedicalID']")).sendKeys(MedicalID);
        WebElement SpecHand = driver.findElement(By.xpath("//select[@name='SpecHand']"));
        Select special = new Select(SpecHand);
        special.selectByValue("94");
        driver.findElement(By.xpath("//input[@name='PatLstNme']")).sendKeys(Patient_Last_Name);
        driver.findElement(By.xpath("//input[@name='PatFrstNme']")).sendKeys(Patient_First_Name);
        driver.findElement(By.xpath("//input[@name='PatDOB']")).sendKeys(Patient_DOB);
        driver.findElement(By.xpath("//input[@name='Gender'][1]")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//input[@type='submit' and @value='Continue']")
        ));

        btn.click();

         //driver.findElement(By.xpath("//input[@type='submit' and @value='Continue']")).click();

    }
}
