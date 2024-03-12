package tests;

import config.ConfigManager;
import dto.TextBoxUserInfo;
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

    @Test(description = "test with filling all fields in the form and validate the common result")
    public void testForm(){
        TextBoxUserInfo textBoxUserInfo = new TextBoxUserInfo()
                .withName("John")
                .withEmail("john@gmail.com")
                .withCurrentAddress("first street")
                .withPermanentAddress("second street");
        textBoxPage.fillForm(textBoxUserInfo);
//        try {
//            Thread.sleep(10000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
        Assert.assertTrue(textBoxPage.validateUserInfoDisplayCorrect(textBoxUserInfo));
    }
}
