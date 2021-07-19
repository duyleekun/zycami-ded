/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.o0;

import com.zhiyun.cama.album.AlbumSection;
import d.v.c.o0.q0;
import java.util.HashMap;

public class q0$b {
    private final HashMap a;

    public q0$b(AlbumSection object) {
        HashMap<String, Object> hashMap;
        this.a = hashMap = new HashMap<String, Object>();
        if (object != null) {
            hashMap.put("section", object);
            return;
        }
        object = new IllegalArgumentException("Argument \"section\" is marked as non-null but was passed a null value.");
        throw object;
    }

    public q0$b(q0 object) {
        HashMap hashMap;
        this.a = hashMap = new HashMap();
        object = q0.a((q0)object);
        hashMap.putAll(object);
    }

    public q0 a() {
        HashMap hashMap = this.a;
        q0 q02 = new q0(hashMap, null);
        return q02;
    }

    public AlbumSection b() {
        return (AlbumSection)this.a.get("section");
    }

    public q0$b c(AlbumSection object) {
        if (object != null) {
            this.a.put("section", object);
            return this;
        }
        object = new IllegalArgumentException("Argument \"section\" is marked as non-null but was passed a null value.");
        throw object;
    }
}

