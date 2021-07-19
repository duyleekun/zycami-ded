/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.database.Cursor
 */
package d.v.g.f.b.d;

import android.database.Cursor;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteQuery;
import com.zhiyun.device.data.local.entity.DeviceInfo;
import d.v.g.f.b.b;
import d.v.g.f.b.d.d;
import java.util.List;
import java.util.concurrent.Callable;

public class d$i
implements Callable {
    public final /* synthetic */ RoomSQLiteQuery a;
    public final /* synthetic */ d b;

    public d$i(d d10, RoomSQLiteQuery roomSQLiteQuery) {
        this.b = d10;
        this.a = roomSQLiteQuery;
    }

    public DeviceInfo a() {
        DeviceInfo deviceInfo;
        RoomDatabase roomDatabase;
        block26: {
            roomDatabase = d.o(this.b);
            Object object = this.a;
            int n10 = 0;
            Object object2 = null;
            deviceInfo = null;
            roomDatabase = DBUtil.query(roomDatabase, (SupportSQLiteQuery)object, false, null);
            object = "serial";
            int n11 = CursorUtil.getColumnIndexOrThrow((Cursor)roomDatabase, (String)object);
            object2 = "device_name";
            n10 = CursorUtil.getColumnIndexOrThrow((Cursor)roomDatabase, (String)object2);
            String string2 = "version";
            int n12 = CursorUtil.getColumnIndexOrThrow((Cursor)roomDatabase, string2);
            String string3 = "sub_model";
            int n13 = CursorUtil.getColumnIndexOrThrow((Cursor)roomDatabase, string3);
            String string4 = "create_timestamp";
            int n14 = CursorUtil.getColumnIndexOrThrow((Cursor)roomDatabase, string4);
            String string5 = "update_timestamp";
            int n15 = CursorUtil.getColumnIndexOrThrow((Cursor)roomDatabase, string5);
            boolean bl2 = roomDatabase.moveToFirst();
            if (!bl2) break block26;
            deviceInfo = new DeviceInfo();
            n11 = roomDatabase.getInt(n11);
            deviceInfo.setSerial(n11);
            object = roomDatabase.getString(n10);
            deviceInfo.setDeviceName((String)object);
            object = roomDatabase.getString(n12);
            deviceInfo.setVer((String)object);
            object = roomDatabase.getString(n13);
            object2 = this.b;
            object2 = d.n((d)object2);
            object = ((b)object2).b((String)object);
            deviceInfo.setSubModels((List)object);
            long l10 = roomDatabase.getLong(n14);
            deviceInfo.setCreateTimestamp(l10);
            l10 = roomDatabase.getLong(n15);
            deviceInfo.setUpdateTimestamp(l10);
        }
        return deviceInfo;
        finally {
            roomDatabase.close();
        }
    }

    public void finalize() {
        this.a.release();
    }
}

