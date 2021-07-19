/*
 * Decompiled with CFR 0.151.
 */
package b.b;

import androidx.arch.core.util.Function;
import androidx.sqlite.db.SupportSQLiteDatabase;

public final class b
implements Function {
    public static final /* synthetic */ b a;

    static {
        b b10;
        a = b10 = new b();
    }

    public final Object apply(Object object) {
        return ((SupportSQLiteDatabase)object).isReadOnly();
    }
}

