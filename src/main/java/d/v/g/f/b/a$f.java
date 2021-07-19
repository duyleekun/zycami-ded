/*
 * Decompiled with CFR 0.151.
 */
package d.v.g.f.b;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import m.a.a;

public final class a$f
extends Migration {
    public a$f(int n10, int n11) {
        super(n10, n11);
    }

    public void migrate(SupportSQLiteDatabase supportSQLiteDatabase) {
        Object[] objectArray = new Object[]{};
        a.i("MIGRATION_5_6, \u6570\u636e\u5e93", objectArray);
        supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `Feedback` (`errcode` INTEGER NOT NULL, `errmsg` TEXT, `id` INTEGER NOT NULL, `userId` INTEGER NOT NULL, `name` TEXT, `contact` TEXT, `title` TEXT, `content` TEXT, `type` TEXT, `platform` TEXT, `mobileModel` TEXT, `mobileOSVersion` TEXT, `appVersion` TEXT, `deviceModel` TEXT, `images` TEXT, `user_lang` TEXT, `firmwareVersion` TEXT, `frequency` INTEGER NOT NULL, `advice_target` TEXT, `dealStatus` INTEGER NOT NULL, `createAt` TEXT, `closedAt` TEXT, `canActive` INTEGER NOT NULL, PRIMARY KEY(`id`))");
    }
}

