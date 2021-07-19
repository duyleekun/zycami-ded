/*
 * Decompiled with CFR 0.151.
 */
package d.v.g.f.b.d;

import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.zhiyun.device.data.local.entity.RegionalRestrictionsInfo;
import d.v.g.f.b.d.h;

public class h$b
extends EntityDeletionOrUpdateAdapter {
    public final /* synthetic */ h a;

    public h$b(h h10, RoomDatabase roomDatabase) {
        this.a = h10;
        super(roomDatabase);
    }

    public void a(SupportSQLiteStatement supportSQLiteStatement, RegionalRestrictionsInfo regionalRestrictionsInfo) {
        long l10 = regionalRestrictionsInfo.getId();
        supportSQLiteStatement.bindLong(1, l10);
    }

    public String createQuery() {
        return "DELETE FROM `regional_restrictions_info` WHERE `id` = ?";
    }
}

