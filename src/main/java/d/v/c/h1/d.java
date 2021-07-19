/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.h1;

import androidx.lifecycle.Observer;
import com.zhiyun.cama.data.PagingRequestHelper$b;
import d.v.c.h1.p;

public final class d
implements Observer {
    public final /* synthetic */ p a;

    public /* synthetic */ d(p p10) {
        this.a = p10;
    }

    public final void onChanged(Object object) {
        p p10 = this.a;
        object = (PagingRequestHelper$b)object;
        p.w(p10, (PagingRequestHelper$b)object);
    }
}

