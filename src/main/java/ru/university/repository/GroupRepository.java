package ru.university.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import ru.university.config.PostgresConfig;
import ru.university.model.Group;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class GroupRepository implements Repository<Group> {
    private final Connection connection;

    public GroupRepository() {
        try {
            this.connection = DriverManager.getConnection(
                    PostgresConfig.URL,
                    PostgresConfig.USERNAME,
                    PostgresConfig.PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        loadAll();
    }

    @Override
    public void loadAll() {
//        Path path = Path.of(System.getProperty("user.home")).resolve("group.json");
//        try {
//            if (Files.notExists(path)) {
//                Files.createFile(path);
//            }
//            groups.addAll(mapper.readValue(
//                    Files.newBufferedReader(path),
//                    new TypeReference<List<Group>>(){}));
//        } catch (JsonMappingException ignored) {
//
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
    }

    @Override
    public void saveAll() {
//        Path path = Path.of(System.getProperty("user.home")).resolve("group.json");
//        try (OutputStream os =  Files.newOutputStream(path, StandardOpenOption.CREATE)) {
//            mapper.writeValue(os, groups);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
    }

    @Override
    public void add(Group entity) {
        String sql = "INSERT INTO groups (name, curatorId) VALUES (?, ?)";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, entity.getGroupName());
            statement.setLong(2, entity.getCuratorId());

            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
//        groups.add(entity);
//        saveAll();
    }

    @Override
    public void edit(Group entity) {
        String sql = "UPDATE groups SET name = ?, curatorId = ? WHERE id = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, entity.getGroupName());
            statement.setLong(2, entity.getCuratorId());
            statement.setLong(3, entity.getId());

            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
//        Group currentGroup = groups.stream().filter(c -> c.getId() == entity.getId()).findFirst().orElseThrow();
//        currentGroup.setGroupName(entity.getGroupName());
//        currentGroup.setCuratorId(entity.getCuratorId());
//        saveAll();
    }

    @Override
    public void delete(long id) {
        String sql = "DELETE FROM groups WHERE id = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, id);

            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
//        groups.stream().filter(g -> g.getId() == id)
//                .findFirst().map(groups::remove);
//        System.out.println("Группа удалена");
//        saveAll();
    }

    @Override
    public void deleteAll() {
        try {
            connection.prepareStatement("DELETE FROM groups").executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
//        groups.removeIf(g -> true);
//        System.out.println("Все группы удалены");
//        saveAll();
    }

    @Override
    public Group get(long id) {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM groups WHERE id = ?");
            statement.setLong(1, id);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return mapGroup(resultSet);
            }
            throw new NoSuchElementException();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
//        return groups.stream().filter(g -> g.getId() == id).findFirst().orElseThrow();
    }

    @Override
    public List<Group> list() {
        try {
            Statement statement = connection.createStatement();

            List<Group> result = new ArrayList<>();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM groups");
            while (resultSet.next()) {
                result.add(mapGroup(resultSet));
            }
            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
//        return groups;
    }

    @Override
    // зачем?
    public long getCurId() {
        return 0;
//        return list().get(list().size() - 1).getId();
    }

    private Group mapGroup(ResultSet resultSet) {
        Group group = new Group();

        try {
            group.setId(resultSet.getLong("id"));
            group.setGroupName(resultSet.getString("name"));
            group.setCuratorId(resultSet.getLong("curatorId"));

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return group;
    }
}
