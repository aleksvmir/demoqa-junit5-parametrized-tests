package guru.qa.data.enums;

public enum GenderType {
    MALE,
    FEMALE,
    OTHER;

    @Override
    public String toString() {
        return name().charAt(0) + name().substring(1).toLowerCase();
    }
}