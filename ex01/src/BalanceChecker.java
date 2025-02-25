/**
 * File for balance checks on string
 *
 * @author: Michael Kaiser
 * @version 1.0
 */

import utils.MyStack;

import javax.management.openmbean.InvalidKeyException;

/**
 *
 * Class that is used to check the balance of a string based on its quotes and parenthesis
 */
public class BalanceChecker {

    private final String opening;
    private final String closing;

    /**
     * constructor
     */
    public BalanceChecker() {
        this.opening = "({[";
        this.closing = ")]}";
    }

    /**
     * functio to check if a string is balanced in terms of opening and closing characters
     * @param value
     */
    public boolean checkBalance(String value) {
        MyStack<String> myStack = new MyStack<>();
        for (int i = 0; i < value.length(); i++) {

            char character = value.charAt(i);
            String myString = String.valueOf(character);

            if (this.isOpening(character)) {
                myStack.push(myString);
            }

            else if (this.isClosing(character)) {
                if (myStack.top().equals(String.valueOf(this.getOppositeChar(character)))) {
                    myStack.pop();
                } else {
                    return false;
                }
            }
        }
        return myStack.isEmpty();
    }

    /**
     * Checks if a character is an opening character as defined in the exercise or not
     * @param character the character tho check for
     * @return true if the character is opening
     */
    private boolean isOpening(char character) {
        return this.opening.contains(String.valueOf(character));
    }

    /**
     * Checks if a character is a closing character as defined in the exercise or not
     * @param character the character tho check for
     * @return True if the character is closing
     */
    private boolean isClosing(char character) {
        return this.closing.contains(String.valueOf(character));
    }

    /**
     * Method to get the opposite character to then check the stack.
     * @param character
     * @return
     */
    private char getOppositeChar(char character) {

        return switch (character) {
            case '(' -> ')';
            case ')' -> '(';
            case '{' -> '}';
            case '}' -> '{';
            case '[' -> ']';
            case ']' -> '[';
            default -> throw new InvalidKeyException("This character is not allowed for parsing");
        };
    }

    private char getOppositeChar(String character){
        assert character.length() == 1;
        return this.getOppositeChar(character.charAt(0));
    }
}
