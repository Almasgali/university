package ru.university.app.modules;

import ru.university.repository.StudentRepository;

public class StudentModel {
    private final StudentRepository studentRepository;

    public StudentModel() {
        studentRepository = new StudentRepository();
    }
}
