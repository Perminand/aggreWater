package ru.perminov.aggrewater.exceptions.errors;

public class DuplicatedDataException extends RuntimeException {
    public DuplicatedDataException (String s) {
        super(s);
    }
}
