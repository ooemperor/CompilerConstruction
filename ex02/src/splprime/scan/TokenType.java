package splprime.scan;

public enum TokenType {
	// special characters characters
    LEFT_PAREN, RIGHT_PAREN, // (, )
    LEFT_BRACE, RIGHT_BRACE, // {, }
    SEMICOLON, // ; ,

    // Operators
    PLUS, MINUS, MUL, DIV, // + - * /
    EQUAL, EQUAL_EQUAL, NOT_EQUAL, // = == !=
    LESS_THAN, GREATER_THAN, // < >
    LESS_THAN_EQUAL, GREATER_THAN_EQUAL, // <= >=

    // Keywords
    TRUE, FALSE,
    AND, OR,
    VAR, PRINT,
    IF, ELSE,
    WHILE,

    STRING, NUMBER, IDENTIFIER


}
