package models;

public class Symbol {
    private char symbolChar;

    public Symbol(char symbol) {
        this.symbolChar = symbol;
    }

    // Once you set the symbol via constructor you can not cahange it so no setter only getter
    public char getSymbolChar() {
        return symbolChar;
    }
}
