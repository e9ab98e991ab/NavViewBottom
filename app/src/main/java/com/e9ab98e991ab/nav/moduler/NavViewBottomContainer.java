package com.e9ab98e991ab.nav.moduler;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gaoxin 2019/12/18 下午 12:03
 * @version V1.0.0
 * @name NavViewBottomContainer
 * @mail godfeer@aliyun.com
 * @description  TODO
 */
public class NavViewBottomContainer extends LinearLayout implements View.OnClickListener {

    private List<NavItem> itemList = new ArrayList<>();

    private OnItemClickListener onItemClickListener;

    private boolean isCustomSelected = true;

    public NavViewBottomContainer(Context context) {
        super(context);
    }

    public NavViewBottomContainer(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public NavViewBottomContainer(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    private int newCheck = 0;
    private int oldCheck = 0;

    /**
     * 设置当前选中位置
     *
     * @param position 当前选中的item位置索引
     */
    public void setSelectedPosition(int position) {
        if (!itemList.isEmpty() && itemList.size() >= getChildCount()) {
            for (int i = 0; i < getChildCount(); i++) {
                if ((getChildAt(i) instanceof NavItemLayout) && !itemList.isEmpty()) {
                    ((NavItemLayout) getChildAt(i)).setSelectAnimator(false, itemList.get(i));
                }
            }
            if ((getChildAt(position) instanceof NavItemLayout) && !itemList.isEmpty()) {
                ((NavItemLayout) getChildAt(position)).setSelectAnimator(true, itemList.get(position));
            }
        }
    }

    /**
     * 添加Item
     * @param itemList
     */
    public void addItem(ArrayList<NavItem> itemList) {
        removeAllViews();
        this.itemList = itemList;
        for (int i = 0; i < itemList.size(); i++) {
            NavItemLayout itemLayout = new NavItemLayout(getContext());
            itemLayout.setSelected(itemList.get(i).getIconResId(),
                    itemList.get(i).getTitleResId());
            LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1, 1.0F);
            itemLayout.setTag(i);
            itemLayout.setOnClickListener(this);
            addView(itemLayout, layoutParams);
        }
    }

    /**
     * 设置Item点击事件
     * @param listener
     */
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.onItemClickListener = listener;
    }


    @Override
    public void onClick(View view) {
        int position = (int) view.getTag();
        newCheck = position;
        if (isCustomSelected){
            setSelectedPosition(newCheck);
        }
        if (onItemClickListener != null) {
            onItemClickListener.onItemSelect(newCheck,oldCheck);
            oldCheck = position;
        }
    }
    public int getOldCheckIndex(){
        return oldCheck;
    }

    public void setCustomSelectedPosition(int i) {
        isCustomSelected = false;
        oldCheck = i;
        setSelectedPosition(i);
    }

    public interface OnItemClickListener {
        void onItemSelect(int newPosition, int oldPosition);
    }

}
