package guru.qa.tests;

import guru.qa.commonconfig.TestConfig;
import guru.qa.pages.RegistrationPage;
import guru.qa.utils.Gender;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.api.DisplayName;

public class ParametrizedTest extends TestConfig {

    RegistrationPage registrationPage = new RegistrationPage();

    @DisplayName("Проверка валидации имён")
    @ParameterizedTest(name = "Валидация имени: {0}")
    @ValueSource(strings = {"Vladimir", "Mihail555", "M@xim#"})
    void firstNameValidationTest(String firstName) {
        registrationPage.openPage()
                .setBasicInfo(firstName, "Alekseev", "Male", "1234567890")
                .submitForm()
                .checkResultTable()
                .verifyResult("Student Name", firstName + " Alekseev");
    }

    @DisplayName("Проверка всех доступных гендеров")
    @ParameterizedTest(name = "Пол: {0}")
    @EnumSource(Gender.class)
    void genderSelectionTest(Gender gender) {
        registrationPage.openPage()
                .setBasicInfo("New", "User", gender.toString(), "9876543210")
                .submitForm()
                .checkResultTable()
                .verifyResult("Gender", gender.toString());
    }

    @DisplayName("Проверка комбинаций данных")
    @ParameterizedTest(name = "Комбинация: Хобби={0}, Штат={1}, Город={2}")
    @CsvSource(delimiter = '|', value = {
            "Reading|NCR|Delhi",
            "Sports|Uttar Pradesh|Agra",
            "Music|Haryana|Karnal"
    })
    void complexDataTest(String hobby, String state, String city) {
        registrationPage.openPage()
                .setBasicInfo("Vladimir", "Alekseev", "Male", "5551234567")
                .selectHobby(hobby)
                .selectState(state)
                .selectCity(city)
                .submitForm()
                .checkResultTable()
                .verifyResult("Hobbies", hobby)
                .verifyResult("State and City", state + " " + city);
    }
}