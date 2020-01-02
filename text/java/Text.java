/**
 * @author Mr.Zhong
 * @create2019-09-04 14:53
 */


import org.junit.Test;

import javax.xml.crypto.Data;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Text {


    @Test
    public void t1() throws Exception {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");     // 输入的时间格式（2019-05-11）
        java.util.Date date = df.parse("2019-05-11");           // 输入时间具体时间
        Calendar cal = Calendar.getInstance();                          // 获取某具体时间的方法
        cal.setTime(date);                                              // 返回一个Date表示此日历的时间
        long timestamp = cal.getTimeInMillis();                         // 日历的时间转换为时间戳（时间戳是指格林威治时间1970年01月01日00时00分00秒(北京时间1970年01月01日08时00分00秒)起至现在的总秒数）
        long time = System.currentTimeMillis();                         // 获取现在本机的时间戳
        long day = (time - timestamp) / (24 * 60 * 60 * 1000) + 1;      // 现在的时间戳减去（2019-05-11 0:00）时间的时间戳---再除以一天时间的总秒数 == 等于天数（算上今天再加一）
        System.out.println("第 " + day + " 天");                        // 把结果打印到控制台
    }


    @Test
    public void tt1() {

        List<Shop> shopList = new ArrayList<>();
        List<Shop> shopListA = new ArrayList<>();
        Shop a = new Shop();
        Shop b = new Shop();
        Shop c = new Shop();

        a.setName("0水果店");
        a.setAppleName("红富士");
        a.setAppleNumber(0);
        a.setApplePay(8.00);
        a.setType(true);
        shopList.add(a);

        b.setName("1水果店");
        b.setAppleName("红富");
        b.setAppleNumber(999);
        b.setApplePay(9.00);
        b.setType(true);
        shopList.add(b);

        c.setName("2水果店");
        c.setAppleName("红富士");
        c.setAppleNumber(999);
        c.setApplePay(9.00);
        c.setType(true);
        shopList.add(c);

        for (Shop rr : shopList) {
            if (rr.isType()) {
                if (rr.getAppleName() == "红富士" && rr.getAppleNumber() > 0 && rr.getApplePay() < 10.00) {
                    shopListA.add(rr);
                } else {
                    System.out.println(rr.getName() + "没有符合的水果");
                }
            } else {
                System.out.println(rr.getName() + "未开门");
            }
        }


        Shop shop = null;
        double mo = 11.00;
        for (Shop rr : shopListA) {
            if (rr.getApplePay() < mo) {
                shop = rr;
                mo = rr.getApplePay();
            }
        }

        if (shop != null) {
            System.out.println("=========================");
            System.out.println(shop.getName());
            System.out.println(shop.getApplePay());
        } else {
            System.out.println("=========================");
            System.out.println("未找到合法苹果");
        }

    }


    @Test
    public void tt2() {
        int[] arr = {11, 88, 2, 34, 46, 72, 20, 8};
        for (int i = 0; i < arr.length - 1; i++) {
            int z = -1;
            int cen = 0;
            for (int m = i; m < arr.length; m++) {
                if (arr[m] > cen) {
                    z = m;
                    cen = arr[m];
                }
            }
            if (z != i && z != -1) {
                int c;
                c = arr[z];
                arr[z] = arr[i];
                arr[i] = c;
            }
        }
        for (int a : arr) {
            System.out.println(a);
        }

    }


    @Test
    public void tt12() {

        for (int i = 0; i < 100; i++) {
            for (int m = 0; m < 200; m++) {
                System.out.print("*");
            }
            System.out.println();
        }


    }

    @Test
    public void tt22() {
        String string = new SimpleDateFormat("yyyyMMdd").format(new Date()).toString();
        System.out.println(string);
    }

    @Test
    public void t12() {
//        int i ;
//        int m ;
//        for(i=1;i>=-1;i-=0.05){
//            for(m=-1;m<=1;m+=0.025){
//                System.out.print("*");
//                continue;
//            }
//            System.out.println("\n");
//        }

        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }
    }

    static int arr = 1;
    static int a = 0;
    static int b = 0;
    static int c = 0;
    static int d = 0;

    public static void main(String[] args) {


        new Thread(() -> {
            try {
                int i = 1;
                do {
                    int time = i * 1000;
                    System.out.println(time);
                    Thread.sleep(time);
                } while (i++ < 5);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
//
//        new Thread(() -> {
//            while (arr < 100000000) {
//                arr++;
//                a++;
//            }
//        }).start();
//
//        new Thread(() -> {
//            while (arr < 100000000) {
//                arr++;
//                b++;
//            }
//        }).start();
//
//        new Thread(() -> {
//            while (arr < 100000000) {
//                arr++;
//                c++;
//            }
//
//        }).start();
//
//        new Thread(() -> {
//            while (arr < 100000000) {
//                arr++;
//                d++;
//            }
//        }).start();
//
//        while (true) {
//            try {
//                if (arr > 99000000) {
//                    System.out.println("a=" + a);
//                    System.out.println("b=" + b);
//                    System.out.println("c=" + c);
//                    System.out.println("d=" + d);
//                    break;
//                }
//                System.out.println(arr);
//                Thread.sleep(50);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }

    }


}











