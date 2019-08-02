package com.zhiliao.netty.Text;

import com.zhiliao.netty.GetServer;

/**
 * @author Mr.Zhong
 * @create2019-07-31 9:37
 */
public class Te01 {


    public static void main(String[] args) {

        new Thread(() -> {
            GetServer.getInstance().initServer(null);

        }).start();

        if (GetServer.getInitialize().getObjectList() == GetServer.getInitialize().getObjectList()) {
            System.out.println("true");
        }
        System.out.println("1、" + GetServer.getInstance());
        System.out.println("2、" + GetServer.getInstance());


        new Thread(() -> {
            try {
                Thread.sleep(6000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(GetServer.getInitialize().getObjectList());
            if (GetServer.getInitialize().getObjectList().size() != 0) {
                System.out.println("start2");
                GetServer.getInitialize().getObjectList().get(0).writeAndFlush("BigBang");
            }
        }).start();


    }


}
