/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.zhiyun.cama.data.database;

import android.content.Context;
import androidx.room.Room;
import androidx.room.RoomDatabase$Builder;
import androidx.room.migration.Migration;
import com.zhiyun.cama.data.database.AppDatabaseComm;
import com.zhiyun.cama.data.database.DBMigrationsComm;
import d.v.e.f;
import java.io.File;
import m.a.a;

public class DatabaseCommHelper {
    private static final String DB_EDITOR_NAME = "new_editor.db";
    private static volatile DatabaseCommHelper instance;
    private AppDatabaseComm mAppDatabaseComm;

    private DatabaseCommHelper() {
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static DatabaseCommHelper getInstance() {
        Object object = instance;
        if (object != null) return instance;
        object = DatabaseCommHelper.class;
        synchronized (object) {
            DatabaseCommHelper databaseCommHelper = instance;
            if (databaseCommHelper != null) return instance;
            instance = databaseCommHelper = new DatabaseCommHelper();
            return instance;
        }
    }

    public AppDatabaseComm getDataBase() {
        Object object = this.mAppDatabaseComm;
        if (object == null) {
            object = f.a().b();
            Migration[] migrationArray = object.getDatabasePath("editor.db");
            Object object2 = new Object[1];
            boolean bl2 = migrationArray.exists();
            Boolean bl3 = bl2;
            object2[0] = bl3;
            a.i("\u6570\u636e\u5e93\u6587\u4ef6editor.db\u662f\u5426\u5b58\u5728 %s", object2);
            object2 = AppDatabaseComm.class;
            String string2 = DB_EDITOR_NAME;
            object = Room.databaseBuilder((Context)object, (Class)object2, string2);
            boolean bl4 = migrationArray.exists();
            if (bl4) {
                ((RoomDatabase$Builder)object).createFromFile((File)migrationArray);
            }
            migrationArray = DBMigrationsComm.MIGRATION;
            this.mAppDatabaseComm = object = (AppDatabaseComm)((RoomDatabase$Builder)object).addMigrations(migrationArray).allowMainThreadQueries().build();
        }
        return this.mAppDatabaseComm;
    }
}

