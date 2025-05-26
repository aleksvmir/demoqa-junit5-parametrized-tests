package guru.qa.utils;

public enum Gender {
    MALE,
    FEMALE,
    OTHER;

    @Override
    public String toString() {
        return name().charAt(0) + name().substring(1).toLowerCase();
    }
}