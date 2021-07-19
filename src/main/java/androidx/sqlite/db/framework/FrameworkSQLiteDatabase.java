/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ContentValues
 *  android.database.Cursor
 *  android.database.sqlite.SQLiteDatabase
 *  android.database.sqlite.SQLiteDatabase$CursorFactory
 *  android.database.sqlite.SQLiteStatement
 *  android.database.sqlite.SQLiteTransactionListener
 *  android.os.CancellationSignal
 *  android.text.TextUtils
 */
package androidx.sqlite.db.framework;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.database.sqlite.SQLiteTransactionListener;
import android.os.CancellationSignal;
import android.text.TextUtils;
import androidx.sqlite.db.SimpleSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteProgram;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteStatement;
import androidx.sqlite.db.framework.FrameworkSQLiteDatabase$1;
import androidx.sqlite.db.framework.FrameworkSQLiteDatabase$2;
import androidx.sqlite.db.framework.FrameworkSQLiteStatement;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public class FrameworkSQLiteDatabase
implements SupportSQLiteDatabase {
    private static final String[] CONFLICT_VALUES = new String[]{"", " OR ROLLBACK ", " OR ABORT ", " OR FAIL ", " OR IGNORE ", " OR REPLACE "};
    private static final String[] EMPTY_STRING_ARRAY = new String[0];
    private final SQLiteDatabase mDelegate;

    public FrameworkSQLiteDatabase(SQLiteDatabase sQLiteDatabase) {
        this.mDelegate = sQLiteDatabase;
    }

    public void beginTransaction() {
        this.mDelegate.beginTransaction();
    }

    public void beginTransactionNonExclusive() {
        this.mDelegate.beginTransactionNonExclusive();
    }

    public void beginTransactionWithListener(SQLiteTransactionListener sQLiteTransactionListener) {
        this.mDelegate.beginTransactionWithListener(sQLiteTransactionListener);
    }

    public void beginTransactionWithListenerNonExclusive(SQLiteTransactionListener sQLiteTransactionListener) {
        this.mDelegate.beginTransactionWithListenerNonExclusive(sQLiteTransactionListener);
    }

    public void close() {
        this.mDelegate.close();
    }

    public SupportSQLiteStatement compileStatement(String string2) {
        string2 = this.mDelegate.compileStatement(string2);
        FrameworkSQLiteStatement frameworkSQLiteStatement = new FrameworkSQLiteStatement((SQLiteStatement)string2);
        return frameworkSQLiteStatement;
    }

    public int delete(String object, String string2, Object[] objectArray) {
        StringBuilder stringBuilder = new StringBuilder();
        String string3 = "DELETE FROM ";
        stringBuilder.append(string3);
        stringBuilder.append((String)object);
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (bl2) {
            object = "";
        } else {
            object = new StringBuilder();
            string3 = " WHERE ";
            ((StringBuilder)object).append(string3);
            ((StringBuilder)object).append(string2);
            object = ((StringBuilder)object).toString();
        }
        stringBuilder.append((String)object);
        object = stringBuilder.toString();
        object = this.compileStatement((String)object);
        SimpleSQLiteQuery.bind((SupportSQLiteProgram)object, objectArray);
        return object.executeUpdateDelete();
    }

    public void disableWriteAheadLogging() {
        this.mDelegate.disableWriteAheadLogging();
    }

    public boolean enableWriteAheadLogging() {
        return this.mDelegate.enableWriteAheadLogging();
    }

    public void endTransaction() {
        this.mDelegate.endTransaction();
    }

    public void execSQL(String string2) {
        this.mDelegate.execSQL(string2);
    }

    public void execSQL(String string2, Object[] objectArray) {
        this.mDelegate.execSQL(string2, objectArray);
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

    public boolean inTransaction() {
        return this.mDelegate.inTransaction();
    }

    public long insert(String string2, int n10, ContentValues contentValues) {
        return this.mDelegate.insertWithOnConflict(string2, null, contentValues, n10);
    }

    public boolean isDatabaseIntegrityOk() {
        return this.mDelegate.isDatabaseIntegrityOk();
    }

    public boolean isDbLockedByCurrentThread() {
        return this.mDelegate.isDbLockedByCurrentThread();
    }

    public boolean isDelegate(SQLiteDatabase sQLiteDatabase) {
        boolean bl2;
        SQLiteDatabase sQLiteDatabase2 = this.mDelegate;
        if (sQLiteDatabase2 == sQLiteDatabase) {
            bl2 = true;
        } else {
            bl2 = false;
            sQLiteDatabase = null;
        }
        return bl2;
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

    public boolean needUpgrade(int n10) {
        return this.mDelegate.needUpgrade(n10);
    }

    public Cursor query(SupportSQLiteQuery object) {
        SQLiteDatabase sQLiteDatabase = this.mDelegate;
        FrameworkSQLiteDatabase$1 frameworkSQLiteDatabase$1 = new FrameworkSQLiteDatabase$1(this, (SupportSQLiteQuery)object);
        object = object.getSql();
        String[] stringArray = EMPTY_STRING_ARRAY;
        return sQLiteDatabase.rawQueryWithFactory((SQLiteDatabase.CursorFactory)frameworkSQLiteDatabase$1, (String)object, stringArray, null);
    }

    public Cursor query(SupportSQLiteQuery supportSQLiteQuery, CancellationSignal cancellationSignal) {
        SQLiteDatabase sQLiteDatabase = this.mDelegate;
        FrameworkSQLiteDatabase$2 frameworkSQLiteDatabase$2 = new FrameworkSQLiteDatabase$2(this, supportSQLiteQuery);
        String string2 = supportSQLiteQuery.getSql();
        String[] stringArray = EMPTY_STRING_ARRAY;
        return sQLiteDatabase.rawQueryWithFactory((SQLiteDatabase.CursorFactory)frameworkSQLiteDatabase$2, string2, stringArray, null, cancellationSignal);
    }

    public Cursor query(String string2) {
        SimpleSQLiteQuery simpleSQLiteQuery = new SimpleSQLiteQuery(string2);
        return this.query(simpleSQLiteQuery);
    }

    public Cursor query(String string2, Object[] objectArray) {
        SimpleSQLiteQuery simpleSQLiteQuery = new SimpleSQLiteQuery(string2, objectArray);
        return this.query(simpleSQLiteQuery);
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
        this.mDelegate.setTransactionSuccessful();
    }

    public void setVersion(int n10) {
        this.mDelegate.setVersion(n10);
    }

    public int update(String object, int n10, ContentValues contentValues, String string2, Object[] objectArray) {
        int n11;
        if (contentValues != null && (n11 = contentValues.size()) != 0) {
            boolean bl2;
            int n12 = 120;
            StringBuilder stringBuilder = new StringBuilder(n12);
            stringBuilder.append("UPDATE ");
            Object[] objectArray2 = CONFLICT_VALUES;
            String string3 = objectArray2[n10];
            stringBuilder.append(string3);
            stringBuilder.append((String)object);
            object = " SET ";
            stringBuilder.append((String)object);
            int n13 = contentValues.size();
            n10 = objectArray == null ? n13 : objectArray.length + n13;
            objectArray2 = new Object[n10];
            int n14 = 0;
            Object object2 = null;
            Iterator iterator2 = contentValues.keySet().iterator();
            while (bl2 = iterator2.hasNext()) {
                Object object3 = (String)iterator2.next();
                String string4 = n14 > 0 ? "," : "";
                stringBuilder.append(string4);
                stringBuilder.append((String)object3);
                int n15 = n14 + 1;
                objectArray2[n14] = object3 = contentValues.get((String)object3);
                object2 = "=?";
                stringBuilder.append((String)object2);
                n14 = n15;
            }
            if (objectArray != null) {
                for (int i10 = n13; i10 < n10; ++i10) {
                    n14 = i10 - n13;
                    objectArray2[i10] = object2 = objectArray[n14];
                }
            }
            if ((n13 = (int)(TextUtils.isEmpty((CharSequence)string2) ? 1 : 0)) == 0) {
                object = " WHERE ";
                stringBuilder.append((String)object);
                stringBuilder.append(string2);
            }
            object = stringBuilder.toString();
            object = this.compileStatement((String)object);
            SimpleSQLiteQuery.bind((SupportSQLiteProgram)object, objectArray2);
            return object.executeUpdateDelete();
        }
        object = new IllegalArgumentException("Empty values");
        throw object;
    }

    public boolean yieldIfContendedSafely() {
        return this.mDelegate.yieldIfContendedSafely();
    }

    public boolean yieldIfContendedSafely(long l10) {
        return this.mDelegate.yieldIfContendedSafely(l10);
    }
}

