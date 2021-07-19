/*
 * Decompiled with CFR 0.151.
 */
package b.b;

import androidx.room.QueryInterceptorDatabase;

public final class c0
implements Runnable {
    public final /* synthetic */ QueryInterceptorDatabase a;
    public final /* synthetic */ String b;

    public /* synthetic */ c0(QueryInterceptorDatabase queryInterceptorDatabase, String string2) {
        this.a = queryInterceptorDatabase;
        this.b = string2;
    }

    public final void run() {
        QueryInterceptorDatabase queryInterceptorDatabase = this.a;
        String string2 = this.b;
        queryInterceptorDatabase.p0(string2);
    }
}

