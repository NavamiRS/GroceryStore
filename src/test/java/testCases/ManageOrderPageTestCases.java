package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import constants.Constant;
import elementRepository.LoginPage;
import elementRepository.ManageOrderPage;

public class ManageOrderPageTestCases extends BaseClass {
  @Test
  public void getalloptions() throws InterruptedException {
	  LoginPage lp;
	  ManageOrderPage mop;
	  
	  lp=new LoginPage(driver);
	  mop=new ManageOrderPage(driver);
	  lp.presteps();
	 boolean actual_PaymentMode=mop.searchPaymentModeListDetails();
	 
	 Assert.assertTrue(actual_PaymentMode,Constant.PAYMENTMODEERROR);
	  
	  
  }
  @Test
  public void verifyThatOrderIdAndPaymentModeWhileClickingSearchOption() throws InterruptedException {
	  LoginPage lp;
	  ManageOrderPage mop;
	  
	  lp=new LoginPage(driver);
	  mop=new ManageOrderPage(driver);
	  lp.presteps();
	  mop.orderIdAndPaymentModeVeri();
	  
	String actual_Orderid=mop.orderIdVerification();
	String actual_PaymentMode=mop.PaymentModeVerification();
	
	String expected_OrderId="367";
	String expected_PaymentMode="COD";
	
	SoftAssert sa=new SoftAssert();
	sa.assertEquals(actual_Orderid, expected_OrderId,"-------OrderId Not Found----------");
	sa.assertEquals(actual_PaymentMode, expected_PaymentMode,"-------PaymentMode Not Found----------");
	sa.assertAll();
}
  @Test
  public void verifyStatusDropDownSize() throws InterruptedException {
	  LoginPage lp;
	  ManageOrderPage mop;
	  
	  lp=new LoginPage(driver);
	  mop=new ManageOrderPage(driver);
	  lp.presteps();
	  int actualSize=mop.statusDropDown();
	  int expectedSize=5;
	  
	  Assert.assertEquals(actualSize, expectedSize,"------Invalid Size-----------");
  }
}
