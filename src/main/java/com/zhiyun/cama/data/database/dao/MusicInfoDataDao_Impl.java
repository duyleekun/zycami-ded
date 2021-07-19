/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.database.Cursor
 */
package com.zhiyun.cama.data.database.dao;

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
import com.zhiyun.cama.data.database.dao.MusicInfoDataDao;
import com.zhiyun.cama.data.database.dao.MusicInfoDataDao_Impl$1;
import com.zhiyun.cama.data.database.dao.MusicInfoDataDao_Impl$10;
import com.zhiyun.cama.data.database.dao.MusicInfoDataDao_Impl$6;
import com.zhiyun.cama.data.database.dao.MusicInfoDataDao_Impl$7;
import com.zhiyun.cama.data.database.dao.MusicInfoDataDao_Impl$8;
import com.zhiyun.cama.data.database.dao.MusicInfoDataDao_Impl$9;
import com.zhiyun.cama.data.database.model.music.MusicInfoData;
import e.a.i0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class MusicInfoDataDao_Impl
implements MusicInfoDataDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter __deletionAdapterOfMusicInfoData;
    private final EntityInsertionAdapter __insertionAdapterOfMusicInfoData;
    private final EntityInsertionAdapter __insertionAdapterOfMusicInfoData_1;
    private final SharedSQLiteStatement __preparedStmtOfDeleteAll;
    private final EntityDeletionOrUpdateAdapter __updateAdapterOfMusicInfoData;

    public MusicInfoDataDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        SharedSQLiteStatement sharedSQLiteStatement = new MusicInfoDataDao_Impl$1(this, roomDatabase);
        this.__insertionAdapterOfMusicInfoData = sharedSQLiteStatement;
        super(this, roomDatabase);
        this.__insertionAdapterOfMusicInfoData_1 = sharedSQLiteStatement;
        super(this, roomDatabase);
        this.__deletionAdapterOfMusicInfoData = sharedSQLiteStatement;
        super(this, roomDatabase);
        this.__updateAdapterOfMusicInfoData = sharedSQLiteStatement;
        super(this, roomDatabase);
        this.__preparedStmtOfDeleteAll = sharedSQLiteStatement;
    }

    public static /* synthetic */ RoomDatabase access$000(MusicInfoDataDao_Impl musicInfoDataDao_Impl) {
        return musicInfoDataDao_Impl.__db;
    }

    public static /* synthetic */ EntityInsertionAdapter access$100(MusicInfoDataDao_Impl musicInfoDataDao_Impl) {
        return musicInfoDataDao_Impl.__insertionAdapterOfMusicInfoData;
    }

    public static /* synthetic */ EntityInsertionAdapter access$200(MusicInfoDataDao_Impl musicInfoDataDao_Impl) {
        return musicInfoDataDao_Impl.__insertionAdapterOfMusicInfoData_1;
    }

    public static List getRequiredConverters() {
        return Collections.emptyList();
    }

    public void delete(MusicInfoData object) {
        this.__db.assertNotSuspendingTransaction();
        Object object2 = this.__db;
        ((RoomDatabase)object2).beginTransaction();
        try {
            object2 = this.__deletionAdapterOfMusicInfoData;
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
            object2 = this.__deletionAdapterOfMusicInfoData;
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

    public void deleteMusicInfoDataByPath(List object) {
        boolean bl2;
        this.__db.assertNotSuspendingTransaction();
        Object object2 = StringUtil.newStringBuilder();
        ((StringBuilder)object2).append("delete from music_info_data where musicPath in (");
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

    public LiveData getAllMusicInfoDataList() {
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire("SELECT `music_info_data`.`id` AS `id`, `music_info_data`.`musicName` AS `musicName`, `music_info_data`.`albumType` AS `albumType`, `music_info_data`.`albumName` AS `albumName`, `music_info_data`.`musicPath` AS `musicPath`, `music_info_data`.`musicUrl` AS `musicUrl`, `music_info_data`.`musicImage` AS `musicImage`, `music_info_data`.`duration` AS `duration`, `music_info_data`.`size` AS `size`, `music_info_data`.`import_timestamp` AS `import_timestamp` FROM music_info_data ORDER BY id desc", 0);
        InvalidationTracker invalidationTracker = this.__db.getInvalidationTracker();
        String[] stringArray = new String[]{"music_info_data"};
        MusicInfoDataDao_Impl$8 musicInfoDataDao_Impl$8 = new MusicInfoDataDao_Impl$8(this, roomSQLiteQuery);
        return invalidationTracker.createLiveData(stringArray, false, musicInfoDataDao_Impl$8);
    }

    public LiveData getMusicInfoDataListByAlbumType(int n10) {
        int n11 = 1;
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire("SELECT * FROM music_info_data where albumType = ?", n11);
        long l10 = n10;
        roomSQLiteQuery.bindLong(n11, l10);
        InvalidationTracker invalidationTracker = this.__db.getInvalidationTracker();
        String[] stringArray = new String[]{"music_info_data"};
        MusicInfoDataDao_Impl$9 musicInfoDataDao_Impl$9 = new MusicInfoDataDao_Impl$9(this, roomSQLiteQuery);
        return invalidationTracker.createLiveData(stringArray, false, musicInfoDataDao_Impl$9);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public List getMusicInfoDataListByMusicName(String string2) {
        MusicInfoDataDao_Impl musicInfoDataDao_Impl = this;
        Object object = string2;
        int n10 = 1;
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire("SELECT * FROM music_info_data where musicName = ?", n10);
        if (string2 == null) {
            roomSQLiteQuery.bindNull(n10);
        } else {
            roomSQLiteQuery.bindString(n10, string2);
        }
        musicInfoDataDao_Impl.__db.assertNotSuspendingTransaction();
        object = musicInfoDataDao_Impl.__db;
        n10 = 0;
        int n11 = 0;
        String string3 = null;
        Cursor cursor = DBUtil.query((RoomDatabase)object, roomSQLiteQuery, false, null);
        object = "id";
        try {
            int n12 = CursorUtil.getColumnIndexOrThrow(cursor, (String)object);
            String string4 = "musicName";
            int n13 = CursorUtil.getColumnIndexOrThrow(cursor, string4);
            String string5 = "albumType";
            int n14 = CursorUtil.getColumnIndexOrThrow(cursor, string5);
            String string6 = "albumName";
            int n15 = CursorUtil.getColumnIndexOrThrow(cursor, string6);
            String string7 = "musicPath";
            int n16 = CursorUtil.getColumnIndexOrThrow(cursor, string7);
            String string8 = "musicUrl";
            int n17 = CursorUtil.getColumnIndexOrThrow(cursor, string8);
            String string9 = "musicImage";
            int n18 = CursorUtil.getColumnIndexOrThrow(cursor, string9);
            String string10 = "duration";
            int n19 = CursorUtil.getColumnIndexOrThrow(cursor, string10);
            String string11 = "size";
            int n20 = CursorUtil.getColumnIndexOrThrow(cursor, string11);
            String string12 = "import_timestamp";
            int n21 = CursorUtil.getColumnIndexOrThrow(cursor, string12);
            int n22 = cursor.getCount();
            ArrayList<MusicInfoData> arrayList = new ArrayList<MusicInfoData>(n22);
            while ((n22 = (int)(cursor.moveToNext() ? 1 : 0)) != 0) {
                MusicInfoData musicInfoData = new MusicInfoData();
                n11 = cursor.getInt(n12);
                musicInfoData.setId(n11);
                n11 = (int)(cursor.isNull(n13) ? 1 : 0);
                if (n11 != 0) {
                    n11 = 0;
                    string3 = null;
                } else {
                    string3 = cursor.getString(n13);
                }
                musicInfoData.setMusicName(string3);
                n11 = cursor.getInt(n14);
                musicInfoData.setAlbumType(n11);
                n11 = (int)(cursor.isNull(n15) ? 1 : 0);
                if (n11 != 0) {
                    n11 = 0;
                    string3 = null;
                } else {
                    string3 = cursor.getString(n15);
                }
                musicInfoData.setAlbumName(string3);
                n11 = (int)(cursor.isNull(n16) ? 1 : 0);
                if (n11 != 0) {
                    n11 = 0;
                    string3 = null;
                } else {
                    string3 = cursor.getString(n16);
                }
                musicInfoData.setMusicPath(string3);
                n11 = (int)(cursor.isNull(n17) ? 1 : 0);
                if (n11 != 0) {
                    n11 = 0;
                    string3 = null;
                } else {
                    string3 = cursor.getString(n17);
                }
                musicInfoData.setMusicUrl(string3);
                n11 = (int)(cursor.isNull(n18) ? 1 : 0);
                if (n11 != 0) {
                    n11 = 0;
                    string3 = null;
                } else {
                    string3 = cursor.getString(n18);
                }
                musicInfoData.setMusicImage(string3);
                n11 = n12;
                long l10 = cursor.getLong(n19);
                musicInfoData.setDuration(l10);
                l10 = cursor.getLong(n20);
                musicInfoData.setSize(l10);
                l10 = cursor.getLong(n21);
                musicInfoData.setImportTimestamp(l10);
                arrayList.add(musicInfoData);
                musicInfoDataDao_Impl = this;
                n11 = 0;
                string3 = null;
            }
            return arrayList;
        }
        finally {
            cursor.close();
            roomSQLiteQuery.release();
        }
    }

    public LiveData getMusicInfoDataLiveDataByMusicName(String object) {
        int n10 = 1;
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire("SELECT * FROM music_info_data where musicName = ?", n10);
        if (object == null) {
            roomSQLiteQuery.bindNull(n10);
        } else {
            roomSQLiteQuery.bindString(n10, (String)object);
        }
        object = this.__db.getInvalidationTracker();
        String[] stringArray = new String[]{"music_info_data"};
        MusicInfoDataDao_Impl$10 musicInfoDataDao_Impl$10 = new MusicInfoDataDao_Impl$10(this, roomSQLiteQuery);
        return ((InvalidationTracker)object).createLiveData(stringArray, false, musicInfoDataDao_Impl$10);
    }

    public long insert(MusicInfoData object) {
        this.__db.assertNotSuspendingTransaction();
        Object object2 = this.__db;
        ((RoomDatabase)object2).beginTransaction();
        try {
            object2 = this.__insertionAdapterOfMusicInfoData_1;
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
            object = this.__insertionAdapterOfMusicInfoData_1;
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
        MusicInfoDataDao_Impl$7 musicInfoDataDao_Impl$7 = new MusicInfoDataDao_Impl$7(this, list);
        return i0.o0(musicInfoDataDao_Impl$7);
    }

    public long replace(MusicInfoData object) {
        this.__db.assertNotSuspendingTransaction();
        Object object2 = this.__db;
        ((RoomDatabase)object2).beginTransaction();
        try {
            object2 = this.__insertionAdapterOfMusicInfoData;
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
            object = this.__insertionAdapterOfMusicInfoData;
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
        MusicInfoDataDao_Impl$6 musicInfoDataDao_Impl$6 = new MusicInfoDataDao_Impl$6(this, list);
        return i0.o0(musicInfoDataDao_Impl$6);
    }

    public void update(MusicInfoData object) {
        this.__db.assertNotSuspendingTransaction();
        Object object2 = this.__db;
        ((RoomDatabase)object2).beginTransaction();
        try {
            object2 = this.__updateAdapterOfMusicInfoData;
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

