package com.example.lenovo.appdemo.ui.view.bottom;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.lenovo.appdemo.R;

/**
 * Created by LSH on 2018/11/29.
 * description：底部栏item
 */
public class BottomItemLayout extends LinearLayout {

    private TextView bottomItemView;
    //选中显示的Icon
    private Drawable selectedDrawable;
    //正常显示的Icon
    private Drawable normalDrawable;
    //选中Title颜色
    private int selectedTextColor;
    //正常Title颜色
    private int normalTextColor;
    //item的下标
    private int index;
    private Context context;

    public BottomItemLayout(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        this.context = context;
        View root = LayoutInflater.from(context).inflate(R.layout.bottom_item_layout, this, true);
        bottomItemView = root.findViewById(R.id.bottom_item_layout_view);
        setGravity(Gravity.CENTER);
        selectedTextColor = context.getResources().getColor(R.color.colorPrimaryDark, null);
        normalTextColor = context.getResources().getColor(R.color.secondaryText, null);
    }

    /**
     * Item是否选中
     *
     * @param selected 选中
     */
    public void setSelected(boolean selected) {
        if (selected) {
            selectedDrawable.setBounds(0, 0, selectedDrawable.getMinimumWidth(), selectedDrawable.getMinimumHeight());
            bottomItemView.setCompoundDrawables(null, selectedDrawable, null, null);
            bottomItemView.setTextColor(selectedTextColor);
        } else {
            normalDrawable.setBounds(0, 0, normalDrawable.getMinimumWidth(), normalDrawable.getMinimumHeight());
            bottomItemView.setCompoundDrawables(null, normalDrawable, null, null);
            bottomItemView.setTextColor(normalTextColor);
        }
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    /**
     * 设置Item的初始属性
     *
     * @param item 参数
     */
    public void setBottomItem(BottomItem item) {
        selectedDrawable = context.getDrawable(item.getSelectedDrawable());
        normalDrawable = context.getDrawable(item.getNormalDrawable());
        bottomItemView.setText(item.getTitle());
        normalDrawable.setBounds(0, 0, normalDrawable.getMinimumWidth(), normalDrawable.getMinimumHeight());
        bottomItemView.setCompoundDrawables(null, normalDrawable, null, null);
        bottomItemView.setTextColor(normalTextColor);
    }

}
