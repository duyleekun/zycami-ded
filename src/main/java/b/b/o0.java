/*
 * Decompiled with CFR 0.151.
 */
package b.b;

import androidx.arch.core.util.Function;
import androidx.sqlite.db.SupportSQLiteStatement;

public final class o0
implements Function {
    public static final /* synthetic */ o0 a;

    static {
        o0 o02;
        a = o02 = new o0();
    }

    public final Object apply(Object object) {
        return ((SupportSQLiteStatement)object).simpleQueryForLong();
    }
}

