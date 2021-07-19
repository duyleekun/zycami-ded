/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package androidx.room;

import android.content.Context;
import androidx.room.SQLiteCopyOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper$Configuration;
import androidx.sqlite.db.SupportSQLiteOpenHelper$Factory;
import java.io.File;
import java.util.concurrent.Callable;

public class SQLiteCopyOpenHelperFactory
implements SupportSQLiteOpenHelper$Factory {
    private final String mCopyFromAssetPath;
    private final File mCopyFromFile;
    private final Callable mCopyFromInputStream;
    private final SupportSQLiteOpenHelper$Factory mDelegate;

    public SQLiteCopyOpenHelperFactory(String string2, File file, Callable callable, SupportSQLiteOpenHelper$Factory supportSQLiteOpenHelper$Factory) {
        this.mCopyFromAssetPath = string2;
        this.mCopyFromFile = file;
        this.mCopyFromInputStream = callable;
        this.mDelegate = supportSQLiteOpenHelper$Factory;
    }

    public SupportSQLiteOpenHelper create(SupportSQLiteOpenHelper$Configuration supportSQLiteOpenHelper$Configuration) {
        Context context = supportSQLiteOpenHelper$Configuration.context;
        String string2 = this.mCopyFromAssetPath;
        File file = this.mCopyFromFile;
        Callable callable = this.mCopyFromInputStream;
        int n10 = supportSQLiteOpenHelper$Configuration.callback.version;
        SupportSQLiteOpenHelper supportSQLiteOpenHelper = this.mDelegate.create(supportSQLiteOpenHelper$Configuration);
        SQLiteCopyOpenHelper sQLiteCopyOpenHelper = new SQLiteCopyOpenHelper(context, string2, file, callable, n10, supportSQLiteOpenHelper);
        return sQLiteCopyOpenHelper;
    }
}

