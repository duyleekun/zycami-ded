/*
 * Decompiled with CFR 0.151.
 */
package f.x1;

import f.h2.t.f0;
import f.l2.q;
import f.x1.a1$a;
import f.x1.c;
import f.x1.n;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;
import java.util.RandomAccess;

public final class a1
extends c
implements RandomAccess {
    private final int b;
    private int c;
    private int d;
    private final Object[] e;

    public a1(int n10) {
        Object[] objectArray = new Object[n10];
        this(objectArray, 0);
    }

    public a1(Object[] object, int n10) {
        CharSequence charSequence = "buffer";
        f0.p(object, (String)charSequence);
        this.e = object;
        int n11 = 1;
        int n12 = n10 >= 0 ? n11 : 0;
        if (n12 != 0) {
            n12 = ((Object[])object).length;
            if (n10 > n12) {
                n11 = 0;
                charSequence = null;
            }
            if (n11 != 0) {
                int n13;
                this.b = n13 = ((Object)object).length;
                this.d = n10;
                return;
            }
            ((StringBuilder)charSequence).append("ring buffer filled size: ");
            ((StringBuilder)charSequence).append(n10);
            ((StringBuilder)charSequence).append(" cannot be larger than the buffer size: ");
            int n14 = ((Object)object).length;
            ((StringBuilder)charSequence).append(n14);
            object = ((StringBuilder)charSequence).toString();
            object = object.toString();
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)object);
            throw illegalArgumentException;
        }
        super();
        ((StringBuilder)object).append("ring buffer filled size should not be negative but it is ");
        ((StringBuilder)object).append(n10);
        object = ((StringBuilder)object).toString();
        object = object.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)object);
        throw illegalArgumentException;
    }

    public static final /* synthetic */ int c(a1 a12, int n10, int n11) {
        return a12.m(n10, n11);
    }

    public static final /* synthetic */ Object[] e(a1 a12) {
        return a12.e;
    }

    public static final /* synthetic */ int g(a1 a12) {
        return a12.size();
    }

    public static final /* synthetic */ int h(a1 a12) {
        return a12.c;
    }

    public static final /* synthetic */ void i(a1 a12, int n10) {
        a12.d = n10;
    }

    public static final /* synthetic */ void j(a1 a12, int n10) {
        a12.c = n10;
    }

    private final int m(int n10, int n11) {
        n10 += n11;
        n11 = this.b;
        return n10 % n11;
    }

    public int b() {
        return this.d;
    }

    public Object get(int n10) {
        Object[] objectArray = f.x1.c.a;
        int n11 = this.size();
        objectArray.b(n10, n11);
        objectArray = this.e;
        n11 = this.c + n10;
        n10 = this.b;
        return objectArray[n11 %= n10];
    }

    public Iterator iterator() {
        a1$a a1$a = new a1$a(this);
        return a1$a;
    }

    public final void k(Object object) {
        boolean bl2 = this.n();
        if (!bl2) {
            int n10;
            Object[] objectArray = this.e;
            int n11 = this.c;
            int n12 = this.size();
            n11 += n12;
            n12 = this.b;
            objectArray[n11 %= n12] = object;
            this.d = n10 = this.size() + 1;
            return;
        }
        object = new IllegalStateException("ring buffer is full");
        throw object;
    }

    public final a1 l(int n10) {
        Object object;
        Object[] objectArray;
        int n11 = this.b;
        int n12 = n11 >> 1;
        n10 = q.u(n11 + n12 + 1, n10);
        n11 = this.c;
        if (n11 == 0) {
            objectArray = Arrays.copyOf(this.e, n10);
            object = "java.util.Arrays.copyOf(this, newSize)";
            f0.o(objectArray, (String)object);
        } else {
            objectArray = new Object[n10];
            objectArray = this.toArray(objectArray);
        }
        n12 = this.size();
        object = new a1(objectArray, n12);
        return object;
    }

    public final boolean n() {
        int n10;
        int n11 = this.size();
        n11 = n11 == (n10 = this.b) ? 1 : 0;
        return n11 != 0;
    }

    public final void o(int n10) {
        int n11 = 1;
        Object[] objectArray = null;
        int n12 = n10 >= 0 ? n11 : 0;
        if (n12 != 0) {
            Object[] objectArray2;
            n12 = this.size();
            if (n10 > n12) {
                n11 = 0;
                objectArray2 = null;
            }
            if (n11 != 0) {
                if (n10 > 0) {
                    n11 = this.c;
                    n12 = n11 + n10;
                    int n13 = this.b;
                    n12 %= n13;
                    n13 = 0;
                    if (n11 > n12) {
                        Object[] objectArray3 = this.e;
                        int n14 = this.b;
                        n.n2(objectArray3, null, n11, n14);
                        objectArray2 = this.e;
                        n.n2(objectArray2, null, 0, n12);
                    } else {
                        objectArray = this.e;
                        n.n2(objectArray, null, n11, n12);
                    }
                    this.c = n12;
                    this.d = n11 = this.size() - n10;
                }
                return;
            }
            objectArray2 = new StringBuilder();
            objectArray2.append("n shouldn't be greater than the buffer size: n = ");
            objectArray2.append(n10);
            objectArray2.append(", size = ");
            n10 = this.size();
            objectArray2.append(n10);
            String string2 = objectArray2.toString();
            string2 = string2.toString();
            objectArray2 = new IllegalArgumentException(string2);
            throw objectArray2;
        }
        Serializable serializable = new StringBuilder();
        serializable.append("n shouldn't be negative but it is ");
        serializable.append(n10);
        String string3 = serializable.toString();
        string3 = string3.toString();
        serializable = new IllegalArgumentException(string3);
        throw serializable;
    }

    public Object[] toArray() {
        Object[] objectArray = new Object[this.size()];
        return this.toArray(objectArray);
    }

    public Object[] toArray(Object[] objectArray) {
        Object object;
        int n10;
        int n11;
        String string2 = "array";
        f0.p(objectArray, string2);
        int n12 = objectArray.length;
        int n13 = this.size();
        if (n12 < n13) {
            n12 = this.size();
            objectArray = Arrays.copyOf(objectArray, n12);
            string2 = "java.util.Arrays.copyOf(this, newSize)";
            f0.o(objectArray, string2);
        }
        n12 = this.size();
        n13 = this.c;
        int n14 = 0;
        for (n11 = 0; n11 < n12 && n13 < (n10 = this.b); ++n11, ++n13) {
            Object object2;
            objectArray[n11] = object2 = this.e[n13];
        }
        while (n11 < n12) {
            objectArray[n11] = object = this.e[n14];
            ++n11;
            ++n14;
        }
        n12 = objectArray.length;
        n13 = this.size();
        if (n12 > n13) {
            n12 = this.size();
            n13 = 0;
            object = null;
            objectArray[n12] = null;
        }
        Objects.requireNonNull(objectArray, "null cannot be cast to non-null type kotlin.Array<T>");
        return objectArray;
    }
}

