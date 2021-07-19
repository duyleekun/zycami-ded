/*
 * Decompiled with CFR 0.151.
 */
package j$.time.p;

import j$.e.a.a.a.a;
import j$.time.p.b;
import j$.time.p.j;
import j$.time.q.r;
import j$.time.q.t;
import java.io.Serializable;

abstract class c
implements b,
r,
t,
Serializable {
    static b m(j object, r r10) {
        Object object2 = (r10 = (b)r10).f();
        boolean bl2 = object.equals(object2);
        if (bl2) {
            return r10;
        }
        StringBuilder stringBuilder = a.b("Chronology mismatch, expected: ");
        object = object.q();
        stringBuilder.append((String)object);
        stringBuilder.append(", actual: ");
        object = r10.f().q();
        stringBuilder.append((String)object);
        object = stringBuilder.toString();
        object2 = new ClassCastException((String)object);
        throw object2;
    }
}

