/*
 * Decompiled with CFR 0.151.
 */
package k;

import java.util.concurrent.CompletableFuture;
import k.d;
import k.f;
import k.g$a;
import k.r;
import retrofit2.HttpException;

public class g$a$a
implements f {
    private final CompletableFuture a;
    public final /* synthetic */ g.a b;

    public g$a$a(g.a a10, CompletableFuture completableFuture) {
        this.b = a10;
        this.a = completableFuture;
    }

    public void onFailure(d d10, Throwable throwable) {
        this.a.completeExceptionally(throwable);
    }

    public void onResponse(d object, r object2) {
        boolean bl2 = ((r)object2).g();
        if (bl2) {
            object = this.a;
            object2 = ((r)object2).a();
            ((CompletableFuture)object).complete(object2);
        } else {
            object = this.a;
            HttpException httpException = new HttpException((r)object2);
            ((CompletableFuture)object).completeExceptionally(httpException);
        }
    }
}

