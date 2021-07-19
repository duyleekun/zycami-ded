/*
 * Decompiled with CFR 0.151.
 */
package f.e2;

import f.h2.t.f0;
import java.io.File;

public abstract class h$c {
    private final File a;

    public h$c(File file) {
        f0.p(file, "root");
        this.a = file;
    }

    public final File a() {
        return this.a;
    }

    public abstract File b();
}

