/*
 * Decompiled with CFR 0.151.
 */
package b.b;

import androidx.arch.core.util.Function;
import androidx.sqlite.db.SupportSQLiteDatabase;

public final class a
implements Function {
    public static final /* synthetic */ a a;

    static {
        a a10;
        a = a10 = new a();
    }

    public final Object apply(Object object) {
        return ((SupportSQLiteDatabase)object).isDbLockedByCurrentThread();
    }
}

