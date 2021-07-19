/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package d.v.d.g.g;

import android.content.Context;
import d.v.d.e;
import d.v.d.g.a;
import d.v.d.g.g.o;
import d.v.d.g.g.p.d;
import d.v.d.g.g.q.c;
import d.v.d.g.g.t.f;

public class n
implements a {
    private o a;
    private final e b;

    public n(Context context, e e10) {
        this.b = e10;
        int n10 = (Integer)e10.X0().get();
        this.e(n10, context);
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    private void e(int var1_1, Context var2_2) {
        var3_3 = new StringBuilder();
        var4_4 = "open camera huawei mode =";
        var3_3.append(var4_4);
        var3_3.append(var1_1);
        var3_3 = var3_3.toString();
        d.v.d.h.f.a((String)var3_3);
        var5_5 = 1;
        var6_6 = 2;
        if (var1_1 == var5_5) ** GOTO lbl-1000
        if (var1_1 == var6_6 || var1_1 == (var5_5 = 16) || var1_1 == (var5_5 = 17)) ** GOTO lbl-1000
        switch (var1_1) {
            default: {
                break;
            }
            case 7: {
                var3_3 = this.b;
                this.a = var7_7 = new d.v.d.g.g.s.c(var2_2 /* !! */ , (e)var3_3);
                break;
            }
            case 6: {
                var3_3 = this.b;
                this.a = var7_7 = new d(var2_2 /* !! */ , (e)var3_3);
                break;
            }
            case 5: {
                var3_3 = this.b;
                this.a = var7_7 = new c(var2_2 /* !! */ , (e)var3_3);
                break;
            }
            case 9: lbl-1000:
            // 2 sources

            {
                var3_3 = this.b;
                var7_7 = new f(var2_2 /* !! */ , (e)var3_3);
                this.a = var7_7;
                break;
            }
            case 8: lbl-1000:
            // 2 sources

            {
                var3_3 = this.b;
                var7_7 = new d.v.d.g.g.r.c(var2_2 /* !! */ , (e)var3_3);
                this.a = var7_7;
            }
        }
        var7_7 = this.b.Z0();
        var2_2 /* !! */  = Integer.valueOf(var6_6);
        var7_7.n((Integer)var2_2 /* !! */ );
    }

    public void a() {
        this.a.a();
    }

    public void b() {
        o o10 = this.a;
        if (o10 != null) {
            o10.b();
            o10 = null;
            this.a = null;
        }
    }

    public void c() {
        this.a.c();
    }

    public d.v.d.i.a.c d(int n10) {
        return (d.v.d.i.a.c)this.b.a1().get(n10);
    }
}

