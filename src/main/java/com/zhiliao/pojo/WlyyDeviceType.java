package com.zhiliao.pojo;

/**
 * 物联网类型信息pojo
 *
 * @author Mr.Zhong
 * @create2019-08-01 14:13
 */

public class WlyyDeviceType {
    //  编号
    private Integer id;
    //  设备名称
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}