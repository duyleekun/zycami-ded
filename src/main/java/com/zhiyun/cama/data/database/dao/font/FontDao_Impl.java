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
import com.zhiyun.cama.data.database.dao.font.FontDao;
import com.zhiyun.cama.data.database.dao.font.FontDao_Impl$1;
import com.zhiyun.cama.data.database.dao.font.FontDao_Impl$10;
import com.zhiyun.cama.data.database.dao.font.FontDao_Impl$11;
import com.zhiyun.cama.data.database.dao.font.FontDao_Impl$9;
import com.zhiyun.cama.data.database.model.ResourceData;
import com.zhiyun.cama.data.database.model.font.FontData;
import e.a.i0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class FontDao_Impl
implements FontDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter __deletionAdapterOfFontData;
    private final EntityInsertionAdapter __insertionAdapterOfFontData;
    private final EntityInsertionAdapter __insertionAdapterOfFontData_1;
    private final SharedSQLiteStatement __preparedStmtOfDeleteAll;
    private final SharedSQLiteStatement __preparedStmtOfDeleteAssetsFont;
    private final SharedSQLiteStatement __preparedStmtOfDeleteDownloadFont;
    private final SharedSQLiteStatement __preparedStmtOfUpdateFontPath;
    private final EntityDeletionOrUpdateAdapter __updateAdapterOfFontData;

    public FontDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        SharedSQLiteStatement sharedSQLiteStatement = new FontDao_Impl$1(this, roomDatabase);
        this.__insertionAdapterOfFontData = sharedSQLiteStatement;
        super(this, roomDatabase);
        this.__insertionAdapterOfFontData_1 = sharedSQLiteStatement;
        super(this, roomDatabase);
        this.__deletionAdapterOfFontData = sharedSQLiteStatement;
        super(this, roomDatabase);
        this.__updateAdapterOfFontData = sharedSQLiteStatement;
        super(this, roomDatabase);
        this.__preparedStmtOfDeleteAssetsFont = sharedSQLiteStatement;
        super(this, roomDatabase);
        this.__preparedStmtOfDeleteDownloadFont = sharedSQLiteStatement;
        super(this, roomDatabase);
        this.__preparedStmtOfUpdateFontPath = sharedSQLiteStatement;
        super(this, roomDatabase);
        this.__preparedStmtOfDeleteAll = sharedSQLiteStatement;
    }

    public static /* synthetic */ RoomDatabase access$000(FontDao_Impl fontDao_Impl) {
        return fontDao_Impl.__db;
    }

    public static /* synthetic */ EntityInsertionAdapter access$100(FontDao_Impl fontDao_Impl) {
        return fontDao_Impl.__insertionAdapterOfFontData;
    }

    public static /* synthetic */ EntityInsertionAdapter access$200(FontDao_Impl fontDao_Impl) {
        return fontDao_Impl.__insertionAdapterOfFontData_1;
    }

    public static List getRequiredConverters() {
        return Collections.emptyList();
    }

    public void delete(FontData object) {
        this.__db.assertNotSuspendingTransaction();
        Object object2 = this.__db;
        ((RoomDatabase)object2).beginTransaction();
        try {
            object2 = this.__deletionAdapterOfFontData;
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
            object2 = this.__deletionAdapterOfFontData;
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

    public void deleteAssetsFont() {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatement = this.__preparedStmtOfDeleteAssetsFont.acquire();
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
            this.__preparedStmtOfDeleteAssetsFont.release(supportSQLiteStatement);
        }
    }

    public void deleteDownloadFont() {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatement = this.__preparedStmtOfDeleteDownloadFont.acquire();
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
            this.__preparedStmtOfDeleteDownloadFont.release(supportSQLiteStatement);
        }
    }

    public LiveData getAllFontData() {
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire("SELECT `font_data`.`size` AS `size`, `font_data`.`path` AS `path`, `font_data`.`hash` AS `hash`, `font_data`.`thumb` AS `thumb`, `font_data`.`requiredPrime` AS `requiredPrime`, `font_data`.`id` AS `id`, `font_data`.`res_id` AS `res_id`, `font_data`.`label` AS `label`, `font_data`.`label_tw` AS `label_tw`, `font_data`.`label_en` AS `label_en`, `font_data`.`sort` AS `sort` FROM font_data ORDER BY sort desc", 0);
        InvalidationTracker invalidationTracker = this.__db.getInvalidationTracker();
        String[] stringArray = new String[]{"font_data"};
        FontDao_Impl$11 fontDao_Impl$11 = new FontDao_Impl$11(this, roomSQLiteQuery);
        return invalidationTracker.createLiveData(stringArray, false, fontDao_Impl$11);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public List getFontDataByResId(int n10) {
        int n11 = 1;
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire("select * from font_data where res_id = ? ORDER BY sort desc", n11);
        int n12 = n10;
        long l10 = n10;
        roomSQLiteQuery.bindLong(n11, l10);
        this.__db.assertNotSuspendingTransaction();
        Object object = this.__db;
        n11 = 0;
        int n13 = 0;
        Object object2 = null;
        Cursor cursor = DBUtil.query((RoomDatabase)object, roomSQLiteQuery, false, null);
        object = "size";
        try {
            n12 = CursorUtil.getColumnIndexOrThrow(cursor, (String)object);
            String string2 = "path";
            int n14 = CursorUtil.getColumnIndexOrThrow(cursor, string2);
            String string3 = "hash";
            int n15 = CursorUtil.getColumnIndexOrThrow(cursor, string3);
            String string4 = "thumb";
            int n16 = CursorUtil.getColumnIndexOrThrow(cursor, string4);
            String string5 = "requiredPrime";
            int n17 = CursorUtil.getColumnIndexOrThrow(cursor, string5);
            String string6 = "id";
            int n18 = CursorUtil.getColumnIndexOrThrow(cursor, string6);
            String string7 = "res_id";
            int n19 = CursorUtil.getColumnIndexOrThrow(cursor, string7);
            String string8 = "label";
            int n20 = CursorUtil.getColumnIndexOrThrow(cursor, string8);
            String string9 = "label_tw";
            int n21 = CursorUtil.getColumnIndexOrThrow(cursor, string9);
            String string10 = "label_en";
            int n22 = CursorUtil.getColumnIndexOrThrow(cursor, string10);
            String string11 = "sort";
            int n23 = CursorUtil.getColumnIndexOrThrow(cursor, string11);
            n13 = cursor.getCount();
            ArrayList<Object> arrayList = new ArrayList<Object>(n13);
            while ((n13 = (int)(cursor.moveToNext() ? 1 : 0)) != 0) {
                String string12;
                String string13;
                String string14;
                String string15;
                String string16;
                String string17;
                long l11 = cursor.getLong(n12);
                n13 = (int)(cursor.isNull(n14) ? 1 : 0);
                if (n13 != 0) {
                    string17 = null;
                } else {
                    object2 = cursor.getString(n14);
                    string17 = object2;
                }
                n13 = (int)(cursor.isNull(n15) ? 1 : 0);
                if (n13 != 0) {
                    string16 = null;
                } else {
                    object2 = cursor.getString(n15);
                    string16 = object2;
                }
                n13 = (int)(cursor.isNull(n16) ? 1 : 0);
                if (n13 != 0) {
                    string15 = null;
                } else {
                    object2 = cursor.getString(n16);
                    string15 = object2;
                }
                int n24 = cursor.getInt(n17);
                long l12 = cursor.getLong(n19);
                n13 = (int)(cursor.isNull(n20) ? 1 : 0);
                if (n13 != 0) {
                    string14 = null;
                } else {
                    object2 = cursor.getString(n20);
                    string14 = object2;
                }
                n13 = (int)(cursor.isNull(n21) ? 1 : 0);
                if (n13 != 0) {
                    string13 = null;
                } else {
                    object2 = cursor.getString(n21);
                    string13 = object2;
                }
                n13 = (int)(cursor.isNull(n22) ? 1 : 0);
                if (n13 != 0) {
                    string12 = null;
                } else {
                    object2 = cursor.getString(n22);
                    string12 = object2;
                }
                int n25 = cursor.getInt(n23);
                object2 = new FontData(l12, string14, string13, string12, n25, l11, string17, string16, string15, n24);
                long l13 = cursor.getLong(n18);
                ((ResourceData)object2).setId(l13);
                arrayList.add(object2);
            }
            return arrayList;
        }
        finally {
            cursor.close();
            roomSQLiteQuery.release();
        }
    }

    public long insert(FontData object) {
        this.__db.assertNotSuspendingTransaction();
        Object object2 = this.__db;
        ((RoomDatabase)object2).beginTransaction();
        try {
            object2 = this.__insertionAdapterOfFontData_1;
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
            object = this.__insertionAdapterOfFontData_1;
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
        FontDao_Impl$10 fontDao_Impl$10 = new FontDao_Impl$10(this, list);
        return i0.o0(fontDao_Impl$10);
    }

    public long replace(FontData object) {
        this.__db.assertNotSuspendingTransaction();
        Object object2 = this.__db;
        ((RoomDatabase)object2).beginTransaction();
        try {
            object2 = this.__insertionAdapterOfFontData;
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
            object = this.__insertionAdapterOfFontData;
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
        FontDao_Impl$9 fontDao_Impl$9 = new FontDao_Impl$9(this, list);
        return i0.o0(fontDao_Impl$9);
    }

    public void update(FontData object) {
        this.__db.assertNotSuspendingTransaction();
        Object object2 = this.__db;
        ((RoomDatabase)object2).beginTransaction();
        try {
            object2 = this.__updateAdapterOfFontData;
            ((EntityDeletionOrUpdateAdapter)object2).handle(object);
            object = this.__db;
            ((RoomDatabase)object).setTransactionSuccessful();
            return;
        }
        finally {
            this.__db.endTransaction();
        }
    }

    public int updateFontPath(String object, String object2) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatement = this.__preparedStmtOfUpdateFontPath.acquire();
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
            this.__preparedStmtOfUpdateFontPath.release(supportSQLiteStatement);
        }
    }
}

