/*
 * Decompiled with CFR 0.151.
 */
package j$.time.format;

import j$.e.a.a.a.a;
import j$.time.Instant;
import j$.time.c;
import j$.time.format.DateTimeFormatter;
import j$.time.format.u;
import j$.time.format.z;
import j$.time.k;
import j$.time.l;
import j$.time.p.j;
import j$.time.q.b_0;
import j$.time.q.h;
import j$.time.q.s;
import j$.time.q.w;
import j$.time.r.d;
import java.util.Locale;
import java.util.Objects;

final class v {
    private s a;
    private DateTimeFormatter b;
    private int c;

    /*
     * Unable to fully structure code
     */
    v(s var1_1, DateTimeFormatter var2_2) {
        block20: {
            super();
            var3_3 = var2_2.b();
            var4_4 = var2_2.e();
            if (var3_3 == null && var4_4 == null) break block20;
            var5_5 = j$.time.q.v.a;
            var6_6 = b_0.a;
            var6_6 = (j)var1_1.d((w)var6_6);
            var7_7 = j$.time.q.d.a;
            var7_7 = (k)var1_1.d((w)var7_7);
            var8_8 = Objects.equals(var3_3, var6_6);
            var9_9 = null;
            if (var8_8) {
                var3_3 = null;
            }
            if (var8_8 = Objects.equals(var4_4, var7_7)) {
                var10_10 = false;
                var4_4 = null;
            }
            if (var3_3 == null && var4_4 == null) break block20;
            var11_11 = var3_3 != null ? var3_3 : var6_6;
            if (var4_4 == null) ** GOTO lbl61
            var12_12 = h.G;
            var13_13 = var1_1.g((j$.time.q.u)var12_12);
            if (var13_13 != 0) {
                if (var11_11 == null) {
                    var11_11 = j$.time.p.k.a;
                }
                var1_1 = Instant.o((s)var1_1);
                var1_1 = var11_11.t((Instant)var1_1, (k)var4_4);
            } else {
                block19: {
                    block18: {
                        try {
                            var12_12 = var4_4.m();
                        }
                        catch (d v0) {}
                        var14_14 = var12_12.i();
                        if (var14_14 == 0) break block18;
                        var15_15 = Instant.c;
                        var12_12 = var12_12.d((Instant)var15_15);
                        break block19;
                    }
                    var12_12 = var4_4;
                }
                var13_13 = var12_12 instanceof l;
                if (var13_13 != 0 && (var14_14 = var1_1.g((j$.time.q.u)(var12_12 = h.H))) != 0) {
                    var13_13 = var1_1.k((j$.time.q.u)var12_12);
                    var15_15 = ((k)var4_4).m();
                    var16_16 = Instant.c;
                    var14_14 = (var15_15 = var15_15.d(var16_16)).C();
                    if (var13_13 != var14_14) {
                        var3_3 = new StringBuilder();
                        var3_3.append("Unable to apply override zone '");
                        var3_3.append(var4_4);
                        var3_3.append("' because the temporal object being formatted has a different offset but does not represent an instant: ");
                        var3_3.append(var1_1);
                        var1_1 = var3_3.toString();
                        var2_2 = new c((String)var1_1);
                        throw var2_2;
                    }
                }
lbl61:
                // 5 sources

                if (var4_4 != null) {
                    var7_7 = var4_4;
                }
                if (var3_3 != null) {
                    var4_4 = h.y;
                    var10_10 = var1_1.g((j$.time.q.u)var4_4);
                    if (var10_10) {
                        var9_9 = var11_11.r((s)var1_1);
                    } else {
                        var4_4 = j$.time.p.k.a;
                        if (var3_3 != var4_4 || var6_6 != null) {
                            var4_4 = h.values();
                            var5_5 = 30;
                            var12_12 = null;
                            for (var13_13 = 0; var13_13 < var5_5; ++var13_13) {
                                var15_15 = var4_4[var13_13];
                                var17_17 = var15_15.m();
                                if (!var17_17 || (var14_14 = var1_1.g((j$.time.q.u)var15_15)) == 0) continue;
                                super();
                                var4_4.append("Unable to apply override chronology '");
                                var4_4.append(var3_3);
                                var4_4.append("' because the temporal object being formatted contains date fields but does not represent a whole date: ");
                                var4_4.append(var1_1);
                                var1_1 = var4_4.toString();
                                var2_2 = new c((String)var1_1);
                                throw var2_2;
                            }
                        }
                    }
                }
                var1_1 = var3_3 = new u(var9_9, (s)var1_1, (j)var11_11, (k)var7_7);
            }
        }
        this.a = var1_1;
        this.b = var2_2;
    }

    void a() {
        int n10;
        this.c = n10 = this.c + -1;
    }

    z b() {
        return this.b.c();
    }

    Locale c() {
        return this.b.d();
    }

    s d() {
        return this.a;
    }

    Long e(j$.time.q.u u10) {
        s s10;
        try {
            s10 = this.a;
        }
        catch (c c10) {
            int n10 = this.c;
            if (n10 > 0) {
                return null;
            }
            throw c10;
        }
        long l10 = s10.h(u10);
        return l10;
    }

    Object f(w object) {
        int n10;
        Object object2 = this.a;
        if ((object = object2.d((w)object)) == null && (n10 = this.c) == 0) {
            object2 = j$.e.a.a.a.a.b("Unable to extract value: ");
            Class<?> clazz = this.a.getClass();
            ((StringBuilder)object2).append(clazz);
            object2 = ((StringBuilder)object2).toString();
            object = new c((String)object2);
            throw object;
        }
        return object;
    }

    void g() {
        int n10;
        this.c = n10 = this.c + 1;
    }

    public String toString() {
        return this.a.toString();
    }
}

