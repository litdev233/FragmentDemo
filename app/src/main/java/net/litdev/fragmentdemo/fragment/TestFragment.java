package net.litdev.fragmentdemo.fragment;

import android.view.LayoutInflater;
import android.view.View;

import net.litdev.fragmentdemo.BaseFragment;
import net.litdev.fragmentdemo.R;

/**
 * Created by litde on 2016/5/19.
 */
public class TestFragment extends BaseFragment {
    @Override
    protected View initView(LayoutInflater inflater) {
        View view = inflater.inflate(R.layout.fragment_test, null);
        return view;
    }
}
