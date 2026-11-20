package ru.netology.javaqa__collection_crud_testing;

public class NotRegisteredException extends RuntimeException {
    public NotRegisteredException(String playerName) {
        super("Игрок с именем " + playerName + " не зарегистрирован в турнире");
    }
}

