package pages;

public class TextBoxPage extends BasePage{
    public boolean validateUrlTextBoxCorrect() {
        String url = "https://demoqa.com/text-box";
        String currentUrl = getCurrentUrlBase();
        return isTextEqualBy2Strings(currentUrl,url);
    }
}
