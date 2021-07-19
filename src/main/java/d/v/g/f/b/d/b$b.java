/*
 * Decompiled with CFR 0.151.
 */
package d.v.g.f.b.d;

import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.zhiyun.device.data.local.entity.ActivationData;
import d.v.g.f.b.d.b;

public class b$b
extends EntityDeletionOrUpdateAdapter {
    public final /* synthetic */ b a;

    public b$b(b b10, RoomDatabase roomDatabase) {
        this.a = b10;
        super(roomDatabase);
    }

    public void a(SupportSQLiteStatement supportSQLiteStatement, ActivationData activationData) {
        long l10 = activationData.getId();
        supportSQLiteStatement.bindLong(1, l10);
    }

    public String createQuery() {
        return "DELETE FROM `activation_data` WHERE `id` = ?";
    }
}

