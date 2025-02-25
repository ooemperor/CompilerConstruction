package tree_v1;

/**
 * Operation definition Enum
 */
public enum Operation {
    addition("addition"), mult("mult"), number("number");

    private final String operation;

    private Operation(String operation){
        this.operation = operation;
    }
}
