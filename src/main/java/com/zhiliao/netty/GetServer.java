package com.zhiliao.netty;



/**
 * @author Mr.Zhong
 * @create2019-07-29 11:30
 */
public class GetServer {

    private static server servers;

    private static Initialize initialize;

    private static GetServer getServer;

    private GetServer(){}

    public static synchronized GetServer getServer(){
        if(getServer == null){
            getServer = new GetServer();
        }
        return getServer;
    }

    public static synchronized server getInstance(){
        if(servers == null){
            servers = new server();
        }
        return servers;
    }

    public static synchronized Initialize getInitialize(){
        if(initialize == null){
            initialize = new Initialize();
        }
        return initialize;
    }

}
