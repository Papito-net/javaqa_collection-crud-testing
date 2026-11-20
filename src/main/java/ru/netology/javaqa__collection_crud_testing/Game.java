package ru.netology.javaqa__collection_crud_testing;


import java.util.HashMap;
import java.util.Map;

// Класс для управления турниром
public class Game {
    // Замена List<Player> на Map<String, Player>
    private Map<String, Player> players = new HashMap<>();

    // В метод регистрации игрока добавляем пару: ключ(имя)-значение(объект)
    public void register(Player player) {
        players.put(player.getName(), player);
    }

    // Метод поиска информации об игроке
    public Player findByName(String name) {
        // Убрали цикл. Метод get() сразу вернет игрока по ключу или null, если его нет
        return players.get(name);
    }

    // Метод соревнования между двумя игроками: проверка наличия регистрации и сравнение силы игроков
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
