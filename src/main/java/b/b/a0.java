/*
 * Decompiled with CFR 0.151.
 */
package b.b;

import androidx.room.QueryInterceptorDatabase;
import java.util.List;

public final class a0
implements Runnable {
    public final /* synthetic */ QueryInterceptorDatabase a;
    public final /* synthetic */ String b;
    public final /* synthetic */ List c;

    public /* synthetic */ a0(QueryInterceptorDatabase queryInterceptorDatabase, String string2, List list) {
        this.a = queryInterceptorDatabase;
        this.b = string2;
        this.c = list;
    }

    public final void run() {
        QueryInterceptorDatabase queryInterceptorDatabase = this.a;
        String string2 = this.b;
        List list = this.c;
        queryInterceptorDatabase.r0(string2, list);
    }
}

