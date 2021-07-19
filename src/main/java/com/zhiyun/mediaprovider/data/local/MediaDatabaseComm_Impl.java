/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.mediaprovider.data.local;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomOpenHelper;
import androidx.room.RoomOpenHelper$Delegate;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper$Callback;
import androidx.sqlite.db.SupportSQLiteOpenHelper$Configuration;
import androidx.sqlite.db.SupportSQLiteOpenHelper$Configuration$Builder;
import com.zhiyun.mediaprovider.data.local.MediaDatabaseComm;
import com.zhiyun.mediaprovider.data.local.MediaDatabaseComm_Impl$1;
import com.zhiyun.mediaprovider.data.local.dao.AlbumCustomizeDao;
import com.zhiyun.mediaprovider.data.local.dao.AlbumCustomizeDao_Impl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class MediaDatabaseComm_Impl
extends MediaDatabaseComm {
    private volatile AlbumCustomizeDao _albumCustomizeDao;

    public static /* synthetic */ List access$000(MediaDatabaseComm_Impl mediaDatabaseComm_Impl) {
        return mediaDatabaseComm_Impl.mCallbacks;
    }

    public static /* synthetic */ List access$100(MediaDatabaseComm_Impl mediaDatabaseComm_Impl) {
        return mediaDatabaseComm_Impl.mCallbacks;
    }

    public static /* synthetic */ List access$1000(MediaDatabaseComm_Impl mediaDatabaseComm_Impl) {
        return mediaDatabaseComm_Impl.mCallbacks;
    }

    public static /* synthetic */ List access$200(MediaDatabaseComm_Impl mediaDatabaseComm_Impl) {
        return mediaDatabaseComm_Impl.mCallbacks;
    }

    public static /* synthetic */ List access$300(MediaDatabaseComm_Impl mediaDatabaseComm_Impl) {
        return mediaDatabaseComm_Impl.mCallbacks;
    }

    public static /* synthetic */ List access$400(MediaDatabaseComm_Impl mediaDatabaseComm_Impl) {
        return mediaDatabaseComm_Impl.mCallbacks;
    }

    public static /* synthetic */ List access$500(MediaDatabaseComm_Impl mediaDatabaseComm_Impl) {
        return mediaDatabaseComm_Impl.mCallbacks;
    }

    public static /* synthetic */ SupportSQLiteDatabase access$602(MediaDatabaseComm_Impl mediaDatabaseComm_Impl, SupportSQLiteDatabase supportSQLiteDatabase) {
        mediaDatabaseComm_Impl.mDatabase = supportSQLiteDatabase;
        return supportSQLiteDatabase;
    }

    public static /* synthetic */ void access$700(MediaDatabaseComm_Impl mediaDatabaseComm_Impl, SupportSQLiteDatabase supportSQLiteDatabase) {
        mediaDatabaseComm_Impl.internalInitInvalidationTracker(supportSQLiteDatabase);
    }

    public static /* synthetic */ List access$800(MediaDatabaseComm_Impl mediaDatabaseComm_Impl) {
        return mediaDatabaseComm_Impl.mCallbacks;
    }

    public static /* synthetic */ List access$900(MediaDatabaseComm_Impl mediaDatabaseComm_Impl) {
        return mediaDatabaseComm_Impl.mCallbacks;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public AlbumCustomizeDao albumCustomizeDao() {
        AlbumCustomizeDao albumCustomizeDao = this._albumCustomizeDao;
        if (albumCustomizeDao != null) {
            return this._albumCustomizeDao;
        }
        synchronized (this) {
            albumCustomizeDao = this._albumCustomizeDao;
            if (albumCustomizeDao != null) return this._albumCustomizeDao;
            this._albumCustomizeDao = albumCustomizeDao = new AlbumCustomizeDao_Impl(this);
            return this._albumCustomizeDao;
        }
    }

    public void clearAllTables() {
        String string2 = "VACUUM";
        String string3 = "PRAGMA wal_checkpoint(FULL)";
        super.assertNotMainThread();
        SupportSQLiteDatabase supportSQLiteDatabase = super.getOpenHelper().getWritableDatabase();
        try {
            super.beginTransaction();
            String string4 = "DELETE FROM `AlbumCustomizeData`";
            supportSQLiteDatabase.execSQL(string4);
            super.setTransactionSuccessful();
            return;
        }
        finally {
            super.endTransaction();
            string3 = supportSQLiteDatabase.query(string3);
            string3.close();
            boolean bl2 = supportSQLiteDatabase.inTransaction();
            if (!bl2) {
                supportSQLiteDatabase.execSQL(string2);
            }
        }
    }

    public InvalidationTracker createInvalidationTracker() {
        HashMap hashMap = new HashMap(0);
        HashMap hashMap2 = new HashMap(0);
        String[] stringArray = new String[]{"AlbumCustomizeData"};
        InvalidationTracker invalidationTracker = new InvalidationTracker((RoomDatabase)this, hashMap, hashMap2, stringArray);
        return invalidationTracker;
    }

    public SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration databaseConfiguration) {
        Object object = new MediaDatabaseComm_Impl$1(this, 1);
        Object object2 = new RoomOpenHelper(databaseConfiguration, (RoomOpenHelper$Delegate)object, "744bf2c9f9d331baa5f0eecfb319a5c9", "fc1e737953a5318e800526a53db1dd06");
        object = SupportSQLiteOpenHelper$Configuration.builder(databaseConfiguration.context);
        String string2 = databaseConfiguration.name;
        object2 = ((SupportSQLiteOpenHelper$Configuration$Builder)object).name(string2).callback((SupportSQLiteOpenHelper$Callback)object2).build();
        return databaseConfiguration.sqliteOpenHelperFactory.create((SupportSQLiteOpenHelper$Configuration)object2);
    }

    public Map getRequiredTypeConverters() {
        HashMap<Class<AlbumCustomizeDao>, List> hashMap = new HashMap<Class<AlbumCustomizeDao>, List>();
        List list = AlbumCustomizeDao_Impl.getRequiredConverters();
        hashMap.put(AlbumCustomizeDao.class, list);
        return hashMap;
    }
}

