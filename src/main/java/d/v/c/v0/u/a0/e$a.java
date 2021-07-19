/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.v0.u.a0;

import com.zhiyun.cama.data.PagingRequestHelper$c$a;
import com.zhiyun.net.DataListEntity;
import d.v.c.v0.u.a0.a;
import d.v.c.v0.u.a0.b;
import d.v.c.v0.u.a0.e;
import java.util.ArrayList;
import java.util.concurrent.Executor;

public class e$a
extends d.v.a.f.b.a {
    public final /* synthetic */ int a;
    public final /* synthetic */ PagingRequestHelper$c$a b;
    public final /* synthetic */ e c;

    public e$a(e e10, int n10, PagingRequestHelper$c$a pagingRequestHelper$c$a) {
        this.c = e10;
        this.a = n10;
        this.b = pagingRequestHelper$c$a;
    }

    private /* synthetic */ void a(int n10) {
        int n11 = 1;
        if (n10 == n11) {
            e e10 = this.c;
            e10.e();
        }
    }

    private /* synthetic */ void c(int n10, DataListEntity object, PagingRequestHelper$c$a pagingRequestHelper$c$a) {
        e e10;
        int n11 = 1;
        if (n10 == n11) {
            e10 = this.c;
            e10.e();
        }
        if (object != null) {
            e10 = this.c;
            object = ((DataListEntity)object).list;
            e10.i((ArrayList)object);
        }
        pagingRequestHelper$c$a.b();
    }

    public /* synthetic */ void b(int n10) {
        this.a(n10);
    }

    public /* synthetic */ void d(int n10, DataListEntity dataListEntity, PagingRequestHelper$c$a pagingRequestHelper$c$a) {
        this.c(n10, dataListEntity, pagingRequestHelper$c$a);
    }

    public void e(DataListEntity dataListEntity) {
        Executor executor = e.a(this.c);
        int n10 = this.a;
        PagingRequestHelper$c$a pagingRequestHelper$c$a = this.b;
        b b10 = new b(this, n10, dataListEntity, pagingRequestHelper$c$a);
        executor.execute(b10);
    }

    public void onError(Throwable throwable, int n10, String string2) {
        int n11;
        Object object = this.c;
        int n12 = e.b((e)object);
        if (n12 == 0) {
            object = e.a(this.c);
            n11 = this.a;
            a a10 = new a(this, n11);
            object.execute(a10);
        }
        if ((n12 = this.a) > (n11 = 1)) {
            object = this.c;
            int n13 = e.c((e)object) - n11;
            e.d((e)object, n13);
        }
        this.b.a(throwable, n10, string2);
    }
}

