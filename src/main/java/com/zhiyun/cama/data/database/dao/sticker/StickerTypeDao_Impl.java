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
import com.zhiyun.cama.data.database.dao.sticker.StickerTypeDao;
import com.zhiyun.cama.data.database.dao.sticker.StickerTypeDao_Impl$1;
import com.zhiyun.cama.data.database.dao.sticker.StickerTypeDao_Impl$7;
import com.zhiyun.cama.data.database.dao.sticker.StickerTypeDao_Impl$8;
import com.zhiyun.cama.data.database.dao.sticker.StickerTypeDao_Impl$9;
import com.zhiyun.cama.data.database.model.sticker.StickerType;
import e.a.i0;
import java.util.Collections;
import java.util.List;

public final class StickerTypeDao_Impl
implements StickerTypeDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter __deletionAdapterOfStickerType;
    private final EntityInsertionAdapter __insertionAdapterOfStickerType;
    private final EntityInsertionAdapter __insertionAdapterOfStickerType_1;
    private final SharedSQLiteStatement __preparedStmtOfDeleteAssetsStickerType;
    private final SharedSQLiteStatement __preparedStmtOfDeleteDownloadStickerType;
    private final EntityDeletionOrUpdateAdapter __updateAdapterOfStickerType;

    public StickerTypeDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        SharedSQLiteStatement sharedSQLiteStatement = new StickerTypeDao_Impl$1(this, roomDatabase);
        this.__insertionAdapterOfStickerType = sharedSQLiteStatement;
        super(this, roomDatabase);
        this.__insertionAdapterOfStickerType_1 = sharedSQLiteStatement;
        super(this, roomDatabase);
        this.__deletionAdapterOfStickerType = sharedSQLiteStatement;
        super(this, roomDatabase);
        this.__updateAdapterOfStickerType = sharedSQLiteStatement;
        super(this, roomDatabase);
        this.__preparedStmtOfDeleteAssetsStickerType = sharedSQLiteStatement;
        super(this, roomDatabase);
        this.__preparedStmtOfDeleteDownloadStickerType = sharedSQLiteStatement;
    }

    public static /* synthetic */ RoomDatabase access$000(StickerTypeDao_Impl stickerTypeDao_Impl) {
        return stickerTypeDao_Impl.__db;
    }

    public static /* synthetic */ EntityInsertionAdapter access$100(StickerTypeDao_Impl stickerTypeDao_Impl) {
        return stickerTypeDao_Impl.__insertionAdapterOfStickerType;
    }

    public static /* synthetic */ EntityInsertionAdapter access$200(StickerTypeDao_Impl stickerTypeDao_Impl) {
        return stickerTypeDao_Impl.__insertionAdapterOfStickerType_1;
    }

    public static List getRequiredConverters() {
        return Collections.emptyList();
    }

    public void delete(StickerType object) {
        this.__db.assertNotSuspendingTransaction();
        Object object2 = this.__db;
        ((RoomDatabase)object2).beginTransaction();
        try {
            object2 = this.__deletionAdapterOfStickerType;
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
            object2 = this.__deletionAdapterOfStickerType;
            ((EntityDeletionOrUpdateAdapter)object2).handleMultiple((Iterable)object);
            object = this.__db;
            ((RoomDatabase)object).setTransactionSuccessful();
            return;
        }
        finally {
            this.__db.endTransaction();
        }
    }

    public void deleteAssetsStickerType() {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatement = this.__preparedStmtOfDeleteAssetsStickerType.acquire();
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
            this.__preparedStmtOfDeleteAssetsStickerType.release(supportSQLiteStatement);
        }
    }

    public void deleteDownloadStickerType() {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatement = this.__preparedStmtOfDeleteDownloadStickerType.acquire();
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
            this.__preparedStmtOfDeleteDownloadStickerType.release(supportSQLiteStatement);
        }
    }

    public LiveData getAllStickerTypeData() {
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire("SELECT `sticker_type`.`id` AS `id`, `sticker_type`.`res_id` AS `res_id`, `sticker_type`.`label` AS `label`, `sticker_type`.`label_tw` AS `label_tw`, `sticker_type`.`label_en` AS `label_en`, `sticker_type`.`sort` AS `sort` FROM sticker_type ORDER BY sort desc", 0);
        InvalidationTracker invalidationTracker = this.__db.getInvalidationTracker();
        String[] stringArray = new String[]{"sticker_type"};
        StickerTypeDao_Impl$9 stickerTypeDao_Impl$9 = new StickerTypeDao_Impl$9(this, roomSQLiteQuery);
        return invalidationTracker.createLiveData(stringArray, false, stickerTypeDao_Impl$9);
    }

    public long insert(StickerType object) {
        this.__db.assertNotSuspendingTransaction();
        Object object2 = this.__db;
        ((RoomDatabase)object2).beginTransaction();
        try {
            object2 = this.__insertionAdapterOfStickerType_1;
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
            object = this.__insertionAdapterOfStickerType_1;
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
        StickerTypeDao_Impl$8 stickerTypeDao_Impl$8 = new StickerTypeDao_Impl$8(this, list);
        return i0.o0(stickerTypeDao_Impl$8);
    }

    public long replace(StickerType object) {
        this.__db.assertNotSuspendingTransaction();
        Object object2 = this.__db;
        ((RoomDatabase)object2).beginTransaction();
        try {
            object2 = this.__insertionAdapterOfStickerType;
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
            object = this.__insertionAdapterOfStickerType;
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
        StickerTypeDao_Impl$7 stickerTypeDao_Impl$7 = new StickerTypeDao_Impl$7(this, list);
        return i0.o0(stickerTypeDao_Impl$7);
    }

    public void update(StickerType object) {
        this.__db.assertNotSuspendingTransaction();
        Object object2 = this.__db;
        ((RoomDatabase)object2).beginTransaction();
        try {
            object2 = this.__updateAdapterOfStickerType;
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

