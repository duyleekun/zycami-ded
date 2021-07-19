/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.View
 */
package d.v.c.i1.t2;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.navigation.NavDirections;
import androidx.recyclerview.widget.RecyclerView$ItemDecoration;
import androidx.recyclerview.widget.RecyclerView$LayoutManager;
import com.zhiyun.cama.data.database.model.Likes;
import com.zhiyun.cama.main.me.user.UserPageActivity;
import d.v.c.h1.o;
import d.v.c.h1.p;
import d.v.c.i1.o2;
import d.v.c.i1.t2.g0;
import d.v.c.i1.t2.i0;
import d.v.c.i1.t2.j0;
import d.v.c.i1.t2.s;
import d.v.c.i1.t2.t;
import d.v.c.i1.t2.u;
import d.v.c.v0.k;
import d.v.c.x1.l;
import d.v.e.l.h2;
import d.v.e.l.m2;
import d.v.f.i.g;
import d.v.i0.b;

public class k0
extends p {
    private i0 f;

    private /* synthetic */ void M(View object, int n10, Likes object2) {
        long l10 = ((Likes)object2).getId();
        object = k.a(l10);
        String string2 = this.requireActivity().getClass().getSimpleName();
        object2 = UserPageActivity.class.getSimpleName();
        n10 = (int)(string2.equals(object2) ? 1 : 0);
        object2 = null;
        object = n10 != 0 ? g0.a((String)object, false) : o2.i((String)object, false);
        l.f(this, (NavDirections)object);
    }

    private /* synthetic */ void O(Boolean object) {
        boolean bl2 = (Boolean)object;
        if (bl2) {
            this.E();
            this.S();
            object = this.f;
            ((i0)object).M();
        }
    }

    private /* synthetic */ void Q() {
        this.b.d.scrollToPosition(0);
    }

    private void S() {
        FragmentActivity fragmentActivity = this.getActivity();
        s s10 = new s(this);
        m2.X(200L, fragmentActivity, s10);
    }

    public void D() {
        this.f.y();
    }

    public void E() {
        this.f.A();
    }

    public /* synthetic */ void N(View view, int n10, Likes likes) {
        this.M(view, n10, likes);
    }

    public /* synthetic */ void P(Boolean bl2) {
        this.O(bl2);
    }

    public /* synthetic */ void R() {
        this.Q();
    }

    public o k() {
        j0 j02 = new j0();
        t t10 = new t(this);
        j02.q(t10);
        return j02;
    }

    public LiveData l() {
        return this.f.e();
    }

    public RecyclerView$ItemDecoration m() {
        return null;
    }

    public RecyclerView$LayoutManager n() {
        o o10 = this.c;
        Context context = this.getContext();
        return o10.c(context, 1, 2);
    }

    public LiveData o() {
        return this.f.f();
    }

    public void s() {
        this.G(2131231808);
        Object object = g.m(this.requireContext(), 2131952532);
        this.H((String)object);
        object = this.b.d;
        float f10 = 15.0f;
        int n10 = h2.b(f10);
        int n11 = h2.b(f10);
        object.setPadding(n10, 0, n11, 0);
        object = this.f.g();
        LifecycleOwner lifecycleOwner = this.getViewLifecycleOwner();
        u u10 = new u(this);
        ((LiveData)object).observe(lifecycleOwner, u10);
    }

    public void t() {
        i0 i02;
        this.f = i02 = (i0)d.v.i0.b.c(this.requireActivity()).get(i0.class);
    }
}

