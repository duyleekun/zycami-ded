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
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class d$h
implements Callable {
    public final /* synthetic */ RoomSQLiteQuery a;
    public final /* synthetic */ d b;

    public d$h(d d10, RoomSQLiteQuery roomSQLiteQuery) {
        this.b = d10;
        this.a = roomSQLiteQuery;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public List a() {
        RoomDatabase roomDatabase = d.o(this.b);
        Object object = this.a;
        int n10 = 0;
        String string2 = null;
        int n11 = 0;
        String string3 = null;
        roomDatabase = DBUtil.query(roomDatabase, (SupportSQLiteQuery)object, false, null);
        object = "serial";
        try {
            int n12 = CursorUtil.getColumnIndexOrThrow((Cursor)roomDatabase, (String)object);
            string2 = "device_name";
            n10 = CursorUtil.getColumnIndexOrThrow((Cursor)roomDatabase, string2);
            string3 = "version";
            n11 = CursorUtil.getColumnIndexOrThrow((Cursor)roomDatabase, string3);
            String string4 = "sub_model";
            int n13 = CursorUtil.getColumnIndexOrThrow((Cursor)roomDatabase, string4);
            String string5 = "create_timestamp";
            int n14 = CursorUtil.getColumnIndexOrThrow((Cursor)roomDatabase, string5);
            String string6 = "update_timestamp";
            int n15 = CursorUtil.getColumnIndexOrThrow((Cursor)roomDatabase, string6);
            int n16 = roomDatabase.getCount();
            ArrayList<DeviceInfo> arrayList = new ArrayList<DeviceInfo>(n16);
            while ((n16 = (int)(roomDatabase.moveToNext() ? 1 : 0)) != 0) {
                DeviceInfo deviceInfo = new DeviceInfo();
                int n17 = roomDatabase.getInt(n12);
                deviceInfo.setSerial(n17);
                Object object2 = roomDatabase.getString(n10);
                deviceInfo.setDeviceName((String)object2);
                object2 = roomDatabase.getString(n11);
                deviceInfo.setVer((String)object2);
                object2 = roomDatabase.getString(n13);
                Object object3 = this.b;
                object3 = d.n((d)object3);
                object2 = ((b)object3).b((String)object2);
                deviceInfo.setSubModels((List)object2);
                long l10 = roomDatabase.getLong(n14);
                deviceInfo.setCreateTimestamp(l10);
                l10 = roomDatabase.getLong(n15);
                deviceInfo.setUpdateTimestamp(l10);
                arrayList.add(deviceInfo);
            }
            return arrayList;
        }
        finally {
            roomDatabase.close();
        }
    }

    public void finalize() {
        this.a.release();
    }
}

