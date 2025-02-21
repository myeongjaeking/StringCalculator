package separator;

public enum Separator {

    COLON_SEPARATOR(":"),
    REST_SEPARATOR(",");

    private final String separator;

    Separator(String separator) {
        this.separator = separator;
    }

    public String getSeparator() {
        return this.separator;
    }

}