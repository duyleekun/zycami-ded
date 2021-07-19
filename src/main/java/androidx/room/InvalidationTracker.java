/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.database.sqlite.SQLiteException
 *  android.os.Build$VERSION
 *  android.util.Log
 */
package androidx.room;

import android.content.Context;
import android.database.sqlite.SQLiteException;
import android.os.Build;
import android.util.Log;
import androidx.arch.core.internal.SafeIterableMap;
import androidx.lifecycle.LiveData;
import androidx.room.AutoCloser;
import androidx.room.InvalidationLiveDataContainer;
import androidx.room.InvalidationTracker$1;
import androidx.room.InvalidationTracker$ObservedTableTracker;
import androidx.room.InvalidationTracker$Observer;
import androidx.room.InvalidationTracker$ObserverWrapper;
import androidx.room.InvalidationTracker$WeakObserver;
import androidx.room.MultiInstanceInvalidationClient;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;
import b.b.w0;
import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

public class InvalidationTracker {
    private static final String CREATE_TRACKING_TABLE_SQL = "CREATE TEMP TABLE room_table_modification_log(table_id INTEGER PRIMARY KEY, invalidated INTEGER NOT NULL DEFAULT 0)";
    private static final String INVALIDATED_COLUMN_NAME = "invalidated";
    public static final String RESET_UPDATED_TABLES_SQL = "UPDATE room_table_modification_log SET invalidated = 0 WHERE invalidated = 1 ";
    public static final String SELECT_UPDATED_TABLES_SQL = "SELECT * FROM room_table_modification_log WHERE invalidated = 1;";
    private static final String TABLE_ID_COLUMN_NAME = "table_id";
    private static final String[] TRIGGERS = new String[]{"UPDATE", "DELETE", "INSERT"};
    private static final String UPDATE_TABLE_NAME = "room_table_modification_log";
    public AutoCloser mAutoCloser;
    public volatile SupportSQLiteStatement mCleanupStatement;
    public final RoomDatabase mDatabase;
    private volatile boolean mInitialized;
    private final InvalidationLiveDataContainer mInvalidationLiveDataContainer;
    private MultiInstanceInvalidationClient mMultiInstanceInvalidationClient;
    private InvalidationTracker$ObservedTableTracker mObservedTableTracker;
    public final SafeIterableMap mObserverMap;
    public AtomicBoolean mPendingRefresh;
    public Runnable mRefreshRunnable;
    public final HashMap mTableIdLookup;
    public final String[] mTableNames;
    private Map mViewTables;

    public InvalidationTracker(RoomDatabase object, Map object2, Map object3, String ... object4) {
        boolean bl2;
        boolean bl3 = false;
        this.mAutoCloser = null;
        Object object5 = new AtomicBoolean(false);
        this.mPendingRefresh = object5;
        this.mInitialized = false;
        object5 = new SafeIterableMap();
        this.mObserverMap = object5;
        object5 = new InvalidationTracker$1(this);
        this.mRefreshRunnable = object5;
        this.mDatabase = object;
        int n10 = ((String[])object4).length;
        object5 = new InvalidationTracker$ObservedTableTracker(n10);
        this.mObservedTableTracker = object5;
        object5 = new HashMap();
        this.mTableIdLookup = object5;
        this.mViewTables = object3;
        this.mInvalidationLiveDataContainer = object3 = new InvalidationLiveDataContainer((RoomDatabase)object);
        int n11 = ((String[])object4).length;
        object3 = new String[n11];
        this.mTableNames = object3;
        for (int i10 = 0; i10 < n11; ++i10) {
            object3 = object4[i10];
            object5 = Locale.US;
            object3 = ((String)object3).toLowerCase((Locale)object5);
            Object object6 = this.mTableIdLookup;
            Integer n12 = i10;
            ((HashMap)object6).put(object3, n12);
            object6 = object4[i10];
            object6 = (String)object2.get(object6);
            if (object6 != null) {
                object3 = this.mTableNames;
                object3[i10] = object5 = ((String)object6).toLowerCase((Locale)object5);
                continue;
            }
            object5 = this.mTableNames;
            object5[i10] = object3;
        }
        object = object2.entrySet().iterator();
        while (bl2 = object.hasNext()) {
            object2 = (Map.Entry)object.next();
            object3 = (String)object2.getValue();
            object5 = this.mTableIdLookup;
            object4 = Locale.US;
            bl3 = object5.containsKey(object3 = ((String)object3).toLowerCase((Locale)object4));
            if (!bl3) continue;
            object2 = ((String)object2.getKey()).toLowerCase((Locale)object4);
            object4 = this.mTableIdLookup;
            object3 = (Integer)((HashMap)object4).get(object3);
            ((HashMap)object4).put(object2, object3);
        }
    }

