package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;


//Question: Write a Cypress test script to automate the process of
//a. searching for a product (phone) on the site.
//b. Hover over the product, and click the cart icon from the icons displayed.
//c. Proceed to checkout from the popup displayed.
//d. Fill in the details
//e. Uncheck the store newsletter
//f. Complete checkout

public class AssessmentOne {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\USER\\Downloads\\AssessmentDOne\\src\\chromedriver.exe");
        //launch browser
        WebDriver driver = new ChromeDriver();
        //maximize browser
        driver.manage().window().maximize();
        //wait for an element to appear on the page
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        System.out.println("Browser launched");
        //navigate to url
        driver.get("https://ecommerce-playground.lambdatest.io/");

        //searching for a product (phone) on the site.
        driver.findElement(By.xpath("//body[1]/div[1]/div[5]/header[1]/div[2]/div[1]/div[2]/div[1]" +
                "/form[1]/div[1]/div[1]/div[1]/div[2]/input[1]")).sendKeys("phone");
        driver.findElement(By.xpath("//body[1]/div[1]/div[5]/header[1]/div[2]/div[1]/div[2]/div[1]" +
                "/form[1]/div[1]/div[1]/div[1]/div[2]/input[1]")).sendKeys(Keys.ENTER);
        System.out.println("Phone search successful");

        //Hover over the product, and click the cart icon from the icons displayed.
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,700)");
        WebElement phone = driver.findElement(By.xpath("//body/div[1]/div[6]/div[1]/div[2]/div[1]/div[1]" +
                        "/div[5]/div[1]/div[4]/div[1]/div[1]/div[1]/a[1]/div[1]/div[1]/img[1]"));
        Actions mouse = new Actions(driver);
        mouse.moveToElement(phone).build().perform();
        driver.findElement(By.xpath("//body/div[1]/div[6]/div[1]/div[2]/div[1]/div[1]/div[5]/div[1]" +
                "/div[4]/div[1]/div[1]/div[2]/button[1]")).click();
        System.out.println("Successfully clicked on cart icon");

        //Proceed to checkout from the popup displayed.
        driver.findElement(By.xpath("//body/div[@id='notification-box-top']/div[1]/div[2]/div[2]/div[2]/a[1]"))
                .click();
        System.out.println("Proceeded to checkout");

        //Fill in the details
        //first name
        WebElement firstName = driver.findElement(By.xpath("//input[@id='input-payment-firstname']"));
        firstName.sendKeys("Lazbat");
        //last name
        WebElement lastName = driver.findElement(By.xpath("//input[@id='input-payment-lastname']"));
        lastName.sendKeys("Babayale");
        //email
        WebElement email = driver.findElement(By.xpath("//input[@id='input-payment-email']"));
        email.sendKeys("daisy@mailinator.com");
        //telephone
        WebElement telephone = driver.findElement(By.xpath("//input[@id='input-payment-telephone']"));
        telephone.sendKeys("+2348060302552");
        //password
        WebElement password = driver.findElement(By.xpath("//input[@id='input-payment-password']"));
        password.sendKeys("Beta123.");
        //confirm password
        WebElement passwordConfirm = driver.findElement(By.xpath("//input[@id='input-payment-confirm']"));
        passwordConfirm.sendKeys("Beta123.");
        //company
        WebElement company = driver.findElement(By.xpath("//input[@id='input-payment-company']"));
        company.sendKeys("Travel Beta");
        //address1
        WebElement address1 = driver.findElement(By.xpath("//body[1]/div[1]/div[5]/div[1]/div[1]/div[1]" +
                "/form[1]/div[1]/div[1]/div[1]/div[3]/div[2]/div[2]/div[1]/input[1]"));
        address1.sendKeys("14, Ojuelegba");
        //address2
        WebElement address2 = driver.findElement(By.xpath("//body[1]/div[1]/div[5]/div[1]/div[1]/div[1]" +
                "/form[1]/div[1]/div[1]/div[1]/div[3]/div[2]/div[3]/div[1]/input[1]"));
        address2.sendKeys("14, Ojuelegba");
        //city
        WebElement city = driver.findElement(By.xpath("//input[@id='input-payment-city']"));
        city.sendKeys("Surulere");
        //postcode
        WebElement postCode = driver.findElement(By.xpath("//input[@id='input-payment-postcode']"));
        postCode.sendKeys("101302");
        //country
        WebElement selectCountry = driver.findElement(By.xpath("//select[@id='input-payment-country']"));
        Select country = new Select(selectCountry);
        country.selectByVisibleText("Nigeria");
        //state/region
        WebElement selectState = driver.findElement(By.xpath("//select[@id='input-payment-zone']"));
        Select state = new Select(selectState);
        state.selectByVisibleText("Lagos");
        System.out.println("All required fields filled");

        //Uncheck the store newsletter
        WebElement newsLetterCheckBox = driver.findElement(By.xpath("//body/div[1]/div[5]/div[1]/div[1]/div[1]/form[1]/div[1]/div[2]/div[1]/div[3]"));
        newsLetterCheckBox.click();
        //if (newsLetterCheckBox.isSelected()) {
           // newsLetterCheckBox.click();
        //}
        System.out.println("Unchecked store newsletter");

        //Complete checkout
        driver.findElement(By.xpath("//body/div[1]/div[5]/div[1]/div[1]/div[1]/form[1]/div[1]/div[2]/div[1]/div[4]")).click();
        driver.findElement(By.xpath("//body/div[1]/div[5]/div[1]/div[1]/div[1]/form[1]/div[1]/div[2]/div[1]/div[5]")).click();
        WebElement continueButton = driver.findElement(By.xpath("//button[@id='button-save']"));
        continueButton.click();
        js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");
        WebElement confirmOrderButton = driver.findElement(By.xpath("//button[@id='button-confirm']"));
        confirmOrderButton.click();
        System.out.println("Checkout successful");
        driver.findElement(By.xpath("//a[contains(text(),'Continue')]")).click();

        driver.quit();

    }
}
