/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.v0.u.a0;

import com.zhiyun.cama.data.PagingRequestHelper$c$a;
import com.zhiyun.net.DataListEntity;
import d.v.c.v0.u.a0.e$a;

public final class b
implements Runnable {
    public final /* synthetic */ e$a a;
    public final /* synthetic */ int b;
    public final /* synthetic */ DataListEntity c;
    public final /* synthetic */ PagingRequestHelper$c$a d;

    public /* synthetic */ b(e$a e$a, int n10, DataListEntity dataListEntity, PagingRequestHelper$c$a pagingRequestHelper$c$a) {
        this.a = e$a;
        this.b = n10;
        this.c = dataListEntity;
        this.d = pagingRequestHelper$c$a;
    }

    public final void run() {
        e$a e$a = this.a;
        int n10 = this.b;
        DataListEntity dataListEntity = this.c;
        PagingRequestHelper$c$a pagingRequestHelper$c$a = this.d;
        e$a.d(n10, dataListEntity, pagingRequestHelper$c$a);
    }
}

