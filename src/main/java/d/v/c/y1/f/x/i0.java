/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Dialog
 *  android.content.Context
 *  android.view.Window
 *  android.view.WindowManager$LayoutParams
 *  android.widget.TextView
 */
package d.v.c.y1.f.x;

import android.app.Dialog;
import android.content.Context;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$Adapter;
import androidx.recyclerview.widget.RecyclerView$LayoutManager;
import com.zhiyun.cama.voice.music.mine.MusicLocalImportViewModel;
import com.zhiyun.common.util.Windows;
import d.v.c.q0.b;
import d.v.c.w0.h9;
import d.v.c.y1.f.q;
import d.v.c.y1.f.x.h0;
import d.v.c.y1.f.x.i0$a;
import d.v.c.y1.f.x.o;
import d.v.c.y1.f.x.r;
import d.v.c.y1.f.x.s;
import d.v.c.y1.f.x.t;
import d.v.f.i.g;
import java.util.List;

public class i0
extends b {
    private MusicLocalImportViewModel g;
    private h9 h;
    private h0 i;

    private void A() {
        Object object = this.h.c.b;
        Object object2 = d.v.f.i.g.o(this.getResources(), 2131952068);
        object.setText((CharSequence)object2);
        object = (MusicLocalImportViewModel)d.v.i0.b.a(this).get(MusicLocalImportViewModel.class);
        this.g = object;
        this.h.B((MusicLocalImportViewModel)object);
        object = this.getLifecycle();
        object2 = this.g;
        ((Lifecycle)object).addObserver((LifecycleObserver)object2);
        object2 = this.g;
        this.i = object = new h0((LifecycleOwner)this, (MusicLocalImportViewModel)object2);
        object = this.h.a;
        Object object3 = this.requireContext();
        object2 = new LinearLayoutManager((Context)object3, 1, false);
        ((RecyclerView)object).setLayoutManager((RecyclerView$LayoutManager)object2);
        object = this.h.a;
        object2 = this.i;
        ((RecyclerView)object).setAdapter((RecyclerView$Adapter)object2);
        object = this.h.c.c;
        object2 = d.v.f.i.g.m(this.requireContext(), 2131952090);
        object.setText((CharSequence)object2);
        this.g.M();
        object = this.g.N();
        object2 = new s(this);
        ((LiveData)object).observe(this, (Observer)object2);
        object = this.g.H();
        object2 = new o(this);
        ((LiveData)object).observe(this, (Observer)object2);
        object = this.g.I();
        object2 = this.getViewLifecycleOwner();
        object3 = new t(this);
        ((LiveData)object).observe((LifecycleOwner)object2, (Observer)object3);
        object = this.g.L();
        object2 = this.getViewLifecycleOwner();
        object3 = new d.v.c.y1.f.x.q(this);
        ((LiveData)object).observe((LifecycleOwner)object2, (Observer)object3);
        object = this.g.K();
        object2 = this.getViewLifecycleOwner();
        object3 = new r(this);
        ((LiveData)object).observe((LifecycleOwner)object2, (Observer)object3);
    }

    private /* synthetic */ void B(q q10) {
        this.i.addData(q10);
    }

    private /* synthetic */ void D(Boolean object) {
        TextView textView = this.h.c.c;
        boolean bl2 = (Boolean)object;
        if (bl2) {
            object = this.requireContext();
            int n10 = 2131952014;
            object = d.v.f.i.g.m((Context)object, n10);
        } else {
            object = this.requireContext();
            int n11 = 2131952090;
            object = d.v.f.i.g.m((Context)object, n11);
        }
        textView.setText((CharSequence)object);
    }

    private /* synthetic */ void F(Integer object) {
        String string2 = d.v.f.i.g.o(this.getResources(), 2131952067);
        Object[] objectArray = new Object[]{object};
        object = String.format(string2, objectArray);
        this.h.d.setText((CharSequence)object);
    }

    private /* synthetic */ void H(List list) {
        if (list != null) {
            Object object = this.i;
            ((d.v.f.d.b)object).l(list);
            boolean bl2 = list.isEmpty();
            int n10 = 8;
            if (bl2) {
                this.h.e.c();
                list = this.h.c.c;
                list.setVisibility(n10);
            } else {
                this.h.e.a();
                object = this.g;
                boolean bl3 = ((MusicLocalImportViewModel)object).y(list);
                if (bl3) {
                    list = this.h.c.c;
                    list.setVisibility(n10);
                }
            }
        }
    }

    private /* synthetic */ void J(Exception exception) {
        if (exception != null) {
            this.h.e.d();
            exception = this.h.c.c;
            int n10 = 8;
            exception.setVisibility(n10);
        }
    }

    private void L() {
        Window window;
        Dialog dialog = this.getDialog();
        if (dialog != null && (window = dialog.getWindow()) != null) {
            int n10;
            window = Windows.o(this.requireContext());
            dialog = dialog.getWindow();
            dialog.getAttributes().windowAnimations = 2132017745;
            int n11 = 2131099860;
            dialog.setBackgroundDrawableResource(n11);
            dialog.getDecorView().setPadding(0, 0, 0, 0);
            WindowManager.LayoutParams layoutParams = dialog.getAttributes();
            layoutParams.width = n10 = window.getWidth();
            layoutParams.height = -1;
            layoutParams.flags = 32;
            layoutParams.gravity = n10 = 80;
            dialog.setAttributes(layoutParams);
        }
    }

    public static /* synthetic */ MusicLocalImportViewModel w(i0 i02) {
        return i02.g;
    }

    public static /* synthetic */ h0 x(i0 i02) {
        return i02.i;
    }

    public static /* synthetic */ h9 y(i0 i02) {
        return i02.h;
    }

    public static i0 z() {
        i0 i02 = new i0();
        return i02;
    }

    public /* synthetic */ void C(q q10) {
        this.B(q10);
    }

    public /* synthetic */ void E(Boolean bl2) {
        this.D(bl2);
    }

    public /* synthetic */ void G(Integer n10) {
        this.F(n10);
    }

    public /* synthetic */ void I(List list) {
        this.H(list);
    }

    public /* synthetic */ void K(Exception exception) {
        this.J(exception);
    }

    public void onDestroyView() {
        super.onDestroyView();
        Lifecycle lifecycle = this.getLifecycle();
        MusicLocalImportViewModel musicLocalImportViewModel = this.g;
        lifecycle.removeObserver(musicLocalImportViewModel);
    }

    public int s() {
        return 2131558604;
    }

    public void t(ViewDataBinding viewDataBinding) {
        super.t(viewDataBinding);
        viewDataBinding = (h9)viewDataBinding;
        this.h = viewDataBinding;
        i0$a i0$a = new i0$a(this);
        ((h9)viewDataBinding).A(i0$a);
        this.m(true);
        this.L();
        this.A();
    }
}

