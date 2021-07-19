/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 */
package d.v.c.y1.f;

import android.view.View;
import androidx.fragment.app.FragmentManager;
import d.v.c.y1.f.p;
import d.v.c.y1.f.x.i0;
import d.v.c.y1.h.h;
import d.v.f.g.b;

public class p$b {
    public final /* synthetic */ p a;

    public p$b(p p10) {
        this.a = p10;
    }

    public void a(View object) {
        int n10 = 1;
        object = h.G(n10 != 0, 2, n10);
        FragmentManager fragmentManager = this.a.getChildFragmentManager();
        ((b)object).q(fragmentManager);
    }

    public void b(View object) {
        object = i0.z();
        FragmentManager fragmentManager = this.a.getChildFragmentManager();
        ((b)object).q(fragmentManager);
    }

    public void c(View view, int n10) {
        p.w(this.a).g(n10);
        p.x((p)this.a).j.setCurrentItem(n10);
    }
}

