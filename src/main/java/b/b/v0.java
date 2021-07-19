/*
 * Decompiled with CFR 0.151.
 */
package b.b;

import androidx.arch.core.util.Function;
import androidx.sqlite.db.SupportSQLiteDatabase;

public final class v0
implements Function {
    public static final /* synthetic */ v0 a;

    static {
        v0 v02;
        a = v02 = new v0();
    }

    public final Object apply(Object object) {
        return ((SupportSQLiteDatabase)object).getAttachedDbs();
    }
}

