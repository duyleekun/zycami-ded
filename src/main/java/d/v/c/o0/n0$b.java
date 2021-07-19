/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.o0;

import com.zhiyun.cama.album.AlbumSection;
import d.v.c.o0.n0;
import java.util.HashMap;

public class n0$b {
    private final HashMap a;

    public n0$b(AlbumSection albumSection) {
        HashMap<String, AlbumSection> hashMap;
        this.a = hashMap = new HashMap<String, AlbumSection>();
        hashMap.put("section", albumSection);
    }

    public n0$b(n0 object) {
        HashMap hashMap;
        this.a = hashMap = new HashMap();
        object = n0.a((n0)object);
        hashMap.putAll(object);
    }

    public n0 a() {
        HashMap hashMap = this.a;
        n0 n02 = new n0(hashMap, null);
        return n02;
    }

    public AlbumSection b() {
        return (AlbumSection)this.a.get("section");
    }

    public n0$b c(AlbumSection albumSection) {
        this.a.put("section", albumSection);
        return this;
    }
}

