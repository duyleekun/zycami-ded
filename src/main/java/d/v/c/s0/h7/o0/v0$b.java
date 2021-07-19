/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package d.v.c.s0.h7.o0;

import android.content.Context;
import androidx.databinding.ObservableBoolean;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import com.zhiyun.cama.album.AlbumListAdapter;
import d.v.c.s0.h7.o0.c;
import d.v.c.s0.h7.o0.h;
import d.v.c.s0.h7.o0.i;
import d.v.c.s0.h7.o0.v0;
import d.v.e.l.h2;
import d.v.f.f.a;
import d.v.f.i.g;
import d.v.g0.k$a;
import d.v.g0.k$b;
import java.util.List;

public class v0$b {
    public final /* synthetic */ v0 a;

    public v0$b(v0 v02) {
        this.a = v02;
    }

    private /* synthetic */ void a(List list, DialogFragment dialogFragment) {
        dialogFragment.dismiss();
        v0.m(this.a).d(list);
    }

    private /* synthetic */ void c(List list, DialogFragment dialogFragment) {
        dialogFragment.dismiss();
        v0.m(this.a).h0(list);
    }

    public /* synthetic */ void b(List list, DialogFragment dialogFragment) {
        this.a(list, dialogFragment);
    }

    public /* synthetic */ void d(List list, DialogFragment dialogFragment) {
        this.c(list, dialogFragment);
    }

    public void e() {
        v0.j(this.a);
    }

    public void f() {
        Object object = v0.l(this.a).e();
        boolean bl2 = object.isEmpty();
        if (bl2) {
            return;
        }
        Context context = this.a.getContext();
        Object object2 = new k$b(context);
        object2 = (k$b)((k$a)object2).m(2131953116);
        int n10 = h2.b(320.0f);
        object2 = (k$b)((k$a)object2).g(n10, -1);
        a a10 = c.a;
        object2 = (k$b)((k$a)object2).o(2131951833, a10);
        a10 = new i(this, (List)object);
        object = (k$b)((k$a)object2).v(2131952621, a10);
        object2 = this.a.getChildFragmentManager();
        ((k$a)object).D((FragmentManager)object2);
    }

    public void g() {
        Object object = v0.l(this.a).e();
        boolean bl2 = object.isEmpty();
        if (bl2) {
            return;
        }
        Object object2 = this.a.requireContext();
        Object object3 = new Object[1];
        Integer n10 = object.size();
        object3[0] = n10;
        object2 = g.n((Context)object2, 2131953146, (Object[])object3);
        object3 = this.a.getContext();
        k$b k$b = new k$b((Context)object3);
        object2 = (k$b)k$b.n((String)object2);
        int n11 = h2.b(320.0f);
        object2 = (k$b)((k$a)object2).g(n11, -1);
        object3 = c.a;
        object2 = (k$b)((k$a)object2).o(2131951833, (a)object3);
        object3 = new h(this, (List)object);
        object = (k$b)((k$a)object2).v(2131952621, (a)object3);
        object2 = this.a.getChildFragmentManager();
        ((k$a)object).D((FragmentManager)object2);
    }

    public void h() {
        Object object = v0.k(this.a);
        boolean bl2 = v0.k(this.a).get() ^ true;
        ((ObservableBoolean)object).set(bl2);
        object = v0.l(this.a);
        bl2 = v0.k(this.a).get();
        ((AlbumListAdapter)object).t(bl2);
    }
}

