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

public class PaiFeng extends Fragment implements View.OnClickListener{
    public static final String TAG = "PaiFeng";
    public static final String PAIFENG_OPEN = "com.daogukeji.dapeng.service.PaiFengIntentService_open";//开启除湿广播标志
    public static final String PAIFENG_CLOSE = "com.daogukeji.dapeng.service.PaiFengIntentService_close";//关闭除湿广播标志

    private TextView text;
    private Button pf_btn_open;
    private Button pf_btn_close;

    private ReceiveBroadCast receiveBroadCast;
    class ReceiveBroadCast extends BroadcastReceiver {
        @Override
        public void onReceive(Context context,Intent intent){
            if(PAIFENG_OPEN.equals(intent.getAction())){
                String on = intent.getExtras().getString("paifeng_open");
                System.out.println("开启排风接收广播为》》》》》》》");
                text.setText(on);
            }
            if(PAIFENG_CLOSE.equals(intent.getAction())){
                String off = intent.getExtras().getString("paifeng_close");
                System.out.println("关闭排风接收广播为》》》》》》》");
                text.setText(off);
            }
        }
    }

    @Override
    public void onAttach(Context context){
        //注册广播
        receiveBroadCast = new ReceiveBroadCast();
        IntentFilter filter = new IntentFilter();
        filter.addAction(PAIFENG_OPEN);
        filter.addAction(PAIFENG_CLOSE);
        context.registerReceiver(receiveBroadCast,filter);
        super.onAttach(context);
        Log.d(TAG,"排风>>>>>>>>>onAttach");
    }
    public void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        Log.d(TAG,"排风>>>>>>>>>onCreate");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        Log.d(TAG,"排风>>>>>>>>>onCreateView");
        return inflater.inflate(R.layout.pai_feng, container, false);
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        //加载控件和事件
        text = (TextView) getActivity().findViewById(R.id.text);
        pf_btn_open = (Button) getActivity().findViewById(R.id.pf_btn_open);
        pf_btn_close = (Button) getActivity().findViewById(R.id.pf_btn_close);
        pf_btn_open.setOnClickListener(this);
        pf_btn_close.setOnClickListener(this);
        super.onActivityCreated(savedInstanceState);
        Log.d(TAG,"排风>>>>>>>>>onActivityCreated");
    }
    @Override
    public void onClick(View v){
        switch (v.getId()){
            //开启按钮事件
            case R.id.pf_btn_open:
                Intent PaiFengIntentService_open = new Intent(getActivity(), com.daogukeji.dapeng.service.PaiFengIntentService_open.class);
                getActivity().startService(PaiFengIntentService_open);
                text.setText("排风正在开启，请稍后...");
                break;
            //关闭按钮事件
            case R.id.pf_btn_close:
                Intent PaiFengIntentService_close = new Intent(getActivity(), com.daogukeji.dapeng.service.PaiFengIntentService_close.class);
                getActivity().startService(PaiFengIntentService_close);
                text.setText("排风正在关闭，请稍后...");
                break;
            default:
                break;
        }
    }
    @Override
    public void onStart(){
        super.onStart();
        Log.d(TAG,"排风>>>>>>>>>onStart");
    }
    @Override
    public void onResume(){
        super.onResume();
        Log.d(TAG,"排风>>>>>>>>>onResume");
    }
    @Override
    public void onPause(){
        super.onPause();
        Log.d(TAG,"排风>>>>>>>>>onPause");
    }
    @Override
    public void onStop(){
        super.onStop();
        Log.d(TAG,"排风>>>>>>>>>onStop");
    }
    @Override
    public void onDestroyView(){
        super.onDestroyView();
        Log.d(TAG,"排风>>>>>>>>>onDestroyView");
    }
    @Override
    public void onDestroy(){
        super.onDestroy();
        Log.d(TAG,"排风>>>>>>>>>onDestroy");
    }
    @Override
    public void onDetach(){
        getActivity().unregisterReceiver(receiveBroadCast);//注销广播接收器
        super.onDetach();
        Log.d(TAG,"排风>>>>>>>>>onDetach");
    }
}
