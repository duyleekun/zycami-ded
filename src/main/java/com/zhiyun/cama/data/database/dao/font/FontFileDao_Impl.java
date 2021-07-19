/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.database.dao.font;

import androidx.lifecycle.LiveData;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.zhiyun.cama.data.database.dao.font.FontFileDao;
import com.zhiyun.cama.data.database.dao.font.FontFileDao_Impl$1;
import com.zhiyun.cama.data.database.dao.font.FontFileDao_Impl$7;
import com.zhiyun.cama.data.database.dao.font.FontFileDao_Impl$8;
import com.zhiyun.cama.data.database.dao.font.FontFileDao_Impl$9;
import com.zhiyun.cama.data.database.model.font.FontFile;
import e.a.i0;
import java.util.Collections;
import java.util.List;

public final class FontFileDao_Impl
implements FontFileDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter __deletionAdapterOfFontFile;
    private final EntityInsertionAdapter __insertionAdapterOfFontFile;
    private final EntityInsertionAdapter __insertionAdapterOfFontFile_1;
    private final SharedSQLiteStatement __preparedStmtOfDeleteAll;
    private final SharedSQLiteStatement __preparedStmtOfDeleteAllAssetsFontFile;
    private final EntityDeletionOrUpdateAdapter __updateAdapterOfFontFile;

    public FontFileDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        SharedSQLiteStatement sharedSQLiteStatement = new FontFileDao_Impl$1(this, roomDatabase);
        this.__insertionAdapterOfFontFile = sharedSQLiteStatement;
        super(this, roomDatabase);
        this.__insertionAdapterOfFontFile_1 = sharedSQLiteStatement;
        super(this, roomDatabase);
        this.__deletionAdapterOfFontFile = sharedSQLiteStatement;
        super(this, roomDatabase);
        this.__updateAdapterOfFontFile = sharedSQLiteStatement;
        super(this, roomDatabase);
        this.__preparedStmtOfDeleteAllAssetsFontFile = sharedSQLiteStatement;
        super(this, roomDatabase);
        this.__preparedStmtOfDeleteAll = sharedSQLiteStatement;
    }

    public static /* synthetic */ RoomDatabase access$000(FontFileDao_Impl fontFileDao_Impl) {
        return fontFileDao_Impl.__db;
    }

    public static /* synthetic */ EntityInsertionAdapter access$100(FontFileDao_Impl fontFileDao_Impl) {
        return fontFileDao_Impl.__insertionAdapterOfFontFile;
    }

    public static /* synthetic */ EntityInsertionAdapter access$200(FontFileDao_Impl fontFileDao_Impl) {
        return fontFileDao_Impl.__insertionAdapterOfFontFile_1;
    }

    public static List getRequiredConverters() {
        return Collections.emptyList();
    }

    public void delete(FontFile object) {
        this.__db.assertNotSuspendingTransaction();
        Object object2 = this.__db;
        ((RoomDatabase)object2).beginTransaction();
        try {
            object2 = this.__deletionAdapterOfFontFile;
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
            object2 = this.__deletionAdapterOfFontFile;
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

    public void deleteAllAssetsFontFile() {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatement = this.__preparedStmtOfDeleteAllAssetsFontFile.acquire();
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
            this.__preparedStmtOfDeleteAllAssetsFontFile.release(supportSQLiteStatement);
        }
    }

    public LiveData getAllFontFile() {
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire("SELECT `ext_lic_url`, `ext_lic_name`, `ext_lic_path`, `font_file`.`hash` AS `hash`, `font_file`.`name` AS `name`, `font_file`.`category` AS `category`, `font_file`.`mime` AS `mime`, `font_file`.`size` AS `size`, `font_file`.`url` AS `url`, `font_file`.`path` AS `path`, `font_file`.`download_timestamp` AS `download_timestamp` FROM font_file", 0);
        InvalidationTracker invalidationTracker = this.__db.getInvalidationTracker();
        String[] stringArray = new String[]{"font_file"};
        FontFileDao_Impl$9 fontFileDao_Impl$9 = new FontFileDao_Impl$9(this, roomSQLiteQuery);
        return invalidationTracker.createLiveData(stringArray, false, fontFileDao_Impl$9);
    }

    public long insert(FontFile object) {
        this.__db.assertNotSuspendingTransaction();
        Object object2 = this.__db;
        ((RoomDatabase)object2).beginTransaction();
        try {
            object2 = this.__insertionAdapterOfFontFile_1;
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
            object = this.__insertionAdapterOfFontFile_1;
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
        FontFileDao_Impl$8 fontFileDao_Impl$8 = new FontFileDao_Impl$8(this, list);
        return i0.o0(fontFileDao_Impl$8);
    }

    public long replace(FontFile object) {
        this.__db.assertNotSuspendingTransaction();
        Object object2 = this.__db;
        ((RoomDatabase)object2).beginTransaction();
        try {
            object2 = this.__insertionAdapterOfFontFile;
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
            object = this.__insertionAdapterOfFontFile;
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
        FontFileDao_Impl$7 fontFileDao_Impl$7 = new FontFileDao_Impl$7(this, list);
        return i0.o0(fontFileDao_Impl$7);
    }

    public void update(FontFile object) {
        this.__db.assertNotSuspendingTransaction();
        Object object2 = this.__db;
        ((RoomDatabase)object2).beginTransaction();
        try {
            object2 = this.__updateAdapterOfFontFile;
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

