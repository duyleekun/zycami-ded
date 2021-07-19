/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 */
package androidx.sqlite.db;

import android.content.Context;
import android.text.TextUtils;
import androidx.sqlite.db.SupportSQLiteOpenHelper$Callback;
import androidx.sqlite.db.SupportSQLiteOpenHelper$Configuration;

public class SupportSQLiteOpenHelper$Configuration$Builder {
    public SupportSQLiteOpenHelper$Callback mCallback;
    public Context mContext;
    public String mName;
    public boolean mUseNoBackUpDirectory;

    public SupportSQLiteOpenHelper$Configuration$Builder(Context context) {
        this.mContext = context;
    }

    public SupportSQLiteOpenHelper$Configuration build() {
        Object object = this.mCallback;
        if (object != null) {
            object = this.mContext;
            if (object != null) {
                boolean bl2 = this.mUseNoBackUpDirectory;
                if (bl2 && (bl2 = TextUtils.isEmpty((CharSequence)(object = this.mName)))) {
                    object = new IllegalArgumentException("Must set a non-null database name to a configuration that uses the no backup directory.");
                    throw object;
                }
                Context context = this.mContext;
                String string2 = this.mName;
                SupportSQLiteOpenHelper$Callback supportSQLiteOpenHelper$Callback = this.mCallback;
                boolean bl3 = this.mUseNoBackUpDirectory;
                object = new SupportSQLiteOpenHelper$Configuration(context, string2, supportSQLiteOpenHelper$Callback, bl3);
                return object;
            }
            object = new IllegalArgumentException("Must set a non-null context to create the configuration.");
            throw object;
        }
        object = new IllegalArgumentException("Must set a callback to create the configuration.");
        throw object;
    }

    public SupportSQLiteOpenHelper$Configuration$Builder callback(SupportSQLiteOpenHelper$Callback supportSQLiteOpenHelper$Callback) {
        this.mCallback = supportSQLiteOpenHelper$Callback;
        return this;
    }

    public SupportSQLiteOpenHelper$Configuration$Builder name(String string2) {
        this.mName = string2;
        return this;
    }

    public SupportSQLiteOpenHelper$Configuration$Builder noBackupDirectory(boolean bl2) {
        this.mUseNoBackUpDirectory = bl2;
        return this;
    }
}

