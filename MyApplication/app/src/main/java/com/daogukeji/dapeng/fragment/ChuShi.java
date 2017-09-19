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
import android.widget.Toast;

import com.daogukeji.dapeng.R;
import com.daogukeji.dapeng.service.ChuShiIntentService_close;
import com.daogukeji.dapeng.service.ChuShiIntentService_open;

/**
 * Created by dell on 2017/6/17.
 */

public class ChuShi extends Fragment implements View.OnClickListener{
    public static final String CHUSHI_OPEN = "com.daogukeji.dapeng.service.ChuShiIntentService_open";//开启除湿广播标志
    public static final String CHUSHI_CLOSE = "com.daogukeji.dapeng.service.ChuShiIntentService_close";//关闭除湿广播标志
    public static final String TAG = "ChuShi";

    private TextView cs_text;
    private Button cs_btn_open;
    private Button cs_btn_close;

    private ReceiveBroadCast receiveBroadCast;
    class ReceiveBroadCast extends BroadcastReceiver{
        @Override
        public void onReceive(Context context,Intent intent){
            if(CHUSHI_OPEN.equals(intent.getAction())){
                String on = intent.getExtras().getString("chushi_open");
                System.out.println("开启除湿接收广播为》》》》》》》"+on);
                cs_text.setText(on);
            }
            if(CHUSHI_CLOSE.equals(intent.getAction())){
                String off = intent.getExtras().getString("chushi_close");
                System.out.println("关闭除湿接收广播为》》》》》》》"+off);
                cs_text.setText(off);
            }
        }
    }

    @Override
    public void onAttach(Context context){
        //注册广播
        receiveBroadCast = new ReceiveBroadCast();
        IntentFilter filter = new IntentFilter();
        filter.addAction(CHUSHI_OPEN);
        filter.addAction(CHUSHI_CLOSE);
        context.registerReceiver(receiveBroadCast,filter);

        super.onAttach(context);
        Log.d(TAG,"除湿>>>>>>>>>onAttach");
    }
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        Log.d(TAG,"除湿>>>>>>>>>onCreate");
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.d(TAG,"除湿>>>>>>>>>onCreateView");
        return inflater.inflate(R.layout.chu_shi, container, false);
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        //加载控件和事件
        cs_text = (TextView) getActivity().findViewById(R.id.cs_text);
        cs_btn_open = (Button) getActivity().findViewById(R.id.cs_btn_open);
        cs_btn_close = (Button) getActivity().findViewById(R.id.cs_btn_close);
        cs_btn_open.setOnClickListener(this);
        cs_btn_close.setOnClickListener(this);
        super.onActivityCreated(savedInstanceState);
        Log.d(TAG,"除湿>>>>>>>>>onActivityCreated");
    }
    @Override
    public void onClick(View v){
        switch (v.getId()){
            //开启按钮事件
            case R.id.cs_btn_open:
                Intent ChuShiIntentService_open = new Intent(getActivity(),ChuShiIntentService_open.class);
                getActivity().startService(ChuShiIntentService_open);
                cs_text.setText("除湿正在开启，请稍后...");
                break;
            //关闭按钮事件
            case R.id.cs_btn_close:
                Intent ChuShiIntentService_close = new Intent(getActivity(),ChuShiIntentService_close.class);
                getActivity().startService(ChuShiIntentService_close);
                cs_text.setText("除湿正在关闭，请稍后...");
                break;
            default:
                break;
        }
    }
    @Override
    public void onStart(){
        super.onStart();
        Log.d(TAG,"除湿>>>>>>>>>onStart");
    }
    @Override
    public void onResume(){
        super.onResume();
        Log.d(TAG,"除湿>>>>>>>>>onResume");
    }
    @Override
    public void onPause(){
        super.onPause();
        Log.d(TAG,"除湿>>>>>>>>>onPause");
    }
    @Override
    public void onStop(){
        super.onStop();
        Log.d(TAG,"除湿>>>>>>>>>onStop");
    }
    @Override
    public void onDestroyView(){
        //save();
        super.onDestroyView();
        Log.d(TAG,"除湿>>>>>>>>>onDestroyView");
    }
    @Override
    public void onDestroy(){
        super.onDestroy();
        Log.d(TAG,"除湿>>>>>>>>>onDestroy");
    }
    @Override
    public void onDetach(){
        getActivity().unregisterReceiver(receiveBroadCast);//注销广播接收器
        super.onDetach();
        Log.d(TAG,"除湿>>>>>>>>>onDetach");
    }
    /*save
    private Bundle save(){
        Bundle bundle = new Bundle();

            bundle.putString("pf",text.getText().toString());
        Log.d(TAG, "-------------");
        return bundle;
    }
    //qu chu
    private void rec(){
        if(save() != null){
            String pf = save().getString("pf");
            Log.e(TAG, pf+"++++++++");
            Toast.makeText(getActivity(),pf,Toast.LENGTH_LONG).show();
            Log.e(TAG, "wwwwwwwwwwwwwwwwwwwwwww " );
        }
    }


    @Override
    public void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        String cs = text.getText().toString();
        outState.putString("cs",cs);
    }
    */
}
