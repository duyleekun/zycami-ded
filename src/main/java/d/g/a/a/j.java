/*
 * Decompiled with CFR 0.151.
 */
package d.g.a.a;

import d.g.a.a.i;
import d.g.a.a.j$a;
import java.util.HashMap;
import java.util.Map;

public final class j {
    private final Map a;

    public j() {
        HashMap hashMap;
        this.a = hashMap = new HashMap();
    }

    public static /* synthetic */ Map a(j j10) {
        return j10.a;
    }

    public j b(char c10, String string2) {
        Map map = this.a;
        String string3 = String.valueOf(c10);
        String[] stringArray = new String[]{string2};
        map.put(string3, stringArray);
        return this;
    }

    public j c(String string2, String[] stringArray) {
        this.a.put(string2, stringArray);
        return this;
    }

    public String d(char c10) {
        Map map = this.a;
        String string2 = String.valueOf(c10);
        return ((String[])map.get(string2))[0];
    }

    public i e() {
        j$a j$a = new j$a(this);
        return j$a;
    }
}

