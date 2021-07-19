/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package androidx.sqlite.db.framework;

import android.content.Context;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper$Callback;
import androidx.sqlite.db.SupportSQLiteOpenHelper$Configuration;
import androidx.sqlite.db.SupportSQLiteOpenHelper$Factory;
import androidx.sqlite.db.framework.FrameworkSQLiteOpenHelper;

public final class FrameworkSQLiteOpenHelperFactory
implements SupportSQLiteOpenHelper$Factory {
    public SupportSQLiteOpenHelper create(SupportSQLiteOpenHelper$Configuration supportSQLiteOpenHelper$Configuration) {
        Context context = supportSQLiteOpenHelper$Configuration.context;
        String string2 = supportSQLiteOpenHelper$Configuration.name;
        SupportSQLiteOpenHelper$Callback supportSQLiteOpenHelper$Callback = supportSQLiteOpenHelper$Configuration.callback;
        boolean bl2 = supportSQLiteOpenHelper$Configuration.useNoBackupDirectory;
        FrameworkSQLiteOpenHelper frameworkSQLiteOpenHelper = new FrameworkSQLiteOpenHelper(context, string2, supportSQLiteOpenHelper$Callback, bl2);
        return frameworkSQLiteOpenHelper;
    }
}

