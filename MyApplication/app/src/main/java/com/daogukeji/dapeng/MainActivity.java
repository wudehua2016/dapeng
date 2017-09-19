package com.daogukeji.dapeng;



import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.daogukeji.dapeng.fragment.BuGuang;
import com.daogukeji.dapeng.fragment.ChuShi;
import com.daogukeji.dapeng.fragment.GuanGai;
import com.daogukeji.dapeng.fragment.KaiGuan;
import com.daogukeji.dapeng.fragment.PaiFeng;
import com.daogukeji.dapeng.fragment.SheZhi;
import com.daogukeji.dapeng.fragment.ShiFei;
import com.daogukeji.dapeng.service.Controller;

import java.util.ArrayList;
import java.util.List;

/**
 * 此类为主活动类：加载fragment布局，启动后台服务
 * 启动app。开关加载  显示开关界面onActivityCreated执行
 *          排风加载  当切换到排风选项卡时 补光加载
 *                    当切换到补光选项卡时 开关DestroyVIew 后边的除湿加载
 *                    选项卡 n 加载时：n-2 的选项卡onDestroyVIew
 *                                  n+2 的选项卡onActivityCreated
 */

public class MainActivity extends AppCompatActivity {
    //广播标志
    public static final String CONTROLLER = "com.daogukeji.dapeng.service.Controller";
    //选项卡
    private TabLayout mTabLyout;//选项卡控件
    private ViewPager mViewPager;//每个选项卡显示的内容（需要关联）
    private List<Fragment> list_fragment;//fragment集合，用于将多个fragment添加到activity中来
    private KaiGuan KaiGuan;//开关fragment
    private PaiFeng PaiFeng;//排风fragment
    private BuGuang BuGuang;//补光fragmen
    private ChuShi ChuShi;//除湿fragment
    private GuanGai GuanGai;//灌溉fragment
    private ShiFei ShiFei;//施肥fragment
    private SheZhi SheZhi;//设置fragment
    //tabLayout
    private TabLayout PaiFeng_icon;

    //此广播接收器可以写到对应的fragment下面
    /*温湿度广播接收器
    public BroadcastReceiver tempReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if(intent.getAction().equals(CONTROLLER)){
               a = intent.getExtras().getString("count");
                Log.d("MainActivity",a);

            }
        }
    };*/

    //TabLayout的标题内容  是一个String 数组
    private String[] mTitles =new String[]{"开关","排风","补光","除湿","灌溉","施肥","设置"};

    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_main);
        /*activyty向fragment传值的错误写法
        //向KaiGuan传值
        KaiGuan = new KaiGuan();
        Bundle bundle = new Bundle();
        bundle.putString("sun",a);
        KaiGuan.setArguments(bundle);
       // System.out.println(a);
       */

        //启动后台服务
        Intent Intent = new Intent(MainActivity.this,com.daogukeji.dapeng.service.Controller.class);
        startService(Intent);
        //加载选项卡
        intiViews();
    }
    //选项卡显示方法
    protected void intiViews(){
        mTabLyout = (TabLayout)findViewById(R.id.id_tablayout);//在activity_main下加载这两个布局
        mViewPager = (ViewPager) findViewById(R.id.id_viewpager);

        KaiGuan = new KaiGuan();//实例化
        PaiFeng = new PaiFeng();
        BuGuang = new BuGuang();
        ChuShi = new ChuShi();
        GuanGai = new GuanGai();
        ShiFei = new ShiFei();
        SheZhi = new SheZhi();
        list_fragment = new ArrayList<>();//创建List集合用于显示多个选项卡及内容
        list_fragment.add(KaiGuan);//按照要求按顺序添加
        list_fragment.add(PaiFeng);
        list_fragment.add(BuGuang);
        list_fragment.add(ChuShi);
        list_fragment.add(GuanGai);
        list_fragment.add(ShiFei);
        list_fragment.add(SheZhi);

        //Viewpager通过适配器与Fragment关联
        mViewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return list_fragment.get(position);
            }

            @Override
            public int getCount() {
                return mTitles.length;
            }

            @Override
            public CharSequence getPageTitle(int position){
                return mTitles[position];
            }
        });
        //TabLayout和ViewPager关联
        mTabLyout.setupWithViewPager(mViewPager);
        mViewPager.setOffscreenPageLimit(list_fragment.size());
        //加载选项卡图标

    }

    @Override
    public void onDestroy(){
        super.onDestroy();
    }
}











