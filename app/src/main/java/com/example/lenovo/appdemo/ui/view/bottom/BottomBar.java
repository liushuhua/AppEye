package com.example.lenovo.appdemo.ui.view.bottom;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LSH on 2018/11/28.
 * description：底部导航栏
 */
public class BottomBar extends LinearLayout {

    private LinearLayout mTabLayout;
    private LinearLayout.LayoutParams mTabParams;
    private int mCurrentPosition = 0;
    private Context context;
    private List<BottomItemLayout> viewGroup = new ArrayList<>();

    public BottomBar(Context context) {
        super(context);
        init(context);
    }

    public BottomBar(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public BottomBar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }


    private void init(Context context) {
        this.context = context;
        setOrientation(LinearLayout.HORIZONTAL);
        mTabLayout = new LinearLayout(context);
        mTabLayout.setBackgroundColor(Color.WHITE);
        mTabLayout.setOrientation(LinearLayout.HORIZONTAL);
        mTabParams = new LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT);
        mTabParams.weight = 1f;
        addView(mTabLayout, mTabParams);
    }

    public void addItem(BottomItem item) {
        final BottomItemLayout bottomItemLayout = new BottomItemLayout(context);
        bottomItemLayout.setBottomItem(item);
        mTabLayout.addView(bottomItemLayout, mTabParams);
        viewGroup.add(bottomItemLayout);
        bottomItemLayout.setIndex(viewGroup.indexOf(bottomItemLayout));

        bottomItemLayout.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mCurrentPosition == bottomItemLayout.getIndex()) {
                    if (onTabSelectedListener != null) {
                        onTabSelectedListener.onTabReselected(mCurrentPosition);
                    }
                } else {
                    if (onTabSelectedListener != null) {
                        onTabSelectedListener.onTabSelected(bottomItemLayout.getIndex(), mCurrentPosition);
                    }
                    mCurrentPosition = bottomItemLayout.getIndex();
                    refreshBottom(mCurrentPosition);
                }
            }
        });

    }

    public void initialise() {
        viewGroup.get(mCurrentPosition).setSelected(true);
    }

    private void refreshBottom(int index) {
        for (BottomItemLayout itemLayout : viewGroup) {
            if (itemLayout.getIndex() == index) {
                itemLayout.setSelected(true);
            } else {
                itemLayout.setSelected(false);
            }
        }
    }

    public void setOnTabSelectedListener(BottomBar.onTabSelectedListener onTabSelectedListener) {
        this.onTabSelectedListener = onTabSelectedListener;
    }

    private onTabSelectedListener onTabSelectedListener;

    /**
     * 选项卡选择监听
     */
    public interface onTabSelectedListener {
        /**
         * 选项卡被选中
         */
        void onTabSelected(int position, int prePosition);

        /**
         * 当选项卡被重复选择
         */
        void onTabReselected(int position);
    }
}
