package ru.university.model;

public class Group {

    private long id;
    private String groupName;
    private long curatorId;

    public Group() {
    }

    public Group(long id, String groupName, int curatorId) {
        this.id = id;
        this.groupName = groupName;
        this.curatorId = curatorId;
    }

    public long getId() {
        return id;
    }

    public String getGroupName() {
        return groupName;
    }

    public long getCuratorId() {
        return curatorId;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public void setCuratorId(long curatorId) {
        this.curatorId = curatorId;
    }
}
