package com.example.lenovo.appdemo.ui.activity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;

import com.example.lenovo.appdemo.R;

/**
 * 闪屏Activity
 */
public class SplashActivity extends BaseActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //执行Activity关闭动画 step 1
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        setContentView(R.layout.activity_splash);
        //执行Activity关闭动画 step 2
        Transition transition = TransitionInflater.from(this).inflateTransition(R.transition.fade_out);
        getWindow().setExitTransition(transition);
        ImageView backGround = findViewById(R.id.splash_layout_background);
        setAnimator(backGround);
    }

    /**
     * 设置动画
     */
    private void setAnimator(View view) {
        ObjectAnimator scaleX = ObjectAnimator.ofFloat(view, "scaleX", 1f, 1.08f);
        ObjectAnimator scaleY = ObjectAnimator.ofFloat(view, "scaleX", 1f, 1.08f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(scaleX, scaleY);
        animatorSet.setDuration(2000);
        animatorSet.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                //执行Activity关闭动画 step 3
                startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(SplashActivity.this).toBundle());
            }
        });
        animatorSet.start();
    }
}
