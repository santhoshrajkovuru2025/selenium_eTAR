package Other_Services;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class RespiratoryTherapy {
	
	WebDriver driver = new ChromeDriver();
	String SplittedTAR;
	
	public void logintoeTAR() { 
		
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
	driver.findElement(By.xpath("//a[normalize-space()='Respiratory Therapy']")).click();
	driver.findElement(By.xpath("//input[@name='ServiceCode']")).sendKeys("86490");
	driver.findElement(By.xpath("//input[@name='TotUnitsReq']")).sendKeys("1");
	driver.findElement(By.xpath("//input[@name='FromDate']")).clear();
	driver.findElement(By.xpath("//input[@name='FromDate']")).sendKeys("10022024");
	driver.findElement(By.xpath("//input[@name='ThruDate']")).clear();
	driver.findElement(By.xpath("//input[@name='ThruDate']")).sendKeys("10022024");
	driver.findElement(By.xpath("//input[@name='AdmitDate']")).clear();
	driver.findElement(By.xpath("//input[@name='AdmitDate']")).sendKeys("10022024");
	driver.findElement(By.xpath("//input[@name='Quantity']")).sendKeys("1");
	WebElement QuantInd = driver.findElement(By.xpath("//select[@name='QuantityInd']"));
	Select Quant = new Select(QuantInd);
	Quant.selectByIndex(6);
	WebElement Schedule = driver.findElement(By.xpath("//select[@name='Schedule']"));
	Select schdl = new Select(Schedule);
	schdl.selectByIndex(2);
	driver.findElement(By.xpath("//input[@name='Frequency']")).sendKeys("1");
	WebElement FreqInd = driver.findElement(By.xpath("//select[@name='FrequencyInd']"));
	Select Freq = new Select(FreqInd);
	Freq.selectByIndex(6);
	WebElement POS = driver.findElement(By.xpath("//select[@name='POS']"));
	Select pos = new Select(POS);
	pos.selectByVisibleText("Home");
	WebElement ICD_Code = driver.findElement(By.xpath("//select[@name='Serv_ICDCodeType']"));
	Select icd = new Select(ICD_Code);
	icd.selectByIndex(1);
	driver.findElement(By.xpath("//input[@name='Serv_ICD9_1']")).sendKeys("A92.5");
	driver.findElement(By.xpath("//input[@name='Serv_DateOnset_1']")).clear();
	driver.findElement(By.xpath("//input[@name='Serv_DateOnset_1']")).sendKeys("10012024");
	driver.findElement(By.xpath("//input[@name='PhysLimit_1']")).sendKeys("500");
	driver.findElement(By.xpath("//input[@name='PrevPhysLimit_1']")).sendKeys("525");
	driver.findElement(By.xpath("//input[@name='MedStat_1']")).sendKeys("525");
	driver.findElement(By.xpath("//textarea[@name='GoalSummary']")).sendKeys("No Summary");
	driver.findElement(By.xpath("//input[@name='AltServCode_1']")).sendKeys("86490");
	driver.findElement(By.xpath("//input[@name='AlternateDesc_1']")).sendKeys("No Alternative Reason");
	WebElement Alt_Reason = driver.findElement(By.xpath("//select[@name='AltReason_1']"));
	Select Reason = new Select(Alt_Reason);
	Reason.selectByIndex(4);
	driver.findElement(By.xpath("//textarea[@name='ExplCost']")).sendKeys("No Treatment");
	driver.findElement(By.xpath("//textarea[@name='PhysPresc']")).sendKeys("No Prescription");
	driver.findElement(By.xpath("//input[@name='PhysLicNum']")).sendKeys("1548201965");
	driver.findElement(By.xpath("//input[@name='PhysName']")).sendKeys("Prescribing Provider1");
	driver.findElement(By.xpath("//input[@name='PhysPhne1']")).sendKeys("455");
	driver.findElement(By.xpath("//input[@name='PhysPhne2']")).sendKeys("455");
	driver.findElement(By.xpath("//input[@name='PhysPhne3']")).sendKeys("4554");
	driver.findElement(By.xpath("//input[@name='PrescriptDte']")).sendKeys("10012024");
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
		
		driver.findElement(By.xpath("//a[@href='http://sysdev.softsol.com/cgi-forte/forteisapi.dll??serviceName=softsolwebservice&templateName=SetAttachmentsInd.htm&CurrentPage=Serv_Sel']")).click();
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
		// TODO Auto-generated method stub
		
		RespiratoryTherapy TAR = new RespiratoryTherapy();
		TAR.logintoeTAR();
		TAR.enterProviderInformation();
		TAR.enterPatientInformation();
		TAR.addServiceInformation();
		TAR.checkTARSummary();
		TAR.submitTAR();
	}
}
