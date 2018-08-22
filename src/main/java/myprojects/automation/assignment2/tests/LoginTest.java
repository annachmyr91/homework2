package myprojects.automation.assignment2.tests;

import myprojects.automation.assignment2.BaseScript;
import myprojects.automation.assignment2.utils.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginTest extends BaseScript {

    public static void main(String[] args) throws InterruptedException {
        // TODO Script to execute login and logout steps


        WebDriver driver = getDriver();

        driver.get(Properties.getBaseAdminUrl());
        Thread.sleep(1000);
        driver.findElement(By.id("email")).sendKeys("webinar.test@gmail.com");
        driver.findElement(By.id("passwd")).sendKeys("Xcg7299bnSmMuRLp9ITw");
        driver.findElement(By.className("btn-lg")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("header_employee_box")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("header_logout")).click();

        driver.quit();
    }
}

