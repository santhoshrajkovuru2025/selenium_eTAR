package practice.Test_Class;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import io.github.bonigarcia.wdm.WebDriverManager;

public class hospitalDays {
	
	
	WebDriver driver = new ChromeDriver();
	String SplittedTAR;
	
public void logintoeTAR() { 
	
	WebDriverManager.chromedriver().setup();
	driver.get("https://providerportal.softsol.net/providerportalsimulator");
	driver.manage().window().maximize();
	driver.findElement(By.xpath("//input[@id='pname']")).sendKeys("00A088470");
	driver.findElement(By.xpath("//input[@id='oname']")).sendKeys("01");
	driver.findElement(By.xpath("//input[@id='emailId']")).sendKeys("santhoshraj.kovuru@softsol.com");
	driver.findElement(By.xpath("//button[@id='txt_MedicalServices']")).click();
	driver.findElement(By.xpath("//a[normalize-space()='Create a New TAR']")).click();
	
	}

public void enterProviderInformation() {

	driver.findElement(By.xpath("//input[@name='ProvFax_area']")).sendKeys("858");
	driver.findElement(By.xpath("//input[@name='ProvFax_pre']")).sendKeys("959");
	driver.findElement(By.xpath("//input[@name='ProvFax_sufx']")).sendKeys("7488");
	driver.findElement(By.xpath("//input[@name='txtTARCompBy']")).sendKeys("John Allebe");
	driver.findElement(By.xpath("//input[@name='txtProvContNme']")).sendKeys("sam Allebe");
	driver.findElement(By.xpath("//input[@name='ContPhne_area']")).sendKeys("141");
	driver.findElement(By.xpath("//input[@name='ContPhne_pre']")).sendKeys("525");
	driver.findElement(By.xpath("//input[@name='ContPhne_sufx']")).sendKeys("4156");
	driver.findElement(By.xpath("//input[@name='ContPhne_ext']")).sendKeys("91");
	driver.findElement(By.xpath("//input[@name='Submit']")).click();
	driver.switchTo().alert().accept();
}

public void enterPatientInformation() {
	
	driver.findElement(By.xpath("//input[@name='MedicalID']")).sendKeys("000000001");
WebElement SpecHand =	driver.findElement(By.xpath("//select[@name='SpecHand']"));
	Select spcl = new Select(SpecHand);
	spcl.selectByValue("94");
	driver.findElement(By.xpath("//input[@name='PatLstNme']")).sendKeys("Rogers");
	driver.findElement(By.xpath("//input[@name='PatFrstNme']")).sendKeys("Steve");
	driver.findElement(By.xpath("//input[@name='PatDOB']")).sendKeys("09242024");
	driver.findElement(By.xpath("//input[@name='Gender'][1]")).click();
	driver.findElement(By.xpath("//input[@name='Submit']")).click();
	
}

public void addServiceInformation() throws InterruptedException {
	
Thread.sleep(500);
driver.findElement(By.xpath("//a[normalize-space()='Hospital Days']")).click();
driver.findElement(By.xpath("//input[@name='ServiceCode']")).sendKeys("2");
driver.findElement(By.xpath("//input[@name='TotUnitsReq']")).sendKeys("12");
driver.findElement(By.xpath("//input[@name='FromDate']")).clear();
driver.findElement(By.xpath("//input[@name='FromDate']")).sendKeys("09242024");
driver.findElement(By.xpath("//input[@name='AdmitDate']")).clear();
driver.findElement(By.xpath("//input[@name='AdmitDate']")).sendKeys("09242024");
driver.findElement(By.xpath("//input[@name='ThruDate']")).clear();
driver.findElement(By.xpath("//input[@name='ThruDate']")).sendKeys("09242024");
driver.findElement(By.xpath("//input[@name='DischDate']")).clear();
driver.findElement(By.xpath("//input[@name='DischDate']")).sendKeys("09242024");
WebElement ICD_CODE = driver.findElement(By.xpath("//select[@name='Serv_ICDCodeType']"));
Select icd_code = new Select(ICD_CODE);
icd_code.selectByIndex(1);
driver.findElement(By.xpath("//input[@name='Serv_ICD9_1']")).sendKeys("A52.9");
driver.findElement(By.xpath("//input[@name='Submit']")).click();
	
}

public void  checkTARSummary() throws InterruptedException {
	
	driver.findElement(By.xpath("//a[@alt=\"['TAR Summary']\"]")).click();
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0, -500);");
	Thread.sleep(2000);
	 js.executeScript("window.scrollBy(0, 500);");
	Thread.sleep(5000);
	driver.findElement(By.xpath("//input[@id='button16']")).click();
}

public void submitTAR() throws InterruptedException {
	
	driver.findElement(By.xpath("//a[@alt=\"['Submit TAR']\"]")).click();
	driver.findElement(By.xpath("//input[@alt='Attachment(s) Submission Option: 2']")).click();
	driver.findElement(By.xpath("//input[@id='submit1']")).click();
	Thread.sleep(3000);
	String TAR = driver.findElement(By.xpath("//*[text()='TAR # : ']")).getText();
	String[] splitTAR = TAR.split(":");
	
	if(splitTAR.length > 1) {
		
		System.out.println("TCN: "+ splitTAR[1].trim());
		SplittedTAR = splitTAR[1].trim();
		
	}else
	{
		System.out.println("No TAR Found");
	}
	
	TARInquiry(SplittedTAR);
}

public void TARInquiry(String SplittedTAR) throws InterruptedException {
	
	driver.findElement(By.xpath("//a[@alt='[TAR Menu]']")).click();
	driver.findElement(By.xpath("//a[normalize-space()='Inquire on a TAR']")).click();
	driver.findElement(By.xpath("//input[@name='TarNum']")).sendKeys(SplittedTAR);
	driver.findElement(By.xpath("//input[@name='Submit']")).click();
	driver.switchTo().alert().accept();
	driver.findElement(By.xpath("//td[@headers='TCN']")).click();	
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0, -500);");
	Thread.sleep(2000);
	 js.executeScript("window.scrollBy(0, 500);");
	Thread.sleep(5000);
	driver.quit();
}
	public static void main(String[] args) throws InterruptedException {
			
		
		for (int i = 1; i <= 5; i++) {
	        
		hospitalDays TAR = new hospitalDays();
		TAR.logintoeTAR();
		TAR.enterProviderInformation();
		TAR.enterPatientInformation();
		TAR.addServiceInformation();
		TAR.checkTARSummary();
		System.out.println("------ Iteration: " + i + " ------");
		TAR.submitTAR();
		System.out.println("------ Completed Iteration: " + i + " ------\n");
		}
	}

}
