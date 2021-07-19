/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.media.AudioManager
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.View$OnScrollChangeListener
 *  android.view.View$OnTouchListener
 *  android.view.ViewGroup$LayoutParams
 */
package com.zhiyun.cama.voice.record;

import android.content.Context;
import android.media.AudioManager;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$ItemDecoration;
import androidx.recyclerview.widget.RecyclerView$LayoutManager;
import com.zhiyun.cama.voice.record.EditorRecordFragment$a;
import com.zhiyun.cama.voice.record.EditorRecordFragment$b;
import com.zhiyun.cama.voice.record.TimelineAdapter;
import com.zhiyun.common.util.Windows;
import d.v.c.b2.t;
import d.v.c.i1.i2;
import d.v.c.w0.l7;
import d.v.c.y1.g.a;
import d.v.c.y1.g.b;
import d.v.c.y1.g.d;
import d.v.c.y1.g.e;
import d.v.c.y1.g.f;
import d.v.c.y1.g.g;
import d.v.c.y1.g.l;
import d.v.c.y1.g.o.c;
import d.v.e.l.h2;
import d.v.h.h.a$a;
import d.v.v.q.h;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class EditorRecordFragment
extends d.v.c.q0.d {
    private static final long t = 1000000L;
    private l7 j;
    private l k;
    private c l;
    private AudioManager m;
    private int n = 0;
    private boolean o = false;
    private long p;
    private int q;
    private d.v.c.x0.a r;
    private boolean s;

    public static /* synthetic */ c A(EditorRecordFragment editorRecordFragment, c c10) {
        editorRecordFragment.l = c10;
        return c10;
    }

    public static /* synthetic */ d.v.c.b1.t.g B(EditorRecordFragment editorRecordFragment) {
        return editorRecordFragment.g;
    }

    public static /* synthetic */ d.v.c.b1.t.g C(EditorRecordFragment editorRecordFragment) {
        return editorRecordFragment.g;
    }

    public static /* synthetic */ d.v.c.b1.t.g D(EditorRecordFragment editorRecordFragment) {
        return editorRecordFragment.g;
    }

    public static /* synthetic */ d.v.c.b1.t.g E(EditorRecordFragment editorRecordFragment) {
        return editorRecordFragment.g;
    }

    public static /* synthetic */ d.v.c.b1.t.g F(EditorRecordFragment editorRecordFragment) {
        return editorRecordFragment.g;
    }

    public static /* synthetic */ d.v.c.b1.t.g G(EditorRecordFragment editorRecordFragment) {
        return editorRecordFragment.g;
    }

    public static /* synthetic */ d.v.c.b1.t.g H(EditorRecordFragment editorRecordFragment) {
        return editorRecordFragment.g;
    }

    public static /* synthetic */ d.v.c.b1.t.g I(EditorRecordFragment editorRecordFragment) {
        return editorRecordFragment.g;
    }

    public static /* synthetic */ void J(EditorRecordFragment editorRecordFragment, long l10) {
        editorRecordFragment.w(l10);
    }

    public static /* synthetic */ l7 K(EditorRecordFragment editorRecordFragment) {
        return editorRecordFragment.j;
    }

    public static /* synthetic */ d.v.c.b1.t.g L(EditorRecordFragment editorRecordFragment) {
        return editorRecordFragment.g;
    }

    public static /* synthetic */ boolean M(EditorRecordFragment editorRecordFragment, boolean bl2) {
        editorRecordFragment.o = bl2;
        return bl2;
    }

    public static /* synthetic */ void N(EditorRecordFragment editorRecordFragment, boolean bl2) {
        editorRecordFragment.m0(bl2);
    }

    public static /* synthetic */ d.v.c.b1.t.g O(EditorRecordFragment editorRecordFragment) {
        return editorRecordFragment.g;
    }

    public static /* synthetic */ boolean P(EditorRecordFragment editorRecordFragment) {
        return editorRecordFragment.s;
    }

    public static /* synthetic */ boolean Q(EditorRecordFragment editorRecordFragment, boolean bl2) {
        editorRecordFragment.s = bl2;
        return bl2;
    }

    public static /* synthetic */ d.v.c.x0.a R(EditorRecordFragment editorRecordFragment) {
        return editorRecordFragment.r;
    }

    public static /* synthetic */ d.v.c.b1.t.g S(EditorRecordFragment editorRecordFragment) {
        return editorRecordFragment.g;
    }

    private void T() {
        int n10;
        long l10;
        Object object;
        this.m = object = (AudioManager)d.v.e.f.a().b().getSystemService("audio");
        object = new d.v.c.x0.a();
        this.r = object;
        object = this.k.d();
        Integer n11 = (int)(this.g.z() ? 1 : 0);
        d.v.e.i.h.g((MutableLiveData)object, n11);
        this.p = l10 = this.g.d2();
        double d10 = l10;
        double d11 = 4.0E-4;
        this.q = n10 = (int)(d10 * d11);
        this.W();
        this.V();
        this.X();
        n10 = (int)((double)h.n() * d11);
        n11 = this.j.d;
        f f10 = new f(this, n10);
        n11.post(f10);
        this.s = false;
    }

    private void U() {
        Object object = this.k.d();
        Object object2 = this.getViewLifecycleOwner();
        Observer observer = new b(this);
        ((LiveData)object).observe((LifecycleOwner)object2, observer);
        object = this.k.b();
        object2 = new d.v.c.y1.g.c(this);
        ((LiveData)object).observe(this, (Observer)object2);
        object = this.g;
        object2 = new EditorRecordFragment$a(this);
        ((i2)object).s3((a$a)object2);
        object = this.j.d;
        object2 = new e(this);
        object.setOnScrollChangeListener((View.OnScrollChangeListener)object2);
        object = this.g.T0();
        object2 = this.getViewLifecycleOwner();
        observer = new a(this);
        ((LiveData)object).observe((LifecycleOwner)object2, observer);
        object = this.j.d;
        object2 = new d(this);
        object.setOnTouchListener((View.OnTouchListener)object2);
        object = this.j.f;
        object2 = d.v.c.y1.g.g.a;
        object.setOnTouchListener((View.OnTouchListener)object2);
    }

    private void V() {
        EditorRecordFragment editorRecordFragment = this;
        Object object = this.j.e.getLayoutParams();
        int n10 = this.q;
        int n11 = Windows.l(this.requireContext()).getWidth();
        ((ViewGroup.LayoutParams)object).width = n10 += n11;
        float f10 = 54.0f;
        ((ViewGroup.LayoutParams)object).height = n10 = h2.b(f10);
        this.j.e.setLayoutParams((ViewGroup.LayoutParams)object);
        object = new ArrayList();
        Object object2 = this.g.O1();
        Object object3 = new ArrayList(object2);
        object2 = this.k;
        ((l)object2).p((List)object3);
        object3 = object3.iterator();
        while ((n11 = (int)(object3.hasNext() ? 1 : 0)) != 0) {
            d.v.c.y1.g.m.b b10;
            object2 = (d.v.h.h.b)object3.next();
            long l10 = ((d.v.h.h.b)object2).d();
            long l11 = ((d.v.h.h.b)object2).m();
            long l12 = ((d.v.h.h.b)object2).f();
            String string2 = ((d.v.h.h.b)object2).k();
            Object object4 = b10;
            b10 = new d.v.c.y1.g.m.b(l10, l11, l12, string2);
            String string3 = ((d.v.h.h.b)object2).k();
            long l13 = ((d.v.h.h.b)object2).m();
            long l14 = ((d.v.h.h.b)object2).f();
            l10 = ((d.v.h.h.b)object2).e();
            double d10 = l10;
            l11 = 4556014321273684781L;
            double d11 = 4.0E-4;
            n11 = (int)(d10 *= d11);
            object4 = new d.v.c.b2.w.l.c(string3, l13, l14, n11);
            b10.j((d.v.c.b2.w.l.c)object4);
            object.add(b10);
        }
        editorRecordFragment.j.e.e((List)object);
    }

    private void W() {
        List list = this.g.C1();
        this.j.g.setData(list);
    }

    private void X() {
        ArrayList<Object> arrayList = new ArrayList<Object>();
        long l10 = this.p;
        long l11 = 1000000L;
        int n10 = (int)(l10 /= l11);
        int n11 = 1;
        for (int i10 = 0; i10 < (n10 += n11); ++i10) {
            Object object = new BigDecimal(i10);
            int n12 = 4;
            object = ((BigDecimal)object).setScale(n11, n12).toString();
            arrayList.add(object);
        }
        TimelineAdapter timelineAdapter = new TimelineAdapter(arrayList);
        this.j.f.setAdapter(timelineAdapter);
    }

    private void Y() {
        RecyclerView recyclerView = this.j.f;
        Context context = this.getContext();
        Object object = new t(context, 1, 2131232218);
        recyclerView.addItemDecoration((RecyclerView$ItemDecoration)object);
        recyclerView = this.j.f;
        context = this.getContext();
        object = new LinearLayoutManager(context, 0, false);
        recyclerView.setLayoutManager((RecyclerView$LayoutManager)object);
    }

    private /* synthetic */ void Z(int n10) {
        this.j.d.scrollTo(n10, 0);
    }

    private /* synthetic */ void b0(Integer object) {
        int n10 = (Integer)object;
        int n11 = 1;
        int n12 = 2;
        if (n10 == n12) {
            object = this.g;
            ((i2)object).M3(false);
            this.o = n11;
        } else {
            int n13 = (Integer)object;
            if (n13 == n11) {
                this.o = false;
                object = this.g;
                ((i2)object).M3(n11 != 0);
            }
        }
    }

    private /* synthetic */ void d0(Boolean objectArray) {
        int n10 = (int)(objectArray.booleanValue() ? 1 : 0);
        if (n10 != 0) {
            n10 = 1;
            this.m0(n10 != 0);
            this.g.B3();
            objectArray = new Object[n10];
            long l10 = h.n();
            Long l11 = l10;
            objectArray[0] = l11;
            String string2 = "current position = %s";
            m.a.a.b(string2, objectArray);
        }
    }

    private /* synthetic */ void f0(View view, int n10, int n11, int n12, int n13) {
        int n14 = this.n;
        if (n14 != n10) {
            n14 = n10 - n12;
            this.j.g.scrollBy(n14, n11);
            RecyclerView recyclerView = this.j.f;
            recyclerView.scrollBy(n14, n11);
            this.n0(n10);
            this.n = n10;
        }
    }

    private /* synthetic */ void h0(Long object) {
        long l10 = h.n();
        double d10 = l10;
        double d11 = 4.0E-4;
        int n10 = (int)(d10 *= d11);
        Object object2 = this.j.d;
        object2.scrollTo(n10, 0);
        object = this.k.e();
        n10 = (Integer)object;
        int n11 = 1;
        if (n10 == n11 || (n10 = ((Integer)(object = this.k.e())).intValue()) == 0) {
            object = this.k.d();
            n11 = (int)(this.g.z() ? 1 : 0);
            object2 = n11;
            d.v.e.i.h.g((MutableLiveData)object, object2);
        }
    }

    private /* synthetic */ boolean j0(View view, MotionEvent motionEvent) {
        return this.o;
    }

    public static /* synthetic */ boolean l0(View view, MotionEvent motionEvent) {
        return true;
    }

    /*
     * WARNING - void declaration
     */
    private void m0(boolean bl2) {
        void var1_4;
        AudioManager audioManager = this.m;
        if (bl2) {
            int n10 = -100;
        } else {
            int n11 = 100;
        }
        audioManager.adjustStreamVolume(3, (int)var1_4, 0);
    }

    private void n0(int n10) {
        block3: {
            Object object;
            long l10;
            block2: {
                long l11;
                l10 = n10 * 2500;
                object = this.g.y1();
                n10 = (int)(((Boolean)object).booleanValue() ? 1 : 0);
                if (n10 == 0) break block2;
                long l12 = h.n();
                long l13 = (l12 = Math.abs(l10 - l12)) - (l11 = 50000L);
                n10 = (int)(l13 == 0L ? 0 : (l13 < 0L ? -1 : 1));
                if (n10 <= 0) break block3;
            }
            object = this.g;
            ((i2)object).a3(l10);
        }
    }

    public static /* synthetic */ l x(EditorRecordFragment editorRecordFragment) {
        return editorRecordFragment.k;
    }

    public static /* synthetic */ c y(EditorRecordFragment editorRecordFragment) {
        return editorRecordFragment.l;
    }

    public static /* synthetic */ d.v.c.b1.t.g z(EditorRecordFragment editorRecordFragment) {
        return editorRecordFragment.g;
    }

    public /* synthetic */ void a0(int n10) {
        this.Z(n10);
    }

    public /* synthetic */ void c0(Integer n10) {
        this.b0(n10);
    }

    public /* synthetic */ void e0(Boolean bl2) {
        this.d0(bl2);
    }

    public /* synthetic */ void g0(View view, int n10, int n11, int n12, int n13) {
        this.f0(view, n10, n11, n12, n13);
    }

    public int h() {
        return 2131558580;
    }

    public void i(ViewDataBinding object) {
        super.i((ViewDataBinding)object);
        object = (l7)object;
        this.j = object;
        this.k = object = (l)d.v.i0.b.a(this).get(l.class);
        this.j.D((l)object);
        object = this.j;
        Object object2 = this.g;
        ((l7)object).C((i2)object2);
        object = this.j;
        object2 = new EditorRecordFragment$b(this);
        ((l7)object).B((EditorRecordFragment$b)object2);
        this.Y();
        this.T();
        this.U();
    }

    public /* synthetic */ void i0(Long l10) {
        this.h0(l10);
    }

    public /* synthetic */ boolean k0(View view, MotionEvent motionEvent) {
        return this.j0(view, motionEvent);
    }

    public void onAttach(Context context) {
        super.onAttach(context);
    }

    public void onDestroy() {
        super.onDestroy();
        d.v.c.b1.t.g g10 = this.g;
        boolean bl2 = g10.m2();
        if (bl2) {
            g10 = this.g;
            g10.G();
        }
        this.g.M3(true);
        this.m0(false);
        this.g.s3(null);
    }

    public void r() {
    }

    public boolean s(int n10) {
        this.j.u().g(n10);
        return true;
    }
}

