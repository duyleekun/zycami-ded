/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.database.Cursor
 */
package com.zhiyun.cama.data.database.dao;

import android.database.Cursor;
import androidx.paging.DataSource$Factory;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.zhiyun.cama.data.database.dao.FeedbackDao;
import com.zhiyun.cama.data.database.dao.FeedbackDao_Impl$1;
import com.zhiyun.cama.data.database.dao.FeedbackDao_Impl$3;
import com.zhiyun.cama.data.database.model.Feedback;
import java.util.Collections;
import java.util.List;

public final class FeedbackDao_Impl
implements FeedbackDao {
    private final RoomDatabase __db;
    private final EntityInsertionAdapter __insertionAdapterOfFeedback;
    private final SharedSQLiteStatement __preparedStmtOfDeleteFeedback;

    public FeedbackDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        SharedSQLiteStatement sharedSQLiteStatement = new FeedbackDao_Impl$1(this, roomDatabase);
        this.__insertionAdapterOfFeedback = sharedSQLiteStatement;
        super(this, roomDatabase);
        this.__preparedStmtOfDeleteFeedback = sharedSQLiteStatement;
    }

    public static /* synthetic */ RoomDatabase access$000(FeedbackDao_Impl feedbackDao_Impl) {
        return feedbackDao_Impl.__db;
    }

    public static List getRequiredConverters() {
        return Collections.emptyList();
    }

    public void deleteFeedback() {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatement = this.__preparedStmtOfDeleteFeedback.acquire();
        RoomDatabase roomDatabase = this.__db;
        roomDatabase.beginTransaction();
        try {
            supportSQLiteStatement.executeUpdateDelete();
            roomDatabase = this.__db;
            roomDatabase.setTransactionSuccessful();
            return;
        }
        finally {
            this.__db.endTransaction();
            this.__preparedStmtOfDeleteFeedback.release(supportSQLiteStatement);
        }
    }

    public void insertFeedback(List object) {
        this.__db.assertNotSuspendingTransaction();
        Object object2 = this.__db;
        ((RoomDatabase)object2).beginTransaction();
        try {
            object2 = this.__insertionAdapterOfFeedback;
            ((EntityInsertionAdapter)object2).insert((Iterable)object);
            object = this.__db;
            ((RoomDatabase)object).setTransactionSuccessful();
            return;
        }
        finally {
            this.__db.endTransaction();
        }
    }

    public void insertFeedback(Feedback ... object) {
        this.__db.assertNotSuspendingTransaction();
        Object object2 = this.__db;
        ((RoomDatabase)object2).beginTransaction();
        try {
            object2 = this.__insertionAdapterOfFeedback;
            ((EntityInsertionAdapter)object2).insert((Object[])object);
            object = this.__db;
            ((RoomDatabase)object).setTransactionSuccessful();
            return;
        }
        finally {
            this.__db.endTransaction();
        }
    }

    public Feedback loadFeedback(int n10) {
        Object object = this;
        boolean bl2 = true;
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire("SELECT * FROM Feedback WHERE id = ?", (int)(bl2 ? 1 : 0));
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
            String string6 = "name";
            int n17 = CursorUtil.getColumnIndexOrThrow(cursor, string6);
            String string7 = "contact";
            int n18 = CursorUtil.getColumnIndexOrThrow(cursor, string7);
            String string8 = "title";
            int n19 = CursorUtil.getColumnIndexOrThrow(cursor, string8);
            String string9 = "content";
            int n20 = CursorUtil.getColumnIndexOrThrow(cursor, string9);
            String string10 = "type";
            int n21 = CursorUtil.getColumnIndexOrThrow(cursor, string10);
            String string11 = "platform";
            int n22 = CursorUtil.getColumnIndexOrThrow(cursor, string11);
            String string12 = "mobileModel";
            bl2 = CursorUtil.getColumnIndexOrThrow(cursor, string12);
            string2 = "mobileOSVersion";
            n12 = CursorUtil.getColumnIndexOrThrow(cursor, string2);
            object3 = "appVersion";
            n13 = CursorUtil.getColumnIndexOrThrow(cursor, (String)object3);
            object = "deviceModel";
            int n23 = CursorUtil.getColumnIndexOrThrow(cursor, (String)object);
            return n23;
        }
        finally {
            RoomSQLiteQuery roomSQLiteQuery2 = roomSQLiteQuery;
        }
    }

    public DataSource$Factory loadFeedbackList() {
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire("SELECT `Feedback`.`errcode` AS `errcode`, `Feedback`.`errmsg` AS `errmsg`, `Feedback`.`id` AS `id`, `Feedback`.`userId` AS `userId`, `Feedback`.`name` AS `name`, `Feedback`.`contact` AS `contact`, `Feedback`.`title` AS `title`, `Feedback`.`content` AS `content`, `Feedback`.`type` AS `type`, `Feedback`.`platform` AS `platform`, `Feedback`.`mobileModel` AS `mobileModel`, `Feedback`.`mobileOSVersion` AS `mobileOSVersion`, `Feedback`.`appVersion` AS `appVersion`, `Feedback`.`deviceModel` AS `deviceModel`, `Feedback`.`images` AS `images`, `Feedback`.`user_lang` AS `user_lang`, `Feedback`.`firmwareVersion` AS `firmwareVersion`, `Feedback`.`frequency` AS `frequency`, `Feedback`.`advice_target` AS `advice_target`, `Feedback`.`dealStatus` AS `dealStatus`, `Feedback`.`createAt` AS `createAt`, `Feedback`.`closedAt` AS `closedAt`, `Feedback`.`canActive` AS `canActive` FROM Feedback ORDER BY createAt DESC", 0);
        FeedbackDao_Impl$3 feedbackDao_Impl$3 = new FeedbackDao_Impl$3(this, roomSQLiteQuery);
        return feedbackDao_Impl$3;
    }
}

