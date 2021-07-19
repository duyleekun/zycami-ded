/*
 * Decompiled with CFR 0.151.
 */
package b.b;

import androidx.arch.core.util.Function;
import androidx.room.AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;
import java.util.Locale;

public final class h
implements Function {
    public final /* synthetic */ Locale a;

    public /* synthetic */ h(Locale locale) {
        this.a = locale;
    }

    public final Object apply(Object object) {
        Locale locale = this.a;
        object = (SupportSQLiteDatabase)object;
        return AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase.S(locale, (SupportSQLiteDatabase)object);
    }
}

