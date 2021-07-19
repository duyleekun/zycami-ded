/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package d.v.c.z0;

import android.content.Context;
import androidx.fragment.app.Fragment;
import d.v.c.i0$b;
import d.v.c.z0.d;
import d.v.c.z0.i;
import d.v.e.l.m2;
import d.v.f.g.b;
import d.v.f.i.g;

public class i$a
implements i0$b {
    public final /* synthetic */ i a;

    public i$a(i i10) {
        this.a = i10;
    }

    private /* synthetic */ void c() {
        boolean bl2;
        Object object = i.v(this.a);
        if (object != null && (bl2 = ((Fragment)(object = i.v(this.a))).isVisible())) {
            object = i.v(this.a);
            ((b)object).i();
        }
        if ((object = i.w(this.a)) != null) {
            object = i.w(this.a);
            object.complete();
        }
        this.a.i();
    }

    public void a() {
        i i10 = this.a;
        boolean bl2 = i10.isAdded();
        if (!bl2) {
            return;
        }
        i i11 = this.a;
        d d10 = new d(this);
        m2.X(100, i11, d10);
    }

    public void b() {
        i i10 = this.a;
        boolean bl2 = i10.isAdded();
        if (!bl2) {
            return;
        }
        i.u((i)this.a).a.setVisibility(8);
    }

    public /* synthetic */ void d() {
        this.c();
    }

    public void onError(Throwable object) {
        object = this.a;
        boolean bl2 = ((Fragment)object).isAdded();
        if (!bl2) {
            return;
        }
        object = i.v(this.a);
        if (object != null && (bl2 = ((Fragment)(object = i.v(this.a))).isVisible())) {
            object = i.v(this.a);
            ((b)object).i();
        }
        i.u((i)this.a).b.setProgress(0);
        i.u((i)this.a).a.setVisibility(0);
        object = i.u((i)this.a).c;
        String string2 = g.m(this.a.getContext(), 2131952829);
        object.setText((CharSequence)string2);
    }

    public void onProgress(int n10) {
        i i10 = this.a;
        boolean bl2 = i10.isAdded();
        if (!bl2) {
            return;
        }
        i.u((i)this.a).b.setProgress(n10);
        i10 = i.u((i)this.a).c;
        Context context = this.a.requireContext();
        Object object = n10;
        Object[] objectArray = new Object[]{object};
        object = g.n(context, 2131952832, objectArray);
        i10.setText((CharSequence)object);
    }
}

