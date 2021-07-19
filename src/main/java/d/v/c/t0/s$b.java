/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.t0;

import d.v.c.t0.s;
import java.util.HashMap;

public class s$b {
    private final HashMap a;

    public s$b(s object) {
        HashMap hashMap;
        this.a = hashMap = new HashMap();
        object = s.a((s)object);
        hashMap.putAll(object);
    }

    public s$b(String object, String string2, String string3, String string4, int n10) {
        HashMap<Object, Object> hashMap;
        this.a = hashMap = new HashMap<Object, Object>();
        if (object != null) {
            String string5 = "fileUrl";
            hashMap.put(string5, object);
            if (string2 != null) {
                object = "coverUrl";
                hashMap.put(object, string2);
                if (string3 != null) {
                    object = "videoDuration";
                    hashMap.put(object, string3);
                    if (string4 != null) {
                        hashMap.put("startAt", string4);
                        object = n10;
                        hashMap.put("compositeDuration", object);
                        return;
                    }
                    object = new IllegalArgumentException("Argument \"startAt\" is marked as non-null but was passed a null value.");
                    throw object;
                }
                object = new IllegalArgumentException("Argument \"videoDuration\" is marked as non-null but was passed a null value.");
                throw object;
            }
            object = new IllegalArgumentException("Argument \"coverUrl\" is marked as non-null but was passed a null value.");
            throw object;
        }
        object = new IllegalArgumentException("Argument \"fileUrl\" is marked as non-null but was passed a null value.");
        throw object;
    }

    public s a() {
        HashMap hashMap = this.a;
        s s10 = new s(hashMap, null);
        return s10;
    }

    public int b() {
        return (Integer)this.a.get("compositeDuration");
    }

    public String c() {
        return (String)this.a.get("coverUrl");
    }

    public String d() {
        return (String)this.a.get("fileUrl");
    }

    public String e() {
        return (String)this.a.get("startAt");
    }

    public String f() {
        return (String)this.a.get("videoDuration");
    }

    public s$b g(int n10) {
        HashMap hashMap = this.a;
        Integer n11 = n10;
        hashMap.put("compositeDuration", n11);
        return this;
    }

    public s$b h(String object) {
        if (object != null) {
            this.a.put("coverUrl", object);
            return this;
        }
        object = new IllegalArgumentException("Argument \"coverUrl\" is marked as non-null but was passed a null value.");
        throw object;
    }

    public s$b i(String object) {
        if (object != null) {
            this.a.put("fileUrl", object);
            return this;
        }
        object = new IllegalArgumentException("Argument \"fileUrl\" is marked as non-null but was passed a null value.");
        throw object;
    }

    public s$b j(String object) {
        if (object != null) {
            this.a.put("startAt", object);
            return this;
        }
        object = new IllegalArgumentException("Argument \"startAt\" is marked as non-null but was passed a null value.");
        throw object;
    }

    public s$b k(String object) {
        if (object != null) {
            this.a.put("videoDuration", object);
            return this;
        }
        object = new IllegalArgumentException("Argument \"videoDuration\" is marked as non-null but was passed a null value.");
        throw object;
    }
}

