package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.*;

public class Experiment1 {

    @Test
    public void switchTab(){
        WebDriver driver = new FirefoxDriver();
        driver.get("https://demoqa.com/browser-windows");
        driver.manage().window().maximize();

        String mainWindowHandler = driver.getWindowHandle(); // Получает идентификатор текущего (главного) окна браузера и сохраняет его в переменной mainWindowHandler.
        WebElement newButton = driver.findElement(By.xpath("//button[@id='tabButton']")); //Находим кнопку
        newButton.click(); // и жмем на нее, чтобы открыть новую вкладку.

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));// Создает объект WebDriverWait, который будет ожидать на протяжении 5 секунд, чтобы выполнить следующую команду.
        wait.until(ExpectedConditions.numberOfWindowsToBe(2)); // Ожидает, пока количество открытых окон в браузере не станет равным 2.
        Set<String> allWindowHandles = driver.getWindowHandles();// Получает все идентификаторы окон, открытых в браузере, и сохраняет их в коллекции типа Set<String>.

        String newWindowHandler = ""; // Объявляет переменную newWindowHandler, которая будет использоваться для хранения идентификатора нового окна или вкладки.
        for (String windowHandle : allWindowHandles){ // Пробегаемся по всем идентификаторам окон, найденным на предыдущем шаге.
            if(!windowHandle.equals(mainWindowHandler)){ // Проверяем, является ли текущий идентификатор окна отличным от идентификатора главного окна, сохраненного на первом шаге.
                newWindowHandler = windowHandle;// Если идентификатор окна отличается от главного, сохраняем этот идентификатор в переменной newWindowHandler и завершаем цикл.
                break;
            }
        }
        driver.switchTo().window(newWindowHandler); // Переключаемся на новую вкладку, используя его идентификатор.
        WebElement newPageElement = driver.findElement(By.xpath("//h1[@id='sampleHeading']"));//  пытаемся найти элемент на новой вкладке.
        newPageElement.click();
        driver.quit();

    }

    @Test
    public static void switchTabByIndex(){
        WebDriver driver = new FirefoxDriver();
        driver.get("https://demoqa.com/browser-windows");
        driver.manage().window().maximize();

        WebElement newButton = driver.findElement(By.xpath("//button[@id='tabButton']")); //Находим кнопку
        newButton.click(); // и жмем на нее, чтобы открыть новую вкладку.

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));// Создает объект WebDriverWait, который будет ожидать на протяжении 5 секунд, чтобы выполнить следующую команду.
        wait.until(ExpectedConditions.numberOfWindowsToBe(2)); // Ожидает, пока количество открытых окон в браузере не станет равным 2.

        Set <String> handles = driver.getWindowHandles();

        driver.switchTo().window(handles.toArray()[1].toString());

        WebElement newPageElement = driver.findElement(By.xpath("//h1[@id='sampleHeading']"));//  пытаемся найти элемент на новой вкладке.
        newPageElement.click();
        driver.quit();

    }

    @Test
    public void iframeTest() throws InterruptedException {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://the-internet.herokuapp.com/iframe");
        driver.manage().window().maximize();

        Thread.sleep(2000);
        By textElementInIframe = By.xpath("//body[@id='tinymce']/p");

        List<WebElement> beforeIframe = driver.findElements(textElementInIframe);
        System.out.println("before switch to iframe should be zero: " + beforeIframe.size());

        //driver.switchTo().frame(0);
        driver.switchTo().frame("mce_0_ifr");

        List<WebElement> insideIframe = driver.findElements(textElementInIframe);
        System.out.println("after switch to iframe should be one: " + insideIframe.size());

        driver.switchTo().defaultContent();

        List<WebElement> backToDefault = driver.findElements(textElementInIframe);
        System.out.println("after switch back to default should be zero: " + backToDefault.size());

        driver.quit();

    }

    @Test
    public void iFrameNestedTest() throws InterruptedException {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://the-internet.herokuapp.com/nested_frames");
        driver.manage().window().maximize();

        Thread.sleep(2000);

        By bodyTag = By.xpath("//body");
        System.out.println("bot a frame, size 0: " + driver.findElements(bodyTag).size());

        driver.switchTo().frame("frame-top");
        driver.switchTo().frame(0);
        System.out.println("LEFT: " + driver.findElement(bodyTag).getText());

        driver.switchTo().defaultContent();
        driver.switchTo().defaultContent();

        driver.switchTo().frame("frame-bottom");
        System.out.println("Bottom: " + driver.findElement(bodyTag).getText());

        driver.quit();
    }

    @Test
    public void testRectangle() throws InterruptedException {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://demoqa.com/slider");
        driver.manage().window().maximize();
        WebElement range =
                driver.findElement(By.xpath("//input[@type='range']"));

        Rectangle rectangleRange = range.getRect();
        int widthRange = rectangleRange.width;
        System.out.println("width: " + widthRange);

        Actions actions = new Actions(driver);
        actions.moveToElement(range).perform();

        int xLocation = range.getLocation().getX();
        System.out.println("x location: " + xLocation);

        //  int xTo = (widthRange - xLocation) / 2;
        int xTo = (widthRange) / 3;

        actions.moveByOffset(xTo, 0).click().perform();

        Thread.sleep(5000);

        driver.quit();

    }

    // TODO iframe

    @Test
    public void softAssertsTest() {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://demoqa.com/text-box");
        driver.manage().window().maximize();

        SoftAssert softAssert = new SoftAssert();
        String text = driver.findElement(By.xpath("//label[@id='currentAddress-label']")).getText();
        // Current Address
        softAssert.assertTrue(text.contains("Current"), "current");
        //  softAssert.assertTrue(text.contains("name"), "name");
        softAssert.assertTrue(text.contains("Address"));
        System.out.println("all tests checked");
        driver.quit();
        softAssert.assertAll();

    }



}