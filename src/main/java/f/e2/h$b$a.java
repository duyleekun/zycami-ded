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

public final class h$b$a
extends h$a {
    private boolean b;
    private File[] c;
    private int d;
    private boolean e;
    public final /* synthetic */ h$b f;

    public h$b$a(h$b h$b, File file) {
        f0.p(file, "rootDir");
        this.f = h$b;
        super(file);
    }

    public File b() {
        Object object;
        int n10 = this.e;
        int n11 = 0;
        int n12 = 1;
        if (n10 == 0 && (object = this.c) == null) {
            File file;
            object = h.e(this.f.d);
            if (object != null && (n10 = (int)(((Boolean)(object = (Boolean)object.invoke(file = this.a()))).booleanValue() ? 1 : 0)) == 0) {
                return null;
            }
            object = this.a().listFiles();
            this.c = object;
            if (object == null) {
                object = h.f(this.f.d);
                if (object != null) {
                    file = this.a();
                    File file2 = this.a();
                    int n13 = 2;
                    String string2 = "Cannot list files in a directory";
                    AccessDeniedException accessDeniedException = new AccessDeniedException(file2, null, string2, n13, null);
                    object = (q1)object.invoke(file, accessDeniedException);
                }
                this.e = n12;
            }
        }
        if ((object = this.c) != null) {
            int n14 = this.d;
            f0.m(object);
            n10 = ((File[])object).length;
            if (n14 < n10) {
                object = this.c;
                f0.m(object);
                n11 = this.d;
                this.d = n12 = n11 + 1;
                return object[n11];
            }
        }
        if ((n10 = this.b) == 0) {
            this.b = n12;
            return this.a();
        }
        object = h.g(this.f.d);
        if (object != null) {
            File file = this.a();
            object = (q1)object.invoke(file);
        }
        return null;
    }
}

