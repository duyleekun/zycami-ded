/*
 * Decompiled with CFR 0.151.
 */
package com.xiaomi.push.service;

import com.xiaomi.push.ai$a;
import com.xiaomi.push.hm;
import com.xiaomi.push.il;
import com.xiaomi.push.iw;
import com.xiaomi.push.ix;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.an;
import com.xiaomi.push.service.w;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class b
extends ai$a {
    private il a;
    private WeakReference a;
    private boolean a = false;

    public b(il il2, WeakReference weakReference, boolean bl2) {
        this.a = il2;
        this.a = weakReference;
        this.a = bl2;
    }

    public int a() {
        return 22;
    }

    public void run() {
        Object object;
        Object object2 = this.a;
        if (object2 != null && (object = this.a) != null) {
            if ((object2 = (XMPushService)((Reference)object2).get()) == null) {
                return;
            }
            object = this.a;
            Object object3 = an.a();
            ((il)object).a((String)object3);
            this.a.a(false);
            object = new StringBuilder();
            ((StringBuilder)object).append("MoleInfo aw_ping : send aw_Ping msg ");
            object3 = this.a.a();
            ((StringBuilder)object).append((String)object3);
            object = ((StringBuilder)object).toString();
            com.xiaomi.channel.commonutils.logger.b.c((String)object);
            object = this.a;
            object = ((il)object).c();
            object3 = this.a;
            object3 = ((il)object3).b();
            il il2 = this.a;
            hm hm2 = hm.i;
            object3 = w.a((String)object, (String)object3, il2, hm2);
            object3 = iw.a((ix)object3);
            boolean bl2 = this.a;
            try {
                ((XMPushService)object2).a((String)object, (byte[])object3, bl2);
            }
            catch (Exception exception) {
                object = new StringBuilder();
                object3 = "MoleInfo aw_ping : send help app ping error";
                ((StringBuilder)object).append((String)object3);
                String string2 = exception.toString();
                ((StringBuilder)object).append(string2);
                string2 = ((StringBuilder)object).toString();
                com.xiaomi.channel.commonutils.logger.b.d(string2);
            }
        }
    }
}

