/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 */
package d.v.c.s0.h7.p0;

import android.view.View;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$LayoutManager;
import androidx.recyclerview.widget.RecyclerView$OnScrollListener;
import d.v.c.s0.h7.m0;
import d.v.c.s0.h7.p0.p;

public class p$a
extends RecyclerView$OnScrollListener {
    public final /* synthetic */ p a;

    public p$a(p p10) {
        this.a = p10;
    }

    public void onScrollStateChanged(RecyclerView object, int n10) {
        super.onScrollStateChanged((RecyclerView)object, n10);
        object = this.a;
        int n11 = p.j((p)object);
        if (n11 == 0) {
            return;
        }
        if (n10 == 0) {
            object = p.m(this.a);
            Object object2 = p.l(this.a);
            if ((object = ((LinearSnapHelper)object).findSnapView((RecyclerView$LayoutManager)object2)) == null) {
                return;
            }
            n11 = p.l(this.a).getPosition((View)object) + -1;
            if (n11 == (n10 = ((m0)(object2 = p.n(this.a))).m())) {
                return;
            }
            object2 = p.n(this.a);
            ((m0)object2).d0(n11);
        }
    }
}

