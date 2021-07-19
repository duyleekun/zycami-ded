/*
 * Decompiled with CFR 0.151.
 */
package j$.time.p;

import j$.e.a.a.a.a;
import j$.time.Instant;
import j$.time.c;
import j$.time.f;
import j$.time.p.b;
import j$.time.p.d;
import j$.time.p.g;
import j$.time.p.i;
import j$.time.p.k;
import j$.time.q.b_0;
import j$.time.q.s;
import java.io.Serializable;
import java.util.Objects;

public interface j
extends Comparable {
    public static j A(s object) {
        Objects.requireNonNull(object, "temporal");
        b_0 b_02 = b_0.a;
        object = (j)object.d(b_02);
        if (object == null) {
            object = k.a;
        }
        return object;
    }

    public b B(int var1, int var2, int var3);

    default public j.d I(s object) {
        Serializable serializable;
        b b10;
        try {
            b10 = this.r((s)object);
        }
        catch (c c10) {
            StringBuilder stringBuilder = a.b("Unable to obtain ChronoLocalDateTime from TemporalAccessor: ");
            object = object.getClass();
            stringBuilder.append(object);
            object = stringBuilder.toString();
            serializable = new c((String)object, c10);
            throw serializable;
        }
        serializable = f.o((s)object);
        return b10.F((f)serializable);
    }

    public boolean equals(Object var1);

    public int p(j var1);

    public String q();

    public b r(s var1);

    default public g t(Instant instant, j$.time.k k10) {
        return i.n(this, instant, k10);
    }

    public boolean y(long var1);
}

