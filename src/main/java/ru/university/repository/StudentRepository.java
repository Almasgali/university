package ru.university.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import ru.university.model.Group;
import ru.university.model.Student;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository implements Repository<Student> {
    private final List<Student> students;
    private final ObjectMapper mapper;

    public StudentRepository() {
        this.students = new ArrayList<>();
        this.mapper = new ObjectMapper();
    }

    @Override
    public void loadAll() {
        URL resource = this.getClass().getResource("/student.json");
        try {
            mapper.readValue(resource, new TypeReference<List<Student>>(){});
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void saveAll() {

    }

    @Override
    public void add(Student entity) {

    }

    @Override
    public List<Student> list() {
        return students;
    }
}
