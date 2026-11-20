package ru.netology.javaqa__collection_crud_testing;

import java.util.ArrayList;
import java.util.List;

// Класс для управления турниром
public class Game {
    private List<Player> players = new ArrayList<>();

    // Метод регистрации игрока
    public void register(Player player) {
        players.add(player);
    }

    // Метод поиска информации об игроке
    public Player findByName(String name) {
        for (Player player : players) {
            if (player.getName().equals(name)) {
                return player;
            }
        }
        return null;
    }

    // Метод соревнования между двумя игроками: проверка наличия регистрации и сравнение силы игроков.
    public int round(String playerName1, String playerName2) {
        Player player1 = findByName(playerName1);
        Player player2 = findByName(playerName2);

        if (player1 == null) {
            throw new NotRegisteredException(playerName1);
        }
        if (player2 == null) {
            throw new NotRegisteredException(playerName2);
        }

        if (player1.getStrength() > player2.getStrength()) {
            return 1;
        }
        if (player1.getStrength() < player2.getStrength()) {
            return 2;
        }
        return 0;
    }
}
