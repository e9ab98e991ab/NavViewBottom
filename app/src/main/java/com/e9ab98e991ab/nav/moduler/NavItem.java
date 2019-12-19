package com.e9ab98e991ab.nav.moduler;
//
//import android.support.annotation.ColorRes;
//import android.support.annotation.StringRes;

import androidx.annotation.ColorRes;
import androidx.annotation.StringRes;

/**
 * @author gaoxin 2019/12/18 上午 11:46
 * @version V1.0.0
 * @name NavItem
 * @mail godfeer@aliyun.com
 * @description  TODO
 */
public class NavItem {
    private int titleResId;
    private int iconResId;
    private int textColor;

    public NavItem(@StringRes int titleResId, int iconResId, @ColorRes int textColor ) {
        this.titleResId = titleResId;
        this.iconResId = iconResId;
        this.textColor = textColor;
    }
    //获取标题资源ID
    int getTitleResId() {
        return titleResId;
    }

    //获取图标资源ID
    int getIconResId() {
        return iconResId;
    }
    //获取当前资源值
    int getTextColor() {
        return textColor;
    }
}
