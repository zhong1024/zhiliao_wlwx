package com.zhiliao.pojo;

import com.zhiliao.service.equipment_manage.EquipmentTypeService;
import com.zhiliao.service.merchants_manage.MerchantsManageService;

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
    private Integer typeId;
    //  显示物联网类型
    private String typeName;
    //  商家ID
    private Integer businessId;
    //  显示商家名称
    private String businessName;



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

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
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
        }else
            time = null;
        return time;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    //    public String getTypeName() throws Exception{
//        System.out.println("typeId:"+typeId);
//        if(typeId!=0){
//            MerchantsManageService merchantsManageService = new MerchantsManageService();
//            typeName = merchantsManageService.selectByPrimaryKey(typeId).getName();
//        }
//        System.out.println("typeName:"+typeName);
//        return typeName;
//    }

//    public String getBusinessName() throws Exception{
//        System.out.println("businessId:"+businessId);
//        if(businessId!=0){
//            EquipmentTypeService equipmentTypeService = new EquipmentTypeService();
//            System.out.println(equipmentTypeService.selectByPrimaryKey(businessId).getBusinessName());
//            businessName = equipmentTypeService.selectByPrimaryKey(businessId).getBusinessName();
//        }else
//            businessName = null;
//        System.out.println("businessName:"+businessName);
//        return businessName;
//    }

}