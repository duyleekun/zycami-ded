/*
 * Decompiled with CFR 0.151.
 */
package i.h.h;

import i.h.h.a;
import java.util.HashMap;
import java.util.Map;

public class a$a
extends InheritableThreadLocal {
    public final /* synthetic */ a a;

    public a$a(a a10) {
        this.a = a10;
    }

    public Map a(Map map) {
        if (map == null) {
            return null;
        }
        HashMap hashMap = new HashMap(map);
        return hashMap;
    }
}

