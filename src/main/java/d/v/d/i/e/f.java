/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Size
 */
package d.v.d.i.e;

import android.util.Size;
import androidx.collection.ArrayMap;
import androidx.collection.SimpleArrayMap;
import d.v.d.i.a.a;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class f
extends a {
    public static final ArrayMap l;
    private final List h;
    private final List i;
    private final ArrayMap j;
    private String k;

    static {
        ArrayMap arrayMap;
        l = arrayMap = new ArrayMap();
        Double d10 = 1.3333;
        arrayMap.put("4:3", d10);
        d10 = 1.7778;
        arrayMap.put("16:9", d10);
        d10 = 2.0;
        arrayMap.put("18:9", d10);
        d10 = 1.0;
        arrayMap.put("1:1", d10);
    }

    public f() {
        Object object = new ArrayList();
        this.h = object;
        object = new ArrayList();
        this.i = object;
        this.j = object = new ArrayMap();
    }

    private void r() {
        int n10;
        Object object = new StringBuilder();
        ((StringBuilder)object).append("select photo size mCurrentRatio=");
        Object object2 = this.k;
        ((StringBuilder)object).append((String)object2);
        d.v.d.h.f.a(((StringBuilder)object).toString());
        object = this.k;
        if (object == null) {
            return;
        }
        object2 = this.j;
        if ((object = (List)((SimpleArrayMap)object2).get(object)) != null && (n10 = object.size()) > 0) {
            n10 = 0;
            this.a = object = object.get(0);
            object = new StringBuilder();
            ((StringBuilder)object).append("select photo size=");
            object2 = this.a;
            ((StringBuilder)object).append(object2);
            object = ((StringBuilder)object).toString();
            d.v.d.h.f.a((String)object);
        } else {
            object = "current is have invalid photo size";
            d.v.d.h.f.a((String)object);
        }
    }

    private void v() {
        boolean bl2;
        DecimalFormat decimalFormat = new DecimalFormat(".0000");
        Iterator iterator2 = this.h.iterator();
        while (bl2 = iterator2.hasNext()) {
            Object object = (Size)iterator2.next();
            int n10 = object.getWidth();
            double d10 = (double)n10 * 1.0;
            int n11 = object.getHeight();
            double d11 = n11;
            Object object2 = decimalFormat.format(d10 /= d11);
            Object object3 = new Object();
            ((StringBuilder)object3).append("support photo size=");
            ((StringBuilder)object3).append(object);
            String string2 = ",ratio=";
            ((StringBuilder)object3).append(string2);
            ((StringBuilder)object3).append((String)object2);
            d.v.d.h.f.a(((StringBuilder)object3).toString());
            object3 = this.j;
            boolean bl3 = ((SimpleArrayMap)object3).containsKey(object2);
            if (bl3) {
                object3 = this.j;
                if ((object2 = (List)((SimpleArrayMap)object3).get(object2)) == null || (bl3 = object2.contains(object))) continue;
                object2.add(object);
                continue;
            }
            object3 = new Object();
            object3.add(object);
            this.i.add(object2);
            object = this.j;
            ((SimpleArrayMap)object).put(object2, object3);
        }
    }

    public String n() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("get Photo ratio=");
        String string2 = this.k;
        stringBuilder.append(string2);
        d.v.d.h.f.a(stringBuilder.toString());
        return this.k;
    }

    public List o(String string2) {
        return (List)this.j.get(string2);
    }

    public List p() {
        return this.i;
    }

    public List q() {
        return this.h;
    }

    public void s(Size size) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("set Photo size=");
        stringBuilder.append(size);
        d.v.d.h.f.a(stringBuilder.toString());
        super.set(size);
    }

    public void t(String string2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("set Photo ratio=");
        stringBuilder.append(string2);
        stringBuilder.append(",mT=");
        Object object = this.a;
        stringBuilder.append(object);
        stringBuilder.append(",mCurrentRatio=");
        object = this.k;
        stringBuilder.append((String)object);
        d.v.d.h.f.a(stringBuilder.toString());
        this.k = string2;
    }

    public void u(List list) {
        this.h.clear();
        this.h.addAll(list);
        this.i.clear();
        this.j.clear();
        this.v();
        this.r();
    }
}

