/*
 * Decompiled with CFR 0.151.
 */
package l.a.q.g0;

import java.util.function.Function;
import l.a.q.g0.q$b;

public final class m
implements Function {
    public final /* synthetic */ String a;

    public /* synthetic */ m(String string2) {
        this.a = string2;
    }

    public final Object apply(Object object) {
        String string2 = this.a;
        object = (String)object;
        return q$b.h(string2, (String)object);
    }
}

