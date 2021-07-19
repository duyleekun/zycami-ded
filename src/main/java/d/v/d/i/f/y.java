/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Build
 */
package d.v.d.i.f;

import android.os.Build;
import d.v.d.h.f;
import d.v.d.i.a.a;
import d.v.d.i.f.c;
import d.v.d.i.f.l;
import java.io.Serializable;
import java.util.List;

public class y
extends a {
    private static final String i = "Xiaomi";
    private static final String j = "MI CC 9 Meitu Edition";
    public static final int k = 0;
    public static final int l = 1;
    public static final int m = 2;
    public static final int n = 3;
    public static final int o = 4;
    public static final int p = 5;
    public static final int q = 6;
    private final List h;

    public y() {
        Serializable serializable = 0;
        this.a = serializable;
        this.h = serializable;
    }

    private boolean n() {
        String string2 = Build.MANUFACTURER;
        String string3 = Build.MODEL;
        CharSequence charSequence = new StringBuilder();
        charSequence.append("checkPhone manufacturer=");
        charSequence.append(string2);
        String string4 = "\uff0cMODEL=";
        charSequence.append(string4);
        charSequence.append(string3);
        d.v.d.h.f.a(charSequence.toString());
        charSequence = i;
        boolean bl2 = string2.equalsIgnoreCase((String)charSequence);
        if (bl2 && (bl2 = string3.equalsIgnoreCase(string2 = j))) {
            bl2 = true;
        } else {
            bl2 = false;
            string2 = null;
        }
        return bl2;
    }

    public static /* synthetic */ void p(Integer n10) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("WB type =");
        stringBuilder.append(n10);
        d.v.d.h.f.a(stringBuilder.toString());
    }

    public List o() {
        return this.h;
    }

    public void q(Integer n10) {
        Object object = new StringBuilder();
        Object object2 = "set Wb type integer=";
        ((StringBuilder)object).append((String)object2);
        ((StringBuilder)object).append(n10);
        d.v.d.h.f.a(((StringBuilder)object).toString());
        object = this.a;
        boolean bl2 = n10.equals(object);
        if (bl2) {
            d.v.d.h.f.a("current is sample flash ,return");
            return;
        }
        object = this.h;
        object2 = d.v.d.i.f.c.a;
        object.forEach(object2);
        object = this.h;
        bl2 = object.contains(n10);
        if (!bl2) {
            d.v.d.h.f.a("current is invalid value ,return");
            return;
        }
        super.set(n10);
    }

    public void r(List list, l l10) {
        boolean bl2;
        List list2 = this.h;
        list2.clear();
        boolean bl3 = this.n();
        if (bl3 && (bl2 = l10.s())) {
            return;
        }
        this.h.addAll(list);
    }
}

