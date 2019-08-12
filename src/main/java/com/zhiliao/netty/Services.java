package com.zhiliao.netty;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Mr.Zhong
 * @create2019-08-05 9:09
 */
public class Services {

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


    public String switchs(String data) {

        switch (data) {
            case "1":
                ;
                break;
            case "2":
                ;
                break;
        }

        return data;
    }


}
