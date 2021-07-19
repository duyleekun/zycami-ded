/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.t0;

import com.zhiyun.cama.publish.UploadCEMediaInfo;
import d.v.c.t0.j0;
import java.io.Serializable;
import java.util.HashMap;

public class j0$b {
    private final HashMap a;

    public j0$b(long l10, UploadCEMediaInfo uploadCEMediaInfo) {
        HashMap<String, Object> hashMap;
        this.a = hashMap = new HashMap<String, Object>();
        Serializable serializable = l10;
        String string2 = "templeteId";
        hashMap.put(string2, serializable);
        if (uploadCEMediaInfo != null) {
            hashMap.put("mediaArr", uploadCEMediaInfo);
            return;
        }
        super("Argument \"mediaArr\" is marked as non-null but was passed a null value.");
        throw serializable;
    }

    public j0$b(j0 object) {
        HashMap hashMap;
        this.a = hashMap = new HashMap();
        object = j0.a((j0)object);
        hashMap.putAll(object);
    }

    public j0 a() {
        HashMap hashMap = this.a;
        j0 j02 = new j0(hashMap, null);
        return j02;
    }

    public UploadCEMediaInfo b() {
        return (UploadCEMediaInfo)this.a.get("mediaArr");
    }

    public long c() {
        return (Long)this.a.get("templeteId");
    }

    public j0$b d(UploadCEMediaInfo object) {
        if (object != null) {
            this.a.put("mediaArr", object);
            return this;
        }
        object = new IllegalArgumentException("Argument \"mediaArr\" is marked as non-null but was passed a null value.");
        throw object;
    }

    public j0$b e(long l10) {
        HashMap hashMap = this.a;
        Long l11 = l10;
        hashMap.put("templeteId", l11);
        return this;
    }
}

