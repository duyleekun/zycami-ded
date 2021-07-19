/*
 * Decompiled with CFR 0.151.
 */
package b.b;

import androidx.arch.core.util.Function;
import androidx.sqlite.db.SupportSQLiteDatabase;

public final class r0
implements Function {
    public static final /* synthetic */ r0 a;

    static {
        r0 r02;
        a = r02 = new r0();
    }

    public final Object apply(Object object) {
        return ((SupportSQLiteDatabase)object).getPageSize();
    }
}

