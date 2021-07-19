/*
 * Decompiled with CFR 0.151.
 */
package g.h0.q;

import g.h0.h.a;
import g.h0.q.e;
import java.io.IOException;

public final class e$e
extends a {
    public final /* synthetic */ e e;

    public e$e(e object) {
        this.e = object;
        StringBuilder stringBuilder = new StringBuilder();
        object = g.h0.q.e.j((e)object);
        stringBuilder.append((String)object);
        stringBuilder.append(" writer");
        object = stringBuilder.toString();
        super((String)object, false, 2, null);
    }

    public long f() {
        e e10 = this.e;
        try {
            boolean bl2 = e10.F();
            if (bl2) {
                return 0L;
            }
        }
        catch (IOException iOException) {
            e e11 = this.e;
            e11.r(iOException, null);
        }
        return -1;
    }
}

