/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.j1.b;

import d.v.c.j1.b.m0;
import java.util.HashMap;

public class m0$b {
    private final HashMap a;

    public m0$b(m0 object) {
        HashMap hashMap;
        this.a = hashMap = new HashMap();
        object = m0.a((m0)object);
        hashMap.putAll(object);
    }

    public m0$b(String object, String string2, String string3) {
        HashMap<Object, Object> hashMap;
        this.a = hashMap = new HashMap<Object, Object>();
        if (object != null) {
            String string4 = "title";
            hashMap.put(string4, object);
            if (string2 != null) {
                object = "time";
                hashMap.put(object, string2);
                if (string3 != null) {
                    hashMap.put("content", string3);
                    return;
                }
                object = new IllegalArgumentException("Argument \"content\" is marked as non-null but was passed a null value.");
                throw object;
            }
            object = new IllegalArgumentException("Argument \"time\" is marked as non-null but was passed a null value.");
            throw object;
        }
        object = new IllegalArgumentException("Argument \"title\" is marked as non-null but was passed a null value.");
        throw object;
    }

    public m0 a() {
        HashMap hashMap = this.a;
        m0 m02 = new m0(hashMap, null);
        return m02;
    }

    public String b() {
        return (String)this.a.get("content");
    }

    public String c() {
        return (String)this.a.get("time");
    }

    public String d() {
        return (String)this.a.get("title");
    }

    public m0$b e(String object) {
        if (object != null) {
            this.a.put("content", object);
            return this;
        }
        object = new IllegalArgumentException("Argument \"content\" is marked as non-null but was passed a null value.");
        throw object;
    }

    public m0$b f(String object) {
        if (object != null) {
            this.a.put("time", object);
            return this;
        }
        object = new IllegalArgumentException("Argument \"time\" is marked as non-null but was passed a null value.");
        throw object;
    }

    public m0$b g(String object) {
        if (object != null) {
            this.a.put("title", object);
            return this;
        }
        object = new IllegalArgumentException("Argument \"title\" is marked as non-null but was passed a null value.");
        throw object;
    }
}

