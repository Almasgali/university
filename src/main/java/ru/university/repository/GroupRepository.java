package ru.university.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import ru.university.model.Group;

import javax.swing.text.html.parser.Parser;
import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

public class GroupRepository implements Repository<Group> {
    private final List<Group> groups;
    private final ObjectMapper mapper;

    public GroupRepository() {
        this.groups = new ArrayList<>();
        this.mapper = new ObjectMapper();
        loadAll();
    }

    @Override
    public void loadAll() {
        Path path = Path.of(System.getProperty("user.home")).resolve("group.json");
        try {
            groups.addAll(mapper.readValue(path.toFile(), new TypeReference<List<Group>>(){}));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void saveAll() {
        Path path = Path.of(System.getProperty("user.home")).resolve("group.json");
        try (OutputStream os =  Files.newOutputStream(path, StandardOpenOption.CREATE)) {
            mapper.writeValue(os, groups);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void add(Group entity) {
        groups.add(entity);
    }

    @Override
    public List<Group> list() {
        return groups;
    }

}
