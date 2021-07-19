/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.v0.u.a0;

import androidx.lifecycle.LiveData;
import androidx.paging.PagedList$BoundaryCallback;
import com.zhiyun.cama.data.PagingRequestHelper;
import com.zhiyun.cama.data.PagingRequestHelper$RequestType;
import com.zhiyun.cama.data.PagingRequestHelper$c$a;
import d.v.c.v0.u.a0.c;
import d.v.c.v0.u.a0.d;
import d.v.c.v0.u.a0.e$a;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public abstract class e
extends PagedList$BoundaryCallback {
    private int a;
    private int b;
    private boolean c = false;
    private final Executor d;
    private final PagingRequestHelper e;
    private final LiveData f;

    public e(int n10) {
        PagingRequestHelper pagingRequestHelper;
        this.a = n10;
        Object object = Executors.newSingleThreadExecutor();
        this.d = object;
        this.e = pagingRequestHelper = new PagingRequestHelper((Executor)object);
        this.f = object = pagingRequestHelper.b();
    }

    public static /* synthetic */ Executor a(e e10) {
        return e10.d;
    }

    public static /* synthetic */ boolean b(e e10) {
        return e10.c;
    }

    public static /* synthetic */ int c(e e10) {
        return e10.b;
    }

    public static /* synthetic */ int d(e e10, int n10) {
        e10.b = n10;
        return n10;
    }

    private /* synthetic */ void k(PagingRequestHelper$c$a pagingRequestHelper$c$a) {
        int n10;
        this.b = n10 = this.b + 1;
        int n11 = this.a;
        this.o(n10, n11, pagingRequestHelper$c$a);
    }

    private /* synthetic */ void m(PagingRequestHelper$c$a pagingRequestHelper$c$a) {
        int n10;
        this.b = n10 = 1;
        int n11 = this.a;
        this.o(n10, n11, pagingRequestHelper$c$a);
    }

    private void o(int n10, int n11, PagingRequestHelper$c$a pagingRequestHelper$c$a) {
        k.d d10 = this.f(n10, n11);
        e$a e$a = new e$a(this, n10, pagingRequestHelper$c$a);
        d10.h(e$a);
    }

    public abstract void e();

    public abstract k.d f(int var1, int var2);

    public PagingRequestHelper g() {
        return this.e;
    }

    public LiveData h() {
        return this.f;
    }

    public abstract void i(ArrayList var1);

    public boolean j() {
        return this.c;
    }

    public /* synthetic */ void l(PagingRequestHelper$c$a pagingRequestHelper$c$a) {
        this.k(pagingRequestHelper$c$a);
    }

    public /* synthetic */ void n(PagingRequestHelper$c$a pagingRequestHelper$c$a) {
        this.m(pagingRequestHelper$c$a);
    }

    public void onItemAtEndLoaded(Object object) {
        object = this.e;
        PagingRequestHelper$RequestType pagingRequestHelper$RequestType = PagingRequestHelper$RequestType.AFTER;
        c c10 = new c(this);
        ((PagingRequestHelper)object).k(pagingRequestHelper$RequestType, c10);
    }

    public void onZeroItemsLoaded() {
        PagingRequestHelper pagingRequestHelper = this.e;
        PagingRequestHelper$RequestType pagingRequestHelper$RequestType = PagingRequestHelper$RequestType.INITIAL;
        d d10 = new d(this);
        pagingRequestHelper.k(pagingRequestHelper$RequestType, d10);
    }

    public void p(boolean bl2) {
        this.c = bl2;
    }
}

