package ru.university.model;

public class Curator {
    private int id;
    private String surname;
    private String name;
    private int groupId;

    public Curator(int id, String surname, String name, int groupId) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.groupId = groupId;
    }
}
