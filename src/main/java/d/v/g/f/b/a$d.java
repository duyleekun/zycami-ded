/*
 * Decompiled with CFR 0.151.
 */
package d.v.g.f.b;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import m.a.a;

public final class a$d
extends Migration {
    public a$d(int n10, int n11) {
        super(n10, n11);
    }

    public void migrate(SupportSQLiteDatabase supportSQLiteDatabase) {
        Object[] objectArray = new Object[]{};
        a.i("MIGRATION_3_4, \u6570\u636e\u5e93", objectArray);
        supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `SplashAd` (`id` INTEGER NOT NULL, `code` TEXT, `text` TEXT, `image` TEXT, `url` TEXT, `refType` TEXT, `refId` INTEGER NOT NULL, `type` INTEGER NOT NULL, `period` INTEGER NOT NULL, `region` TEXT, `startAt` TEXT, `endAt` TEXT, `startUnix` INTEGER NOT NULL, `endUnix` INTEGER NOT NULL, `filePath` TEXT, `isVideo` INTEGER NOT NULL, `isAutoDisappear` INTEGER NOT NULL, `lang` TEXT, `watchId` INTEGER, `isWatched` INTEGER, `watchTime` INTEGER, PRIMARY KEY(`id`))");
        supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `SplashAdWatch` (`watchId` INTEGER NOT NULL, `isWatched` INTEGER NOT NULL, `watchTime` INTEGER NOT NULL, PRIMARY KEY(`watchId`))");
        supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `MessageUnReadCount` (`id` INTEGER NOT NULL, `message` INTEGER NOT NULL, `comment` INTEGER NOT NULL, `follow` INTEGER NOT NULL, `like` INTEGER NOT NULL, `personal` INTEGER NOT NULL, `notice` INTEGER NOT NULL, PRIMARY KEY(`id`))");
        supportSQLiteDatabase.execSQL("ALTER TABLE PublishWorks ADD COLUMN archive TEXT");
    }
}

