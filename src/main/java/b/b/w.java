/*
 * Decompiled with CFR 0.151.
 */
package b.b;

import androidx.arch.core.util.Function;
import androidx.sqlite.db.SupportSQLiteStatement;

public final class w
implements Function {
    public static final /* synthetic */ w a;

    static {
        w w10;
        a = w10 = new w();
    }

    public final Object apply(Object object) {
        return ((SupportSQLiteStatement)object).simpleQueryForString();
    }
}

