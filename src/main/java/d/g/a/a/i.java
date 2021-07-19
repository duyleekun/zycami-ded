/*
 * Decompiled with CFR 0.151.
 */
package d.g.a.a;

import d.g.a.a.h;
import java.util.Map;
import java.util.Set;

public abstract class i
implements h {
    public Set a() {
        Object object = this.c();
        object = object != null ? this.c().keySet() : null;
        return object;
    }

    public String[] b(String stringArray) {
        Map map = this.c();
        if (map != null) {
            map = this.c();
            stringArray = (String[])map.get(stringArray);
        } else {
            stringArray = null;
        }
        return stringArray;
    }

    public abstract Map c();
}

