/*
 * Decompiled with CFR 0.151.
 */
package d.v.g.f.b.d;

import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.zhiyun.device.data.local.entity.RegionalRestrictionsInfo;
import d.v.g.f.b.d.h;

public class h$a
extends EntityInsertionAdapter {
    public final /* synthetic */ h a;

    public h$a(h h10, RoomDatabase roomDatabase) {
        this.a = h10;
        super(roomDatabase);
    }

    public void a(SupportSQLiteStatement supportSQLiteStatement, RegionalRestrictionsInfo regionalRestrictionsInfo) {
        int n10 = regionalRestrictionsInfo.getId();
        long l10 = n10;
        int n11 = 1;
        supportSQLiteStatement.bindLong(n11, l10);
        String string2 = regionalRestrictionsInfo.getDeviceName();
        int n12 = 2;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n12);
        } else {
            string2 = regionalRestrictionsInfo.getDeviceName();
            supportSQLiteStatement.bindString(n12, string2);
        }
        string2 = regionalRestrictionsInfo.getDeviceSn();
        n12 = 3;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n12);
        } else {
            string2 = regionalRestrictionsInfo.getDeviceSn();
            supportSQLiteStatement.bindString(n12, string2);
        }
        long l11 = (long)regionalRestrictionsInfo.isRestrictions();
        supportSQLiteStatement.bindLong(4, l11);
    }

    public String createQuery() {
        return "INSERT OR REPLACE INTO `regional_restrictions_info` (`id`,`deviceName`,`deviceSn`,`isRestrictions`) VALUES (nullif(?, 0),?,?,?)";
    }
}

