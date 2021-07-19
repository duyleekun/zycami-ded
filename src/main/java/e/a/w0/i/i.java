/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.i;

import e.a.v0.c;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public final class i
implements c {
    public final Comparator a;

    public i(Comparator comparator) {
        this.a = comparator;
    }

    /*
     * Unable to fully structure code
     */
    public List a(List var1_1, List var2_2) {
        block11: {
            var3_3 = var1_1.size();
            var4_4 = var2_2.size();
            if ((var3_3 += var4_4) == 0) {
                var1_1 = new ArrayList();
                return var1_1;
            }
            var5_5 = new ArrayList<Object>(var3_3);
            var1_1 = var1_1.iterator();
            var2_2 = var2_2.iterator();
            var3_3 = (int)var1_1.hasNext();
            if (var3_3 != 0) {
                var6_6 = var1_1.next();
            } else {
                var3_3 = 0;
                var6_6 = null;
            }
            var7_7 = var2_2.hasNext();
            if (!var7_7) break block11;
            var8_8 = var2_2.next();
            ** GOTO lbl23
        }
        block0: while (true) {
            var7_7 = false;
            var8_8 = null;
            while (var6_6 != null && var8_8 != null) {
                var9_9 = this.a;
                var10_10 = var9_9.compare(var6_6, var8_8);
                if (var10_10 < 0) {
                    var5_5.add(var6_6);
                    var3_3 = (int)var1_1.hasNext();
                    if (var3_3 != 0) {
                        var6_6 = var1_1.next();
                        continue;
                    }
                    var3_3 = 0;
                    var6_6 = null;
                    continue;
                }
                var5_5.add(var8_8);
                var7_7 = var2_2.hasNext();
                if (!var7_7) continue block0;
                var8_8 = var2_2.next();
            }
            break;
        }
        if (var6_6 != null) {
            var5_5.add(var6_6);
            while (var11_11 = var1_1.hasNext()) {
                var2_2 = var1_1.next();
                var5_5.add(var2_2);
            }
        } else {
            var5_5.add(var8_8);
            while (var12_12 = var2_2.hasNext()) {
                var1_1 = var2_2.next();
                var5_5.add(var1_1);
            }
        }
        return var5_5;
    }
}

