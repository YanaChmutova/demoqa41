package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.Set;

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
    public void testRectangle() {
        // TODO
    }

    // TODO SoftAsserts

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