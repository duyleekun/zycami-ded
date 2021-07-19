/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Canvas
 *  android.graphics.ColorFilter
 *  android.graphics.Paint
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.PorterDuffColorFilter
 *  android.graphics.Rect
 *  android.graphics.drawable.Drawable
 *  android.os.Build$VERSION
 *  android.os.Parcelable
 *  android.util.AttributeSet
 *  android.util.Log
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewGroup$MarginLayoutParams
 */
package androidx.slidingpanelayout.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.ContextCompat;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.customview.widget.ViewDragHelper;
import androidx.customview.widget.ViewDragHelper$Callback;
import androidx.slidingpanelayout.widget.SlidingPaneLayout$DisableLayerRunnable;
import androidx.slidingpanelayout.widget.SlidingPaneLayout$LayoutParams;
import androidx.slidingpanelayout.widget.SlidingPaneLayout$PanelSlideListener;
import androidx.slidingpanelayout.widget.SlidingPaneLayout$SavedState;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class SlidingPaneLayout
extends ViewGroup {
    private static final int DEFAULT_FADE_COLOR = -858993460;
    private static final int DEFAULT_OVERHANG_SIZE = 32;
    private static final int MIN_FLING_VELOCITY = 400;
    private static final String TAG = "SlidingPaneLayout";
    private boolean mCanSlide;
    private int mCoveredFadeColor;
    private boolean mDisplayListReflectionLoaded;
    public final ViewDragHelper mDragHelper;
    private boolean mFirstLayout;
    private Method mGetDisplayList;
    private float mInitialMotionX;
    private float mInitialMotionY;
    public boolean mIsUnableToDrag;
    private final int mOverhangSize;
    private SlidingPaneLayout$PanelSlideListener mPanelSlideListener;
    private int mParallaxBy;
    private float mParallaxOffset;
    public final ArrayList mPostedRunnables;
    public boolean mPreservedOpenState;
    private Field mRecreateDisplayList;
    private Drawable mShadowDrawableLeft;
    private Drawable mShadowDrawableRight;
    public float mSlideOffset;
    public int mSlideRange;
    public View mSlideableView;
    private int mSliderFadeColor = -858993460;
    private final Rect mTmpRect;

    public SlidingPaneLayout(Context context) {
        this(context, null);
    }

    public SlidingPaneLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SlidingPaneLayout(Context context, AttributeSet object, int n10) {
        super(context, (AttributeSet)object, n10);
        Object object2;
        int n11 = 1;
        this.mFirstLayout = n11;
        this.mTmpRect = object2 = new Rect();
        super();
        this.mPostedRunnables = object2;
        float f10 = context.getResources().getDisplayMetrics().density;
        float f11 = 32.0f * f10;
        float f12 = 0.5f;
        this.mOverhangSize = n10 = (int)(f11 + f12);
        this.setWillNotDraw(false);
        super(this);
        ViewCompat.setAccessibilityDelegate((View)this, (AccessibilityDelegateCompat)object2);
        ViewCompat.setImportantForAccessibility((View)this, n11);
        super(this);
        object = ViewDragHelper.create(this, f12, (ViewDragHelper$Callback)object);
        this.mDragHelper = object;
        ((ViewDragHelper)object).setMinVelocity(f10 *= 400.0f);
    }

    private boolean closePane(View view, int n10) {
        boolean bl2 = this.mFirstLayout;
        if (!bl2 && !(bl2 = this.smoothSlideTo(0.0f, n10))) {
            return false;
        }
        this.mPreservedOpenState = false;
        return true;
    }

    private void dimChildView(View object, float f10, int n10) {
        SlidingPaneLayout$LayoutParams slidingPaneLayout$LayoutParams = (SlidingPaneLayout$LayoutParams)object.getLayoutParams();
        PorterDuffColorFilter porterDuffColorFilter = null;
        float f11 = f10 - 0.0f;
        Object object2 = f11 == 0.0f ? 0 : (f11 > 0.0f ? 1 : -1);
        if (object2 > 0 && n10 != 0) {
            int n11 = (int)((float)((0xFF000000 & n10) >>> 24) * f10) << 24;
            object2 = 0xFFFFFF;
            n11 |= (n10 &= object2);
            Paint paint = slidingPaneLayout$LayoutParams.dimPaint;
            if (paint == null) {
                slidingPaneLayout$LayoutParams.dimPaint = paint = new Paint();
            }
            paint = slidingPaneLayout$LayoutParams.dimPaint;
            PorterDuff.Mode mode = PorterDuff.Mode.SRC_OVER;
            porterDuffColorFilter = new PorterDuffColorFilter(n11, mode);
            paint.setColorFilter((ColorFilter)porterDuffColorFilter);
            n11 = object.getLayerType();
            n10 = 2;
            if (n11 != n10) {
                Paint paint2 = slidingPaneLayout$LayoutParams.dimPaint;
                object.setLayerType(n10, paint2);
            }
            this.invalidateChildRegion((View)object);
        } else {
            int n12 = object.getLayerType();
            if (n12 != 0) {
                Object object3 = slidingPaneLayout$LayoutParams.dimPaint;
                if (object3 != null) {
                    n10 = 0;
                    Object var8_10 = null;
                    object3.setColorFilter(null);
                }
                object3 = new SlidingPaneLayout$DisableLayerRunnable(this, (View)object);
                object = this.mPostedRunnables;
                ((ArrayList)object).add(object3);
                ViewCompat.postOnAnimation((View)this, (Runnable)object3);
            }
        }
    }

    private boolean openPane(View view, int n10) {
        float f10;
        boolean bl2 = this.mFirstLayout;
        if (!bl2 && !(bl2 = this.smoothSlideTo(f10 = 1.0f, n10))) {
            return false;
        }
        this.mPreservedOpenState = bl2 = true;
        return bl2;
    }

    private void parallaxOtherViews(float f10) {
        int n10;
        boolean bl2 = this.isLayoutRtlSupport();
        SlidingPaneLayout$LayoutParams slidingPaneLayout$LayoutParams = (SlidingPaneLayout$LayoutParams)this.mSlideableView.getLayoutParams();
        int n11 = slidingPaneLayout$LayoutParams.dimWhenOffset;
        int n12 = 0;
        if (n11 != 0 && (n10 = bl2 ? slidingPaneLayout$LayoutParams.rightMargin : slidingPaneLayout$LayoutParams.leftMargin) <= 0) {
            n10 = 1;
        } else {
            n10 = 0;
            slidingPaneLayout$LayoutParams = null;
        }
        n11 = this.getChildCount();
        while (n12 < n11) {
            View view;
            View view2 = this.getChildAt(n12);
            if (view2 != (view = this.mSlideableView)) {
                float f11 = this.mParallaxOffset;
                int n13 = 1065353216;
                float f12 = 1.0f;
                f11 = f12 - f11;
                int n14 = this.mParallaxBy;
                float f13 = n14;
                int n15 = (int)(f11 *= f13);
                this.mParallaxOffset = f10;
                f13 = f12 - f10;
                float f14 = n14;
                n14 = (int)(f13 *= f14);
                n15 -= n14;
                if (bl2) {
                    n15 = -n15;
                }
                view2.offsetLeftAndRight(n15);
                if (n10 != 0) {
                    f11 = this.mParallaxOffset;
                    f11 = bl2 ? (f11 -= f12) : f12 - f11;
                    n13 = this.mCoveredFadeColor;
                    this.dimChildView(view2, f11, n13);
                }
            }
            ++n12;
        }
    }

    private static boolean viewIsOpaque(View view) {
        int n10 = view.isOpaque();
        boolean bl2 = true;
        if (n10 != 0) {
            return bl2;
        }
        n10 = Build.VERSION.SDK_INT;
        int n11 = 18;
        if (n10 >= n11) {
            return false;
        }
        if ((view = view.getBackground()) != null) {
            int n12 = view.getOpacity();
            if (n12 != (n10 = -1)) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public boolean canScroll(View view, boolean bl2, int n10, int n11, int n12) {
        int n13;
        block8: {
            block7: {
                int n14 = view instanceof ViewGroup;
                n13 = 1;
                if (n14 != 0) {
                    View view2 = view;
                    view2 = (ViewGroup)view;
                    int n15 = view.getScrollX();
                    int n16 = view.getScrollY();
                    for (int i10 = view2.getChildCount() - n13; i10 >= 0; i10 += -1) {
                        int n17;
                        int n18 = n11 + n15;
                        View view3 = view2.getChildAt(i10);
                        int n19 = view3.getLeft();
                        if (n18 < n19 || n18 >= (n19 = view3.getRight()) || (n19 = n12 + n16) < (n17 = view3.getTop()) || n19 >= (n17 = view3.getBottom())) continue;
                        int n20 = view3.getLeft();
                        n20 = n18 - n20;
                        n18 = view3.getTop();
                        int n21 = n19 - n18;
                        n19 = 1;
                        n17 = n10;
                        n18 = (int)(this.canScroll(view3, n19 != 0, n10, n20, n21) ? 1 : 0);
                        if (n18 == 0) continue;
                        return n13 != 0;
                    }
                }
                if (!bl2) break block7;
                n14 = this.isLayoutRtlSupport();
                if (n14 != 0) {
                    n14 = n10;
                } else {
                    n14 = n10;
                    n14 = -n10;
                }
                boolean bl3 = view.canScrollHorizontally(n14);
                if (bl3) break block8;
            }
            n13 = 0;
        }
        return n13 != 0;
    }

    public boolean canSlide() {
        return this.mCanSlide;
    }

    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        boolean bl2;
        boolean bl3 = layoutParams instanceof SlidingPaneLayout$LayoutParams;
        if (bl3 && (bl2 = super.checkLayoutParams(layoutParams))) {
            bl2 = true;
        } else {
            bl2 = false;
            layoutParams = null;
        }
        return bl2;
    }

    public boolean closePane() {
        View view = this.mSlideableView;
        return this.closePane(view, 0);
    }

    public void computeScroll() {
        ViewDragHelper viewDragHelper = this.mDragHelper;
        boolean bl2 = true;
        boolean bl3 = viewDragHelper.continueSettling(bl2);
        if (bl3) {
            bl3 = this.mCanSlide;
            if (!bl3) {
                this.mDragHelper.abort();
                return;
            }
            ViewCompat.postInvalidateOnAnimation((View)this);
        }
    }

    public void dispatchOnPanelClosed(View view) {
        SlidingPaneLayout$PanelSlideListener slidingPaneLayout$PanelSlideListener = this.mPanelSlideListener;
        if (slidingPaneLayout$PanelSlideListener != null) {
            slidingPaneLayout$PanelSlideListener.onPanelClosed(view);
        }
        this.sendAccessibilityEvent(32);
    }

    public void dispatchOnPanelOpened(View view) {
        SlidingPaneLayout$PanelSlideListener slidingPaneLayout$PanelSlideListener = this.mPanelSlideListener;
        if (slidingPaneLayout$PanelSlideListener != null) {
            slidingPaneLayout$PanelSlideListener.onPanelOpened(view);
        }
        this.sendAccessibilityEvent(32);
    }

    public void dispatchOnPanelSlide(View view) {
        SlidingPaneLayout$PanelSlideListener slidingPaneLayout$PanelSlideListener = this.mPanelSlideListener;
        if (slidingPaneLayout$PanelSlideListener != null) {
            float f10 = this.mSlideOffset;
            slidingPaneLayout$PanelSlideListener.onPanelSlide(view, f10);
        }
    }

    public void draw(Canvas canvas) {
        View view;
        super.draw(canvas);
        boolean bl2 = this.isLayoutRtlSupport();
        Drawable drawable2 = bl2 ? this.mShadowDrawableRight : this.mShadowDrawableLeft;
        int n10 = this.getChildCount();
        int n11 = 1;
        if (n10 > n11) {
            view = this.getChildAt(n11);
        } else {
            n10 = 0;
            view = null;
        }
        if (view != null && drawable2 != null) {
            n11 = view.getTop();
            int n12 = view.getBottom();
            int n13 = drawable2.getIntrinsicWidth();
            boolean bl3 = this.isLayoutRtlSupport();
            if (bl3) {
                n10 = view.getRight();
                n13 += n10;
            } else {
                n10 = view.getLeft();
                int n14 = n10 - n13;
                n13 = n10;
                n10 = n14;
            }
            drawable2.setBounds(n10, n11, n13, n12);
            drawable2.draw(canvas);
        }
    }

    public boolean drawChild(Canvas canvas, View view, long l10) {
        boolean bl2;
        SlidingPaneLayout$LayoutParams slidingPaneLayout$LayoutParams = (SlidingPaneLayout$LayoutParams)view.getLayoutParams();
        int n10 = canvas.save();
        int n11 = this.mCanSlide;
        if (n11 != 0 && !(bl2 = slidingPaneLayout$LayoutParams.slideable) && (slidingPaneLayout$LayoutParams = this.mSlideableView) != null) {
            slidingPaneLayout$LayoutParams = this.mTmpRect;
            canvas.getClipBounds((Rect)slidingPaneLayout$LayoutParams);
            bl2 = this.isLayoutRtlSupport();
            if (bl2) {
                slidingPaneLayout$LayoutParams = this.mTmpRect;
                n11 = ((Rect)slidingPaneLayout$LayoutParams).left;
                View view2 = this.mSlideableView;
                int n12 = view2.getRight();
                ((Rect)slidingPaneLayout$LayoutParams).left = n11 = Math.max(n11, n12);
            } else {
                slidingPaneLayout$LayoutParams = this.mTmpRect;
                n11 = ((Rect)slidingPaneLayout$LayoutParams).right;
                View view3 = this.mSlideableView;
                int n13 = view3.getLeft();
                ((Rect)slidingPaneLayout$LayoutParams).right = n11 = Math.min(n11, n13);
            }
            slidingPaneLayout$LayoutParams = this.mTmpRect;
            canvas.clipRect((Rect)slidingPaneLayout$LayoutParams);
        }
        boolean bl3 = super.drawChild(canvas, view, l10);
        canvas.restoreToCount(n10);
        return bl3;
    }

    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        SlidingPaneLayout$LayoutParams slidingPaneLayout$LayoutParams = new SlidingPaneLayout$LayoutParams();
        return slidingPaneLayout$LayoutParams;
    }

    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        Context context = this.getContext();
        SlidingPaneLayout$LayoutParams slidingPaneLayout$LayoutParams = new SlidingPaneLayout$LayoutParams(context, attributeSet);
        return slidingPaneLayout$LayoutParams;
    }

    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        SlidingPaneLayout$LayoutParams slidingPaneLayout$LayoutParams;
        boolean bl2 = layoutParams instanceof ViewGroup.MarginLayoutParams;
        if (bl2) {
            layoutParams = (ViewGroup.MarginLayoutParams)layoutParams;
            slidingPaneLayout$LayoutParams = new SlidingPaneLayout$LayoutParams((ViewGroup.MarginLayoutParams)layoutParams);
        } else {
            slidingPaneLayout$LayoutParams = new SlidingPaneLayout$LayoutParams(layoutParams);
        }
        return slidingPaneLayout$LayoutParams;
    }

    public int getCoveredFadeColor() {
        return this.mCoveredFadeColor;
    }

    public int getParallaxDistance() {
        return this.mParallaxBy;
    }

    public int getSliderFadeColor() {
        return this.mSliderFadeColor;
    }

    public void invalidateChildRegion(View view) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 17;
        if (n10 >= n11) {
            Paint paint = ((SlidingPaneLayout$LayoutParams)view.getLayoutParams()).dimPaint;
            ViewCompat.setLayerPaint(view, paint);
            return;
        }
        n11 = 16;
        if (n10 >= n11) {
            Object object;
            n10 = (int)(this.mDisplayListReflectionLoaded ? 1 : 0);
            n11 = 0;
            String string2 = null;
            boolean bl2 = true;
            String string3 = TAG;
            if (n10 == 0) {
                object = View.class;
                String string4 = "getDisplayList";
                object = ((Class)object).getDeclaredMethod(string4, null);
                try {
                    this.mGetDisplayList = object;
                }
                catch (NoSuchMethodException noSuchMethodException) {
                    string4 = "Couldn't fetch getDisplayList method; dimming won't work right.";
                    Log.e((String)string3, (String)string4, (Throwable)noSuchMethodException);
                }
                object = View.class;
                string4 = "mRecreateDisplayList";
                object = ((Class)object).getDeclaredField(string4);
                this.mRecreateDisplayList = object;
                try {
                    ((Field)object).setAccessible(bl2);
                }
                catch (NoSuchFieldException noSuchFieldException) {
                    string4 = "Couldn't fetch mRecreateDisplayList field; dimming will be slow.";
                    Log.e((String)string3, (String)string4, (Throwable)noSuchFieldException);
                }
                this.mDisplayListReflectionLoaded = bl2;
            }
            if ((object = this.mGetDisplayList) != null && (object = this.mRecreateDisplayList) != null) {
                ((Field)object).setBoolean(view, bl2);
                object = this.mGetDisplayList;
                try {
                    ((Method)object).invoke(view, null);
                }
                catch (Exception exception) {
                    string2 = "Error refreshing display list state";
                    Log.e((String)string3, (String)string2, (Throwable)exception);
                }
            } else {
                view.invalidate();
                return;
            }
        }
        n10 = view.getLeft();
        n11 = view.getTop();
        int n12 = view.getRight();
        int n13 = view.getBottom();
        ViewCompat.postInvalidateOnAnimation((View)this, n10, n11, n12, n13);
    }

    public boolean isDimmed(View object) {
        Object object2;
        boolean bl2 = false;
        if (object == null) {
            return false;
        }
        object = (SlidingPaneLayout$LayoutParams)object.getLayoutParams();
        boolean bl3 = this.mCanSlide;
        if (bl3 && (object2 = object.dimWhenOffset) != 0) {
            float f10 = this.mSlideOffset;
            bl3 = false;
            float f11 = f10 - 0.0f;
            object2 = f11 == 0.0f ? 0 : (f11 > 0.0f ? 1 : -1);
            if (object2 > 0) {
                bl2 = true;
            }
        }
        return bl2;
    }

    public boolean isLayoutRtlSupport() {
        int n10;
        int n11 = ViewCompat.getLayoutDirection((View)this);
        if (n11 != (n10 = 1)) {
            n10 = 0;
        }
        return n10 != 0;
    }

    public boolean isOpen() {
        float f10;
        float f11;
        float f12;
        boolean bl2 = this.mCanSlide;
        if (bl2 && (bl2 = (f12 = (f11 = this.mSlideOffset) - (f10 = 1.0f)) == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1))) {
            bl2 = false;
            f11 = 0.0f;
        } else {
            bl2 = true;
            f11 = Float.MIN_VALUE;
        }
        return bl2;
    }

    public boolean isSlideable() {
        return this.mCanSlide;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mFirstLayout = true;
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mFirstLayout = true;
        ArrayList arrayList = this.mPostedRunnables;
        int n10 = arrayList.size();
        for (int i10 = 0; i10 < n10; ++i10) {
            SlidingPaneLayout$DisableLayerRunnable slidingPaneLayout$DisableLayerRunnable = (SlidingPaneLayout$DisableLayerRunnable)this.mPostedRunnables.get(i10);
            slidingPaneLayout$DisableLayerRunnable.run();
        }
        this.mPostedRunnables.clear();
    }

    /*
     * Unable to fully structure code
     */
    public boolean onInterceptTouchEvent(MotionEvent var1_1) {
        block6: {
            block7: {
                block8: {
                    var2_2 = var1_1.getActionMasked();
                    var3_3 = this.mCanSlide;
                    var4_4 = 1;
                    var5_5 = 1.4E-45f;
                    if (var3_3 == 0 && var2_2 == 0 && (var3_3 = this.getChildCount()) > var4_4 && (var6_6 = this.getChildAt(var4_4)) != null) {
                        var7_7 = this.mDragHelper;
                        var8_8 = var1_1.getX();
                        var9_9 = (int)var8_8;
                        var10_10 = var1_1.getY();
                        var11_11 = (int)var10_10;
                        var3_3 = var7_7.isViewUnder((View)var6_6, var9_9, var11_11) ^ var4_4;
                        this.mPreservedOpenState = var3_3;
                    }
                    if ((var3_3 = this.mCanSlide) == 0 || (var3_3 = (int)this.mIsUnableToDrag) != 0 && var2_2 != 0) break block6;
                    var3_3 = 3;
                    var12_12 = 4.2E-45f;
                    var7_7 = null;
                    if (var2_2 == var3_3 || var2_2 == var4_4) break block7;
                    if (var2_2 == 0) break block8;
                    var3_3 = 2;
                    var12_12 = 2.8E-45f;
                    if (var2_2 == var3_3) {
                        var13_13 = var1_1.getX();
                        var12_12 = var1_1.getY();
                        var8_8 = this.mInitialMotionX;
                        var13_13 = Math.abs(var13_13 - var8_8);
                        var8_8 = this.mInitialMotionY;
                        var12_12 = Math.abs(var12_12 - var8_8);
                        var14_14 = this.mDragHelper;
                        var8_8 = var14_14.getTouchSlop();
                        cfr_temp_0 = var13_13 - var8_8;
                        var9_9 = (int)(cfr_temp_0 == 0.0f ? 0 : (cfr_temp_0 > 0.0f ? 1 : -1));
                        if (var9_9 > 0 && (var2_2 = (int)(var12_12 == var13_13 ? 0 : (var12_12 > var13_13 ? 1 : -1))) > 0) {
                            this.mDragHelper.cancel();
                            this.mIsUnableToDrag = var4_4;
                            return false;
                        }
                    }
                    ** GOTO lbl-1000
                }
                this.mIsUnableToDrag = false;
                var13_13 = var1_1.getX();
                var12_12 = var1_1.getY();
                this.mInitialMotionX = var13_13;
                this.mInitialMotionY = var12_12;
                var14_15 = this.mDragHelper;
                var15_16 = this.mSlideableView;
                var2_2 = (int)var13_13;
                var3_3 = (int)var12_12;
                if ((var2_2 = (int)var14_15.isViewUnder(var15_16, var2_2, var3_3)) != 0 && (var2_2 = (int)this.isDimmed(var16_17 = this.mSlideableView)) != 0) {
                    var2_2 = var4_4;
                    var13_13 = var5_5;
                } else lbl-1000:
                // 2 sources

                {
                    var2_2 = 0;
                    var16_17 = null;
                    var13_13 = 0.0f;
                }
                var6_6 = this.mDragHelper;
                var17_18 = var6_6.shouldInterceptTouchEvent(var1_1);
                if (!var17_18 && var2_2 == 0) {
                    var4_4 = 0;
                    var5_5 = 0.0f;
                }
                return (boolean)var4_4;
            }
            this.mDragHelper.cancel();
            return false;
        }
        this.mDragHelper.cancel();
        return super.onInterceptTouchEvent(var1_1);
    }

    public void onLayout(boolean bl2, int n10, int n11, int n12, int n13) {
        View view;
        float f10;
        int n14;
        ViewDragHelper viewDragHelper;
        SlidingPaneLayout slidingPaneLayout = this;
        int n15 = this.isLayoutRtlSupport();
        int n16 = 1;
        float f11 = Float.MIN_VALUE;
        if (n15 != 0) {
            viewDragHelper = this.mDragHelper;
            n14 = 2;
            viewDragHelper.setEdgeTrackingEnabled(n14);
        } else {
            viewDragHelper = this.mDragHelper;
            viewDragHelper.setEdgeTrackingEnabled(n16);
        }
        int n17 = n12 - n10;
        n14 = n15 != 0 ? this.getPaddingRight() : this.getPaddingLeft();
        int n18 = n15 != 0 ? this.getPaddingLeft() : this.getPaddingRight();
        int n19 = this.getPaddingTop();
        int n20 = this.getChildCount();
        int n21 = slidingPaneLayout.mFirstLayout;
        if (n21 != 0) {
            n21 = slidingPaneLayout.mCanSlide;
            if (n21 != 0 && (n21 = slidingPaneLayout.mPreservedOpenState) != 0) {
                n21 = 1065353216;
                f10 = 1.0f;
            } else {
                n21 = 0;
                f10 = 0.0f;
            }
            slidingPaneLayout.mSlideOffset = f10;
        }
        int n22 = n14;
        for (int i10 = 0; i10 < n20; ++i10) {
            float f12;
            int n23;
            int n24;
            View view2 = slidingPaneLayout.getChildAt(i10);
            int n25 = view2.getVisibility();
            if (n25 == (n24 = 8)) {
                n23 = 1065353216;
                f12 = 1.0f;
            } else {
                int n26;
                SlidingPaneLayout$LayoutParams slidingPaneLayout$LayoutParams = (SlidingPaneLayout$LayoutParams)view2.getLayoutParams();
                n24 = view2.getMeasuredWidth();
                n16 = (int)(slidingPaneLayout$LayoutParams.slideable ? 1 : 0);
                if (n16 != 0) {
                    int n27;
                    n16 = slidingPaneLayout$LayoutParams.leftMargin;
                    n21 = slidingPaneLayout$LayoutParams.rightMargin;
                    n16 += n21;
                    n21 = n17 - n18;
                    n26 = slidingPaneLayout.mOverhangSize;
                    n26 = n21 - n26;
                    slidingPaneLayout.mSlideRange = n26 = Math.min(n14, n26) - n22 - n16;
                    n16 = n15 != 0 ? slidingPaneLayout$LayoutParams.rightMargin : slidingPaneLayout$LayoutParams.leftMargin;
                    int n28 = n22 + n16 + n26;
                    n23 = n28 + (n27 = n24 / 2);
                    if (n23 > n21) {
                        n21 = 1;
                        f10 = Float.MIN_VALUE;
                    } else {
                        n21 = 0;
                        f10 = 0.0f;
                    }
                    slidingPaneLayout$LayoutParams.dimWhenOffset = n21;
                    f10 = n26;
                    f12 = slidingPaneLayout.mSlideOffset;
                    n21 = (int)(f10 * f12);
                    n22 += (n16 += n21);
                    f11 = n21;
                    f10 = n26;
                    slidingPaneLayout.mSlideOffset = f11 /= f10;
                    n16 = 0;
                    f11 = 0.0f;
                    view = null;
                    n23 = 1065353216;
                    f12 = 1.0f;
                } else {
                    n16 = (int)(slidingPaneLayout.mCanSlide ? 1 : 0);
                    if (n16 != 0 && (n16 = slidingPaneLayout.mParallaxBy) != 0) {
                        f10 = slidingPaneLayout.mSlideOffset;
                        n23 = 1065353216;
                        f12 = 1.0f;
                        f10 = f12 - f10;
                        f11 = n16;
                        n16 = (int)(f10 *= f11);
                        n22 = n14;
                    } else {
                        n23 = 1065353216;
                        f12 = 1.0f;
                        n22 = n14;
                        n16 = 0;
                        f11 = 0.0f;
                        view = null;
                    }
                }
                if (n15 != 0) {
                    n21 = n17 - n22 + n16;
                    n16 = n21 - n24;
                } else {
                    n16 = n22 - n16;
                    n21 = n16 + n24;
                }
                n26 = view2.getMeasuredHeight() + n19;
                view2.layout(n16, n19, n21, n26);
                n16 = view2.getWidth();
                n14 += n16;
            }
            n16 = 1;
            f11 = Float.MIN_VALUE;
        }
        n15 = slidingPaneLayout.mFirstLayout;
        if (n15 != 0) {
            SlidingPaneLayout$LayoutParams slidingPaneLayout$LayoutParams;
            n15 = slidingPaneLayout.mCanSlide;
            if (n15 != 0) {
                n15 = slidingPaneLayout.mParallaxBy;
                if (n15 != 0) {
                    float f13 = slidingPaneLayout.mSlideOffset;
                    slidingPaneLayout.parallaxOtherViews(f13);
                }
                slidingPaneLayout$LayoutParams = (SlidingPaneLayout$LayoutParams)slidingPaneLayout.mSlideableView.getLayoutParams();
                n15 = (int)(slidingPaneLayout$LayoutParams.dimWhenOffset ? 1 : 0);
                if (n15 != 0) {
                    slidingPaneLayout$LayoutParams = slidingPaneLayout.mSlideableView;
                    f11 = slidingPaneLayout.mSlideOffset;
                    n17 = slidingPaneLayout.mSliderFadeColor;
                    slidingPaneLayout.dimChildView((View)slidingPaneLayout$LayoutParams, f11, n17);
                }
            } else {
                float f14 = 0.0f;
                slidingPaneLayout$LayoutParams = null;
                for (n15 = 0; n15 < n20; ++n15) {
                    view = slidingPaneLayout.getChildAt(n15);
                    n17 = slidingPaneLayout.mSliderFadeColor;
                    n14 = 0;
                    slidingPaneLayout.dimChildView(view, 0.0f, n17);
                }
            }
            slidingPaneLayout$LayoutParams = slidingPaneLayout.mSlideableView;
            slidingPaneLayout.updateObscuredViewsVisibility((View)slidingPaneLayout$LayoutParams);
        }
        slidingPaneLayout.mFirstLayout = false;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public void onMeasure(int var1_1, int var2_2) {
        block55: {
            block54: {
                var3_3 = this;
                var4_4 = View.MeasureSpec.getMode((int)var1_1);
                var5_5 = View.MeasureSpec.getSize((int)var1_1);
                var6_6 = View.MeasureSpec.getMode((int)var2_2);
                var7_7 = View.MeasureSpec.getSize((int)var2_2);
                var8_8 = 300;
                var9_9 = -1 << -1;
                var10_10 = 0x40000000;
                var11_11 = 2.0f;
                if (var4_4 == var10_10) ** GOTO lbl18
                var12_12 = this.isInEditMode();
                if (var12_12 != 0) {
                    if (var4_4 != var9_9 && var4_4 == 0) {
                        var5_5 = var8_8;
                    }
                } else {
                    var13_13 = new IllegalStateException("Width must have an exact value or MATCH_PARENT");
                    throw var13_13;
lbl18:
                    // 1 sources

                    if (var6_6 == 0) {
                        var4_4 = (int)this.isInEditMode();
                        if (var4_4 != 0) {
                            if (var6_6 == 0) {
                                var7_7 = var8_8;
                                var6_6 = var9_9;
                            }
                        } else {
                            var13_14 = new IllegalStateException("Height must not be UNSPECIFIED");
                            throw var13_14;
                        }
                    }
                }
                var4_4 = 0;
                var13_15 = null;
                if (var6_6 == var9_9) ** GOTO lbl40
                if (var6_6 != var10_10) {
                    var7_7 = 0;
lbl32:
                    // 2 sources

                    while (true) {
                        var8_8 = var7_7;
                        break;
                    }
                } else {
                    var8_8 = this.getPaddingTop();
                    var7_7 -= var8_8;
                    var8_8 = this.getPaddingBottom();
                    var7_7 -= var8_8;
                    ** continue;
lbl40:
                    // 1 sources

                    var8_8 = this.getPaddingTop();
                    var7_7 -= var8_8;
                    var8_8 = this.getPaddingBottom();
                    var8_8 = var7_7 - var8_8;
                    var7_7 = 0;
                }
                var12_12 = this.getPaddingLeft();
                var12_12 = var5_5 - var12_12;
                var14_16 = this.getPaddingRight();
                var12_12 -= var14_16;
                var14_16 = this.getChildCount();
                var15_17 = 2;
                var16_18 = 2.8E-45f;
                if (var14_16 > var15_17) {
                    var17_19 = "SlidingPaneLayout";
                    var18_20 = "onMeasure: More than two child views are not supported.";
                    Log.e((String)var17_19, (String)var18_20);
                }
                var15_17 = 0;
                var16_18 = 0.0f;
                var17_19 = null;
                var3_3.mSlideableView = null;
                var19_21 = 0;
                var18_20 = null;
                var20_22 = 0.0f;
                var21_23 = 0;
                var22_24 = var12_12;
                var23_25 = 0;
                var24_26 = 0.0f;
                while (true) {
                    block52: {
                        block53: {
                            block51: {
                                var25_27 = 8;
                                var26_28 = 1.1E-44f;
                                var27_29 = 1;
                                var28_30 = 1.4E-45f;
                                if (var19_21 >= var14_16) break;
                                var29_31 = var3_3.getChildAt(var19_21);
                                var31_33 /* !! */  = var30_32 = var29_31.getLayoutParams();
                                var31_33 /* !! */  = (SlidingPaneLayout$LayoutParams)var30_32;
                                var15_17 = var29_31.getVisibility();
                                if (var15_17 != var25_27) break block51;
                                var31_33 /* !! */ .dimWhenOffset = false;
                                break block52;
                            }
                            var16_18 = var31_33 /* !! */ .weight;
                            var25_27 = 0;
                            var26_28 = 0.0f;
                            var32_34 = null;
                            cfr_temp_0 = var16_18 - 0.0f;
                            var33_35 /* !! */  = (float)(cfr_temp_0 == 0.0f ? 0 : (cfr_temp_0 > 0.0f ? 1 : -1));
                            if (var33_35 /* !! */  <= 0) break block53;
                            var24_26 += var16_18;
                            var15_17 = var31_33 /* !! */ .width;
                            if (var15_17 == 0) break block52;
                        }
                        var15_17 = var31_33 /* !! */ .leftMargin;
                        var25_27 = var31_33 /* !! */ .rightMargin;
                        var15_17 += var25_27;
                        var25_27 = var31_33 /* !! */ .width;
                        var4_4 = -2;
                        if (var25_27 == var4_4) {
                            var15_17 = var12_12 - var15_17;
                            var25_27 = -1 << -1;
                            var26_28 = -0.0f;
                            var15_17 = View.MeasureSpec.makeMeasureSpec((int)var15_17, (int)var25_27);
                            var34_36 = var24_26;
                            var23_25 = var25_27;
                            var24_26 = var26_28;
                            var4_4 = -1;
lbl107:
                            // 2 sources

                            while (true) {
                                var25_27 = var15_17;
                                break;
                            }
                        } else {
                            var34_36 = var24_26;
                            var4_4 = -1;
                            var23_25 = -1 << -1;
                            var24_26 = -0.0f;
                            if (var25_27 == var4_4) {
                                var15_17 = var12_12 - var15_17;
                                var25_27 = 0x40000000;
                                var26_28 = 2.0f;
                                var15_17 = View.MeasureSpec.makeMeasureSpec((int)var15_17, (int)var25_27);
                                ** continue;
                            }
                            var15_17 = 0x40000000;
                            var16_18 = 2.0f;
                            var25_27 = View.MeasureSpec.makeMeasureSpec((int)var25_27, (int)var15_17);
                        }
                        var15_17 = var31_33 /* !! */ .height;
                        var4_4 = -2;
                        if (var15_17 == var4_4) {
                            var4_4 = View.MeasureSpec.makeMeasureSpec((int)var8_8, (int)var23_25);
                        } else {
                            var4_4 = -1;
                            if (var15_17 == var4_4) {
                                var4_4 = 0x40000000;
                                var15_17 = View.MeasureSpec.makeMeasureSpec((int)var8_8, (int)var4_4);
                            } else {
                                var4_4 = 0x40000000;
                                var15_17 = View.MeasureSpec.makeMeasureSpec((int)var15_17, (int)var4_4);
                            }
                            var4_4 = var15_17;
                        }
                        var29_31.measure(var25_27, var4_4);
                        var4_4 = var29_31.getMeasuredWidth();
                        var15_17 = var29_31.getMeasuredHeight();
                        if (var6_6 == var23_25 && var15_17 > var7_7) {
                            var7_7 = Math.min(var15_17, var8_8);
                        }
                        if ((var22_24 -= var4_4) < 0) {
                            var4_4 = var27_29;
                        } else {
                            var4_4 = 0;
                            var13_15 = null;
                        }
                        var31_33 /* !! */ .slideable = var4_4;
                        var21_23 |= var4_4;
                        if (var4_4 != 0) {
                            var3_3.mSlideableView = var29_31;
                        }
                        var24_26 = var34_36;
                    }
                    ++var19_21;
                    var4_4 = 0;
                    var13_15 = null;
                    var9_9 = -1 << -1;
                    var10_10 = 0x40000000;
                    var11_11 = 2.0f;
                }
                if (var21_23 != 0) break block54;
                var4_4 = 0;
                var13_15 = null;
                cfr_temp_1 = var24_26 - 0.0f;
                var6_6 = (int)(cfr_temp_1 == 0.0f ? 0 : (cfr_temp_1 > 0.0f ? 1 : -1));
                if (var6_6 <= 0) break block55;
            }
            var4_4 = var3_3.mOverhangSize;
            var4_4 = var12_12 - var4_4;
            for (var6_6 = 0; var6_6 < var14_16; ++var6_6) {
                block50: {
                    block58: {
                        block56: {
                            block57: {
                                var29_31 = var3_3.getChildAt(var6_6);
                                var10_10 = var29_31.getVisibility();
                                if (var10_10 == var25_27) lbl-1000:
                                // 6 sources

                                {
                                    while (true) {
                                        var35_37 = var4_4;
lbl174:
                                        // 3 sources

                                        while (true) {
                                            var4_4 = 0;
                                            var13_15 = null;
                                            var10_10 = 0x40000000;
                                            var11_11 = 2.0f;
                                            break block50;
                                            break;
                                        }
                                        break;
                                    }
                                }
                                var31_33 /* !! */  = (SlidingPaneLayout$LayoutParams)var29_31.getLayoutParams();
                                var15_17 = var29_31.getVisibility();
                                if (var15_17 == var25_27) ** GOTO lbl-1000
                                var15_17 = var31_33 /* !! */ .width;
                                if (var15_17 != 0) ** GOTO lbl-1000
                                var16_18 = var31_33 /* !! */ .weight;
                                var19_21 = 0;
                                var20_22 = 0.0f;
                                var18_20 = null;
                                cfr_temp_2 = var16_18 - 0.0f;
                                var15_17 = (int)(cfr_temp_2 == 0.0f ? 0 : (cfr_temp_2 > 0.0f ? 1 : -1));
                                if (var15_17 > 0) {
                                    var15_17 = var27_29;
                                    var16_18 = var28_30;
                                } else lbl-1000:
                                // 2 sources

                                {
                                    var15_17 = 0;
                                    var16_18 = 0.0f;
                                    var17_19 = null;
                                }
                                if (var15_17 != 0) {
                                    var19_21 = 0;
                                    var20_22 = 0.0f;
                                    var18_20 = null;
                                } else {
                                    var19_21 = var29_31.getMeasuredWidth();
                                }
                                if (var21_23 == 0 || var29_31 == (var32_34 = var3_3.mSlideableView)) break block56;
                                var25_27 = var31_33 /* !! */ .width;
                                if (var25_27 >= 0) ** GOTO lbl-1000
                                if (var19_21 > var4_4) break block57;
                                var20_22 = var31_33 /* !! */ .weight;
                                var25_27 = 0;
                                var26_28 = 0.0f;
                                var32_34 = null;
                                cfr_temp_3 = var20_22 - 0.0f;
                                var19_21 = (int)(cfr_temp_3 == 0.0f ? 0 : (cfr_temp_3 > 0.0f ? 1 : -1));
                                if (var19_21 <= 0) ** GOTO lbl-1000
                            }
                            if (var15_17 != 0) {
                                var10_10 = var31_33 /* !! */ .height;
                                var15_17 = -2;
                                var16_18 = 0.0f / 0.0f;
                                if (var10_10 == var15_17) {
                                    var10_10 = View.MeasureSpec.makeMeasureSpec((int)var8_8, (int)(-1 << -1));
                                    var15_17 = 0x40000000;
                                    var16_18 = 2.0f;
                                } else {
                                    var15_17 = -1;
                                    var16_18 = 0.0f / 0.0f;
                                    if (var10_10 == var15_17) {
                                        var15_17 = 0x40000000;
                                        var16_18 = 2.0f;
                                        var10_10 = View.MeasureSpec.makeMeasureSpec((int)var8_8, (int)var15_17);
                                    } else {
                                        var15_17 = 0x40000000;
                                        var16_18 = 2.0f;
                                        var10_10 = View.MeasureSpec.makeMeasureSpec((int)var10_10, (int)var15_17);
                                    }
                                }
                            } else {
                                var15_17 = 0x40000000;
                                var16_18 = 2.0f;
                                var10_10 = View.MeasureSpec.makeMeasureSpec((int)var29_31.getMeasuredHeight(), (int)var15_17);
                            }
                            var19_21 = View.MeasureSpec.makeMeasureSpec((int)var4_4, (int)var15_17);
                            var29_31.measure(var19_21, var10_10);
                            ** GOTO lbl-1000
                        }
                        var16_18 = var31_33 /* !! */ .weight;
                        var25_27 = 0;
                        var26_28 = 0.0f;
                        var32_34 = null;
                        cfr_temp_4 = var16_18 - 0.0f;
                        var15_17 = (int)(cfr_temp_4 == 0.0f ? 0 : (cfr_temp_4 > 0.0f ? 1 : -1));
                        if (var15_17 > 0) ** break;
                        ** continue;
                        var15_17 = var31_33 /* !! */ .width;
                        if (var15_17 == 0) {
                            var15_17 = var31_33 /* !! */ .height;
                            var25_27 = -2;
                            var26_28 = 0.0f / 0.0f;
                            if (var15_17 == var25_27) {
                                var15_17 = View.MeasureSpec.makeMeasureSpec((int)var8_8, (int)(-1 << -1));
                                var25_27 = 0x40000000;
                                var26_28 = 2.0f;
                            } else {
                                var25_27 = -1;
                                var26_28 = 0.0f / 0.0f;
                                if (var15_17 == var25_27) {
                                    var25_27 = 0x40000000;
                                    var26_28 = 2.0f;
                                    var15_17 = View.MeasureSpec.makeMeasureSpec((int)var8_8, (int)var25_27);
                                } else {
                                    var25_27 = 0x40000000;
                                    var26_28 = 2.0f;
                                    var15_17 = View.MeasureSpec.makeMeasureSpec((int)var15_17, (int)var25_27);
                                }
                            }
                        } else {
                            var25_27 = 0x40000000;
                            var26_28 = 2.0f;
                            var15_17 = View.MeasureSpec.makeMeasureSpec((int)var29_31.getMeasuredHeight(), (int)var25_27);
                        }
                        if (var21_23 == 0) break block58;
                        var25_27 = var31_33 /* !! */ .leftMargin;
                        var10_10 = var31_33 /* !! */ .rightMargin;
                        var25_27 += var10_10;
                        var10_10 = var12_12 - var25_27;
                        var35_37 = var4_4;
                        var25_27 = 0x40000000;
                        var26_28 = 2.0f;
                        var4_4 = View.MeasureSpec.makeMeasureSpec((int)var10_10, (int)var25_27);
                        if (var19_21 == var10_10) ** GOTO lbl174
                        var29_31.measure(var4_4, var15_17);
                        ** continue;
                    }
                    var35_37 = var4_4;
                    var4_4 = 0;
                    var13_15 = null;
                    var25_27 = Math.max(0, var22_24);
                    var11_11 = var31_33 /* !! */ .weight;
                    var26_28 = var25_27;
                    var10_10 = (int)(var11_11 * var26_28 / var24_26);
                    var19_21 += var10_10;
                    var10_10 = 0x40000000;
                    var11_11 = 2.0f;
                    var19_21 = View.MeasureSpec.makeMeasureSpec((int)var19_21, (int)var10_10);
                    var29_31.measure(var19_21, var15_17);
                }
                var4_4 = var35_37;
                var25_27 = 8;
                var26_28 = 1.1E-44f;
            }
        }
        var4_4 = this.getPaddingTop();
        var7_7 += var4_4;
        var4_4 = this.getPaddingBottom();
        var3_3.setMeasuredDimension(var5_5, var7_7 += var4_4);
        var3_3.mCanSlide = var21_23;
        var13_15 = var3_3.mDragHelper;
        var4_4 = var13_15.getViewDragState();
        if (var4_4 != 0 && var21_23 == 0) {
            var13_15 = var3_3.mDragHelper;
            var13_15.abort();
        }
    }

    public void onPanelDragged(int n10) {
        View view;
        View view2 = this.mSlideableView;
        if (view2 == null) {
            this.mSlideOffset = 0.0f;
            return;
        }
        int n11 = this.isLayoutRtlSupport();
        SlidingPaneLayout$LayoutParams slidingPaneLayout$LayoutParams = (SlidingPaneLayout$LayoutParams)this.mSlideableView.getLayoutParams();
        View view3 = this.mSlideableView;
        int n12 = view3.getWidth();
        if (n11 != 0) {
            int n13 = this.getWidth() - n10;
            n10 = n13 - n12;
        }
        n12 = n11 != 0 ? this.getPaddingRight() : this.getPaddingLeft();
        n11 = n11 != 0 ? slidingPaneLayout$LayoutParams.rightMargin : slidingPaneLayout$LayoutParams.leftMargin;
        float f10 = n10 -= (n12 += n11);
        float f11 = this.mSlideRange;
        this.mSlideOffset = f10 /= f11;
        n11 = this.mParallaxBy;
        if (n11 != 0) {
            this.parallaxOtherViews(f10);
        }
        if ((n10 = (int)(slidingPaneLayout$LayoutParams.dimWhenOffset ? 1 : 0)) != 0) {
            view = this.mSlideableView;
            f11 = this.mSlideOffset;
            int n14 = this.mSliderFadeColor;
            this.dimChildView(view, f11, n14);
        }
        view = this.mSlideableView;
        this.dispatchOnPanelSlide(view);
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        boolean bl2;
        boolean bl3 = parcelable instanceof SlidingPaneLayout$SavedState;
        if (!bl3) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        parcelable = (SlidingPaneLayout$SavedState)parcelable;
        Parcelable parcelable2 = parcelable.getSuperState();
        super.onRestoreInstanceState(parcelable2);
        bl3 = parcelable.isOpen;
        if (bl3) {
            this.openPane();
        } else {
            this.closePane();
        }
        this.mPreservedOpenState = bl2 = parcelable.isOpen;
    }

    public Parcelable onSaveInstanceState() {
        Parcelable parcelable = super.onSaveInstanceState();
        SlidingPaneLayout$SavedState slidingPaneLayout$SavedState = new SlidingPaneLayout$SavedState(parcelable);
        boolean bl2 = this.isSlideable();
        bl2 = bl2 ? this.isOpen() : this.mPreservedOpenState;
        slidingPaneLayout$SavedState.isOpen = bl2;
        return slidingPaneLayout$SavedState;
    }

    public void onSizeChanged(int n10, int n11, int n12, int n13) {
        super.onSizeChanged(n10, n11, n12, n13);
        if (n10 != n12) {
            n10 = 1;
            this.mFirstLayout = n10;
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int n10 = this.mCanSlide;
        if (n10 == 0) {
            return super.onTouchEvent(motionEvent);
        }
        ViewDragHelper viewDragHelper = this.mDragHelper;
        viewDragHelper.processTouchEvent(motionEvent);
        n10 = motionEvent.getActionMasked();
        int n11 = 1;
        if (n10 != 0) {
            if (n10 == n11 && (n10 = this.isDimmed((View)(viewDragHelper = this.mSlideableView))) != 0) {
                float f10;
                float f11;
                float f12 = motionEvent.getX();
                float f13 = motionEvent.getY();
                float f14 = this.mInitialMotionX;
                f14 = f12 - f14;
                float f15 = this.mInitialMotionY;
                f15 = f13 - f15;
                ViewDragHelper viewDragHelper2 = this.mDragHelper;
                int n12 = viewDragHelper2.getTouchSlop();
                f14 *= f14;
                f15 *= f15;
                if ((f11 = (f10 = (f14 += f15) - (f15 = (float)(n12 *= n12))) == 0.0f ? 0 : (f10 < 0.0f ? -1 : 1)) < 0) {
                    ViewDragHelper viewDragHelper3 = this.mDragHelper;
                    View view = this.mSlideableView;
                    n10 = (int)f12;
                    int n13 = (int)f13;
                    if ((n13 = (int)(viewDragHelper3.isViewUnder(view, n10, n13) ? 1 : 0)) != 0) {
                        motionEvent = this.mSlideableView;
                        n10 = 0;
                        f12 = 0.0f;
                        viewDragHelper = null;
                        this.closePane((View)motionEvent, 0);
                    }
                }
            }
        } else {
            float f16 = motionEvent.getX();
            float f17 = motionEvent.getY();
            this.mInitialMotionX = f16;
            this.mInitialMotionY = f17;
        }
        return n11 != 0;
    }

    public boolean openPane() {
        View view = this.mSlideableView;
        return this.openPane(view, 0);
    }

    public void requestChildFocus(View view, View view2) {
        super.requestChildFocus(view, view2);
        boolean bl2 = this.isInTouchMode();
        if (!bl2 && !(bl2 = this.mCanSlide)) {
            boolean bl3;
            view2 = this.mSlideableView;
            if (view == view2) {
                bl3 = true;
            } else {
                bl3 = false;
                view = null;
            }
            this.mPreservedOpenState = bl3;
        }
    }

    public void setAllChildrenVisible() {
        int n10 = this.getChildCount();
        for (int i10 = 0; i10 < n10; ++i10) {
            int n11;
            View view = this.getChildAt(i10);
            int n12 = view.getVisibility();
            if (n12 != (n11 = 4)) continue;
            view.setVisibility(0);
        }
    }

    public void setCoveredFadeColor(int n10) {
        this.mCoveredFadeColor = n10;
    }

    public void setPanelSlideListener(SlidingPaneLayout$PanelSlideListener slidingPaneLayout$PanelSlideListener) {
        this.mPanelSlideListener = slidingPaneLayout$PanelSlideListener;
    }

    public void setParallaxDistance(int n10) {
        this.mParallaxBy = n10;
        this.requestLayout();
    }

    public void setShadowDrawable(Drawable drawable2) {
        this.setShadowDrawableLeft(drawable2);
    }

    public void setShadowDrawableLeft(Drawable drawable2) {
        this.mShadowDrawableLeft = drawable2;
    }

    public void setShadowDrawableRight(Drawable drawable2) {
        this.mShadowDrawableRight = drawable2;
    }

    public void setShadowResource(int n10) {
        Drawable drawable2 = this.getResources().getDrawable(n10);
        this.setShadowDrawable(drawable2);
    }

    public void setShadowResourceLeft(int n10) {
        Drawable drawable2 = ContextCompat.getDrawable(this.getContext(), n10);
        this.setShadowDrawableLeft(drawable2);
    }

    public void setShadowResourceRight(int n10) {
        Drawable drawable2 = ContextCompat.getDrawable(this.getContext(), n10);
        this.setShadowDrawableRight(drawable2);
    }

    public void setSliderFadeColor(int n10) {
        this.mSliderFadeColor = n10;
    }

    public void smoothSlideClosed() {
        this.closePane();
    }

    public void smoothSlideOpen() {
        this.openPane();
    }

    public boolean smoothSlideTo(float f10, int n10) {
        int n11;
        int n12;
        n10 = (int)(this.mCanSlide ? 1 : 0);
        if (n10 == 0) {
            return false;
        }
        n10 = (int)(this.isLayoutRtlSupport() ? 1 : 0);
        SlidingPaneLayout$LayoutParams slidingPaneLayout$LayoutParams = (SlidingPaneLayout$LayoutParams)this.mSlideableView.getLayoutParams();
        if (n10 != 0) {
            n10 = this.getPaddingRight();
            int n13 = slidingPaneLayout$LayoutParams.rightMargin;
            n10 += n13;
            slidingPaneLayout$LayoutParams = this.mSlideableView;
            n13 = slidingPaneLayout$LayoutParams.getWidth();
            n12 = this.getWidth();
            float f11 = n12;
            float f12 = n10;
            int n14 = this.mSlideRange;
            float f13 = n14;
            f12 += (f10 *= f13);
            f10 = n13;
            n11 = (int)(f11 -= (f12 += f10));
        } else {
            n10 = this.getPaddingLeft();
            int n15 = slidingPaneLayout$LayoutParams.leftMargin;
            float f14 = n10 += n15;
            n15 = this.mSlideRange;
            float f15 = n15;
            n11 = (int)(f14 += (f10 *= f15));
        }
        ViewDragHelper viewDragHelper = this.mDragHelper;
        slidingPaneLayout$LayoutParams = this.mSlideableView;
        n12 = slidingPaneLayout$LayoutParams.getTop();
        n11 = (int)(viewDragHelper.smoothSlideViewTo((View)slidingPaneLayout$LayoutParams, n11, n12) ? 1 : 0);
        if (n11 != 0) {
            this.setAllChildrenVisible();
            ViewCompat.postInvalidateOnAnimation((View)this);
            return true;
        }
        return false;
    }

    public void updateObscuredViewsVisibility(View view) {
        View view2;
        int n10;
        int n11;
        int n12;
        int n13;
        int n14;
        int n15;
        int n16;
        View view3 = view;
        int n17 = this.isLayoutRtlSupport();
        if (n17 != 0) {
            n16 = this.getWidth();
            n15 = this.getPaddingRight();
            n16 -= n15;
        } else {
            n16 = this.getPaddingLeft();
        }
        if (n17 != 0) {
            n15 = this.getPaddingLeft();
        } else {
            n15 = this.getWidth();
            n14 = this.getPaddingRight();
            n15 -= n14;
        }
        n14 = this.getPaddingTop();
        int n18 = this.getHeight();
        int n19 = this.getPaddingBottom();
        n18 -= n19;
        if (view3 != null && (n13 = SlidingPaneLayout.viewIsOpaque(view)) != 0) {
            n13 = view.getLeft();
            n12 = view.getRight();
            n11 = view.getTop();
            n10 = view.getBottom();
        } else {
            n13 = 0;
            n12 = 0;
            n11 = 0;
            n10 = 0;
        }
        int n20 = this.getChildCount();
        for (int i10 = 0; i10 < n20 && (view2 = this.getChildAt(i10)) != view3; ++i10) {
            int n21;
            int n22 = view2.getVisibility();
            if (n22 == (n19 = 8)) {
                n21 = n17;
            } else {
                n19 = n17 != 0 ? n15 : n16;
                n22 = view2.getLeft();
                n19 = Math.max(n19, n22);
                n22 = view2.getTop();
                n22 = Math.max(n14, n22);
                n21 = n17;
                int n23 = n17 != 0 ? n16 : n15;
                n17 = view2.getRight();
                n23 = Math.min(n23, n17);
                n17 = view2.getBottom();
                n17 = Math.min(n18, n17);
                if (n19 >= n13 && n22 >= n11 && n23 <= n12 && n17 <= n10) {
                    n23 = 4;
                } else {
                    n23 = 0;
                    view3 = null;
                }
                view2.setVisibility(n23);
            }
            view3 = view;
            n17 = n21;
        }
    }
}

