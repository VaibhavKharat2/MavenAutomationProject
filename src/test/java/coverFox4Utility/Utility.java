package coverFox4Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Reporter;

public class Utility {

	public static String getDataFromExcell(int row, int col, String sheetName)
			throws EncryptedDocumentException, IOException {

		Reporter.log("Getting data from excell", true);
		String path = System.getProperty("user.dir") + "\\Vishubhav.xlsx";
		FileInputStream file = new FileInputStream(path);
		Sheet sheet = WorkbookFactory.create(file).getSheet(sheetName);
		String data = sheet.getRow(row).getCell(col).getStringCellValue();
		return data;
	}

	public static void takeScreenShot(WebDriver driver, String name) throws IOException {

		//Reporter.log("Taking ScreenShot", true);
		String timeStamp= new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		
		File dest = new File(System.getProperty("user.dir") + "\\ScreenShot\\" + name+ timeStamp + ".jpg");
		FileHandler.copy(src, dest);
	}

	public static String getDataFromPropertyFile(String key) throws IOException {

		//Reporter.log("Getting data from PropertyFile", true);
		FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "//Property.properties");
		Properties prop = new Properties();
		prop.load(file);
		prop.getProperty(key);
		return prop.getProperty(key);
	}

}
