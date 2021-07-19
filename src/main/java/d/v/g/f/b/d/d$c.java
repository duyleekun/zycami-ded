/*
 * Decompiled with CFR 0.151.
 */
package d.v.g.f.b.d;

import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.zhiyun.device.data.local.entity.DeviceInfo;
import d.v.g.f.b.d.d;

public class d$c
extends EntityDeletionOrUpdateAdapter {
    public final /* synthetic */ d a;

    public d$c(d d10, RoomDatabase roomDatabase) {
        this.a = d10;
        super(roomDatabase);
    }

    public void a(SupportSQLiteStatement supportSQLiteStatement, DeviceInfo deviceInfo) {
        long l10 = deviceInfo.getSerial();
        supportSQLiteStatement.bindLong(1, l10);
    }

    public String createQuery() {
        return "DELETE FROM `device_info` WHERE `serial` = ?";
    }
}

