package eTAR.DME_Services;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class HospitalDays {
	
	WebDriver driver = new ChromeDriver();
	String splittedTAR;
	
	public void logintoeTAR(){
		
		System.setProperty("webdriver.chrome.driver", "D:\\Santhosh\\chromedriver\\chromedriver.exe");
		driver.get("http://sysdev.softsol.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		driver.findElement(By.xpath("//a[@id='MedicalService']")).click();
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
		driver.findElement(By.xpath("//input[@name='PatLstNme']")).sendKeys("Rogers");
		driver.findElement(By.xpath("//input[@name='PatFrstNme']")).sendKeys("Steve");
		driver.findElement(By.xpath("//input[@name='PatDOB']")).sendKeys("09242024");
		driver.findElement(By.xpath("//input[@name='Gender'][1]")).click();
		driver.findElement(By.xpath("//input[@name='Submit']")).click();
		
	}
	
	public void addServiceInformation() {
		
		driver.findElement(By.xpath("//a[normalize-space()='Hospital Days']")).click();
		driver.findElement(By.xpath("//input[@name='ServiceCode']")).sendKeys("2");
		driver.findElement(By.xpath("//input[@name='TotUnitsReq']")).sendKeys("12");
		driver.findElement(By.xpath("//input[@name='FromDate']")).clear();
		driver.findElement(By.xpath("//input[@name='FromDate']")).sendKeys("09182024");
		driver.findElement(By.xpath("//input[@name='ThruDate']")).clear();
		driver.findElement(By.xpath("//input[@name='ThruDate']")).sendKeys("09182024");
		driver.findElement(By.xpath("//input[@name='AdmitDate']")).clear();
		driver.findElement(By.xpath("//input[@name='AdmitDate']")).sendKeys("09182024");
		WebElement icdCMTye = driver.findElement(By.xpath("//select[@name='Serv_ICDCodeType']"));
		Select icdType = new Select(icdCMTye);
		icdType.selectByValue("0");
		driver.findElement(By.xpath("//input[@name='Serv_ICD9_1']")).sendKeys("A92.5");
		driver.findElement(By.xpath("//input[@name='Submit']")).click();
		
	}
	
	public void  checkTARSummary() throws InterruptedException {
		
		driver.findElement(By.xpath("//a[@alt=\"['TAR Summary']\"]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='button16']")).click();
	}
	
	public void submitTAR() throws InterruptedException {
		
		driver.findElement(By.xpath("//a[@href='http://sysdev.softsol.com/cgi-forte/forteisapi.dll??serviceName=softsolwebservice&templateName=SetAttachmentsInd.htm&CurrentPage=Serv_Sel']")).click();
		driver.findElement(By.xpath("//input[@alt='Attachment(s) Submission Option: 2']")).click();
		driver.findElement(By.xpath("//input[@id='submit1']")).click();
		String TAR = driver.findElement(By.xpath("//*[text()='TAR # : ']")).getText();
		String[] splitTAR = TAR.split(":");
		
		if(splitTAR.length > 1) {
			
			System.out.println("TCN: "+ splitTAR[1].trim());
			splittedTAR = splitTAR[1].trim();
			
		}else
		{
			System.out.println("No TAR Found");
		}
		
		TARInquiry(splittedTAR);
	}
	
	public void TARInquiry(String SplittedTAR) throws InterruptedException {
		
		driver.findElement(By.xpath("//a[@alt='[TAR Menu]']")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Inquire on a TAR']")).click();
		driver.findElement(By.xpath("//input[@name='TarNum']")).sendKeys(SplittedTAR);
		driver.findElement(By.xpath("//input[@name='Submit']")).click();
		driver.switchTo().alert().accept();
		driver.findElement(By.xpath("//td[@headers='TCN']")).click();	
		Thread.sleep(3000);
		driver.quit();
	}
	
	

public static void main(String[] args) throws InterruptedException {
	
	HospitalDays TAR = new HospitalDays();
	TAR.logintoeTAR();
	TAR.enterProviderInformation();
	TAR.enterPatientInformation();
	TAR.addServiceInformation();
	TAR.checkTARSummary();
	TAR.submitTAR();
	
}
}

