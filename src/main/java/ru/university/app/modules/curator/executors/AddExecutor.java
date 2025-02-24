package ru.university.app.modules.curator.executors;

import ru.university.model.Curator;
import ru.university.repository.Repository;

public class AddExecutor implements Executor<Curator> {

    @Override
    public void execute(String[] args, Repository<Curator> repository) {
        Curator curator = new Curator();
        int i = 0;
        while (i < args.length) {
            switch (args[i]) {
                case "help" -> showHelp();
                case "-i" -> curator.setId(Integer.parseInt(args[i + 1]));
                case "-s" -> curator.setSurname(args[i + 1]);
                case "-n" -> curator.setName(args[i + 1]);
            }
            i += 2;
        }
        repository.add(curator);
    }

    public void showHelp() {
        System.out.println("""
                Curator add command parameters:
                -i - ID
                -s - surname
                -n - name
                """);
    }
}
