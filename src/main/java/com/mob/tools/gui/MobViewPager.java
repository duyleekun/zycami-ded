/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Canvas
 *  android.util.AttributeSet
 *  android.view.MotionEvent
 *  android.view.VelocityTracker
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.view.ViewConfiguration
 *  android.view.ViewGroup
 *  android.view.animation.Interpolator
 *  android.widget.Scroller
 */
package com.mob.tools.gui;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import com.mob.tools.gui.MobViewPager$1;
import com.mob.tools.gui.MobViewPager$2;
import com.mob.tools.gui.ViewPagerAdapter;

public class MobViewPager
extends ViewGroup {
    private static final int DECELERATION = 10;
    private static final int SNAP_VELOCITY = 500;
    private static final int TOUCH_STATE_REST = 0;
    private static final int TOUCH_STATE_SCROLLING = 1;
    private ViewPagerAdapter adapter;
    private View currentPage;
    private int currentScreen;
    private int flingVelocity;
    private float lastMotionX;
    private float lastMotionY;
    private int maximumVelocity;
    private View nextPage;
    private int pageWidth;
    private View previousPage;
    private int screenCount;
    private Scroller scroller;
    private boolean skipScreen;
    private int touchSlop;
    private int touchState;
    private VelocityTracker velocityTracker;

    public MobViewPager(Context context) {
        this(context, null);
    }

    public MobViewPager(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MobViewPager(Context context, AttributeSet attributeSet, int n10) {
        super(context, attributeSet, n10);
        this.init(context);
    }

    public static /* synthetic */ void access$000(MobViewPager mobViewPager, int n10, boolean bl2) {
        mobViewPager.scrollToScreenOnUIThread(n10, bl2);
    }

    private void adjustScroller() {
        View view;
        int n10;
        this.skipScreen = n10 = 1;
        View view2 = this.currentPage;
        if (view2 != null && (view2 = this.getFocusedChild()) == (view = this.currentPage)) {
            view.clearFocus();
        }
        n10 = this.currentScreen;
        int n11 = this.getWidth();
        n10 *= n11;
        n11 = this.getScrollX();
        int n12 = n10 - n11;
        view2 = this.scroller;
        view2.abortAnimation();
        if (n12 != 0) {
            Scroller scroller = this.scroller;
            int n13 = this.getScrollX();
            scroller.startScroll(n13, 0, n12, 0, 0);
        }
        this.invalidate();
    }

    private void handleInterceptMove(MotionEvent motionEvent) {
        float f10 = motionEvent.getX();
        float f11 = motionEvent.getY();
        float f12 = this.lastMotionX;
        f12 = Math.abs(f10 - f12);
        int n10 = (int)f12;
        float f13 = this.lastMotionY;
        int n11 = (int)(f11 = Math.abs(f11 - f13));
        if (n11 < n10 && n10 > (n11 = this.touchSlop)) {
            n11 = 1;
            f11 = Float.MIN_VALUE;
            this.touchState = n11;
            this.lastMotionX = f10;
        }
    }

    private void handleScrollMove(MotionEvent motionEvent) {
        int n10;
        ViewPagerAdapter viewPagerAdapter = this.adapter;
        if (viewPagerAdapter == null) {
            return;
        }
        float f10 = motionEvent.getX();
        float f11 = this.lastMotionX - f10;
        int n11 = (int)f11;
        this.lastMotionX = f10;
        f10 = 0.0f;
        motionEvent = null;
        if (n11 < 0) {
            int n12 = this.getScrollX();
            if (n12 > 0) {
                n12 = -this.getScrollX();
                n11 = Math.max(n12, n11);
                this.scrollBy(n11, 0);
            }
        } else if (n11 > 0 && (n10 = this.getChildCount()) != 0) {
            n10 = this.getChildCount() + -1;
            View view = this.getChildAt(n10);
            n10 = view.getRight();
            int n13 = this.getScrollX();
            n10 -= n13;
            n13 = this.getWidth();
            if ((n10 -= n13) > 0) {
                n11 = Math.min(n10, n11);
                this.scrollBy(n11, 0);
            }
        }
    }

    private void init(Context context) {
        int n10;
        int n11;
        Scroller scroller;
        MobViewPager$1 mobViewPager$1 = new MobViewPager$1(this);
        this.scroller = scroller = new Scroller(context, (Interpolator)mobViewPager$1);
        this.touchState = 0;
        context = ViewConfiguration.get((Context)context);
        this.touchSlop = n11 = context.getScaledTouchSlop();
        this.maximumVelocity = n10 = context.getScaledMaximumFlingVelocity();
    }

    /*
     * Unable to fully structure code
     */
    private void onScreenChange(int var1_1) {
        block13: {
            var2_2 = this.adapter;
            if (var2_2 == null) break block13;
            var3_3 = this.skipScreen;
            var4_4 = 2;
            if (var3_3 == 0) ** GOTO lbl-1000
            var3_3 = this.currentScreen;
            if ((var3_3 = Math.abs(var1_1 - var3_3)) > var4_4) {
                this.removeAllViews();
                var3_3 = this.currentScreen;
                if (var3_3 > 0) {
                    var5_5 = this.adapter;
                    var6_7 = this.previousPage;
                    var2_2 = var5_5.getView(var3_3 += -1, var6_7, this);
                    this.previousPage = var2_2;
                    this.addView((View)var2_2);
                }
                var2_2 = this.adapter;
                var4_4 = this.currentScreen;
                var6_7 = this.currentPage;
                var2_2 = var2_2.getView(var4_4, var6_7, this);
                this.currentPage = var2_2;
                this.addView((View)var2_2);
                var3_3 = this.currentScreen;
                var4_4 = this.screenCount + -1;
                if (var3_3 < var4_4) {
                    var5_5 = this.adapter;
                    var6_7 = this.nextPage;
                    var2_2 = var5_5.getView(++var3_3, var6_7, this);
                    this.nextPage = var2_2;
                    this.addView((View)var2_2);
                }
            } else lbl-1000:
            // 2 sources

            {
                var3_3 = this.currentScreen;
                var7_8 = 3;
                if (var3_3 > var1_1) {
                    var2_2 = null;
                    for (var3_3 = 0; var3_3 < (var4_4 = this.currentScreen - var1_1); ++var3_3) {
                        var4_4 = var1_1 + var3_3 + 1;
                        var8_9 = this.previousPage;
                        var9_11 = this.currentPage;
                        this.previousPage = var9_11;
                        var9_11 = this.nextPage;
                        this.currentPage = var9_11;
                        var10_13 = this.getChildCount();
                        if (var10_13 >= var7_8) {
                            this.removeViewAt(0);
                        }
                        if (var4_4 < (var10_13 = this.screenCount + -1)) {
                            var9_11 = this.adapter;
                            this.nextPage = var5_6 = var9_11.getView(++var4_4, var8_9, this);
                            this.addView(var5_6);
                            continue;
                        }
                        this.nextPage = var8_9;
                    }
                } else {
                    var3_3 = 0;
                    var2_2 = null;
                    while (true) {
                        var11_14 = this.currentScreen;
                        if (var3_3 >= (var11_14 = var1_1 - var11_14)) break;
                        var11_14 = var1_1 - var3_3 + -1;
                        var9_12 = this.nextPage;
                        var12_15 = this.currentPage;
                        this.nextPage = var12_15;
                        var12_15 = this.previousPage;
                        this.currentPage = var12_15;
                        var13_16 = this.getChildCount();
                        if (var13_16 >= var7_8) {
                            this.removeViewAt(var4_4);
                        }
                        if (var11_14 > 0) {
                            var12_15 = this.adapter;
                            this.previousPage = var8_10 = var12_15.getView(var11_14 += -1, var9_12, this);
                            this.addView(var8_10, 0);
                        } else {
                            this.previousPage = var9_12;
                        }
                        ++var3_3;
                    }
                }
            }
            var2_2 = this.adapter;
            var4_4 = this.currentScreen;
            var2_2.onScreenChange(var4_4, var1_1);
        }
    }

    /*
     * Unable to fully structure code
     */
    private void scrollToScreenOnUIThread(int var1_1, boolean var2_2) {
        block4: {
            this.skipScreen = var2_2;
            var3_3 = this.currentPage;
            if (var3_3 != null && (var3_3 = this.getFocusedChild()) == (var4_4 = this.currentPage)) {
                var4_4.clearFocus();
            }
            var5_5 = this.getWidth();
            var1_1 *= var5_5;
            var5_5 = this.getScrollX();
            var6_6 = var1_1 - var5_5;
            var7_7 = this.scroller;
            var7_7.abortAnimation();
            if (var6_6 == 0) break block4;
            var1_1 = 0;
            var7_7 = null;
            if (var2_2 != 0) ** GOTO lbl-1000
            var2_2 = Math.abs(var6_6) / 2;
            var5_5 = this.flingVelocity;
            if (var5_5 != 0) {
                var1_1 = Math.abs(var5_5);
                var5_5 = Math.abs(var6_6);
                var8_8 = 1000.0;
                var10_9 = var1_1;
                var1_1 *= var1_1;
                var12_10 = Math.sqrt(var1_1 - (var5_5 *= 20));
                var10_9 = (var10_9 - var12_10) * var8_8;
                var14_11 = 10.0;
                var1_1 = (int)(var10_9 /= var14_11);
            }
            if (var1_1 == 0 || var1_1 > var2_2) {
                var16_12 = var2_2;
            } else lbl-1000:
            // 2 sources

            {
                var16_12 = var1_1;
            }
            var4_4 = this.scroller;
            var17_13 = this.getScrollX();
            var4_4.startScroll(var17_13, 0, var6_6, 0, var16_12);
        }
        this.invalidate();
    }

    public void computeScroll() {
        int n10;
        ViewPagerAdapter viewPagerAdapter = this.adapter;
        if (viewPagerAdapter != null && (n10 = this.screenCount) > 0) {
            float f10;
            int n11;
            Object object;
            viewPagerAdapter = this.scroller;
            n10 = (int)(viewPagerAdapter.computeScrollOffset() ? 1 : 0);
            if (n10 != 0) {
                viewPagerAdapter = this.scroller;
                n10 = viewPagerAdapter.getCurrX();
                object = this.scroller;
                n11 = object.getCurrY();
                this.scrollTo(n10, n11);
                this.postInvalidate();
            } else {
                n10 = this.currentScreen;
                object = this.scroller;
                n11 = object.getCurrX();
                int n12 = this.getWidth();
                int n13 = n11 / n12;
                if ((n11 %= n12) > (n12 /= 2)) {
                    ++n13;
                }
                f10 = 0.0f;
                object = null;
                n12 = this.screenCount + -1;
                n12 = Math.min(n13, n12);
                this.currentScreen = n11 = Math.max(0, n12);
                if (n10 != n11) {
                    this.onScreenChange(n10);
                }
            }
            viewPagerAdapter = this.adapter;
            if (viewPagerAdapter != null) {
                n10 = this.getScrollX();
                float f11 = n10;
                n11 = this.getWidth();
                f10 = n11;
                object = this.adapter;
                ((ViewPagerAdapter)object).onScreenChanging(f11 /= f10);
            }
        }
    }

    public void dispatchDraw(Canvas canvas) {
        int n10;
        ViewPagerAdapter viewPagerAdapter = this.adapter;
        if (viewPagerAdapter != null && (n10 = this.screenCount) > 0) {
            View view;
            long l10 = this.getDrawingTime();
            int n11 = this.currentScreen;
            if (n11 > 0) {
                view = this.previousPage;
                this.drawChild(canvas, view, l10);
            }
            view = this.currentPage;
            this.drawChild(canvas, view, l10);
            n11 = this.currentScreen;
            int n12 = this.screenCount + -1;
            if (n11 < n12) {
                view = this.nextPage;
                this.drawChild(canvas, view, l10);
            }
        }
    }

    public boolean dispatchUnhandledMove(View view, int n10) {
        ViewPagerAdapter viewPagerAdapter = this.adapter;
        if (viewPagerAdapter == null) {
            return super.dispatchUnhandledMove(view, n10);
        }
        int n11 = 17;
        int n12 = 1;
        if (n10 == n11) {
            n11 = this.currentScreen;
            if (n11 > 0) {
                this.scrollToScreenOnUIThread(n11 -= n12, false);
                return n12 != 0;
            }
        } else {
            int n13;
            n11 = 66;
            if (n10 == n11 && (n11 = this.currentScreen) < (n13 = this.screenCount - n12)) {
                this.scrollToScreenOnUIThread(n11 += n12, false);
                return n12 != 0;
            }
        }
        return super.dispatchUnhandledMove(view, n10);
    }

    public int getCurrentScreen() {
        return this.currentScreen;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int n10;
        int n11;
        block7: {
            block4: {
                float f10;
                block5: {
                    block6: {
                        int n12;
                        int n13 = motionEvent.getAction();
                        int n14 = 2;
                        n11 = 1;
                        if (n13 == n14 && (n12 = this.touchState) != 0) {
                            return n11 != 0;
                        }
                        VelocityTracker velocityTracker = this.velocityTracker;
                        if (velocityTracker == null) {
                            this.velocityTracker = velocityTracker = VelocityTracker.obtain();
                        }
                        this.velocityTracker.addMovement(motionEvent);
                        n12 = 0;
                        velocityTracker = null;
                        if (n13 == 0) break block4;
                        if (n13 == n11) break block5;
                        if (n13 == n14) break block6;
                        n10 = 3;
                        f10 = 4.2E-45f;
                        if (n13 == n10) break block5;
                        break block7;
                    }
                    this.handleInterceptMove(motionEvent);
                    break block7;
                }
                if ((motionEvent = this.velocityTracker) != null) {
                    motionEvent.recycle();
                    n10 = 0;
                    f10 = 0.0f;
                    motionEvent = null;
                    this.velocityTracker = null;
                }
                this.touchState = 0;
                break block7;
            }
            float f11 = motionEvent.getX();
            float f12 = motionEvent.getY();
            this.lastMotionX = f11;
            this.lastMotionY = f12;
            motionEvent = this.scroller;
            this.touchState = n10 = motionEvent.isFinished() ^ n11;
        }
        n10 = this.touchState;
        if (n10 == 0) {
            n11 = 0;
        }
        return n11 != 0;
    }

    public void onLayout(boolean n10, int n11, int n12, int n13, int n14) {
        ViewPagerAdapter viewPagerAdapter = this.adapter;
        if (viewPagerAdapter != null && (n10 = this.screenCount) > 0) {
            int n15;
            n13 -= n11;
            n14 -= n12;
            n10 = this.currentScreen;
            n11 = n10 * n13;
            n12 = 0;
            if (n10 > 0) {
                viewPagerAdapter = this.previousPage;
                n15 = n11 - n13;
                viewPagerAdapter.layout(n15, 0, n11, n14);
            }
            viewPagerAdapter = this.currentPage;
            n15 = n11 + n13;
            viewPagerAdapter.layout(n11, 0, n15, n14);
            n10 = this.currentScreen;
            n11 = this.screenCount + -1;
            if (n10 < n11) {
                viewPagerAdapter = this.nextPage;
                viewPagerAdapter.layout(n15, 0, n13 += n15, n14);
            }
            if ((n10 = this.pageWidth) != (n11 = this.getWidth())) {
                n10 = this.pageWidth;
                this.pageWidth = n11 = this.getWidth();
                if (n10 != 0) {
                    this.adjustScroller();
                }
            }
        }
    }

    public void onMeasure(int n10, int n11) {
        super.onMeasure(n10, n11);
        ViewPagerAdapter viewPagerAdapter = this.adapter;
        if (viewPagerAdapter != null && (n10 = this.screenCount) > 0) {
            int n12;
            n10 = this.getMeasuredWidth();
            n11 = this.getMeasuredHeight();
            int n13 = 0x40000000;
            n10 = View.MeasureSpec.makeMeasureSpec((int)n10, (int)n13);
            n11 = View.MeasureSpec.makeMeasureSpec((int)n11, (int)n13);
            for (n13 = 0; n13 < (n12 = this.getChildCount()); ++n13) {
                View view = this.getChildAt(n13);
                view.measure(n10, n11);
            }
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        ViewPagerAdapter viewPagerAdapter = this.adapter;
        if (viewPagerAdapter == null) {
            return false;
        }
        viewPagerAdapter = this.velocityTracker;
        if (viewPagerAdapter == null) {
            viewPagerAdapter = VelocityTracker.obtain();
            this.velocityTracker = viewPagerAdapter;
        }
        viewPagerAdapter = this.velocityTracker;
        viewPagerAdapter.addMovement(motionEvent);
        int n10 = motionEvent.getAction();
        float f10 = motionEvent.getX();
        int n11 = 1;
        if (n10 != 0) {
            if (n10 != n11) {
                int n12 = 2;
                f10 = 2.8E-45f;
                if (n10 != n12) {
                    int n13 = 3;
                    float f11 = 4.2E-45f;
                    if (n10 == n13) {
                        this.touchState = 0;
                    }
                } else {
                    n10 = this.touchState;
                    if (n10 == n11) {
                        this.handleScrollMove(motionEvent);
                    } else {
                        n10 = (int)(this.onInterceptTouchEvent(motionEvent) ? 1 : 0);
                        if (n10 != 0 && (n10 = this.touchState) == n11) {
                            this.handleScrollMove(motionEvent);
                        }
                    }
                }
            } else {
                int n14 = this.touchState;
                if (n14 == n11) {
                    motionEvent = this.velocityTracker;
                    int n15 = this.maximumVelocity;
                    f10 = n15;
                    motionEvent.computeCurrentVelocity(1000, f10);
                    motionEvent = this.velocityTracker;
                    float f12 = motionEvent.getXVelocity();
                    this.flingVelocity = n14 = (int)f12;
                    n10 = 500;
                    if (n14 > n10 && (n10 = this.currentScreen) > 0) {
                        this.scrollToScreenOnUIThread(n10 -= n11, false);
                    } else {
                        n10 = -500;
                        if (n14 < n10 && (n14 = this.currentScreen) < (n10 = this.screenCount - n11)) {
                            this.scrollToScreenOnUIThread(n14 += n11, false);
                        } else {
                            n14 = this.getWidth();
                            n10 = this.getScrollX();
                            n15 = n14 / 2;
                            n10 = (n10 + n15) / n14;
                            this.scrollToScreenOnUIThread(n10, false);
                        }
                    }
                    motionEvent = this.velocityTracker;
                    if (motionEvent != null) {
                        motionEvent.recycle();
                        n14 = 0;
                        f12 = 0.0f;
                        motionEvent = null;
                        this.velocityTracker = null;
                    }
                }
                this.touchState = 0;
            }
        } else {
            int n16 = this.touchState;
            if (n16 != 0) {
                motionEvent = this.scroller;
                n16 = (int)(motionEvent.isFinished() ? 1 : 0);
                if (n16 == 0) {
                    motionEvent = this.scroller;
                    motionEvent.abortAnimation();
                }
                this.lastMotionX = f10;
            }
        }
        return n11 != 0;
    }

    public void scrollLeft(boolean bl2) {
        int n10 = this.currentScreen;
        if (n10 > 0) {
            this.scrollToScreen(n10 += -1, bl2);
        }
    }

    public void scrollRight(boolean bl2) {
        int n10 = this.currentScreen;
        int n11 = this.screenCount + -1;
        if (n10 < n11) {
            this.scrollToScreen(++n10, bl2);
        }
    }

    public void scrollToScreen(int n10, boolean bl2) {
        MobViewPager$2 mobViewPager$2 = new MobViewPager$2(this, n10, bl2);
        this.post(mobViewPager$2);
    }

    public void scrollToScreen(int n10, boolean bl2, boolean bl3) {
        this.scrollToScreen(n10, bl2);
    }

    public void setAdapter(ViewPagerAdapter viewPagerAdapter) {
        View view;
        int n10;
        ViewPagerAdapter viewPagerAdapter2 = this.adapter;
        if (viewPagerAdapter2 != null) {
            n10 = 0;
            view = null;
            viewPagerAdapter2.setMobViewPager(null);
        }
        this.adapter = viewPagerAdapter;
        if (viewPagerAdapter != null) {
            viewPagerAdapter.setMobViewPager(this);
        }
        int n11 = 0;
        viewPagerAdapter2 = null;
        if (viewPagerAdapter == null) {
            this.currentScreen = 0;
            this.removeAllViews();
            return;
        }
        this.screenCount = n10 = viewPagerAdapter.getCount();
        if (n10 <= 0) {
            this.currentScreen = 0;
            this.removeAllViews();
            return;
        }
        n11 = this.currentScreen;
        int n12 = 1;
        if (n10 <= n11) {
            this.scrollToScreenOnUIThread(n10 -= n12, n12 != 0);
        } else {
            this.removeAllViews();
            n11 = this.currentScreen;
            if (n11 > 0) {
                view = this.previousPage;
                viewPagerAdapter2 = viewPagerAdapter.getView(n11 -= n12, view, this);
                this.previousPage = viewPagerAdapter2;
                this.addView((View)viewPagerAdapter2);
            }
            n11 = this.currentScreen;
            view = this.currentPage;
            viewPagerAdapter2 = viewPagerAdapter.getView(n11, view, this);
            this.currentPage = viewPagerAdapter2;
            this.addView((View)viewPagerAdapter2);
            n11 = this.currentScreen;
            n10 = this.screenCount - n12;
            if (n11 < n10) {
                view = this.nextPage;
                viewPagerAdapter = viewPagerAdapter.getView(n11 += n12, view, this);
                this.nextPage = viewPagerAdapter;
                this.addView((View)viewPagerAdapter);
            }
        }
    }
}

