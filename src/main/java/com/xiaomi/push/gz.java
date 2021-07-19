/*
 * Decompiled with CFR 0.151.
 */
package com.xiaomi.push;

import com.xiaomi.push.fh;
import com.xiaomi.push.fs;
import com.xiaomi.push.ha;
import com.xiaomi.push.hb;
import com.xiaomi.push.hc;
import com.xiaomi.push.he;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.XMPushService$i;
import com.xiaomi.push.service.ap$b;
import com.xiaomi.push.service.ap$b$a;
import com.xiaomi.push.service.ap$c;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class gz
implements ap$b$a {
    private int a;
    private fs a;
    private XMPushService a;
    private ap$b a;
    private ap$c a;
    private boolean a = false;

    public gz(XMPushService object, ap$b ap$b) {
        this.a = object;
        object = ap$c.b;
        this.a = object;
        this.a = ap$b;
    }

    public static /* synthetic */ void a(gz gz2) {
        gz2.c();
    }

    private void b() {
        this.a.b(this);
    }

    /*
     * Unable to fully structure code
     */
    private void c() {
        block20: {
            block21: {
                block19: {
                    this.b();
                    var1_1 = this.a;
                    if (var1_1 == 0) {
                        return;
                    }
                    var1_1 = this.a;
                    var2_2 = 11;
                    if (var1_1 == var2_2) {
                        return;
                    }
                    var3_3 = he.a().a();
                    var4_4 = hb.a;
                    var5_5 = this.a;
                    var6_6 = var5_5.ordinal();
                    var2_2 = var4_4[var6_6];
                    if (var2_2 == (var6_6 = 1)) break block19;
                    var7_7 = 3;
                    if (var2_2 == var7_7) {
                        var4_4 = (Object)fh.E;
lbl18:
                        // 3 sources

                        while (true) {
                            var2_2 = var4_4.a();
                            var3_3.a = var2_2;
                            ** GOTO lbl54
                            break;
                        }
                    }
                    break block20;
                }
                var2_2 = this.a;
                var7_8 = 17;
                if (var2_2 != var7_8) break block21;
                var4_4 = fh.I;
                ** GOTO lbl18
            }
            var7_8 = 21;
            if (var2_2 == var7_8) {
                var4_4 = (Object)fh.P;
                ** continue;
            }
            var4_4 = he.a();
            var4_4 = var4_4.a();
            var4_4 = hc.c((Exception)var4_4);
            var8_9 = var4_4.a;
            var7_8 = var8_9.a();
            var3_3.a = var7_8;
            var4_4 = var4_4.a;
            try {
                var3_3.c((String)var4_4);
            }
            catch (NullPointerException v0) {
                var1_1 = 0;
                var3_3 = null;
            }
        }
        if (var3_3 == null) ** GOTO lbl77
        var4_4 = this.a.a();
        var3_3.b((String)var4_4);
        var4_4 = this.a.b;
        var3_3.d((String)var4_4);
        var3_3.b = var6_6;
        var4_4 = this.a;
        var4_4 = var4_4.g;
        var2_2 = (byte)Integer.parseInt((String)var4_4);
        try {
            var3_3.a((byte)var2_2);
        }
        catch (NumberFormatException v1) {
            ** continue;
        }
lbl74:
        // 2 sources

        while (true) {
            var4_4 = he.a();
            var4_4.a(var3_3);
lbl77:
            // 2 sources

            return;
        }
    }

    public void a() {
        fs fs2;
        this.a.a(this);
        this.a = fs2 = this.a.a();
    }

    public void a(ap$c object, ap$c object2, int n10) {
        ap$c ap$c;
        boolean bl2 = this.a;
        if (!bl2 && object == (ap$c = ap$c.b)) {
            boolean bl3;
            this.a = object2;
            this.a = n10;
            this.a = bl3 = true;
        }
        object = this.a;
        object2 = new ha(this, 4);
        ((XMPushService)object).a((XMPushService$i)object2);
    }
}

