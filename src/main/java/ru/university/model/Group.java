package ru.university.model;

public class Group {
    private int id;
    private String groupName;
    private int curatorId;

    public Group(int id, String groupName, int curatorId) {
        this.id = id;
        this.groupName = groupName;
        this.curatorId = curatorId;
    }
}
