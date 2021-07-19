/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.v0.u;

import com.zhiyun.cama.data.MessagePageType;
import d.v.c.v0.u.v$e;

public final class b
implements Runnable {
    public final /* synthetic */ v$e a;
    public final /* synthetic */ MessagePageType b;
    public final /* synthetic */ int c;

    public /* synthetic */ b(v$e e10, MessagePageType messagePageType, int n10) {
        this.a = e10;
        this.b = messagePageType;
        this.c = n10;
    }

    public final void run() {
        v$e v$e = this.a;
        MessagePageType messagePageType = this.b;
        int n10 = this.c;
        v$e.b(messagePageType, n10);
    }
}

