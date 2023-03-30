package cn.caber.app.common.dao;

import lombok.Data;

import java.io.Serializable;

@Data
public class BaseEntity implements Serializable, Cloneable {
    private int id;
}
