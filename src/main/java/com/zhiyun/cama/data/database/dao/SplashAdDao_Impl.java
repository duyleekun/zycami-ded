/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.database.Cursor
 */
package com.zhiyun.cama.data.database.dao;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.room.EntityInsertionAdapter;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.zhiyun.cama.data.database.dao.SplashAdDao;
import com.zhiyun.cama.data.database.dao.SplashAdDao_Impl$1;
import com.zhiyun.cama.data.database.dao.SplashAdDao_Impl$4;
import com.zhiyun.cama.data.database.dao.SplashAdDao_Impl$5;
import com.zhiyun.cama.data.database.dao.SplashAdDao_Impl$6;
import com.zhiyun.cama.data.database.dao.SplashAdDao_Impl$7;
import com.zhiyun.cama.data.database.model.SplashAd;
import com.zhiyun.cama.data.database.model.SplashAdWatch;
import java.util.Collections;
import java.util.List;

public final class SplashAdDao_Impl
implements SplashAdDao {
    private final RoomDatabase __db;
    private final EntityInsertionAdapter __insertionAdapterOfSplashAd;
    private final EntityInsertionAdapter __insertionAdapterOfSplashAdWatch;
    private final SharedSQLiteStatement __preparedStmtOfDeleteAllSplashAd;

    public SplashAdDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        SharedSQLiteStatement sharedSQLiteStatement = new SplashAdDao_Impl$1(this, roomDatabase);
        this.__insertionAdapterOfSplashAd = sharedSQLiteStatement;
        super(this, roomDatabase);
        this.__insertionAdapterOfSplashAdWatch = sharedSQLiteStatement;
        super(this, roomDatabase);
        this.__preparedStmtOfDeleteAllSplashAd = sharedSQLiteStatement;
    }

    public static /* synthetic */ RoomDatabase access$000(SplashAdDao_Impl splashAdDao_Impl) {
        return splashAdDao_Impl.__db;
    }

    public static List getRequiredConverters() {
        return Collections.emptyList();
    }

    public void deleteAllSplashAd() {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatement = this.__preparedStmtOfDeleteAllSplashAd.acquire();
        RoomDatabase roomDatabase = this.__db;
        roomDatabase.beginTransaction();
        try {
            supportSQLiteStatement.executeUpdateDelete();
            roomDatabase = this.__db;
            roomDatabase.setTransactionSuccessful();
            return;
        }
        finally {
            this.__db.endTransaction();
            this.__preparedStmtOfDeleteAllSplashAd.release(supportSQLiteStatement);
        }
    }

    public void insertSplashAd(SplashAd ... object) {
        this.__db.assertNotSuspendingTransaction();
        Object object2 = this.__db;
        ((RoomDatabase)object2).beginTransaction();
        try {
            object2 = this.__insertionAdapterOfSplashAd;
            ((EntityInsertionAdapter)object2).insert((Object[])object);
            object = this.__db;
            ((RoomDatabase)object).setTransactionSuccessful();
            return;
        }
        finally {
            this.__db.endTransaction();
        }
    }

    public void insertSplashAdWatch(SplashAdWatch object) {
        this.__db.assertNotSuspendingTransaction();
        Object object2 = this.__db;
        ((RoomDatabase)object2).beginTransaction();
        try {
            object2 = this.__insertionAdapterOfSplashAdWatch;
            ((EntityInsertionAdapter)object2).insert(object);
            object = this.__db;
            ((RoomDatabase)object).setTransactionSuccessful();
            return;
        }
        finally {
            this.__db.endTransaction();
        }
    }

    public LiveData loadSplashAd(int n10) {
        int n11 = 1;
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire("SELECT * FROM SplashAd WHERE id = ?", n11);
        long l10 = n10;
        roomSQLiteQuery.bindLong(n11, l10);
        InvalidationTracker invalidationTracker = this.__db.getInvalidationTracker();
        String[] stringArray = new String[]{"SplashAd"};
        SplashAdDao_Impl$7 splashAdDao_Impl$7 = new SplashAdDao_Impl$7(this, roomSQLiteQuery);
        return invalidationTracker.createLiveData(stringArray, false, splashAdDao_Impl$7);
    }

    public SplashAdWatch loadSplashAdWatchData(int n10) {
        SplashAdWatch splashAdWatch;
        RoomDatabase roomDatabase;
        RoomSQLiteQuery roomSQLiteQuery;
        block10: {
            int n11;
            int n12;
            SplashAdWatch splashAdWatch2;
            boolean bl2;
            block11: {
                String string2;
                int n13;
                bl2 = true;
                roomSQLiteQuery = RoomSQLiteQuery.acquire("SELECT * FROM SplashAdWatch WHERE watchId = ?", (int)(bl2 ? 1 : 0));
                long l10 = n10;
                roomSQLiteQuery.bindLong((int)(bl2 ? 1 : 0), l10);
                this.__db.assertNotSuspendingTransaction();
                roomDatabase = this.__db;
                splashAdWatch2 = null;
                n12 = 0;
                splashAdWatch = null;
                roomDatabase = DBUtil.query(roomDatabase, roomSQLiteQuery, false, null);
                String string3 = "watchId";
                try {
                    n13 = CursorUtil.getColumnIndexOrThrow((Cursor)roomDatabase, string3);
                    string2 = "isWatched";
                }
                catch (Throwable throwable) {
                    roomDatabase.close();
                    roomSQLiteQuery.release();
                    throw throwable;
                }
                int n14 = CursorUtil.getColumnIndexOrThrow((Cursor)roomDatabase, string2);
                String string4 = "watchTime";
                n11 = CursorUtil.getColumnIndexOrThrow((Cursor)roomDatabase, string4);
                boolean bl3 = roomDatabase.moveToFirst();
                if (!bl3) break block10;
                n12 = roomDatabase.getInt(n13);
                n13 = roomDatabase.getInt(n14);
                if (n13 != 0) break block11;
                bl2 = false;
                Object var17_16 = null;
            }
            long l11 = roomDatabase.getLong(n11);
            splashAdWatch = splashAdWatch2 = new SplashAdWatch(n12, bl2, l11);
        }
        roomDatabase.close();
        roomSQLiteQuery.release();
        return splashAdWatch;
    }

    public LiveData loadTypeOneSplashAd(String object, long l10) {
        int n10 = 3;
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire("SELECT * FROM SplashAd WHERE type = 1 AND startUnix < ? AND endUnix > ? AND lang = ? AND isWatched = 0 ", n10);
        roomSQLiteQuery.bindLong(1, l10);
        int n11 = 2;
        roomSQLiteQuery.bindLong(n11, l10);
        if (object == null) {
            roomSQLiteQuery.bindNull(n10);
        } else {
            roomSQLiteQuery.bindString(n10, (String)object);
        }
        object = this.__db.getInvalidationTracker();
        String[] stringArray = new String[]{"SplashAd"};
        SplashAdDao_Impl$4 splashAdDao_Impl$4 = new SplashAdDao_Impl$4(this, roomSQLiteQuery);
        return ((InvalidationTracker)object).createLiveData(stringArray, false, splashAdDao_Impl$4);
    }

    public LiveData loadTypeThreeSplashAd(String object, long l10) {
        int n10 = 3;
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire("SELECT * FROM SplashAd WHERE type = 3 AND startUnix < ? AND endUnix > ? AND lang = ?", n10);
        roomSQLiteQuery.bindLong(1, l10);
        int n11 = 2;
        roomSQLiteQuery.bindLong(n11, l10);
        if (object == null) {
            roomSQLiteQuery.bindNull(n10);
        } else {
            roomSQLiteQuery.bindString(n10, (String)object);
        }
        object = this.__db.getInvalidationTracker();
        String[] stringArray = new String[]{"SplashAd"};
        SplashAdDao_Impl$6 splashAdDao_Impl$6 = new SplashAdDao_Impl$6(this, roomSQLiteQuery);
        return ((InvalidationTracker)object).createLiveData(stringArray, false, splashAdDao_Impl$6);
    }

    public LiveData loadTypeTwoSplashAd(String object, long l10, long l11) {
        int n10 = 4;
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire("SELECT * FROM SplashAd WHERE type = 2 AND startUnix < ? AND endUnix > ? AND lang = ? AND watchTime < ? ", n10);
        roomSQLiteQuery.bindLong(1, l10);
        int n11 = 2;
        roomSQLiteQuery.bindLong(n11, l10);
        int n12 = 3;
        if (object == null) {
            roomSQLiteQuery.bindNull(n12);
        } else {
            roomSQLiteQuery.bindString(n12, (String)object);
        }
        roomSQLiteQuery.bindLong(n10, l11);
        object = this.__db.getInvalidationTracker();
        String[] stringArray = new String[]{"SplashAd"};
        SplashAdDao_Impl$5 splashAdDao_Impl$5 = new SplashAdDao_Impl$5(this, roomSQLiteQuery);
        return ((InvalidationTracker)object).createLiveData(stringArray, false, splashAdDao_Impl$5);
    }
}

