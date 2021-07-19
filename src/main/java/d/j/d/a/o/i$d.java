/*
 * Decompiled with CFR 0.151.
 */
package d.j.d.a.o;

import d.j.d.a.f;
import d.j.d.a.h;
import d.j.d.a.i;
import java.util.concurrent.CountDownLatch;

public final class i$d
implements f,
h,
i {
    public final CountDownLatch a;

    public i$d() {
        CountDownLatch countDownLatch;
        this.a = countDownLatch = new CountDownLatch(1);
    }

    public final void onCanceled() {
        this.a.countDown();
    }

    public final void onFailure(Exception exception) {
        this.a.countDown();
    }

    public final void onSuccess(Object object) {
        this.a.countDown();
    }
}

