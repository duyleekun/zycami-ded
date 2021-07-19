/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.KeyEvent
 *  android.view.View
 *  android.view.View$OnKeyListener
 *  android.widget.CheckBox
 */
package d.v.c.y1.f.x;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import android.widget.CheckBox;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$Adapter;
import androidx.recyclerview.widget.RecyclerView$LayoutManager;
import com.zhiyun.cama.voice.music.MusicListViewModel;
import d.v.c.q0.c;
import d.v.c.w0.f7;
import d.v.c.y1.f.q;
import d.v.c.y1.f.x.g0$a;
import d.v.c.y1.f.x.k0;
import d.v.c.y1.f.x.l;
import d.v.c.y1.f.x.l0;
import d.v.c.y1.f.x.m;
import d.v.c.y1.f.x.n;
import d.v.i0.b;
import java.util.List;

public class g0
extends c {
    private f7 g;
    private MusicListViewModel h;
    private l0 i;
    private k0 j;

    private /* synthetic */ void A(View object, int n10, q q10) {
        if (q10 == null) {
            return;
        }
        object = (CheckBox)object;
        int n11 = object.isChecked();
        q10.J(n11 != 0);
        l0 l02 = this.i;
        n10 = l02.f();
        int n12 = 1;
        n11 = n11 != 0 ? n12 : -1;
        this.i.j(n10 += n11);
        object = this.i;
        k0 k02 = this.j;
        int n13 = k02.getItemCount();
        if (n10 != n13) {
            n12 = 0;
            q10 = null;
        }
        ((l0)object).i(n12 != 0);
    }

    private /* synthetic */ boolean C(View view, int n10, KeyEvent keyEvent) {
        int n11;
        int n12 = keyEvent.getAction();
        if (n12 == (n11 = 1) && n10 == (n12 = 4)) {
            this.y();
            return n11 != 0;
        }
        return false;
    }

    private /* synthetic */ void E(List list) {
        this.j.m(list);
        this.j.notifyDataSetChanged();
    }

    public static /* synthetic */ void u(g0 g02) {
        g02.y();
    }

    public static /* synthetic */ l0 v(g0 g02) {
        return g02.i;
    }

    public static /* synthetic */ k0 w(g0 g02) {
        return g02.j;
    }

    public static /* synthetic */ MusicListViewModel x(g0 g02) {
        return g02.h;
    }

    private void y() {
        this.getParentFragmentManager().beginTransaction().remove(this).commit();
    }

    private void z() {
        Object object = this.h;
        Object object2 = new k0((LifecycleOwner)this, (MusicListViewModel)object);
        this.j = object2;
        object = new n(this);
        ((k0)object2).t((d.v.f.f.b)object);
        object2 = this.g.b;
        Context context = this.requireContext();
        boolean bl2 = true;
        object = new LinearLayoutManager(context, (int)(bl2 ? 1 : 0), false);
        ((RecyclerView)object2).setLayoutManager((RecyclerView$LayoutManager)object);
        object2 = this.g.b;
        object = this.j;
        ((RecyclerView)object2).setAdapter((RecyclerView$Adapter)object);
        this.g.getRoot().setFocusableInTouchMode(bl2);
        this.g.getRoot().requestFocus();
        object2 = this.g.getRoot();
        object = new l(this);
        object2.setOnKeyListener((View.OnKeyListener)object);
        object2 = this.h.t();
        object = new m(this);
        ((LiveData)object2).observe(this, (Observer)object);
    }

    public /* synthetic */ void B(View view, int n10, q q10) {
        this.A(view, n10, q10);
    }

    public /* synthetic */ boolean D(View view, int n10, KeyEvent keyEvent) {
        return this.C(view, n10, keyEvent);
    }

    public /* synthetic */ void F(List list) {
        this.E(list);
    }

    public int h() {
        return 2131558577;
    }

    public void i(ViewDataBinding object) {
        super.i((ViewDataBinding)object);
        object = (f7)object;
        this.g = object;
        object = d.v.i0.b.a(this);
        Object object2 = (MusicListViewModel)((ViewModelProvider)object).get(MusicListViewModel.class);
        this.h = object2;
        this.i = object = (l0)((ViewModelProvider)object).get(l0.class);
        object = this.g;
        object2 = new g0$a(this);
        ((f7)object).A((g0$a)object2);
        object = this.g;
        object2 = this.i;
        ((f7)object).B((l0)object2);
        this.z();
    }
}

