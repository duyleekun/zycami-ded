/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.u1.n;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$OnScrollListener;
import d.v.c.u1.n.d0;
import m.a.a;

public class d0$b
extends RecyclerView$OnScrollListener {
    public final /* synthetic */ d0 a;

    public d0$b(d0 d02) {
        this.a = d02;
    }

    public void onScrollStateChanged(RecyclerView object, int n10) {
        Object object2 = n10;
        Object[] objectArray = new Object[]{object2};
        object2 = "onScrollStateChanged, newState %s";
        m.a.a.b((String)object2, objectArray);
        super.onScrollStateChanged((RecyclerView)object, n10);
        object = d0.z(this.a).getLayoutManager();
        int n11 = object instanceof LinearLayoutManager;
        if (n11 != 0) {
            object = (LinearLayoutManager)object;
            n11 = ((LinearLayoutManager)object).findFirstCompletelyVisibleItemPosition();
            int n12 = ((LinearLayoutManager)object).findLastVisibleItemPosition();
            object2 = this.a;
            ((d0)object2).H0(n11, n12, n10);
        }
    }
}

