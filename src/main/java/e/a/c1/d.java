/*
 * Decompiled with CFR 0.151.
 */
package e.a.c1;

import e.a.w0.b.a;
import java.util.concurrent.TimeUnit;

public final class d {
    public final Object a;
    public final long b;
    public final TimeUnit c;

    public d(Object object, long l10, TimeUnit timeUnit) {
        this.a = object;
        this.b = l10;
        object = (TimeUnit)((Object)e.a.w0.b.a.g((Object)timeUnit, "unit is null"));
        this.c = object;
    }

    public long a() {
        return this.b;
    }

    public long b(TimeUnit timeUnit) {
        long l10 = this.b;
        TimeUnit timeUnit2 = this.c;
        return timeUnit.convert(l10, timeUnit2);
    }

    public TimeUnit c() {
        return this.c;
    }

    public Object d() {
        return this.a;
    }

    public boolean equals(Object object) {
        boolean bl2 = object instanceof d;
        boolean bl3 = false;
        if (bl2) {
            boolean bl4;
            long l10;
            long l11;
            long l12;
            object = (d)object;
            Object object2 = this.a;
            Object object3 = ((d)object).a;
            bl2 = e.a.w0.b.a.c(object2, object3);
            if (bl2 && !(bl2 = (l12 = (l11 = this.b) - (l10 = ((d)object).b)) == 0L ? 0 : (l12 < 0L ? -1 : 1)) && (bl4 = e.a.w0.b.a.c(object2 = this.c, object = ((d)object).c))) {
                bl3 = true;
            }
        }
        return bl3;
    }

    public int hashCode() {
        int n10;
        Object object = this.a;
        if (object != null) {
            n10 = object.hashCode();
        } else {
            n10 = 0;
            object = null;
        }
        int n11 = 31;
        n10 *= n11;
        long l10 = this.b;
        long l11 = l10 >>> n11;
        int n12 = (int)(l10 ^ l11);
        n10 = (n10 + n12) * n11;
        n11 = this.c.hashCode();
        return n10 + n11;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Timed[time=");
        long l10 = this.b;
        stringBuilder.append(l10);
        stringBuilder.append(", unit=");
        Object object = this.c;
        stringBuilder.append(object);
        stringBuilder.append(", value=");
        object = this.a;
        stringBuilder.append(object);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}

