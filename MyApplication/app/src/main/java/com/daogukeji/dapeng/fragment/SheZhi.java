package com.daogukeji.dapeng.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.daogukeji.dapeng.R;

/**
 * Created by dell on 2017/6/17.
 */

public class SheZhi extends Fragment {
    public static final String TAG = "SheZhi";

    @Override
    public void onAttach(Context context){
        super.onAttach(context);
        Log.d(TAG,"设置>>>>>>>>>onAttach");
    }
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        Log.d(TAG,"设置>>>>>>>>>onCreate");
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.d(TAG,"设置>>>>>>>>>onCreateView");
        return inflater.inflate(R.layout.she_zhi, container, false);
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        Log.d(TAG,"设置>>>>>>>>>onActivityCreated");
    }
    @Override
    public void onStart(){
        super.onStart();
        Log.d(TAG,"设置>>>>>>>>>onStart");
    }
    @Override
    public void onResume(){
        super.onResume();
        Log.d(TAG,"设置>>>>>>>>>onResume");
    }
    @Override
    public void onPause(){
        super.onPause();
        Log.d(TAG,"设置>>>>>>>>>onPause");
    }
    @Override
    public void onStop(){
        super.onStop();
        Log.d(TAG,"设置>>>>>>>>>onStop");
    }
    @Override
    public void onDestroyView(){
        super.onDestroyView();
        Log.d(TAG,"设置>>>>>>>>>onDestroyView");
    }
    @Override
    public void onDestroy(){
        super.onDestroy();
        Log.d(TAG,"设置>>>>>>>>>onDestroy");
    }
    @Override
    public void onDetach(){
        super.onDetach();
        Log.d(TAG,"设置>>>>>>>>>onDetach");
    }
}
