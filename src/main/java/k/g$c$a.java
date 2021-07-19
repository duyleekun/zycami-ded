/*
 * Decompiled with CFR 0.151.
 */
package k;

import java.util.concurrent.CompletableFuture;
import k.d;
import k.f;
import k.g$c;
import k.r;

public class g$c$a
implements f {
    private final CompletableFuture a;
    public final /* synthetic */ g.c b;

    public g$c$a(g.c c10, CompletableFuture completableFuture) {
        this.b = c10;
        this.a = completableFuture;
    }

    public void onFailure(d d10, Throwable throwable) {
        this.a.completeExceptionally(throwable);
    }

    public void onResponse(d d10, r r10) {
        this.a.complete(r10);
    }
}

