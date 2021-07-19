/*
 * Decompiled with CFR 0.151.
 */
package i.g;

import i.g.e;
import java.util.concurrent.Flow;

public final class a$h
implements e {
    public final Flow.Subscription a;

    public a$h(Flow.Subscription subscription) {
        this.a = subscription;
    }

    public void cancel() {
        this.a.cancel();
    }

    public void request(long l10) {
        this.a.request(l10);
    }
}

