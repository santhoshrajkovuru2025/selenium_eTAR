package tests;

import pages.*;
import base.BaseTest;
import org.testng.annotations.Test;

public class HospitalDaysTest extends BaseTest {

    @Test(dataProvider = "loginData", dataProviderClass = TestData.class)
    public void createHospitalDaysTAR(String UserName,
                                      String OwnerNum,
                                      String Email,
                                      String Fax_Area_Code,
                                      String Fax_Prefix_Code,
                                      String Fax_Suffix_Code,
                                      String Completed_By,
                                      String Provider_Contact_Name,
                                      String Phone_Area_Code,
                                      String Phone_Prefix_Code,
                                      String Phone_Suffix_Code,
                                      String Phone_Extension,
                                      String MedicalID,
                                      String Patient_Last_Name,
                                      String Patient_First_Name,
                                      String Patient_DOB,
                                      String Service_Code,
                                      String Total_Units,
                                      String From_Date,
                                      String Thru_Date,
                                      String Admit_Date,
                                      String Discharge_Date,
                                      String ICD_Code) throws InterruptedException {

        // Create page objects, pass driver from BaseTest

        LoginPage login = new LoginPage(driver);
        ProviderPage provider = new ProviderPage(driver);
        PatientPage patient = new PatientPage(driver);
        ServicePage service = new ServicePage(driver);
        SubmissionPage submission = new SubmissionPage(driver);
        TARInquiryPage inquiry = new TARInquiryPage(driver);

        // Login
        login.loginToeTAR(UserName,OwnerNum,Email);

        // Fill all TAR information
        provider.enterProviderInformation(Fax_Area_Code,Fax_Prefix_Code,Fax_Suffix_Code,Completed_By,Provider_Contact_Name,Phone_Area_Code,Phone_Prefix_Code,Phone_Suffix_Code,Phone_Extension);
        patient.enterPatientInformation(MedicalID,Patient_Last_Name,Patient_First_Name,Patient_DOB);
        service.addServiceInformation(Service_Code,Total_Units,From_Date,Thru_Date,Admit_Date,Discharge_Date,ICD_Code);

        // Check summary and submit
        submission.checkTARSummary();
        String tarNumber = submission.submitTAR(); // Returns TAR number

        // Perform TAR inquiry using returned TAR number
        inquiry.TARInquiry(tarNumber);
    }
}
