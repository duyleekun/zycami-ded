/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.widget.AbsListView
 *  android.widget.AbsListView$OnScrollListener
 */
package d.c.a;

import android.widget.AbsListView;
import d.c.a.f$a;
import d.c.a.f$b;
import d.c.a.f$c;
import d.c.a.f$d;
import d.c.a.h;
import d.c.a.i;
import d.c.a.s.j.p;
import java.util.List;

public class f
implements AbsListView.OnScrollListener {
    private final int a;
    private final f$d b;
    private final i c;
    private final f$a d;
    private final f$b e;
    private int f;
    private int g;
    private int h = -1;
    private int i;
    private boolean j;

    public f(i object, f$a f$a, f$b f$b, int n10) {
        int n11 = 1;
        this.j = n11;
        this.c = object;
        this.d = f$a;
        this.e = f$b;
        this.a = n10;
        this.b = object = new f$d(n10 += n11);
    }

    private void a() {
        Object object;
        int n10;
        for (int i10 = 0; i10 < (n10 = (object = this.b.a).size()); ++i10) {
            object = this.c;
            f$c f$c = this.b.a(0, 0);
            ((i)object).z(f$c);
        }
    }

    private void b(int n10, int n11) {
        int n12;
        int n13;
        if (n10 < n11) {
            n13 = Math.max(this.f, n10);
            n12 = n11;
        } else {
            n12 = Math.min(this.g, n10);
            n13 = n11;
        }
        n12 = Math.min(this.i, n12);
        int bl2 = this.i;
        n13 = Math.max(0, n13);
        n13 = Math.min(bl2, n13);
        if (n10 < n11) {
            for (n10 = n13; n10 < n12; ++n10) {
                List list = this.d.a(n10);
                boolean bl3 = true;
                this.d(list, n10, bl3);
            }
        } else {
            for (n10 = n12 + -1; n10 >= n13; n10 += -1) {
                List list = this.d.a(n10);
                this.d(list, n10, false);
            }
        }
        this.g = n13;
        this.f = n12;
    }

    /*
     * WARNING - void declaration
     */
    private void c(int n10, boolean bl2) {
        void var2_5;
        boolean bl3 = this.j;
        if (bl3 != bl2) {
            this.j = bl2;
            this.a();
        }
        if (bl2) {
            int n11 = this.a;
        } else {
            int n12 = -this.a;
        }
        void var2_6 = var2_5 + n10;
        this.b(n10, (int)var2_6);
    }

    private void d(List list, int n10, boolean n11) {
        int n12 = list.size();
        if (n11 != 0) {
            Object var5_5 = null;
            for (n11 = 0; n11 < n12; ++n11) {
                Object e10 = list.get(n11);
                this.e(e10, n10, n11);
            }
        } else {
            n12 += -1;
            while (n12 >= 0) {
                Object e11 = list.get(n12);
                this.e(e11, n10, n12);
                n12 += -1;
            }
        }
    }

    private void e(Object object, int n10, int n11) {
        if (object == null) {
            return;
        }
        f$b f$b = this.e;
        Object object2 = f$b.a(object, n10, n11);
        if (object2 == null) {
            return;
        }
        Object object3 = this.d;
        if ((object = object3.b(object)) == null) {
            return;
        }
        object3 = this.b;
        int n12 = object2[0];
        n10 = object2[1];
        object2 = ((f$d)object3).a(n12, n10);
        ((h)object).j1((p)object2);
    }

    public void onScroll(AbsListView absListView, int n10, int n11, int n12) {
        this.i = n12;
        int n13 = this.h;
        if (n10 > n13) {
            n13 = 1;
            this.c(n11 += n10, n13 != 0);
        } else if (n10 < n13) {
            n13 = 0;
            this.c(n10, false);
        }
        this.h = n10;
    }

    public void onScrollStateChanged(AbsListView absListView, int n10) {
    }
}

