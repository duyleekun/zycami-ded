/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.database.Cursor
 */
package com.zhiyun.cama.data.database.dao;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import com.zhiyun.cama.data.database.dao.PrimeInfoDao;
import com.zhiyun.cama.data.database.dao.PrimeInfoDao_Impl$1;
import com.zhiyun.cama.prime.model.PrimeInfo;
import java.util.Collections;
import java.util.List;

public final class PrimeInfoDao_Impl
implements PrimeInfoDao {
    private final RoomDatabase __db;
    private final EntityInsertionAdapter __insertionAdapterOfPrimeInfo;

    public PrimeInfoDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        PrimeInfoDao_Impl$1 primeInfoDao_Impl$1 = new PrimeInfoDao_Impl$1(this, roomDatabase);
        this.__insertionAdapterOfPrimeInfo = primeInfoDao_Impl$1;
    }

    public static List getRequiredConverters() {
        return Collections.emptyList();
    }

    public void insertPrimeInfoInfo(PrimeInfo ... object) {
        this.__db.assertNotSuspendingTransaction();
        Object object2 = this.__db;
        ((RoomDatabase)object2).beginTransaction();
        try {
            object2 = this.__insertionAdapterOfPrimeInfo;
            ((EntityInsertionAdapter)object2).insert((Object[])object);
            object = this.__db;
            ((RoomDatabase)object).setTransactionSuccessful();
            return;
        }
        finally {
            this.__db.endTransaction();
        }
    }

    public PrimeInfo loadPrimeInfoData(int n10) {
        Object object = this;
        boolean bl2 = true;
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire("SELECT * FROM PrimeInfo WHERE userId = ?", (int)(bl2 ? 1 : 0));
        int n11 = n10;
        long l10 = n10;
        roomSQLiteQuery.bindLong((int)(bl2 ? 1 : 0), l10);
        this.__db.assertNotSuspendingTransaction();
        Object object2 = this.__db;
        int n12 = 0;
        String string2 = null;
        int n13 = 0;
        Object object3 = null;
        Cursor cursor = DBUtil.query((RoomDatabase)object2, roomSQLiteQuery, false, null);
        object2 = "errcode";
        try {
            n11 = CursorUtil.getColumnIndexOrThrow(cursor, (String)object2);
            String string3 = "errmsg";
            int n14 = CursorUtil.getColumnIndexOrThrow(cursor, string3);
            String string4 = "id";
            int n15 = CursorUtil.getColumnIndexOrThrow(cursor, string4);
            String string5 = "userId";
            int n16 = CursorUtil.getColumnIndexOrThrow(cursor, string5);
            String string6 = "deviceId";
            int n17 = CursorUtil.getColumnIndexOrThrow(cursor, string6);
            String string7 = "periodTime";
            int n18 = CursorUtil.getColumnIndexOrThrow(cursor, string7);
            String string8 = "activeTime";
            int n19 = CursorUtil.getColumnIndexOrThrow(cursor, string8);
            String string9 = "startTime";
            int n20 = CursorUtil.getColumnIndexOrThrow(cursor, string9);
            String string10 = "endTime";
            int n21 = CursorUtil.getColumnIndexOrThrow(cursor, string10);
            String string11 = "hasRenew";
            int n22 = CursorUtil.getColumnIndexOrThrow(cursor, string11);
            String string12 = "status";
            bl2 = CursorUtil.getColumnIndexOrThrow(cursor, string12);
            string2 = "getWay";
            n12 = CursorUtil.getColumnIndexOrThrow(cursor, string2);
            object3 = "createAt";
            n13 = CursorUtil.getColumnIndexOrThrow(cursor, (String)object3);
            object = "updateAt";
            int n23 = CursorUtil.getColumnIndexOrThrow(cursor, (String)object);
            return n23;
        }
        finally {
            RoomSQLiteQuery roomSQLiteQuery2 = roomSQLiteQuery;
        }
    }
}

