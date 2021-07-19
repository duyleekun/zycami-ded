/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.n1;

import androidx.lifecycle.Observer;
import com.zhiyun.cama.data.PagingRequestHelper$Status;
import d.v.c.n1.i2;

public final class v
implements Observer {
    public final /* synthetic */ i2 a;

    public /* synthetic */ v(i2 i22) {
        this.a = i22;
    }

    public final void onChanged(Object object) {
        i2 i22 = this.a;
        object = (PagingRequestHelper$Status)((Object)object);
        i22.N((PagingRequestHelper$Status)((Object)object));
    }
}

