/*
 * Decompiled with CFR 0.151.
 */
package d.v.e0;

import d.v.e0.ce;
import e.a.v0.o;
import java.util.List;

public final class la
implements o {
    public final /* synthetic */ long a;
    public final /* synthetic */ List b;

    public /* synthetic */ la(long l10, List list) {
        this.a = l10;
        this.b = list;
    }

    public final Object apply(Object object) {
        long l10 = this.a;
        List list = this.b;
        object = (Boolean)object;
        return ce.m4(l10, list, (Boolean)object);
    }
}

