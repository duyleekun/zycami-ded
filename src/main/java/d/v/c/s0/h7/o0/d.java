/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.s0.h7.o0;

import java.io.File;
import java.util.function.Function;

public final class d
implements Function {
    public static final /* synthetic */ d a;

    static {
        d d10;
        a = d10 = new d();
    }

    public final Object apply(Object object) {
        object = (String)object;
        File file = new File((String)object);
        return file;
    }
}

