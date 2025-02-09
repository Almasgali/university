package ru.university.model;

public class Student {
    private int id;
    private String surname;
    private String name;
    private int age;
    private String gender;
    private int groupId;

    public Student(int id, String surname, String name,
                   int age, String gender, int groupId) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.groupId = groupId;
    }



}
