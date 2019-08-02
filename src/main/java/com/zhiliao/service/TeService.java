package com.zhiliao.service;

import com.zhiliao.dao.WlyyBusinessMapper;
import com.zhiliao.pojo.WlyyBusiness;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
import java.util.List;


/**
 * @author Mr.Zhong
 * @create2019-07-29 9:38
 */
@Service
@Transactional
public class TeService{

    @Resource
    WlyyBusinessMapper wlyyBusinessMapper ;

    /**
     *
     */
//    public List<WlyyBusiness> getAll() {
//        return wlyyBusinessMapper.selectByExample(null);
//    }


    public WlyyBusiness getAll() {
        return wlyyBusinessMapper.selectByPrimaryKey(1);
    }

}
