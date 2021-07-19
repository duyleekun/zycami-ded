/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.device.data.local;

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
import com.zhiyun.device.data.local.DeviceDatabaseComm;
import com.zhiyun.device.data.local.DeviceDatabaseComm_Impl$a;
import d.v.g.f.b.d.a;
import d.v.g.f.b.d.b;
import d.v.g.f.b.d.c;
import d.v.g.f.b.d.d;
import d.v.g.f.b.d.e;
import d.v.g.f.b.d.f;
import d.v.g.f.b.d.g;
import d.v.g.f.b.d.h;
import java.util.HashMap;
import java.util.List;

public final class DeviceDatabaseComm_Impl
extends DeviceDatabaseComm {
    private volatile a a;
    private volatile e b;
    private volatile c c;
    private volatile g d;

    public static /* synthetic */ List i(DeviceDatabaseComm_Impl deviceDatabaseComm_Impl) {
        return deviceDatabaseComm_Impl.mCallbacks;
    }

    public static /* synthetic */ List j(DeviceDatabaseComm_Impl deviceDatabaseComm_Impl) {
        return deviceDatabaseComm_Impl.mCallbacks;
    }

    public static /* synthetic */ List k(DeviceDatabaseComm_Impl deviceDatabaseComm_Impl) {
        return deviceDatabaseComm_Impl.mCallbacks;
    }

    public static /* synthetic */ List l(DeviceDatabaseComm_Impl deviceDatabaseComm_Impl) {
        return deviceDatabaseComm_Impl.mCallbacks;
    }

    public static /* synthetic */ List m(DeviceDatabaseComm_Impl deviceDatabaseComm_Impl) {
        return deviceDatabaseComm_Impl.mCallbacks;
    }

    public static /* synthetic */ List n(DeviceDatabaseComm_Impl deviceDatabaseComm_Impl) {
        return deviceDatabaseComm_Impl.mCallbacks;
    }

    public static /* synthetic */ List o(DeviceDatabaseComm_Impl deviceDatabaseComm_Impl) {
        return deviceDatabaseComm_Impl.mCallbacks;
    }

    public static /* synthetic */ SupportSQLiteDatabase p(DeviceDatabaseComm_Impl deviceDatabaseComm_Impl, SupportSQLiteDatabase supportSQLiteDatabase) {
        deviceDatabaseComm_Impl.mDatabase = supportSQLiteDatabase;
        return supportSQLiteDatabase;
    }

    public static /* synthetic */ void q(DeviceDatabaseComm_Impl deviceDatabaseComm_Impl, SupportSQLiteDatabase supportSQLiteDatabase) {
        deviceDatabaseComm_Impl.internalInitInvalidationTracker(supportSQLiteDatabase);
    }

    public static /* synthetic */ List r(DeviceDatabaseComm_Impl deviceDatabaseComm_Impl) {
        return deviceDatabaseComm_Impl.mCallbacks;
    }

    public static /* synthetic */ List s(DeviceDatabaseComm_Impl deviceDatabaseComm_Impl) {
        return deviceDatabaseComm_Impl.mCallbacks;
    }

    public void clearAllTables() {
        String string2 = "VACUUM";
        String string3 = "PRAGMA wal_checkpoint(FULL)";
        super.assertNotMainThread();
        SupportSQLiteDatabase supportSQLiteDatabase = super.getOpenHelper().getWritableDatabase();
        try {
            super.beginTransaction();
            String string4 = "DELETE FROM `device_info`";
            supportSQLiteDatabase.execSQL(string4);
            string4 = "DELETE FROM `firmware_info`";
            supportSQLiteDatabase.execSQL(string4);
            string4 = "DELETE FROM `AppDeviceInfo`";
            supportSQLiteDatabase.execSQL(string4);
            string4 = "DELETE FROM `activation_data`";
            supportSQLiteDatabase.execSQL(string4);
            string4 = "DELETE FROM `regional_restrictions_info`";
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
        String[] stringArray = new String[]{"device_info", "firmware_info", "AppDeviceInfo", "activation_data", "regional_restrictions_info"};
        InvalidationTracker invalidationTracker = new InvalidationTracker((RoomDatabase)this, hashMap, hashMap2, stringArray);
        return invalidationTracker;
    }

    public SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration databaseConfiguration) {
        Object object = new DeviceDatabaseComm_Impl$a(this, 11);
        Object object2 = new RoomOpenHelper(databaseConfiguration, (RoomOpenHelper$Delegate)object, "3d81cc47a12703bb14caf26c16d91573", "14faa3c57266ea508ae3a2eae6c25820");
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
    public a e() {
        a a10 = this.a;
        if (a10 != null) {
            return this.a;
        }
        synchronized (this) {
            a10 = this.a;
            if (a10 != null) return this.a;
            this.a = a10 = new b(this);
            return this.a;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public c f() {
        c c10 = this.c;
        if (c10 != null) {
            return this.c;
        }
        synchronized (this) {
            c10 = this.c;
            if (c10 != null) return this.c;
            this.c = c10 = new d(this);
            return this.c;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public e g() {
        e e10 = this.b;
        if (e10 != null) {
            return this.b;
        }
        synchronized (this) {
            e10 = this.b;
            if (e10 != null) return this.b;
            this.b = e10 = new f(this);
            return this.b;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public g h() {
        g g10 = this.d;
        if (g10 != null) {
            return this.d;
        }
        synchronized (this) {
            g10 = this.d;
            if (g10 != null) return this.d;
            this.d = g10 = new h(this);
            return this.d;
        }
    }
}

