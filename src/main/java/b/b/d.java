/*
 * Decompiled with CFR 0.151.
 */
package b.b;

import androidx.arch.core.util.Function;
import androidx.sqlite.db.SupportSQLiteDatabase;

public final class d
implements Function {
    public static final /* synthetic */ d a;

    static {
        d d10;
        a = d10 = new d();
    }

    public final Object apply(Object object) {
        return ((SupportSQLiteDatabase)object).getMaximumSize();
    }
}

