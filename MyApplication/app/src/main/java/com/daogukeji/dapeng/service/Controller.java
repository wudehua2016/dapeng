package com.daogukeji.dapeng.service;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.daogukeji.dapeng.MainActivity;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Timer;
import java.util.TimerTask;

import android_serialport_api.SerialPort;



/**
 * Created by dell on 2017/6/17.
 * 程序主界面后台服务类。
 * 此类为IntentService后台类：onHandleIntent()用于执行具体耗时任务
 *                            配置串口参数
 *                            打开串口
 *                            发送串口数据
 *                            接收串口数据
 *                            将接收到的串口数据通过广播发送
 */

public class Controller extends IntentService{

    public static final String TAG = "Controller";//标志
    //串口相关参数
    private SerialPort mSerialPort;//串口类
    private InputStream mInputStream;//输入流
    private OutputStream mOutputStream;//输出流
    private String port = "ttyS3";//串口名称
    private int baudrate = 9600;//波特率
//    private Thread sendThread_air;//发送空气传感器串口数据线程
//    private Thread recThread_air;//接收串口数据线程
//
//    private Thread sendThread_soil;//发送土壤传感器串口数据线程
//    private Thread recThread_soil;//接收串口数据线程
    private Timer timer;//计时器
    private TimerTask task;

    String air = null;//空气传感器返回数据标记
    String sun = null;//光照传感器返回数据标记
    //无参构造
    public Controller(){
        super("Controller");
    }
    //有参构造
    public Controller(String name){
        super(name);
    }

    //onHandleIntent执行耗时任务
    @Override
    public void onHandleIntent(Intent intent){
        if(null != intent){//若有意图
            OpenSerial();//打开串口
            /*
                启动一个定时器来执行串口任务
                1秒后开始执行，每30秒执行一次
             */
            timer = new Timer();
            task = new TimerTask() {
                @Override
                public void run() {
                    send_air();//发送空气传感器指令
                    rec_air();//接收空气传感器数据
                    send_sun();//发送光照传感器指令
                    rec_sun();//接收光照传感器数据
                    send_soil();//发送土壤传感器指令
                    rec_soil();//接收土壤传感器数据并  一并发送广播
                }
            };
            timer.schedule(task,1*1000,120*1000);
        }
    }
    //打开串口方法
    private void OpenSerial(){
        try{
            mSerialPort = new SerialPort(new File("/dev/" + port),baudrate,0);//配置串口参数：串口名字、波特率、效验位
            mInputStream = mSerialPort.getInputStream();//将输入输出流关联SerialPort，以便通过串口读写数据
            mOutputStream = mSerialPort.getOutputStream();
            Log.e(TAG, "OpenSerial: 串口打开成功并获取io流" );
            Thread.sleep(2*1000);//执行完毕打开串口命令后，等待2秒再执行下面命令
        }catch (SecurityException e){
            Log.e(TAG, "OpenSerial: 串口配置异常！" );
            e.printStackTrace();
        }catch(Exception e){
            Log.e(TAG, "OpenSerial: 获取IO流异常！" );
            e.printStackTrace();
        }
    }

    //发送空气传感器串口数据方法
    private void send_air(){
        //Log.i(TAG, "send_air" );
                try{
                    byte[] b = convert2HexArray("0100");//向串口发送的指令：byte数组
                    mOutputStream.write(b);//写出
                    Log.i(TAG,"空气开始发送了！");
                        //Thread.sleep(2*1000);
                    Log.i(TAG,"空气发送完毕！");
                    //发送完毕,执行接收串口数据线程
//                    try{
//                        Thread.sleep(2*1000);
//                    }catch (Exception e){
//                        e.printStackTrace();
//                    }
                   // rec_air();
                }catch(Exception e){
                    e.printStackTrace();
                }

    }
    //接收空气传感器串口数据方法
    //方法返回值为String空气传感器值，为了下面一起发送广播
    private String rec_air(){
        System.out.println(mInputStream);
                if(mInputStream == null){//若为null则没有收到任何串口数据
                    //若没收到则再次发送
                    Log.e(TAG, "rec_air: 接收空气传感器数据异常");
                }
                try{
                    byte[] buffer = new byte[1024];
                    int size;//标志作用，看有没有收到数据
                    size = mInputStream.read(buffer);//读取收到的串口数据的长度
                    System.out.println("空气数据长度》》》》》》》》》》》》"+size);
                    if(size==6){//此判断用于辨别串口返回数据内容，防止接到别的指令返回的数据（空气传感器返回数据的长度为6）
                        byte[] buf_data = new byte[size];
                        for (int i = 0; i < size; i++) {
                            buf_data[i] = buffer[i];
                        }
                        air = new String(byte2hex(buf_data));//将返回的数据转为String
                    }
                    Log.i(TAG, "rec_air: 接收空气数据完毕！");
                    Log.e(TAG, "rec_air: "+air);
                    //send_soil();//启动发送土壤传感器数据
                }catch(Exception e){
                    e.printStackTrace();
                }
                return air;
    }

