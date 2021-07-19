/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data;

import com.zhiyun.cama.data.PagingRequestHelper;
import com.zhiyun.cama.data.PagingRequestHelper$RequestType;
import com.zhiyun.cama.data.PagingRequestHelper$c;
import com.zhiyun.cama.data.PagingRequestHelper$c$a;
import d.v.c.v0.a;
import java.util.concurrent.Executor;

public class PagingRequestHelper$e
implements Runnable {
    public final PagingRequestHelper$c a;
    public final PagingRequestHelper b;
    public final PagingRequestHelper$RequestType c;

    public PagingRequestHelper$e(PagingRequestHelper$c pagingRequestHelper$c, PagingRequestHelper pagingRequestHelper, PagingRequestHelper$RequestType pagingRequestHelper$RequestType) {
        this.a = pagingRequestHelper$c;
        this.b = pagingRequestHelper;
        this.c = pagingRequestHelper$RequestType;
    }

    private /* synthetic */ void a() {
        PagingRequestHelper pagingRequestHelper = this.b;
        PagingRequestHelper$RequestType pagingRequestHelper$RequestType = this.c;
        PagingRequestHelper$c pagingRequestHelper$c = this.a;
        pagingRequestHelper.k(pagingRequestHelper$RequestType, pagingRequestHelper$c);
    }

    public /* synthetic */ void b() {
        this.a();
    }

    public void c(Executor executor) {
        a a10 = new a(this);
        executor.execute(a10);
    }

    public void run() {
        PagingRequestHelper$c pagingRequestHelper$c = this.a;
        PagingRequestHelper pagingRequestHelper = this.b;
        PagingRequestHelper$c$a pagingRequestHelper$c$a = new PagingRequestHelper$c$a(this, pagingRequestHelper);
        pagingRequestHelper$c.a(pagingRequestHelper$c$a);
    }
}

