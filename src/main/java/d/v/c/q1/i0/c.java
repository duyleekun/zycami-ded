/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.q1.i0;

import androidx.lifecycle.Observer;
import com.zhiyun.cama.set.server.ServersFragment;
import com.zhiyun.net.DataListEntity;

public final class c
implements Observer {
    public final /* synthetic */ ServersFragment a;

    public /* synthetic */ c(ServersFragment serversFragment) {
        this.a = serversFragment;
    }

    public final void onChanged(Object object) {
        ServersFragment serversFragment = this.a;
        object = (DataListEntity)object;
        serversFragment.o((DataListEntity)object);
    }
}

