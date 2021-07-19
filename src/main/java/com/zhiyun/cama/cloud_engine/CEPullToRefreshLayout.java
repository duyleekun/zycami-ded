/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.AttributeSet
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.view.ViewConfiguration
 *  android.view.ViewGroup
 *  android.view.animation.Animation
 *  android.view.animation.Animation$AnimationListener
 *  android.view.animation.DecelerateInterpolator
 *  android.view.animation.Interpolator
 *  android.widget.ListView
 */
package com.zhiyun.cama.cloud_engine;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.ListView;
import androidx.core.view.NestedScrollingChild;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.NestedScrollingParent;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.core.view.ViewCompat;
import androidx.core.widget.ListViewCompat;
import com.zhiyun.cama.cloud_engine.CEPullToRefreshLayout$a;
import com.zhiyun.cama.cloud_engine.CEPullToRefreshLayout$b;
import com.zhiyun.cama.cloud_engine.CEPullToRefreshLayout$c;
import com.zhiyun.cama.cloud_engine.CEPullToRefreshLayout$d;
import d.v.c.t0.b0;
import d.v.e.l.o1;
import m.a.a;

public class CEPullToRefreshLayout
extends ViewGroup
implements NestedScrollingParent,
NestedScrollingChild {
    public static final int C = 40;
    private static final String D = CEPullToRefreshLayout.class.getSimpleName();
    private static final float E = 2.0f;
    private static final int F = 255;
    private static final float G = 0.5f;
    private static final int H = 200;
    private static final int I = 200;
    private static final int J = 64;
    private static final int[] K;
    private final Animation A;
    private final Animation B;
    private View a;
    public CEPullToRefreshLayout$d b;
    public boolean c = false;
    private final int d;
    private final float e;
    private float f;
    private final NestedScrollingParentHelper g;
    private final NestedScrollingChildHelper h;
    private final int[] i;
    private final int[] j;
    private boolean k;
    public int l;
    private float m;
    private float n;
    private boolean o;
    private int p;
    private boolean q;
    private final DecelerateInterpolator r;
    public b0 s;
    private int t;
    public int u;
    public int v;
    public int w;
    public boolean x;
    private final int y;
    private final Animation.AnimationListener z;

    static {
        int[] nArray = new int[]{0x101000E};
        K = nArray;
    }

    public CEPullToRefreshLayout(Context context) {
        this(context, null);
    }

    public CEPullToRefreshLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        float f10;
        int n10;
        int n11 = 2;
        int[] nArray = new int[n11];
        this.i = nArray;
        Object object = new int[n11];
        this.j = object;
        this.p = n11 = -1;
        this.t = n11;
        object = new CEPullToRefreshLayout$a;
        super(this);
        this.z = (Animation.AnimationListener)object;
        object = (Object)new CEPullToRefreshLayout$b;
        super(this);
        this.A = (Animation)object;
        object = (Object)new CEPullToRefreshLayout$c;
        super(this);
        this.B = (Animation)object;
        this.d = n11 = ViewConfiguration.get((Context)context).getScaledTouchSlop();
        o1.B(context, 0x10E0001);
        this.setWillNotDraw(false);
        object = new DecelerateInterpolator;
        super(2.0f);
        this.r = (DecelerateInterpolator)object;
        object = this.getResources().getDisplayMetrics();
        this.y = n10 = (int)(object.density * 40.0f);
        this.d();
        boolean bl2 = true;
        this.setChildrenDrawingOrderEnabled(bl2);
        this.w = n11 = (int)(object.density * 64.0f);
        this.e = f10 = (float)n11;
        object = new NestedScrollingParentHelper;
        super(this);
        this.g = (NestedScrollingParentHelper)object;
        object = new NestedScrollingChildHelper;
        super((View)this);
        this.h = (NestedScrollingChildHelper)object;
        this.setNestedScrollingEnabled(bl2);
        this.l = n11 = -n10;
        this.v = n11;
        this.i(1.0f);
        object = K;
        context = context.obtainStyledAttributes(attributeSet, object);
        boolean bl3 = context.getBoolean(0, bl2);
        this.setEnabled(bl3);
        context.recycle();
    }

    private void a(int n10, Animation.AnimationListener animationListener) {
        this.u = n10;
        this.A.reset();
        Object object = this.A;
        long l10 = 200L;
        object.setDuration(l10);
        object = this.A;
        DecelerateInterpolator decelerateInterpolator = this.r;
        object.setInterpolator((Interpolator)decelerateInterpolator);
        if (animationListener != null) {
            object = this.s;
            object.setAnimationListener(animationListener);
        }
        this.s.clearAnimation();
        object = this.s;
        animationListener = this.A;
        object.startAnimation((Animation)animationListener);
    }

    private void b(int n10) {
        this.u = n10;
        this.B.reset();
        this.B.setDuration(200L);
        Object object = this.B;
        DecelerateInterpolator decelerateInterpolator = this.r;
        object.setInterpolator((Interpolator)decelerateInterpolator);
        this.s.clearAnimation();
        object = this.s;
        decelerateInterpolator = this.B;
        object.startAnimation((Animation)decelerateInterpolator);
    }

    private void d() {
        b0 b02;
        Context context = this.getContext();
        this.s = b02 = new b0(context);
        b02.setVisibility(8);
        b02 = this.s;
        this.addView((View)b02);
    }

    private void e() {
        View view = this.a;
        if (view == null) {
            int n10;
            view = null;
            for (int i10 = 0; i10 < (n10 = this.getChildCount()); ++i10) {
                b0 b02;
                View view2 = this.getChildAt(i10);
                boolean bl2 = view2.equals((Object)(b02 = this.s));
                if (bl2) continue;
                this.a = view2;
                break;
            }
        }
    }

    private void f(float f10) {
        float f11 = this.e;
        float f12 = f10 - f11;
        Object object = f12 == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1);
        if (object > 0) {
            object = true;
            f10 = Float.MIN_VALUE;
            this.l((boolean)object, (boolean)object);
        } else {
            f10 = 0.0f;
            this.c = false;
            object = this.l;
            this.b((int)object);
        }
    }

    private void h(float f10) {
        float f11 = this.e;
        f11 = Math.abs(f10 / f11);
        f11 = Math.min(1.0f, f11);
        f10 = Math.abs(f10);
        float f12 = this.e;
        f10 -= f12;
        int n10 = this.w;
        f12 = n10;
        float f13 = 2.0f;
        float f14 = f12 * f13;
        f10 = Math.min(f10, f14) / f12;
        f10 = Math.max(0.0f, f10);
        f14 = 4.0f;
        double d10 = f10 / f14;
        double d11 = Math.pow(d10, 2.0);
        f10 = (float)(d10 -= d11) * f13 * f12 * f13;
        int n11 = this.v;
        f12 = f12 * f11 + f10;
        int n12 = (int)f12;
        n11 += n12;
        b0 b02 = this.s;
        n12 = b02.getVisibility();
        if (n12 != 0) {
            b02 = this.s;
            f11 = 0.0f;
            b02.setVisibility(0);
        }
        n12 = this.l;
        this.setTargetOffsetTopAndBottom(n11 -= n12);
    }

    private void j(MotionEvent motionEvent) {
        int n10;
        int n11 = motionEvent.getActionIndex();
        int n12 = motionEvent.getPointerId(n11);
        if (n12 == (n10 = this.p)) {
            int n13;
            n11 = n11 == 0 ? 1 : 0;
            this.p = n13 = motionEvent.getPointerId(n11);
        }
    }

    /*
     * WARNING - void declaration
     */
    private void l(boolean bl2, boolean bl3) {
        boolean bl4 = this.c;
        if (bl4 != bl2) {
            void var2_4;
            this.x = var2_4;
            this.e();
            this.c = bl2;
            if (bl2) {
                int n10 = this.l;
                Animation.AnimationListener animationListener = this.z;
                this.a(n10, animationListener);
            } else {
                int n11 = this.l;
                this.b(n11);
            }
        }
    }

    private void m(float f10) {
        float f11 = this.n;
        int n10 = this.d;
        float f12 = n10;
        float f13 = (f10 -= f11) - f12;
        Object object = f13 == 0.0f ? 0 : (f13 > 0.0f ? 1 : -1);
        if (object > 0 && (object = (Object)this.o) == false) {
            f10 = n10;
            this.m = f11 += f10;
            object = true;
            f10 = Float.MIN_VALUE;
            this.o = object;
        }
    }

    public boolean c() {
        View view = this.a;
        boolean bl2 = view instanceof ListView;
        int n10 = -1;
        if (bl2) {
            return ListViewCompat.canScrollList((ListView)view, n10);
        }
        return view.canScrollVertically(n10);
    }

    public boolean dispatchNestedFling(float f10, float f11, boolean bl2) {
        return this.h.dispatchNestedFling(f10, f11, bl2);
    }

    public boolean dispatchNestedPreFling(float f10, float f11) {
        return this.h.dispatchNestedPreFling(f10, f11);
    }

    public boolean dispatchNestedPreScroll(int n10, int n11, int[] nArray, int[] nArray2) {
        return this.h.dispatchNestedPreScroll(n10, n11, nArray, nArray2);
    }

    public boolean dispatchNestedScroll(int n10, int n11, int n12, int n13, int[] nArray) {
        return this.h.dispatchNestedScroll(n10, n11, n12, n13, nArray);
    }

    public boolean g() {
        return this.c;
    }

    public int getChildDrawingOrder(int n10, int n11) {
        int n12 = this.t;
        if (n12 < 0) {
            return n11;
        }
        if (n11 == (n10 += -1)) {
            return n12;
        }
        if (n11 >= n12) {
            ++n11;
        }
        return n11;
    }

    public int getNestedScrollAxes() {
        return this.g.getNestedScrollAxes();
    }

    public boolean hasNestedScrollingParent() {
        return this.h.hasNestedScrollingParent();
    }

    public void i(float f10) {
        int n10 = this.u;
        int n11 = (int)((float)(this.v - n10) * f10);
        n10 += n11;
        n11 = this.s.getTop();
        this.setTargetOffsetTopAndBottom(n10 -= n11);
    }

    public boolean isNestedScrollingEnabled() {
        return this.h.isNestedScrollingEnabled();
    }

    public void k() {
        this.s.clearAnimation();
        this.s.setVisibility(8);
        int n10 = this.v;
        int n11 = this.l;
        this.setTargetOffsetTopAndBottom(n10 -= n11);
        this.l = n10 = this.s.getTop();
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.k();
    }

    public boolean onInterceptTouchEvent(MotionEvent object) {
        block5: {
            block9: {
                float f10;
                int n10;
                int n11;
                block6: {
                    block7: {
                        int n12;
                        block8: {
                            this.e();
                            n11 = object.getActionMasked();
                            n10 = this.q;
                            if (n10 != 0 && n11 == 0) {
                                this.q = false;
                            }
                            if ((n10 = this.isEnabled()) == 0 || (n10 = this.q) != 0 || (n10 = this.c()) != 0 || (n10 = this.c) != 0 || (n10 = this.k) != 0) break block5;
                            if (n11 == 0) break block6;
                            n10 = -1;
                            n12 = 1;
                            if (n11 == n12) break block7;
                            int n13 = 2;
                            if (n11 == n13) break block8;
                            n12 = 3;
                            if (n11 == n12) break block7;
                            n10 = 6;
                            if (n11 == n10) {
                                this.j((MotionEvent)object);
                            }
                            break block9;
                        }
                        n11 = this.p;
                        if (n11 == n10) {
                            object = D;
                            Object[] objectArray = new Object[n12];
                            objectArray[0] = "Got ACTION_MOVE event but don't have an active pointer id.";
                            m.a.a.e((String)object, objectArray);
                            return false;
                        }
                        if ((n11 = object.findPointerIndex(n11)) < 0) {
                            return false;
                        }
                        float f11 = object.getY(n11);
                        this.m(f11);
                        break block9;
                    }
                    this.o = false;
                    this.p = n10;
                    break block9;
                }
                n11 = this.v;
                b0 b02 = this.s;
                n10 = b02.getTop();
                this.setTargetOffsetTopAndBottom(n11 -= n10);
                this.p = n11 = object.getPointerId(0);
                this.o = false;
                n11 = object.findPointerIndex(n11);
                if (n11 < 0) {
                    return false;
                }
                this.n = f10 = object.getY(n11);
            }
            return this.o;
        }
        return false;
    }

    public void onLayout(boolean bl2, int n10, int n11, int n12, int n13) {
        int n14 = this.getMeasuredWidth();
        int n15 = this.getMeasuredHeight();
        int n16 = this.getChildCount();
        if (n16 == 0) {
            return;
        }
        View view = this.a;
        if (view == null) {
            this.e();
        }
        if ((view = this.a) == null) {
            return;
        }
        int n17 = this.getPaddingLeft();
        int n18 = this.getPaddingTop();
        int n19 = this.getPaddingLeft();
        n19 = n14 - n19;
        int n20 = this.getPaddingRight();
        n19 -= n20;
        n20 = this.getPaddingTop();
        n15 -= n20;
        n20 = this.getPaddingBottom();
        n15 -= n20;
        n20 = this.y;
        int n21 = this.l;
        n20 = n20 + n21 + n18;
        view.layout(n17, n20, n19 += n17, n18 += n15);
        n15 = this.s.getMeasuredWidth();
        n16 = this.s.getMeasuredHeight();
        b0 b02 = this.s;
        int n22 = n14 / 2;
        n18 = n22 - (n15 /= 2);
        n19 = this.l;
        int n23 = n22 + n15;
        b02.layout(n18, n19, n23, n16 += n19);
    }

    public void onMeasure(int n10, int n11) {
        super.onMeasure(n10, n11);
        Object object = this.a;
        if (object == null) {
            this.e();
        }
        if ((object = this.a) == null) {
            return;
        }
        n11 = this.getMeasuredWidth();
        int n12 = this.getPaddingLeft();
        n11 -= n12;
        n12 = this.getPaddingRight();
        n11 -= n12;
        n12 = 0x40000000;
        n11 = View.MeasureSpec.makeMeasureSpec((int)n11, (int)n12);
        int n13 = this.getMeasuredHeight();
        int n14 = this.getPaddingTop();
        n13 -= n14;
        n14 = this.getPaddingBottom();
        n13 = View.MeasureSpec.makeMeasureSpec((int)(n13 - n14), (int)n12);
        object.measure(n11, n13);
        object = this.s;
        n11 = View.MeasureSpec.makeMeasureSpec((int)this.y, (int)n12);
        n13 = this.y;
        n12 = View.MeasureSpec.makeMeasureSpec((int)n13, (int)n12);
        object.measure(n11, n12);
        this.t = -1;
        object = null;
        for (n10 = 0; n10 < (n11 = this.getChildCount()); ++n10) {
            b0 b02;
            View view = this.getChildAt(n10);
            if (view != (b02 = this.s)) continue;
            this.t = n10;
            break;
        }
    }

    public boolean onNestedFling(View view, float f10, float f11, boolean bl2) {
        return this.dispatchNestedFling(f10, f11, bl2);
    }

    public boolean onNestedPreFling(View view, float f10, float f11) {
        return this.dispatchNestedPreFling(f10, f11);
    }

    public void onNestedPreScroll(View object, int n10, int object2, int[] nArray) {
        float f10;
        int n11;
        float f11;
        float f12;
        float f13;
        float f14;
        Object object3 = 0;
        object = null;
        int n12 = 1;
        if (object2 > 0 && (f14 = (f13 = (f12 = this.f) - 0.0f) == 0.0f ? 0 : (f13 > 0.0f ? 1 : -1)) > 0) {
            f11 = object2;
            float f15 = f11 - f12;
            Object object4 = f15 == 0.0f ? 0 : (f15 > 0.0f ? 1 : -1);
            if (object4 > 0) {
                n11 = (int)f12;
                nArray[n12] = n11 = object2 - n11;
                this.f = 0.0f;
            } else {
                this.f = f12 -= f11;
                nArray[n12] = object2;
            }
            f12 = this.f;
            this.h(f12);
        }
        if (object2 > 0 && (object3 = (f10 = (f12 = this.f) - 0.0f) == 0.0f ? 0 : (f10 > 0.0f ? 1 : -1)) == 0) {
            object3 = nArray[n12];
            if ((object3 = Math.abs(object2 - object3)) > 0) {
                object = this.s;
                n11 = 8;
                f12 = 1.1E-44f;
                object.setVisibility(n11);
            }
        }
        object = this.i;
        n11 = 0;
        f12 = 0.0f;
        f14 = nArray[0];
        n10 -= f14;
        f14 = nArray[n12];
        object2 -= f14;
        f14 = 0.0f;
        f11 = 0.0f;
        if ((n10 = (int)(this.dispatchNestedPreScroll(n10, (int)object2, (int[])object, null) ? 1 : 0)) != 0) {
            n10 = nArray[0];
            object2 = object[0];
            nArray[0] = n10 += object2;
            n10 = nArray[n12];
            object3 = object[n12];
            nArray[n12] = n10 += object3;
        }
    }

    public void onNestedScroll(View object, int n10, int n11, int n12, int n13) {
        int[] nArray = this.j;
        this.dispatchNestedScroll(n10, n11, n12, n13, nArray);
        object = this.j;
        n10 = 1;
        float f10 = Float.MIN_VALUE;
        Object object2 = object[n10];
        if ((n13 += object2) < 0 && (object2 = (Object)this.c()) == false) {
            float f11 = this.f;
            n10 = Math.abs(n13);
            f10 = n10;
            this.f = f11 += f10;
            this.h(f11);
        }
    }

    public void onNestedScrollAccepted(View view, View view2, int n10) {
        this.g.onNestedScrollAccepted(view, view2, n10);
        int n11 = n10 & 2;
        this.startNestedScroll(n11);
        this.f = 0.0f;
        this.k = true;
    }

    public boolean onStartNestedScroll(View view, View view2, int n10) {
        int n11 = this.isEnabled();
        n11 = n11 != 0 && (n11 = this.q) == 0 && (n11 = this.c) == 0 && (n11 = n10 & 2) != 0 ? 1 : 0;
        return n11 != 0;
    }

    public void onStopNestedScroll(View view) {
        this.g.onStopNestedScroll(view);
        view = null;
        this.k = false;
        float f10 = this.f;
        float f11 = f10 - 0.0f;
        float f12 = f11 == 0.0f ? 0 : (f11 > 0.0f ? 1 : -1);
        if (f12 > 0) {
            this.f(f10);
            this.f = 0.0f;
        }
        this.stopNestedScroll();
    }

    /*
     * Enabled aggressive block sorting
     */
    public boolean onTouchEvent(MotionEvent object) {
        int n10 = object.getActionMasked();
        int n11 = this.q;
        int n12 = 0;
        if (n11 != 0 && n10 == 0) {
            this.q = false;
        }
        if ((n11 = this.isEnabled()) == 0) return false;
        n11 = this.q;
        if (n11 != 0) return false;
        n11 = this.c();
        if (n11 != 0) return false;
        n11 = this.c;
        if (n11 != 0) return false;
        n11 = this.k;
        if (n11 != 0) {
            return false;
        }
        n11 = 1;
        if (n10 == 0) {
            int n13;
            this.p = n13 = object.getPointerId(0);
            this.o = false;
            return n11 != 0;
        }
        int n14 = 0x3F000000;
        float f10 = 0.5f;
        if (n10 != n11) {
            int n15 = 2;
            if (n10 != n15) {
                int n16;
                n14 = 3;
                f10 = 4.2E-45f;
                if (n10 == n14) return false;
                n14 = 5;
                f10 = 7.0E-45f;
                if (n10 != n14) {
                    n12 = 6;
                    if (n10 != n12) {
                        return n11 != 0;
                    }
                    this.j((MotionEvent)object);
                    return n11 != 0;
                }
                n10 = object.getActionIndex();
                if (n10 < 0) {
                    String string2 = D;
                    Object[] objectArray = new Object[n11];
                    objectArray[0] = "Got ACTION_POINTER_DOWN event but have an invalid action index.";
                    m.a.a.e(string2, objectArray);
                    return false;
                }
                this.p = n16 = object.getPointerId(n10);
                return n11 != 0;
            }
            n10 = this.p;
            if ((n10 = object.findPointerIndex(n10)) < 0) {
                String string3 = D;
                Object[] objectArray = new Object[n11];
                objectArray[0] = "Got ACTION_MOVE event but have an invalid active pointer id.";
                m.a.a.e(string3, objectArray);
                return false;
            }
            float f11 = object.getY(n10);
            this.m(f11);
            n10 = (int)(this.o ? 1 : 0);
            if (n10 == 0) return n11 != 0;
            float f12 = this.m;
            f11 = (f11 - f12) * f10;
            f12 = 0.0f;
            Object var8_13 = null;
            float f13 = f11 - 0.0f;
            n10 = (int)(f13 == 0.0f ? 0 : (f13 > 0.0f ? 1 : -1));
            if (n10 <= 0) return false;
            this.h(f11);
            return n11 != 0;
        }
        n10 = this.p;
        if ((n10 = object.findPointerIndex(n10)) < 0) {
            String string4 = D;
            Object[] objectArray = new Object[n11];
            objectArray[0] = "Got ACTION_UP event but don't have an active pointer id.";
            m.a.a.e(string4, objectArray);
            return false;
        }
        n11 = this.o;
        if (n11 != 0) {
            float f14 = object.getY(n10);
            float f15 = this.m;
            f14 = (f14 - f15) * f10;
            this.o = false;
            this.f(f14);
        }
        this.p = -1;
        return false;
    }

    public void requestDisallowInterceptTouchEvent(boolean bl2) {
        boolean bl3;
        View view = this.a;
        if (view == null || (bl3 = ViewCompat.isNestedScrollingEnabled(view))) {
            super.requestDisallowInterceptTouchEvent(bl2);
        }
    }

    public void setEnabled(boolean bl2) {
        super.setEnabled(bl2);
        if (!bl2) {
            this.k();
        }
    }

    public void setNestedScrollingEnabled(boolean bl2) {
        this.h.setNestedScrollingEnabled(bl2);
    }

    public void setOnRefreshListener(CEPullToRefreshLayout$d cEPullToRefreshLayout$d) {
        this.b = cEPullToRefreshLayout$d;
    }

    public void setRefreshing(boolean bl2) {
        int n10;
        Animation.AnimationListener animationListener = null;
        if (bl2 && (n10 = this.c) == 0) {
            int n11;
            boolean bl3;
            this.c = bl3 = true;
            n10 = this.w;
            int n12 = this.v;
            n10 += n12;
            n12 = this.l;
            this.setTargetOffsetTopAndBottom(n10 -= n12);
            this.x = bl3;
            this.l = n11 = this.v;
            b0 b02 = this.s;
            b02.setVisibility(0);
            int n13 = this.l;
            animationListener = this.z;
            this.a(n13, animationListener);
        } else {
            this.l(bl2, false);
        }
    }

    public void setTargetOffsetTopAndBottom(int n10) {
        this.s.bringToFront();
        ViewCompat.offsetTopAndBottom((View)this.s, n10);
        this.l = n10 = this.s.getTop();
    }

    public boolean startNestedScroll(int n10) {
        return this.h.startNestedScroll(n10);
    }

    public void stopNestedScroll() {
        this.h.stopNestedScroll();
    }
}

