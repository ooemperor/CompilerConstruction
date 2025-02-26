package splprime.scan;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import static splprime.SplPrime.error;


public class Scanner {

    // In and output
    private final String source;
    private final List<Token> tokens = new ArrayList<>();

    private int current = 0;
    private int line = 0;

    private HashMap<String, TokenType> keywords = new HashMap<>();

    public Scanner(String source) {
        this.source = source;
        this.keywords.put("true", TokenType.TRUE);
        this.keywords.put("false", TokenType.FALSE);
        this.keywords.put("and", TokenType.AND);
        this.keywords.put("or", TokenType.OR);
        this.keywords.put("var", TokenType.VAR);
        this.keywords.put("print", TokenType.PRINT);
        this.keywords.put("if", TokenType.IF);
        this.keywords.put("else", TokenType.ELSE);
        this.keywords.put("while", TokenType.WHILE);

    }

    // Scan tokens
    public List<Token> scanTokens() {
        // TODO
        while (!this.isEnd()) {
            // parse for the next Token
            int start = this.current;

            char c = this.advance();
            switch (c) {
                // start with the brackets and braces
                case '(':
                    this.tokens.add(new Token(TokenType.LEFT_PAREN, String.valueOf(c), null, this.line));
                    break;

                case ')':
                    this.tokens.add(new Token(TokenType.RIGHT_PAREN, String.valueOf(c), null, this.line));
                    break;

                case '{':
                    this.tokens.add(new Token(TokenType.LEFT_BRACE, String.valueOf(c), null, this.line));
                    break;

                case '}':
                    this.tokens.add(new Token(TokenType.RIGHT_BRACE, String.valueOf(c), null, this.line));
                    break;

                case ';':
                    this.tokens.add(new Token(TokenType.SEMICOLON, String.valueOf(c), null, this.line));
                    break;

                // mathematical operators
                case '+':
                    this.tokens.add(new Token(TokenType.PLUS, String.valueOf(c), null, this.line));
                    break;

                case '-':
                    this.tokens.add(new Token(TokenType.MINUS, String.valueOf(c), null, this.line));
                    break;

                case '*':
                    this.tokens.add(new Token(TokenType.MUL, String.valueOf(c), null, this.line));
                    break;

                case '/':
                    if (this.match('/')) {
                        // the following is a comment
                        while (this.advance() != '\n' && this.peek() != '\n' && !this.isEnd()) {
                            this.advance();
                        }
                    } else {
                        this.tokens.add(new Token(TokenType.DIV, String.valueOf(c), null, this.line));
                    }
                    break;

                case '=':
                    if (this.match('=')){
                        this.tokens.add(new Token(TokenType.EQUAL_EQUAL, "==", null, this.line));
                    } else {
                        this.tokens.add(new Token(TokenType.EQUAL, "=", null, this.line));
                    }
                    break;

                case '!':
                    if (this.match('=')) {
                        this.tokens.add(new Token(TokenType.NOT_EQUAL, "!=", null, this.line));
                    }
                    break;

                case '>':
                    if (this.match('=')) {
                        this.tokens.add(new Token(TokenType.GREATER_THAN_EQUAL, ">=", null, this.line));
                    } else {
                        this.tokens.add(new Token(TokenType.GREATER_THAN, ">", null, this.line));
                    }
                    break;

                case '<':
                    if (this.match('=')) {
                        this.tokens.add(new Token(TokenType.LESS_THAN_EQUAL, "<=", null, this.line));
                    } else {
                        this.tokens.add(new Token(TokenType.LESS_THAN, "<", null, this.line));
                    }
                    break;

                //strings
                case '"':
                    while (this.peek() != '"' && !this.isEnd()) {
                        this.advance();
                    }
                    if (this.isEnd()) {
                        error(this.line, "Unexpected end of string");
                    }
                    this.advance();
                    String stringValue = source.substring(start + 1, current - 1);
                    this.tokens.add(new Token(TokenType.STRING, stringValue, stringValue, this.line));
                    break;

                // Identifiers and keywords
                case 'a': case 'b': case 'c': case 'd': case 'e': case 'f': case 'g':
                case 'h': case 'i': case 'j': case 'k': case 'l': case 'm': case 'n':
                case 'o': case 'p': case 'q': case 'r': case 's': case 't': case 'u':
                case 'v': case 'w': case 'x': case 'y': case 'z':
                case 'A': case 'B': case 'C': case 'D': case 'E': case 'F': case 'G':
                case 'H': case 'I': case 'J': case 'K': case 'L': case 'M': case 'N':
                case 'O': case 'P': case 'Q': case 'R': case 'S': case 'T': case 'U':
                case 'V': case 'W': case 'X': case 'Y': case 'Z': case '_':
                    while (this.isAlpha(this.peek()) && !this.isEnd()) {
                        this.advance();
                    }
                    String identValue = this.source.substring(start, this.current);
                    TokenType type = this.keywords.get(identValue);

                    if (type == null) {
                        // it is not a keyword --> is identifier
                        this.tokens.add(new Token(TokenType.IDENTIFIER, identValue, identValue, this.line));
                    }
                    else {
                        this.tokens.add(new Token(type, identValue, null, this.line));
                    }
                    break;

                // numbers
                case '1': case '2': case '3': case '4': case '5': case '6': case '7': case '8': case '9': case '0':
                    while ((this.isNumeric(this.peek()) || this.peek() == '.') && !this.isEnd()) {
                        this.advance();
                    }
                    String value = source.substring(start, current);
                    this.tokens.add(new Token(TokenType.NUMBER, value, value, this.line));
                    break;

                case ' ':
                case '\t':
                case '\r':
                    // ignore blank spaces
                    break;

                case '\n':
                    this.line++;
                    break;

                default:
                    error(this.line, "Unexpected character '" + c + "'");
            }


        }
        return tokens;
    }

    /**
     * Fetch the next token and incremet the current index
     * @return the next character
     */
    private char advance() {
        return this.source.charAt(this.current++);
    }

    /**
     * Peek the next character without moving forward
     * @return the next character
     */
    private char peek() {
        return this.source.charAt(this.current);
    }

    /**
     * check if the next character is the expected one
     * @param expected the character that we expect to be the next one
     * @return if the expected one matches the next one
     */
    private boolean match(char expected) {
        if (this.isEnd()) {
            return false;
        } else if (this.source.charAt(this.current) != expected) {
            return false;
        }
        this.current++;
        return true;
    }

    /**
     * Check if character is Numeric
     * @param c the character to check
     * @return If char is numeric or not
     */
    private boolean isNumeric(char c) {
        return (c >= '0' && c <= '9');
    }

    /**
     * Check if character is Alpha numeric
     * @param c the character to check
     * @return If char is Alpha numeric or not
     */
    private boolean isAlpha(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || c == '_' || this.isNumeric(c);
    }

    /**
     * Check if we are at the end of the input
     * @return True if we are at the end of the input
     */
    private boolean isEnd() {
        return this.current == this.source.length();
    }
}
