/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Build$VERSION
 */
package androidx.sqlite.db.framework;

import android.content.Context;
import android.os.Build;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper$Callback;
import androidx.sqlite.db.framework.FrameworkSQLiteDatabase;
import androidx.sqlite.db.framework.FrameworkSQLiteOpenHelper$OpenHelper;
import java.io.File;

public class FrameworkSQLiteOpenHelper
implements SupportSQLiteOpenHelper {
    private final SupportSQLiteOpenHelper$Callback mCallback;
    private final Context mContext;
    private FrameworkSQLiteOpenHelper$OpenHelper mDelegate;
    private final Object mLock;
    private final String mName;
    private final boolean mUseNoBackupDirectory;
    private boolean mWriteAheadLoggingEnabled;

    public FrameworkSQLiteOpenHelper(Context context, String string2, SupportSQLiteOpenHelper$Callback supportSQLiteOpenHelper$Callback) {
        this(context, string2, supportSQLiteOpenHelper$Callback, false);
    }

    public FrameworkSQLiteOpenHelper(Context object, String string2, SupportSQLiteOpenHelper$Callback supportSQLiteOpenHelper$Callback, boolean bl2) {
        this.mContext = object;
        this.mName = string2;
        this.mCallback = supportSQLiteOpenHelper$Callback;
        this.mUseNoBackupDirectory = bl2;
        this.mLock = object;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private FrameworkSQLiteOpenHelper$OpenHelper getDelegate() {
        Object object = this.mLock;
        synchronized (object) {
            Object object2;
            FrameworkSQLiteDatabase[] frameworkSQLiteDatabaseArray = this.mDelegate;
            if (frameworkSQLiteDatabaseArray != null) return this.mDelegate;
            int n10 = 1;
            frameworkSQLiteDatabaseArray = new FrameworkSQLiteDatabase[n10];
            int n11 = Build.VERSION.SDK_INT;
            int n12 = 23;
            if (n11 >= n12 && (object2 = this.mName) != null && (n12 = (int)(this.mUseNoBackupDirectory ? 1 : 0))) {
                Object object3 = this.mContext;
                object3 = object3.getNoBackupFilesDir();
                String string2 = this.mName;
                object2 = new File((File)object3, string2);
                string2 = this.mContext;
                object2 = ((File)object2).getAbsolutePath();
                SupportSQLiteOpenHelper$Callback supportSQLiteOpenHelper$Callback = this.mCallback;
                object3 = new FrameworkSQLiteOpenHelper$OpenHelper((Context)string2, (String)object2, frameworkSQLiteDatabaseArray, supportSQLiteOpenHelper$Callback);
                this.mDelegate = object3;
            } else {
                Context context = this.mContext;
                String string3 = this.mName;
                SupportSQLiteOpenHelper$Callback supportSQLiteOpenHelper$Callback = this.mCallback;
                object2 = new FrameworkSQLiteOpenHelper$OpenHelper(context, string3, frameworkSQLiteDatabaseArray, supportSQLiteOpenHelper$Callback);
                this.mDelegate = object2;
            }
            n10 = 16;
            if (n11 < n10) return this.mDelegate;
            frameworkSQLiteDatabaseArray = this.mDelegate;
            n11 = (int)(this.mWriteAheadLoggingEnabled ? 1 : 0);
            frameworkSQLiteDatabaseArray.setWriteAheadLoggingEnabled(n11 != 0);
            return this.mDelegate;
        }
    }

    public void close() {
        this.getDelegate().close();
    }

    public String getDatabaseName() {
        return this.mName;
    }

    public SupportSQLiteDatabase getReadableDatabase() {
        return this.getDelegate().getReadableSupportDatabase();
    }

    public SupportSQLiteDatabase getWritableDatabase() {
        return this.getDelegate().getWritableSupportDatabase();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void setWriteAheadLoggingEnabled(boolean bl2) {
        Object object = this.mLock;
        synchronized (object) {
            FrameworkSQLiteOpenHelper$OpenHelper frameworkSQLiteOpenHelper$OpenHelper = this.mDelegate;
            if (frameworkSQLiteOpenHelper$OpenHelper != null) {
                frameworkSQLiteOpenHelper$OpenHelper.setWriteAheadLoggingEnabled(bl2);
            }
            this.mWriteAheadLoggingEnabled = bl2;
            return;
        }
    }
}

