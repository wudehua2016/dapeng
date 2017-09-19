package com.daogukeji.dapeng.fragment;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.daogukeji.dapeng.MainActivity;
import com.daogukeji.dapeng.R;
import com.daogukeji.dapeng.service.Controller;

import static com.daogukeji.dapeng.MainActivity.CONTROLLER;


/**
 * Created by dell on 2017/6/17.
 */

public class KaiGuan extends Fragment {
    //public static final String CONTROLLER = "com.daogukeji.dapeng.service.Controller";
    public static final String TAG = "KaiGuan";
    //UI
    private TextView tem1;//空气温度
    private TextView tem2;//空气湿度
    private TextView soil1;//土壤肥力
    private TextView soil2;//土壤湿度
    private TextView pm;//PM2.5
    private TextView sun;//光照强度
    private ReceiveBroadCast receiveBroadCast;//广播接收器

    //广播接收器
    class ReceiveBroadCast extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent)
        {
            if(intent.getAction().equals(CONTROLLER)){
                String tem1_info = intent.getExtras().getString("tem1");//获得广播空气温度数据
                String tem2_info = intent.getExtras().getString("tem2");//获得广播空气湿度数据
                String soil1_info = intent.getExtras().getString("soil1");//获得广播土壤肥力数据
                String soil2_info = intent.getExtras().getString("soil2");//获得广播土壤湿度数据
                String pm_info = intent.getExtras().getString("pm");//获得广播PM2.5数据
                String sun_info = intent.getExtras().getString("sun");//获得广播光照强度数据
                tem1.setText("空气温度:"+tem1_info);//更新空气温度
                tem2.setText("空气湿度:"+tem2_info);//更新空气湿度
                soil1.setText("土壤温度:"+soil1_info);//更新土壤肥力
                soil2.setText("土壤湿度:"+soil2_info);//更新土壤湿度
                pm.setText("PM2.5:            "+"    光照强度:            "+sun_info);//更新PM2.5//目前没有PM2.5和光照数据，所以发送空字符串
               // sun.setText("光照强度:"+sun_info);//更新光照强度
            }
        }
    }
    @Override
    public void onAttach(Context context){
        /*注册广播 */
        receiveBroadCast = new ReceiveBroadCast();
        IntentFilter filter = new IntentFilter();
        filter.addAction(CONTROLLER);    //只有持有相同的action的接受者才能接收此广播
        context.registerReceiver(receiveBroadCast, filter);
        super.onAttach(context);
        Toast.makeText(getActivity(),"正在获取数据,请稍后...",Toast.LENGTH_SHORT).show();//加载fragment后提示用户等待加载数据...
        Log.d(TAG,"开关>>>>>>>>>onAttach");
    }
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        Log.d(TAG,"开关>>>>>>>>>onCreate");
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.d(TAG,"开关>>>>>>>>>onCreateView");
        return inflater.inflate(R.layout.kai_guan, container, false);
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        //加载fragment布局控件
        tem1 = (TextView) getView().findViewById(R.id.tem1);//空气温度
        tem2 = (TextView) getView().findViewById(R.id.tem2);//空气湿度
        soil1 = (TextView) getView().findViewById(R.id.soil1);//土壤温度
        soil2 = (TextView) getView().findViewById(R.id.soil2);//土壤湿度
        pm = (TextView) getView().findViewById(R.id.pm);//PM2.5
       // sun = (TextView) getView().findViewById(R.id.sun);//光照强度
        super.onActivityCreated(savedInstanceState);
        Log.d(TAG,"开关>>>>>>>>>onActivityCreated");
    }
    @Override
    public void onStart(){
        super.onStart();
        Log.d(TAG,"开关>>>>>>>>>onStart");
    }
    @Override
    public void onResume(){
        super.onResume();
        Log.d(TAG,"开关>>>>>>>>>onResume");
    }
    @Override
    public void onPause(){
        super.onPause();
        Log.d(TAG,"开关>>>>>>>>>onPause");
    }
    @Override
    public void onStop(){
        super.onStop();
        Log.d(TAG,"开关>>>>>>>>>onStop");
    }
    @Override
    public void onDestroyView(){
        super.onDestroyView();
        Log.d(TAG,"开关>>>>>>>>>onDestroyView");
    }
    @Override
    public void onDestroy(){
        super.onDestroy();
        Log.d(TAG,"开关>>>>>>>>>onDestroy");
    }
    @Override
    public void onDetach(){
        getActivity().unregisterReceiver(receiveBroadCast);//注销广播
        super.onDetach();
        Log.d(TAG,"开关>>>>>>>>>onDetach");
    }
}
