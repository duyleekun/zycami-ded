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
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.zhiyun.cama.data.database.dao.WorksDao;
import com.zhiyun.cama.data.database.dao.WorksDao_Impl$1;
import com.zhiyun.cama.data.database.dao.WorksDao_Impl$10;
import com.zhiyun.cama.data.database.dao.WorksDao_Impl$11;
import com.zhiyun.cama.data.database.dao.WorksDao_Impl$12;
import com.zhiyun.cama.data.database.model.PublishWorks;
import com.zhiyun.cama.data.database.model.Works;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class WorksDao_Impl
implements WorksDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter __deletionAdapterOfLikes;
    private final EntityDeletionOrUpdateAdapter __deletionAdapterOfPublishWorks;
    private final EntityDeletionOrUpdateAdapter __deletionAdapterOfWorks;
    private final EntityInsertionAdapter __insertionAdapterOfLikes;
    private final EntityInsertionAdapter __insertionAdapterOfPublishWorks;
    private final EntityInsertionAdapter __insertionAdapterOfWorks;
    private final SharedSQLiteStatement __preparedStmtOfDeletedAllPublish;
    private final SharedSQLiteStatement __preparedStmtOfDeletedUserLikes;
    private final SharedSQLiteStatement __preparedStmtOfDeletedUserWorks;

    public WorksDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        SharedSQLiteStatement sharedSQLiteStatement = new WorksDao_Impl$1(this, roomDatabase);
        this.__insertionAdapterOfWorks = sharedSQLiteStatement;
        super(this, roomDatabase);
        this.__insertionAdapterOfPublishWorks = sharedSQLiteStatement;
        super(this, roomDatabase);
        this.__insertionAdapterOfLikes = sharedSQLiteStatement;
        super(this, roomDatabase);
        this.__deletionAdapterOfPublishWorks = sharedSQLiteStatement;
        super(this, roomDatabase);
        this.__deletionAdapterOfWorks = sharedSQLiteStatement;
        super(this, roomDatabase);
        this.__deletionAdapterOfLikes = sharedSQLiteStatement;
        super(this, roomDatabase);
        this.__preparedStmtOfDeletedUserWorks = sharedSQLiteStatement;
        super(this, roomDatabase);
        this.__preparedStmtOfDeletedAllPublish = sharedSQLiteStatement;
        super(this, roomDatabase);
        this.__preparedStmtOfDeletedUserLikes = sharedSQLiteStatement;
    }

    public static /* synthetic */ RoomDatabase access$000(WorksDao_Impl worksDao_Impl) {
        return worksDao_Impl.__db;
    }

    public static List getRequiredConverters() {
        return Collections.emptyList();
    }

    public void deleteLikes(List object) {
        this.__db.assertNotSuspendingTransaction();
        Object object2 = this.__db;
        ((RoomDatabase)object2).beginTransaction();
        try {
            object2 = this.__deletionAdapterOfLikes;
            ((EntityDeletionOrUpdateAdapter)object2).handleMultiple((Iterable)object);
            object = this.__db;
            ((RoomDatabase)object).setTransactionSuccessful();
            return;
        }
        finally {
            this.__db.endTransaction();
        }
    }

    public void deletePublishWorks(PublishWorks object) {
        this.__db.assertNotSuspendingTransaction();
        Object object2 = this.__db;
        ((RoomDatabase)object2).beginTransaction();
        try {
            object2 = this.__deletionAdapterOfPublishWorks;
            ((EntityDeletionOrUpdateAdapter)object2).handle(object);
            object = this.__db;
            ((RoomDatabase)object).setTransactionSuccessful();
            return;
        }
        finally {
            this.__db.endTransaction();
        }
    }

    public void deleteWorks(Works object) {
        this.__db.assertNotSuspendingTransaction();
        Object object2 = this.__db;
        ((RoomDatabase)object2).beginTransaction();
        try {
            object2 = this.__deletionAdapterOfWorks;
            ((EntityDeletionOrUpdateAdapter)object2).handle(object);
            object = this.__db;
            ((RoomDatabase)object).setTransactionSuccessful();
            return;
        }
        finally {
            this.__db.endTransaction();
        }
    }

    public void deletedAllPublish() {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatement = this.__preparedStmtOfDeletedAllPublish.acquire();
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
            this.__preparedStmtOfDeletedAllPublish.release(supportSQLiteStatement);
        }
    }

    public void deletedUserLikes(int n10) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatement = this.__preparedStmtOfDeletedUserLikes.acquire();
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
            this.__preparedStmtOfDeletedUserLikes.release(supportSQLiteStatement);
        }
    }

    public void deletedUserWorks(int n10) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatement = this.__preparedStmtOfDeletedUserWorks.acquire();
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
            this.__preparedStmtOfDeletedUserWorks.release(supportSQLiteStatement);
        }
    }

    public void insertLikes(List object) {
        this.__db.assertNotSuspendingTransaction();
        Object object2 = this.__db;
        ((RoomDatabase)object2).beginTransaction();
        try {
            object2 = this.__insertionAdapterOfLikes;
            ((EntityInsertionAdapter)object2).insert((Iterable)object);
            object = this.__db;
            ((RoomDatabase)object).setTransactionSuccessful();
            return;
        }
        finally {
            this.__db.endTransaction();
        }
    }

    public void insertPublishWorks(PublishWorks object) {
        this.__db.assertNotSuspendingTransaction();
        Object object2 = this.__db;
        ((RoomDatabase)object2).beginTransaction();
        try {
            object2 = this.__insertionAdapterOfPublishWorks;
            ((EntityInsertionAdapter)object2).insert(object);
            object = this.__db;
            ((RoomDatabase)object).setTransactionSuccessful();
            return;
        }
        finally {
            this.__db.endTransaction();
        }
    }

    public void insertWorks(List object) {
        this.__db.assertNotSuspendingTransaction();
        Object object2 = this.__db;
        ((RoomDatabase)object2).beginTransaction();
        try {
            object2 = this.__insertionAdapterOfWorks;
            ((EntityInsertionAdapter)object2).insert((Iterable)object);
            object = this.__db;
            ((RoomDatabase)object).setTransactionSuccessful();
            return;
        }
        finally {
            this.__db.endTransaction();
        }
    }

    public void insertWorks(Works ... object) {
        this.__db.assertNotSuspendingTransaction();
        Object object2 = this.__db;
        ((RoomDatabase)object2).beginTransaction();
        try {
            object2 = this.__insertionAdapterOfWorks;
            ((EntityInsertionAdapter)object2).insert((Object[])object);
            object = this.__db;
            ((RoomDatabase)object).setTransactionSuccessful();
            return;
        }
        finally {
            this.__db.endTransaction();
        }
    }

    public List loadLikesData(int n10) {
        ArrayList<Object> arrayList = this;
        int n11 = 1;
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire("SELECT * FROM Likes WHERE id = ?", n11);
        int n12 = n10;
        long l10 = n10;
        roomSQLiteQuery.bindLong(n11, l10);
        this.__db.assertNotSuspendingTransaction();
        Object object = this.__db;
        n11 = 0;
        int n13 = 0;
        String string2 = null;
        Cursor cursor = DBUtil.query((RoomDatabase)object, roomSQLiteQuery, false, null);
        object = "likeId";
        try {
            n12 = CursorUtil.getColumnIndexOrThrow(cursor, (String)object);
            String string3 = "user";
            int n14 = CursorUtil.getColumnIndexOrThrow(cursor, string3);
            String string4 = "id";
            int n15 = CursorUtil.getColumnIndexOrThrow(cursor, string4);
            String string5 = "sourceUrls";
            int n16 = CursorUtil.getColumnIndexOrThrow(cursor, string5);
            String string6 = "des";
            int n17 = CursorUtil.getColumnIndexOrThrow(cursor, string6);
            String string7 = "commentCnt";
            int n18 = CursorUtil.getColumnIndexOrThrow(cursor, string7);
            String string8 = "likeCnt";
            int n19 = CursorUtil.getColumnIndexOrThrow(cursor, string8);
            String string9 = "shareCnt";
            int n20 = CursorUtil.getColumnIndexOrThrow(cursor, string9);
            String string10 = "publishAt";
            int n21 = CursorUtil.getColumnIndexOrThrow(cursor, string10);
            String string11 = "pv";
            int n22 = CursorUtil.getColumnIndexOrThrow(cursor, string11);
            String string12 = "duration";
            int n23 = CursorUtil.getColumnIndexOrThrow(cursor, string12);
            String string13 = "thumbwh";
            int n24 = CursorUtil.getColumnIndexOrThrow(cursor, string13);
            string2 = "userId";
            n13 = CursorUtil.getColumnIndexOrThrow(cursor, string2);
            return n13;
        }
        finally {
            RoomSQLiteQuery roomSQLiteQuery2 = roomSQLiteQuery;
        }
    }

    public List loadLikesData(int n10, int n11) {
        ArrayList<Object> arrayList = this;
        int n12 = 2;
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire("SELECT * FROM Likes WHERE user =? AND id = ?", n12);
        int n13 = n10;
        long l10 = n10;
        roomSQLiteQuery.bindLong(1, l10);
        n13 = n11;
        l10 = n11;
        roomSQLiteQuery.bindLong(n12, l10);
        this.__db.assertNotSuspendingTransaction();
        Object object = this.__db;
        n12 = 0;
        int n14 = 0;
        String string2 = null;
        Cursor cursor = DBUtil.query((RoomDatabase)object, roomSQLiteQuery, false, null);
        object = "likeId";
        try {
            n13 = CursorUtil.getColumnIndexOrThrow(cursor, (String)object);
            String string3 = "user";
            int n15 = CursorUtil.getColumnIndexOrThrow(cursor, string3);
            String string4 = "id";
            int n16 = CursorUtil.getColumnIndexOrThrow(cursor, string4);
            String string5 = "sourceUrls";
            int n17 = CursorUtil.getColumnIndexOrThrow(cursor, string5);
            String string6 = "des";
            int n18 = CursorUtil.getColumnIndexOrThrow(cursor, string6);
            String string7 = "commentCnt";
            int n19 = CursorUtil.getColumnIndexOrThrow(cursor, string7);
            String string8 = "likeCnt";
            int n20 = CursorUtil.getColumnIndexOrThrow(cursor, string8);
            String string9 = "shareCnt";
            int n21 = CursorUtil.getColumnIndexOrThrow(cursor, string9);
            String string10 = "publishAt";
            int n22 = CursorUtil.getColumnIndexOrThrow(cursor, string10);
            String string11 = "pv";
            int n23 = CursorUtil.getColumnIndexOrThrow(cursor, string11);
            String string12 = "duration";
            int n24 = CursorUtil.getColumnIndexOrThrow(cursor, string12);
            String string13 = "thumbwh";
            int n25 = CursorUtil.getColumnIndexOrThrow(cursor, string13);
            string2 = "userId";
            n14 = CursorUtil.getColumnIndexOrThrow(cursor, string2);
            return n14;
        }
        finally {
            RoomSQLiteQuery roomSQLiteQuery2 = roomSQLiteQuery;
        }
    }

    public DataSource$Factory loadLikesWithUserId(int n10) {
        int n11 = 1;
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire("SELECT * FROM Likes WHERE user =? ORDER BY likeId", n11);
        long l10 = n10;
        roomSQLiteQuery.bindLong(n11, l10);
        WorksDao_Impl$12 worksDao_Impl$12 = new WorksDao_Impl$12(this, roomSQLiteQuery);
        return worksDao_Impl$12;
    }

    public LiveData loadPublishWorks() {
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire("SELECT `PublishWorks`.`filePath` AS `filePath`, `PublishWorks`.`coverPath` AS `coverPath`, `PublishWorks`.`fileDuration` AS `fileDuration`, `PublishWorks`.`worksDes` AS `worksDes`, `PublishWorks`.`state` AS `state`, `PublishWorks`.`percent` AS `percent`, `PublishWorks`.`title` AS `title`, `PublishWorks`.`tags` AS `tags`, `PublishWorks`.`devices` AS `devices`, `PublishWorks`.`address` AS `address`, `PublishWorks`.`activeId` AS `activeId`, `PublishWorks`.`themeId` AS `themeId`, `PublishWorks`.`needToDelete` AS `needToDelete`, `PublishWorks`.`config` AS `config`, `PublishWorks`.`publishFromType` AS `publishFromType`, `PublishWorks`.`worksId` AS `worksId`, `PublishWorks`.`postUrl` AS `postUrl`, `PublishWorks`.`smallImgUrl` AS `smallImgUrl`, `PublishWorks`.`fileUrl` AS `fileUrl`, `PublishWorks`.`circleId` AS `circleId`, `PublishWorks`.`type` AS `type`, `PublishWorks`.`archive` AS `archive`, `PublishWorks`.`shareToKwai` AS `shareToKwai`, `PublishWorks`.`kwaiToken` AS `kwaiToken`, `PublishWorks`.`resolution` AS `resolution`, `PublishWorks`.`coverObjectKey` AS `coverObjectKey`, `PublishWorks`.`fileObjectKey` AS `fileObjectKey` FROM PublishWorks", 0);
        InvalidationTracker invalidationTracker = this.__db.getInvalidationTracker();
        String[] stringArray = new String[]{"PublishWorks"};
        WorksDao_Impl$11 worksDao_Impl$11 = new WorksDao_Impl$11(this, roomSQLiteQuery);
        return invalidationTracker.createLiveData(stringArray, false, worksDao_Impl$11);
    }

    public PublishWorks loadPublishWorksData() {
        Object object = this;
        boolean bl2 = false;
        String string2 = null;
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire("SELECT `PublishWorks`.`filePath` AS `filePath`, `PublishWorks`.`coverPath` AS `coverPath`, `PublishWorks`.`fileDuration` AS `fileDuration`, `PublishWorks`.`worksDes` AS `worksDes`, `PublishWorks`.`state` AS `state`, `PublishWorks`.`percent` AS `percent`, `PublishWorks`.`title` AS `title`, `PublishWorks`.`tags` AS `tags`, `PublishWorks`.`devices` AS `devices`, `PublishWorks`.`address` AS `address`, `PublishWorks`.`activeId` AS `activeId`, `PublishWorks`.`themeId` AS `themeId`, `PublishWorks`.`needToDelete` AS `needToDelete`, `PublishWorks`.`config` AS `config`, `PublishWorks`.`publishFromType` AS `publishFromType`, `PublishWorks`.`worksId` AS `worksId`, `PublishWorks`.`postUrl` AS `postUrl`, `PublishWorks`.`smallImgUrl` AS `smallImgUrl`, `PublishWorks`.`fileUrl` AS `fileUrl`, `PublishWorks`.`circleId` AS `circleId`, `PublishWorks`.`type` AS `type`, `PublishWorks`.`archive` AS `archive`, `PublishWorks`.`shareToKwai` AS `shareToKwai`, `PublishWorks`.`kwaiToken` AS `kwaiToken`, `PublishWorks`.`resolution` AS `resolution`, `PublishWorks`.`coverObjectKey` AS `coverObjectKey`, `PublishWorks`.`fileObjectKey` AS `fileObjectKey` FROM PublishWorks", 0);
        this.__db.assertNotSuspendingTransaction();
        Object object2 = this.__db;
        int n10 = 0;
        Object object3 = null;
        Cursor cursor = DBUtil.query((RoomDatabase)object2, roomSQLiteQuery, false, null);
        object2 = "filePath";
        try {
            int n11 = CursorUtil.getColumnIndexOrThrow(cursor, (String)object2);
            String string3 = "coverPath";
            int n12 = CursorUtil.getColumnIndexOrThrow(cursor, string3);
            String string4 = "fileDuration";
            int n13 = CursorUtil.getColumnIndexOrThrow(cursor, string4);
            String string5 = "worksDes";
            int n14 = CursorUtil.getColumnIndexOrThrow(cursor, string5);
            String string6 = "state";
            int n15 = CursorUtil.getColumnIndexOrThrow(cursor, string6);
            String string7 = "percent";
            int n16 = CursorUtil.getColumnIndexOrThrow(cursor, string7);
            String string8 = "title";
            int n17 = CursorUtil.getColumnIndexOrThrow(cursor, string8);
            String string9 = "tags";
            int n18 = CursorUtil.getColumnIndexOrThrow(cursor, string9);
            String string10 = "devices";
            int n19 = CursorUtil.getColumnIndexOrThrow(cursor, string10);
            String string11 = "address";
            int n20 = CursorUtil.getColumnIndexOrThrow(cursor, string11);
            String string12 = "activeId";
            int n21 = CursorUtil.getColumnIndexOrThrow(cursor, string12);
            string2 = "themeId";
            int n22 = CursorUtil.getColumnIndexOrThrow(cursor, string2);
            object3 = "needToDelete";
            n10 = CursorUtil.getColumnIndexOrThrow(cursor, (String)object3);
            object = "config";
            int n23 = CursorUtil.getColumnIndexOrThrow(cursor, (String)object);
            return n23;
        }
        finally {
            RoomSQLiteQuery roomSQLiteQuery2 = roomSQLiteQuery;
        }
    }

    public Works loadWorksData(int n10) {
        Object object = this;
        int n11 = 1;
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire("SELECT * FROM Works WHERE id = ?", n11);
        int n12 = n10;
        long l10 = n10;
        roomSQLiteQuery.bindLong(n11, l10);
        this.__db.assertNotSuspendingTransaction();
        Object object2 = this.__db;
        n11 = 0;
        int n13 = 0;
        Object object3 = null;
        Cursor cursor = DBUtil.query((RoomDatabase)object2, roomSQLiteQuery, false, null);
        object2 = "id";
        try {
            n12 = CursorUtil.getColumnIndexOrThrow(cursor, (String)object2);
            String string2 = "sourceUrls";
            int n14 = CursorUtil.getColumnIndexOrThrow(cursor, string2);
            String string3 = "des";
            int n15 = CursorUtil.getColumnIndexOrThrow(cursor, string3);
            String string4 = "commentCnt";
            int n16 = CursorUtil.getColumnIndexOrThrow(cursor, string4);
            String string5 = "likeCnt";
            int n17 = CursorUtil.getColumnIndexOrThrow(cursor, string5);
            String string6 = "shareCnt";
            int n18 = CursorUtil.getColumnIndexOrThrow(cursor, string6);
            String string7 = "publishAt";
            int n19 = CursorUtil.getColumnIndexOrThrow(cursor, string7);
            String string8 = "duration";
            int n20 = CursorUtil.getColumnIndexOrThrow(cursor, string8);
            String string9 = "thumbwh";
            int n21 = CursorUtil.getColumnIndexOrThrow(cursor, string9);
            String string10 = "pv";
            int n22 = CursorUtil.getColumnIndexOrThrow(cursor, string10);
            String string11 = "address";
            int n23 = CursorUtil.getColumnIndexOrThrow(cursor, string11);
            String string12 = "status";
            int n24 = CursorUtil.getColumnIndexOrThrow(cursor, string12);
            object3 = "isChoice";
            n13 = CursorUtil.getColumnIndexOrThrow(cursor, (String)object3);
            object = "userId";
            int n25 = CursorUtil.getColumnIndexOrThrow(cursor, (String)object);
            return n25;
        }
        finally {
            RoomSQLiteQuery roomSQLiteQuery2 = roomSQLiteQuery;
        }
    }

    public Works loadWorksDataWithApprovalId(int n10) {
        Object object = this;
        int n11 = 1;
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire("SELECT * FROM Works WHERE approval_id = ?", n11);
        int n12 = n10;
        long l10 = n10;
        roomSQLiteQuery.bindLong(n11, l10);
        this.__db.assertNotSuspendingTransaction();
        Object object2 = this.__db;
        n11 = 0;
        int n13 = 0;
        Object object3 = null;
        Cursor cursor = DBUtil.query((RoomDatabase)object2, roomSQLiteQuery, false, null);
        object2 = "id";
        try {
            n12 = CursorUtil.getColumnIndexOrThrow(cursor, (String)object2);
            String string2 = "sourceUrls";
            int n14 = CursorUtil.getColumnIndexOrThrow(cursor, string2);
            String string3 = "des";
            int n15 = CursorUtil.getColumnIndexOrThrow(cursor, string3);
            String string4 = "commentCnt";
            int n16 = CursorUtil.getColumnIndexOrThrow(cursor, string4);
            String string5 = "likeCnt";
            int n17 = CursorUtil.getColumnIndexOrThrow(cursor, string5);
            String string6 = "shareCnt";
            int n18 = CursorUtil.getColumnIndexOrThrow(cursor, string6);
            String string7 = "publishAt";
            int n19 = CursorUtil.getColumnIndexOrThrow(cursor, string7);
            String string8 = "duration";
            int n20 = CursorUtil.getColumnIndexOrThrow(cursor, string8);
            String string9 = "thumbwh";
            int n21 = CursorUtil.getColumnIndexOrThrow(cursor, string9);
            String string10 = "pv";
            int n22 = CursorUtil.getColumnIndexOrThrow(cursor, string10);
            String string11 = "address";
            int n23 = CursorUtil.getColumnIndexOrThrow(cursor, string11);
            String string12 = "status";
            int n24 = CursorUtil.getColumnIndexOrThrow(cursor, string12);
            object3 = "isChoice";
            n13 = CursorUtil.getColumnIndexOrThrow(cursor, (String)object3);
            object = "userId";
            int n25 = CursorUtil.getColumnIndexOrThrow(cursor, (String)object);
            return n25;
        }
        finally {
            RoomSQLiteQuery roomSQLiteQuery2 = roomSQLiteQuery;
        }
    }

    public DataSource$Factory loadWorksWithUserId(int n10) {
        int n11 = 1;
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire("SELECT * FROM Works WHERE userId =? ORDER BY id DESC", n11);
        long l10 = n10;
        roomSQLiteQuery.bindLong(n11, l10);
        WorksDao_Impl$10 worksDao_Impl$10 = new WorksDao_Impl$10(this, roomSQLiteQuery);
        return worksDao_Impl$10;
    }
}

