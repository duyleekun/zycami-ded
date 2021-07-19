/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.Animator$AnimatorListener
 *  android.animation.TimeInterpolator
 *  android.animation.ValueAnimator
 *  android.animation.ValueAnimator$AnimatorUpdateListener
 *  android.content.Context
 *  android.content.res.Resources
 *  android.graphics.Canvas
 *  android.graphics.ColorFilter
 *  android.graphics.Paint$Cap
 *  android.graphics.Rect
 *  android.graphics.drawable.Animatable
 *  android.graphics.drawable.Drawable
 *  android.view.animation.Interpolator
 *  android.view.animation.LinearInterpolator
 */
package androidx.swiperefreshlayout.widget;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import androidx.core.util.Preconditions;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import androidx.swiperefreshlayout.widget.CircularProgressDrawable$1;
import androidx.swiperefreshlayout.widget.CircularProgressDrawable$2;
import androidx.swiperefreshlayout.widget.CircularProgressDrawable$Ring;

public class CircularProgressDrawable
extends Drawable
implements Animatable {
    private static final int ANIMATION_DURATION = 1332;
    private static final int ARROW_HEIGHT = 5;
    private static final int ARROW_HEIGHT_LARGE = 6;
    private static final int ARROW_WIDTH = 10;
    private static final int ARROW_WIDTH_LARGE = 12;
    private static final float CENTER_RADIUS = 7.5f;
    private static final float CENTER_RADIUS_LARGE = 11.0f;
    private static final int[] COLORS;
    private static final float COLOR_CHANGE_OFFSET = 0.75f;
    public static final int DEFAULT = 1;
    private static final float GROUP_FULL_ROTATION = 216.0f;
    public static final int LARGE = 0;
    private static final Interpolator LINEAR_INTERPOLATOR;
    private static final Interpolator MATERIAL_INTERPOLATOR;
    private static final float MAX_PROGRESS_ARC = 0.8f;
    private static final float MIN_PROGRESS_ARC = 0.01f;
    private static final float RING_ROTATION = 0.20999998f;
    private static final float SHRINK_OFFSET = 0.5f;
    private static final float STROKE_WIDTH = 2.5f;
    private static final float STROKE_WIDTH_LARGE = 3.0f;
    private Animator mAnimator;
    public boolean mFinishing;
    private Resources mResources;
    private final CircularProgressDrawable$Ring mRing;
    private float mRotation;
    public float mRotationCount;

    static {
        Object object = new LinearInterpolator();
        LINEAR_INTERPOLATOR = object;
        object = new FastOutSlowInInterpolator();
        MATERIAL_INTERPOLATOR = object;
        object = new int[1];
        object[0] = (LinearInterpolator)-16777216;
        COLORS = (int[])object;
    }

    public CircularProgressDrawable(Context object) {
        object = ((Context)Preconditions.checkNotNull(object)).getResources();
        this.mResources = object;
        this.mRing = object;
        int[] nArray = COLORS;
        ((CircularProgressDrawable$Ring)object).setColors(nArray);
        this.setStrokeWidth(2.5f);
        this.setupAnimators();
    }

    private void applyFinishTranslation(float f10, CircularProgressDrawable$Ring circularProgressDrawable$Ring) {
        this.updateRingColor(f10, circularProgressDrawable$Ring);
        float f11 = (float)(Math.floor(circularProgressDrawable$Ring.getStartingRotation() / 0.8f) + 1.0);
        float f12 = circularProgressDrawable$Ring.getStartingStartTrim();
        float f13 = circularProgressDrawable$Ring.getStartingEndTrim() - 0.01f;
        float f14 = circularProgressDrawable$Ring.getStartingStartTrim();
        f13 = (f13 - f14) * f10;
        circularProgressDrawable$Ring.setStartTrim(f12 += f13);
        f12 = circularProgressDrawable$Ring.getStartingEndTrim();
        circularProgressDrawable$Ring.setEndTrim(f12);
        f12 = circularProgressDrawable$Ring.getStartingRotation();
        f13 = circularProgressDrawable$Ring.getStartingRotation();
        f11 = (f11 - f13) * f10;
        circularProgressDrawable$Ring.setRotation(f12 += f11);
    }

    private int evaluateColorChange(float f10, int n10, int n11) {
        int n12 = n10 >> 24 & 0xFF;
        int n13 = n10 >> 16 & 0xFF;
        int n14 = n10 >> 8 & 0xFF;
        int n15 = n11 >> 24 & 0xFF;
        int n16 = n11 >> 16 & 0xFF;
        int n17 = n11 >> 8 & 0xFF;
        n15 = (int)((float)(n15 - n12) * f10);
        n12 = n12 + n15 << 24;
        n15 = (int)((float)(n16 - n13) * f10);
        n13 = n13 + n15 << 16;
        n12 |= n13;
        n13 = (int)((float)(n17 - n14) * f10);
        n13 = n14 + n13 << 8;
        float f11 = (n11 &= 0xFF) - (n10 &= 0xFF);
        int n18 = (int)(f10 * f11);
        return (n12 |= n13) | (n10 += n18);
    }

    private float getRotation() {
        return this.mRotation;
    }

    private void setRotation(float f10) {
        this.mRotation = f10;
    }

    private void setSizeParameters(float f10, float f11, float f12, float f13) {
        CircularProgressDrawable$Ring circularProgressDrawable$Ring = this.mRing;
        float f14 = this.mResources.getDisplayMetrics().density;
        circularProgressDrawable$Ring.setStrokeWidth(f11 *= f14);
        circularProgressDrawable$Ring.setCenterRadius(f10 *= f14);
        circularProgressDrawable$Ring.setColorIndex(0);
        circularProgressDrawable$Ring.setArrowDimensions(f12 *= f14, f13 *= f14);
    }

    private void setupAnimators() {
        CircularProgressDrawable$Ring circularProgressDrawable$Ring = this.mRing;
        Object object = new float[]{0.0f, 1.0f};
        object = ValueAnimator.ofFloat((float[])object);
        Object object2 = new CircularProgressDrawable$1(this, circularProgressDrawable$Ring);
        object.addUpdateListener((ValueAnimator.AnimatorUpdateListener)object2);
        object.setRepeatCount(-1);
        object.setRepeatMode(1);
        object2 = LINEAR_INTERPOLATOR;
        object.setInterpolator((TimeInterpolator)object2);
        object2 = new CircularProgressDrawable$2(this, circularProgressDrawable$Ring);
        object.addListener((Animator.AnimatorListener)object2);
        this.mAnimator = (Animator)object;
    }

    public void applyTransformation(float f10, CircularProgressDrawable$Ring circularProgressDrawable$Ring, boolean bl2) {
        int n10 = this.mFinishing;
        if (n10 != 0) {
            this.applyFinishTranslation(f10, circularProgressDrawable$Ring);
        } else {
            n10 = 1065353216;
            float f11 = 1.0f;
            float f12 = f10 - f11;
            Object object = f12 == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1);
            if (object != false || bl2) {
                float f13;
                float f14 = circularProgressDrawable$Ring.getStartingRotation();
                object = 0x3F000000;
                float f15 = 0.5f;
                float f16 = f10 == f15 ? 0 : (f10 < f15 ? -1 : 1);
                float f17 = 0.01f;
                float f18 = 0.79f;
                if (f16 < 0) {
                    f11 = f10 / f15;
                    f15 = circularProgressDrawable$Ring.getStartingStartTrim();
                    Interpolator interpolator2 = MATERIAL_INTERPOLATOR;
                    f11 = interpolator2.getInterpolation(f11) * f18 + f17 + f15;
                } else {
                    f13 = (f10 - f15) / f15;
                    f15 = circularProgressDrawable$Ring.getStartingStartTrim() + f18;
                    Interpolator interpolator3 = MATERIAL_INTERPOLATOR;
                    f13 = interpolator3.getInterpolation(f13);
                    f11 = (f11 - f13) * f18 + f17;
                    f11 = f15 - f11;
                    float f19 = f15;
                    f15 = f11;
                    f11 = f19;
                }
                f13 = 0.20999998f * f10;
                f14 += f13;
                f16 = 1129840640;
                f13 = 216.0f;
                f17 = this.mRotationCount;
                f10 = (f10 + f17) * f13;
                circularProgressDrawable$Ring.setStartTrim(f15);
                circularProgressDrawable$Ring.setEndTrim(f11);
                circularProgressDrawable$Ring.setRotation(f14);
                this.setRotation(f10);
            }
        }
    }

    public void draw(Canvas canvas) {
        Rect rect = this.getBounds();
        canvas.save();
        float f10 = this.mRotation;
        float f11 = rect.exactCenterX();
        float f12 = rect.exactCenterY();
        canvas.rotate(f10, f11, f12);
        this.mRing.draw(canvas, rect);
        canvas.restore();
    }

    public int getAlpha() {
        return this.mRing.getAlpha();
    }

    public boolean getArrowEnabled() {
        return this.mRing.getShowArrow();
    }

    public float getArrowHeight() {
        return this.mRing.getArrowHeight();
    }

    public float getArrowScale() {
        return this.mRing.getArrowScale();
    }

    public float getArrowWidth() {
        return this.mRing.getArrowWidth();
    }

    public int getBackgroundColor() {
        return this.mRing.getBackgroundColor();
    }

    public float getCenterRadius() {
        return this.mRing.getCenterRadius();
    }

    public int[] getColorSchemeColors() {
        return this.mRing.getColors();
    }

    public float getEndTrim() {
        return this.mRing.getEndTrim();
    }

    public int getOpacity() {
        return -3;
    }

    public float getProgressRotation() {
        return this.mRing.getRotation();
    }

    public float getStartTrim() {
        return this.mRing.getStartTrim();
    }

    public Paint.Cap getStrokeCap() {
        return this.mRing.getStrokeCap();
    }

    public float getStrokeWidth() {
        return this.mRing.getStrokeWidth();
    }

    public boolean isRunning() {
        return this.mAnimator.isRunning();
    }

    public void setAlpha(int n10) {
        this.mRing.setAlpha(n10);
        this.invalidateSelf();
    }

    public void setArrowDimensions(float f10, float f11) {
        this.mRing.setArrowDimensions(f10, f11);
        this.invalidateSelf();
    }

    public void setArrowEnabled(boolean bl2) {
        this.mRing.setShowArrow(bl2);
        this.invalidateSelf();
    }

    public void setArrowScale(float f10) {
        this.mRing.setArrowScale(f10);
        this.invalidateSelf();
    }

    public void setBackgroundColor(int n10) {
        this.mRing.setBackgroundColor(n10);
        this.invalidateSelf();
    }

    public void setCenterRadius(float f10) {
        this.mRing.setCenterRadius(f10);
        this.invalidateSelf();
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.mRing.setColorFilter(colorFilter);
        this.invalidateSelf();
    }

    public void setColorSchemeColors(int ... nArray) {
        this.mRing.setColors(nArray);
        this.mRing.setColorIndex(0);
        this.invalidateSelf();
    }

    public void setProgressRotation(float f10) {
        this.mRing.setRotation(f10);
        this.invalidateSelf();
    }

    public void setStartEndTrim(float f10, float f11) {
        this.mRing.setStartTrim(f10);
        this.mRing.setEndTrim(f11);
        this.invalidateSelf();
    }

    public void setStrokeCap(Paint.Cap cap) {
        this.mRing.setStrokeCap(cap);
        this.invalidateSelf();
    }

    public void setStrokeWidth(float f10) {
        this.mRing.setStrokeWidth(f10);
        this.invalidateSelf();
    }

    public void setStyle(int n10) {
        if (n10 == 0) {
            n10 = 1093664768;
            float f10 = 11.0f;
            float f11 = 3.0f;
            float f12 = 12.0f;
            float f13 = 6.0f;
            this.setSizeParameters(f10, f11, f12, f13);
        } else {
            n10 = 0x40F00000;
            float f14 = 7.5f;
            float f15 = 2.5f;
            float f16 = 10.0f;
            float f17 = 5.0f;
            this.setSizeParameters(f14, f15, f16, f17);
        }
        this.invalidateSelf();
    }

    public void start() {
        this.mAnimator.cancel();
        this.mRing.storeOriginals();
        CircularProgressDrawable$Ring circularProgressDrawable$Ring = this.mRing;
        float f10 = circularProgressDrawable$Ring.getEndTrim();
        CircularProgressDrawable$Ring circularProgressDrawable$Ring2 = this.mRing;
        float f11 = circularProgressDrawable$Ring2.getStartTrim();
        float f12 = f10 == f11 ? 0 : (f10 > f11 ? 1 : -1);
        if (f12 != false) {
            f12 = 1.0f;
            f10 = Float.MIN_VALUE;
            this.mFinishing = f12;
            circularProgressDrawable$Ring = this.mAnimator;
            long l10 = 666L;
            circularProgressDrawable$Ring.setDuration(l10);
            circularProgressDrawable$Ring = this.mAnimator;
            circularProgressDrawable$Ring.start();
        } else {
            circularProgressDrawable$Ring = this.mRing;
            f11 = 0.0f;
            circularProgressDrawable$Ring2 = null;
            circularProgressDrawable$Ring.setColorIndex(0);
            this.mRing.resetOriginals();
            circularProgressDrawable$Ring = this.mAnimator;
            long l11 = 1332L;
            circularProgressDrawable$Ring.setDuration(l11);
            circularProgressDrawable$Ring = this.mAnimator;
            circularProgressDrawable$Ring.start();
        }
    }

    public void stop() {
        this.mAnimator.cancel();
        this.setRotation(0.0f);
        this.mRing.setShowArrow(false);
        this.mRing.setColorIndex(0);
        this.mRing.resetOriginals();
        this.invalidateSelf();
    }

    public void updateRingColor(float f10, CircularProgressDrawable$Ring circularProgressDrawable$Ring) {
        int n10 = 1061158912;
        float f11 = 0.75f;
        float f12 = f10 - f11;
        Object object = f12 == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1);
        if (object > 0) {
            f10 -= f11;
            f11 = 0.25f;
            n10 = circularProgressDrawable$Ring.getStartingColor();
            object = circularProgressDrawable$Ring.getNextColor();
            int n11 = this.evaluateColorChange(f10 /= f11, n10, (int)object);
            circularProgressDrawable$Ring.setColor(n11);
        } else {
            int n12 = circularProgressDrawable$Ring.getStartingColor();
            circularProgressDrawable$Ring.setColor(n12);
        }
    }
}

