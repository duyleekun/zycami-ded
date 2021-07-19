/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.w0;

import androidx.swiperefreshlayout.widget.SwipeRefreshLayout$OnRefreshListener;
import d.v.c.x0.c.d.j$a;

public class g8$a
implements SwipeRefreshLayout$OnRefreshListener {
    private j$a a;

    public g8$a a(j$a object) {
        this.a = object;
        object = object == null ? null : this;
        return object;
    }

    public void onRefresh() {
        this.a.b();
    }
}

