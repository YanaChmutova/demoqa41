package pages;

import org.openqa.selenium.By;

public class MainPage extends BasePage{
    By textElements = By.xpath("//h5[text()='Elements']");
    By boxElements = By.xpath("//div[contains(@class, 'avatar')]");
    String elements = "Elements";
    String boxElementsJS = "document.querySelector(\".card-body\").click();";
//    public String getTextElements(){
//        return getTextBase(textElements);
//    }

public boolean validateTextElementsCorrect(){
    return isTextEqual(textElements,elements);
}

    public void openElementsPage() {
   // clickBase(boxElements);
        jsExecutorBase(boxElementsJS);
    }
}
