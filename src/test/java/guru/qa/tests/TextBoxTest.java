package guru.qa.tests;

import guru.qa.commonconfig.TestConfig;
import guru.qa.pages.TextBoxPage;
import guru.qa.utils.DataFactory;
import guru.qa.utils.TextBoxFormData;
import org.junit.jupiter.api.Test;

public class TextBoxTest extends TestConfig {

    TextBoxPage textBoxPage = new TextBoxPage();
    DataFactory dataFactory = new DataFactory();

    @Test
    void successfulFillingFormTest() {
        TextBoxFormData formData = dataFactory.generateTextBoxData();

        textBoxPage.openPage()
                .setName(formData.getFullName())
                .setMail(formData.getEmail())
                .setCurrentAddress(formData.getCurrentAddress())
                .setPermanentAddress(formData.getPermanentAddress())
                .submitForm()
                .checkResultBox("Name:", formData.getFullName())
                .checkResultBox("Email:", formData.getEmail())
                .checkResultBox("Current Address :", formData.getCurrentAddress())
                .checkResultBox("Permananet Address :", formData.getPermanentAddress());
    }
}