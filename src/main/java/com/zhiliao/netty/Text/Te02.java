package com.zhiliao.netty.Text;

/**
 * @author Mr.Zhong
 * @create2019-07-31 9:19
 */
public class Te02 {

    public static void main(String[] args) {
        new Thread(()->{
            TimeClient timeClient = new TimeClient();
            timeClient.init();
        }).start();


//        new Thread(()->{
//            try{
//                Thread.sleep(1000);
//                System.out.println("start1");
//                System.out.println(GetServer.getInitialize().getObjectList());
//                if(GetServer.getInitialize().getObjectList().size()!=0){
//                    System.out.println("start2");
//                    GetServer.getInitialize().getObjectList().get(0).writeAndFlush("BigBang");
//                }
//            }catch (Exception e){
//                e.printStackTrace();
//            }
//        }).start();

    }

}
