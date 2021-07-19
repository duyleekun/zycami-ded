/*
 * Decompiled with CFR 0.151.
 */
package d.v.g.f.b.d;

import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.zhiyun.device.data.local.entity.DeviceInfo;
import d.v.g.f.b.b;
import d.v.g.f.b.d.d;
import java.util.List;

public class d$e
extends EntityDeletionOrUpdateAdapter {
    public final /* synthetic */ d a;

    public d$e(d d10, RoomDatabase roomDatabase) {
        this.a = d10;
        super(roomDatabase);
    }

    public void a(SupportSQLiteStatement supportSQLiteStatement, DeviceInfo deviceInfo) {
        int n10 = deviceInfo.getSerial();
        long l10 = n10;
        int n11 = 1;
        supportSQLiteStatement.bindLong(n11, l10);
        Object object = deviceInfo.getDeviceName();
        int n12 = 2;
        if (object == null) {
            supportSQLiteStatement.bindNull(n12);
        } else {
            object = deviceInfo.getDeviceName();
            supportSQLiteStatement.bindString(n12, (String)object);
        }
        object = deviceInfo.getVer();
        n12 = 3;
        if (object == null) {
            supportSQLiteStatement.bindNull(n12);
        } else {
            object = deviceInfo.getVer();
            supportSQLiteStatement.bindString(n12, (String)object);
        }
        object = d.n(this.a);
        List list = deviceInfo.getSubModels();
        object = ((b)object).a(list);
        n12 = 4;
        if (object == null) {
            supportSQLiteStatement.bindNull(n12);
        } else {
            supportSQLiteStatement.bindString(n12, (String)object);
        }
        long l11 = deviceInfo.getCreateTimestamp();
        supportSQLiteStatement.bindLong(5, l11);
        l11 = deviceInfo.getUpdateTimestamp();
        supportSQLiteStatement.bindLong(6, l11);
        l11 = deviceInfo.getSerial();
        supportSQLiteStatement.bindLong(7, l11);
    }

    public String createQuery() {
        return "UPDATE OR REPLACE `device_info` SET `serial` = ?,`device_name` = ?,`version` = ?,`sub_model` = ?,`create_timestamp` = ?,`update_timestamp` = ? WHERE `serial` = ?";
    }
}

