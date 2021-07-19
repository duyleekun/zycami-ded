/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.editortemplate.data.database;

import androidx.room.migration.Migration;
import com.zhiyun.editortemplate.data.database.DBMigrationsTemplate$1;
import com.zhiyun.editortemplate.data.database.DBMigrationsTemplate$2;
import com.zhiyun.editortemplate.data.database.DBMigrationsTemplate$3;
import com.zhiyun.editortemplate.data.database.DBMigrationsTemplate$4;
import com.zhiyun.editortemplate.data.database.DBMigrationsTemplate$5;

public class DBMigrationsTemplate {
    public static final Migration[] MIGRATION;
    public static final Migration MIGRATION_1_2;
    public static final Migration MIGRATION_2_3;
    public static final Migration MIGRATION_3_4;
    public static final Migration MIGRATION_4_5;
    public static final Migration MIGRATION_5_6;

    static {
        int n10 = 1;
        int n11 = 2;
        DBMigrationsTemplate$1 dBMigrationsTemplate$1 = new DBMigrationsTemplate$1(n10, n11);
        MIGRATION_1_2 = dBMigrationsTemplate$1;
        int n12 = 3;
        DBMigrationsTemplate$2 dBMigrationsTemplate$2 = new DBMigrationsTemplate$2(n11, n12);
        MIGRATION_2_3 = dBMigrationsTemplate$2;
        int n13 = 4;
        DBMigrationsTemplate$3 dBMigrationsTemplate$3 = new DBMigrationsTemplate$3(n12, n13);
        MIGRATION_3_4 = dBMigrationsTemplate$3;
        int n14 = 5;
        DBMigrationsTemplate$4 dBMigrationsTemplate$4 = new DBMigrationsTemplate$4(n13, n14);
        MIGRATION_4_5 = dBMigrationsTemplate$4;
        DBMigrationsTemplate$5 dBMigrationsTemplate$5 = new DBMigrationsTemplate$5(n14, 6);
        MIGRATION_5_6 = dBMigrationsTemplate$5;
        Migration[] migrationArray = new Migration[n14];
        migrationArray[0] = dBMigrationsTemplate$1;
        migrationArray[n10] = dBMigrationsTemplate$2;
        migrationArray[n11] = dBMigrationsTemplate$3;
        migrationArray[n12] = dBMigrationsTemplate$4;
        migrationArray[n13] = dBMigrationsTemplate$5;
        MIGRATION = migrationArray;
    }
}

