/*
 * Decompiled with CFR 0.151.
 */
package j$.time;

import j$.time.b;
import j$.time.k;
import java.io.Serializable;

final class a
extends b
implements Serializable {
    private final k a;

    a(k k10) {
        this.a = k10;
    }

    public k a() {
        return this.a;
    }

    public boolean equals(Object object) {
        boolean bl2 = object instanceof a;
        if (bl2) {
            k k10 = this.a;
            object = ((a)object).a;
            return k10.equals(object);
        }
        return false;
    }

    public int hashCode() {
        return this.a.hashCode() + 1;
    }

    public String toString() {
        StringBuilder stringBuilder = j$.e.a.a.a.a.b("SystemClock[");
        k k10 = this.a;
        stringBuilder.append(k10);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}

