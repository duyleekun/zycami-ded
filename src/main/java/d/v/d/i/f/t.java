/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Size
 */
package d.v.d.i.f;

import android.util.Size;
import androidx.collection.ArrayMap;
import androidx.collection.SimpleArrayMap;
import d.v.d.h.f;
import d.v.d.i.a.a;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class t
extends a {
    public static final ArrayMap l;
    private List h;
    private final List i;
    private final ArrayMap j;
    private String k;

    static {
        ArrayMap arrayMap;
        l = arrayMap = new ArrayMap();
    }

    public t() {
        Object object = new ArrayMap();
        this.j = object;
        object = new ArrayList();
        this.i = object;
        object = new ArrayList();
        this.h = object;
        object = l;
        Double d10 = 1.3333;
        ((SimpleArrayMap)object).put("4:3", d10);
        d10 = 1.7778;
        ((SimpleArrayMap)object).put("16:9", d10);
        d10 = 2.0;
        ((SimpleArrayMap)object).put("18:9", d10);
        d10 = 1.0;
        ((SimpleArrayMap)object).put("1:1", d10);
    }

    private void n() {
        boolean bl2;
        this.i.clear();
        this.j.clear();
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
            ((StringBuilder)object3).append("support preview size=");
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

    private void u(Size object) {
        int n10;
        Object object2 = new StringBuilder();
        ((StringBuilder)object2).append("select preview size mCurrentRatio=");
        Object object3 = this.k;
        ((StringBuilder)object2).append((String)object3);
        d.v.d.h.f.a(((StringBuilder)object2).toString());
        object2 = this.k;
        if (object2 == null) {
            return;
        }
        object3 = this.j;
        if ((object2 = (List)((SimpleArrayMap)object3).get(object2)) != null && (n10 = object2.size()) > 0) {
            this.a = object = this.t((List)object2, (Size)object);
            object = new StringBuilder();
            ((StringBuilder)object).append("select preview size=");
            object2 = this.a;
            ((StringBuilder)object).append(object2);
            object = ((StringBuilder)object).toString();
            d.v.d.h.f.a((String)object);
        } else {
            object = "current is have invalid photo size";
            d.v.d.h.f.a((String)object);
        }
    }

    public int o() {
        return ((Size)this.a).getHeight();
    }

    public List p(String string2) {
        return (List)this.j.get(string2);
    }

    public List q() {
        return this.i;
    }

    public List r() {
        return this.h;
    }

    public int s() {
        return ((Size)this.a).getWidth();
    }

    public Size t(List object, Size size) {
        boolean bl2;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("select optimal preview size mCurrentRatio=");
        String string2 = this.k;
        stringBuilder.append(string2);
        string2 = ",PreviewView Size=";
        stringBuilder.append(string2);
        stringBuilder.append(size);
        d.v.d.h.f.a(stringBuilder.toString());
        int n10 = size.getHeight();
        object = object.iterator();
        int n11 = 0;
        stringBuilder = null;
        double d10 = Double.MAX_VALUE;
        while (bl2 = object.hasNext()) {
            double d11;
            Size size2 = (Size)object.next();
            CharSequence charSequence = new StringBuilder();
            charSequence.append("select optimalSize size=");
            charSequence.append(size2);
            String string3 = ", minDiff=";
            charSequence.append(string3);
            charSequence.append(d10);
            charSequence = charSequence.toString();
            d.v.d.h.f.a((String)charSequence);
            double d12 = Math.abs(size2.getHeight() - n10);
            double d13 = d12 - d10;
            Object object2 = d13 == 0.0 ? 0 : (d13 < 0.0 ? -1 : 1);
            if (object2 >= 0) continue;
            n11 = Math.abs(size2.getHeight() - n10);
            d10 = d11 = (double)n11;
            stringBuilder = size2;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append(" calculationSize final preview size: ");
        ((StringBuilder)object).append((Object)stringBuilder);
        d.v.d.h.f.a(((StringBuilder)object).toString());
        return stringBuilder;
    }

    public void v(Size size) {
        Object object = new StringBuilder();
        String string2 = "Preview Size set size=";
        ((StringBuilder)object).append(string2);
        ((StringBuilder)object).append(size);
        d.v.d.h.f.a(((StringBuilder)object).toString());
        object = this.h;
        boolean bl2 = object.contains(size);
        if (!bl2) {
            d.v.d.h.f.a("preview size set size illegal \uff0creturn");
            return;
        }
        super.set(size);
    }

    public void w(String string2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("set preview size ratio =");
        stringBuilder.append(string2);
        stringBuilder.append(",mT=");
        Object object = this.a;
        stringBuilder.append(object);
        d.v.d.h.f.a(stringBuilder.toString());
        this.k = string2;
    }

    public void x(List list, Size size) {
        this.h = list;
        this.n();
        this.u(size);
    }
}

