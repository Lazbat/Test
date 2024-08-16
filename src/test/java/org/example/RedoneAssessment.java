package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;


//Question: Write a Cypress test script to automate the process of
//a. searching for a product (phone) on the site.
//b. Hover over the product, and click the cart icon from the icons displayed.
//c. Proceed to checkout from the popup displayed.
//d. Fill in the details
//e. Uncheck the store newsletter
//f. Complete checkout

public class RedoneAssessment {
    WebDriver driver;

    @BeforeClass
    public void openBrowser() {
        //launch browser
        driver = new ChromeDriver();
        //maximize browser
        driver.manage().window().maximize();
        //Implicit wait: wait for an element to appear on the page
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        //Explicit wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        System.out.println("Browser launched");
        //navigate to url
        driver.get("https://ecommerce-playground.lambdatest.io/");
    }

    @Test(priority = 0)
    public void searchForAProduct() {
        //searching for a product (phone) on the site.
        driver.findElement(By.cssSelector(".flex-md-nowrap [type='text']")).sendKeys("phone");
        driver.findElement(By.cssSelector(".flex-md-nowrap [type='text']")).sendKeys(Keys.ENTER);
        System.out.println("Phone search successful");
    }

    @Test(priority = 1)
    public void hoverOverTheProduct() {
        //Hover over the product, and click the cart icon from the icons displayed.
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,700)");
        WebElement phone = driver.findElement(By.cssSelector("div:nth-of-type(4) > .product-thumb > .product-thumb-top > .image > .carousel.d-block.slide > div > div:nth-of-type(1) > img[alt='iPhone']"));
        Actions mouse = new Actions(driver);
        mouse.moveToElement(phone).build().perform();
        driver.findElement(By.cssSelector("div:nth-of-type(4) > .product-thumb > .product-thumb-top > .product-action > button[title='Add to Cart'] > .fa-shopping-cart.fas"))
                .click();
        System.out.println("Successfully clicked on cart icon");
    }

    @Test(priority = 2)
    public void proceedToCheckOut() {
        //Proceed to checkout from the popup displayed.
        driver.findElement(By.cssSelector("body.product-search:nth-child(2) div.toast.m-3.fade.show div.toast-body div.form-row div.col:nth-child(2) > a.btn.btn-secondary.btn-block"))
                .click();
        System.out.println("Proceeded to checkout");
    }

    @Test(priority = 3)
    public void fillInTheDetails() {
        //Fill in the details
        //first name
        driver.findElement(By.cssSelector("#input-payment-firstname")).sendKeys("Lazbat");
        //last name
        driver.findElement(By.cssSelector("#input-payment-lastname")).sendKeys("Babayale");
        //email
        driver.findElement(By.cssSelector("#input-payment-email")).sendKeys("bizedge@mailinator.com");
        //telephone
        driver.findElement(By.cssSelector("#input-payment-telephone")).sendKeys("+2348060302552");
        //password
        driver.findElement(By.cssSelector("#input-payment-password")).sendKeys("Beta123.");
        //confirm password
        driver.findElement(By.cssSelector("#input-payment-confirm")).sendKeys("Beta123.");
        //company
        driver.findElement(By.cssSelector("#input-payment-company")).sendKeys("Travel Beta");
        //address1
        driver.findElement(By.cssSelector("#input-payment-address-1")).sendKeys("14, Ojuelegba");
        //address2
        driver.findElement(By.cssSelector("#input-payment-address-2")).sendKeys("14, Ojuelegba");
        //city
        driver.findElement(By.cssSelector("#input-payment-city")).sendKeys("Surulere");
        //postcode
        driver.findElement(By.cssSelector("#input-payment-postcode")).sendKeys("101302");
        //country
        WebElement selectCountry = driver.findElement(By.cssSelector("#input-payment-country"));
        Select country = new Select(selectCountry);
        country.selectByVisibleText("Nigeria");
        //state/region
        WebElement selectState = driver.findElement(By.cssSelector("#input-payment-zone"));
        Select state = new Select(selectState);
        state.selectByVisibleText("Lagos");
        System.out.println("All required fields filled");
    }

    @Test(priority = 4)
    public void uncheckTheStoreNewsletter() {
        //Uncheck the store newsletter
        driver.findElement(By.cssSelector("body.checkout-checkout:nth-child(2) div.mz-pure-container:nth-child(1) div.mz-pure-pusher-container:nth-child(5) div.container.content.pb-5:nth-child(2) div.row:nth-child(2) div.col-md-12 form:nth-child(1) div.row div.col-lg-7.mb-5.mb-lg-0 div.sticky-top > div.custom-control.custom-checkbox:nth-child(3)"))
                .click();
        System.out.println("Unchecked store newsletter");
    }

    @Test(priority = 5)
    public void completeCheckout() {
        // Complete checkout
        driver.findElement(By.cssSelector("body.checkout-checkout:nth-child(2) div.mz-pure-container:nth-child(1) div.mz-pure-pusher-container:nth-child(5) div.container.content.pb-5:nth-child(2) div.row:nth-child(2) div.col-md-12 form:nth-child(1) div.row div.col-lg-7.mb-5.mb-lg-0 div.sticky-top > div.custom-control.custom-checkbox:nth-child(4)"))
                .click();
        driver.findElement(By.cssSelector("body.checkout-checkout:nth-child(2) div.mz-pure-container:nth-child(1) div.mz-pure-pusher-container:nth-child(5) div.container.content.pb-5:nth-child(2) div.row:nth-child(2) div.col-md-12 form:nth-child(1) div.row div.col-lg-7.mb-5.mb-lg-0 div.sticky-top > div.custom-control.custom-checkbox:nth-child(6)"))
                .click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100)); // Declaring WebDriverWait
        WebElement continueButton = new WebDriverWait(driver, Duration.ofSeconds(100))
                .until(ExpectedConditions.elementToBeClickable(By.cssSelector("#button-save")));
        continueButton.click();
        driver.findElement(By.xpath("//button[@id='button-save']")).click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");
        WebElement confirmButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#button-confirm")));
        confirmButton.click();
        System.out.println("Checkout successful");
        driver.findElement(By.cssSelector("body.checkout-success:nth-child(2) div.mz-pure-container:nth-child(1) div.mz-pure-pusher-container:nth-child(5) div.container.content.pb-5:nth-child(2) div.row:nth-child(2) div.col-md-12 div.buttons.mb-4:nth-child(9) > a.btn.btn-primary"))
                .click();
    }

    @AfterClass
    public void quitBrowser() {
        driver.quit();
        System.out.println("Quit Browser");
    }

    public static void main(String [] args) {
        RedoneAssessment assessment = new RedoneAssessment();
        assessment.openBrowser();
        assessment.searchForAProduct();
        assessment.hoverOverTheProduct();
        assessment.proceedToCheckOut();
        assessment.fillInTheDetails();
        assessment.uncheckTheStoreNewsletter();
        assessment.completeCheckout();
    }
}
