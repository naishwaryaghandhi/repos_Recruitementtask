package modern.co.uk;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class SortOrder extends BaseClass {

	public void sortorder() throws InterruptedException{
		
		driver.findElement(By.linkText("Sofas")).click();
		System.out.println("\nSORT ORDER:\n");
		// Sort the product backlog according to the selected sort value in the item page
		for (int i=0; i<6; i++){
			new Select(driver.findElement(By.className("sorts"))).selectByIndex(i);
			Select se2 = new Select(driver.findElement(By.className("sorts")));
			String x = se2.getFirstSelectedOption().getText();
			
			System.out.println("The page is sorted by :" + x );
		}
		
	}

	
}
