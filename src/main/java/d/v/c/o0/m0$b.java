/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.o0;

import com.zhiyun.cama.album.AlbumSection;
import d.v.c.o0.m0;
import java.util.HashMap;

public class m0$b {
    private final HashMap a;

    public m0$b(m0 object) {
        HashMap hashMap;
        this.a = hashMap = new HashMap();
        object = m0.a((m0)object);
        hashMap.putAll(object);
    }

    public m0$b(AlbumSection[] object) {
        HashMap<String, AlbumSection[]> hashMap;
        this.a = hashMap = new HashMap<String, AlbumSection[]>();
        if (object != null) {
            hashMap.put("deleteSections", (AlbumSection[])object);
            return;
        }
        super("Argument \"deleteSections\" is marked as non-null but was passed a null value.");
        throw object;
    }

    public m0 a() {
        HashMap hashMap = this.a;
        m0 m02 = new m0(hashMap, null);
        return m02;
    }

    public AlbumSection[] b() {
        return (AlbumSection[])this.a.get("deleteSections");
    }

    public m0$b c(AlbumSection[] object) {
        if (object != null) {
            this.a.put("deleteSections", object);
            return this;
        }
        object = new IllegalArgumentException("Argument \"deleteSections\" is marked as non-null but was passed a null value.");
        throw object;
    }
}

