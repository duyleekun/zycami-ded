/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.w0;

import androidx.swiperefreshlayout.widget.SwipeRefreshLayout$OnRefreshListener;
import d.v.c.x0.b.p$b;

public class k9$a
implements SwipeRefreshLayout$OnRefreshListener {
    private p$b a;

    public k9$a a(p$b object) {
        this.a = object;
        object = object == null ? null : this;
        return object;
    }

    public void onRefresh() {
        this.a.b();
    }
}

