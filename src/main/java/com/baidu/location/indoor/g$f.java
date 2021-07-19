/*
 * Decompiled with CFR 0.151.
 */
package com.baidu.location.indoor;

import com.baidu.location.BDLocation;
import com.baidu.location.indoor.g;
import com.baidu.location.indoor.g$e;
import com.baidu.location.indoor.g$f$a;
import java.util.Collections;
import java.util.List;

public class g$f {
    public int a = 10;
    public final /* synthetic */ g b;
    private List c;

    public g$f(g list) {
        this.b = list;
        list = new List();
        this.c = list = Collections.synchronizedList(list);
    }

    public static /* synthetic */ List a(g$f g$f) {
        return g$f.c;
    }

    public void a(BDLocation bDLocation) {
        double d10 = bDLocation.getLongitude();
        double d11 = bDLocation.getLatitude();
        double d12 = g$e.h(g.a(this.b));
        g$f$a g$f$a = new g$f$a(this, d10, d11, d12);
        this.c.add(g$f$a);
    }

    public String toString() {
        g$f g$f = this;
        Object object = this.c;
        int n10 = object.size();
        if (n10 == 0) {
            return "";
        }
        object = new StringBuffer();
        Object object2 = this.c;
        Object object3 = null;
        double d10 = ((g$f$a)object2.get((int)0)).a;
        double d11 = ((g$f$a)this.c.get((int)0)).b;
        object2 = (g$f$a)this.c.get(0);
        double d12 = ((g$f$a)object2).c;
        int n11 = 3;
        Object object4 = new Object[n11];
        Double d13 = d10;
        object4[0] = d13;
        d13 = d11;
        int n12 = 1;
        object4[n12] = d13;
        Object object5 = d12;
        int n13 = 2;
        object4[n13] = object5;
        object5 = String.format("%.6f:%.6f:%.1f", (Object[])object4);
        ((StringBuffer)object).append((String)object5);
        object5 = this.c;
        int n14 = object5.size();
        int n15 = this.a;
        if (n14 > n15) {
            object5 = this.c;
            n14 = object5.size();
            n15 = this.a;
            n14 -= n15;
        } else {
            n14 = 0;
            object5 = null;
        }
        n14 += n12;
        while (n14 < (n15 = (object4 = g$f.c).size())) {
            double d14 = ((g$f$a)g$f.c.get((int)n14)).a - d10;
            double d15 = 1000000.0;
            d14 *= d15;
            g$f$a g$f$a = (g$f$a)g$f.c.get(n14);
            double d16 = (g$f$a.b - d11) * d15;
            d15 = ((g$f$a)g$f.c.get((int)n14)).c;
            Object[] objectArray = new Object[n11];
            object4 = d14;
            d13 = null;
            objectArray[0] = object4;
            objectArray[n12] = object3 = Double.valueOf(d16);
            objectArray[n13] = object3 = Double.valueOf(d15);
            object3 = String.format(";%.0f:%.0f:%.1f", objectArray);
            ((StringBuffer)object).append((String)object3);
            ++n14;
            object3 = null;
        }
        return ((StringBuffer)object).toString();
    }
}

