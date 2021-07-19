/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.w0;

import androidx.swiperefreshlayout.widget.SwipeRefreshLayout$OnRefreshListener;
import d.v.c.y1.f.v.j$a;

public class y6$a
implements SwipeRefreshLayout$OnRefreshListener {
    private j$a a;

    public y6$a a(j$a object) {
        this.a = object;
        object = object == null ? null : this;
        return object;
    }

    public void onRefresh() {
        this.a.b();
    }
}

