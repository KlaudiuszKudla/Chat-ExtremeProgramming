package org.example.auth.entity;

public enum Code {
    SUCCESS("Operacja zakończona sukcesem"),
    USER_EXIST_WITH_NAME("Użytkownik o podanej nazwie juz istnieje"),
    USER_EXIST_WITH_MAIL("Użytkownik o podanmym mailu juz istnieje");

    public final String label;
    private Code(String label){
        this.label = label;
    }
}
