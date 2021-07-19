/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.drawable.Drawable
 *  android.util.AttributeSet
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.View$OnScrollChangeListener
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.HorizontalScrollView
 *  android.widget.LinearLayout
 */
package com.zhiyun.cama.camera.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import com.zhiyun.cama.camera.widget.ModeSwitch$b;
import d.v.c.s0.i7.c;
import d.v.c.s0.i7.d;
import d.v.c.s0.i7.e;
import d.v.c.s0.i7.f;
import d.v.c.s0.i7.g;
import d.v.e.l.h2;
import java.util.List;
import l.a.q.c0;
import l.a.q.m;
import l.a.q.z;

public class ModeSwitch
extends HorizontalScrollView
implements z {
    private int a;
    private int b = 0;
    private boolean c = false;
    private ModeSwitch$b d;
    private boolean e;
    private boolean f;
    private Runnable g;
    private LinearLayout h;
    private View i;
    private View j;
    private List k;

    public ModeSwitch(Context context) {
        this(context, null);
    }

    public ModeSwitch(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ModeSwitch(Context object, AttributeSet attributeSet, int n10) {
        super(object, attributeSet, n10);
        boolean bl2;
        this.e = bl2 = true;
        this.f = bl2;
        super(this);
        this.g = object;
        this.m();
    }

    private void A(HorizontalScrollView horizontalScrollView, View view) {
        int n10 = horizontalScrollView.getWidth();
        int n11 = view.getWidth();
        float f10 = (float)(n10 + n11) * 1.0f / 2.0f;
        int n12 = view.getRight();
        n10 = (int)f10;
        horizontalScrollView.smoothScrollTo(n12 -= n10, 0);
    }

    private void B() {
        Runnable runnable = this.g;
        this.removeCallbacks(runnable);
        runnable = this.g;
        this.postDelayed(runnable, 100);
    }

    public static /* synthetic */ int a(ModeSwitch modeSwitch) {
        return modeSwitch.a;
    }

    public static /* synthetic */ LinearLayout b(ModeSwitch modeSwitch) {
        return modeSwitch.h;
    }

    public static /* synthetic */ View c(ModeSwitch modeSwitch, ViewGroup viewGroup, int n10) {
        return modeSwitch.l(viewGroup, n10);
    }

    public static /* synthetic */ void d(ModeSwitch modeSwitch, HorizontalScrollView horizontalScrollView, View view) {
        modeSwitch.A(horizontalScrollView, view);
    }

    public static /* synthetic */ int f(ModeSwitch modeSwitch) {
        return modeSwitch.b;
    }

    public static /* synthetic */ int g(ModeSwitch modeSwitch, int n10) {
        modeSwitch.b = n10;
        return n10;
    }

    public static /* synthetic */ void h(ModeSwitch modeSwitch) {
        modeSwitch.z();
    }

    public static /* synthetic */ ModeSwitch$b i(ModeSwitch modeSwitch) {
        return modeSwitch.d;
    }

    private void j() {
        this.c = true;
        int n10 = this.getDataSize();
        if (n10 == 0) {
            return;
        }
        d d10 = new d(this);
        this.post(d10);
    }

    private Drawable k(int n10, boolean bl2) {
        int n11 = bl2 ? 2131231633 : 2131230821;
        int n12 = 1;
        if (n12 == n10) {
            n10 = bl2 ? 2131231023 : 2131230817;
            n11 = n10;
        }
        return d.v.f.i.g.f(this.getContext(), n11);
    }

    private View l(ViewGroup viewGroup, int n10) {
        View view;
        block2: {
            int n11 = viewGroup.getChildCount();
            for (int i10 = 0; i10 < n11; ++i10) {
                view = viewGroup.getChildAt(i10);
                boolean bl2 = this.o(view, n10);
                if (!bl2) {
                    continue;
                }
                break block2;
            }
            view = null;
        }
        return view;
    }

    private void m() {
        Object object;
        Context context = this.getContext();
        this.h = object = new LinearLayout(context);
        object.setOrientation(0);
        object = new ViewGroup.LayoutParams(-1, -2);
        Context context2 = this.getContext();
        context = new View(context2);
        this.i = context;
        context2 = this.getContext();
        context = new View(context2);
        this.j = context;
        context = this.h;
        context2 = this.i;
        context.addView((View)context2);
        context = this.h;
        context2 = this.j;
        context.addView((View)context2);
        context = this.h;
        this.addView((View)context, (ViewGroup.LayoutParams)object);
        this.j();
        object = new f(this);
        this.setOnScrollChangeListener((View.OnScrollChangeListener)object);
    }

    private boolean n(int n10) {
        int n11 = 1;
        if (n10 != 0 && n11 != n10) {
            n11 = 0;
        }
        return n11 != 0;
    }

    private boolean o(View view, int n10) {
        boolean bl2 = false;
        if (view == null) {
            return false;
        }
        int n11 = view.getLeft();
        int n12 = view.getRight();
        if (n10 >= n11 && n10 <= n12) {
            bl2 = true;
        }
        return bl2;
    }

    private /* synthetic */ void p() {
        ViewGroup.LayoutParams layoutParams = this.i.getLayoutParams();
        Object object = this.j.getLayoutParams();
        int n10 = this.getWidth();
        int n11 = this.h.getChildAt(1).getWidth();
        float f10 = n10 - n11;
        float f11 = 1.0f;
        float f12 = 2.0f;
        layoutParams.width = n10 = (int)((f10 *= f11) / f12);
        n10 = this.getWidth();
        LinearLayout linearLayout = this.h;
        int n12 = this.getDataSize();
        int n13 = linearLayout.getChildAt(n12).getWidth();
        object.width = n10 = (int)((float)(n10 - n13) * f11 / f12);
        this.i.setLayoutParams(layoutParams);
        this.j.setLayoutParams(object);
        layoutParams = this.j;
        object = new e(this);
        layoutParams.post((Runnable)object);
    }

    private /* synthetic */ void r(View view, int n10, int n11, int n12, int n13) {
        this.a = n10;
        boolean bl2 = this.c;
        if (!bl2) {
            this.B();
        }
    }

    private /* synthetic */ void t() {
        this.c = false;
        LinearLayout linearLayout = this.h;
        int n10 = this.b;
        linearLayout = linearLayout.getChildAt(n10);
        this.A(this, (View)linearLayout);
    }

    private /* synthetic */ void v(m m10, View view) {
        this.A(this, (View)m10);
    }

    private /* synthetic */ void x(c0 c02, View view) {
        this.A(this, (View)c02);
    }

    private void z() {
        int n10;
        int n11 = 0;
        Drawable drawable2 = null;
        while (n11 < (n10 = this.getDataSize())) {
            int n12;
            float f10;
            Object object = this.h;
            int n13 = n11 + 1;
            object = object.getChildAt(n13);
            int n14 = this.b;
            int n15 = 1;
            if ((n14 -= n15) == n11) {
                object.setVisibility(0);
                n14 = 2131099702;
                f10 = 1.7811765E38f;
                n12 = 2131099705;
            } else {
                n14 = (int)(this.e ? 1 : 0);
                if (n14 != 0) {
                    n14 = 0;
                    f10 = 0.0f;
                } else {
                    n14 = 4;
                    f10 = 5.6E-45f;
                }
                object.setVisibility(n14);
                n14 = 2131099696;
                f10 = 1.7811752E38f;
                n12 = 2131099699;
            }
            boolean bl2 = object instanceof c0;
            if (bl2) {
                Object object2 = object;
                object2 = (c0)object;
                n14 = d.v.f.i.g.c(this.getContext(), n14);
                object2.setTextColor(n14);
                n14 = h2.b(2.0f);
                f10 = n14;
                n12 = d.v.f.i.g.c(this.getContext(), n12);
                object2.setShadowLayer(f10, 0.0f, 0.0f, n12);
            }
            if ((n14 = object instanceof m) != 0) {
                object = (m)object;
                n14 = this.b - n15;
                if (n14 != n11) {
                    n15 = 0;
                }
                drawable2 = this.k(n11, n15 != 0);
                ((AppCompatImageView)object).setImageDrawable(drawable2);
            }
            n11 = n13;
        }
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean bl2 = this.e;
        if (bl2 && (bl2 = this.f)) {
            return super.dispatchTouchEvent(motionEvent);
        }
        return true;
    }

    public void e() {
        this.z();
    }

    public int getDataSize() {
        List list = this.k;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public int getSelected() {
        return this.b + -1;
    }

    public /* synthetic */ void q() {
        this.p();
    }

    public /* synthetic */ void s(View view, int n10, int n11, int n12, int n13) {
        this.r(view, n10, n11, n12, n13);
    }

    public void setData(List list) {
        int n10;
        if (list != null && (n10 = list.isEmpty()) == 0) {
            this.k = list;
            this.h.removeAllViews();
            LinearLayout linearLayout = this.h;
            View view = this.i;
            linearLayout.addView(view);
            linearLayout = this.h;
            linearLayout.setGravity(16);
            n10 = list.size();
            view = null;
            for (int i10 = 0; i10 < n10; ++i10) {
                Object object;
                int n11;
                float f10;
                z z10;
                Object object2;
                boolean bl2 = this.n(i10);
                int n12 = 1097859072;
                float f11 = 15.0f;
                if (bl2) {
                    object2 = this.getContext();
                    z10 = new m((Context)object2);
                    f10 = Float.MIN_VALUE;
                    object2 = this.k(i10, true);
                    ((AppCompatImageView)((Object)z10)).setImageDrawable((Drawable)object2);
                    object2 = this.h;
                    object2.addView((View)z10);
                    n11 = h2.b(f11);
                    n12 = h2.b(f11);
                    z10.setPadding(n11, 0, n12, 0);
                    object = new g(this, (m)z10);
                    z10.setOnClickListener((View.OnClickListener)object);
                    continue;
                }
                object2 = this.getContext();
                z10 = new c0((Context)object2);
                z10.setGravity(17);
                n11 = d.v.f.i.g.c(this.getContext(), 2131099696);
                z10.setTextColor(n11);
                object2 = (CharSequence)list.get(i10);
                z10.setText((CharSequence)object2);
                z10.setTextSize(14.0f);
                f10 = h2.b(2.0f);
                Context context = this.getContext();
                int n13 = d.v.f.i.g.c(context, 2131099699);
                z10.setShadowLayer(f10, 0.0f, 0.0f, n13);
                n11 = h2.b(f11);
                n12 = h2.b(f11);
                z10.setPadding(n11, 0, n12, 0);
                this.h.addView((View)z10);
                object = new c(this, (c0)z10);
                z10.setOnClickListener((View.OnClickListener)object);
            }
            list = this.h;
            linearLayout = this.j;
            list.addView((View)linearLayout);
            this.j();
        }
    }

    public void setOnSelectListener(ModeSwitch$b modeSwitch$b) {
        this.d = modeSwitch$b;
    }

    public void setScrollEnable(boolean n10) {
        int n11 = this.e;
        if (n11 != n10 && (n11 = this.getDataSize()) != 0) {
            this.e = n10;
            this.z();
        }
    }

    public void setSelected(int n10) {
        int n11;
        if (n10 >= 0 && n10 <= (n11 = this.getDataSize() + -1)) {
            this.b = ++n10;
            LinearLayout linearLayout = this.h;
            View view = linearLayout.getChildAt(n10);
            this.A(this, view);
            this.z();
        }
    }

    public void setTouchable(boolean bl2) {
        this.f = bl2;
    }

    public /* synthetic */ void u() {
        this.t();
    }

    public /* synthetic */ void w(m m10, View view) {
        this.v(m10, view);
    }

    public /* synthetic */ void y(c0 c02, View view) {
        this.x(c02, view);
    }
}

