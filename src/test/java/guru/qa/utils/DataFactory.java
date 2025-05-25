package guru.qa.utils;

import java.util.Date;

public class DataFactory {
    private final DataGenerator dataGenerator = new DataGenerator();

    public StudentFormData generateFullStudentFormData() {
        StudentFormData student = new StudentFormData();
        student.setFirstName(dataGenerator.getFirstName());
        student.setLastName(dataGenerator.getLastName());
        student.setEmail(dataGenerator.getEmail());
        student.setGender(dataGenerator.getGender());
        student.setPhoneNumber(dataGenerator.getPhoneNumber());

        Date birthday = dataGenerator.getBirthday();
        student.setDay(dataGenerator.getDay(birthday));
        student.setMonth(dataGenerator.getMonth(birthday));
        student.setYear(dataGenerator.getYear(birthday));

        student.setSubject(dataGenerator.getSubject());
        student.setHobby(dataGenerator.getHobby());
        student.setPictureName(dataGenerator.getPictureName());
        student.setAddress(dataGenerator.getAddress());

        String state = dataGenerator.getState();
        student.setState(state);
        student.setCity(dataGenerator.getCity(state));

        return student;
    }

    public StudentFormData generateMinimalStudentFormData() {
        StudentFormData student = new StudentFormData();
        student.setFirstName(dataGenerator.getFirstName());
        student.setLastName(dataGenerator.getLastName());
        student.setGender(dataGenerator.getGender());
        student.setPhoneNumber(dataGenerator.getPhoneNumber());

        Date birthday = dataGenerator.getBirthday();
        student.setDay(dataGenerator.getDay(birthday));
        student.setMonth(dataGenerator.getMonth(birthday));
        student.setYear(dataGenerator.getYear(birthday));

        return student;
    }

    public TextBoxFormData generateTextBoxData() {
        TextBoxFormData data = new TextBoxFormData();
        data.setFullName(dataGenerator.getFullName());
        data.setEmail(dataGenerator.getEmail());
        data.setCurrentAddress(dataGenerator.getCurrentAddress());
        data.setPermanentAddress(dataGenerator.getPermanentAddress());
        return data;
    }
}