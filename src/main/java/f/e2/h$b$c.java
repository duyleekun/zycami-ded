/*
 * Decompiled with CFR 0.151.
 */
package f.e2;

import f.e2.h;
import f.e2.h$a;
import f.e2.h$b;
import f.h2.t.f0;
import f.q1;
import java.io.File;
import kotlin.io.AccessDeniedException;

public final class h$b$c
extends h$a {
    private boolean b;
    private File[] c;
    private int d;
    public final /* synthetic */ h$b e;

    public h$b$c(h$b h$b, File file) {
        f0.p(file, "rootDir");
        this.e = h$b;
        super(file);
    }

    public File b() {
        int n10;
        Object object;
        int n11;
        block10: {
            File file;
            block11: {
                int n12 = this.b;
                n11 = 0;
                if (n12 == 0) {
                    File file2;
                    Object object2 = h.e(this.e.d);
                    if (object2 != null && (n12 = (int)(((Boolean)(object2 = (Boolean)object2.invoke(file2 = this.a()))).booleanValue() ? 1 : 0)) == 0) {
                        return null;
                    }
                    this.b = true;
                    return this.a();
                }
                object = this.c;
                if (object != null) {
                    n10 = this.d;
                    f0.m(object);
                    n12 = ((File[])object).length;
                    if (n10 >= n12) {
                        object = h.g(this.e.d);
                        if (object != null) {
                            File file3 = this.a();
                            object = (q1)object.invoke(file3);
                        }
                        return null;
                    }
                }
                if ((object = this.c) != null) break block10;
                object = this.a().listFiles();
                this.c = object;
                if (object == null && (object = h.f(this.e.d)) != null) {
                    file = this.a();
                    File file4 = this.a();
                    int n13 = 2;
                    String string2 = "Cannot list files in a directory";
                    AccessDeniedException accessDeniedException = new AccessDeniedException(file4, null, string2, n13, null);
                    object = (q1)object.invoke(file, accessDeniedException);
                }
                if ((object = this.c) == null) break block11;
                f0.m(object);
                n12 = ((File[])object).length;
                if (n12 != 0) break block10;
            }
            if ((object = h.g(this.e.d)) != null) {
                file = this.a();
                object = (q1)object.invoke(file);
            }
            return null;
        }
        object = this.c;
        f0.m(object);
        n11 = this.d;
        this.d = n10 = n11 + 1;
        return object[n11];
    }
}

