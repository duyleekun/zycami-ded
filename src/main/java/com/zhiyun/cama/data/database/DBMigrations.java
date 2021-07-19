/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.database;

import androidx.room.migration.Migration;
import com.zhiyun.cama.data.database.DBMigrations$1;
import com.zhiyun.cama.data.database.DBMigrations$10;
import com.zhiyun.cama.data.database.DBMigrations$11;
import com.zhiyun.cama.data.database.DBMigrations$12;
import com.zhiyun.cama.data.database.DBMigrations$2;
import com.zhiyun.cama.data.database.DBMigrations$3;
import com.zhiyun.cama.data.database.DBMigrations$4;
import com.zhiyun.cama.data.database.DBMigrations$5;
import com.zhiyun.cama.data.database.DBMigrations$6;
import com.zhiyun.cama.data.database.DBMigrations$7;
import com.zhiyun.cama.data.database.DBMigrations$8;
import com.zhiyun.cama.data.database.DBMigrations$9;

public class DBMigrations {
    public static final Migration[] MIGRATION;
    public static final Migration MIGRATION_10_11;
    public static final Migration MIGRATION_11_12;
    public static final Migration MIGRATION_12_13;
    public static final Migration MIGRATION_1_2;
    public static final Migration MIGRATION_2_3;
    public static final Migration MIGRATION_3_4;
    public static final Migration MIGRATION_4_5;
    public static final Migration MIGRATION_5_6;
    public static final Migration MIGRATION_6_7;
    public static final Migration MIGRATION_7_8;
    public static final Migration MIGRATION_8_9;
    public static final Migration MIGRATION_9_10;

    static {
        int n10 = 1;
        int n11 = 2;
        DBMigrations$1 dBMigrations$1 = new DBMigrations$1(n10, n11);
        MIGRATION_1_2 = dBMigrations$1;
        int n12 = 3;
        DBMigrations$2 dBMigrations$2 = new DBMigrations$2(n11, n12);
        MIGRATION_2_3 = dBMigrations$2;
        int n13 = 4;
        DBMigrations$3 dBMigrations$3 = new DBMigrations$3(n12, n13);
        MIGRATION_3_4 = dBMigrations$3;
        int n14 = 5;
        DBMigrations$4 dBMigrations$4 = new DBMigrations$4(n13, n14);
        MIGRATION_4_5 = dBMigrations$4;
        int n15 = 6;
        DBMigrations$5 dBMigrations$5 = new DBMigrations$5(n14, n15);
        MIGRATION_5_6 = dBMigrations$5;
        int n16 = 7;
        DBMigrations$6 dBMigrations$6 = new DBMigrations$6(n15, n16);
        MIGRATION_6_7 = dBMigrations$6;
        int n17 = 8;
        DBMigrations$7 dBMigrations$7 = new DBMigrations$7(n16, n17);
        MIGRATION_7_8 = dBMigrations$7;
        n16 = 9;
        DBMigrations$8 dBMigrations$8 = new DBMigrations$8(n17, n16);
        MIGRATION_8_9 = dBMigrations$8;
        n15 = 10;
        DBMigrations$9 dBMigrations$9 = new DBMigrations$9(n16, n15);
        MIGRATION_9_10 = dBMigrations$9;
        n14 = 11;
        DBMigrations$10 dBMigrations$10 = new DBMigrations$10(n15, n14);
        MIGRATION_10_11 = dBMigrations$10;
        n13 = 12;
        DBMigrations$11 dBMigrations$11 = new DBMigrations$11(n14, n13);
        MIGRATION_11_12 = dBMigrations$11;
        DBMigrations$12 dBMigrations$12 = new DBMigrations$12(n13, 13);
        MIGRATION_12_13 = dBMigrations$12;
        Migration[] migrationArray = new Migration[n13];
        migrationArray[0] = dBMigrations$1;
        migrationArray[n10] = dBMigrations$2;
        migrationArray[n11] = dBMigrations$3;
        migrationArray[3] = dBMigrations$4;
        migrationArray[4] = dBMigrations$5;
        migrationArray[5] = dBMigrations$6;
        migrationArray[6] = dBMigrations$7;
        migrationArray[7] = dBMigrations$8;
        migrationArray[8] = dBMigrations$9;
        migrationArray[9] = dBMigrations$10;
        migrationArray[10] = dBMigrations$11;
        migrationArray[11] = dBMigrations$12;
        MIGRATION = migrationArray;
    }
}

