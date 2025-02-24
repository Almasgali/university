package ru.university.app.modules.student.executors;

import ru.university.model.Student;
import ru.university.repository.Repository;

public class AddExecutor implements Executor<Student> {

    @Override
    public void execute(String[] args, Repository<Student> repository) {
        Student student = new Student();
        int i = 0;
        while (i < args.length) {
            switch (args[i]) {
                case "help" -> showHelp();
                case "-i" -> student.setId(Integer.parseInt(args[i + 1]));
                case "-s" -> student.setSurname(args[i + 1]);
                case "-n" -> student.setName(args[i + 1]);
                case "-g" -> student.setGender(args[i + 1]);
                case "-gi" -> student.setGroupId(Integer.parseInt(args[i + 1]));
            }
            i += 2;
        }
        repository.add(student);
    }

    public void showHelp() {
        System.out.println("""
                group add command parameters:
                -i = id
                -s = surname
                -n = name
                -g = gender
                -gi = group id
                """);
    }
}
