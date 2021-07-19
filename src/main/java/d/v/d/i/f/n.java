/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.Surface
 */
package d.v.d.i.f;

import android.view.Surface;
import d.v.d.h.f;
import d.v.d.i.a.a;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class n
extends a {
    public n() {
        ArrayList arrayList;
        this.a = arrayList = new ArrayList();
    }

    public void b() {
        super.b();
        ((List)this.a).clear();
    }

    public void n(Surface surface) {
        d.v.d.h.f.a("add Preview surface");
        ((List)this.a).clear();
        ((List)this.a).add(surface);
    }

    public void o(Surface surface) {
        Objects.requireNonNull(surface);
        List list = (List)this.a;
        boolean bl2 = list.contains(surface);
        if (bl2) {
            d.v.d.h.f.a("current list contains target surface return");
            return;
        }
        bl2 = surface.isValid();
        if (!bl2) {
            d.v.d.h.f.a("add surface is not valid ,return");
            return;
        }
        ((List)this.a).add(surface);
    }

    public Surface p() {
        Object object = new StringBuilder();
        ((StringBuilder)object).append("get preview list ,mT=");
        List list = (List)this.a;
        int n10 = list.size();
        ((StringBuilder)object).append(n10);
        d.v.d.h.f.a(((StringBuilder)object).toString());
        object = (List)this.a;
        int n11 = object.size();
        n10 = 1;
        if (n11 < n10) {
            return null;
        }
        return (Surface)((List)this.a).get(0);
    }

    public void q(Surface surface) {
        Objects.requireNonNull(surface);
        ((List)this.a).remove(surface);
    }
}

