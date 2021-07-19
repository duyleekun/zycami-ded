/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.h1;

import androidx.lifecycle.Observer;
import androidx.paging.PagedList;
import d.v.c.h1.p;

public final class g
implements Observer {
    public final /* synthetic */ p a;

    public /* synthetic */ g(p p10) {
        this.a = p10;
    }

    public final void onChanged(Object object) {
        p p10 = this.a;
        object = (PagedList)object;
        p10.y((PagedList)object);
    }
}

