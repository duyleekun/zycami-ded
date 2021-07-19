/*
 * Decompiled with CFR 0.151.
 */
package b.b;

import androidx.arch.core.util.Function;
import androidx.sqlite.db.SupportSQLiteDatabase;

public final class e
implements Function {
    public static final /* synthetic */ e a;

    static {
        e e10;
        a = e10 = new e();
    }

    public final Object apply(Object object) {
        return ((SupportSQLiteDatabase)object).getPath();
    }
}

