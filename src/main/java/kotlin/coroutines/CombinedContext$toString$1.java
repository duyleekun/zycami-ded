/*
 * Decompiled with CFR 0.151.
 */
package kotlin.coroutines;

import f.h2.s.p;
import f.h2.t.f0;
import kotlin.coroutines.CoroutineContext$a;
import kotlin.jvm.internal.Lambda;

public final class CombinedContext$toString$1
extends Lambda
implements p {
    public static final CombinedContext$toString$1 INSTANCE;

    static {
        CombinedContext$toString$1 combinedContext$toString$1;
        INSTANCE = combinedContext$toString$1 = new CombinedContext$toString$1();
    }

    public CombinedContext$toString$1() {
        super(2);
    }

    public final String invoke(String string2, CoroutineContext$a coroutineContext$a) {
        f0.p(string2, "acc");
        CharSequence charSequence = "element";
        f0.p(coroutineContext$a, (String)charSequence);
        int n10 = string2.length();
        if (n10 == 0) {
            n10 = 1;
        } else {
            n10 = 0;
            charSequence = null;
        }
        if (n10 != 0) {
            string2 = coroutineContext$a.toString();
        } else {
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append(string2);
            ((StringBuilder)charSequence).append(", ");
            ((StringBuilder)charSequence).append(coroutineContext$a);
            string2 = ((StringBuilder)charSequence).toString();
        }
        return string2;
    }
}

