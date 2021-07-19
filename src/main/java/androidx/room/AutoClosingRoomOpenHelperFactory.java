/*
 * Decompiled with CFR 0.151.
 */
package androidx.room;

import androidx.room.AutoCloser;
import androidx.room.AutoClosingRoomOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper$Configuration;
import androidx.sqlite.db.SupportSQLiteOpenHelper$Factory;

public final class AutoClosingRoomOpenHelperFactory
implements SupportSQLiteOpenHelper$Factory {
    private final AutoCloser mAutoCloser;
    private final SupportSQLiteOpenHelper$Factory mDelegate;

    public AutoClosingRoomOpenHelperFactory(SupportSQLiteOpenHelper$Factory supportSQLiteOpenHelper$Factory, AutoCloser autoCloser) {
        this.mDelegate = supportSQLiteOpenHelper$Factory;
        this.mAutoCloser = autoCloser;
    }

    public AutoClosingRoomOpenHelper create(SupportSQLiteOpenHelper$Configuration object) {
        object = this.mDelegate.create((SupportSQLiteOpenHelper$Configuration)object);
        AutoCloser autoCloser = this.mAutoCloser;
        AutoClosingRoomOpenHelper autoClosingRoomOpenHelper = new AutoClosingRoomOpenHelper((SupportSQLiteOpenHelper)object, autoCloser);
        return autoClosingRoomOpenHelper;
    }
}

