/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.k1.a;

import d.v.c.k1.a.o;
import java.util.HashMap;

public class o$b {
    private final HashMap a;

    public o$b(int n10, long l10, int n11) {
        HashMap<String, Integer> hashMap;
        this.a = hashMap = new HashMap<String, Integer>();
        Number number = n10;
        hashMap.put("max_count_selected", (Integer)number);
        number = l10;
        hashMap.put("templateDataID", (Integer)number);
        number = n11;
        hashMap.put("media_type_load", (Integer)number);
    }

    public o$b(o object) {
        HashMap hashMap;
        this.a = hashMap = new HashMap();
        object = o.a((o)object);
        hashMap.putAll(object);
    }

    public o a() {
        HashMap hashMap = this.a;
        o o10 = new o(hashMap, null);
        return o10;
    }

    public String b() {
        return (String)this.a.get("add_video_type");
    }

    public int c() {
        return (Integer)this.a.get("max_count_selected");
    }

    public int d() {
        return (Integer)this.a.get("media_type_load");
    }

    public long e() {
        return (Long)this.a.get("templateDataID");
    }

    public o$b f(String object) {
        if (object != null) {
            this.a.put("add_video_type", object);
            return this;
        }
        object = new IllegalArgumentException("Argument \"add_video_type\" is marked as non-null but was passed a null value.");
        throw object;
    }

    public o$b g(int n10) {
        HashMap hashMap = this.a;
        Integer n11 = n10;
        hashMap.put("max_count_selected", n11);
        return this;
    }

    public o$b h(int n10) {
        HashMap hashMap = this.a;
        Integer n11 = n10;
        hashMap.put("media_type_load", n11);
        return this;
    }

    public o$b i(long l10) {
        HashMap hashMap = this.a;
        Long l11 = l10;
        hashMap.put("templateDataID", l11);
        return this;
    }
}

