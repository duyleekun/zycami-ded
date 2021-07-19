/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data;

import com.zhiyun.cama.data.PagingRequestHelper;
import com.zhiyun.cama.data.PagingRequestHelper$e;
import java.util.concurrent.atomic.AtomicBoolean;

public class PagingRequestHelper$c$a {
    private final AtomicBoolean a;
    private final PagingRequestHelper.e b;
    private final PagingRequestHelper c;

    public PagingRequestHelper$c$a(PagingRequestHelper.e e10, PagingRequestHelper pagingRequestHelper) {
        AtomicBoolean atomicBoolean;
        this.a = atomicBoolean = new AtomicBoolean();
        this.b = e10;
        this.c = pagingRequestHelper;
    }

    public final void a(Throwable throwable, int n10, String string2) {
        Object object = this.a;
        PagingRequestHelper.e e10 = null;
        boolean bl2 = true;
        boolean bl3 = ((AtomicBoolean)object).compareAndSet(false, bl2);
        if (bl3) {
            object = this.c;
            e10 = this.b;
            ((PagingRequestHelper)object).h(e10, throwable, n10, string2);
            return;
        }
        throwable = new IllegalStateException("already called recordSuccess or recordFailure");
        throw throwable;
    }

    public final void b() {
        Object object = this.a;
        boolean bl2 = true;
        boolean bl3 = ((AtomicBoolean)object).compareAndSet(false, bl2);
        if (bl3) {
            object = this.c;
            PagingRequestHelper.e e10 = this.b;
            ((PagingRequestHelper)object).h(e10, null, 0, "");
            return;
        }
        object = new IllegalStateException("already called recordSuccess or recordFailure");
        throw object;
    }
}

