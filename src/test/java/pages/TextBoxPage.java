package pages;

import dto.TextBoxUserInfo;
import net.bytebuddy.agent.builder.AgentBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;

public class TextBoxPage extends BasePage{

    By inputUserName = By.xpath("//input[@id='userName']");
    By inputUserEmail = By.xpath("//input[@id='userEmail']");
    By placeHolderAddress = By.xpath("//textarea[@id='currentAddress']");
    By getPlaceHolderPermanentAddress = By.xpath("//textarea[@id='permanentAddress']");
    By btnSubmit = By.xpath("//button[@id='submit']");
    By resultsTextBox = By.xpath("//div[@id='output']//p");

public void fillForm(TextBoxUserInfo textBoxUserInfo){
    sendTextBase(inputUserName, textBoxUserInfo.getName());
    sendTextBase(inputUserEmail, textBoxUserInfo.getEmail());
    sendTextBase(placeHolderAddress, textBoxUserInfo.getCurrentAddress());
    sendTextBase(getPlaceHolderPermanentAddress, textBoxUserInfo.getPermanentAddress());
    clickBase(btnSubmit);
}

    public boolean validateUrlTextBoxCorrect() {
        String url = "https://demoqa.com/text-box";
        String currentUrl = getCurrentUrlBase();
        return isTextEqualBy2Strings(currentUrl,url);
    }

    public boolean validateUserInfoDisplayCorrect(TextBoxUserInfo textBoxUserInfo) {
        List<WebElement> elements = findElementsBase(resultsTextBox);
        String result = "";
        for(WebElement e: elements){
            result = result + getTextBaseByElement(e);
        }
        if(result.contains(textBoxUserInfo.getName())
        && result.contains(textBoxUserInfo.getEmail())
        && result.contains(textBoxUserInfo.getCurrentAddress())
        && result.contains(textBoxUserInfo.getPermanentAddress())) {
            return true;
        } else {
            return false;
        }
    }
}
