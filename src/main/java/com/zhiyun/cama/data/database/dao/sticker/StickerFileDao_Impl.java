/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.database.dao.sticker;

import androidx.lifecycle.LiveData;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.zhiyun.cama.data.database.dao.sticker.StickerFileDao;
import com.zhiyun.cama.data.database.dao.sticker.StickerFileDao_Impl$1;
import com.zhiyun.cama.data.database.dao.sticker.StickerFileDao_Impl$7;
import com.zhiyun.cama.data.database.dao.sticker.StickerFileDao_Impl$8;
import com.zhiyun.cama.data.database.dao.sticker.StickerFileDao_Impl$9;
import com.zhiyun.cama.data.database.model.sticker.StickerFile;
import e.a.i0;
import java.util.Collections;
import java.util.List;

public final class StickerFileDao_Impl
implements StickerFileDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter __deletionAdapterOfStickerFile;
    private final EntityInsertionAdapter __insertionAdapterOfStickerFile;
    private final EntityInsertionAdapter __insertionAdapterOfStickerFile_1;
    private final SharedSQLiteStatement __preparedStmtOfDeleteAll;
    private final SharedSQLiteStatement __preparedStmtOfDeleteAllAssetsFile;
    private final EntityDeletionOrUpdateAdapter __updateAdapterOfStickerFile;

    public StickerFileDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        SharedSQLiteStatement sharedSQLiteStatement = new StickerFileDao_Impl$1(this, roomDatabase);
        this.__insertionAdapterOfStickerFile = sharedSQLiteStatement;
        super(this, roomDatabase);
        this.__insertionAdapterOfStickerFile_1 = sharedSQLiteStatement;
        super(this, roomDatabase);
        this.__deletionAdapterOfStickerFile = sharedSQLiteStatement;
        super(this, roomDatabase);
        this.__updateAdapterOfStickerFile = sharedSQLiteStatement;
        super(this, roomDatabase);
        this.__preparedStmtOfDeleteAll = sharedSQLiteStatement;
        super(this, roomDatabase);
        this.__preparedStmtOfDeleteAllAssetsFile = sharedSQLiteStatement;
    }

    public static /* synthetic */ RoomDatabase access$000(StickerFileDao_Impl stickerFileDao_Impl) {
        return stickerFileDao_Impl.__db;
    }

    public static /* synthetic */ EntityInsertionAdapter access$100(StickerFileDao_Impl stickerFileDao_Impl) {
        return stickerFileDao_Impl.__insertionAdapterOfStickerFile;
    }

    public static /* synthetic */ EntityInsertionAdapter access$200(StickerFileDao_Impl stickerFileDao_Impl) {
        return stickerFileDao_Impl.__insertionAdapterOfStickerFile_1;
    }

    public static List getRequiredConverters() {
        return Collections.emptyList();
    }

    public void delete(StickerFile object) {
        this.__db.assertNotSuspendingTransaction();
        Object object2 = this.__db;
        ((RoomDatabase)object2).beginTransaction();
        try {
            object2 = this.__deletionAdapterOfStickerFile;
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
            object2 = this.__deletionAdapterOfStickerFile;
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

    public void deleteAllAssetsFile() {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatement = this.__preparedStmtOfDeleteAllAssetsFile.acquire();
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
            this.__preparedStmtOfDeleteAllAssetsFile.release(supportSQLiteStatement);
        }
    }

    public LiveData getAllStickerFile() {
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire("select `ext_lic_url`, `ext_lic_name`, `ext_lic_path`, `sticker_file`.`hash` AS `hash`, `sticker_file`.`name` AS `name`, `sticker_file`.`category` AS `category`, `sticker_file`.`mime` AS `mime`, `sticker_file`.`size` AS `size`, `sticker_file`.`url` AS `url`, `sticker_file`.`path` AS `path`, `sticker_file`.`download_timestamp` AS `download_timestamp` from sticker_file", 0);
        InvalidationTracker invalidationTracker = this.__db.getInvalidationTracker();
        String[] stringArray = new String[]{"sticker_file"};
        StickerFileDao_Impl$9 stickerFileDao_Impl$9 = new StickerFileDao_Impl$9(this, roomSQLiteQuery);
        return invalidationTracker.createLiveData(stringArray, false, stickerFileDao_Impl$9);
    }

    public long insert(StickerFile object) {
        this.__db.assertNotSuspendingTransaction();
        Object object2 = this.__db;
        ((RoomDatabase)object2).beginTransaction();
        try {
            object2 = this.__insertionAdapterOfStickerFile_1;
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
            object = this.__insertionAdapterOfStickerFile_1;
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
        StickerFileDao_Impl$8 stickerFileDao_Impl$8 = new StickerFileDao_Impl$8(this, list);
        return i0.o0(stickerFileDao_Impl$8);
    }

    public long replace(StickerFile object) {
        this.__db.assertNotSuspendingTransaction();
        Object object2 = this.__db;
        ((RoomDatabase)object2).beginTransaction();
        try {
            object2 = this.__insertionAdapterOfStickerFile;
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
            object = this.__insertionAdapterOfStickerFile;
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
        StickerFileDao_Impl$7 stickerFileDao_Impl$7 = new StickerFileDao_Impl$7(this, list);
        return i0.o0(stickerFileDao_Impl$7);
    }

    public void update(StickerFile object) {
        this.__db.assertNotSuspendingTransaction();
        Object object2 = this.__db;
        ((RoomDatabase)object2).beginTransaction();
        try {
            object2 = this.__updateAdapterOfStickerFile;
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

