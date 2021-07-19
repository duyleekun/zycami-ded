/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.v0.q;

import com.zhiyun.editorinterface.EditConfig$ResourceType;
import d.v.c.v0.q.c;
import d.v.c.v0.q.e.e;
import d.v.c.v0.q.f.a;

public class d {
    private static volatile d c;
    private final e a;
    private final a b;

    private d() {
        Object object = e.d();
        this.a = object;
        this.b = object = d.v.c.v0.q.f.a.a();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static d c() {
        Object object = c;
        if (object != null) return c;
        object = d.class;
        synchronized (object) {
            d d10 = c;
            if (d10 != null) return c;
            c = d10 = new d();
            return c;
        }
    }

    public void a(EditConfig$ResourceType editConfig$ResourceType) {
        this.a.a(editConfig$ResourceType);
    }

    public void b(EditConfig$ResourceType[] editConfig$ResourceTypeArray) {
        this.a.b(editConfig$ResourceTypeArray);
    }

    public void d(c c10) {
        this.a.e(c10);
    }

    public k.d e(long l10) {
        return this.b.b(l10);
    }
}