    //发送光照传感器串口数据方法
    private void send_sun(){
        //Log.i(TAG, "send_air" );
        try{
            byte[] b = convert2HexArray("0300");//向串口发送的指令：byte数组
            mOutputStream.write(b);//写出
            Log.i(TAG,"光照开始发送了！");
            //Thread.sleep(2*1000);
            Log.i(TAG,"光照发送完毕！");
            //发送完毕,执行接收串口数据线程
//                    try{
//                        Thread.sleep(2*1000);
//                    }catch (Exception e){
//                        e.printStackTrace();
//                    }
            // rec_air();
        }catch(Exception e){
            e.printStackTrace();
        }

    }

    //接收光照传感器串口数据方法
    //方法返回值为String空气传感器值，为了下面一起发送广播
    private String rec_sun(){
        System.out.println(mInputStream);
        Log.e(TAG, "rec_sun: 进入程序" );
//        if(mInputStream == null){//若为null则没有收到任何串口数据
//            Log.e(TAG, "rec_sun: 接收光照传感器数据异常..." );
//            // send_sun();//若没收到则再次发送
//        }
        try{
            byte[] buffer = new byte[1024];
            int size;//标志作用，看有没有收到数据
            size = mInputStream.read(buffer);//读取收到的串口数据的长度
            System.out.println("光照数据长度》》》》》》》》》》》》"+size);

            if(size==6){////此判断用于辨别串口返回数据内容，防止接到别的指令返回的数据（光照传感器返回数据的长度为6）
                byte[] buf_data = new byte[size];
                for (int i = 0; i < size; i++) {
                    buf_data[i] = buffer[i];
                }
                sun = new String(byte2hex(buf_data));//将返回的数据转为String
            }
            Log.i(TAG, "rec_sun: 接收光照数据完毕！");
            Log.e(TAG, "rec_sun: "+sun);
            //send_soil();//启动发送土壤传感器数据
        }catch(Exception e){
            e.printStackTrace();
        }
        return sun;
    }
    //发送土壤传感器串口数据方法
    private void send_soil(){
        try{
            byte[] b = convert2HexArray("0200");//向串口发送的指令：byte数组
            mOutputStream.write(b);//写出
            Log.i(TAG,"土壤开始发送了！");
            //Log.e(TAG, "send_soil: "+b );
            //Thread.sleep(2*1000);
            Log.i(TAG,"土壤发送完毕！");
            //发送完毕,执行接收串口数据线程
            //rec_soil();
            //Thread.sleep(2*1000);
        }catch(Exception e){
            e.printStackTrace();
        }

    }
    //接收土壤传感器串口数据方法
    private String rec_soil(){
        String soil = null;
        if(mInputStream == null){//若为null则没有收到任何串口数据
            Log.e(TAG, "rec_soil: 接收土壤传感器数据异常" );
            // send_soil();//若没收到则再次发送
        }
        try{
            //sendThread.join();//等发送线程执行完毕再执行接收线程
            byte[] buffer = new byte[1024];
            int size;//标志作用，看有没有收到数据
            size = mInputStream.read(buffer);//读取收到的串口数据的长度
            System.out.println("土壤数据长度》》》》》》》》》》》》"+size);
            if(size==8){////此判断用于辨别串口返回数据内容，防止接到别的指令返回的数据（土壤传感器返回数据的长度为8）
                byte[] buf_data = new byte[size];
                for (int i = 0; i < size; i++) {
                    buf_data[i] = buffer[i];
                }
                soil = new String(byte2hex(buf_data));//返回土壤传感器数据（String）

                /*
                    计算土壤温度
                 */
                //1.截取土壤温度高8位（倒数第四位）
                String soilT_1 = "0x"+soil.substring(8,10);//值是，例如：0x80
                //2.截取土壤温度低2为（倒数第三位）
                String soilT_2 = "0x"+soil.substring(10,12);//值是，例如：0x00
                //3.将以上俩个值转为int型，便于做位运算
                int soilT_1_int = Integer.parseInt(soilT_1.substring(2),16);//从0x80的下标为2的（80）开始转换
                int soilT_2_int = Integer.parseInt(soilT_2.substring(2),16);//同上
                //4.调下面十六进制位运算方法，返回一个int型整数
                int soil_t_int = hex2int(soilT_1_int,soilT_2_int);
                //5.调用厂家公式，soil_t_int * 5 / 1024 * 20 - 30,直接转为String
                double soil_temp = (double)soil_t_int*5/1024*20-30;
                //6.将计算出的结果转为字符串
                String ff = soil_temp+"";
                //7.截取需要显示的值
                String fff = ff.substring(0,2);

                /*
                    计算土壤湿度
                 */
                //1.截取土壤湿度高8位（倒数第二位）
                String soilR_1 = "0x"+soil.substring(12,14);//值是，例如：0x80
                //2.截取土壤湿度低2为（倒数第一位）
                String soilR_2 = "0x"+soil.substring(14,16);//值是，例如：0x00
                //3.将以上俩个值转为int型，便于做位运算
                int soilR_1_int = Integer.parseInt(soilR_1.substring(2),16);//从0x80的下标为2的（80）开始转换
                int soilR_2_int = Integer.parseInt(soilR_2.substring(2),16);//同上
                //4.调下面十六进制位运算方法，返回一个int型整数
                int soil_r_int = hex2int(soilR_1_int,soilR_2_int);
                //5.调用厂家公式，soil_t_int * 5 / 1024 * 20 ,直接转为String
                double soil_r = (double)soil_r_int*5/1024*20;
                //6.将计算出的结果转为字符串
                String gg = soil_r+"";
                //Log.i(TAG, "rec_soil: ++++++++++++++++++++++++++++++++++"+gg.substring(0,2));
                //7.截取需要显示的值
                String ggg = gg.substring(0,2);

                /*
                    计算光照温度
                 */
                //1.截取光照高8位（倒数第四位）
                String sun_1 = "0x"+sun.substring(8,10);//值是，例如：0x80
                //2.截取光照低2为（倒数第三位）
                String sun_2 = "0x"+sun.substring(10,12);//值是，例如：0x00
                //3.将以上俩个值转为int型，便于做位运算
                int sun_1_int = Integer.parseInt(sun_1.substring(2),16);//从0x80的下标为2的（80）开始转换
                int sun_2_int = Integer.parseInt(sun_2.substring(2),16);//同上
                //4.调下面十六进制位运算方法，返回一个int型整数
                int sun_t_int = hex2int(sun_1_int,sun_2_int);
                //5.调用厂家公式，soil_t_int * 5 / 1024 * 20 - 30,直接转为String
                double sun_temp = (double)soil_t_int*5/1024*40000;
                //6.将计算出的结果转为字符串
                String rr = sun_temp+"";
                //7.截取需要显示的值
                String rrr = rr.substring(0,4);

                /*
                    向页面发送广播消息
                 */
                Intent intent = new Intent();//创建意图
                intent.setAction(MainActivity.CONTROLLER);//广播标记
                intent.putExtra("tem1",hex2str(air.substring(8,10)));//发送空气温度广播
                intent.putExtra("tem2",hex2str(air.substring(10,12))+"%");//发送空气湿度广播
                intent.putExtra("soil1",fff+"");//发送土壤温度广播
                intent.putExtra("soil2",ggg+""+"%");//发送土壤湿度广播
                intent.putExtra("sun",rrr+"LUX");
                sendBroadcast(intent);//通过intent发送广播
            }

           // Thread.sleep(5*1000);
            Log.i(TAG, "rec_soil: 接收土壤数据完毕！");
            Log.e(TAG, "rec_soil: "+soil );
            //send_air();//再次启动发送空气传感器数据
        }catch(Exception e){
            e.printStackTrace();
        }
        return soil;
    }

