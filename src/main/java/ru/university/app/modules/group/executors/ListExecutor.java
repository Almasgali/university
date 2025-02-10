package ru.university.app.modules.group.executors;

import ru.university.model.Group;
import ru.university.repository.Repository;

import java.util.stream.Stream;

public class ListExecutor implements Executor<Group> {
    @Override
    public void execute(String[] args, Repository<Group> repository) {
        int i = 0;
        Stream<Group> allGroups = repository.list().stream();
        while (i < args.length) {
            int finalI = i;
            switch (args[i]) {
                case "-i" -> allGroups.filter(g -> g.getId() == Integer.parseInt(args[finalI + 1]));
            }
            i += 2;
        }
        allGroups.forEach(g -> {
            System.out.println(g.getId() + " " + g.getGroupName() + " " + g.getCuratorId());
        });
    }
}
