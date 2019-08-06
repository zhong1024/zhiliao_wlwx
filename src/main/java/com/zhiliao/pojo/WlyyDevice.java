package com.zhiliao.pojo;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 设备信息
 *
 * @author Mr.Zhong
 * @create2019-08-01 14:13
 */

public class WlyyDevice {
    //  编号
    private Integer id;
    //  设备类型
    private Integer typeId;
    //  IP
    private String ip;
    //  设备端口
    private Integer port;
    //  1在线0不在线
    private Boolean status;
    //  状态显示
    private String typeStatus;
    //  注册时间
    private Integer addTime;
    //  显示时间
    private String time;
    //  商家ID
    private Integer businessId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Integer getAddTime() {
        return addTime;
    }

    public void setAddTime(Integer addTime) {
        this.addTime = addTime;
    }

    public Integer getBusinessId() {
        return businessId;
    }

    public void setBusinessId(Integer businessId) {
        this.businessId = businessId;
    }

    public String getTypeStatus() {
        if (status) {
            typeStatus = "在线";
        } else {
            typeStatus = "未在线";
        }
        return typeStatus;
    }

    public String getTime() {
        if (addTime != 0) {
            SimpleDateFormat unix_time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            time = unix_time.format(new Date(Long.valueOf(addTime + "000")));
        }
        return time;
    }

}