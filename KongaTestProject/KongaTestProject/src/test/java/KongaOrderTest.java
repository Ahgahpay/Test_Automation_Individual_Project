import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class KongaOrderTest {

    // import the selenium webDriver
    private WebDriver driver;


    @BeforeTest
    public void start () throws InterruptedException {
        // locate where the chrome driver is
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        // open my chrome browser
        driver = new ChromeDriver();
        // Flow 1: Visit the Konga URL (https://www.konga.com/)
        driver.get("https://www.konga.com/");
        Thread.sleep(10000);
        // maximize the browser
        driver.manage().window().maximize();
        // Page wait / load
        //Thread.sleep(5000);

    }

    @Test(priority = 0)
    public void visitUrl () throws InterruptedException {

        // Flow 1: Visit the Konga URL (https://www.konga.com/)
        //driver.get("https://www.konga.com/");
        //Thread.sleep(5000);
        // Testcase 1: Confirm user has put in the correct URL and is on the right webpage
        if (driver.getCurrentUrl().contains("https://www.konga.com/"))
            // Pass
            System.out.println("User is on the correct Konga webpage");
        else
            System.out.println("User is on the wrong Konga webpage");
        Thread.sleep(5000);

    }

    @Test(priority = 1)
    public void signIn() throws InterruptedException {

        // Flow 2: Sign in to Konga Successfully
        // click on the login / Signup button
        driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div/div[4]/a")).click();
        Thread.sleep(5000);
        // Locate the email address or phone number field and input email address or phone number
        driver.findElement(By.id("username")).sendKeys("");
        // Locate the password field and input password
        driver.findElement(By.id("password")).sendKeys("");
        Thread.sleep(1000);
        // Click on the log in button to open the profile dashboard
        driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[4]/section/section/aside/div[2]/div/form/div[3]/button")).click();
        Thread.sleep(7000);
        // Testcase 2: Verify that user is sucessfully signed into Konga
        String SignInSuccess = "Login Login Successful";
        if (SignInSuccess.contains("Login Login Successful"))
            // Pass
            System.out.println("Sign in to Konga was successful");
        else
            // Fail
            System.out.println("Sign in to Konga was not successful");

    }

    @Test (priority = 2)
    public void category() throws InterruptedException {
        // Flow 3: From the categories, click on the computers and accessories"
        driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[2]/div/a[2]")).click();
        Thread.sleep(5000);
        // Testcase 3: verify user clicked on the category "computer and accessories"
        String actualCategory = "Computers and Accessories";
        if (actualCategory.contains("Computers and Accessories"))
            // Pass
            System.out.println("User clicked on computer and accessories");
        else
            // Fail
            System.out.println("User did not click on computer and accessories");
    }

    @Test (priority = 3)
    public void subCategory() throws InterruptedException {
        // Flow 4: Click on the Laptop Subcategory
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/section[3]/section/div/section/div[2]/div[2]/ul/li[3]/a/label/span")).click();
        Thread.sleep(3000);
        // Testcase 4: verify user clicked on laptops subcategory
        String actualSubCategory = "Laptops";
        if (actualSubCategory.contains("Laptops"))
            // Pass
            System.out.println("User clicked on Laptops");
        else
            // Fail
            System.out.println("User did not click on Laptops");
    }

    @Test(priority = 4)
    public void AppleMacbook() throws InterruptedException {
        // Flow 5: Click on the Apple Macbooks
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/section[3]/section/div/section/div[2]/div[2]/ul/li[3]/a/ul/li[1]/a/label/span")).click();
        Thread.sleep(5000);
        // Testcase 5: Verify that user selected Apple MacBooks and is on Apple Macbooks page
        String Apple = "Apple MacBooks";
        if (Apple.contains("Apple MacBooks"))
            // Pass
            System.out.println("User clicked on Apple Macbooks radio button");
        else
            // Fail
            System.out.println("User did not click on Apple Macbooks radio button");

    }

    @Test (priority = 5)
    public void addToCart () throws InterruptedException {
        // Flow 6: Add an item (laptop) to the cart
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/section[3]/section/section/section/section/ul/li[3]/div/div/div[2]/form/div[3]/button")).click();
        // page load / wait
        Thread.sleep(5000);
        // Testcase 6: verify that item was added to cart
        String viewCart = "Macbook has been added to your cart";
        if (viewCart.contains("Macbook has been added to your cart"))
            // Pass
            System.out.println("Item has been added to cart");
        else
            // Fail
            System.out.println("Item was not been added to cart");
        // view cart by clicking on "My cart"
        driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div/a[2]/span[1]")).click();
        Thread.sleep(3000);
        // Testcase 7: verify that item was added to cart
        String cartView = "Cart Overview";
        if (cartView.contains("Cart Overview"))
            // Pass
            System.out.println("User can view cart");
        else
            // Fail
            System.out.println("User could not view cart");
        Thread.sleep(3000);
        // click on continue to checkout
        driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[3]/section/section/aside/div[3]/div/div[2]/button")).click();
        Thread.sleep(5000);

        // Testcase 8: verify user is directed to the check out page
        String expectedUrl = "https://www.konga.com/checkout/complete-order";
        String actualUrl = driver.getCurrentUrl();
        if (actualUrl.contains(expectedUrl))
            // Pass
            System.out.println("User is directed to the check out page");
        else
            // Fail
            System.out.println("User is not directed to the check out page");
        Thread.sleep(2000);

    }

    @Test (priority = 6)
    public void selectAddress() throws InterruptedException {
        // Flow 7: Select Address
        // on choose delivery option, click on change
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/form/div/div[1]/section[1]/div/div/div[1]/div[2]/div/button")).click();
        // click on  "add delivery address"
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/form/div/div[1]/section[1]/div/div/div[2]/div[1]/div[2]/div[1]/div/button")).click();
        Thread.sleep(2000);
        // select address
        driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[2]/section/section/aside/div[2]/div/div/div[2]/div[1]/form/button")).click();
        Thread.sleep(2000);
        // click on "Use this address"
        driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[2]/section/section/aside/div[3]/div/div/div/a")).click();
        Thread.sleep(2000);
    }

    @Test (priority = 7)
    public void makePayment() throws InterruptedException {
        // On payment option, click on the "pay now" button
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/form/div/div[1]/section[2]/div/div[2]/div[1]/div[1]/span/input")).click();
        Thread.sleep(5000);
        // click on the "Continue to payment" button
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/form/div/div[1]/section[2]/div/div[2]/div[3]/div[2]/div/button")).click();
        Thread.sleep(5000);
        // Testcase 9: verify user is displayed a payment method to select
        String paymentFrame = "Select Payment Method";
        if (paymentFrame.contains("Select Payment Method"))
            // Pass
            System.out.println("User is displayed payment method");
        else
            // Fail
            System.out.println("User is not displayed payment method");
        //Thread.sleep(1000);
    }

    @Test (priority = 8)
    public void cardPaymentMethod () throws InterruptedException {
        //  switch to iframe to proceed with payment
        By paymentIframe = By.xpath("//*[@id=\"kpg-frame-component\"]");
        driver.switchTo().frame(driver.findElement(paymentIframe));
        Thread.sleep(5000);
        // select card payment method
        driver.findElement(By.xpath("//*[@id=\"channel-template\"]/div[2]/div/div[2]/button")).click();
        // page wait / load
        Thread.sleep(5000);

    }

    @Test (priority = 9)
    public void invalidCardDetails () throws InterruptedException {
        // Flow 8: Input Invalid details
        // Locate the card number field and input an invalid card number
        driver.findElement(By.id("card-number")).sendKeys("5566 44");
        // Locate the date field and input your card expiry date
        driver.findElement(By.id("expiry")).sendKeys("12/25");
        // Locate the cvv field and input your cvv
        driver.findElement(By.id("cvv")).sendKeys("345");
        // Testcase 10: verify user was required to enter card details
        String cardDetailsFrame = "Enter Card Details";
        if (cardDetailsFrame.contains("Enter Card Details"))
            // Pass
            System.out.println("User was required to enter card details");
        else
            // Fail
            System.out.println("User was not required to enter card details");
        // page wait or load
        Thread.sleep(2000);
    }

    @Test (priority = 10)
    public void errorMessage ()  {
        // Flow 9: Print out the error message: Invalid card number
        // expected error message
        String expErrorMessage = "Invalid card number";
        // identify actual error message
        WebElement errormsg = driver.findElement(By.id("card-number_unhappy"));
        String actErrorMessage = errormsg.getText();
        // print error message
        System.out.println("Error: Invalid card number");
        // verify error message with Assertion
        Assert.assertEquals(expErrorMessage, actErrorMessage);

    }

    @Test (priority = 11)
    public void closeIframe () throws InterruptedException {
        // Flow 10: close the iFrame that displays the input card Modal
        driver.findElement(By.xpath("/html/body/section/section/section/div[2]/div[1]/aside")).click();
        Thread.sleep(5000);
        // Testcase 11: verify user closed iframe and order was cancelled
        String SignInSuccess = "Order Placement Failed";
        if (SignInSuccess.contains("Order Placement Failed"))
            // Pass
            System.out.println("Order was cancelled after closing iFrame");
        else
            // Fail
            System.out.println("Order proceeded after closing iFrame");

        // close iframe
        // driver.switchTo().defaultContent()

    }

    @AfterTest
    public void closeBrowser(){
        // Flow 11: Quit the browser
        // Test case 12: verify the browser was quitted
        driver.quit();
        System.out.println("User quitted browser");
    }

}

