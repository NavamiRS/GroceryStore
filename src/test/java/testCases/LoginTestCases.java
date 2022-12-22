package testCases;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import constants.Constant;
import elementRepository.LoginPage;
import net.bytebuddy.agent.builder.AgentBuilder.DescriptionStrategy;

public class LoginTestCases extends BaseClass {
  LoginPage lp;
  @Test
  public void verifyLoggedUsers() {
	  lp=new LoginPage(driver);
	  lp.presteps();
	  
	  String expectedProfileName=Constant.EXPECTEDPROFILENAME;//access from Constant class
	  String actualProfileName=lp.profileVerification();
	  Assert.assertEquals(actualProfileName, expectedProfileName,Constant.LOGINERROR);//access from Constant class
	  

  }
  
  @Test
  public void profileNameStyleValidation() {
	  lp=new LoginPage(driver);
	  lp.presteps();
	  
	 
	  String profileColor=lp.styleProperty();
	  String expectedProfileClr=Constant.ADMIN_CLR_PPTY;
	  Assert.assertEquals(profileColor, expectedProfileClr,Constant.STYLE_ERROR);//access from Constant class
	 

  }
  
  @Test(description="login using dataprovider",dataProvider="data")
  public void verifyLoggedUsersDataProvider(String username,String password) {
	  lp=new LoginPage(driver);
	  //lp.presteps();
	  lp.getUserName(username);
	  lp.getPassWord(password);
	  lp.clickSignin();
	  
	  String expectedProfileName=Constant.EXPECTEDPROFILENAME;//access from Constant class
	  String actualProfileName=lp.profileVerification();
	  Assert.assertEquals(actualProfileName, expectedProfileName,Constant.LOGINERROR);//access from Constant class
	  

  }
  
  @DataProvider(name="data")
  public Object[][] getUserData(){
	  return new Object[][] 
			  { {"admin","admin"},{"admin2","admin4"},{"admin54","admin"},{"admin","admin2"},};
  }
  
  
  @Test
  public void remenberMeCheckBoxValidation() {
	  lp=new LoginPage(driver);
	  lp.getUserName("admin");
	  lp.getPassWord("admin");
	  
	  boolean actual_Status=lp.rememberMeCheckbox();
	  boolean expected_Status=false;
	  Assert.assertEquals(actual_Status, expected_Status,Constant.CHECKBOX_ERROR);
	 
	  

  }
  
  
}

