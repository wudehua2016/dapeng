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
import android.widget.Button;
import android.widget.TextView;

import com.daogukeji.dapeng.R;


/**
 * Created by dell on 2017/6/17.
 */

public class BuGuang extends Fragment implements View.OnClickListener{
    public static final String BUGUANG_OPEN = "com.daogukeji.dapeng.service.BuGuangIntentService_open";
    public static final String BUGUANG_CLOSE = "com.daogukeji.dapeng.service.BuGuangIntentService_close";
    public static final String TAG = "BuGuang";

    private TextView text_bg;
    private Button bg_btn_open;
    private Button bg_btn_close;

    private ReceiveBroadCast receiveBroadCast;
    class ReceiveBroadCast extends BroadcastReceiver {
        @Override
        public void onReceive(Context context,Intent intent){
            if(BUGUANG_OPEN.equals(intent.getAction())){
                String on = intent.getExtras().getString("buguang_open");
                System.out.println("开启补光接收广播为》》》》》》》"+on);
                text_bg.setText(on);
            }
            if(BUGUANG_CLOSE.equals(intent.getAction())){
                String off = intent.getExtras().getString("buguang_close");
                System.out.println("关闭补光接收广播为》》》》》》》"+off);
                text_bg.setText(off);
            }
        }
    }

    @Override
    public void onAttach(Context context){
        //注册广播
        receiveBroadCast = new ReceiveBroadCast();
        IntentFilter filter = new IntentFilter();
        filter.addAction(BUGUANG_OPEN);
        filter.addAction(BUGUANG_CLOSE);
        context.registerReceiver(receiveBroadCast,filter);
        super.onAttach(context);
        Log.d(TAG,"补光>>>>>>>>>onAttach");
    }
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        Log.d(TAG,"补光>>>>>>>>>onCreate");
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.d(TAG,"补光>>>>>>>>>onCreateView");
        return inflater.inflate(R.layout.bu_guang, container, false);
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        //加载控件和事件
        text_bg = (TextView) getActivity().findViewById(R.id.text_bg);
        bg_btn_open = (Button) getActivity().findViewById(R.id.bg_btn_open);
        bg_btn_close = (Button) getActivity().findViewById(R.id.bg_btn_close);
        bg_btn_open.setOnClickListener(this);
        bg_btn_close.setOnClickListener(this);
        super.onActivityCreated(savedInstanceState);
        Log.d(TAG,"补光>>>>>>>>>onActivityCreated");
    }
    @Override
    public void onClick(View v){
        switch (v.getId()){
            //开启按钮事件
            case R.id.bg_btn_open:
                Intent BuGuangIntentService_open = new Intent(getActivity(), com.daogukeji.dapeng.service.BuGuangIntentService_open.class);
                getActivity().startService(BuGuangIntentService_open);
                text_bg.setText("补光正在开启，请稍后...");
                break;
            //关闭按钮事件
            case R.id.bg_btn_close:
                Intent BuGuangIntentService_close = new Intent(getActivity(), com.daogukeji.dapeng.service.BuGuangIntentService_close.class);
                getActivity().startService(BuGuangIntentService_close);
                text_bg.setText("补光正在关闭，请稍后...");
                break;
            default:
                break;
        }
    }
    @Override
    public void onStart(){
        super.onStart();
        Log.d(TAG,"补光>>>>>>>>>onStart");
    }
    @Override
    public void onResume(){
        super.onResume();
        Log.d(TAG,"补光>>>>>>>>>onResume");
    }
    @Override
    public void onPause(){
        super.onPause();
        Log.d(TAG,"补光>>>>>>>>>onPause");
    }
    @Override
    public void onStop(){
        super.onStop();
        Log.d(TAG,"补光>>>>>>>>>onStop");
    }
    @Override
    public void onDestroyView(){
        super.onDestroyView();
        Log.d(TAG,"补光>>>>>>>>>onDestroyView");
    }
    @Override
    public void onDestroy(){
        super.onDestroy();
        Log.d(TAG,"补光>>>>>>>>onDestroy");
    }
    @Override
    public void onDetach(){
        getActivity().unregisterReceiver(receiveBroadCast);//注销广播接收器
        super.onDetach();
        Log.d(TAG,"补光>>>>>>>>onDetach");
    }
}
