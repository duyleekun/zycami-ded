/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.w0;

import androidx.swiperefreshlayout.widget.SwipeRefreshLayout$OnRefreshListener;
import d.v.c.y1.f.v.i$a;

public class w5$a
implements SwipeRefreshLayout$OnRefreshListener {
    private i$a a;

    public w5$a a(i$a object) {
        this.a = object;
        object = object == null ? null : this;
        return object;
    }

    public void onRefresh() {
        this.a.c();
    }
}

