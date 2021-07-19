/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.database.Cursor
 */
package com.zhiyun.cama.data.database.dao;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.paging.DataSource$Factory;
import androidx.room.EntityInsertionAdapter;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.zhiyun.cama.data.database.dao.MessageDao;
import com.zhiyun.cama.data.database.dao.MessageDao_Impl$1;
import com.zhiyun.cama.data.database.dao.MessageDao_Impl$11;
import com.zhiyun.cama.data.database.dao.MessageDao_Impl$12;
import com.zhiyun.cama.data.database.dao.MessageDao_Impl$13;
import com.zhiyun.cama.data.database.dao.MessageDao_Impl$14;
import com.zhiyun.cama.data.database.model.MessageUnReadCount;
import com.zhiyun.cama.data.database.model.MessageViolation;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class MessageDao_Impl
implements MessageDao {
    private final RoomDatabase __db;
    private final EntityInsertionAdapter __insertionAdapterOfMessageLike;
    private final EntityInsertionAdapter __insertionAdapterOfMessageSystem;
    private final EntityInsertionAdapter __insertionAdapterOfMessageUnReadCount;
    private final EntityInsertionAdapter __insertionAdapterOfMessageViolation;
    private final SharedSQLiteStatement __preparedStmtOfDeleteMessageLike;
    private final SharedSQLiteStatement __preparedStmtOfDeleteMessageLike_1;
    private final SharedSQLiteStatement __preparedStmtOfDeleteMessageSystem;
    private final SharedSQLiteStatement __preparedStmtOfDeleteMessageSystem_1;
    private final SharedSQLiteStatement __preparedStmtOfDeleteMessageViolation;
    private final SharedSQLiteStatement __preparedStmtOfDeleteMessageViolation_1;

    public MessageDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        SharedSQLiteStatement sharedSQLiteStatement = new MessageDao_Impl$1(this, roomDatabase);
        this.__insertionAdapterOfMessageLike = sharedSQLiteStatement;
        super(this, roomDatabase);
        this.__insertionAdapterOfMessageSystem = sharedSQLiteStatement;
        super(this, roomDatabase);
        this.__insertionAdapterOfMessageUnReadCount = sharedSQLiteStatement;
        super(this, roomDatabase);
        this.__insertionAdapterOfMessageViolation = sharedSQLiteStatement;
        super(this, roomDatabase);
        this.__preparedStmtOfDeleteMessageLike = sharedSQLiteStatement;
        super(this, roomDatabase);
        this.__preparedStmtOfDeleteMessageLike_1 = sharedSQLiteStatement;
        super(this, roomDatabase);
        this.__preparedStmtOfDeleteMessageSystem = sharedSQLiteStatement;
        super(this, roomDatabase);
        this.__preparedStmtOfDeleteMessageSystem_1 = sharedSQLiteStatement;
        super(this, roomDatabase);
        this.__preparedStmtOfDeleteMessageViolation = sharedSQLiteStatement;
        super(this, roomDatabase);
        this.__preparedStmtOfDeleteMessageViolation_1 = sharedSQLiteStatement;
    }

    public static /* synthetic */ RoomDatabase access$000(MessageDao_Impl messageDao_Impl) {
        return messageDao_Impl.__db;
    }

    public static List getRequiredConverters() {
        return Collections.emptyList();
    }

    public void deleteMessageLike() {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatement = this.__preparedStmtOfDeleteMessageLike.acquire();
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
            this.__preparedStmtOfDeleteMessageLike.release(supportSQLiteStatement);
        }
    }

    public void deleteMessageLike(int n10) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatement = this.__preparedStmtOfDeleteMessageLike_1.acquire();
        long l10 = n10;
        n10 = 1;
        supportSQLiteStatement.bindLong(n10, l10);
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
            this.__preparedStmtOfDeleteMessageLike_1.release(supportSQLiteStatement);
        }
    }

    public void deleteMessageSystem() {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatement = this.__preparedStmtOfDeleteMessageSystem.acquire();
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
            this.__preparedStmtOfDeleteMessageSystem.release(supportSQLiteStatement);
        }
    }

    public void deleteMessageSystem(int n10) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatement = this.__preparedStmtOfDeleteMessageSystem_1.acquire();
        long l10 = n10;
        n10 = 1;
        supportSQLiteStatement.bindLong(n10, l10);
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
            this.__preparedStmtOfDeleteMessageSystem_1.release(supportSQLiteStatement);
        }
    }

    public void deleteMessageViolation() {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatement = this.__preparedStmtOfDeleteMessageViolation.acquire();
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
            this.__preparedStmtOfDeleteMessageViolation.release(supportSQLiteStatement);
        }
    }

    public void deleteMessageViolation(int n10) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatement = this.__preparedStmtOfDeleteMessageViolation_1.acquire();
        long l10 = n10;
        n10 = 1;
        supportSQLiteStatement.bindLong(n10, l10);
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
            this.__preparedStmtOfDeleteMessageViolation_1.release(supportSQLiteStatement);
        }
    }

    public void insertMessageLike(List object) {
        this.__db.assertNotSuspendingTransaction();
        Object object2 = this.__db;
        ((RoomDatabase)object2).beginTransaction();
        try {
            object2 = this.__insertionAdapterOfMessageLike;
            ((EntityInsertionAdapter)object2).insert((Iterable)object);
            object = this.__db;
            ((RoomDatabase)object).setTransactionSuccessful();
            return;
        }
        finally {
            this.__db.endTransaction();
        }
    }

    public void insertMessageSystem(ArrayList object) {
        this.__db.assertNotSuspendingTransaction();
        Object object2 = this.__db;
        ((RoomDatabase)object2).beginTransaction();
        try {
            object2 = this.__insertionAdapterOfMessageSystem;
            ((EntityInsertionAdapter)object2).insert((Iterable)object);
            object = this.__db;
            ((RoomDatabase)object).setTransactionSuccessful();
            return;
        }
        finally {
            this.__db.endTransaction();
        }
    }

    public void insertMessageUnreadCount(MessageUnReadCount object) {
        this.__db.assertNotSuspendingTransaction();
        Object object2 = this.__db;
        ((RoomDatabase)object2).beginTransaction();
        try {
            object2 = this.__insertionAdapterOfMessageUnReadCount;
            ((EntityInsertionAdapter)object2).insert(object);
            object = this.__db;
            ((RoomDatabase)object).setTransactionSuccessful();
            return;
        }
        finally {
            this.__db.endTransaction();
        }
    }

    public void insertMessageViolation(List object) {
        this.__db.assertNotSuspendingTransaction();
        Object object2 = this.__db;
        ((RoomDatabase)object2).beginTransaction();
        try {
            object2 = this.__insertionAdapterOfMessageViolation;
            ((EntityInsertionAdapter)object2).insert((Iterable)object);
            object = this.__db;
            ((RoomDatabase)object).setTransactionSuccessful();
            return;
        }
        finally {
            this.__db.endTransaction();
        }
    }

    public void insertMessageViolation(MessageViolation ... object) {
        this.__db.assertNotSuspendingTransaction();
        Object object2 = this.__db;
        ((RoomDatabase)object2).beginTransaction();
        try {
            object2 = this.__insertionAdapterOfMessageViolation;
            ((EntityInsertionAdapter)object2).insert((Object[])object);
            object = this.__db;
            ((RoomDatabase)object).setTransactionSuccessful();
            return;
        }
        finally {
            this.__db.endTransaction();
        }
    }

    public DataSource$Factory loadMessageLike() {
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire("SELECT `MessageLike`.`id` AS `id`, `MessageLike`.`userId` AS `userId`, `MessageLike`.`nickname` AS `nickname`, `MessageLike`.`avatar` AS `avatar`, `MessageLike`.`verified` AS `verified`, `MessageLike`.`workType` AS `workType`, `MessageLike`.`circleArticleId` AS `circleArticleId`, `MessageLike`.`postId` AS `postId`, `MessageLike`.`sourceUrls` AS `sourceUrls`, `MessageLike`.`createAt` AS `createAt`, `MessageLike`.`isRead` AS `isRead`, `MessageLike`.`targetText` AS `targetText` FROM MessageLike ORDER BY id DESC", 0);
        MessageDao_Impl$11 messageDao_Impl$11 = new MessageDao_Impl$11(this, roomSQLiteQuery);
        return messageDao_Impl$11;
    }

    public DataSource$Factory loadMessageSystem() {
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire("SELECT `MessageSystem`.`id` AS `id`, `MessageSystem`.`createAt` AS `createAt`, `MessageSystem`.`isRead` AS `isRead`, `MessageSystem`.`verb` AS `verb`, `MessageSystem`.`objectId` AS `objectId`, `MessageSystem`.`objectType` AS `objectType`, `MessageSystem`.`title` AS `title`, `MessageSystem`.`content` AS `content`, `MessageSystem`.`nickname` AS `nickname`, `MessageSystem`.`sourceUrls` AS `sourceUrls`, `MessageSystem`.`endAt` AS `endAt`, `MessageSystem`.`image` AS `image`, `MessageSystem`.`userId` AS `userId`, `MessageSystem`.`avatar` AS `avatar` FROM MessageSystem ORDER BY createAt DESC", 0);
        MessageDao_Impl$12 messageDao_Impl$12 = new MessageDao_Impl$12(this, roomSQLiteQuery);
        return messageDao_Impl$12;
    }

    public LiveData loadMessageUnreadCount(int n10) {
        int n11 = 1;
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire("SELECT * FROM MessageUnReadCount WHERE id=?", n11);
        long l10 = n10;
        roomSQLiteQuery.bindLong(n11, l10);
        InvalidationTracker invalidationTracker = this.__db.getInvalidationTracker();
        String[] stringArray = new String[]{"MessageUnReadCount"};
        MessageDao_Impl$13 messageDao_Impl$13 = new MessageDao_Impl$13(this, roomSQLiteQuery);
        return invalidationTracker.createLiveData(stringArray, false, messageDao_Impl$13);
    }

    public MessageUnReadCount loadMessageUnreadCountData(int n10) {
        Cursor cursor;
        MessageUnReadCount messageUnReadCount;
        RoomSQLiteQuery roomSQLiteQuery;
        block21: {
            boolean bl2 = true;
            roomSQLiteQuery = RoomSQLiteQuery.acquire("SELECT * FROM MessageUnReadCount WHERE id=?", (int)(bl2 ? 1 : 0));
            int n11 = n10;
            long l10 = n10;
            roomSQLiteQuery.bindLong((int)(bl2 ? 1 : 0), l10);
            this.__db.assertNotSuspendingTransaction();
            Object object = this.__db;
            messageUnReadCount = null;
            cursor = DBUtil.query((RoomDatabase)object, roomSQLiteQuery, false, null);
            object = "id";
            n11 = CursorUtil.getColumnIndexOrThrow(cursor, (String)object);
            String string2 = "message";
            int n12 = CursorUtil.getColumnIndexOrThrow(cursor, string2);
            String string3 = "comment";
            int n13 = CursorUtil.getColumnIndexOrThrow(cursor, string3);
            String string4 = "follow";
            int n14 = CursorUtil.getColumnIndexOrThrow(cursor, string4);
            String string5 = "like";
            int n15 = CursorUtil.getColumnIndexOrThrow(cursor, string5);
            String string6 = "personal";
            int n16 = CursorUtil.getColumnIndexOrThrow(cursor, string6);
            String string7 = "notice";
            int n17 = CursorUtil.getColumnIndexOrThrow(cursor, string7);
            String string8 = "punished";
            int n18 = CursorUtil.getColumnIndexOrThrow(cursor, string8);
            boolean bl3 = cursor.moveToFirst();
            if (!bl3) break block21;
            int n19 = cursor.getInt(n11);
            int n20 = cursor.getInt(n12);
            int n21 = cursor.getInt(n13);
            int n22 = cursor.getInt(n14);
            int n23 = cursor.getInt(n15);
            int n24 = cursor.getInt(n16);
            int n25 = cursor.getInt(n17);
            n11 = cursor.getInt(n18);
            boolean bl4 = n11 != 0 ? bl2 : false;
            messageUnReadCount = new MessageUnReadCount(n19, n20, n21, n22, n23, n24, n25, bl4);
        }
        return messageUnReadCount;
        finally {
            cursor.close();
            roomSQLiteQuery.release();
        }
    }

    public DataSource$Factory loadMessageViolation() {
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire("SELECT `MessageViolation`.`id` AS `id`, `MessageViolation`.`verb` AS `verb`, `MessageViolation`.`refId` AS `refId`, `MessageViolation`.`refType` AS `refType`, `MessageViolation`.`content` AS `content`, `MessageViolation`.`createAt` AS `createAt`, `MessageViolation`.`isRead` AS `isRead`, `MessageViolation`.`build_time` AS `build_time`, `MessageViolation`.`degree` AS `degree`, `MessageViolation`.`refuse_reason` AS `refuse_reason`, `MessageViolation`.`appeal_id` AS `appeal_id`, `MessageViolation`.`appeal_status` AS `appeal_status`, `MessageViolation`.`has_punish` AS `has_punish`, `MessageViolation`.`classify` AS `classify`, `MessageViolation`.`punish` AS `punish`, `MessageViolation`.`forever` AS `forever`, `MessageViolation`.`punish_endtime` AS `punish_endtime`, `MessageViolation`.`circle_name` AS `circle_name`, `MessageViolation`.`source` AS `source`, `MessageViolation`.`source_id` AS `source_id` FROM MessageViolation ORDER BY createAt DESC", 0);
        MessageDao_Impl$14 messageDao_Impl$14 = new MessageDao_Impl$14(this, roomSQLiteQuery);
        return messageDao_Impl$14;
    }

    public MessageViolation loadMessageViolation(String string2, int n10) {
        Object object = this;
        Object object2 = string2;
        int n11 = 2;
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire("SELECT * FROM MessageViolation WHERE verb = ? AND refId = ?", n11);
        int n12 = 1;
        if (string2 == null) {
            roomSQLiteQuery.bindNull(n12);
        } else {
            roomSQLiteQuery.bindString(n12, string2);
        }
        int n13 = n10;
        long l10 = n10;
        roomSQLiteQuery.bindLong(n11, l10);
        ((MessageDao_Impl)object).__db.assertNotSuspendingTransaction();
        object2 = ((MessageDao_Impl)object).__db;
        n11 = 0;
        n12 = 0;
        Object object3 = null;
        Cursor cursor = DBUtil.query((RoomDatabase)object2, roomSQLiteQuery, false, null);
        object2 = "id";
        try {
            n13 = CursorUtil.getColumnIndexOrThrow(cursor, (String)object2);
            String string3 = "verb";
            int n14 = CursorUtil.getColumnIndexOrThrow(cursor, string3);
            String string4 = "refId";
            int n15 = CursorUtil.getColumnIndexOrThrow(cursor, string4);
            String string5 = "refType";
            int n16 = CursorUtil.getColumnIndexOrThrow(cursor, string5);
            String string6 = "content";
            int n17 = CursorUtil.getColumnIndexOrThrow(cursor, string6);
            String string7 = "createAt";
            int n18 = CursorUtil.getColumnIndexOrThrow(cursor, string7);
            String string8 = "isRead";
            int n19 = CursorUtil.getColumnIndexOrThrow(cursor, string8);
            String string9 = "build_time";
            int n20 = CursorUtil.getColumnIndexOrThrow(cursor, string9);
            String string10 = "degree";
            int n21 = CursorUtil.getColumnIndexOrThrow(cursor, string10);
            String string11 = "refuse_reason";
            int n22 = CursorUtil.getColumnIndexOrThrow(cursor, string11);
            String string12 = "appeal_id";
            int n23 = CursorUtil.getColumnIndexOrThrow(cursor, string12);
            String string13 = "appeal_status";
            int n24 = CursorUtil.getColumnIndexOrThrow(cursor, string13);
            object3 = "has_punish";
            n12 = CursorUtil.getColumnIndexOrThrow(cursor, (String)object3);
            object = "classify";
            int n25 = CursorUtil.getColumnIndexOrThrow(cursor, (String)object);
            return n25;
        }
        finally {
            RoomSQLiteQuery roomSQLiteQuery2 = roomSQLiteQuery;
        }
    }
}

