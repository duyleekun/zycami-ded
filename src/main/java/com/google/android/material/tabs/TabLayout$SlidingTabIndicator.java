/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.animation.Animator$AnimatorListener
 *  android.animation.TimeInterpolator
 *  android.animation.ValueAnimator
 *  android.animation.ValueAnimator$AnimatorUpdateListener
 *  android.content.Context
 *  android.graphics.Canvas
 *  android.graphics.Paint
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.RectF
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.GradientDrawable
 *  android.os.Build$VERSION
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.widget.LinearLayout
 *  android.widget.LinearLayout$LayoutParams
 */
package com.google.android.material.tabs;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.view.View;
import android.widget.LinearLayout;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayout$SlidingTabIndicator$1;
import com.google.android.material.tabs.TabLayout$SlidingTabIndicator$2;
import com.google.android.material.tabs.TabLayout$TabView;

public class TabLayout$SlidingTabIndicator
extends LinearLayout {
    private final GradientDrawable defaultSelectionIndicator;
    private ValueAnimator indicatorAnimator;
    private int indicatorLeft;
    private int indicatorRight;
    private int layoutDirection;
    private int selectedIndicatorHeight;
    private final Paint selectedIndicatorPaint;
    public int selectedPosition;
    public float selectionOffset;
    public final /* synthetic */ TabLayout this$0;

    public TabLayout$SlidingTabIndicator(TabLayout tabLayout, Context context) {
        int n10;
        this.this$0 = tabLayout;
        super(context);
        this.selectedPosition = n10 = -1;
        this.layoutDirection = n10;
        this.indicatorLeft = n10;
        this.indicatorRight = n10;
        this.setWillNotDraw(false);
        super();
        this.selectedIndicatorPaint = tabLayout;
        super();
        this.defaultSelectionIndicator = tabLayout;
    }

    private void calculateTabViewContentBounds(TabLayout$TabView tabLayout$TabView, RectF rectF) {
        int n10;
        TabLayout tabLayout;
        int n11;
        int n12 = TabLayout$TabView.access$500(tabLayout$TabView);
        if (n12 < (n11 = (tabLayout = this.this$0).dpToPx(n10 = 24))) {
            TabLayout tabLayout2 = this.this$0;
            n12 = tabLayout2.dpToPx(n10);
        }
        n11 = tabLayout$TabView.getLeft();
        int n13 = tabLayout$TabView.getRight();
        n11 = (n11 + n13) / 2;
        n13 = n11 - (n12 /= 2);
        float f10 = n13;
        float f11 = n11 += n12;
        rectF.set(f10, 0.0f, f11, 0.0f);
    }

    private void updateIndicatorPosition() {
        int n10;
        int n11;
        int n12 = this.selectedPosition;
        Object object = this.getChildAt(n12);
        if (object != null && (n11 = object.getWidth()) > 0) {
            float f10;
            n11 = object.getLeft();
            n10 = object.getRight();
            TabLayout tabLayout = this.this$0;
            int n13 = tabLayout.tabIndicatorFullWidth;
            if (n13 == 0 && (n13 = object instanceof TabLayout$TabView) != 0) {
                object = (TabLayout$TabView)((Object)object);
                RectF rectF = TabLayout.access$400(tabLayout);
                this.calculateTabViewContentBounds((TabLayout$TabView)((Object)object), rectF);
                n11 = (int)TabLayout.access$400((TabLayout)this.this$0).left;
                object = TabLayout.access$400(this.this$0);
                f10 = object.right;
                n10 = (int)f10;
            }
            f10 = this.selectionOffset;
            int n14 = 0;
            float f11 = 0.0f;
            tabLayout = null;
            float f12 = f10 - 0.0f;
            n12 = (int)(f12 == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1));
            if (n12 > 0 && (n12 = this.selectedPosition) < (n14 = this.getChildCount() + -1)) {
                n12 = this.selectedPosition + 1;
                object = this.getChildAt(n12);
                n14 = object.getLeft();
                n13 = object.getRight();
                TabLayout tabLayout2 = this.this$0;
                boolean bl2 = tabLayout2.tabIndicatorFullWidth;
                if (!bl2 && (bl2 = object instanceof TabLayout$TabView)) {
                    object = (TabLayout$TabView)((Object)object);
                    tabLayout = TabLayout.access$400(tabLayout2);
                    this.calculateTabViewContentBounds((TabLayout$TabView)((Object)object), (RectF)tabLayout);
                    n14 = (int)TabLayout.access$400((TabLayout)this.this$0).left;
                    object = TabLayout.access$400(this.this$0);
                    f10 = object.right;
                    n13 = (int)f10;
                }
                f10 = this.selectionOffset;
                f11 = (float)n14 * f10;
                float f13 = 1.0f;
                float f14 = f13 - f10;
                float f15 = n11;
                n11 = (int)(f11 + (f14 *= f15));
                f11 = (float)n13 * f10;
                f13 -= f10;
                f10 = n10;
                n10 = (int)(f11 += (f13 *= f10));
            }
        } else {
            n11 = -1;
            float f16 = 0.0f / 0.0f;
            n10 = n11;
        }
        this.setIndicatorPosition(n11, n10);
    }

    public void animateIndicatorToPosition(int n10, int n11) {
        RectF rectF;
        boolean bl2;
        Object object = this.indicatorAnimator;
        if (object != null && (bl2 = object.isRunning())) {
            object = this.indicatorAnimator;
            object.cancel();
        }
        if ((object = this.getChildAt(n10)) == null) {
            this.updateIndicatorPosition();
            return;
        }
        int n12 = object.getLeft();
        int n13 = object.getRight();
        Object object2 = this.this$0;
        boolean bl3 = object2.tabIndicatorFullWidth;
        if (!bl3 && (bl3 = object instanceof TabLayout$TabView)) {
            object = (TabLayout$TabView)((Object)object);
            rectF = TabLayout.access$400(object2);
            this.calculateTabViewContentBounds((TabLayout$TabView)((Object)object), rectF);
            n12 = (int)TabLayout.access$400((TabLayout)this.this$0).left;
            object = TabLayout.access$400(this.this$0);
            float f10 = object.right;
            n13 = (int)f10;
        }
        int n14 = n12;
        int n15 = n13;
        int n16 = this.indicatorLeft;
        int n17 = this.indicatorRight;
        if (n16 != n12 || n17 != n13) {
            this.indicatorAnimator = object = new ValueAnimator();
            rectF = AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR;
            object.setInterpolator((TimeInterpolator)rectF);
            long l10 = n11;
            object.setDuration(l10);
            n11 = 2;
            Object object3 = new float[n11];
            object3[0] = 0.0f;
            object3[1] = 1.0f;
            object.setFloatValues(object3);
            object3 = new TabLayout$SlidingTabIndicator$1;
            object2 = object3;
            object3(this, n16, n14, n17, n15);
            object.addUpdateListener((ValueAnimator.AnimatorUpdateListener)object3);
            object3 = (Object)new TabLayout$SlidingTabIndicator$2;
            object3(this, n10);
            object.addListener((Animator.AnimatorListener)object3);
            object.start();
        }
    }

    public boolean childrenNeedLayout() {
        int n10 = this.getChildCount();
        for (int i10 = 0; i10 < n10; ++i10) {
            View view = this.getChildAt(i10);
            int n11 = view.getWidth();
            if (n11 > 0) continue;
            return true;
        }
        return false;
    }

    public void draw(Canvas canvas) {
        int n10;
        int n11;
        int n12;
        Drawable drawable2 = this.this$0.tabSelectedIndicator;
        int n13 = 0;
        PorterDuff.Mode mode = null;
        if (drawable2 != null) {
            n12 = drawable2.getIntrinsicHeight();
        } else {
            n12 = 0;
            drawable2 = null;
        }
        int n14 = this.selectedIndicatorHeight;
        if (n14 >= 0) {
            n12 = n14;
        }
        TabLayout tabLayout = this.this$0;
        n14 = tabLayout.tabIndicatorGravity;
        if (n14 != 0) {
            n11 = 1;
            n10 = 2;
            if (n14 != n11) {
                if (n14 != n10) {
                    n12 = 3;
                    if (n14 != n12) {
                        n12 = 0;
                        drawable2 = null;
                    } else {
                        n12 = this.getHeight();
                    }
                }
            } else {
                n13 = (this.getHeight() - n12) / n10;
                n14 = this.getHeight() + n12;
                n12 = n14 / 2;
            }
        } else {
            n13 = this.getHeight() - n12;
            n12 = this.getHeight();
        }
        if ((n14 = this.indicatorLeft) >= 0 && (n11 = this.indicatorRight) > n14) {
            tabLayout = this.this$0.tabSelectedIndicator;
            if (tabLayout == null) {
                tabLayout = this.defaultSelectionIndicator;
            }
            tabLayout = DrawableCompat.wrap((Drawable)tabLayout);
            n11 = this.indicatorLeft;
            n10 = this.indicatorRight;
            tabLayout.setBounds(n11, n13, n10, n12);
            drawable2 = this.selectedIndicatorPaint;
            if (drawable2 != null) {
                n13 = Build.VERSION.SDK_INT;
                n11 = 21;
                if (n13 == n11) {
                    n12 = drawable2.getColor();
                    mode = PorterDuff.Mode.SRC_IN;
                    tabLayout.setColorFilter(n12, mode);
                } else {
                    n12 = drawable2.getColor();
                    DrawableCompat.setTint((Drawable)tabLayout, n12);
                }
            }
            tabLayout.draw(canvas);
        }
        super.draw(canvas);
    }

    public float getIndicatorPosition() {
        float f10 = this.selectedPosition;
        float f11 = this.selectionOffset;
        return f10 + f11;
    }

    /*
     * WARNING - void declaration
     */
    public void onLayout(boolean bl2, int n10, int n11, int n12, int n13) {
        boolean bl3;
        void var5_7;
        int n14;
        int n15;
        void var2_4;
        super.onLayout(bl2, (int)var2_4, n15, n14, (int)var5_7);
        ValueAnimator valueAnimator = this.indicatorAnimator;
        if (valueAnimator != null && (bl3 = valueAnimator.isRunning())) {
            this.indicatorAnimator.cancel();
            valueAnimator = this.indicatorAnimator;
            long l10 = valueAnimator.getDuration();
            n15 = this.selectedPosition;
            n14 = 1065353216;
            ValueAnimator valueAnimator2 = this.indicatorAnimator;
            float f10 = valueAnimator2.getAnimatedFraction();
            float f11 = 1.0f - f10;
            float f12 = l10;
            int n16 = Math.round(f11 *= f12);
            this.animateIndicatorToPosition(n15, n16);
        } else {
            this.updateIndicatorPosition();
        }
    }

    public void onMeasure(int n10, int n11) {
        super.onMeasure(n10, n11);
        int n12 = View.MeasureSpec.getMode((int)n10);
        int n13 = 0x40000000;
        if (n12 != n13) {
            return;
        }
        TabLayout tabLayout = this.this$0;
        n13 = tabLayout.mode;
        int n14 = 1;
        float f10 = Float.MIN_VALUE;
        if (n13 == n14 && (n12 = tabLayout.tabGravity) == n14) {
            int n15;
            int n16;
            View view;
            int n17;
            n12 = this.getChildCount();
            n13 = 0;
            TabLayout tabLayout2 = null;
            float f11 = 0.0f;
            int n18 = 0;
            for (n17 = 0; n17 < n12; ++n17) {
                view = this.getChildAt(n17);
                n16 = view.getVisibility();
                if (n16 != 0) continue;
                n15 = view.getMeasuredWidth();
                n18 = Math.max(n18, n15);
            }
            if (n18 <= 0) {
                return;
            }
            tabLayout2 = this.this$0;
            n17 = tabLayout2.dpToPx(16);
            n15 = n18 * n12;
            n16 = this.getMeasuredWidth();
            if (n15 <= (n16 -= (n17 *= 2))) {
                n17 = 0;
                tabLayout2 = null;
                f11 = 0.0f;
                while (n13 < n12) {
                    float f12;
                    float f13;
                    view = (LinearLayout.LayoutParams)this.getChildAt(n13).getLayoutParams();
                    n16 = view.width;
                    if (n16 != n18 || (n16 = (int)((f13 = (f12 = view.weight) - 0.0f) == 0.0f ? 0 : (f13 > 0.0f ? 1 : -1))) != 0) {
                        view.width = n18;
                        view.weight = 0.0f;
                        n17 = n14;
                        f11 = f10;
                    }
                    ++n13;
                }
                n14 = n17;
                f10 = f11;
            } else {
                tabLayout = this.this$0;
                tabLayout.tabGravity = 0;
                tabLayout.updateTabViews(false);
            }
            if (n14 != 0) {
                super.onMeasure(n10, n11);
            }
        }
    }

    public void onRtlPropertiesChanged(int n10) {
        super.onRtlPropertiesChanged(n10);
        int n11 = Build.VERSION.SDK_INT;
        int n12 = 23;
        if (n11 < n12 && (n11 = this.layoutDirection) != n10) {
            this.requestLayout();
            this.layoutDirection = n10;
        }
    }

    public void setIndicatorPosition(int n10, int n11) {
        int n12 = this.indicatorLeft;
        if (n10 != n12 || n11 != (n12 = this.indicatorRight)) {
            this.indicatorLeft = n10;
            this.indicatorRight = n11;
            ViewCompat.postInvalidateOnAnimation((View)this);
        }
    }

    public void setIndicatorPositionFromTabPosition(int n10, float f10) {
        boolean bl2;
        ValueAnimator valueAnimator = this.indicatorAnimator;
        if (valueAnimator != null && (bl2 = valueAnimator.isRunning())) {
            valueAnimator = this.indicatorAnimator;
            valueAnimator.cancel();
        }
        this.selectedPosition = n10;
        this.selectionOffset = f10;
        this.updateIndicatorPosition();
    }

    public void setSelectedIndicatorColor(int n10) {
        Paint paint = this.selectedIndicatorPaint;
        int n11 = paint.getColor();
        if (n11 != n10) {
            paint = this.selectedIndicatorPaint;
            paint.setColor(n10);
            ViewCompat.postInvalidateOnAnimation((View)this);
        }
    }

    public void setSelectedIndicatorHeight(int n10) {
        int n11 = this.selectedIndicatorHeight;
        if (n11 != n10) {
            this.selectedIndicatorHeight = n10;
            ViewCompat.postInvalidateOnAnimation((View)this);
        }
    }
}

