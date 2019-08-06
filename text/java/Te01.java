import com.zhiliao.dao.WlyyDeviceLogMapper;
import com.zhiliao.netty.GetServer;
import com.zhiliao.netty.Text.TimeClient;
import com.zhiliao.pojo.WlyyDeviceLog;
import com.zhiliao.service.equipment_type.EquipmentLogService;
import com.zhiliao.util.Hex22String;
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
    public void Te01() throws Exception{
//        Hex22String hex22String = new Hex22String();
//        System.out.println( hex22String.str2HexStr("ALIVEOK",true,"UTF-8"));

        EquipmentLogService equipmentLogService = new  EquipmentLogService();
        WlyyDeviceLog wlyyDeviceLog = new WlyyDeviceLog();
        wlyyDeviceLog.setId(1);
        wlyyDeviceLog.setTypeId(1);
        equipmentLogService.updateTypeKey(wlyyDeviceLog);

    }




}