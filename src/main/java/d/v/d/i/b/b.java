/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package d.v.d.i.b;

import android.content.Context;
import d.v.d.h.d;
import d.v.d.h.f;
import d.v.d.i.a.a;
import java.util.List;

public class b
extends a {
    public static final int j = 1;
    public static final int k = 2;
    public static final int l = 3;
    public static final int m = 5;
    public static final int n = 6;
    public static final int o = 7;
    public static final int p = 8;
    public static final int q = 9;
    public static final int r = 16;
    public static final int s = 17;
    public static final int t = 18;
    public static final int u = 19;
    public static final int v = 20;
    private final List h;
    private Context i;

    public b(Context object) {
        this.i = object;
        this.o((Context)object);
        this.h = object;
        Integer n10 = 1;
        object.add(n10);
        n10 = 2;
        object.add(n10);
        n10 = 3;
        object.add(n10);
        n10 = 8;
        object.add(n10);
        n10 = 9;
        object.add(n10);
        n10 = 16;
        object.add(n10);
        n10 = 17;
        object.add(n10);
        n10 = 18;
        object.add(n10);
        n10 = 19;
        object.add(n10);
        n10 = 20;
        object.add(n10);
    }

    private void o(Context object) {
        this.a = object = Integer.valueOf(d.v.d.h.d.c(object.getApplicationContext()));
        object = new StringBuilder();
        ((StringBuilder)object).append("init select mode ,read mode=");
        Object object2 = this.a;
        ((StringBuilder)object).append(object2);
        d.v.d.h.f.a(((StringBuilder)object).toString());
        object = (Integer)this.a;
        int n10 = (Integer)object;
        int n11 = -1;
        if (n10 == n11) {
            n10 = 2;
            this.a = object = Integer.valueOf(n10);
        }
    }

    public void b() {
        super.b();
        this.i = null;
    }

    public List n() {
        return this.h;
    }

    public boolean p() {
        int n10 = 17;
        Integer n11 = (Integer)this.a;
        int n12 = n11;
        if (n10 == n12) {
            n12 = 1;
        } else {
            n12 = 0;
            n11 = null;
        }
        return n12 != 0;
    }

    public boolean q() {
        int n10 = 1;
        Integer n11 = (Integer)this.a;
        int n12 = n11;
        if (n10 != n12) {
            n10 = 0;
        }
        return n10 != 0;
    }

    public boolean r() {
        int n10 = 16;
        Integer n11 = (Integer)this.a;
        int n12 = n11;
        if (n10 == n12) {
            n12 = 1;
        } else {
            n12 = 0;
            n11 = null;
        }
        return n12 != 0;
    }

    public boolean s() {
        int n10 = 2;
        Integer n11 = (Integer)this.a;
        int n12 = n11;
        if (n10 == n12) {
            n12 = 1;
        } else {
            n12 = 0;
            n11 = null;
        }
        return n12 != 0;
    }

    public void t(Integer n10) {
        Object object = new StringBuilder();
        String string2 = "CameraMode mode set integer=";
        ((StringBuilder)object).append(string2);
        ((StringBuilder)object).append(n10);
        d.v.d.h.f.a(((StringBuilder)object).toString());
        object = this.a;
        int n11 = n10.equals(object);
        if (n11 != 0) {
            d.v.d.h.f.a("CameraMode mode is sample ,return");
            return;
        }
        object = this.h;
        n11 = object.contains(n10);
        if (n11 == 0) {
            d.v.d.h.f.a("current Api is not support set mode ,return");
            return;
        }
        super.set(n10);
        n10 = this.i;
        n11 = (Integer)this.a;
        d.v.d.h.d.f((Context)n10, n11);
    }

    public void u(boolean bl2) {
        Comparable<StringBuilder> comparable = new StringBuilder();
        comparable.append("update support modes isHuaWei=");
        comparable.append(bl2);
        d.v.d.h.f.a(comparable.toString());
        int n10 = 7;
        comparable = n10;
        int n11 = 6;
        Integer n12 = n11;
        int n13 = 5;
        Integer n14 = n13;
        if (bl2) {
            this.h.add(n14);
            this.h.add(n12);
            List list = this.h;
            list.add(comparable);
        } else {
            this.h.remove(n14);
            this.h.remove(n12);
            List list = this.h;
            list.remove(comparable);
        }
    }
}

