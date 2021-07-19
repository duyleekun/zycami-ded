/*
 * Decompiled with CFR 0.151.
 */
package j$.time.format;

import j$.time.format.f;
import j$.time.format.v;
import j$.time.k;
import j$.time.q.w;

class r
implements f {
    private final w a;
    private final String b;

    r(w w10, String string2) {
        this.a = w10;
        this.b = string2;
    }

    public boolean m(v object, StringBuilder stringBuilder) {
        w w10 = this.a;
        if ((object = (k)((v)object).f(w10)) == null) {
            return false;
        }
        object = ((k)object).q();
        stringBuilder.append((String)object);
        return true;
    }

    public String toString() {
        return this.b;
    }
}

