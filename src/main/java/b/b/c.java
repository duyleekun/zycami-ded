/*
 * Decompiled with CFR 0.151.
 */
package b.b;

import androidx.arch.core.util.Function;
import androidx.sqlite.db.SupportSQLiteDatabase;

public final class c
implements Function {
    public static final /* synthetic */ c a;

    static {
        c c10;
        a = c10 = new c();
    }

    public final Object apply(Object object) {
        return ((SupportSQLiteDatabase)object).isDatabaseIntegrityOk();
    }
}

