/*
 * Decompiled with CFR 0.151.
 */
package com.xiaomi.push.service;

import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.fs;
import com.xiaomi.push.hg;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.XMPushService$i;
import com.xiaomi.push.service.ap;
import com.xiaomi.push.service.ap$b;
import com.xiaomi.push.service.ap$c;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class XMPushService$a
extends XMPushService$i {
    public final /* synthetic */ XMPushService a;
    public ap$b a;

    public XMPushService$a(XMPushService xMPushService, ap$b ap$b) {
        this.a = xMPushService;
        super(9);
        this.a = null;
        this.a = ap$b;
    }

    public String a() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("bind the client. ");
        String string2 = this.a.g;
        stringBuilder.append(string2);
        return stringBuilder.toString();
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a() {
        Object object;
        try {
            Object object2 = this.a;
            boolean bl2 = ((XMPushService)object2).c();
            if (!bl2) {
                object2 = "trying bind while the connection is not created, quit!";
                b.d((String)object2);
                return;
            }
            object2 = ap.a();
            object = this.a;
            Object object3 = ((ap$b)object).g;
            object = ((ap$b)object).b;
            if ((object2 = ((ap)object2).a((String)object3, (String)object)) == null) {
                object2 = new StringBuilder();
                object = "ignore bind because the channel ";
                ((StringBuilder)object2).append((String)object);
                object = this.a;
                object = ((ap$b)object).g;
                ((StringBuilder)object2).append((String)object);
                object = " is removed ";
                ((StringBuilder)object2).append((String)object);
                object2 = ((StringBuilder)object2).toString();
            } else {
                object = ((ap$b)object2).a;
                object3 = ap$c.a;
                if (object == object3) {
                    ap$c ap$c = ap$c.b;
                    ((ap$b)object2).a(ap$c, 0, 0, null, null);
                    object = this.a;
                    object = XMPushService.a((XMPushService)object);
                    ((fs)object).a((ap$b)object2);
                    object = this.a;
                    hg.a((XMPushService)object, (ap$b)object2);
                    return;
                }
                object = new StringBuilder();
                object3 = "trying duplicate bind, ingore! ";
                ((StringBuilder)object).append((String)object3);
                object2 = ((ap$b)object2).a;
                ((StringBuilder)object).append(object2);
                object2 = ((StringBuilder)object).toString();
            }
            b.a((String)object2);
            return;
        }
        catch (Exception exception) {
            b.a(exception);
            object = this.a;
            int n10 = 10;
            ((XMPushService)object).a(n10, exception);
        }
        return;
        catch (Throwable throwable) {
            return;
        }
    }
}

