package com.e9ab98e991ab.nav.moduler;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;
import com.e9ab98e991ab.nav.R;


/** 
 * @author gaoxin 2019/12/18 上午 11:46
 * @version V1.0.0
 * @name NavItemLayout
 * @mail godfeer@aliyun.com
 * @description  TODO
 */
public class NavItemLayout extends FrameLayout {
 
    private TextView mTitle;
 
    private LottieAnimationView mLottieView;

    private LottieAnimatorUpdateListener mAnimatorUpdateListener;


    public NavItemLayout(Context context) {
        super(context);
        initView();
    }

    public NavItemLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public NavItemLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    public void setSelectAnimator(boolean isSelected, NavItem navItem) {
        if (isSelected) {
            mLottieView.playAnimation();
            if (mAnimatorUpdateListener == null) {
                mAnimatorUpdateListener = new LottieAnimatorUpdateListener(navItem);
            }
            //设置动画监听事件
            mLottieView.addAnimatorUpdateListener(mAnimatorUpdateListener);
            mLottieView.setSpeed(2.4f);
            return;
        }

        mLottieView.setProgress(0.0f);
        mLottieView.cancelAnimation();
        mTitle.setTextColor(getResources().getColor(R.color.nav_color_normal));

    }


    //初始化控件
    protected void initView() {
        inflate(getContext(), R.layout.layout_nav_item, this);
        mTitle = findViewById(R.id.title);
        mLottieView = findViewById(R.id.icon);
    }

    //设置选中状态
    protected void setSelected(int rawResId, int titleResId) {
        mLottieView.setVisibility(View.VISIBLE);
        mLottieView.setAnimation(rawResId);
        mTitle.setText(titleResId);
        mTitle.setVisibility(View.VISIBLE);
    }

    class LottieAnimatorUpdateListener implements ValueAnimator.AnimatorUpdateListener {

        private NavItem navItem;

        LottieAnimatorUpdateListener(NavItem navItem) {
            this.navItem = navItem;
        }

        /**
         * 动画进度监听事件
         * @param valueAnimator
         */
        @Override
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (valueAnimator.getAnimatedFraction() >= 0.3f) {
                //获取导航栏标题字体颜色资源ID
                mTitle.setTextColor(getResources().getColor(navItem.getTextColor()));
            }
        }
    }

}
