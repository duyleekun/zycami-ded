/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.t0;

import com.zhiyun.cama.cloud_engine.CETemplateModel;
import d.v.c.t0.f0;
import java.util.HashMap;

public class f0$b {
    private final HashMap a;

    public f0$b(CETemplateModel object) {
        HashMap<String, Object> hashMap;
        this.a = hashMap = new HashMap<String, Object>();
        if (object != null) {
            hashMap.put("templateModel", object);
            return;
        }
        object = new IllegalArgumentException("Argument \"templateModel\" is marked as non-null but was passed a null value.");
        throw object;
    }

    public f0$b(f0 object) {
        HashMap hashMap;
        this.a = hashMap = new HashMap();
        object = f0.a((f0)object);
        hashMap.putAll(object);
    }

    public f0 a() {
        HashMap hashMap = this.a;
        f0 f02 = new f0(hashMap, null);
        return f02;
    }

    public CETemplateModel b() {
        return (CETemplateModel)this.a.get("templateModel");
    }

    public f0$b c(CETemplateModel object) {
        if (object != null) {
            this.a.put("templateModel", object);
            return this;
        }
        object = new IllegalArgumentException("Argument \"templateModel\" is marked as non-null but was passed a null value.");
        throw object;
    }
}

