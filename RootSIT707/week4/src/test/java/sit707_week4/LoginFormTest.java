package sit707_week4;

import org.junit.Assert;
import org.junit.Test;


public class LoginFormTest 
{

	@Test
	public void testStudentIdentity() {
		String studentId = "s223764339";
		Assert.assertNotNull("Student ID is null", studentId);
	}

	@Test
	public void testStudentName() {
		String studentName = "Nikhil";
		Assert.assertNotNull("Student name is null", studentName);
	}
	
	@Test
    public void testFailEmptyUsernameAndEmptyPasswordAndDontCareValCode()
    {
		LoginStatus status = LoginForm.login(null, null);
		Assert.assertTrue( status.isLoginSuccess() == false );
    }
	
	/*
	 * Write more test functions below.
	 */
	@Test
    public void testFailEmptyUsernameAndWrongPasswordAndDontCareValCode()
    {
		LoginStatus status = LoginForm.login(null,"xyz");
		Assert.assertTrue( status.isLoginSuccess() == false );
    }
	
	@Test
    public void testFailEmptyUsernameAndCorrectPasswordAndDontCareValCode()
    {
		LoginStatus status = LoginForm.login(null,"nikk_pass");
		Assert.assertTrue( status.isLoginSuccess() == false );
    }
	
	@Test
	public void testFailWrongUsernameAndEmptyPasswordAndDontCareValCode()
    {
		LoginStatus status = LoginForm.login("nik", null);
		Assert.assertTrue( status.isLoginSuccess() == false );
    }
	
	@Test
	public void testFailWrongUsernameAndWrongPasswordAndDontCareValCode()
    {
		LoginStatus status = LoginForm.login("nik", "xyz");
		Assert.assertTrue( status.isLoginSuccess() == false );
    }
	
	@Test
	public void testFailWrongUsernameAndCorrectPasswordAndDontCareValCode()
    {
		LoginStatus status = LoginForm.login("nik", "nikk_pass");
		Assert.assertTrue( status.isLoginSuccess() == false );
    }
	
	@Test
	public void testFailCorrectUsernameAndEmptyPasswordAndDontCareValCode()
    {
		LoginStatus status = LoginForm.login("Nikhil", null);
		Assert.assertTrue( status.isLoginSuccess() == false );
    }
	
	@Test
	public void testFailCorrectUsernameAndWrongPasswordAndDontCareValCode()
    {
		LoginStatus status = LoginForm.login("Nikhil", "xyz");
		Assert.assertTrue( status.isLoginSuccess() == false );
    }
	
	@Test
	public void testFailCorrectUsernameAndCorrectPasswordAndEmptyValCode()
    {
		LoginStatus status = LoginForm.login("Nikhil", "nikk_pass");
		Assert.assertTrue( status.isLoginSuccess() == true );
		Assert.assertFalse(LoginForm.validateCode(" "));
    }
	
	@Test
	public void testFailCorrectUsernameAndCorrectPasswordAndWrongValCode()
    {
		LoginStatus status = LoginForm.login("Nikhil", "nikk_pass");
		Assert.assertTrue( status.isLoginSuccess() == true );
		Assert.assertFalse(LoginForm.validateCode("abcd"));
    }
	
	@Test
	public void testSuccessCorrectUsernameAndCorrectPasswordAndCorrectValCode()
    {
		LoginStatus status = LoginForm.login("Nikhil", "nikk_pass");
		Assert.assertTrue( status.isLoginSuccess() == true );
		Assert.assertTrue(LoginForm.validateCode("123456"));
    }
}