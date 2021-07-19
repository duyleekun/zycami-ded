/*
 * Decompiled with CFR 0.151.
 */
package androidx.room;

import androidx.sqlite.db.SupportSQLiteOpenHelper;

public interface DelegatingOpenHelper {
    public SupportSQLiteOpenHelper getDelegate();
}

