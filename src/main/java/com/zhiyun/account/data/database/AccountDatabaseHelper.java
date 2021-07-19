/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.zhiyun.account.data.database;

import android.content.Context;
import androidx.room.Room;
import com.zhiyun.account.data.database.AccountDatabase;
import d.v.e.f;

public class AccountDatabaseHelper {
    private static final String DB_COMMUNITY_NAME = "account.db";
    private static volatile AccountDatabaseHelper instance;
    private AccountDatabase mAccountDatabaseComm;

    private AccountDatabaseHelper() {
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static AccountDatabaseHelper getInstance() {
        Object object = instance;
        if (object != null) return instance;
        object = AccountDatabaseHelper.class;
        synchronized (object) {
            AccountDatabaseHelper accountDatabaseHelper = instance;
            if (accountDatabaseHelper != null) return instance;
            instance = accountDatabaseHelper = new AccountDatabaseHelper();
            return instance;
        }
    }

    public void close() {
        AccountDatabase accountDatabase = this.mAccountDatabaseComm;
        if (accountDatabase != null) {
            accountDatabase.close();
        }
    }

    public AccountDatabase getDataBase() {
        AccountDatabase accountDatabase = this.mAccountDatabaseComm;
        if (accountDatabase == null) {
            accountDatabase = f.a().c();
            Class<AccountDatabase> clazz = AccountDatabase.class;
            String string2 = DB_COMMUNITY_NAME;
            this.mAccountDatabaseComm = accountDatabase = (AccountDatabase)Room.databaseBuilder((Context)accountDatabase, clazz, string2).allowMainThreadQueries().build();
        }
        return this.mAccountDatabaseComm;
    }
}

