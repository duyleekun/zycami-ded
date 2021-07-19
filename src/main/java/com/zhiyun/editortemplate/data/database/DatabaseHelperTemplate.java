/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.zhiyun.editortemplate.data.database;

import android.content.Context;
import androidx.room.Room;
import androidx.room.RoomDatabase$Builder;
import androidx.room.migration.Migration;
import com.zhiyun.editortemplate.data.database.AppDatabaseTemplate;
import com.zhiyun.editortemplate.data.database.DBMigrationsTemplate;
import d.v.e.f;
import java.io.File;
import m.a.a;

public class DatabaseHelperTemplate {
    public static final String DB_TEMPLATE_NAME = "template.db";
    private static volatile DatabaseHelperTemplate instance;
    private AppDatabaseTemplate mAppDatabaseTemplate;

    private DatabaseHelperTemplate() {
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static DatabaseHelperTemplate getInstance() {
        Object object = instance;
        if (object != null) return instance;
        object = DatabaseHelperTemplate.class;
        synchronized (object) {
            DatabaseHelperTemplate databaseHelperTemplate = instance;
            if (databaseHelperTemplate != null) return instance;
            instance = databaseHelperTemplate = new DatabaseHelperTemplate();
            return instance;
        }
    }

    public AppDatabaseTemplate getDataBase() {
        Object object = this.mAppDatabaseTemplate;
        if (object == null) {
            object = f.a().b();
            Migration[] migrationArray = object.getDatabasePath("editor.db");
            Object object2 = new Object[1];
            boolean bl2 = migrationArray.exists();
            Boolean bl3 = bl2;
            object2[0] = bl3;
            a.i("\u6570\u636e\u5e93\u6587\u4ef6editor.db\u662f\u5426\u5b58\u5728 %s", object2);
            object2 = AppDatabaseTemplate.class;
            String string2 = DB_TEMPLATE_NAME;
            object = Room.databaseBuilder((Context)object, (Class)object2, string2);
            boolean bl4 = migrationArray.exists();
            if (bl4) {
                ((RoomDatabase$Builder)object).createFromFile((File)migrationArray);
            }
            migrationArray = DBMigrationsTemplate.MIGRATION;
            this.mAppDatabaseTemplate = object = (AppDatabaseTemplate)((RoomDatabase$Builder)object).addMigrations(migrationArray).allowMainThreadQueries().build();
        }
        return this.mAppDatabaseTemplate;
    }
}

