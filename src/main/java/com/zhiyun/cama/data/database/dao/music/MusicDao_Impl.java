/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.database.Cursor
 */
package com.zhiyun.cama.data.database.dao.music;

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
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.zhiyun.cama.data.database.dao.music.MusicDao;
import com.zhiyun.cama.data.database.dao.music.MusicDao_Impl$1;
import com.zhiyun.cama.data.database.dao.music.MusicDao_Impl$12;
import com.zhiyun.cama.data.database.dao.music.MusicDao_Impl$13;
import com.zhiyun.cama.data.database.dao.music.MusicDao_Impl$14;
import com.zhiyun.cama.data.database.dao.music.MusicDao_Impl$15;
import com.zhiyun.cama.data.database.dao.music.MusicDao_Impl$16;
import com.zhiyun.cama.data.database.model.ResourceData;
import com.zhiyun.cama.data.database.model.music.MusicData;
import e.a.i0;
import java.util.Collections;
import java.util.List;

public final class MusicDao_Impl
implements MusicDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter __deletionAdapterOfMusicData;
    private final EntityInsertionAdapter __insertionAdapterOfMusicData;
    private final EntityInsertionAdapter __insertionAdapterOfMusicData_1;
    private final SharedSQLiteStatement __preparedStmtOfDeleteAlbumMusic;
    private final SharedSQLiteStatement __preparedStmtOfDeleteAlbumMusicNoHash;
    private final SharedSQLiteStatement __preparedStmtOfDeleteAll;
    private final SharedSQLiteStatement __preparedStmtOfDeleteAssetsMusic;
    private final SharedSQLiteStatement __preparedStmtOfDeleteDownloadAlbumMusic;
    private final SharedSQLiteStatement __preparedStmtOfDeleteDownloadMusic;
    private final SharedSQLiteStatement __preparedStmtOfDeleteMusicNoAlbumId;
    private final EntityDeletionOrUpdateAdapter __updateAdapterOfMusicData;

    public MusicDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        SharedSQLiteStatement sharedSQLiteStatement = new MusicDao_Impl$1(this, roomDatabase);
        this.__insertionAdapterOfMusicData = sharedSQLiteStatement;
        super(this, roomDatabase);
        this.__insertionAdapterOfMusicData_1 = sharedSQLiteStatement;
        super(this, roomDatabase);
        this.__deletionAdapterOfMusicData = sharedSQLiteStatement;
        super(this, roomDatabase);
        this.__updateAdapterOfMusicData = sharedSQLiteStatement;
        super(this, roomDatabase);
        this.__preparedStmtOfDeleteAssetsMusic = sharedSQLiteStatement;
        super(this, roomDatabase);
        this.__preparedStmtOfDeleteDownloadAlbumMusic = sharedSQLiteStatement;
        super(this, roomDatabase);
        this.__preparedStmtOfDeleteDownloadMusic = sharedSQLiteStatement;
        super(this, roomDatabase);
        this.__preparedStmtOfDeleteAlbumMusic = sharedSQLiteStatement;
        super(this, roomDatabase);
        this.__preparedStmtOfDeleteAlbumMusicNoHash = sharedSQLiteStatement;
        super(this, roomDatabase);
        this.__preparedStmtOfDeleteMusicNoAlbumId = sharedSQLiteStatement;
        super(this, roomDatabase);
        this.__preparedStmtOfDeleteAll = sharedSQLiteStatement;
    }

    public static /* synthetic */ RoomDatabase access$000(MusicDao_Impl musicDao_Impl) {
        return musicDao_Impl.__db;
    }

    public static /* synthetic */ EntityInsertionAdapter access$100(MusicDao_Impl musicDao_Impl) {
        return musicDao_Impl.__insertionAdapterOfMusicData;
    }

    public static /* synthetic */ EntityInsertionAdapter access$200(MusicDao_Impl musicDao_Impl) {
        return musicDao_Impl.__insertionAdapterOfMusicData_1;
    }

    public static List getRequiredConverters() {
        return Collections.emptyList();
    }

    public void delete(MusicData object) {
        this.__db.assertNotSuspendingTransaction();
        Object object2 = this.__db;
        ((RoomDatabase)object2).beginTransaction();
        try {
            object2 = this.__deletionAdapterOfMusicData;
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
            object2 = this.__deletionAdapterOfMusicData;
            ((EntityDeletionOrUpdateAdapter)object2).handleMultiple((Iterable)object);
            object = this.__db;
            ((RoomDatabase)object).setTransactionSuccessful();
            return;
        }
        finally {
            this.__db.endTransaction();
        }
    }

    public void deleteAlbumMusic(long l10) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatement = this.__preparedStmtOfDeleteAlbumMusic.acquire();
        int n10 = 1;
        supportSQLiteStatement.bindLong(n10, l10);
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
            this.__preparedStmtOfDeleteAlbumMusic.release(supportSQLiteStatement);
        }
    }

    public void deleteAlbumMusicNoHash(long l10) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatement = this.__preparedStmtOfDeleteAlbumMusicNoHash.acquire();
        int n10 = 1;
        supportSQLiteStatement.bindLong(n10, l10);
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
            this.__preparedStmtOfDeleteAlbumMusicNoHash.release(supportSQLiteStatement);
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

    public void deleteAssetsMusic() {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatement = this.__preparedStmtOfDeleteAssetsMusic.acquire();
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
            this.__preparedStmtOfDeleteAssetsMusic.release(supportSQLiteStatement);
        }
    }

    public void deleteDownloadAlbumMusic(long l10) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatement = this.__preparedStmtOfDeleteDownloadAlbumMusic.acquire();
        int n10 = 1;
        supportSQLiteStatement.bindLong(n10, l10);
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
            this.__preparedStmtOfDeleteDownloadAlbumMusic.release(supportSQLiteStatement);
        }
    }

    public void deleteDownloadMusic() {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatement = this.__preparedStmtOfDeleteDownloadMusic.acquire();
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
            this.__preparedStmtOfDeleteDownloadMusic.release(supportSQLiteStatement);
        }
    }

    public void deleteDownloadMusic(List object) {
        boolean bl2;
        this.__db.assertNotSuspendingTransaction();
        Object object2 = StringUtil.newStringBuilder();
        ((StringBuilder)object2).append("DELETE FROM music_data WHERE path IN (");
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

    public void deleteMusicNoAlbumId() {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatement = this.__preparedStmtOfDeleteMusicNoAlbumId.acquire();
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
            this.__preparedStmtOfDeleteMusicNoAlbumId.release(supportSQLiteStatement);
        }
    }

    public LiveData getAllMusicDataLiveData() {
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire("SELECT `music_data`.`album_id` AS `album_id`, `music_data`.`thumb` AS `thumb`, `music_data`.`hash` AS `hash`, `music_data`.`duration` AS `duration`, `music_data`.`size` AS `size`, `music_data`.`path` AS `path`, `music_data`.`file_download_timestamp` AS `file_download_timestamp`, `music_data`.`requiredPrime` AS `requiredPrime`, `music_data`.`id` AS `id`, `music_data`.`res_id` AS `res_id`, `music_data`.`label` AS `label`, `music_data`.`label_tw` AS `label_tw`, `music_data`.`label_en` AS `label_en`, `music_data`.`sort` AS `sort` FROM music_data ORDER BY sort desc", 0);
        InvalidationTracker invalidationTracker = this.__db.getInvalidationTracker();
        String[] stringArray = new String[]{"music_data"};
        MusicDao_Impl$14 musicDao_Impl$14 = new MusicDao_Impl$14(this, roomSQLiteQuery);
        return invalidationTracker.createLiveData(stringArray, false, musicDao_Impl$14);
    }

    public LiveData getMusicDataByAlbumIdLiveData(long l10) {
        int n10 = 1;
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire("SELECT * FROM music_data WHERE album_id = ? ORDER BY sort desc", n10);
        roomSQLiteQuery.bindLong(n10, l10);
        InvalidationTracker invalidationTracker = this.__db.getInvalidationTracker();
        String[] stringArray = new String[]{"music_data"};
        MusicDao_Impl$15 musicDao_Impl$15 = new MusicDao_Impl$15(this, roomSQLiteQuery);
        return invalidationTracker.createLiveData(stringArray, false, musicDao_Impl$15);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public MusicData getMusicDataByHash(String string2) {
        Object object = this;
        Object object2 = string2;
        int n10 = 1;
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire("SELECT * FROM music_data WHERE hash = ?", n10);
        if (string2 == null) {
            roomSQLiteQuery.bindNull(n10);
        } else {
            roomSQLiteQuery.bindString(n10, string2);
        }
        ((MusicDao_Impl)object).__db.assertNotSuspendingTransaction();
        object2 = ((MusicDao_Impl)object).__db;
        n10 = 0;
        int n11 = 0;
        Object object3 = null;
        Cursor cursor = DBUtil.query((RoomDatabase)object2, roomSQLiteQuery, false, null);
        object2 = "album_id";
        try {
            int n12 = CursorUtil.getColumnIndexOrThrow(cursor, (String)object2);
            String string3 = "thumb";
            int n13 = CursorUtil.getColumnIndexOrThrow(cursor, string3);
            String string4 = "hash";
            int n14 = CursorUtil.getColumnIndexOrThrow(cursor, string4);
            String string5 = "duration";
            int n15 = CursorUtil.getColumnIndexOrThrow(cursor, string5);
            String string6 = "size";
            int n16 = CursorUtil.getColumnIndexOrThrow(cursor, string6);
            String string7 = "path";
            int n17 = CursorUtil.getColumnIndexOrThrow(cursor, string7);
            String string8 = "file_download_timestamp";
            int n18 = CursorUtil.getColumnIndexOrThrow(cursor, string8);
            String string9 = "requiredPrime";
            int n19 = CursorUtil.getColumnIndexOrThrow(cursor, string9);
            String string10 = "id";
            int n20 = CursorUtil.getColumnIndexOrThrow(cursor, string10);
            String string11 = "res_id";
            int n21 = CursorUtil.getColumnIndexOrThrow(cursor, string11);
            String string12 = "label";
            int n22 = CursorUtil.getColumnIndexOrThrow(cursor, string12);
            String string13 = "label_tw";
            int n23 = CursorUtil.getColumnIndexOrThrow(cursor, string13);
            object3 = "label_en";
            n11 = CursorUtil.getColumnIndexOrThrow(cursor, (String)object3);
            object = "sort";
            int n24 = CursorUtil.getColumnIndexOrThrow(cursor, (String)object);
            boolean bl2 = cursor.moveToFirst();
            if (bl2) {
                String string14;
                Object object4;
                bl2 = cursor.isNull(n12);
                if (bl2) {
                    object4 = null;
                } else {
                    long l10 = cursor.getLong(n12);
                    object4 = object2 = Long.valueOf(l10);
                }
                n12 = (int)(cursor.isNull(n13) ? 1 : 0);
                Object object5 = n12 != 0 ? null : (object2 = cursor.getString(n13));
                n12 = (int)(cursor.isNull(n14) ? 1 : 0);
                Object object6 = n12 != 0 ? null : (object2 = cursor.getString(n14));
                long l11 = cursor.getLong(n15);
                long l12 = cursor.getLong(n16);
                n12 = (int)(cursor.isNull(n17) ? 1 : 0);
                Object object7 = n12 != 0 ? null : (object2 = cursor.getString(n17));
                int n25 = cursor.getInt(n19);
                long l13 = cursor.getLong(n21);
                n12 = (int)(cursor.isNull(n22) ? 1 : 0);
                Object object8 = n12 != 0 ? null : (object2 = cursor.getString(n22));
                n12 = (int)(cursor.isNull(n23) ? 1 : 0);
                Object object9 = n12 != 0 ? null : (object2 = cursor.getString(n23));
                n12 = (int)(cursor.isNull(n11) ? 1 : 0);
                if (n12 != 0) {
                    string14 = null;
                } else {
                    object3 = cursor.getString(n11);
                    string14 = object3;
                }
                int n26 = cursor.getInt(n24);
                object3 = new MusicData(l13, (Long)object4, (String)object8, (String)object9, string14, n26, (String)object6, l11, l12, (String)object7, (String)object5, n25);
                long l14 = cursor.getLong(n18);
                ((MusicData)object3).setFileDownloadTimestamp(l14);
                l14 = cursor.getLong(n20);
                ((ResourceData)object3).setId(l14);
                return object3;
            } else {
                n11 = 0;
                object3 = null;
            }
            return object3;
        }
        finally {
            cursor.close();
            roomSQLiteQuery.release();
        }
    }

    public LiveData getMusicDataNoAlbumIdLiveData() {
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire("SELECT `music_data`.`album_id` AS `album_id`, `music_data`.`thumb` AS `thumb`, `music_data`.`hash` AS `hash`, `music_data`.`duration` AS `duration`, `music_data`.`size` AS `size`, `music_data`.`path` AS `path`, `music_data`.`file_download_timestamp` AS `file_download_timestamp`, `music_data`.`requiredPrime` AS `requiredPrime`, `music_data`.`id` AS `id`, `music_data`.`res_id` AS `res_id`, `music_data`.`label` AS `label`, `music_data`.`label_tw` AS `label_tw`, `music_data`.`label_en` AS `label_en`, `music_data`.`sort` AS `sort` FROM music_data WHERE album_id IS NULL ORDER BY sort desc", 0);
        InvalidationTracker invalidationTracker = this.__db.getInvalidationTracker();
        String[] stringArray = new String[]{"music_data"};
        MusicDao_Impl$16 musicDao_Impl$16 = new MusicDao_Impl$16(this, roomSQLiteQuery);
        return invalidationTracker.createLiveData(stringArray, false, musicDao_Impl$16);
    }

    public long insert(MusicData object) {
        this.__db.assertNotSuspendingTransaction();
        Object object2 = this.__db;
        ((RoomDatabase)object2).beginTransaction();
        try {
            object2 = this.__insertionAdapterOfMusicData_1;
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
            object = this.__insertionAdapterOfMusicData_1;
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
        MusicDao_Impl$13 musicDao_Impl$13 = new MusicDao_Impl$13(this, list);
        return i0.o0(musicDao_Impl$13);
    }

    public long replace(MusicData object) {
        this.__db.assertNotSuspendingTransaction();
        Object object2 = this.__db;
        ((RoomDatabase)object2).beginTransaction();
        try {
            object2 = this.__insertionAdapterOfMusicData;
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
            object = this.__insertionAdapterOfMusicData;
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
        MusicDao_Impl$12 musicDao_Impl$12 = new MusicDao_Impl$12(this, list);
        return i0.o0(musicDao_Impl$12);
    }

    public void update(MusicData object) {
        this.__db.assertNotSuspendingTransaction();
        Object object2 = this.__db;
        ((RoomDatabase)object2).beginTransaction();
        try {
            object2 = this.__updateAdapterOfMusicData;
            ((EntityDeletionOrUpdateAdapter)object2).handle(object);
            object = this.__db;
            ((RoomDatabase)object).setTransactionSuccessful();
            return;
        }
        finally {
            this.__db.endTransaction();
        }
    }

    public void updateMusicPath(String object, String string2, long l10) {
        RoomDatabase roomDatabase = this.__db;
        roomDatabase.beginTransaction();
        try {
            MusicDao.super.updateMusicPath((String)object, string2, l10);
            object = this.__db;
            ((RoomDatabase)object).setTransactionSuccessful();
            return;
        }
        finally {
            this.__db.endTransaction();
        }
    }
}

