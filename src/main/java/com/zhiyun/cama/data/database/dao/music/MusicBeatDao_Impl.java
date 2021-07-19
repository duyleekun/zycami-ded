/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.database.Cursor
 */
package com.zhiyun.cama.data.database.dao.music;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.StringUtil;
import com.zhiyun.cama.data.database.MapTypeConverters;
import com.zhiyun.cama.data.database.dao.music.MusicBeatDao;
import com.zhiyun.cama.data.database.dao.music.MusicBeatDao_Impl$1;
import com.zhiyun.cama.data.database.model.music.MusicBeatData;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public final class MusicBeatDao_Impl
implements MusicBeatDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter __deletionAdapterOfMusicBeatData;
    private final EntityInsertionAdapter __insertionAdapterOfMusicBeatData;
    private final EntityDeletionOrUpdateAdapter __updateAdapterOfMusicBeatData;

    public MusicBeatDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        SharedSQLiteStatement sharedSQLiteStatement = new MusicBeatDao_Impl$1(this, roomDatabase);
        this.__insertionAdapterOfMusicBeatData = sharedSQLiteStatement;
        super(this, roomDatabase);
        this.__deletionAdapterOfMusicBeatData = sharedSQLiteStatement;
        super(this, roomDatabase);
        this.__updateAdapterOfMusicBeatData = sharedSQLiteStatement;
    }

    public static List getRequiredConverters() {
        return Collections.emptyList();
    }

    public int delete(MusicBeatData musicBeatData) {
        this.__db.assertNotSuspendingTransaction();
        Object object = this.__db;
        ((RoomDatabase)object).beginTransaction();
        try {
            object = this.__deletionAdapterOfMusicBeatData;
            int n10 = ((EntityDeletionOrUpdateAdapter)object).handle(musicBeatData) + 0;
            object = this.__db;
            ((RoomDatabase)object).setTransactionSuccessful();
            return n10;
        }
        finally {
            this.__db.endTransaction();
        }
    }

    public void deleteMusicBeatList(List object) {
        boolean bl2;
        this.__db.assertNotSuspendingTransaction();
        Object object2 = StringUtil.newStringBuilder();
        ((StringBuilder)object2).append("DELETE FROM music_beat_data WHERE music_path IN (");
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

    public MusicBeatData getMusicBeatDataByPath(String object) {
        Object object2;
        RoomSQLiteQuery roomSQLiteQuery;
        block16: {
            Object object3;
            String string2;
            int n10;
            block19: {
                boolean bl2;
                int n11;
                block18: {
                    int n12;
                    block17: {
                        n10 = 1;
                        roomSQLiteQuery = RoomSQLiteQuery.acquire("SELECT * FROM music_beat_data WHERE music_path = ?", n10);
                        if (object == null) {
                            roomSQLiteQuery.bindNull(n10);
                        } else {
                            roomSQLiteQuery.bindString(n10, (String)object);
                        }
                        this.__db.assertNotSuspendingTransaction();
                        object = this.__db;
                        n10 = 0;
                        object2 = null;
                        object = DBUtil.query((RoomDatabase)object, roomSQLiteQuery, false, null);
                        String string3 = "id";
                        try {
                            n10 = CursorUtil.getColumnIndexOrThrow((Cursor)object, string3);
                            string2 = "music_path";
                        }
                        catch (Throwable throwable) {
                            object.close();
                            roomSQLiteQuery.release();
                            throw throwable;
                        }
                        n12 = CursorUtil.getColumnIndexOrThrow((Cursor)object, string2);
                        object3 = "beat_map";
                        n11 = CursorUtil.getColumnIndexOrThrow((Cursor)object, (String)object3);
                        bl2 = object.moveToFirst();
                        if (!bl2) break block16;
                        bl2 = object.isNull(n12);
                        if (!bl2) break block17;
                        n12 = 0;
                        string2 = null;
                        break block18;
                    }
                    string2 = object.getString(n12);
                }
                bl2 = object.isNull(n11);
                if (bl2) break block19;
                object2 = object.getString(n11);
            }
            object2 = MapTypeConverters.fromString(object2);
            object3 = new MusicBeatData(string2, (HashMap)object2);
            long l10 = object.getLong(n10);
            ((MusicBeatData)object3).setId(l10);
            object2 = object3;
        }
        object.close();
        roomSQLiteQuery.release();
        return object2;
    }

    public void insertMusicBeatData(MusicBeatData object) {
        this.__db.assertNotSuspendingTransaction();
        Object object2 = this.__db;
        ((RoomDatabase)object2).beginTransaction();
        try {
            object2 = this.__insertionAdapterOfMusicBeatData;
            ((EntityInsertionAdapter)object2).insert(object);
            object = this.__db;
            ((RoomDatabase)object).setTransactionSuccessful();
            return;
        }
        finally {
            this.__db.endTransaction();
        }
    }

    public void update(MusicBeatData object) {
        this.__db.assertNotSuspendingTransaction();
        Object object2 = this.__db;
        ((RoomDatabase)object2).beginTransaction();
        try {
            object2 = this.__updateAdapterOfMusicBeatData;
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

