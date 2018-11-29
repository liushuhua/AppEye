package com.example.lenovo.appdemo.ui.view.bottom;

/**
 * Created by LSH on 2018/11/29.
 * description：底部item
 */
public class BottomItem {

    //标题
    private String title;
    //未选中的图片
    private int normalDrawable;
    //选中后的图片
    private int selectedDrawable;

    public BottomItem(String mTitle, int mNormalDrawable, int mSelectedDrawable) {
        this.title = mTitle;
        this.normalDrawable = mNormalDrawable;
        this.selectedDrawable = mSelectedDrawable;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getNormalDrawable() {
        return normalDrawable;
    }

    public void setNormalDrawable(int normalDrawable) {
        this.normalDrawable = normalDrawable;
    }

    public int getSelectedDrawable() {
        return selectedDrawable;
    }

    public void setSelectedDrawable(int selectedDrawable) {
        this.selectedDrawable = selectedDrawable;
    }

}
