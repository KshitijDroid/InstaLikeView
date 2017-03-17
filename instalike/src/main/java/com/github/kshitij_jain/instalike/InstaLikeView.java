package com.github.kshitij_jain.instalike;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorInt;
import android.support.annotation.DrawableRes;
import android.support.v4.content.ContextCompat;
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
        TypedArray a = context.getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.InstaLikeView,
                defStyleAttr, 0);

        int likeColor = a.getColor(R.styleable.InstaLikeView_likeColor, ContextCompat.getColor(context, R.color.heartColor));
        int likeSrc = a.getResourceId(R.styleable.InstaLikeView_likeSrc, R.drawable.img_heart);
        int likeSize = a.getDimensionPixelSize(R.styleable.InstaLikeView_likeSize, getResources().getDimensionPixelSize(R.dimen.likeSize));


        LayoutParams heartParams = new LayoutParams(likeSize, likeSize);
        heartParams.addRule(CENTER_IN_PARENT, TRUE);

        mImageHeart.setLayoutParams(heartParams);
        mImageHeart.setVisibility(GONE);
        mImageHeart.setImageResource(likeSrc);
        mImageHeart.setColorFilter(likeColor);
        addView(mImageHeart);
    }

    public void start() {
        mImageHeart.setVisibility(View.VISIBLE);
        mImageHeart.setScaleY(0f);
        mImageHeart.setScaleX(0f);

        AnimatorSet animatorSet = new AnimatorSet();

        ObjectAnimator likeScaleUpYAnimator = ObjectAnimator.ofFloat(mImageHeart, ImageView.SCALE_Y, 0f, 1f);
        likeScaleUpYAnimator.setDuration(400);
        likeScaleUpYAnimator.setInterpolator(new OvershootInterpolator());

        ObjectAnimator likeScaleUpXAnimator = ObjectAnimator.ofFloat(mImageHeart, ImageView.SCALE_X, 0f, 1f);
        likeScaleUpXAnimator.setDuration(400);
        likeScaleUpXAnimator.setInterpolator(new OvershootInterpolator());

        ObjectAnimator likeScaleDownYAnimator = ObjectAnimator.ofFloat(mImageHeart, ImageView.SCALE_Y, 1f, 0f);
        likeScaleDownYAnimator.setDuration(100);

        ObjectAnimator likeScaleDownXAnimator = ObjectAnimator.ofFloat(mImageHeart, ImageView.SCALE_X, 1f, 0f);
        likeScaleDownXAnimator.setDuration(100);

        animatorSet.playTogether(likeScaleUpXAnimator,
                likeScaleUpYAnimator);

        animatorSet.play(likeScaleDownXAnimator).
                with(likeScaleDownYAnimator).
                after(800);

        animatorSet.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                mImageHeart.setVisibility(View.GONE);
            }
        });

        animatorSet.start();
    }

    public void setLikeResource(@DrawableRes int resource) {
        mImageHeart.setImageResource(resource);
    }

    public void setLikeDrawable(Drawable drawable) {
        mImageHeart.setImageDrawable(drawable);
    }

    public void setLikeColor(@ColorInt int color) {
        mImageHeart.setColorFilter(color);
    }

}
