package ru.university.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import ru.university.model.Group;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
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
            if (Files.notExists(path)) {
                Files.createFile(path);
            }
            groups.addAll(mapper.readValue(
                    Files.newBufferedReader(path),
                    new TypeReference<List<Group>>(){}));
        } catch (JsonMappingException ignored) {

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
