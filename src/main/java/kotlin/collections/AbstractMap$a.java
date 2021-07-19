/*
 * Decompiled with CFR 0.151.
 */
package kotlin.collections;

import f.h2.t.f0;
import f.h2.t.u;
import java.util.Map;

public final class AbstractMap$a {
    private AbstractMap$a() {
    }

    public /* synthetic */ AbstractMap$a(u u10) {
        this();
    }

    public final boolean a(Map.Entry entry, Object object) {
        boolean bl2;
        Object k10;
        String string2 = "e";
        f0.p(entry, string2);
        boolean bl3 = object instanceof Map.Entry;
        boolean bl4 = false;
        if (!bl3) {
            return false;
        }
        string2 = entry.getKey();
        bl3 = f0.g(string2, k10 = (object = (Map.Entry)object).getKey());
        if (bl3 && (bl2 = f0.g(entry = entry.getValue(), object = object.getValue()))) {
            bl4 = true;
        }
        return bl4;
    }

    public final int b(Map.Entry entry) {
        int n10;
        f0.p(entry, "e");
        Object k10 = entry.getKey();
        int n11 = 0;
        if (k10 != null) {
            n10 = k10.hashCode();
        } else {
            n10 = 0;
            k10 = null;
        }
        entry = entry.getValue();
        if (entry != null) {
            n11 = ((Object)entry).hashCode();
        }
        return n10 ^ n11;
    }

    public final String c(Map.Entry entry) {
        f0.p(entry, "e");
        StringBuilder stringBuilder = new StringBuilder();
        Object k10 = entry.getKey();
        stringBuilder.append(k10);
        stringBuilder.append('=');
        entry = entry.getValue();
        stringBuilder.append(entry);
        return stringBuilder.toString();
    }
}

