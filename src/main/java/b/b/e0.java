/*
 * Decompiled with CFR 0.151.
 */
package b.b;

import androidx.room.QueryInterceptorDatabase;

public final class e0
implements Runnable {
    public final /* synthetic */ QueryInterceptorDatabase a;
    public final /* synthetic */ String b;

    public /* synthetic */ e0(QueryInterceptorDatabase queryInterceptorDatabase, String string2) {
        this.a = queryInterceptorDatabase;
        this.b = string2;
    }

    public final void run() {
        QueryInterceptorDatabase queryInterceptorDatabase = this.a;
        String string2 = this.b;
        queryInterceptorDatabase.t0(string2);
    }
}

