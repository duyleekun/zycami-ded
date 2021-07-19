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
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateGlobalDao;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateGlobalDao_Impl$1;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateGlobalDao_Impl$5;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateGlobalDao_Impl$6;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateGlobalDao_Impl$7;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateGlobalDao_Impl$8;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateGlobalDao_Impl$9;
import com.zhiyun.editortemplate.data.database.dao.template.TemplateGlobalDao;
import com.zhiyun.editortemplate.data.database.model.template.config.TemplateGlobal;
import e.a.i0;
import e.a.z;
import java.util.Collections;
import java.util.List;

public final class G_TemplateGlobalDao_Impl
implements G_TemplateGlobalDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter __deletionAdapterOfTemplateGlobal;
    private final EntityInsertionAdapter __insertionAdapterOfTemplateGlobal;
    private final EntityInsertionAdapter __insertionAdapterOfTemplateGlobal_1;
    private final EntityDeletionOrUpdateAdapter __updateAdapterOfTemplateGlobal;

    public G_TemplateGlobalDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        SharedSQLiteStatement sharedSQLiteStatement = new G_TemplateGlobalDao_Impl$1(this, roomDatabase);
        this.__insertionAdapterOfTemplateGlobal = sharedSQLiteStatement;
        super(this, roomDatabase);
        this.__insertionAdapterOfTemplateGlobal_1 = sharedSQLiteStatement;
        super(this, roomDatabase);
        this.__deletionAdapterOfTemplateGlobal = sharedSQLiteStatement;
        super(this, roomDatabase);
        this.__updateAdapterOfTemplateGlobal = sharedSQLiteStatement;
    }

    public static /* synthetic */ RoomDatabase access$000(G_TemplateGlobalDao_Impl g_TemplateGlobalDao_Impl) {
        return g_TemplateGlobalDao_Impl.__db;
    }

    public static /* synthetic */ EntityInsertionAdapter access$100(G_TemplateGlobalDao_Impl g_TemplateGlobalDao_Impl) {
        return g_TemplateGlobalDao_Impl.__insertionAdapterOfTemplateGlobal;
    }

    public static /* synthetic */ EntityInsertionAdapter access$200(G_TemplateGlobalDao_Impl g_TemplateGlobalDao_Impl) {
        return g_TemplateGlobalDao_Impl.__insertionAdapterOfTemplateGlobal_1;
    }

    public static List getRequiredConverters() {
        return Collections.emptyList();
    }

    public void delete(TemplateGlobal object) {
        this.__db.assertNotSuspendingTransaction();
        Object object2 = this.__db;
        ((RoomDatabase)object2).beginTransaction();
        try {
            object2 = this.__deletionAdapterOfTemplateGlobal;
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
            object2 = this.__deletionAdapterOfTemplateGlobal;
            ((EntityDeletionOrUpdateAdapter)object2).handleMultiple((Iterable)object);
            object = this.__db;
            ((RoomDatabase)object).setTransactionSuccessful();
            return;
        }
        finally {
            this.__db.endTransaction();
        }
    }

    public TemplateGlobal getTemplateGlobal(long l10) {
        Object object = this;
        int bl2 = 1;
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire("SELECT * FROM TemplateGlobal where temp_id = ? ", bl2);
        roomSQLiteQuery.bindLong(bl2, l10);
        this.__db.assertNotSuspendingTransaction();
        Object object2 = this.__db;
        boolean bl3 = false;
        Object object3 = null;
        boolean bl4 = false;
        float f10 = 0.0f;
        Object object4 = null;
        Cursor cursor = DBUtil.query((RoomDatabase)object2, roomSQLiteQuery, false, null);
        object2 = "id";
        try {
            boolean bl5 = CursorUtil.getColumnIndexOrThrow(cursor, (String)object2);
            String string2 = "temp_id";
            int n10 = CursorUtil.getColumnIndexOrThrow(cursor, string2);
            String string3 = "temp_duration";
            int n11 = CursorUtil.getColumnIndexOrThrow(cursor, string3);
            String string4 = "temp_timebase";
            int n12 = CursorUtil.getColumnIndexOrThrow(cursor, string4);
            String string5 = "temp_render";
            int n13 = CursorUtil.getColumnIndexOrThrow(cursor, string5);
            String string6 = "temp_display_type";
            int n14 = CursorUtil.getColumnIndexOrThrow(cursor, string6);
            String string7 = "temp_volume";
            int n15 = CursorUtil.getColumnIndexOrThrow(cursor, string7);
            String string8 = "temp_mute";
            int n16 = CursorUtil.getColumnIndexOrThrow(cursor, string8);
            String string9 = "voice_enable";
            int n17 = CursorUtil.getColumnIndexOrThrow(cursor, string9);
            String string10 = "filter_enable";
            int n18 = CursorUtil.getColumnIndexOrThrow(cursor, string10);
            String string11 = "filter_name";
            bl2 = CursorUtil.getColumnIndexOrThrow(cursor, string11);
            object3 = "filter_local_source";
            int n19 = CursorUtil.getColumnIndexOrThrow(cursor, (String)object3);
            object4 = "filter_strength";
            int n20 = CursorUtil.getColumnIndexOrThrow(cursor, (String)object4);
            object = "effect_enable";
            int n21 = CursorUtil.getColumnIndexOrThrow(cursor, (String)object);
            return n21;
        }
        finally {
            RoomSQLiteQuery roomSQLiteQuery2 = roomSQLiteQuery;
        }
    }

    public LiveData getTemplateGlobal_LiveData(long l10) {
        int n10 = 1;
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire("SELECT * FROM TemplateGlobal where temp_id = ? ", n10);
        roomSQLiteQuery.bindLong(n10, l10);
        InvalidationTracker invalidationTracker = this.__db.getInvalidationTracker();
        String[] stringArray = new String[]{"TemplateGlobal"};
        G_TemplateGlobalDao_Impl$8 g_TemplateGlobalDao_Impl$8 = new G_TemplateGlobalDao_Impl$8(this, roomSQLiteQuery);
        return invalidationTracker.createLiveData(stringArray, false, g_TemplateGlobalDao_Impl$8);
    }

    public z getTemplateGlobal_Observable(long l10) {
        int n10 = 1;
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire("SELECT * FROM TemplateGlobal where temp_id = ? ", n10);
        roomSQLiteQuery.bindLong(n10, l10);
        RoomDatabase roomDatabase = this.__db;
        String[] stringArray = new String[]{"TemplateGlobal"};
        G_TemplateGlobalDao_Impl$9 g_TemplateGlobalDao_Impl$9 = new G_TemplateGlobalDao_Impl$9(this, roomSQLiteQuery);
        return RxRoom.createObservable(roomDatabase, false, stringArray, g_TemplateGlobalDao_Impl$9);
    }

    public i0 getTemplateGlobal_Single(long l10) {
        int n10 = 1;
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire("SELECT * FROM TemplateGlobal where temp_id = ? ", n10);
        roomSQLiteQuery.bindLong(n10, l10);
        G_TemplateGlobalDao_Impl$7 g_TemplateGlobalDao_Impl$7 = new G_TemplateGlobalDao_Impl$7(this, roomSQLiteQuery);
        return RxRoom.createSingle(g_TemplateGlobalDao_Impl$7);
    }

    public long insert(TemplateGlobal object) {
        this.__db.assertNotSuspendingTransaction();
        Object object2 = this.__db;
        ((RoomDatabase)object2).beginTransaction();
        try {
            object2 = this.__insertionAdapterOfTemplateGlobal_1;
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
            object = this.__insertionAdapterOfTemplateGlobal_1;
            list = ((EntityInsertionAdapter)object).insertAndReturnIdsList(list);
            object = this.__db;
            ((RoomDatabase)object).setTransactionSuccessful();
            return list;
        }
        finally {
            this.__db.endTransaction();
        }
    }

    public void insertGlobal(TemplateGlobal object) {
        RoomDatabase roomDatabase = this.__db;
        roomDatabase.beginTransaction();
        try {
            TemplateGlobalDao.super.insertGlobal((TemplateGlobal)object);
            object = this.__db;
            ((RoomDatabase)object).setTransactionSuccessful();
            return;
        }
        finally {
            this.__db.endTransaction();
        }
    }

    public i0 insertSingle(List list) {
        G_TemplateGlobalDao_Impl$6 g_TemplateGlobalDao_Impl$6 = new G_TemplateGlobalDao_Impl$6(this, list);
        return i0.o0(g_TemplateGlobalDao_Impl$6);
    }

    public long replace(TemplateGlobal object) {
        this.__db.assertNotSuspendingTransaction();
        Object object2 = this.__db;
        ((RoomDatabase)object2).beginTransaction();
        try {
            object2 = this.__insertionAdapterOfTemplateGlobal;
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
            object = this.__insertionAdapterOfTemplateGlobal;
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
        G_TemplateGlobalDao_Impl$5 g_TemplateGlobalDao_Impl$5 = new G_TemplateGlobalDao_Impl$5(this, list);
        return i0.o0(g_TemplateGlobalDao_Impl$5);
    }

    public void update(TemplateGlobal object) {
        this.__db.assertNotSuspendingTransaction();
        Object object2 = this.__db;
        ((RoomDatabase)object2).beginTransaction();
        try {
            object2 = this.__updateAdapterOfTemplateGlobal;
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

