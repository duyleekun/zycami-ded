/*
 * Decompiled with CFR 0.151.
 */
package kotlin.jvm.internal;

import f.h2.s.a;
import f.h2.s.b;
import f.h2.s.c;
import f.h2.s.d;
import f.h2.s.e;
import f.h2.s.f;
import f.h2.s.g;
import f.h2.s.h;
import f.h2.s.i;
import f.h2.s.j;
import f.h2.s.k;
import f.h2.s.l;
import f.h2.s.m;
import f.h2.s.n;
import f.h2.s.o;
import f.h2.s.q;
import f.h2.s.r;
import f.h2.s.s;
import f.h2.s.t;
import f.h2.s.u;
import f.h2.s.v;
import f.h2.s.w;
import f.p;
import java.io.Serializable;

public abstract class FunctionImpl
implements p,
Serializable,
a,
l,
f.h2.s.p,
q,
r,
s,
t,
u,
v,
w,
b,
c,
d,
e,
f,
g,
h,
i,
j,
k,
m,
n,
o {
    private void a(int n10) {
        int n11 = this.getArity();
        if (n11 != n10) {
            this.b(n10);
        }
    }

    private void b(int n10) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Wrong function arity, expected: ");
        stringBuilder.append(n10);
        stringBuilder.append(", actual: ");
        n10 = this.getArity();
        stringBuilder.append(n10);
        String string2 = stringBuilder.toString();
        IllegalStateException illegalStateException = new IllegalStateException(string2);
        throw illegalStateException;
    }

    public abstract int getArity();

    public Object invoke() {
        this.a(0);
        Object[] objectArray = new Object[]{};
        return this.invokeVararg(objectArray);
    }

    public Object invoke(Object object) {
        int n10 = 1;
        this.a(n10);
        Object[] objectArray = new Object[n10];
        objectArray[0] = object;
        return this.invokeVararg(objectArray);
    }

    public Object invoke(Object object, Object object2) {
        int n10 = 2;
        this.a(n10);
        Object[] objectArray = new Object[n10];
        objectArray[0] = object;
        objectArray[1] = object2;
        return this.invokeVararg(objectArray);
    }

    public Object invoke(Object object, Object object2, Object object3) {
        int n10 = 3;
        this.a(n10);
        Object[] objectArray = new Object[n10];
        objectArray[0] = object;
        objectArray[1] = object2;
        objectArray[2] = object3;
        return this.invokeVararg(objectArray);
    }

    public Object invoke(Object object, Object object2, Object object3, Object object4) {
        int n10 = 4;
        this.a(n10);
        Object[] objectArray = new Object[n10];
        objectArray[0] = object;
        objectArray[1] = object2;
        objectArray[2] = object3;
        objectArray[3] = object4;
        return this.invokeVararg(objectArray);
    }

    public Object invoke(Object object, Object object2, Object object3, Object object4, Object object5) {
        int n10 = 5;
        this.a(n10);
        Object[] objectArray = new Object[n10];
        objectArray[0] = object;
        objectArray[1] = object2;
        objectArray[2] = object3;
        objectArray[3] = object4;
        objectArray[4] = object5;
        return this.invokeVararg(objectArray);
    }

    public Object invoke(Object object, Object object2, Object object3, Object object4, Object object5, Object object6) {
        int n10 = 6;
        this.a(n10);
        Object[] objectArray = new Object[n10];
        objectArray[0] = object;
        objectArray[1] = object2;
        objectArray[2] = object3;
        objectArray[3] = object4;
        objectArray[4] = object5;
        objectArray[5] = object6;
        return this.invokeVararg(objectArray);
    }

    public Object invoke(Object object, Object object2, Object object3, Object object4, Object object5, Object object6, Object object7) {
        int n10 = 7;
        this.a(n10);
        Object[] objectArray = new Object[n10];
        objectArray[0] = object;
        objectArray[1] = object2;
        objectArray[2] = object3;
        objectArray[3] = object4;
        objectArray[4] = object5;
        objectArray[5] = object6;
        objectArray[6] = object7;
        return this.invokeVararg(objectArray);
    }

    public Object invoke(Object object, Object object2, Object object3, Object object4, Object object5, Object object6, Object object7, Object object8) {
        int n10 = 8;
        this.a(n10);
        Object[] objectArray = new Object[n10];
        objectArray[0] = object;
        objectArray[1] = object2;
        objectArray[2] = object3;
        objectArray[3] = object4;
        objectArray[4] = object5;
        objectArray[5] = object6;
        objectArray[6] = object7;
        objectArray[7] = object8;
        return this.invokeVararg(objectArray);
    }

    public Object invoke(Object object, Object object2, Object object3, Object object4, Object object5, Object object6, Object object7, Object object8, Object object9) {
        int n10 = 9;
        this.a(n10);
        Object[] objectArray = new Object[n10];
        objectArray[0] = object;
        objectArray[1] = object2;
        objectArray[2] = object3;
        objectArray[3] = object4;
        objectArray[4] = object5;
        objectArray[5] = object6;
        objectArray[6] = object7;
        objectArray[7] = object8;
        objectArray[8] = object9;
        return this.invokeVararg(objectArray);
    }

    public Object invoke(Object object, Object object2, Object object3, Object object4, Object object5, Object object6, Object object7, Object object8, Object object9, Object object10) {
        int n10 = 10;
        this.a(n10);
        Object[] objectArray = new Object[n10];
        objectArray[0] = object;
        objectArray[1] = object2;
        objectArray[2] = object3;
        objectArray[3] = object4;
        objectArray[4] = object5;
        objectArray[5] = object6;
        objectArray[6] = object7;
        objectArray[7] = object8;
        objectArray[8] = object9;
        objectArray[9] = object10;
        return this.invokeVararg(objectArray);
    }

    public Object invoke(Object object, Object object2, Object object3, Object object4, Object object5, Object object6, Object object7, Object object8, Object object9, Object object10, Object object11) {
        int n10 = 11;
        this.a(n10);
        Object[] objectArray = new Object[n10];
        objectArray[0] = object;
        objectArray[1] = object2;
        objectArray[2] = object3;
        objectArray[3] = object4;
        objectArray[4] = object5;
        objectArray[5] = object6;
        objectArray[6] = object7;
        objectArray[7] = object8;
        objectArray[8] = object9;
        objectArray[9] = object10;
        objectArray[10] = object11;
        return this.invokeVararg(objectArray);
    }

    public Object invoke(Object object, Object object2, Object object3, Object object4, Object object5, Object object6, Object object7, Object object8, Object object9, Object object10, Object object11, Object object12) {
        int n10 = 12;
        this.a(n10);
        Object[] objectArray = new Object[n10];
        objectArray[0] = object;
        objectArray[1] = object2;
        objectArray[2] = object3;
        objectArray[3] = object4;
        objectArray[4] = object5;
        objectArray[5] = object6;
        objectArray[6] = object7;
        objectArray[7] = object8;
        objectArray[8] = object9;
        objectArray[9] = object10;
        objectArray[10] = object11;
        objectArray[11] = object12;
        return this.invokeVararg(objectArray);
    }

    public Object invoke(Object object, Object object2, Object object3, Object object4, Object object5, Object object6, Object object7, Object object8, Object object9, Object object10, Object object11, Object object12, Object object13) {
        int n10 = 13;
        this.a(n10);
        Object[] objectArray = new Object[n10];
        objectArray[0] = object;
        objectArray[1] = object2;
        objectArray[2] = object3;
        objectArray[3] = object4;
        objectArray[4] = object5;
        objectArray[5] = object6;
        objectArray[6] = object7;
        objectArray[7] = object8;
        objectArray[8] = object9;
        objectArray[9] = object10;
        objectArray[10] = object11;
        objectArray[11] = object12;
        objectArray[12] = object13;
        return this.invokeVararg(objectArray);
    }

    public Object invoke(Object object, Object object2, Object object3, Object object4, Object object5, Object object6, Object object7, Object object8, Object object9, Object object10, Object object11, Object object12, Object object13, Object object14) {
        int n10 = 14;
        this.a(n10);
        Object[] objectArray = new Object[n10];
        objectArray[0] = object;
        objectArray[1] = object2;
        objectArray[2] = object3;
        objectArray[3] = object4;
        objectArray[4] = object5;
        objectArray[5] = object6;
        objectArray[6] = object7;
        objectArray[7] = object8;
        objectArray[8] = object9;
        objectArray[9] = object10;
        objectArray[10] = object11;
        objectArray[11] = object12;
        objectArray[12] = object13;
        objectArray[13] = object14;
        return this.invokeVararg(objectArray);
    }

    public Object invoke(Object object, Object object2, Object object3, Object object4, Object object5, Object object6, Object object7, Object object8, Object object9, Object object10, Object object11, Object object12, Object object13, Object object14, Object object15) {
        int n10 = 15;
        this.a(n10);
        Object[] objectArray = new Object[n10];
        objectArray[0] = object;
        objectArray[1] = object2;
        objectArray[2] = object3;
        objectArray[3] = object4;
        objectArray[4] = object5;
        objectArray[5] = object6;
        objectArray[6] = object7;
        objectArray[7] = object8;
        objectArray[8] = object9;
        objectArray[9] = object10;
        objectArray[10] = object11;
        objectArray[11] = object12;
        objectArray[12] = object13;
        objectArray[13] = object14;
        objectArray[14] = object15;
        return this.invokeVararg(objectArray);
    }

    public Object invoke(Object object, Object object2, Object object3, Object object4, Object object5, Object object6, Object object7, Object object8, Object object9, Object object10, Object object11, Object object12, Object object13, Object object14, Object object15, Object object16) {
        int n10 = 16;
        this.a(n10);
        Object[] objectArray = new Object[n10];
        objectArray[0] = object;
        objectArray[1] = object2;
        objectArray[2] = object3;
        objectArray[3] = object4;
        objectArray[4] = object5;
        objectArray[5] = object6;
        objectArray[6] = object7;
        objectArray[7] = object8;
        objectArray[8] = object9;
        objectArray[9] = object10;
        objectArray[10] = object11;
        objectArray[11] = object12;
        objectArray[12] = object13;
        objectArray[13] = object14;
        objectArray[14] = object15;
        objectArray[15] = object16;
        return this.invokeVararg(objectArray);
    }

    public Object invoke(Object object, Object object2, Object object3, Object object4, Object object5, Object object6, Object object7, Object object8, Object object9, Object object10, Object object11, Object object12, Object object13, Object object14, Object object15, Object object16, Object object17) {
        int n10 = 17;
        this.a(n10);
        Object[] objectArray = new Object[n10];
        objectArray[0] = object;
        objectArray[1] = object2;
        objectArray[2] = object3;
        objectArray[3] = object4;
        objectArray[4] = object5;
        objectArray[5] = object6;
        objectArray[6] = object7;
        objectArray[7] = object8;
        objectArray[8] = object9;
        objectArray[9] = object10;
        objectArray[10] = object11;
        objectArray[11] = object12;
        objectArray[12] = object13;
        objectArray[13] = object14;
        objectArray[14] = object15;
        objectArray[15] = object16;
        objectArray[16] = object17;
        return this.invokeVararg(objectArray);
    }

    public Object invoke(Object object, Object object2, Object object3, Object object4, Object object5, Object object6, Object object7, Object object8, Object object9, Object object10, Object object11, Object object12, Object object13, Object object14, Object object15, Object object16, Object object17, Object object18) {
        int n10 = 18;
        this.a(n10);
        Object[] objectArray = new Object[n10];
        objectArray[0] = object;
        objectArray[1] = object2;
        objectArray[2] = object3;
        objectArray[3] = object4;
        objectArray[4] = object5;
        objectArray[5] = object6;
        objectArray[6] = object7;
        objectArray[7] = object8;
        objectArray[8] = object9;
        objectArray[9] = object10;
        objectArray[10] = object11;
        objectArray[11] = object12;
        objectArray[12] = object13;
        objectArray[13] = object14;
        objectArray[14] = object15;
        objectArray[15] = object16;
        objectArray[16] = object17;
        objectArray[17] = object18;
        return this.invokeVararg(objectArray);
    }

    public Object invoke(Object object, Object object2, Object object3, Object object4, Object object5, Object object6, Object object7, Object object8, Object object9, Object object10, Object object11, Object object12, Object object13, Object object14, Object object15, Object object16, Object object17, Object object18, Object object19) {
        int n10 = 19;
        this.a(n10);
        Object[] objectArray = new Object[n10];
        objectArray[0] = object;
        objectArray[1] = object2;
        objectArray[2] = object3;
        objectArray[3] = object4;
        objectArray[4] = object5;
        objectArray[5] = object6;
        objectArray[6] = object7;
        objectArray[7] = object8;
        objectArray[8] = object9;
        objectArray[9] = object10;
        objectArray[10] = object11;
        objectArray[11] = object12;
        objectArray[12] = object13;
        objectArray[13] = object14;
        objectArray[14] = object15;
        objectArray[15] = object16;
        objectArray[16] = object17;
        objectArray[17] = object18;
        objectArray[18] = object19;
        return this.invokeVararg(objectArray);
    }

    public Object invoke(Object object, Object object2, Object object3, Object object4, Object object5, Object object6, Object object7, Object object8, Object object9, Object object10, Object object11, Object object12, Object object13, Object object14, Object object15, Object object16, Object object17, Object object18, Object object19, Object object20) {
        int n10 = 20;
        this.a(n10);
        Object[] objectArray = new Object[n10];
        objectArray[0] = object;
        objectArray[1] = object2;
        objectArray[2] = object3;
        objectArray[3] = object4;
        objectArray[4] = object5;
        objectArray[5] = object6;
        objectArray[6] = object7;
        objectArray[7] = object8;
        objectArray[8] = object9;
        objectArray[9] = object10;
        objectArray[10] = object11;
        objectArray[11] = object12;
        objectArray[12] = object13;
        objectArray[13] = object14;
        objectArray[14] = object15;
        objectArray[15] = object16;
        objectArray[16] = object17;
        objectArray[17] = object18;
        objectArray[18] = object19;
        objectArray[19] = object20;
        return this.invokeVararg(objectArray);
    }

    public Object invoke(Object object, Object object2, Object object3, Object object4, Object object5, Object object6, Object object7, Object object8, Object object9, Object object10, Object object11, Object object12, Object object13, Object object14, Object object15, Object object16, Object object17, Object object18, Object object19, Object object20, Object object21) {
        int n10 = 21;
        this.a(n10);
        Object[] objectArray = new Object[n10];
        objectArray[0] = object;
        objectArray[1] = object2;
        objectArray[2] = object3;
        objectArray[3] = object4;
        objectArray[4] = object5;
        objectArray[5] = object6;
        objectArray[6] = object7;
        objectArray[7] = object8;
        objectArray[8] = object9;
        objectArray[9] = object10;
        objectArray[10] = object11;
        objectArray[11] = object12;
        objectArray[12] = object13;
        objectArray[13] = object14;
        objectArray[14] = object15;
        objectArray[15] = object16;
        objectArray[16] = object17;
        objectArray[17] = object18;
        objectArray[18] = object19;
        objectArray[19] = object20;
        objectArray[20] = object21;
        return this.invokeVararg(objectArray);
    }

    public Object invoke(Object object, Object object2, Object object3, Object object4, Object object5, Object object6, Object object7, Object object8, Object object9, Object object10, Object object11, Object object12, Object object13, Object object14, Object object15, Object object16, Object object17, Object object18, Object object19, Object object20, Object object21, Object object22) {
        int n10 = 22;
        this.a(n10);
        Object[] objectArray = new Object[n10];
        objectArray[0] = object;
        objectArray[1] = object2;
        objectArray[2] = object3;
        objectArray[3] = object4;
        objectArray[4] = object5;
        objectArray[5] = object6;
        objectArray[6] = object7;
        objectArray[7] = object8;
        objectArray[8] = object9;
        objectArray[9] = object10;
        objectArray[10] = object11;
        objectArray[11] = object12;
        objectArray[12] = object13;
        objectArray[13] = object14;
        objectArray[14] = object15;
        objectArray[15] = object16;
        objectArray[16] = object17;
        objectArray[17] = object18;
        objectArray[18] = object19;
        objectArray[19] = object20;
        objectArray[20] = object21;
        objectArray[21] = object22;
        return this.invokeVararg(objectArray);
    }

    public Object invokeVararg(Object ... object) {
        object = new UnsupportedOperationException();
        throw object;
    }
}

