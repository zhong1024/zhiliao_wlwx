package com.zhiliao.pojo;

/**
 * 商家信息pojo
 */
public class WlyyBusiness {
    //  ID
    private Integer id;
    //  商家名称
    private String businessName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName == null ? null : businessName.trim();
    }
}