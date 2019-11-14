package cn.caber.springbootstudy.bean;

/**
 * @Description:
 * @Author: zhaikaibo
 * @Date: 2019/11/14 15:33
 */
public class ConditionBean {

    private People people;

    private String status;

    public ConditionBean(People people, String status) {
        this.people = people;
        this.status = status;
    }

    public ConditionBean() {
    }

    public People getPeople() {
        return people;
    }

    public void setPeople(People people) {
        this.people = people;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
