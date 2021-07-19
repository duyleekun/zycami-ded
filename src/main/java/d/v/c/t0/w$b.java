/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.t0;

import com.quvideo.mobile.external.component.cloudengine.model.CompositeConfig$Resolution;
import com.zhiyun.cama.publish.UploadCEMediaInfo;
import d.v.c.t0.w;
import java.util.HashMap;

public class w$b {
    private final HashMap a;

    public w$b(long l10, UploadCEMediaInfo[] uploadCEMediaInfoArray, CompositeConfig$Resolution compositeConfig$Resolution) {
        HashMap<Object, Object> hashMap;
        this.a = hashMap = new HashMap<Object, Object>();
        Object object = l10;
        String string2 = "templateId";
        hashMap.put(string2, object);
        if (uploadCEMediaInfoArray != null) {
            object = "mediaArr";
            hashMap.put(object, uploadCEMediaInfoArray);
            if (compositeConfig$Resolution != null) {
                hashMap.put("resolution", (Object)compositeConfig$Resolution);
                return;
            }
            object = new IllegalArgumentException("Argument \"resolution\" is marked as non-null but was passed a null value.");
            throw object;
        }
        object = new IllegalArgumentException("Argument \"mediaArr\" is marked as non-null but was passed a null value.");
        throw object;
    }

    public w$b(w object) {
        HashMap hashMap;
        this.a = hashMap = new HashMap();
        object = w.a((w)object);
        hashMap.putAll(object);
    }

    public w a() {
        HashMap hashMap = this.a;
        w w10 = new w(hashMap, null);
        return w10;
    }

    public UploadCEMediaInfo[] b() {
        return (UploadCEMediaInfo[])this.a.get("mediaArr");
    }

    public CompositeConfig$Resolution c() {
        return (CompositeConfig$Resolution)((Object)this.a.get("resolution"));
    }

    public long d() {
        return (Long)this.a.get("templateId");
    }

    public w$b e(UploadCEMediaInfo[] object) {
        if (object != null) {
            this.a.put("mediaArr", object);
            return this;
        }
        object = new IllegalArgumentException("Argument \"mediaArr\" is marked as non-null but was passed a null value.");
        throw object;
    }

    public w$b f(CompositeConfig$Resolution object) {
        if (object != null) {
            this.a.put("resolution", object);
            return this;
        }
        object = new IllegalArgumentException("Argument \"resolution\" is marked as non-null but was passed a null value.");
        throw object;
    }

    public w$b g(long l10) {
        HashMap hashMap = this.a;
        Long l11 = l10;
        hashMap.put("templateId", l11);
        return this;
    }
}

