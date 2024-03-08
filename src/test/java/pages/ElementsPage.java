package pages;

import org.openqa.selenium.By;

public class ElementsPage extends BasePage{
    By btnOpenTextBox = By.cssSelector("#item-0");
    public void openTextBoxPage() {
        clickBase(btnOpenTextBox);
    }
}
