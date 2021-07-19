/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ContentValues
 *  android.database.Cursor
 *  android.database.sqlite.SQLiteTransactionListener
 *  android.os.Build$VERSION
 *  android.os.CancellationSignal
 */
package androidx.room;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteTransactionListener;
import android.os.Build;
import android.os.CancellationSignal;
import androidx.room.AutoCloser;
import androidx.room.AutoClosingRoomOpenHelper$AutoClosingSupportSqliteStatement;
import androidx.room.AutoClosingRoomOpenHelper$KeepAliveCursor;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteStatement;
import b.b.a;
import b.b.b;
import b.b.c;
import b.b.d;
import b.b.e;
import b.b.f;
import b.b.g;
import b.b.h;
import b.b.i;
import b.b.j;
import b.b.k;
import b.b.l;
import b.b.m;
import b.b.n;
import b.b.o;
import b.b.p;
import b.b.q;
import b.b.r;
import b.b.r0;
import b.b.s;
import b.b.s0;
import b.b.u0;
import b.b.v;
import b.b.v0;
import java.util.List;
import java.util.Locale;

public final class AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase
implements SupportSQLiteDatabase {
    private final AutoCloser mAutoCloser;

    public AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase(AutoCloser autoCloser) {
        this.mAutoCloser = autoCloser;
    }

    public static /* synthetic */ Long B(String string2, int n10, ContentValues contentValues, SupportSQLiteDatabase supportSQLiteDatabase) {
        return supportSQLiteDatabase.insert(string2, n10, contentValues);
    }

    public static /* synthetic */ Boolean C(SupportSQLiteDatabase supportSQLiteDatabase) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 16;
        if (n10 >= n11) {
            return supportSQLiteDatabase.isWriteAheadLoggingEnabled();
        }
        return Boolean.FALSE;
    }

    public static /* synthetic */ Boolean D(int n10, SupportSQLiteDatabase supportSQLiteDatabase) {
        return supportSQLiteDatabase.needUpgrade(n10);
    }

    public static /* synthetic */ Object E(SupportSQLiteDatabase supportSQLiteDatabase) {
        return null;
    }

    public static /* synthetic */ Object O(boolean bl2, SupportSQLiteDatabase supportSQLiteDatabase) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 16;
        if (n10 >= n11) {
            supportSQLiteDatabase.setForeignKeyConstraintsEnabled(bl2);
        }
        return null;
    }

    public static /* synthetic */ Object S(Locale locale, SupportSQLiteDatabase supportSQLiteDatabase) {
        supportSQLiteDatabase.setLocale(locale);
        return null;
    }

    public static /* synthetic */ Integer a(String string2, String string3, Object[] objectArray, SupportSQLiteDatabase supportSQLiteDatabase) {
        return supportSQLiteDatabase.delete(string2, string3, objectArray);
    }

    public static /* synthetic */ Object h(String string2, SupportSQLiteDatabase supportSQLiteDatabase) {
        supportSQLiteDatabase.execSQL(string2);
        return null;
    }

    public static /* synthetic */ Object n0(int n10, SupportSQLiteDatabase supportSQLiteDatabase) {
        supportSQLiteDatabase.setMaxSqlCacheSize(n10);
        return null;
    }

    public static /* synthetic */ Long o0(long l10, SupportSQLiteDatabase supportSQLiteDatabase) {
        return supportSQLiteDatabase.setMaximumSize(l10);
    }

    public static /* synthetic */ Object p0(long l10, SupportSQLiteDatabase supportSQLiteDatabase) {
        supportSQLiteDatabase.setPageSize(l10);
        return null;
    }

    public static /* synthetic */ Object q(String string2, Object[] objectArray, SupportSQLiteDatabase supportSQLiteDatabase) {
        supportSQLiteDatabase.execSQL(string2, objectArray);
        return null;
    }

    public static /* synthetic */ Object q0(int n10, SupportSQLiteDatabase supportSQLiteDatabase) {
        supportSQLiteDatabase.setVersion(n10);
        return null;
    }

    public static /* synthetic */ Integer r0(String string2, int n10, ContentValues contentValues, String string3, Object[] objectArray, SupportSQLiteDatabase supportSQLiteDatabase) {
        return supportSQLiteDatabase.update(string2, n10, contentValues, string3, objectArray);
    }

    public void beginTransaction() {
        SupportSQLiteDatabase supportSQLiteDatabase = this.mAutoCloser.incrementCountAndEnsureDbIsOpen();
        try {
            supportSQLiteDatabase.beginTransaction();
            return;
        }
        catch (Throwable throwable) {
            this.mAutoCloser.decrementCountAndScheduleClose();
            throw throwable;
        }
    }

    public void beginTransactionNonExclusive() {
        SupportSQLiteDatabase supportSQLiteDatabase = this.mAutoCloser.incrementCountAndEnsureDbIsOpen();
        try {
            supportSQLiteDatabase.beginTransactionNonExclusive();
            return;
        }
        catch (Throwable throwable) {
            this.mAutoCloser.decrementCountAndScheduleClose();
            throw throwable;
        }
    }

    public void beginTransactionWithListener(SQLiteTransactionListener sQLiteTransactionListener) {
        SupportSQLiteDatabase supportSQLiteDatabase = this.mAutoCloser.incrementCountAndEnsureDbIsOpen();
        try {
            supportSQLiteDatabase.beginTransactionWithListener(sQLiteTransactionListener);
            return;
        }
        catch (Throwable throwable) {
            this.mAutoCloser.decrementCountAndScheduleClose();
            throw throwable;
        }
    }

    public void beginTransactionWithListenerNonExclusive(SQLiteTransactionListener sQLiteTransactionListener) {
        SupportSQLiteDatabase supportSQLiteDatabase = this.mAutoCloser.incrementCountAndEnsureDbIsOpen();
        try {
            supportSQLiteDatabase.beginTransactionWithListenerNonExclusive(sQLiteTransactionListener);
            return;
        }
        catch (Throwable throwable) {
            this.mAutoCloser.decrementCountAndScheduleClose();
            throw throwable;
        }
    }

    public void close() {
        this.mAutoCloser.closeDatabaseIfOpen();
    }

    public SupportSQLiteStatement compileStatement(String string2) {
        AutoCloser autoCloser = this.mAutoCloser;
        AutoClosingRoomOpenHelper$AutoClosingSupportSqliteStatement autoClosingRoomOpenHelper$AutoClosingSupportSqliteStatement = new AutoClosingRoomOpenHelper$AutoClosingSupportSqliteStatement(string2, autoCloser);
        return autoClosingRoomOpenHelper$AutoClosingSupportSqliteStatement;
    }

    public int delete(String string2, String string3, Object[] objectArray) {
        AutoCloser autoCloser = this.mAutoCloser;
        j j10 = new j(string2, string3, objectArray);
        return (Integer)autoCloser.executeRefCountingFunction(j10);
    }

    public void disableWriteAheadLogging() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Enable/disable write ahead logging on the OpenHelper instead of on the database directly.");
        throw unsupportedOperationException;
    }

    public boolean enableWriteAheadLogging() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Enable/disable write ahead logging on the OpenHelper instead of on the database directly.");
        throw unsupportedOperationException;
    }

    public void endTransaction() {
        Object object = this.mAutoCloser.getDelegateDatabase();
        if (object != null) {
            try {
                object = this.mAutoCloser;
                object = ((AutoCloser)object).getDelegateDatabase();
                object.endTransaction();
                return;
            }
            finally {
                this.mAutoCloser.decrementCountAndScheduleClose();
            }
        }
        object = new IllegalStateException("End transaction called but delegateDb is null");
        throw object;
    }

    public void execSQL(String string2) {
        AutoCloser autoCloser = this.mAutoCloser;
        l l10 = new l(string2);
        autoCloser.executeRefCountingFunction(l10);
    }

    public void execSQL(String string2, Object[] objectArray) {
        AutoCloser autoCloser = this.mAutoCloser;
        f f10 = new f(string2, objectArray);
        autoCloser.executeRefCountingFunction(f10);
    }

    public List getAttachedDbs() {
        AutoCloser autoCloser = this.mAutoCloser;
        v0 v02 = v0.a;
        return (List)autoCloser.executeRefCountingFunction(v02);
    }

    public long getMaximumSize() {
        AutoCloser autoCloser = this.mAutoCloser;
        d d10 = d.a;
        return (Long)autoCloser.executeRefCountingFunction(d10);
    }

    public long getPageSize() {
        AutoCloser autoCloser = this.mAutoCloser;
        r0 r02 = r0.a;
        return (Long)autoCloser.executeRefCountingFunction(r02);
    }

    public String getPath() {
        AutoCloser autoCloser = this.mAutoCloser;
        e e10 = e.a;
        return (String)autoCloser.executeRefCountingFunction(e10);
    }

    public int getVersion() {
        AutoCloser autoCloser = this.mAutoCloser;
        s0 s02 = s0.a;
        return (Integer)autoCloser.executeRefCountingFunction(s02);
    }

    public boolean inTransaction() {
        Object object = this.mAutoCloser.getDelegateDatabase();
        if (object == null) {
            return false;
        }
        object = this.mAutoCloser;
        v v10 = v.a;
        return (Boolean)((AutoCloser)object).executeRefCountingFunction(v10);
    }

    public long insert(String string2, int n10, ContentValues contentValues) {
        AutoCloser autoCloser = this.mAutoCloser;
        o o10 = new o(string2, n10, contentValues);
        return (Long)autoCloser.executeRefCountingFunction(o10);
    }

    public boolean isDatabaseIntegrityOk() {
        AutoCloser autoCloser = this.mAutoCloser;
        c c10 = c.a;
        return (Boolean)autoCloser.executeRefCountingFunction(c10);
    }

    public boolean isDbLockedByCurrentThread() {
        Object object = this.mAutoCloser.getDelegateDatabase();
        if (object == null) {
            return false;
        }
        object = this.mAutoCloser;
        a a10 = a.a;
        return (Boolean)((AutoCloser)object).executeRefCountingFunction(a10);
    }

    public boolean isOpen() {
        SupportSQLiteDatabase supportSQLiteDatabase = this.mAutoCloser.getDelegateDatabase();
        if (supportSQLiteDatabase == null) {
            return false;
        }
        return supportSQLiteDatabase.isOpen();
    }

    public boolean isReadOnly() {
        AutoCloser autoCloser = this.mAutoCloser;
        b b10 = b.a;
        return (Boolean)autoCloser.executeRefCountingFunction(b10);
    }

    public boolean isWriteAheadLoggingEnabled() {
        AutoCloser autoCloser = this.mAutoCloser;
        p p10 = p.a;
        return (Boolean)autoCloser.executeRefCountingFunction(p10);
    }

    public boolean needUpgrade(int n10) {
        AutoCloser autoCloser = this.mAutoCloser;
        n n11 = new n(n10);
        return (Boolean)autoCloser.executeRefCountingFunction(n11);
    }

    public void pokeOpen() {
        AutoCloser autoCloser = this.mAutoCloser;
        r r10 = r.a;
        autoCloser.executeRefCountingFunction(r10);
    }

    public Cursor query(SupportSQLiteQuery supportSQLiteQuery) {
        Object object;
        try {
            object = this.mAutoCloser;
        }
        catch (Throwable throwable) {
            this.mAutoCloser.decrementCountAndScheduleClose();
            throw throwable;
        }
        object = ((AutoCloser)object).incrementCountAndEnsureDbIsOpen();
        supportSQLiteQuery = object.query(supportSQLiteQuery);
        AutoCloser autoCloser = this.mAutoCloser;
        object = new AutoClosingRoomOpenHelper$KeepAliveCursor((Cursor)supportSQLiteQuery, autoCloser);
        return object;
    }

    public Cursor query(SupportSQLiteQuery supportSQLiteQuery, CancellationSignal object) {
        Object object2;
        try {
            object2 = this.mAutoCloser;
        }
        catch (Throwable throwable) {
            this.mAutoCloser.decrementCountAndScheduleClose();
            throw throwable;
        }
        object2 = ((AutoCloser)object2).incrementCountAndEnsureDbIsOpen();
        supportSQLiteQuery = object2.query(supportSQLiteQuery, (CancellationSignal)object);
        object2 = this.mAutoCloser;
        object = new AutoClosingRoomOpenHelper$KeepAliveCursor((Cursor)supportSQLiteQuery, (AutoCloser)object2);
        return object;
    }

    public Cursor query(String string2) {
        Object object;
        try {
            object = this.mAutoCloser;
        }
        catch (Throwable throwable) {
            this.mAutoCloser.decrementCountAndScheduleClose();
            throw throwable;
        }
        object = ((AutoCloser)object).incrementCountAndEnsureDbIsOpen();
        string2 = object.query(string2);
        AutoCloser autoCloser = this.mAutoCloser;
        object = new AutoClosingRoomOpenHelper$KeepAliveCursor((Cursor)string2, autoCloser);
        return object;
    }

    public Cursor query(String string2, Object[] object) {
        Object object2;
        try {
            object2 = this.mAutoCloser;
        }
        catch (Throwable throwable) {
            this.mAutoCloser.decrementCountAndScheduleClose();
            throw throwable;
        }
        object2 = ((AutoCloser)object2).incrementCountAndEnsureDbIsOpen();
        string2 = object2.query(string2, (Object[])object);
        object2 = this.mAutoCloser;
        object = new AutoClosingRoomOpenHelper$KeepAliveCursor((Cursor)string2, (AutoCloser)object2);
        return object;
    }

    public void setForeignKeyConstraintsEnabled(boolean bl2) {
        AutoCloser autoCloser = this.mAutoCloser;
        g g10 = new g(bl2);
        autoCloser.executeRefCountingFunction(g10);
    }

    public void setLocale(Locale locale) {
        AutoCloser autoCloser = this.mAutoCloser;
        h h10 = new h(locale);
        autoCloser.executeRefCountingFunction(h10);
    }

    public void setMaxSqlCacheSize(int n10) {
        AutoCloser autoCloser = this.mAutoCloser;
        q q10 = new q(n10);
        autoCloser.executeRefCountingFunction(q10);
    }

    public long setMaximumSize(long l10) {
        AutoCloser autoCloser = this.mAutoCloser;
        m m10 = new m(l10);
        return (Long)autoCloser.executeRefCountingFunction(m10);
    }

    public void setPageSize(long l10) {
        AutoCloser autoCloser = this.mAutoCloser;
        k k10 = new k(l10);
        autoCloser.executeRefCountingFunction(k10);
    }

    public void setTransactionSuccessful() {
        Object object = this.mAutoCloser.getDelegateDatabase();
        if (object != null) {
            object.setTransactionSuccessful();
            return;
        }
        object = new IllegalStateException("setTransactionSuccessful called but delegateDb is null");
        throw object;
    }

    public void setVersion(int n10) {
        AutoCloser autoCloser = this.mAutoCloser;
        s s10 = new s(n10);
        autoCloser.executeRefCountingFunction(s10);
    }

    public int update(String string2, int n10, ContentValues contentValues, String string3, Object[] objectArray) {
        AutoCloser autoCloser = this.mAutoCloser;
        i i10 = new i(string2, n10, contentValues, string3, objectArray);
        return (Integer)autoCloser.executeRefCountingFunction(i10);
    }

    public boolean yieldIfContendedSafely() {
        AutoCloser autoCloser = this.mAutoCloser;
        u0 u02 = u0.a;
        return (Boolean)autoCloser.executeRefCountingFunction(u02);
    }

    public boolean yieldIfContendedSafely(long l10) {
        AutoCloser autoCloser = this.mAutoCloser;
        u0 u02 = u0.a;
        return (Boolean)autoCloser.executeRefCountingFunction(u02);
    }
}

