/*
 * Decompiled with CFR 0.151.
 */
package d.v.e0;

import d.v.e0.rd;
import d.v.y.d.a;
import d.v.y.d.b;
import java.util.ArrayList;
import java.util.List;

public class wd {
    private List a;

    public wd() {
        ArrayList arrayList;
        this.a = arrayList = new ArrayList(4);
    }

    private byte[] c(int n10) {
        return b.q(((rd)this.a.get(n10)).b(), 2);
    }

    public void a(rd rd2) {
        this.a.add(rd2);
    }

    public void b() {
        this.a.clear();
    }

    public String d() {
        int n10;
        Object object = this.a;
        int n11 = object.size();
        if (n11 < (n10 = 4)) {
            return "";
        }
        n11 = 3;
        Object object2 = this.c(n11);
        object = new byte[n11][];
        int n12 = 2;
        byte[] byArray = this.c(n12);
        object[0] = byArray;
        int n13 = 1;
        byte[] byArray2 = this.c(n13);
        object[n13] = byArray2;
        byArray2 = this.c(0);
        object[n12] = byArray2;
        object = d.v.y.d.a.a((byte[])object2, (byte[][])object);
        object2 = new StringBuilder;
        ((StringBuilder)object2)();
        n12 = ((Object)object).length;
        byArray2 = null;
        for (int i10 = 0; i10 < n12; ++i10) {
            Object object3;
            Object object4 = object[i10];
            Object[] objectArray = new Object[n13];
            objectArray[0] = object3 = Byte.valueOf((byte)object4);
            object3 = String.format("%02X", objectArray);
            ((StringBuilder)object2).append((String)object3);
        }
        ((StringBuilder)object2).deleteCharAt(0);
        return ((StringBuilder)object2).toString();
    }
}

