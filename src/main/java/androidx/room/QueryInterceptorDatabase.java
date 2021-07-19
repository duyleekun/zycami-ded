/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ContentValues
 *  android.database.Cursor
 *  android.database.sqlite.SQLiteTransactionListener
 *  android.os.CancellationSignal
 */
package androidx.room;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteTransactionListener;
import android.os.CancellationSignal;
import androidx.room.QueryInterceptorProgram;
import androidx.room.QueryInterceptorStatement;
import androidx.room.RoomDatabase$QueryCallback;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteProgram;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteStatement;
import b.b.a0;
import b.b.b0;
import b.b.c0;
import b.b.d0;
import b.b.e0;
import b.b.f0;
import b.b.g0;
import b.b.h0;
import b.b.i0;
import b.b.x;
import b.b.y;
import b.b.z;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Executor;

public final class QueryInterceptorDatabase
implements SupportSQLiteDatabase {
    private final SupportSQLiteDatabase mDelegate;
    private final RoomDatabase$QueryCallback mQueryCallback;
    private final Executor mQueryCallbackExecutor;

    public QueryInterceptorDatabase(SupportSQLiteDatabase supportSQLiteDatabase, RoomDatabase$QueryCallback roomDatabase$QueryCallback, Executor executor) {
        this.mDelegate = supportSQLiteDatabase;
        this.mQueryCallback = roomDatabase$QueryCallback;
        this.mQueryCallbackExecutor = executor;
    }

    private /* synthetic */ void A0() {
        RoomDatabase$QueryCallback roomDatabase$QueryCallback = this.mQueryCallback;
        List list = Collections.emptyList();
        roomDatabase$QueryCallback.onQuery("TRANSACTION SUCCESSFUL", list);
    }

    private /* synthetic */ void C() {
        RoomDatabase$QueryCallback roomDatabase$QueryCallback = this.mQueryCallback;
        List list = Collections.emptyList();
        roomDatabase$QueryCallback.onQuery("BEGIN EXCLUSIVE TRANSACTION", list);
    }

    private /* synthetic */ void E() {
        RoomDatabase$QueryCallback roomDatabase$QueryCallback = this.mQueryCallback;
        List list = Collections.emptyList();
        roomDatabase$QueryCallback.onQuery("BEGIN DEFERRED TRANSACTION", list);
    }

    private /* synthetic */ void S() {
        RoomDatabase$QueryCallback roomDatabase$QueryCallback = this.mQueryCallback;
        List list = Collections.emptyList();
        roomDatabase$QueryCallback.onQuery("END TRANSACTION", list);
    }

    private /* synthetic */ void a() {
        RoomDatabase$QueryCallback roomDatabase$QueryCallback = this.mQueryCallback;
        List list = Collections.emptyList();
        roomDatabase$QueryCallback.onQuery("BEGIN EXCLUSIVE TRANSACTION", list);
    }

    private /* synthetic */ void o0(String string2) {
        RoomDatabase$QueryCallback roomDatabase$QueryCallback = this.mQueryCallback;
        ArrayList arrayList = new ArrayList(0);
        roomDatabase$QueryCallback.onQuery(string2, arrayList);
    }

    private /* synthetic */ void q() {
        RoomDatabase$QueryCallback roomDatabase$QueryCallback = this.mQueryCallback;
        List list = Collections.emptyList();
        roomDatabase$QueryCallback.onQuery("BEGIN DEFERRED TRANSACTION", list);
    }

    private /* synthetic */ void q0(String string2, List list) {
        this.mQueryCallback.onQuery(string2, list);
    }

    private /* synthetic */ void s0(String string2) {
        RoomDatabase$QueryCallback roomDatabase$QueryCallback = this.mQueryCallback;
        List list = Collections.emptyList();
        roomDatabase$QueryCallback.onQuery(string2, list);
    }

    private /* synthetic */ void u0(String string2, List list) {
        this.mQueryCallback.onQuery(string2, list);
    }

    private /* synthetic */ void w0(SupportSQLiteQuery object, QueryInterceptorProgram object2) {
        RoomDatabase$QueryCallback roomDatabase$QueryCallback = this.mQueryCallback;
        object = object.getSql();
        object2 = ((QueryInterceptorProgram)object2).getBindArgs();
        roomDatabase$QueryCallback.onQuery((String)object, (List)object2);
    }

    private /* synthetic */ void y0(SupportSQLiteQuery object, QueryInterceptorProgram object2) {
        RoomDatabase$QueryCallback roomDatabase$QueryCallback = this.mQueryCallback;
        object = object.getSql();
        object2 = ((QueryInterceptorProgram)object2).getBindArgs();
        roomDatabase$QueryCallback.onQuery((String)object, (List)object2);
    }

    public /* synthetic */ void B() {
        this.q();
    }

    public /* synthetic */ void B0() {
        this.A0();
    }

    public /* synthetic */ void D() {
        this.C();
    }

    public /* synthetic */ void O() {
        this.E();
    }

    public void beginTransaction() {
        Executor executor = this.mQueryCallbackExecutor;
        h0 h02 = new h0(this);
        executor.execute(h02);
        this.mDelegate.beginTransaction();
    }

    public void beginTransactionNonExclusive() {
        Executor executor = this.mQueryCallbackExecutor;
        y y10 = new y(this);
        executor.execute(y10);
        this.mDelegate.beginTransactionNonExclusive();
    }

    public void beginTransactionWithListener(SQLiteTransactionListener sQLiteTransactionListener) {
        Executor executor = this.mQueryCallbackExecutor;
        i0 i02 = new i0(this);
        executor.execute(i02);
        this.mDelegate.beginTransactionWithListener(sQLiteTransactionListener);
    }

    public void beginTransactionWithListenerNonExclusive(SQLiteTransactionListener sQLiteTransactionListener) {
        Executor executor = this.mQueryCallbackExecutor;
        b0 b02 = new b0(this);
        executor.execute(b02);
        this.mDelegate.beginTransactionWithListenerNonExclusive(sQLiteTransactionListener);
    }

    public void close() {
        this.mDelegate.close();
    }

    public SupportSQLiteStatement compileStatement(String string2) {
        SupportSQLiteStatement supportSQLiteStatement = this.mDelegate.compileStatement(string2);
        RoomDatabase$QueryCallback roomDatabase$QueryCallback = this.mQueryCallback;
        Executor executor = this.mQueryCallbackExecutor;
        QueryInterceptorStatement queryInterceptorStatement = new QueryInterceptorStatement(supportSQLiteStatement, roomDatabase$QueryCallback, string2, executor);
        return queryInterceptorStatement;
    }

    public int delete(String string2, String string3, Object[] objectArray) {
        return this.mDelegate.delete(string2, string3, objectArray);
    }

    public void disableWriteAheadLogging() {
        this.mDelegate.disableWriteAheadLogging();
    }

    public boolean enableWriteAheadLogging() {
        return this.mDelegate.enableWriteAheadLogging();
    }

    public void endTransaction() {
        Executor executor = this.mQueryCallbackExecutor;
        x x10 = new x(this);
        executor.execute(x10);
        this.mDelegate.endTransaction();
    }

    public void execSQL(String string2) {
        Executor executor = this.mQueryCallbackExecutor;
        c0 c02 = new c0(this, string2);
        executor.execute(c02);
        this.mDelegate.execSQL(string2);
    }

    public void execSQL(String string2, Object[] object) {
        Object[] objectArray = new ArrayList();
        object = Arrays.asList(object);
        objectArray.addAll(object);
        object = this.mQueryCallbackExecutor;
        a0 a02 = new a0(this, string2, (List)objectArray);
        object.execute(a02);
        object = this.mDelegate;
        objectArray = objectArray.toArray();
        object.execSQL(string2, objectArray);
    }

    public List getAttachedDbs() {
        return this.mDelegate.getAttachedDbs();
    }

    public long getMaximumSize() {
        return this.mDelegate.getMaximumSize();
    }

    public long getPageSize() {
        return this.mDelegate.getPageSize();
    }

    public String getPath() {
        return this.mDelegate.getPath();
    }

    public int getVersion() {
        return this.mDelegate.getVersion();
    }

    public /* synthetic */ void h() {
        this.a();
    }

    public boolean inTransaction() {
        return this.mDelegate.inTransaction();
    }

    public long insert(String string2, int n10, ContentValues contentValues) {
        return this.mDelegate.insert(string2, n10, contentValues);
    }

    public boolean isDatabaseIntegrityOk() {
        return this.mDelegate.isDatabaseIntegrityOk();
    }

    public boolean isDbLockedByCurrentThread() {
        return this.mDelegate.isDbLockedByCurrentThread();
    }

    public boolean isOpen() {
        return this.mDelegate.isOpen();
    }

    public boolean isReadOnly() {
        return this.mDelegate.isReadOnly();
    }

    public boolean isWriteAheadLoggingEnabled() {
        return this.mDelegate.isWriteAheadLoggingEnabled();
    }

    public /* synthetic */ void n0() {
        this.S();
    }

    public boolean needUpgrade(int n10) {
        return this.mDelegate.needUpgrade(n10);
    }

    public /* synthetic */ void p0(String string2) {
        this.o0(string2);
    }

    public Cursor query(SupportSQLiteQuery supportSQLiteQuery) {
        QueryInterceptorProgram queryInterceptorProgram = new QueryInterceptorProgram();
        supportSQLiteQuery.bindTo(queryInterceptorProgram);
        Executor executor = this.mQueryCallbackExecutor;
        d0 d02 = new d0(this, supportSQLiteQuery, queryInterceptorProgram);
        executor.execute(d02);
        return this.mDelegate.query(supportSQLiteQuery);
    }

    public Cursor query(SupportSQLiteQuery supportSQLiteQuery, CancellationSignal object) {
        object = new QueryInterceptorProgram();
        supportSQLiteQuery.bindTo((SupportSQLiteProgram)object);
        Executor executor = this.mQueryCallbackExecutor;
        g0 g02 = new g0(this, supportSQLiteQuery, (QueryInterceptorProgram)object);
        executor.execute(g02);
        return this.mDelegate.query(supportSQLiteQuery);
    }

    public Cursor query(String string2) {
        Executor executor = this.mQueryCallbackExecutor;
        e0 e02 = new e0(this, string2);
        executor.execute(e02);
        return this.mDelegate.query(string2);
    }

    public Cursor query(String string2, Object[] objectArray) {
        ArrayList<Object> arrayList = new ArrayList<Object>();
        Object object = Arrays.asList(objectArray);
        arrayList.addAll((Collection<Object>)object);
        object = this.mQueryCallbackExecutor;
        f0 f02 = new f0(this, string2, arrayList);
        object.execute(f02);
        return this.mDelegate.query(string2, objectArray);
    }

    public /* synthetic */ void r0(String string2, List list) {
        this.q0(string2, list);
    }

    public void setForeignKeyConstraintsEnabled(boolean bl2) {
        this.mDelegate.setForeignKeyConstraintsEnabled(bl2);
    }

    public void setLocale(Locale locale) {
        this.mDelegate.setLocale(locale);
    }

    public void setMaxSqlCacheSize(int n10) {
        this.mDelegate.setMaxSqlCacheSize(n10);
    }

    public long setMaximumSize(long l10) {
        return this.mDelegate.setMaximumSize(l10);
    }

    public void setPageSize(long l10) {
        this.mDelegate.setPageSize(l10);
    }

    public void setTransactionSuccessful() {
        Executor executor = this.mQueryCallbackExecutor;
        z z10 = new z(this);
        executor.execute(z10);
        this.mDelegate.setTransactionSuccessful();
    }

    public void setVersion(int n10) {
        this.mDelegate.setVersion(n10);
    }

    public /* synthetic */ void t0(String string2) {
        this.s0(string2);
    }

    public int update(String string2, int n10, ContentValues contentValues, String string3, Object[] objectArray) {
        return this.mDelegate.update(string2, n10, contentValues, string3, objectArray);
    }

    public /* synthetic */ void v0(String string2, List list) {
        this.u0(string2, list);
    }

    public /* synthetic */ void x0(SupportSQLiteQuery supportSQLiteQuery, QueryInterceptorProgram queryInterceptorProgram) {
        this.w0(supportSQLiteQuery, queryInterceptorProgram);
    }

    public boolean yieldIfContendedSafely() {
        return this.mDelegate.yieldIfContendedSafely();
    }

    public boolean yieldIfContendedSafely(long l10) {
        return this.mDelegate.yieldIfContendedSafely(l10);
    }

    public /* synthetic */ void z0(SupportSQLiteQuery supportSQLiteQuery, QueryInterceptorProgram queryInterceptorProgram) {
        this.y0(supportSQLiteQuery, queryInterceptorProgram);
    }
}

