package net.litdev.fragmentdemo.fragment;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.astuetz.PagerSlidingTabStrip;

import net.litdev.fragmentdemo.BaseFragment;
import net.litdev.fragmentdemo.R;

/**
 * Created by litde on 2016/5/19.
 */
public class TestFragment extends BaseFragment {

    PagerSlidingTabStrip tabsStrip;
    private String tabTitles[] = new String[] { "技术", "生活", "娱乐","家居","房产" };

    @Override
    protected View initView(LayoutInflater inflater) {
        View view = inflater.inflate(R.layout.fragment_test, null);

        ViewPager viewPager = (ViewPager) view.findViewById(R.id.viewpager);
        viewPager.setAdapter(new SampleFragmentPagerAdapter(getFragmentManager()));

        tabsStrip = (PagerSlidingTabStrip) view.findViewById(R.id.tabs);
        tabsStrip.setViewPager(viewPager);
        tabsStrip.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int position) {
                Log.i("APP","---onPageSelected---："+position);
            }

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                Log.i("APP","---onPageScrolled---："+position +"----positionOffset----"+positionOffset+"---positionOffsetPixels---"+positionOffsetPixels);
                resetTextColor();
                TextView tv  = (TextView) tabsStrip.getTouchables().get(position);
                tv.setTextColor(Color.RED);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                Log.i("APP","---onPageScrollStateChanged---："+state);
            }
        });
        return view;
    }

    private void resetTextColor(){
        for(View view : tabsStrip.getTouchables()){
            TextView tv = (TextView) view;
            tv.setTextColor(Color.BLACK);
        }
    }

    public class SampleFragmentPagerAdapter extends FragmentPagerAdapter {
        final int PAGE_COUNT = 5;
        public SampleFragmentPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return PAGE_COUNT;
        }

        @Override
        public Fragment getItem(int position) {
            return PageFragment.newInstance(position + 1);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            // Generate title based on item position
            return tabTitles[position];
        }
    }

}
