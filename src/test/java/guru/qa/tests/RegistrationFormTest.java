package guru.qa.tests;

import guru.qa.commonconfig.TestConfig;
import guru.qa.pages.RegistrationPage;
import guru.qa.utils.StudentFormData;
import guru.qa.utils.DataFactory;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Selenide.$$;

public class RegistrationFormTest extends TestConfig {

    RegistrationPage registrationPage = new RegistrationPage();
    DataFactory studentDataFactory = new DataFactory();

    @Test
    void fillFormWithAllDataTest() {
        StudentFormData student = studentDataFactory.generateFullStudentFormData();

        registrationPage.openPage()
                .setFirstName(student.getFirstName())
                .setLastName(student.getLastName())
                .setEmail(student.getEmail())
                .selectGender(student.getGender())
                .setPhoneNumber(student.getPhoneNumber())
                .setDateOfBirth(student.getDay(), student.getMonth(), student.getYear())
                .setSubjects(student.getSubject())
                .selectHobby(student.getHobby())
                .uploadPicture(student.getPictureName())
                .setAddress(student.getAddress())
                .selectState(student.getState())
                .selectCity(student.getCity())
                .submitForm();

        registrationPage.checkResultTable()
                .verifyResult("Student Name", student.getFirstName() + " " + student.getLastName())
                .verifyResult("Student Email", student.getEmail())
                .verifyResult("Gender", student.getGender())
                .verifyResult("Mobile", student.getPhoneNumber())
                .verifyResult("Date of Birth", student.getDay() + " " + student.getMonth() + "," + student.getYear())
                .verifyResult("Subjects", student.getSubject())
                .verifyResult("Hobbies", student.getHobby())
                .verifyResult("Picture", student.getPictureName())
                .verifyResult("Address", student.getAddress())
                .verifyResult("State and City", student.getState() + " " + student.getCity());
    }

    @Test
    void fillFormMinimalRequiredDataTest() {
        StudentFormData student = studentDataFactory.generateMinimalStudentFormData();

        registrationPage.openPage()
                .setFirstName(student.getFirstName())
                .setLastName(student.getLastName())
                .selectGender(student.getGender())
                .setPhoneNumber(student.getPhoneNumber())
                .setDateOfBirth(student.getDay(), student.getMonth(), student.getYear())
                .submitForm();

        registrationPage.checkResultTable()
                .verifyResult("Student Name", student.getFirstName() + " " + student.getLastName())
                .verifyResult("Gender", student.getGender())
                .verifyResult("Mobile", student.getPhoneNumber())
                .verifyResult("Date of Birth", student.getDay() + " " + student.getMonth() + "," + student.getYear());
    }

    @Test
    void fillFormNegativeTest() {
        registrationPage.openPage()
                .submitForm();
        $$(".modal-content").shouldHave(size(0));
    }
}