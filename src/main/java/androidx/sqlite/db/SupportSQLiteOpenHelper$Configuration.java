/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package androidx.sqlite.db;

import android.content.Context;
import androidx.sqlite.db.SupportSQLiteOpenHelper$Callback;
import androidx.sqlite.db.SupportSQLiteOpenHelper$Configuration$Builder;

public class SupportSQLiteOpenHelper$Configuration {
    public final SupportSQLiteOpenHelper$Callback callback;
    public final Context context;
    public final String name;
    public final boolean useNoBackupDirectory;

    public SupportSQLiteOpenHelper$Configuration(Context context, String string2, SupportSQLiteOpenHelper$Callback supportSQLiteOpenHelper$Callback) {
        this(context, string2, supportSQLiteOpenHelper$Callback, false);
    }

    public SupportSQLiteOpenHelper$Configuration(Context context, String string2, SupportSQLiteOpenHelper$Callback supportSQLiteOpenHelper$Callback, boolean bl2) {
        this.context = context;
        this.name = string2;
        this.callback = supportSQLiteOpenHelper$Callback;
        this.useNoBackupDirectory = bl2;
    }

    public static SupportSQLiteOpenHelper$Configuration$Builder builder(Context context) {
        SupportSQLiteOpenHelper$Configuration$Builder supportSQLiteOpenHelper$Configuration$Builder = new SupportSQLiteOpenHelper$Configuration$Builder(context);
        return supportSQLiteOpenHelper$Configuration$Builder;
    }
}

