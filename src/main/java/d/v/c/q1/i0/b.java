/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.q1.i0;

import androidx.lifecycle.Observer;
import com.zhiyun.cama.set.server.ServersFragment;

public final class b
implements Observer {
    public final /* synthetic */ ServersFragment a;

    public /* synthetic */ b(ServersFragment serversFragment) {
        this.a = serversFragment;
    }

    public final void onChanged(Object object) {
        ServersFragment serversFragment = this.a;
        object = (Boolean)object;
        serversFragment.s((Boolean)object);
    }
}

