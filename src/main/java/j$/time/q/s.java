/*
 * Decompiled with CFR 0.151.
 */
package j$.time.q;

import j$.time.c;
import j$.time.q.b_0;
import j$.time.q.d;
import j$.time.q.e;
import j$.time.q.h;
import j$.time.q.u;
import j$.time.q.w;
import j$.time.q.y;
import j$.time.q.z;
import java.io.Serializable;
import java.util.Objects;

public interface s {
    default public Object d(w w10) {
        w w11 = d.a;
        if (w10 != w11 && w10 != (w11 = b_0.a) && w10 != (w11 = e.a)) {
            return w10.a(this);
        }
        return null;
    }

    public boolean g(u var1);

    public long h(u var1);

    default public z i(u object) {
        boolean bl2 = object instanceof h;
        if (bl2) {
            bl2 = this.g((u)object);
            if (bl2) {
                return object.x();
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Unsupported field: ");
            stringBuilder.append(object);
            object = stringBuilder.toString();
            y y10 = new y((String)object);
            throw y10;
        }
        Objects.requireNonNull(object, "field");
        return object.D(this);
    }

    default public int k(u object) {
        Serializable serializable = this.i((u)object);
        boolean bl2 = ((z)serializable).g();
        if (bl2) {
            long l10 = this.h((u)object);
            boolean bl3 = ((z)serializable).h(l10);
            if (bl3) {
                return (int)l10;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Invalid value for ");
            stringBuilder.append(object);
            stringBuilder.append(" (valid values ");
            stringBuilder.append(serializable);
            stringBuilder.append("): ");
            stringBuilder.append(l10);
            object = stringBuilder.toString();
            c c10 = new c((String)object);
            throw c10;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Invalid field ");
        stringBuilder.append(object);
        stringBuilder.append(" for get() method, use getLong() instead");
        object = stringBuilder.toString();
        serializable = new y((String)object);
        throw serializable;
    }
}

