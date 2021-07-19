/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.net.TrafficStats
 *  android.os.Process
 *  android.os.SystemClock
 *  android.text.TextUtils
 */
package com.xiaomi.push;

import android.content.Context;
import android.net.TrafficStats;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.az;
import com.xiaomi.push.fh;
import com.xiaomi.push.fi;
import com.xiaomi.push.fs;
import com.xiaomi.push.fv;
import com.xiaomi.push.fy;
import com.xiaomi.push.he;
import com.xiaomi.push.hg;
import com.xiaomi.push.service.XMPushService;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class hd
implements fv {
    private int a;
    private long a;
    public fs a;
    public XMPushService a;
    private Exception a;
    private String a;
    private long b;
    private long c;
    private long d;
    private long e;
    private long f;

    public hd(XMPushService object) {
        long l10;
        this.a = l10 = 0L;
        this.b = l10;
        this.c = l10;
        this.d = l10;
        this.e = l10;
        this.f = l10;
        this.a = object;
        this.a = object = "";
        this.b();
        int n10 = Process.myUid();
        l10 = TrafficStats.getUidRxBytes((int)n10);
        this.f = l10;
        l10 = TrafficStats.getUidTxBytes((int)n10);
        try {
            this.e = l10;
        }
        catch (Exception exception) {
            StringBuilder stringBuilder = new StringBuilder();
            String string2 = "Failed to obtain traffic data during initialization: ";
            stringBuilder.append(string2);
            stringBuilder.append(exception);
            String string3 = stringBuilder.toString();
            com.xiaomi.channel.commonutils.logger.b.a(string3);
            this.f = l10 = (long)-1;
            this.e = l10;
        }
    }

    private void b() {
        long l10;
        this.b = l10 = 0L;
        this.d = l10;
        this.a = l10;
        this.c = l10;
        l10 = SystemClock.elapsedRealtime();
        XMPushService xMPushService = this.a;
        boolean bl2 = az.b((Context)xMPushService);
        if (bl2) {
            this.a = l10;
        }
        if (bl2 = (xMPushService = this.a).c()) {
            this.c = l10;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void c() {
        synchronized (this) {
            Object object = new StringBuilder();
            Object object2 = "stat connpt = ";
            ((StringBuilder)object).append((String)object2);
            object2 = this.a;
            ((StringBuilder)object).append((String)object2);
            object2 = " netDuration = ";
            ((StringBuilder)object).append((String)object2);
            long l10 = this.b;
            ((StringBuilder)object).append(l10);
            object2 = " ChannelDuration = ";
            ((StringBuilder)object).append((String)object2);
            l10 = this.d;
            ((StringBuilder)object).append(l10);
            object2 = " channelConnectedTime = ";
            ((StringBuilder)object).append((String)object2);
            l10 = this.c;
            ((StringBuilder)object).append(l10);
            object = ((StringBuilder)object).toString();
            com.xiaomi.channel.commonutils.logger.b.c((String)object);
            object = new fi();
            int n10 = 0;
            object2 = null;
            ((fi)object).a = 0;
            object2 = fh.h;
            n10 = ((fh)((Object)object2)).a();
            ((fi)object).a(n10);
            object2 = this.a;
            ((fi)object).a((String)object2);
            l10 = System.currentTimeMillis();
            long l11 = 1000L;
            n10 = (int)(l10 /= l11);
            ((fi)object).d(n10);
            l10 = this.b;
            n10 = (int)(l10 /= l11);
            ((fi)object).b(n10);
            l10 = this.d;
            n10 = (int)(l10 /= l11);
            ((fi)object).c(n10);
            object2 = he.a();
            ((he)object2).a((fi)object);
            this.b();
            return;
        }
    }

    public Exception a() {
        return this.a;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a() {
        synchronized (this) {
            long l10;
            long l11;
            Object object = this.a;
            if (object == null) {
                return;
            }
            object = az.a((Context)object);
            Object object2 = this.a;
            int n10 = az.b((Context)object2);
            long l12 = SystemClock.elapsedRealtime();
            long l13 = this.a;
            long l14 = 0L;
            long l15 = l13 - l14;
            Object object3 = l15 == 0L ? 0 : (l15 < 0L ? -1 : 1);
            if (object3 > 0) {
                l11 = this.b;
                l13 = l12 - l13;
                this.b = l11 += l13;
                this.a = l14;
            }
            if ((object3 = (l10 = (l13 = this.c) - l14) == 0L ? 0 : (l10 < 0L ? -1 : 1)) != false) {
                l11 = this.d;
                l13 = l12 - l13;
                this.d = l11 += l13;
                this.c = l14;
            }
            if (n10 != 0) {
                long l16;
                long l17;
                object2 = this.a;
                n10 = TextUtils.equals((CharSequence)object2, (CharSequence)object);
                if (n10 == 0 && (n10 = (l17 = (l13 = this.b) - (l11 = 30000L)) == 0L ? 0 : (l17 < 0L ? -1 : 1)) > 0 || (n10 = (l16 = (l13 = this.b) - (l11 = 5400000L)) == 0L ? 0 : (l16 < 0L ? -1 : 1)) > 0) {
                    this.c();
                }
                this.a = object;
                long l18 = this.a;
                long l19 = l18 - l14;
                Object object4 = l19 == 0L ? 0 : (l19 < 0L ? -1 : 1);
                if (object4 == false) {
                    this.a = l12;
                }
                if ((object4 = (Object)((XMPushService)(object = this.a)).c()) != false) {
                    this.c = l12;
                }
            }
            return;
        }
    }

    public void a(fs fs2) {
        long l10;
        this.a();
        this.c = l10 = SystemClock.elapsedRealtime();
        int n10 = fh.s.a();
        String string2 = fs2.a();
        int n11 = fs2.a();
        hg.a(0, n10, string2, n11);
    }

    public void a(fs object, int n10, Exception exception) {
        long l10;
        long l11;
        long l12;
        long l13;
        int n11;
        Object object2;
        int n12 = this.a;
        if (n12 == 0 && (object2 = this.a) == null) {
            this.a = n10;
            this.a = exception;
            object2 = ((fs)object).a();
            hg.b((String)object2, exception);
        }
        if (n10 == (n11 = 22) && (n10 = (int)((l13 = (l12 = this.c) - (l11 = 0L)) == 0L ? 0 : (l13 < 0L ? -1 : 1))) != 0) {
            long l14 = ((fs)object).a();
            l10 = this.c;
            long l15 = (l14 -= l10) - l11;
            n11 = (int)(l15 == 0L ? 0 : (l15 < 0L ? -1 : 1));
            if (n11 < 0) {
                l14 = l11;
            }
            n11 = fy.b() / 2;
            l10 = n11;
            l14 += l10;
            this.d = l10 = this.d + l14;
            this.c = l11;
        }
        this.a();
        int n13 = Process.myUid();
        l12 = -1;
        double d10 = 0.0 / 0.0;
        l11 = TrafficStats.getUidRxBytes((int)n13);
        try {
            long l16 = TrafficStats.getUidTxBytes((int)n13);
            l12 = l11;
            l11 = l16;
        }
        catch (Exception exception2) {
            object2 = new StringBuilder();
            String string2 = "Failed to obtain traffic data: ";
            ((StringBuilder)object2).append(string2);
            ((StringBuilder)object2).append(exception2);
            object = ((StringBuilder)object2).toString();
            com.xiaomi.channel.commonutils.logger.b.a((String)object);
            l11 = l12;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("Stats rx=");
        l10 = this.f;
        l10 = l12 - l10;
        ((StringBuilder)object).append(l10);
        ((StringBuilder)object).append(", tx=");
        l10 = this.e;
        l10 = l11 - l10;
        ((StringBuilder)object).append(l10);
        com.xiaomi.channel.commonutils.logger.b.c(((StringBuilder)object).toString());
        this.f = l12;
        this.e = l11;
    }

    public void a(fs object, Exception exception) {
        int n10 = az.b((Context)this.a);
        int n11 = fh.d.a();
        object = ((fs)object).a();
        hg.a(0, n11, 1, (String)object, n10);
        this.a();
    }

    public void b(fs object) {
        this.a = 0;
        this.a = null;
        this.a = object;
        this.a = object = az.a((Context)this.a);
        int n10 = fh.s.a();
        hg.a(0, n10);
    }
}

