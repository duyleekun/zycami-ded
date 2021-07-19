/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.database.Cursor
 */
package com.zhiyun.mediaprovider.data.local.dao;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.zhiyun.mediaprovider.data.local.dao.AlbumCustomizeDao;
import com.zhiyun.mediaprovider.data.local.dao.AlbumCustomizeDao_Impl$1;
import com.zhiyun.mediaprovider.data.local.model.AlbumCustomizeData;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class AlbumCustomizeDao_Impl
implements AlbumCustomizeDao {
    private final RoomDatabase __db;
    private final EntityInsertionAdapter __insertionAdapterOfAlbumCustomizeData;
    private final SharedSQLiteStatement __preparedStmtOfDeleteAlbumLikeData;
    private final SharedSQLiteStatement __preparedStmtOfDeleteAlbumLikeData_1;
    private final SharedSQLiteStatement __preparedStmtOfDeleteAlbumLikeData_2;

    public AlbumCustomizeDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        SharedSQLiteStatement sharedSQLiteStatement = new AlbumCustomizeDao_Impl$1(this, roomDatabase);
        this.__insertionAdapterOfAlbumCustomizeData = sharedSQLiteStatement;
        super(this, roomDatabase);
        this.__preparedStmtOfDeleteAlbumLikeData = sharedSQLiteStatement;
        super(this, roomDatabase);
        this.__preparedStmtOfDeleteAlbumLikeData_1 = sharedSQLiteStatement;
        super(this, roomDatabase);
        this.__preparedStmtOfDeleteAlbumLikeData_2 = sharedSQLiteStatement;
    }

    public static List getRequiredConverters() {
        return Collections.emptyList();
    }

    public void deleteAlbumLikeData(int n10) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatement = this.__preparedStmtOfDeleteAlbumLikeData_2.acquire();
        long l10 = n10;
        n10 = 1;
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
            this.__preparedStmtOfDeleteAlbumLikeData_2.release(supportSQLiteStatement);
        }
    }

    public void deleteAlbumLikeData(int n10, String string2) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatement = this.__preparedStmtOfDeleteAlbumLikeData_1.acquire();
        long l10 = n10;
        supportSQLiteStatement.bindLong(1, l10);
        n10 = 2;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n10);
        } else {
            supportSQLiteStatement.bindString(n10, string2);
        }
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
            this.__preparedStmtOfDeleteAlbumLikeData_1.release(supportSQLiteStatement);
        }
    }

    public void deleteAlbumLikeData(String object, int n10, String string2) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatement = this.__preparedStmtOfDeleteAlbumLikeData.acquire();
        int n11 = 1;
        if (object == null) {
            supportSQLiteStatement.bindNull(n11);
        } else {
            supportSQLiteStatement.bindString(n11, (String)object);
        }
        long l10 = n10;
        supportSQLiteStatement.bindLong(2, l10);
        int n12 = 3;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n12);
        } else {
            supportSQLiteStatement.bindString(n12, string2);
        }
        object = this.__db;
        ((RoomDatabase)object).beginTransaction();
        try {
            supportSQLiteStatement.executeUpdateDelete();
            object = this.__db;
            ((RoomDatabase)object).setTransactionSuccessful();
            return;
        }
        finally {
            this.__db.endTransaction();
            this.__preparedStmtOfDeleteAlbumLikeData.release(supportSQLiteStatement);
        }
    }

    public void insertAlbumCustomizeData(AlbumCustomizeData object) {
        this.__db.assertNotSuspendingTransaction();
        Object object2 = this.__db;
        ((RoomDatabase)object2).beginTransaction();
        try {
            object2 = this.__insertionAdapterOfAlbumCustomizeData;
            ((EntityInsertionAdapter)object2).insert(object);
            object = this.__db;
            ((RoomDatabase)object).setTransactionSuccessful();
            return;
        }
        finally {
            this.__db.endTransaction();
        }
    }

    public AlbumCustomizeData queryAlbumCustomizeData(String object, int n10) {
        Object object2;
        RoomSQLiteQuery roomSQLiteQuery;
        block17: {
            Object object3;
            int n11;
            String string2;
            block20: {
                boolean bl2;
                int n12;
                block19: {
                    int n13;
                    block18: {
                        int n14 = 2;
                        roomSQLiteQuery = RoomSQLiteQuery.acquire("SELECT * FROM AlbumCustomizeData where albumTag =? and albumId = ?", n14);
                        n13 = 1;
                        if (object == null) {
                            roomSQLiteQuery.bindNull(n13);
                        } else {
                            roomSQLiteQuery.bindString(n13, (String)object);
                        }
                        long l10 = n10;
                        roomSQLiteQuery.bindLong(n14, l10);
                        this.__db.assertNotSuspendingTransaction();
                        object = this.__db;
                        n10 = 0;
                        n14 = 0;
                        object2 = null;
                        object = DBUtil.query((RoomDatabase)object, roomSQLiteQuery, false, null);
                        String string3 = "id";
                        try {
                            n10 = CursorUtil.getColumnIndexOrThrow((Cursor)object, string3);
                            string2 = "albumTag";
                        }
                        catch (Throwable throwable) {
                            object.close();
                            roomSQLiteQuery.release();
                            throw throwable;
                        }
                        n13 = CursorUtil.getColumnIndexOrThrow((Cursor)object, string2);
                        String string4 = "albumId";
                        n11 = CursorUtil.getColumnIndexOrThrow((Cursor)object, string4);
                        object3 = "path";
                        n12 = CursorUtil.getColumnIndexOrThrow((Cursor)object, (String)object3);
                        bl2 = object.moveToFirst();
                        if (!bl2) break block17;
                        bl2 = object.isNull(n13);
                        if (!bl2) break block18;
                        n13 = 0;
                        string2 = null;
                        break block19;
                    }
                    string2 = object.getString(n13);
                }
                n11 = object.getInt(n11);
                bl2 = object.isNull(n12);
                if (bl2) break block20;
                object2 = object.getString(n12);
            }
            object3 = new AlbumCustomizeData(string2, n11, (String)object2);
            n10 = object.getInt(n10);
            ((AlbumCustomizeData)object3).setId(n10);
            object2 = object3;
        }
        object.close();
        roomSQLiteQuery.release();
        return object2;
    }

    public AlbumCustomizeData queryAlbumCustomizeData(String object, int n10, String object2) {
        RoomSQLiteQuery roomSQLiteQuery;
        block19: {
            Object object3;
            String string2;
            int n11;
            block22: {
                boolean bl2;
                int n12;
                block21: {
                    int n13;
                    block20: {
                        n13 = 3;
                        roomSQLiteQuery = RoomSQLiteQuery.acquire("SELECT * FROM AlbumCustomizeData where albumTag =? and albumId = ? and path = ?", n13);
                        n11 = 1;
                        if (object == null) {
                            roomSQLiteQuery.bindNull(n11);
                        } else {
                            roomSQLiteQuery.bindString(n11, (String)object);
                        }
                        int n14 = 2;
                        long l10 = n10;
                        roomSQLiteQuery.bindLong(n14, l10);
                        if (object2 == null) {
                            roomSQLiteQuery.bindNull(n13);
                        } else {
                            roomSQLiteQuery.bindString(n13, (String)object2);
                        }
                        this.__db.assertNotSuspendingTransaction();
                        object = this.__db;
                        n10 = 0;
                        object2 = null;
                        object = DBUtil.query((RoomDatabase)object, roomSQLiteQuery, false, null);
                        String string3 = "id";
                        try {
                            n10 = CursorUtil.getColumnIndexOrThrow((Cursor)object, string3);
                            string2 = "albumTag";
                        }
                        catch (Throwable throwable) {
                            object.close();
                            roomSQLiteQuery.release();
                            throw throwable;
                        }
                        n13 = CursorUtil.getColumnIndexOrThrow((Cursor)object, string2);
                        String string4 = "albumId";
                        n11 = CursorUtil.getColumnIndexOrThrow((Cursor)object, string4);
                        object3 = "path";
                        n12 = CursorUtil.getColumnIndexOrThrow((Cursor)object, (String)object3);
                        bl2 = object.moveToFirst();
                        if (!bl2) break block19;
                        bl2 = object.isNull(n13);
                        if (!bl2) break block20;
                        n13 = 0;
                        string2 = null;
                        break block21;
                    }
                    string2 = object.getString(n13);
                }
                n11 = object.getInt(n11);
                bl2 = object.isNull(n12);
                if (bl2) break block22;
                object2 = object.getString(n12);
            }
            object3 = new AlbumCustomizeData(string2, n11, (String)object2);
            n10 = object.getInt(n10);
            ((AlbumCustomizeData)object3).setId(n10);
            object2 = object3;
        }
        object.close();
        roomSQLiteQuery.release();
        return object2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public List queryAllAlbumCustomizeDataList(String object) {
        int n10 = 1;
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire("SELECT * FROM AlbumCustomizeData where albumTag = ? ORDER BY id", n10);
        if (object == null) {
            roomSQLiteQuery.bindNull(n10);
        } else {
            roomSQLiteQuery.bindString(n10, (String)object);
        }
        this.__db.assertNotSuspendingTransaction();
        object = this.__db;
        n10 = 0;
        object = DBUtil.query((RoomDatabase)object, roomSQLiteQuery, false, null);
        String string2 = "id";
        try {
            n10 = CursorUtil.getColumnIndexOrThrow((Cursor)object, string2);
            String string3 = "albumTag";
            int n11 = CursorUtil.getColumnIndexOrThrow((Cursor)object, string3);
            String string4 = "albumId";
            int n12 = CursorUtil.getColumnIndexOrThrow((Cursor)object, string4);
            String string5 = "path";
            int n13 = CursorUtil.getColumnIndexOrThrow((Cursor)object, string5);
            int n14 = object.getCount();
            ArrayList<AlbumCustomizeData> arrayList = new ArrayList<AlbumCustomizeData>(n14);
            while ((n14 = (int)(object.moveToNext() ? 1 : 0)) != 0) {
                String string6;
                String string7;
                n14 = (int)(object.isNull(n11) ? 1 : 0);
                if (n14 != 0) {
                    n14 = 0;
                    string7 = null;
                } else {
                    string7 = object.getString(n11);
                }
                int n15 = object.getInt(n12);
                boolean bl2 = object.isNull(n13);
                if (bl2) {
                    bl2 = false;
                    string6 = null;
                } else {
                    string6 = object.getString(n13);
                }
                AlbumCustomizeData albumCustomizeData = new AlbumCustomizeData(string7, n15, string6);
                n14 = object.getInt(n10);
                albumCustomizeData.setId(n14);
                arrayList.add(albumCustomizeData);
            }
            return arrayList;
        }
        finally {
            object.close();
            roomSQLiteQuery.release();
        }
    }
}

