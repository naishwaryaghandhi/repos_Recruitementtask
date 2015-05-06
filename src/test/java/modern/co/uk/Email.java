package modern.co.uk;


import org.openqa.selenium.By;



public class Email extends BaseClass {
	
	public void Emailtest() throws InterruptedException {
	      
	  //Get email id's to check validation of Email sign up field
	  String[] emailIds = {"test.user","emailtest@gmail.uk", "emailtest@gmail.uk","9835t39thjfi"};	
	  int size = emailIds.length;
	  int counter = 0;
	  System.out.println("\nEMAIL SIGN UP:\n");
	  //Loop to pass the emailid's to the field and retrieve the validation message
	  while ( counter< size) 
	  {        
		  
		  System.out.println("Email id entered: "+emailIds[counter]);
		  driver.findElement(By.id("newsletter-email")).clear();
	      driver.findElement(By.id("newsletter-email")).sendKeys(emailIds[counter]);
	      driver.findElement(By.xpath(".//*[@id='newsletter-signup']/button")).click();
	      Thread.sleep(2000);
	      String eMailMsg = driver.findElement(By.className("newsletter-signup-errormsg")).getText();
	      checkEmail(eMailMsg);
	      counter = counter + 1 ;
    	}
	      
	}
	
	public void checkEmail(String eMailMsg){
		
		//Cases to validate and print the messages
		String eMailExists = new String("Email address exists");
		String invalideMail= new String("Invalid email address");
		String eMailSubscribe = new String("Email address subscribed");
		if (eMailMsg.equals(eMailExists)){
			System.out.println(eMailMsg);
		}
		else if (eMailMsg.equals(invalideMail)){
			System.out.println(eMailMsg);	
		}
		else {
			eMailMsg = eMailSubscribe;
			System.out.println(eMailMsg);
		}
	}
	
	
}
	

