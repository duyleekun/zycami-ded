/*
 * Decompiled with CFR 0.151.
 */
package b.b;

import androidx.arch.core.util.Function;
import androidx.sqlite.db.SupportSQLiteDatabase;

public final class s0
implements Function {
    public static final /* synthetic */ s0 a;

    static {
        s0 s02;
        a = s02 = new s0();
    }

    public final Object apply(Object object) {
        return ((SupportSQLiteDatabase)object).getVersion();
    }
}

