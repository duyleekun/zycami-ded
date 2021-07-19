/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.g;

import e.a.w0.g.g;
import java.util.concurrent.ThreadFactory;

public final class e$c
extends g {
    private long c = 0L;

    public e$c(ThreadFactory threadFactory) {
        super(threadFactory);
    }

    public long i() {
        return this.c;
    }

    public void j(long l10) {
        this.c = l10;
    }
}

