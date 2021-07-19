/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.b2;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$OnScrollListener;
import d.v.c.b2.u;
import d.v.c.b2.u$b;

public class u$a
extends RecyclerView$OnScrollListener {
    public final /* synthetic */ u a;

    public u$a(u u10) {
        this.a = u10;
    }

    public void onScrollStateChanged(RecyclerView recyclerView, int n10) {
        if (n10 != 0) {
            int n11 = 1;
            if (n10 != n11) {
                n11 = 2;
                if (n10 == n11) {
                    recyclerView = this.a;
                    u.d((u)recyclerView);
                }
            } else {
                recyclerView = this.a;
                u.b((u)recyclerView);
            }
        } else {
            recyclerView = this.a;
            u.a((u)recyclerView);
        }
    }

    public void onScrolled(RecyclerView recyclerView, int n10, int n11) {
        Object object = this.a;
        int n12 = u.e((u)object) + n10;
        u.f((u)object, n12);
        object = this.a;
        n12 = u.g((u)object) + n11;
        u.h((u)object, n12);
        object = this.a;
        n12 = 0;
        Object object2 = null;
        u.i((u)object, false);
        u.j(this.a, false);
        u.k(this.a, false);
        object = this.a;
        u.l((u)object, false);
        boolean bl2 = true;
        if (n10 > 0) {
            object2 = this.a;
            u.j((u)object2, bl2);
        } else if (n10 < 0) {
            object2 = this.a;
            u.i((u)object2, bl2);
        }
        if (n11 > 0) {
            object2 = this.a;
            u.l((u)object2, bl2);
        } else if (n11 < 0) {
            object2 = this.a;
            u.k((u)object2, bl2);
        }
        object = this.a;
        bl2 = u.m((u)object);
        if (bl2) {
            object = u.c(this.a).iterator();
            while ((n12 = (int)(object.hasNext() ? 1 : 0)) != 0) {
                object2 = (u$b)object.next();
                object2.e(recyclerView, n10, n11);
            }
        }
    }
}

