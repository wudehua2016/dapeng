package com.daogukeji.dapeng.service;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import android_serialport_api.SerialPort;

import static com.daogukeji.dapeng.fragment.GuanGai.GUANGAI_OPEN;
import static com.daogukeji.dapeng.fragment.PaiFeng.PAIFENG_OPEN;

/**
 * Created by dell on 2017/6/22.
 */

public class GuanGaiIntentService_open extends IntentService{
    public static final String TAG = "GuanGaiIntentService_open";

    //串口相关参数
    private SerialPort mSerialPort;
    private InputStream mInputStream;
    private OutputStream mOutputStream;
    private String port = "ttyS3";
    private int baudrate = 9600;

    public GuanGaiIntentService_open(){
        super("GuanGaiIntentService_open");
    }
    @Override
    public void onHandleIntent(Intent intent){
        send_open();//发送指令方法
        send_rec();//接收指令方法
    }
    private void send_open(){
        byte[] b = convert2HexArray("1001");//向串口发送的指令：byte数组
        try{
            mSerialPort = new SerialPort(new File("/dev/" + port),baudrate,0);//配置串口参数：串口名字、波特率、效验位
            mInputStream = mSerialPort.getInputStream();//将输入输出流关联SerialPort，以便通过串口读写数据
            mOutputStream = mSerialPort.getOutputStream();
            mOutputStream.write(b);
            System.out.println("开启灌溉指令发送成功");
            //send_rec();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    private void send_rec(){
        Thread recThread = new Thread(){
            @Override
            public void run(){
                byte[] buffer = new byte[1024];
                int size;
                try{
                    Intent intent = new Intent();//创建意图
                    size = mInputStream.read(buffer);
                    if(size==5){//此判断用于辨别串口返回数据内容，防止接到别的指令返回的数据（灌溉继电器返回数据的长度为5）
                        byte[] buf_data = new byte[size];
                        for (int i = 0; i < size; i++) {
                            buf_data[i] = buffer[i];
                        }
                        String guangai = new String(byte2hex(buf_data));//将返回的数据转为String
                        Log.i(TAG, "send_rec: "+guangai);
                        intent.setAction(GUANGAI_OPEN);//设置广播标志
                        if("8083100001".equals(guangai)){//排风开启成功返回的数据
                            intent.putExtra("guangai_open","灌溉已开启...");//添加广播数据
                            sendBroadcast(intent);//发送广播
                        }else{
                            intent.putExtra("guangai_open","灌溉开启失败，请重试");
                            sendBroadcast(intent);
                        }
                    }
                }catch (IOException e){
                    e.printStackTrace();
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        };
        recThread.start();
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
    public void onDestroy(){
        System.out.println("灌溉开启服务销毁");
        super.onDestroy();
    }
}
