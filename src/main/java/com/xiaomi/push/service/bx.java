/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.xiaomi.push.service;

import android.content.Context;
import com.xiaomi.push.ab;
import com.xiaomi.push.ft;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.XMPushService$i;
import com.xiaomi.push.service.ap;
import com.xiaomi.push.service.l;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class bx
extends XMPushService$i {
    public final /* synthetic */ XMPushService a;
    public final /* synthetic */ String a;
    public final /* synthetic */ byte[] a;
    public final /* synthetic */ int b;

    public bx(XMPushService xMPushService, int n10, int n11, byte[] byArray, String string2) {
        this.a = xMPushService;
        this.b = n11;
        this.a = byArray;
        this.a = string2;
        super(n10);
    }

    public String a() {
        return "clear account cache.";
    }

    public void a() {
        l.a((Context)this.a);
        ap.a().a("5");
        ab.a(this.b);
        Object object = XMPushService.a(this.a);
        Object object2 = ft.a();
        ((ft)object).c((String)object2);
        object = this.a;
        object2 = this.a;
        String string2 = this.a;
        ((XMPushService)object).a((byte[])object2, string2);
    }
}

