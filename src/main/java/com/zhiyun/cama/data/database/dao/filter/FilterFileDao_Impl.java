/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.database.dao.filter;

import androidx.lifecycle.LiveData;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.zhiyun.cama.data.database.dao.filter.FilterFileDao;
import com.zhiyun.cama.data.database.dao.filter.FilterFileDao_Impl$1;
import com.zhiyun.cama.data.database.dao.filter.FilterFileDao_Impl$6;
import com.zhiyun.cama.data.database.dao.filter.FilterFileDao_Impl$7;
import com.zhiyun.cama.data.database.dao.filter.FilterFileDao_Impl$8;
import com.zhiyun.cama.data.database.model.filter.FilterFile;
import e.a.i0;
import java.util.Collections;
import java.util.List;

public final class FilterFileDao_Impl
implements FilterFileDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter __deletionAdapterOfFilterFile;
    private final EntityInsertionAdapter __insertionAdapterOfFilterFile;
    private final EntityInsertionAdapter __insertionAdapterOfFilterFile_1;
    private final SharedSQLiteStatement __preparedStmtOfDeleteAll;
    private final EntityDeletionOrUpdateAdapter __updateAdapterOfFilterFile;

    public FilterFileDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        SharedSQLiteStatement sharedSQLiteStatement = new FilterFileDao_Impl$1(this, roomDatabase);
        this.__insertionAdapterOfFilterFile = sharedSQLiteStatement;
        super(this, roomDatabase);
        this.__insertionAdapterOfFilterFile_1 = sharedSQLiteStatement;
        super(this, roomDatabase);
        this.__deletionAdapterOfFilterFile = sharedSQLiteStatement;
        super(this, roomDatabase);
        this.__updateAdapterOfFilterFile = sharedSQLiteStatement;
        super(this, roomDatabase);
        this.__preparedStmtOfDeleteAll = sharedSQLiteStatement;
    }

    public static /* synthetic */ RoomDatabase access$000(FilterFileDao_Impl filterFileDao_Impl) {
        return filterFileDao_Impl.__db;
    }

    public static /* synthetic */ EntityInsertionAdapter access$100(FilterFileDao_Impl filterFileDao_Impl) {
        return filterFileDao_Impl.__insertionAdapterOfFilterFile;
    }

    public static /* synthetic */ EntityInsertionAdapter access$200(FilterFileDao_Impl filterFileDao_Impl) {
        return filterFileDao_Impl.__insertionAdapterOfFilterFile_1;
    }

    public static List getRequiredConverters() {
        return Collections.emptyList();
    }

    public void delete(FilterFile object) {
        this.__db.assertNotSuspendingTransaction();
        Object object2 = this.__db;
        ((RoomDatabase)object2).beginTransaction();
        try {
            object2 = this.__deletionAdapterOfFilterFile;
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
            object2 = this.__deletionAdapterOfFilterFile;
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

    public LiveData getAllFilterFile() {
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire("SELECT `ext_lic_url`, `ext_lic_name`, `ext_lic_path`, `filter_file`.`hash` AS `hash`, `filter_file`.`name` AS `name`, `filter_file`.`category` AS `category`, `filter_file`.`mime` AS `mime`, `filter_file`.`size` AS `size`, `filter_file`.`url` AS `url`, `filter_file`.`path` AS `path`, `filter_file`.`download_timestamp` AS `download_timestamp` FROM filter_file", 0);
        InvalidationTracker invalidationTracker = this.__db.getInvalidationTracker();
        String[] stringArray = new String[]{"filter_file"};
        FilterFileDao_Impl$8 filterFileDao_Impl$8 = new FilterFileDao_Impl$8(this, roomSQLiteQuery);
        return invalidationTracker.createLiveData(stringArray, false, filterFileDao_Impl$8);
    }

    public long insert(FilterFile object) {
        this.__db.assertNotSuspendingTransaction();
        Object object2 = this.__db;
        ((RoomDatabase)object2).beginTransaction();
        try {
            object2 = this.__insertionAdapterOfFilterFile_1;
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
            object = this.__insertionAdapterOfFilterFile_1;
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
        FilterFileDao_Impl$7 filterFileDao_Impl$7 = new FilterFileDao_Impl$7(this, list);
        return i0.o0(filterFileDao_Impl$7);
    }

    public long replace(FilterFile object) {
        this.__db.assertNotSuspendingTransaction();
        Object object2 = this.__db;
        ((RoomDatabase)object2).beginTransaction();
        try {
            object2 = this.__insertionAdapterOfFilterFile;
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
            object = this.__insertionAdapterOfFilterFile;
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
        FilterFileDao_Impl$6 filterFileDao_Impl$6 = new FilterFileDao_Impl$6(this, list);
        return i0.o0(filterFileDao_Impl$6);
    }

    public void update(FilterFile object) {
        this.__db.assertNotSuspendingTransaction();
        Object object2 = this.__db;
        ((RoomDatabase)object2).beginTransaction();
        try {
            object2 = this.__updateAdapterOfFilterFile;
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

