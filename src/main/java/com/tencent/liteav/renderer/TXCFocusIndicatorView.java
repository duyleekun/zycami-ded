/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Canvas
 *  android.graphics.Paint
 *  android.graphics.Paint$Style
 *  android.graphics.Rect
 *  android.util.AttributeSet
 *  android.view.View
 *  android.view.animation.Animation
 *  android.view.animation.ScaleAnimation
 *  android.widget.FrameLayout$LayoutParams
 */
package com.tencent.liteav.renderer;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import com.tencent.liteav.renderer.TXCFocusIndicatorView$1;

public class TXCFocusIndicatorView
extends View {
    private static final int FOCUS_AREA_STROKE = 1;
    private int mFocusAreaStroke = 2;
    private Runnable mHideRunnable;
    private Paint mPaint;
    private ScaleAnimation mScaleAnimation;
    private int mSize = 0;

    public TXCFocusIndicatorView(Context context) {
        super(context);
        TXCFocusIndicatorView$1 tXCFocusIndicatorView$1 = new TXCFocusIndicatorView$1(this);
        this.mHideRunnable = tXCFocusIndicatorView$1;
        this.init(null, 0);
    }

    public TXCFocusIndicatorView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TXCFocusIndicatorView$1 tXCFocusIndicatorView$1 = new TXCFocusIndicatorView$1(this);
        this.mHideRunnable = tXCFocusIndicatorView$1;
        this.init(attributeSet, 0);
    }

    public TXCFocusIndicatorView(Context object, AttributeSet attributeSet, int n10) {
        super(object, attributeSet, n10);
        super(this);
        this.mHideRunnable = object;
        this.init(attributeSet, n10);
    }

    private void init(AttributeSet attributeSet, int n10) {
        int n11;
        attributeSet = new Paint();
        this.mPaint = attributeSet;
        this.mFocusAreaStroke = n11 = (int)(this.getContext().getResources().getDisplayMetrics().density * 1.0f + 0.5f);
        attributeSet = new ScaleAnimation(1.3f, 1.0f, 1.3f, 1.0f, 1, 0.5f, 1, 0.5f);
        this.mScaleAnimation = attributeSet;
        attributeSet.setDuration(200L);
    }

    public void onDraw(Canvas canvas) {
        canvas.save();
        int n10 = this.mFocusAreaStroke / 2;
        int n11 = this.mSize;
        int n12 = n11 - n10;
        Rect rect = new Rect(n10, n10, n12, n11 -= n10);
        this.mPaint.setColor(-1);
        Paint paint = this.mPaint;
        Paint.Style style2 = Paint.Style.STROKE;
        paint.setStyle(style2);
        paint = this.mPaint;
        float f10 = n10 * 2;
        paint.setStrokeWidth(f10);
        Paint paint2 = this.mPaint;
        canvas.drawRect(rect, paint2);
        canvas.restore();
        super.onDraw(canvas);
    }

    public void show(int n10, int n11, int n12) {
        Runnable runnable = this.mHideRunnable;
        this.removeCallbacks(runnable);
        this.mScaleAnimation.cancel();
        this.mSize = n12;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams)this.getLayoutParams();
        layoutParams.setMargins(n10, n11, 0, 0);
        layoutParams.width = n10 = this.mSize;
        layoutParams.height = n10;
        this.setVisibility(0);
        this.requestLayout();
        this.mScaleAnimation.reset();
        Object object = this.mScaleAnimation;
        this.startAnimation((Animation)object);
        object = this.mHideRunnable;
        this.postDelayed((Runnable)object, 1000L);
    }
}

