/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.database.Cursor
 */
package com.zhiyun.cama.data.database.dao;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import com.zhiyun.cama.data.database.dao.CEUpLoadCloudLogInfoDao;
import com.zhiyun.cama.data.database.dao.CEUpLoadCloudLogInfoDao_Impl$1;
import d.v.c.t0.h0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class CEUpLoadCloudLogInfoDao_Impl
implements CEUpLoadCloudLogInfoDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter __deletionAdapterOfCEUpLoadCloudLogInfo;
    private final EntityInsertionAdapter __insertionAdapterOfCEUpLoadCloudLogInfo;

    public CEUpLoadCloudLogInfoDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        SharedSQLiteStatement sharedSQLiteStatement = new CEUpLoadCloudLogInfoDao_Impl$1(this, roomDatabase);
        this.__insertionAdapterOfCEUpLoadCloudLogInfo = sharedSQLiteStatement;
        super(this, roomDatabase);
        this.__deletionAdapterOfCEUpLoadCloudLogInfo = sharedSQLiteStatement;
    }

    public static List getRequiredConverters() {
        return Collections.emptyList();
    }

    public void deleteCEUpLoadCloudLogInfo(h0 ... object) {
        this.__db.assertNotSuspendingTransaction();
        Object object2 = this.__db;
        ((RoomDatabase)object2).beginTransaction();
        try {
            object2 = this.__deletionAdapterOfCEUpLoadCloudLogInfo;
            ((EntityDeletionOrUpdateAdapter)object2).handleMultiple((Object[])object);
            object = this.__db;
            ((RoomDatabase)object).setTransactionSuccessful();
            return;
        }
        finally {
            this.__db.endTransaction();
        }
    }

    public void insertCEUpLoadCloudLogInfo(h0 ... object) {
        this.__db.assertNotSuspendingTransaction();
        Object object2 = this.__db;
        ((RoomDatabase)object2).beginTransaction();
        try {
            object2 = this.__insertionAdapterOfCEUpLoadCloudLogInfo;
            ((EntityInsertionAdapter)object2).insert((Object[])object);
            object = this.__db;
            ((RoomDatabase)object).setTransactionSuccessful();
            return;
        }
        finally {
            this.__db.endTransaction();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public List loadCEUpLoadCloudLogInfoData() {
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire("SELECT `CEUpLoadCloudLogInfo`.`startedAt` AS `startedAt`, `CEUpLoadCloudLogInfo`.`version` AS `version`, `CEUpLoadCloudLogInfo`.`longitude` AS `longitude`, `CEUpLoadCloudLogInfo`.`latitude` AS `latitude`, `CEUpLoadCloudLogInfo`.`url` AS `url`, `CEUpLoadCloudLogInfo`.`status` AS `status`, `CEUpLoadCloudLogInfo`.`duration` AS `duration`, `CEUpLoadCloudLogInfo`.`operation` AS `operation` FROM CEUpLoadCloudLogInfo", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursor = DBUtil.query(this.__db, roomSQLiteQuery, false, null);
        String string2 = "startedAt";
        try {
            int n10 = CursorUtil.getColumnIndexOrThrow(cursor, string2);
            String string3 = "version";
            int n11 = CursorUtil.getColumnIndexOrThrow(cursor, string3);
            String string4 = "longitude";
            int n12 = CursorUtil.getColumnIndexOrThrow(cursor, string4);
            String string5 = "latitude";
            int n13 = CursorUtil.getColumnIndexOrThrow(cursor, string5);
            String string6 = "url";
            int n14 = CursorUtil.getColumnIndexOrThrow(cursor, string6);
            String string7 = "status";
            int n15 = CursorUtil.getColumnIndexOrThrow(cursor, string7);
            String string8 = "duration";
            int n16 = CursorUtil.getColumnIndexOrThrow(cursor, string8);
            String string9 = "operation";
            int n17 = CursorUtil.getColumnIndexOrThrow(cursor, string9);
            int n18 = cursor.getCount();
            ArrayList<h0> arrayList = new ArrayList<h0>(n18);
            while ((n18 = (int)(cursor.moveToNext() ? 1 : 0)) != 0) {
                String string10;
                h0 h02 = new h0();
                int n19 = cursor.isNull(n10);
                if (n19 != 0) {
                    n19 = 0;
                    string10 = null;
                } else {
                    string10 = cursor.getString(n10);
                }
                h02.m(string10);
                n19 = cursor.isNull(n11);
                if (n19 != 0) {
                    n19 = 0;
                    string10 = null;
                } else {
                    string10 = cursor.getString(n11);
                }
                h02.p(string10);
                n19 = cursor.isNull(n12);
                if (n19 != 0) {
                    n19 = 0;
                    string10 = null;
                } else {
                    string10 = cursor.getString(n12);
                }
                h02.k(string10);
                n19 = cursor.isNull(n13);
                if (n19 != 0) {
                    n19 = 0;
                    string10 = null;
                } else {
                    string10 = cursor.getString(n13);
                }
                h02.j(string10);
                n19 = cursor.isNull(n14);
                if (n19 != 0) {
                    n19 = 0;
                    string10 = null;
                } else {
                    string10 = cursor.getString(n14);
                }
                h02.o(string10);
                n19 = cursor.getInt(n15);
                h02.n(n19);
                n19 = cursor.getInt(n16);
                h02.i(n19);
                n19 = cursor.getInt(n17);
                h02.l(n19);
                arrayList.add(h02);
            }
            return arrayList;
        }
        finally {
            cursor.close();
            roomSQLiteQuery.release();
        }
    }
}

