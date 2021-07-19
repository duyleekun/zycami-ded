/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.v0.q;

import com.zhiyun.net.download.DownLoadHelper$CancelControl;
import d.v.c.v0.q.b$a;
import d.v.c.v0.q.c;
import k.r;

public final class a
implements Runnable {
    public final /* synthetic */ b$a a;
    public final /* synthetic */ c b;
    public final /* synthetic */ r c;
    public final /* synthetic */ DownLoadHelper$CancelControl d;

    public /* synthetic */ a(b$a a10, c c10, r r10, DownLoadHelper$CancelControl downLoadHelper$CancelControl) {
        this.a = a10;
        this.b = c10;
        this.c = r10;
        this.d = downLoadHelper$CancelControl;
    }

    public final void run() {
        b$a b$a = this.a;
        c c10 = this.b;
        r r10 = this.c;
        DownLoadHelper$CancelControl downLoadHelper$CancelControl = this.d;
        b$a.b(c10, r10, downLoadHelper$CancelControl);
    }
}

