package tests;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class test01 {
    private WebDriver driver;
    
    
//Here we call the chromeDriver.exe, the path for the executable file should be added here.
    @BeforeMethod
    public void turnOnDriver() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\USER\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
    }
     

    @Test
    public void testEvershop() throws InterruptedException {
        // Open Homepage
        driver.get("https://demo.evershop.io/");
        
        //validate that homepage was accessed
        System.out.println("Page title is: " + driver.getTitle());
        
        //Open login page
        driver.get("https://demo.evershop.io/account/login");
        
        //validate that login page was accessed
        System.out.println("Page title is: " + driver.getTitle());
        
   //Login by email and password
        WebElement emailField = driver.findElement(By.name("email"));
        emailField.sendKeys("francoveraaranda@gmail.com");
        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("evershop123.");
        
        WebElement signInButton = driver.findElement(By.xpath("//span[contains(text(),'SIGN IN')]"));
        signInButton.click();
        
        Thread.sleep(2000);
   //Purchase
        
        //Going to the Men section
        WebElement menSectionButton = driver.findElement(By.linkText("Men"));
        menSectionButton.click();
        //Selecting Products
        
        //Product 1
        WebElement product1 = driver.findElement(By.linkText("Strutter shoes"));
        product1.click();
        	//Input the quantity
        	WebElement p1qtyfield = driver.findElement(By.name("qty"));
        	p1qtyfield.clear();
        	p1qtyfield.sendKeys("2");
        	
        	//Select the Size
        	WebElement p1SizeButton = driver.findElement(By.xpath("//a[contains(text(),'L')]"));
        	p1SizeButton.click();
      
        	//Select the color
        	WebElement p1ColorButton = driver.findElement(By.xpath("//a[contains(text(),'White')]"));
        	p1ColorButton.click();
        	
        	//We use this to wait for a second before adding to cart
        	Thread.sleep(1000);
        	
        	
        	//add to cart
        	WebElement addButton = driver.findElement(By.xpath("//span[contains(text(),'ADD TO CART')]"));
        	addButton.click();
        	
        	Thread.sleep(2000);
        
        	
        // Open Homepage
        driver.get("https://demo.evershop.io/");    
        //validate that homepage was accessed  
        //Going to the Women section
        WebElement womenSectionButton = driver.findElement(By.linkText("Women"));
        womenSectionButton.click();
        
        
        //Product 2
        WebElement product2 = driver.findElement(By.linkText("Seasonal color chuck 70"));
        product2.click();
           	//Input the quantity
            WebElement p2qtyfield = driver.findElement(By.name("qty"));
            p2qtyfield.clear();
            p2qtyfield.sendKeys("1");
            	
            //Select the Size
            WebElement p2SizeButton = driver.findElement(By.xpath("//a[contains(text(),'X')]"));
            p2SizeButton.click();
          
            //Select the color
            WebElement p2ColorButton = driver.findElement(By.xpath("//a[contains(text(),'Pink')]"));
            p2ColorButton.click();
            	
            //We use this to wait for a second before adding to cart
            Thread.sleep(1000);
            	
            //add to cart
            addButton = driver.findElement(By.xpath("//span[contains(text(),'ADD TO CART')]"));
            addButton.click();
        
        	Thread.sleep(2000);
        
        // Open Homepage
        driver.get("https://demo.evershop.io/");    
        //Going to the Women section
        WebElement kidSectionButton = driver.findElement(By.xpath("//span[contains(text(),'Shop kids')]"));
        kidSectionButton.click();
                        
        //Product 3
        WebElement product3 = driver.findElement(By.linkText("Coated glitter chuck taylor all star"));
        product3.click();
            //Input the quantity
            WebElement p3qtyfield = driver.findElement(By.name("qty"));
            p3qtyfield.clear();
            p3qtyfield.sendKeys("3");
                	
            //Select the Size
            WebElement p3SizeButton = driver.findElement(By.xpath("//a[contains(text(),'S')]"));
            p3SizeButton.click();
              
            //Select the color
            WebElement p3ColorButton = driver.findElement(By.xpath("//a[contains(text(),'Purple')]"));
            p3ColorButton.click();
                	
            //We use this to wait for a second before adding to cart
            Thread.sleep(1000);
                	
            //add to cart
            addButton = driver.findElement(By.xpath("//span[contains(text(),'ADD TO CART')]"));
            addButton.click();
            
            Thread.sleep(2000);        
      
    //Checkout
       //Check the cart 
       driver.get("https://demo.evershop.io/cart");
        	
       //Checkout
       WebElement checkoutButton = driver.findElement(By.xpath("//span[contains(text(),'CHECKOUT')]"));
       checkoutButton.click(); 
       
       //Input the shipping address
   		WebElement fullName = driver.findElement(By.name("address[full_name]"));
   		fullName.clear();
   		fullName.sendKeys("Franco Vera");
        
   		WebElement telephone = driver.findElement(By.name("address[telephone]"));
   		telephone.clear();
   		telephone.sendKeys("911111111");
   		
   		WebElement address = driver.findElement(By.name("address[address_1]"));
   		address.clear();
   		address.sendKeys("Lima city test");
   		
   		WebElement city = driver.findElement(By.name("address[city]"));
   		city.clear();
   		city.sendKeys("perucity");
        
   		WebElement country = driver.findElement(By.name("address[country]")); 
        Select countryList = new Select(country);
        countryList.selectByVisibleText("United States");
        
        Thread.sleep(2000);
        
        WebElement province = driver.findElement(By.name("address[province]")); 
        Select provinceList = new Select(province);
        provinceList.selectByVisibleText("New York");
        
        Thread.sleep(2000);
        
        WebElement postCode = driver.findElement(By.name("address[postcode]"));
   		postCode.clear();
   		postCode.sendKeys("12");
   		
   		Thread.sleep(1000);
   		
   		//Selecting standard delivery 
        WebElement radio1 = driver.findElement(By.xpath("//span[contains(text(),'Standard Delivery')]")); 
        //click the first option for standard delivery
        radio1.click();
        
        Thread.sleep(1000);
        
      //Payment
        //continue to payment
        WebElement continueToPayment = driver.findElement(By.xpath("//span[contains(text(),'Continue to payment')]"));
        continueToPayment.click(); 
       
        

        Thread.sleep(5000);
        
        //couldn't find a way to locate the radiobuttons in the payment method form, so manual handling should be used here.
                
        WebElement placeOrder = driver.findElement(By.xpath("//span[contains(text(),'Place Order')]"));
        placeOrder.click(); 
        
        Thread.sleep(1000);
        
        //Validate Sale
        WebElement fullNameInfo = driver.findElement(By.className("full-name"));
        String fullNameText = fullNameInfo.getText();

        WebElement addressOne = driver.findElement(By.className("address-one"));
        String addressOneText = addressOne.getText();

        WebElement addressElement = driver.findElement(By.className("city-province-postcode"));
        List<WebElement> cpp = addressElement.findElements(By.tagName("div"));
        String address1 = cpp.get(0).getText();
        String address2 = cpp.get(1).getText();

        WebElement telephoneInfo = driver.findElement(By.className("telephone"));
        String telephoneText = telephoneInfo.getText();
           
            // Assertions        
            Assert.assertEquals(fullNameText, "Franco Vera");
            Assert.assertEquals(addressOneText, "Lima city test");
            Assert.assertEquals(address1, "12, perucity");
            Assert.assertEquals(address2, "New York, United States");
            Assert.assertEquals(telephoneText, "911111111");
        
            
        //Validate products purchased
        List<WebElement> productColumns = driver.findElements(By.className("product-column"));
        boolean productExists1 = false;
        boolean productExists2 = false;
        boolean productExists3 = false;

        for (WebElement productColumn : productColumns) {
        String productInfo = productColumn.getText();
        if (productInfo.contains("Strutter shoes")) {
         productExists1 = true;
        } else if (productInfo.contains("Seasonal color chuck 70")){
        	productExists2 = true;
        }else if (productInfo.contains("Coated glitter chuck taylor all star")){
        	productExists3 = true;
         break; 
         }
         }
        
        //Assertions
         Assert.assertTrue(productExists1, "Item doesn't exist");  
         Assert.assertTrue(productExists2, "Item doesn't exist");
         Assert.assertTrue(productExists3, "Item doesn't exist.");
                   
    }
    //We use this to quit the chromedriver and finish execution.
    @AfterMethod
    public void turnOffDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}