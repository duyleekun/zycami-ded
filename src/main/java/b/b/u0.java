/*
 * Decompiled with CFR 0.151.
 */
package b.b;

import androidx.arch.core.util.Function;
import androidx.sqlite.db.SupportSQLiteDatabase;

public final class u0
implements Function {
    public static final /* synthetic */ u0 a;

    static {
        u0 u02;
        a = u02 = new u0();
    }

    public final Object apply(Object object) {
        return ((SupportSQLiteDatabase)object).yieldIfContendedSafely();
    }
}

