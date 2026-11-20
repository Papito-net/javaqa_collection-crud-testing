package ru.netology.javaqa__collection_crud_testing;

// Дата-класс для хранения данных
public class Player {
    private int id;
    private String name;
    private int strength;

    // Конструктор класса Player для создания объекта и инициализации его начальных характеристик
    public Player(int id, String name, int strength) {
        this.id = id;
        this.name = name;
        this.strength = strength;
    }

    // Специальные методы для безопасного получения значений закрытых полей объекта Player
    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getStrength() {
        return strength;
    }
}