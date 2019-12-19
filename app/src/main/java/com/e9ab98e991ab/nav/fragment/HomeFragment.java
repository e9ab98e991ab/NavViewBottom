package com.e9ab98e991ab.nav.fragment;

import android.animation.ValueAnimator;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.airbnb.lottie.LottieAnimationView;
import com.e9ab98e991ab.nav.R;
import com.e9ab98e991ab.nav.base.BaseFragment;

public class HomeFragment extends BaseFragment {
    public static HomeFragment newInstance() {
        Bundle args = new Bundle();
        HomeFragment fragment = new HomeFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getContentView() {
        return R.layout.fragment_home;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        LottieAnimationView lottieAnimationView = mContentView.findViewById(R.id.home_lottie);
        lottieAnimationView.setAnimation(R.raw.home);
        //设置无限重复
        //mTestLottie.loop(true);
        lottieAnimationView.setRepeatCount(ValueAnimator.INFINITE);
        //运行动画
        lottieAnimationView.playAnimation();
    }
}
