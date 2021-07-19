/*
 * Decompiled with CFR 0.151.
 */
package b.b;

import androidx.arch.core.util.Function;
import androidx.sqlite.db.SupportSQLiteStatement;

public final class t0
implements Function {
    public static final /* synthetic */ t0 a;

    static {
        t0 t02;
        a = t02 = new t0();
    }

    public final Object apply(Object object) {
        return ((SupportSQLiteStatement)object).executeInsert();
    }
}

