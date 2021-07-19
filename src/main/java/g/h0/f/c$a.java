/*
 * Decompiled with CFR 0.151.
 */
package g.h0.f;

import f.h2.t.f0;
import f.h2.t.u;
import g.a0;
import g.c0;

public final class c$a {
    private c$a() {
    }

    public /* synthetic */ c$a(u u10) {
        this();
    }

    /*
     * Unable to fully structure code
     */
    public final boolean a(c0 var1_1, a0 var2_2) {
        block8: {
            f0.p(var1_1, "response");
            var3_3 = "request";
            f0.p(var2_2, (String)var3_3);
            var4_4 = var1_1.v0();
            var5_5 = 200;
            var6_6 = false;
            if (var4_4 == var5_5 || var4_4 == (var5_5 = 410) || var4_4 == (var5_5 = 414) || var4_4 == (var5_5 = 501) || var4_4 == (var5_5 = 203) || var4_4 == (var5_5 = 204)) break block8;
            var5_5 = 307;
            if (var4_4 == var5_5) ** GOTO lbl-1000
            var5_5 = 308;
            if (var4_4 == var5_5 || var4_4 == (var5_5 = 404) || var4_4 == (var5_5 = 405)) break block8;
            switch (var4_4) {
                default: {
                    return false;
                }
                case 302: lbl-1000:
                // 2 sources

                {
                    if ((var3_3 = c0.A0((c0)var1_1, var7_7 = "Expires", null, var4_4 = 2, null)) != null || (var4_4 = (var3_3 = var1_1.s0()).n()) != (var5_5 = -1) || (var4_4 = (int)(var3_3 = var1_1.s0()).m()) != 0 || (var4_4 = (int)(var3_3 = var1_1.s0()).l()) != 0) break;
                    return false;
                }
                case 300: 
                case 301: 
            }
        }
        if (!(var8_8 = (var1_1 = var1_1.s0()).s()) && !(var8_8 = (var1_1 = var2_2.g()).s())) {
            var6_6 = true;
        }
        return var6_6;
    }
}

