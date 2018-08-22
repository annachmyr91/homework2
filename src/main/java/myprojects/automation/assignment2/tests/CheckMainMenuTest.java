package myprojects.automation.assignment2.tests;

import myprojects.automation.assignment2.BaseScript;
import myprojects.automation.assignment2.utils.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CheckMainMenuTest extends BaseScript {

    public static void main(String[] args) throws InterruptedException {
        // TODO Script to check Main Menu items

        WebDriver driver = getDriver();
        WebDriverWait wait = new WebDriverWait(driver, 15);

        driver.get(Properties.getBaseAdminUrl());
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("email"))));
        driver.findElement(By.id("email")).sendKeys("webinar.test@gmail.com");
        driver.findElement(By.id("passwd")).sendKeys("Xcg7299bnSmMuRLp9ITw");
        driver.findElement(By.className("btn-lg")).click();

        Thread.sleep(3000);
        List<WebElement> dashboardList = driver.findElements(By.xpath("(//nav/ul[contains(@class, 'menu') or contains(@class ,'main-menu')]/li/a)"));

        int dashboardListSize = dashboardList.size();
        System.out.println(dashboardListSize);

        for (int i = 0; i < dashboardListSize; i++) {

            driver.findElement(By.xpath("(//nav/ul[contains(@class, 'menu') or contains(@class ,'main-menu')]/li/a)[" + (i + 1) + "]")).click();

            String beforeRefresh = driver.findElement(By.tagName("h2")).getText();
            System.out.println(beforeRefresh);


            driver.navigate().refresh();
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//nav/ul[contains(@class, 'menu') or contains(@class ,'main-menu')]/li/a)[" + (i + 1) + "]")));
            String afterRefresh = driver.findElement(By.tagName("h2")).getText();
            System.out.println(afterRefresh);


            if (beforeRefresh.equals(afterRefresh)) {
                System.out.println("You are still at the " + afterRefresh + " page after refreshing");
            } else
                System.out.println("Something went wrong after refreshing. You are at " + afterRefresh + " page instead of " + beforeRefresh + " page");

        }

        driver.quit();
    }

}

