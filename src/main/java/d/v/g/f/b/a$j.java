/*
 * Decompiled with CFR 0.151.
 */
package d.v.g.f.b;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import m.a.a;

public final class a$j
extends Migration {
    public a$j(int n10, int n11) {
        super(n10, n11);
    }

    public void migrate(SupportSQLiteDatabase supportSQLiteDatabase) {
        Object[] objectArray = new Object[]{};
        a.i("MIGRATION_9_10, \u7ec4\u4ef6\u6570\u636e\u5e93", objectArray);
        supportSQLiteDatabase.execSQL("DROP TABLE UserInfo");
        supportSQLiteDatabase.execSQL("DROP TABLE CameraParam");
        supportSQLiteDatabase.execSQL("DROP TABLE Works");
        supportSQLiteDatabase.execSQL("DROP TABLE Likes");
        supportSQLiteDatabase.execSQL("DROP TABLE PublishWorks");
        supportSQLiteDatabase.execSQL("DROP TABLE PublishLog");
        supportSQLiteDatabase.execSQL("DROP TABLE MessageLike");
        supportSQLiteDatabase.execSQL("DROP TABLE MessageSystem");
        supportSQLiteDatabase.execSQL("DROP TABLE MessageUnReadCount");
        supportSQLiteDatabase.execSQL("DROP TABLE PrimeInfo");
        supportSQLiteDatabase.execSQL("DROP TABLE CEUpLoadCloudLogInfo");
        supportSQLiteDatabase.execSQL("DROP TABLE SplashAd");
        supportSQLiteDatabase.execSQL("DROP TABLE SplashAdWatch");
        supportSQLiteDatabase.execSQL("DROP TABLE Feedback");
        supportSQLiteDatabase.execSQL("ALTER TABLE firmware_info ADD COLUMN before_update_tip TEXT ");
        supportSQLiteDatabase.execSQL("ALTER TABLE firmware_info ADD COLUMN after_update_tip TEXT ");
    }
}

