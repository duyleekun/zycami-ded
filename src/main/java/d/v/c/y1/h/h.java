/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Dialog
 *  android.content.Context
 *  android.net.Uri
 *  android.os.Bundle
 *  android.view.View
 */
package d.v.c.y1.h;

import android.app.Dialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$Adapter;
import androidx.recyclerview.widget.RecyclerView$ItemDecoration;
import androidx.recyclerview.widget.RecyclerView$LayoutManager;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.zhiyun.cama.device.connect.help.SingleBindingAdapter;
import com.zhiyun.cama.publish.CropImageActivity;
import com.zhiyun.cama.publish.UploadCEMediaInfo;
import com.zhiyun.nvseditor.data.NvsTimelineData;
import d.v.c.n1.l2;
import d.v.c.o0.p0;
import d.v.c.o0.x0;
import d.v.c.w0.j6;
import d.v.c.y1.h.a;
import d.v.c.y1.h.b;
import d.v.c.y1.h.c;
import d.v.c.y1.h.g;
import d.v.c.y1.h.h$a;
import d.v.c.y1.h.i;
import d.v.e.i.j;
import d.v.e.l.h2;
import java.util.Objects;

public class h
extends d.v.c.q0.b {
    private static final String n = "show_back";
    private static final String o = "media_type";
    private static final String p = "source";
    private j6 g;
    private p0 h;
    private SingleBindingAdapter i;
    private l2 j;
    private boolean k;
    private int l;
    private int m;

    private /* synthetic */ void B(Boolean object) {
        object = this.i.getData();
        boolean bl2 = object.isEmpty();
        if (bl2) {
            this.H();
        }
    }

    private /* synthetic */ void D(Boolean object) {
        object = this.i.getData();
        boolean bl2 = object.isEmpty();
        if (bl2) {
            this.H();
        }
    }

    private void F() {
        Dialog dialog = this.getDialog();
        if (dialog != null && (dialog = this.getDialog().getWindow()) != null) {
            dialog = this.getDialog().getWindow();
            dialog.setBackgroundDrawableResource(2131099739);
            View view = dialog.getDecorView();
            view.setPadding(0, 0, 0, 0);
            int n10 = -1;
            dialog.setLayout(n10, n10);
        }
    }

    public static h G(boolean bl2, int n10, int n11) {
        Bundle bundle = new Bundle();
        bundle.putBoolean(n, bl2);
        bundle.putInt(o, n10);
        bundle.putInt(p, n11);
        h h10 = new h();
        h10.setArguments(bundle);
        return h10;
    }

    private void H() {
        p0 p02 = this.h;
        boolean bl2 = Objects.isNull(p02);
        if (bl2) {
            Object object = this.getContext();
            this.h = p02 = new p0((Context)object);
            object = this.i;
            ((BaseQuickAdapter)object).setEmptyView((View)p02);
        }
        this.h.c(1);
    }

    private void I(Uri uri) {
        Object object = d.v.v.j.h.t().n();
        int n10 = ((NvsTimelineData)object).getAspectRadio();
        int n11 = 4;
        float f10 = 5.6E-45f;
        if (n10 == n11) {
            n10 = d.v.v.q.j.d();
        }
        int n12 = 16;
        float f11 = 2.24E-44f;
        int n13 = 9;
        float f12 = 1.3E-44f;
        int n14 = 3;
        float f13 = 4.2E-45f;
        int n15 = 1;
        float f14 = Float.MIN_VALUE;
        int n16 = 0;
        if (n10 != 0) {
            if (n10 != n15) {
                int n17 = 2;
                if (n10 != n17) {
                    if (n10 != n14) {
                        n12 = 5;
                        f11 = 7.0E-45f;
                        if (n10 != n12) {
                            n11 = 6;
                            f10 = 8.4E-45f;
                            if (n10 != n11) {
                                return;
                            }
                            n11 = n15;
                            f10 = f14;
                            n16 = n15;
                        } else {
                            n15 = n11;
                            f14 = f10;
                            n11 = n14;
                            f10 = f13;
                        }
                    } else {
                        n11 = n12;
                        f10 = f11;
                        n15 = n13;
                        f14 = f12;
                    }
                } else {
                    n15 = n14;
                    f14 = f13;
                }
            } else {
                n11 = n15;
                f10 = f14;
            }
        } else {
            n15 = n12;
            f14 = f11;
            n11 = n13;
            f10 = f12;
        }
        object = this.getParentFragment();
        f10 = n11;
        f11 = n15;
        CropImageActivity.b0((Fragment)object, uri, f10, f11, n16 != 0);
    }

    private void w() {
        int n10;
        int n11;
        Bundle bundle = this.getArguments();
        boolean bl2 = true;
        this.k = n11 = bundle.getBoolean(n, bl2);
        this.l = n11 = bundle.getInt(o);
        String string2 = p;
        this.m = n10 = bundle.getInt(string2);
        bundle = this.g.a;
        n11 = (int)(this.k ? 1 : 0);
        if (n11 != 0) {
            n11 = 0;
            string2 = null;
        } else {
            n11 = 8;
        }
        bundle.setVisibility(n11);
    }

    private void x() {
        Object object = new SingleBindingAdapter(2131558620);
        this.i = object;
        object = this.g.c;
        Context context = this.getContext();
        Object object2 = new GridLayoutManager(context, 3);
        ((RecyclerView)object).setLayoutManager((RecyclerView$LayoutManager)object2);
        object = this.g.c;
        int n10 = h2.b(2.0f);
        object2 = new x0(n10);
        ((RecyclerView)object).addItemDecoration((RecyclerView$ItemDecoration)object2);
        this.g.c.setHasFixedSize(true);
        object = this.g.c;
        object2 = this.i;
        ((RecyclerView)object).setAdapter((RecyclerView$Adapter)object2);
        object = this.i;
        object2 = new a(this);
        ((BaseQuickAdapter)object).setOnItemClickListener((OnItemClickListener)object2);
    }

    private void y() {
        Object object = (l2)d.v.i0.b.a(this).get(l2.class);
        this.j = object;
        this.g.B((l2)object);
        object = this.j.j();
        LifecycleOwner lifecycleOwner = this.getViewLifecycleOwner();
        Object object2 = this.i;
        object2.getClass();
        g g10 = new g((SingleBindingAdapter)object2);
        ((j)object).observe(lifecycleOwner, g10);
        object = this.j.g();
        lifecycleOwner = this.getViewLifecycleOwner();
        object2 = new b(this);
        ((LiveData)object).observe(lifecycleOwner, (Observer)object2);
        object = this.j.i();
        lifecycleOwner = this.getViewLifecycleOwner();
        object2 = new c(this);
        ((LiveData)object).observe(lifecycleOwner, (Observer)object2);
        object = this.j;
        int n10 = this.l;
        ((l2)object).k(n10);
    }

    private /* synthetic */ void z(BaseQuickAdapter object, View object2, int n10) {
        int n11;
        object2 = this.i;
        ((BaseQuickAdapter)object2).getData();
        if (n10 >= 0 && n10 <= (n11 = (object = ((BaseQuickAdapter)object).getData()).size())) {
            object = ((UploadCEMediaInfo)this.i.getData().get(n10)).d();
            int n12 = this.m;
            n10 = 1;
            if (n12 != n10) {
                n10 = 2;
                if (n12 == n10) {
                    this.I((Uri)object);
                }
            } else {
                object = d.v.c.y1.h.i.C(object.toString());
                object2 = this.getParentFragmentManager();
                ((d.v.f.g.b)object).q((FragmentManager)object2);
            }
        }
    }

    public /* synthetic */ void A(BaseQuickAdapter baseQuickAdapter, View view, int n10) {
        this.z(baseQuickAdapter, view, n10);
    }

    public /* synthetic */ void C(Boolean bl2) {
        this.B(bl2);
    }

    public /* synthetic */ void E(Boolean bl2) {
        this.D(bl2);
    }

    public void onStop() {
        super.onStop();
        this.j.l();
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.w();
        this.x();
        this.y();
    }

    public int s() {
        return 2131558566;
    }

    public void t(ViewDataBinding viewDataBinding) {
        super.t(viewDataBinding);
        viewDataBinding = (j6)viewDataBinding;
        this.g = viewDataBinding;
        h$a h$a = new h$a(this);
        ((j6)viewDataBinding).A(h$a);
        this.F();
    }
}

