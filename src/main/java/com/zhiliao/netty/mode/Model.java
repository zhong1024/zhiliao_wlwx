package com.zhiliao.netty.mode;

import java.util.HashMap;
import java.util.Map;

/**
 * 持久化数据层
 *
 * @author Mr.Zhong
 * @create2019-08-16 9:47
 */
public class Model {


    public static Map<String, Object[]> cmds = new HashMap<>();
    static{
        try {
            cmds.put("00",new String[]{});  //锁关紧
            cmds.put("11",new String[]{});  //锁打开
            cmds.put("22",new String[]{});  //锁没有连接
            cmds.put("33",new String[]{});  //锁故障
        }catch (Exception e){
            e.printStackTrace();
        }
    }


}
