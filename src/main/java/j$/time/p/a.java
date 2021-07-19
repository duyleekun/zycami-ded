/*
 * Decompiled with CFR 0.151.
 */
package j$.time.p;

import j$.time.p.j;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;

public abstract class a
implements j {
    static {
        new ConcurrentHashMap();
        new ConcurrentHashMap();
        String string2 = "JP";
        Locale locale = new Locale("ja", string2, string2);
    }

    protected a() {
    }

    public boolean equals(Object object) {
        boolean bl2 = true;
        if (this == object) {
            return bl2;
        }
        boolean bl3 = object instanceof a;
        if (bl3) {
            int n10 = this.p((j)(object = (a)object));
            if (n10 != 0) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public int hashCode() {
        return this.getClass().hashCode() ^ 0x11C65;
    }

    public int p(j object) {
        object = object.q();
        return "ISO".compareTo((String)object);
    }

    public String toString() {
        return "ISO";
    }
}

