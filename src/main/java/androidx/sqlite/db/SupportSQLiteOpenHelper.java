/*
 * Decompiled with CFR 0.151.
 */
package androidx.sqlite.db;

import androidx.sqlite.db.SupportSQLiteDatabase;
import java.io.Closeable;

public interface SupportSQLiteOpenHelper
extends Closeable {
    public void close();

    public String getDatabaseName();

    public SupportSQLiteDatabase getReadableDatabase();

    public SupportSQLiteDatabase getWritableDatabase();

    public void setWriteAheadLoggingEnabled(boolean var1);
}

