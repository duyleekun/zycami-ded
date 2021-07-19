/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.database.dao.font;

import androidx.lifecycle.LiveData;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.zhiyun.cama.data.database.dao.font.CaptionStyleFileDao;
import com.zhiyun.cama.data.database.dao.font.CaptionStyleFileDao_Impl$1;
import com.zhiyun.cama.data.database.dao.font.CaptionStyleFileDao_Impl$7;
import com.zhiyun.cama.data.database.dao.font.CaptionStyleFileDao_Impl$8;
import com.zhiyun.cama.data.database.dao.font.CaptionStyleFileDao_Impl$9;
import com.zhiyun.cama.data.database.model.font.CaptionStyleFile;
import e.a.i0;
import java.util.Collections;
import java.util.List;

public final class CaptionStyleFileDao_Impl
implements CaptionStyleFileDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter __deletionAdapterOfCaptionStyleFile;
    private final EntityInsertionAdapter __insertionAdapterOfCaptionStyleFile;
    private final EntityInsertionAdapter __insertionAdapterOfCaptionStyleFile_1;
    private final SharedSQLiteStatement __preparedStmtOfDeleteAll;
    private final SharedSQLiteStatement __preparedStmtOfDeleteAllAssetsCaptionStyleFile;
    private final EntityDeletionOrUpdateAdapter __updateAdapterOfCaptionStyleFile;

    public CaptionStyleFileDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        SharedSQLiteStatement sharedSQLiteStatement = new CaptionStyleFileDao_Impl$1(this, roomDatabase);
        this.__insertionAdapterOfCaptionStyleFile = sharedSQLiteStatement;
        super(this, roomDatabase);
        this.__insertionAdapterOfCaptionStyleFile_1 = sharedSQLiteStatement;
        super(this, roomDatabase);
        this.__deletionAdapterOfCaptionStyleFile = sharedSQLiteStatement;
        super(this, roomDatabase);
        this.__updateAdapterOfCaptionStyleFile = sharedSQLiteStatement;
        super(this, roomDatabase);
        this.__preparedStmtOfDeleteAllAssetsCaptionStyleFile = sharedSQLiteStatement;
        super(this, roomDatabase);
        this.__preparedStmtOfDeleteAll = sharedSQLiteStatement;
    }

    public static /* synthetic */ RoomDatabase access$000(CaptionStyleFileDao_Impl captionStyleFileDao_Impl) {
        return captionStyleFileDao_Impl.__db;
    }

    public static /* synthetic */ EntityInsertionAdapter access$100(CaptionStyleFileDao_Impl captionStyleFileDao_Impl) {
        return captionStyleFileDao_Impl.__insertionAdapterOfCaptionStyleFile;
    }

    public static /* synthetic */ EntityInsertionAdapter access$200(CaptionStyleFileDao_Impl captionStyleFileDao_Impl) {
        return captionStyleFileDao_Impl.__insertionAdapterOfCaptionStyleFile_1;
    }

    public static List getRequiredConverters() {
        return Collections.emptyList();
    }

    public void delete(CaptionStyleFile object) {
        this.__db.assertNotSuspendingTransaction();
        Object object2 = this.__db;
        ((RoomDatabase)object2).beginTransaction();
        try {
            object2 = this.__deletionAdapterOfCaptionStyleFile;
            ((EntityDeletionOrUpdateAdapter)object2).handle(object);
            object = this.__db;
            ((RoomDatabase)object).setTransactionSuccessful();
            return;
        }
        finally {
            this.__db.endTransaction();
        }
    }

    public void delete(List object) {
        this.__db.assertNotSuspendingTransaction();
        Object object2 = this.__db;
        ((RoomDatabase)object2).beginTransaction();
        try {
            object2 = this.__deletionAdapterOfCaptionStyleFile;
            ((EntityDeletionOrUpdateAdapter)object2).handleMultiple((Iterable)object);
            object = this.__db;
            ((RoomDatabase)object).setTransactionSuccessful();
            return;
        }
        finally {
            this.__db.endTransaction();
        }
    }

    public void deleteAll() {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatement = this.__preparedStmtOfDeleteAll.acquire();
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
            this.__preparedStmtOfDeleteAll.release(supportSQLiteStatement);
        }
    }

    public void deleteAllAssetsCaptionStyleFile() {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatement = this.__preparedStmtOfDeleteAllAssetsCaptionStyleFile.acquire();
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
            this.__preparedStmtOfDeleteAllAssetsCaptionStyleFile.release(supportSQLiteStatement);
        }
    }

    public LiveData getAllCaptionStyleFile() {
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire("SELECT `ext_lic_url`, `ext_lic_name`, `ext_lic_path`, `caption_style_file`.`hash` AS `hash`, `caption_style_file`.`name` AS `name`, `caption_style_file`.`category` AS `category`, `caption_style_file`.`mime` AS `mime`, `caption_style_file`.`size` AS `size`, `caption_style_file`.`url` AS `url`, `caption_style_file`.`path` AS `path`, `caption_style_file`.`download_timestamp` AS `download_timestamp` FROM caption_style_file", 0);
        InvalidationTracker invalidationTracker = this.__db.getInvalidationTracker();
        String[] stringArray = new String[]{"caption_style_file"};
        CaptionStyleFileDao_Impl$9 captionStyleFileDao_Impl$9 = new CaptionStyleFileDao_Impl$9(this, roomSQLiteQuery);
        return invalidationTracker.createLiveData(stringArray, false, captionStyleFileDao_Impl$9);
    }

    public long insert(CaptionStyleFile object) {
        this.__db.assertNotSuspendingTransaction();
        Object object2 = this.__db;
        ((RoomDatabase)object2).beginTransaction();
        try {
            object2 = this.__insertionAdapterOfCaptionStyleFile_1;
            long l10 = ((EntityInsertionAdapter)object2).insertAndReturnId(object);
            object = this.__db;
            ((RoomDatabase)object).setTransactionSuccessful();
            return l10;
        }
        finally {
            this.__db.endTransaction();
        }
    }

    public List insert(List list) {
        this.__db.assertNotSuspendingTransaction();
        Object object = this.__db;
        ((RoomDatabase)object).beginTransaction();
        try {
            object = this.__insertionAdapterOfCaptionStyleFile_1;
            list = ((EntityInsertionAdapter)object).insertAndReturnIdsList(list);
            object = this.__db;
            ((RoomDatabase)object).setTransactionSuccessful();
            return list;
        }
        finally {
            this.__db.endTransaction();
        }
    }

    public i0 insertSingle(List list) {
        CaptionStyleFileDao_Impl$8 captionStyleFileDao_Impl$8 = new CaptionStyleFileDao_Impl$8(this, list);
        return i0.o0(captionStyleFileDao_Impl$8);
    }

    public long replace(CaptionStyleFile object) {
        this.__db.assertNotSuspendingTransaction();
        Object object2 = this.__db;
        ((RoomDatabase)object2).beginTransaction();
        try {
            object2 = this.__insertionAdapterOfCaptionStyleFile;
            long l10 = ((EntityInsertionAdapter)object2).insertAndReturnId(object);
            object = this.__db;
            ((RoomDatabase)object).setTransactionSuccessful();
            return l10;
        }
        finally {
            this.__db.endTransaction();
        }
    }

    public List replace(List list) {
        this.__db.assertNotSuspendingTransaction();
        Object object = this.__db;
        ((RoomDatabase)object).beginTransaction();
        try {
            object = this.__insertionAdapterOfCaptionStyleFile;
            list = ((EntityInsertionAdapter)object).insertAndReturnIdsList(list);
            object = this.__db;
            ((RoomDatabase)object).setTransactionSuccessful();
            return list;
        }
        finally {
            this.__db.endTransaction();
        }
    }

    public i0 replaceSingle(List list) {
        CaptionStyleFileDao_Impl$7 captionStyleFileDao_Impl$7 = new CaptionStyleFileDao_Impl$7(this, list);
        return i0.o0(captionStyleFileDao_Impl$7);
    }

    public void update(CaptionStyleFile object) {
        this.__db.assertNotSuspendingTransaction();
        Object object2 = this.__db;
        ((RoomDatabase)object2).beginTransaction();
        try {
            object2 = this.__updateAdapterOfCaptionStyleFile;
            ((EntityDeletionOrUpdateAdapter)object2).handle(object);
            object = this.__db;
            ((RoomDatabase)object).setTransactionSuccessful();
            return;
        }
        finally {
            this.__db.endTransaction();
        }
    }
}

