/*
 * Decompiled with CFR 0.151.
 */
package b.b;

import androidx.arch.core.util.Function;
import androidx.sqlite.db.SupportSQLiteStatement;

public final class x0
implements Function {
    public static final /* synthetic */ x0 a;

    static {
        x0 x02;
        a = x02 = new x0();
    }

    public final Object apply(Object object) {
        return ((SupportSQLiteStatement)object).executeUpdateDelete();
    }
}

