/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.n1;

import com.zhiyun.cama.publish.UploadCEMediaInfo;
import d.v.c.n1.n2;
import java.util.HashMap;

public class n2$b {
    private final HashMap a;

    public n2$b(UploadCEMediaInfo object) {
        HashMap<String, Object> hashMap;
        this.a = hashMap = new HashMap<String, Object>();
        if (object != null) {
            hashMap.put("media", object);
            return;
        }
        object = new IllegalArgumentException("Argument \"media\" is marked as non-null but was passed a null value.");
        throw object;
    }

    public n2$b(n2 object) {
        HashMap hashMap;
        this.a = hashMap = new HashMap();
        object = n2.a((n2)object);
        hashMap.putAll(object);
    }

    public n2 a() {
        HashMap hashMap = this.a;
        n2 n22 = new n2(hashMap, null);
        return n22;
    }

    public UploadCEMediaInfo b() {
        return (UploadCEMediaInfo)this.a.get("media");
    }

    public n2$b c(UploadCEMediaInfo object) {
        if (object != null) {
            this.a.put("media", object);
            return this;
        }
        object = new IllegalArgumentException("Argument \"media\" is marked as non-null but was passed a null value.");
        throw object;
    }
}

