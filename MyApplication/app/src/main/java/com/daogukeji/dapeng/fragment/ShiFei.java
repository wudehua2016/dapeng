package com.daogukeji.dapeng.fragment;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.daogukeji.dapeng.R;
import com.daogukeji.dapeng.service.ChuShiIntentService_close;
import com.daogukeji.dapeng.service.ChuShiIntentService_open;

/**
 * Created by dell on 2017/6/17.
 */

public class ShiFei extends Fragment implements View.OnClickListener{

    public static final String SHIFEI_OPEN = "com.daogukeji.dapeng.service.ShiFeiIntentService_open";//开启除湿广播标志
    public static final String SHIFEI_CLOSE = "com.daogukeji.dapeng.service.ShiFeiIntentService_close";//关闭除湿广播标志
    public static final String TAG = "ChuShi";

    private TextView text;
    private Button btn_open;
    private Button btn_close;

    private ReceiveBroadCast receiveBroadCast;
    class ReceiveBroadCast extends BroadcastReceiver {
        @Override
        public void onReceive(Context context,Intent intent){
            if(SHIFEI_OPEN.equals(intent.getAction())){
                String on = intent.getExtras().getString("shifei_open");
                System.out.println("开启除湿接收广播为》》》》》》》"+on);
                text.setText(on);
            }
            if(SHIFEI_CLOSE.equals(intent.getAction())){
                String off = intent.getExtras().getString("shifei_close");
                System.out.println("关闭除湿接收广播为》》》》》》》"+off);
                text.setText(off);
            }
        }
    }

    @Override
    public void onAttach(Context context){
        //注册广播
        receiveBroadCast = new ReceiveBroadCast();
        IntentFilter filter = new IntentFilter();
        filter.addAction(SHIFEI_OPEN);
        filter.addAction(SHIFEI_CLOSE);
        context.registerReceiver(receiveBroadCast,filter);
        super.onAttach(context);
        Log.d(TAG,"施肥>>>>>>>>>onAttach");
    }
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        Log.d(TAG,"施肥>>>>>>>>>onCreate");
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.d(TAG,"施肥>>>>>>>>>onCreateView");
        return inflater.inflate(R.layout.shi_fei, container, false);
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        //加载控件和事件
        text = (TextView) getActivity().findViewById(R.id.ss_text);
        btn_open = (Button) getActivity().findViewById(R.id.ss_btn_open);
        btn_close = (Button) getActivity().findViewById(R.id.ss_btn_close);
        btn_open.setOnClickListener(this);
        btn_close.setOnClickListener(this);
        super.onActivityCreated(savedInstanceState);
        Log.d(TAG,"施肥>>>>>>>>>onActivityCreated");
    }
    @Override
    public void onClick(View v){
        switch (v.getId()){
            //开启按钮事件
            case R.id.ss_btn_open:
                Intent ShiFeiIntentService_open = new Intent(getActivity(), com.daogukeji.dapeng.service.ShiFeiIntentService_open.class);
                getActivity().startService(ShiFeiIntentService_open);
                text.setText("施肥正在开启，请稍后...");
                break;
            //关闭按钮事件
            case R.id.ss_btn_close:
                Intent ShiFeiIntentService_close = new Intent(getActivity(), com.daogukeji.dapeng.service.ShiFeiIntentService_close.class);
                getActivity().startService(ShiFeiIntentService_close);
                text.setText("施肥正在关闭，请稍后...");
                break;
            default:
                break;
        }
    }
    @Override
    public void onStart(){
        super.onStart();
        Log.d(TAG,"施肥>>>>>>>>>onStart");
    }
    @Override
    public void onResume(){
        super.onResume();
        Log.d(TAG,"施肥>>>>>>>>>onResume");
    }
    @Override
    public void onPause(){
        super.onPause();
        Log.d(TAG,"施肥>>>>>>>>>onPause");
    }
    @Override
    public void onStop(){
        super.onStop();
        Log.d(TAG,"施肥>>>>>>>>>onStop");
    }
    @Override
    public void onDestroyView(){
        super.onDestroyView();
        Log.d(TAG,"施肥>>>>>>>>>onDestroyView");
    }
    @Override
    public void onDestroy(){
        super.onDestroy();
        Log.d(TAG,"施肥>>>>>>>>>onDestroy");
    }
    @Override
    public void onDetach(){
        getActivity().unregisterReceiver(receiveBroadCast);//注销广播接收器
        super.onDetach();
        Log.d(TAG,"施肥>>>>>>>>>onDetach");
    }
}
