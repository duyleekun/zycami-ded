/*
 * Decompiled with CFR 0.151.
 */
package g.h0.l;

import g.h0.h.a;
import g.h0.l.d;
import java.io.IOException;
import java.util.List;
import okhttp3.internal.http2.ErrorCode;

public final class d$g
extends a {
    public final /* synthetic */ String e;
    public final /* synthetic */ boolean f;
    public final /* synthetic */ d g;
    public final /* synthetic */ int h;
    public final /* synthetic */ List i;
    public final /* synthetic */ boolean j;

    public d$g(String string2, boolean bl2, String string3, boolean bl3, d d10, int n10, List list, boolean bl4) {
        this.e = string2;
        this.f = bl2;
        this.g = d10;
        this.h = n10;
        this.i = list;
        this.j = bl4;
        super(string3, bl3);
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public long f() {
        var1_1 = d.O(this.g);
        var5_5 = var1_1.c(var2_2 = this.h, (List)(var3_3 = this.i), var4_4 = this.j);
        if (!var5_5) ** GOTO lbl10
        try {
            var6_6 = this.g;
            var6_6 = var6_6.P0();
            var7_7 = this.h;
            var8_8 = ErrorCode.CANCEL;
            var6_6.p0(var7_7, var8_8);
lbl10:
            // 2 sources

            if (!var5_5) {
                var5_5 = this.j;
                if (var5_5 == false) return -1;
            }
            var1_1 = this.g;
            synchronized (var1_1) {
                var6_6 = this.g;
            }
        }
        catch (IOException v0) {
            return -1;
        }
        {
            var6_6 = d.q((d)var6_6);
            var7_7 = this.h;
            var3_3 = var7_7;
            var6_6.remove(var3_3);
            return -1;
        }
    }
}

