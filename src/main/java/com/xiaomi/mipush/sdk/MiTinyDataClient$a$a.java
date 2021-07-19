/*
 * Decompiled with CFR 0.151.
 */
package com.xiaomi.mipush.sdk;

import com.xiaomi.mipush.sdk.MiTinyDataClient$a;
import com.xiaomi.mipush.sdk.ad;
import com.xiaomi.mipush.sdk.ae;
import com.xiaomi.mipush.sdk.aq;
import com.xiaomi.mipush.sdk.b;
import com.xiaomi.push.hm;
import com.xiaomi.push.hq;
import com.xiaomi.push.il;
import com.xiaomi.push.ix;
import com.xiaomi.push.service.bi;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class MiTinyDataClient$a$a {
    public final /* synthetic */ MiTinyDataClient$a a;
    private final Runnable a;
    public final ArrayList a;
    private ScheduledFuture a;
    private ScheduledThreadPoolExecutor a;

    public MiTinyDataClient$a$a(MiTinyDataClient$a object) {
        this.a = object;
        this.a = object = new ScheduledThreadPoolExecutor(1);
        object = new ArrayList();
        this.a = object;
        this.a = object = new ae(this);
    }

    public static /* synthetic */ ScheduledFuture a(MiTinyDataClient$a$a miTinyDataClient$a$a) {
        return miTinyDataClient$a$a.a;
    }

    public static /* synthetic */ ScheduledFuture a(MiTinyDataClient$a$a miTinyDataClient$a$a, ScheduledFuture scheduledFuture) {
        miTinyDataClient$a$a.a = scheduledFuture;
        return scheduledFuture;
    }

    private void a() {
        ScheduledFuture<?> scheduledFuture = this.a;
        if (scheduledFuture == null) {
            ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = this.a;
            Runnable runnable = this.a;
            long l10 = 1000L;
            long l11 = 1000L;
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            this.a = scheduledFuture = scheduledThreadPoolExecutor.scheduleAtFixedRate(runnable, l10, l11, timeUnit);
        }
    }

    public static /* synthetic */ void a(MiTinyDataClient$a$a miTinyDataClient$a$a) {
        miTinyDataClient$a$a.a();
    }

    private void b() {
        boolean bl2;
        hq hq2 = (hq)this.a.remove(0);
        Object object = MiTinyDataClient$a.a(this.a).getPackageName();
        Object object2 = b.a(MiTinyDataClient$a.a(this.a)).a();
        boolean bl3 = true;
        Object object3 = new hq[bl3];
        object3[0] = hq2;
        Object object4 = Arrays.asList(object3);
        int n10 = 30720;
        object4 = bi.a(object4, (String)object, (String)object2, n10).iterator();
        while (bl2 = object4.hasNext()) {
            object = (il)object4.next();
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("MiTinyDataClient Send item by PushServiceClient.sendMessage(XmActionNotification).");
            object3 = hq2.d();
            ((StringBuilder)object2).append((String)object3);
            com.xiaomi.channel.commonutils.logger.b.c(((StringBuilder)object2).toString());
            object2 = aq.a(MiTinyDataClient$a.a(this.a));
            object3 = hm.i;
            ((aq)object2).a((ix)object, (hm)((Object)object3), bl3, null);
        }
    }

    public static /* synthetic */ void b(MiTinyDataClient$a$a miTinyDataClient$a$a) {
        miTinyDataClient$a$a.b();
    }

    public void a(hq hq2) {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = this.a;
        ad ad2 = new ad(this, hq2);
        scheduledThreadPoolExecutor.execute(ad2);
    }
}

