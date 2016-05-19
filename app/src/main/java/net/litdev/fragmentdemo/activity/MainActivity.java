package net.litdev.fragmentdemo.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();


    }

    private void initView() {
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
