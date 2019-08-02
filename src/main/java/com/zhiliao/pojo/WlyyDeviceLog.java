package com.zhiliao.pojo;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日志信息pojo
 */
public class WlyyDeviceLog {
    //  编号
    private Integer id;
    //  设备ID
    private Integer deviceId;
    //  日期时间戳
    private Integer addTime;
    //  显示时间
    private String  time;
    //  物联网类型
    private Boolean typeId;
    //  商家ID
    private Integer businessId;



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Integer deviceId) {
        this.deviceId = deviceId;
    }

    public Integer getAddTime() {
        return addTime;
    }

    public void setAddTime(Integer addTime) {
        this.addTime = addTime;
    }

    public Boolean getTypeId() {
        return typeId;
    }

    public void setTypeId(Boolean typeId) {
        this.typeId = typeId;
    }

    public Integer getBusinessId() {
        return businessId;
    }

    public void setBusinessId(Integer businessId) {
        this.businessId = businessId;
    }

    public String getTime() {
        if(addTime!=0){
            SimpleDateFormat unix_time=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            time=unix_time.format(new Date(Long.valueOf(addTime+"000")));
        }
        return time;
    }


}