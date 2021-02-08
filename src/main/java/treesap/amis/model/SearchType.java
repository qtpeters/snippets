package treesap.amis.model;

public enum SearchType {
    EQUALS("equals"),
    BEGINS_WITH("beginsWith"),
    ENDS_WITH("endsWith"),
    CONTAINS("contains");

    public final String typeString;

    private SearchType(String typeString) {
        this.typeString = typeString;
    }
}
