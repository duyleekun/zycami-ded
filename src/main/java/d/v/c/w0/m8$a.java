/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.w0;

import androidx.swiperefreshlayout.widget.SwipeRefreshLayout$OnRefreshListener;
import d.v.c.x0.c.f.k$a;

public class m8$a
implements SwipeRefreshLayout$OnRefreshListener {
    private k$a a;

    public m8$a a(k$a object) {
        this.a = object;
        object = object == null ? null : this;
        return object;
    }

    public void onRefresh() {
        this.a.b();
    }
}

