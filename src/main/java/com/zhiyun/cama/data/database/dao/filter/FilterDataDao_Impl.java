/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.database.Cursor
 */
package com.zhiyun.cama.data.database.dao.filter;

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
import com.zhiyun.cama.data.database.dao.filter.FilterDataDao;
import com.zhiyun.cama.data.database.dao.filter.FilterDataDao_Impl$1;
import com.zhiyun.cama.data.database.dao.filter.FilterDataDao_Impl$10;
import com.zhiyun.cama.data.database.dao.filter.FilterDataDao_Impl$11;
import com.zhiyun.cama.data.database.dao.filter.FilterDataDao_Impl$12;
import com.zhiyun.cama.data.database.model.filter.FilterData;
import e.a.i0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class FilterDataDao_Impl
implements FilterDataDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter __deletionAdapterOfFilterData;
    private final EntityInsertionAdapter __insertionAdapterOfFilterData;
    private final EntityInsertionAdapter __insertionAdapterOfFilterData_1;
    private final SharedSQLiteStatement __preparedStmtOfDeleteAll;
    private final SharedSQLiteStatement __preparedStmtOfDeleteAssetsFilter;
    private final SharedSQLiteStatement __preparedStmtOfDeleteDownloadFilter;
    private final SharedSQLiteStatement __preparedStmtOfUpdateFilterPath;
    private final SharedSQLiteStatement __preparedStmtOfUpdateFilterThumbPath;
    private final EntityDeletionOrUpdateAdapter __updateAdapterOfFilterData;

    public FilterDataDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        SharedSQLiteStatement sharedSQLiteStatement = new FilterDataDao_Impl$1(this, roomDatabase);
        this.__insertionAdapterOfFilterData = sharedSQLiteStatement;
        super(this, roomDatabase);
        this.__insertionAdapterOfFilterData_1 = sharedSQLiteStatement;
        super(this, roomDatabase);
        this.__deletionAdapterOfFilterData = sharedSQLiteStatement;
        super(this, roomDatabase);
        this.__updateAdapterOfFilterData = sharedSQLiteStatement;
        super(this, roomDatabase);
        this.__preparedStmtOfDeleteAssetsFilter = sharedSQLiteStatement;
        super(this, roomDatabase);
        this.__preparedStmtOfDeleteDownloadFilter = sharedSQLiteStatement;
        super(this, roomDatabase);
        this.__preparedStmtOfUpdateFilterPath = sharedSQLiteStatement;
        super(this, roomDatabase);
        this.__preparedStmtOfUpdateFilterThumbPath = sharedSQLiteStatement;
        super(this, roomDatabase);
        this.__preparedStmtOfDeleteAll = sharedSQLiteStatement;
    }

    public static /* synthetic */ RoomDatabase access$000(FilterDataDao_Impl filterDataDao_Impl) {
        return filterDataDao_Impl.__db;
    }

    public static /* synthetic */ EntityInsertionAdapter access$100(FilterDataDao_Impl filterDataDao_Impl) {
        return filterDataDao_Impl.__insertionAdapterOfFilterData;
    }

    public static /* synthetic */ EntityInsertionAdapter access$200(FilterDataDao_Impl filterDataDao_Impl) {
        return filterDataDao_Impl.__insertionAdapterOfFilterData_1;
    }

    public static List getRequiredConverters() {
        return Collections.emptyList();
    }

    public void delete(FilterData object) {
        this.__db.assertNotSuspendingTransaction();
        Object object2 = this.__db;
        ((RoomDatabase)object2).beginTransaction();
        try {
            object2 = this.__deletionAdapterOfFilterData;
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
            object2 = this.__deletionAdapterOfFilterData;
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

    public void deleteAssetsFilter() {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatement = this.__preparedStmtOfDeleteAssetsFilter.acquire();
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
            this.__preparedStmtOfDeleteAssetsFilter.release(supportSQLiteStatement);
        }
    }

    public void deleteDownloadFilter() {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatement = this.__preparedStmtOfDeleteDownloadFilter.acquire();
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
            this.__preparedStmtOfDeleteDownloadFilter.release(supportSQLiteStatement);
        }
    }

    public LiveData getAllFilterData() {
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire("SELECT `filter_data`.`type_id` AS `type_id`, `filter_data`.`size` AS `size`, `filter_data`.`path` AS `path`, `filter_data`.`thumb` AS `thumb`, `filter_data`.`hash` AS `hash`, `filter_data`.`main_sort` AS `main_sort`, `filter_data`.`licensePath` AS `licensePath`, `filter_data`.`licenseName` AS `licenseName`, `filter_data`.`requiredPrime` AS `requiredPrime`, `filter_data`.`id` AS `id`, `filter_data`.`res_id` AS `res_id`, `filter_data`.`label` AS `label`, `filter_data`.`label_tw` AS `label_tw`, `filter_data`.`label_en` AS `label_en`, `filter_data`.`sort` AS `sort` FROM filter_data ORDER BY main_sort desc,sort desc", 0);
        InvalidationTracker invalidationTracker = this.__db.getInvalidationTracker();
        String[] stringArray = new String[]{"filter_data"};
        FilterDataDao_Impl$12 filterDataDao_Impl$12 = new FilterDataDao_Impl$12(this, roomSQLiteQuery);
        return invalidationTracker.createLiveData(stringArray, false, filterDataDao_Impl$12);
    }

    public FilterData getFilterDataByHash(String string2) {
        Object object = this;
        Object object2 = string2;
        int n10 = 1;
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire("select * from filter_data where hash = ?", n10);
        if (string2 == null) {
            roomSQLiteQuery.bindNull(n10);
        } else {
            roomSQLiteQuery.bindString(n10, string2);
        }
        ((FilterDataDao_Impl)object).__db.assertNotSuspendingTransaction();
        object2 = ((FilterDataDao_Impl)object).__db;
        n10 = 0;
        int n11 = 0;
        Object object3 = null;
        Cursor cursor = DBUtil.query((RoomDatabase)object2, roomSQLiteQuery, false, null);
        object2 = "type_id";
        try {
            int n12 = CursorUtil.getColumnIndexOrThrow(cursor, (String)object2);
            String string3 = "size";
            int n13 = CursorUtil.getColumnIndexOrThrow(cursor, string3);
            String string4 = "path";
            int n14 = CursorUtil.getColumnIndexOrThrow(cursor, string4);
            String string5 = "thumb";
            int n15 = CursorUtil.getColumnIndexOrThrow(cursor, string5);
            String string6 = "hash";
            int n16 = CursorUtil.getColumnIndexOrThrow(cursor, string6);
            String string7 = "main_sort";
            int n17 = CursorUtil.getColumnIndexOrThrow(cursor, string7);
            String string8 = "licensePath";
            int n18 = CursorUtil.getColumnIndexOrThrow(cursor, string8);
            String string9 = "licenseName";
            int n19 = CursorUtil.getColumnIndexOrThrow(cursor, string9);
            String string10 = "requiredPrime";
            int n20 = CursorUtil.getColumnIndexOrThrow(cursor, string10);
            String string11 = "id";
            int n21 = CursorUtil.getColumnIndexOrThrow(cursor, string11);
            String string12 = "res_id";
            int n22 = CursorUtil.getColumnIndexOrThrow(cursor, string12);
            String string13 = "label";
            int n23 = CursorUtil.getColumnIndexOrThrow(cursor, string13);
            object3 = "label_tw";
            n11 = CursorUtil.getColumnIndexOrThrow(cursor, (String)object3);
            object = "label_en";
            int n24 = CursorUtil.getColumnIndexOrThrow(cursor, (String)object);
            return n24;
        }
        finally {
            RoomSQLiteQuery roomSQLiteQuery2 = roomSQLiteQuery;
        }
    }

    public List getFilterDataByResId(int n10) {
        Object object = this;
        int n11 = 1;
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire("select * from filter_data where res_id = ? ORDER BY sort desc", n11);
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
            String string4 = "path";
            int n15 = CursorUtil.getColumnIndexOrThrow(cursor, string4);
            String string5 = "thumb";
            int n16 = CursorUtil.getColumnIndexOrThrow(cursor, string5);
            String string6 = "hash";
            int n17 = CursorUtil.getColumnIndexOrThrow(cursor, string6);
            String string7 = "main_sort";
            int n18 = CursorUtil.getColumnIndexOrThrow(cursor, string7);
            String string8 = "licensePath";
            int n19 = CursorUtil.getColumnIndexOrThrow(cursor, string8);
            String string9 = "licenseName";
            int n20 = CursorUtil.getColumnIndexOrThrow(cursor, string9);
            String string10 = "requiredPrime";
            int n21 = CursorUtil.getColumnIndexOrThrow(cursor, string10);
            ArrayList<Object> arrayList = "id";
            int n22 = CursorUtil.getColumnIndexOrThrow(cursor, (String)((Object)arrayList));
            String string11 = "res_id";
            int n23 = CursorUtil.getColumnIndexOrThrow(cursor, string11);
            String string12 = "label";
            int n24 = CursorUtil.getColumnIndexOrThrow(cursor, string12);
            string2 = "label_tw";
            n13 = CursorUtil.getColumnIndexOrThrow(cursor, string2);
            object = "label_en";
            int n25 = CursorUtil.getColumnIndexOrThrow(cursor, (String)object);
            return n25;
        }
        finally {
            RoomSQLiteQuery roomSQLiteQuery2 = roomSQLiteQuery;
        }
    }

    public long insert(FilterData object) {
        this.__db.assertNotSuspendingTransaction();
        Object object2 = this.__db;
        ((RoomDatabase)object2).beginTransaction();
        try {
            object2 = this.__insertionAdapterOfFilterData_1;
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
            object = this.__insertionAdapterOfFilterData_1;
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
        FilterDataDao_Impl$11 filterDataDao_Impl$11 = new FilterDataDao_Impl$11(this, list);
        return i0.o0(filterDataDao_Impl$11);
    }

    public long replace(FilterData object) {
        this.__db.assertNotSuspendingTransaction();
        Object object2 = this.__db;
        ((RoomDatabase)object2).beginTransaction();
        try {
            object2 = this.__insertionAdapterOfFilterData;
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
            object = this.__insertionAdapterOfFilterData;
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
        FilterDataDao_Impl$10 filterDataDao_Impl$10 = new FilterDataDao_Impl$10(this, list);
        return i0.o0(filterDataDao_Impl$10);
    }

    public void update(FilterData object) {
        this.__db.assertNotSuspendingTransaction();
        Object object2 = this.__db;
        ((RoomDatabase)object2).beginTransaction();
        try {
            object2 = this.__updateAdapterOfFilterData;
            ((EntityDeletionOrUpdateAdapter)object2).handle(object);
            object = this.__db;
            ((RoomDatabase)object).setTransactionSuccessful();
            return;
        }
        finally {
            this.__db.endTransaction();
        }
    }

    public int updateFilterPath(String object, String object2) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatement = this.__preparedStmtOfUpdateFilterPath.acquire();
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
            this.__preparedStmtOfUpdateFilterPath.release(supportSQLiteStatement);
        }
    }

    public void updateFilterThumbPath(String object, String string2) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatement = this.__preparedStmtOfUpdateFilterThumbPath.acquire();
        int n10 = 1;
        if (object == null) {
            supportSQLiteStatement.bindNull(n10);
        } else {
            supportSQLiteStatement.bindString(n10, (String)object);
        }
        int n11 = 2;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n11);
        } else {
            supportSQLiteStatement.bindString(n11, string2);
        }
        object = this.__db;
        ((RoomDatabase)object).beginTransaction();
        try {
            supportSQLiteStatement.executeUpdateDelete();
            object = this.__db;
            ((RoomDatabase)object).setTransactionSuccessful();
            return;
        }
        finally {
            this.__db.endTransaction();
            this.__preparedStmtOfUpdateFilterThumbPath.release(supportSQLiteStatement);
        }
    }
}

