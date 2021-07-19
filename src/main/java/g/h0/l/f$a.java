/*
 * Decompiled with CFR 0.151.
 */
package g.h0.l;

import f.h2.t.u;
import g.h0.l.f;
import java.io.IOException;
import java.util.logging.Logger;

public final class f$a {
    private f$a() {
    }

    public /* synthetic */ f$a(u u10) {
        this();
    }

    public final Logger a() {
        return f.a();
    }

    public final int b(int n10, int n11, int n12) {
        if ((n11 &= 8) != 0) {
            n10 += -1;
        }
        if (n12 <= n10) {
            return n10 - n12;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("PROTOCOL_ERROR padding ");
        stringBuilder.append(n12);
        stringBuilder.append(" > remaining length ");
        stringBuilder.append(n10);
        String string2 = stringBuilder.toString();
        IOException iOException = new IOException(string2);
        throw iOException;
    }
}

