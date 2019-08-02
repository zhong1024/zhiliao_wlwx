import com.zhiliao.netty.GetServer;
import com.zhiliao.netty.Text.TimeClient;
import com.zhiliao.pojo.WlyyDeviceLog;
import org.junit.Test;

/**
 * @author Mr.Zhong
 * @create2019-07-31 9:08
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
    }


    @Test
    public void Te01(){
//        WlyyDeviceLog wlyyDeviceLog = new WlyyDeviceLog();
//        wlyyDeviceLog.setAddTime(1541261100);
////        wlyyDeviceLog.setTime();
//        System.out.println(wlyyDeviceLog.getTime());
    }

}
