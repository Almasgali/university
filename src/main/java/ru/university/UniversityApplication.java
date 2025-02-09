package ru.university;

import ru.university.model.Curator;
import ru.university.model.Group;
import ru.university.model.Student;
import ru.university.repository.CuratorRepository;
import ru.university.repository.GroupRepository;
import ru.university.repository.Repository;
import ru.university.repository.StudentRepository;

public class UniversityApplication {

    private final Repository<Student> studentRepository;
    private final Repository<Group> groupRepository;
    private final Repository<Curator> curatorRepository ;

    public UniversityApplication(String[] args) {

        // parse args

        studentRepository = new StudentRepository();
        groupRepository = new GroupRepository();
        curatorRepository = new CuratorRepository();
    }
}
