/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.IBinder$DeathRecipient
 *  android.os.Messenger
 */
package com.xiaomi.push.service;

import android.os.IBinder;
import android.os.Messenger;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.XMPushService$i;
import com.xiaomi.push.service.ap$b;
import com.xiaomi.push.service.ar;
import com.xiaomi.push.service.as;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class ap$b$c
implements IBinder.DeathRecipient {
    public final Messenger a;
    public final ap$b a;
    public final /* synthetic */ ap$b b;

    public ap$b$c(ap$b ap$b, ap$b ap$b2, Messenger messenger) {
        this.b = ap$b;
        this.a = ap$b2;
        this.a = messenger;
    }

    public void binderDied() {
        Object object = new StringBuilder();
        ((StringBuilder)object).append("peer died, chid = ");
        Object object2 = this.a.g;
        ((StringBuilder)object).append((String)object2);
        com.xiaomi.channel.commonutils.logger.b.b(((StringBuilder)object).toString());
        object = ap$b.a(this.b);
        object2 = new ar(this, 0);
        long l10 = 0L;
        ((XMPushService)object).a((XMPushService$i)object2, l10);
        object = this.a.g;
        object2 = "9";
        boolean bl2 = ((String)object2).equals(object);
        if (bl2 && (bl2 = ((String)(object2 = "com.xiaomi.xmsf")).equals(object = ap$b.a(this.b).getPackageName()))) {
            object = ap$b.a(this.b);
            object2 = new as(this, 0);
            long l11 = 60000L;
            ((XMPushService)object).a((XMPushService$i)object2, l11);
        }
    }
}

