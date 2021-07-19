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
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateMusicDao;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateMusicDao_Impl$1;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateMusicDao_Impl$5;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateMusicDao_Impl$6;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateMusicDao_Impl$7;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateMusicDao_Impl$8;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateMusicDao_Impl$9;
import com.zhiyun.editortemplate.data.database.dao.template.TemplateMusicDao;
import com.zhiyun.editortemplate.data.database.model.template.config.TemplateMusic;
import e.a.i0;
import e.a.z;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class G_TemplateMusicDao_Impl
implements G_TemplateMusicDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter __deletionAdapterOfTemplateMusic;
    private final EntityInsertionAdapter __insertionAdapterOfTemplateMusic;
    private final EntityInsertionAdapter __insertionAdapterOfTemplateMusic_1;
    private final EntityDeletionOrUpdateAdapter __updateAdapterOfTemplateMusic;

    public G_TemplateMusicDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        SharedSQLiteStatement sharedSQLiteStatement = new G_TemplateMusicDao_Impl$1(this, roomDatabase);
        this.__insertionAdapterOfTemplateMusic = sharedSQLiteStatement;
        super(this, roomDatabase);
        this.__insertionAdapterOfTemplateMusic_1 = sharedSQLiteStatement;
        super(this, roomDatabase);
        this.__deletionAdapterOfTemplateMusic = sharedSQLiteStatement;
        super(this, roomDatabase);
        this.__updateAdapterOfTemplateMusic = sharedSQLiteStatement;
    }

    public static /* synthetic */ RoomDatabase access$000(G_TemplateMusicDao_Impl g_TemplateMusicDao_Impl) {
        return g_TemplateMusicDao_Impl.__db;
    }

    public static /* synthetic */ EntityInsertionAdapter access$100(G_TemplateMusicDao_Impl g_TemplateMusicDao_Impl) {
        return g_TemplateMusicDao_Impl.__insertionAdapterOfTemplateMusic;
    }

    public static /* synthetic */ EntityInsertionAdapter access$200(G_TemplateMusicDao_Impl g_TemplateMusicDao_Impl) {
        return g_TemplateMusicDao_Impl.__insertionAdapterOfTemplateMusic_1;
    }

    public static List getRequiredConverters() {
        return Collections.emptyList();
    }

    public void delete(TemplateMusic object) {
        this.__db.assertNotSuspendingTransaction();
        Object object2 = this.__db;
        ((RoomDatabase)object2).beginTransaction();
        try {
            object2 = this.__deletionAdapterOfTemplateMusic;
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
            object2 = this.__deletionAdapterOfTemplateMusic;
            ((EntityDeletionOrUpdateAdapter)object2).handleMultiple((Iterable)object);
            object = this.__db;
            ((RoomDatabase)object).setTransactionSuccessful();
            return;
        }
        finally {
            this.__db.endTransaction();
        }
    }

    public List getTemplateMusics(long l10) {
        Object object = this;
        int n10 = 1;
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire("SELECT * FROM TemplateMusic where temp_id = ? ", n10);
        roomSQLiteQuery.bindLong(n10, l10);
        this.__db.assertNotSuspendingTransaction();
        Object object2 = this.__db;
        int n11 = 0;
        ArrayList<Object> arrayList = null;
        int n12 = 0;
        String string2 = null;
        Cursor cursor = DBUtil.query((RoomDatabase)object2, roomSQLiteQuery, false, null);
        object2 = "id";
        try {
            int n13 = CursorUtil.getColumnIndexOrThrow(cursor, (String)object2);
            String string3 = "temp_id";
            int n14 = CursorUtil.getColumnIndexOrThrow(cursor, string3);
            String string4 = "name";
            int n15 = CursorUtil.getColumnIndexOrThrow(cursor, string4);
            String string5 = "title";
            int n16 = CursorUtil.getColumnIndexOrThrow(cursor, string5);
            String string6 = "attach_time";
            int n17 = CursorUtil.getColumnIndexOrThrow(cursor, string6);
            String string7 = "start_time";
            int n18 = CursorUtil.getColumnIndexOrThrow(cursor, string7);
            String string8 = "end_time";
            int n19 = CursorUtil.getColumnIndexOrThrow(cursor, string8);
            String string9 = "timebase";
            int n20 = CursorUtil.getColumnIndexOrThrow(cursor, string9);
            String string10 = "volume";
            int n21 = CursorUtil.getColumnIndexOrThrow(cursor, string10);
            String string11 = "mute";
            int n22 = CursorUtil.getColumnIndexOrThrow(cursor, string11);
            String string12 = "local_source";
            n10 = CursorUtil.getColumnIndexOrThrow(cursor, string12);
            arrayList = "customer_uuid";
            n11 = CursorUtil.getColumnIndexOrThrow(cursor, (String)((Object)arrayList));
            string2 = "fade_in_start_time";
            n12 = CursorUtil.getColumnIndexOrThrow(cursor, string2);
            object = "fade_in_end_time";
            int n23 = CursorUtil.getColumnIndexOrThrow(cursor, (String)object);
            return n23;
        }
        finally {
            RoomSQLiteQuery roomSQLiteQuery2 = roomSQLiteQuery;
        }
    }

    public LiveData getTemplateMusics_LiveData(long l10) {
        int n10 = 1;
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire("SELECT * FROM TemplateMusic where temp_id = ? ", n10);
        roomSQLiteQuery.bindLong(n10, l10);
        InvalidationTracker invalidationTracker = this.__db.getInvalidationTracker();
        String[] stringArray = new String[]{"TemplateMusic"};
        G_TemplateMusicDao_Impl$8 g_TemplateMusicDao_Impl$8 = new G_TemplateMusicDao_Impl$8(this, roomSQLiteQuery);
        return invalidationTracker.createLiveData(stringArray, false, g_TemplateMusicDao_Impl$8);
    }

    public z getTemplateMusics_Observable(long l10) {
        int n10 = 1;
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire("SELECT * FROM TemplateMusic where temp_id = ? ", n10);
        roomSQLiteQuery.bindLong(n10, l10);
        RoomDatabase roomDatabase = this.__db;
        String[] stringArray = new String[]{"TemplateMusic"};
        G_TemplateMusicDao_Impl$9 g_TemplateMusicDao_Impl$9 = new G_TemplateMusicDao_Impl$9(this, roomSQLiteQuery);
        return RxRoom.createObservable(roomDatabase, false, stringArray, g_TemplateMusicDao_Impl$9);
    }

    public i0 getTemplateMusics_Single(long l10) {
        int n10 = 1;
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire("SELECT * FROM TemplateMusic where temp_id = ? ", n10);
        roomSQLiteQuery.bindLong(n10, l10);
        G_TemplateMusicDao_Impl$7 g_TemplateMusicDao_Impl$7 = new G_TemplateMusicDao_Impl$7(this, roomSQLiteQuery);
        return RxRoom.createSingle(g_TemplateMusicDao_Impl$7);
    }

    public long insert(TemplateMusic object) {
        this.__db.assertNotSuspendingTransaction();
        Object object2 = this.__db;
        ((RoomDatabase)object2).beginTransaction();
        try {
            object2 = this.__insertionAdapterOfTemplateMusic_1;
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
            object = this.__insertionAdapterOfTemplateMusic_1;
            list = ((EntityInsertionAdapter)object).insertAndReturnIdsList(list);
            object = this.__db;
            ((RoomDatabase)object).setTransactionSuccessful();
            return list;
        }
        finally {
            this.__db.endTransaction();
        }
    }

    public void insertMusic(List object, long l10) {
        RoomDatabase roomDatabase = this.__db;
        roomDatabase.beginTransaction();
        try {
            TemplateMusicDao.super.insertMusic((List)object, l10);
            object = this.__db;
            ((RoomDatabase)object).setTransactionSuccessful();
            return;
        }
        finally {
            this.__db.endTransaction();
        }
    }

    public i0 insertSingle(List list) {
        G_TemplateMusicDao_Impl$6 g_TemplateMusicDao_Impl$6 = new G_TemplateMusicDao_Impl$6(this, list);
        return i0.o0(g_TemplateMusicDao_Impl$6);
    }

    public long replace(TemplateMusic object) {
        this.__db.assertNotSuspendingTransaction();
        Object object2 = this.__db;
        ((RoomDatabase)object2).beginTransaction();
        try {
            object2 = this.__insertionAdapterOfTemplateMusic;
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
            object = this.__insertionAdapterOfTemplateMusic;
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
        G_TemplateMusicDao_Impl$5 g_TemplateMusicDao_Impl$5 = new G_TemplateMusicDao_Impl$5(this, list);
        return i0.o0(g_TemplateMusicDao_Impl$5);
    }

    public void update(TemplateMusic object) {
        this.__db.assertNotSuspendingTransaction();
        Object object2 = this.__db;
        ((RoomDatabase)object2).beginTransaction();
        try {
            object2 = this.__updateAdapterOfTemplateMusic;
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

