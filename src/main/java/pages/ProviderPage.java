package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProviderPage {
    WebDriver driver;

    public ProviderPage(WebDriver driver) {

        this.driver = driver;
    }

    public void enterProviderInformation(String Fax_Area_Code, String Fax_Prefix_Code, String Fax_Suffix_Code, String Completed_By, String Provider_Contact_Name, String Phone_Area_Code, String Phone_Prefix_Code, String Phone_Suffix_Code, String Phone_Extension) {

        driver.findElement(By.xpath("//a[normalize-space()='Create a New TAR']")).click();
        driver.findElement(By.xpath("//tbody/tr[2]/td[1]/span[1]/a[1]")).click();
        driver.findElement(By.xpath("//input[@name='ProvFax_area']")).sendKeys(Fax_Area_Code);
        driver.findElement(By.xpath("//input[@name='ProvFax_pre']")).sendKeys(Fax_Prefix_Code);
        driver.findElement(By.xpath("//input[@name='ProvFax_sufx']")).sendKeys(Fax_Suffix_Code);
        driver.findElement(By.xpath("//input[@name='txtTARCompBy']")).sendKeys(Completed_By);
        driver.findElement(By.xpath("//input[@name='txtProvContNme']")).sendKeys(Provider_Contact_Name);
        driver.findElement(By.xpath("//input[@name='ContPhne_area']")).sendKeys(Phone_Area_Code);
        driver.findElement(By.xpath("//input[@name='ContPhne_pre']")).sendKeys(Phone_Prefix_Code);
        driver.findElement(By.xpath("//input[@name='ContPhne_sufx']")).sendKeys(Phone_Suffix_Code);
        driver.findElement(By.xpath("//input[@name='ContPhne_ext']")).sendKeys(Phone_Extension);
        driver.findElement(By.xpath("//input[@name='Submit']")).click();
        driver.switchTo().alert().accept();
    }
}
