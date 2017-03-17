package com.github.kshitij_jain.instalike;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;

/**
 * Created by flash on 17/3/17.
 */

public class InstaLikeView extends RelativeLayout {

    private AppCompatImageView mImageHeart;

    public InstaLikeView(Context context) {
        super(context);
    }

    public InstaLikeView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs, 0);
    }

    public InstaLikeView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs, defStyleAttr);
    }

    private void init(Context context, AttributeSet attrs, int defStyleAttr) {
        mImageHeart = new AppCompatImageView(context);

        LayoutParams heartParams = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
        heartParams.addRule(CENTER_IN_PARENT, TRUE);

        mImageHeart.setLayoutParams(heartParams);
        mImageHeart.setScaleType(ImageView.ScaleType.CENTER);
        mImageHeart.setVisibility(GONE);
        mImageHeart.setImageResource(R.drawable.img_heart);
        addView(mImageHeart);
    }

    public void start() {
        mImageHeart.setVisibility(View.VISIBLE);
        mImageHeart.setScaleY(0f);
        mImageHeart.setScaleX(0f);

        AnimatorSet animatorSet = new AnimatorSet();

        ObjectAnimator heartScaleUpYAnimator = ObjectAnimator.ofFloat(mImageHeart, ImageView.SCALE_Y, 0f, 1f);
        heartScaleUpYAnimator.setDuration(400);
        heartScaleUpYAnimator.setInterpolator(new OvershootInterpolator());

        ObjectAnimator heartScaleUpXAnimator = ObjectAnimator.ofFloat(mImageHeart, ImageView.SCALE_X, 0f, 1f);
        heartScaleUpXAnimator.setDuration(400);
        heartScaleUpXAnimator.setInterpolator(new OvershootInterpolator());

        ObjectAnimator heartScaleDownYAnimator = ObjectAnimator.ofFloat(mImageHeart, ImageView.SCALE_Y, 1f, 0f);
        heartScaleDownYAnimator.setDuration(100);
        heartScaleDownYAnimator.setStartDelay(400);
        heartScaleDownYAnimator.setInterpolator(new LinearInterpolator());

        ObjectAnimator heartScaleDownXAnimator = ObjectAnimator.ofFloat(mImageHeart, ImageView.SCALE_X, 1f, 0f);
        heartScaleDownXAnimator.setDuration(100);
        heartScaleDownXAnimator.setStartDelay(400);
        heartScaleDownXAnimator.setInterpolator(new LinearInterpolator());

        animatorSet.playTogether(heartScaleUpXAnimator,
                heartScaleUpYAnimator);

        animatorSet.play(heartScaleDownXAnimator).
                with(heartScaleDownYAnimator).
                after(heartScaleUpYAnimator);

        animatorSet.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                mImageHeart.setVisibility(View.GONE);
            }
        });

        animatorSet.start();
    }

}
