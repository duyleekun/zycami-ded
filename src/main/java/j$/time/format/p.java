/*
 * Decompiled with CFR 0.151.
 */
package j$.time.format;

import j$.e.a.a.a.a;
import j$.time.format.B;
import j$.time.format.C;
import j$.time.format.f;
import j$.time.format.j;
import j$.time.format.v;
import j$.time.format.y;
import j$.time.p.k;
import j$.time.q.b_0;
import j$.time.q.h;
import j$.time.q.u;
import j$.time.q.w;
import java.util.Locale;
import java.util.Objects;

final class p
implements f {
    private final u a;
    private final C b;
    private final y c;
    private volatile j d;

    p(u u10, C c10, y y10) {
        this.a = u10;
        this.b = c10;
        this.c = y10;
    }

    public boolean m(v v10, StringBuilder stringBuilder) {
        Object object;
        Object object2 = this.a;
        if ((object2 = v10.e((u)object2)) == null) {
            return false;
        }
        Object object3 = v10.d();
        Object object4 = b_0.a;
        if ((object3 = (j$.time.p.j)object3.d((w)object4)) != null && object3 != (object4 = k.a)) {
            boolean bl2;
            object = this.c;
            u u10 = this.a;
            long l10 = (Long)object2;
            C c10 = this.b;
            Locale locale = v10.c();
            Objects.requireNonNull(object);
            if (object3 != object4 && (bl2 = u10 instanceof h)) {
                bl2 = false;
                object2 = null;
            } else {
                object2 = object.c(u10, l10, c10, locale);
            }
        } else {
            object3 = this.c;
            object4 = this.a;
            long l11 = (Long)object2;
            C c11 = this.b;
            Locale locale = v10.c();
            object2 = ((y)object3).c((u)object4, l11, c11, locale);
        }
        int n10 = 1;
        if (object2 == null) {
            object2 = this.d;
            if (object2 == null) {
                object4 = this.a;
                object = B.a;
                int n11 = 19;
                this.d = object2 = new j((u)object4, n10, n11, (B)((Object)object));
            }
            return this.d.m(v10, stringBuilder);
        }
        stringBuilder.append((String)object2);
        return n10 != 0;
    }

    public String toString() {
        Object object = this.b;
        Object object2 = C.b;
        String string2 = ")";
        String string3 = "Text(";
        if (object == object2) {
            object = j$.e.a.a.a.a.b(string3);
            object2 = this.a;
        } else {
            object = j$.e.a.a.a.a.b(string3);
            object2 = this.a;
            ((StringBuilder)object).append(object2);
            ((StringBuilder)object).append(",");
            object2 = this.b;
        }
        ((StringBuilder)object).append(object2);
        ((StringBuilder)object).append(string2);
        return ((StringBuilder)object).toString();
    }
}

