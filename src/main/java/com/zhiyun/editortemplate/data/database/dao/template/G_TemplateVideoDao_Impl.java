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
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateVideoDao;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateVideoDao_Impl$1;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateVideoDao_Impl$10;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateVideoDao_Impl$11;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateVideoDao_Impl$12;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateVideoDao_Impl$5;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateVideoDao_Impl$6;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateVideoDao_Impl$7;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateVideoDao_Impl$8;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateVideoDao_Impl$9;
import com.zhiyun.editortemplate.data.database.dao.template.TemplateVideoDao;
import com.zhiyun.editortemplate.data.database.model.template.config.TemplateVideo;
import e.a.i0;
import e.a.z;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class G_TemplateVideoDao_Impl
implements G_TemplateVideoDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter __deletionAdapterOfTemplateVideo;
    private final EntityInsertionAdapter __insertionAdapterOfTemplateVideo;
    private final EntityInsertionAdapter __insertionAdapterOfTemplateVideo_1;
    private final EntityDeletionOrUpdateAdapter __updateAdapterOfTemplateVideo;

    public G_TemplateVideoDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        SharedSQLiteStatement sharedSQLiteStatement = new G_TemplateVideoDao_Impl$1(this, roomDatabase);
        this.__insertionAdapterOfTemplateVideo = sharedSQLiteStatement;
        super(this, roomDatabase);
        this.__insertionAdapterOfTemplateVideo_1 = sharedSQLiteStatement;
        super(this, roomDatabase);
        this.__deletionAdapterOfTemplateVideo = sharedSQLiteStatement;
        super(this, roomDatabase);
        this.__updateAdapterOfTemplateVideo = sharedSQLiteStatement;
    }

    public static /* synthetic */ RoomDatabase access$000(G_TemplateVideoDao_Impl g_TemplateVideoDao_Impl) {
        return g_TemplateVideoDao_Impl.__db;
    }

    public static /* synthetic */ EntityInsertionAdapter access$100(G_TemplateVideoDao_Impl g_TemplateVideoDao_Impl) {
        return g_TemplateVideoDao_Impl.__insertionAdapterOfTemplateVideo;
    }

    public static /* synthetic */ EntityInsertionAdapter access$200(G_TemplateVideoDao_Impl g_TemplateVideoDao_Impl) {
        return g_TemplateVideoDao_Impl.__insertionAdapterOfTemplateVideo_1;
    }

    public static List getRequiredConverters() {
        return Collections.emptyList();
    }

    public void delete(TemplateVideo object) {
        this.__db.assertNotSuspendingTransaction();
        Object object2 = this.__db;
        ((RoomDatabase)object2).beginTransaction();
        try {
            object2 = this.__deletionAdapterOfTemplateVideo;
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
            object2 = this.__deletionAdapterOfTemplateVideo;
            ((EntityDeletionOrUpdateAdapter)object2).handleMultiple((Iterable)object);
            object = this.__db;
            ((RoomDatabase)object).setTransactionSuccessful();
            return;
        }
        finally {
            this.__db.endTransaction();
        }
    }

    public List getTemplateVideos(long l10) {
        Object object = this;
        int n10 = 1;
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire("SELECT * FROM TemplateVideo where temp_id = ? ", n10);
        roomSQLiteQuery.bindLong(n10, l10);
        this.__db.assertNotSuspendingTransaction();
        ArrayList<Object> arrayList = this.__db;
        int n11 = 0;
        Object object2 = null;
        int n12 = 0;
        float f10 = 0.0f;
        Object object3 = null;
        Cursor cursor = DBUtil.query((RoomDatabase)((Object)arrayList), roomSQLiteQuery, false, null);
        arrayList = "id";
        try {
            int n13 = CursorUtil.getColumnIndexOrThrow(cursor, (String)((Object)arrayList));
            String string2 = "temp_id";
            int n14 = CursorUtil.getColumnIndexOrThrow(cursor, string2);
            String string3 = "timebase";
            int n15 = CursorUtil.getColumnIndexOrThrow(cursor, string3);
            String string4 = "start_time";
            int n16 = CursorUtil.getColumnIndexOrThrow(cursor, string4);
            String string5 = "end_time";
            int n17 = CursorUtil.getColumnIndexOrThrow(cursor, string5);
            String string6 = "duration";
            int n18 = CursorUtil.getColumnIndexOrThrow(cursor, string6);
            String string7 = "mute";
            int n19 = CursorUtil.getColumnIndexOrThrow(cursor, string7);
            String string8 = "volume";
            int n20 = CursorUtil.getColumnIndexOrThrow(cursor, string8);
            String string9 = "voice_enable";
            int n21 = CursorUtil.getColumnIndexOrThrow(cursor, string9);
            String string10 = "rate";
            int n22 = CursorUtil.getColumnIndexOrThrow(cursor, string10);
            String string11 = "rate_type";
            n10 = CursorUtil.getColumnIndexOrThrow(cursor, string11);
            object2 = "bezier_rate";
            n11 = CursorUtil.getColumnIndexOrThrow(cursor, (String)object2);
            object3 = "videoPath";
            n12 = CursorUtil.getColumnIndexOrThrow(cursor, (String)object3);
            object = "is_local_source";
            int n23 = CursorUtil.getColumnIndexOrThrow(cursor, (String)object);
            return n23;
        }
        finally {
            RoomSQLiteQuery roomSQLiteQuery2 = roomSQLiteQuery;
        }
    }

    public LiveData getTemplateVideos_LiveData(long l10) {
        int n10 = 1;
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire("SELECT * FROM TemplateVideo where temp_id = ? ", n10);
        roomSQLiteQuery.bindLong(n10, l10);
        InvalidationTracker invalidationTracker = this.__db.getInvalidationTracker();
        String[] stringArray = new String[]{"TemplateVideo"};
        G_TemplateVideoDao_Impl$8 g_TemplateVideoDao_Impl$8 = new G_TemplateVideoDao_Impl$8(this, roomSQLiteQuery);
        return invalidationTracker.createLiveData(stringArray, false, g_TemplateVideoDao_Impl$8);
    }

    public z getTemplateVideos_Observable(long l10) {
        int n10 = 1;
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire("SELECT * FROM TemplateVideo where temp_id = ? ", n10);
        roomSQLiteQuery.bindLong(n10, l10);
        RoomDatabase roomDatabase = this.__db;
        String[] stringArray = new String[]{"TemplateVideo"};
        G_TemplateVideoDao_Impl$9 g_TemplateVideoDao_Impl$9 = new G_TemplateVideoDao_Impl$9(this, roomSQLiteQuery);
        return RxRoom.createObservable(roomDatabase, false, stringArray, g_TemplateVideoDao_Impl$9);
    }

    public i0 getTemplateVideos_Single(long l10) {
        int n10 = 1;
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire("SELECT * FROM TemplateVideo where temp_id = ? ", n10);
        roomSQLiteQuery.bindLong(n10, l10);
        G_TemplateVideoDao_Impl$7 g_TemplateVideoDao_Impl$7 = new G_TemplateVideoDao_Impl$7(this, roomSQLiteQuery);
        return RxRoom.createSingle(g_TemplateVideoDao_Impl$7);
    }

    public long insert(TemplateVideo object) {
        this.__db.assertNotSuspendingTransaction();
        Object object2 = this.__db;
        ((RoomDatabase)object2).beginTransaction();
        try {
            object2 = this.__insertionAdapterOfTemplateVideo_1;
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
            object = this.__insertionAdapterOfTemplateVideo_1;
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
        G_TemplateVideoDao_Impl$6 g_TemplateVideoDao_Impl$6 = new G_TemplateVideoDao_Impl$6(this, list);
        return i0.o0(g_TemplateVideoDao_Impl$6);
    }

    public void insertTemplateVideo(List object, long l10) {
        RoomDatabase roomDatabase = this.__db;
        roomDatabase.beginTransaction();
        try {
            TemplateVideoDao.super.insertTemplateVideo((List)object, l10);
            object = this.__db;
            ((RoomDatabase)object).setTransactionSuccessful();
            return;
        }
        finally {
            this.__db.endTransaction();
        }
    }

    public LiveData loadTemplateVideoData(long l10) {
        int n10 = 1;
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire("SELECT * FROM TemplateVideo WHERE temp_id = ?", n10);
        roomSQLiteQuery.bindLong(n10, l10);
        InvalidationTracker invalidationTracker = this.__db.getInvalidationTracker();
        String[] stringArray = new String[]{"TemplateVideo"};
        G_TemplateVideoDao_Impl$12 g_TemplateVideoDao_Impl$12 = new G_TemplateVideoDao_Impl$12(this, roomSQLiteQuery);
        return invalidationTracker.createLiveData(stringArray, false, g_TemplateVideoDao_Impl$12);
    }

    public z loadTemplateVideoData_Observable(long l10) {
        int n10 = 1;
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire("SELECT * FROM TemplateVideo WHERE temp_id = ?", n10);
        roomSQLiteQuery.bindLong(n10, l10);
        RoomDatabase roomDatabase = this.__db;
        String[] stringArray = new String[]{"TemplateVideo"};
        G_TemplateVideoDao_Impl$11 g_TemplateVideoDao_Impl$11 = new G_TemplateVideoDao_Impl$11(this, roomSQLiteQuery);
        return RxRoom.createObservable(roomDatabase, false, stringArray, g_TemplateVideoDao_Impl$11);
    }

    public List loadTemplateVideoData_Primitive(long l10) {
        Object object = this;
        int n10 = 1;
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire("SELECT * FROM TemplateVideo WHERE temp_id = ?", n10);
        roomSQLiteQuery.bindLong(n10, l10);
        this.__db.assertNotSuspendingTransaction();
        ArrayList<Object> arrayList = this.__db;
        int n11 = 0;
        Object object2 = null;
        int n12 = 0;
        float f10 = 0.0f;
        Object object3 = null;
        Cursor cursor = DBUtil.query((RoomDatabase)((Object)arrayList), roomSQLiteQuery, false, null);
        arrayList = "id";
        try {
            int n13 = CursorUtil.getColumnIndexOrThrow(cursor, (String)((Object)arrayList));
            String string2 = "temp_id";
            int n14 = CursorUtil.getColumnIndexOrThrow(cursor, string2);
            String string3 = "timebase";
            int n15 = CursorUtil.getColumnIndexOrThrow(cursor, string3);
            String string4 = "start_time";
            int n16 = CursorUtil.getColumnIndexOrThrow(cursor, string4);
            String string5 = "end_time";
            int n17 = CursorUtil.getColumnIndexOrThrow(cursor, string5);
            String string6 = "duration";
            int n18 = CursorUtil.getColumnIndexOrThrow(cursor, string6);
            String string7 = "mute";
            int n19 = CursorUtil.getColumnIndexOrThrow(cursor, string7);
            String string8 = "volume";
            int n20 = CursorUtil.getColumnIndexOrThrow(cursor, string8);
            String string9 = "voice_enable";
            int n21 = CursorUtil.getColumnIndexOrThrow(cursor, string9);
            String string10 = "rate";
            int n22 = CursorUtil.getColumnIndexOrThrow(cursor, string10);
            String string11 = "rate_type";
            n10 = CursorUtil.getColumnIndexOrThrow(cursor, string11);
            object2 = "bezier_rate";
            n11 = CursorUtil.getColumnIndexOrThrow(cursor, (String)object2);
            object3 = "videoPath";
            n12 = CursorUtil.getColumnIndexOrThrow(cursor, (String)object3);
            object = "is_local_source";
            int n23 = CursorUtil.getColumnIndexOrThrow(cursor, (String)object);
            return n23;
        }
        finally {
            RoomSQLiteQuery roomSQLiteQuery2 = roomSQLiteQuery;
        }
    }

    public i0 loadTemplateVideoData_Single(long l10) {
        int n10 = 1;
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire("SELECT * FROM TemplateVideo WHERE temp_id = ?", n10);
        roomSQLiteQuery.bindLong(n10, l10);
        G_TemplateVideoDao_Impl$10 g_TemplateVideoDao_Impl$10 = new G_TemplateVideoDao_Impl$10(this, roomSQLiteQuery);
        return RxRoom.createSingle(g_TemplateVideoDao_Impl$10);
    }

    public long replace(TemplateVideo object) {
        this.__db.assertNotSuspendingTransaction();
        Object object2 = this.__db;
        ((RoomDatabase)object2).beginTransaction();
        try {
            object2 = this.__insertionAdapterOfTemplateVideo;
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
            object = this.__insertionAdapterOfTemplateVideo;
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
        G_TemplateVideoDao_Impl$5 g_TemplateVideoDao_Impl$5 = new G_TemplateVideoDao_Impl$5(this, list);
        return i0.o0(g_TemplateVideoDao_Impl$5);
    }

    public void update(TemplateVideo object) {
        this.__db.assertNotSuspendingTransaction();
        Object object2 = this.__db;
        ((RoomDatabase)object2).beginTransaction();
        try {
            object2 = this.__updateAdapterOfTemplateVideo;
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

