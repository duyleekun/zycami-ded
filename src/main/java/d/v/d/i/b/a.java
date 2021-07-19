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
import java.util.ArrayList;
import java.util.List;

public class a
extends d.v.d.i.a.a {
    public static final int j = 1;
    public static final int k = 2;
    public static final int l = 3;
    private final List h;
    private Context i;

    public a(Context object) {
        ArrayList<Context> arrayList;
        this.h = arrayList = new ArrayList<Context>();
        this.i = object;
        object = 1;
        arrayList.add((Context)object);
        object = 2;
        arrayList.add((Context)object);
    }

    public void b() {
        super.b();
        this.i = null;
    }

    public List n() {
        return this.h;
    }

    public void o(int n10) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("init api api=");
        stringBuilder.append(n10);
        d.v.d.h.f.a(stringBuilder.toString());
        Integer n11 = n10;
        this.a = n11;
        stringBuilder = this.i;
        n10 = n11;
        d.v.d.h.d.d((Context)stringBuilder, n10);
    }

    public boolean p() {
        int n10;
        Integer n11 = (Integer)this.a;
        int n12 = n11;
        if (n12 == (n10 = 2)) {
            n12 = 1;
        } else {
            n12 = 0;
            n11 = null;
        }
        return n12 != 0;
    }

    public boolean q() {
        int n10;
        Integer n11 = (Integer)this.a;
        int n12 = n11;
        if (n12 != (n10 = 1)) {
            n10 = 0;
        }
        return n10 != 0;
    }

    public boolean r() {
        int n10;
        Integer n11 = (Integer)this.a;
        int n12 = n11;
        if (n12 == (n10 = 3)) {
            n12 = 1;
        } else {
            n12 = 0;
            n11 = null;
        }
        return n12 != 0;
    }

    public void s(Integer n10) {
        Object object = new StringBuilder();
        String string2 = "Set api integer=";
        ((StringBuilder)object).append(string2);
        ((StringBuilder)object).append(n10);
        d.v.d.h.f.a(((StringBuilder)object).toString());
        object = this.a;
        int n11 = n10.equals(object);
        if (n11 != 0) {
            d.v.d.h.f.a("Set same api . return");
            return;
        }
        super.set(n10);
        n10 = this.i;
        n11 = (Integer)this.a;
        d.v.d.h.d.d((Context)n10, n11);
    }
}

