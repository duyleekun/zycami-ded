/*
 * Decompiled with CFR 0.151.
 */
package b.b;

import androidx.arch.core.util.Function;
import androidx.sqlite.db.SupportSQLiteDatabase;

public final class v
implements Function {
    public static final /* synthetic */ v a;

    static {
        v v10;
        a = v10 = new v();
    }

    public final Object apply(Object object) {
        return ((SupportSQLiteDatabase)object).inTransaction();
    }
}

