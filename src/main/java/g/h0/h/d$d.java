/*
 * Decompiled with CFR 0.151.
 */
package g.h0.h;

import f.h2.t.f0;
import f.q1;
import g.h0.h.a;
import g.h0.h.b;
import g.h0.h.c;
import g.h0.h.d;
import java.util.logging.Level;

public final class d$d
implements Runnable {
    public final /* synthetic */ d a;

    public d$d(d d10) {
        this.a = d10;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void run() {
        while (true) {
            var1_1 = this.a;
            synchronized (var1_1) {
                var2_2 = this.a;
                var2_2 = var2_2.e();
                ** if (var2_2 != null) goto lbl8
            }
lbl7:
            // 1 sources

            return;
lbl8:
            // 1 sources

            var1_1 = var2_2.d();
            f0.m(var1_1);
            var3_3 = -1;
            var5_4 = d.j.a();
            var6_5 = Level.FINE;
            var7_8 = var5_4.isLoggable((Level)var6_5);
            if (var7_8) {
                var8_9 = var1_1.k().h();
                var3_3 = var8_9.nanoTime();
                var6_5 = "starting";
                b.a((a)var2_2, (c)var1_1, (String)var6_5);
            }
            var6_5 = this.a;
            d.b((d)var6_5, (a)var2_2);
            {
                catch (Throwable var6_6) {}
                {
                    var12_12 = this.a;
                    var12_12 = var12_12.h();
                    var12_12.execute(this);
                    throw var6_6;
                }
            }
            ** try [egrp 2[TRYBLOCK] [4 : 102->105)] { 
lbl-1000:
            // 1 sources

            {
                catch (Throwable var6_7) {
                    if (var7_8) {
                        var5_4 = var1_1.k().h();
                        var13_13 = var5_4.nanoTime() - var3_3;
                        var8_9 = new StringBuilder();
                        var8_9.append("failed a run in ");
                        var11_11 = b.b(var13_13);
                        var8_9.append(var11_11);
                        var8_9 = var8_9.toString();
                        b.a((a)var2_2, (c)var1_1, (String)var8_9);
                    }
                    throw var6_7;
                }
            }
lbl-1000:
            // 1 sources

            {
                var6_5 = q1.a;
                if (!var7_8) continue;
                var5_4 = var1_1.k().h();
                var9_10 = var5_4.nanoTime() - var3_3;
                var8_9 = new StringBuilder();
                var8_9.append("finished run in ");
                var11_11 = b.b(var9_10);
                var8_9.append(var11_11);
                var8_9 = var8_9.toString();
                b.a((a)var2_2, (c)var1_1, (String)var8_9);
                continue;
            }
            break;
        }
    }
}

