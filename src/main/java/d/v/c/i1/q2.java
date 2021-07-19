/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.View$OnTouchListener
 *  android.view.ViewOutlineProvider
 */
package d.v.c.i1;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.lifecycle.MutableLiveData;
import d.v.c.i1.c2;
import d.v.c.i1.d2;
import d.v.c.i1.q2$b;
import d.v.c.i1.r2;
import d.v.c.w0.ge;
import d.v.e.h.a;
import d.v.e.l.h2;
import d.v.e.l.m2;
import d.v.e.l.m2$d;

public class q2 {
    private final r2 a;
    private int b;
    private int c;
    private int d;
    private int e;
    private int f;
    private long g;
    private m2$d h;
    private boolean i = false;

    public q2(ge ge2, r2 object) {
        this.a = object;
        object = ge2.f;
        c2 c22 = new c2(this, ge2);
        object.post(c22);
        ge2 = ge2.c;
        super(this);
        ge2.setOutlineProvider((ViewOutlineProvider)object);
    }

    public static /* synthetic */ m2$d a(q2 q22) {
        return q22.h;
    }

    public static /* synthetic */ m2$d b(q2 q22, m2$d m2$d) {
        q22.h = m2$d;
        return m2$d;
    }

    public static /* synthetic */ int c(q2 q22) {
        return q22.e;
    }

    public static /* synthetic */ int d(q2 q22, int n10) {
        q22.e = n10;
        return n10;
    }

    public static /* synthetic */ int e(q2 q22) {
        return q22.f;
    }

    public static /* synthetic */ int f(q2 q22, int n10) {
        q22.f = n10;
        return n10;
    }

    public static /* synthetic */ long g(q2 q22) {
        return q22.g;
    }

    public static /* synthetic */ long h(q2 q22, long l10) {
        q22.g = l10;
        return l10;
    }

    public static /* synthetic */ r2 i(q2 q22) {
        return q22.a;
    }

    public static /* synthetic */ int j(q2 q22) {
        return q22.b;
    }

    public static /* synthetic */ int k(q2 q22) {
        return q22.c;
    }

    public static /* synthetic */ void l(q2 q22, View view) {
        q22.n(view);
    }

    public static /* synthetic */ int m(q2 q22) {
        return q22.d;
    }

    private void n(View view) {
        m2.a(this.h);
        Object object = (Boolean)this.a.n.getValue();
        int n10 = d.v.e.h.a.c((Boolean)object);
        if (n10 != 0) {
            object = this.a.n;
            Boolean bl2 = Boolean.FALSE;
            ((MutableLiveData)object).setValue(bl2);
            object = this.a;
            int n11 = ((r2)object).q;
            int n12 = this.d;
            int n13 = n12 / 2;
            n11 += n13;
            n13 = this.b;
            int n14 = n13 / 2;
            float f10 = 12.0f;
            if (n11 < n14) {
                ((r2)object).q = n11 = -h2.b(f10);
                object = this.a;
                n11 = this.d;
                n12 = h2.b(f10);
                ((r2)object).r = n11 -= n12;
            } else {
                n13 -= n12;
                n11 = h2.b(f10);
                ((r2)object).q = n13 += n11;
                object = this.a;
                n11 = this.b;
                n12 = h2.b(f10);
                ((r2)object).r = n11 += n12;
            }
            object = this.a;
            n10 = ((r2)object).q;
            n11 = view.getTop();
            r2 r22 = this.a;
            n12 = r22.r;
            n13 = view.getBottom();
            view.layout(n10, n11, n12, n13);
        }
    }

    private void o(ge ge2) {
        boolean bl2 = this.i;
        if (bl2) {
            return;
        }
        this.i = true;
        Object object = ge2.f;
        d2 d22 = new d2(this);
        object.setOnTouchListener((View.OnTouchListener)d22);
        ge2 = ge2.c;
        object = new q2$b(this);
        ge2.setOnTouchListener((View.OnTouchListener)object);
    }

    private /* synthetic */ boolean p(View view, MotionEvent motionEvent) {
        view = view.findViewById(2131362492);
        this.n(view);
        return false;
    }

    private /* synthetic */ void r(ge ge2) {
        int n10;
        this.b = n10 = ge2.f.getWidth();
        this.c = n10 = ge2.f.getHeight();
        this.d = n10 = ge2.c.getWidth();
        this.o(ge2);
    }

    public /* synthetic */ boolean q(View view, MotionEvent motionEvent) {
        return this.p(view, motionEvent);
    }

    public /* synthetic */ void s(ge ge2) {
        this.r(ge2);
    }
}

