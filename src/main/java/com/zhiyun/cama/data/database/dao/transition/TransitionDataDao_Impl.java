/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.database.Cursor
 */
package com.zhiyun.cama.data.database.dao.transition;

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
import com.zhiyun.cama.data.database.dao.transition.TransitionDataDao;
import com.zhiyun.cama.data.database.dao.transition.TransitionDataDao_Impl$1;
import com.zhiyun.cama.data.database.dao.transition.TransitionDataDao_Impl$10;
import com.zhiyun.cama.data.database.dao.transition.TransitionDataDao_Impl$11;
import com.zhiyun.cama.data.database.dao.transition.TransitionDataDao_Impl$9;
import com.zhiyun.cama.data.database.model.transition.TransitionData;
import e.a.i0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class TransitionDataDao_Impl
implements TransitionDataDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter __deletionAdapterOfTransitionData;
    private final EntityInsertionAdapter __insertionAdapterOfTransitionData;
    private final EntityInsertionAdapter __insertionAdapterOfTransitionData_1;
    private final SharedSQLiteStatement __preparedStmtOfDeleteAll;
    private final SharedSQLiteStatement __preparedStmtOfDeleteAssetsTransition;
    private final SharedSQLiteStatement __preparedStmtOfDeleteDownloadTransition;
    private final SharedSQLiteStatement __preparedStmtOfUpdateTransitionPath;
    private final EntityDeletionOrUpdateAdapter __updateAdapterOfTransitionData;

    public TransitionDataDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        SharedSQLiteStatement sharedSQLiteStatement = new TransitionDataDao_Impl$1(this, roomDatabase);
        this.__insertionAdapterOfTransitionData = sharedSQLiteStatement;
        super(this, roomDatabase);
        this.__insertionAdapterOfTransitionData_1 = sharedSQLiteStatement;
        super(this, roomDatabase);
        this.__deletionAdapterOfTransitionData = sharedSQLiteStatement;
        super(this, roomDatabase);
        this.__updateAdapterOfTransitionData = sharedSQLiteStatement;
        super(this, roomDatabase);
        this.__preparedStmtOfDeleteAssetsTransition = sharedSQLiteStatement;
        super(this, roomDatabase);
        this.__preparedStmtOfDeleteDownloadTransition = sharedSQLiteStatement;
        super(this, roomDatabase);
        this.__preparedStmtOfUpdateTransitionPath = sharedSQLiteStatement;
        super(this, roomDatabase);
        this.__preparedStmtOfDeleteAll = sharedSQLiteStatement;
    }

    public static /* synthetic */ RoomDatabase access$000(TransitionDataDao_Impl transitionDataDao_Impl) {
        return transitionDataDao_Impl.__db;
    }

    public static /* synthetic */ EntityInsertionAdapter access$100(TransitionDataDao_Impl transitionDataDao_Impl) {
        return transitionDataDao_Impl.__insertionAdapterOfTransitionData;
    }

    public static /* synthetic */ EntityInsertionAdapter access$200(TransitionDataDao_Impl transitionDataDao_Impl) {
        return transitionDataDao_Impl.__insertionAdapterOfTransitionData_1;
    }

    public static List getRequiredConverters() {
        return Collections.emptyList();
    }

    public void delete(TransitionData object) {
        this.__db.assertNotSuspendingTransaction();
        Object object2 = this.__db;
        ((RoomDatabase)object2).beginTransaction();
        try {
            object2 = this.__deletionAdapterOfTransitionData;
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
            object2 = this.__deletionAdapterOfTransitionData;
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

    public void deleteAssetsTransition() {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatement = this.__preparedStmtOfDeleteAssetsTransition.acquire();
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
            this.__preparedStmtOfDeleteAssetsTransition.release(supportSQLiteStatement);
        }
    }

    public void deleteDownloadTransition() {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatement = this.__preparedStmtOfDeleteDownloadTransition.acquire();
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
            this.__preparedStmtOfDeleteDownloadTransition.release(supportSQLiteStatement);
        }
    }

    public LiveData getAllTransitionData() {
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire("SELECT `transition_data`.`size` AS `size`, `transition_data`.`path` AS `path`, `transition_data`.`hash` AS `hash`, `transition_data`.`thumb` AS `thumb`, `transition_data`.`littleThumb` AS `littleThumb`, `transition_data`.`transitionType` AS `transitionType`, `transition_data`.`licensePath` AS `licensePath`, `transition_data`.`licenseName` AS `licenseName`, `transition_data`.`requiredPrime` AS `requiredPrime`, `transition_data`.`id` AS `id`, `transition_data`.`res_id` AS `res_id`, `transition_data`.`label` AS `label`, `transition_data`.`label_tw` AS `label_tw`, `transition_data`.`label_en` AS `label_en`, `transition_data`.`sort` AS `sort` FROM transition_data ORDER BY sort desc", 0);
        InvalidationTracker invalidationTracker = this.__db.getInvalidationTracker();
        String[] stringArray = new String[]{"transition_data"};
        TransitionDataDao_Impl$11 transitionDataDao_Impl$11 = new TransitionDataDao_Impl$11(this, roomSQLiteQuery);
        return invalidationTracker.createLiveData(stringArray, false, transitionDataDao_Impl$11);
    }

    public List getTransitionDataByResId(int n10) {
        Object object = this;
        int n11 = 1;
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire("select * from transition_data where res_id = ? ORDER BY sort desc", n11);
        int n12 = n10;
        long l10 = n10;
        roomSQLiteQuery.bindLong(n11, l10);
        this.__db.assertNotSuspendingTransaction();
        Object object2 = this.__db;
        n11 = 0;
        int n13 = 0;
        String string2 = null;
        Cursor cursor = DBUtil.query((RoomDatabase)object2, roomSQLiteQuery, false, null);
        object2 = "size";
        try {
            n12 = CursorUtil.getColumnIndexOrThrow(cursor, (String)object2);
            String string3 = "path";
            int n14 = CursorUtil.getColumnIndexOrThrow(cursor, string3);
            String string4 = "hash";
            int n15 = CursorUtil.getColumnIndexOrThrow(cursor, string4);
            String string5 = "thumb";
            int n16 = CursorUtil.getColumnIndexOrThrow(cursor, string5);
            String string6 = "littleThumb";
            int n17 = CursorUtil.getColumnIndexOrThrow(cursor, string6);
            String string7 = "transitionType";
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

    public long insert(TransitionData object) {
        this.__db.assertNotSuspendingTransaction();
        Object object2 = this.__db;
        ((RoomDatabase)object2).beginTransaction();
        try {
            object2 = this.__insertionAdapterOfTransitionData_1;
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
            object = this.__insertionAdapterOfTransitionData_1;
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
        TransitionDataDao_Impl$10 transitionDataDao_Impl$10 = new TransitionDataDao_Impl$10(this, list);
        return i0.o0(transitionDataDao_Impl$10);
    }

    public long replace(TransitionData object) {
        this.__db.assertNotSuspendingTransaction();
        Object object2 = this.__db;
        ((RoomDatabase)object2).beginTransaction();
        try {
            object2 = this.__insertionAdapterOfTransitionData;
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
            object = this.__insertionAdapterOfTransitionData;
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
        TransitionDataDao_Impl$9 transitionDataDao_Impl$9 = new TransitionDataDao_Impl$9(this, list);
        return i0.o0(transitionDataDao_Impl$9);
    }

    public void update(TransitionData object) {
        this.__db.assertNotSuspendingTransaction();
        Object object2 = this.__db;
        ((RoomDatabase)object2).beginTransaction();
        try {
            object2 = this.__updateAdapterOfTransitionData;
            ((EntityDeletionOrUpdateAdapter)object2).handle(object);
            object = this.__db;
            ((RoomDatabase)object).setTransactionSuccessful();
            return;
        }
        finally {
            this.__db.endTransaction();
        }
    }

    public int updateTransitionPath(String object, String object2) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatement = this.__preparedStmtOfUpdateTransitionPath.acquire();
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
            this.__preparedStmtOfUpdateTransitionPath.release(supportSQLiteStatement);
        }
    }
}

