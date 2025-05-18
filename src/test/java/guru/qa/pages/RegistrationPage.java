package guru.qa.pages;

import guru.qa.pages.components.CalendarComponent;
import guru.qa.pages.components.CheckResultComponent;

import java.io.File;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {

    private CalendarComponent calendar = new CalendarComponent();

    public RegistrationPage openPage() {
        open("/automation-practice-form");
        return this;
    }

    public RegistrationPage setFirstName(String value) {
        $("#firstName").setValue(value);
        return this;
    }

    public RegistrationPage setLastName(String value) {
        $("#lastName").setValue(value);
        return this;
    }

    public RegistrationPage setEmail(String value) {
        $("#userEmail").setValue(value);
        return this;
    }

    public RegistrationPage selectGender(String gender) {
        $(byText(gender)).click();
        return this;
    }

    public RegistrationPage setPhoneNumber(String number) {
        $("#userNumber").setValue(number);
        return this;
    }

    public RegistrationPage setDateOfBirth(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        calendar.setDate(day, month, year);
        return this;
    }

    public RegistrationPage setSubjects(String subject) {
        $("#subjectsInput").setValue(subject).pressEnter();
        return this;
    }

    public RegistrationPage selectHobby(String hobby) {
        $(byText(hobby)).click();
        return this;
    }

    public RegistrationPage uploadPicture(String fileName) {
        $("#uploadPicture").uploadFile(new File("src/test/resources/" + fileName));
        return this;
    }

    public RegistrationPage setAddress(String address) {
        $("#currentAddress").setValue(address);
        return this;
    }

    public RegistrationPage selectState(String state) {
        $("#state").click();
        $(byText(state)).click();
        return this;
    }

    public RegistrationPage selectCity(String city) {
        $("#city").click();
        $(byText(city)).click();
        return this;
    }

    public RegistrationPage submitForm() {
        $("#submit").scrollTo().click();
        return this;
    }

    public CheckResultComponent checkResultTable() {
        return new CheckResultComponent();
    }
}
