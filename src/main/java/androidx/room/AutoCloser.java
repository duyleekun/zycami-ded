/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Looper
 *  android.os.SystemClock
 *  android.util.Log
 */
package androidx.room;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;
import androidx.arch.core.util.Function;
import androidx.room.AutoCloser$1;
import androidx.room.AutoCloser$2;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

public final class AutoCloser {
    public final long mAutoCloseTimeoutInMs;
    public final Runnable mAutoCloser;
    public SupportSQLiteDatabase mDelegateDatabase;
    private SupportSQLiteOpenHelper mDelegateOpenHelper = null;
    private final Runnable mExecuteAutoCloser;
    public final Executor mExecutor;
    private final Handler mHandler;
    public long mLastDecrementRefCountTimeStamp;
    public final Object mLock;
    private boolean mManuallyClosed;
    public Runnable mOnAutoCloseCallback;
    public int mRefCount;

    public AutoCloser(long l10, TimeUnit timeUnit, Executor executor) {
        long l11;
        Object object;
        Handler handler;
        Looper looper = Looper.getMainLooper();
        this.mHandler = handler = new Handler(looper);
        this.mOnAutoCloseCallback = null;
        this.mLock = object = new Object();
        this.mRefCount = 0;
        this.mLastDecrementRefCountTimeStamp = l11 = SystemClock.uptimeMillis();
        this.mManuallyClosed = false;
        this.mExecuteAutoCloser = object = new AutoCloser$1(this);
        this.mAutoCloser = object = new AutoCloser$2(this);
        this.mAutoCloseTimeoutInMs = l10 = timeUnit.toMillis(l10);
        this.mExecutor = executor;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void closeDatabaseIfOpen() {
        Object object = this.mLock;
        synchronized (object) {
            boolean bl2;
            this.mManuallyClosed = bl2 = true;
            SupportSQLiteDatabase supportSQLiteDatabase = this.mDelegateDatabase;
            if (supportSQLiteDatabase != null) {
                supportSQLiteDatabase.close();
            }
            bl2 = false;
            supportSQLiteDatabase = null;
            this.mDelegateDatabase = null;
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void decrementCountAndScheduleClose() {
        Object object = this.mLock;
        synchronized (object) {
            int n10 = this.mRefCount;
            if (n10 <= 0) {
                String string2 = "ref count is 0 or lower but we're supposed to decrement";
                IllegalStateException illegalStateException = new IllegalStateException(string2);
                throw illegalStateException;
            }
            this.mRefCount = n10 += -1;
            if (n10 == 0) {
                SupportSQLiteDatabase supportSQLiteDatabase = this.mDelegateDatabase;
                if (supportSQLiteDatabase == null) {
                    return;
                }
                supportSQLiteDatabase = this.mHandler;
                Runnable runnable = this.mExecuteAutoCloser;
                long l10 = this.mAutoCloseTimeoutInMs;
                supportSQLiteDatabase.postDelayed(runnable, l10);
            }
            return;
        }
    }

    public Object executeRefCountingFunction(Function object) {
        try {
            SupportSQLiteDatabase supportSQLiteDatabase = this.incrementCountAndEnsureDbIsOpen();
            object = object.apply(supportSQLiteDatabase);
            return object;
        }
        finally {
            this.decrementCountAndScheduleClose();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public SupportSQLiteDatabase getDelegateDatabase() {
        Object object = this.mLock;
        synchronized (object) {
            return this.mDelegateDatabase;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public int getRefCountForTest() {
        Object object = this.mLock;
        synchronized (object) {
            return this.mRefCount;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public SupportSQLiteDatabase incrementCountAndEnsureDbIsOpen() {
        Object object = this.mLock;
        synchronized (object) {
            int n10;
            Object object2 = this.mHandler;
            Object object3 = this.mExecuteAutoCloser;
            object2.removeCallbacks((Runnable)object3);
            this.mRefCount = n10 = this.mRefCount + 1;
            n10 = (int)(this.mManuallyClosed ? 1 : 0);
            if (n10 != 0) {
                object3 = "Attempting to open already closed database.";
                object2 = new IllegalStateException((String)object3);
                throw object2;
            }
            object2 = this.mDelegateDatabase;
            if (object2 != null && (n10 = (int)(object2.isOpen() ? 1 : 0)) != 0) {
                return this.mDelegateDatabase;
            }
            object2 = this.mDelegateOpenHelper;
            if (object2 != null) {
                this.mDelegateDatabase = object2 = object2.getWritableDatabase();
                return object2;
            }
            object3 = "AutoCloser has not been initialized. Please file a bug against Room at: https://issuetracker.google.com/issues/new?component=413107&template=1096568";
            object2 = new IllegalStateException((String)object3);
            throw object2;
        }
    }

    public void init(SupportSQLiteOpenHelper supportSQLiteOpenHelper) {
        SupportSQLiteOpenHelper supportSQLiteOpenHelper2 = this.mDelegateOpenHelper;
        if (supportSQLiteOpenHelper2 != null) {
            Log.e((String)"ROOM", (String)"AutoCloser initialized multiple times. Please file a bug against room at: https://issuetracker.google.com/issues/new?component=413107&template=1096568");
            return;
        }
        this.mDelegateOpenHelper = supportSQLiteOpenHelper;
    }

    public boolean isActive() {
        return this.mManuallyClosed ^ true;
    }

    public void setAutoCloseCallback(Runnable runnable) {
        this.mOnAutoCloseCallback = runnable;
    }
}

