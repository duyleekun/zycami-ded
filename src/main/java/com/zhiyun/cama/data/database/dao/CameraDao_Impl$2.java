/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.database.Cursor
 */
package com.zhiyun.cama.data.database.dao;

import android.database.Cursor;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteQuery;
import com.zhiyun.cama.camera.data.CameraSet$Mode;
import com.zhiyun.cama.data.database.TypeCameraModeConverters;
import com.zhiyun.cama.data.database.TypeFpsSizeConverters;
import com.zhiyun.cama.data.database.dao.CameraDao_Impl;
import com.zhiyun.cama.data.database.model.CameraParam;
import d.v.d.i.g.k$a;
import java.util.concurrent.Callable;

public class CameraDao_Impl$2
implements Callable {
    public final /* synthetic */ CameraDao_Impl this$0;
    public final /* synthetic */ RoomSQLiteQuery val$_statement;

    public CameraDao_Impl$2(CameraDao_Impl cameraDao_Impl, RoomSQLiteQuery roomSQLiteQuery) {
        this.this$0 = cameraDao_Impl;
        this.val$_statement = roomSQLiteQuery;
    }

    public CameraParam call() {
        Object object;
        RoomDatabase roomDatabase;
        block17: {
            int n10;
            Object object2;
            int n11;
            Object object3;
            int n12;
            Object object4;
            block18: {
                roomDatabase = CameraDao_Impl.access$100(this.this$0);
                Object object5 = this.val$_statement;
                int n13 = 0;
                object4 = null;
                object = null;
                roomDatabase = DBUtil.query(roomDatabase, (SupportSQLiteQuery)object5, false, null);
                object5 = "facing";
                try {
                    n12 = CursorUtil.getColumnIndexOrThrow((Cursor)roomDatabase, (String)object5);
                    object4 = "mode";
                }
                catch (Throwable throwable) {
                    roomDatabase.close();
                    throw throwable;
                }
                n13 = CursorUtil.getColumnIndexOrThrow((Cursor)roomDatabase, object4);
                object3 = "videoResolution";
                n11 = CursorUtil.getColumnIndexOrThrow((Cursor)roomDatabase, (String)object3);
                object2 = "whiteBalance";
                n10 = CursorUtil.getColumnIndexOrThrow((Cursor)roomDatabase, (String)object2);
                boolean bl2 = roomDatabase.moveToFirst();
                if (!bl2) break block17;
                n12 = roomDatabase.getInt(n12);
                n13 = roomDatabase.getInt(n13);
                object4 = TypeCameraModeConverters.idToMode(n13);
                bl2 = roomDatabase.isNull(n11);
                if (bl2) break block18;
                object = roomDatabase.getString(n11);
            }
            object3 = this.this$0;
            object3 = CameraDao_Impl.access$000((CameraDao_Impl)object3);
            object = ((TypeFpsSizeConverters)object3).stringToFpsSize((String)object);
            n11 = roomDatabase.getInt(n10);
            object = object2 = new CameraParam(n12, (CameraSet$Mode)((Object)object4), (k$a)object, n11);
        }
        roomDatabase.close();
        return object;
    }

    public void finalize() {
        this.val$_statement.release();
    }
}

