/*
 * Decompiled with CFR 0.151.
 */
package d.c.a.o.k.z;

import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

public class b$a
implements FilenameFilter {
    public final /* synthetic */ Pattern a;

    public b$a(Pattern pattern) {
        this.a = pattern;
    }

    public boolean accept(File file, String string2) {
        return this.a.matcher(string2).matches();
    }
}

