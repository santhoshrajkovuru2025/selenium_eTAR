package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class ServicePage {

    WebDriver driver;
    WebDriverWait wait;

    public ServicePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void addServiceInformation(String Service_Code, String Total_Units, String From_Date, String Thru_Date, String Admit_Date, String Discharge_Date, String ICD_Code) {


            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Hospital Days']"))).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("ServiceCode"))).sendKeys(Service_Code);
            driver.findElement(By.name("TotUnitsReq")).sendKeys(Total_Units);

            driver.findElement(By.name("FromDate")).clear();
            driver.findElement(By.name("FromDate")).sendKeys(From_Date);

            driver.findElement(By.name("ThruDate")).clear();
            driver.findElement(By.name("ThruDate")).sendKeys(Thru_Date);

            driver.findElement(By.name("AdmitDate")).clear();
            driver.findElement(By.name("AdmitDate")).sendKeys(Admit_Date);

            driver.findElement(By.name("DischDate")).clear();
            driver.findElement(By.name("DischDate")).sendKeys(Discharge_Date);

            Select icd_code = new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("Serv_ICDCodeType"))));
            icd_code.selectByIndex(1);

            driver.findElement(By.name("Serv_ICD9_1")).sendKeys(ICD_Code);

            wait.until(ExpectedConditions.elementToBeClickable(By.name("Submit"))).click();
    }
}
