package com.example.chapter3.homework;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TableLayout;

/**
 * 使用 ViewPager 和 Fragment 做一个简单版的好友列表界面
 * 1. 使用 ViewPager 和 Fragment 做个可滑动界面
 * 2. 使用 TabLayout 添加 Tab 支持
 * 3. 对于好友列表 Fragment，使用 Lottie 实现 Loading 效果，在 5s 后展示实际的列表，要求这里的动效是淡入淡出
 */
public class Ch3Ex3Activity extends AppCompatActivity {
    private static final String TAG = "Ch3Ex3Activity";
    private  String[] titles=new String[]{"好友列表","我的好友7"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ch3ex3);

//        View target= findViewById(R.id.animation_view2);
//        ObjectAnimator alpha= ObjectAnimator.ofFloat(target,"alpha",1.0f,0f,0f);
//        alpha.setRepeatCount(ValueAnimator.INFINITE);
//        alpha.setDuration(5000);
//        alpha.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//            @Override
//            public void onAnimationUpdate(ValueAnimator animation) {
//                Log.d("eeee", "onAnimationUpdate: "+(float)animation.getAnimatedValue());
//            }
//        });



        // TODO: ex3-1. 添加 ViewPager 和 Fragment 做可滑动界面
        ;
        ViewPager viewPager=findViewById(R.id.viewpager);
        TabLayout tabLayout=findViewById(R.id.tablayout);
        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                Fragment fragment= new PlaceholderFragment();
                Log.d(TAG, "getItem() called with: i = [" + i + "]");
                return fragment;
//                return new Fragment();
            }

            @Override
            public int getCount() {
                return titles.length;
            }

            @Override
            public CharSequence getPageTitle(int position){
                return titles[position];
            }
        });


        // TODO: ex3-2, 添加 TabLayout 支持 Tab
        tabLayout.setupWithViewPager(viewPager,false);
    }
}
