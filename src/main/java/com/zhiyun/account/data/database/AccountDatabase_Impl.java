/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.account.data.database;

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
import com.zhiyun.account.data.database.AccountDatabase;
import com.zhiyun.account.data.database.AccountDatabase_Impl$1;
import com.zhiyun.account.data.database.dao.UserInfoDao;
import com.zhiyun.account.data.database.dao.UserInfoDao_Impl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class AccountDatabase_Impl
extends AccountDatabase {
    private volatile UserInfoDao _userInfoDao;

    public static /* synthetic */ List access$000(AccountDatabase_Impl accountDatabase_Impl) {
        return accountDatabase_Impl.mCallbacks;
    }

    public static /* synthetic */ List access$100(AccountDatabase_Impl accountDatabase_Impl) {
        return accountDatabase_Impl.mCallbacks;
    }

    public static /* synthetic */ List access$1000(AccountDatabase_Impl accountDatabase_Impl) {
        return accountDatabase_Impl.mCallbacks;
    }

    public static /* synthetic */ List access$200(AccountDatabase_Impl accountDatabase_Impl) {
        return accountDatabase_Impl.mCallbacks;
    }

    public static /* synthetic */ List access$300(AccountDatabase_Impl accountDatabase_Impl) {
        return accountDatabase_Impl.mCallbacks;
    }

    public static /* synthetic */ List access$400(AccountDatabase_Impl accountDatabase_Impl) {
        return accountDatabase_Impl.mCallbacks;
    }

    public static /* synthetic */ List access$500(AccountDatabase_Impl accountDatabase_Impl) {
        return accountDatabase_Impl.mCallbacks;
    }

    public static /* synthetic */ SupportSQLiteDatabase access$602(AccountDatabase_Impl accountDatabase_Impl, SupportSQLiteDatabase supportSQLiteDatabase) {
        accountDatabase_Impl.mDatabase = supportSQLiteDatabase;
        return supportSQLiteDatabase;
    }

    public static /* synthetic */ void access$700(AccountDatabase_Impl accountDatabase_Impl, SupportSQLiteDatabase supportSQLiteDatabase) {
        accountDatabase_Impl.internalInitInvalidationTracker(supportSQLiteDatabase);
    }

    public static /* synthetic */ List access$800(AccountDatabase_Impl accountDatabase_Impl) {
        return accountDatabase_Impl.mCallbacks;
    }

    public static /* synthetic */ List access$900(AccountDatabase_Impl accountDatabase_Impl) {
        return accountDatabase_Impl.mCallbacks;
    }

    public void clearAllTables() {
        String string2 = "VACUUM";
        String string3 = "PRAGMA wal_checkpoint(FULL)";
        super.assertNotMainThread();
        SupportSQLiteDatabase supportSQLiteDatabase = super.getOpenHelper().getWritableDatabase();
        try {
            super.beginTransaction();
            String string4 = "DELETE FROM `UserInfo`";
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
        String[] stringArray = new String[]{"UserInfo"};
        InvalidationTracker invalidationTracker = new InvalidationTracker((RoomDatabase)this, hashMap, hashMap2, stringArray);
        return invalidationTracker;
    }

    public SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration databaseConfiguration) {
        Object object = new AccountDatabase_Impl$1(this, 1);
        Object object2 = new RoomOpenHelper(databaseConfiguration, (RoomOpenHelper$Delegate)object, "ec6dec70e235d74b541838d16b001381", "945a2f5db9533b9f2b2504750f867e86");
        object = SupportSQLiteOpenHelper$Configuration.builder(databaseConfiguration.context);
        String string2 = databaseConfiguration.name;
        object2 = ((SupportSQLiteOpenHelper$Configuration$Builder)object).name(string2).callback((SupportSQLiteOpenHelper$Callback)object2).build();
        return databaseConfiguration.sqliteOpenHelperFactory.create((SupportSQLiteOpenHelper$Configuration)object2);
    }

    public Map getRequiredTypeConverters() {
        HashMap<Class<UserInfoDao>, List> hashMap = new HashMap<Class<UserInfoDao>, List>();
        List list = UserInfoDao_Impl.getRequiredConverters();
        hashMap.put(UserInfoDao.class, list);
        return hashMap;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public UserInfoDao userInfoDao() {
        UserInfoDao userInfoDao = this._userInfoDao;
        if (userInfoDao != null) {
            return this._userInfoDao;
        }
        synchronized (this) {
            userInfoDao = this._userInfoDao;
            if (userInfoDao != null) return this._userInfoDao;
            this._userInfoDao = userInfoDao = new UserInfoDao_Impl(this);
            return this._userInfoDao;
        }
    }
}

