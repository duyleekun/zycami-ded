/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Bundle
 *  android.text.TextUtils
 *  android.view.MotionEvent
 *  android.view.View
 *  android.widget.PopupWindow$OnDismissListener
 */
package com.zhiyun.cama.mediacontent.media;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.PopupWindow;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.ItemTouchHelper$Callback;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$Adapter;
import androidx.recyclerview.widget.RecyclerView$ItemDecoration;
import androidx.recyclerview.widget.RecyclerView$LayoutManager;
import com.zhiyun.account.widget.StatusView;
import com.zhiyun.cama.mediacontent.media.AddVideoFragment$a;
import com.zhiyun.cama.mediacontent.media.AddVideoFragment$b;
import com.zhiyun.common.util.Windows;
import com.zhiyun.editorinterface.edit.MediaType;
import d.v.c.i1.k2;
import d.v.c.k1.a.c;
import d.v.c.k1.a.d;
import d.v.c.k1.a.e;
import d.v.c.k1.a.f;
import d.v.c.k1.a.i;
import d.v.c.k1.a.j;
import d.v.c.k1.a.k;
import d.v.c.k1.a.r;
import d.v.c.k1.a.s;
import d.v.c.k1.a.u;
import d.v.c.k1.a.v;
import d.v.c.k1.a.w;
import d.v.c.w0.v6;
import d.v.e.i.h;
import d.v.e.l.h2;
import d.v.e.l.n2;
import d.v.e.l.s1;
import d.v.f.i.g;
import d.v.g0.n$a;
import d.v.h.e.a;
import d.v.i0.b;
import d.v.j.e.i.f1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AddVideoFragment
extends d.v.c.q0.d {
    private static final String t = "templateDataID";
    private static final String u = "add_video_type";
    private static final String v = "max_count_selected";
    private static final String w = "media_type_load";
    private long j;
    private int k = -1;
    private v6 l;
    private w m;
    private int n = 0;
    private v o;
    private u p;
    private int q;
    private int r;
    private boolean s;

    public static /* synthetic */ w A(AddVideoFragment addVideoFragment) {
        return addVideoFragment.m;
    }

    public static /* synthetic */ u B(AddVideoFragment addVideoFragment) {
        return addVideoFragment.p;
    }

    public static Bundle D(long l10) {
        Bundle bundle = new Bundle();
        bundle.putString(u, "template");
        bundle.putLong(t, l10);
        return bundle;
    }

    public static Bundle E(String string2, int n10) {
        Bundle bundle = new Bundle();
        bundle.putString(u, string2);
        bundle.putInt(v, n10);
        return bundle;
    }

    private void G() {
        int n10 = 0;
        Object object = null;
        this.n = 0;
        Object object2 = this.getArguments();
        if (object2 != null) {
            Object object3;
            String string2 = "";
            String string3 = object2.getString(u, string2);
            int n11 = -1;
            int n12 = string3.hashCode();
            int n13 = 5;
            int n14 = 4;
            int n15 = 3;
            int n16 = 2;
            int n17 = 1;
            switch (n12) {
                default: {
                    break;
                }
                case 1438273625: {
                    String string4 = "autoEdit";
                    object3 = string3.equals(string4);
                    if (object3 == 0) break;
                    n11 = n16;
                    break;
                }
                case 3305108: {
                    String string5 = "kwai";
                    object3 = string3.equals(string5);
                    if (object3 == 0) break;
                    n11 = n17;
                    break;
                }
                case -993422309: {
                    String string6 = "autoEditReplace";
                    object3 = string3.equals(string6);
                    if (object3 == 0) break;
                    n11 = n15;
                    break;
                }
                case -1307827859: {
                    String string7 = "editor";
                    object3 = string3.equals(string7);
                    if (object3 == 0) break;
                    n11 = n13;
                    break;
                }
                case -1321546630: {
                    String string8 = "template";
                    object3 = string3.equals(string8);
                    if (object3 == 0) break;
                    n11 = 0;
                    string2 = null;
                    break;
                }
                case -1930524457: {
                    String string9 = "cloudEngine";
                    object3 = string3.equals(string9);
                    if (object3 == 0) break;
                    n11 = n14;
                }
            }
            string3 = t;
            if (n11 != 0) {
                if (n11 != n17) {
                    if (n11 != n16) {
                        if (n11 != n15) {
                            if (n11 != n14) {
                                this.n = 0;
                            } else {
                                long l10;
                                this.n = n13;
                                this.j = l10 = object2.getLong(string3);
                                string3 = w;
                                this.r = object3 = object2.getInt(string3);
                            }
                        } else {
                            this.n = n14;
                        }
                    } else {
                        this.n = n15;
                    }
                } else {
                    this.n = n16;
                }
            } else {
                long l11;
                this.j = l11 = object2.getLong(string3);
                long l12 = 0L;
                long l13 = l11 - l12;
                object3 = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
                if (object3 != 0) {
                    this.n = n17;
                }
            }
            string3 = v;
            this.q = n10 = object2.getInt(string3, 0);
        }
        object = this.m;
        int n18 = this.n;
        ((w)object).I(n18);
        object = this.l;
        object2 = this.n;
        ((v6)object).D((Integer)object2);
    }

    private void H() {
        Object object = this.m.w();
        Object object2 = this.getViewLifecycleOwner();
        Observer observer = new k(this);
        ((LiveData)object).observe((LifecycleOwner)object2, observer);
        object = this.m.x();
        object2 = this.getViewLifecycleOwner();
        observer = new d.v.c.k1.a.g(this);
        ((LiveData)object).observe((LifecycleOwner)object2, observer);
        object = this.o;
        object2 = new c(this);
        ((v)object).r((d.v.f.f.c)object2);
        object = this.m.A();
        object2 = this.getViewLifecycleOwner();
        observer = new d.v.c.k1.a.b(this);
        ((LiveData)object).observe((LifecycleOwner)object2, observer);
    }

    private void I() {
        r r10;
        this.G();
        Object object = this.m;
        Object object2 = new u((LifecycleOwner)this, (w)object);
        this.p = object2;
        object = new d.v.c.k1.a.a(this);
        ((d.v.f.d.b)object2).n((d.v.f.f.b)object);
        float f10 = 4.0f;
        int n10 = h2.b(f10);
        object2 = this.l.h;
        object = r10;
        r10 = new r(3, n10, false, 0, 0);
        ((RecyclerView)object2).addItemDecoration(r10);
        object2 = this.l.h;
        Object object3 = this.getContext();
        n10 = 3;
        object = new GridLayoutManager((Context)object3, n10);
        ((RecyclerView)object2).setLayoutManager((RecyclerView$LayoutManager)object);
        object2 = this.l.h;
        object = this.p;
        ((RecyclerView)object2).setAdapter((RecyclerView$Adapter)object);
        object2 = this.m.y();
        object = new e(this);
        ((LiveData)object2).observe(this, (Observer)object);
        object2 = this.l;
        object = MediaType.ALL;
        ((v6)object2).F((MediaType)((Object)object));
        object2 = this.m;
        int n11 = this.n;
        int n12 = this.r;
        ((w)object2).J(n11, n12);
        object = this.m;
        this.o = object2 = new v((LifecycleOwner)this, (w)object);
        object2 = this.l.g;
        float f11 = 8.0f;
        n12 = h2.b(f11);
        int n13 = h2.b(20.0f);
        float f12 = 94.0f;
        int n14 = h2.b(f12);
        object = new s(n12, n13, n14);
        ((RecyclerView)object2).addItemDecoration((RecyclerView$ItemDecoration)object);
        object2 = this.l.g;
        object3 = this.getContext();
        n13 = 0;
        object = new LinearLayoutManager((Context)object3, 0, false);
        ((RecyclerView)object2).setLayoutManager((RecyclerView$LayoutManager)object);
        object2 = this.l.g;
        object = this.o;
        ((RecyclerView)object2).setAdapter((RecyclerView$Adapter)object);
        int n15 = this.n;
        n11 = 1;
        if (n15 == n11) {
            object2 = (f1)d.v.i0.b.a(this).get(f1.class);
            long l10 = this.j;
            object2 = ((f1)object2).m(l10);
            object = this.getViewLifecycleOwner();
            object3 = new j(this);
            ((LiveData)object2).observe((LifecycleOwner)object, (Observer)object3);
        }
        if ((n15 = this.n) == n10 || n15 == (n11 = 5)) {
            object = this.o.d();
            object2 = new AddVideoFragment$a(this, (List)object);
            object = new ItemTouchHelper((ItemTouchHelper$Callback)object2);
            object2 = this.l.g;
            ((ItemTouchHelper)object).attachToRecyclerView((RecyclerView)object2);
        }
    }

    public static /* synthetic */ void J(AddVideoFragment addVideoFragment) {
        addVideoFragment.h0();
    }

    private /* synthetic */ void K(Boolean object) {
        if (object == null) {
            return;
        }
        object = this.p.d();
        boolean bl2 = ((ArrayList)object).isEmpty();
        if (bl2) {
            object = this.l.k;
            ((StatusView)((Object)object)).c();
        } else {
            object = this.l.k;
            ((StatusView)((Object)object)).a();
        }
    }

    private /* synthetic */ void M(Boolean bl2) {
        if (bl2 == null) {
            return;
        }
        this.l.k.d();
    }

    private /* synthetic */ boolean O(View view, int n10, a a10, MotionEvent object) {
        object = a10.e();
        boolean bl2 = TextUtils.isEmpty((CharSequence)object);
        if (bl2) {
            return false;
        }
        this.l.i.b(true, a10, view, n10);
        return false;
    }

    private /* synthetic */ void Q(Integer object) {
        int n10;
        if (object != null && (n10 = ((Integer)object).intValue()) != 0) {
            int n11 = (Integer)object;
            object = d.v.f.i.g.s(this, n11);
            n2.e((String)object);
        }
    }

    private /* synthetic */ void S(View object, int n10, a a10) {
        if (n10 >= 0 && a10 != null) {
            int n11;
            int n12 = this.q;
            n10 = 1;
            if (n12 > 0 && (n12 = ((ArrayList)(object = this.o.d())).size()) == (n11 = this.q)) {
                n12 = this.n;
                if (n12 == 0) {
                    n12 = 2131952069;
                    object = d.v.f.i.g.s(this, n12);
                    n2.e((String)object);
                } else {
                    n12 = 2131951839;
                    Object[] objectArray = new Object[n10];
                    a10 = null;
                    Integer n13 = n11;
                    objectArray[0] = n13;
                    object = d.v.f.i.g.t(this, n12, objectArray);
                    n2.e((String)object);
                }
                return;
            }
            object = a10.e();
            n12 = (int)(s1.q((String)object) ? 1 : 0);
            if (n12 == 0) {
                this.e0();
                n12 = this.n;
                n10 = 2;
                if (n12 == n10) {
                    n12 = 2131952382;
                    object = d.v.f.i.g.s(this, n12);
                    n2.e((String)object);
                }
                return;
            }
            n12 = (int)(this.s ? 1 : 0);
            if (n12 == 0) {
                n12 = this.n;
                n11 = 3;
                if (n12 == n11) {
                    this.g0();
                } else {
                    n11 = 5;
                    if (n12 != n11) {
                        this.f0();
                    }
                }
                this.s = n10;
            }
            object = this.m;
            RecyclerView recyclerView = this.l.g;
            v v10 = this.o;
            ((w)object).k(recyclerView, v10, a10);
        }
    }

    private /* synthetic */ void U(a a10) {
        MediaType mediaType;
        if (a10 == null) {
            return;
        }
        MediaType mediaType2 = this.l.x();
        if (mediaType2 != (mediaType = MediaType.ALL) && (mediaType2 = a10.f()) != (mediaType = this.l.x())) {
            return;
        }
        this.p.addData(a10);
    }

    private /* synthetic */ void W(List list) {
        v v10 = this.o;
        list = this.m.H(list);
        v10.l(list);
        this.o.q(0);
    }

    private /* synthetic */ void Y() {
        n$a n$a = new n$a();
        Object object = this.l.getRoot();
        n$a = n$a.c((View)object);
        object = d.v.f.i.g.m(this.requireContext(), 2131952072);
        n$a = n$a.k((String)object).d(2132017750).h(0x800033).g(2);
        int n10 = h2.b(20.0f);
        n$a = n$a.m(n10);
        n10 = Windows.o(this.requireContext()).getHeight();
        int n11 = h2.b(144.0f);
        n$a = n$a.n(n10 -= n11);
        n10 = h2.b(32.0f);
        n$a.f(n10).o();
        k2.e().n(true);
    }

    private /* synthetic */ void a0() {
        n$a n$a = new n$a();
        Object object = this.l.b;
        n$a = n$a.c((View)object);
        object = d.v.f.i.g.m(this.requireContext(), 2131952072);
        n$a = n$a.k((String)object).d(2132017750).h(0x800033).g(2);
        object = new d.v.c.k1.a.h(this);
        n$a = n$a.j((PopupWindow.OnDismissListener)object);
        int n10 = h2.b(20.0f);
        n$a = n$a.m(n10);
        n10 = Windows.o(this.requireContext()).getHeight();
        int n11 = h2.b(144.0f);
        n$a = n$a.n(n10 -= n11);
        n10 = h2.b(32.0f);
        n$a.f(n10).o();
    }

    public static /* synthetic */ void c0() {
        k2.e().m(true);
    }

    public static AddVideoFragment d0(Bundle bundle) {
        AddVideoFragment addVideoFragment = new AddVideoFragment();
        addVideoFragment.setArguments(bundle);
        return addVideoFragment;
    }

    private void e0() {
        this.p.d().clear();
        this.p.notifyDataSetChanged();
        w w10 = this.m;
        int n10 = this.n;
        int n11 = this.r;
        w10.J(n10, n11);
    }

    private void f0() {
        k2 k22 = k2.e();
        boolean bl2 = k22.g();
        if (bl2) {
            return;
        }
        k22 = this.l.b;
        i i10 = new i(this);
        k22.post(i10);
    }

    private void g0() {
        k2 k22 = k2.e();
        boolean bl2 = k22.f();
        if (bl2) {
            return;
        }
        k22 = this.l.b;
        f f10 = new f(this);
        k22.post(f10);
    }

    private void h0() {
        n$a n$a = new n$a();
        Object object = this.l.b;
        n$a = n$a.c((View)object);
        object = d.v.f.i.g.s(this, 2131952071);
        n$a = n$a.k((String)object).d(2132017750).h(49).g(2).m(0);
        int n10 = Windows.o(this.requireContext()).getHeight();
        int n11 = h2.b(144.0f);
        n$a = n$a.n(n10 -= n11).e(0.5f);
        object = d.v.c.k1.a.d.a;
        n$a.j((PopupWindow.OnDismissListener)object).o();
    }

    private void i0() {
        Object object = this.o;
        if (object != null && (object = ((d.v.f.d.b)object).d()) != null) {
            boolean bl2;
            int n10 = 0;
            object = null;
            Iterator iterator2 = this.o.d().iterator();
            int n11 = 1;
            while (bl2 = iterator2.hasNext()) {
                a a10 = (a)iterator2.next();
                Object object2 = a10.e();
                int n12 = s1.q((String)object2);
                if (n12 != 0) continue;
                n10 = this.n;
                if (n10 != n11) {
                    iterator2.remove();
                } else {
                    object = a10.e();
                    n10 = (int)(TextUtils.isEmpty((CharSequence)object) ? 1 : 0);
                    if (!n10) {
                        object = this.l.u();
                        object2 = this.o.d();
                        n12 = ((ArrayList)object2).indexOf(a10);
                        ((AddVideoFragment$b)object).e(n11 != 0, n12, a10);
                    }
                }
                n10 = n11;
            }
            if (n10) {
                this.e0();
            }
        }
    }

    public static /* synthetic */ v6 x(AddVideoFragment addVideoFragment) {
        return addVideoFragment.l;
    }

    public static /* synthetic */ int y(AddVideoFragment addVideoFragment) {
        return addVideoFragment.n;
    }

    public static /* synthetic */ v z(AddVideoFragment addVideoFragment) {
        return addVideoFragment.o;
    }

    public boolean C() {
        int n10 = this.n;
        int n11 = 1;
        if (n10 != n11) {
            n11 = 0;
        }
        return n11 != 0;
    }

    public void F() {
        Object object = (v)this.l.g.getAdapter();
        if (object == null) {
            return;
        }
        object = this.m;
        FragmentActivity fragmentActivity = this.requireActivity();
        long l10 = this.j;
        ((w)object).G(fragmentActivity, this, l10);
    }

    public /* synthetic */ void L(Boolean bl2) {
        this.K(bl2);
    }

    public /* synthetic */ void N(Boolean bl2) {
        this.M(bl2);
    }

    public /* synthetic */ boolean P(View view, int n10, a a10, MotionEvent motionEvent) {
        return this.O(view, n10, a10, motionEvent);
    }

    public /* synthetic */ void R(Integer n10) {
        this.Q(n10);
    }

    public /* synthetic */ void T(View view, int n10, a a10) {
        this.S(view, n10, a10);
    }

    public /* synthetic */ void V(a a10) {
        this.U(a10);
    }

    public /* synthetic */ void X(List list) {
        this.W(list);
    }

    public /* synthetic */ void Z() {
        this.Y();
    }

    public /* synthetic */ void b0() {
        this.a0();
    }

    public int h() {
        return 2131558572;
    }

    public void i(ViewDataBinding object) {
        super.i((ViewDataBinding)object);
        object = (v6)object;
        this.l = object;
        AddVideoFragment$b addVideoFragment$b = new AddVideoFragment$b(this);
        ((v6)object).C(addVideoFragment$b);
        this.m = object = (w)d.v.i0.b.c(this.requireActivity()).get(w.class);
        this.l.E((w)object);
        this.I();
        this.H();
    }

    public void onActivityResult(int n10, int n11, Intent intent) {
        super.onActivityResult(n10, n11, intent);
        if (n10 == 0 && n11 == (n10 = -1) && intent != null) {
            String string2 = "deleted_position";
            this.k = n10 = intent.getIntExtra(string2, n10);
        }
    }

    public void onDestroy() {
        super.onDestroy();
        h.e(this.m.y(), null);
        h.e(this.m.w(), null);
        h.e(this.m.x(), null);
        this.m.s().clear();
    }

    public void onResume() {
        super.onResume();
        int n10 = this.k;
        if (n10 >= 0) {
            Object object = this.o.d();
            int n11 = this.k;
            Object object2 = ((a)(object = (a)((ArrayList)object).get(n11))).e();
            if ((n11 = (int)(TextUtils.isEmpty((CharSequence)object2) ? 1 : 0)) != 0) {
                return;
            }
            object2 = this.o.d();
            int n12 = this.k;
            ((ObservableArrayList)object2).remove(n12);
            object2 = this.o.d();
            n12 = this.k;
            object = ((a)object).c();
            String string2 = "";
            object = ((a)object).l(string2).p(string2);
            ((ObservableArrayList)object2).add(n12, object);
            object = this.m;
            object2 = this.o.d();
            ((w)object).r((List)object2);
            this.m.l();
            object = this.o;
            n11 = this.k;
            ((v)object).q(n11);
            object = this.l.g;
            n11 = this.k;
            ((RecyclerView)object).smoothScrollToPosition(n11);
        }
        this.i0();
    }

    public void onStop() {
        super.onStop();
        this.m.L();
        this.k = -1;
    }
}

