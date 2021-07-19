/*
 * Decompiled with CFR 0.151.
 */
package h;

import f.h2.s.a;
import f.h2.t.c0;
import f.h2.t.f0;
import f.q2.d;
import java.nio.charset.Charset;

public final class i {
    public static final byte[] a(String object) {
        f0.p(object, "$this$asUtf8ToByteArray");
        Charset charset = d.a;
        object = ((String)object).getBytes(charset);
        f0.o(object, "(this as java.lang.String).getBytes(charset)");
        return object;
    }

    public static final Object b(Object object, a object2) {
        f0.p(object, "lock");
        String string2 = "block";
        f0.p(object2, string2);
        synchronized (object) {
            int n10 = 1;
            try {
                object2 = object2.invoke();
                return object2;
            }
            finally {
                c0.d(n10);
                // MONITOREXIT @DISABLED, blocks:[1, 3] lbl11 : MonitorExitStatement: MONITOREXIT : var0
                c0.c(n10);
            }
        }
    }

    public static final String c(byte[] byArray) {
        f0.p(byArray, "$this$toUtf8String");
        Charset charset = d.a;
        String string2 = new String(byArray, charset);
        return string2;
    }
}

