/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.database.Cursor
 */
package d.v.g.f.b.d;

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
import androidx.sqlite.db.SupportSQLiteStatement;
import com.zhiyun.device.data.local.entity.AppDeviceInfo;
import com.zhiyun.device.data.local.entity.DeviceInfo;
import d.v.g.f.b.b;
import d.v.g.f.b.d.c;
import d.v.g.f.b.d.d$a;
import d.v.g.f.b.d.d$b;
import d.v.g.f.b.d.d$c;
import d.v.g.f.b.d.d$d;
import d.v.g.f.b.d.d$e;
import d.v.g.f.b.d.d$f;
import d.v.g.f.b.d.d$g;
import d.v.g.f.b.d.d$h;
import d.v.g.f.b.d.d$i;
import java.util.ArrayList;
import java.util.List;

public final class d
implements c {
    private final RoomDatabase a;
    private final EntityInsertionAdapter b;
    private final b c;
    private final EntityInsertionAdapter d;
    private final EntityDeletionOrUpdateAdapter e;
    private final EntityDeletionOrUpdateAdapter f;
    private final EntityDeletionOrUpdateAdapter g;
    private final SharedSQLiteStatement h;

    public d(RoomDatabase roomDatabase) {
        Object object = new b();
        this.c = object;
        this.a = roomDatabase;
        this.b = object = new d$a(this, roomDatabase);
        this.d = object = new d$b(this, roomDatabase);
        this.e = object = new d$c(this, roomDatabase);
        this.f = object = new d$d(this, roomDatabase);
        this.g = object = new d$e(this, roomDatabase);
        this.h = object = new d$f(this, roomDatabase);
    }

    public static /* synthetic */ b n(d d10) {
        return d10.c;
    }

    public static /* synthetic */ RoomDatabase o(d d10) {
        return d10.a;
    }

    public void c(DeviceInfo object) {
        this.a.assertNotSuspendingTransaction();
        Object object2 = this.a;
        ((RoomDatabase)object2).beginTransaction();
        try {
            object2 = this.b;
            ((EntityInsertionAdapter)object2).insert(object);
            object = this.a;
            ((RoomDatabase)object).setTransactionSuccessful();
            return;
        }
        finally {
            this.a.endTransaction();
        }
    }

    public void d() {
        this.a.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatement = this.h.acquire();
        RoomDatabase roomDatabase = this.a;
        roomDatabase.beginTransaction();
        try {
            supportSQLiteStatement.executeUpdateDelete();
            roomDatabase = this.a;
            roomDatabase.setTransactionSuccessful();
            return;
        }
        finally {
            this.a.endTransaction();
            this.h.release(supportSQLiteStatement);
        }
    }

    public LiveData e(int n10) {
        int n11 = 1;
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire("SELECT * FROM device_info WHERE serial=?", n11);
        long l10 = n10;
        roomSQLiteQuery.bindLong(n11, l10);
        InvalidationTracker invalidationTracker = this.a.getInvalidationTracker();
        String[] stringArray = new String[]{"device_info"};
        d$i d$i = new d$i(this, roomSQLiteQuery);
        return invalidationTracker.createLiveData(stringArray, false, d$i);
    }

    public void f(DeviceInfo object) {
        this.a.assertNotSuspendingTransaction();
        Object object2 = this.a;
        ((RoomDatabase)object2).beginTransaction();
        try {
            object2 = this.e;
            ((EntityDeletionOrUpdateAdapter)object2).handle(object);
            object = this.a;
            ((RoomDatabase)object).setTransactionSuccessful();
            return;
        }
        finally {
            this.a.endTransaction();
        }
    }

    public void g(List object) {
        this.a.assertNotSuspendingTransaction();
        Object object2 = this.a;
        ((RoomDatabase)object2).beginTransaction();
        try {
            object2 = this.f;
            ((EntityDeletionOrUpdateAdapter)object2).handleMultiple((Iterable)object);
            object = this.a;
            ((RoomDatabase)object).setTransactionSuccessful();
            return;
        }
        finally {
            this.a.endTransaction();
        }
    }

    public void h(AppDeviceInfo ... object) {
        this.a.assertNotSuspendingTransaction();
        Object object2 = this.a;
        ((RoomDatabase)object2).beginTransaction();
        try {
            object2 = this.d;
            ((EntityInsertionAdapter)object2).insert((Object[])object);
            object = this.a;
            ((RoomDatabase)object).setTransactionSuccessful();
            return;
        }
        finally {
            this.a.endTransaction();
        }
    }

    public LiveData i() {
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire("SELECT * FROM device_info ORDER BY create_timestamp DESC", 0);
        InvalidationTracker invalidationTracker = this.a.getInvalidationTracker();
        String[] stringArray = new String[]{"device_info"};
        d$h d$h = new d$h(this, roomSQLiteQuery);
        return invalidationTracker.createLiveData(stringArray, false, d$h);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public List j() {
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire("SELECT * FROM AppDeviceInfo ORDER BY id desc", 0);
        this.a.assertNotSuspendingTransaction();
        Cursor cursor = DBUtil.query(this.a, roomSQLiteQuery, false, null);
        String string2 = "id";
        try {
            int n10 = CursorUtil.getColumnIndexOrThrow(cursor, string2);
            String string3 = "userid";
            int n11 = CursorUtil.getColumnIndexOrThrow(cursor, string3);
            String string4 = "phoneid";
            int n12 = CursorUtil.getColumnIndexOrThrow(cursor, string4);
            String string5 = "model";
            int n13 = CursorUtil.getColumnIndexOrThrow(cursor, string5);
            String string6 = "deviceid";
            int n14 = CursorUtil.getColumnIndexOrThrow(cursor, string6);
            String string7 = "bts";
            int n15 = CursorUtil.getColumnIndexOrThrow(cursor, string7);
            String string8 = "ets";
            int n16 = CursorUtil.getColumnIndexOrThrow(cursor, string8);
            String string9 = "longitude";
            int n17 = CursorUtil.getColumnIndexOrThrow(cursor, string9);
            String string10 = "latitude";
            int n18 = CursorUtil.getColumnIndexOrThrow(cursor, string10);
            String string11 = "serial_num";
            int n19 = CursorUtil.getColumnIndexOrThrow(cursor, string11);
            int n20 = cursor.getCount();
            ArrayList<Object> arrayList = new ArrayList<Object>(n20);
            while ((n20 = (int)(cursor.moveToNext() ? 1 : 0)) != 0) {
                Object object;
                Integer n21;
                n20 = (int)(cursor.isNull(n10) ? 1 : 0);
                if (n20 != 0) {
                    n21 = null;
                } else {
                    n20 = cursor.getInt(n10);
                    object = n20;
                    n21 = object;
                }
                String string12 = cursor.getString(n11);
                String string13 = cursor.getString(n12);
                String string14 = cursor.getString(n13);
                String string15 = cursor.getString(n14);
                String string16 = cursor.getString(n15);
                String string17 = cursor.getString(n16);
                String string18 = cursor.getString(n17);
                String string19 = cursor.getString(n18);
                String string20 = cursor.getString(n19);
                object = new AppDeviceInfo(n21, string12, string13, string14, string15, string16, string17, string18, string19, string20);
                arrayList.add(object);
            }
            return arrayList;
        }
        finally {
            cursor.close();
            roomSQLiteQuery.release();
        }
    }

    public void k(DeviceInfo object) {
        this.a.assertNotSuspendingTransaction();
        Object object2 = this.a;
        ((RoomDatabase)object2).beginTransaction();
        try {
            object2 = this.g;
            ((EntityDeletionOrUpdateAdapter)object2).handle(object);
            object = this.a;
            ((RoomDatabase)object).setTransactionSuccessful();
            return;
        }
        finally {
            this.a.endTransaction();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public List l(int n10) {
        int n11 = 1;
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire("SELECT * FROM device_info ORDER BY create_timestamp DESC LIMIT ?", n11);
        long l10 = n10;
        roomSQLiteQuery.bindLong(n11, l10);
        this.a.assertNotSuspendingTransaction();
        RoomDatabase roomDatabase = this.a;
        n11 = 0;
        int n12 = 0;
        String string2 = null;
        roomDatabase = DBUtil.query(roomDatabase, roomSQLiteQuery, false, null);
        String string3 = "serial";
        try {
            n11 = CursorUtil.getColumnIndexOrThrow((Cursor)roomDatabase, string3);
            string2 = "device_name";
            n12 = CursorUtil.getColumnIndexOrThrow((Cursor)roomDatabase, string2);
            String string4 = "version";
            int n13 = CursorUtil.getColumnIndexOrThrow((Cursor)roomDatabase, string4);
            String string5 = "sub_model";
            int n14 = CursorUtil.getColumnIndexOrThrow((Cursor)roomDatabase, string5);
            String string6 = "create_timestamp";
            int n15 = CursorUtil.getColumnIndexOrThrow((Cursor)roomDatabase, string6);
            String string7 = "update_timestamp";
            int n16 = CursorUtil.getColumnIndexOrThrow((Cursor)roomDatabase, string7);
            int n17 = roomDatabase.getCount();
            ArrayList<DeviceInfo> arrayList = new ArrayList<DeviceInfo>(n17);
            while ((n17 = (int)(roomDatabase.moveToNext() ? 1 : 0)) != 0) {
                DeviceInfo deviceInfo = new DeviceInfo();
                int n18 = roomDatabase.getInt(n11);
                deviceInfo.setSerial(n18);
                Object object = roomDatabase.getString(n12);
                deviceInfo.setDeviceName((String)object);
                object = roomDatabase.getString(n13);
                deviceInfo.setVer((String)object);
                object = roomDatabase.getString(n14);
                b b10 = this.c;
                object = b10.b((String)object);
                deviceInfo.setSubModels((List)object);
                long l11 = roomDatabase.getLong(n15);
                deviceInfo.setCreateTimestamp(l11);
                l11 = roomDatabase.getLong(n16);
                deviceInfo.setUpdateTimestamp(l11);
                arrayList.add(deviceInfo);
            }
            return arrayList;
        }
        finally {
            roomDatabase.close();
            roomSQLiteQuery.release();
        }
    }

    public LiveData m(int n10) {
        int n11 = 1;
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire("SELECT * FROM device_info ORDER BY create_timestamp DESC LIMIT ?", n11);
        long l10 = n10;
        roomSQLiteQuery.bindLong(n11, l10);
        InvalidationTracker invalidationTracker = this.a.getInvalidationTracker();
        String[] stringArray = new String[]{"device_info"};
        d$g d$g = new d$g(this, roomSQLiteQuery);
        return invalidationTracker.createLiveData(stringArray, false, d$g);
    }
}

