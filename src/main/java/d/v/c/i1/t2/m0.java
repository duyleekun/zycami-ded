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
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.navigation.NavDirections;
import androidx.recyclerview.widget.RecyclerView$ItemDecoration;
import androidx.recyclerview.widget.RecyclerView$LayoutManager;
import com.zhiyun.cama.data.database.model.Works;
import com.zhiyun.cama.main.me.user.UserPageActivity;
import d.v.c.h1.o;
import d.v.c.h1.p;
import d.v.c.i1.o2;
import d.v.c.i1.t2.g0;
import d.v.c.i1.t2.i0;
import d.v.c.i1.t2.l0;
import d.v.c.i1.t2.w;
import d.v.c.i1.t2.x;
import d.v.c.v0.k;
import d.v.c.x1.l;
import d.v.e.l.h2;
import d.v.f.i.g;
import d.v.i0.b;

public class m0
extends p {
    private i0 f;

    private /* synthetic */ void M(View object, int n10, Works object2) {
        long l10 = ((Works)object2).getId();
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
            this.b.d.scrollToPosition(0);
            object = this.f;
            ((i0)object).N();
        }
    }

    public void D() {
        this.f.z();
    }

    public void E() {
        this.f.G();
    }

    public /* synthetic */ void N(View view, int n10, Works works) {
        this.M(view, n10, works);
    }

    public /* synthetic */ void P(Boolean bl2) {
        this.O(bl2);
    }

    public o k() {
        l0 l02 = new l0();
        w w10 = new w(this);
        l02.q(w10);
        return l02;
    }

    public LiveData l() {
        return this.f.l();
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
        return this.f.m();
    }

    public void s() {
        this.G(2131231812);
        Object object = g.m(this.requireContext(), 2131952577);
        this.H((String)object);
        object = this.b.d;
        float f10 = 15.0f;
        int n10 = h2.b(f10);
        int n11 = h2.b(f10);
        object.setPadding(n10, 0, n11, 0);
        object = this.f.i();
        LifecycleOwner lifecycleOwner = this.getViewLifecycleOwner();
        x x10 = new x(this);
        ((LiveData)object).observe(lifecycleOwner, x10);
    }

    public void t() {
        i0 i02;
        this.f = i02 = (i0)d.v.i0.b.c(this.requireActivity()).get(i0.class);
    }
}

