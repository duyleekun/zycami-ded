/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.w0;

import androidx.swiperefreshlayout.widget.SwipeRefreshLayout$OnRefreshListener;
import d.v.c.y1.f.w.f$a;

public class c7$a
implements SwipeRefreshLayout$OnRefreshListener {
    private f$a a;

    public c7$a a(f$a object) {
        this.a = object;
        object = object == null ? null : this;
        return object;
    }

    public void onRefresh() {
        this.a.b();
    }
}

