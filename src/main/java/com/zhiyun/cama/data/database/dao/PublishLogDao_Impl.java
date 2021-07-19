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
import com.zhiyun.cama.data.database.dao.PublishLogDao;
import com.zhiyun.cama.data.database.dao.PublishLogDao_Impl$1;
import com.zhiyun.cama.data.database.model.PublishLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class PublishLogDao_Impl
implements PublishLogDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter __deletionAdapterOfPublishLog;
    private final EntityInsertionAdapter __insertionAdapterOfPublishLog;

    public PublishLogDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        SharedSQLiteStatement sharedSQLiteStatement = new PublishLogDao_Impl$1(this, roomDatabase);
        this.__insertionAdapterOfPublishLog = sharedSQLiteStatement;
        super(this, roomDatabase);
        this.__deletionAdapterOfPublishLog = sharedSQLiteStatement;
    }

    public static List getRequiredConverters() {
        return Collections.emptyList();
    }

    public void deletePublishLog(List object) {
        this.__db.assertNotSuspendingTransaction();
        Object object2 = this.__db;
        ((RoomDatabase)object2).beginTransaction();
        try {
            object2 = this.__deletionAdapterOfPublishLog;
            ((EntityDeletionOrUpdateAdapter)object2).handleMultiple((Iterable)object);
            object = this.__db;
            ((RoomDatabase)object).setTransactionSuccessful();
            return;
        }
        finally {
            this.__db.endTransaction();
        }
    }

    public void insert(PublishLog ... object) {
        this.__db.assertNotSuspendingTransaction();
        Object object2 = this.__db;
        ((RoomDatabase)object2).beginTransaction();
        try {
            object2 = this.__insertionAdapterOfPublishLog;
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
    public List loadPublishLog() {
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire("SELECT `PublishLog`.`id` AS `id`, `PublishLog`.`userId` AS `userId`, `PublishLog`.`postId` AS `postId`, `PublishLog`.`phoneid` AS `phoneid`, `PublishLog`.`reason` AS `reason`, `PublishLog`.`reasonCode` AS `reasonCode`, `PublishLog`.`sourceUrl1` AS `sourceUrl1`, `PublishLog`.`sourceUrl2` AS `sourceUrl2`, `PublishLog`.`failAt` AS `failAt`, `PublishLog`.`version` AS `version` FROM PublishLog ORDER BY id desc", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursor = DBUtil.query(this.__db, roomSQLiteQuery, false, null);
        String string2 = "id";
        try {
            int n10 = CursorUtil.getColumnIndexOrThrow(cursor, string2);
            String string3 = "userId";
            int n11 = CursorUtil.getColumnIndexOrThrow(cursor, string3);
            String string4 = "postId";
            int n12 = CursorUtil.getColumnIndexOrThrow(cursor, string4);
            String string5 = "phoneid";
            int n13 = CursorUtil.getColumnIndexOrThrow(cursor, string5);
            String string6 = "reason";
            int n14 = CursorUtil.getColumnIndexOrThrow(cursor, string6);
            String string7 = "reasonCode";
            int n15 = CursorUtil.getColumnIndexOrThrow(cursor, string7);
            String string8 = "sourceUrl1";
            int n16 = CursorUtil.getColumnIndexOrThrow(cursor, string8);
            String string9 = "sourceUrl2";
            int n17 = CursorUtil.getColumnIndexOrThrow(cursor, string9);
            String string10 = "failAt";
            int n18 = CursorUtil.getColumnIndexOrThrow(cursor, string10);
            String string11 = "version";
            int n19 = CursorUtil.getColumnIndexOrThrow(cursor, string11);
            int n20 = cursor.getCount();
            ArrayList<Object> arrayList = new ArrayList<Object>(n20);
            while ((n20 = (int)(cursor.moveToNext() ? 1 : 0)) != 0) {
                String string12;
                String string13;
                String string14;
                String string15;
                String string16;
                String string17;
                String string18;
                Object object;
                String string19;
                int n21 = cursor.getInt(n10);
                n20 = (int)(cursor.isNull(n11) ? 1 : 0);
                if (n20 != 0) {
                    string19 = null;
                } else {
                    object = cursor.getString(n11);
                    string19 = object;
                }
                n20 = (int)(cursor.isNull(n12) ? 1 : 0);
                if (n20 != 0) {
                    string18 = null;
                } else {
                    object = cursor.getString(n12);
                    string18 = object;
                }
                n20 = (int)(cursor.isNull(n13) ? 1 : 0);
                if (n20 != 0) {
                    string17 = null;
                } else {
                    object = cursor.getString(n13);
                    string17 = object;
                }
                n20 = (int)(cursor.isNull(n14) ? 1 : 0);
                if (n20 != 0) {
                    string16 = null;
                } else {
                    object = cursor.getString(n14);
                    string16 = object;
                }
                n20 = (int)(cursor.isNull(n15) ? 1 : 0);
                if (n20 != 0) {
                    string15 = null;
                } else {
                    object = cursor.getString(n15);
                    string15 = object;
                }
                n20 = (int)(cursor.isNull(n16) ? 1 : 0);
                if (n20 != 0) {
                    string14 = null;
                } else {
                    object = cursor.getString(n16);
                    string14 = object;
                }
                n20 = (int)(cursor.isNull(n17) ? 1 : 0);
                if (n20 != 0) {
                    string13 = null;
                } else {
                    object = cursor.getString(n17);
                    string13 = object;
                }
                n20 = (int)(cursor.isNull(n18) ? 1 : 0);
                if (n20 != 0) {
                    string12 = null;
                } else {
                    object = cursor.getString(n18);
                    string12 = object;
                }
                n20 = (int)(cursor.isNull(n19) ? 1 : 0);
                Object object2 = n20 != 0 ? null : (object = cursor.getString(n19));
                object = new PublishLog(n21, string19, string18, string17, string16, string15, string14, string13, string12, (String)object2);
                arrayList.add(object);
            }
            return arrayList;
        }
        finally {
            cursor.close();
            roomSQLiteQuery.release();
        }
    }
}

