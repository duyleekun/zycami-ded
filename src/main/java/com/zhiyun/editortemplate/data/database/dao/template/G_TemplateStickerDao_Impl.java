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
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateStickerDao;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateStickerDao_Impl$1;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateStickerDao_Impl$5;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateStickerDao_Impl$6;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateStickerDao_Impl$7;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateStickerDao_Impl$8;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateStickerDao_Impl$9;
import com.zhiyun.editortemplate.data.database.dao.template.TemplateStickerDao;
import com.zhiyun.editortemplate.data.database.model.template.config.TemplateSticker;
import e.a.i0;
import e.a.z;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class G_TemplateStickerDao_Impl
implements G_TemplateStickerDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter __deletionAdapterOfTemplateSticker;
    private final EntityInsertionAdapter __insertionAdapterOfTemplateSticker;
    private final EntityInsertionAdapter __insertionAdapterOfTemplateSticker_1;
    private final EntityDeletionOrUpdateAdapter __updateAdapterOfTemplateSticker;

    public G_TemplateStickerDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        SharedSQLiteStatement sharedSQLiteStatement = new G_TemplateStickerDao_Impl$1(this, roomDatabase);
        this.__insertionAdapterOfTemplateSticker = sharedSQLiteStatement;
        super(this, roomDatabase);
        this.__insertionAdapterOfTemplateSticker_1 = sharedSQLiteStatement;
        super(this, roomDatabase);
        this.__deletionAdapterOfTemplateSticker = sharedSQLiteStatement;
        super(this, roomDatabase);
        this.__updateAdapterOfTemplateSticker = sharedSQLiteStatement;
    }

    public static /* synthetic */ RoomDatabase access$000(G_TemplateStickerDao_Impl g_TemplateStickerDao_Impl) {
        return g_TemplateStickerDao_Impl.__db;
    }

    public static /* synthetic */ EntityInsertionAdapter access$100(G_TemplateStickerDao_Impl g_TemplateStickerDao_Impl) {
        return g_TemplateStickerDao_Impl.__insertionAdapterOfTemplateSticker;
    }

    public static /* synthetic */ EntityInsertionAdapter access$200(G_TemplateStickerDao_Impl g_TemplateStickerDao_Impl) {
        return g_TemplateStickerDao_Impl.__insertionAdapterOfTemplateSticker_1;
    }

    public static List getRequiredConverters() {
        return Collections.emptyList();
    }

    public void delete(TemplateSticker object) {
        this.__db.assertNotSuspendingTransaction();
        Object object2 = this.__db;
        ((RoomDatabase)object2).beginTransaction();
        try {
            object2 = this.__deletionAdapterOfTemplateSticker;
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
            object2 = this.__deletionAdapterOfTemplateSticker;
            ((EntityDeletionOrUpdateAdapter)object2).handleMultiple((Iterable)object);
            object = this.__db;
            ((RoomDatabase)object).setTransactionSuccessful();
            return;
        }
        finally {
            this.__db.endTransaction();
        }
    }

    public List getTemplateStick(long l10) {
        Object object = this;
        int n10 = 1;
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire("SELECT * FROM TemplateSticker where temp_id = ? ", n10);
        long l11 = l10;
        roomSQLiteQuery.bindLong(n10, l10);
        this.__db.assertNotSuspendingTransaction();
        ArrayList<Object> arrayList = this.__db;
        int n11 = 0;
        String string2 = null;
        int n12 = 0;
        String string3 = null;
        Cursor cursor = DBUtil.query((RoomDatabase)((Object)arrayList), roomSQLiteQuery, false, null);
        arrayList = "id";
        try {
            int n13 = CursorUtil.getColumnIndexOrThrow(cursor, (String)((Object)arrayList));
            String string4 = "temp_id";
            int n14 = CursorUtil.getColumnIndexOrThrow(cursor, string4);
            String string5 = "start_time";
            int n15 = CursorUtil.getColumnIndexOrThrow(cursor, string5);
            String string6 = "end_time";
            int n16 = CursorUtil.getColumnIndexOrThrow(cursor, string6);
            String string7 = "angle";
            int n17 = CursorUtil.getColumnIndexOrThrow(cursor, string7);
            String string8 = "center";
            int n18 = CursorUtil.getColumnIndexOrThrow(cursor, string8);
            String string9 = "type";
            int n19 = CursorUtil.getColumnIndexOrThrow(cursor, string9);
            String string10 = "sticker_type_id";
            int n20 = CursorUtil.getColumnIndexOrThrow(cursor, string10);
            String string11 = "scale";
            int n21 = CursorUtil.getColumnIndexOrThrow(cursor, string11);
            String string12 = "text_font_size";
            int n22 = CursorUtil.getColumnIndexOrThrow(cursor, string12);
            String string13 = "text_color";
            n10 = CursorUtil.getColumnIndexOrThrow(cursor, string13);
            string2 = "text_content";
            n11 = CursorUtil.getColumnIndexOrThrow(cursor, string2);
            string3 = "text_caption_name";
            n12 = CursorUtil.getColumnIndexOrThrow(cursor, string3);
            object = "caption_local_source";
            int n23 = CursorUtil.getColumnIndexOrThrow(cursor, (String)object);
            return n23;
        }
        finally {
            RoomSQLiteQuery roomSQLiteQuery2 = roomSQLiteQuery;
        }
    }

    public LiveData getTemplateStick_LiveData(long l10) {
        int n10 = 1;
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire("SELECT * FROM TemplateSticker where temp_id = ? ", n10);
        roomSQLiteQuery.bindLong(n10, l10);
        InvalidationTracker invalidationTracker = this.__db.getInvalidationTracker();
        String[] stringArray = new String[]{"TemplateSticker"};
        G_TemplateStickerDao_Impl$8 g_TemplateStickerDao_Impl$8 = new G_TemplateStickerDao_Impl$8(this, roomSQLiteQuery);
        return invalidationTracker.createLiveData(stringArray, false, g_TemplateStickerDao_Impl$8);
    }

    public z getTemplateStick_Observable(long l10) {
        int n10 = 1;
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire("SELECT * FROM TemplateSticker where temp_id = ? ", n10);
        roomSQLiteQuery.bindLong(n10, l10);
        RoomDatabase roomDatabase = this.__db;
        String[] stringArray = new String[]{"TemplateSticker"};
        G_TemplateStickerDao_Impl$9 g_TemplateStickerDao_Impl$9 = new G_TemplateStickerDao_Impl$9(this, roomSQLiteQuery);
        return RxRoom.createObservable(roomDatabase, false, stringArray, g_TemplateStickerDao_Impl$9);
    }

    public i0 getTemplateStick_Single(long l10) {
        int n10 = 1;
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire("SELECT * FROM TemplateSticker where temp_id = ? ", n10);
        roomSQLiteQuery.bindLong(n10, l10);
        G_TemplateStickerDao_Impl$7 g_TemplateStickerDao_Impl$7 = new G_TemplateStickerDao_Impl$7(this, roomSQLiteQuery);
        return RxRoom.createSingle(g_TemplateStickerDao_Impl$7);
    }

    public long insert(TemplateSticker object) {
        this.__db.assertNotSuspendingTransaction();
        Object object2 = this.__db;
        ((RoomDatabase)object2).beginTransaction();
        try {
            object2 = this.__insertionAdapterOfTemplateSticker_1;
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
            object = this.__insertionAdapterOfTemplateSticker_1;
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
        G_TemplateStickerDao_Impl$6 g_TemplateStickerDao_Impl$6 = new G_TemplateStickerDao_Impl$6(this, list);
        return i0.o0(g_TemplateStickerDao_Impl$6);
    }

    public void insertSticker(List object, long l10) {
        RoomDatabase roomDatabase = this.__db;
        roomDatabase.beginTransaction();
        try {
            TemplateStickerDao.super.insertSticker((List)object, l10);
            object = this.__db;
            ((RoomDatabase)object).setTransactionSuccessful();
            return;
        }
        finally {
            this.__db.endTransaction();
        }
    }

    public long replace(TemplateSticker object) {
        this.__db.assertNotSuspendingTransaction();
        Object object2 = this.__db;
        ((RoomDatabase)object2).beginTransaction();
        try {
            object2 = this.__insertionAdapterOfTemplateSticker;
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
            object = this.__insertionAdapterOfTemplateSticker;
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
        G_TemplateStickerDao_Impl$5 g_TemplateStickerDao_Impl$5 = new G_TemplateStickerDao_Impl$5(this, list);
        return i0.o0(g_TemplateStickerDao_Impl$5);
    }

    public void update(TemplateSticker object) {
        this.__db.assertNotSuspendingTransaction();
        Object object2 = this.__db;
        ((RoomDatabase)object2).beginTransaction();
        try {
            object2 = this.__updateAdapterOfTemplateSticker;
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

