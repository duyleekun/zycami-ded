/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.database.Cursor
 *  android.os.Build$VERSION
 *  android.os.CancellationSignal
 *  android.os.Looper
 */
package androidx.room;

import android.content.Context;
import android.database.Cursor;
import android.os.Build;
import android.os.CancellationSignal;
import android.os.Looper;
import androidx.room.AutoCloser;
import androidx.room.AutoClosingRoomOpenHelper;
import androidx.room.DatabaseConfiguration;
import androidx.room.DelegatingOpenHelper;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase$JournalMode;
import androidx.room.SQLiteCopyOpenHelper;
import androidx.room.TransactionExecutor;
import androidx.sqlite.db.SimpleSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteStatement;
import b.b.p0;
import b.b.q0;
import java.util.BitSet;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public abstract class RoomDatabase {
    private static final String DB_IMPL_SUFFIX = "_Impl";
    public static final int MAX_BIND_PARAMETER_CNT = 999;
    private boolean mAllowMainThreadQueries;
    private AutoCloser mAutoCloser;
    private final Map mBackingFieldMap;
    public List mCallbacks;
    private final ReentrantReadWriteLock mCloseLock;
    public volatile SupportSQLiteDatabase mDatabase;
    private final InvalidationTracker mInvalidationTracker;
    private SupportSQLiteOpenHelper mOpenHelper;
    private Executor mQueryExecutor;
    private final ThreadLocal mSuspendingTransactionId;
    private Executor mTransactionExecutor;
    private final Map mTypeConverters;
    public boolean mWriteAheadLoggingEnabled;

    public RoomDatabase() {
        HashMap hashMap = new HashMap();
        this.mCloseLock = hashMap;
        hashMap = new HashMap();
        this.mSuspendingTransactionId = hashMap;
        hashMap = new HashMap();
        hashMap = Collections.synchronizedMap(hashMap);
        this.mBackingFieldMap = hashMap;
        hashMap = this.createInvalidationTracker();
        this.mInvalidationTracker = hashMap;
        this.mTypeConverters = hashMap = new HashMap();
    }

    private /* synthetic */ Object a(SupportSQLiteDatabase supportSQLiteDatabase) {
        this.internalBeginTransaction();
        return null;
    }

    private /* synthetic */ Object c(SupportSQLiteDatabase supportSQLiteDatabase) {
        this.internalEndTransaction();
        return null;
    }

    private void internalBeginTransaction() {
        this.assertNotMainThread();
        SupportSQLiteDatabase supportSQLiteDatabase = this.mOpenHelper.getWritableDatabase();
        InvalidationTracker invalidationTracker = this.mInvalidationTracker;
        invalidationTracker.syncTriggers(supportSQLiteDatabase);
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 16;
        if (n10 >= n11 && (n10 = (int)(supportSQLiteDatabase.isWriteAheadLoggingEnabled() ? 1 : 0)) != 0) {
            supportSQLiteDatabase.beginTransactionNonExclusive();
        } else {
            supportSQLiteDatabase.beginTransaction();
        }
    }

    private void internalEndTransaction() {
        Object object = this.mOpenHelper.getWritableDatabase();
        object.endTransaction();
        boolean bl2 = this.inTransaction();
        if (!bl2) {
            object = this.mInvalidationTracker;
            ((InvalidationTracker)object).refreshVersionsAsync();
        }
    }

    private static boolean isMainThread() {
        boolean bl2;
        Thread thread;
        Thread thread2 = Looper.getMainLooper().getThread();
        if (thread2 == (thread = Thread.currentThread())) {
            bl2 = true;
        } else {
            bl2 = false;
            thread2 = null;
        }
        return bl2;
    }

    private Object unwrapOpenHelper(Class clazz, SupportSQLiteOpenHelper supportSQLiteOpenHelper) {
        boolean bl2 = clazz.isInstance(supportSQLiteOpenHelper);
        if (bl2) {
            return supportSQLiteOpenHelper;
        }
        bl2 = supportSQLiteOpenHelper instanceof DelegatingOpenHelper;
        if (bl2) {
            supportSQLiteOpenHelper = ((DelegatingOpenHelper)((Object)supportSQLiteOpenHelper)).getDelegate();
            return this.unwrapOpenHelper(clazz, supportSQLiteOpenHelper);
        }
        return null;
    }

    public void assertNotMainThread() {
        boolean bl2 = this.mAllowMainThreadQueries;
        if (bl2) {
            return;
        }
        bl2 = RoomDatabase.isMainThread();
        if (!bl2) {
            return;
        }
        IllegalStateException illegalStateException = new IllegalStateException("Cannot access database on the main thread since it may potentially lock the UI for a long period of time.");
        throw illegalStateException;
    }

    public void assertNotSuspendingTransaction() {
        Object object;
        boolean bl2 = this.inTransaction();
        if (!bl2 && (object = this.mSuspendingTransactionId.get()) != null) {
            object = new Object("Cannot access database on a different coroutine context inherited from a suspending transaction.");
            throw object;
        }
    }

    public /* synthetic */ Object b(SupportSQLiteDatabase supportSQLiteDatabase) {
        return this.a(supportSQLiteDatabase);
    }

    public void beginTransaction() {
        this.assertNotMainThread();
        AutoCloser autoCloser = this.mAutoCloser;
        if (autoCloser == null) {
            this.internalBeginTransaction();
        } else {
            p0 p02 = new p0(this);
            autoCloser.executeRefCountingFunction(p02);
        }
    }

    public abstract void clearAllTables();

    public void close() {
        boolean bl2 = this.isOpen();
        if (bl2) {
            ReentrantReadWriteLock.WriteLock writeLock = this.mCloseLock.writeLock();
            writeLock.lock();
            try {
                Object object = this.mInvalidationTracker;
                ((InvalidationTracker)object).stopMultiInstanceInvalidation();
                object = this.mOpenHelper;
                object.close();
            }
            finally {
                writeLock.unlock();
            }
        }
    }

    public SupportSQLiteStatement compileStatement(String string2) {
        this.assertNotMainThread();
        this.assertNotSuspendingTransaction();
        return this.mOpenHelper.getWritableDatabase().compileStatement(string2);
    }

    public abstract InvalidationTracker createInvalidationTracker();

    public abstract SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration var1);

    public /* synthetic */ Object d(SupportSQLiteDatabase supportSQLiteDatabase) {
        return this.c(supportSQLiteDatabase);
    }

    public void endTransaction() {
        AutoCloser autoCloser = this.mAutoCloser;
        if (autoCloser == null) {
            this.internalEndTransaction();
        } else {
            q0 q02 = new q0(this);
            autoCloser.executeRefCountingFunction(q02);
        }
    }

    public Map getBackingFieldMap() {
        return this.mBackingFieldMap;
    }

    public Lock getCloseLock() {
        return this.mCloseLock.readLock();
    }

    public InvalidationTracker getInvalidationTracker() {
        return this.mInvalidationTracker;
    }

    public SupportSQLiteOpenHelper getOpenHelper() {
        return this.mOpenHelper;
    }

    public Executor getQueryExecutor() {
        return this.mQueryExecutor;
    }

    public Map getRequiredTypeConverters() {
        return Collections.emptyMap();
    }

    public ThreadLocal getSuspendingTransactionId() {
        return this.mSuspendingTransactionId;
    }

    public Executor getTransactionExecutor() {
        return this.mTransactionExecutor;
    }

    public Object getTypeConverter(Class clazz) {
        return this.mTypeConverters.get(clazz);
    }

    public boolean inTransaction() {
        return this.mOpenHelper.getWritableDatabase().inTransaction();
    }

    public void init(DatabaseConfiguration object) {
        Object object2 = this.createOpenHelper((DatabaseConfiguration)object);
        this.mOpenHelper = object2;
        Object object3 = SQLiteCopyOpenHelper.class;
        if ((object2 = (SQLiteCopyOpenHelper)this.unwrapOpenHelper((Class)object3, (SupportSQLiteOpenHelper)object2)) != null) {
            ((SQLiteCopyOpenHelper)object2).setDatabaseConfiguration((DatabaseConfiguration)object);
        }
        if ((object2 = (AutoClosingRoomOpenHelper)this.unwrapOpenHelper(AutoClosingRoomOpenHelper.class, (SupportSQLiteOpenHelper)(object3 = this.mOpenHelper))) != null) {
            this.mAutoCloser = object2 = ((AutoClosingRoomOpenHelper)object2).getAutoCloser();
            object3 = this.mInvalidationTracker;
            ((InvalidationTracker)object3).setAutoCloser((AutoCloser)object2);
        }
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 16;
        int n12 = 0;
        Iterator iterator2 = null;
        int n13 = 1;
        if (n10 >= n11) {
            object2 = ((DatabaseConfiguration)object).journalMode;
            object3 = RoomDatabase$JournalMode.WRITE_AHEAD_LOGGING;
            if (object2 == object3) {
                n12 = n13;
            }
            object2 = this.mOpenHelper;
            object2.setWriteAheadLoggingEnabled(n12 != 0);
        }
        object2 = ((DatabaseConfiguration)object).callbacks;
        this.mCallbacks = object2;
        object2 = ((DatabaseConfiguration)object).queryExecutor;
        this.mQueryExecutor = object2;
        object3 = ((DatabaseConfiguration)object).transactionExecutor;
        this.mTransactionExecutor = object2 = new TransactionExecutor((Executor)object3);
        n10 = (int)(((DatabaseConfiguration)object).allowMainThreadQueries ? 1 : 0);
        this.mAllowMainThreadQueries = n10;
        this.mWriteAheadLoggingEnabled = n12;
        n10 = (int)(((DatabaseConfiguration)object).multiInstanceInvalidation ? 1 : 0);
        if (n10 != 0) {
            object2 = this.mInvalidationTracker;
            object3 = ((DatabaseConfiguration)object).context;
            iterator2 = ((DatabaseConfiguration)object).name;
            ((InvalidationTracker)object2).startMultiInstanceInvalidation((Context)object3, (String)((Object)iterator2));
        }
        object2 = this.getRequiredTypeConverters();
        object3 = new BitSet();
        object2 = object2.entrySet().iterator();
        while ((n12 = object2.hasNext()) != 0) {
            boolean bl2;
            iterator2 = (Map.Entry)object2.next();
            Class clazz = (Class)iterator2.getKey();
            iterator2 = ((List)iterator2.getValue()).iterator();
            while (bl2 = iterator2.hasNext()) {
                Class<?> clazz2;
                int n14;
                List list;
                Class clazz3;
                block11: {
                    clazz3 = (Class)iterator2.next();
                    list = ((DatabaseConfiguration)object).typeConverters;
                    for (n14 = list.size() - n13; n14 >= 0; n14 += -1) {
                        clazz2 = ((DatabaseConfiguration)object).typeConverters.get(n14).getClass();
                        boolean bl3 = clazz3.isAssignableFrom(clazz2);
                        if (!bl3) continue;
                        ((BitSet)object3).set(n14);
                        break block11;
                    }
                    n14 = -1;
                }
                if (n14 >= 0) {
                    clazz2 = this.mTypeConverters;
                    List list2 = ((DatabaseConfiguration)object).typeConverters;
                    list = list2.get(n14);
                    clazz2.put(clazz3, list);
                    continue;
                }
                object2 = new StringBuilder();
                ((StringBuilder)object2).append("A required type converter (");
                ((StringBuilder)object2).append(clazz3);
                ((StringBuilder)object2).append(") for ");
                object3 = clazz.getCanonicalName();
                ((StringBuilder)object2).append((String)object3);
                ((StringBuilder)object2).append(" is missing in the database configuration.");
                object2 = ((StringBuilder)object2).toString();
                object = new IllegalArgumentException((String)object2);
                throw object;
            }
        }
        object2 = ((DatabaseConfiguration)object).typeConverters;
        for (n10 = object2.size() - n13; n10 >= 0; n10 += -1) {
            n12 = (int)(((BitSet)object3).get(n10) ? 1 : 0);
            if (n12 != 0) {
                continue;
            }
            object = ((DatabaseConfiguration)object).typeConverters.get(n10);
            object3 = new StringBuilder();
            ((StringBuilder)object3).append("Unexpected type converter ");
            ((StringBuilder)object3).append(object);
            ((StringBuilder)object3).append(". Annotate TypeConverter class with @ProvidedTypeConverter annotation or remove this converter from the builder.");
            object = ((StringBuilder)object3).toString();
            object2 = new IllegalArgumentException((String)object);
            throw object2;
        }
    }

    public void internalInitInvalidationTracker(SupportSQLiteDatabase supportSQLiteDatabase) {
        this.mInvalidationTracker.internalInit(supportSQLiteDatabase);
    }

    public boolean isOpen() {
        boolean bl2;
        Object object = this.mAutoCloser;
        if (object != null) {
            return ((AutoCloser)object).isActive();
        }
        object = this.mDatabase;
        if (object != null && (bl2 = object.isOpen())) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    public Cursor query(SupportSQLiteQuery supportSQLiteQuery) {
        return this.query(supportSQLiteQuery, null);
    }

    public Cursor query(SupportSQLiteQuery supportSQLiteQuery, CancellationSignal cancellationSignal) {
        int n10;
        int n11;
        this.assertNotMainThread();
        this.assertNotSuspendingTransaction();
        if (cancellationSignal != null && (n11 = Build.VERSION.SDK_INT) >= (n10 = 16)) {
            return this.mOpenHelper.getWritableDatabase().query(supportSQLiteQuery, cancellationSignal);
        }
        return this.mOpenHelper.getWritableDatabase().query(supportSQLiteQuery);
    }

    public Cursor query(String string2, Object[] objectArray) {
        SupportSQLiteDatabase supportSQLiteDatabase = this.mOpenHelper.getWritableDatabase();
        SimpleSQLiteQuery simpleSQLiteQuery = new SimpleSQLiteQuery(string2, objectArray);
        return supportSQLiteDatabase.query(simpleSQLiteQuery);
    }

    /*
     * Exception decompiling
     */
    public Object runInTransaction(Callable var1_1) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Back jump on a try block [egrp 2[TRYBLOCK] [6 : 26->30)] java.lang.Throwable
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op02WithProcessedDataAndRefs.insertExceptionBlocks(Op02WithProcessedDataAndRefs.java:2289)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:414)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1042)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:929)
         *     at org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:257)
         *     at org.benf.cfr.reader.Driver.doJar(Driver.java:139)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:73)
         *     at org.benf.cfr.reader.Main.main(Main.java:49)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    public void runInTransaction(Runnable runnable) {
        this.beginTransaction();
        try {
            runnable.run();
            this.setTransactionSuccessful();
            return;
        }
        finally {
            this.endTransaction();
        }
    }

    public void setTransactionSuccessful() {
        this.mOpenHelper.getWritableDatabase().setTransactionSuccessful();
    }
}

