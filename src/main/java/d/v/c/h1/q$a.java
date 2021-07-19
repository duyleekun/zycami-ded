/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.h1;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$OnScrollListener;
import d.v.c.h1.q;

public class q$a
extends RecyclerView$OnScrollListener {
    public final /* synthetic */ q a;

    public q$a(q q10) {
        this.a = q10;
    }

    public void onScrollStateChanged(RecyclerView recyclerView, int n10) {
        super.onScrollStateChanged(recyclerView, n10);
        if (n10 == 0) {
            q q10 = this.a;
            q.j(q10, recyclerView);
        }
    }

    public void onScrolled(RecyclerView recyclerView, int n10, int n11) {
        super.onScrolled(recyclerView, n10, n11);
        n10 = (int)(recyclerView.canScrollVertically(1) ? 1 : 0);
        if (n10 != 0) {
            q q10 = this.a;
            q.j(q10, recyclerView);
        }
    }
}

