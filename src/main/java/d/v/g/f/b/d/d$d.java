/*
 * Decompiled with CFR 0.151.
 */
package d.v.g.f.b.d;

import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.zhiyun.device.data.local.entity.AppDeviceInfo;
import d.v.g.f.b.d.d;

public class d$d
extends EntityDeletionOrUpdateAdapter {
    public final /* synthetic */ d a;

    public d$d(d d10, RoomDatabase roomDatabase) {
        this.a = d10;
        super(roomDatabase);
    }

    public void a(SupportSQLiteStatement supportSQLiteStatement, AppDeviceInfo object) {
        Integer n10 = ((AppDeviceInfo)object).getId();
        int n11 = 1;
        if (n10 == null) {
            supportSQLiteStatement.bindNull(n11);
        } else {
            object = ((AppDeviceInfo)object).getId();
            int n12 = (Integer)object;
            long l10 = n12;
            supportSQLiteStatement.bindLong(n11, l10);
        }
    }

    public String createQuery() {
        return "DELETE FROM `AppDeviceInfo` WHERE `id` = ?";
    }
}

