/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.database.Cursor
 */
package com.zhiyun.cama.data.database.dao;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.room.EntityInsertionAdapter;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import com.zhiyun.cama.camera.data.CameraSet$Mode;
import com.zhiyun.cama.data.database.TypeCameraModeConverters;
import com.zhiyun.cama.data.database.TypeFpsSizeConverters;
import com.zhiyun.cama.data.database.dao.CameraDao;
import com.zhiyun.cama.data.database.dao.CameraDao_Impl$1;
import com.zhiyun.cama.data.database.dao.CameraDao_Impl$2;
import com.zhiyun.cama.data.database.model.CameraParam;
import d.v.d.i.g.k$a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class CameraDao_Impl
implements CameraDao {
    private final RoomDatabase __db;
    private final EntityInsertionAdapter __insertionAdapterOfCameraParam;
    private final TypeFpsSizeConverters __typeFpsSizeConverters;

    public CameraDao_Impl(RoomDatabase roomDatabase) {
        Object object = new TypeFpsSizeConverters();
        this.__typeFpsSizeConverters = object;
        this.__db = roomDatabase;
        this.__insertionAdapterOfCameraParam = object = new CameraDao_Impl$1(this, roomDatabase);
    }

    public static /* synthetic */ TypeFpsSizeConverters access$000(CameraDao_Impl cameraDao_Impl) {
        return cameraDao_Impl.__typeFpsSizeConverters;
    }

    public static /* synthetic */ RoomDatabase access$100(CameraDao_Impl cameraDao_Impl) {
        return cameraDao_Impl.__db;
    }

    public static List getRequiredConverters() {
        return Collections.emptyList();
    }

    public void insertCameraParam(CameraParam ... object) {
        this.__db.assertNotSuspendingTransaction();
        Object object2 = this.__db;
        ((RoomDatabase)object2).beginTransaction();
        try {
            object2 = this.__insertionAdapterOfCameraParam;
            ((EntityInsertionAdapter)object2).insert((Object[])object);
            object = this.__db;
            ((RoomDatabase)object).setTransactionSuccessful();
            return;
        }
        finally {
            this.__db.endTransaction();
        }
    }

    public LiveData loadCameraParam(int n10, CameraSet$Mode stringArray) {
        int n11 = 2;
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire("SELECT * FROM CameraParam WHERE facing = ? AND mode = ?", n11);
        long l10 = n10;
        roomSQLiteQuery.bindLong(1, l10);
        long l11 = TypeCameraModeConverters.modeToId((CameraSet$Mode)stringArray);
        roomSQLiteQuery.bindLong(n11, l11);
        InvalidationTracker invalidationTracker = this.__db.getInvalidationTracker();
        stringArray = new String[]{"CameraParam"};
        CameraDao_Impl$2 cameraDao_Impl$2 = new CameraDao_Impl$2(this, roomSQLiteQuery);
        return invalidationTracker.createLiveData(stringArray, false, cameraDao_Impl$2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public List loadCameraParamDataList(int n10) {
        int n11 = 1;
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire("SELECT * FROM CameraParam WHERE facing = ?", n11);
        long l10 = n10;
        roomSQLiteQuery.bindLong(n11, l10);
        this.__db.assertNotSuspendingTransaction();
        RoomDatabase roomDatabase = this.__db;
        n11 = 0;
        roomDatabase = DBUtil.query(roomDatabase, roomSQLiteQuery, false, null);
        String string2 = "facing";
        try {
            n11 = CursorUtil.getColumnIndexOrThrow((Cursor)roomDatabase, string2);
            String string3 = "mode";
            int n12 = CursorUtil.getColumnIndexOrThrow((Cursor)roomDatabase, string3);
            String string4 = "videoResolution";
            int n13 = CursorUtil.getColumnIndexOrThrow((Cursor)roomDatabase, string4);
            String string5 = "whiteBalance";
            int n14 = CursorUtil.getColumnIndexOrThrow((Cursor)roomDatabase, string5);
            int n15 = roomDatabase.getCount();
            ArrayList<CameraParam> arrayList = new ArrayList<CameraParam>(n15);
            while ((n15 = (int)(roomDatabase.moveToNext() ? 1 : 0)) != 0) {
                Object object;
                n15 = roomDatabase.getInt(n11);
                int n16 = roomDatabase.getInt(n12);
                CameraSet$Mode cameraSet$Mode = TypeCameraModeConverters.idToMode(n16);
                boolean bl2 = roomDatabase.isNull(n13);
                if (bl2) {
                    bl2 = false;
                    object = null;
                } else {
                    object = roomDatabase.getString(n13);
                }
                TypeFpsSizeConverters typeFpsSizeConverters = this.__typeFpsSizeConverters;
                object = typeFpsSizeConverters.stringToFpsSize((String)object);
                int n17 = roomDatabase.getInt(n14);
                CameraParam cameraParam = new CameraParam(n15, cameraSet$Mode, (k$a)object, n17);
                arrayList.add(cameraParam);
            }
            return arrayList;
        }
        finally {
            roomDatabase.close();
            roomSQLiteQuery.release();
        }
    }
}

