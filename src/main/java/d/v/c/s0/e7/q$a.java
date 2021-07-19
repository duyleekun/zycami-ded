/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.view.GestureDetector$SimpleOnGestureListener
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.ViewGroup$LayoutParams
 *  android.view.WindowManager$LayoutParams
 *  android.widget.FrameLayout$LayoutParams
 */
package d.v.c.s0.e7;

import android.content.Context;
import android.content.res.Resources;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import com.zhiyun.common.util.Windows;
import d.v.c.s0.e7.o;
import d.v.c.s0.e7.q;
import d.v.e.l.h2;

public class q$a
extends GestureDetector.SimpleOnGestureListener {
    private float a;
    private float b;
    public final /* synthetic */ q c;

    public q$a(q q10) {
        this.c = q10;
    }

    private void a() {
        ViewGroup.LayoutParams layoutParams = q.l((q)this.c).b.getLayoutParams();
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(layoutParams);
        int n10 = layoutParams2.width;
        int n11 = 77;
        if (n10 != n11) {
            q.l((q)this.c).a.setBackgroundResource(2131099771);
            layoutParams2.topMargin = n11 = h2.b(0.0f);
            layoutParams2.leftMargin = n10 = h2.b(0.0f);
            float f10 = 77.0f;
            layoutParams2.width = n11 = h2.b(f10);
            layoutParams2.height = n10 = h2.b(f10);
            layoutParams = q.l((q)this.c).b;
            layoutParams.setLayoutParams((ViewGroup.LayoutParams)layoutParams2);
            layoutParams2 = q.l((q)this.c).b;
            n10 = 2131231157;
            f10 = 1.8078387E38f;
            layoutParams2.setImageResource(n10);
        }
    }

    public boolean onDown(MotionEvent motionEvent) {
        float f10;
        float f11;
        this.b = f11 = motionEvent.getRawX();
        this.a = f10 = motionEvent.getRawY();
        return false;
    }

    public boolean onScroll(MotionEvent object, MotionEvent object2, float f10, float f11) {
        int n10;
        int n11;
        float f12;
        int n12;
        object = q.i(this.c);
        boolean n112 = ((o)object).e();
        if (n112) {
            object = this.c;
            q.j((q)object);
        }
        q.k(this.c);
        object = this.c.d;
        f10 = ((WindowManager.LayoutParams)object).x;
        f11 = object2.getRawX();
        float f13 = this.b;
        ((WindowManager.LayoutParams)object).x = n12 = (int)(f10 + (f11 -= f13));
        object = this.c.d;
        f10 = ((WindowManager.LayoutParams)object).y;
        f11 = object2.getRawY();
        f13 = this.a;
        ((WindowManager.LayoutParams)object).y = n12 = (int)(f10 += (f11 -= f13));
        this.b = f12 = object2.getRawX();
        this.a = f12 = object2.getRawY();
        object = this.c.a.getResources();
        int n13 = Windows.m((Resources)object);
        float f14 = 12.5f;
        int n14 = h2.b(f14);
        int n15 = n13 - n14;
        object2 = this.c;
        WindowManager.LayoutParams layoutParams = ((o)object2).d;
        int n16 = layoutParams.y;
        if (n16 >= n15) {
            n11 = n16;
        }
        layoutParams.y = n11;
        object = Windows.l(((o)object2).a);
        int n17 = object.getHeight();
        f14 = 58.5f;
        n14 = h2.b(f14);
        int n18 = n17 - n14;
        object2 = this.c.a;
        n14 = (int)(h2.c((Context)object2) ? 1 : 0);
        if (n14 != 0) {
            object2 = this.c.a;
            n14 = Windows.h((Context)object2);
        } else {
            n14 = 0;
            f14 = 0.0f;
            object2 = null;
        }
        int n19 = n18 - n14;
        object2 = this.c.d;
        n12 = ((WindowManager.LayoutParams)object2).y;
        if (n12 <= n19) {
            n10 = n12;
        }
        ((WindowManager.LayoutParams)object2).y = n10;
        this.a();
        object = this.c;
        object2 = ((o)object).b;
        layoutParams = ((o)object).c;
        object = ((o)object).d;
        object2.updateViewLayout((View)layoutParams, (ViewGroup.LayoutParams)object);
        return true;
    }

    public boolean onSingleTapUp(MotionEvent object) {
        object = q.i(this.c);
        boolean bl2 = ((o)object).h;
        if (bl2 && (bl2 = ((o)(object = q.i(this.c))).e())) {
            q.j(this.c);
            object = this.c;
            q.k((q)object);
        } else {
            object = this.c;
            WindowManager.LayoutParams layoutParams = ((o)object).d;
            int n10 = layoutParams.x;
            int bl3 = layoutParams.y;
            ((q)object).L(n10, bl3);
            object = this.c;
            boolean bl4 = ((q)object).o;
            ((q)object).I(bl4);
        }
        return true;
    }
}

