package ru.university.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import ru.university.model.Curator;
import ru.university.model.Group;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class CuratorRepository implements Repository<Curator> {
    private final List<Curator> curators;
    private final ObjectMapper mapper;

    public CuratorRepository() {
        this.curators = new ArrayList<>();
        this.mapper = new ObjectMapper();
    }

    @Override
    public void loadAll() {
        URL resource = this.getClass().getResource("/curator.json");
        try {
            mapper.readValue(resource, new TypeReference<List<Curator>>(){});
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void saveAll() {

    }

    @Override
    public void add(Curator entity) {

    }

    @Override
    public List<Curator> list() {
        return curators;
    }
}
