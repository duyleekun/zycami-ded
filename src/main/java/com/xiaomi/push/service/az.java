/*
 * Decompiled with CFR 0.151.
 */
package com.xiaomi.push.service;

import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.he;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.XMPushService$d;
import com.xiaomi.push.service.XMPushService$i;
import com.xiaomi.push.service.ad;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class az {
    private static int d = 300000;
    private int a;
    private long a;
    private XMPushService a;
    private int b = 0;
    private int c = 0;

    public az(XMPushService xMPushService) {
        this.a = xMPushService;
        this.a = 500;
        this.a = 0L;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private int a() {
        int n10 = this.b;
        int n11 = 8;
        if (n10 > n11) {
            return 300000;
        }
        double d10 = 1.0;
        double d11 = Math.random();
        double d12 = 2.0;
        d11 = d11 * d12 + d10;
        n10 = this.b;
        n11 = 4;
        if (n10 > n11) {
            d10 = 60000.0;
            return (int)(d11 * d10);
        }
        int n12 = 1;
        if (n10 > n12) {
            d10 = 10000.0;
            return (int)(d11 * d10);
        }
        long l10 = this.a;
        long l11 = 0L;
        n10 = (int)(l10 == l11 ? 0 : (l10 < l11 ? -1 : 1));
        int n13 = 0;
        if (n10 == 0) {
            return 0;
        }
        l11 = System.currentTimeMillis();
        long l12 = this.a;
        long l13 = (l11 -= l12) - (l12 = 310000L);
        n10 = (int)(l13 == 0L ? 0 : (l13 < 0L ? -1 : 1));
        if (n10 < 0) {
            int n14;
            n10 = this.a;
            n13 = d;
            if (n10 >= n13) {
                return n10;
            }
            this.c = n14 = this.c + n12;
            if (n14 >= n11) {
                return n13;
            }
            double d13 = n10;
            double d14 = 1.5;
            this.a = n11 = (int)(d13 *= d14);
            return n10;
        }
        this.a = 1000;
        this.c = 0;
        return 0;
    }

    public void a() {
        long l10;
        this.a = l10 = System.currentTimeMillis();
        this.a.a(1);
        this.b = 0;
    }

    public void a(boolean n10) {
        Object object = this.a;
        int n11 = (int)(((XMPushService)object).a() ? 1 : 0);
        if (n11 != 0) {
            n11 = 1;
            if (n10 != 0) {
                XMPushService xMPushService = this.a;
                boolean bl2 = xMPushService.a(n11);
                if (!bl2) {
                    int n12;
                    this.b = n12 = this.b + n11;
                }
                this.a.a(n11);
                xMPushService = this.a;
                xMPushService.getClass();
                object = new XMPushService$d(xMPushService);
                xMPushService.a((XMPushService$i)object);
            } else {
                int n13;
                boolean bl3;
                int n14;
                Object object2 = this.a;
                boolean bl4 = ((XMPushService)object2).a(n11);
                if (bl4) {
                    return;
                }
                int n15 = this.a();
                this.b = n14 = this.b + n11;
                object = new StringBuilder();
                ((StringBuilder)object).append("schedule reconnect in ");
                ((StringBuilder)object).append(n15);
                ((StringBuilder)object).append("ms");
                com.xiaomi.channel.commonutils.logger.b.a(((StringBuilder)object).toString());
                object = this.a;
                object.getClass();
                XMPushService$d xMPushService$d = new XMPushService$d((XMPushService)object);
                long l10 = n15;
                ((XMPushService)object).a(xMPushService$d, l10);
                int n16 = this.b;
                n11 = 2;
                if (n16 == n11 && (bl3 = ((he)(object2 = he.a())).a())) {
                    ad.b();
                }
                if ((n13 = this.b) == (n11 = 3)) {
                    ad.a();
                }
            }
        } else {
            String string2 = "should not reconnect as no client or network.";
            com.xiaomi.channel.commonutils.logger.b.c(string2);
        }
    }
}

