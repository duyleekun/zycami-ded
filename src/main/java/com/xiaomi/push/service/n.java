/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  org.json.JSONException
 */
package com.xiaomi.push.service;

import android.content.Context;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.gd;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.XMPushService$a;
import com.xiaomi.push.service.XMPushService$i;
import com.xiaomi.push.service.ap;
import com.xiaomi.push.service.ap$b;
import com.xiaomi.push.service.ap$c;
import com.xiaomi.push.service.k;
import com.xiaomi.push.service.l;
import com.xiaomi.push.service.o;
import com.xiaomi.push.service.w;
import java.io.IOException;
import org.json.JSONException;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class n
extends XMPushService$i {
    private XMPushService a;
    private String a;
    private byte[] a;
    private String b;
    private String c;

    public n(XMPushService xMPushService, String string2, String string3, String string4, byte[] byArray) {
        super(9);
        this.a = xMPushService;
        this.a = string2;
        this.a = byArray;
        this.b = string3;
        this.c = string4;
    }

    public String a() {
        return "register app";
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a() {
        Object object;
        Object object2;
        block13: {
            object2 = l.a((Context)this.a);
            if (object2 == null) {
                try {
                    object = this.a;
                    String string2 = this.a;
                    String string3 = this.b;
                    String string4 = this.c;
                    object2 = l.a((Context)object, string2, string3, string4);
                    break block13;
                }
                catch (JSONException jSONException) {
                }
                catch (IOException iOException) {
                    // empty catch block
                }
                com.xiaomi.channel.commonutils.logger.b.a((Throwable)object);
            }
        }
        if (object2 == null) {
            com.xiaomi.channel.commonutils.logger.b.d("no account for mipush");
            object2 = this.a;
            int n10 = 70000002;
            String string5 = "no account.";
            o.a((Context)object2, n10, string5);
            return;
        }
        object = ap.a();
        String string6 = "5";
        int n11 = (object = ((ap)object).a(string6)).isEmpty();
        if (n11 != 0) {
            object = this.a;
            object2 = ((k)object2).a((XMPushService)object);
            w.a(this.a, (ap$b)object2);
            object = ap.a();
            ((ap)object).a((ap$b)object2);
        } else {
            object2 = (ap$b)object.iterator().next();
        }
        object = this.a;
        boolean bl2 = ((XMPushService)object).c();
        if (!bl2) {
            object2 = this.a;
            bl2 = true;
            ((XMPushService)object2).a(bl2);
            return;
        }
        try {
            object = ((ap$b)object2).a;
            ap$c ap$c = ap$c.c;
            if (object == ap$c) {
                object2 = this.a;
                object = this.a;
                byte[] byArray = this.a;
                w.a((XMPushService)object2, (String)object, byArray);
                return;
            }
            ap$c ap$c2 = ap$c.a;
            if (object != ap$c2) return;
            object = this.a;
            object.getClass();
            XMPushService$a xMPushService$a = new XMPushService$a((XMPushService)object, (ap$b)object2);
            ((XMPushService)object).a(xMPushService$a);
            return;
        }
        catch (gd gd2) {
            com.xiaomi.channel.commonutils.logger.b.a(gd2);
            object = this.a;
            n11 = 10;
            ((XMPushService)object).a(n11, (Exception)gd2);
            return;
        }
    }
}

