/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.i1.t2;

import d.v.c.i1.t2.n0;
import java.util.HashMap;

public class n0$b {
    private final HashMap a;

    public n0$b(n0 object) {
        HashMap hashMap;
        this.a = hashMap = new HashMap();
        object = n0.a((n0)object);
        hashMap.putAll(object);
    }

    public n0$b(String object, boolean bl2) {
        HashMap<String, Object> hashMap;
        this.a = hashMap = new HashMap<String, Object>();
        if (object != null) {
            hashMap.put("url", object);
            object = bl2;
            hashMap.put("useBgColor", object);
            return;
        }
        object = new IllegalArgumentException("Argument \"url\" is marked as non-null but was passed a null value.");
        throw object;
    }

    public n0 a() {
        HashMap hashMap = this.a;
        n0 n02 = new n0(hashMap, null);
        return n02;
    }

    public boolean b() {
        return (Boolean)this.a.get("darkMode");
    }

    public boolean c() {
        return (Boolean)this.a.get("hideBack");
    }

    public String d() {
        return (String)this.a.get("url");
    }

    public boolean e() {
        return (Boolean)this.a.get("useBgColor");
    }

    public n0$b f(boolean bl2) {
        HashMap hashMap = this.a;
        Boolean bl3 = bl2;
        hashMap.put("darkMode", bl3);
        return this;
    }

    public n0$b g(boolean bl2) {
        HashMap hashMap = this.a;
        Boolean bl3 = bl2;
        hashMap.put("hideBack", bl3);
        return this;
    }

    public n0$b h(String object) {
        if (object != null) {
            this.a.put("url", object);
            return this;
        }
        object = new IllegalArgumentException("Argument \"url\" is marked as non-null but was passed a null value.");
        throw object;
    }

    public n0$b i(boolean bl2) {
        HashMap hashMap = this.a;
        Boolean bl3 = bl2;
        hashMap.put("useBgColor", bl3);
        return this;
    }
}

