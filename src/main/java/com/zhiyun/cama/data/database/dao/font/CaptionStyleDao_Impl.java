/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.database.Cursor
 */
package com.zhiyun.cama.data.database.dao.font;

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
import com.zhiyun.cama.data.database.dao.font.CaptionStyleDao;
import com.zhiyun.cama.data.database.dao.font.CaptionStyleDao_Impl$1;
import com.zhiyun.cama.data.database.dao.font.CaptionStyleDao_Impl$10;
import com.zhiyun.cama.data.database.dao.font.CaptionStyleDao_Impl$11;
import com.zhiyun.cama.data.database.dao.font.CaptionStyleDao_Impl$9;
import com.zhiyun.cama.data.database.model.font.CaptionStyleData;
import e.a.i0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class CaptionStyleDao_Impl
implements CaptionStyleDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter __deletionAdapterOfCaptionStyleData;
    private final EntityInsertionAdapter __insertionAdapterOfCaptionStyleData;
    private final EntityInsertionAdapter __insertionAdapterOfCaptionStyleData_1;
    private final SharedSQLiteStatement __preparedStmtOfDeleteAll;
    private final SharedSQLiteStatement __preparedStmtOfDeleteAssetsCaptionStyle;
    private final SharedSQLiteStatement __preparedStmtOfDeleteDownloadCaptionStyle;
    private final SharedSQLiteStatement __preparedStmtOfUpdateCaptionPath;
    private final EntityDeletionOrUpdateAdapter __updateAdapterOfCaptionStyleData;

    public CaptionStyleDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        SharedSQLiteStatement sharedSQLiteStatement = new CaptionStyleDao_Impl$1(this, roomDatabase);
        this.__insertionAdapterOfCaptionStyleData = sharedSQLiteStatement;
        super(this, roomDatabase);
        this.__insertionAdapterOfCaptionStyleData_1 = sharedSQLiteStatement;
        super(this, roomDatabase);
        this.__deletionAdapterOfCaptionStyleData = sharedSQLiteStatement;
        super(this, roomDatabase);
        this.__updateAdapterOfCaptionStyleData = sharedSQLiteStatement;
        super(this, roomDatabase);
        this.__preparedStmtOfDeleteAssetsCaptionStyle = sharedSQLiteStatement;
        super(this, roomDatabase);
        this.__preparedStmtOfDeleteDownloadCaptionStyle = sharedSQLiteStatement;
        super(this, roomDatabase);
        this.__preparedStmtOfUpdateCaptionPath = sharedSQLiteStatement;
        super(this, roomDatabase);
        this.__preparedStmtOfDeleteAll = sharedSQLiteStatement;
    }

    public static /* synthetic */ RoomDatabase access$000(CaptionStyleDao_Impl captionStyleDao_Impl) {
        return captionStyleDao_Impl.__db;
    }

    public static /* synthetic */ EntityInsertionAdapter access$100(CaptionStyleDao_Impl captionStyleDao_Impl) {
        return captionStyleDao_Impl.__insertionAdapterOfCaptionStyleData;
    }

    public static /* synthetic */ EntityInsertionAdapter access$200(CaptionStyleDao_Impl captionStyleDao_Impl) {
        return captionStyleDao_Impl.__insertionAdapterOfCaptionStyleData_1;
    }

    public static List getRequiredConverters() {
        return Collections.emptyList();
    }

    public void delete(CaptionStyleData object) {
        this.__db.assertNotSuspendingTransaction();
        Object object2 = this.__db;
        ((RoomDatabase)object2).beginTransaction();
        try {
            object2 = this.__deletionAdapterOfCaptionStyleData;
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
            object2 = this.__deletionAdapterOfCaptionStyleData;
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

    public void deleteAssetsCaptionStyle() {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatement = this.__preparedStmtOfDeleteAssetsCaptionStyle.acquire();
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
            this.__preparedStmtOfDeleteAssetsCaptionStyle.release(supportSQLiteStatement);
        }
    }

    public void deleteDownloadCaptionStyle() {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatement = this.__preparedStmtOfDeleteDownloadCaptionStyle.acquire();
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
            this.__preparedStmtOfDeleteDownloadCaptionStyle.release(supportSQLiteStatement);
        }
    }

    public LiveData getAllCaptionStyleData() {
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire("SELECT `caption_style_data`.`size` AS `size`, `caption_style_data`.`path` AS `path`, `caption_style_data`.`hash` AS `hash`, `caption_style_data`.`thumb` AS `thumb`, `caption_style_data`.`licensePath` AS `licensePath`, `caption_style_data`.`licenseName` AS `licenseName`, `caption_style_data`.`requiredPrime` AS `requiredPrime`, `caption_style_data`.`id` AS `id`, `caption_style_data`.`res_id` AS `res_id`, `caption_style_data`.`label` AS `label`, `caption_style_data`.`label_tw` AS `label_tw`, `caption_style_data`.`label_en` AS `label_en`, `caption_style_data`.`sort` AS `sort` FROM caption_style_data ORDER BY sort desc", 0);
        InvalidationTracker invalidationTracker = this.__db.getInvalidationTracker();
        String[] stringArray = new String[]{"caption_style_data"};
        CaptionStyleDao_Impl$11 captionStyleDao_Impl$11 = new CaptionStyleDao_Impl$11(this, roomSQLiteQuery);
        return invalidationTracker.createLiveData(stringArray, false, captionStyleDao_Impl$11);
    }

    public List getCaptionStyleDataByResId(int n10) {
        ArrayList<Object> arrayList = this;
        int n11 = 1;
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire("select * from caption_style_data where res_id = ? ORDER BY sort desc", n11);
        int n12 = n10;
        long l10 = n10;
        roomSQLiteQuery.bindLong(n11, l10);
        this.__db.assertNotSuspendingTransaction();
        Object object = this.__db;
        n11 = 0;
        int n13 = 0;
        String string2 = null;
        Cursor cursor = DBUtil.query((RoomDatabase)object, roomSQLiteQuery, false, null);
        object = "size";
        try {
            n12 = CursorUtil.getColumnIndexOrThrow(cursor, (String)object);
            String string3 = "path";
            int n14 = CursorUtil.getColumnIndexOrThrow(cursor, string3);
            String string4 = "hash";
            int n15 = CursorUtil.getColumnIndexOrThrow(cursor, string4);
            String string5 = "thumb";
            int n16 = CursorUtil.getColumnIndexOrThrow(cursor, string5);
            String string6 = "licensePath";
            int n17 = CursorUtil.getColumnIndexOrThrow(cursor, string6);
            String string7 = "licenseName";
            int n18 = CursorUtil.getColumnIndexOrThrow(cursor, string7);
            String string8 = "requiredPrime";
            int n19 = CursorUtil.getColumnIndexOrThrow(cursor, string8);
            String string9 = "id";
            int n20 = CursorUtil.getColumnIndexOrThrow(cursor, string9);
            String string10 = "res_id";
            int n21 = CursorUtil.getColumnIndexOrThrow(cursor, string10);
            String string11 = "label";
            int n22 = CursorUtil.getColumnIndexOrThrow(cursor, string11);
            String string12 = "label_tw";
            int n23 = CursorUtil.getColumnIndexOrThrow(cursor, string12);
            String string13 = "label_en";
            int n24 = CursorUtil.getColumnIndexOrThrow(cursor, string13);
            string2 = "sort";
            n13 = CursorUtil.getColumnIndexOrThrow(cursor, string2);
            return n13;
        }
        finally {
            RoomSQLiteQuery roomSQLiteQuery2 = roomSQLiteQuery;
        }
    }

    public long insert(CaptionStyleData object) {
        this.__db.assertNotSuspendingTransaction();
        Object object2 = this.__db;
        ((RoomDatabase)object2).beginTransaction();
        try {
            object2 = this.__insertionAdapterOfCaptionStyleData_1;
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
            object = this.__insertionAdapterOfCaptionStyleData_1;
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
        CaptionStyleDao_Impl$10 captionStyleDao_Impl$10 = new CaptionStyleDao_Impl$10(this, list);
        return i0.o0(captionStyleDao_Impl$10);
    }

    public long replace(CaptionStyleData object) {
        this.__db.assertNotSuspendingTransaction();
        Object object2 = this.__db;
        ((RoomDatabase)object2).beginTransaction();
        try {
            object2 = this.__insertionAdapterOfCaptionStyleData;
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
            object = this.__insertionAdapterOfCaptionStyleData;
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
        CaptionStyleDao_Impl$9 captionStyleDao_Impl$9 = new CaptionStyleDao_Impl$9(this, list);
        return i0.o0(captionStyleDao_Impl$9);
    }

    public void update(CaptionStyleData object) {
        this.__db.assertNotSuspendingTransaction();
        Object object2 = this.__db;
        ((RoomDatabase)object2).beginTransaction();
        try {
            object2 = this.__updateAdapterOfCaptionStyleData;
            ((EntityDeletionOrUpdateAdapter)object2).handle(object);
            object = this.__db;
            ((RoomDatabase)object).setTransactionSuccessful();
            return;
        }
        finally {
            this.__db.endTransaction();
        }
    }

    public int updateCaptionPath(String object, String object2) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatement = this.__preparedStmtOfUpdateCaptionPath.acquire();
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
            this.__preparedStmtOfUpdateCaptionPath.release(supportSQLiteStatement);
        }
    }
}

