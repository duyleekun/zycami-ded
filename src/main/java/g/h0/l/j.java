/*
 * Decompiled with CFR 0.151.
 */
package g.h0.l;

import g.h0.l.j$a;
import g.h0.l.j$a$a;
import h.o;
import java.util.List;
import okhttp3.internal.http2.ErrorCode;

public interface j {
    public static final j a;
    public static final j$a b;

    static {
        Object object = new j$a(null);
        b = object;
        a = object = new j$a$a();
    }

    public void a(int var1, ErrorCode var2);

    public boolean b(int var1, List var2);

    public boolean c(int var1, List var2, boolean var3);

    public boolean d(int var1, o var2, int var3, boolean var4);
}

