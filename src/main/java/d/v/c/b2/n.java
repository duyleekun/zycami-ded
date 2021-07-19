/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.AttributeSet
 *  android.view.MotionEvent
 *  android.view.VelocityTracker
 *  android.view.ViewConfiguration
 *  android.widget.OverScroller
 */
package d.v.c.b2;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import android.widget.OverScroller;
import androidx.appcompat.widget.LinearLayoutCompat;

public abstract class n
extends LinearLayoutCompat {
    private static final String h = n.class.getSimpleName();
    private static final int i = Integer.MAX_VALUE;
    private int a;
    public OverScroller b;
    public VelocityTracker c;
    private int d;
    private int e;
    private int f;
    private boolean g;

    public n(Context context) {
        this(context, null);
    }

    public n(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public n(Context context, AttributeSet attributeSet, int n10) {
        super(context, attributeSet, n10);
        this.b();
    }

    private void b() {
        int n10;
        int n11;
        OverScroller overScroller;
        Context context = this.getContext();
        this.b = overScroller = new OverScroller(context);
        this.setOverScrollMode(0);
        overScroller = ViewConfiguration.get((Context)this.getContext());
        this.d = n11 = overScroller.getScaledTouchSlop();
        this.e = n11 = overScroller.getScaledMinimumFlingVelocity();
        this.f = n10 = overScroller.getScaledMaximumFlingVelocity();
    }

    private void c() {
        VelocityTracker velocityTracker = this.c;
        if (velocityTracker == null) {
            this.c = velocityTracker = VelocityTracker.obtain();
        }
    }

    private void g() {
        VelocityTracker velocityTracker = this.c;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            velocityTracker = null;
            this.c = null;
        }
    }

    public void a(int n10) {
        OverScroller overScroller = this.b;
        int n11 = this.getScrollX();
        int n12 = this.getScrollY();
        int n13 = this.getMinimumScroll();
        int n14 = this.getMaximumScroll();
        int n15 = this.getWidth() / 2;
        overScroller.fling(n11, n12, n10, 0, n13, n14, 0, 0, n15, 0);
        this.d();
    }

    public int computeHorizontalScrollRange() {
        return this.getMaximumScroll();
    }

    public void computeScroll() {
        OverScroller overScroller = this.b;
        int n10 = overScroller.computeScrollOffset();
        if (n10 != 0) {
            int n11 = this.getScrollX();
            int n12 = this.getScrollY();
            overScroller = this.b;
            n10 = overScroller.getCurrX();
            int n13 = this.b.getCurrY();
            int n14 = n10 - n11;
            int n15 = n13 - n12;
            int n16 = this.getMaximumScroll();
            int n17 = this.getWidth();
            this.overScrollBy(n14, n15, n11, n12, n16, 0, n17, 0, false);
            this.d();
        }
    }

    public void d() {
        this.postInvalidateOnAnimation();
    }

    public boolean e() {
        OverScroller overScroller;
        boolean bl2 = this.g;
        if (!bl2 && (bl2 = (overScroller = this.b).isFinished())) {
            bl2 = false;
            overScroller = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }

    public boolean f(int n10) {
        int n11 = this.getScrollX();
        int n12 = this.getScrollY();
        int n13 = this.getMaximumScroll();
        int n14 = this.getWidth();
        return this.overScrollBy(n10, 0, n11, n12, n13, 0, n14, 0, false);
    }

    public int getMaximumScroll() {
        int n10 = this.getMinimumScroll();
        int n11 = this.getWidth();
        return n10 - n11;
    }

    public int getMinimumScroll() {
        return 0;
    }

    public void h() {
        OverScroller overScroller = this.b;
        int n10 = this.getScrollX();
        int n11 = this.getScrollY();
        int n12 = this.getMinimumScroll();
        int n13 = this.getMaximumScroll();
        overScroller.springBack(n10, n11, n12, n13, 0, 0);
        this.d();
    }

    public void onMeasure(int n10, int n11) {
        super.onMeasure(n10, n11);
    }

    public void onOverScrolled(int n10, int n11, boolean n12, boolean bl2) {
        n12 = this.getMinimumScroll();
        if (n10 < n12) {
            n10 = this.getMinimumScroll();
        } else {
            n12 = this.getMaximumScroll();
            if (n10 > n12) {
                n10 = this.getMaximumScroll();
            }
        }
        OverScroller overScroller = this.b;
        n12 = (int)(overScroller.isFinished() ? 1 : 0);
        if (n12 == 0) {
            n12 = this.getScrollX();
            int n13 = this.getScrollY();
            this.setScrollX(n10);
            this.onScrollChanged(n10, n11, n12, n13);
        } else {
            super.scrollTo(n10, n11);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int n10;
        this.c();
        VelocityTracker velocityTracker = this.c;
        velocityTracker.addMovement(motionEvent);
        int n11 = motionEvent.getAction();
        int n12 = 1;
        if (n11 != 0) {
            int n13 = 0;
            Object object = null;
            int n14 = -1 >>> 1;
            if (n11 != n12) {
                int n15 = 2;
                float f10 = 2.8E-45f;
                if (n11 != n15) {
                    int n16 = 3;
                    float f11 = 4.2E-45f;
                    if (n11 == n16) {
                        n16 = this.g;
                        if (n16 != 0 && (n16 = (int)((motionEvent = this.b).isFinished() ? 1 : 0)) != 0) {
                            this.h();
                        }
                        this.g = false;
                        this.a = n14;
                        this.g();
                    }
                } else {
                    float f12;
                    n11 = (int)(this.g ? 1 : 0);
                    if (n11 == 0 && (n11 = this.a) == n14) {
                        f12 = motionEvent.getX();
                        this.a = n11 = (int)f12;
                    }
                    float f13 = motionEvent.getX();
                    int n17 = (int)f13;
                    n11 = this.a - n17;
                    n13 = this.g;
                    if (n13 == 0 && (n13 = Math.abs(n11)) > (n14 = this.d)) {
                        object = this.getParent();
                        if (object != null) {
                            object = this.getParent();
                            object.requestDisallowInterceptTouchEvent(n12 != 0);
                        }
                        this.g = n12;
                        if (n11 > 0) {
                            n13 = this.d;
                            n11 -= n13;
                        } else {
                            n13 = this.d;
                            n11 += n13;
                        }
                    }
                    if ((n13 = (int)(this.g ? 1 : 0)) != 0) {
                        this.a = n17;
                        n17 = this.getScrollX();
                        if (n17 <= 0 || (n17 = this.getScrollX()) >= (n13 = this.getMaximumScroll())) {
                            f13 = n11;
                            f12 = 0.7f;
                            n11 = (int)(f13 *= f12);
                        }
                        n14 = n11;
                        n15 = 0;
                        f10 = 0.0f;
                        int n18 = this.getScrollX();
                        int n19 = this.getScrollY();
                        int n20 = this.getMaximumScroll();
                        int n21 = this.getWidth();
                        boolean bl2 = true;
                        object = this;
                        n17 = (int)(this.overScrollBy(n11, 0, n18, n19, n20, 0, n21, 0, bl2) ? 1 : 0);
                        if (n17 != 0) {
                            motionEvent = this.c;
                            motionEvent.clear();
                        }
                    }
                }
            } else {
                int n22 = this.g;
                if (n22 != 0) {
                    motionEvent = this.c;
                    float f14 = 1.401E-42f;
                    float f15 = this.f;
                    motionEvent.computeCurrentVelocity(1000, f15);
                    motionEvent = this.c;
                    float f16 = motionEvent.getXVelocity();
                    n22 = (int)f16;
                    n11 = Math.abs(n22);
                    int n23 = this.e;
                    if (n11 > n23) {
                        n22 = -n22;
                        this.a(n22);
                    } else {
                        this.h();
                    }
                }
                this.g = false;
                this.a = n14;
                this.g();
            }
            return n12 != 0;
        }
        n11 = (int)(this.g ? 1 : 0);
        OverScroller overScroller = this.b;
        int n24 = overScroller.isFinished();
        if (n11 != n24 && (velocityTracker = this.getParent()) != null) {
            velocityTracker = this.getParent();
            velocityTracker.requestDisallowInterceptTouchEvent(n12 != 0);
        }
        if ((n11 = (int)((velocityTracker = this.b).isFinished() ? 1 : 0)) == 0) {
            velocityTracker = this.b;
            velocityTracker.abortAnimation();
            this.g = n12;
        }
        this.a = n10 = (int)motionEvent.getX();
        return n12 != 0;
    }
}

