/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.functions;

import e.a.v0.a;
import java.util.concurrent.Future;

public final class Functions$v
implements a {
    public final Future a;

    public Functions$v(Future future) {
        this.a = future;
    }

    public void run() {
        this.a.get();
    }
}

