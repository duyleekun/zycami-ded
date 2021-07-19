/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.database.dao.transition;

import androidx.lifecycle.LiveData;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.zhiyun.cama.data.database.dao.transition.TransitionFileDao;
import com.zhiyun.cama.data.database.dao.transition.TransitionFileDao_Impl$1;
import com.zhiyun.cama.data.database.dao.transition.TransitionFileDao_Impl$7;
import com.zhiyun.cama.data.database.dao.transition.TransitionFileDao_Impl$8;
import com.zhiyun.cama.data.database.dao.transition.TransitionFileDao_Impl$9;
import com.zhiyun.cama.data.database.model.transition.TransitionFile;
import e.a.i0;
import java.util.Collections;
import java.util.List;

public final class TransitionFileDao_Impl
implements TransitionFileDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter __deletionAdapterOfTransitionFile;
    private final EntityInsertionAdapter __insertionAdapterOfTransitionFile;
    private final EntityInsertionAdapter __insertionAdapterOfTransitionFile_1;
    private final SharedSQLiteStatement __preparedStmtOfDeleteAll;
    private final SharedSQLiteStatement __preparedStmtOfDeleteAllAssetsFile;
    private final EntityDeletionOrUpdateAdapter __updateAdapterOfTransitionFile;

    public TransitionFileDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        SharedSQLiteStatement sharedSQLiteStatement = new TransitionFileDao_Impl$1(this, roomDatabase);
        this.__insertionAdapterOfTransitionFile = sharedSQLiteStatement;
        super(this, roomDatabase);
        this.__insertionAdapterOfTransitionFile_1 = sharedSQLiteStatement;
        super(this, roomDatabase);
        this.__deletionAdapterOfTransitionFile = sharedSQLiteStatement;
        super(this, roomDatabase);
        this.__updateAdapterOfTransitionFile = sharedSQLiteStatement;
        super(this, roomDatabase);
        this.__preparedStmtOfDeleteAll = sharedSQLiteStatement;
        super(this, roomDatabase);
        this.__preparedStmtOfDeleteAllAssetsFile = sharedSQLiteStatement;
    }

    public static /* synthetic */ RoomDatabase access$000(TransitionFileDao_Impl transitionFileDao_Impl) {
        return transitionFileDao_Impl.__db;
    }

    public static /* synthetic */ EntityInsertionAdapter access$100(TransitionFileDao_Impl transitionFileDao_Impl) {
        return transitionFileDao_Impl.__insertionAdapterOfTransitionFile;
    }

    public static /* synthetic */ EntityInsertionAdapter access$200(TransitionFileDao_Impl transitionFileDao_Impl) {
        return transitionFileDao_Impl.__insertionAdapterOfTransitionFile_1;
    }

    public static List getRequiredConverters() {
        return Collections.emptyList();
    }

    public void delete(TransitionFile object) {
        this.__db.assertNotSuspendingTransaction();
        Object object2 = this.__db;
        ((RoomDatabase)object2).beginTransaction();
        try {
            object2 = this.__deletionAdapterOfTransitionFile;
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
            object2 = this.__deletionAdapterOfTransitionFile;
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

    public LiveData getAllTransitionFile() {
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire("select `ext_lic_url`, `ext_lic_name`, `ext_lic_path`, `transition_file`.`hash` AS `hash`, `transition_file`.`name` AS `name`, `transition_file`.`category` AS `category`, `transition_file`.`mime` AS `mime`, `transition_file`.`size` AS `size`, `transition_file`.`url` AS `url`, `transition_file`.`path` AS `path`, `transition_file`.`download_timestamp` AS `download_timestamp` from transition_file", 0);
        InvalidationTracker invalidationTracker = this.__db.getInvalidationTracker();
        String[] stringArray = new String[]{"transition_file"};
        TransitionFileDao_Impl$9 transitionFileDao_Impl$9 = new TransitionFileDao_Impl$9(this, roomSQLiteQuery);
        return invalidationTracker.createLiveData(stringArray, false, transitionFileDao_Impl$9);
    }

    public long insert(TransitionFile object) {
        this.__db.assertNotSuspendingTransaction();
        Object object2 = this.__db;
        ((RoomDatabase)object2).beginTransaction();
        try {
            object2 = this.__insertionAdapterOfTransitionFile_1;
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
            object = this.__insertionAdapterOfTransitionFile_1;
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
        TransitionFileDao_Impl$8 transitionFileDao_Impl$8 = new TransitionFileDao_Impl$8(this, list);
        return i0.o0(transitionFileDao_Impl$8);
    }

    public long replace(TransitionFile object) {
        this.__db.assertNotSuspendingTransaction();
        Object object2 = this.__db;
        ((RoomDatabase)object2).beginTransaction();
        try {
            object2 = this.__insertionAdapterOfTransitionFile;
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
            object = this.__insertionAdapterOfTransitionFile;
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
        TransitionFileDao_Impl$7 transitionFileDao_Impl$7 = new TransitionFileDao_Impl$7(this, list);
        return i0.o0(transitionFileDao_Impl$7);
    }

    public void update(TransitionFile object) {
        this.__db.assertNotSuspendingTransaction();
        Object object2 = this.__db;
        ((RoomDatabase)object2).beginTransaction();
        try {
            object2 = this.__updateAdapterOfTransitionFile;
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

