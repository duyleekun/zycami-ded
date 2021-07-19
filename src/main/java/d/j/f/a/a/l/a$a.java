/*
 * Decompiled with CFR 0.151.
 */
package d.j.f.a.a.l;

import d.j.f.a.a.l.a;
import java.util.concurrent.CountDownLatch;

public class a$a
implements Runnable {
    public final /* synthetic */ CountDownLatch a;
    public final /* synthetic */ a b;

    public a$a(a a10, CountDownLatch countDownLatch) {
        this.b = a10;
        this.a = countDownLatch;
    }

    public void run() {
        a a10 = this.b;
        String string2 = d.j.f.a.a.l.a.a(a10).getUrl();
        a10.d(string2);
        this.a.countDown();
    }
}

