package sit707_week4;


public class Main 
{
    public static void main( String[] args )
    {
    	/*
    	 * Failed login and don't care validation code.
    	 */
    	LoginStatus status = LoginForm.login(null, null);
        System.out.println("[Empty username, empty password] >> " + status);
        
        status = LoginForm.login(null, "xyz");
        System.out.println("[Empty username, wrong password] >> " + status);
        
        status = LoginForm.login(null, "nikk_pass");
        System.out.println("[Empty username, Correct password] >> " + status);
        
        status = LoginForm.login("abc", null);
        System.out.println("[Wrong username, Empty password] >> " + status);
        
        status = LoginForm.login("abc", "xyz");
        System.out.println("[Wrong username, wrong password] >> " + status);
        
        status = LoginForm.login("abc", "nikk_pass");
        System.out.println("[Wrong username, Correct password] >> " + status);
        
        status = LoginForm.login("Nikhil", null);
        System.out.println("[Correct username, empty password] >> " + status);
        
        status = LoginForm.login("Nikhil", "xyz");
        System.out.println("[Correct username, wrong password] >> " + status);
        

        /*
         * Login success case, there is a validation code in errorMsg field.
         */
        status = LoginForm.login("Nikhil", "nikk_pass");
        System.out.println("[Correct username, Correct password] >> " + status);
               
        if (status.isLoginSuccess()) {
        	/*
        	 * Test validation code cases
        	 */
        	System.out.println("\tEmpty code >> " + LoginForm.validateCode(null));
        	System.out.println("\tWrong code >> " + LoginForm.validateCode("abcd"));
        	System.out.println("\tCorrect code >> " + LoginForm.validateCode("123456"));
        }
    }
}
