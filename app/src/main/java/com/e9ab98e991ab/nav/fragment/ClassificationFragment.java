package com.e9ab98e991ab.nav.fragment;

import android.animation.ValueAnimator;
import android.os.Bundle;

import com.airbnb.lottie.LottieAnimationView;
import com.e9ab98e991ab.nav.R;
import com.e9ab98e991ab.nav.base.BaseFragment;

public class ClassificationFragment extends BaseFragment {
    public static ClassificationFragment newInstance() {
        Bundle args = new Bundle();
        ClassificationFragment fragment = new ClassificationFragment();
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
        lottieAnimationView.setAnimation(R.raw.classification);
        //设置无限重复
        //mTestLottie.loop(true);
        lottieAnimationView.setRepeatCount(ValueAnimator.INFINITE);
        //运行动画
        lottieAnimationView.playAnimation();
    }
}
