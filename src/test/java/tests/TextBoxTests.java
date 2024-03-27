package tests;

import config.ConfigManager;
import dto.TextBoxUserInfo;
import io.qameta.allure.Allure;
import org.junit.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.ScreenShotManager;

public class TextBoxTests extends BaseTest {

    @BeforeClass
    public void beforeClass() {
        Allure.step("open main page");
        ConfigManager.navigateToMainPage();
        Allure.step("open elements page");
        mainPage.openElementsPage();
        Allure.step("open text box page");
        elementsPage.openTextBoxPage();
    }

    @Test(description = "validate that the text box page opened by url")
    public void textBoxPageOpened() {
        Allure.description("validate that the text box page opened by url");
        Allure.step("make screenshot");
        ScreenShotManager.takeScreenshot("textBoxPageOpened ");
        Allure.step("assert actual url equal to expected");
        Assert.assertTrue(textBoxPage.validateUrlTextBoxCorrect());
    }

    @Test(description = "test with filling all fields in the form and validate the common result")
    public void testForm(){
        Allure.description("test with filling all fields in the form and validate the common result");
        Allure.step("create and fill object TextBoxUserInfo");
        TextBoxUserInfo textBoxUserInfo = new TextBoxUserInfo()
                .withName("John")
                .withEmail("john@gmail.com")
                .withCurrentAddress("first street")
                .withPermanentAddress("second street");
        Allure.step("fill form and send data to inputs and click on the submit button");
        textBoxPage.fillForm(textBoxUserInfo);
//        try {
//            Thread.sleep(10000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
        Allure.step("make screenshot");
        ScreenShotManager.takeScreenshot("testForm ");
        Allure.step("validate info displays the same with created");
        Assert.assertTrue(textBoxPage.validateUserInfoDisplayCorrect(textBoxUserInfo));
    }
}
