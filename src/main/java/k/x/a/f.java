/*
 * Decompiled with CFR 0.151.
 */
package k.x.a;

import e.a.h0;
import e.a.z;
import io.reactivex.BackpressureStrategy;
import java.lang.reflect.Type;
import k.d;
import k.e;
import k.x.a.a;
import k.x.a.b;
import k.x.a.c;

public final class f
implements e {
    private final Type a;
    private final h0 b;
    private final boolean c;
    private final boolean d;
    private final boolean e;
    private final boolean f;
    private final boolean g;
    private final boolean h;
    private final boolean i;

    public f(Type type, h0 h02, boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6, boolean bl7, boolean bl8) {
        this.a = type;
        this.b = h02;
        this.c = bl2;
        this.d = bl3;
        this.e = bl4;
        this.f = bl5;
        this.g = bl6;
        this.h = bl7;
        this.i = bl8;
    }

    public Type a() {
        return this.a;
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     */
    public Object b(d object) {
        h0 h02;
        boolean bl2;
        z z10;
        block10: {
            void var1_3;
            block9: {
                block8: {
                    boolean bl3 = this.c;
                    z10 = bl3 ? new b((d)object) : new c((d)object);
                    bl2 = this.d;
                    if (!bl2) break block8;
                    k.x.a.e e10 = new k.x.a.e(z10);
                    break block9;
                }
                bl2 = this.e;
                if (!bl2) break block10;
                a a10 = new a(z10);
            }
            z10 = var1_3;
        }
        if ((h02 = this.b) != null) {
            z10 = z10.L5(h02);
        }
        if (bl2 = this.f) {
            BackpressureStrategy backpressureStrategy = BackpressureStrategy.LATEST;
            return z10.V6(backpressureStrategy);
        }
        bl2 = this.g;
        if (bl2) {
            return z10.s5();
        }
        bl2 = this.h;
        if (bl2) {
            return z10.r5();
        }
        bl2 = this.i;
        if (bl2) {
            return z10.k3();
        }
        return e.a.a1.a.R(z10);
    }
}

