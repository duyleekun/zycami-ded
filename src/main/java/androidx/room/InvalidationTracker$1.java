/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.database.sqlite.SQLiteException
 *  android.util.Log
 */
package androidx.room;

import android.database.sqlite.SQLiteException;
import android.util.Log;
import androidx.room.InvalidationTracker;
import androidx.room.InvalidationTracker$ObserverWrapper;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SimpleSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteQuery;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class InvalidationTracker$1
implements Runnable {
    public final /* synthetic */ InvalidationTracker this$0;

    public InvalidationTracker$1(InvalidationTracker invalidationTracker) {
        this.this$0 = invalidationTracker;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private Set checkUpdatedTable() {
        Object object;
        HashSet<Object> hashSet;
        block4: {
            int n10;
            hashSet = new HashSet<Object>();
            object = this.this$0.mDatabase;
            String string2 = "SELECT * FROM room_table_modification_log WHERE invalidated = 1;";
            Object object2 = new SimpleSQLiteQuery(string2);
            object = ((RoomDatabase)object).query((SupportSQLiteQuery)object2);
            while ((n10 = object.moveToNext()) != 0) {
                n10 = 0;
                object2 = null;
                n10 = object.getInt(0);
                object2 = n10;
                hashSet.add(object2);
            }
            boolean bl2 = hashSet.isEmpty();
            if (bl2) break block4;
            object = this.this$0.mCleanupStatement;
            object.executeUpdateDelete();
        }
        return hashSet;
        finally {
            object.close();
        }
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void run() {
        block23: {
            block25: {
                block24: {
                    var1_1 = this.this$0.mDatabase.getCloseLock();
                    var1_1.lock();
                    var2_2 = null;
                    try {
                        var3_4 = this.this$0;
                        var4_7 = var3_4.ensureInitialization();
                        if (!var4_7) {
                        }
                        ** GOTO lbl-1000
                    }
                    catch (Throwable var2_3) {
                        break block23;
                    }
                    catch (SQLiteException var3_5) {
                        break block24;
                    }
                    catch (IllegalStateException var3_6) {
                        // empty catch block
                        break block24;
                    }
                    var1_1.unlock();
                    var1_1 = this.this$0.mAutoCloser;
                    if (var1_1 != null) {
                        var1_1.decrementCountAndScheduleClose();
                    }
                    return;
lbl-1000:
                    // 1 sources

                    {
                        var3_4 = this.this$0;
                        var3_4 = var3_4.mPendingRefresh;
                        var5_8 = true;
                        var6_9 = null;
                        var4_7 = var3_4.compareAndSet(var5_8, false);
                        if (var4_7) ** GOTO lbl-1000
                    }
                    var1_1.unlock();
                    var1_1 = this.this$0.mAutoCloser;
                    if (var1_1 != null) {
                        var1_1.decrementCountAndScheduleClose();
                    }
                    return;
lbl-1000:
                    // 1 sources

                    {
                        var3_4 = this.this$0;
                        var3_4 = var3_4.mDatabase;
                        var4_7 = var3_4.inTransaction();
                        if (!var4_7) ** GOTO lbl-1000
                    }
                    var1_1.unlock();
                    var1_1 = this.this$0.mAutoCloser;
                    if (var1_1 != null) {
                        var1_1.decrementCountAndScheduleClose();
                    }
                    return;
lbl-1000:
                    // 1 sources

                    {
                        var3_4 = this.this$0;
                        var3_4 = var3_4.mDatabase;
                        var5_8 = var3_4.mWriteAheadLoggingEnabled;
                        if (!var5_8) ** GOTO lbl-1000
                        var3_4 = var3_4.getOpenHelper();
                        var3_4 = var3_4.getWritableDatabase();
                        var3_4.beginTransactionNonExclusive();
                    }
                    try {
                        var2_2 = this.checkUpdatedTable();
                        var3_4.setTransactionSuccessful();
                    }
                    finally {
                        var3_4.endTransaction();
                    }
lbl-1000:
                    // 1 sources

                    {
                        var2_2 = this.checkUpdatedTable();
                    }
                    var1_1.unlock();
                    var1_1 = this.this$0.mAutoCloser;
                    if (var1_1 != null) {
                        while (true) {
                            var1_1.decrementCountAndScheduleClose();
                            break block25;
                            break;
                        }
                    }
                    break block25;
                }
                var7_11 = "ROOM";
                var6_9 = "Cannot run invalidation tracker. Is the db closed?";
                {
                    Log.e((String)var7_11, (String)var6_9, (Throwable)var3_4);
                    var1_1.unlock();
                    if ((var1_1 = this.this$0.mAutoCloser) != null) ** continue;
                }
            }
            if (var2_2 != null && !(var8_12 = var2_2.isEmpty())) {
                var1_1 = this.this$0.mObserverMap;
                synchronized (var1_1) {
                    var3_4 = this.this$0;
                    var3_4 = var3_4.mObserverMap;
                    var3_4 = var3_4.iterator();
                    while (var5_8 = var3_4.hasNext()) {
                        var7_11 = var3_4.next();
                        var7_11 = (Map.Entry)var7_11;
                        var7_11 = var7_11.getValue();
                        var7_11 = (InvalidationTracker$ObserverWrapper)var7_11;
                        var7_11.notifyByTableInvalidStatus(var2_2);
                    }
                }
            }
            return;
        }
        var1_1.unlock();
        var1_1 = this.this$0.mAutoCloser;
        if (var1_1 != null) {
            var1_1.decrementCountAndScheduleClose();
        }
        throw var2_3;
    }
}

