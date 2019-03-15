package cn.caber.caberspringbootstudy.domain;

import java.io.Serializable;
import java.util.List;

public class Group implements Serializable {
    private int id;
    private int count;
    private List<People> peoples;

    public Group() {
    }

    public Group(int id, int count, List<People> peoples) {
        this.id = id;
        this.count = count;
        this.peoples = peoples;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<People> getPeoples() {
        return peoples;
    }

    public void setPeoples(List<People> peoples) {
        this.peoples = peoples;
    }

    @Override
    public String toString() {
        return "Group{" +
                "id=" + id +
                ", count=" + count +
                ", peoples=" + peoples +
                '}';
    }
}