    // 字符串转化为十六进制字节数组
    private byte[] convert2HexArray(String apdu) {
        // TODO Auto-generated method stub
        int len = apdu.length() / 2;
        char[] chars = apdu.toCharArray();
        String[] hexes = new String[len];
        byte[] bytes = new byte[len];
        for (int i = 0, j = 0; j < len; i = i + 2, j++) {
            hexes[j] = "" + chars[i] + chars[i + 1];
            bytes[j] = (byte) Integer.parseInt(hexes[j], 16);
        }
        return bytes;
    }
    /**
     * java字节码转字符串
     *
     * @param b
     * @return
     */
    public static String byte2hex(byte[] b) { //一个字节的数，

        // 转成16进制字符串

        String hs = "";
        String tmp = "";
        for (int n = 0; n < b.length; n++) {
            //整数转成十六进制表示

            tmp = (java.lang.Integer.toHexString(b[n] & 0XFF));
            if (tmp.length() == 1) {
                hs = hs + "0" + tmp;
            } else {
                hs = hs + tmp;
            }
        }
        tmp = null;
        return hs.toUpperCase(); //转成大写

    }
    //十六进制转换为10进制方法
    public static String hex2str(String str){
        char[] s = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
        char[] inChar = str.toCharArray();

        long sum = 0 ;
        for(int i = 0 ; i < inChar.length; i++ ){
            for(int j = 0 ; j < s.length; j++){
                if(s[j]== inChar[i]){
                    sum += j*Math.pow(16,inChar.length - 1-i);//输入的顺序颠倒过来
                    break;
                }
            }
        }
        String mm = (""+sum);
        return mm;
    }
    //十六进制位运算
    private int hex2int(int x,int y){
        int a = x<<2|y;
        return a;
    }
    //关闭串口方法

    @Override
    public void onCreate() {
        super.onCreate();

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}















