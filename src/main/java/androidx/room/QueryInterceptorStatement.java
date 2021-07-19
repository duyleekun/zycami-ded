/*
 * Decompiled with CFR 0.151.
 */
package androidx.room;

import androidx.room.RoomDatabase$QueryCallback;
import androidx.sqlite.db.SupportSQLiteStatement;
import b.b.j0;
import b.b.k0;
import b.b.l0;
import b.b.m0;
import b.b.n0;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

public final class QueryInterceptorStatement
implements SupportSQLiteStatement {
    private final List mBindArgsCache;
    private final SupportSQLiteStatement mDelegate;
    private final RoomDatabase$QueryCallback mQueryCallback;
    private final Executor mQueryCallbackExecutor;
    private final String mSqlStatement;

    public QueryInterceptorStatement(SupportSQLiteStatement supportSQLiteStatement, RoomDatabase$QueryCallback roomDatabase$QueryCallback, String string2, Executor executor) {
        ArrayList arrayList;
        this.mBindArgsCache = arrayList = new ArrayList();
        this.mDelegate = supportSQLiteStatement;
        this.mQueryCallback = roomDatabase$QueryCallback;
        this.mSqlStatement = string2;
        this.mQueryCallbackExecutor = executor;
    }

    private /* synthetic */ void C() {
        RoomDatabase$QueryCallback roomDatabase$QueryCallback = this.mQueryCallback;
        String string2 = this.mSqlStatement;
        List list = this.mBindArgsCache;
        roomDatabase$QueryCallback.onQuery(string2, list);
    }

    private /* synthetic */ void E() {
        RoomDatabase$QueryCallback roomDatabase$QueryCallback = this.mQueryCallback;
        String string2 = this.mSqlStatement;
        List list = this.mBindArgsCache;
        roomDatabase$QueryCallback.onQuery(string2, list);
    }

    private /* synthetic */ void S() {
        RoomDatabase$QueryCallback roomDatabase$QueryCallback = this.mQueryCallback;
        String string2 = this.mSqlStatement;
        List list = this.mBindArgsCache;
        roomDatabase$QueryCallback.onQuery(string2, list);
    }

    private /* synthetic */ void a() {
        RoomDatabase$QueryCallback roomDatabase$QueryCallback = this.mQueryCallback;
        String string2 = this.mSqlStatement;
        List list = this.mBindArgsCache;
        roomDatabase$QueryCallback.onQuery(string2, list);
    }

    private /* synthetic */ void q() {
        RoomDatabase$QueryCallback roomDatabase$QueryCallback = this.mQueryCallback;
        String string2 = this.mSqlStatement;
        List list = this.mBindArgsCache;
        roomDatabase$QueryCallback.onQuery(string2, list);
    }

    private void saveArgsToCache(int n10, Object object) {
        List list = this.mBindArgsCache;
        int n11 = list.size();
        if ((n10 += -1) >= n11) {
            list = this.mBindArgsCache;
            for (n11 = list.size(); n11 <= n10; ++n11) {
                List list2 = this.mBindArgsCache;
                list2.add(null);
            }
        }
        this.mBindArgsCache.set(n10, object);
    }

    public /* synthetic */ void B() {
        this.q();
    }

    public /* synthetic */ void D() {
        this.C();
    }

    public /* synthetic */ void O() {
        this.E();
    }

    public void bindBlob(int n10, byte[] byArray) {
        this.saveArgsToCache(n10, byArray);
        this.mDelegate.bindBlob(n10, byArray);
    }

    public void bindDouble(int n10, double d10) {
        Double d11 = d10;
        this.saveArgsToCache(n10, d11);
        this.mDelegate.bindDouble(n10, d10);
    }

    public void bindLong(int n10, long l10) {
        Long l11 = l10;
        this.saveArgsToCache(n10, l11);
        this.mDelegate.bindLong(n10, l10);
    }

    public void bindNull(int n10) {
        Object[] objectArray = this.mBindArgsCache.toArray();
        this.saveArgsToCache(n10, objectArray);
        this.mDelegate.bindNull(n10);
    }

    public void bindString(int n10, String string2) {
        this.saveArgsToCache(n10, string2);
        this.mDelegate.bindString(n10, string2);
    }

    public void clearBindings() {
        this.mBindArgsCache.clear();
        this.mDelegate.clearBindings();
    }

    public void close() {
        this.mDelegate.close();
    }

    public void execute() {
        Executor executor = this.mQueryCallbackExecutor;
        k0 k02 = new k0(this);
        executor.execute(k02);
        this.mDelegate.execute();
    }

    public long executeInsert() {
        Executor executor = this.mQueryCallbackExecutor;
        l0 l02 = new l0(this);
        executor.execute(l02);
        return this.mDelegate.executeInsert();
    }

    public int executeUpdateDelete() {
        Executor executor = this.mQueryCallbackExecutor;
        m0 m02 = new m0(this);
        executor.execute(m02);
        return this.mDelegate.executeUpdateDelete();
    }

    public /* synthetic */ void h() {
        this.a();
    }

    public /* synthetic */ void n0() {
        this.S();
    }

    public long simpleQueryForLong() {
        Executor executor = this.mQueryCallbackExecutor;
        n0 n02 = new n0(this);
        executor.execute(n02);
        return this.mDelegate.simpleQueryForLong();
    }

    public String simpleQueryForString() {
        Executor executor = this.mQueryCallbackExecutor;
        j0 j02 = new j0(this);
        executor.execute(j02);
        return this.mDelegate.simpleQueryForString();
    }
}

