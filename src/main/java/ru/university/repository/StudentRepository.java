package ru.university.repository;

import ru.university.model.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentRepository implements Repository<Student> {
    List<Student> students = new ArrayList<>();

    @Override
    public void loadAll() {

    }
}
