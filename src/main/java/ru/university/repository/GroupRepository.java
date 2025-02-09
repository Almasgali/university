package ru.university.repository;

import ru.university.model.Group;

import java.util.ArrayList;
import java.util.List;

public class GroupRepository implements Repository<Group> {
    List<Group> groups = new ArrayList<>();

    @Override
    public void loadAll() {

    }
}
