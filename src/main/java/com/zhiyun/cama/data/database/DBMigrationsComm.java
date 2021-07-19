/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.database;

import androidx.room.migration.Migration;
import com.zhiyun.cama.data.database.DBMigrationsComm$1;
import com.zhiyun.cama.data.database.DBMigrationsComm$2;
import com.zhiyun.cama.data.database.DBMigrationsComm$3;
import com.zhiyun.cama.data.database.DBMigrationsComm$4;
import com.zhiyun.cama.data.database.DBMigrationsComm$5;
import com.zhiyun.cama.data.database.DBMigrationsComm$6;

public class DBMigrationsComm {
    public static final Migration[] MIGRATION;
    public static final Migration MIGRATION_1_2;
    public static final Migration MIGRATION_2_3;
    public static final Migration MIGRATION_3_4;
    public static final Migration MIGRATION_4_5;
    public static final Migration MIGRATION_5_6;
    public static final Migration MIGRATION_6_7;

    static {
        int n10 = 1;
        int n11 = 2;
        DBMigrationsComm$1 dBMigrationsComm$1 = new DBMigrationsComm$1(n10, n11);
        MIGRATION_1_2 = dBMigrationsComm$1;
        int n12 = 3;
        DBMigrationsComm$2 dBMigrationsComm$2 = new DBMigrationsComm$2(n11, n12);
        MIGRATION_2_3 = dBMigrationsComm$2;
        int n13 = 4;
        DBMigrationsComm$3 dBMigrationsComm$3 = new DBMigrationsComm$3(n12, n13);
        MIGRATION_3_4 = dBMigrationsComm$3;
        int n14 = 5;
        DBMigrationsComm$4 dBMigrationsComm$4 = new DBMigrationsComm$4(n13, n14);
        MIGRATION_4_5 = dBMigrationsComm$4;
        int n15 = 6;
        DBMigrationsComm$5 dBMigrationsComm$5 = new DBMigrationsComm$5(n14, n15);
        MIGRATION_5_6 = dBMigrationsComm$5;
        DBMigrationsComm$6 dBMigrationsComm$6 = new DBMigrationsComm$6(n15, 7);
        MIGRATION_6_7 = dBMigrationsComm$6;
        Migration[] migrationArray = new Migration[n15];
        migrationArray[0] = dBMigrationsComm$1;
        migrationArray[n10] = dBMigrationsComm$2;
        migrationArray[n11] = dBMigrationsComm$3;
        migrationArray[n12] = dBMigrationsComm$4;
        migrationArray[n13] = dBMigrationsComm$5;
        migrationArray[n14] = dBMigrationsComm$6;
        MIGRATION = migrationArray;
    }
}