    public InvalidationTracker(RoomDatabase roomDatabase, String ... stringArray) {
        HashMap hashMap = new HashMap();
        Map map = Collections.emptyMap();
        this(roomDatabase, hashMap, map, stringArray);
    }

    private static void appendTriggerName(StringBuilder stringBuilder, String string2, String string3) {
        String string4 = "`";
        stringBuilder.append(string4);
        stringBuilder.append("room_table_modification_trigger_");
        stringBuilder.append(string2);
        stringBuilder.append("_");
        stringBuilder.append(string3);
        stringBuilder.append(string4);
    }

    private static void beginTransactionInternal(SupportSQLiteDatabase supportSQLiteDatabase) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 16;
        if (n10 >= n11 && (n10 = (int)(supportSQLiteDatabase.isWriteAheadLoggingEnabled() ? 1 : 0)) != 0) {
            supportSQLiteDatabase.beginTransactionNonExclusive();
        } else {
            supportSQLiteDatabase.beginTransaction();
        }
    }

    private String[] resolveViews(String[] stringArray) {
        HashSet<String> hashSet = new HashSet<String>();
        for (String string2 : stringArray) {
            Object object = Locale.US;
            Map map = this.mViewTables;
            boolean bl2 = map.containsKey(object = string2.toLowerCase((Locale)object));
            if (bl2) {
                Collection collection = (Collection)this.mViewTables.get(object);
                hashSet.addAll(collection);
                continue;
            }
            hashSet.add(string2);
        }
        stringArray = new String[hashSet.size()];
        return hashSet.toArray(stringArray);
    }

    private void startTrackingTable(SupportSQLiteDatabase supportSQLiteDatabase, int n10) {
        CharSequence charSequence = new StringBuilder();
        charSequence.append("INSERT OR IGNORE INTO room_table_modification_log VALUES(");
        charSequence.append(n10);
        charSequence.append(", 0)");
        charSequence = charSequence.toString();
        supportSQLiteDatabase.execSQL((String)charSequence);
        charSequence = this.mTableNames[n10];
        StringBuilder stringBuilder = new StringBuilder();
        for (String string2 : TRIGGERS) {
            stringBuilder.setLength(0);
            stringBuilder.append("CREATE TEMP TRIGGER IF NOT EXISTS ");
            InvalidationTracker.appendTriggerName(stringBuilder, (String)charSequence, string2);
            stringBuilder.append(" AFTER ");
            stringBuilder.append(string2);
            stringBuilder.append(" ON `");
            stringBuilder.append((String)charSequence);
            stringBuilder.append("` BEGIN UPDATE ");
            stringBuilder.append(UPDATE_TABLE_NAME);
            stringBuilder.append(" SET ");
            string2 = INVALIDATED_COLUMN_NAME;
            stringBuilder.append(string2);
            stringBuilder.append(" = 1");
            stringBuilder.append(" WHERE ");
            stringBuilder.append(TABLE_ID_COLUMN_NAME);
            stringBuilder.append(" = ");
            stringBuilder.append(n10);
            String string3 = " AND ";
            stringBuilder.append(string3);
            stringBuilder.append(string2);
            stringBuilder.append(" = 0");
            stringBuilder.append("; END");
            string2 = stringBuilder.toString();
            supportSQLiteDatabase.execSQL(string2);
        }
    }

    private void stopTrackingTable(SupportSQLiteDatabase supportSQLiteDatabase, int n10) {
        String string2 = this.mTableNames[n10];
        StringBuilder stringBuilder = new StringBuilder();
        for (String string3 : TRIGGERS) {
            stringBuilder.setLength(0);
            String string4 = "DROP TRIGGER IF EXISTS ";
            stringBuilder.append(string4);
            InvalidationTracker.appendTriggerName(stringBuilder, string2, string3);
            string3 = stringBuilder.toString();
            supportSQLiteDatabase.execSQL(string3);
        }
    }

    private String[] validateAndResolveTableNames(String[] object) {
        object = this.resolveViews((String[])object);
        int n10 = ((String[])object).length;
        for (int i10 = 0; i10 < n10; ++i10) {
            String string2 = object[i10];
            HashMap hashMap = this.mTableIdLookup;
            Object object2 = Locale.US;
            boolean bl2 = hashMap.containsKey(object2 = string2.toLowerCase((Locale)object2));
            if (bl2) {
                continue;
            }
            CharSequence charSequence = new StringBuilder();
            charSequence.append("There is no table with name ");
            charSequence.append(string2);
            charSequence = charSequence.toString();
            object = new IllegalArgumentException((String)charSequence);
            throw object;
        }
        return object;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public void addObserver(InvalidationTracker$Observer object) {
        Object object2 = ((InvalidationTracker$Observer)object).mTables;
        object2 = this.resolveViews((String[])object2);
        int n10 = ((String[])object2).length;
        Object object3 = new int[n10];
        int n11 = ((String[])object2).length;
        int n12 = 0;
        SafeIterableMap safeIterableMap = null;
        while (true) {
            int n13;
            if (n12 >= n11) {
                InvalidationTracker$ObserverWrapper invalidationTracker$ObserverWrapper = new InvalidationTracker$ObserverWrapper((InvalidationTracker$Observer)object, (int[])object3, (String[])object2);
                object2 = this.mObserverMap;
                // MONITORENTER : object2
                safeIterableMap = this.mObserverMap;
                object = safeIterableMap.putIfAbsent(object, invalidationTracker$ObserverWrapper);
                object = (InvalidationTracker$ObserverWrapper)object;
                // MONITOREXIT : object2
                if (object != null) return;
                object = this.mObservedTableTracker;
                boolean bl2 = ((InvalidationTracker$ObservedTableTracker)object).onAdded((int[])object3);
                if (!bl2) return;
                this.syncTriggers();
                return;
            }
            Serializable serializable = this.mTableIdLookup;
            String string2 = object2[n12];
            Locale locale = Locale.US;
            if ((serializable = (Integer)((HashMap)serializable).get(string2 = string2.toLowerCase(locale))) == null) {
                object3 = new StringBuilder;
                ((StringBuilder)object3)();
                ((StringBuilder)object3).append("There is no table with name ");
                object2 = object2[n12];
                ((StringBuilder)object3).append((String)object2);
                object2 = ((StringBuilder)object3).toString();
                object = new IllegalArgumentException((String)object2);
                throw object;
            }
            object3[n12] = n13 = ((Integer)serializable).intValue();
            ++n12;
        }
    }

    public void addWeakObserver(InvalidationTracker$Observer invalidationTracker$Observer) {
        InvalidationTracker$WeakObserver invalidationTracker$WeakObserver = new InvalidationTracker$WeakObserver(this, invalidationTracker$Observer);
        this.addObserver(invalidationTracker$WeakObserver);
    }

    public LiveData createLiveData(String[] stringArray, Callable callable) {
        return this.createLiveData(stringArray, false, callable);
    }

    public LiveData createLiveData(String[] stringArray, boolean bl2, Callable callable) {
        InvalidationLiveDataContainer invalidationLiveDataContainer = this.mInvalidationLiveDataContainer;
        stringArray = this.validateAndResolveTableNames(stringArray);
        return invalidationLiveDataContainer.create(stringArray, bl2, callable);
    }

    public boolean ensureInitialization() {
        Object object = this.mDatabase;
        boolean bl2 = ((RoomDatabase)object).isOpen();
        if (!bl2) {
            return false;
        }
        bl2 = this.mInitialized;
        if (!bl2) {
            object = this.mDatabase.getOpenHelper();
            object.getWritableDatabase();
        }
        if (!(bl2 = this.mInitialized)) {
            Log.e((String)"ROOM", (String)"database is not initialized even though it is open");
            return false;
        }
        return true;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void internalInit(SupportSQLiteDatabase object) {
        synchronized (this) {
            boolean bl2;
            boolean bl3 = this.mInitialized;
            if (bl3) {
                object = "ROOM";
                String string2 = "Invalidation tracker is initialized twice :/.";
                Log.e((String)object, (String)string2);
                return;
            }
            String string3 = "PRAGMA temp_store = MEMORY;";
            object.execSQL(string3);
            string3 = "PRAGMA recursive_triggers='ON';";
            object.execSQL(string3);
            string3 = CREATE_TRACKING_TABLE_SQL;
            object.execSQL(string3);
            this.syncTriggers((SupportSQLiteDatabase)object);
            string3 = RESET_UPDATED_TABLES_SQL;
            this.mCleanupStatement = object = object.compileStatement(string3);
            this.mInitialized = bl2 = true;
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void notifyObserversByTableNames(String ... stringArray) {
        SafeIterableMap safeIterableMap = this.mObserverMap;
        synchronized (safeIterableMap) {
            Object object = this.mObserverMap;
            object = ((SafeIterableMap)object).iterator();
            boolean bl2;
            while (bl2 = object.hasNext()) {
                Object object2 = object.next();
                object2 = (Map.Entry)object2;
                Object object3 = object2.getKey();
                boolean bl3 = ((InvalidationTracker$Observer)(object3 = (InvalidationTracker$Observer)object3)).isRemote();
                if (bl3) continue;
                object2 = object2.getValue();
                object2 = (InvalidationTracker$ObserverWrapper)object2;
                ((InvalidationTracker$ObserverWrapper)object2).notifyByTableNames(stringArray);
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void onAutoCloseCallback() {
        synchronized (this) {
            InvalidationTracker$ObservedTableTracker invalidationTracker$ObservedTableTracker = null;
            this.mInitialized = false;
            invalidationTracker$ObservedTableTracker = this.mObservedTableTracker;
            invalidationTracker$ObservedTableTracker.resetTriggerState();
            return;
        }
    }

    public void refreshVersionsAsync() {
        Object object = this.mPendingRefresh;
        Runnable runnable = null;
        boolean bl2 = true;
        boolean bl3 = ((AtomicBoolean)object).compareAndSet(false, bl2);
        if (bl3) {
            object = this.mAutoCloser;
            if (object != null) {
                ((AutoCloser)object).incrementCountAndEnsureDbIsOpen();
            }
            object = this.mDatabase.getQueryExecutor();
            runnable = this.mRefreshRunnable;
            object.execute(runnable);
        }
    }

    public void refreshVersionsSync() {
        AutoCloser autoCloser = this.mAutoCloser;
        if (autoCloser != null) {
            autoCloser.incrementCountAndEnsureDbIsOpen();
        }
        this.syncTriggers();
        this.mRefreshRunnable.run();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public void removeObserver(InvalidationTracker$Observer object) {
        Object object2 = this.mObserverMap;
        // MONITORENTER : object2
        SafeIterableMap safeIterableMap = this.mObserverMap;
        object = safeIterableMap.remove(object);
        object = (InvalidationTracker$ObserverWrapper)object;
        // MONITOREXIT : object2
        if (object == null) return;
        object2 = this.mObservedTableTracker;
        object = ((InvalidationTracker$ObserverWrapper)object).mTableIds;
        boolean bl2 = ((InvalidationTracker$ObservedTableTracker)object2).onRemoved((int[])object);
        if (!bl2) return;
        this.syncTriggers();
    }

    public void setAutoCloser(AutoCloser autoCloser) {
        this.mAutoCloser = autoCloser;
        w0 w02 = new w0(this);
        autoCloser.setAutoCloseCallback(w02);
    }

    public void startMultiInstanceInvalidation(Context context, String string2) {
        MultiInstanceInvalidationClient multiInstanceInvalidationClient;
        Executor executor = this.mDatabase.getQueryExecutor();
        this.mMultiInstanceInvalidationClient = multiInstanceInvalidationClient = new MultiInstanceInvalidationClient(context, string2, this, executor);
    }

    public void stopMultiInstanceInvalidation() {
        MultiInstanceInvalidationClient multiInstanceInvalidationClient = this.mMultiInstanceInvalidationClient;
        if (multiInstanceInvalidationClient != null) {
            multiInstanceInvalidationClient.stop();
            multiInstanceInvalidationClient = null;
            this.mMultiInstanceInvalidationClient = null;
        }
    }

    public void syncTriggers() {
        Object object = this.mDatabase;
        boolean bl2 = ((RoomDatabase)object).isOpen();
        if (!bl2) {
            return;
        }
        object = this.mDatabase.getOpenHelper().getWritableDatabase();
        this.syncTriggers((SupportSQLiteDatabase)object);
    }

    /*
     * Loose catch block
     * WARNING - void declaration
     */
    public void syncTriggers(SupportSQLiteDatabase supportSQLiteDatabase) {
        void var1_5;
        Object object;
        boolean bl2 = supportSQLiteDatabase.inTransaction();
        if (bl2) {
            return;
        }
        while (true) {
            Object object2;
            block24: {
                object = this.mDatabase;
                object = ((RoomDatabase)object).getCloseLock();
                object.lock();
                object2 = this.mObservedTableTracker;
                object2 = ((InvalidationTracker$ObservedTableTracker)object2).getTablesToSync();
                if (object2 != null) break block24;
                object.unlock();
                return;
            }
            int n10 = ((Object)object2).length;
            InvalidationTracker.beginTransactionInternal(supportSQLiteDatabase);
            for (int i10 = 0; i10 < n10; ++i10) {
                block25: {
                    Object object3 = object2[i10];
                    int n11 = 1;
                    if (object3 == n11) break block25;
                    n11 = 2;
                    if (object3 != n11) continue;
                    this.stopTrackingTable(supportSQLiteDatabase, i10);
                    continue;
                }
                this.startTrackingTable(supportSQLiteDatabase, i10);
            }
            supportSQLiteDatabase.setTransactionSuccessful();
            supportSQLiteDatabase.endTransaction();
            object2 = this.mObservedTableTracker;
            ((InvalidationTracker$ObservedTableTracker)object2).onSyncCompleted();
            object.unlock();
            continue;
            break;
        }
        catch (Throwable throwable) {
            try {
                supportSQLiteDatabase.endTransaction();
                throw throwable;
            }
            catch (Throwable throwable2) {
                try {
                    object.unlock();
                    throw throwable2;
                }
                catch (SQLiteException sQLiteException) {
                }
                catch (IllegalStateException illegalStateException) {
                    // empty catch block
                }
            }
        }
        Log.e((String)"ROOM", (String)"Cannot run invalidation tracker. Is the db closed?", (Throwable)var1_5);
    }
}

