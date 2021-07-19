/*
 * Decompiled with CFR 0.151.
 */
package j$.time.format;

import j$.e.a.a.a.a;
import j$.time.c;
import j$.time.format.B;
import j$.time.format.c_0;
import j$.time.format.f;
import j$.time.format.v;
import j$.time.format.z;
import j$.time.q.u;

class j
implements f {
    static final long[] f;
    final u a;
    final int b;
    final int c;
    private final B d;
    final int e;

    static {
        long[] lArray;
        long[] lArray2 = lArray = new long[11];
        long[] lArray3 = lArray;
        lArray2[0] = 0L;
        lArray3[1] = 10;
        lArray2[2] = 100;
        lArray3[3] = 1000L;
        lArray2[4] = 10000L;
        lArray3[5] = 100000L;
        lArray2[6] = 1000000L;
        lArray3[7] = 10000000L;
        lArray2[8] = 100000000L;
        lArray3[9] = 1000000000L;
        lArray3[10] = 10000000000L;
        f = lArray;
    }

    j(u u10, int n10, int n11, B b10) {
        this.a = u10;
        this.b = n10;
        this.c = n11;
        this.d = b10;
        this.e = 0;
    }

    protected j(u u10, int n10, int n11, B b10, int n12) {
        this.a = u10;
        this.b = n10;
        this.c = n11;
        this.d = b10;
        this.e = n12;
    }

    static /* synthetic */ B a(j j10) {
        return j10.d;
    }

    long b(v v10, long l10) {
        return l10;
    }

    j c() {
        int n10 = this.e;
        int n11 = -1;
        if (n10 == n11) {
            return this;
        }
        u u10 = this.a;
        int n12 = this.b;
        int n13 = this.c;
        B b10 = this.d;
        j j10 = new j(u10, n12, n13, b10, -1);
        return j10;
    }

    j d(int n10) {
        u u10 = this.a;
        int n11 = this.b;
        int n12 = this.c;
        B b10 = this.d;
        int n13 = this.e + n10;
        j j10 = new j(u10, n11, n12, b10, n13);
        return j10;
    }

    public boolean m(v object, StringBuilder charSequence) {
        String string2;
        Object object2;
        Object object3;
        long l10;
        Object object4;
        block4: {
            int n10;
            int n11;
            int n102;
            block6: {
                block7: {
                    block8: {
                        block9: {
                            Object object5;
                            block5: {
                                String string3;
                                long l11;
                                int n12;
                                object4 = this.a;
                                object4 = ((v)object).e((u)object4);
                                n102 = 0;
                                if (object4 == null) {
                                    return false;
                                }
                                l10 = (Long)object4;
                                l10 = this.b((v)object, l10);
                                object = ((v)object).b();
                                long l12 = Long.MIN_VALUE;
                                long l13 = l10 - l12;
                                object3 = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
                                if (object3 == false) {
                                    object4 = "9223372036854775808";
                                } else {
                                    l12 = Math.abs(l10);
                                    object4 = Long.toString(l12);
                                }
                                int c11 = ((String)object4).length();
                                int n13 = this.c;
                                object2 = " cannot be printed as the value ";
                                string2 = "Field ";
                                if (c11 > n13) break block4;
                                object4 = ((z)object).a((String)object4);
                                l12 = 0L;
                                long l14 = l10 == l12 ? 0 : (l10 < l12 ? -1 : 1);
                                n11 = 1;
                                if (l14 < 0) break block5;
                                object5 = c_0.a;
                                object2 = this.d;
                                int n14 = ((Enum)object2).ordinal();
                                Object object6 = object5[n14];
                                if (object6 == n11 ? (n12 = this.b) >= (n14 = 19) || (n10 = (int)((l11 = l10 - (string3 = (object2 = (Object)f)[n12])) == 0L ? 0 : (l11 < 0L ? -1 : 1))) < 0 : object6 != (n10 = 2)) break block6;
                                n10 = ((z)object).d();
                                break block7;
                            }
                            object5 = (Object)this.d;
                            int n15 = object5.ordinal();
                            if (n15 == 0 || n15 == n11) break block8;
                            int n16 = 3;
                            if (n15 == n16) break block9;
                            n10 = 4;
                            if (n15 == n10) break block8;
                            break block6;
                        }
                        charSequence = j$.e.a.a.a.a.b(string2);
                        object4 = this.a;
                        ((StringBuilder)charSequence).append(object4);
                        ((StringBuilder)charSequence).append((String)object2);
                        ((StringBuilder)charSequence).append(l10);
                        ((StringBuilder)charSequence).append(" cannot be negative according to the SignStyle");
                        charSequence = ((StringBuilder)charSequence).toString();
                        object = new c((String)charSequence);
                        throw object;
                    }
                    n10 = ((z)object).c();
                }
                ((StringBuilder)charSequence).append((char)n10);
            }
            while (true) {
                n10 = this.b;
                int n17 = ((String)object4).length();
                if (n102 >= (n10 -= n17)) break;
                n10 = ((z)object).e();
                ((StringBuilder)charSequence).append((char)n10);
                ++n102;
            }
            ((StringBuilder)charSequence).append((String)object4);
            return n11 != 0;
        }
        charSequence = j$.e.a.a.a.a.b(string2);
        object4 = this.a;
        ((StringBuilder)charSequence).append(object4);
        ((StringBuilder)charSequence).append((String)object2);
        ((StringBuilder)charSequence).append(l10);
        ((StringBuilder)charSequence).append(" exceeds the maximum print width of ");
        object3 = this.c;
        ((StringBuilder)charSequence).append((int)object3);
        charSequence = ((StringBuilder)charSequence).toString();
        object = new c((String)charSequence);
        throw object;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public String toString() {
        block2: {
            var1_1 = this.b;
            var2_2 = ")";
            var3_3 /* !! */  = "Value(";
            var4_4 = 1;
            if (var1_1 != var4_4 || (var4_4 = this.c) != (var5_5 = 19) || (var6_6 = this.d) != (var7_7 /* !! */  = B.a)) break block2;
            var8_8 = j$.e.a.a.a.a.b((String)var3_3 /* !! */ );
            var3_3 /* !! */  = this.a;
            ** GOTO lbl40
        }
        var4_4 = this.c;
        var7_7 /* !! */  = ",";
        if (var1_1 == var4_4 && (var8_8 = this.d) == (var6_6 = B.c)) {
            var8_8 = j$.e.a.a.a.a.b((String)var3_3 /* !! */ );
            var3_3 /* !! */  = this.a;
            var8_8.append(var3_3 /* !! */ );
            var8_8.append(var7_7 /* !! */ );
            var9_9 = this.b;
            var8_8.append(var9_9);
        } else {
            var8_8 = j$.e.a.a.a.a.b((String)var3_3 /* !! */ );
            var3_3 /* !! */  = this.a;
            var8_8.append(var3_3 /* !! */ );
            var8_8.append(var7_7 /* !! */ );
            var9_10 = this.b;
            var8_8.append(var9_10);
            var8_8.append(var7_7 /* !! */ );
            var9_10 = this.c;
            var8_8.append(var9_10);
            var8_8.append(var7_7 /* !! */ );
            var3_3 /* !! */  = this.d;
lbl40:
            // 2 sources

            var8_8.append(var3_3 /* !! */ );
        }
        var8_8.append(var2_2);
        return var8_8.toString();
    }
}

