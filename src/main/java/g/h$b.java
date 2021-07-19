/*
 * Decompiled with CFR 0.151.
 */
package g;

import f.h2.t.f0;
import f.q2.u;
import g.h;
import java.util.Comparator;
import java.util.Objects;

public final class h$b {
    private h$b() {
    }

    public /* synthetic */ h$b(f.h2.t.u u10) {
        this();
    }

    public static final /* synthetic */ h a(h$b h$b, String string2, int n10) {
        return h$b.d(string2, n10);
    }

    private final h d(String string2, int n10) {
        h h10 = new h(string2, null);
        h.b().put(string2, h10);
        return h10;
    }

    private final String e(String string2) {
        CharSequence charSequence = "TLS_";
        boolean bl2 = false;
        StringBuilder stringBuilder = null;
        int n10 = 2;
        boolean bl3 = u.q2(string2, (String)charSequence, false, n10, null);
        String string3 = "(this as java.lang.String).substring(startIndex)";
        String string4 = "null cannot be cast to non-null type java.lang.String";
        int n11 = 4;
        String string5 = "SSL_";
        if (bl3) {
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append(string5);
            Objects.requireNonNull(string2, string4);
            string2 = string2.substring(n11);
            f0.o(string2, string3);
            ((StringBuilder)charSequence).append(string2);
            string2 = ((StringBuilder)charSequence).toString();
        } else {
            bl2 = u.q2(string2, string5, false, n10, null);
            if (bl2) {
                stringBuilder = new StringBuilder();
                stringBuilder.append((String)charSequence);
                Objects.requireNonNull(string2, string4);
                string2 = string2.substring(n11);
                f0.o(string2, string3);
                stringBuilder.append(string2);
                string2 = stringBuilder.toString();
            }
        }
        return string2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final h b(String string2) {
        synchronized (this) {
            Object object = "javaName";
            f0.p(string2, (String)object);
            object = h.b();
            object = object.get(string2);
            object = (h)object;
            if (object == null) {
                object = h.b();
                Object object2 = this.e(string2);
                object = object.get(object2);
                if ((object = (h)object) == null) {
                    object2 = null;
                    object = new h(string2, null);
                }
                object2 = h.b();
                object2.put(string2, object);
            }
            return object;
        }
    }

    public final Comparator c() {
        return h.c();
    }
}

