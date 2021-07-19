/*
 * Decompiled with CFR 0.151.
 */
package i.g;

import i.g.e;
import java.util.concurrent.Flow;

public final class a$d
implements Flow.Subscription {
    public final e a;

    public a$d(e e10) {
        this.a = e10;
    }

    public void a() {
        this.a.cancel();
    }

    public void b(long l10) {
        this.a.request(l10);
    }
}

