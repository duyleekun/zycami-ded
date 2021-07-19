/*
 * Decompiled with CFR 0.151.
 */
package b.b;

import androidx.room.QueryInterceptorDatabase;
import androidx.room.QueryInterceptorProgram;
import androidx.sqlite.db.SupportSQLiteQuery;

public final class d0
implements Runnable {
    public final /* synthetic */ QueryInterceptorDatabase a;
    public final /* synthetic */ SupportSQLiteQuery b;
    public final /* synthetic */ QueryInterceptorProgram c;

    public /* synthetic */ d0(QueryInterceptorDatabase queryInterceptorDatabase, SupportSQLiteQuery supportSQLiteQuery, QueryInterceptorProgram queryInterceptorProgram) {
        this.a = queryInterceptorDatabase;
        this.b = supportSQLiteQuery;
        this.c = queryInterceptorProgram;
    }

    public final void run() {
        QueryInterceptorDatabase queryInterceptorDatabase = this.a;
        SupportSQLiteQuery supportSQLiteQuery = this.b;
        QueryInterceptorProgram queryInterceptorProgram = this.c;
        queryInterceptorDatabase.x0(supportSQLiteQuery, queryInterceptorProgram);
    }
}

