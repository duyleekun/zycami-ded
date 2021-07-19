/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.database.Cursor
 */
package com.zhiyun.editortemplate.data.database.dao.template;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.RxRoom;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import com.zhiyun.editortemplate.data.database.dao.template.G_SortResultDao;
import com.zhiyun.editortemplate.data.database.dao.template.G_SortResultDao_Impl$1;
import com.zhiyun.editortemplate.data.database.dao.template.G_SortResultDao_Impl$5;
import com.zhiyun.editortemplate.data.database.dao.template.G_SortResultDao_Impl$6;
import com.zhiyun.editortemplate.data.database.dao.template.G_SortResultDao_Impl$7;
import com.zhiyun.editortemplate.data.database.dao.template.G_SortResultDao_Impl$8;
import com.zhiyun.editortemplate.data.database.dao.template.G_SortResultDao_Impl$9;
import com.zhiyun.editortemplate.data.database.model.TypeListConverters;
import com.zhiyun.editortemplate.data.database.model.template.templatelist.SortResult;
import e.a.i0;
import e.a.z;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

public final class G_SortResultDao_Impl
implements G_SortResultDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter __deletionAdapterOfSortResult;
    private final EntityInsertionAdapter __insertionAdapterOfSortResult;
    private final EntityInsertionAdapter __insertionAdapterOfSortResult_1;
    private final EntityDeletionOrUpdateAdapter __updateAdapterOfSortResult;

    public G_SortResultDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        SharedSQLiteStatement sharedSQLiteStatement = new G_SortResultDao_Impl$1(this, roomDatabase);
        this.__insertionAdapterOfSortResult = sharedSQLiteStatement;
        super(this, roomDatabase);
        this.__insertionAdapterOfSortResult_1 = sharedSQLiteStatement;
        super(this, roomDatabase);
        this.__deletionAdapterOfSortResult = sharedSQLiteStatement;
        super(this, roomDatabase);
        this.__updateAdapterOfSortResult = sharedSQLiteStatement;
    }

    public static /* synthetic */ RoomDatabase access$000(G_SortResultDao_Impl g_SortResultDao_Impl) {
        return g_SortResultDao_Impl.__db;
    }

    public static /* synthetic */ EntityInsertionAdapter access$100(G_SortResultDao_Impl g_SortResultDao_Impl) {
        return g_SortResultDao_Impl.__insertionAdapterOfSortResult;
    }

    public static /* synthetic */ EntityInsertionAdapter access$200(G_SortResultDao_Impl g_SortResultDao_Impl) {
        return g_SortResultDao_Impl.__insertionAdapterOfSortResult_1;
    }

    public static List getRequiredConverters() {
        return Collections.emptyList();
    }

    public void delete(SortResult object) {
        this.__db.assertNotSuspendingTransaction();
        Object object2 = this.__db;
        ((RoomDatabase)object2).beginTransaction();
        try {
            object2 = this.__deletionAdapterOfSortResult;
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
            object2 = this.__deletionAdapterOfSortResult;
            ((EntityDeletionOrUpdateAdapter)object2).handleMultiple((Iterable)object);
            object = this.__db;
            ((RoomDatabase)object).setTransactionSuccessful();
            return;
        }
        finally {
            this.__db.endTransaction();
        }
    }

    public SortResult getSortResult(String object) {
        Object object2;
        RoomSQLiteQuery roomSQLiteQuery;
        block17: {
            Object object3;
            int n10;
            int n11;
            String string2;
            block20: {
                boolean bl2;
                int n12;
                block19: {
                    int n13;
                    block18: {
                        String string3;
                        n13 = 1;
                        roomSQLiteQuery = RoomSQLiteQuery.acquire("SELECT * FROM SortResult WHERE page_type = ?", n13);
                        if (object == null) {
                            roomSQLiteQuery.bindNull(n13);
                        } else {
                            roomSQLiteQuery.bindString(n13, (String)object);
                        }
                        this.__db.assertNotSuspendingTransaction();
                        object = this.__db;
                        n13 = 0;
                        object2 = null;
                        object = DBUtil.query((RoomDatabase)object, roomSQLiteQuery, false, null);
                        string2 = "page_type";
                        try {
                            n13 = CursorUtil.getColumnIndexOrThrow((Cursor)object, string2);
                            string3 = "next_page";
                        }
                        catch (Throwable throwable) {
                            object.close();
                            roomSQLiteQuery.release();
                            throw throwable;
                        }
                        n11 = CursorUtil.getColumnIndexOrThrow((Cursor)object, string3);
                        String string4 = "count";
                        n10 = CursorUtil.getColumnIndexOrThrow((Cursor)object, string4);
                        object3 = "id_list";
                        n12 = CursorUtil.getColumnIndexOrThrow((Cursor)object, (String)object3);
                        bl2 = object.moveToFirst();
                        if (!bl2) break block17;
                        bl2 = object.isNull(n13);
                        if (!bl2) break block18;
                        n13 = 0;
                        string2 = null;
                        break block19;
                    }
                    string2 = object.getString(n13);
                }
                n11 = object.getInt(n11);
                n10 = object.getInt(n10);
                bl2 = object.isNull(n12);
                if (bl2) break block20;
                object2 = object.getString(n12);
            }
            object2 = TypeListConverters.stringToLongList(object2);
            object2 = object3 = new SortResult(string2, n11, n10, (List)object2);
        }
        object.close();
        roomSQLiteQuery.release();
        return object2;
    }

    public LiveData getSortResult_LiveData(String object) {
        int n10 = 1;
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire("SELECT * FROM SortResult WHERE page_type = ?", n10);
        if (object == null) {
            roomSQLiteQuery.bindNull(n10);
        } else {
            roomSQLiteQuery.bindString(n10, (String)object);
        }
        object = this.__db.getInvalidationTracker();
        String[] stringArray = new String[]{"SortResult"};
        G_SortResultDao_Impl$8 g_SortResultDao_Impl$8 = new G_SortResultDao_Impl$8(this, roomSQLiteQuery);
        return ((InvalidationTracker)object).createLiveData(stringArray, false, g_SortResultDao_Impl$8);
    }

    public z getSortResult_Observable(String object) {
        int n10 = 1;
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire("SELECT * FROM SortResult WHERE page_type = ?", n10);
        if (object == null) {
            roomSQLiteQuery.bindNull(n10);
        } else {
            roomSQLiteQuery.bindString(n10, (String)object);
        }
        object = this.__db;
        String[] stringArray = new String[]{"SortResult"};
        G_SortResultDao_Impl$9 g_SortResultDao_Impl$9 = new G_SortResultDao_Impl$9(this, roomSQLiteQuery);
        return RxRoom.createObservable((RoomDatabase)object, false, stringArray, g_SortResultDao_Impl$9);
    }

    public i0 getSortResult_Single(String object) {
        int n10 = 1;
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire("SELECT * FROM SortResult WHERE page_type = ?", n10);
        if (object == null) {
            roomSQLiteQuery.bindNull(n10);
        } else {
            roomSQLiteQuery.bindString(n10, (String)object);
        }
        object = new G_SortResultDao_Impl$7(this, roomSQLiteQuery);
        return RxRoom.createSingle((Callable)object);
    }

    public long insert(SortResult object) {
        this.__db.assertNotSuspendingTransaction();
        Object object2 = this.__db;
        ((RoomDatabase)object2).beginTransaction();
        try {
            object2 = this.__insertionAdapterOfSortResult_1;
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
            object = this.__insertionAdapterOfSortResult_1;
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
        G_SortResultDao_Impl$6 g_SortResultDao_Impl$6 = new G_SortResultDao_Impl$6(this, list);
        return i0.o0(g_SortResultDao_Impl$6);
    }

    public long replace(SortResult object) {
        this.__db.assertNotSuspendingTransaction();
        Object object2 = this.__db;
        ((RoomDatabase)object2).beginTransaction();
        try {
            object2 = this.__insertionAdapterOfSortResult;
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
            object = this.__insertionAdapterOfSortResult;
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
        G_SortResultDao_Impl$5 g_SortResultDao_Impl$5 = new G_SortResultDao_Impl$5(this, list);
        return i0.o0(g_SortResultDao_Impl$5);
    }

    public void update(SortResult object) {
        this.__db.assertNotSuspendingTransaction();
        Object object2 = this.__db;
        ((RoomDatabase)object2).beginTransaction();
        try {
            object2 = this.__updateAdapterOfSortResult;
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

