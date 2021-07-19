/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.xiaomi.push.service;

import android.content.Context;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.cv;
import com.xiaomi.push.cy;
import com.xiaomi.push.cz;
import com.xiaomi.push.cz$a;
import com.xiaomi.push.cz$b;
import com.xiaomi.push.ej$a;
import com.xiaomi.push.ek$b;
import com.xiaomi.push.fs;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.au$a;
import com.xiaomi.push.service.au$b;
import com.xiaomi.push.service.be;
import com.xiaomi.push.service.be$a;
import java.util.ArrayList;
import java.util.Iterator;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class au
extends be$a
implements cz$a {
    private long a;
    private XMPushService a;

    public au(XMPushService xMPushService) {
        this.a = xMPushService;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void a(XMPushService xMPushService) {
        au au2 = new au(xMPushService);
        be.a().a(au2);
        Class<cz> clazz = cz.class;
        synchronized (clazz) {
            cz.a(au2);
            au$a au$a = new au$a();
            String string2 = "0";
            String string3 = "push";
            String string4 = "2.2";
            cz.a((Context)xMPushService, null, au$a, string2, string3, string4);
            return;
        }
    }

    public cz a(Context context, cy cy2, cz$b cz$b, String string2) {
        au$b au$b = new au$b(context, cy2, cz$b, string2);
        return au$b;
    }

    public void a(ej$a ej$a) {
    }

    public void a(ek$b object) {
        Object object2 = ((ek$b)object).b();
        if (object2 != 0 && (object2 = ((ek$b)object).a()) != 0) {
            long l10 = System.currentTimeMillis();
            long l11 = this.a;
            long l12 = (l10 -= l11) - (l11 = 3600000L);
            object2 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
            if (object2 > 0) {
                Object object3 = new StringBuilder();
                String string2 = "fetch bucket :";
                ((StringBuilder)object3).append(string2);
                boolean bl2 = ((ek$b)object).a();
                ((StringBuilder)object3).append(bl2);
                b.a(((StringBuilder)object3).toString());
                this.a = l10 = System.currentTimeMillis();
                object = cz.a();
                ((cz)object).a();
                ((cz)object).b();
                object3 = this.a.a();
                if (object3 != null && (object = ((cz)object).b(string2 = ((fs)object3).a().c())) != null) {
                    boolean bl3;
                    object = ((cv)object).a();
                    boolean bl4 = true;
                    Iterator iterator2 = ((ArrayList)object).iterator();
                    while (bl3 = iterator2.hasNext()) {
                        String string3;
                        String string4 = (String)iterator2.next();
                        bl3 = string4.equals(string3 = ((fs)object3).a());
                        if (!bl3) continue;
                        bl4 = false;
                        string2 = null;
                        break;
                    }
                    if (bl4 && !(bl2 = ((ArrayList)object).isEmpty())) {
                        b.a("bucket changed, force reconnect");
                        object = this.a;
                        object2 = 0;
                        object3 = null;
                        ((XMPushService)object).a(0, null);
                        object = this.a;
                        ((XMPushService)object).a(false);
                    }
                }
            }
        }
    }
}

