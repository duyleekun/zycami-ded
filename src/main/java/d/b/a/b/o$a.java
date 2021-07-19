/*
 * Decompiled with CFR 0.151.
 */
package d.b.a.b;

import d.b.a.b.d0;
import d.b.a.b.o;
import java.util.ArrayList;
import java.util.List;

public class o$a {
    private String a;
    private List b;

    private o$a() {
    }

    public /* synthetic */ o$a(d0 d02) {
        this();
    }

    public o a() {
        Object object = this.a;
        if (object != null) {
            object = this.b;
            if (object != null) {
                object = new o();
                Object object2 = this.a;
                o.e((o)object, (String)object2);
                object2 = this.b;
                o.f((o)object, (List)object2);
                o.g((o)object, null);
                return object;
            }
            object = new IllegalArgumentException("SKUs list must be set");
            throw object;
        }
        object = new IllegalArgumentException("SKU type must be set");
        throw object;
    }

    public o$a b(List list) {
        ArrayList arrayList;
        this.b = arrayList = new ArrayList(list);
        return this;
    }

    public o$a c(String string2) {
        this.a = string2;
        return this;
    }
}

