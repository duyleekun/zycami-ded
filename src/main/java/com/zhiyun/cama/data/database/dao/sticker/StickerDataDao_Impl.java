/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.database.Cursor
 */
package com.zhiyun.cama.data.database.dao.sticker;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.zhiyun.cama.data.database.dao.sticker.StickerDataDao;
import com.zhiyun.cama.data.database.dao.sticker.StickerDataDao_Impl$1;
import com.zhiyun.cama.data.database.dao.sticker.StickerDataDao_Impl$10;
import com.zhiyun.cama.data.database.dao.sticker.StickerDataDao_Impl$11;
import com.zhiyun.cama.data.database.dao.sticker.StickerDataDao_Impl$12;
import com.zhiyun.cama.data.database.dao.sticker.StickerDataDao_Impl$13;
import com.zhiyun.cama.data.database.model.sticker.StickerData;
import e.a.i0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class StickerDataDao_Impl
implements StickerDataDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter __deletionAdapterOfStickerData;
    private final EntityInsertionAdapter __insertionAdapterOfStickerData;
    private final EntityInsertionAdapter __insertionAdapterOfStickerData_1;
    private final SharedSQLiteStatement __preparedStmtOfDeleteAll;
    private final SharedSQLiteStatement __preparedStmtOfDeleteAssetsSticker;
    private final SharedSQLiteStatement __preparedStmtOfDeleteDownloadSticker;
    private final SharedSQLiteStatement __preparedStmtOfDeleteDownloadStickerByType;
    private final SharedSQLiteStatement __preparedStmtOfUpdateStickerPath;
    private final EntityDeletionOrUpdateAdapter __updateAdapterOfStickerData;

    public StickerDataDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        SharedSQLiteStatement sharedSQLiteStatement = new StickerDataDao_Impl$1(this, roomDatabase);
        this.__insertionAdapterOfStickerData = sharedSQLiteStatement;
        super(this, roomDatabase);
        this.__insertionAdapterOfStickerData_1 = sharedSQLiteStatement;
        super(this, roomDatabase);
        this.__deletionAdapterOfStickerData = sharedSQLiteStatement;
        super(this, roomDatabase);
        this.__updateAdapterOfStickerData = sharedSQLiteStatement;
        super(this, roomDatabase);
        this.__preparedStmtOfDeleteAssetsSticker = sharedSQLiteStatement;
        super(this, roomDatabase);
        this.__preparedStmtOfDeleteDownloadSticker = sharedSQLiteStatement;
        super(this, roomDatabase);
        this.__preparedStmtOfDeleteDownloadStickerByType = sharedSQLiteStatement;
        super(this, roomDatabase);
        this.__preparedStmtOfUpdateStickerPath = sharedSQLiteStatement;
        super(this, roomDatabase);
        this.__preparedStmtOfDeleteAll = sharedSQLiteStatement;
    }

    public static /* synthetic */ RoomDatabase access$000(StickerDataDao_Impl stickerDataDao_Impl) {
        return stickerDataDao_Impl.__db;
    }

    public static /* synthetic */ EntityInsertionAdapter access$100(StickerDataDao_Impl stickerDataDao_Impl) {
        return stickerDataDao_Impl.__insertionAdapterOfStickerData;
    }

    public static /* synthetic */ EntityInsertionAdapter access$200(StickerDataDao_Impl stickerDataDao_Impl) {
        return stickerDataDao_Impl.__insertionAdapterOfStickerData_1;
    }

    public static List getRequiredConverters() {
        return Collections.emptyList();
    }

    public void delete(StickerData object) {
        this.__db.assertNotSuspendingTransaction();
        Object object2 = this.__db;
        ((RoomDatabase)object2).beginTransaction();
        try {
            object2 = this.__deletionAdapterOfStickerData;
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
            object2 = this.__deletionAdapterOfStickerData;
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

    public void deleteAssetsSticker() {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatement = this.__preparedStmtOfDeleteAssetsSticker.acquire();
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
            this.__preparedStmtOfDeleteAssetsSticker.release(supportSQLiteStatement);
        }
    }

    public void deleteDownloadSticker() {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatement = this.__preparedStmtOfDeleteDownloadSticker.acquire();
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
            this.__preparedStmtOfDeleteDownloadSticker.release(supportSQLiteStatement);
        }
    }

    public void deleteDownloadStickerByType(int n10) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatement = this.__preparedStmtOfDeleteDownloadStickerByType.acquire();
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
            this.__preparedStmtOfDeleteDownloadStickerByType.release(supportSQLiteStatement);
        }
    }

    public LiveData getAllStickerData() {
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire("SELECT `sticker_data`.`type_id` AS `type_id`, `sticker_data`.`size` AS `size`, `sticker_data`.`name` AS `name`, `sticker_data`.`scale` AS `scale`, `sticker_data`.`thumb` AS `thumb`, `sticker_data`.`little_thumb` AS `little_thumb`, `sticker_data`.`path` AS `path`, `sticker_data`.`hash` AS `hash`, `sticker_data`.`licensePath` AS `licensePath`, `sticker_data`.`licenseName` AS `licenseName`, `sticker_data`.`requiredPrime` AS `requiredPrime`, `sticker_data`.`id` AS `id`, `sticker_data`.`res_id` AS `res_id`, `sticker_data`.`label` AS `label`, `sticker_data`.`label_tw` AS `label_tw`, `sticker_data`.`label_en` AS `label_en`, `sticker_data`.`sort` AS `sort` FROM sticker_data ORDER BY sort desc", 0);
        InvalidationTracker invalidationTracker = this.__db.getInvalidationTracker();
        String[] stringArray = new String[]{"sticker_data"};
        StickerDataDao_Impl$12 stickerDataDao_Impl$12 = new StickerDataDao_Impl$12(this, roomSQLiteQuery);
        return invalidationTracker.createLiveData(stringArray, false, stickerDataDao_Impl$12);
    }

    public List getStickerDataByResId(int n10) {
        Object object = this;
        int n11 = 1;
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire("select * from sticker_data where res_id = ? ORDER BY sort desc", n11);
        int n12 = n10;
        long l10 = n10;
        roomSQLiteQuery.bindLong(n11, l10);
        this.__db.assertNotSuspendingTransaction();
        Object object2 = this.__db;
        n11 = 0;
        int n13 = 0;
        String string2 = null;
        Cursor cursor = DBUtil.query((RoomDatabase)object2, roomSQLiteQuery, false, null);
        object2 = "type_id";
        try {
            n12 = CursorUtil.getColumnIndexOrThrow(cursor, (String)object2);
            String string3 = "size";
            int n14 = CursorUtil.getColumnIndexOrThrow(cursor, string3);
            String string4 = "name";
            int n15 = CursorUtil.getColumnIndexOrThrow(cursor, string4);
            String string5 = "scale";
            int n16 = CursorUtil.getColumnIndexOrThrow(cursor, string5);
            String string6 = "thumb";
            int n17 = CursorUtil.getColumnIndexOrThrow(cursor, string6);
            String string7 = "little_thumb";
            int n18 = CursorUtil.getColumnIndexOrThrow(cursor, string7);
            String string8 = "path";
            int n19 = CursorUtil.getColumnIndexOrThrow(cursor, string8);
            String string9 = "hash";
            int n20 = CursorUtil.getColumnIndexOrThrow(cursor, string9);
            ArrayList<Object> arrayList = "licensePath";
            int n21 = CursorUtil.getColumnIndexOrThrow(cursor, (String)((Object)arrayList));
            String string10 = "licenseName";
            int n22 = CursorUtil.getColumnIndexOrThrow(cursor, string10);
            String string11 = "requiredPrime";
            int n23 = CursorUtil.getColumnIndexOrThrow(cursor, string11);
            String string12 = "id";
            int n24 = CursorUtil.getColumnIndexOrThrow(cursor, string12);
            string2 = "res_id";
            n13 = CursorUtil.getColumnIndexOrThrow(cursor, string2);
            object = "label";
            int n25 = CursorUtil.getColumnIndexOrThrow(cursor, (String)object);
            return n25;
        }
        finally {
            RoomSQLiteQuery roomSQLiteQuery2 = roomSQLiteQuery;
        }
    }

    public LiveData getStickerDataByType(int n10) {
        int n11 = 1;
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire("select * from sticker_data where type_id = ? ORDER BY sort desc", n11);
        long l10 = n10;
        roomSQLiteQuery.bindLong(n11, l10);
        InvalidationTracker invalidationTracker = this.__db.getInvalidationTracker();
        String[] stringArray = new String[]{"sticker_data"};
        StickerDataDao_Impl$13 stickerDataDao_Impl$13 = new StickerDataDao_Impl$13(this, roomSQLiteQuery);
        return invalidationTracker.createLiveData(stringArray, false, stickerDataDao_Impl$13);
    }

    public long insert(StickerData object) {
        this.__db.assertNotSuspendingTransaction();
        Object object2 = this.__db;
        ((RoomDatabase)object2).beginTransaction();
        try {
            object2 = this.__insertionAdapterOfStickerData_1;
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
            object = this.__insertionAdapterOfStickerData_1;
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
        StickerDataDao_Impl$11 stickerDataDao_Impl$11 = new StickerDataDao_Impl$11(this, list);
        return i0.o0(stickerDataDao_Impl$11);
    }

    public long replace(StickerData object) {
        this.__db.assertNotSuspendingTransaction();
        Object object2 = this.__db;
        ((RoomDatabase)object2).beginTransaction();
        try {
            object2 = this.__insertionAdapterOfStickerData;
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
            object = this.__insertionAdapterOfStickerData;
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
        StickerDataDao_Impl$10 stickerDataDao_Impl$10 = new StickerDataDao_Impl$10(this, list);
        return i0.o0(stickerDataDao_Impl$10);
    }

    public void update(StickerData object) {
        this.__db.assertNotSuspendingTransaction();
        Object object2 = this.__db;
        ((RoomDatabase)object2).beginTransaction();
        try {
            object2 = this.__updateAdapterOfStickerData;
            ((EntityDeletionOrUpdateAdapter)object2).handle(object);
            object = this.__db;
            ((RoomDatabase)object).setTransactionSuccessful();
            return;
        }
        finally {
            this.__db.endTransaction();
        }
    }

    public int updateStickerPath(String object, String object2) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatement = this.__preparedStmtOfUpdateStickerPath.acquire();
        int n10 = 1;
        if (object == null) {
            supportSQLiteStatement.bindNull(n10);
        } else {
            supportSQLiteStatement.bindString(n10, (String)object);
        }
        int n11 = 2;
        if (object2 == null) {
            supportSQLiteStatement.bindNull(n11);
        } else {
            supportSQLiteStatement.bindString(n11, (String)object2);
        }
        object = this.__db;
        ((RoomDatabase)object).beginTransaction();
        try {
            n11 = supportSQLiteStatement.executeUpdateDelete();
            object2 = this.__db;
            ((RoomDatabase)object2).setTransactionSuccessful();
            return n11;
        }
        finally {
            this.__db.endTransaction();
            this.__preparedStmtOfUpdateStickerPath.release(supportSQLiteStatement);
        }
    }
}

