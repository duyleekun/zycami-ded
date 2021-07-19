/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.database.dao.music;

import androidx.lifecycle.LiveData;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.zhiyun.cama.data.database.dao.music.MusicFileDao;
import com.zhiyun.cama.data.database.dao.music.MusicFileDao_Impl$1;
import com.zhiyun.cama.data.database.dao.music.MusicFileDao_Impl$7;
import com.zhiyun.cama.data.database.dao.music.MusicFileDao_Impl$8;
import com.zhiyun.cama.data.database.dao.music.MusicFileDao_Impl$9;
import com.zhiyun.cama.data.database.model.music.MusicFile;
import e.a.i0;
import java.util.Collections;
import java.util.List;

public final class MusicFileDao_Impl
implements MusicFileDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter __deletionAdapterOfMusicFile;
    private final EntityInsertionAdapter __insertionAdapterOfMusicFile;
    private final EntityInsertionAdapter __insertionAdapterOfMusicFile_1;
    private final SharedSQLiteStatement __preparedStmtOfDeleteAll;
    private final SharedSQLiteStatement __preparedStmtOfDeleteAllAssetsFile;
    private final EntityDeletionOrUpdateAdapter __updateAdapterOfMusicFile;

    public MusicFileDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        SharedSQLiteStatement sharedSQLiteStatement = new MusicFileDao_Impl$1(this, roomDatabase);
        this.__insertionAdapterOfMusicFile = sharedSQLiteStatement;
        super(this, roomDatabase);
        this.__insertionAdapterOfMusicFile_1 = sharedSQLiteStatement;
        super(this, roomDatabase);
        this.__deletionAdapterOfMusicFile = sharedSQLiteStatement;
        super(this, roomDatabase);
        this.__updateAdapterOfMusicFile = sharedSQLiteStatement;
        super(this, roomDatabase);
        this.__preparedStmtOfDeleteAllAssetsFile = sharedSQLiteStatement;
        super(this, roomDatabase);
        this.__preparedStmtOfDeleteAll = sharedSQLiteStatement;
    }

    public static /* synthetic */ RoomDatabase access$000(MusicFileDao_Impl musicFileDao_Impl) {
        return musicFileDao_Impl.__db;
    }

    public static /* synthetic */ EntityInsertionAdapter access$100(MusicFileDao_Impl musicFileDao_Impl) {
        return musicFileDao_Impl.__insertionAdapterOfMusicFile;
    }

    public static /* synthetic */ EntityInsertionAdapter access$200(MusicFileDao_Impl musicFileDao_Impl) {
        return musicFileDao_Impl.__insertionAdapterOfMusicFile_1;
    }

    public static List getRequiredConverters() {
        return Collections.emptyList();
    }

    public void delete(MusicFile object) {
        this.__db.assertNotSuspendingTransaction();
        Object object2 = this.__db;
        ((RoomDatabase)object2).beginTransaction();
        try {
            object2 = this.__deletionAdapterOfMusicFile;
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
            object2 = this.__deletionAdapterOfMusicFile;
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

    public void deleteDownloadMusic(List object) {
        boolean bl2;
        this.__db.assertNotSuspendingTransaction();
        Object object2 = StringUtil.newStringBuilder();
        ((StringBuilder)object2).append("DELETE FROM music_file WHERE path IN (");
        int n10 = object.size();
        StringUtil.appendPlaceholders((StringBuilder)object2, n10);
        ((StringBuilder)object2).append(")");
        object2 = ((StringBuilder)object2).toString();
        RoomDatabase roomDatabase = this.__db;
        object2 = roomDatabase.compileStatement((String)object2);
        object = object.iterator();
        n10 = 1;
        while (bl2 = object.hasNext()) {
            String string2 = (String)object.next();
            if (string2 == null) {
                object2.bindNull(n10);
            } else {
                object2.bindString(n10, string2);
            }
            ++n10;
        }
        object = this.__db;
        ((RoomDatabase)object).beginTransaction();
        try {
            object2.executeUpdateDelete();
            object = this.__db;
            ((RoomDatabase)object).setTransactionSuccessful();
            return;
        }
        finally {
            this.__db.endTransaction();
        }
    }

    public LiveData getAllMusicFileListLiveData() {
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire("SELECT `ext_lic_url`, `ext_lic_name`, `ext_lic_path`, `music_file`.`hash` AS `hash`, `music_file`.`name` AS `name`, `music_file`.`category` AS `category`, `music_file`.`mime` AS `mime`, `music_file`.`size` AS `size`, `music_file`.`url` AS `url`, `music_file`.`path` AS `path`, `music_file`.`download_timestamp` AS `download_timestamp` FROM music_file ORDER BY download_timestamp desc", 0);
        InvalidationTracker invalidationTracker = this.__db.getInvalidationTracker();
        String[] stringArray = new String[]{"music_file"};
        MusicFileDao_Impl$9 musicFileDao_Impl$9 = new MusicFileDao_Impl$9(this, roomSQLiteQuery);
        return invalidationTracker.createLiveData(stringArray, false, musicFileDao_Impl$9);
    }

    public long insert(MusicFile object) {
        this.__db.assertNotSuspendingTransaction();
        Object object2 = this.__db;
        ((RoomDatabase)object2).beginTransaction();
        try {
            object2 = this.__insertionAdapterOfMusicFile_1;
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
            object = this.__insertionAdapterOfMusicFile_1;
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
        MusicFileDao_Impl$8 musicFileDao_Impl$8 = new MusicFileDao_Impl$8(this, list);
        return i0.o0(musicFileDao_Impl$8);
    }

    public long replace(MusicFile object) {
        this.__db.assertNotSuspendingTransaction();
        Object object2 = this.__db;
        ((RoomDatabase)object2).beginTransaction();
        try {
            object2 = this.__insertionAdapterOfMusicFile;
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
            object = this.__insertionAdapterOfMusicFile;
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
        MusicFileDao_Impl$7 musicFileDao_Impl$7 = new MusicFileDao_Impl$7(this, list);
        return i0.o0(musicFileDao_Impl$7);
    }

    public void update(MusicFile object) {
        this.__db.assertNotSuspendingTransaction();
        Object object2 = this.__db;
        ((RoomDatabase)object2).beginTransaction();
        try {
            object2 = this.__updateAdapterOfMusicFile;
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

