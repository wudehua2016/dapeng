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
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.daogukeji.dapeng.R;
import com.daogukeji.dapeng.service.ChuShiIntentService_close;
import com.daogukeji.dapeng.service.ChuShiIntentService_open;
import com.daogukeji.dapeng.service.GuanGaiIntentService_open;
import com.daogukeji.dapeng.service.GuanGaiIntentService_close;


/**
 * Created by dell on 2017/6/17.
 *灌溉fragment类：开关控制后台服务 发送开启与关闭指令
 */

public class GuanGai extends Fragment implements View.OnClickListener{
    public static final String GUANGAI_OPEN = "com.daogukeji.dapeng.service.GuanGaiIntentService_open";//开启灌溉广播标志
    public static final String GUANGAI_CLOSE = "com.daogukeji.dapeng.service.GuanGaiIntentService_close";//关闭灌溉广播标志
    public static final String TAG = "GuanGai";

    private TextView gg_text;
    private Button gg_btn_open;
    private Button gg_btn_close;
    private ReceiveBroadCast receiveBroadCast;//广播接收器

    class ReceiveBroadCast extends BroadcastReceiver{
        @Override
        public void onReceive(Context context,Intent intent){
            if(intent.getAction().equals(GUANGAI_OPEN)){//若接收广播标志为GUANGAI
                String on = intent.getExtras().getString("guangai_open");
                System.out.println("接收开启灌溉广播为》》》》》》》"+on);
                gg_text.setText(on);
            }
            if(intent.getAction().equals(GUANGAI_CLOSE)){//若接收广播标志为GUANGAI
                String off = intent.getExtras().getString("guangai_close");
                System.out.println("接收关闭灌溉广播为》》》》》》》"+off);
                gg_text.setText(off);
            }
        }
    }

    @Override
    public void onAttach(Context context){
        //*注册广播 */
        receiveBroadCast = new ReceiveBroadCast();
        IntentFilter filter = new IntentFilter();
        filter.addAction(GUANGAI_OPEN);    //只有持有相同的action的接受者才能接收此广播
        filter.addAction(GUANGAI_CLOSE);
        context.registerReceiver(receiveBroadCast, filter);
        super.onAttach(context);
        Log.d(TAG,"灌溉>>>>>>>>>onAttach");
    }
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        Log.d(TAG,"灌溉>>>>>>>>>onCreate");
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.d(TAG,"灌溉>>>>>>>>>onCreateView");
        return inflater.inflate(R.layout.guan_gai, container, false);
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        //加载控件和事件
        gg_text = (TextView) getActivity().findViewById(R.id.gg_text);
        gg_btn_open = (Button) getActivity().findViewById(R.id.gg_btn_open);
        gg_btn_close = (Button) getActivity().findViewById(R.id.gg_btn_close);
        gg_btn_open.setOnClickListener(this);
        gg_btn_close.setOnClickListener(this);
        super.onActivityCreated(savedInstanceState);
        Log.d(TAG,"灌溉>>>>>>>>>onActivityCreated");
    }

    @Override
    public void onClick(View v){
        switch (v.getId()){
            //开启按钮事件
            case R.id.gg_btn_open:
                Intent GuanGaiIntentService_open = new Intent(getActivity(), com.daogukeji.dapeng.service.GuanGaiIntentService_open.class);
                getActivity().startService(GuanGaiIntentService_open);
                gg_text.setText("灌溉正在开启，请稍后...");
                break;
            //关闭按钮事件
            case R.id.gg_btn_close:
                Intent GuanGaiIntentService_close = new Intent(getActivity(), com.daogukeji.dapeng.service.GuanGaiIntentService_close.class);
                getActivity().startService(GuanGaiIntentService_close);
                gg_text.setText("灌溉正在关闭，请稍后...");
                break;
            default:
                break;
        }
    }
    @Override
    public void onStart(){
        super.onStart();
        Log.d(TAG,"灌溉>>>>>>>>>onStart");
    }
    @Override
    public void onResume(){
        super.onResume();
        Log.d(TAG,"灌溉>>>>>>>>>onResume");
    }
    @Override
    public void onPause(){
        super.onPause();
        Log.d(TAG,"灌溉>>>>>>>>>onPause");
    }
    @Override
    public void onStop(){
        super.onStop();
        Log.d(TAG,"灌溉>>>>>>>>>onStop");
    }
    @Override
    public void onDestroyView(){
        super.onDestroyView();
        Log.d(TAG,"灌溉>>>>>>>>>onDestroyView");
    }
    @Override
    public void onDestroy(){
        super.onDestroy();
        Log.d(TAG,"灌溉>>>>>>>>>onDestroy");
    }
    @Override
    public void onDetach(){
        getActivity().unregisterReceiver(receiveBroadCast);//注销广播
        super.onDetach();
        Log.d(TAG,"灌溉>>>>>>>>>onDetach");
    }
}
