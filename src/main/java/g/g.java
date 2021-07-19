/*
 * Decompiled with CFR 0.151.
 */
package g;

import f.h2.t.f0;
import f.x1.t0;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;

public final class g {
    private final Map a;
    private final String b;

    public g(String string2, String object) {
        f0.p(string2, "scheme");
        String string3 = "realm";
        f0.p(object, string3);
        object = Collections.singletonMap(string3, object);
        f0.o(object, "singletonMap(\"realm\", realm)");
        this(string2, (Map)object);
    }

    public g(String map, Map object) {
        boolean bl2;
        f0.p(map, "scheme");
        Object object2 = "authParams";
        f0.p(object, (String)object2);
        this.b = map;
        map = new Map<String, Object>();
        object = object.entrySet().iterator();
        while (bl2 = object.hasNext()) {
            object2 = (Map.Entry)object.next();
            String string2 = (String)object2.getKey();
            object2 = (String)object2.getValue();
            if (string2 != null) {
                Object object3 = Locale.US;
                f0.o(object3, "US");
                String string3 = "null cannot be cast to non-null type java.lang.String";
                Objects.requireNonNull(string2, string3);
                string2 = string2.toLowerCase((Locale)object3);
                object3 = "(this as java.lang.String).toLowerCase(locale)";
                f0.o(string2, (String)object3);
            } else {
                string2 = null;
            }
            map.put(string2, object2);
        }
        map = Collections.unmodifiableMap(map);
        f0.o(map, "unmodifiableMap<String?, String>(newAuthParams)");
        this.a = map;
    }

    public final Map a() {
        return this.a;
    }

    public final Charset b() {
        return this.f();
    }

    public final String c() {
        return this.g();
    }

    public final String d() {
        return this.b;
    }

    public final Map e() {
        return this.a;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean equals(Object object) {
        boolean bl2 = object instanceof g;
        if (!bl2) return false;
        object = (g)object;
        Object object2 = ((g)object).b;
        String string2 = this.b;
        bl2 = f0.g(object2, string2);
        if (!bl2) return false;
        object = ((g)object).a;
        object2 = this.a;
        boolean bl3 = f0.g(object, object2);
        if (!bl3) return false;
        return true;
    }

    public final Charset f() {
        Object object = this.a;
        String string2 = "charset";
        if ((object = (String)object.get(string2)) != null) {
            try {
                object = Charset.forName((String)object);
                string2 = "Charset.forName(charset)";
            }
            catch (Exception exception) {}
            f0.o(object, string2);
            return object;
        }
        object = StandardCharsets.ISO_8859_1;
        f0.o(object, "ISO_8859_1");
        return object;
    }

    public final String g() {
        return (String)this.a.get("realm");
    }

    public final String h() {
        return this.b;
    }

    public int hashCode() {
        int n10 = this.b.hashCode();
        int n11 = (899 + n10) * 31;
        n10 = ((Object)this.a).hashCode();
        return n11 + n10;
    }

    public final g i(Charset object) {
        String string2 = "charset";
        f0.p(object, string2);
        Map map = t0.J0(this.a);
        object = ((Charset)object).name();
        f0.o(object, "charset.name()");
        map.put(string2, object);
        string2 = this.b;
        object = new g(string2, map);
        return object;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Object object = this.b;
        stringBuilder.append((String)object);
        stringBuilder.append(" authParams=");
        object = this.a;
        stringBuilder.append(object);
        return stringBuilder.toString();
    }
}

