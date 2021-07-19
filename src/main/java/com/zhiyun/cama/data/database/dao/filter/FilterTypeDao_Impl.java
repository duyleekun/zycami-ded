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
import com.zhiyun.cama.data.database.dao.filter.FilterTypeDao;
import com.zhiyun.cama.data.database.dao.filter.FilterTypeDao_Impl$1;
import com.zhiyun.cama.data.database.dao.filter.FilterTypeDao_Impl$10;
import com.zhiyun.cama.data.database.dao.filter.FilterTypeDao_Impl$8;
import com.zhiyun.cama.data.database.dao.filter.FilterTypeDao_Impl$9;
import com.zhiyun.cama.data.database.model.filter.FilterType;
import e.a.i0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class FilterTypeDao_Impl
implements FilterTypeDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter __deletionAdapterOfFilterType;
    private final EntityInsertionAdapter __insertionAdapterOfFilterType;
    private final EntityInsertionAdapter __insertionAdapterOfFilterType_1;
    private final SharedSQLiteStatement __preparedStmtOfDeleteAll;
    private final SharedSQLiteStatement __preparedStmtOfDeleteAssetsFilterType;
    private final SharedSQLiteStatement __preparedStmtOfDeleteDownloadFilterType;
    private final EntityDeletionOrUpdateAdapter __updateAdapterOfFilterType;

    public FilterTypeDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        SharedSQLiteStatement sharedSQLiteStatement = new FilterTypeDao_Impl$1(this, roomDatabase);
        this.__insertionAdapterOfFilterType = sharedSQLiteStatement;
        super(this, roomDatabase);
        this.__insertionAdapterOfFilterType_1 = sharedSQLiteStatement;
        super(this, roomDatabase);
        this.__deletionAdapterOfFilterType = sharedSQLiteStatement;
        super(this, roomDatabase);
        this.__updateAdapterOfFilterType = sharedSQLiteStatement;
        super(this, roomDatabase);
        this.__preparedStmtOfDeleteAssetsFilterType = sharedSQLiteStatement;
        super(this, roomDatabase);
        this.__preparedStmtOfDeleteDownloadFilterType = sharedSQLiteStatement;
        super(this, roomDatabase);
        this.__preparedStmtOfDeleteAll = sharedSQLiteStatement;
    }

    public static /* synthetic */ RoomDatabase access$000(FilterTypeDao_Impl filterTypeDao_Impl) {
        return filterTypeDao_Impl.__db;
    }

    public static /* synthetic */ EntityInsertionAdapter access$100(FilterTypeDao_Impl filterTypeDao_Impl) {
        return filterTypeDao_Impl.__insertionAdapterOfFilterType;
    }

    public static /* synthetic */ EntityInsertionAdapter access$200(FilterTypeDao_Impl filterTypeDao_Impl) {
        return filterTypeDao_Impl.__insertionAdapterOfFilterType_1;
    }

    public static List getRequiredConverters() {
        return Collections.emptyList();
    }

    public void delete(FilterType object) {
        this.__db.assertNotSuspendingTransaction();
        Object object2 = this.__db;
        ((RoomDatabase)object2).beginTransaction();
        try {
            object2 = this.__deletionAdapterOfFilterType;
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
            object2 = this.__deletionAdapterOfFilterType;
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

    public void deleteAssetsFilterType() {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatement = this.__preparedStmtOfDeleteAssetsFilterType.acquire();
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
            this.__preparedStmtOfDeleteAssetsFilterType.release(supportSQLiteStatement);
        }
    }

    public void deleteDownloadFilterType() {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatement = this.__preparedStmtOfDeleteDownloadFilterType.acquire();
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
            this.__preparedStmtOfDeleteDownloadFilterType.release(supportSQLiteStatement);
        }
    }

    public LiveData getAllFilterTypeData() {
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire("SELECT `filter_type`.`thumb` AS `thumb`, `filter_type`.`id` AS `id`, `filter_type`.`res_id` AS `res_id`, `filter_type`.`label` AS `label`, `filter_type`.`label_tw` AS `label_tw`, `filter_type`.`label_en` AS `label_en`, `filter_type`.`sort` AS `sort` FROM filter_type ORDER BY sort desc", 0);
        InvalidationTracker invalidationTracker = this.__db.getInvalidationTracker();
        String[] stringArray = new String[]{"filter_type"};
        FilterTypeDao_Impl$10 filterTypeDao_Impl$10 = new FilterTypeDao_Impl$10(this, roomSQLiteQuery);
        return invalidationTracker.createLiveData(stringArray, false, filterTypeDao_Impl$10);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public List getFilterTypeDataByResId(int n10) {
        int n11 = 1;
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire("select * from filter_type where res_id = ? ORDER BY sort desc", n11);
        long l10 = n10;
        roomSQLiteQuery.bindLong(n11, l10);
        this.__db.assertNotSuspendingTransaction();
        RoomDatabase roomDatabase = this.__db;
        n11 = 0;
        roomDatabase = DBUtil.query(roomDatabase, roomSQLiteQuery, false, null);
        String string2 = "thumb";
        try {
            n11 = CursorUtil.getColumnIndexOrThrow((Cursor)roomDatabase, string2);
            String string3 = "id";
            int n12 = CursorUtil.getColumnIndexOrThrow((Cursor)roomDatabase, string3);
            String string4 = "res_id";
            int n13 = CursorUtil.getColumnIndexOrThrow((Cursor)roomDatabase, string4);
            String string5 = "label";
            int n14 = CursorUtil.getColumnIndexOrThrow((Cursor)roomDatabase, string5);
            String string6 = "label_tw";
            int n15 = CursorUtil.getColumnIndexOrThrow((Cursor)roomDatabase, string6);
            String string7 = "label_en";
            int n16 = CursorUtil.getColumnIndexOrThrow((Cursor)roomDatabase, string7);
            String string8 = "sort";
            int n17 = CursorUtil.getColumnIndexOrThrow((Cursor)roomDatabase, string8);
            int n18 = roomDatabase.getCount();
            ArrayList<FilterType> arrayList = new ArrayList<FilterType>(n18);
            while ((n18 = (int)(roomDatabase.moveToNext() ? 1 : 0)) != 0) {
                String string9;
                FilterType filterType = new FilterType();
                int n19 = roomDatabase.isNull(n11);
                if (n19 != 0) {
                    n19 = 0;
                    string9 = null;
                } else {
                    string9 = roomDatabase.getString(n11);
                }
                filterType.setThumb(string9);
                long l11 = roomDatabase.getLong(n12);
                filterType.setId(l11);
                l11 = roomDatabase.getLong(n13);
                filterType.setResId(l11);
                n19 = roomDatabase.isNull(n14);
                if (n19 != 0) {
                    n19 = 0;
                    string9 = null;
                } else {
                    string9 = roomDatabase.getString(n14);
                }
                filterType.setLabel(string9);
                n19 = roomDatabase.isNull(n15);
                if (n19 != 0) {
                    n19 = 0;
                    string9 = null;
                } else {
                    string9 = roomDatabase.getString(n15);
                }
                filterType.setLabel_tw(string9);
                n19 = roomDatabase.isNull(n16);
                if (n19 != 0) {
                    n19 = 0;
                    string9 = null;
                } else {
                    string9 = roomDatabase.getString(n16);
                }
                filterType.setLabel_en(string9);
                n19 = roomDatabase.getInt(n17);
                filterType.setSort(n19);
                arrayList.add(filterType);
            }
            return arrayList;
        }
        finally {
            roomDatabase.close();
            roomSQLiteQuery.release();
        }
    }

    public long insert(FilterType object) {
        this.__db.assertNotSuspendingTransaction();
        Object object2 = this.__db;
        ((RoomDatabase)object2).beginTransaction();
        try {
            object2 = this.__insertionAdapterOfFilterType_1;
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
            object = this.__insertionAdapterOfFilterType_1;
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
        FilterTypeDao_Impl$9 filterTypeDao_Impl$9 = new FilterTypeDao_Impl$9(this, list);
        return i0.o0(filterTypeDao_Impl$9);
    }

    public long replace(FilterType object) {
        this.__db.assertNotSuspendingTransaction();
        Object object2 = this.__db;
        ((RoomDatabase)object2).beginTransaction();
        try {
            object2 = this.__insertionAdapterOfFilterType;
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
            object = this.__insertionAdapterOfFilterType;
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
        FilterTypeDao_Impl$8 filterTypeDao_Impl$8 = new FilterTypeDao_Impl$8(this, list);
        return i0.o0(filterTypeDao_Impl$8);
    }

    public void update(FilterType object) {
        this.__db.assertNotSuspendingTransaction();
        Object object2 = this.__db;
        ((RoomDatabase)object2).beginTransaction();
        try {
            object2 = this.__updateAdapterOfFilterType;
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

