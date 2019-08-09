package com.zhiliao.pojo;

/**
 * 商家信息pojo
 *
 * @author Mr.Zhong
 * @create2019-08-01 14:13
 */

public class WlyyBusiness {
    //  ID
    private Integer id;
    //  商家名称
    private String businessName;
    //  多条件查询条件
    private String searContent;

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

    public String getSearContent() {
        return searContent;
    }

    public void setSearContent(String searContent) {
        this.searContent = searContent;
    }
}