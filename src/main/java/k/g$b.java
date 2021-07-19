/*
 * Decompiled with CFR 0.151.
 */
package k;

import java.util.concurrent.CompletableFuture;
import k.d;

public final class g$b
extends CompletableFuture {
    private final d a;

    public g$b(d d10) {
        this.a = d10;
    }

    public boolean cancel(boolean bl2) {
        if (bl2) {
            d d10 = this.a;
            d10.cancel();
        }
        return super.cancel(bl2);
    }
}

