package ru.university.app.modules.group;

import ru.university.app.modules.group.executors.AddExecutor;
import ru.university.app.modules.group.executors.ListExecutor;
import ru.university.exception.UnexpectedParameterException;
import ru.university.repository.GroupRepository;

import java.util.Arrays;

public class GroupModel {

    private final GroupRepository groupRepository;
    private final AddExecutor addExecutor;
    private final ListExecutor listExecutor;

    public GroupModel() {
        groupRepository = new GroupRepository();
        addExecutor = new AddExecutor();
        listExecutor = new ListExecutor();
    }

    public void executeCommand(String[] commandArgs) {
        switch (commandArgs[0]) {
            case "help" -> showHelp();
            case "add" -> addExecutor.execute(
                    Arrays.copyOfRange(commandArgs, 1, commandArgs.length),
                    groupRepository);
            case "list" -> listExecutor.execute(
                    Arrays.copyOfRange(commandArgs, 1, commandArgs.length),
                    groupRepository);
            default -> throw new UnexpectedParameterException(commandArgs[0]);
        }
    }

    private void showHelp() {

    }

    public void close() {
        groupRepository.saveAll();
    }
}
