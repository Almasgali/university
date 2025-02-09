package ru.university.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import ru.university.model.Curator;

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
        try(BufferedReader br = new BufferedReader(new InputStreamReader(resource.openStream()))) {
            br.lines().forEach(line -> {
                try {
                    curators.add(mapper.readValue(line, Curator.class));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
