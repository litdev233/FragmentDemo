package net.litdev.fragmentdemo.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioGroup;

import net.litdev.fragmentdemo.BaseFragmentController;
import net.litdev.fragmentdemo.R;
import net.litdev.fragmentdemo.fragment.HomeFragment;
import net.litdev.fragmentdemo.fragment.TestFragment;
import net.litdev.fragmentdemo.fragment.UserFragment;

import java.util.ArrayList;


public class MainActivity extends FragmentActivity {

    private FrameLayout fl_container;
    private BaseFragmentController controller;
    private RadioGroup rg_group;
    private DrawerLayout drawer_layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();


    }

    private void initView() {
        drawer_layout = (DrawerLayout) findViewById(R.id.drawer_layout);
        fl_container = (FrameLayout) findViewById(R.id.fl_container);
        rg_group = (RadioGroup) findViewById(R.id.rg_group);

        rg_group.setOnCheckedChangeListener(new rbGroupListener());

        ArrayList<Fragment> fragmentArrayList = new ArrayList<>();
        fragmentArrayList.add(new HomeFragment());
        fragmentArrayList.add(new TestFragment());
        fragmentArrayList.add(new UserFragment());
        controller = BaseFragmentController.getInstance(this,R.id.fl_container,fragmentArrayList);
        //默认显示第一个Fragment
        controller.showFragment(0);

        //通过这样调用Fragment里的方法
        //((HomeFragment)controller.getFragment(0)).checkTest();

        drawer_layout.addDrawerListener(new customDrawerListener());
    }

    /**
     * 抽屉监听器
     */
    private class customDrawerListener implements DrawerLayout.DrawerListener
    {

        @Override
        public void onDrawerSlide(View drawerView, float slideOffset) {

        }

        @Override
        public void onDrawerOpened(View drawerView) {
            Log.i("app","打开");
        }

        @Override
        public void onDrawerClosed(View drawerView) {
            Log.i("app","关闭");
        }

        @Override
        public void onDrawerStateChanged(int newState) {

        }
    }

    private class rbGroupListener implements RadioGroup.OnCheckedChangeListener
    {

        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            int index = 0;
            switch (checkedId){
                case R.id.rb_home:
                    index=0;
                    break;
                case R.id.rb_test:
                    index=1;
                    break;
                case R.id.rb_user:
                    index=2;
                    break;
            }
            controller.showFragment(index);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        controller.clearFragment();
    }
}
