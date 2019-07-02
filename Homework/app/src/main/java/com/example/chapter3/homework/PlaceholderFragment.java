package com.example.chapter3.homework;


import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class PlaceholderFragment extends Fragment {
    private static final String TAG = "PlaceholderFragment";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO ex3-3: 修改 fragment_placeholder，添加 loading 控件和列表视图控件
        return inflater.inflate(R.layout.fragment_placeholder, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
//        Log.d(TAG, "onActivityCreated() called with: savedInstanceState = [" + savedInstanceState + "]");
        final View view=getView();
        view.postDelayed(new Runnable() {
            LoadingFragment loadingFragment=new LoadingFragment();
            @Override
            public void run() {
                // 这里会在 5s 后执行
                //getFragmentManager().beginTransaction().replace(R.id.animation_view3,new Fragment()).commit();
                /**
                 * 使用上行代码会崩溃？？？
                 */
                // TODO ex3-4：实现动画，将 lottie 控件淡出，列表数据淡入
                view.animate()
                        .alpha(0f)
                        .setDuration(1000)
                        .setListener(null);
                //Log.d(TAG, "run: getfragment"+getFragmentManager().findFragmentById(R.id.frameLayout33));
                /**
                 * 把loading隐藏后，采用方式
                 * getFragmentManager().beginTransaction(,).replace().commit()
                 * getFragmentManager().findFragmentById(R.id.frameLayout33),去分别设置lottie和列表的淡入淡出
                 * failed
                 *
                 * Fragment 和FrameLayout区别和联系
                 *
                 * 列表使用与上次作业类似的方式
                 */
            }
        }, 5000);
    }
}
