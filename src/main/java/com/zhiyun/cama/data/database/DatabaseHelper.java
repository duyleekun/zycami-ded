/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.database.sqlite.SQLiteDatabase
 */
package com.zhiyun.cama.data.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import androidx.room.Room;
import androidx.room.RoomDatabase$Builder;
import androidx.room.migration.Migration;
import com.zhiyun.cama.data.database.AppDatabase;
import com.zhiyun.cama.data.database.DBMigrations;
import d.v.e.f;
import java.io.File;
import m.a.a;

public class DatabaseHelper {
    private static final String DB_COMMUNITY_NAME = "new_zycama.db";
    private static volatile DatabaseHelper instance;
    private AppDatabase mAppDatabaseComm;

    private DatabaseHelper() {
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static DatabaseHelper getInstance() {
        Object object = instance;
        if (object != null) return instance;
        object = DatabaseHelper.class;
        synchronized (object) {
            DatabaseHelper databaseHelper = instance;
            if (databaseHelper != null) return instance;
            instance = databaseHelper = new DatabaseHelper();
            return instance;
        }
    }

    public void close() {
        AppDatabase appDatabase = this.mAppDatabaseComm;
        if (appDatabase != null) {
            appDatabase.close();
        }
    }

    public AppDatabase getDataBase() {
        Object object = this.mAppDatabaseComm;
        if (object == null) {
            Object object2;
            object = f.a().c();
            Migration[] migrationArray = object.getDatabasePath("zycama.db");
            int n10 = 1;
            Object object3 = new Object[n10];
            boolean bl2 = migrationArray.exists();
            object3[0] = object2 = Boolean.valueOf(bl2);
            a.i("zycama.db\u662f\u5426\u5b58\u5728 %s", (Object[])object3);
            object3 = AppDatabase.class;
            object2 = DB_COMMUNITY_NAME;
            object = Room.databaseBuilder((Context)object, (Class)object3, (String)object2);
            int n11 = migrationArray.exists();
            if (n11 != 0) {
                object3 = migrationArray.getAbsolutePath();
                bl2 = false;
                object2 = null;
                object3 = SQLiteDatabase.openDatabase((String)object3, null, (int)0);
                Object[] objectArray = new Object[n10];
                n11 = object3.getVersion();
                object3 = n11;
                objectArray[0] = object3;
                object3 = "zycama.db----version = %s";
                a.b((String)object3, objectArray);
                ((RoomDatabase$Builder)object).createFromFile((File)migrationArray);
            }
            migrationArray = DBMigrations.MIGRATION;
            this.mAppDatabaseComm = object = (AppDatabase)((RoomDatabase$Builder)object).addMigrations(migrationArray).allowMainThreadQueries().build();
        }
        return this.mAppDatabaseComm;
    }
}

