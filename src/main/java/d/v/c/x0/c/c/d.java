/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package d.v.c.x0.c.c;

import android.content.Context;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$Adapter;
import androidx.recyclerview.widget.RecyclerView$LayoutManager;
import com.zhiyun.editorinterface.decoration.DecorationType;
import com.zhiyun.editorsdk.decoration.DecorationUseCases;
import d.v.c.i1.i2;
import d.v.c.k1.a.r;
import d.v.c.w0.d8;
import d.v.c.x0.c.c.a;
import d.v.c.x0.c.c.b;
import d.v.c.x0.c.c.c;
import d.v.c.x0.c.c.d$a;
import d.v.c.x0.c.c.e;
import d.v.c.x0.c.c.f;
import d.v.e.i.h;
import d.v.e.l.h2;
import java.util.ArrayList;
import java.util.List;

public class d
extends d.v.c.q0.d {
    private d8 j;
    private f k;
    private e l;

    private /* synthetic */ void A(DecorationType object) {
        Object object2 = DecorationType.FONT;
        if (object != object2 && object != (object2 = DecorationType.CAPTION)) {
            return;
        }
        object = this.k.f();
        object2 = -1;
        h.g((MutableLiveData)object, object2);
    }

    private /* synthetic */ void C(Integer object) {
        ViewModel viewModel;
        int n10;
        int n11 = (Integer)object;
        if (n11 == (n10 = -1)) {
            return;
        }
        Object object2 = this.l.d();
        int n12 = (Integer)object;
        object = (Integer)((ArrayList)object2).get(n12);
        n12 = (Integer)object;
        object2 = this.g.X0();
        if (object2 == null) {
            viewModel = this.g;
            Context context = this.requireContext();
            ((i2)viewModel).w(context);
        }
        if ((n10 = (int)(((f)(viewModel = this.k)).b((d.v.h.d.d)object2, n12) ? 1 : 0)) != 0) {
            return;
        }
        viewModel = this.g;
        int n13 = DecorationUseCases.a(n12)[0];
        int n14 = 100;
        n13 = n13 * n14 / 255;
        ((i2)viewModel).e4(n12, n13);
        this.G((d.v.h.d.d)object2);
        object = this.k.j();
        object2 = n14;
        h.g((MutableLiveData)object, object2);
    }

    private /* synthetic */ void E(Integer n10) {
        int n11;
        ViewModel viewModel = this.k;
        int n12 = ((f)viewModel).g();
        if (n12 == (n11 = -1)) {
            return;
        }
        viewModel = this.g;
        ObservableArrayList observableArrayList = this.l.d();
        int n13 = this.k.g();
        n11 = (Integer)observableArrayList.get(n13);
        int n14 = n10;
        ((i2)viewModel).e4(n11, n14);
    }

    private void G(d.v.h.d.d d10) {
        d.v.h.d.d d11 = this.g.X0();
        f f10 = this.k;
        ObservableArrayList observableArrayList = this.l.d();
        f10.c(d10, d11, observableArrayList);
    }

    public static /* synthetic */ f x(d d10) {
        return d10.k;
    }

    private void y() {
        MutableLiveData mutableLiveData = this.g.Y0();
        Observer observer = new b(this);
        mutableLiveData.observe(this, observer);
        mutableLiveData = this.k.f();
        observer = new c(this);
        mutableLiveData.observe(this, observer);
        mutableLiveData = this.k.j();
        observer = new a(this);
        mutableLiveData.observe(this, observer);
    }

    private void z() {
        r r10;
        Object object = this.j.b;
        int n10 = h2.b(16.0f);
        int n11 = h2.b(24.0f);
        int n12 = h2.b(20.0f);
        Object object2 = r10;
        r10 = new r(8, n10, false, n11, n12);
        ((RecyclerView)object).addItemDecoration(r10);
        object = this.j.b;
        Context context = this.requireContext();
        object2 = new GridLayoutManager(context, 8);
        ((RecyclerView)object).setLayoutManager((RecyclerView$LayoutManager)object2);
        object2 = this.k;
        this.l = object = new e((LifecycleOwner)this, (f)object2);
        this.j.b.setAdapter((RecyclerView$Adapter)object);
        object = this.k.i();
        this.l.l((List)object);
    }

    public /* synthetic */ void B(DecorationType decorationType) {
        this.A(decorationType);
    }

    public /* synthetic */ void D(Integer n10) {
        this.C(n10);
    }

    public /* synthetic */ void F(Integer n10) {
        this.E(n10);
    }

    public int h() {
        return 2131558589;
    }

    public void i(ViewDataBinding object) {
        super.i((ViewDataBinding)object);
        object = (d8)object;
        this.j = object;
        d$a d$a = new d$a(this);
        ((d8)object).A(d$a);
        this.k = object = (f)d.v.i0.b.a(this).get(f.class);
        this.j.B((f)object);
        this.z();
        this.y();
    }

    public void onResume() {
        super.onResume();
        Object object = this.k;
        Object object2 = this.g.X0();
        Object object3 = this.l.d();
        int n10 = ((f)object).e((d.v.h.d.d)object2, (List)object3);
        object2 = this.k;
        object3 = this.g.X0();
        int n11 = ((f)object2).d((d.v.h.d.d)object3);
        int n12 = -1;
        if (n10 != n12) {
            object3 = this.j.b;
            ((RecyclerView)object3).smoothScrollToPosition(n10);
        }
        object3 = this.k.f();
        object = n10;
        h.g((MutableLiveData)object3, object);
        object = this.k.j();
        object2 = n11 * 100 / 255;
        h.g((MutableLiveData)object, object2);
    }
}

