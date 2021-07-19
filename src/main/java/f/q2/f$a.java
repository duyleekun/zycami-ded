/*
 * Decompiled with CFR 0.151.
 */
package f.q2;

import f.h2.t.x0.a;
import f.l2.k;
import f.l2.q;
import f.q2.f;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import kotlin.Pair;
import kotlin.text.StringsKt__StringsKt;

public final class f$a
implements Iterator,
a {
    private int a = -1;
    private int b;
    private int c;
    private k d;
    private int e;
    public final /* synthetic */ f f;

    public f$a(f f10) {
        this.f = f10;
        int n10 = f.q2.f.f(f10);
        int n11 = f.q2.f.d(f10).length();
        this.b = n11 = q.B(n10, 0, n11);
        this.c = n11;
    }

    /*
     * Unable to fully structure code
     */
    private final void b() {
        block6: {
            block7: {
                block5: {
                    var1_1 = this.c;
                    var2_2 = 0;
                    var3_3 = null;
                    if (var1_1 >= 0) break block5;
                    this.a = 0;
                    var1_1 = 0;
                    var4_4 = null;
                    this.d = null;
                    break block6;
                }
                var4_5 = this.f;
                var1_1 = f.q2.f.e((f)var4_5);
                var5_6 = -1;
                var6_7 = 1;
                if (var1_1 <= 0) break block7;
                this.e = var1_1 = this.e + var6_7;
                var7_8 = this.f;
                var8_9 = f.q2.f.e((f)var7_8);
                if (var1_1 >= var8_9) ** GOTO lbl-1000
            }
            if ((var1_1 = this.c) > (var8_9 = (var7_8 = f.q2.f.d(this.f)).length())) lbl-1000:
            // 2 sources

            {
                var1_1 = this.b;
                var7_8 = f.q2.f.d(this.f);
                var8_9 = StringsKt__StringsKt.a3((CharSequence)var7_8);
                this.d = var3_3 = new k(var1_1, var8_9);
                this.c = var5_6;
            } else {
                var4_5 = f.q2.f.c(this.f);
                var7_8 = f.q2.f.d(this.f);
                if ((var4_5 = (Pair)var4_5.invoke(var7_8, var10_11 = Integer.valueOf(var9_10 = this.c))) == null) {
                    var1_1 = this.b;
                    var7_8 = f.q2.f.d(this.f);
                    var8_9 = StringsKt__StringsKt.a3((CharSequence)var7_8);
                    this.d = var3_3 = new k(var1_1, var8_9);
                    this.c = var5_6;
                } else {
                    var11_12 = (Number)var4_5.component1();
                    var5_6 = var11_12.intValue();
                    var4_5 = (Number)var4_5.component2();
                    var1_1 = var4_5.intValue();
                    var8_9 = this.b;
                    this.d = var7_8 = q.n1(var8_9, var5_6);
                    this.b = var5_6 += var1_1;
                    if (var1_1 == 0) {
                        var2_2 = var6_7;
                    }
                    this.c = var5_6 += var2_2;
                }
            }
            this.a = var6_7;
        }
    }

    public final int c() {
        return this.e;
    }

    public final int e() {
        return this.b;
    }

    public final k f() {
        return this.d;
    }

    public final int g() {
        return this.c;
    }

    public final int h() {
        return this.a;
    }

    public boolean hasNext() {
        int n10 = this.a;
        int n11 = -1;
        if (n10 == n11) {
            this.b();
        }
        if ((n10 = this.a) != (n11 = 1)) {
            n11 = 0;
        }
        return n11 != 0;
    }

    public k i() {
        int n10 = this.a;
        int n11 = -1;
        if (n10 == n11) {
            this.b();
        }
        if ((n10 = this.a) != 0) {
            k k10 = this.d;
            Objects.requireNonNull(k10, "null cannot be cast to non-null type kotlin.ranges.IntRange");
            this.d = null;
            this.a = n11;
            return k10;
        }
        NoSuchElementException noSuchElementException = new NoSuchElementException();
        throw noSuchElementException;
    }

    public final void j(int n10) {
        this.e = n10;
    }

    public final void k(int n10) {
        this.b = n10;
    }

    public final void l(k k10) {
        this.d = k10;
    }

    public final void m(int n10) {
        this.c = n10;
    }

    public final void n(int n10) {
        this.a = n10;
    }

    public void remove() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw unsupportedOperationException;
    }
}

