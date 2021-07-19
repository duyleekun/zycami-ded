/*
 * Decompiled with CFR 0.151.
 */
package j$.time.r;

import j$.time.Instant;
import j$.time.LocalDate;
import j$.time.e;
import j$.time.l;
import j$.time.r.a;
import j$.time.r.b;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public final class c
implements Serializable {
    private static final long[] i = new long[0];
    private static final b[] j = new b[0];
    private static final e[] k = new e[0];
    private static final a[] l = new a[0];
    private final long[] a;
    private final l[] b;
    private final long[] c;
    private final e[] d;
    private final l[] e;
    private final b[] f;
    private final TimeZone g;
    private final transient ConcurrentMap h;

    private c(l serializableArray) {
        l[] lArray;
        this.h = lArray = new ConcurrentHashMap();
        lArray = new l[1];
        this.b = lArray;
        lArray[0] = serializableArray;
        serializableArray = (Serializable[])i;
        this.a = (long[])serializableArray;
        this.c = (long[])serializableArray;
        serializableArray = k;
        this.d = serializableArray;
        this.e = lArray;
        serializableArray = j;
        this.f = serializableArray;
        this.g = null;
    }

    c(TimeZone timeZone) {
        Serializable[] serializableArray = new ConcurrentHashMap();
        this.h = serializableArray;
        serializableArray = new l[1];
        this.b = serializableArray;
        e[] eArray = j$.time.r.c.k(timeZone.getRawOffset());
        serializableArray[0] = eArray;
        eArray = (e[])i;
        this.a = (long[])eArray;
        this.c = (long[])eArray;
        eArray = k;
        this.d = eArray;
        this.e = serializableArray;
        serializableArray = j;
        this.f = serializableArray;
        this.g = timeZone;
    }

    private Object a(e e10, a a10) {
        e e11 = a10.n();
        boolean bl2 = a10.O();
        boolean bl3 = e10.L(e11);
        if (bl2) {
            if (bl3) {
                return a10.D();
            }
            e11 = a10.m();
            boolean bl4 = e10.L(e11);
            if (bl4) {
                return a10;
            }
            return a10.C();
        }
        if (!bl3) {
            return a10.C();
        }
        e11 = a10.m();
        boolean bl5 = e10.L(e11);
        if (bl5) {
            return a10.D();
        }
        return a10;
    }

    private a[] b(int n10) {
        c c10 = this;
        int n11 = n10;
        Serializable[] serializableArray = l;
        Integer n12 = n10;
        Object object = (a[])this.h.get(n12);
        if (object != null) {
            return object;
        }
        object = this.g;
        l l10 = null;
        if (object != null) {
            long l11;
            int n13 = 1800;
            if (n10 < n13) {
                return serializableArray;
            }
            n13 = n10 + -1;
            int n14 = 12;
            int n15 = 31;
            object = j$.time.e.O(n13, n14, n15, 0, 0);
            l[] lArray = this.b;
            l10 = lArray[0];
            long l12 = object.N(l10);
            object = this.g;
            long l13 = 1000L;
            double d10 = 4.94E-321;
            long l14 = l12 * l13;
            n13 = ((TimeZone)object).getOffset(l14);
            double d11 = 1.57942906E-316;
            l14 = 31968000L + l12;
            while ((l11 = l12 == l14 ? 0 : (l12 < l14 ? -1 : 1)) < 0) {
                long l15;
                long l16 = 7776000L + l12;
                TimeZone timeZone = c10.g;
                long l17 = l12;
                long l18 = l16 * l13;
                int n16 = timeZone.getOffset(l18);
                if (n13 != n16) {
                    TimeZone timeZone2;
                    long l19;
                    while ((n16 = (int)((l19 = (l17 = l16 - l12) - (l15 = 1L)) == 0L ? 0 : (l19 < 0L ? -1 : 1))) > 0) {
                        l13 = l16 + l12;
                        l15 = l14;
                        l13 = Math.floorDiv(l13, (long)2);
                        timeZone2 = c10.g;
                        l17 = l16;
                        l14 = 1000L;
                        d11 = 4.94E-321;
                        l16 = l13 * l14;
                        n16 = timeZone2.getOffset(l16);
                        if (n16 == n13) {
                            l12 = l13;
                            l16 = l17;
                        } else {
                            l16 = l13;
                        }
                        l13 = l14;
                        d10 = d11;
                        l14 = l15;
                    }
                    l15 = l14;
                    l17 = l16;
                    l14 = l13;
                    d11 = d10;
                    timeZone2 = c10.g;
                    n16 = timeZone2.getOffset(l13 = l12 * l13);
                    if (n16 == n13) {
                        l12 = l16;
                    }
                    object = j$.time.r.c.k(n13);
                    timeZone2 = c10.g;
                    l13 = l12 * l14;
                    n16 = timeZone2.getOffset(l13);
                    l l20 = j$.time.r.c.k(n16);
                    int n17 = c10.c(l12, l20);
                    if (n17 == n11) {
                        n17 = serializableArray.length + 1;
                        serializableArray = (a[])Arrays.copyOf(serializableArray, n17);
                        n17 = serializableArray.length + -1;
                        a a10 = new a(l12, (l)object, l20);
                        serializableArray[n17] = a10;
                    }
                    n13 = n16;
                } else {
                    l15 = l14;
                    l14 = l13;
                    d11 = d10;
                    l12 = l16;
                }
                l13 = l14;
                d10 = d11;
                l14 = l15;
            }
            n13 = 1916;
            if (n13 <= n11 && n11 < (n13 = 2100)) {
                ConcurrentMap concurrentMap = c10.h;
                concurrentMap.putIfAbsent(n12, serializableArray);
            }
            return serializableArray;
        }
        serializableArray = this.f;
        int n18 = serializableArray.length;
        object = new a[n18];
        int n19 = serializableArray.length;
        if (n19 <= 0) {
            n19 = 2100;
            if (n10 < n19) {
                ConcurrentMap concurrentMap = this.h;
                concurrentMap.putIfAbsent(n12, object);
            }
            return object;
        }
        Serializable serializable = serializableArray[0];
        throw null;
    }

    private int c(long l10, l l11) {
        long l12 = l11.C();
        return LocalDate.L(j$.a.a(l10 + l12, 86400)).getYear();
    }

    /*
     * WARNING - void declaration
     */
    private Object e(e s10) {
        int n10;
        int n11;
        e[] eArray;
        e e10;
        TimeZone object = this.g;
        int n12 = 0;
        Object var4_20 = null;
        l[] lArray = null;
        if (object != null) {
            void var4_22;
            int n13 = ((e)s10).C();
            a[] aArray = this.b(n13);
            int n14 = aArray.length;
            if (n14 == 0) {
                TimeZone timeZone = this.g;
                l l10 = this.b[0];
                long l11 = s10.N(l10) * 1000L;
                return j$.time.r.c.k(timeZone.getOffset(l11));
            }
            for (a a10 : aArray) {
                l l12;
                Object object2 = this.a((e)s10, a10);
                boolean bl2 = object2 instanceof a;
                if (!bl2 && (n12 = (int)(object2.equals(l12 = a10.D()) ? 1 : 0)) == 0) {
                    Object object3 = object2;
                    continue;
                }
                return object2;
            }
            return var4_22;
        }
        long[] lArray2 = this.c;
        int n15 = lArray2.length;
        if (n15 == 0) {
            return this.b[0];
        }
        b[] bArray = this.f;
        n15 = bArray.length;
        if (n15 > 0 && (n15 = (int)(((e)s10).D(e10 = (eArray = this.d)[n11 = eArray.length + -1]) ? 1 : 0)) != 0) {
            void var4_26;
            n15 = ((e)s10).C();
            a[] aArray = this.b(n15);
            n11 = aArray.length;
            while (n10 < n11) {
                l l13;
                a a11 = aArray[n10];
                Object object4 = this.a((e)s10, a11);
                boolean bl3 = object4 instanceof a;
                if (!bl3 && (n12 = (int)(object4.equals(l13 = a11.D()) ? 1 : 0)) == 0) {
                    ++n10;
                    Object object5 = object4;
                    continue;
                }
                return object4;
            }
            return var4_26;
        }
        Object[] objectArray = this.d;
        int n16 = Arrays.binarySearch(objectArray, s10);
        if (n16 == (n15 = -1)) {
            return this.e[0];
        }
        if (n16 < 0) {
            n16 = -n16 + -2;
        } else {
            e e11;
            e e12;
            e[] eArray2 = this.d;
            n12 = eArray2.length + -1;
            if (n16 < n12 && (n15 = (int)((e12 = eArray2[n16]).equals(e11 = eArray2[n10 = n16 + 1]) ? 1 : 0)) != 0) {
                n16 = n10;
            }
        }
        n15 = n16 & 1;
        if (n15 == 0) {
            int n17;
            e[] eArray3 = this.d;
            e e13 = eArray3[n16];
            n10 = n16 + 1;
            e e14 = eArray3[n10];
            lArray = this.e;
            l l14 = lArray[n16 /= 2];
            if ((n10 = ((l)(s10 = lArray[++n16])).C()) > (n17 = l14.C())) {
                a a12 = new a(e13, l14, (l)s10);
                return a12;
            }
            a a13 = new a(e14, l14, (l)s10);
            return a13;
        }
        l[] lArray3 = this.e;
        n16 = n16 / 2 + 1;
        return lArray3[n16];
    }

    public static c j(l l10) {
        c c10 = new c(l10);
        return c10;
    }

    private static l k(int n10) {
        return j$.time.l.O(n10 / 1000);
    }

    public l d(Instant object) {
        Object object2;
        long l10;
        Object object3 = this.g;
        if (object3 != null) {
            long l11 = object.toEpochMilli();
            return j$.time.r.c.k(((TimeZone)object3).getOffset(l11));
        }
        object3 = this.c;
        int n10 = ((Object)object3).length;
        if (n10 == 0) {
            return this.b[0];
        }
        long l12 = object.x();
        object = this.f;
        int n11 = ((b[])object).length;
        if (n11 > 0 && (n11 = (int)((l10 = l12 - (object2 = (object = (Object)this.c)[n10 = ((b[])object).length + -1])) == 0L ? 0 : (l10 < 0L ? -1 : 1))) > 0) {
            int n12;
            object = this.e;
            n10 = ((b[])object).length + -1;
            object = object[n10];
            n11 = this.c(l12, (l)object);
            object = this.b(n11);
            n10 = 0;
            object3 = null;
            for (int i10 = 0; i10 < (n12 = ((b[])object).length); ++i10) {
                object3 = object[i10];
                object2 = ((a)object3).H();
                long l13 = l12 - object2;
                n12 = (int)(l13 == 0L ? 0 : (l13 < 0L ? -1 : 1));
                if (n12 >= 0) continue;
                return ((a)object3).D();
            }
            return ((a)object3).C();
        }
        object = this.c;
        n11 = Arrays.binarySearch((long[])object, l12);
        if (n11 < 0) {
            n11 = -n11 + -2;
        }
        object3 = this.e;
        return object3[++n11];
    }

    public boolean equals(Object objectArray) {
        boolean bl2 = true;
        if (this == objectArray) {
            return bl2;
        }
        boolean bl3 = objectArray instanceof c;
        if (bl3) {
            boolean bl4;
            objectArray = (c)objectArray;
            Object object = this.g;
            Object object2 = objectArray.g;
            bl3 = Objects.equals(object, object2);
            if (!(bl3 && (bl3 = Arrays.equals((long[])(object = (Object)this.a), (long[])(object2 = (Object)objectArray.a))) && (bl3 = Arrays.equals(object = this.b, object2 = objectArray.b)) && (bl3 = Arrays.equals((long[])(object = (Object)this.c), (long[])(object2 = (Object)objectArray.c))) && (bl3 = Arrays.equals(object = this.e, object2 = objectArray.e)) && (bl4 = Arrays.equals(object = this.f, objectArray = objectArray.f)))) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public a f(e object) {
        boolean bl2 = (object = this.e((e)object)) instanceof a;
        object = bl2 ? (a)object : null;
        return object;
    }

    public List g(e object) {
        boolean bl2 = (object = this.e((e)object)) instanceof a;
        if (bl2) {
            return ((a)object).L();
        }
        return Collections.singletonList((l)object);
    }

    public boolean h(Instant s10) {
        Object object = this.g;
        if (object != null) {
            int n10 = object.getRawOffset();
            object = j$.time.r.c.k(n10);
        } else {
            object = this.c;
            int n11 = ((Object)object).length;
            if (n11 == 0) {
                object = this.b;
                Object var4_5 = null;
                object = object[0];
            } else {
                long[] lArray = this.a;
                long l10 = s10.x();
                n11 = Arrays.binarySearch(lArray, l10);
                if (n11 < 0) {
                    n11 = -n11 + -2;
                }
                l[] lArray2 = this.b;
                object = lArray2[++n11];
            }
        }
        s10 = this.d((Instant)s10);
        return object.equals(s10) ^ true;
    }

    public int hashCode() {
        int n10 = Objects.hashCode(this.g);
        int n11 = Arrays.hashCode(this.a);
        n10 ^= n11;
        n11 = Arrays.hashCode(this.b);
        n10 ^= n11;
        n11 = Arrays.hashCode(this.c);
        n10 ^= n11;
        n11 = Arrays.hashCode(this.e);
        n10 ^= n11;
        n11 = Arrays.hashCode(this.f);
        return n10 ^ n11;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public boolean i() {
        block16: {
            block17: {
                block15: {
                    block18: {
                        var1_1 = this;
                        var2_2 = this.g;
                        var3_3 = 0;
                        var4_4 = 1;
                        if (var2_2 == null) break block16;
                        var5_5 = var2_2.useDaylightTime();
                        if (var5_5 != 0 || (var5_5 = (var2_2 = this.g).getDSTSavings()) != 0) break block17;
                        var2_2 = Instant.c;
                        var2_2 = j$.time.l.f;
                        var6_7 /* !! */  = System.currentTimeMillis();
                        var2_2 = Instant.D(var6_7 /* !! */ );
                        var8_8 = this.g;
                        var9_9 = 0x7FFFFFFFFFFFFFFFL;
                        var11_10 = 1L;
                        var13_11 = null;
                        if (var8_8 == null) break block18;
                        var14_12 = var2_2.x();
                        var16_14 = var2_2.C();
                        if (var16_14 > 0 && (var16_14 = (int)(var14_12 == var9_9 ? 0 : (var14_12 < var9_9 ? -1 : 1))) < 0) {
                            var14_12 += var11_10;
                        }
                        var2_2 = var1_1.d((Instant)var2_2);
                        var5_5 = var1_1.c(var14_12, (l)var2_2);
                        var8_8 = var1_1.b(var5_5);
                        for (var17_16 = ((a[])var8_8).length - var4_4; var17_16 >= 0; var17_16 += -1) {
                            var18_18 = var8_8[var17_16];
                            var19_19 = var18_18.H();
                            cfr_temp_0 = var14_12 - var19_19;
                            var21_21 /* !! */  = (long)(cfr_temp_0 == 0L ? 0 : (cfr_temp_0 < 0L ? -1 : 1));
                            if (var21_21 /* !! */  <= 0) continue;
                            var13_11 = var8_8[var17_16];
                            break block15;
                        }
                        var16_14 = 1800;
                        if (var5_5 > var16_14) {
                            var2_2 = var1_1.b(var5_5 -= var4_4);
                            for (var17_16 = ((b[])var2_2).length - var4_4; var17_16 >= 0; var17_16 += -1) {
                                var18_18 = var2_2[var17_16];
                                var19_19 = var18_18.H();
                                cfr_temp_1 = var14_12 - var19_19;
                                var21_21 /* !! */  = (long)(cfr_temp_1 == 0L ? 0 : (cfr_temp_1 < 0L ? -1 : 1));
                                if (var21_21 /* !! */  <= 0) continue;
                                var13_11 = var2_2[var17_16];
                                break block15;
                            }
                            var9_9 = var14_12 - 31104000L;
                            j$.time.b.b();
                            var19_19 = System.currentTimeMillis();
                            var22_23 = 1000L;
                            var19_19 /= var22_23;
                            var24_24 = 31968000L;
                            var9_9 = Math.min(var9_9, var19_19 += var24_24);
                            var2_2 = var1_1.g;
                            var11_10 = (var14_12 - var11_10) * var22_23;
                            var5_5 = var2_2.getOffset(var11_10);
                            var8_8 = LocalDate.D(var16_14, var4_4, var4_4);
                            var11_10 = var8_8.s();
                            var19_19 = 86400L;
                            var11_10 *= var19_19;
                            while ((var16_14 = (int)(var11_10 == var9_9 ? 0 : (var11_10 < var9_9 ? -1 : 1))) <= 0) {
                                var8_8 = var1_1.g;
                                var19_19 = var9_9 * var22_23;
                                var16_14 = var8_8.getOffset(var19_19);
                                if (var5_5 != var16_14) {
                                    var2_2 = j$.time.r.c.k(var16_14);
                                    var5_5 = var1_1.c(var9_9, (l)var2_2);
                                    var16_14 = var5_5 + 1;
                                    var8_8 = var1_1.b(var16_14);
                                    for (var17_16 = ((Object)var8_8).length - var4_4; var17_16 >= 0; var17_16 += -1) {
                                        var18_18 = var8_8[var17_16];
                                        var26_25 = var18_18.H();
                                        cfr_temp_2 = var14_12 - var26_25;
                                        var21_21 /* !! */  = (long)(cfr_temp_2 == 0L ? 0 : (cfr_temp_2 < 0L ? -1 : 1));
                                        if (var21_21 /* !! */  <= 0) continue;
                                        var13_11 = var8_8[var17_16];
                                        break block15;
                                    }
                                    var2_2 = var1_1.b(var5_5);
                                    var16_14 = ((Object)var2_2).length - var4_4;
                                    var13_11 = var2_2[var16_14];
                                    break block15;
                                }
                                var19_19 = 7776000L;
                                var9_9 -= var19_19;
                            }
                        }
                        break block15;
                    }
                    var8_8 = this.c;
                    var16_15 = ((Object)var8_8).length;
                    if (var16_15 == 0) break block15;
                    var14_13 = var2_2.x();
                    var5_5 = var2_2.C();
                    if (var5_5 > 0 && (var5_5 = (int)(var14_13 == var9_9 ? 0 : (var14_13 < var9_9 ? -1 : 1))) < 0) {
                        var14_13 += var11_10;
                    }
                    var2_2 = var1_1.c;
                    var16_15 = ((Object)var2_2).length - var4_4;
                    var6_7 /* !! */  = (long)var2_2[var16_15];
                    var2_2 = var1_1.f;
                    var5_5 = ((b[])var2_2).length;
                    if (var5_5 <= 0 || (var5_5 = (int)(var14_13 == var6_7 /* !! */  ? 0 : (var14_13 < var6_7 /* !! */  ? -1 : 1))) <= 0) ** GOTO lbl-1000
                    var2_2 = var1_1.e;
                    var21_22 = ((b[])var2_2).length - var4_4;
                    var2_2 = var2_2[var21_22];
                    var21_22 = var1_1.c(var14_13, (l)var2_2);
                    var28_27 = var1_1.b(var21_22);
                    for (var29_28 = var28_27.length - var4_4; var29_28 >= 0; var29_28 += -1) {
                        var30_29 = var28_27[var29_28];
                        var19_20 = var30_29.H();
                        cfr_temp_3 = var14_13 - var19_20;
                        var31_30 /* !! */  = (long)(cfr_temp_3 == 0L ? 0 : (cfr_temp_3 < 0L ? -1 : 1));
                        if (var31_30 /* !! */  <= 0) continue;
                        var13_11 = var28_27[var29_28];
                        break block15;
                    }
                    var5_5 = var1_1.c(var6_7 /* !! */ , (l)var2_2);
                    if ((var21_22 += -1) > var5_5) {
                        var2_2 = var1_1.b(var21_22);
                        var16_15 = ((Object)var2_2).length - var4_4;
                        var13_11 = var2_2[var16_15];
                    } else lbl-1000:
                    // 2 sources

                    {
                        if ((var5_5 = Arrays.binarySearch((long[])(var2_2 = (Object)var1_1.c), var14_13)) < 0) {
                            var5_5 = -var5_5 - var4_4;
                        }
                        if (var5_5 > 0) {
                            var8_8 = var1_1.c;
                            var17_17 = var5_5 + -1;
                            var26_26 = var8_8[var17_17];
                            var8_8 = var1_1.e;
                            var32_31 = var8_8[var17_17];
                            var2_2 = var8_8[var5_5];
                            var13_11 = new a((long)var26_26, (l)var32_31, (l)var2_2);
                        }
                    }
                }
                if (var13_11 == null) {
                    var3_3 = var4_4;
                }
            }
            return (boolean)var3_3;
        }
        var2_2 = this.c;
        var5_6 = ((Object)var2_2).length;
        if (var5_6 == 0) {
            var3_3 = var4_4;
        }
        return (boolean)var3_3;
    }

    public String toString() {
        Serializable serializable = this.g;
        String string2 = "]";
        if (serializable != null) {
            serializable = j$.e.a.a.a.a.b("ZoneRules[timeZone=");
            String string3 = this.g.getID();
            ((StringBuilder)serializable).append(string3);
        } else {
            serializable = j$.e.a.a.a.a.b("ZoneRules[currentStandardOffset=");
            Object object = this.b;
            int n10 = ((l[])object).length + -1;
            object = object[n10];
            ((StringBuilder)serializable).append(object);
        }
        ((StringBuilder)serializable).append(string2);
        return ((StringBuilder)serializable).toString();
    }
}

