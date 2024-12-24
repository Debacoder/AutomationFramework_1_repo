package books;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import genericutility.BaseClass;
import genericutility.ListenerUtility;
import objectrepository.HomePage;


@Listeners(ListenerUtility.class)
public class TC_DWS_005_Test extends BaseClass {
	@Test
	public void clickOnBooks() {
		test=extReports.createTest("clickOnBooks");
		hp=new HomePage(driver);
		hp.getBooksLink().click();
		Assert.assertEquals(driver.getTitle(), "Demo Web Shop. Book");
		test.log(Status.PASS, "Books page should be display");
	}
}
