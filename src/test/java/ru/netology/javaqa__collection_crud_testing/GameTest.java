package ru.netology.javaqa__collection_crud_testing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GameTest {
    private Game game;
    // Поля класса указаны в начале тестов, чтобы быть доступными всем тестам ниже
    private Player player1;
    private Player player2;
    private Player player3;

    // Указание JUnit, что метод setup() нужно запускать заново перед каждым @Test
    @BeforeEach
    public void setup() {
        game = new Game();
        player1 = new Player(1, "Игрок1", 200);
        player2 = new Player(2, "Игрок2", 250);
        player3 = new Player(3, "Игрок3", 200);

        game.register(player1);
        game.register(player2);
        game.register(player3);
    }

    @Test
    public void shouldWinWhenFirstPlayerStronger() {
        // Сила первого больше
        int expected = 1;
        int actual = game.round("Игрок2", "Игрок1");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldWinWhenSecondPlayerStronger() {
        // Сила второго больше
        int expected = 2;
        int actual = game.round("Игрок1", "Игрок2");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldDrawWhenStrengthsAreEqual() {
        // Сила равна - ничья (0)
        int expected = 0;
        int actual = game.round("Игрок1", "Игрок3");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFailIfFirstPlayerUnregistered() {
        // Игрок "Игрок4" не зарегистрирован в setup()
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Игрок4", "Игрок1");
        });
    }

    @Test
    public void shouldFailIfSecondPlayerUnregistered() {
        // Игрок "Игрок5" не зарегистрирован в setup()
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Игрок1", "Игрок5");
        });
    }

    @Test
    public void shouldFailIfBothPlayersUnregistered() {
        // Когда оба игрока не зарегистрированы
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Игрок4", "Игрок5");
        });
    }

    // Проверяем, что метод getId() действительно возвращает 1
    @Test
    public void shouldGetPlayerId() {
        long expected = 1;
        long actual = player1.getId();

        Assertions.assertEquals(expected, actual);
    }
}
