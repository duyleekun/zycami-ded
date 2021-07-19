/*
 * Decompiled with CFR 0.151.
 */
package d.n.a.q0.x;

import e.a.v0.o;

public final class m$a
implements o {
    public Boolean a(Long l10) {
        long l11;
        long l12 = l10;
        long l13 = l12 - (l11 = 0L);
        Object object = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
        if (object == false) {
            object = 1;
        } else {
            object = 0;
            l10 = null;
        }
        return (boolean)object;
    }
}

