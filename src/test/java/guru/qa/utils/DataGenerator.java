package guru.qa.utils;

import com.github.javafaker.Faker;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DataGenerator {
    private final Faker faker = new Faker(new Locale("en"));

    public String getFirstName() {
        return faker.name().firstName();
    }

    public String getLastName() {
        return faker.name().lastName();
    }

    public String getEmail() {
        return faker.internet().emailAddress();
    }

    public String getGender() {
        return faker.options().option("Male", "Female", "Other");
    }

    public String getPhoneNumber() {
        return faker.numerify("##########");
    }

    public Date getBirthday() {
        return faker.date().birthday(18, 65);
    }

    public String getDay(Date date) {
        return new SimpleDateFormat("d").format(date);
    }

    public String getMonth(Date date) {
        return new SimpleDateFormat("MMMM", Locale.ENGLISH).format(date);
    }

    public String getYear(Date date) {
        return new SimpleDateFormat("yyyy").format(date);
    }

    public String getSubject() {
        return faker.options().option("History", "Maths", "Biology");
    }

    public String getHobby() {
        return faker.options().option("Reading", "Sports", "Music");
    }

    public String getPictureName() {
        return faker.options().option("photo.png");
    }

    public String getAddress() {
        return faker.address().fullAddress();
    }

    public String getState() {
        return faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");
    }

    public String getCity(String state) {
        switch (state) {
            case "NCR": return faker.options().option("Delhi", "Gurgaon", "Noida");
            case "Uttar Pradesh": return faker.options().option("Agra", "Lucknow", "Merrut");
            case "Haryana": return faker.options().option("Karnal", "Panipat");
            case "Rajasthan": return faker.options().option("Jaipur", "Jaiselmer");
            default: return "";
        }
    }

    public String getFullName() {
        return faker.name().fullName();
    }

    public String getCurrentAddress() {
        return faker.address().streetAddress();
    }

    public String getPermanentAddress() {
        return faker.address().secondaryAddress();
    }
}