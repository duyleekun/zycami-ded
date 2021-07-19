/*
 * Decompiled with CFR 0.151.
 */
package d.v.q.h;

import d.v.q.h.i;
import java.io.File;
import java.io.FilenameFilter;

public final class b
implements FilenameFilter {
    public static final /* synthetic */ b a;

    static {
        b b10;
        a = b10 = new b();
    }

    public final boolean accept(File file, String string2) {
        return i.c(file, string2);
    }
}

