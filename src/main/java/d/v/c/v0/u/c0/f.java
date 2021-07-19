/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.v0.u.c0;

import com.kwai.auth.common.InternalResponse;
import com.zhiyun.cama.data.me.remote.KWaiManager$2;
import com.zhiyun.cama.data.me.remote.KWaiManager$OnKWaiLoginCallback;

public final class f
implements Runnable {
    public final /* synthetic */ KWaiManager$2 a;
    public final /* synthetic */ InternalResponse b;
    public final /* synthetic */ KWaiManager$OnKWaiLoginCallback c;

    public /* synthetic */ f(KWaiManager$2 kWaiManager$2, InternalResponse internalResponse, KWaiManager$OnKWaiLoginCallback kWaiManager$OnKWaiLoginCallback) {
        this.a = kWaiManager$2;
        this.b = internalResponse;
        this.c = kWaiManager$OnKWaiLoginCallback;
    }

    public final void run() {
        KWaiManager$2 kWaiManager$2 = this.a;
        InternalResponse internalResponse = this.b;
        KWaiManager$OnKWaiLoginCallback kWaiManager$OnKWaiLoginCallback = this.c;
        kWaiManager$2.b(internalResponse, kWaiManager$OnKWaiLoginCallback);
    }
}

