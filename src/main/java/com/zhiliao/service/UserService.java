package com.zhiliao.service;

import com.zhiliao.dao.WlyyUserMapper;
import com.zhiliao.pojo.WlyyUser;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 用户管理Service
 *
 * @author Mr.Zhong
 * @create2019-08-13 16:05
 */
@Service
public class UserService {

    @Resource
    WlyyUserMapper wlyyUserMapper;


    /**
     * 登陆
     *
     * @param
     * @return
     */
    public WlyyUser login(WlyyUser record) {
        return wlyyUserMapper.login(record);
    }


}
