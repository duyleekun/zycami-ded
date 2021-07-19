/*
 * Decompiled with CFR 0.151.
 */
package f.d2;

import f.h2.t.f0;
import java.lang.reflect.Method;
import kotlin.collections.ArraysKt___ArraysKt;

public final class k$a {
    public static final Method a;
    public static final Method b;
    public static final k$a c;

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    static {
        block6: {
            var0 = new k$a();
            k$a.c = var0;
            var0 = Throwable.class;
            var1_1 = var0.getMethods();
            var2_2 = "throwableMethods";
            f0.o(var1_1, (String)var2_2);
            var3_3 = var1_1.length;
            var4_4 = 0;
            var5_5 = 0;
            var6_6 = null;
            while (true) {
                var7_7 = "it";
                var8_8 = null;
                if (var5_5 >= var3_3) break;
                var9_9 = var1_1[var5_5];
                f0.o(var9_9, var7_7);
                var10_10 /* !! */  = var9_9.getName();
                var11_11 = "addSuppressed";
                var12_12 = f0.g(var10_10 /* !! */ , var11_11);
                if (!var12_12) ** GOTO lbl-1000
                var10_10 /* !! */  = var9_9.getParameterTypes();
                var11_11 = "it.parameterTypes";
                f0.o(var10_10 /* !! */ , var11_11);
                var10_10 /* !! */  = (Class)ArraysKt___ArraysKt.mt(var10_10 /* !! */ );
                var12_12 = f0.g(var10_10 /* !! */ , var0);
                if (var12_12) {
                    var12_12 = true;
                } else lbl-1000:
                // 2 sources

                {
                    var12_12 = false;
                    var10_10 /* !! */  = null;
                }
                if (!var12_12) {
                    ++var5_5;
                    continue;
                }
                break block6;
                break;
            }
            var9_9 = null;
        }
        k$a.a = var9_9;
        var13_13 = var1_1.length;
        while (var4_4 < var13_13) {
            var2_2 = var1_1[var4_4];
            f0.o(var2_2, var7_7);
            var6_6 = var2_2.getName();
            var9_9 = "getSuppressed";
            var5_5 = (int)f0.g(var6_6, var9_9);
            if (var5_5 != 0) {
                var8_8 = var2_2;
                break;
            }
            ++var4_4;
        }
        k$a.b = var8_8;
    }

    private k$a() {
    }
}

