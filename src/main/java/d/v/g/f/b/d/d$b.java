/*
 * Decompiled with CFR 0.151.
 */
package d.v.g.f.b.d;

import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.zhiyun.device.data.local.entity.AppDeviceInfo;
import d.v.g.f.b.d.d;

public class d$b
extends EntityInsertionAdapter {
    public final /* synthetic */ d a;

    public d$b(d d10, RoomDatabase roomDatabase) {
        this.a = d10;
        super(roomDatabase);
    }

    public void a(SupportSQLiteStatement supportSQLiteStatement, AppDeviceInfo object) {
        Object object2 = ((AppDeviceInfo)object).getId();
        int n10 = 1;
        if (object2 == null) {
            supportSQLiteStatement.bindNull(n10);
        } else {
            object2 = ((AppDeviceInfo)object).getId();
            int n11 = (Integer)object2;
            long l10 = n11;
            supportSQLiteStatement.bindLong(n10, l10);
        }
        object2 = ((AppDeviceInfo)object).getUserid();
        n10 = 2;
        if (object2 == null) {
            supportSQLiteStatement.bindNull(n10);
        } else {
            object2 = ((AppDeviceInfo)object).getUserid();
            supportSQLiteStatement.bindString(n10, (String)object2);
        }
        object2 = ((AppDeviceInfo)object).getPhoneid();
        n10 = 3;
        if (object2 == null) {
            supportSQLiteStatement.bindNull(n10);
        } else {
            object2 = ((AppDeviceInfo)object).getPhoneid();
            supportSQLiteStatement.bindString(n10, (String)object2);
        }
        object2 = ((AppDeviceInfo)object).getModel();
        n10 = 4;
        if (object2 == null) {
            supportSQLiteStatement.bindNull(n10);
        } else {
            object2 = ((AppDeviceInfo)object).getModel();
            supportSQLiteStatement.bindString(n10, (String)object2);
        }
        object2 = ((AppDeviceInfo)object).getDeviceid();
        n10 = 5;
        if (object2 == null) {
            supportSQLiteStatement.bindNull(n10);
        } else {
            object2 = ((AppDeviceInfo)object).getDeviceid();
            supportSQLiteStatement.bindString(n10, (String)object2);
        }
        object2 = ((AppDeviceInfo)object).getBts();
        n10 = 6;
        if (object2 == null) {
            supportSQLiteStatement.bindNull(n10);
        } else {
            object2 = ((AppDeviceInfo)object).getBts();
            supportSQLiteStatement.bindString(n10, (String)object2);
        }
        object2 = ((AppDeviceInfo)object).getEts();
        n10 = 7;
        if (object2 == null) {
            supportSQLiteStatement.bindNull(n10);
        } else {
            object2 = ((AppDeviceInfo)object).getEts();
            supportSQLiteStatement.bindString(n10, (String)object2);
        }
        object2 = ((AppDeviceInfo)object).getLongitude();
        n10 = 8;
        if (object2 == null) {
            supportSQLiteStatement.bindNull(n10);
        } else {
            object2 = ((AppDeviceInfo)object).getLongitude();
            supportSQLiteStatement.bindString(n10, (String)object2);
        }
        object2 = ((AppDeviceInfo)object).getLatitude();
        n10 = 9;
        if (object2 == null) {
            supportSQLiteStatement.bindNull(n10);
        } else {
            object2 = ((AppDeviceInfo)object).getLatitude();
            supportSQLiteStatement.bindString(n10, (String)object2);
        }
        object2 = ((AppDeviceInfo)object).getSerial_num();
        n10 = 10;
        if (object2 == null) {
            supportSQLiteStatement.bindNull(n10);
        } else {
            object = ((AppDeviceInfo)object).getSerial_num();
            supportSQLiteStatement.bindString(n10, (String)object);
        }
    }

    public String createQuery() {
        return "INSERT OR REPLACE INTO `AppDeviceInfo` (`id`,`userid`,`phoneid`,`model`,`deviceid`,`bts`,`ets`,`longitude`,`latitude`,`serial_num`) VALUES (?,?,?,?,?,?,?,?,?,?)";
    }
}

