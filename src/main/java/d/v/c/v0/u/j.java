/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.v0.u;

import com.zhiyun.cama.data.MessagePageType;
import d.v.c.v0.u.v;

public final class j
implements Runnable {
    public final /* synthetic */ v a;
    public final /* synthetic */ MessagePageType b;

    public /* synthetic */ j(v v10, MessagePageType messagePageType) {
        this.a = v10;
        this.b = messagePageType;
    }

    public final void run() {
        v v10 = this.a;
        MessagePageType messagePageType = this.b;
        v10.P(messagePageType);
    }
}

