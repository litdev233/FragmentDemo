package net.litdev.fragmentdemo.fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

import net.litdev.fragmentdemo.BaseFragment;
import net.litdev.fragmentdemo.R;

/**
 * Created by litde on 2016/5/19.
 */
public class HomeFragment extends BaseFragment {
    @Override
    protected View initView(LayoutInflater inflater) {
        View view = inflater.inflate(R.layout.fragment_home,null);

        return view;
    }

    //暴露方法给供父容器调用
//    public void checkTest(){
//        Log.i("s","");
//    }

}
