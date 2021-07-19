/*
 * Decompiled with CFR 0.151.
 */
package cn.sharesdk.framework.utils.QRCodeUtil;

import cn.sharesdk.framework.utils.QRCodeUtil.g;

public final class h {
    private final g a;
    private final int[] b;

    public h(g object, int[] nArray) {
        int n10 = nArray.length;
        if (n10 != 0) {
            int n11;
            this.a = object;
            int n12 = nArray.length;
            n10 = 1;
            if (n12 > n10 && (n11 = nArray[0]) == 0) {
                int n13;
                for (n11 = n10; n11 < n12 && (n13 = nArray[n11]) == 0; ++n11) {
                }
                if (n11 == n12) {
                    object = new int[n10];
                    object[0] = false;
                    this.b = (int[])object;
                } else {
                    object = new int[n12 -= n11];
                    this.b = (int[])object;
                    n10 = ((Object)object).length;
                    System.arraycopy(nArray, n11, object, 0, n10);
                }
            } else {
                this.b = nArray;
            }
            return;
        }
        object = new IllegalArgumentException();
        throw object;
    }

    public int a(int n10) {
        int[] nArray = this.b;
        int n11 = nArray.length + -1 - n10;
        return nArray[n11];
    }

    public h a(int n10, int n11) {
        if (n10 >= 0) {
            if (n11 == 0) {
                return this.a.a();
            }
            Object object = this.b;
            int n12 = ((int[])object).length;
            int[] nArray = new int[n10 += n12];
            for (int i10 = 0; i10 < n12; ++i10) {
                int n13;
                g g10 = this.a;
                int[] nArray2 = this.b;
                int n14 = nArray2[i10];
                nArray[i10] = n13 = g10.c(n14, n11);
            }
            object = this.a;
            h h10 = new h((g)object, nArray);
            return h10;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException();
        throw illegalArgumentException;
    }

    public h a(h object) {
        Object object2 = this.a;
        Object object3 = ((h)object).a;
        boolean bl2 = object2.equals(object3);
        if (bl2) {
            Object object4;
            bl2 = this.c();
            if (bl2) {
                return object;
            }
            bl2 = ((h)object).c();
            if (bl2) {
                return this;
            }
            object2 = this.b;
            int n10 = ((Object)object2).length;
            object = ((h)object).b;
            int n11 = ((Object)object).length;
            if (n10 <= n11) {
                Object object5 = object2;
                object2 = object;
                object = object5;
            }
            n10 = ((Object)object2).length;
            object3 = new int[n10];
            n11 = ((Object)object2).length;
            int n12 = ((Object)object).length;
            System.arraycopy(object2, 0, object3, 0, n11 -= n12);
            for (n12 = n11; n12 < (object4 = ((Object)object2).length); ++n12) {
                object4 = n12 - n11;
                object4 = object[object4];
                Object object6 = object2[n12];
                object4 = g.b(object4, (int)object6);
                object3[n12] = object4;
            }
            object2 = this.a;
            object = new h((g)object2, (int[])object3);
            return object;
        }
        object = new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
        throw object;
    }

    public int[] a() {
        return this.b;
    }

    public int b() {
        return this.b.length + -1;
    }

    public h b(h object) {
        Object object2 = this.a;
        g g10 = ((h)object).a;
        boolean bl2 = object2.equals(g10);
        if (bl2) {
            bl2 = this.c();
            if (!bl2 && !(bl2 = ((h)object).c())) {
                object2 = this.b;
                int n10 = ((Object)object2).length;
                object = ((h)object).b;
                int n11 = ((Object)object).length;
                int n12 = n10 + n11 + -1;
                int[] nArray = new int[n12];
                for (int i10 = 0; i10 < n10; ++i10) {
                    Object object3 = object2[i10];
                    for (int i11 = 0; i11 < n11; ++i11) {
                        int n13 = i10 + i11;
                        int n14 = nArray[n13];
                        g g11 = this.a;
                        Object object4 = object[i11];
                        int n15 = g11.c((int)object3, (int)object4);
                        nArray[n13] = n14 = g.b(n14, n15);
                    }
                }
                object2 = this.a;
                object = new h((g)object2, nArray);
                return object;
            }
            return this.a.a();
        }
        object = new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
        throw object;
    }

    public boolean c() {
        int[] nArray = this.b;
        boolean bl2 = false;
        int n10 = nArray[0];
        if (n10 == 0) {
            bl2 = true;
        }
        return bl2;
    }

    public h[] c(h hArray) {
        Object object = this.a;
        g g10 = hArray.a;
        boolean bl2 = object.equals(g10);
        if (bl2) {
            bl2 = hArray.c();
            if (!bl2) {
                int n10;
                int n11;
                object = this.a.a();
                int n12 = hArray.b();
                n12 = hArray.a(n12);
                n12 = this.a.c(n12);
                h h10 = this;
                while ((n11 = h10.b()) >= (n10 = hArray.b()) && (n11 = (int)(h10.c() ? 1 : 0)) == 0) {
                    n11 = h10.b();
                    n10 = hArray.b();
                    n11 -= n10;
                    g g11 = this.a;
                    int n13 = h10.b();
                    n13 = h10.a(n13);
                    n10 = g11.c(n13, n12);
                    h h11 = hArray.a(n11, n10);
                    g g12 = this.a;
                    h h12 = g12.a(n11, n10);
                    object = ((h)object).a(h12);
                    h10 = h10.a(h11);
                }
                hArray = new h[]{object, h10};
                return hArray;
            }
            hArray = new IllegalArgumentException("Divide by 0");
            throw hArray;
        }
        hArray = new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
        throw hArray;
    }

    public String toString() {
        int n10 = this.b() * 8;
        StringBuilder stringBuilder = new StringBuilder(n10);
        for (n10 = this.b(); n10 >= 0; n10 += -1) {
            int n11;
            String string2;
            int n12 = this.a(n10);
            if (n12 == 0) continue;
            if (n12 < 0) {
                string2 = " - ";
                stringBuilder.append(string2);
                n12 = -n12;
            } else {
                n11 = stringBuilder.length();
                if (n11 > 0) {
                    string2 = " + ";
                    stringBuilder.append(string2);
                }
            }
            n11 = 1;
            if (n10 == 0 || n12 != n11) {
                Object object = this.a;
                if ((n12 = ((g)object).b(n12)) == 0) {
                    n12 = 49;
                    stringBuilder.append((char)n12);
                } else if (n12 == n11) {
                    n12 = 97;
                    stringBuilder.append((char)n12);
                } else {
                    object = "a^";
                    stringBuilder.append((String)object);
                    stringBuilder.append(n12);
                }
            }
            if (n10 == 0) continue;
            if (n10 == n11) {
                n12 = 120;
                stringBuilder.append((char)n12);
                continue;
            }
            String string3 = "x^";
            stringBuilder.append(string3);
            stringBuilder.append(n10);
        }
        return stringBuilder.toString();
    }
}

