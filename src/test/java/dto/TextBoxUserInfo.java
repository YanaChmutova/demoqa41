package dto;

public class TextBoxUserInfo {
    String name;
    String email;
    String CurrentAddress;
    String PermanentAddress;

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getCurrentAddress() {
        return CurrentAddress;
    }

    public String getPermanentAddress() {
        return PermanentAddress;
    }

    public TextBoxUserInfo withName(String name) {
        this.name = name;
        return this;
    }

    public TextBoxUserInfo withEmail(String email) {
        this.email = email;
        return this;
    }

    public TextBoxUserInfo withCurrentAddress(String currentAddress) {
        CurrentAddress = currentAddress;
        return this;
    }

    public TextBoxUserInfo withPermanentAddress(String permanentAddress) {
        PermanentAddress = permanentAddress;
        return this;
    }
}
