/*
 * Decompiled with CFR 0.151.
 */
package d.q.a;

import d.q.a.b0;
import d.q.a.c0;
import java.util.concurrent.Callable;

public final class c
implements Callable {
    public final /* synthetic */ b0 a;

    public /* synthetic */ c(b0 b02) {
        this.a = b02;
    }

    public final Object call() {
        return c0.b(this.a);
    }
}

