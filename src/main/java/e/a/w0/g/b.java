/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.g;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public final class b
implements Future {
    public final e.a.s0.b a;

    public b(e.a.s0.b b10) {
        this.a = b10;
    }

    public boolean cancel(boolean bl2) {
        this.a.dispose();
        return false;
    }

    public Object get() {
        return null;
    }

    public Object get(long l10, TimeUnit timeUnit) {
        return null;
    }

    public boolean isCancelled() {
        return false;
    }

    public boolean isDone() {
        return false;
    }
}

