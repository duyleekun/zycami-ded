/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ContentValues
 *  android.database.Cursor
 *  android.database.sqlite.SQLiteTransactionListener
 *  android.os.CancellationSignal
 */
package androidx.sqlite.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteTransactionListener;
import android.os.CancellationSignal;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.io.Closeable;
import java.util.List;
import java.util.Locale;

public interface SupportSQLiteDatabase
extends Closeable {
    public void beginTransaction();

    public void beginTransactionNonExclusive();

    public void beginTransactionWithListener(SQLiteTransactionListener var1);

    public void beginTransactionWithListenerNonExclusive(SQLiteTransactionListener var1);

    public SupportSQLiteStatement compileStatement(String var1);

    public int delete(String var1, String var2, Object[] var3);

    public void disableWriteAheadLogging();

    public boolean enableWriteAheadLogging();

    public void endTransaction();

    public void execSQL(String var1);

    public void execSQL(String var1, Object[] var2);

    public List getAttachedDbs();

    public long getMaximumSize();

    public long getPageSize();

    public String getPath();

    public int getVersion();

    public boolean inTransaction();

    public long insert(String var1, int var2, ContentValues var3);

    public boolean isDatabaseIntegrityOk();

    public boolean isDbLockedByCurrentThread();

    public boolean isOpen();

    public boolean isReadOnly();

    public boolean isWriteAheadLoggingEnabled();

    public boolean needUpgrade(int var1);

    public Cursor query(SupportSQLiteQuery var1);

    public Cursor query(SupportSQLiteQuery var1, CancellationSignal var2);

    public Cursor query(String var1);

    public Cursor query(String var1, Object[] var2);

    public void setForeignKeyConstraintsEnabled(boolean var1);

    public void setLocale(Locale var1);

    public void setMaxSqlCacheSize(int var1);

    public long setMaximumSize(long var1);

    public void setPageSize(long var1);

    public void setTransactionSuccessful();

    public void setVersion(int var1);

    public int update(String var1, int var2, ContentValues var3, String var4, Object[] var5);

    public boolean yieldIfContendedSafely();

    public boolean yieldIfContendedSafely(long var1);
}

