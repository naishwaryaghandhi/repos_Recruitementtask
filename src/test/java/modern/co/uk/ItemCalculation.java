package modern.co.uk;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;


public class ItemCalculation extends BaseClass {
	
	public void itemCalculation() throws InterruptedException{
	
		WebDriverWait wait = new WebDriverWait(driver, 10);	
		
		//Select a sofa from the product catalogue to add to basket
		driver.findElement(By.linkText("Sofas")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath
				 (".//*[@id='item_image']/img"))).click();		 
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath
				 (".//*[@id='ws-btnaddcart']"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath
				 (".//*[@id='dropdown-basket']/div[2]/table/tbody/tr/td[2]/div/div[2]/a/span"))).click();
		
		//Get the price of the selected sofa gives value as £value
		String price = driver.findElement(By.className("product_price"))
			.getText();
		
		//Splitting and converting the string to float for multiplying with quantity
		String[] array = price.split("\\£");
		String value = array[1].replaceAll("\\s", "");
		float itemprice = Float.valueOf(value);
		System.out.println("Price of the selected item is :" + itemprice);

		//Select quantity of the selected item
	    WebElement quantity_selection = driver.findElement(By.name("quantity"));
	    Select quantityvalue = new Select(quantity_selection);
	    //Change the index to alter the quantity
	    quantityvalue.selectByIndex(6);
	    Alert alert = driver.switchTo().alert();
	    alert.accept();
	    Select se1 = new Select(driver.findElement(By.name("quantity")));
	    String selectedquantity = se1.getFirstSelectedOption().getText();
	    int quantity = Integer.parseInt(selectedquantity);
	    System.out.println(quantity);
	    
	    //Find the actual price of the selected item
	    float actualIntegerVal = itemprice * quantity;
	    System.out.println(actualIntegerVal);
	    Thread.sleep(3000);
	    
	    //Get the Goods total from the site
	    String total = driver.findElement(By.className("goods_total")).getText();
	    String[] array1 = total.split("\\£");
	    String value1 = array1[1].replaceAll("\\s", "");
	    String[] actual_value = value1.split("\\,");
	    String actual_value1 = actual_value[0]+actual_value[1];
	    String actual_value2 = actual_value1.replaceAll("\\s", "");
	    float expectedIntegerVal = Float.valueOf(actual_value2);
	    System.out.println(expectedIntegerVal);
	    
	    //Method call to compare actual and expected values
	    compareIntegerVals(actualIntegerVal,expectedIntegerVal);
		}
	
	
	public boolean compareIntegerVals(float actualIntegerVal, float expectedIntegerVal){
		SoftAssert Soft_Assert = new SoftAssert();
		try{
		   //If this assertion will fail, It will throw exception and catch block will be executed.
		   Assert.assertEquals(actualIntegerVal, expectedIntegerVal);
		   }catch(Throwable t){
		    //This will throw soft assertion to keep continue your execution even assertion failure 
		    Soft_Assert.fail("Actual Value '"+actualIntegerVal+"' And Expected Value '"+expectedIntegerVal+"' Do Not Match.");
		    //If Integer values will not match, return false.
		    return false;
		    
		   }
		  //If  Integer values match, return true.
		  return true;
		 }

}
