/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.g1;

import java.io.File;
import java.io.FileFilter;

public final class a
implements FileFilter {
    public static final /* synthetic */ a a;

    static {
        a a10;
        a = a10 = new a();
    }

    public final boolean accept(File file) {
        return file.isDirectory();
    }
}

