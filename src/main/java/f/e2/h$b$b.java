/*
 * Decompiled with CFR 0.151.
 */
package f.e2;

import f.e2.h$b;
import f.e2.h$c;
import f.h2.t.f0;
import java.io.File;

public final class h$b$b
extends h$c {
    private boolean b;
    public final /* synthetic */ h.b c;

    public h$b$b(h.b b10, File file) {
        f0.p(file, "rootFile");
        this.c = b10;
        super(file);
    }

    public File b() {
        boolean bl2 = this.b;
        if (bl2) {
            return null;
        }
        this.b = true;
        return this.a();
    }
}

