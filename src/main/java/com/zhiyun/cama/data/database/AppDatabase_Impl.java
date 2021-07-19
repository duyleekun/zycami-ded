/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.database;

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
import com.zhiyun.cama.data.database.AppDatabase;
import com.zhiyun.cama.data.database.AppDatabase_Impl$1;
import com.zhiyun.cama.data.database.dao.CEUpLoadCloudLogInfoDao;
import com.zhiyun.cama.data.database.dao.CEUpLoadCloudLogInfoDao_Impl;
import com.zhiyun.cama.data.database.dao.CameraDao;
import com.zhiyun.cama.data.database.dao.CameraDao_Impl;
import com.zhiyun.cama.data.database.dao.FeedbackDao;
import com.zhiyun.cama.data.database.dao.FeedbackDao_Impl;
import com.zhiyun.cama.data.database.dao.MessageDao;
import com.zhiyun.cama.data.database.dao.MessageDao_Impl;
import com.zhiyun.cama.data.database.dao.PrimeInfoDao;
import com.zhiyun.cama.data.database.dao.PrimeInfoDao_Impl;
import com.zhiyun.cama.data.database.dao.PublishLogDao;
import com.zhiyun.cama.data.database.dao.PublishLogDao_Impl;
import com.zhiyun.cama.data.database.dao.SplashAdDao;
import com.zhiyun.cama.data.database.dao.SplashAdDao_Impl;
import com.zhiyun.cama.data.database.dao.WorksDao;
import com.zhiyun.cama.data.database.dao.WorksDao_Impl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class AppDatabase_Impl
extends AppDatabase {
    private volatile CEUpLoadCloudLogInfoDao _cEUpLoadCloudLogInfoDao;
    private volatile CameraDao _cameraDao;
    private volatile FeedbackDao _feedbackDao;
    private volatile MessageDao _messageDao;
    private volatile PrimeInfoDao _primeInfoDao;
    private volatile PublishLogDao _publishLogDao;
    private volatile SplashAdDao _splashAdDao;
    private volatile WorksDao _worksDao;

    public static /* synthetic */ List access$000(AppDatabase_Impl appDatabase_Impl) {
        return appDatabase_Impl.mCallbacks;
    }

    public static /* synthetic */ List access$100(AppDatabase_Impl appDatabase_Impl) {
        return appDatabase_Impl.mCallbacks;
    }

    public static /* synthetic */ List access$1000(AppDatabase_Impl appDatabase_Impl) {
        return appDatabase_Impl.mCallbacks;
    }

    public static /* synthetic */ List access$200(AppDatabase_Impl appDatabase_Impl) {
        return appDatabase_Impl.mCallbacks;
    }

    public static /* synthetic */ List access$300(AppDatabase_Impl appDatabase_Impl) {
        return appDatabase_Impl.mCallbacks;
    }

    public static /* synthetic */ List access$400(AppDatabase_Impl appDatabase_Impl) {
        return appDatabase_Impl.mCallbacks;
    }

    public static /* synthetic */ List access$500(AppDatabase_Impl appDatabase_Impl) {
        return appDatabase_Impl.mCallbacks;
    }

    public static /* synthetic */ SupportSQLiteDatabase access$602(AppDatabase_Impl appDatabase_Impl, SupportSQLiteDatabase supportSQLiteDatabase) {
        appDatabase_Impl.mDatabase = supportSQLiteDatabase;
        return supportSQLiteDatabase;
    }

    public static /* synthetic */ void access$700(AppDatabase_Impl appDatabase_Impl, SupportSQLiteDatabase supportSQLiteDatabase) {
        appDatabase_Impl.internalInitInvalidationTracker(supportSQLiteDatabase);
    }

    public static /* synthetic */ List access$800(AppDatabase_Impl appDatabase_Impl) {
        return appDatabase_Impl.mCallbacks;
    }

    public static /* synthetic */ List access$900(AppDatabase_Impl appDatabase_Impl) {
        return appDatabase_Impl.mCallbacks;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public CameraDao cameraDao() {
        CameraDao cameraDao = this._cameraDao;
        if (cameraDao != null) {
            return this._cameraDao;
        }
        synchronized (this) {
            cameraDao = this._cameraDao;
            if (cameraDao != null) return this._cameraDao;
            this._cameraDao = cameraDao = new CameraDao_Impl(this);
            return this._cameraDao;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public CEUpLoadCloudLogInfoDao ceUpLoadCloudLogInfoDao() {
        CEUpLoadCloudLogInfoDao cEUpLoadCloudLogInfoDao = this._cEUpLoadCloudLogInfoDao;
        if (cEUpLoadCloudLogInfoDao != null) {
            return this._cEUpLoadCloudLogInfoDao;
        }
        synchronized (this) {
            cEUpLoadCloudLogInfoDao = this._cEUpLoadCloudLogInfoDao;
            if (cEUpLoadCloudLogInfoDao != null) return this._cEUpLoadCloudLogInfoDao;
            this._cEUpLoadCloudLogInfoDao = cEUpLoadCloudLogInfoDao = new CEUpLoadCloudLogInfoDao_Impl(this);
            return this._cEUpLoadCloudLogInfoDao;
        }
    }

    public void clearAllTables() {
        String string2 = "VACUUM";
        String string3 = "PRAGMA wal_checkpoint(FULL)";
        super.assertNotMainThread();
        SupportSQLiteDatabase supportSQLiteDatabase = super.getOpenHelper().getWritableDatabase();
        try {
            super.beginTransaction();
            String string4 = "DELETE FROM `CameraParam`";
            supportSQLiteDatabase.execSQL(string4);
            string4 = "DELETE FROM `Works`";
            supportSQLiteDatabase.execSQL(string4);
            string4 = "DELETE FROM `Likes`";
            supportSQLiteDatabase.execSQL(string4);
            string4 = "DELETE FROM `PublishWorks`";
            supportSQLiteDatabase.execSQL(string4);
            string4 = "DELETE FROM `PublishLog`";
            supportSQLiteDatabase.execSQL(string4);
            string4 = "DELETE FROM `MessageLike`";
            supportSQLiteDatabase.execSQL(string4);
            string4 = "DELETE FROM `MessageSystem`";
            supportSQLiteDatabase.execSQL(string4);
            string4 = "DELETE FROM `MessageViolation`";
            supportSQLiteDatabase.execSQL(string4);
            string4 = "DELETE FROM `MessageUnReadCount`";
            supportSQLiteDatabase.execSQL(string4);
            string4 = "DELETE FROM `PrimeInfo`";
            supportSQLiteDatabase.execSQL(string4);
            string4 = "DELETE FROM `CEUpLoadCloudLogInfo`";
            supportSQLiteDatabase.execSQL(string4);
            string4 = "DELETE FROM `SplashAd`";
            supportSQLiteDatabase.execSQL(string4);
            string4 = "DELETE FROM `SplashAdWatch`";
            supportSQLiteDatabase.execSQL(string4);
            string4 = "DELETE FROM `Feedback`";
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
        String[] stringArray = new String[]{"CameraParam", "Works", "Likes", "PublishWorks", "PublishLog", "MessageLike", "MessageSystem", "MessageViolation", "MessageUnReadCount", "PrimeInfo", "CEUpLoadCloudLogInfo", "SplashAd", "SplashAdWatch", "Feedback"};
        InvalidationTracker invalidationTracker = new InvalidationTracker((RoomDatabase)this, hashMap, hashMap2, stringArray);
        return invalidationTracker;
    }

    public SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration databaseConfiguration) {
        Object object = new AppDatabase_Impl$1(this, 13);
        Object object2 = new RoomOpenHelper(databaseConfiguration, (RoomOpenHelper$Delegate)object, "dc6bf63997517fb5ab45f619c0271294", "80bf5b77470f6771a103334b7da0a39b");
        object = SupportSQLiteOpenHelper$Configuration.builder(databaseConfiguration.context);
        String string2 = databaseConfiguration.name;
        object2 = ((SupportSQLiteOpenHelper$Configuration$Builder)object).name(string2).callback((SupportSQLiteOpenHelper$Callback)object2).build();
        return databaseConfiguration.sqliteOpenHelperFactory.create((SupportSQLiteOpenHelper$Configuration)object2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public FeedbackDao feedbackDao() {
        FeedbackDao feedbackDao = this._feedbackDao;
        if (feedbackDao != null) {
            return this._feedbackDao;
        }
        synchronized (this) {
            feedbackDao = this._feedbackDao;
            if (feedbackDao != null) return this._feedbackDao;
            this._feedbackDao = feedbackDao = new FeedbackDao_Impl(this);
            return this._feedbackDao;
        }
    }

    public Map getRequiredTypeConverters() {
        HashMap<Class, List> hashMap = new HashMap<Class, List>();
        List list = CameraDao_Impl.getRequiredConverters();
        hashMap.put(CameraDao.class, list);
        list = WorksDao_Impl.getRequiredConverters();
        hashMap.put(WorksDao.class, list);
        list = MessageDao_Impl.getRequiredConverters();
        hashMap.put(MessageDao.class, list);
        list = PublishLogDao_Impl.getRequiredConverters();
        hashMap.put(PublishLogDao.class, list);
        list = PrimeInfoDao_Impl.getRequiredConverters();
        hashMap.put(PrimeInfoDao.class, list);
        list = CEUpLoadCloudLogInfoDao_Impl.getRequiredConverters();
        hashMap.put(CEUpLoadCloudLogInfoDao.class, list);
        list = SplashAdDao_Impl.getRequiredConverters();
        hashMap.put(SplashAdDao.class, list);
        list = FeedbackDao_Impl.getRequiredConverters();
        hashMap.put(FeedbackDao.class, list);
        return hashMap;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public MessageDao messageDao() {
        MessageDao messageDao = this._messageDao;
        if (messageDao != null) {
            return this._messageDao;
        }
        synchronized (this) {
            messageDao = this._messageDao;
            if (messageDao != null) return this._messageDao;
            this._messageDao = messageDao = new MessageDao_Impl(this);
            return this._messageDao;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public PrimeInfoDao primeInfoDao() {
        PrimeInfoDao primeInfoDao = this._primeInfoDao;
        if (primeInfoDao != null) {
            return this._primeInfoDao;
        }
        synchronized (this) {
            primeInfoDao = this._primeInfoDao;
            if (primeInfoDao != null) return this._primeInfoDao;
            this._primeInfoDao = primeInfoDao = new PrimeInfoDao_Impl(this);
            return this._primeInfoDao;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public PublishLogDao publishLogDao() {
        PublishLogDao publishLogDao = this._publishLogDao;
        if (publishLogDao != null) {
            return this._publishLogDao;
        }
        synchronized (this) {
            publishLogDao = this._publishLogDao;
            if (publishLogDao != null) return this._publishLogDao;
            this._publishLogDao = publishLogDao = new PublishLogDao_Impl(this);
            return this._publishLogDao;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public SplashAdDao splashAdDao() {
        SplashAdDao splashAdDao = this._splashAdDao;
        if (splashAdDao != null) {
            return this._splashAdDao;
        }
        synchronized (this) {
            splashAdDao = this._splashAdDao;
            if (splashAdDao != null) return this._splashAdDao;
            this._splashAdDao = splashAdDao = new SplashAdDao_Impl(this);
            return this._splashAdDao;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public WorksDao worksDao() {
        WorksDao worksDao = this._worksDao;
        if (worksDao != null) {
            return this._worksDao;
        }
        synchronized (this) {
            worksDao = this._worksDao;
            if (worksDao != null) return this._worksDao;
            this._worksDao = worksDao = new WorksDao_Impl(this);
            return this._worksDao;
        }
    }
}

