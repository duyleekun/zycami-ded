/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.i;

import java.util.ArrayList;

public class h {
    public final int a;
    public Object[] b;
    public Object[] c;
    public volatile int d;
    public int e;

    public h(int n10) {
        this.a = n10;
    }

    public void a(Object objectArray) {
        int n10 = this.d;
        Object[] objectArray2 = null;
        int n11 = 1;
        if (n10 == 0) {
            n10 = this.a + n11;
            Object[] objectArray3 = new Object[n10];
            this.b = objectArray3;
            this.c = objectArray3;
            objectArray3[0] = objectArray;
            this.e = n11;
            this.d = n11;
        } else {
            n10 = this.e;
            int n12 = this.a;
            if (n10 == n12) {
                int n13;
                n10 = n12 + 1;
                Object[] objectArray4 = new Object[n10];
                objectArray4[0] = objectArray;
                objectArray = this.c;
                objectArray[n12] = objectArray4;
                this.c = objectArray4;
                this.e = n11;
                this.d = n13 = this.d + n11;
            } else {
                int n14;
                objectArray2 = this.c;
                objectArray2[n10] = objectArray;
                this.e = n10 += n11;
                this.d = n14 = this.d + n11;
            }
        }
    }

    public Object[] b() {
        return this.b;
    }

    public int c() {
        return this.d;
    }

    public String toString() {
        int n10 = this.a;
        int n11 = this.d;
        int n12 = n11 + 1;
        ArrayList<Object> arrayList = new ArrayList<Object>(n12);
        Object[] objectArray = this.b();
        int n13 = 0;
        for (int i10 = 0; i10 < n11; ++i10) {
            Object object = objectArray[n13];
            arrayList.add(object);
            if (++n13 != n10) continue;
            objectArray = (Object[])objectArray[n10];
            n13 = 0;
        }
        return ((Object)arrayList).toString();
    }
}

