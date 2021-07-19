/*
 * Decompiled with CFR 0.151.
 */
package d.o.a.a.b.c;

import com.quvideo.mobile.external.platform.uploader.OooO0o;
import d.o.a.a.b.c.b$a;
import d.o.a.a.b.c.b$b;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class b
extends ThreadPoolExecutor {
    public b() {
        OooO0o oooO0o = new OooO0o();
        this(oooO0o);
    }

    private b(BlockingQueue blockingQueue) {
        TimeUnit timeUnit = TimeUnit.SECONDS;
        b$b b$b = new b$b();
        b$a b$a = new b$a();
        super(1, 1, 60, timeUnit, blockingQueue, b$b, b$a);
        this.allowCoreThreadTimeOut(true);
    }

    public void a(String string2) {
        OooO0o oooO0o = this.getQueue();
        boolean bl2 = oooO0o instanceof OooO0o;
        if (bl2) {
            oooO0o = oooO0o;
            oooO0o.OooO00o(string2);
        }
    }
}

