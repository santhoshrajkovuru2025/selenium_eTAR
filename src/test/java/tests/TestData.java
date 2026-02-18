package tests;

import org.testng.annotations.DataProvider;
import utils.ExcelUtils;

public class TestData {

    @DataProvider(name = "loginData")
    public static Object[][] getLoginData() {
        return ExcelUtils.readExcel("src/test/resources/LoginData.xlsx");
    }

}
