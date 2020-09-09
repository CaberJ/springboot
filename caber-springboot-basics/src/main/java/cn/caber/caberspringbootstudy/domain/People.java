package cn.caber.caberspringbootstudy.domain;

import java.io.Serializable;

public class People implements Serializable {
    private String id;
    private String name;
    private int age;
    private String gid;

    public People() {
    }

    public People(String id, String name, int age, String gid) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gid = gid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGid() {
        return gid;
    }

    public void setGid(String gid) {
        this.gid = gid;
    }

    @Override
    public String toString() {
        return "People{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gid='" + gid + '\'' +
                '}';
    }
}
