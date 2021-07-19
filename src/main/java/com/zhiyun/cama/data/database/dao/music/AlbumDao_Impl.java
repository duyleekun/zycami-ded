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
import androidx.sqlite.db.SupportSQLiteStatement;
import com.zhiyun.cama.data.database.dao.music.AlbumDao;
import com.zhiyun.cama.data.database.dao.music.AlbumDao_Impl$1;
import com.zhiyun.cama.data.database.dao.music.AlbumDao_Impl$10;
import com.zhiyun.cama.data.database.dao.music.AlbumDao_Impl$8;
import com.zhiyun.cama.data.database.dao.music.AlbumDao_Impl$9;
import com.zhiyun.cama.data.database.model.music.AlbumData;
import e.a.i0;
import java.util.Collections;
import java.util.List;

public final class AlbumDao_Impl
implements AlbumDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter __deletionAdapterOfAlbumData;
    private final EntityInsertionAdapter __insertionAdapterOfAlbumData;
    private final EntityInsertionAdapter __insertionAdapterOfAlbumData_1;
    private final SharedSQLiteStatement __preparedStmtOfDeleteAll;
    private final SharedSQLiteStatement __preparedStmtOfDeleteAssetsAlbum;
    private final SharedSQLiteStatement __preparedStmtOfDeleteDownloadAlbum;
    private final EntityDeletionOrUpdateAdapter __updateAdapterOfAlbumData;

    public AlbumDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        SharedSQLiteStatement sharedSQLiteStatement = new AlbumDao_Impl$1(this, roomDatabase);
        this.__insertionAdapterOfAlbumData = sharedSQLiteStatement;
        super(this, roomDatabase);
        this.__insertionAdapterOfAlbumData_1 = sharedSQLiteStatement;
        super(this, roomDatabase);
        this.__deletionAdapterOfAlbumData = sharedSQLiteStatement;
        super(this, roomDatabase);
        this.__updateAdapterOfAlbumData = sharedSQLiteStatement;
        super(this, roomDatabase);
        this.__preparedStmtOfDeleteAssetsAlbum = sharedSQLiteStatement;
        super(this, roomDatabase);
        this.__preparedStmtOfDeleteDownloadAlbum = sharedSQLiteStatement;
        super(this, roomDatabase);
        this.__preparedStmtOfDeleteAll = sharedSQLiteStatement;
    }

    public static /* synthetic */ RoomDatabase access$000(AlbumDao_Impl albumDao_Impl) {
        return albumDao_Impl.__db;
    }

    public static /* synthetic */ EntityInsertionAdapter access$100(AlbumDao_Impl albumDao_Impl) {
        return albumDao_Impl.__insertionAdapterOfAlbumData;
    }

    public static /* synthetic */ EntityInsertionAdapter access$200(AlbumDao_Impl albumDao_Impl) {
        return albumDao_Impl.__insertionAdapterOfAlbumData_1;
    }

    public static List getRequiredConverters() {
        return Collections.emptyList();
    }

    public void delete(AlbumData object) {
        this.__db.assertNotSuspendingTransaction();
        Object object2 = this.__db;
        ((RoomDatabase)object2).beginTransaction();
        try {
            object2 = this.__deletionAdapterOfAlbumData;
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
            object2 = this.__deletionAdapterOfAlbumData;
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

    public void deleteAssetsAlbum() {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatement = this.__preparedStmtOfDeleteAssetsAlbum.acquire();
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
            this.__preparedStmtOfDeleteAssetsAlbum.release(supportSQLiteStatement);
        }
    }

    public void deleteDownloadAlbum() {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatement = this.__preparedStmtOfDeleteDownloadAlbum.acquire();
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
            this.__preparedStmtOfDeleteDownloadAlbum.release(supportSQLiteStatement);
        }
    }

    public LiveData getAllAlbumDataLiveData() {
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire("SELECT `album_data`.`cover_url` AS `cover_url`, `album_data`.`song_count` AS `song_count`, `album_data`.`id` AS `id`, `album_data`.`res_id` AS `res_id`, `album_data`.`label` AS `label`, `album_data`.`label_tw` AS `label_tw`, `album_data`.`label_en` AS `label_en`, `album_data`.`sort` AS `sort` FROM album_data ORDER BY sort desc", 0);
        InvalidationTracker invalidationTracker = this.__db.getInvalidationTracker();
        String[] stringArray = new String[]{"album_data"};
        AlbumDao_Impl$10 albumDao_Impl$10 = new AlbumDao_Impl$10(this, roomSQLiteQuery);
        return invalidationTracker.createLiveData(stringArray, false, albumDao_Impl$10);
    }

    public long insert(AlbumData object) {
        this.__db.assertNotSuspendingTransaction();
        Object object2 = this.__db;
        ((RoomDatabase)object2).beginTransaction();
        try {
            object2 = this.__insertionAdapterOfAlbumData_1;
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
            object = this.__insertionAdapterOfAlbumData_1;
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
        AlbumDao_Impl$9 albumDao_Impl$9 = new AlbumDao_Impl$9(this, list);
        return i0.o0(albumDao_Impl$9);
    }

    public long replace(AlbumData object) {
        this.__db.assertNotSuspendingTransaction();
        Object object2 = this.__db;
        ((RoomDatabase)object2).beginTransaction();
        try {
            object2 = this.__insertionAdapterOfAlbumData;
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
            object = this.__insertionAdapterOfAlbumData;
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
        AlbumDao_Impl$8 albumDao_Impl$8 = new AlbumDao_Impl$8(this, list);
        return i0.o0(albumDao_Impl$8);
    }

    public void update(AlbumData object) {
        this.__db.assertNotSuspendingTransaction();
        Object object2 = this.__db;
        ((RoomDatabase)object2).beginTransaction();
        try {
            object2 = this.__updateAdapterOfAlbumData;
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

