package tests;

import config.ConfigManager;
import org.junit.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TextBoxTests extends BaseTest {

    @BeforeClass
    public void beforeClass() {
        ConfigManager.navigateToMainPage();
        mainPage.openElementsPage();
        elementsPage.openTextBoxPage();
    }

    @Test
    public void textBoxPageOpened() {

        Assert.assertTrue(textBoxPage.validateUrlTextBoxCorrect());
    }
}
